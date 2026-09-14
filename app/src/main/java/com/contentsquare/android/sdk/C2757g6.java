package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g6 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C2757g6 {
    /* JADX INFO: renamed from: a */
    public static EventKt.Dsl m1141a(String str, EventKt.Dsl.Companion companion) {
        SessionRecordingV1.Event.Builder builderNewBuilder = SessionRecordingV1.Event.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, str);
        return companion._create(builderNewBuilder);
    }
}
