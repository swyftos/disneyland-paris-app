package cucumber.runtime;

/* loaded from: classes5.dex */
public class CucumberException extends RuntimeException {
    public CucumberException(String str) {
        super(str);
    }

    public CucumberException(String str, Throwable th) {
        super(str, th);
    }

    public CucumberException(Throwable th) {
        super(th);
    }
}
