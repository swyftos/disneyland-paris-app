package androidx.work.impl.utils;

import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(26)
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0003"}, m1836d2 = {"toMillisCompat", "", "Ljava/time/Duration;", "work-runtime_release"}, m1837k = 2, m1838mv = {1, 8, 0}, m1840xi = 48)
@JvmName(name = "DurationApi26Impl")
public final class DurationApi26Impl {
    @DoNotInline
    public static final long toMillisCompat(@NotNull Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return duration.toMillis();
    }
}
