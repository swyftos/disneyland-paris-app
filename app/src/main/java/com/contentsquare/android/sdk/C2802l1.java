package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.EndOfScreenViewKt;
import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.l1 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nEndOfScreenViewEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EndOfScreenViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/EndOfScreenViewEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 EndOfScreenViewKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EndOfScreenViewKtKt\n*L\n1#1,31:1\n11#2:32\n1#3:33\n1#3:35\n11#4:34\n*S KotlinDebug\n*F\n+ 1 EndOfScreenViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/EndOfScreenViewEvent\n*L\n25#1:32\n25#1:33\n26#1:35\n26#1:34\n*E\n"})
public final class C2802l1 extends AbstractC2777i6 {
    public C2802l1(long j) {
        setTimestamp(j);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        EndOfScreenViewKt.Dsl.Companion companion = EndOfScreenViewKt.Dsl.INSTANCE;
        SessionRecordingV1.EndOfScreenView.Builder builderNewBuilder = SessionRecordingV1.EndOfScreenView.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EndOfScreenViewKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        dslM1141a.setEndOfScreenView(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
