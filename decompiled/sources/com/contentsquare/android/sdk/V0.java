package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.sessionreplay.v1.CustomErrorKt;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCustomErrorSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CustomErrorSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CustomErrorKt.kt\ncom/contentsquare/proto/sessionreplay/v1/CustomErrorKtKt\n*L\n1#1,30:1\n11#2:31\n1#3:32\n1#3:34\n11#4:33\n*S KotlinDebug\n*F\n+ 1 CustomErrorSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CustomErrorSrEvent\n*L\n20#1:31\n20#1:32\n21#1:34\n21#1:33\n*E\n"})
/* loaded from: classes2.dex */
public final class V0 extends AbstractC0707i6 {

    @NotNull
    public final T0 a;

    public V0(@NotNull T0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a = event;
        setTimestamp(event.j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof V0) && Intrinsics.areEqual(this.a, ((V0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        CustomErrorKt.Dsl.Companion companion = CustomErrorKt.Dsl.INSTANCE;
        SessionRecordingV1.CustomError.Builder builderNewBuilder = SessionRecordingV1.CustomError.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CustomErrorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        String str = this.a.m;
        if (str == null) {
            str = "";
        }
        dsl_create.setMessage(str);
        String str2 = this.a.n;
        dsl_create.setErrorSource(str2 != null ? str2 : "");
        Long l = this.a.o;
        dsl_create.setRelativeTime(l != null ? l.longValue() : 0L);
        dsl_create.putAllCustomAttributes(dsl_create.getCustomAttributesMap(), this.a.p);
        dsl_create.setUnixTimestampMs(this.a.j);
        dslA.setCustomError(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        return "CustomErrorSrEvent(event=" + this.a + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
