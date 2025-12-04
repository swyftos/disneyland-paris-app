package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.CrashKt;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"crash", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/sessionreplay/v1/CrashKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializecrash", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrashKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashKt.kt\ncom/contentsquare/proto/sessionreplay/v1/CrashKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n1#2:119\n*E\n"})
/* loaded from: classes3.dex */
public final class CrashKtKt {
    @JvmName(name = "-initializecrash")
    @NotNull
    /* renamed from: -initializecrash, reason: not valid java name */
    public static final SessionRecordingV1.Crash m1281initializecrash(Function1<? super CrashKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        SessionRecordingV1.Crash.Builder builderNewBuilder = SessionRecordingV1.Crash.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionRecordingV1.Crash copy(SessionRecordingV1.Crash crash, Function1<? super CrashKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(crash, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        SessionRecordingV1.Crash.Builder builder = crash.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
