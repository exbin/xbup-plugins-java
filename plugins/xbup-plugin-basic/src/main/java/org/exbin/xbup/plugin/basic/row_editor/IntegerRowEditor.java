/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.plugin.basic.row_editor;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.ubnumber.type.UBInt32;
import org.exbin.xbup.plugin.XBAbstractRowEditor;
import org.exbin.xbup.plugin.XBRowEditor;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @author ExBin Project (https://exbin.org)
 */
public class IntegerRowEditor extends XBAbstractRowEditor implements XBRowEditor, XBPSequenceSerializable {

    private UBInt32 value = new UBInt32();
    private JTextField editor = null;

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JComponent getViewer() {
        JTextField component = new JTextField(String.valueOf(value.getLong()));
        component.setEditable(false);
        component.setOpaque(false);
        return component;
    }

    @Override
    public JComponent getEditor() {
        editor = new JTextField(String.valueOf(value.getLong()));
        editor.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(final FocusEvent fe) {
            }

            @Override
            public void focusGained(final FocusEvent fe) {
                ((JTextField) fe.getComponent()).selectAll();
            }
        });
        return editor;
    }

    @Override
    public boolean finishEditor() {
        editor.setCaretPosition(0);
        value.setValue(Long.valueOf(editor.getText()));
        fireValueChange();
        return true;
    }

    public UBInt32 getValue() {
        return value;
    }

    public void setValue(UBInt32 value) {
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
