package ch.qos.logback.core.joran.event;

import ch.qos.logback.core.joran.spi.ElementPath;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes2.dex */
public class StartEvent extends SaxEvent {
    public final Attributes attributes;
    public final ElementPath elementPath;

    StartEvent(ElementPath elementPath, String str, String str2, String str3, Attributes attributes, Locator locator) {
        super(str, str2, str3, locator);
        this.attributes = new AttributesImpl(attributes);
        this.elementPath = elementPath;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StartEvent(");
        sb.append(getQName());
        if (this.attributes != null) {
            for (int i = 0; i < this.attributes.getLength(); i++) {
                if (i > 0) {
                    sb.append(' ');
                }
                sb.append(this.attributes.getLocalName(i));
                sb.append("=\"");
                sb.append(this.attributes.getValue(i));
                sb.append("\"");
            }
        }
        sb.append(")  [");
        sb.append(this.locator.getLineNumber());
        sb.append(",");
        sb.append(this.locator.getColumnNumber());
        sb.append("]");
        return sb.toString();
    }
}
