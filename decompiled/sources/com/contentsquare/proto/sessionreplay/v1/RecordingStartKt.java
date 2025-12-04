package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/RecordingStartKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordingStartKt {

    @NotNull
    public static final RecordingStartKt INSTANCE = new RecordingStartKt();

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0001J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/RecordingStartKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart$Builder;)V", "value", "", "isNewSession", "getIsNewSession", "()Z", "setIsNewSession", "(Z)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart$StartReason;", "startReason", "getStartReason", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart$StartReason;", "setStartReason", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart$StartReason;)V", "", "startReasonValue", "getStartReasonValue", "()I", "setStartReasonValue", "(I)V", "", "unixTimestampMs", "getUnixTimestampMs", "()J", "setUnixTimestampMs", "(J)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart;", "clearIsNewSession", "", "clearStartReason", "clearUnixTimestampMs", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.RecordingStart.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/RecordingStartKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/RecordingStartKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$RecordingStart$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.RecordingStart.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.RecordingStart.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.RecordingStart _build() {
            SessionRecordingV1.RecordingStart recordingStartBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(recordingStartBuild, "_builder.build()");
            return recordingStartBuild;
        }

        public final void clearIsNewSession() {
            this._builder.clearIsNewSession();
        }

        public final void clearStartReason() {
            this._builder.clearStartReason();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        @JvmName(name = "getIsNewSession")
        public final boolean getIsNewSession() {
            return this._builder.getIsNewSession();
        }

        @JvmName(name = "getStartReason")
        @NotNull
        public final SessionRecordingV1.RecordingStart.StartReason getStartReason() {
            SessionRecordingV1.RecordingStart.StartReason startReason = this._builder.getStartReason();
            Intrinsics.checkNotNullExpressionValue(startReason, "_builder.getStartReason()");
            return startReason;
        }

        @JvmName(name = "getStartReasonValue")
        public final int getStartReasonValue() {
            return this._builder.getStartReasonValue();
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        @JvmName(name = "setIsNewSession")
        public final void setIsNewSession(boolean z) {
            this._builder.setIsNewSession(z);
        }

        @JvmName(name = "setStartReason")
        public final void setStartReason(SessionRecordingV1.RecordingStart.StartReason value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStartReason(value);
        }

        @JvmName(name = "setStartReasonValue")
        public final void setStartReasonValue(int i) {
            this._builder.setStartReasonValue(i);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.RecordingStart.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private RecordingStartKt() {
    }
}
