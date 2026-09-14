package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.p023v1.TouchGestureKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.B7 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nTouchEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TouchEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/TouchEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 TouchGestureKt.kt\ncom/contentsquare/proto/sessionreplay/v1/TouchGestureKtKt\n*L\n1#1,38:1\n11#2:39\n1#3:40\n1#3:42\n11#4:41\n*S KotlinDebug\n*F\n+ 1 TouchEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/TouchEvent\n*L\n17#1:39\n17#1:40\n18#1:42\n18#1:41\n*E\n"})
public final class C2454B7 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final ArrayList f1449a = new ArrayList();

    /* JADX INFO: renamed from: b */
    @NotNull
    public final ArrayList f1450b = new ArrayList();

    /* JADX INFO: renamed from: c */
    @NotNull
    public final ArrayList f1451c = new ArrayList();

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        TouchGestureKt.Dsl.Companion companion = TouchGestureKt.Dsl.INSTANCE;
        SessionRecordingV1.TouchGesture.Builder builderNewBuilder = SessionRecordingV1.TouchGesture.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        TouchGestureKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.addAllUnixTimestampsMs(dsl_create.getUnixTimestampsMs(), this.f1449a);
        dsl_create.addAllXPositions(dsl_create.getXPositions(), this.f1450b);
        dsl_create.addAllYPositions(dsl_create.getYPositions(), this.f1451c);
        dslM1141a.setTouchGesture(dsl_create._build());
        return dslM1141a._build();
    }
}
