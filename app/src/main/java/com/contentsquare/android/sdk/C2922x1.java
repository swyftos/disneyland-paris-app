package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2922x1 {

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final List<Integer> f3222c = CollectionsKt.listOf((Object[]) new Integer[]{25, 26, 21, Integer.valueOf(SessionRecordingV1.Event.EventCase.CUSTOM_ERROR.getNumber()), Integer.valueOf(SessionRecordingV1.Event.EventCase.JS_ERROR.getNumber()), Integer.valueOf(SessionRecordingV1.Event.EventCase.NETWORK_REQUEST_METRIC.getNumber())});

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ScreenViewTracker f3223a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final LinkedHashMap f3224b;

    public C2922x1(@NotNull ScreenViewTracker screenViewTracker) {
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        this.f3223a = screenViewTracker;
        this.f3224b = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m1231a(int i) {
        if (!f3222c.contains(Integer.valueOf(i))) {
            return false;
        }
        if (this.f3223a.isScreenNumberChanged()) {
            this.f3224b.clear();
            this.f3223a.updateLastScreenNumber();
        }
        Integer num = (Integer) this.f3224b.get(Integer.valueOf(i));
        return (num != null ? num.intValue() : 0) >= 20;
    }
}
