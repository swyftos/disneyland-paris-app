package androidx.work.impl;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0003\"\u0014\u0010\u0001\u001a\u00020\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, m1836d2 = {"", "PRUNE_THRESHOLD_MILLIS", "J", "work-runtime_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class WorkDatabaseKt {

    @JvmField
    public static final long PRUNE_THRESHOLD_MILLIS = TimeUnit.DAYS.toMillis(1);
}
