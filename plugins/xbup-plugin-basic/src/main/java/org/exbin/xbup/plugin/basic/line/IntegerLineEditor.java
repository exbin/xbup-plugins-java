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

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.ubnumber.type.UBInt32;
import org.exbin.xbup.plugin.XBAbstractLineEditor;
import org.exbin.xbup.plugin.XBLineEditor;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.1.24 2015/01/09
 * @author ExBin Project (http://exbin.org)
 */
public class IntegerLineEditor extends XBAbstractLineEditor implements XBLineEditor, XBPSequenceSerializable {

    private UBInt32 value = new UBInt32();

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JComponent getComponent() {
        JTextField component = new JTextField(String.valueOf(value.getLong()));
        component.setEditable(false);
        component.setOpaque(false);
        return component;
    }

    @Override
    public JComponent getEditor() {
        JTextField component = new JTextField(String.valueOf(value.getLong()));
        component.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(final FocusEvent fe) {
            }

            @Override
            public void focusGained(final FocusEvent fe) {
                ((JTextField) fe.getComponent()).selectAll();
            }
        });
        return component;
    }

    @Override
    public boolean finishEditor(JComponent editor) {
        JTextField component = (JTextField) editor;
        component.setCaretPosition(0);
        value.setValue(Long.valueOf(component.getText()));
        fireValueChange();
        return true;
    }

    public UBInt32 getValue() {
        return value;
    }

    public void setValue(UBInt32 value) {
        this.value = value;
    }
}
