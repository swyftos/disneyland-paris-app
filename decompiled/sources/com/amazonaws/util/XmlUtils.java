package com.amazonaws.util;

import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes2.dex */
public class XmlUtils {
    public static XMLReader parse(InputStream inputStream, ContentHandler contentHandler) throws SAXException, IOException {
        XMLReader xMLReaderCreateXMLReader = XMLReaderFactory.createXMLReader();
        xMLReaderCreateXMLReader.setContentHandler(contentHandler);
        xMLReaderCreateXMLReader.parse(new InputSource(inputStream));
        inputStream.close();
        return xMLReaderCreateXMLReader;
    }
}
