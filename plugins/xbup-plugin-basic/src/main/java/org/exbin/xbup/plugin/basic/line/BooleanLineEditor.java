/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.plugin.basic.line;

import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.ubnumber.type.UBBool;
import org.exbin.xbup.plugin.XBAbstractLineEditor;
import org.exbin.xbup.plugin.XBLineEditor;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.1.24 2015/01/13
 * @author ExBin Project (http://exbin.org)
 */
public class BooleanLineEditor extends XBAbstractLineEditor implements XBLineEditor, XBPSequenceSerializable {

    private UBBool value = new UBBool();
    private static final String TRUE_TEXT = "true";
    private static final String FALSE_TEXT = "false";

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JComponent getComponent() {
        JCheckBox component = new JCheckBox(FALSE_TEXT);
        component.addChangeListener(new javax.swing.event.ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();
                source.setText(source.isSelected() ? TRUE_TEXT : FALSE_TEXT);
            }
        });
        component.setSelected(value.getBoolean());
        // component.setEditable(false);
        component.setOpaque(false);
        return component;
    }

    @Override
    public JComponent getEditor() {
        JCheckBox component = new JCheckBox(FALSE_TEXT);
        component.addChangeListener(new javax.swing.event.ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();
                source.setText(source.isSelected() ? TRUE_TEXT : FALSE_TEXT);
            }
        });
        component.setSelected(value.getBoolean());
        component.requestFocusInWindow();
        return component;
    }

    @Override
    public boolean finishEditor(JComponent editor) {
        JCheckBox component = (JCheckBox) editor;
        value.setValue(component.isSelected());
        fireValueChange();
        return true;
    }

    public UBBool getValue() {
        return value;
    }

    public void setValue(UBBool value) {
        this.value = value;
    }
}
