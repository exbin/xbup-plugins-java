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
package org.exbin.xbup.plugin.picture.pane;

import java.io.IOException;
import javax.swing.JPanel;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.plugin.XBAbstractPaneEditor;
import org.exbin.xbup.plugin.XBPanelEditor;
import org.exbin.xbup.visual.xbplugins.XBPicturePanel;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.1.24 2015/01/14
 * @author ExBin Project (http://exbin.org)
 */
public class PicturePaneEditor extends XBAbstractPaneEditor implements XBPanelEditor, XBPSequenceSerializable {

    private XBPicturePanel value = new XBPicturePanel();

    public PicturePaneEditor() {
        value.attachChangeListener(new XBPicturePanel.ChangeListener() {

            @Override
            public void valueChanged() {
                fireValueChange();
            }
        });
    }

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JPanel getPanel() {
        return value;
    }

    public XBPicturePanel getValue() {
        return value;
    }

    public void setValue(XBPicturePanel value) {
        this.value = value;
    }

}
