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
package org.exbin.xbup.plugin.basic;

import javax.annotation.Nonnull;
import javax.swing.JPanel;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.plugin.InvalidPluginParameter;
import org.exbin.xbup.plugin.XBRowEditor;
import org.exbin.xbup.plugin.XBComponentEditor;
import org.exbin.xbup.plugin.basic.line.BooleanRowEditor;
import org.exbin.xbup.plugin.basic.line.IntegerRowEditor;
import org.exbin.xbup.plugin.basic.line.NaturalRowEditor;
import org.exbin.xbup.plugin.basic.line.StringRowEditor;
import org.exbin.xbup.plugin.XBCatalogPlugin;
import org.exbin.xbup.plugin.XBComponentEditorCatalogPlugin;
import org.exbin.xbup.plugin.XBComponentViewer;
import org.exbin.xbup.plugin.XBComponentViewerCatalogPlugin;
import org.exbin.xbup.plugin.XBRowEditorCatalogPlugin;

/**
 * Basic catalog plugin - provides panels for basic XBUP data types.
 *
 * @version 0.2.1 2020/07/27
 * @author ExBin Project (http://exbin.org)
 */
public class XBBasicPlugin implements XBCatalogPlugin, XBRowEditorCatalogPlugin, XBComponentViewerCatalogPlugin, XBComponentEditorCatalogPlugin {

    @Nonnull
    @Override
    public String getPluginPath() {
        return "basic/xbup-plugin-basic-0.2.1-SNAPSHOT.jar";
    }

    @Override
    public long getRowEditorsCount() {
        return 4;
    }

    @Nonnull
    @Override
    public XBRowEditor getRowEditor(long index) {
        switch ((int) index) {
            case 0: {
                return new NaturalRowEditor();
            }
            case 1: {
                return new IntegerRowEditor();
            }
            case 2: {
                return new StringRowEditor();
            }
            case 3: {
                return new BooleanRowEditor();
            }
        }

        throw new InvalidPluginParameter();
    }

    @Override
    public long getComponentViewersCount() {
        return 0;
    }

    @Override
    public XBComponentViewer getComponentViewer(long index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getComponentEditorsCount() {
        return 1;
    }

    @Nonnull
    @Override
    public XBComponentEditor getComponentEditor(long index) {
        if (index == 0) {
            return new XBComponentEditor() {

                @Override
                public JPanel getEditor() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void attachChangeListener(XBComponentEditor.ChangeListener listener) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public boolean finishEditor() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public void setData(XBTBlock block) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }

                @Override
                public XBTBlock getData() {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
        }

        throw new InvalidPluginParameter();
    }
}
