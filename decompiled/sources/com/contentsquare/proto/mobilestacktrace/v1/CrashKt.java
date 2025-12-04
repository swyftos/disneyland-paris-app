package com.contentsquare.proto.mobilestacktrace.v1;

import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrashKt {

    @NotNull
    public static final CrashKt INSTANCE = new CrashKt();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010-\u001a\u00020.H\u0001J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u000200J\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u000200J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000206R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0017\u0010'\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0017\u0010*\u001a\u0004\u0018\u00010!*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00069"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash$Builder;", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash$Builder;)V", "value", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "context", "getContext", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "setContext", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;)V", "", "crashId", "getCrashId", "()J", "setCrashId", "(J)V", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$OS;", "os", "getOs", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$OS;", "setOs", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$OS;)V", "", "osValue", "getOsValue", "()I", "setOsValue", "(I)V", "relativeTime", "getRelativeTime", "setRelativeTime", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "threadReport", "getThreadReport", "()Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "setThreadReport", "(Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;)V", "contextOrNull", "getContextOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "threadReportOrNull", "getThreadReportOrNull", "(Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt$Dsl;)Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "_build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "clearContext", "", "clearCrashId", "clearOs", "clearRelativeTime", "clearThreadReport", "hasContext", "", "hasThreadReport", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final MobileStacktrace.Crash.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/mobilestacktrace/v1/CrashKt$Dsl;", "builder", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(MobileStacktrace.Crash.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(MobileStacktrace.Crash.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ MobileStacktrace.Crash _build() {
            MobileStacktrace.Crash crashBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(crashBuild, "_builder.build()");
            return crashBuild;
        }

        public final void clearContext() {
            this._builder.clearContext();
        }

        public final void clearCrashId() {
            this._builder.clearCrashId();
        }

        public final void clearOs() {
            this._builder.clearOs();
        }

        public final void clearRelativeTime() {
            this._builder.clearRelativeTime();
        }

        public final void clearThreadReport() {
            this._builder.clearThreadReport();
        }

        @JvmName(name = "getContext")
        @NotNull
        public final MobileStacktrace.Context getContext() {
            MobileStacktrace.Context context = this._builder.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "_builder.getContext()");
            return context;
        }

        @Nullable
        public final MobileStacktrace.Context getContextOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return CrashKtKt.getContextOrNull(dsl._builder);
        }

        @JvmName(name = "getCrashId")
        public final long getCrashId() {
            return this._builder.getCrashId();
        }

        @JvmName(name = "getOs")
        @NotNull
        public final MobileStacktrace.OS getOs() {
            MobileStacktrace.OS os = this._builder.getOs();
            Intrinsics.checkNotNullExpressionValue(os, "_builder.getOs()");
            return os;
        }

        @JvmName(name = "getOsValue")
        public final int getOsValue() {
            return this._builder.getOsValue();
        }

        @JvmName(name = "getRelativeTime")
        public final long getRelativeTime() {
            return this._builder.getRelativeTime();
        }

        @JvmName(name = "getThreadReport")
        @NotNull
        public final MobileStacktrace.ThreadReport getThreadReport() {
            MobileStacktrace.ThreadReport threadReport = this._builder.getThreadReport();
            Intrinsics.checkNotNullExpressionValue(threadReport, "_builder.getThreadReport()");
            return threadReport;
        }

        @Nullable
        public final MobileStacktrace.ThreadReport getThreadReportOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return CrashKtKt.getThreadReportOrNull(dsl._builder);
        }

        public final boolean hasContext() {
            return this._builder.hasContext();
        }

        public final boolean hasThreadReport() {
            return this._builder.hasThreadReport();
        }

        @JvmName(name = "setContext")
        public final void setContext(MobileStacktrace.Context value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setContext(value);
        }

        @JvmName(name = "setCrashId")
        public final void setCrashId(long j) {
            this._builder.setCrashId(j);
        }

        @JvmName(name = "setOs")
        public final void setOs(MobileStacktrace.OS value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOs(value);
        }

        @JvmName(name = "setOsValue")
        public final void setOsValue(int i) {
            this._builder.setOsValue(i);
        }

        @JvmName(name = "setRelativeTime")
        public final void setRelativeTime(long j) {
            this._builder.setRelativeTime(j);
        }

        @JvmName(name = "setThreadReport")
        public final void setThreadReport(MobileStacktrace.ThreadReport value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setThreadReport(value);
        }

        public /* synthetic */ Dsl(MobileStacktrace.Crash.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private CrashKt() {
    }
}
