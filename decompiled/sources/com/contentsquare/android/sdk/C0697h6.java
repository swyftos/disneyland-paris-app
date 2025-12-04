package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.v1.AppStateChangeKt;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSrAppStateEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SrAppStateEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/appstate/SrAppStateEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppStateChangeKt.kt\ncom/contentsquare/proto/sessionreplay/v1/AppStateChangeKtKt\n*L\n1#1,45:1\n11#2:46\n1#3:47\n1#3:49\n11#4:48\n*S KotlinDebug\n*F\n+ 1 SrAppStateEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/appstate/SrAppStateEvent\n*L\n33#1:46\n33#1:47\n34#1:49\n34#1:48\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.h6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0697h6 extends AbstractC0707i6 {

    @NotNull
    public final EnumC0677f6 a;

    public C0697h6(long j, @NotNull EnumC0677f6 srAppState) {
        Intrinsics.checkNotNullParameter(srAppState, "srAppState");
        this.a = srAppState;
        setTimestamp(j);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        SessionRecordingV1.AppStateChange.Transition transition;
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        AppStateChangeKt.Dsl.Companion companion = AppStateChangeKt.Dsl.INSTANCE;
        SessionRecordingV1.AppStateChange.Builder builderNewBuilder = SessionRecordingV1.AppStateChange.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        AppStateChangeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            transition = SessionRecordingV1.AppStateChange.Transition.TRANSITION_BACKGROUND;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            transition = SessionRecordingV1.AppStateChange.Transition.TRANSITION_FOREGROUND;
        }
        dsl_create.setStateTransition(transition);
        dslA.setAppStateChange(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
