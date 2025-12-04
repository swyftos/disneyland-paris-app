package com.urbanairship.util;

import android.net.TrafficStats;
import android.os.HandlerThread;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/util/AirshipHandlerThread;", "Landroid/os/HandlerThread;", "name", "", "(Ljava/lang/String;)V", "run", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AirshipHandlerThread extends HandlerThread {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AirshipHandlerThread(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    @CallSuper
    public void run() {
        TrafficStats.setThreadStatsTag(AirshipThreadFactory.THREAD_STATS_TAG);
        super.run();
    }
}
