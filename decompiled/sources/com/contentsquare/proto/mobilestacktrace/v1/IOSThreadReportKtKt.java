package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.IOSThreadReportKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Î\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u00100\u001a\u0002012\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0087\bø\u0001\u0000¢\u0006\u0002\b7\u001a)\u00108\u001a\u000201*\u0002012\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u0001*\u00020\u00012\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020:*\u00020:2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u0014*\u00020\u00142\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020=*\u00020=2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u0006*\u00020\u00062\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u000b*\u00020\u000b2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u001d*\u00020\u001d2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020!*\u00020!2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u000f*\u00020\u000f2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020)*\u00020)2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020\u0018*\u00020\u00182\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020-*\u00020-2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020G*\u00020G2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\u001a)\u00108\u001a\u00020I*\u00020I2\u0017\u00102\u001a\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020503¢\u0006\u0002\b6H\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u0017\u0010 \u001a\u0004\u0018\u00010!*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u0017\u0010$\u001a\u0004\u0018\u00010\u000f*\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'\"\u0017\u0010(\u001a\u0004\u0018\u00010)*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0017\u0010,\u001a\u0004\u0018\u00010-*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006K"}, d2 = {"applicationInfoOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;", "getApplicationInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "cBinaryInformationOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$FrameOrBuilder;", "getCBinaryInformationOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$FrameOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "cSourceLocationOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "getCSourceLocationOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$FrameOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "codeTypeOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$BinaryOrBuilder;", "getCodeTypeOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$BinaryOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "lastExceptionBacktraceOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "getLastExceptionBacktraceOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "machExceptionOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SignalOrBuilder;", "getMachExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SignalOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "machineInfoOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "getMachineInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "processInfoOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "getProcessInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "processorOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfoOrBuilder;", "getProcessorOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfoOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "signalOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "getSignalOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "systemInfoOrNull", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "getSystemInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReportOrBuilder;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "iOSThreadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeiOSThreadReport", "copy", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ApplicationInfoKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$BinaryInformationKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$SourceLocationKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessInfoKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessorKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SystemInfoKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$RegisterKt$Dsl;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIOSThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IOSThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2559:1\n1#2:2560\n*E\n"})
/* loaded from: classes3.dex */
public final class IOSThreadReportKtKt {
    @JvmName(name = "-initializeiOSThreadReport")
    @NotNull
    /* renamed from: -initializeiOSThreadReport, reason: not valid java name */
    public static final MobileStacktrace.IOSThreadReport m770initializeiOSThreadReport(Function1<? super IOSThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.Dsl.Companion companion = IOSThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        IOSThreadReportKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.ApplicationInfo copy(MobileStacktrace.IOSThreadReport.ApplicationInfo applicationInfo, Function1<? super IOSThreadReportKt.ApplicationInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(applicationInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.ApplicationInfoKt.Dsl.Companion companion = IOSThreadReportKt.ApplicationInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.ApplicationInfo.Builder builder = applicationInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.ApplicationInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Binary copy(MobileStacktrace.IOSThreadReport.Binary binary, Function1<? super IOSThreadReportKt.BinaryKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(binary, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.BinaryKt.Dsl.Companion companion = IOSThreadReportKt.BinaryKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Binary.Builder builder = binary.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.BinaryKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Exception copy(MobileStacktrace.IOSThreadReport.Exception exception, Function1<? super IOSThreadReportKt.ExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(exception, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.ExceptionKt.Dsl.Companion companion = IOSThreadReportKt.ExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Exception.Builder builder = exception.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.ExceptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Frame.BinaryInformation copy(MobileStacktrace.IOSThreadReport.Frame.BinaryInformation binaryInformation, Function1<? super IOSThreadReportKt.FrameKt.BinaryInformationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(binaryInformation, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.FrameKt.BinaryInformationKt.Dsl.Companion companion = IOSThreadReportKt.FrameKt.BinaryInformationKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.Builder builder = binaryInformation.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.FrameKt.BinaryInformationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Frame.SourceLocation copy(MobileStacktrace.IOSThreadReport.Frame.SourceLocation sourceLocation, Function1<? super IOSThreadReportKt.FrameKt.SourceLocationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(sourceLocation, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.FrameKt.SourceLocationKt.Dsl.Companion companion = IOSThreadReportKt.FrameKt.SourceLocationKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Frame.SourceLocation.Builder builder = sourceLocation.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.FrameKt.SourceLocationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Frame copy(MobileStacktrace.IOSThreadReport.Frame frame, Function1<? super IOSThreadReportKt.FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(frame, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.FrameKt.Dsl.Companion companion = IOSThreadReportKt.FrameKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Frame.Builder builder = frame.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.FrameKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.MachineInfo copy(MobileStacktrace.IOSThreadReport.MachineInfo machineInfo, Function1<? super IOSThreadReportKt.MachineInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(machineInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.MachineInfoKt.Dsl.Companion companion = IOSThreadReportKt.MachineInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.MachineInfo.Builder builder = machineInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.MachineInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.ProcessInfo copy(MobileStacktrace.IOSThreadReport.ProcessInfo processInfo, Function1<? super IOSThreadReportKt.ProcessInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(processInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.ProcessInfoKt.Dsl.Companion companion = IOSThreadReportKt.ProcessInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.ProcessInfo.Builder builder = processInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.ProcessInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Processor copy(MobileStacktrace.IOSThreadReport.Processor processor, Function1<? super IOSThreadReportKt.ProcessorKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(processor, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.ProcessorKt.Dsl.Companion companion = IOSThreadReportKt.ProcessorKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Processor.Builder builder = processor.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.ProcessorKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Signal.MachException copy(MobileStacktrace.IOSThreadReport.Signal.MachException machException, Function1<? super IOSThreadReportKt.SignalKt.MachExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(machException, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.SignalKt.MachExceptionKt.Dsl.Companion companion = IOSThreadReportKt.SignalKt.MachExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Signal.MachException.Builder builder = machException.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.SignalKt.MachExceptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Signal copy(MobileStacktrace.IOSThreadReport.Signal signal, Function1<? super IOSThreadReportKt.SignalKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(signal, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.SignalKt.Dsl.Companion companion = IOSThreadReportKt.SignalKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Signal.Builder builder = signal.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.SignalKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.SystemInfo copy(MobileStacktrace.IOSThreadReport.SystemInfo systemInfo, Function1<? super IOSThreadReportKt.SystemInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(systemInfo, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.SystemInfoKt.Dsl.Companion companion = IOSThreadReportKt.SystemInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.SystemInfo.Builder builder = systemInfo.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.SystemInfoKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Thread.Register copy(MobileStacktrace.IOSThreadReport.Thread.Register register, Function1<? super IOSThreadReportKt.ThreadKt.RegisterKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(register, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.ThreadKt.RegisterKt.Dsl.Companion companion = IOSThreadReportKt.ThreadKt.RegisterKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Thread.Register.Builder builder = register.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.ThreadKt.RegisterKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport.Thread copy(MobileStacktrace.IOSThreadReport.Thread thread, Function1<? super IOSThreadReportKt.ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(thread, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.ThreadKt.Dsl.Companion companion = IOSThreadReportKt.ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Thread.Builder builder = thread.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.ThreadKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final MobileStacktrace.IOSThreadReport copy(MobileStacktrace.IOSThreadReport iOSThreadReport, Function1<? super IOSThreadReportKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(iOSThreadReport, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        IOSThreadReportKt.Dsl.Companion companion = IOSThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Builder builder = iOSThreadReport.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        IOSThreadReportKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.ApplicationInfo getApplicationInfoOrNull(MobileStacktrace.IOSThreadReportOrBuilder iOSThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(iOSThreadReportOrBuilder, "<this>");
        if (iOSThreadReportOrBuilder.hasApplicationInfo()) {
            return iOSThreadReportOrBuilder.getApplicationInfo();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Frame.BinaryInformation getCBinaryInformationOrNull(MobileStacktrace.IOSThreadReport.FrameOrBuilder frameOrBuilder) {
        Intrinsics.checkNotNullParameter(frameOrBuilder, "<this>");
        if (frameOrBuilder.hasCBinaryInformation()) {
            return frameOrBuilder.getCBinaryInformation();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Frame.SourceLocation getCSourceLocationOrNull(MobileStacktrace.IOSThreadReport.FrameOrBuilder frameOrBuilder) {
        Intrinsics.checkNotNullParameter(frameOrBuilder, "<this>");
        if (frameOrBuilder.hasCSourceLocation()) {
            return frameOrBuilder.getCSourceLocation();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Processor getCodeTypeOrNull(MobileStacktrace.IOSThreadReport.BinaryOrBuilder binaryOrBuilder) {
        Intrinsics.checkNotNullParameter(binaryOrBuilder, "<this>");
        if (binaryOrBuilder.hasCodeType()) {
            return binaryOrBuilder.getCodeType();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Exception getLastExceptionBacktraceOrNull(MobileStacktrace.IOSThreadReportOrBuilder iOSThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(iOSThreadReportOrBuilder, "<this>");
        if (iOSThreadReportOrBuilder.hasLastExceptionBacktrace()) {
            return iOSThreadReportOrBuilder.getLastExceptionBacktrace();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Signal.MachException getMachExceptionOrNull(MobileStacktrace.IOSThreadReport.SignalOrBuilder signalOrBuilder) {
        Intrinsics.checkNotNullParameter(signalOrBuilder, "<this>");
        if (signalOrBuilder.hasMachException()) {
            return signalOrBuilder.getMachException();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.MachineInfo getMachineInfoOrNull(MobileStacktrace.IOSThreadReportOrBuilder iOSThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(iOSThreadReportOrBuilder, "<this>");
        if (iOSThreadReportOrBuilder.hasMachineInfo()) {
            return iOSThreadReportOrBuilder.getMachineInfo();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.ProcessInfo getProcessInfoOrNull(MobileStacktrace.IOSThreadReportOrBuilder iOSThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(iOSThreadReportOrBuilder, "<this>");
        if (iOSThreadReportOrBuilder.hasProcessInfo()) {
            return iOSThreadReportOrBuilder.getProcessInfo();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Processor getProcessorOrNull(MobileStacktrace.IOSThreadReport.MachineInfoOrBuilder machineInfoOrBuilder) {
        Intrinsics.checkNotNullParameter(machineInfoOrBuilder, "<this>");
        if (machineInfoOrBuilder.hasProcessor()) {
            return machineInfoOrBuilder.getProcessor();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.Signal getSignalOrNull(MobileStacktrace.IOSThreadReportOrBuilder iOSThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(iOSThreadReportOrBuilder, "<this>");
        if (iOSThreadReportOrBuilder.hasSignal()) {
            return iOSThreadReportOrBuilder.getSignal();
        }
        return null;
    }

    @Nullable
    public static final MobileStacktrace.IOSThreadReport.SystemInfo getSystemInfoOrNull(MobileStacktrace.IOSThreadReportOrBuilder iOSThreadReportOrBuilder) {
        Intrinsics.checkNotNullParameter(iOSThreadReportOrBuilder, "<this>");
        if (iOSThreadReportOrBuilder.hasSystemInfo()) {
            return iOSThreadReportOrBuilder.getSystemInfo();
        }
        return null;
    }
}
