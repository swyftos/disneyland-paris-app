package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.sessionreplay.p023v1.CustomErrorKt;
import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.V0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCustomErrorSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CustomErrorSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CustomErrorKt.kt\ncom/contentsquare/proto/sessionreplay/v1/CustomErrorKtKt\n*L\n1#1,30:1\n11#2:31\n1#3:32\n1#3:34\n11#4:33\n*S KotlinDebug\n*F\n+ 1 CustomErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CustomErrorSrEvent\n*L\n20#1:31\n20#1:32\n21#1:34\n21#1:33\n*E\n"})
public final class C2646V0 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2626T0 f2190a;

    public C2646V0(@NotNull C2626T0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f2190a = event;
        setTimestamp(event.f2555j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2646V0) && Intrinsics.areEqual(this.f2190a, ((C2646V0) obj).f2190a);
    }

    public final int hashCode() {
        return this.f2190a.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        CustomErrorKt.Dsl.Companion companion = CustomErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.CustomError.Builder builderNewBuilder = SessionRecordingV1.CustomError.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CustomErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        String str = this.f2190a.f2136m;
        if (str == null) {
            str = "";
        }
        dsl_create.setMessage(str);
        String str2 = this.f2190a.f2137n;
        dsl_create.setErrorSource(str2 != null ? str2 : "");
        Long l = this.f2190a.f2138o;
        dsl_create.setRelativeTime(l != null ? l.longValue() : 0L);
        dsl_create.putAllCustomAttributes(dsl_create.getCustomAttributesMap(), this.f2190a.f2139p);
        dsl_create.setUnixTimestampMs(this.f2190a.f2555j);
        dslM1141a.setCustomError(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        return "CustomErrorSrEvent(event=" + this.f2190a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
