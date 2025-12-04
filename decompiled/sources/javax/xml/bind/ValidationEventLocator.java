package javax.xml.bind;

import java.net.URL;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public interface ValidationEventLocator {
    int getColumnNumber();

    int getLineNumber();

    Node getNode();

    Object getObject();

    int getOffset();

    URL getURL();
}
