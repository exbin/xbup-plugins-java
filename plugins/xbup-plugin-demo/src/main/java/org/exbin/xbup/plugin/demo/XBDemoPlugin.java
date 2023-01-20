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
package org.exbin.xbup.plugin.demo;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.plugin.InvalidPluginParameterException;
import org.exbin.xbup.plugin.XBCatalogPlugin;
import org.exbin.xbup.plugin.XBPanelViewer;
import org.exbin.xbup.plugin.XBPanelViewerCatalogPlugin;
import org.exbin.xbup.plugin.demo.panel_viewer.XmlDocumentPanelViewer;

/**
 * Basic catalog plugin - provides panels for demo purposes.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBDemoPlugin implements XBCatalogPlugin, XBPanelViewerCatalogPlugin {

    @Nonnull
    @Override
    public String getPluginPath() {
        return "basic/xbup-plugin-demo-0.2.1-SNAPSHOT.jar";
    }

    @Override
    public long getPanelViewersCount() {
        return 1;
    }

    @Override
    public XBPanelViewer getPanelViewer(long index) {
        switch ((int) index) {
            case 0: {
                return new XmlDocumentPanelViewer();
            }
        }

        throw new InvalidPluginParameterException();
    }

}
