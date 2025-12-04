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
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt;", "", "()V", "flutterAppInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterAppInfoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeflutterAppInfo", "flutterException", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl;", "-initializeflutterException", TypedValues.AttributesType.S_FRAME, "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FrameKt$Dsl;", "-initializeframe", "thread", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl;", "-initializethread", "Dsl", "FlutterAppInfoKt", "FlutterExceptionKt", "FrameKt", "ThreadKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFlutterThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlutterThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,871:1\n1#2:872\n*E\n"})
/* loaded from: classes3.dex */
public final class FlutterThreadReportKt {

    @NotNull
    public static final FlutterThreadReportKt INSTANCE = new FlutterThreadReportKt();

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002KLB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00100\u001a\u000201H\u0001J\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203J\u0006\u00107\u001a\u000203J\u0006\u00108\u001a\u000203J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020:J%\u0010<\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\u0005\u001a\u00020 H\u0007¢\u0006\u0002\b=J+\u0010>\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020 0@H\u0007¢\u0006\u0002\bAJ\u001d\u0010B\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0007¢\u0006\u0002\bCJ&\u0010D\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010\u0005\u001a\u00020 H\u0087\n¢\u0006\u0002\bEJ,\u0010D\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020 0@H\u0087\n¢\u0006\u0002\bFJ.\u0010G\u001a\u000203*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f2\u0006\u0010H\u001a\u00020I2\u0006\u0010\u0005\u001a\u00020 H\u0087\u0002¢\u0006\u0002\bJR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010*\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\u0004\u0018\u00010\u0012*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006M"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "appInfo", "getAppInfo", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "setAppInfo", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;)V", "", "context", "getContext", "()Ljava/lang/String;", "setContext", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "exception", "getException", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "setException", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;)V", "library", "getLibrary", "setLibrary", ErrorBundle.SUMMARY_ENTRY, "getSummary", "setSummary", "threads", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl$ThreadsProxy;", "getThreads", "()Lcom/google/protobuf/kotlin/DslList;", "", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "appInfoOrNull", "getAppInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "exceptionOrNull", "getExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "clearAppInfo", "", "clearContext", "clearException", "clearLibrary", "clearSummary", "clearTimestamp", "hasAppInfo", "", "hasException", "add", "addThreads", "addAll", "values", "", "addAllThreads", "clear", "clearThreads", "plusAssign", "plusAssignThreads", "plusAssignAllThreads", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setThreads", "Companion", "ThreadsProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.FlutterThreadReport.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.FlutterThreadReport.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$Dsl$ThreadsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ThreadsProxy extends DslProxy {
            private ThreadsProxy() {
            }
        }

        private Dsl(MobileStacktrace.FlutterThreadReport.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.FlutterThreadReport _build() {
            MobileStacktrace.FlutterThreadReport flutterThreadReportBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(flutterThreadReportBuild, "_builder.build()");
            return flutterThreadReportBuild;
        }

        @JvmName(name = "addAllThreads")
        public final /* synthetic */ void addAllThreads(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllThreads(values);
        }

        @JvmName(name = "addThreads")
        public final /* synthetic */ void addThreads(DslList dslList, MobileStacktrace.FlutterThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addThreads(value);
        }

        public final void clearAppInfo() {
            this._builder.clearAppInfo();
        }

        public final void clearContext() {
            this._builder.clearContext();
        }

        public final void clearException() {
            this._builder.clearException();
        }

        public final void clearLibrary() {
            this._builder.clearLibrary();
        }

        public final void clearSummary() {
            this._builder.clearSummary();
        }

        @JvmName(name = "clearThreads")
        public final /* synthetic */ void clearThreads(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearThreads();
        }

        public final void clearTimestamp() {
            this._builder.clearTimestamp();
        }

        @JvmName(name = "getAppInfo")
        @NotNull
        public final MobileStacktrace.FlutterThreadReport.FlutterAppInfo getAppInfo() {
            MobileStacktrace.FlutterThreadReport.FlutterAppInfo appInfo = this._builder.getAppInfo();
            Intrinsics.checkNotNullExpressionValue(appInfo, "_builder.getAppInfo()");
            return appInfo;
        }

        @Nullable
        public final MobileStacktrace.FlutterThreadReport.FlutterAppInfo getAppInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FlutterThreadReportKtKt.getAppInfoOrNull(dsl._builder);
        }

        @JvmName(name = "getContext")
        @NotNull
        public final String getContext() {
            String context = this._builder.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "_builder.getContext()");
            return context;
        }

        @JvmName(name = "getException")
        @NotNull
        public final MobileStacktrace.FlutterThreadReport.FlutterException getException() {
            MobileStacktrace.FlutterThreadReport.FlutterException exception = this._builder.getException();
            Intrinsics.checkNotNullExpressionValue(exception, "_builder.getException()");
            return exception;
        }

        @Nullable
        public final MobileStacktrace.FlutterThreadReport.FlutterException getExceptionOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FlutterThreadReportKtKt.getExceptionOrNull(dsl._builder);
        }

        @JvmName(name = "getLibrary")
        @NotNull
        public final String getLibrary() {
            String library = this._builder.getLibrary();
            Intrinsics.checkNotNullExpressionValue(library, "_builder.getLibrary()");
            return library;
        }

        @JvmName(name = "getSummary")
        @NotNull
        public final String getSummary() {
            String summary = this._builder.getSummary();
            Intrinsics.checkNotNullExpressionValue(summary, "_builder.getSummary()");
            return summary;
        }

        public final /* synthetic */ DslList getThreads() {
            List<MobileStacktrace.FlutterThreadReport.Thread> threadsList = this._builder.getThreadsList();
            Intrinsics.checkNotNullExpressionValue(threadsList, "_builder.getThreadsList()");
            return new DslList(threadsList);
        }

        @JvmName(name = "getTimestamp")
        public final long getTimestamp() {
            return this._builder.getTimestamp();
        }

        public final boolean hasAppInfo() {
            return this._builder.hasAppInfo();
        }

        public final boolean hasException() {
            return this._builder.hasException();
        }

        @JvmName(name = "plusAssignAllThreads")
        public final /* synthetic */ void plusAssignAllThreads(DslList<MobileStacktrace.FlutterThreadReport.Thread, ThreadsProxy> dslList, Iterable<MobileStacktrace.FlutterThreadReport.Thread> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllThreads(dslList, values);
        }

        @JvmName(name = "plusAssignThreads")
        public final /* synthetic */ void plusAssignThreads(DslList<MobileStacktrace.FlutterThreadReport.Thread, ThreadsProxy> dslList, MobileStacktrace.FlutterThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addThreads(dslList, value);
        }

        @JvmName(name = "setAppInfo")
        public final void setAppInfo(MobileStacktrace.FlutterThreadReport.FlutterAppInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppInfo(value);
        }

        @JvmName(name = "setContext")
        public final void setContext(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setContext(value);
        }

        @JvmName(name = "setException")
        public final void setException(MobileStacktrace.FlutterThreadReport.FlutterException value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setException(value);
        }

        @JvmName(name = "setLibrary")
        public final void setLibrary(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLibrary(value);
        }

        @JvmName(name = "setSummary")
        public final void setSummary(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSummary(value);
        }

        @JvmName(name = "setThreads")
        public final /* synthetic */ void setThreads(DslList dslList, int i, MobileStacktrace.FlutterThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setThreads(i, value);
        }

        @JvmName(name = "setTimestamp")
        public final void setTimestamp(long j) {
            this._builder.setTimestamp(j);
        }

        public /* synthetic */ Dsl(MobileStacktrace.FlutterThreadReport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterAppInfoKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FlutterAppInfoKt {

        @NotNull
        public static final FlutterAppInfoKt INSTANCE = new FlutterAppInfoKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006#"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterAppInfoKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo$Builder;)V", "value", "", "buildNumber", "getBuildNumber", "()Ljava/lang/String;", "setBuildNumber", "(Ljava/lang/String;)V", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "getPackageName", "setPackageName", "pubName", "getPubName", "setPubName", "symbolFileId", "getSymbolFileId", "setSymbolFileId", "version", "getVersion", "setVersion", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo;", "clearBuildNumber", "", "clearPackageName", "clearPubName", "clearSymbolFileId", "clearVersion", "hasSymbolFileId", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.FlutterThreadReport.FlutterAppInfo.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterAppInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterAppInfoKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterAppInfo$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.FlutterThreadReport.FlutterAppInfo.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.FlutterThreadReport.FlutterAppInfo.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.FlutterThreadReport.FlutterAppInfo _build() {
                MobileStacktrace.FlutterThreadReport.FlutterAppInfo flutterAppInfoBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(flutterAppInfoBuild, "_builder.build()");
                return flutterAppInfoBuild;
            }

            public final void clearBuildNumber() {
                this._builder.clearBuildNumber();
            }

            public final void clearPackageName() {
                this._builder.clearPackageName();
            }

            public final void clearPubName() {
                this._builder.clearPubName();
            }

            public final void clearSymbolFileId() {
                this._builder.clearSymbolFileId();
            }

            public final void clearVersion() {
                this._builder.clearVersion();
            }

            @JvmName(name = "getBuildNumber")
            @NotNull
            public final String getBuildNumber() {
                String buildNumber = this._builder.getBuildNumber();
                Intrinsics.checkNotNullExpressionValue(buildNumber, "_builder.getBuildNumber()");
                return buildNumber;
            }

            @JvmName(name = "getPackageName")
            @NotNull
            public final String getPackageName() {
                String packageName = this._builder.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
                return packageName;
            }

            @JvmName(name = "getPubName")
            @NotNull
            public final String getPubName() {
                String pubName = this._builder.getPubName();
                Intrinsics.checkNotNullExpressionValue(pubName, "_builder.getPubName()");
                return pubName;
            }

            @JvmName(name = "getSymbolFileId")
            @NotNull
            public final String getSymbolFileId() {
                String symbolFileId = this._builder.getSymbolFileId();
                Intrinsics.checkNotNullExpressionValue(symbolFileId, "_builder.getSymbolFileId()");
                return symbolFileId;
            }

            @JvmName(name = "getVersion")
            @NotNull
            public final String getVersion() {
                String version = this._builder.getVersion();
                Intrinsics.checkNotNullExpressionValue(version, "_builder.getVersion()");
                return version;
            }

            public final boolean hasSymbolFileId() {
                return this._builder.hasSymbolFileId();
            }

            @JvmName(name = "setBuildNumber")
            public final void setBuildNumber(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setBuildNumber(value);
            }

            @JvmName(name = "setPackageName")
            public final void setPackageName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPackageName(value);
            }

            @JvmName(name = "setPubName")
            public final void setPubName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPubName(value);
            }

            @JvmName(name = "setSymbolFileId")
            public final void setSymbolFileId(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setSymbolFileId(value);
            }

            @JvmName(name = "setVersion")
            public final void setVersion(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setVersion(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.FlutterThreadReport.FlutterAppInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private FlutterAppInfoKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FlutterExceptionKt {

        @NotNull
        public static final FlutterExceptionKt INSTANCE = new FlutterExceptionKt();

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J%\u0010\u001a\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u001bJ+\u0010\u001c\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0007¢\u0006\u0002\b\u001fJ\u001d\u0010 \u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0002\b!J&\u0010\"\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\n¢\u0006\u0002\b#J,\u0010\"\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0087\n¢\u0006\u0002\b$J.\u0010%\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\b(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006+"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException$Builder;)V", "value", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "type", "getType", "setType", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException;", "clearDescription", "", "clearType", "add", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.FlutterThreadReport.FlutterException.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$FlutterException$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.FlutterThreadReport.FlutterException.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FlutterExceptionKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.FlutterThreadReport.FlutterException.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.FlutterThreadReport.FlutterException _build() {
                MobileStacktrace.FlutterThreadReport.FlutterException flutterExceptionBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(flutterExceptionBuild, "_builder.build()");
                return flutterExceptionBuild;
            }

            @JvmName(name = "addAllFrames")
            public final /* synthetic */ void addAllFrames(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllFrames(values);
            }

            @JvmName(name = "addFrames")
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.FlutterThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addFrames(value);
            }

            public final void clearDescription() {
                this._builder.clearDescription();
            }

            @JvmName(name = "clearFrames")
            public final /* synthetic */ void clearFrames(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearFrames();
            }

            public final void clearType() {
                this._builder.clearType();
            }

            @JvmName(name = "getDescription")
            @NotNull
            public final String getDescription() {
                String description = this._builder.getDescription();
                Intrinsics.checkNotNullExpressionValue(description, "_builder.getDescription()");
                return description;
            }

            public final /* synthetic */ DslList getFrames() {
                List<MobileStacktrace.FlutterThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "getType")
            @NotNull
            public final String getType() {
                String type = this._builder.getType();
                Intrinsics.checkNotNullExpressionValue(type, "_builder.getType()");
                return type;
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.FlutterThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.FlutterThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.FlutterThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.FlutterThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "setDescription")
            public final void setDescription(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setDescription(value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.FlutterThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            @JvmName(name = "setType")
            public final void setType(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setType(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.FlutterThreadReport.FlutterException.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private FlutterExceptionKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FrameKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FrameKt {

        @NotNull
        public static final FrameKt INSTANCE = new FrameKt();

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00106\u001a\u000207H\u0001J\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u000209J\u0006\u0010;\u001a\u000209J\u0006\u0010<\u001a\u000209J\u0006\u0010=\u001a\u000209J\u0006\u0010>\u001a\u000209J\u0006\u0010?\u001a\u000209J\u0006\u0010@\u001a\u000209J\u0006\u0010A\u001a\u000209J\u0006\u0010B\u001a\u000209J\u0006\u0010C\u001a\u000209J\u0006\u0010D\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R$\u0010$\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R$\u0010'\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R$\u0010*\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R$\u0010-\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R$\u00100\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R$\u00103\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017¨\u0006F"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FrameKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "cFrameType", "getCFrameType", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "setCFrameType", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;)V", "", "cFrameTypeValue", "getCFrameTypeValue", "()I", "setCFrameTypeValue", "(I)V", "", "className", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "column", "getColumn", "setColumn", "", "isConstructor", "getIsConstructor", "()Z", "setIsConstructor", "(Z)V", "line", "getLine", "setLine", "method", "getMethod", "setMethod", "number", "getNumber", "setNumber", "packagePath", "getPackagePath", "setPackagePath", "packageScheme", "getPackageScheme", "setPackageScheme", "package_", "getPackage_", "setPackage_", "source", "getSource", "setSource", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame;", "clearCFrameType", "", "clearClassName", "clearColumn", "clearIsConstructor", "clearLine", "clearMethod", "clearNumber", "clearPackagePath", "clearPackageScheme", "clearPackage_", "clearSource", "hasCFrameType", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.FlutterThreadReport.Frame.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FrameKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$FrameKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.FlutterThreadReport.Frame.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.FlutterThreadReport.Frame.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.FlutterThreadReport.Frame _build() {
                MobileStacktrace.FlutterThreadReport.Frame frameBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(frameBuild, "_builder.build()");
                return frameBuild;
            }

            public final void clearCFrameType() {
                this._builder.clearCFrameType();
            }

            public final void clearClassName() {
                this._builder.clearClassName();
            }

            public final void clearColumn() {
                this._builder.clearColumn();
            }

            public final void clearIsConstructor() {
                this._builder.clearIsConstructor();
            }

            public final void clearLine() {
                this._builder.clearLine();
            }

            public final void clearMethod() {
                this._builder.clearMethod();
            }

            public final void clearNumber() {
                this._builder.clearNumber();
            }

            public final void clearPackagePath() {
                this._builder.clearPackagePath();
            }

            public final void clearPackageScheme() {
                this._builder.clearPackageScheme();
            }

            public final void clearPackage_() {
                this._builder.clearPackage();
            }

            public final void clearSource() {
                this._builder.clearSource();
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

            @JvmName(name = "getClassName")
            @NotNull
            public final String getClassName() {
                String className = this._builder.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "_builder.getClassName()");
                return className;
            }

            @JvmName(name = "getColumn")
            public final int getColumn() {
                return this._builder.getColumn();
            }

            @JvmName(name = "getIsConstructor")
            public final boolean getIsConstructor() {
                return this._builder.getIsConstructor();
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

            @JvmName(name = "getNumber")
            public final int getNumber() {
                return this._builder.getNumber();
            }

            @JvmName(name = "getPackagePath")
            @NotNull
            public final String getPackagePath() {
                String packagePath = this._builder.getPackagePath();
                Intrinsics.checkNotNullExpressionValue(packagePath, "_builder.getPackagePath()");
                return packagePath;
            }

            @JvmName(name = "getPackageScheme")
            @NotNull
            public final String getPackageScheme() {
                String packageScheme = this._builder.getPackageScheme();
                Intrinsics.checkNotNullExpressionValue(packageScheme, "_builder.getPackageScheme()");
                return packageScheme;
            }

            @JvmName(name = "getPackage_")
            @NotNull
            public final String getPackage_() {
                String str = this._builder.getPackage();
                Intrinsics.checkNotNullExpressionValue(str, "_builder.getPackage()");
                return str;
            }

            @JvmName(name = "getSource")
            @NotNull
            public final String getSource() {
                String source = this._builder.getSource();
                Intrinsics.checkNotNullExpressionValue(source, "_builder.getSource()");
                return source;
            }

            public final boolean hasCFrameType() {
                return this._builder.hasCFrameType();
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

            @JvmName(name = "setClassName")
            public final void setClassName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setClassName(value);
            }

            @JvmName(name = "setColumn")
            public final void setColumn(int i) {
                this._builder.setColumn(i);
            }

            @JvmName(name = "setIsConstructor")
            public final void setIsConstructor(boolean z) {
                this._builder.setIsConstructor(z);
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

            @JvmName(name = "setNumber")
            public final void setNumber(int i) {
                this._builder.setNumber(i);
            }

            @JvmName(name = "setPackagePath")
            public final void setPackagePath(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPackagePath(value);
            }

            @JvmName(name = "setPackageScheme")
            public final void setPackageScheme(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPackageScheme(value);
            }

            @JvmName(name = "setPackage_")
            public final void setPackage_(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPackage(value);
            }

            @JvmName(name = "setSource")
            public final void setSource(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setSource(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.FlutterThreadReport.Frame.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private FrameKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ThreadKt {

        @NotNull
        public static final ThreadKt INSTANCE = new ThreadKt();

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0001J%\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u0016J&\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b\u0018J,\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0087\n¢\u0006\u0002\b\u0019J.\u0010\u001a\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread$Builder;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread;", "add", "", "value", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.FlutterThreadReport.Thread.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport$Thread$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.FlutterThreadReport.Thread.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/FlutterThreadReportKt$ThreadKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.FlutterThreadReport.Thread.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.FlutterThreadReport.Thread _build() {
                MobileStacktrace.FlutterThreadReport.Thread threadBuild = this._builder.build();
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
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.FlutterThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addFrames(value);
            }

            @JvmName(name = "clearFrames")
            public final /* synthetic */ void clearFrames(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearFrames();
            }

            public final /* synthetic */ DslList getFrames() {
                List<MobileStacktrace.FlutterThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.FlutterThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.FlutterThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.FlutterThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.FlutterThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.FlutterThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.FlutterThreadReport.Thread.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ThreadKt() {
        }
    }

    private FlutterThreadReportKt() {
    }

    @JvmName(name = "-initializeflutterAppInfo")
    @NotNull
    /* renamed from: -initializeflutterAppInfo, reason: not valid java name */
    public final MobileStacktrace.FlutterThreadReport.FlutterAppInfo m751initializeflutterAppInfo(Function1<? super FlutterAppInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterAppInfoKt.Dsl.Companion companion = FlutterAppInfoKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.FlutterAppInfo.Builder builderNewBuilder = MobileStacktrace.FlutterThreadReport.FlutterAppInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FlutterAppInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeflutterException")
    @NotNull
    /* renamed from: -initializeflutterException, reason: not valid java name */
    public final MobileStacktrace.FlutterThreadReport.FlutterException m752initializeflutterException(Function1<? super FlutterExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FlutterExceptionKt.Dsl.Companion companion = FlutterExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.FlutterException.Builder builderNewBuilder = MobileStacktrace.FlutterThreadReport.FlutterException.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FlutterExceptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeframe")
    @NotNull
    /* renamed from: -initializeframe, reason: not valid java name */
    public final MobileStacktrace.FlutterThreadReport.Frame m753initializeframe(Function1<? super FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FrameKt.Dsl.Companion companion = FrameKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.Frame.Builder builderNewBuilder = MobileStacktrace.FlutterThreadReport.Frame.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FrameKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializethread")
    @NotNull
    /* renamed from: -initializethread, reason: not valid java name */
    public final MobileStacktrace.FlutterThreadReport.Thread m754initializethread(Function1<? super ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadKt.Dsl.Companion companion = ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.FlutterThreadReport.Thread.Builder builderNewBuilder = MobileStacktrace.FlutterThreadReport.Thread.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ThreadKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
