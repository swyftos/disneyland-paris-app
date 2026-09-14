package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.RemovalMutationKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.g3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nMutationRemovalEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutationRemovalEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/MutationRemovalEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 RemovalMutationKt.kt\ncom/contentsquare/proto/sessionreplay/v1/RemovalMutationKtKt\n*L\n1#1,35:1\n11#2:36\n1#3:37\n1#3:39\n11#4:38\n*S KotlinDebug\n*F\n+ 1 MutationRemovalEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/MutationRemovalEvent\n*L\n28#1:36\n28#1:37\n29#1:39\n29#1:38\n*E\n"})
public final class C2754g3 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    public final long f2664a;

    public C2754g3(long j, long j2) {
        this.f2664a = j2;
        setTimestamp(j);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        RemovalMutationKt.Dsl.Companion companion = RemovalMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.RemovalMutation.Builder builderNewBuilder = SessionRecordingV1.RemovalMutation.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        RemovalMutationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        dsl_create.setViewId(this.f2664a);
        dslM1141a.setRemovalMutation(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
