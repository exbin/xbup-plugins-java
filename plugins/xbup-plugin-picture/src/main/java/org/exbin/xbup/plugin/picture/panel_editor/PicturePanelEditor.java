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
package org.exbin.xbup.plugin.picture.panel_editor;

import java.io.IOException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.JPanel;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.plugin.XBAbstractPanelEditor;
import org.exbin.xbup.plugin.XBPanelEditor;
import org.exbin.xbup.visual.xbplugins.XBPicturePanel;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.2.1 2020/09/15
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class PicturePanelEditor extends XBAbstractPanelEditor implements XBPanelEditor, XBPSequenceSerializable {

    private XBPicturePanel value = new XBPicturePanel();

    public PicturePanelEditor() {
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
    public JPanel getEditor() {
        return value;
    }

    public XBPicturePanel getValue() {
        return value;
    }

    public void setValue(XBPicturePanel value) {
        this.value = value;
    }

    @Override
    public boolean finishEditor() {
        return true;
    }

    @Override
    public void setData(XBTBlock block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
