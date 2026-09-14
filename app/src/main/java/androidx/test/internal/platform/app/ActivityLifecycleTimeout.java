package androidx.test.internal.platform.app;

import androidx.test.internal.platform.util.InstrumentationParameterUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityLifecycleTimeout {
    public static long getMillis() {
        return InstrumentationParameterUtil.getTimeoutMillis("activityLifecycleChangeTimeoutMillis", 45000L);
    }
}
