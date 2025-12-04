package androidx.test.core.app;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

/* loaded from: classes2.dex */
public final class ApplicationProvider {
    public static <T extends Context> T getApplicationContext() {
        return (T) InstrumentationRegistry.getInstrumentation().getTargetContext().getApplicationContext();
    }
}
