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
package org.exbin.xbup.plugin.basic.panel_editor;

import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.type.XBText;
import org.exbin.xbup.plugin.XBAbstractPanelEditor;
import org.exbin.xbup.plugin.XBPanelEditor;

/**
 * XBUP editor plugin - provides panels for basic XBUP data types.
 *
 * @author ExBin Project (https://exbin.org)
 */
public class TextPanelEditor extends XBAbstractPanelEditor implements XBPanelEditor, XBPSequenceSerializable {

    private XBText value = new XBText();
    private JTextArea textArea;
    private JScrollPane editor = null;

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JComponent getEditor() {
        textArea = new JTextArea(value.getValue());
        editor = new JScrollPane(textArea);
        return editor;
    }

    @Override
    public boolean finishEditor() {
        value.setValue(textArea.getText());
        fireValueChange();
        return true;
    }

    public XBText getValue() {
        return value;
    }

    public void setValue(XBText value) {
        this.value = value;
    }

    @Override
    public void setData(XBTBlock block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
