package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.facebook.react.uimanager.ViewProps;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewShadowKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewShadowKt {

    @NotNull
    public static final ViewShadowKt INSTANCE = new ViewShadowKt();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewShadowKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow$Builder;)V", "value", "", "offsetX", "getOffsetX", "()F", "setOffsetX", "(F)V", "offsetY", "getOffsetY", "setOffsetY", ViewProps.OPACITY, "getOpacity", "setOpacity", "radius", "getRadius", "setRadius", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "clearOffsetX", "", "clearOffsetY", "clearOpacity", "clearRadius", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.ViewShadow.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewShadowKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/ViewShadowKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.ViewShadow.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.ViewShadow.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.ViewShadow _build() {
            SessionRecordingV1.ViewShadow viewShadowBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(viewShadowBuild, "_builder.build()");
            return viewShadowBuild;
        }

        public final void clearOffsetX() {
            this._builder.clearOffsetX();
        }

        public final void clearOffsetY() {
            this._builder.clearOffsetY();
        }

        public final void clearOpacity() {
            this._builder.clearOpacity();
        }

        public final void clearRadius() {
            this._builder.clearRadius();
        }

        @JvmName(name = "getOffsetX")
        public final float getOffsetX() {
            return this._builder.getOffsetX();
        }

        @JvmName(name = "getOffsetY")
        public final float getOffsetY() {
            return this._builder.getOffsetY();
        }

        @JvmName(name = "getOpacity")
        public final float getOpacity() {
            return this._builder.getOpacity();
        }

        @JvmName(name = "getRadius")
        public final float getRadius() {
            return this._builder.getRadius();
        }

        @JvmName(name = "setOffsetX")
        public final void setOffsetX(float f) {
            this._builder.setOffsetX(f);
        }

        @JvmName(name = "setOffsetY")
        public final void setOffsetY(float f) {
            this._builder.setOffsetY(f);
        }

        @JvmName(name = "setOpacity")
        public final void setOpacity(float f) {
            this._builder.setOpacity(f);
        }

        @JvmName(name = "setRadius")
        public final void setRadius(float f) {
            this._builder.setRadius(f);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.ViewShadow.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private ViewShadowKt() {
    }
}
