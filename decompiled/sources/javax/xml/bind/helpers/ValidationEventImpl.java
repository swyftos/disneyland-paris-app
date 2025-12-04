package javax.xml.bind.helpers;

import java.text.MessageFormat;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;

/* loaded from: classes5.dex */
public class ValidationEventImpl implements ValidationEvent {
    private Throwable linkedException;
    private ValidationEventLocator locator;
    private String message;
    private int severity;

    public ValidationEventImpl(int i, String str, ValidationEventLocator validationEventLocator) {
        this(i, str, validationEventLocator, null);
    }

    public ValidationEventImpl(int i, String str, ValidationEventLocator validationEventLocator, Throwable th) {
        setSeverity(i);
        this.message = str;
        this.locator = validationEventLocator;
        this.linkedException = th;
    }

    @Override // javax.xml.bind.ValidationEvent
    public int getSeverity() {
        return this.severity;
    }

    public void setSeverity(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException(Messages.format("ValidationEventImpl.IllegalSeverity"));
        }
        this.severity = i;
    }

    @Override // javax.xml.bind.ValidationEvent
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // javax.xml.bind.ValidationEvent
    public Throwable getLinkedException() {
        return this.linkedException;
    }

    public void setLinkedException(Throwable th) {
        this.linkedException = th;
    }

    @Override // javax.xml.bind.ValidationEvent
    public ValidationEventLocator getLocator() {
        return this.locator;
    }

    public void setLocator(ValidationEventLocator validationEventLocator) {
        this.locator = validationEventLocator;
    }

    public String toString() {
        String strValueOf;
        int severity = getSeverity();
        if (severity == 0) {
            strValueOf = "WARNING";
        } else if (severity == 1) {
            strValueOf = "ERROR";
        } else if (severity == 2) {
            strValueOf = "FATAL_ERROR";
        } else {
            strValueOf = String.valueOf(getSeverity());
        }
        return MessageFormat.format("[severity={0},message={1},locator={2}]", strValueOf, getMessage(), getLocator());
    }
}
