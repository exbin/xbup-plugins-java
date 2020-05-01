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
package org.exbin.xbup.plugin.audio;

import javax.swing.JPanel;
import org.exbin.xbup.plugin.XBCatalogPlugin;
import org.exbin.xbup.plugin.XBLineEditor;
import org.exbin.xbup.plugin.XBPanelEditor;
import org.exbin.xbup.plugin.XBTransformation;

/**
 * XBUP Editor plugin - provides editing panel for XBUP data.
 *
 * @version 0.2.0 2016/03/29
 * @author ExBin Project (http://exbin.org)
 */
public class XBAudioPlugin implements XBCatalogPlugin {

    @Override
    public String getPluginPath() {
        return "xbup/visual/audio/XBAudioPlugin.jar";
    }

    @Override
    public long getLineEditorsCount() {
        return 0;
    }

    @Override
    public XBLineEditor getLineEditor(long index) {
        return null;
    }

    @Override
    public long getPanelEditorsCount() {
        return 1;
    }

    @Override
    public XBPanelEditor getPanelEditor(long index) {
        if (index == 0) {
            return new XBPanelEditor() {

                @Override
                public JPanel getPanel() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void attachChangeListener(XBPanelEditor.ChangeListener listener) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
        }
        return null;
    }

    @Override
    public long getTransformationCount() {
        return 0;
    }

    @Override
    public XBTransformation getTransformation(long index) {
        return null;
    }
}
