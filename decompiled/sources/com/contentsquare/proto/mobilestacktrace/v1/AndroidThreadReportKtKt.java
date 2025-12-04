package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.AndroidThreadReportKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0019\u001a)\u0010\u001a\u001a\u00020\u0013*\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000\u001a)\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000\u001a)\u0010\u001a\u001a\u00020\n*\u00020\n2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000\u001a)\u0010\u001a\u001a\u00020\u001d*\u00020\u001d2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000\u001a)\u0010\u001a\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000\u001a)\u0010\u001a\u001a\u00020 *\u00020 2\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00170\u0015¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"causeOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktraceOrBuilder;", "getCauseOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktraceOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "errorStacktraceOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReportOrBuilder;", "getErrorStacktraceOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "exceptionOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "getExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktraceOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "javaFrameOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$FrameOrBuilder;", "getJavaFrameOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$FrameOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;", "androidThreadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeandroidThreadReport", "copy", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$ThrowableKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$FrameKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$JavaFrameKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAndroidThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,794:1\n1#2:795\n*E\n"})
/* loaded from: classes3.dex */
public final class AndroidThreadReportKtKt {
    @JvmName(name = "-initializeandroidThreadReport")
    @NotNull
    /* renamed from: -initializeandroidThreadReport, reason: not valid java name */
    public static final MobileStacktrace.AndroidThreadReport m746initializeandroidThreadReport(Function1<? super AndroidThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.Dsl.Companion companion = AndroidThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        AndroidThreadReportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable copy(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable throwable, Function1<? super AndroidThreadReportKt.ErrorStacktraceKt.ThrowableKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(throwable, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.ErrorStacktraceKt.ThrowableKt.Dsl.Companion companion = AndroidThreadReportKt.ErrorStacktraceKt.ThrowableKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder builder = throwable.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.ErrorStacktraceKt.ThrowableKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.AndroidThreadReport.ErrorStacktrace copy(MobileStacktrace.AndroidThreadReport.ErrorStacktrace errorStacktrace, Function1<? super AndroidThreadReportKt.ErrorStacktraceKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(errorStacktrace, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.ErrorStacktraceKt.Dsl.Companion companion = AndroidThreadReportKt.ErrorStacktraceKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder builder = errorStacktrace.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.ErrorStacktraceKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.AndroidThreadReport.Frame copy(MobileStacktrace.AndroidThreadReport.Frame frame, Function1<? super AndroidThreadReportKt.FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(frame, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.FrameKt.Dsl.Companion companion = AndroidThreadReportKt.FrameKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Frame.Builder builder = frame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.FrameKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.AndroidThreadReport.JavaFrame copy(MobileStacktrace.AndroidThreadReport.JavaFrame javaFrame, Function1<? super AndroidThreadReportKt.JavaFrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(javaFrame, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.JavaFrameKt.Dsl.Companion companion = AndroidThreadReportKt.JavaFrameKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.JavaFrame.Builder builder = javaFrame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.JavaFrameKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.AndroidThreadReport.Thread copy(MobileStacktrace.AndroidThreadReport.Thread thread, Function1<? super AndroidThreadReportKt.ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.ThreadKt.Dsl.Companion companion = AndroidThreadReportKt.ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Thread.Builder builder = thread.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.ThreadKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.AndroidThreadReport copy(MobileStacktrace.AndroidThreadReport androidThreadReport, Function1<? super AndroidThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(androidThreadReport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AndroidThreadReportKt.Dsl.Companion companion = AndroidThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Builder builder = androidThreadReport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AndroidThreadReportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final MobileStacktrace.AndroidThreadReport.ErrorStacktrace getCauseOrNull(MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder errorStacktraceOrBuilder) {
        Intrinsics.checkNotNullParameter(errorStacktraceOrBuilder, "<this>");
        if (errorStacktraceOrBuilder.hasCause()) {
            return errorStacktraceOrBuilder.getCause();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.AndroidThreadReport.ErrorStacktrace getErrorStacktraceOrNull(MobileStacktrace.AndroidThreadReportOrBuilder androidThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(androidThreadReportOrBuilder, "<this>");
        if (androidThreadReportOrBuilder.hasErrorStacktrace()) {
            return androidThreadReportOrBuilder.getErrorStacktrace();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable getExceptionOrNull(MobileStacktrace.AndroidThreadReport.ErrorStacktraceOrBuilder errorStacktraceOrBuilder) {
        Intrinsics.checkNotNullParameter(errorStacktraceOrBuilder, "<this>");
        if (errorStacktraceOrBuilder.hasException()) {
            return errorStacktraceOrBuilder.getException();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.AndroidThreadReport.JavaFrame getJavaFrameOrNull(MobileStacktrace.AndroidThreadReport.FrameOrBuilder frameOrBuilder) {
        Intrinsics.checkNotNullParameter(frameOrBuilder, "<this>");
        if (frameOrBuilder.hasJavaFrame()) {
            return frameOrBuilder.getJavaFrame();
        }
        return null;
    }
}
