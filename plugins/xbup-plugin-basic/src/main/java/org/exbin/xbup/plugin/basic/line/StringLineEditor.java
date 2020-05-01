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
import org.exbin.xbup.core.type.XBString;
import org.exbin.xbup.plugin.XBAbstractLineEditor;
import org.exbin.xbup.plugin.XBLineEditor;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.1.24 2015/01/09
 * @author ExBin Project (http://exbin.org)
 */
public class StringLineEditor extends XBAbstractLineEditor implements XBLineEditor, XBPSequenceSerializable {

    private XBString value = new XBString();

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JComponent getComponent() {
        JTextField component = new JTextField(value.getValue());
        component.setEditable(false);
        component.setOpaque(false);
        return component;
    }

    @Override
    public JComponent getEditor() {
        JTextField component = new JTextField(value.getValue());
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
        value.setValue(component.getText());
        fireValueChange();
        return true;
    }

    public XBString getValue() {
        return value;
    }

    public void setValue(XBString value) {
        this.value = value;
    }
}
