package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.p023v1.WebviewEventKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.O8 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nWebViewEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/WebViewSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WebviewEventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/WebviewEventKtKt\n*L\n1#1,71:1\n11#2:72\n1#3:73\n1#3:75\n11#4:74\n*S KotlinDebug\n*F\n+ 1 WebViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/WebViewSrEvent\n*L\n50#1:72\n50#1:73\n51#1:75\n51#1:74\n*E\n"})
public final class C2585O8 extends AbstractC2485E8 {

    /* JADX INFO: renamed from: a */
    public final long f1947a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f1948b;

    public C2585O8(@NotNull String event, long j) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1947a = j;
        this.f1948b = event;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof C2585O8) {
            C2585O8 c2585o8 = (C2585O8) obj;
            if (this.f1947a == c2585o8.f1947a && Intrinsics.areEqual(this.f1948b, c2585o8.f1948b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1947a) + ((this.f1948b.hashCode() + 31) * 31);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        WebviewEventKt.Dsl.Companion companion = WebviewEventKt.Dsl.INSTANCE;
        SessionRecordingV1.WebviewEvent.Builder builderNewBuilder = SessionRecordingV1.WebviewEvent.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        WebviewEventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setEvent(this.f1948b);
        dsl_create.setWebviewId(this.f1947a);
        dslM1141a.setWebviewEvent(dsl_create._build());
        return dslM1141a._build();
    }
}
