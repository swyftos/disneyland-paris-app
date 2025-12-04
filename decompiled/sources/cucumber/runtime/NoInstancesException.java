package cucumber.runtime;

/* loaded from: classes5.dex */
public class NoInstancesException extends CucumberException {
    public NoInstancesException(Class cls) {
        super(createMessage(cls));
    }

    private static String createMessage(Class cls) {
        return String.format("Couldn't find a single implementation of " + cls, new Object[0]);
    }
}
