package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.FlutterThreadReportKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0014*\u00020\u00142\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0016*\u00020\u00162\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"appInfoOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReportOrBuilder;", "getAppInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "exceptionOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "getExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "flutterThreadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeflutterThreadReport", "copy", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterAppInfoKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FrameKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFlutterThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlutterThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,871:1\n1#2:872\n*E\n"})
/* loaded from: classes3.dex */
public final class FlutterThreadReportKtKt {
    @JvmName(name = "-initializeflutterThreadReport")
    @NotNull
    /* renamed from: -initializeflutterThreadReport, reason: not valid java name */
    public static final MobileStacktrace.FlutterThreadReport m755initializeflutterThreadReport(Function1<? super FlutterThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterThreadReportKt.Dsl.Companion companion = FlutterThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.Builder builderNewBuilder = MobileStacktrace.FlutterThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FlutterThreadReportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.FlutterThreadReport.FlutterAppInfo copy(MobileStacktrace.FlutterThreadReport.FlutterAppInfo flutterAppInfo, Function1<? super FlutterThreadReportKt.FlutterAppInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(flutterAppInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterThreadReportKt.FlutterAppInfoKt.Dsl.Companion companion = FlutterThreadReportKt.FlutterAppInfoKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.FlutterAppInfo.Builder builder = flutterAppInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FlutterThreadReportKt.FlutterAppInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.FlutterThreadReport.FlutterException copy(MobileStacktrace.FlutterThreadReport.FlutterException flutterException, Function1<? super FlutterThreadReportKt.FlutterExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(flutterException, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterThreadReportKt.FlutterExceptionKt.Dsl.Companion companion = FlutterThreadReportKt.FlutterExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.FlutterException.Builder builder = flutterException.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FlutterThreadReportKt.FlutterExceptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.FlutterThreadReport.Frame copy(MobileStacktrace.FlutterThreadReport.Frame frame, Function1<? super FlutterThreadReportKt.FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(frame, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterThreadReportKt.FrameKt.Dsl.Companion companion = FlutterThreadReportKt.FrameKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.Frame.Builder builder = frame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FlutterThreadReportKt.FrameKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.FlutterThreadReport.Thread copy(MobileStacktrace.FlutterThreadReport.Thread thread, Function1<? super FlutterThreadReportKt.ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterThreadReportKt.ThreadKt.Dsl.Companion companion = FlutterThreadReportKt.ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.Thread.Builder builder = thread.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FlutterThreadReportKt.ThreadKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.FlutterThreadReport copy(MobileStacktrace.FlutterThreadReport flutterThreadReport, Function1<? super FlutterThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(flutterThreadReport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterThreadReportKt.Dsl.Companion companion = FlutterThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.Builder builder = flutterThreadReport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        FlutterThreadReportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final MobileStacktrace.FlutterThreadReport.FlutterAppInfo getAppInfoOrNull(MobileStacktrace.FlutterThreadReportOrBuilder flutterThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(flutterThreadReportOrBuilder, "<this>");
        if (flutterThreadReportOrBuilder.hasAppInfo()) {
            return flutterThreadReportOrBuilder.getAppInfo();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.FlutterThreadReport.FlutterException getExceptionOrNull(MobileStacktrace.FlutterThreadReportOrBuilder flutterThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(flutterThreadReportOrBuilder, "<this>");
        if (flutterThreadReportOrBuilder.hasException()) {
            return flutterThreadReportOrBuilder.getException();
        }
        return null;
    }
}
