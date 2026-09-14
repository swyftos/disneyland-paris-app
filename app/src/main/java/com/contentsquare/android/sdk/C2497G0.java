package com.contentsquare.android.sdk;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.proto.sessionreplay.p023v1.CrashKt;
import com.contentsquare.proto.sessionreplay.p023v1.EventKt;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.G0 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nCrashSrEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CrashSrEvent\n+ 2 EventKt.kt\ncom/contentsquare/proto/sessionreplay/v1/EventKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 CrashKt.kt\ncom/contentsquare/proto/sessionreplay/v1/CrashKtKt\n*L\n1#1,32:1\n11#2:33\n1#3:34\n1#3:36\n11#4:35\n*S KotlinDebug\n*F\n+ 1 CrashSrEvent.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/events/CrashSrEvent\n*L\n23#1:33\n23#1:34\n24#1:36\n24#1:35\n*E\n"})
public final class C2497G0 extends AbstractC2777i6 {

    /* JADX INFO: renamed from: a */
    public final long f1622a;

    /* JADX INFO: renamed from: b */
    public final long f1623b;

    /* JADX INFO: renamed from: c */
    public final long f1624c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final String f1625d;

    public C2497G0(long j, long j2, long j3, @NotNull String errorSource) {
        Intrinsics.checkNotNullParameter(errorSource, "errorSource");
        this.f1622a = j;
        this.f1623b = j2;
        this.f1624c = j3;
        this.f1625d = errorSource;
        setTimestamp(j);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2497G0)) {
            return false;
        }
        C2497G0 c2497g0 = (C2497G0) obj;
        return this.f1622a == c2497g0.f1622a && this.f1623b == c2497g0.f1623b && this.f1624c == c2497g0.f1624c && Intrinsics.areEqual(this.f1625d, c2497g0.f1625d);
    }

    public final int hashCode() {
        return this.f1625d.hashCode() + ((Long.hashCode(this.f1624c) + ((Long.hashCode(this.f1623b) + (Long.hashCode(this.f1622a) * 31)) * 31)) * 31);
    }

    @Override // com.contentsquare.android.sdk.AbstractC2777i6
    @NotNull
    /* JADX INFO: renamed from: toProto */
    public final SessionRecordingV1.Event getBaseEvent() {
        EventKt.Dsl dslM1141a = C2757g6.m1141a("newBuilder()", EventKt.Dsl.INSTANCE);
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        SessionRecordingV1.Crash.Builder builderNewBuilder = SessionRecordingV1.Crash.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setUnixTimestampMs(getTimestamp());
        dsl_create.setCrashId(this.f1623b);
        dsl_create.setRelativeTime(this.f1624c);
        dsl_create.setErrorSource(this.f1625d);
        dslM1141a.setCrash(dsl_create._build());
        return dslM1141a._build();
    }

    @NotNull
    public final String toString() {
        return "CrashSrEvent(currentTimestamp=" + this.f1622a + ", crashId=" + this.f1623b + ", relativeTime=" + this.f1624c + ", errorSource=" + this.f1625d + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
