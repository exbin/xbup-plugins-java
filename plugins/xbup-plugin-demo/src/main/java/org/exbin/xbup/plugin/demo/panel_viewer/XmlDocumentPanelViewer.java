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
package org.exbin.xbup.plugin.demo.panel_viewer;

import java.io.IOException;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.token.XBTToken;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.type.XBString;
import org.exbin.xbup.plugin.XBAbstractPanelViewer;
import org.exbin.xbup.plugin.XBPanelViewer;

/**
 * XBUP viewer plugin - provides panels for basic XBUP data types.
 *
 * @version 0.2.1 2020/09/25
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XmlDocumentPanelViewer extends XBAbstractPanelViewer implements XBPanelViewer, XBPSequenceSerializable {

    private String value = "";

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        StringBuilder builder = new StringBuilder();
        serial.begin();
        serial.matchType();
        
        // Process prolog
        serial.begin();
        serial.matchType();

        serial.begin();
        serial.matchType();
        serial.end();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

        serial.begin();
        serial.matchType();
        XBString val1 = new XBString();
        serial.join(val1);
        XBString val2 = new XBString();
        serial.join(val2);
        XBString val3 = new XBString();
        serial.join(val3);
        builder.append("<!DOCTYPE " + val1.getValue() + " \"" + val2.getValue() + "\" \"" + val3.getValue() +"\">\n");
        serial.end();

        serial.end();
        
        // Process tags
        StringBuilder postBuilder = new StringBuilder();
//        serial.begin();
//        serial.pullAttribute();
        processTag(serial, builder, postBuilder);

        value = builder.toString() + postBuilder.toString();
        serial.end();
    }
    
    private void processTag(XBPSequenceSerialHandler serial, StringBuilder builder, StringBuilder postBuilder) throws XBProcessingException, IOException {
        builder.append("<!-- TODO: tags -->");
//        XBString tagName = new XBString();
//        serial.join(tagName);

//        XBTToken token = serial.pullToken();
//        serial.

//        serial.end();
        
//        builder.append("<" + tagName.getValue());
//        postBuilder.append("</" + tagName.getValue() + ">\n");
    }

    @Override
    public JComponent getViewer() {
        JTextArea component = new JTextArea(value);
        component.setEditable(false);
        return component;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setData(XBTBlock block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
