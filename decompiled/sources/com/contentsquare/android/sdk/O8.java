package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.contentsquare.proto.sessionreplay.v1.WebviewEventKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nWebViewEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/WebViewSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 WebviewEventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/WebviewEventKtKt\n*L\n1#1,71:1\n11#2:72\n1#3:73\n1#3:75\n11#4:74\n*S KotlinDebug\n*F\n+ 1 WebViewEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/WebViewSrEvent\n*L\n50#1:72\n50#1:73\n51#1:75\n51#1:74\n*E\n"})
/* loaded from: classes2.dex */
public final class O8 extends E8 {
    public final long a;

    @NotNull
    public final String b;

    public O8(@NotNull String event, long j) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a = j;
        this.b = event;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof O8) {
            O8 o8 = (O8) obj;
            if (this.a == o8.a && Intrinsics.areEqual(this.b, o8.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.a) + ((this.b.hashCode() + 31) * 31);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        WebviewEventKt.Dsl.Companion companion = WebviewEventKt.Dsl.INSTANCE;
        SessionRecordingV1.WebviewEvent.Builder builderNewBuilder = SessionRecordingV1.WebviewEvent.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        WebviewEventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setEvent(this.b);
        dsl_create.setWebviewId(this.a);
        dslA.setWebviewEvent(dsl_create._build());
        return dslA._build();
    }
}
