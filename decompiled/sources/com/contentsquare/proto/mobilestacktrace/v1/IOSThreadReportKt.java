package com.contentsquare.proto.mobilestacktrace.v1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslMap;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.channel.AttributeMutation;
import java.util.List;
import java.util.Map;
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

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u000b/0123456789B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000eJ*\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0012J*\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0016J*\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u001aJ*\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u001eJ*\u0010\u001f\u001a\u00020 2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\"J*\u0010#\u001a\u00020$2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b&J*\u0010'\u001a\u00020(2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b*J*\u0010+\u001a\u00020,2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b.\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006:"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt;", "", "()V", "applicationInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ApplicationInfoKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeapplicationInfo", "binary", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt$Dsl;", "-initializebinary", "exception", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl;", "-initializeexception", TypedValues.AttributesType.S_FRAME, "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl;", "-initializeframe", "machineInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt$Dsl;", "-initializemachineInfo", "processInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessInfoKt$Dsl;", "-initializeprocessInfo", "processor", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessorKt$Dsl;", "-initializeprocessor", "signal", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$Dsl;", "-initializesignal", "systemInfo", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SystemInfoKt$Dsl;", "-initializesystemInfo", "thread", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl;", "-initializethread", "ApplicationInfoKt", "BinaryKt", "Dsl", "ExceptionKt", "FrameKt", "MachineInfoKt", "ProcessInfoKt", "ProcessorKt", "SignalKt", "SystemInfoKt", "ThreadKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIOSThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IOSThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2559:1\n1#2:2560\n*E\n"})
/* loaded from: classes3.dex */
public final class IOSThreadReportKt {

    @NotNull
    public static final IOSThreadReportKt INSTANCE = new IOSThreadReportKt();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ApplicationInfoKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ApplicationInfoKt {

        @NotNull
        public static final ApplicationInfoKt INSTANCE = new ApplicationInfoKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ApplicationInfoKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo$Builder;)V", "value", "", "identifier", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "marketingVersion", "getMarketingVersion", "setMarketingVersion", "version", "getVersion", "setVersion", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "clearIdentifier", "", "clearMarketingVersion", "clearVersion", "hasMarketingVersion", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.ApplicationInfo.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ApplicationInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ApplicationInfoKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.ApplicationInfo.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.ApplicationInfo.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.ApplicationInfo _build() {
                MobileStacktrace.IOSThreadReport.ApplicationInfo applicationInfoBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(applicationInfoBuild, "_builder.build()");
                return applicationInfoBuild;
            }

            public final void clearIdentifier() {
                this._builder.clearIdentifier();
            }

            public final void clearMarketingVersion() {
                this._builder.clearMarketingVersion();
            }

            public final void clearVersion() {
                this._builder.clearVersion();
            }

            @JvmName(name = "getIdentifier")
            @NotNull
            public final String getIdentifier() {
                String identifier = this._builder.getIdentifier();
                Intrinsics.checkNotNullExpressionValue(identifier, "_builder.getIdentifier()");
                return identifier;
            }

            @JvmName(name = "getMarketingVersion")
            @NotNull
            public final String getMarketingVersion() {
                String marketingVersion = this._builder.getMarketingVersion();
                Intrinsics.checkNotNullExpressionValue(marketingVersion, "_builder.getMarketingVersion()");
                return marketingVersion;
            }

            @JvmName(name = "getVersion")
            @NotNull
            public final String getVersion() {
                String version = this._builder.getVersion();
                Intrinsics.checkNotNullExpressionValue(version, "_builder.getVersion()");
                return version;
            }

            public final boolean hasMarketingVersion() {
                return this._builder.hasMarketingVersion();
            }

            @JvmName(name = "setIdentifier")
            public final void setIdentifier(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setIdentifier(value);
            }

            @JvmName(name = "setMarketingVersion")
            public final void setMarketingVersion(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setMarketingVersion(value);
            }

            @JvmName(name = "setVersion")
            public final void setVersion(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setVersion(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.ApplicationInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ApplicationInfoKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BinaryKt {

        @NotNull
        public static final BinaryKt INSTANCE = new BinaryKt();

        @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010<\u001a\u00020=H\u0001J\u0006\u0010>\u001a\u00020?J\u0006\u0010@\u001a\u00020?J\u0006\u0010A\u001a\u00020?J\u0006\u0010B\u001a\u00020?J\u0006\u0010C\u001a\u00020?J\u0006\u0010D\u001a\u00020?J\u0006\u0010E\u001a\u00020?J\u0006\u0010F\u001a\u00020?J\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020HR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R$\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020*8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010\t\"\u0004\b2\u0010\u000bR$\u00104\u001a\u0002032\u0006\u0010\u0005\u001a\u0002038G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0017\u00109\u001a\u0004\u0018\u00010!*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006K"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary$Builder;)V", "value", "", "baseAddress", "getBaseAddress", "()J", "setBaseAddress", "(J)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Architecture;", "cArchitecture", "getCArchitecture", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Architecture;", "setCArchitecture", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Architecture;)V", "", "cArchitectureValue", "getCArchitectureValue", "()I", "setCArchitectureValue", "(I)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "cType", "getCType", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "setCType", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;)V", "cTypeValue", "getCTypeValue", "setCTypeValue", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "codeType", "getCodeType", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "setCodeType", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;)V", "id", "getId", "setId", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", TCEventPropertiesNames.TCP_SIZE, "getSize", "setSize", "Lcom/google/protobuf/ByteString;", "uuid", "getUuid", "()Lcom/google/protobuf/ByteString;", "setUuid", "(Lcom/google/protobuf/ByteString;)V", "codeTypeOrNull", "getCodeTypeOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary;", "clearBaseAddress", "", "clearCArchitecture", "clearCType", "clearCodeType", "clearId", "clearName", "clearSize", "clearUuid", "hasCodeType", "", "hasUuid", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.Binary.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$BinaryKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Binary.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.Binary.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.Binary _build() {
                MobileStacktrace.IOSThreadReport.Binary binaryBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(binaryBuild, "_builder.build()");
                return binaryBuild;
            }

            public final void clearBaseAddress() {
                this._builder.clearBaseAddress();
            }

            public final void clearCArchitecture() {
                this._builder.clearCArchitecture();
            }

            public final void clearCType() {
                this._builder.clearCType();
            }

            public final void clearCodeType() {
                this._builder.clearCodeType();
            }

            public final void clearId() {
                this._builder.clearId();
            }

            public final void clearName() {
                this._builder.clearName();
            }

            public final void clearSize() {
                this._builder.clearSize();
            }

            public final void clearUuid() {
                this._builder.clearUuid();
            }

            @JvmName(name = "getBaseAddress")
            public final long getBaseAddress() {
                return this._builder.getBaseAddress();
            }

            @JvmName(name = "getCArchitecture")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Architecture getCArchitecture() {
                MobileStacktrace.IOSThreadReport.Architecture cArchitecture = this._builder.getCArchitecture();
                Intrinsics.checkNotNullExpressionValue(cArchitecture, "_builder.getCArchitecture()");
                return cArchitecture;
            }

            @JvmName(name = "getCArchitectureValue")
            public final int getCArchitectureValue() {
                return this._builder.getCArchitectureValue();
            }

            @JvmName(name = "getCType")
            @NotNull
            public final MobileStacktrace.ModuleType getCType() {
                MobileStacktrace.ModuleType cType = this._builder.getCType();
                Intrinsics.checkNotNullExpressionValue(cType, "_builder.getCType()");
                return cType;
            }

            @JvmName(name = "getCTypeValue")
            public final int getCTypeValue() {
                return this._builder.getCTypeValue();
            }

            @JvmName(name = "getCodeType")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Processor getCodeType() {
                MobileStacktrace.IOSThreadReport.Processor codeType = this._builder.getCodeType();
                Intrinsics.checkNotNullExpressionValue(codeType, "_builder.getCodeType()");
                return codeType;
            }

            @Nullable
            public final MobileStacktrace.IOSThreadReport.Processor getCodeTypeOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return IOSThreadReportKtKt.getCodeTypeOrNull(dsl._builder);
            }

            @JvmName(name = "getId")
            public final int getId() {
                return this._builder.getId();
            }

            @JvmName(name = "getName")
            @NotNull
            public final String getName() {
                String name = this._builder.getName();
                Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
                return name;
            }

            @JvmName(name = "getSize")
            public final long getSize() {
                return this._builder.getSize();
            }

            @JvmName(name = "getUuid")
            @NotNull
            public final ByteString getUuid() {
                ByteString uuid = this._builder.getUuid();
                Intrinsics.checkNotNullExpressionValue(uuid, "_builder.getUuid()");
                return uuid;
            }

            public final boolean hasCodeType() {
                return this._builder.hasCodeType();
            }

            public final boolean hasUuid() {
                return this._builder.hasUuid();
            }

            @JvmName(name = "setBaseAddress")
            public final void setBaseAddress(long j) {
                this._builder.setBaseAddress(j);
            }

            @JvmName(name = "setCArchitecture")
            public final void setCArchitecture(MobileStacktrace.IOSThreadReport.Architecture value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCArchitecture(value);
            }

            @JvmName(name = "setCArchitectureValue")
            public final void setCArchitectureValue(int i) {
                this._builder.setCArchitectureValue(i);
            }

            @JvmName(name = "setCType")
            public final void setCType(MobileStacktrace.ModuleType value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCType(value);
            }

            @JvmName(name = "setCTypeValue")
            public final void setCTypeValue(int i) {
                this._builder.setCTypeValue(i);
            }

            @JvmName(name = "setCodeType")
            public final void setCodeType(MobileStacktrace.IOSThreadReport.Processor value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCodeType(value);
            }

            @JvmName(name = "setId")
            public final void setId(int i) {
                this._builder.setId(i);
            }

            @JvmName(name = "setName")
            public final void setName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setName(value);
            }

            @JvmName(name = "setSize")
            public final void setSize(long j) {
                this._builder.setSize(j);
            }

            @JvmName(name = "setUuid")
            public final void setUuid(ByteString value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setUuid(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Binary.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private BinaryKt() {
        }
    }

    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u000b\b\u0007\u0018\u0000 s2\u00020\u0001:\u0003rstB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010I\u001a\u00020JH\u0001J\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020LJ\u0006\u0010N\u001a\u00020LJ\u0006\u0010O\u001a\u00020LJ\u0006\u0010P\u001a\u00020LJ\u0006\u0010Q\u001a\u00020LJ\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020SJ\u0006\u0010U\u001a\u00020SJ\u0006\u0010V\u001a\u00020SJ\u0006\u0010W\u001a\u00020SJ\u0006\u0010X\u001a\u00020SJ%\u0010Y\u001a\u00020L*\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204022\u0006\u0010\u0005\u001a\u000203H\u0007¢\u0006\u0002\bZJ+\u0010[\u001a\u00020L*\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204022\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002030]H\u0007¢\u0006\u0002\b^J\u001d\u0010_\u001a\u00020L*\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020402H\u0007¢\u0006\u0002\b`J#\u0010_\u001a\u00020L*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0007¢\u0006\u0002\baJ&\u0010b\u001a\u00020L*\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204022\u0006\u0010\u0005\u001a\u000203H\u0087\n¢\u0006\u0002\bcJ,\u0010b\u001a\u00020L*\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204022\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002030]H\u0087\n¢\u0006\u0002\bdJ3\u0010e\u001a\u00020L*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\u0007¢\u0006\u0002\bgJ7\u0010h\u001a\u00020L*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0jH\u0007¢\u0006\u0002\bkJ+\u0010l\u001a\u00020L*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010f\u001a\u00020\u000eH\u0007¢\u0006\u0002\bmJ.\u0010n\u001a\u00020L*\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204022\u0006\u0010o\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u000203H\u0087\u0002¢\u0006\u0002\bpJ4\u0010n\u001a\u00020L*\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000fH\u0087\n¢\u0006\u0002\bqR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00138G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00198G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020%8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020+8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00101\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204028F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0017\u00107\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0017\u0010:\u001a\u0004\u0018\u00010\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0017\u0010=\u001a\u0004\u0018\u00010\u0019*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0017\u0010@\u001a\u0004\u0018\u00010\u001f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0017\u0010C\u001a\u0004\u0018\u00010%*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010F\u001a\u0004\u0018\u00010+*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006u"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "applicationInfo", "getApplicationInfo", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "setApplicationInfo", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;)V", "binaries", "Lcom/google/protobuf/kotlin/DslMap;", "", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Binary;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl$BinariesProxy;", "getBinariesMap", "()Lcom/google/protobuf/kotlin/DslMap;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "lastExceptionBacktrace", "getLastExceptionBacktrace", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "setLastExceptionBacktrace", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "machineInfo", "getMachineInfo", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "setMachineInfo", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "processInfo", "getProcessInfo", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "setProcessInfo", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "signal", "getSignal", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "setSignal", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "systemInfo", "getSystemInfo", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "setSystemInfo", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;)V", "threads", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl$ThreadsProxy;", "getThreads", "()Lcom/google/protobuf/kotlin/DslList;", "applicationInfoOrNull", "getApplicationInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ApplicationInfo;", "lastExceptionBacktraceOrNull", "getLastExceptionBacktraceOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "machineInfoOrNull", "getMachineInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "processInfoOrNull", "getProcessInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "signalOrNull", "getSignalOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "systemInfoOrNull", "getSystemInfoOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;", "clearApplicationInfo", "", "clearLastExceptionBacktrace", "clearMachineInfo", "clearProcessInfo", "clearSignal", "clearSystemInfo", "hasApplicationInfo", "", "hasLastExceptionBacktrace", "hasMachineInfo", "hasProcessInfo", "hasSignal", "hasSystemInfo", "add", "addThreads", "addAll", "values", "", "addAllThreads", "clear", "clearThreads", "clearBinaries", "plusAssign", "plusAssignThreads", "plusAssignAllThreads", "put", "key", "putBinaries", "putAll", "map", "", "putAllBinaries", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "removeBinaries", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setThreads", "setBinaries", "BinariesProxy", "Companion", "ThreadsProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.IOSThreadReport.Builder _builder;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl$BinariesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class BinariesProxy extends DslProxy {
            private BinariesProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$Dsl$ThreadsProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ThreadsProxy extends DslProxy {
            private ThreadsProxy() {
            }
        }

        private Dsl(MobileStacktrace.IOSThreadReport.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.IOSThreadReport _build() {
            MobileStacktrace.IOSThreadReport iOSThreadReportBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(iOSThreadReportBuild, "_builder.build()");
            return iOSThreadReportBuild;
        }

        @JvmName(name = "addAllThreads")
        public final /* synthetic */ void addAllThreads(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllThreads(values);
        }

        @JvmName(name = "addThreads")
        public final /* synthetic */ void addThreads(DslList dslList, MobileStacktrace.IOSThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addThreads(value);
        }

        public final void clearApplicationInfo() {
            this._builder.clearApplicationInfo();
        }

        @JvmName(name = "clearBinaries")
        public final /* synthetic */ void clearBinaries(DslMap dslMap) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.clearBinaries();
        }

        public final void clearLastExceptionBacktrace() {
            this._builder.clearLastExceptionBacktrace();
        }

        public final void clearMachineInfo() {
            this._builder.clearMachineInfo();
        }

        public final void clearProcessInfo() {
            this._builder.clearProcessInfo();
        }

        public final void clearSignal() {
            this._builder.clearSignal();
        }

        public final void clearSystemInfo() {
            this._builder.clearSystemInfo();
        }

        @JvmName(name = "clearThreads")
        public final /* synthetic */ void clearThreads(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearThreads();
        }

        @JvmName(name = "getApplicationInfo")
        @NotNull
        public final MobileStacktrace.IOSThreadReport.ApplicationInfo getApplicationInfo() {
            MobileStacktrace.IOSThreadReport.ApplicationInfo applicationInfo = this._builder.getApplicationInfo();
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "_builder.getApplicationInfo()");
            return applicationInfo;
        }

        @Nullable
        public final MobileStacktrace.IOSThreadReport.ApplicationInfo getApplicationInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return IOSThreadReportKtKt.getApplicationInfoOrNull(dsl._builder);
        }

        @JvmName(name = "getBinariesMap")
        public final /* synthetic */ DslMap getBinariesMap() {
            Map<Integer, MobileStacktrace.IOSThreadReport.Binary> binariesMap = this._builder.getBinariesMap();
            Intrinsics.checkNotNullExpressionValue(binariesMap, "_builder.getBinariesMap()");
            return new DslMap(binariesMap);
        }

        @JvmName(name = "getLastExceptionBacktrace")
        @NotNull
        public final MobileStacktrace.IOSThreadReport.Exception getLastExceptionBacktrace() {
            MobileStacktrace.IOSThreadReport.Exception lastExceptionBacktrace = this._builder.getLastExceptionBacktrace();
            Intrinsics.checkNotNullExpressionValue(lastExceptionBacktrace, "_builder.getLastExceptionBacktrace()");
            return lastExceptionBacktrace;
        }

        @Nullable
        public final MobileStacktrace.IOSThreadReport.Exception getLastExceptionBacktraceOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return IOSThreadReportKtKt.getLastExceptionBacktraceOrNull(dsl._builder);
        }

        @JvmName(name = "getMachineInfo")
        @NotNull
        public final MobileStacktrace.IOSThreadReport.MachineInfo getMachineInfo() {
            MobileStacktrace.IOSThreadReport.MachineInfo machineInfo = this._builder.getMachineInfo();
            Intrinsics.checkNotNullExpressionValue(machineInfo, "_builder.getMachineInfo()");
            return machineInfo;
        }

        @Nullable
        public final MobileStacktrace.IOSThreadReport.MachineInfo getMachineInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return IOSThreadReportKtKt.getMachineInfoOrNull(dsl._builder);
        }

        @JvmName(name = "getProcessInfo")
        @NotNull
        public final MobileStacktrace.IOSThreadReport.ProcessInfo getProcessInfo() {
            MobileStacktrace.IOSThreadReport.ProcessInfo processInfo = this._builder.getProcessInfo();
            Intrinsics.checkNotNullExpressionValue(processInfo, "_builder.getProcessInfo()");
            return processInfo;
        }

        @Nullable
        public final MobileStacktrace.IOSThreadReport.ProcessInfo getProcessInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return IOSThreadReportKtKt.getProcessInfoOrNull(dsl._builder);
        }

        @JvmName(name = "getSignal")
        @NotNull
        public final MobileStacktrace.IOSThreadReport.Signal getSignal() {
            MobileStacktrace.IOSThreadReport.Signal signal = this._builder.getSignal();
            Intrinsics.checkNotNullExpressionValue(signal, "_builder.getSignal()");
            return signal;
        }

        @Nullable
        public final MobileStacktrace.IOSThreadReport.Signal getSignalOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return IOSThreadReportKtKt.getSignalOrNull(dsl._builder);
        }

        @JvmName(name = "getSystemInfo")
        @NotNull
        public final MobileStacktrace.IOSThreadReport.SystemInfo getSystemInfo() {
            MobileStacktrace.IOSThreadReport.SystemInfo systemInfo = this._builder.getSystemInfo();
            Intrinsics.checkNotNullExpressionValue(systemInfo, "_builder.getSystemInfo()");
            return systemInfo;
        }

        @Nullable
        public final MobileStacktrace.IOSThreadReport.SystemInfo getSystemInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return IOSThreadReportKtKt.getSystemInfoOrNull(dsl._builder);
        }

        public final /* synthetic */ DslList getThreads() {
            List<MobileStacktrace.IOSThreadReport.Thread> threadsList = this._builder.getThreadsList();
            Intrinsics.checkNotNullExpressionValue(threadsList, "_builder.getThreadsList()");
            return new DslList(threadsList);
        }

        public final boolean hasApplicationInfo() {
            return this._builder.hasApplicationInfo();
        }

        public final boolean hasLastExceptionBacktrace() {
            return this._builder.hasLastExceptionBacktrace();
        }

        public final boolean hasMachineInfo() {
            return this._builder.hasMachineInfo();
        }

        public final boolean hasProcessInfo() {
            return this._builder.hasProcessInfo();
        }

        public final boolean hasSignal() {
            return this._builder.hasSignal();
        }

        public final boolean hasSystemInfo() {
            return this._builder.hasSystemInfo();
        }

        @JvmName(name = "plusAssignAllThreads")
        public final /* synthetic */ void plusAssignAllThreads(DslList<MobileStacktrace.IOSThreadReport.Thread, ThreadsProxy> dslList, Iterable<MobileStacktrace.IOSThreadReport.Thread> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllThreads(dslList, values);
        }

        @JvmName(name = "plusAssignThreads")
        public final /* synthetic */ void plusAssignThreads(DslList<MobileStacktrace.IOSThreadReport.Thread, ThreadsProxy> dslList, MobileStacktrace.IOSThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addThreads(dslList, value);
        }

        @JvmName(name = "putAllBinaries")
        public final /* synthetic */ void putAllBinaries(DslMap dslMap, Map map) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(map, "map");
            this._builder.putAllBinaries(map);
        }

        @JvmName(name = "putBinaries")
        public final void putBinaries(DslMap<Integer, MobileStacktrace.IOSThreadReport.Binary, BinariesProxy> dslMap, int i, MobileStacktrace.IOSThreadReport.Binary value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.putBinaries(i, value);
        }

        @JvmName(name = "removeBinaries")
        public final /* synthetic */ void removeBinaries(DslMap dslMap, int i) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            this._builder.removeBinaries(i);
        }

        @JvmName(name = "setApplicationInfo")
        public final void setApplicationInfo(MobileStacktrace.IOSThreadReport.ApplicationInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setApplicationInfo(value);
        }

        @JvmName(name = "setBinaries")
        public final /* synthetic */ void setBinaries(DslMap<Integer, MobileStacktrace.IOSThreadReport.Binary, BinariesProxy> dslMap, int i, MobileStacktrace.IOSThreadReport.Binary value) {
            Intrinsics.checkNotNullParameter(dslMap, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            putBinaries(dslMap, i, value);
        }

        @JvmName(name = "setLastExceptionBacktrace")
        public final void setLastExceptionBacktrace(MobileStacktrace.IOSThreadReport.Exception value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setLastExceptionBacktrace(value);
        }

        @JvmName(name = "setMachineInfo")
        public final void setMachineInfo(MobileStacktrace.IOSThreadReport.MachineInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMachineInfo(value);
        }

        @JvmName(name = "setProcessInfo")
        public final void setProcessInfo(MobileStacktrace.IOSThreadReport.ProcessInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setProcessInfo(value);
        }

        @JvmName(name = "setSignal")
        public final void setSignal(MobileStacktrace.IOSThreadReport.Signal value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSignal(value);
        }

        @JvmName(name = "setSystemInfo")
        public final void setSystemInfo(MobileStacktrace.IOSThreadReport.SystemInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSystemInfo(value);
        }

        @JvmName(name = "setThreads")
        public final /* synthetic */ void setThreads(DslList dslList, int i, MobileStacktrace.IOSThreadReport.Thread value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setThreads(i, value);
        }

        public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ExceptionKt {

        @NotNull
        public static final ExceptionKt INSTANCE = new ExceptionKt();

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J%\u0010\u001a\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u001bJ+\u0010\u001c\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH\u0007¢\u0006\u0002\b\u001fJ\u001d\u0010 \u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b!J&\u0010\"\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b#J,\u0010\"\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001eH\u0087\n¢\u0006\u0002\b$J.\u0010%\u001a\u00020\u0018*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010&\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006+"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception$Builder;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "reason", "getReason", "setReason", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception;", "clearName", "", "clearReason", "add", "addFrames", "addAll", "values", "", "addAllFrames", "clear", "clearFrames", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setFrames", "Companion", "FramesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.Exception.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Exception$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Exception.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ExceptionKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.Exception.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.Exception _build() {
                MobileStacktrace.IOSThreadReport.Exception exceptionBuild = this._builder.build();
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
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.IOSThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addFrames(value);
            }

            @JvmName(name = "clearFrames")
            public final /* synthetic */ void clearFrames(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearFrames();
            }

            public final void clearName() {
                this._builder.clearName();
            }

            public final void clearReason() {
                this._builder.clearReason();
            }

            public final /* synthetic */ DslList getFrames() {
                List<MobileStacktrace.IOSThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "getName")
            @NotNull
            public final String getName() {
                String name = this._builder.getName();
                Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
                return name;
            }

            @JvmName(name = "getReason")
            @NotNull
            public final String getReason() {
                String reason = this._builder.getReason();
                Intrinsics.checkNotNullExpressionValue(reason, "_builder.getReason()");
                return reason;
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.IOSThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.IOSThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.IOSThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.IOSThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.IOSThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            @JvmName(name = "setName")
            public final void setName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setName(value);
            }

            @JvmName(name = "setReason")
            public final void setReason(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setReason(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Exception.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ExceptionKt() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt;", "", "()V", "binaryInformation", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$BinaryInformationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializebinaryInformation", "sourceLocation", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$SourceLocationKt$Dsl;", "-initializesourceLocation", "BinaryInformationKt", "Dsl", "SourceLocationKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nIOSThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IOSThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2559:1\n1#2:2560\n*E\n"})
    public static final class FrameKt {

        @NotNull
        public static final FrameKt INSTANCE = new FrameKt();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$BinaryInformationKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class BinaryInformationKt {

            @NotNull
            public static final BinaryInformationKt INSTANCE = new BinaryInformationKt();

            @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$BinaryInformationKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "type", "getType", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;", "setType", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ModuleType;)V", "", "typeValue", "getTypeValue", "()I", "setTypeValue", "(I)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "clearName", "", "clearType", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            @ProtoDslMarker
            public static final class Dsl {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);

                @NotNull
                private final MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.Builder _builder;

                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$BinaryInformationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$BinaryInformationKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    @PublishedApi
                    public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        return new Dsl(builder, null);
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                private Dsl(MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.Builder builder) {
                    this._builder = builder;
                }

                @PublishedApi
                public final /* synthetic */ MobileStacktrace.IOSThreadReport.Frame.BinaryInformation _build() {
                    MobileStacktrace.IOSThreadReport.Frame.BinaryInformation binaryInformationBuild = this._builder.build();
                    Intrinsics.checkNotNullExpressionValue(binaryInformationBuild, "_builder.build()");
                    return binaryInformationBuild;
                }

                public final void clearName() {
                    this._builder.clearName();
                }

                public final void clearType() {
                    this._builder.clearType();
                }

                @JvmName(name = "getName")
                @NotNull
                public final String getName() {
                    String name = this._builder.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
                    return name;
                }

                @JvmName(name = "getType")
                @NotNull
                public final MobileStacktrace.ModuleType getType() {
                    MobileStacktrace.ModuleType type = this._builder.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "_builder.getType()");
                    return type;
                }

                @JvmName(name = "getTypeValue")
                public final int getTypeValue() {
                    return this._builder.getTypeValue();
                }

                @JvmName(name = "setName")
                public final void setName(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setName(value);
                }

                @JvmName(name = "setType")
                public final void setType(MobileStacktrace.ModuleType value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setType(value);
                }

                @JvmName(name = "setTypeValue")
                public final void setTypeValue(int i) {
                    this._builder.setTypeValue(i);
                }

                public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                    this(builder);
                }
            }

            private BinaryInformationKt() {
            }
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0001J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u000200J\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u000200J\u0006\u00105\u001a\u000200J\u0006\u00106\u001a\u000200J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u000208R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR$\u0010!\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u0017\u0010'\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\u0004\u0018\u00010\u0018*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006<"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$Builder;)V", "value", "", "binaryId", "getBinaryId", "()I", "setBinaryId", "(I)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "cBinaryInformation", "getCBinaryInformation", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "setCBinaryInformation", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;)V", "", "cByteOffset", "getCByteOffset", "()J", "setCByteOffset", "(J)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "cSourceLocation", "getCSourceLocation", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "setCSourceLocation", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;)V", "frameId", "getFrameId", "setFrameId", "instructionAddress", "getInstructionAddress", "setInstructionAddress", "repeatedCount", "getRepeatedCount", "setRepeatedCount", "cBinaryInformationOrNull", "getCBinaryInformationOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$BinaryInformation;", "cSourceLocationOrNull", "getCSourceLocationOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame;", "clearBinaryId", "", "clearCBinaryInformation", "clearCByteOffset", "clearCSourceLocation", "clearFrameId", "clearInstructionAddress", "clearRepeatedCount", "hasCBinaryInformation", "", "hasCByteOffset", "hasCSourceLocation", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.Frame.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Frame.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.Frame.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.Frame _build() {
                MobileStacktrace.IOSThreadReport.Frame frameBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(frameBuild, "_builder.build()");
                return frameBuild;
            }

            public final void clearBinaryId() {
                this._builder.clearBinaryId();
            }

            public final void clearCBinaryInformation() {
                this._builder.clearCBinaryInformation();
            }

            public final void clearCByteOffset() {
                this._builder.clearCByteOffset();
            }

            public final void clearCSourceLocation() {
                this._builder.clearCSourceLocation();
            }

            public final void clearFrameId() {
                this._builder.clearFrameId();
            }

            public final void clearInstructionAddress() {
                this._builder.clearInstructionAddress();
            }

            public final void clearRepeatedCount() {
                this._builder.clearRepeatedCount();
            }

            @JvmName(name = "getBinaryId")
            public final int getBinaryId() {
                return this._builder.getBinaryId();
            }

            @JvmName(name = "getCBinaryInformation")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Frame.BinaryInformation getCBinaryInformation() {
                MobileStacktrace.IOSThreadReport.Frame.BinaryInformation cBinaryInformation = this._builder.getCBinaryInformation();
                Intrinsics.checkNotNullExpressionValue(cBinaryInformation, "_builder.getCBinaryInformation()");
                return cBinaryInformation;
            }

            @Nullable
            public final MobileStacktrace.IOSThreadReport.Frame.BinaryInformation getCBinaryInformationOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return IOSThreadReportKtKt.getCBinaryInformationOrNull(dsl._builder);
            }

            @JvmName(name = "getCByteOffset")
            public final long getCByteOffset() {
                return this._builder.getCByteOffset();
            }

            @JvmName(name = "getCSourceLocation")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Frame.SourceLocation getCSourceLocation() {
                MobileStacktrace.IOSThreadReport.Frame.SourceLocation cSourceLocation = this._builder.getCSourceLocation();
                Intrinsics.checkNotNullExpressionValue(cSourceLocation, "_builder.getCSourceLocation()");
                return cSourceLocation;
            }

            @Nullable
            public final MobileStacktrace.IOSThreadReport.Frame.SourceLocation getCSourceLocationOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return IOSThreadReportKtKt.getCSourceLocationOrNull(dsl._builder);
            }

            @JvmName(name = "getFrameId")
            public final int getFrameId() {
                return this._builder.getFrameId();
            }

            @JvmName(name = "getInstructionAddress")
            public final long getInstructionAddress() {
                return this._builder.getInstructionAddress();
            }

            @JvmName(name = "getRepeatedCount")
            public final int getRepeatedCount() {
                return this._builder.getRepeatedCount();
            }

            public final boolean hasCBinaryInformation() {
                return this._builder.hasCBinaryInformation();
            }

            public final boolean hasCByteOffset() {
                return this._builder.hasCByteOffset();
            }

            public final boolean hasCSourceLocation() {
                return this._builder.hasCSourceLocation();
            }

            @JvmName(name = "setBinaryId")
            public final void setBinaryId(int i) {
                this._builder.setBinaryId(i);
            }

            @JvmName(name = "setCBinaryInformation")
            public final void setCBinaryInformation(MobileStacktrace.IOSThreadReport.Frame.BinaryInformation value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCBinaryInformation(value);
            }

            @JvmName(name = "setCByteOffset")
            public final void setCByteOffset(long j) {
                this._builder.setCByteOffset(j);
            }

            @JvmName(name = "setCSourceLocation")
            public final void setCSourceLocation(MobileStacktrace.IOSThreadReport.Frame.SourceLocation value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCSourceLocation(value);
            }

            @JvmName(name = "setFrameId")
            public final void setFrameId(int i) {
                this._builder.setFrameId(i);
            }

            @JvmName(name = "setInstructionAddress")
            public final void setInstructionAddress(long j) {
                this._builder.setInstructionAddress(j);
            }

            @JvmName(name = "setRepeatedCount")
            public final void setRepeatedCount(int i) {
                this._builder.setRepeatedCount(i);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Frame.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$SourceLocationKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class SourceLocationKt {

            @NotNull
            public static final SourceLocationKt INSTANCE = new SourceLocationKt();

            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$SourceLocationKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation$Builder;)V", "value", "", "cFile", "getCFile", "()Ljava/lang/String;", "setCFile", "(Ljava/lang/String;)V", "cFunctionName", "getCFunctionName", "setCFunctionName", "", "cLine", "getCLine", "()I", "setCLine", "(I)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation;", "clearCFile", "", "clearCFunctionName", "clearCLine", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            @ProtoDslMarker
            public static final class Dsl {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);

                @NotNull
                private final MobileStacktrace.IOSThreadReport.Frame.SourceLocation.Builder _builder;

                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$SourceLocationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$FrameKt$SourceLocationKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame$SourceLocation$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    @PublishedApi
                    public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Frame.SourceLocation.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        return new Dsl(builder, null);
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                private Dsl(MobileStacktrace.IOSThreadReport.Frame.SourceLocation.Builder builder) {
                    this._builder = builder;
                }

                @PublishedApi
                public final /* synthetic */ MobileStacktrace.IOSThreadReport.Frame.SourceLocation _build() {
                    MobileStacktrace.IOSThreadReport.Frame.SourceLocation sourceLocationBuild = this._builder.build();
                    Intrinsics.checkNotNullExpressionValue(sourceLocationBuild, "_builder.build()");
                    return sourceLocationBuild;
                }

                public final void clearCFile() {
                    this._builder.clearCFile();
                }

                public final void clearCFunctionName() {
                    this._builder.clearCFunctionName();
                }

                public final void clearCLine() {
                    this._builder.clearCLine();
                }

                @JvmName(name = "getCFile")
                @NotNull
                public final String getCFile() {
                    String cFile = this._builder.getCFile();
                    Intrinsics.checkNotNullExpressionValue(cFile, "_builder.getCFile()");
                    return cFile;
                }

                @JvmName(name = "getCFunctionName")
                @NotNull
                public final String getCFunctionName() {
                    String cFunctionName = this._builder.getCFunctionName();
                    Intrinsics.checkNotNullExpressionValue(cFunctionName, "_builder.getCFunctionName()");
                    return cFunctionName;
                }

                @JvmName(name = "getCLine")
                public final int getCLine() {
                    return this._builder.getCLine();
                }

                @JvmName(name = "setCFile")
                public final void setCFile(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setCFile(value);
                }

                @JvmName(name = "setCFunctionName")
                public final void setCFunctionName(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setCFunctionName(value);
                }

                @JvmName(name = "setCLine")
                public final void setCLine(int i) {
                    this._builder.setCLine(i);
                }

                public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Frame.SourceLocation.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                    this(builder);
                }
            }

            private SourceLocationKt() {
            }
        }

        private FrameKt() {
        }

        @JvmName(name = "-initializebinaryInformation")
        @NotNull
        /* renamed from: -initializebinaryInformation, reason: not valid java name */
        public final MobileStacktrace.IOSThreadReport.Frame.BinaryInformation m766initializebinaryInformation(Function1<? super BinaryInformationKt.Dsl, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            BinaryInformationKt.Dsl.Companion companion = BinaryInformationKt.Dsl.INSTANCE;
            MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Frame.BinaryInformation.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
            BinaryInformationKt.Dsl dsl_create = companion._create(builderNewBuilder);
            block.invoke(dsl_create);
            return dsl_create._build();
        }

        @JvmName(name = "-initializesourceLocation")
        @NotNull
        /* renamed from: -initializesourceLocation, reason: not valid java name */
        public final MobileStacktrace.IOSThreadReport.Frame.SourceLocation m767initializesourceLocation(Function1<? super SourceLocationKt.Dsl, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            SourceLocationKt.Dsl.Companion companion = SourceLocationKt.Dsl.INSTANCE;
            MobileStacktrace.IOSThreadReport.Frame.SourceLocation.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Frame.SourceLocation.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
            SourceLocationKt.Dsl dsl_create = companion._create(builderNewBuilder);
            block.invoke(dsl_create);
            return dsl_create._build();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MachineInfoKt {

        @NotNull
        public static final MachineInfoKt INSTANCE = new MachineInfoKt();

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0001J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00158G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u0017\u0010$\u001a\u0004\u0018\u00010\u001b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u00063"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Architecture;", "cArchitecture", "getCArchitecture", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Architecture;", "setCArchitecture", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Architecture;)V", "", "cArchitectureValue", "getCArchitectureValue", "()I", "setCArchitectureValue", "(I)V", "logicalProcessorCount", "getLogicalProcessorCount", "setLogicalProcessorCount", "", TCEventPropertiesNames.TCD_MODEL, "getModel", "()Ljava/lang/String;", "setModel", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "processor", "getProcessor", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "setProcessor", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;)V", "processorCount", "getProcessorCount", "setProcessorCount", "processorOrNull", "getProcessorOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo;", "clearCArchitecture", "", "clearLogicalProcessorCount", "clearModel", "clearProcessor", "clearProcessorCount", "hasModel", "", "hasProcessor", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.MachineInfo.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$MachineInfoKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$MachineInfo$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.MachineInfo.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.MachineInfo.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.MachineInfo _build() {
                MobileStacktrace.IOSThreadReport.MachineInfo machineInfoBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(machineInfoBuild, "_builder.build()");
                return machineInfoBuild;
            }

            public final void clearCArchitecture() {
                this._builder.clearCArchitecture();
            }

            public final void clearLogicalProcessorCount() {
                this._builder.clearLogicalProcessorCount();
            }

            public final void clearModel() {
                this._builder.clearModel();
            }

            public final void clearProcessor() {
                this._builder.clearProcessor();
            }

            public final void clearProcessorCount() {
                this._builder.clearProcessorCount();
            }

            @JvmName(name = "getCArchitecture")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Architecture getCArchitecture() {
                MobileStacktrace.IOSThreadReport.Architecture cArchitecture = this._builder.getCArchitecture();
                Intrinsics.checkNotNullExpressionValue(cArchitecture, "_builder.getCArchitecture()");
                return cArchitecture;
            }

            @JvmName(name = "getCArchitectureValue")
            public final int getCArchitectureValue() {
                return this._builder.getCArchitectureValue();
            }

            @JvmName(name = "getLogicalProcessorCount")
            public final int getLogicalProcessorCount() {
                return this._builder.getLogicalProcessorCount();
            }

            @JvmName(name = "getModel")
            @NotNull
            public final String getModel() {
                String model = this._builder.getModel();
                Intrinsics.checkNotNullExpressionValue(model, "_builder.getModel()");
                return model;
            }

            @JvmName(name = "getProcessor")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Processor getProcessor() {
                MobileStacktrace.IOSThreadReport.Processor processor = this._builder.getProcessor();
                Intrinsics.checkNotNullExpressionValue(processor, "_builder.getProcessor()");
                return processor;
            }

            @JvmName(name = "getProcessorCount")
            public final int getProcessorCount() {
                return this._builder.getProcessorCount();
            }

            @Nullable
            public final MobileStacktrace.IOSThreadReport.Processor getProcessorOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return IOSThreadReportKtKt.getProcessorOrNull(dsl._builder);
            }

            public final boolean hasModel() {
                return this._builder.hasModel();
            }

            public final boolean hasProcessor() {
                return this._builder.hasProcessor();
            }

            @JvmName(name = "setCArchitecture")
            public final void setCArchitecture(MobileStacktrace.IOSThreadReport.Architecture value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCArchitecture(value);
            }

            @JvmName(name = "setCArchitectureValue")
            public final void setCArchitectureValue(int i) {
                this._builder.setCArchitectureValue(i);
            }

            @JvmName(name = "setLogicalProcessorCount")
            public final void setLogicalProcessorCount(int i) {
                this._builder.setLogicalProcessorCount(i);
            }

            @JvmName(name = "setModel")
            public final void setModel(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setModel(value);
            }

            @JvmName(name = "setProcessor")
            public final void setProcessor(MobileStacktrace.IOSThreadReport.Processor value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setProcessor(value);
            }

            @JvmName(name = "setProcessorCount")
            public final void setProcessorCount(int i) {
                this._builder.setProcessorCount(i);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.MachineInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private MachineInfoKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessInfoKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ProcessInfoKt {

        @NotNull
        public static final ProcessInfoKt INSTANCE = new ProcessInfoKt();

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0001J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u0006\u00100\u001a\u00020*J\u0006\u00101\u001a\u00020\u0006J\u0006\u00102\u001a\u00020\u0006J\u0006\u00103\u001a\u00020\u0006J\u0006\u00104\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00066"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessInfoKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo$Builder;)V", "value", "", "native", "getNative", "()Z", "setNative", "(Z)V", "", "parentProcessId", "getParentProcessId", "()I", "setParentProcessId", "(I)V", "", "parentProcessName", "getParentProcessName", "()Ljava/lang/String;", "setParentProcessName", "(Ljava/lang/String;)V", "processId", "getProcessId", "setProcessId", "processName", "getProcessName", "setProcessName", "processPath", "getProcessPath", "setProcessPath", "", "startTime", "getStartTime", "()J", "setStartTime", "(J)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo;", "clearNative", "", "clearParentProcessId", "clearParentProcessName", "clearProcessId", "clearProcessName", "clearProcessPath", "clearStartTime", "hasParentProcessName", "hasProcessName", "hasProcessPath", "hasStartTime", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.ProcessInfo.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessInfoKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$ProcessInfo$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.ProcessInfo.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.ProcessInfo.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.ProcessInfo _build() {
                MobileStacktrace.IOSThreadReport.ProcessInfo processInfoBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(processInfoBuild, "_builder.build()");
                return processInfoBuild;
            }

            public final void clearNative() {
                this._builder.clearNative();
            }

            public final void clearParentProcessId() {
                this._builder.clearParentProcessId();
            }

            public final void clearParentProcessName() {
                this._builder.clearParentProcessName();
            }

            public final void clearProcessId() {
                this._builder.clearProcessId();
            }

            public final void clearProcessName() {
                this._builder.clearProcessName();
            }

            public final void clearProcessPath() {
                this._builder.clearProcessPath();
            }

            public final void clearStartTime() {
                this._builder.clearStartTime();
            }

            @JvmName(name = "getNative")
            public final boolean getNative() {
                return this._builder.getNative();
            }

            @JvmName(name = "getParentProcessId")
            public final int getParentProcessId() {
                return this._builder.getParentProcessId();
            }

            @JvmName(name = "getParentProcessName")
            @NotNull
            public final String getParentProcessName() {
                String parentProcessName = this._builder.getParentProcessName();
                Intrinsics.checkNotNullExpressionValue(parentProcessName, "_builder.getParentProcessName()");
                return parentProcessName;
            }

            @JvmName(name = "getProcessId")
            public final int getProcessId() {
                return this._builder.getProcessId();
            }

            @JvmName(name = "getProcessName")
            @NotNull
            public final String getProcessName() {
                String processName = this._builder.getProcessName();
                Intrinsics.checkNotNullExpressionValue(processName, "_builder.getProcessName()");
                return processName;
            }

            @JvmName(name = "getProcessPath")
            @NotNull
            public final String getProcessPath() {
                String processPath = this._builder.getProcessPath();
                Intrinsics.checkNotNullExpressionValue(processPath, "_builder.getProcessPath()");
                return processPath;
            }

            @JvmName(name = "getStartTime")
            public final long getStartTime() {
                return this._builder.getStartTime();
            }

            public final boolean hasParentProcessName() {
                return this._builder.hasParentProcessName();
            }

            public final boolean hasProcessName() {
                return this._builder.hasProcessName();
            }

            public final boolean hasProcessPath() {
                return this._builder.hasProcessPath();
            }

            public final boolean hasStartTime() {
                return this._builder.hasStartTime();
            }

            @JvmName(name = "setNative")
            public final void setNative(boolean z) {
                this._builder.setNative(z);
            }

            @JvmName(name = "setParentProcessId")
            public final void setParentProcessId(int i) {
                this._builder.setParentProcessId(i);
            }

            @JvmName(name = "setParentProcessName")
            public final void setParentProcessName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setParentProcessName(value);
            }

            @JvmName(name = "setProcessId")
            public final void setProcessId(int i) {
                this._builder.setProcessId(i);
            }

            @JvmName(name = "setProcessName")
            public final void setProcessName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setProcessName(value);
            }

            @JvmName(name = "setProcessPath")
            public final void setProcessPath(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setProcessPath(value);
            }

            @JvmName(name = "setStartTime")
            public final void setStartTime(long j) {
                this._builder.setStartTime(j);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.ProcessInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ProcessInfoKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessorKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ProcessorKt {

        @NotNull
        public static final ProcessorKt INSTANCE = new ProcessorKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0001J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\""}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessorKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor$TypeEncoding;", "encoding", "getEncoding", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor$TypeEncoding;", "setEncoding", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor$TypeEncoding;)V", "", "encodingValue", "getEncodingValue", "()I", "setEncodingValue", "(I)V", "", "subtype", "getSubtype", "()J", "setSubtype", "(J)V", "type", "getType", "setType", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor;", "clearEncoding", "", "clearSubtype", "clearType", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.Processor.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessorKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ProcessorKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Processor$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Processor.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.Processor.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.Processor _build() {
                MobileStacktrace.IOSThreadReport.Processor processorBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(processorBuild, "_builder.build()");
                return processorBuild;
            }

            public final void clearEncoding() {
                this._builder.clearEncoding();
            }

            public final void clearSubtype() {
                this._builder.clearSubtype();
            }

            public final void clearType() {
                this._builder.clearType();
            }

            @JvmName(name = "getEncoding")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Processor.TypeEncoding getEncoding() {
                MobileStacktrace.IOSThreadReport.Processor.TypeEncoding encoding = this._builder.getEncoding();
                Intrinsics.checkNotNullExpressionValue(encoding, "_builder.getEncoding()");
                return encoding;
            }

            @JvmName(name = "getEncodingValue")
            public final int getEncodingValue() {
                return this._builder.getEncodingValue();
            }

            @JvmName(name = "getSubtype")
            public final long getSubtype() {
                return this._builder.getSubtype();
            }

            @JvmName(name = "getType")
            public final long getType() {
                return this._builder.getType();
            }

            @JvmName(name = "setEncoding")
            public final void setEncoding(MobileStacktrace.IOSThreadReport.Processor.TypeEncoding value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setEncoding(value);
            }

            @JvmName(name = "setEncodingValue")
            public final void setEncodingValue(int i) {
                this._builder.setEncodingValue(i);
            }

            @JvmName(name = "setSubtype")
            public final void setSubtype(long j) {
                this._builder.setSubtype(j);
            }

            @JvmName(name = "setType")
            public final void setType(long j) {
                this._builder.setType(j);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Processor.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private ProcessorKt() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt;", "", "()V", "machException", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializemachException", "Dsl", "MachExceptionKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nIOSThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IOSThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2559:1\n1#2:2560\n*E\n"})
    public static final class SignalKt {

        @NotNull
        public static final SignalKt INSTANCE = new SignalKt();

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u0012*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$Builder;)V", "value", "", "address", "getAddress", "()J", "setAddress", "(J)V", "", "code", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "machException", "getMachException", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "setMachException", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;)V", "name", "getName", "setName", "machExceptionOrNull", "getMachExceptionOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal;", "clearAddress", "", "clearCode", "clearMachException", "clearName", "hasMachException", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.Signal.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Signal.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.Signal.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.Signal _build() {
                MobileStacktrace.IOSThreadReport.Signal signalBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(signalBuild, "_builder.build()");
                return signalBuild;
            }

            public final void clearAddress() {
                this._builder.clearAddress();
            }

            public final void clearCode() {
                this._builder.clearCode();
            }

            public final void clearMachException() {
                this._builder.clearMachException();
            }

            public final void clearName() {
                this._builder.clearName();
            }

            @JvmName(name = "getAddress")
            public final long getAddress() {
                return this._builder.getAddress();
            }

            @JvmName(name = "getCode")
            @NotNull
            public final String getCode() {
                String code = this._builder.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "_builder.getCode()");
                return code;
            }

            @JvmName(name = "getMachException")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.Signal.MachException getMachException() {
                MobileStacktrace.IOSThreadReport.Signal.MachException machException = this._builder.getMachException();
                Intrinsics.checkNotNullExpressionValue(machException, "_builder.getMachException()");
                return machException;
            }

            @Nullable
            public final MobileStacktrace.IOSThreadReport.Signal.MachException getMachExceptionOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return IOSThreadReportKtKt.getMachExceptionOrNull(dsl._builder);
            }

            @JvmName(name = "getName")
            @NotNull
            public final String getName() {
                String name = this._builder.getName();
                Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
                return name;
            }

            public final boolean hasMachException() {
                return this._builder.hasMachException();
            }

            @JvmName(name = "setAddress")
            public final void setAddress(long j) {
                this._builder.setAddress(j);
            }

            @JvmName(name = "setCode")
            public final void setCode(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setCode(value);
            }

            @JvmName(name = "setMachException")
            public final void setMachException(MobileStacktrace.IOSThreadReport.Signal.MachException value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setMachException(value);
            }

            @JvmName(name = "setName")
            public final void setName(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setName(value);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Signal.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class MachExceptionKt {

            @NotNull
            public static final MachExceptionKt INSTANCE = new MachExceptionKt();

            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J%\u0010\u0015\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0016J+\u0010\u0017\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0007¢\u0006\u0002\b\u001aJ\u001d\u0010\u001b\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b\u001cJ&\u0010\u001d\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b\u001eJ,\u0010\u001d\u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0087\n¢\u0006\u0002\b\u001fJ.\u0010 \u001a\u00020\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException$Builder;)V", "codes", "Lcom/google/protobuf/kotlin/DslList;", "", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl$CodesProxy;", "getCodes", "()Lcom/google/protobuf/kotlin/DslList;", "value", "type", "getType", "()J", "setType", "(J)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException;", "clearType", "", "add", "addCodes", "addAll", "values", "", "addAllCodes", "clear", "clearCodes", "plusAssign", "plusAssignCodes", "plusAssignAllCodes", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "", "setCodes", "CodesProxy", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            @ProtoDslMarker
            public static final class Dsl {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);

                @NotNull
                private final MobileStacktrace.IOSThreadReport.Signal.MachException.Builder _builder;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl$CodesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class CodesProxy extends DslProxy {
                    private CodesProxy() {
                    }
                }

                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SignalKt$MachExceptionKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Signal$MachException$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    @PublishedApi
                    public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Signal.MachException.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        return new Dsl(builder, null);
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                private Dsl(MobileStacktrace.IOSThreadReport.Signal.MachException.Builder builder) {
                    this._builder = builder;
                }

                @PublishedApi
                public final /* synthetic */ MobileStacktrace.IOSThreadReport.Signal.MachException _build() {
                    MobileStacktrace.IOSThreadReport.Signal.MachException machExceptionBuild = this._builder.build();
                    Intrinsics.checkNotNullExpressionValue(machExceptionBuild, "_builder.build()");
                    return machExceptionBuild;
                }

                @JvmName(name = "addAllCodes")
                public final /* synthetic */ void addAllCodes(DslList dslList, Iterable values) {
                    Intrinsics.checkNotNullParameter(dslList, "<this>");
                    Intrinsics.checkNotNullParameter(values, "values");
                    this._builder.addAllCodes(values);
                }

                @JvmName(name = "addCodes")
                public final /* synthetic */ void addCodes(DslList dslList, long j) {
                    Intrinsics.checkNotNullParameter(dslList, "<this>");
                    this._builder.addCodes(j);
                }

                @JvmName(name = "clearCodes")
                public final /* synthetic */ void clearCodes(DslList dslList) {
                    Intrinsics.checkNotNullParameter(dslList, "<this>");
                    this._builder.clearCodes();
                }

                public final void clearType() {
                    this._builder.clearType();
                }

                public final /* synthetic */ DslList getCodes() {
                    List<Long> codesList = this._builder.getCodesList();
                    Intrinsics.checkNotNullExpressionValue(codesList, "_builder.getCodesList()");
                    return new DslList(codesList);
                }

                @JvmName(name = "getType")
                public final long getType() {
                    return this._builder.getType();
                }

                @JvmName(name = "plusAssignAllCodes")
                public final /* synthetic */ void plusAssignAllCodes(DslList<Long, CodesProxy> dslList, Iterable<Long> values) {
                    Intrinsics.checkNotNullParameter(dslList, "<this>");
                    Intrinsics.checkNotNullParameter(values, "values");
                    addAllCodes(dslList, values);
                }

                @JvmName(name = "plusAssignCodes")
                public final /* synthetic */ void plusAssignCodes(DslList<Long, CodesProxy> dslList, long j) {
                    Intrinsics.checkNotNullParameter(dslList, "<this>");
                    addCodes(dslList, j);
                }

                @JvmName(name = "setCodes")
                public final /* synthetic */ void setCodes(DslList dslList, int i, long j) {
                    Intrinsics.checkNotNullParameter(dslList, "<this>");
                    this._builder.setCodes(i, j);
                }

                @JvmName(name = "setType")
                public final void setType(long j) {
                    this._builder.setType(j);
                }

                public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Signal.MachException.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                    this(builder);
                }
            }

            private MachExceptionKt() {
            }
        }

        private SignalKt() {
        }

        @JvmName(name = "-initializemachException")
        @NotNull
        /* renamed from: -initializemachException, reason: not valid java name */
        public final MobileStacktrace.IOSThreadReport.Signal.MachException m768initializemachException(Function1<? super MachExceptionKt.Dsl, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            MachExceptionKt.Dsl.Companion companion = MachExceptionKt.Dsl.INSTANCE;
            MobileStacktrace.IOSThreadReport.Signal.MachException.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Signal.MachException.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
            MachExceptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
            block.invoke(dsl_create);
            return dsl_create._build();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SystemInfoKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SystemInfoKt {

        @NotNull
        public static final SystemInfoKt INSTANCE = new SystemInfoKt();

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006+"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SystemInfoKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo$OperatingSystem;", "operatingSystem", "getOperatingSystem", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo$OperatingSystem;", "setOperatingSystem", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo$OperatingSystem;)V", "", "operatingSystemValue", "getOperatingSystemValue", "()I", "setOperatingSystemValue", "(I)V", "", "osBuild", "getOsBuild", "()Ljava/lang/String;", "setOsBuild", "(Ljava/lang/String;)V", "osVersion", "getOsVersion", "setOsVersion", "", "timestamp", "getTimestamp", "()J", "setTimestamp", "(J)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo;", "clearOperatingSystem", "", "clearOsBuild", "clearOsVersion", "clearTimestamp", "hasOsBuild", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.SystemInfo.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SystemInfoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$SystemInfoKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$SystemInfo$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.SystemInfo.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.SystemInfo.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.SystemInfo _build() {
                MobileStacktrace.IOSThreadReport.SystemInfo systemInfoBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(systemInfoBuild, "_builder.build()");
                return systemInfoBuild;
            }

            public final void clearOperatingSystem() {
                this._builder.clearOperatingSystem();
            }

            public final void clearOsBuild() {
                this._builder.clearOsBuild();
            }

            public final void clearOsVersion() {
                this._builder.clearOsVersion();
            }

            public final void clearTimestamp() {
                this._builder.clearTimestamp();
            }

            @JvmName(name = "getOperatingSystem")
            @NotNull
            public final MobileStacktrace.IOSThreadReport.SystemInfo.OperatingSystem getOperatingSystem() {
                MobileStacktrace.IOSThreadReport.SystemInfo.OperatingSystem operatingSystem = this._builder.getOperatingSystem();
                Intrinsics.checkNotNullExpressionValue(operatingSystem, "_builder.getOperatingSystem()");
                return operatingSystem;
            }

            @JvmName(name = "getOperatingSystemValue")
            public final int getOperatingSystemValue() {
                return this._builder.getOperatingSystemValue();
            }

            @JvmName(name = "getOsBuild")
            @NotNull
            public final String getOsBuild() {
                String osBuild = this._builder.getOsBuild();
                Intrinsics.checkNotNullExpressionValue(osBuild, "_builder.getOsBuild()");
                return osBuild;
            }

            @JvmName(name = "getOsVersion")
            @NotNull
            public final String getOsVersion() {
                String osVersion = this._builder.getOsVersion();
                Intrinsics.checkNotNullExpressionValue(osVersion, "_builder.getOsVersion()");
                return osVersion;
            }

            @JvmName(name = "getTimestamp")
            public final long getTimestamp() {
                return this._builder.getTimestamp();
            }

            public final boolean hasOsBuild() {
                return this._builder.hasOsBuild();
            }

            @JvmName(name = "setOperatingSystem")
            public final void setOperatingSystem(MobileStacktrace.IOSThreadReport.SystemInfo.OperatingSystem value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setOperatingSystem(value);
            }

            @JvmName(name = "setOperatingSystemValue")
            public final void setOperatingSystemValue(int i) {
                this._builder.setOperatingSystemValue(i);
            }

            @JvmName(name = "setOsBuild")
            public final void setOsBuild(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setOsBuild(value);
            }

            @JvmName(name = "setOsVersion")
            public final void setOsVersion(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setOsVersion(value);
            }

            @JvmName(name = "setTimestamp")
            public final void setTimestamp(long j) {
                this._builder.setTimestamp(j);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.SystemInfo.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        private SystemInfoKt() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt;", "", "()V", "register", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register;", "block", "Lkotlin/Function1;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$RegisterKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeregister", "Dsl", "RegisterKt", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nIOSThreadReportKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IOSThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,2559:1\n1#2:2560\n*E\n"})
    public static final class ThreadKt {

        @NotNull
        public static final ThreadKt INSTANCE = new ThreadKt();

        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0012\b\u0007\u0018\u0000 52\u00020\u0001:\u0003567B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ%\u0010!\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\"J%\u0010!\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0007¢\u0006\u0002\b#J+\u0010$\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070&H\u0007¢\u0006\u0002\b'J+\u0010$\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&H\u0007¢\u0006\u0002\b(J\u001d\u0010)\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\b*J\u001d\u0010)\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0006H\u0007¢\u0006\u0002\b+J&\u0010,\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b-J,\u0010,\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070&H\u0087\n¢\u0006\u0002\b.J&\u0010,\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\n¢\u0006\u0002\b/J,\u0010,\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&H\u0087\n¢\u0006\u0002\b0J.\u00101\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u00102\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\b3J.\u00101\u001a\u00020\u001f*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u00102\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\u0002¢\u0006\u0002\b4R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00168G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00068"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Builder;)V", CommonProperties.FRAMES, "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Frame;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl$FramesProxy;", "getFrames", "()Lcom/google/protobuf/kotlin/DslList;", "value", "", "isCrashingThread", "getIsCrashingThread", "()Z", "setIsCrashingThread", "(Z)V", "registers", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register;", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl$RegistersProxy;", "getRegisters", "", "threadId", "getThreadId", "()I", "setThreadId", "(I)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread;", "clearIsCrashingThread", "", "clearThreadId", "add", "addFrames", "addRegisters", "addAll", "values", "", "addAllFrames", "addAllRegisters", "clear", "clearFrames", "clearRegisters", "plusAssign", "plusAssignFrames", "plusAssignAllFrames", "plusAssignRegisters", "plusAssignAllRegisters", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setFrames", "setRegisters", "Companion", "FramesProxy", "RegistersProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @ProtoDslMarker
        public static final class Dsl {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            @NotNull
            private final MobileStacktrace.IOSThreadReport.Thread.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Thread.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl$FramesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class FramesProxy extends DslProxy {
                private FramesProxy() {
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$Dsl$RegistersProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class RegistersProxy extends DslProxy {
                private RegistersProxy() {
                }
            }

            private Dsl(MobileStacktrace.IOSThreadReport.Thread.Builder builder) {
                this._builder = builder;
            }

            @PublishedApi
            public final /* synthetic */ MobileStacktrace.IOSThreadReport.Thread _build() {
                MobileStacktrace.IOSThreadReport.Thread threadBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(threadBuild, "_builder.build()");
                return threadBuild;
            }

            @JvmName(name = "addAllFrames")
            public final /* synthetic */ void addAllFrames(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllFrames(values);
            }

            @JvmName(name = "addAllRegisters")
            public final /* synthetic */ void addAllRegisters(DslList dslList, Iterable values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                this._builder.addAllRegisters(values);
            }

            @JvmName(name = "addFrames")
            public final /* synthetic */ void addFrames(DslList dslList, MobileStacktrace.IOSThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addFrames(value);
            }

            @JvmName(name = "addRegisters")
            public final /* synthetic */ void addRegisters(DslList dslList, MobileStacktrace.IOSThreadReport.Thread.Register value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.addRegisters(value);
            }

            @JvmName(name = "clearFrames")
            public final /* synthetic */ void clearFrames(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearFrames();
            }

            public final void clearIsCrashingThread() {
                this._builder.clearIsCrashingThread();
            }

            @JvmName(name = "clearRegisters")
            public final /* synthetic */ void clearRegisters(DslList dslList) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                this._builder.clearRegisters();
            }

            public final void clearThreadId() {
                this._builder.clearThreadId();
            }

            public final /* synthetic */ DslList getFrames() {
                List<MobileStacktrace.IOSThreadReport.Frame> framesList = this._builder.getFramesList();
                Intrinsics.checkNotNullExpressionValue(framesList, "_builder.getFramesList()");
                return new DslList(framesList);
            }

            @JvmName(name = "getIsCrashingThread")
            public final boolean getIsCrashingThread() {
                return this._builder.getIsCrashingThread();
            }

            public final /* synthetic */ DslList getRegisters() {
                List<MobileStacktrace.IOSThreadReport.Thread.Register> registersList = this._builder.getRegistersList();
                Intrinsics.checkNotNullExpressionValue(registersList, "_builder.getRegistersList()");
                return new DslList(registersList);
            }

            @JvmName(name = "getThreadId")
            public final int getThreadId() {
                return this._builder.getThreadId();
            }

            @JvmName(name = "plusAssignAllFrames")
            public final /* synthetic */ void plusAssignAllFrames(DslList<MobileStacktrace.IOSThreadReport.Frame, FramesProxy> dslList, Iterable<MobileStacktrace.IOSThreadReport.Frame> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllFrames(dslList, values);
            }

            @JvmName(name = "plusAssignAllRegisters")
            public final /* synthetic */ void plusAssignAllRegisters(DslList<MobileStacktrace.IOSThreadReport.Thread.Register, RegistersProxy> dslList, Iterable<MobileStacktrace.IOSThreadReport.Thread.Register> values) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(values, "values");
                addAllRegisters(dslList, values);
            }

            @JvmName(name = "plusAssignFrames")
            public final /* synthetic */ void plusAssignFrames(DslList<MobileStacktrace.IOSThreadReport.Frame, FramesProxy> dslList, MobileStacktrace.IOSThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addFrames(dslList, value);
            }

            @JvmName(name = "plusAssignRegisters")
            public final /* synthetic */ void plusAssignRegisters(DslList<MobileStacktrace.IOSThreadReport.Thread.Register, RegistersProxy> dslList, MobileStacktrace.IOSThreadReport.Thread.Register value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                addRegisters(dslList, value);
            }

            @JvmName(name = "setFrames")
            public final /* synthetic */ void setFrames(DslList dslList, int i, MobileStacktrace.IOSThreadReport.Frame value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setFrames(i, value);
            }

            @JvmName(name = "setIsCrashingThread")
            public final void setIsCrashingThread(boolean z) {
                this._builder.setIsCrashingThread(z);
            }

            @JvmName(name = "setRegisters")
            public final /* synthetic */ void setRegisters(DslList dslList, int i, MobileStacktrace.IOSThreadReport.Thread.Register value) {
                Intrinsics.checkNotNullParameter(dslList, "<this>");
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setRegisters(i, value);
            }

            @JvmName(name = "setThreadId")
            public final void setThreadId(int i) {
                this._builder.setThreadId(i);
            }

            public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Thread.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$RegisterKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RegisterKt {

            @NotNull
            public static final RegisterKt INSTANCE = new RegisterKt();

            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$RegisterKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register$Builder;)V", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "getValue", "()J", "setValue", "(J)V", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register;", "clearName", "", "clearValue", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            @ProtoDslMarker
            public static final class Dsl {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);

                @NotNull
                private final MobileStacktrace.IOSThreadReport.Thread.Register.Builder _builder;

                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$RegisterKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/IOSThreadReportKt$ThreadKt$RegisterKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport$Thread$Register$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    @PublishedApi
                    public final /* synthetic */ Dsl _create(MobileStacktrace.IOSThreadReport.Thread.Register.Builder builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        return new Dsl(builder, null);
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                private Dsl(MobileStacktrace.IOSThreadReport.Thread.Register.Builder builder) {
                    this._builder = builder;
                }

                @PublishedApi
                public final /* synthetic */ MobileStacktrace.IOSThreadReport.Thread.Register _build() {
                    MobileStacktrace.IOSThreadReport.Thread.Register registerBuild = this._builder.build();
                    Intrinsics.checkNotNullExpressionValue(registerBuild, "_builder.build()");
                    return registerBuild;
                }

                public final void clearName() {
                    this._builder.clearName();
                }

                public final void clearValue() {
                    this._builder.clearValue();
                }

                @JvmName(name = "getName")
                @NotNull
                public final String getName() {
                    String name = this._builder.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
                    return name;
                }

                @JvmName(name = "getValue")
                public final long getValue() {
                    return this._builder.getValue();
                }

                @JvmName(name = "setName")
                public final void setName(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    this._builder.setName(value);
                }

                @JvmName(name = "setValue")
                public final void setValue(long j) {
                    this._builder.setValue(j);
                }

                public /* synthetic */ Dsl(MobileStacktrace.IOSThreadReport.Thread.Register.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                    this(builder);
                }
            }

            private RegisterKt() {
            }
        }

        private ThreadKt() {
        }

        @JvmName(name = "-initializeregister")
        @NotNull
        /* renamed from: -initializeregister, reason: not valid java name */
        public final MobileStacktrace.IOSThreadReport.Thread.Register m769initializeregister(Function1<? super RegisterKt.Dsl, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            RegisterKt.Dsl.Companion companion = RegisterKt.Dsl.INSTANCE;
            MobileStacktrace.IOSThreadReport.Thread.Register.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Thread.Register.newBuilder();
            Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
            RegisterKt.Dsl dsl_create = companion._create(builderNewBuilder);
            block.invoke(dsl_create);
            return dsl_create._build();
        }
    }

    private IOSThreadReportKt() {
    }

    @JvmName(name = "-initializeapplicationInfo")
    @NotNull
    /* renamed from: -initializeapplicationInfo, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.ApplicationInfo m756initializeapplicationInfo(Function1<? super ApplicationInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ApplicationInfoKt.Dsl.Companion companion = ApplicationInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.ApplicationInfo.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.ApplicationInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ApplicationInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializebinary")
    @NotNull
    /* renamed from: -initializebinary, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.Binary m757initializebinary(Function1<? super BinaryKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BinaryKt.Dsl.Companion companion = BinaryKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Binary.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Binary.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        BinaryKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeexception")
    @NotNull
    /* renamed from: -initializeexception, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.Exception m758initializeexception(Function1<? super ExceptionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ExceptionKt.Dsl.Companion companion = ExceptionKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Exception.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Exception.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ExceptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeframe")
    @NotNull
    /* renamed from: -initializeframe, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.Frame m759initializeframe(Function1<? super FrameKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        FrameKt.Dsl.Companion companion = FrameKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Frame.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Frame.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        FrameKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializemachineInfo")
    @NotNull
    /* renamed from: -initializemachineInfo, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.MachineInfo m760initializemachineInfo(Function1<? super MachineInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MachineInfoKt.Dsl.Companion companion = MachineInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.MachineInfo.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.MachineInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        MachineInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeprocessInfo")
    @NotNull
    /* renamed from: -initializeprocessInfo, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.ProcessInfo m761initializeprocessInfo(Function1<? super ProcessInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ProcessInfoKt.Dsl.Companion companion = ProcessInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.ProcessInfo.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.ProcessInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ProcessInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializeprocessor")
    @NotNull
    /* renamed from: -initializeprocessor, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.Processor m762initializeprocessor(Function1<? super ProcessorKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ProcessorKt.Dsl.Companion companion = ProcessorKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Processor.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Processor.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ProcessorKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializesignal")
    @NotNull
    /* renamed from: -initializesignal, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.Signal m763initializesignal(Function1<? super SignalKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SignalKt.Dsl.Companion companion = SignalKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Signal.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Signal.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        SignalKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializesystemInfo")
    @NotNull
    /* renamed from: -initializesystemInfo, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.SystemInfo m764initializesystemInfo(Function1<? super SystemInfoKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SystemInfoKt.Dsl.Companion companion = SystemInfoKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.SystemInfo.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.SystemInfo.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        SystemInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializethread")
    @NotNull
    /* renamed from: -initializethread, reason: not valid java name */
    public final MobileStacktrace.IOSThreadReport.Thread m765initializethread(Function1<? super ThreadKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadKt.Dsl.Companion companion = ThreadKt.Dsl.INSTANCE;
        MobileStacktrace.IOSThreadReport.Thread.Builder builderNewBuilder = MobileStacktrace.IOSThreadReport.Thread.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ThreadKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
