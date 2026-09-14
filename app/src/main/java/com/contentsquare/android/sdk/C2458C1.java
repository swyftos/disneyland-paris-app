package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.C1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2458C1 extends AbstractC2448B1 {

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SessionRecordingV1.EventPayload.Builder f1456b;

    /* JADX INFO: renamed from: c */
    public int f1457c;

    public C2458C1(SessionRecordingV1.EventPayload.Position position) {
        SessionRecordingV1.EventPayload.Builder payload = SessionRecordingV1.EventPayload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(payload, "newBuilder()");
        System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(position, "position");
        this.f1456b = payload;
        payload.setSchemaVersion("1");
        payload.setPosition(position);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final byte[] m882a() {
        byte[] byteArray = this.f1456b.build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "payload.build().toByteArray()");
        return byteArray;
    }
}
