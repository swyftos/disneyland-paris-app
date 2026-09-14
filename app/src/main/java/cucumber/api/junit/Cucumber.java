package cucumber.api.junit;

import org.apiguardian.api.API;
import org.junit.runners.model.InitializationError;

/* JADX INFO: loaded from: classes5.dex */
@API(status = API.Status.MAINTAINED)
@Deprecated
public class Cucumber extends io.cucumber.junit.Cucumber {
    public Cucumber(Class cls) throws InitializationError {
        super(cls);
    }
}
