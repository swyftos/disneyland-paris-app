package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.JsErrorKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nJsErrorSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/JsErrorSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 JsErrorKt.kt\ncom/contentsquare/proto/sessionreplay/v1/JsErrorKtKt\n*L\n1#1,33:1\n11#2:34\n1#3:35\n1#3:37\n11#4:36\n*S KotlinDebug\n*F\n+ 1 JsErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/JsErrorSrEvent\n*L\n20#1:34\n20#1:35\n21#1:37\n21#1:36\n*E\n"})
/* loaded from: classes2.dex */
public final class C2 extends AbstractC0707i6 {

    @NotNull
    public final A2 a;

    public C2(@NotNull A2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a = event;
        setTimestamp(event.j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2) && Intrinsics.areEqual(this.a, ((C2) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        JsErrorKt.Dsl.Companion companion = JsErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.JsError.Builder builderNewBuilder = SessionRecordingV1.JsError.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        JsErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        String str = this.a.m;
        if (str == null) {
            str = "";
        }
        dsl_create.setMessage(str);
        String str2 = this.a.n;
        if (str2 == null) {
            str2 = "";
        }
        dsl_create.setFilename(str2);
        String str3 = this.a.o;
        if (str3 == null) {
            str3 = "";
        }
        dsl_create.setPageUrl(str3);
        Integer num = this.a.p;
        dsl_create.setColNumber(num != null ? num.intValue() : 0);
        Integer num2 = this.a.q;
        dsl_create.setLineNumber(num2 != null ? num2.intValue() : 0);
        String str4 = this.a.r;
        dsl_create.setErrorSource(str4 != null ? str4 : "");
        Long l = this.a.s;
        dsl_create.setRelativeTime(l != null ? l.longValue() : 0L);
        dsl_create.setUnixTimestampMs(this.a.j);
        dslA.setJsError(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        return "JsErrorSrEvent(event=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
