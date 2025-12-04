package javax.xml.bind.helpers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* loaded from: classes5.dex */
public abstract class AbstractUnmarshallerImpl implements Unmarshaller {
    private ValidationEventHandler eventHandler = new DefaultValidationEventHandler();
    protected boolean validating = false;
    private XMLReader reader = null;

    protected abstract Object unmarshal(XMLReader xMLReader, InputSource inputSource) throws JAXBException;

    protected XMLReader getXMLReader() throws JAXBException {
        if (this.reader == null) {
            try {
                SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
                sAXParserFactoryNewInstance.setNamespaceAware(true);
                sAXParserFactoryNewInstance.setValidating(false);
                this.reader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
            } catch (ParserConfigurationException e) {
                throw new JAXBException(e);
            } catch (SAXException e2) {
                throw new JAXBException(e2);
            }
        }
        return this.reader;
    }

    @Override // javax.xml.bind.Unmarshaller
    public Object unmarshal(Source source) throws JAXBException {
        if (source == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "source"));
        }
        if (source instanceof SAXSource) {
            return unmarshal((SAXSource) source);
        }
        if (source instanceof StreamSource) {
            return unmarshal(streamSourceToInputSource((StreamSource) source));
        }
        if (source instanceof DOMSource) {
            return unmarshal(((DOMSource) source).getNode());
        }
        throw new IllegalArgumentException();
    }

    private Object unmarshal(SAXSource sAXSource) throws JAXBException {
        XMLReader xMLReader = sAXSource.getXMLReader();
        if (xMLReader == null) {
            xMLReader = getXMLReader();
        }
        return unmarshal(xMLReader, sAXSource.getInputSource());
    }

    @Override // javax.xml.bind.Unmarshaller
    public final Object unmarshal(InputSource inputSource) throws JAXBException {
        if (inputSource == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "source"));
        }
        return unmarshal(getXMLReader(), inputSource);
    }

    private Object unmarshal(String str) {
        return unmarshal(new InputSource(str));
    }

    @Override // javax.xml.bind.Unmarshaller
    public final Object unmarshal(URL url) throws JAXBException {
        if (url == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "url"));
        }
        return unmarshal(url.toExternalForm());
    }

    @Override // javax.xml.bind.Unmarshaller
    public final Object unmarshal(File file) throws JAXBException {
        if (file == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "file"));
        }
        try {
            return unmarshal(new BufferedInputStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override // javax.xml.bind.Unmarshaller
    public final Object unmarshal(InputStream inputStream) throws JAXBException {
        if (inputStream == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "is"));
        }
        return unmarshal(new InputSource(inputStream));
    }

    @Override // javax.xml.bind.Unmarshaller
    public final Object unmarshal(Reader reader) throws JAXBException {
        if (reader == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "reader"));
        }
        return unmarshal(new InputSource(reader));
    }

    private static InputSource streamSourceToInputSource(StreamSource streamSource) {
        InputSource inputSource = new InputSource();
        inputSource.setSystemId(streamSource.getSystemId());
        inputSource.setByteStream(streamSource.getInputStream());
        inputSource.setCharacterStream(streamSource.getReader());
        return inputSource;
    }

    @Override // javax.xml.bind.Unmarshaller
    public boolean isValidating() throws JAXBException {
        return this.validating;
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setEventHandler(ValidationEventHandler validationEventHandler) throws JAXBException {
        if (validationEventHandler == null) {
            this.eventHandler = new DefaultValidationEventHandler();
        } else {
            this.eventHandler = validationEventHandler;
        }
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setValidating(boolean z) throws JAXBException {
        this.validating = z;
    }

    @Override // javax.xml.bind.Unmarshaller
    public ValidationEventHandler getEventHandler() throws JAXBException {
        return this.eventHandler;
    }

    protected UnmarshalException createUnmarshalException(SAXException sAXException) {
        Exception exception = sAXException.getException();
        if (exception instanceof UnmarshalException) {
            return (UnmarshalException) exception;
        }
        if (exception instanceof RuntimeException) {
            throw ((RuntimeException) exception);
        }
        if (exception != null) {
            return new UnmarshalException(exception);
        }
        return new UnmarshalException(sAXException);
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setProperty(String str, Object obj) throws PropertyException {
        if (str == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "name"));
        }
        throw new PropertyException(str, obj);
    }

    @Override // javax.xml.bind.Unmarshaller
    public Object getProperty(String str) throws PropertyException {
        if (str == null) {
            throw new IllegalArgumentException(Messages.format("Shared.MustNotBeNull", "name"));
        }
        throw new PropertyException(str);
    }

    @Override // javax.xml.bind.Unmarshaller
    public Object unmarshal(XMLEventReader xMLEventReader) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public Object unmarshal(XMLStreamReader xMLStreamReader) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public <T> JAXBElement<T> unmarshal(Node node, Class<T> cls) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public <T> JAXBElement<T> unmarshal(Source source, Class<T> cls) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public <T> JAXBElement<T> unmarshal(XMLStreamReader xMLStreamReader, Class<T> cls) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public <T> JAXBElement<T> unmarshal(XMLEventReader xMLEventReader, Class<T> cls) throws JAXBException {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setSchema(Schema schema) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public Schema getSchema() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setAdapter(XmlAdapter xmlAdapter) {
        if (xmlAdapter == null) {
            throw new IllegalArgumentException();
        }
        setAdapter(xmlAdapter.getClass(), xmlAdapter);
    }

    @Override // javax.xml.bind.Unmarshaller
    public <A extends XmlAdapter> void setAdapter(Class<A> cls, A a) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public <A extends XmlAdapter> A getAdapter(Class<A> cls) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setAttachmentUnmarshaller(AttachmentUnmarshaller attachmentUnmarshaller) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public AttachmentUnmarshaller getAttachmentUnmarshaller() {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public void setListener(Unmarshaller.Listener listener) {
        throw new UnsupportedOperationException();
    }

    @Override // javax.xml.bind.Unmarshaller
    public Unmarshaller.Listener getListener() {
        throw new UnsupportedOperationException();
    }
}
