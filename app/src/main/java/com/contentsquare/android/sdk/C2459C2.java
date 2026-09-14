package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.JsErrorKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.C2 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nJsErrorSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/JsErrorSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 JsErrorKt.kt\ncom/contentsquare/proto/sessionreplay/v1/JsErrorKtKt\n*L\n1#1,33:1\n11#2:34\n1#3:35\n1#3:37\n11#4:36\n*S KotlinDebug\n*F\n+ 1 JsErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/JsErrorSrEvent\n*L\n20#1:34\n20#1:35\n21#1:37\n21#1:36\n*E\n"})
public final class C2459C2 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2439A2 f1458a;

    public C2459C2(@NotNull C2439A2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f1458a = event;
        setTimestamp(event.f2555j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2459C2) && Intrinsics.areEqual(this.f1458a, ((C2459C2) obj).f1458a);
    }

    public final int hashCode() {
        return this.f1458a.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        JsErrorKt.Dsl.Companion companion = JsErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.JsError.Builder builderNewBuilder = SessionRecordingV1.JsError.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        JsErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        String str = this.f1458a.f1373m;
        if (str == null) {
            str = "";
        }
        dsl_create.setMessage(str);
        String str2 = this.f1458a.f1374n;
        if (str2 == null) {
            str2 = "";
        }
        dsl_create.setFilename(str2);
        String str3 = this.f1458a.f1375o;
        if (str3 == null) {
            str3 = "";
        }
        dsl_create.setPageUrl(str3);
        Integer num = this.f1458a.f1376p;
        dsl_create.setColNumber(num != null ? num.intValue() : 0);
        Integer num2 = this.f1458a.f1377q;
        dsl_create.setLineNumber(num2 != null ? num2.intValue() : 0);
        String str4 = this.f1458a.f1378r;
        dsl_create.setErrorSource(str4 != null ? str4 : "");
        Long l = this.f1458a.f1379s;
        dsl_create.setRelativeTime(l != null ? l.longValue() : 0L);
        dsl_create.setUnixTimestampMs(this.f1458a.f2555j);
        dslM1141a.setJsError(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        return "JsErrorSrEvent(event=" + this.f1458a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
