package javax.xml.bind;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* loaded from: classes5.dex */
public interface Unmarshaller {

    public static abstract class Listener {
        public void afterUnmarshal(Object obj, Object obj2) {
        }

        public void beforeUnmarshal(Object obj, Object obj2) {
        }
    }

    <A extends XmlAdapter> A getAdapter(Class<A> cls);

    AttachmentUnmarshaller getAttachmentUnmarshaller();

    ValidationEventHandler getEventHandler() throws JAXBException;

    Listener getListener();

    Object getProperty(String str) throws PropertyException;

    Schema getSchema();

    UnmarshallerHandler getUnmarshallerHandler();

    boolean isValidating() throws JAXBException;

    <A extends XmlAdapter> void setAdapter(Class<A> cls, A a);

    void setAdapter(XmlAdapter xmlAdapter);

    void setAttachmentUnmarshaller(AttachmentUnmarshaller attachmentUnmarshaller);

    void setEventHandler(ValidationEventHandler validationEventHandler) throws JAXBException;

    void setListener(Listener listener);

    void setProperty(String str, Object obj) throws PropertyException;

    void setSchema(Schema schema);

    void setValidating(boolean z) throws JAXBException;

    Object unmarshal(File file) throws JAXBException;

    Object unmarshal(InputStream inputStream) throws JAXBException;

    Object unmarshal(Reader reader) throws JAXBException;

    Object unmarshal(URL url) throws JAXBException;

    Object unmarshal(XMLEventReader xMLEventReader) throws JAXBException;

    Object unmarshal(XMLStreamReader xMLStreamReader) throws JAXBException;

    Object unmarshal(Source source) throws JAXBException;

    Object unmarshal(Node node) throws JAXBException;

    Object unmarshal(InputSource inputSource) throws JAXBException;

    <T> JAXBElement<T> unmarshal(XMLEventReader xMLEventReader, Class<T> cls) throws JAXBException;

    <T> JAXBElement<T> unmarshal(XMLStreamReader xMLStreamReader, Class<T> cls) throws JAXBException;

    <T> JAXBElement<T> unmarshal(Source source, Class<T> cls) throws JAXBException;

    <T> JAXBElement<T> unmarshal(Node node, Class<T> cls) throws JAXBException;
}
