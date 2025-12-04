package javax.xml.bind.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.sax.SAXSource;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/* loaded from: classes5.dex */
public class JAXBSource extends SAXSource {
    private final Object contentObject;
    private final Marshaller marshaller;
    private final XMLReader pseudoParser;

    /* JADX WARN: Illegal instructions before constructor call */
    public JAXBSource(JAXBContext jAXBContext, Object obj) throws JAXBException {
        Marshaller marshallerCreateMarshaller;
        if (jAXBContext == null) {
            marshallerCreateMarshaller = assertionFailed(Messages.format("JAXBSource.NullContext"));
        } else {
            marshallerCreateMarshaller = jAXBContext.createMarshaller();
        }
        this(marshallerCreateMarshaller, obj == null ? assertionFailed(Messages.format("JAXBSource.NullContent")) : obj);
    }

    public JAXBSource(Marshaller marshaller, Object obj) throws JAXBException {
        XMLReader xMLReader = new XMLReader() { // from class: javax.xml.bind.util.JAXBSource.1
            private DTDHandler dtdHandler;
            private EntityResolver entityResolver;
            private ErrorHandler errorHandler;
            private LexicalHandler lexicalHandler;
            private XMLFilter repeater = new XMLFilterImpl();

            @Override // org.xml.sax.XMLReader
            public boolean getFeature(String str) throws SAXNotRecognizedException {
                if (str.equals("http://xml.org/sax/features/namespaces")) {
                    return true;
                }
                if (str.equals("http://xml.org/sax/features/namespace-prefixes")) {
                    return false;
                }
                throw new SAXNotRecognizedException(str);
            }

            @Override // org.xml.sax.XMLReader
            public void setFeature(String str, boolean z) throws SAXNotRecognizedException {
                if (str.equals("http://xml.org/sax/features/namespaces") && z) {
                    return;
                }
                if (!str.equals("http://xml.org/sax/features/namespace-prefixes") || z) {
                    throw new SAXNotRecognizedException(str);
                }
            }

            @Override // org.xml.sax.XMLReader
            public Object getProperty(String str) throws SAXNotRecognizedException {
                if ("http://xml.org/sax/properties/lexical-handler".equals(str)) {
                    return this.lexicalHandler;
                }
                throw new SAXNotRecognizedException(str);
            }

            @Override // org.xml.sax.XMLReader
            public void setProperty(String str, Object obj2) throws SAXNotRecognizedException {
                if ("http://xml.org/sax/properties/lexical-handler".equals(str)) {
                    this.lexicalHandler = (LexicalHandler) obj2;
                    return;
                }
                throw new SAXNotRecognizedException(str);
            }

            @Override // org.xml.sax.XMLReader
            public void setEntityResolver(EntityResolver entityResolver) {
                this.entityResolver = entityResolver;
            }

            @Override // org.xml.sax.XMLReader
            public EntityResolver getEntityResolver() {
                return this.entityResolver;
            }

            @Override // org.xml.sax.XMLReader
            public void setDTDHandler(DTDHandler dTDHandler) {
                this.dtdHandler = dTDHandler;
            }

            @Override // org.xml.sax.XMLReader
            public DTDHandler getDTDHandler() {
                return this.dtdHandler;
            }

            @Override // org.xml.sax.XMLReader
            public void setContentHandler(ContentHandler contentHandler) {
                this.repeater.setContentHandler(contentHandler);
            }

            @Override // org.xml.sax.XMLReader
            public ContentHandler getContentHandler() {
                return this.repeater.getContentHandler();
            }

            @Override // org.xml.sax.XMLReader
            public void setErrorHandler(ErrorHandler errorHandler) {
                this.errorHandler = errorHandler;
            }

            @Override // org.xml.sax.XMLReader
            public ErrorHandler getErrorHandler() {
                return this.errorHandler;
            }

            @Override // org.xml.sax.XMLReader
            public void parse(InputSource inputSource) throws SAXException {
                parse();
            }

            @Override // org.xml.sax.XMLReader
            public void parse(String str) throws SAXException {
                parse();
            }

            public void parse() throws SAXException {
                try {
                    JAXBSource.this.marshaller.marshal(JAXBSource.this.contentObject, (XMLFilterImpl) this.repeater);
                } catch (JAXBException e) {
                    SAXParseException sAXParseException = new SAXParseException(e.getMessage(), null, null, -1, -1, e);
                    ErrorHandler errorHandler = this.errorHandler;
                    if (errorHandler != null) {
                        errorHandler.fatalError(sAXParseException);
                    }
                    throw sAXParseException;
                }
            }
        };
        this.pseudoParser = xMLReader;
        if (marshaller == null) {
            throw new JAXBException(Messages.format("JAXBSource.NullMarshaller"));
        }
        if (obj == null) {
            throw new JAXBException(Messages.format("JAXBSource.NullContent"));
        }
        this.marshaller = marshaller;
        this.contentObject = obj;
        super.setXMLReader(xMLReader);
        super.setInputSource(new InputSource());
    }

    private static Marshaller assertionFailed(String str) throws JAXBException {
        throw new JAXBException(str);
    }
}
