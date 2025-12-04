package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class C1 extends B1 {

    @NotNull
    public final SessionRecordingV1.EventPayload.Builder b;
    public int c;

    public C1(SessionRecordingV1.EventPayload.Position position) {
        SessionRecordingV1.EventPayload.Builder payload = SessionRecordingV1.EventPayload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(payload, "newBuilder()");
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(position, "position");
        this.b = payload;
        payload.setSchemaVersion("1");
        payload.setPosition(position);
    }

    @NotNull
    public final byte[] a() {
        byte[] byteArray = this.b.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "payload.build().toByteArray()");
        return byteArray;
    }
}
