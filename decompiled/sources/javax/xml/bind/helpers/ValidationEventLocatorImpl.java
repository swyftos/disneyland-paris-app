package javax.xml.bind.helpers;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import javax.xml.bind.ValidationEventLocator;
import org.w3c.dom.Node;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;

/* loaded from: classes5.dex */
public class ValidationEventLocatorImpl implements ValidationEventLocator {
    private int columnNumber;
    private int lineNumber;
    private Node node;
    private Object object;
    private int offset;
    private URL url;

    public ValidationEventLocatorImpl() {
        this.url = null;
        this.offset = -1;
        this.lineNumber = -1;
        this.columnNumber = -1;
        this.object = null;
        this.node = null;
    }

    public ValidationEventLocatorImpl(Locator locator) {
        this.url = null;
        this.offset = -1;
        this.lineNumber = -1;
        this.columnNumber = -1;
        this.object = null;
        this.node = null;
        if (locator == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "loc"));
        }
        this.url = toURL(locator.getSystemId());
        this.columnNumber = locator.getColumnNumber();
        this.lineNumber = locator.getLineNumber();
    }

    public ValidationEventLocatorImpl(SAXParseException sAXParseException) {
        this.url = null;
        this.offset = -1;
        this.lineNumber = -1;
        this.columnNumber = -1;
        this.object = null;
        this.node = null;
        if (sAXParseException == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "e"));
        }
        this.url = toURL(sAXParseException.getSystemId());
        this.columnNumber = sAXParseException.getColumnNumber();
        this.lineNumber = sAXParseException.getLineNumber();
    }

    public ValidationEventLocatorImpl(Node node) {
        this.url = null;
        this.offset = -1;
        this.lineNumber = -1;
        this.columnNumber = -1;
        this.object = null;
        this.node = null;
        if (node == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "_node"));
        }
        this.node = node;
    }

    public ValidationEventLocatorImpl(Object obj) {
        this.url = null;
        this.offset = -1;
        this.lineNumber = -1;
        this.columnNumber = -1;
        this.object = null;
        this.node = null;
        if (obj == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "_object"));
        }
        this.object = obj;
    }

    private static URL toURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // javax.xml.bind.ValidationEventLocator
    public URL getURL() {
        return this.url;
    }

    public void setURL(URL url) {
        this.url = url;
    }

    @Override // javax.xml.bind.ValidationEventLocator
    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    @Override // javax.xml.bind.ValidationEventLocator
    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }

    @Override // javax.xml.bind.ValidationEventLocator
    public int getColumnNumber() {
        return this.columnNumber;
    }

    public void setColumnNumber(int i) {
        this.columnNumber = i;
    }

    @Override // javax.xml.bind.ValidationEventLocator
    public Object getObject() {
        return this.object;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    @Override // javax.xml.bind.ValidationEventLocator
    public Node getNode() {
        return this.node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String toString() {
        return MessageFormat.format("[node={0},object={1},url={2},line={3},col={4},offset={5}]", getNode(), getObject(), getURL(), String.valueOf(getLineNumber()), String.valueOf(getColumnNumber()), String.valueOf(getOffset()));
    }
}
