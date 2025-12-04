package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.CrashKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"contextOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$CrashOrBuilder;", "getContextOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$CrashOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "threadReportOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "getThreadReportOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$CrashOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "crash", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializecrash", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrashKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/CrashKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
/* loaded from: classes3.dex */
public final class CrashKtKt {
    @JvmName(name = "-initializecrash")
    @NotNull
    /* renamed from: -initializecrash, reason: not valid java name */
    public static final MobileStacktrace.Crash m748initializecrash(Function1<? super CrashKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        MobileStacktrace.Crash.Builder builderNewBuilder = MobileStacktrace.Crash.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.Crash copy(MobileStacktrace.Crash crash, Function1<? super CrashKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(crash, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        MobileStacktrace.Crash.Builder builder = crash.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final MobileStacktrace.Context getContextOrNull(MobileStacktrace.CrashOrBuilder crashOrBuilder) {
        Intrinsics.checkNotNullParameter(crashOrBuilder, "<this>");
        if (crashOrBuilder.hasContext()) {
            return crashOrBuilder.getContext();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.ThreadReport getThreadReportOrNull(MobileStacktrace.CrashOrBuilder crashOrBuilder) {
        Intrinsics.checkNotNullParameter(crashOrBuilder, "<this>");
        if (crashOrBuilder.hasThreadReport()) {
            return crashOrBuilder.getThreadReport();
        }
        return null;
    }
}
