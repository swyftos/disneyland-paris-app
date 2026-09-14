package javax.xml.bind;

import org.xml.sax.ContentHandler;

/* JADX INFO: loaded from: classes5.dex */
public interface UnmarshallerHandler extends ContentHandler {
    Object getResult() throws IllegalStateException, JAXBException;
}
