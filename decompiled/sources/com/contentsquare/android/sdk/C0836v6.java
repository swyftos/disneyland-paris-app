package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.RecordingStartKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSrStartEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrStartEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/startstop/SrStartEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 RecordingStartKt.kt\ncom/contentsquare/proto/sessionreplay/v1/RecordingStartKtKt\n*L\n1#1,56:1\n11#2:57\n1#3:58\n1#3:60\n11#4:59\n*S KotlinDebug\n*F\n+ 1 SrStartEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/startstop/SrStartEvent\n*L\n28#1:57\n28#1:58\n29#1:60\n29#1:59\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.v6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0836v6 extends AbstractC0707i6 {

    @NotNull
    public final EnumC0845w6 a;
    public final boolean b;

    public C0836v6(long j, @NotNull EnumC0845w6 reason, boolean z) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.a = reason;
        this.b = z;
        setTimestamp(j);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        SessionRecordingV1.RecordingStart.StartReason startReason;
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        RecordingStartKt.Dsl.Companion companion = RecordingStartKt.Dsl.INSTANCE;
        SessionRecordingV1.RecordingStart.Builder builderNewBuilder = SessionRecordingV1.RecordingStart.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        RecordingStartKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            startReason = SessionRecordingV1.RecordingStart.StartReason.START_REASON_REGULAR;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            startReason = SessionRecordingV1.RecordingStart.StartReason.START_REASON_FORCED;
        }
        dsl_create.setStartReason(startReason);
        dsl_create.setIsNewSession(this.b);
        dslA.setRecordingStart(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
