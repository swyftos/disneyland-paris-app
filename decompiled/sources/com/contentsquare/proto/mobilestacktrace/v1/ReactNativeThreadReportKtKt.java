package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.contentsquare.proto.mobilestacktrace.v1.ReactNativeThreadReportKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0010\u001a)\u0010\u0011\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0014*\u00020\u00142\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0016*\u00020\u00162\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"appInfoOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReportOrBuilder;", "getAppInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "exceptionOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "getExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "reactNativeThreadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializereactNativeThreadReport", "copy", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$AppInfoKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$FrameKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactNativeThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactNativeThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: classes3.dex */
public final class ReactNativeThreadReportKtKt {
    @JvmName(name = "-initializereactNativeThreadReport")
    @NotNull
    /* renamed from: -initializereactNativeThreadReport, reason: not valid java name */
    public static final MobileStacktrace.ReactNativeThreadReport m1260initializereactNativeThreadReport(Function1<? super ReactNativeThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReactNativeThreadReportKt.Dsl.Companion companion = ReactNativeThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ReactNativeThreadReportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.ReactNativeThreadReport.AppInfo copy(MobileStacktrace.ReactNativeThreadReport.AppInfo appInfo, Function1<? super ReactNativeThreadReportKt.AppInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(appInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ReactNativeThreadReportKt.AppInfoKt.Dsl.Companion companion = ReactNativeThreadReportKt.AppInfoKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder builder = appInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ReactNativeThreadReportKt.AppInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.ReactNativeThreadReport.Exception copy(MobileStacktrace.ReactNativeThreadReport.Exception exception, Function1<? super ReactNativeThreadReportKt.ExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(exception, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ReactNativeThreadReportKt.ExceptionKt.Dsl.Companion companion = ReactNativeThreadReportKt.ExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Exception.Builder builder = exception.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ReactNativeThreadReportKt.ExceptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.ReactNativeThreadReport.Frame copy(MobileStacktrace.ReactNativeThreadReport.Frame frame, Function1<? super ReactNativeThreadReportKt.FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(frame, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ReactNativeThreadReportKt.FrameKt.Dsl.Companion companion = ReactNativeThreadReportKt.FrameKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder builder = frame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ReactNativeThreadReportKt.FrameKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.ReactNativeThreadReport.Thread copy(MobileStacktrace.ReactNativeThreadReport.Thread thread, Function1<? super ReactNativeThreadReportKt.ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ReactNativeThreadReportKt.ThreadKt.Dsl.Companion companion = ReactNativeThreadReportKt.ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Thread.Builder builder = thread.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ReactNativeThreadReportKt.ThreadKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.ReactNativeThreadReport copy(MobileStacktrace.ReactNativeThreadReport reactNativeThreadReport, Function1<? super ReactNativeThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(reactNativeThreadReport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ReactNativeThreadReportKt.Dsl.Companion companion = ReactNativeThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Builder builder = reactNativeThreadReport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ReactNativeThreadReportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final MobileStacktrace.ReactNativeThreadReport.AppInfo getAppInfoOrNull(MobileStacktrace.ReactNativeThreadReportOrBuilder reactNativeThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(reactNativeThreadReportOrBuilder, "<this>");
        if (reactNativeThreadReportOrBuilder.hasAppInfo()) {
            return reactNativeThreadReportOrBuilder.getAppInfo();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.ReactNativeThreadReport.Exception getExceptionOrNull(MobileStacktrace.ReactNativeThreadReportOrBuilder reactNativeThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(reactNativeThreadReportOrBuilder, "<this>");
        if (reactNativeThreadReportOrBuilder.hasException()) {
            return reactNativeThreadReportOrBuilder.getException();
        }
        return null;
    }
}
