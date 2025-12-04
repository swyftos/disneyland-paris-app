package androidx.test.espresso;

import android.os.Looper;
import androidx.test.espresso.core.internal.deps.guava.base.Joiner;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class AppNotIdleException extends RuntimeException implements EspressoException {
    private AppNotIdleException(String str) {
        super(str);
        TestOutputEmitter.dumpThreadStates("ThreadState-AppNotIdleException.txt");
    }

    @Deprecated
    public static AppNotIdleException create(List<String> list, int i, int i2) {
        Preconditions.checkState(Looper.myLooper() == Looper.getMainLooper());
        return new AppNotIdleException(String.format(Locale.ROOT, "App not idle within timeout of %s seconds evenafter trying for %s iterations. The following Idle Conditions failed %s", Integer.valueOf(i2), Integer.valueOf(i), Joiner.on(",").join(list)));
    }

    public static AppNotIdleException create(List<String> list, String str) {
        return new AppNotIdleException(String.format(Locale.ROOT, "%s The following Idle Conditions failed %s.", str, Joiner.on(",").join(list)));
    }
}
