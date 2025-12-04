package androidx.test;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;

@Deprecated
/* loaded from: classes2.dex */
public final class InstrumentationRegistry {
    @Deprecated
    public static Instrumentation getInstrumentation() {
        return androidx.test.platform.app.InstrumentationRegistry.getInstrumentation();
    }

    @Deprecated
    public static Bundle getArguments() {
        return androidx.test.platform.app.InstrumentationRegistry.getArguments();
    }

    @Deprecated
    public static Context getContext() {
        return getInstrumentation().getContext();
    }

    @Deprecated
    public static Context getTargetContext() {
        return getInstrumentation().getTargetContext();
    }

    @Deprecated
    public static void registerInstance(Instrumentation instrumentation, Bundle bundle) {
        androidx.test.platform.app.InstrumentationRegistry.registerInstance(instrumentation, bundle);
    }
}
