package androidx.test.internal.platform.util;

import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class InstrumentationParameterUtil {
    public static long getTimeoutMillis(String str, long j) throws NumberFormatException {
        Checks.checkArgument(j != 0, "default timeout value cannot be zero");
        long j2 = Long.parseLong(InstrumentationRegistry.getArguments().getString(str, "0"));
        if (j2 != 0) {
            j = j2;
        }
        return j < 0 ? TimeUnit.DAYS.toMillis(1L) : j;
    }
}
