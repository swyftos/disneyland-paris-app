package javax.xml.bind.helpers;

import java.net.URL;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class DefaultValidationEventHandler implements ValidationEventHandler {
    @Override // javax.xml.bind.ValidationEventHandler
    public boolean handleEvent(ValidationEvent validationEvent) {
        String str;
        if (validationEvent == null) {
            throw new IllegalArgumentException();
        }
        int severity = validationEvent.getSeverity();
        boolean z = true;
        if (severity != 0) {
            if (severity == 1) {
                str = Messages.format("DefaultValidationEventHandler.Error");
            } else {
                str = severity != 2 ? null : Messages.format("DefaultValidationEventHandler.FatalError");
            }
            z = false;
        } else {
            str = Messages.format("DefaultValidationEventHandler.Warning");
        }
        System.out.println(Messages.format("DefaultValidationEventHandler.SeverityMessage", str, validationEvent.getMessage(), getLocation(validationEvent)));
        return z;
    }

    private String getLocation(ValidationEvent validationEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        ValidationEventLocator locator = validationEvent.getLocator();
        if (locator != null) {
            URL url = locator.getURL();
            Object object = locator.getObject();
            Node node = locator.getNode();
            int lineNumber = locator.getLineNumber();
            if (url != null || lineNumber != -1) {
                stringBuffer.append("line " + lineNumber);
                if (url != null) {
                    stringBuffer.append(" of " + url);
                }
            } else if (object != null) {
                stringBuffer.append(" obj: " + object.toString());
            } else if (node != null) {
                stringBuffer.append(" node: " + node.toString());
            }
        } else {
            stringBuffer.append(Messages.format("DefaultValidationEventHandler.LocationUnavailable"));
        }
        return stringBuffer.toString();
    }
}
