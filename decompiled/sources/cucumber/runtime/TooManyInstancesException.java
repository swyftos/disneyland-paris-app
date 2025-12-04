package cucumber.runtime;

import java.util.Collection;

/* loaded from: classes5.dex */
public class TooManyInstancesException extends CucumberException {
    public TooManyInstancesException(Collection collection) {
        super(createMessage(collection));
    }

    private static String createMessage(Collection collection) {
        return String.format("Expected only one instance, but found too many: " + collection, new Object[0]);
    }
}
