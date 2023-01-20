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
package org.exbin.xbup.plugin.picture;

import javax.annotation.Nonnull;
import org.exbin.xbup.plugin.InvalidPluginParameterException;
import org.exbin.xbup.plugin.XBRowEditor;
import org.exbin.xbup.plugin.picture.panel_editor.PicturePanelEditor;
import org.exbin.xbup.plugin.XBCatalogPlugin;
import org.exbin.xbup.plugin.XBPanelEditor;
import org.exbin.xbup.plugin.XBPanelEditorCatalogPlugin;
import org.exbin.xbup.plugin.XBPanelViewer;
import org.exbin.xbup.plugin.XBPanelViewerCatalogPlugin;
import org.exbin.xbup.plugin.XBRowEditorCatalogPlugin;
import org.exbin.xbup.plugin.picture.panel_viewer.PicturePanelViewer;

/**
 * XBUP Editor plugin - provides editing panel for XBUP data.
 *
 * @author ExBin Project (https://exbin.org)
 */
public class XBPicturePlugin implements XBCatalogPlugin, XBRowEditorCatalogPlugin, XBPanelViewerCatalogPlugin, XBPanelEditorCatalogPlugin {

    @Override
    public String getPluginPath() {
        return "xbup/visual/picture/xbup-plugin-picture-0.2.1-SNAPSHOT.jar";
    }

    @Override
    public long getRowEditorsCount() {
        return 0;
    }

    @Nonnull
    @Override
    public XBRowEditor getRowEditor(long index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getPanelViewersCount() {
        return 1;
    }

    @Override
    public XBPanelViewer getPanelViewer(long index) {
        if (index == 0) {
            return new PicturePanelViewer();
        }

        throw new InvalidPluginParameterException();
    }

    @Override
    public long getPanelEditorsCount() {
        return 1;
    }

    @Nonnull
    @Override
    public XBPanelEditor getPanelEditor(long index) {
        if (index == 0) {
            return new PicturePanelEditor();
        }

        throw new InvalidPluginParameterException();
    }
}
