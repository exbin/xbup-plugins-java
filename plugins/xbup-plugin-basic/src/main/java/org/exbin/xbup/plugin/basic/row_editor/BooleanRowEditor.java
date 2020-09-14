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
package org.exbin.xbup.plugin.basic.row_editor;

import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.ubnumber.type.UBBool;
import org.exbin.xbup.plugin.XBAbstractRowEditor;
import org.exbin.xbup.plugin.XBRowEditor;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.2.1 2020/07/23
 * @author ExBin Project (http://exbin.org)
 */
public class BooleanRowEditor extends XBAbstractRowEditor implements XBRowEditor, XBPSequenceSerializable {

    private UBBool value = new UBBool();
    private static final String TRUE_TEXT = "true";
    private static final String FALSE_TEXT = "false";
    
    private JCheckBox editor = null;

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JComponent getViewer() {
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
        editor = new JCheckBox(FALSE_TEXT);
        editor.addChangeListener(new javax.swing.event.ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JCheckBox source = (JCheckBox) e.getSource();
                source.setText(source.isSelected() ? TRUE_TEXT : FALSE_TEXT);
            }
        });
        editor.setSelected(value.getBoolean());
        editor.requestFocusInWindow();
        return editor;
    }

    @Override
    public boolean finishEditor() {
        value.setValue(editor.isSelected());
        fireValueChange();
        return true;
    }

    public UBBool getValue() {
        return value;
    }

    public void setValue(UBBool value) {
        this.value = value;
    }

    @Override
    public void setData(XBTBlock block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBTBlock getData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
