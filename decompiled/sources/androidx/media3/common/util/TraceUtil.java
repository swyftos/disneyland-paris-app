package androidx.media3.common.util;

import android.os.Trace;

@UnstableApi
/* loaded from: classes.dex */
public final class TraceUtil {
    public static void beginSection(String str) {
        Trace.beginSection(str);
    }

    public static void endSection() {
        Trace.endSection();
    }
}
