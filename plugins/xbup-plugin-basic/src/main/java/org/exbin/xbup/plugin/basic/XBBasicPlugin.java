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

import javax.swing.JPanel;
import org.exbin.xbup.plugin.XBLineEditor;
import org.exbin.xbup.plugin.XBPanelEditor;
import org.exbin.xbup.plugin.XBTransformation;
import org.exbin.xbup.plugin.basic.line.BooleanLineEditor;
import org.exbin.xbup.plugin.basic.line.IntegerLineEditor;
import org.exbin.xbup.plugin.basic.line.NaturalLineEditor;
import org.exbin.xbup.plugin.basic.line.StringLineEditor;
import org.exbin.xbup.plugin.XBCatalogPlugin;

/**
 * XBUP Editor plugin - provides panels for basic XBUP data types.
 *
 * @version 0.2.0 2016/03/27
 * @author ExBin Project (http://exbin.org)
 */
public class XBBasicPlugin implements XBCatalogPlugin {

    @Override
    public String getPluginPath() {
        return "basic/xbup-plugin-basic-0.2.1-SNAPSHOT.jar";
    }

    @Override
    public long getLineEditorsCount() {
        return 4;
    }

    @Override
    public XBLineEditor getLineEditor(long index) {
        switch ((int) index) {
            case 0: {
                return new NaturalLineEditor();
            }
            case 1: {
                return new IntegerLineEditor();
            }
            case 2: {
                return new StringLineEditor();
            }
            case 3: {
                return new BooleanLineEditor();
            }
        }
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
