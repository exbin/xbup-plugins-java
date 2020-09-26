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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.token.XBTTokenType;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.type.XBString;
import org.exbin.xbup.core.util.StreamUtils;
import org.exbin.xbup.core.util.StringUtils;
import org.exbin.xbup.plugin.XBAbstractPanelViewer;
import org.exbin.xbup.plugin.XBPanelViewer;

/**
 * XBUP viewer plugin - provides panels for basic XBUP data types.
 *
 * @version 0.2.1 2020/09/26
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
        builder.append("<!DOCTYPE " + val1.getValue() + " \"" + val2.getValue() + "\" \"" + val3.getValue() + "\">\n");
        serial.end();

        serial.end();

        // Process tags
        serial.begin();
        serial.pullType();
        processTagBody(serial, builder);
        serial.pullEnd();

        value = builder.toString();
        serial.end();
    }

    private void processTagBody(XBPSequenceSerialHandler serial, StringBuilder builder) throws XBProcessingException, IOException {
        serial.pullAttribute();
        int hasAttributes = serial.pullIntAttribute(); // Maybe incorrect meaning, but used for attributes detection for now... Don't remember what it was :-/
        int subCount = serial.pullIntAttribute(); // Maybe number of subtags...
        XBString tagName = new XBString();
        serial.join(tagName);
        builder.append("<" + tagName.getValue());
        if (hasAttributes == 2) {
            serial.begin();
            serial.pullType();
            int attrCount = serial.pullIntAttribute();
            
            for (int i = 0; i < attrCount; i++) {
                serial.begin();
                serial.pullType();
                XBString attrName = new XBString();
                serial.join(attrName);
                XBString attrValue = new XBString();
                serial.join(attrValue);
                serial.end();
                builder.append(" " + attrName.getValue() + "=\"" + attrValue.getValue() + "\"");
            }
            serial.end();
        }
        builder.append(">\n");

        for (int sub = 0; sub < subCount; sub++) {
            serial.begin();
            if (serial.getFutureTokenType() == XBTTokenType.DATA) {
                InputStream inputStream = serial.pullData();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                try {
                    StreamUtils.copyInputStreamToOutputStream(inputStream, stream);
                } catch (IOException ex) {
                    Logger.getLogger(XmlDocumentPanelViewer.class.getName()).log(Level.SEVERE, null, ex);
                }

                builder.append(new String(stream.toByteArray(), Charset.forName(StringUtils.ENCODING_UTF8)));
                serial.pullEnd();
            } else {
                serial.pullType();
                processTagBody(serial, builder);
                serial.pullEnd();
            }
        }

        builder.append("</" + tagName.getValue() + ">\n");
    }

    @Override
    public JComponent getViewer() {
        JTextArea textArea = new JTextArea(value);
        textArea.setEditable(false);
        JScrollPane component = new JScrollPane(textArea);
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
