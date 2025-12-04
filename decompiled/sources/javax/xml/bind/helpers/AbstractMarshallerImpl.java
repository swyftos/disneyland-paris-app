package javax.xml.bind.helpers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

/* loaded from: classes5.dex */
public abstract class AbstractMarshallerImpl implements Marshaller {
    static String[] aliases = {"UTF-8", "UTF8", "UTF-16", "Unicode", "UTF-16BE", "UnicodeBigUnmarked", "UTF-16LE", "UnicodeLittleUnmarked", "US-ASCII", "ASCII", "TIS-620", "TIS620", "ISO-10646-UCS-2", "Unicode", "EBCDIC-CP-US", "cp037", "EBCDIC-CP-CA", "cp037", "EBCDIC-CP-NL", "cp037", "EBCDIC-CP-WT", "cp037", "EBCDIC-CP-DK", "cp277", "EBCDIC-CP-NO", "cp277", "EBCDIC-CP-FI", "cp278", "EBCDIC-CP-SE", "cp278", "EBCDIC-CP-IT", "cp280", "EBCDIC-CP-ES", "cp284", "EBCDIC-CP-GB", "cp285", "EBCDIC-CP-FR", "cp297", "EBCDIC-CP-AR1", "cp420", "EBCDIC-CP-HE", "cp424", "EBCDIC-CP-BE", "cp500", "EBCDIC-CP-CH", "cp500", "EBCDIC-CP-ROECE", "cp870", "EBCDIC-CP-YU", "cp870", "EBCDIC-CP-IS", "cp871", "EBCDIC-CP-AR2", "cp918"};
    private ValidationEventHandler eventHandler = new DefaultValidationEventHandler();
    private String encoding = "UTF-8";
    private String schemaLocation = null;
    private String noNSSchemaLocation = null;
    private boolean formattedOutput = false;
    private boolean fragment = false;

    @Override // javax.xml.bind.Marshaller
    public final void marshal(Object obj, OutputStream outputStream) throws JAXBException {
        checkNotNull(obj, "obj", outputStream, "os");
        marshal(obj, new StreamResult(outputStream));
    }

    @Override // javax.xml.bind.Marshaller
    public void marshal(Object obj, File file) throws IOException, JAXBException {
        checkNotNull(obj, "jaxbElement", file, "output");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                marshal(obj, new StreamResult(bufferedOutputStream));
            } finally {
                bufferedOutputStream.close();
            }
        } catch (IOException e) {
            throw new JAXBException(e);
        }
    }

    @Override // javax.xml.bind.Marshaller
    public final void marshal(Object obj, Writer writer) throws JAXBException {
        checkNotNull(obj, "obj", writer, "writer");
        marshal(obj, new StreamResult(writer));
    }

    @Override // javax.xml.bind.Marshaller
    public final void marshal(Object obj, ContentHandler contentHandler) throws JAXBException {
        checkNotNull(obj, "obj", contentHandler, "handler");
        marshal(obj, new SAXResult(contentHandler));
    }

    @Override // javax.xml.bind.Marshaller
    public final void marshal(Object obj, Node node) throws JAXBException {
        checkNotNull(obj, "obj", node, "node");
        marshal(obj, new DOMResult(node));
    }

    @Override // javax.xml.bind.Marshaller
    public Node getNode(Object obj) throws JAXBException {
        checkNotNull(obj, "obj", Boolean.TRUE, "foo");
        throw new UnsupportedOperationException();
    }

    protected String getEncoding() {
        return this.encoding;
    }

    protected void setEncoding(String str) {
        this.encoding = str;
    }

    protected String getSchemaLocation() {
        return this.schemaLocation;
    }

    protected void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }

    protected String getNoNSSchemaLocation() {
        return this.noNSSchemaLocation;
    }

    protected void setNoNSSchemaLocation(String str) {
        this.noNSSchemaLocation = str;
    }

    protected boolean isFormattedOutput() {
        return this.formattedOutput;
    }

    protected void setFormattedOutput(boolean z) {
        this.formattedOutput = z;
    }

    protected boolean isFragment() {
        return this.fragment;
    }

    protected void setFragment(boolean z) {
        this.fragment = z;
    }

    protected String getJavaEncoding(String str) throws UnsupportedEncodingException {
        try {
            "1".getBytes(str);
            return str;
        } catch (UnsupportedEncodingException unused) {
            int i = 0;
            while (true) {
                String[] strArr = aliases;
                if (i < strArr.length) {
                    if (str.equals(strArr[i])) {
                        int i2 = i + 1;
                        "1".getBytes(aliases[i2]);
                        return aliases[i2];
                    }
                    i += 2;
                } else {
                    throw new UnsupportedEncodingException(str);
                }
            }
        }
    }

    @Override // javax.xml.bind.Marshaller
    public void setProperty(String str, Object obj) throws PropertyException {
        if (str == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "name"));
        }
        if (Marshaller.JAXB_ENCODING.equals(str)) {
            checkString(str, obj);
            setEncoding((String) obj);
            return;
        }
        if (Marshaller.JAXB_FORMATTED_OUTPUT.equals(str)) {
            checkBoolean(str, obj);
            setFormattedOutput(((Boolean) obj).booleanValue());
            return;
        }
        if (Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION.equals(str)) {
            checkString(str, obj);
            setNoNSSchemaLocation((String) obj);
        } else if (Marshaller.JAXB_SCHEMA_LOCATION.equals(str)) {
            checkString(str, obj);
            setSchemaLocation((String) obj);
        } else {
            if (Marshaller.JAXB_FRAGMENT.equals(str)) {
                checkBoolean(str, obj);
                setFragment(((Boolean) obj).booleanValue());
                return;
            }
            throw new PropertyException(str, obj);
        }
    }

    @Override // javax.xml.bind.Marshaller
    public Object getProperty(String str) throws PropertyException {
        if (str == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "name"));
        }
        if (Marshaller.JAXB_ENCODING.equals(str)) {
            return getEncoding();
        }
        if (Marshaller.JAXB_FORMATTED_OUTPUT.equals(str)) {
            return isFormattedOutput() ? Boolean.TRUE : Boolean.FALSE;
        }
        if (Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION.equals(str)) {
            return getNoNSSchemaLocation();
        }
        if (Marshaller.JAXB_SCHEMA_LOCATION.equals(str)) {
            return getSchemaLocation();
        }
        if (Marshaller.JAXB_FRAGMENT.equals(str)) {
            return isFragment() ? Boolean.TRUE : Boolean.FALSE;
        }
        throw new PropertyException(str);
    }

    @Override // javax.xml.bind.Marshaller
    public ValidationEventHandler getEventHandler() throws JAXBException {
        return this.eventHandler;
    }

    @Override // javax.xml.bind.Marshaller
    public void setEventHandler(ValidationEventHandler validationEventHandler) throws JAXBException {
        if (validationEventHandler == null) {
            this.eventHandler = new DefaultValidationEventHandler();
        } else {
            this.eventHandler = validationEventHandler;
        }
    }

    private void checkBoolean(String str, Object obj) throws PropertyException {
        if (!(obj instanceof Boolean)) {
            throw new PropertyException(Messages.format("AbstractMarshallerImpl.MustBeBoolean", str));
        }
    }

    private void checkString(String str, Object obj) throws PropertyException {
        if (!(obj instanceof String)) {
            throw new PropertyException(Messages.format("AbstractMarshallerImpl.MustBeString", str));
        }
    }

    private void checkNotNull(Object obj, String str, Object obj2, String str2) {
        if (obj == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", str));
        }
        if (obj2 == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", str2));
        }
    }

    @Override // javax.xml.bind.Marshaller
    public void marshal(Object obj, XMLEventWriter xMLEventWriter) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public void marshal(Object obj, XMLStreamWriter xMLStreamWriter) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public void setSchema(Schema schema) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public Schema getSchema() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public void setAdapter(XmlAdapter xmlAdapter) {
        if (xmlAdapter == null) {
            throw new IllegalArgumentException();
        }
        setAdapter(xmlAdapter.getClass(), xmlAdapter);
    }

    @Override // javax.xml.bind.Marshaller
    public <A extends XmlAdapter> void setAdapter(Class<A> cls, A a) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public <A extends XmlAdapter> A getAdapter(Class<A> cls) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public void setAttachmentMarshaller(AttachmentMarshaller attachmentMarshaller) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public AttachmentMarshaller getAttachmentMarshaller() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public void setListener(Marshaller.Listener listener) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Marshaller
    public Marshaller.Listener getListener() {
        throw new UnsupportedOperationException();
    }
}
