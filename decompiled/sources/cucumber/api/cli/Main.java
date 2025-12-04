package cucumber.api.cli;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

@Deprecated
/* loaded from: classes5.dex */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] strArr) {
        System.exit(run(strArr, Thread.currentThread().getContextClassLoader()));
    }

    public static byte run(String[] strArr, ClassLoader classLoader) {
        log.warn("You are using deprecated Main class. Please use io.cucumber.core.cli.Main");
        return io.cucumber.core.cli.Main.run(strArr, classLoader);
    }
}
