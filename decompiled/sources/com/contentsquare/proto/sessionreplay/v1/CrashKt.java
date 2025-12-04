package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CrashKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CrashKt {

    @NotNull
    public static final CrashKt INSTANCE = new CrashKt();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\""}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CrashKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash$Builder;)V", "value", "", "crashId", "getCrashId", "()J", "setCrashId", "(J)V", "", "errorSource", "getErrorSource", "()Ljava/lang/String;", "setErrorSource", "(Ljava/lang/String;)V", "relativeTime", "getRelativeTime", "setRelativeTime", "unixTimestampMs", "getUnixTimestampMs", "setUnixTimestampMs", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash;", "clearCrashId", "", "clearErrorSource", "clearRelativeTime", "clearUnixTimestampMs", "hasErrorSource", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.Crash.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/CrashKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/CrashKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$Crash$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.Crash.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.Crash.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.Crash _build() {
            SessionRecordingV1.Crash crashBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(crashBuild, "_builder.build()");
            return crashBuild;
        }

        public final void clearCrashId() {
            this._builder.clearCrashId();
        }

        public final void clearErrorSource() {
            this._builder.clearErrorSource();
        }

        public final void clearRelativeTime() {
            this._builder.clearRelativeTime();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        @JvmName(name = "getCrashId")
        public final long getCrashId() {
            return this._builder.getCrashId();
        }

        @JvmName(name = "getErrorSource")
        @NotNull
        public final String getErrorSource() {
            String errorSource = this._builder.getErrorSource();
            Intrinsics.checkNotNullExpressionValue(errorSource, "_builder.getErrorSource()");
            return errorSource;
        }

        @JvmName(name = "getRelativeTime")
        public final long getRelativeTime() {
            return this._builder.getRelativeTime();
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        public final boolean hasErrorSource() {
            return this._builder.hasErrorSource();
        }

        @JvmName(name = "setCrashId")
        public final void setCrashId(long j) {
            this._builder.setCrashId(j);
        }

        @JvmName(name = "setErrorSource")
        public final void setErrorSource(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setErrorSource(value);
        }

        @JvmName(name = "setRelativeTime")
        public final void setRelativeTime(long j) {
            this._builder.setRelativeTime(j);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.Crash.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private CrashKt() {
    }
}
