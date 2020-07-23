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
package org.exbin.xbup.plugin.picture;

import javax.annotation.Nonnull;
import org.exbin.xbup.plugin.XBRowEditor;
import org.exbin.xbup.plugin.XBComponentEditor;
import org.exbin.xbup.plugin.XBTransformation;
import org.exbin.xbup.plugin.picture.pane.PicturePaneEditor;
import org.exbin.xbup.plugin.XBCatalogPlugin;

/**
 * XBUP Editor plugin - provides editing panel for XBUP data.
 *
 * @version 0.2.0 2020/07/23
 * @author ExBin Project (http://exbin.org)
 */
public class XBPicturePlugin implements XBCatalogPlugin {

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
        return null;
    }

    @Override
    public long getComponentEditorsCount() {
        return 1;
    }

    @Nonnull
    @Override
    public XBComponentEditor getComponentEditor(long index) {
        if (index == 0) {
            return new PicturePaneEditor();
        }
        return null;
    }

    @Override
    public long getTransformationCount() {
        return 0;
    }

    @Nonnull
    @Override
    public XBTransformation getTransformation(long index) {
        return null;
    }
}
