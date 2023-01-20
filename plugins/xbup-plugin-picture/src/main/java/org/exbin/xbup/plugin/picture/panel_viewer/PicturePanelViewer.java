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
package org.exbin.xbup.plugin.picture.panel_viewer;

import java.io.IOException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.JPanel;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.plugin.XBAbstractPanelViewer;
import org.exbin.xbup.plugin.XBPanelViewer;
import org.exbin.xbup.visual.xbplugins.XBPictureViewerPanel;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class PicturePanelViewer extends XBAbstractPanelViewer implements XBPanelViewer, XBPSequenceSerializable {

    private XBPictureViewerPanel value = new XBPictureViewerPanel();

    public PicturePanelViewer() {
        value.attachChangeListener(this::fireValueChange);
    }

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.append(value);
    }

    @Override
    public JPanel getViewer() {
        return value;
    }

    public XBPictureViewerPanel getValue() {
        return value;
    }

    public void setValue(XBPictureViewerPanel value) {
        this.value = value;
    }

    @Override
    public void setData(XBTBlock block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
