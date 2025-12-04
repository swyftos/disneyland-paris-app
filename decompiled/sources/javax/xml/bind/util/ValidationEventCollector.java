package javax.xml.bind.util;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

/* loaded from: classes5.dex */
public class ValidationEventCollector implements ValidationEventHandler {
    private final List events = new ArrayList();

    public ValidationEvent[] getEvents() {
        List list = this.events;
        return (ValidationEvent[]) list.toArray(new ValidationEvent[list.size()]);
    }

    public void reset() {
        this.events.clear();
    }

    public boolean hasEvents() {
        return !this.events.isEmpty();
    }

    @Override // javax.xml.bind.ValidationEventHandler
    public boolean handleEvent(ValidationEvent validationEvent) {
        this.events.add(validationEvent);
        int severity = validationEvent.getSeverity();
        if (severity == 0 || severity == 1) {
            return true;
        }
        if (severity == 2) {
            return false;
        }
        _assert(false, Messages.format("ValidationEventCollector.UnrecognizedSeverity", Integer.valueOf(validationEvent.getSeverity())));
        return true;
    }

    private static void _assert(boolean z, String str) {
        if (!z) {
            throw new InternalError(str);
        }
    }
}
