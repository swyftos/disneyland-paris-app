package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.sessionreplay.v1.CrashKt;
import com.contentsquare.proto.sessionreplay.v1.EventKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCrashSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CrashSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CrashKt.kt\ncom/contentsquare/proto/sessionreplay/v1/CrashKtKt\n*L\n1#1,32:1\n11#2:33\n1#3:34\n1#3:36\n11#4:35\n*S KotlinDebug\n*F\n+ 1 CrashSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CrashSrEvent\n*L\n23#1:33\n23#1:34\n24#1:36\n24#1:35\n*E\n"})
/* loaded from: classes2.dex */
public final class G0 extends AbstractC0707i6 {
    public final long a;
    public final long b;
    public final long c;

    @NotNull
    public final String d;

    public G0(long j, long j2, long j3, @NotNull String errorSource) {
        Intrinsics.checkNotNullParameter(errorSource, "errorSource");
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = errorSource;
        setTimestamp(j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G0)) {
            return false;
        }
        G0 g0 = (G0) obj;
        return this.a == g0.a && this.b == g0.b && this.c == g0.c && Intrinsics.areEqual(this.d, g0.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((Long.hashCode(this.c) + ((Long.hashCode(this.b) + (Long.hashCode(this.a) * 31)) * 31)) * 31);
    }

    @Override // com.contentsquare.android.sdk.AbstractC0707i6
    @NotNull
    /* renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslA = C0687g6.a("newBuilder()", EventKt.Dsl.INSTANCE);
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        SessionRecordingV1.Crash.Builder builderNewBuilder = SessionRecordingV1.Crash.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        dsl_create.setCrashId(this.b);
        dsl_create.setRelativeTime(this.c);
        dsl_create.setErrorSource(this.d);
        dslA.setCrash(dsl_create._build());
        return dslA._build();
    }

    @NotNull
    public final String toString() {
        return "CrashSrEvent(currentTimestamp=" + this.a + ", crashId=" + this.b + ", relativeTime=" + this.c + ", errorSource=" + this.d + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
