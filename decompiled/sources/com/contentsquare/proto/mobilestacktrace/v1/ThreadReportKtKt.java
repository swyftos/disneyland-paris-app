package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.contentsquare.proto.mobilestacktrace.v1.ThreadReportKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0015\u001a\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\b\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u001c\u001a)\u0010\u001d\u001a\u00020\u0016*\u00020\u00162\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\b\u001bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"androidOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReportOrBuilder;", "getAndroidOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;", "emptyReportOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;", "getEmptyReportOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;", "flutterOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "getFlutterOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "iosOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;", "getIosOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;", "reactNativeOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;", "getReactNativeOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;", "threadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializethreadReport", "copy", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: classes3.dex */
public final class ThreadReportKtKt {
    @JvmName(name = "-initializethreadReport")
    @NotNull
    /* renamed from: -initializethreadReport, reason: not valid java name */
    public static final MobileStacktrace.ThreadReport m1261initializethreadReport(Function1<? super ThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadReportKt.Dsl.Companion companion = ThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.ThreadReport.Builder builderNewBuilder = MobileStacktrace.ThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ThreadReportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.ThreadReport copy(MobileStacktrace.ThreadReport threadReport, Function1<? super ThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(threadReport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadReportKt.Dsl.Companion companion = ThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.ThreadReport.Builder builder = threadReport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        ThreadReportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final MobileStacktrace.AndroidThreadReport getAndroidOrNull(MobileStacktrace.ThreadReportOrBuilder threadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(threadReportOrBuilder, "<this>");
        if (threadReportOrBuilder.hasAndroid()) {
            return threadReportOrBuilder.getAndroid();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.EmptyThreadReport getEmptyReportOrNull(MobileStacktrace.ThreadReportOrBuilder threadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(threadReportOrBuilder, "<this>");
        if (threadReportOrBuilder.hasEmptyReport()) {
            return threadReportOrBuilder.getEmptyReport();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.FlutterThreadReport getFlutterOrNull(MobileStacktrace.ThreadReportOrBuilder threadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(threadReportOrBuilder, "<this>");
        if (threadReportOrBuilder.hasFlutter()) {
            return threadReportOrBuilder.getFlutter();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport getIosOrNull(MobileStacktrace.ThreadReportOrBuilder threadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(threadReportOrBuilder, "<this>");
        if (threadReportOrBuilder.hasIos()) {
            return threadReportOrBuilder.getIos();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.ReactNativeThreadReport getReactNativeOrNull(MobileStacktrace.ThreadReportOrBuilder threadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(threadReportOrBuilder, "<this>");
        if (threadReportOrBuilder.hasReactNative()) {
            return threadReportOrBuilder.getReactNative();
        }
        return null;
    }
}
