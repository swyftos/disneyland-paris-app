package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Stack;

/* loaded from: classes2.dex */
public class XMLWriter {
    private Stack elementStack;
    private boolean rootElement;
    private final Writer writer;
    private final String xmlns;

    public XMLWriter(Writer writer) {
        this(writer, null);
    }

    public XMLWriter(Writer writer, String str) throws IOException {
        this.elementStack = new Stack();
        this.rootElement = true;
        this.writer = writer;
        this.xmlns = str;
        append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    public XMLWriter startElement(String str) throws IOException {
        append("<" + str);
        if (this.rootElement && this.xmlns != null) {
            append(" xmlns=\"" + this.xmlns + "\"");
            this.rootElement = false;
        }
        append(">");
        this.elementStack.push(str);
        return this;
    }

    public XMLWriter endElement() throws IOException {
        append("</" + ((String) this.elementStack.pop()) + ">");
        return this;
    }

    public XMLWriter value(String str) throws IOException {
        append(escapeXMLEntities(str));
        return this;
    }

    public XMLWriter value(Date date) throws IOException {
        append(escapeXMLEntities(StringUtils.fromDate(date)));
        return this;
    }

    public XMLWriter value(Object obj) throws IOException {
        append(escapeXMLEntities(obj.toString()));
        return this;
    }

    private void append(String str) throws IOException {
        try {
            this.writer.append((CharSequence) str);
        } catch (IOException e) {
            throw new AmazonClientException("Unable to write XML document", e);
        }
    }

    private String escapeXMLEntities(String str) {
        if (str.contains("&")) {
            str = str.replace("&quot;", "\"").replace("&apos;", "'").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
        }
        return str.replace("&", "&amp;").replace("\"", "&quot;").replace("'", "&apos;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
