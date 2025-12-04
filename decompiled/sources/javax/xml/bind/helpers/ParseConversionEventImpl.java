package javax.xml.bind.helpers;

import javax.xml.bind.ParseConversionEvent;
import javax.xml.bind.ValidationEventLocator;

/* loaded from: classes5.dex */
public class ParseConversionEventImpl extends ValidationEventImpl implements ParseConversionEvent {
    public ParseConversionEventImpl(int i, String str, ValidationEventLocator validationEventLocator) {
        super(i, str, validationEventLocator);
    }

    public ParseConversionEventImpl(int i, String str, ValidationEventLocator validationEventLocator, Throwable th) {
        super(i, str, validationEventLocator, th);
    }
}
