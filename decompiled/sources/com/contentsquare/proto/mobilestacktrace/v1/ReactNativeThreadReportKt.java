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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt;", "", "()V", "appInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$AppInfoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeappInfo", "exception", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl;", "-initializeexception", TypedValues.AttributesType.S_FRAME, "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$FrameKt$Dsl;", "-initializeframe", "thread", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl;", "-initializethread", "AppInfoKt", "Dsl", "ExceptionKt", "FrameKt", "ThreadKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactNativeThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactNativeThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
/* loaded from: classes3.dex */
public final class ReactNativeThreadReportKt {

    @NotNull
    public static final ReactNativeThreadReportKt INSTANCE = new ReactNativeThreadReportKt();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$AppInfoKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppInfoKt {

        @NotNull
        public static final AppInfoKt INSTANCE = new AppInfoKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$AppInfoKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo$Builder;)V", "value", "", "buildNumber", "getBuildNumber", "()Ljava/lang/String;", "setBuildNumber", "(Ljava/lang/String;)V", "jsVersion", "getJsVersion", "setJsVersion", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "getPackageName", "setPackageName", "version", "getVersion", "setVersion", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "clearBuildNumber", "", "clearJsVersion", "clearPackageName", "clearVersion", "hasJsVersion", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$AppInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$AppInfoKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.ReactNativeThreadReport.AppInfo _build() {
                MobileStacktrace.ReactNativeThreadReport.AppInfo appInfoBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(appInfoBuild, "_builder.build()");
                return appInfoBuild;
            }

            public final void clearBuildNumber() {
                this._builder.clearBuildNumber();
            }

            public final void clearJsVersion() {
                this._builder.clearJsVersion();
            }

            public final void clearPackageName() {
                this._builder.clearPackageName();
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

            @JvmName(name = "getJsVersion")
            @NotNull
            public final String getJsVersion() {
                String jsVersion = this._builder.getJsVersion();
                Intrinsics.checkNotNullExpressionValue(jsVersion, "_builder.getJsVersion()");
                return jsVersion;
            }

            @JvmName(name = "getPackageName")
            @NotNull
            public final String getPackageName() {
                String packageName = this._builder.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "_builder.getPackageName()");
                return packageName;
            }

            @JvmName(name = "getVersion")
            @NotNull
            public final String getVersion() {
                String version = this._builder.getVersion();
                Intrinsics.checkNotNullExpressionValue(version, "_builder.getVersion()");
                return version;
            }

            public final boolean hasJsVersion() {
                return this._builder.hasJsVersion();
            }

            @JvmName(name = "setBuildNumber")
            public final void setBuildNumber(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setBuildNumber(value);
            }

            @JvmName(name = "setJsVersion")
            public final void setJsVersion(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setJsVersion(value);
            }

            @JvmName(name = "setPackageName")
            public final void setPackageName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setPackageName(value);
            }

            @JvmName(name = "setVersion")
            public final void setVersion(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setVersion(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private AppInfoKt() {
        }
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002DEB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020+H\u0001J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020-J\u0006\u00100\u001a\u00020-J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J%\u00105\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0007¢\u0006\u0002\b6J+\u00107\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a09H\u0007¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0007¢\u0006\u0002\b<J&\u0010=\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\n¢\u0006\u0002\b>J,\u0010=\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001a09H\u0087\n¢\u0006\u0002\b?J.\u0010@\u001a\u00020-*\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010A\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020\u001aH\u0087\u0002¢\u0006\u0002\bCR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010$\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006F"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "appInfo", "getAppInfo", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "setAppInfo", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "exception", "getException", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "setException", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;)V", "", "mappingFileId", "getMappingFileId", "()Ljava/lang/String;", "setMappingFileId", "(Ljava/lang/String;)V", "threads", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl$ThreadsProxy;", "getThreads", "()Lcom/google/protobuf/kotlin/DslList;", "", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "appInfoOrNull", "getAppInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$AppInfo;", "exceptionOrNull", "getExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;", "clearAppInfo", "", "clearException", "clearMappingFileId", "clearTimestamp", "hasAppInfo", "", "hasException", "hasMappingFileId", "add", "addThreads", "addAll", "values", "", "addAllThreads", "clear", "clearThreads", "plusAssign", "plusAssignThreads", "plusAssignAllThreads", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setThreads", "Companion", "ThreadsProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.ReactNativeThreadReport.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.ReactNativeThreadReport.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$Dsl$ThreadsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ThreadsProxy extends DslProxy {
            private ThreadsProxy() {
            }
        }

        private Dsl(MobileStacktrace.ReactNativeThreadReport.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.ReactNativeThreadReport _build() {
            MobileStacktrace.ReactNativeThreadReport reactNativeThreadReportBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(reactNativeThreadReportBuild, "_builder.build()");
            return reactNativeThreadReportBuild;
        }

        @JvmName(name = "addAllThreads")
        public final /* synthetic */ void addAllThreads(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllThreads(values);
        }

        @JvmName(name = "addThreads")
        public final /* synthetic */ void addThreads(DslList dslList, MobileStacktrace.ReactNativeThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addThreads(value);
        }

        public final void clearAppInfo() {
            this._builder.clearAppInfo();
        }

        public final void clearException() {
            this._builder.clearException();
        }

        public final void clearMappingFileId() {
            this._builder.clearMappingFileId();
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
        public final MobileStacktrace.ReactNativeThreadReport.AppInfo getAppInfo() {
            MobileStacktrace.ReactNativeThreadReport.AppInfo appInfo = this._builder.getAppInfo();
            Intrinsics.checkNotNullExpressionValue(appInfo, "_builder.getAppInfo()");
            return appInfo;
        }

        @Nullable
        public final MobileStacktrace.ReactNativeThreadReport.AppInfo getAppInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ReactNativeThreadReportKtKt.getAppInfoOrNull(dsl._builder);
        }

        @JvmName(name = "getException")
        @NotNull
        public final MobileStacktrace.ReactNativeThreadReport.Exception getException() {
            MobileStacktrace.ReactNativeThreadReport.Exception exception = this._builder.getException();
            Intrinsics.checkNotNullExpressionValue(exception, "_builder.getException()");
            return exception;
        }

        @Nullable
        public final MobileStacktrace.ReactNativeThreadReport.Exception getExceptionOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ReactNativeThreadReportKtKt.getExceptionOrNull(dsl._builder);
        }

        @JvmName(name = "getMappingFileId")
        @NotNull
        public final String getMappingFileId() {
            String mappingFileId = this._builder.getMappingFileId();
            Intrinsics.checkNotNullExpressionValue(mappingFileId, "_builder.getMappingFileId()");
            return mappingFileId;
        }

        public final /* synthetic */ DslList getThreads() {
            List<MobileStacktrace.ReactNativeThreadReport.Thread> threadsList = this._builder.getThreadsList();
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

        public final boolean hasMappingFileId() {
            return this._builder.hasMappingFileId();
        }

        @JvmName(name = "plusAssignAllThreads")
        public final /* synthetic */ void plusAssignAllThreads(DslList<MobileStacktrace.ReactNativeThreadReport.Thread, ThreadsProxy> dslList, Iterable<MobileStacktrace.ReactNativeThreadReport.Thread> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllThreads(dslList, values);
        }

        @JvmName(name = "plusAssignThreads")
        public final /* synthetic */ void plusAssignThreads(DslList<MobileStacktrace.ReactNativeThreadReport.Thread, ThreadsProxy> dslList, MobileStacktrace.ReactNativeThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addThreads(dslList, value);
        }

        @JvmName(name = "setAppInfo")
        public final void setAppInfo(MobileStacktrace.ReactNativeThreadReport.AppInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAppInfo(value);
        }

        @JvmName(name = "setException")
        public final void setException(MobileStacktrace.ReactNativeThreadReport.Exception value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setException(value);
        }

        @JvmName(name = "setMappingFileId")
        public final void setMappingFileId(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMappingFileId(value);
        }

        @JvmName(name = "setThreads")
        public final /* synthetic */ void setThreads(DslList dslList, int i, MobileStacktrace.ReactNativeThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setThreads(i, value);
        }

        @JvmName(name = "setTimestamp")
        public final void setTimestamp(long j) {
            this._builder.setTimestamp(j);
        }

        public /* synthetic */ Dsl(MobileStacktrace.ReactNativeThreadReport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ExceptionKt {

        @NotNull
        public static final ExceptionKt INSTANCE = new ExceptionKt();

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J%\u0010\u001a\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u001bJ+\u0010\u001c\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0007¢\u0006\u0002\b\u001fJ\u001d\u0010 \u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0007¢\u0006\u0002\b!J&\u0010\"\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\n¢\u0006\u0002\b#J,\u0010\"\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0087\n¢\u0006\u0002\b$J.\u0010%\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u000eH\u0087\u0002¢\u0006\u0002\b(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006+"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception$Builder;)V", "value", "", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "type", "getType", "setType", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception;", "clearDescription", "", "clearType", "add", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.ReactNativeThreadReport.Exception.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Exception$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.ReactNativeThreadReport.Exception.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ExceptionKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.ReactNativeThreadReport.Exception.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.ReactNativeThreadReport.Exception _build() {
                MobileStacktrace.ReactNativeThreadReport.Exception exceptionBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(exceptionBuild, "_builder.build()");
                return exceptionBuild;
            }

            @JvmName(name = "addAllFrames")
            public final /* synthetic */ void addAllFrames(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllFrames(values);
            }

            @JvmName(name = "addFrames")
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.ReactNativeThreadReport.Frame value) {
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
                List<MobileStacktrace.ReactNativeThreadReport.Frame> framesList = this._builder.getFramesList();
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
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.ReactNativeThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.ReactNativeThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.ReactNativeThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.ReactNativeThreadReport.Frame value) {
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
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.ReactNativeThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            @JvmName(name = "setType")
            public final void setType(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setType(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.ReactNativeThreadReport.Exception.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ExceptionKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$FrameKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class FrameKt {

        @NotNull
        public static final FrameKt INSTANCE = new FrameKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020!J\u0006\u0010&\u001a\u00020!J\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000b¨\u0006*"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$FrameKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame$Builder;)V", "value", "", "cContextLine", "getCContextLine", "()Ljava/lang/String;", "setCContextLine", "(Ljava/lang/String;)V", "", "column", "getColumn", "()I", "setColumn", "(I)V", "file", "getFile", "setFile", "frameId", "getFrameId", "setFrameId", "lineNumber", "getLineNumber", "setLineNumber", "methodName", "getMethodName", "setMethodName", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame;", "clearCContextLine", "", "clearColumn", "clearFile", "clearFrameId", "clearLineNumber", "clearMethodName", "hasCContextLine", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.ReactNativeThreadReport.Frame.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$FrameKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$FrameKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.ReactNativeThreadReport.Frame.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.ReactNativeThreadReport.Frame.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.ReactNativeThreadReport.Frame _build() {
                MobileStacktrace.ReactNativeThreadReport.Frame frameBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(frameBuild, "_builder.build()");
                return frameBuild;
            }

            public final void clearCContextLine() {
                this._builder.clearCContextLine();
            }

            public final void clearColumn() {
                this._builder.clearColumn();
            }

            public final void clearFile() {
                this._builder.clearFile();
            }

            public final void clearFrameId() {
                this._builder.clearFrameId();
            }

            public final void clearLineNumber() {
                this._builder.clearLineNumber();
            }

            public final void clearMethodName() {
                this._builder.clearMethodName();
            }

            @JvmName(name = "getCContextLine")
            @NotNull
            public final String getCContextLine() {
                String cContextLine = this._builder.getCContextLine();
                Intrinsics.checkNotNullExpressionValue(cContextLine, "_builder.getCContextLine()");
                return cContextLine;
            }

            @JvmName(name = "getColumn")
            public final int getColumn() {
                return this._builder.getColumn();
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

            @JvmName(name = "getLineNumber")
            public final int getLineNumber() {
                return this._builder.getLineNumber();
            }

            @JvmName(name = "getMethodName")
            @NotNull
            public final String getMethodName() {
                String methodName = this._builder.getMethodName();
                Intrinsics.checkNotNullExpressionValue(methodName, "_builder.getMethodName()");
                return methodName;
            }

            public final boolean hasCContextLine() {
                return this._builder.hasCContextLine();
            }

            @JvmName(name = "setCContextLine")
            public final void setCContextLine(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCContextLine(value);
            }

            @JvmName(name = "setColumn")
            public final void setColumn(int i) {
                this._builder.setColumn(i);
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

            @JvmName(name = "setLineNumber")
            public final void setLineNumber(int i) {
                this._builder.setLineNumber(i);
            }

            @JvmName(name = "setMethodName")
            public final void setMethodName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setMethodName(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.ReactNativeThreadReport.Frame.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private FrameKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ThreadKt {

        @NotNull
        public static final ThreadKt INSTANCE = new ThreadKt();

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0001J%\u0010\r\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J+\u0010\u0011\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u0016J&\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b\u0018J,\u0010\u0017\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0087\n¢\u0006\u0002\b\u0019J.\u0010\u001a\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread$Builder;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread;", "add", "", "value", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.ReactNativeThreadReport.Thread.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport$Thread$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.ReactNativeThreadReport.Thread.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ReactNativeThreadReportKt$ThreadKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.ReactNativeThreadReport.Thread.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.ReactNativeThreadReport.Thread _build() {
                MobileStacktrace.ReactNativeThreadReport.Thread threadBuild = this._builder.build();
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
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.ReactNativeThreadReport.Frame value) {
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
                List<MobileStacktrace.ReactNativeThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.ReactNativeThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.ReactNativeThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.ReactNativeThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.ReactNativeThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.ReactNativeThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.ReactNativeThreadReport.Thread.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ThreadKt() {
        }
    }

    private ReactNativeThreadReportKt() {
    }

    @JvmName(name = "-initializeappInfo")
    @NotNull
    /* renamed from: -initializeappInfo, reason: not valid java name */
    public final MobileStacktrace.ReactNativeThreadReport.AppInfo m1256initializeappInfo(Function1<? super AppInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AppInfoKt.Dsl.Companion companion = AppInfoKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.AppInfo.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.AppInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        AppInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeexception")
    @NotNull
    /* renamed from: -initializeexception, reason: not valid java name */
    public final MobileStacktrace.ReactNativeThreadReport.Exception m1257initializeexception(Function1<? super ExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ExceptionKt.Dsl.Companion companion = ExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Exception.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.Exception.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ExceptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeframe")
    @NotNull
    /* renamed from: -initializeframe, reason: not valid java name */
    public final MobileStacktrace.ReactNativeThreadReport.Frame m1258initializeframe(Function1<? super FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FrameKt.Dsl.Companion companion = FrameKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Frame.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.Frame.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FrameKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializethread")
    @NotNull
    /* renamed from: -initializethread, reason: not valid java name */
    public final MobileStacktrace.ReactNativeThreadReport.Thread m1259initializethread(Function1<? super ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadKt.Dsl.Companion companion = ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.ReactNativeThreadReport.Thread.Builder builderNewBuilder = MobileStacktrace.ReactNativeThreadReport.Thread.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ThreadKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
