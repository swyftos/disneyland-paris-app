package javax.xml.bind.helpers;

import javax.xml.bind.PrintConversionEvent;
import javax.xml.bind.ValidationEventLocator;

/* loaded from: classes5.dex */
public class PrintConversionEventImpl extends ValidationEventImpl implements PrintConversionEvent {
    public PrintConversionEventImpl(int i, String str, ValidationEventLocator validationEventLocator) {
        super(i, str, validationEventLocator);
    }

    public PrintConversionEventImpl(int i, String str, ValidationEventLocator validationEventLocator, Throwable th) {
        super(i, str, validationEventLocator, th);
    }
}
