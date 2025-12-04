package androidx.test.platform.app;

import android.app.Instrumentation;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class InstrumentationRegistry {
    private static final AtomicReference instrumentationRef = new AtomicReference(null);
    private static final AtomicReference arguments = new AtomicReference(null);

    public static Instrumentation getInstrumentation() {
        Instrumentation instrumentation = (Instrumentation) instrumentationRef.get();
        if (instrumentation != null) {
            return instrumentation;
        }
        throw new IllegalStateException("No instrumentation registered! Must run under a registering instrumentation.");
    }

    public static Bundle getArguments() {
        Bundle bundle = (Bundle) arguments.get();
        if (bundle == null) {
            throw new IllegalStateException("No instrumentation arguments registered! Are you running under an Instrumentation which registers arguments?");
        }
        return new Bundle(bundle);
    }

    public static void registerInstance(Instrumentation instrumentation, Bundle bundle) {
        instrumentationRef.set(instrumentation);
        arguments.set(new Bundle(bundle));
    }
}
