package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.InsertionMutationKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nMutationInsertionEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutationInsertionEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/MutationInsertionEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 InsertionMutationKt.kt\ncom/contentsquare/proto/sessionreplay/v1/InsertionMutationKtKt\n*L\n1#1,50:1\n11#2:51\n1#3:52\n1#3:54\n11#4:53\n*S KotlinDebug\n*F\n+ 1 MutationInsertionEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/MutationInsertionEvent\n*L\n37#1:51\n37#1:52\n38#1:54\n38#1:53\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.f3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0674f3 extends AbstractC0707i6 {
    public final long a;
    public final int b;

    @NotNull
    public final SessionRecordingV1.View c;

    public C0674f3(long j, long j2, int i, @NotNull ViewLight insertionView) {
        Intrinsics.checkNotNullParameter(insertionView, "insertionView");
        this.a = j2;
        this.b = i;
        setTimestamp(j);
        this.c = C0769o8.a(insertionView);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        InsertionMutationKt.Dsl.Companion companion = InsertionMutationKt.Dsl.INSTANCE;
        SessionRecordingV1.InsertionMutation.Builder builderNewBuilder = SessionRecordingV1.InsertionMutation.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        InsertionMutationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        long j = this.a;
        if (j != -1) {
            dsl_create.setParentViewId(j);
        }
        int i = this.b;
        if (i != -1) {
            dsl_create.setIndexInParent(i);
        }
        dsl_create.setUnixTimestampMs(getTimestamp());
        dsl_create.setView(this.c);
        dslA.setInsertionMutation(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        String string = getBaseEvent().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toProto().toString()");
        return string;
    }
}
