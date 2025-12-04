package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.contentsquare.android.sdk.g6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0687g6 {
    public static EventKt.Dsl a(String str, EventKt.Dsl.Companion companion) {
        SessionRecordingV1.Event.Builder builderNewBuilder = SessionRecordingV1.Event.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, str);
        return companion._create(builderNewBuilder);
    }
}
