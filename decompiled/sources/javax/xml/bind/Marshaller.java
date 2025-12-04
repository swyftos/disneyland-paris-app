package javax.xml.bind;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.validation.Schema;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

/* loaded from: classes5.dex */
public interface Marshaller {
    public static final String JAXB_ENCODING = "jaxb.encoding";
    public static final String JAXB_FORMATTED_OUTPUT = "jaxb.formatted.output";
    public static final String JAXB_FRAGMENT = "jaxb.fragment";
    public static final String JAXB_NO_NAMESPACE_SCHEMA_LOCATION = "jaxb.noNamespaceSchemaLocation";
    public static final String JAXB_SCHEMA_LOCATION = "jaxb.schemaLocation";

    public static abstract class Listener {
        public void afterMarshal(Object obj) {
        }

        public void beforeMarshal(Object obj) {
        }
    }

    <A extends XmlAdapter> A getAdapter(Class<A> cls);

    AttachmentMarshaller getAttachmentMarshaller();

    ValidationEventHandler getEventHandler() throws JAXBException;

    Listener getListener();

    Node getNode(Object obj) throws JAXBException;

    Object getProperty(String str) throws PropertyException;

    Schema getSchema();

    void marshal(Object obj, File file) throws JAXBException;

    void marshal(Object obj, OutputStream outputStream) throws JAXBException;

    void marshal(Object obj, Writer writer) throws JAXBException;

    void marshal(Object obj, XMLEventWriter xMLEventWriter) throws JAXBException;

    void marshal(Object obj, XMLStreamWriter xMLStreamWriter) throws JAXBException;

    void marshal(Object obj, Result result) throws JAXBException;

    void marshal(Object obj, Node node) throws JAXBException;

    void marshal(Object obj, ContentHandler contentHandler) throws JAXBException;

    <A extends XmlAdapter> void setAdapter(Class<A> cls, A a);

    void setAdapter(XmlAdapter xmlAdapter);

    void setAttachmentMarshaller(AttachmentMarshaller attachmentMarshaller);

    void setEventHandler(ValidationEventHandler validationEventHandler) throws JAXBException;

    void setListener(Listener listener);

    void setProperty(String str, Object obj) throws PropertyException;

    void setSchema(Schema schema);
}
