package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.x1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0849x1 {

    @NotNull
    public static final List<Integer> c = CollectionsKt.listOf((Object[]) new Integer[]{25, 26, 21, Integer.valueOf(SessionRecordingV1.Event.EventCase.CUSTOM_ERROR.getNumber()), Integer.valueOf(SessionRecordingV1.Event.EventCase.JS_ERROR.getNumber()), Integer.valueOf(SessionRecordingV1.Event.EventCase.NETWORK_REQUEST_METRIC.getNumber())});

    @NotNull
    public final ScreenViewTracker a;

    @NotNull
    public final LinkedHashMap b;

    public C0849x1(@NotNull ScreenViewTracker screenViewTracker) {
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        this.a = screenViewTracker;
        this.b = new LinkedHashMap();
    }

    public final boolean a(int i) {
        if (!c.contains(Integer.valueOf(i))) {
            return false;
        }
        if (this.a.isScreenNumberChanged()) {
            this.b.clear();
            this.a.updateLastScreenNumber();
        }
        Integer num = (Integer) this.b.get(Integer.valueOf(i));
        return (num != null ? num.intValue() : 0) >= 20;
    }
}
