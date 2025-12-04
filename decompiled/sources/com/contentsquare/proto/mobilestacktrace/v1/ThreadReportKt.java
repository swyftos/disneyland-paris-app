package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ThreadReportKt {

    @NotNull
    public static final ThreadReportKt INSTANCE = new ThreadReportKt();

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010(\u001a\u00020)H\u0001J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u0006\u0010/\u001a\u00020+J\u0006\u00100\u001a\u00020+J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000202R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00068"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;", "android", "getAndroid", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;", "setAndroid", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$AndroidThreadReport;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;", "emptyReport", "getEmptyReport", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;", "setEmptyReport", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$EmptyThreadReport;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "flutter", "getFlutter", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "setFlutter", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;", "ios", "getIos", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;", "setIos", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$IOSThreadReport;)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;", "reactNative", "getReactNative", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;", "setReactNative", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ReactNativeThreadReport;)V", "reportCase", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport$ReportCase;", "getReportCase", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport$ReportCase;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "clearAndroid", "", "clearEmptyReport", "clearFlutter", "clearIos", "clearReactNative", "clearReport", "hasAndroid", "", "hasEmptyReport", "hasFlutter", "hasIos", "hasReactNative", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.ThreadReport.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.ThreadReport.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(MobileStacktrace.ThreadReport.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.ThreadReport _build() {
            MobileStacktrace.ThreadReport threadReportBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(threadReportBuild, "_builder.build()");
            return threadReportBuild;
        }

        public final void clearAndroid() {
            this._builder.clearAndroid();
        }

        public final void clearEmptyReport() {
            this._builder.clearEmptyReport();
        }

        public final void clearFlutter() {
            this._builder.clearFlutter();
        }

        public final void clearIos() {
            this._builder.clearIos();
        }

        public final void clearReactNative() {
            this._builder.clearReactNative();
        }

        public final void clearReport() {
            this._builder.clearReport();
        }

        @JvmName(name = "getAndroid")
        @NotNull
        public final MobileStacktrace.AndroidThreadReport getAndroid() {
            MobileStacktrace.AndroidThreadReport android2 = this._builder.getAndroid();
            Intrinsics.checkNotNullExpressionValue(android2, "_builder.getAndroid()");
            return android2;
        }

        @JvmName(name = "getEmptyReport")
        @NotNull
        public final MobileStacktrace.EmptyThreadReport getEmptyReport() {
            MobileStacktrace.EmptyThreadReport emptyReport = this._builder.getEmptyReport();
            Intrinsics.checkNotNullExpressionValue(emptyReport, "_builder.getEmptyReport()");
            return emptyReport;
        }

        @JvmName(name = "getFlutter")
        @NotNull
        public final MobileStacktrace.FlutterThreadReport getFlutter() {
            MobileStacktrace.FlutterThreadReport flutter = this._builder.getFlutter();
            Intrinsics.checkNotNullExpressionValue(flutter, "_builder.getFlutter()");
            return flutter;
        }

        @JvmName(name = "getIos")
        @NotNull
        public final MobileStacktrace.IOSThreadReport getIos() {
            MobileStacktrace.IOSThreadReport ios = this._builder.getIos();
            Intrinsics.checkNotNullExpressionValue(ios, "_builder.getIos()");
            return ios;
        }

        @JvmName(name = "getReactNative")
        @NotNull
        public final MobileStacktrace.ReactNativeThreadReport getReactNative() {
            MobileStacktrace.ReactNativeThreadReport reactNative = this._builder.getReactNative();
            Intrinsics.checkNotNullExpressionValue(reactNative, "_builder.getReactNative()");
            return reactNative;
        }

        @JvmName(name = "getReportCase")
        @NotNull
        public final MobileStacktrace.ThreadReport.ReportCase getReportCase() {
            MobileStacktrace.ThreadReport.ReportCase reportCase = this._builder.getReportCase();
            Intrinsics.checkNotNullExpressionValue(reportCase, "_builder.getReportCase()");
            return reportCase;
        }

        public final boolean hasAndroid() {
            return this._builder.hasAndroid();
        }

        public final boolean hasEmptyReport() {
            return this._builder.hasEmptyReport();
        }

        public final boolean hasFlutter() {
            return this._builder.hasFlutter();
        }

        public final boolean hasIos() {
            return this._builder.hasIos();
        }

        public final boolean hasReactNative() {
            return this._builder.hasReactNative();
        }

        @JvmName(name = "setAndroid")
        public final void setAndroid(MobileStacktrace.AndroidThreadReport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setAndroid(value);
        }

        @JvmName(name = "setEmptyReport")
        public final void setEmptyReport(MobileStacktrace.EmptyThreadReport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEmptyReport(value);
        }

        @JvmName(name = "setFlutter")
        public final void setFlutter(MobileStacktrace.FlutterThreadReport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFlutter(value);
        }

        @JvmName(name = "setIos")
        public final void setIos(MobileStacktrace.IOSThreadReport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setIos(value);
        }

        @JvmName(name = "setReactNative")
        public final void setReactNative(MobileStacktrace.ReactNativeThreadReport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReactNative(value);
        }

        public /* synthetic */ Dsl(MobileStacktrace.ThreadReport.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private ThreadReportKt() {
    }
}
