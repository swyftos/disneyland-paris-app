package javax.xml.bind;

/* loaded from: classes5.dex */
public interface Validator {
    ValidationEventHandler getEventHandler() throws JAXBException;

    Object getProperty(String str) throws PropertyException;

    void setEventHandler(ValidationEventHandler validationEventHandler) throws JAXBException;

    void setProperty(String str, Object obj) throws PropertyException;

    boolean validate(Object obj) throws JAXBException;

    boolean validateRoot(Object obj) throws JAXBException;
}
