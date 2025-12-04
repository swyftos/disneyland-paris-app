package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/StyleMutationKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StyleMutationKt {

    @NotNull
    public static final StyleMutationKt INSTANCE = new StyleMutationKt();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/StyleMutationKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation$Builder;)V", "value", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "styleChanges", "getStyleChanges", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "setStyleChanges", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;)V", "", "unixTimestampMs", "getUnixTimestampMs", "()J", "setUnixTimestampMs", "(J)V", "viewId", "getViewId", "setViewId", "styleChangesOrNull", "getStyleChangesOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/StyleMutationKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation;", "clearStyleChanges", "", "clearUnixTimestampMs", "clearViewId", "hasStyleChanges", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.StyleMutation.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/StyleMutationKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/StyleMutationKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$StyleMutation$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.StyleMutation.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.StyleMutation.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.StyleMutation _build() {
            SessionRecordingV1.StyleMutation styleMutationBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(styleMutationBuild, "_builder.build()");
            return styleMutationBuild;
        }

        public final void clearStyleChanges() {
            this._builder.clearStyleChanges();
        }

        public final void clearUnixTimestampMs() {
            this._builder.clearUnixTimestampMs();
        }

        public final void clearViewId() {
            this._builder.clearViewId();
        }

        @JvmName(name = "getStyleChanges")
        @NotNull
        public final SessionRecordingV1.ViewStyle getStyleChanges() {
            SessionRecordingV1.ViewStyle styleChanges = this._builder.getStyleChanges();
            Intrinsics.checkNotNullExpressionValue(styleChanges, "_builder.getStyleChanges()");
            return styleChanges;
        }

        @Nullable
        public final SessionRecordingV1.ViewStyle getStyleChangesOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return StyleMutationKtKt.getStyleChangesOrNull(dsl._builder);
        }

        @JvmName(name = "getUnixTimestampMs")
        public final long getUnixTimestampMs() {
            return this._builder.getUnixTimestampMs();
        }

        @JvmName(name = "getViewId")
        public final long getViewId() {
            return this._builder.getViewId();
        }

        public final boolean hasStyleChanges() {
            return this._builder.hasStyleChanges();
        }

        @JvmName(name = "setStyleChanges")
        public final void setStyleChanges(SessionRecordingV1.ViewStyle value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setStyleChanges(value);
        }

        @JvmName(name = "setUnixTimestampMs")
        public final void setUnixTimestampMs(long j) {
            this._builder.setUnixTimestampMs(j);
        }

        @JvmName(name = "setViewId")
        public final void setViewId(long j) {
            this._builder.setViewId(j);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.StyleMutation.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private StyleMutationKt() {
    }
}
