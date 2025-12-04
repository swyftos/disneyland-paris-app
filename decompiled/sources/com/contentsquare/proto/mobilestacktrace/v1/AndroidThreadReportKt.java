package com.contentsquare.proto.mobilestacktrace.v1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.firebase.messaging.Constants;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.urbanairship.channel.AttributeMutation;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt;", "", "()V", "errorStacktrace", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeerrorStacktrace", TypedValues.AttributesType.S_FRAME, "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$FrameKt$Dsl;", "-initializeframe", "javaFrame", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$JavaFrameKt$Dsl;", "-initializejavaFrame", "thread", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl;", "-initializethread", "Dsl", "ErrorStacktraceKt", "FrameKt", "JavaFrameKt", "ThreadKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAndroidThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,794:1\n1#2:795\n*E\n"})
/* loaded from: classes3.dex */
public final class AndroidThreadReportKt {

    @NotNull
    public static final AndroidThreadReportKt INSTANCE = new AndroidThreadReportKt();

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u0001:\u00029:B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020)J%\u0010*\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0007¢\u0006\u0002\b+J+\u0010,\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0.H\u0007¢\u0006\u0002\b/J\u001d\u00100\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0007¢\u0006\u0002\b1J&\u00102\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\n¢\u0006\u0002\b3J,\u00102\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0.H\u0087\n¢\u0006\u0002\b4J.\u00105\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u00106\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\u0002¢\u0006\u0002\b8R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006;"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Builder;)V", "value", "", "applicationVersion", "getApplicationVersion", "()Ljava/lang/String;", "setApplicationVersion", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "errorStacktrace", "getErrorStacktrace", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "setErrorStacktrace", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;)V", "mappingVersion", "getMappingVersion", "setMappingVersion", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "getPackageName", "setPackageName", "threads", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl$ThreadsProxy;", "getThreads", "()Lcom/google/protobuf/kotlin/DslList;", "errorStacktraceOrNull", "getErrorStacktraceOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;", "clearApplicationVersion", "", "clearErrorStacktrace", "clearMappingVersion", "clearPackageName", "hasErrorStacktrace", "", "add", "addThreads", "addAll", "values", "", "addAllThreads", "clear", "clearThreads", "plusAssign", "plusAssignThreads", "plusAssignAllThreads", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setThreads", "Companion", "ThreadsProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.AndroidThreadReport.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.AndroidThreadReport.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$Dsl$ThreadsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ThreadsProxy extends DslProxy {
            private ThreadsProxy() {
            }
        }

        private Dsl(MobileStacktrace.AndroidThreadReport.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.AndroidThreadReport _build() {
            MobileStacktrace.AndroidThreadReport androidThreadReportBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(androidThreadReportBuild, "_builder.build()");
            return androidThreadReportBuild;
        }

        @JvmName(name = "addAllThreads")
        public final /* synthetic */ void addAllThreads(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllThreads(values);
        }

        @JvmName(name = "addThreads")
        public final /* synthetic */ void addThreads(DslList dslList, MobileStacktrace.AndroidThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addThreads(value);
        }

        public final void clearApplicationVersion() {
            this._builder.clearApplicationVersion();
        }

        public final void clearErrorStacktrace() {
            this._builder.clearErrorStacktrace();
        }

        public final void clearMappingVersion() {
            this._builder.clearMappingVersion();
        }

        public final void clearPackageName() {
            this._builder.clearPackageName();
        }

        @JvmName(name = "clearThreads")
        public final /* synthetic */ void clearThreads(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearThreads();
        }

        @JvmName(name = "getApplicationVersion")
        @NotNull
        public final String getApplicationVersion() {
            String applicationVersion = this._builder.getApplicationVersion();
            Intrinsics.checkNotNullExpressionValue(applicationVersion, "_builder.getApplicationVersion()");
            return applicationVersion;
        }

        @JvmName(name = "getErrorStacktrace")
        @NotNull
        public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace getErrorStacktrace() {
            MobileStacktrace.AndroidThreadReport.ErrorStacktrace errorStacktrace = this._builder.getErrorStacktrace();
            Intrinsics.checkNotNullExpressionValue(errorStacktrace, "_builder.getErrorStacktrace()");
            return errorStacktrace;
        }

        @Nullable
        public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace getErrorStacktraceOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return AndroidThreadReportKtKt.getErrorStacktraceOrNull(dsl._builder);
        }

        @JvmName(name = "getMappingVersion")
        @NotNull
        public final String getMappingVersion() {
            String mappingVersion = this._builder.getMappingVersion();
            Intrinsics.checkNotNullExpressionValue(mappingVersion, "_builder.getMappingVersion()");
            return mappingVersion;
        }

        @JvmName(name = "getPackageName")
        @NotNull
        public final String getPackageName() {
            String packageName = this._builder.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
            return packageName;
        }

        public final /* synthetic */ DslList getThreads() {
            List<MobileStacktrace.AndroidThreadReport.Thread> threadsList = this._builder.getThreadsList();
            Intrinsics.checkNotNullExpressionValue(threadsList, "_builder.getThreadsList()");
            return new DslList(threadsList);
        }

        public final boolean hasErrorStacktrace() {
            return this._builder.hasErrorStacktrace();
        }

        @JvmName(name = "plusAssignAllThreads")
        public final /* synthetic */ void plusAssignAllThreads(DslList<MobileStacktrace.AndroidThreadReport.Thread, ThreadsProxy> dslList, Iterable<MobileStacktrace.AndroidThreadReport.Thread> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllThreads(dslList, values);
        }

        @JvmName(name = "plusAssignThreads")
        public final /* synthetic */ void plusAssignThreads(DslList<MobileStacktrace.AndroidThreadReport.Thread, ThreadsProxy> dslList, MobileStacktrace.AndroidThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addThreads(dslList, value);
        }

        @JvmName(name = "setApplicationVersion")
        public final void setApplicationVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setApplicationVersion(value);
        }

        @JvmName(name = "setErrorStacktrace")
        public final void setErrorStacktrace(MobileStacktrace.AndroidThreadReport.ErrorStacktrace value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setErrorStacktrace(value);
        }

        @JvmName(name = "setMappingVersion")
        public final void setMappingVersion(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMappingVersion(value);
        }

        @JvmName(name = "setPackageName")
        public final void setPackageName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPackageName(value);
        }

        @JvmName(name = "setThreads")
        public final /* synthetic */ void setThreads(DslList dslList, int i, MobileStacktrace.AndroidThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setThreads(i, value);
        }

        public /* synthetic */ Dsl(MobileStacktrace.AndroidThreadReport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt;", "", "()V", "throwable", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$ThrowableKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializethrowable", "Dsl", "ThrowableKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAndroidThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,794:1\n1#2:795\n*E\n"})
    public static final class ErrorStacktraceKt {

        @NotNull
        public static final ErrorStacktraceKt INSTANCE = new ErrorStacktraceKt();

        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020\u0006H\u0001J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J%\u00100\u001a\u00020)*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0005\u001a\u00020\u0014H\u0007¢\u0006\u0002\b1J+\u00102\u001a\u00020)*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001404H\u0007¢\u0006\u0002\b5J\u001d\u00106\u001a\u00020)*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007¢\u0006\u0002\b7J&\u00108\u001a\u00020)*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0005\u001a\u00020\u0014H\u0087\n¢\u0006\u0002\b9J,\u00108\u001a\u00020)*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001404H\u0087\n¢\u0006\u0002\b:J.\u0010;\u001a\u00020)*\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010<\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0014H\u0087\u0002¢\u0006\u0002\b=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0017\u0010!\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006@"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "cause", "getCause", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "setCause", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "exception", "getException", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "setException", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "", "overflowCount", "getOverflowCount", "()I", "setOverflowCount", "(I)V", "threadId", "getThreadId", "setThreadId", "causeOrNull", "getCauseOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace;", "exceptionOrNull", "getExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "_build", "clearCause", "", "clearException", "clearOverflowCount", "clearThreadId", "hasCause", "", "hasException", "add", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.AndroidThreadReport.ErrorStacktrace _build() {
                MobileStacktrace.AndroidThreadReport.ErrorStacktrace errorStacktraceBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(errorStacktraceBuild, "_builder.build()");
                return errorStacktraceBuild;
            }

            @JvmName(name = "addAllFrames")
            public final /* synthetic */ void addAllFrames(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllFrames(values);
            }

            @JvmName(name = "addFrames")
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.AndroidThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addFrames(value);
            }

            public final void clearCause() {
                this._builder.clearCause();
            }

            public final void clearException() {
                this._builder.clearException();
            }

            @JvmName(name = "clearFrames")
            public final /* synthetic */ void clearFrames(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearFrames();
            }

            public final void clearOverflowCount() {
                this._builder.clearOverflowCount();
            }

            public final void clearThreadId() {
                this._builder.clearThreadId();
            }

            @JvmName(name = "getCause")
            @NotNull
            public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace getCause() {
                MobileStacktrace.AndroidThreadReport.ErrorStacktrace cause = this._builder.getCause();
                Intrinsics.checkNotNullExpressionValue(cause, "_builder.getCause()");
                return cause;
            }

            @Nullable
            public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace getCauseOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return AndroidThreadReportKtKt.getCauseOrNull(dsl._builder);
            }

            @JvmName(name = "getException")
            @NotNull
            public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable getException() {
                MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable exception = this._builder.getException();
                Intrinsics.checkNotNullExpressionValue(exception, "_builder.getException()");
                return exception;
            }

            @Nullable
            public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable getExceptionOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return AndroidThreadReportKtKt.getExceptionOrNull(dsl._builder);
            }

            public final /* synthetic */ DslList getFrames() {
                List<MobileStacktrace.AndroidThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "getOverflowCount")
            public final int getOverflowCount() {
                return this._builder.getOverflowCount();
            }

            @JvmName(name = "getThreadId")
            public final int getThreadId() {
                return this._builder.getThreadId();
            }

            public final boolean hasCause() {
                return this._builder.hasCause();
            }

            public final boolean hasException() {
                return this._builder.hasException();
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.AndroidThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.AndroidThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.AndroidThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.AndroidThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "setCause")
            public final void setCause(MobileStacktrace.AndroidThreadReport.ErrorStacktrace value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCause(value);
            }

            @JvmName(name = "setException")
            public final void setException(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setException(value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.AndroidThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            @JvmName(name = "setOverflowCount")
            public final void setOverflowCount(int i) {
                this._builder.setOverflowCount(i);
            }

            @JvmName(name = "setThreadId")
            public final void setThreadId(int i) {
                this._builder.setThreadId(i);
            }

            public /* synthetic */ Dsl(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$ThrowableKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ThrowableKt {

            @NotNull
            public static final ThrowableKt INSTANCE = new ThrowableKt();

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$ThrowableKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable$Builder;)V", "value", "", "class_", "getClass_", "()Ljava/lang/String;", "setClass_", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable;", "clearClass_", "", "clearMessage", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            @ProtoDslMarker
            public static final class Dsl {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);

                @NotNull
                private final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder _builder;

                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$ThrowableKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ErrorStacktraceKt$ThrowableKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$ErrorStacktrace$Throwable$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    @PublishedApi
                    public final /* synthetic */ Dsl _create(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        return new Dsl(builder, null);
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                private Dsl(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder builder) {
                    this._builder = builder;
                }

                @PublishedApi
                public final /* synthetic */ MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable _build() {
                    MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable throwableBuild = this._builder.build();
                    Intrinsics.checkNotNullExpressionValue(throwableBuild, "_builder.build()");
                    return throwableBuild;
                }

                public final void clearClass_() {
                    this._builder.clearClass_();
                }

                public final void clearMessage() {
                    this._builder.clearMessage();
                }

                @JvmName(name = "getClass_")
                @NotNull
                public final String getClass_() {
                    String class_ = this._builder.getClass_();
                    Intrinsics.checkNotNullExpressionValue(class_, "_builder.getClass_()");
                    return class_;
                }

                @JvmName(name = "getMessage")
                @NotNull
                public final String getMessage() {
                    String message = this._builder.getMessage();
                    Intrinsics.checkNotNullExpressionValue(message, "_builder.getMessage()");
                    return message;
                }

                @JvmName(name = "setClass_")
                public final void setClass_(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setClass_(value);
                }

                @JvmName(name = "setMessage")
                public final void setMessage(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setMessage(value);
                }

                public /* synthetic */ Dsl(MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                    this(builder);
                }
            }

            private ThrowableKt() {
            }
        }

        private ErrorStacktraceKt() {
        }

        @JvmName(name = "-initializethrowable")
        @NotNull
        /* renamed from: -initializethrowable, reason: not valid java name */
        public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable m745initializethrowable(Function1<? super ThrowableKt.Dsl, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            ThrowableKt.Dsl.Companion companion = ThrowableKt.Dsl.INSTANCE;
            MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Throwable.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
            ThrowableKt.Dsl dsl_create = companion._create(builderNewBuilder);
            block.invoke(dsl_create);
            return dsl_create._build();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$FrameKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FrameKt {

        @NotNull
        public static final FrameKt INSTANCE = new FrameKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$FrameKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame$Builder;)V", "frameCase", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame$FrameCase;", "getFrameCase", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame$FrameCase;", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;", "javaFrame", "getJavaFrame", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;", "setJavaFrame", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame;", "clearFrame", "", "clearJavaFrame", "hasJavaFrame", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.AndroidThreadReport.Frame.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$FrameKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$FrameKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.AndroidThreadReport.Frame.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.AndroidThreadReport.Frame.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.AndroidThreadReport.Frame _build() {
                MobileStacktrace.AndroidThreadReport.Frame frameBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(frameBuild, "_builder.build()");
                return frameBuild;
            }

            public final void clearFrame() {
                this._builder.clearFrame();
            }

            public final void clearJavaFrame() {
                this._builder.clearJavaFrame();
            }

            @JvmName(name = "getFrameCase")
            @NotNull
            public final MobileStacktrace.AndroidThreadReport.Frame.FrameCase getFrameCase() {
                MobileStacktrace.AndroidThreadReport.Frame.FrameCase frameCase = this._builder.getFrameCase();
                Intrinsics.checkNotNullExpressionValue(frameCase, "_builder.getFrameCase()");
                return frameCase;
            }

            @JvmName(name = "getJavaFrame")
            @NotNull
            public final MobileStacktrace.AndroidThreadReport.JavaFrame getJavaFrame() {
                MobileStacktrace.AndroidThreadReport.JavaFrame javaFrame = this._builder.getJavaFrame();
                Intrinsics.checkNotNullExpressionValue(javaFrame, "_builder.getJavaFrame()");
                return javaFrame;
            }

            public final boolean hasJavaFrame() {
                return this._builder.hasJavaFrame();
            }

            @JvmName(name = "setJavaFrame")
            public final void setJavaFrame(MobileStacktrace.AndroidThreadReport.JavaFrame value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setJavaFrame(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.AndroidThreadReport.Frame.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private FrameKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$JavaFrameKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class JavaFrameKt {

        @NotNull
        public static final JavaFrameKt INSTANCE = new JavaFrameKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0001J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u0006\u00100\u001a\u00020*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R$\u0010!\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R$\u0010$\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011¨\u00062"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$JavaFrameKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "cFrameType", "getCFrameType", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "setCFrameType", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;)V", "", "cFrameTypeValue", "getCFrameTypeValue", "()I", "setCFrameTypeValue", "(I)V", "", "class_", "getClass_", "()Ljava/lang/String;", "setClass_", "(Ljava/lang/String;)V", "file", "getFile", "setFile", "frameId", "getFrameId", "setFrameId", "line", "getLine", "setLine", "method", "getMethod", "setMethod", "repeatedCount", "getRepeatedCount", "setRepeatedCount", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame;", "clearCFrameType", "", "clearClass_", "clearFile", "clearFrameId", "clearLine", "clearMethod", "clearRepeatedCount", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.AndroidThreadReport.JavaFrame.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$JavaFrameKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$JavaFrameKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$JavaFrame$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.AndroidThreadReport.JavaFrame.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.AndroidThreadReport.JavaFrame.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.AndroidThreadReport.JavaFrame _build() {
                MobileStacktrace.AndroidThreadReport.JavaFrame javaFrameBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(javaFrameBuild, "_builder.build()");
                return javaFrameBuild;
            }

            public final void clearCFrameType() {
                this._builder.clearCFrameType();
            }

            public final void clearClass_() {
                this._builder.clearClass_();
            }

            public final void clearFile() {
                this._builder.clearFile();
            }

            public final void clearFrameId() {
                this._builder.clearFrameId();
            }

            public final void clearLine() {
                this._builder.clearLine();
            }

            public final void clearMethod() {
                this._builder.clearMethod();
            }

            public final void clearRepeatedCount() {
                this._builder.clearRepeatedCount();
            }

            @JvmName(name = "getCFrameType")
            @NotNull
            public final MobileStacktrace.ModuleType getCFrameType() {
                MobileStacktrace.ModuleType cFrameType = this._builder.getCFrameType();
                Intrinsics.checkNotNullExpressionValue(cFrameType, "_builder.getCFrameType()");
                return cFrameType;
            }

            @JvmName(name = "getCFrameTypeValue")
            public final int getCFrameTypeValue() {
                return this._builder.getCFrameTypeValue();
            }

            @JvmName(name = "getClass_")
            @NotNull
            public final String getClass_() {
                String class_ = this._builder.getClass_();
                Intrinsics.checkNotNullExpressionValue(class_, "_builder.getClass_()");
                return class_;
            }

            @JvmName(name = "getFile")
            @NotNull
            public final String getFile() {
                String file = this._builder.getFile();
                Intrinsics.checkNotNullExpressionValue(file, "_builder.getFile()");
                return file;
            }

            @JvmName(name = "getFrameId")
            public final int getFrameId() {
                return this._builder.getFrameId();
            }

            @JvmName(name = "getLine")
            public final int getLine() {
                return this._builder.getLine();
            }

            @JvmName(name = "getMethod")
            @NotNull
            public final String getMethod() {
                String method = this._builder.getMethod();
                Intrinsics.checkNotNullExpressionValue(method, "_builder.getMethod()");
                return method;
            }

            @JvmName(name = "getRepeatedCount")
            public final int getRepeatedCount() {
                return this._builder.getRepeatedCount();
            }

            @JvmName(name = "setCFrameType")
            public final void setCFrameType(MobileStacktrace.ModuleType value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCFrameType(value);
            }

            @JvmName(name = "setCFrameTypeValue")
            public final void setCFrameTypeValue(int i) {
                this._builder.setCFrameTypeValue(i);
            }

            @JvmName(name = "setClass_")
            public final void setClass_(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setClass_(value);
            }

            @JvmName(name = "setFile")
            public final void setFile(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFile(value);
            }

            @JvmName(name = "setFrameId")
            public final void setFrameId(int i) {
                this._builder.setFrameId(i);
            }

            @JvmName(name = "setLine")
            public final void setLine(int i) {
                this._builder.setLine(i);
            }

            @JvmName(name = "setMethod")
            public final void setMethod(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setMethod(value);
            }

            @JvmName(name = "setRepeatedCount")
            public final void setRepeatedCount(int i) {
                this._builder.setRepeatedCount(i);
            }

            public /* synthetic */ Dsl(MobileStacktrace.AndroidThreadReport.JavaFrame.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private JavaFrameKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ThreadKt {

        @NotNull
        public static final ThreadKt INSTANCE = new ThreadKt();

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ%\u0010\u001d\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001eJ+\u0010\u001f\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0007¢\u0006\u0002\b\"J\u001d\u0010#\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b$J&\u0010%\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b&J,\u0010%\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0087\n¢\u0006\u0002\b'J.\u0010(\u001a\u00020\u001b*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010)\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006-"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread$Builder;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "value", "", "threadId", "getThreadId", "()I", "setThreadId", "(I)V", "", "threadName", "getThreadName", "()Ljava/lang/String;", "setThreadName", "(Ljava/lang/String;)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread;", "clearThreadId", "", "clearThreadName", "add", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.AndroidThreadReport.Thread.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport$Thread$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.AndroidThreadReport.Thread.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/AndroidThreadReportKt$ThreadKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.AndroidThreadReport.Thread.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.AndroidThreadReport.Thread _build() {
                MobileStacktrace.AndroidThreadReport.Thread threadBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(threadBuild, "_builder.build()");
                return threadBuild;
            }

            @JvmName(name = "addAllFrames")
            public final /* synthetic */ void addAllFrames(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllFrames(values);
            }

            @JvmName(name = "addFrames")
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.AndroidThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addFrames(value);
            }

            @JvmName(name = "clearFrames")
            public final /* synthetic */ void clearFrames(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearFrames();
            }

            public final void clearThreadId() {
                this._builder.clearThreadId();
            }

            public final void clearThreadName() {
                this._builder.clearThreadName();
            }

            public final /* synthetic */ DslList getFrames() {
                List<MobileStacktrace.AndroidThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "getThreadId")
            public final int getThreadId() {
                return this._builder.getThreadId();
            }

            @JvmName(name = "getThreadName")
            @NotNull
            public final String getThreadName() {
                String threadName = this._builder.getThreadName();
                Intrinsics.checkNotNullExpressionValue(threadName, "_builder.getThreadName()");
                return threadName;
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.AndroidThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.AndroidThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.AndroidThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.AndroidThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.AndroidThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            @JvmName(name = "setThreadId")
            public final void setThreadId(int i) {
                this._builder.setThreadId(i);
            }

            @JvmName(name = "setThreadName")
            public final void setThreadName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setThreadName(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.AndroidThreadReport.Thread.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ThreadKt() {
        }
    }

    private AndroidThreadReportKt() {
    }

    @JvmName(name = "-initializeerrorStacktrace")
    @NotNull
    /* renamed from: -initializeerrorStacktrace, reason: not valid java name */
    public final MobileStacktrace.AndroidThreadReport.ErrorStacktrace m741initializeerrorStacktrace(Function1<? super ErrorStacktraceKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ErrorStacktraceKt.Dsl.Companion companion = ErrorStacktraceKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.ErrorStacktrace.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.ErrorStacktrace.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ErrorStacktraceKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeframe")
    @NotNull
    /* renamed from: -initializeframe, reason: not valid java name */
    public final MobileStacktrace.AndroidThreadReport.Frame m742initializeframe(Function1<? super FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FrameKt.Dsl.Companion companion = FrameKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Frame.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.Frame.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FrameKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializejavaFrame")
    @NotNull
    /* renamed from: -initializejavaFrame, reason: not valid java name */
    public final MobileStacktrace.AndroidThreadReport.JavaFrame m743initializejavaFrame(Function1<? super JavaFrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        JavaFrameKt.Dsl.Companion companion = JavaFrameKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.JavaFrame.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.JavaFrame.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        JavaFrameKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializethread")
    @NotNull
    /* renamed from: -initializethread, reason: not valid java name */
    public final MobileStacktrace.AndroidThreadReport.Thread m744initializethread(Function1<? super ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadKt.Dsl.Companion companion = ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.AndroidThreadReport.Thread.Builder builderNewBuilder = MobileStacktrace.AndroidThreadReport.Thread.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ThreadKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
