package javax.xml.bind.helpers;

import javax.xml.bind.NotIdentifiableEvent;
import javax.xml.bind.ValidationEventLocator;

/* loaded from: classes5.dex */
public class NotIdentifiableEventImpl extends ValidationEventImpl implements NotIdentifiableEvent {
    public NotIdentifiableEventImpl(int i, String str, ValidationEventLocator validationEventLocator) {
        super(i, str, validationEventLocator);
    }

    public NotIdentifiableEventImpl(int i, String str, ValidationEventLocator validationEventLocator, Throwable th) {
        super(i, str, validationEventLocator, th);
    }
}
