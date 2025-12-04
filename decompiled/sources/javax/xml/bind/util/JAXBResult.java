package javax.xml.bind.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.transform.sax.SAXResult;

/* loaded from: classes5.dex */
public class JAXBResult extends SAXResult {
    private final UnmarshallerHandler unmarshallerHandler;

    public JAXBResult(JAXBContext jAXBContext) throws JAXBException {
        this(jAXBContext == null ? assertionFailed() : jAXBContext.createUnmarshaller());
    }

    public JAXBResult(Unmarshaller unmarshaller) throws JAXBException {
        if (unmarshaller == null) {
            throw new JAXBException(Messages.format("JAXBResult.NullUnmarshaller"));
        }
        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
        this.unmarshallerHandler = unmarshallerHandler;
        super.setHandler(unmarshallerHandler);
    }

    public Object getResult() throws JAXBException {
        return this.unmarshallerHandler.getResult();
    }

    private static Unmarshaller assertionFailed() throws JAXBException {
        throw new JAXBException(Messages.format("JAXBResult.NullContext"));
    }
}
