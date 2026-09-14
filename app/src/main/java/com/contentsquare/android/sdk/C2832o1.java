package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.EtrKt;
import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.o1 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nEtrScreenEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EtrScreenEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/EtrScreenEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 EtrKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EtrKtKt\n*L\n1#1,27:1\n11#2:28\n1#3:29\n1#3:31\n11#4:30\n*S KotlinDebug\n*F\n+ 1 EtrScreenEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/EtrScreenEvent\n*L\n21#1:28\n21#1:29\n22#1:31\n22#1:30\n*E\n"})
public final class C2832o1 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f2935a;

    public C2832o1(@NotNull String name, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f2935a = name;
        setTimestamp(j);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        EtrKt.Dsl.Companion companion = EtrKt.Dsl.INSTANCE;
        SessionRecordingV1.Etr.Builder builderNewBuilder = SessionRecordingV1.Etr.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        EtrKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        dsl_create.setName(this.f2935a);
        dslM1141a.setEtrScreen(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
