package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ProtoDslMarker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewStyleKt {

    @NotNull
    public static final ViewStyleKt INSTANCE = new ViewStyleKt();

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b,\b\u0007\u0018\u0000 \u009f\u00012\u00020\u0001:\u0002\u009f\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010q\u001a\u00020rH\u0001J\u0006\u0010s\u001a\u00020tJ\u0006\u0010u\u001a\u00020tJ\u0006\u0010v\u001a\u00020tJ\u0006\u0010w\u001a\u00020tJ\u0006\u0010x\u001a\u00020tJ\u0006\u0010y\u001a\u00020tJ\u0006\u0010z\u001a\u00020tJ\u0006\u0010{\u001a\u00020tJ\u0006\u0010|\u001a\u00020tJ\u0006\u0010}\u001a\u00020tJ\u0006\u0010~\u001a\u00020tJ\u0006\u0010\u007f\u001a\u00020tJ\u0007\u0010\u0080\u0001\u001a\u00020tJ\u0007\u0010\u0081\u0001\u001a\u00020tJ\u0007\u0010\u0082\u0001\u001a\u00020tJ\u0007\u0010\u0083\u0001\u001a\u00020tJ\u0007\u0010\u0084\u0001\u001a\u00020tJ\u0007\u0010\u0085\u0001\u001a\u00020tJ\u0007\u0010\u0086\u0001\u001a\u00020tJ\u0007\u0010\u0087\u0001\u001a\u00020tJ\u0007\u0010\u0088\u0001\u001a\u00020tJ\u0007\u0010\u0089\u0001\u001a\u00020tJ\u0007\u0010\u008a\u0001\u001a\u00020\u001bJ\u0007\u0010\u008b\u0001\u001a\u00020\u001bJ\u0007\u0010\u008c\u0001\u001a\u00020\u001bJ\u0007\u0010\u008d\u0001\u001a\u00020\u001bJ\u0007\u0010\u008e\u0001\u001a\u00020\u001bJ\u0007\u0010\u008f\u0001\u001a\u00020\u001bJ\u0007\u0010\u0090\u0001\u001a\u00020\u001bJ\u0007\u0010\u0091\u0001\u001a\u00020\u001bJ\u0007\u0010\u0092\u0001\u001a\u00020\u001bJ\u0007\u0010\u0093\u0001\u001a\u00020\u001bJ\u0007\u0010\u0094\u0001\u001a\u00020\u001bJ\u0007\u0010\u0095\u0001\u001a\u00020\u001bJ\u0007\u0010\u0096\u0001\u001a\u00020\u001bJ\u0007\u0010\u0097\u0001\u001a\u00020\u001bJ\u0007\u0010\u0098\u0001\u001a\u00020\u001bJ\u0007\u0010\u0099\u0001\u001a\u00020\u001bJ\u0007\u0010\u009a\u0001\u001a\u00020\u001bJ\u0007\u0010\u009b\u0001\u001a\u00020\u001bJ\u0007\u0010\u009c\u0001\u001a\u00020\u001bJ\u0007\u0010\u009d\u0001\u001a\u00020\u001bJ\u0007\u0010\u009e\u0001\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010'\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R$\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR$\u0010-\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R$\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u0002008G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R$\u00109\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R$\u0010<\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001b8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R$\u0010?\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R$\u0010C\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020B8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010H\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R$\u0010K\u001a\u0002002\u0006\u0010\u0005\u001a\u0002008G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u00103\"\u0004\bM\u00105R$\u0010O\u001a\u00020N2\u0006\u0010\u0005\u001a\u00020N8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u00020T2\u0006\u0010\u0005\u001a\u00020T8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010Z\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010$\"\u0004\b\\\u0010&R$\u0010]\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010$\"\u0004\b_\u0010&R$\u0010`\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020!8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010$\"\u0004\bb\u0010&R$\u0010c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\t\"\u0004\be\u0010\u000bR\u0017\u0010f\u001a\u0004\u0018\u000100*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0017\u0010i\u001a\u0004\u0018\u000100*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bj\u0010hR\u0017\u0010k\u001a\u0004\u0018\u00010N*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0017\u0010n\u001a\u0004\u0018\u00010T*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bo\u0010p¨\u0006 \u0001"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle$Builder;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "", "backgroundColorHex", "getBackgroundColorHex", "()Ljava/lang/String;", "setBackgroundColorHex", "(Ljava/lang/String;)V", "Lcom/google/protobuf/ByteString;", "bitmap", "getBitmap", "()Lcom/google/protobuf/ByteString;", "setBitmap", "(Lcom/google/protobuf/ByteString;)V", "bitmapHash", "getBitmapHash", "setBitmapHash", "", "clipChildren", "getClipChildren", "()Z", "setClipChildren", "(Z)V", "", "contentOffsetX", "getContentOffsetX", "()I", "setContentOffsetX", "(I)V", "contentOffsetY", "getContentOffsetY", "setContentOffsetY", "cornerRadius", "getCornerRadius", "setCornerRadius", "height", "getHeight", "setHeight", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;", "htmlText", "getHtmlText", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;", "setHtmlText", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;)V", "interactionEnabled", "getInteractionEnabled", "setInteractionEnabled", "isBlur", "getIsBlur", "setIsBlur", "isVisible", "getIsVisible", "setIsVisible", "keyboardType", "getKeyboardType", "setKeyboardType", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle$Placeholder;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "getPlaceholder", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle$Placeholder;", "setPlaceholder", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle$Placeholder;)V", "placeholderValue", "getPlaceholderValue", "setPlaceholderValue", "serializedText", "getSerializedText", "setSerializedText", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "shadow", "getShadow", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "setShadow", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;)V", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;", "text", "getText", "()Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;", "setText", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "z", "getZ", "setZ", "htmlTextOrNull", "getHtmlTextOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;", "serializedTextOrNull", "getSerializedTextOrNull", "shadowOrNull", "getShadowOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewShadow;", "textOrNull", "getTextOrNull", "(Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl;)Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewText;", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle;", "clearAlpha", "", "clearBackgroundColorHex", "clearBitmap", "clearBitmapHash", "clearClipChildren", "clearContentOffsetX", "clearContentOffsetY", "clearCornerRadius", "clearHeight", "clearHtmlText", "clearInteractionEnabled", "clearIsBlur", "clearIsVisible", "clearKeyboardType", "clearPlaceholder", "clearSerializedText", "clearShadow", "clearText", "clearWidth", "clearX", "clearY", "clearZ", "hasAlpha", "hasBackgroundColorHex", "hasBitmap", "hasBitmapHash", "hasClipChildren", "hasContentOffsetX", "hasContentOffsetY", "hasCornerRadius", "hasHeight", "hasHtmlText", "hasIsBlur", "hasIsVisible", "hasKeyboardType", "hasPlaceholder", "hasSerializedText", "hasShadow", "hasText", "hasWidth", "hasX", "hasY", "hasZ", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.ViewStyle.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/ViewStyleKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewStyle$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.ViewStyle.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Dsl(SessionRecordingV1.ViewStyle.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.ViewStyle _build() {
            SessionRecordingV1.ViewStyle viewStyleBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(viewStyleBuild, "_builder.build()");
            return viewStyleBuild;
        }

        public final void clearAlpha() {
            this._builder.clearAlpha();
        }

        public final void clearBackgroundColorHex() {
            this._builder.clearBackgroundColorHex();
        }

        public final void clearBitmap() {
            this._builder.clearBitmap();
        }

        public final void clearBitmapHash() {
            this._builder.clearBitmapHash();
        }

        public final void clearClipChildren() {
            this._builder.clearClipChildren();
        }

        public final void clearContentOffsetX() {
            this._builder.clearContentOffsetX();
        }

        public final void clearContentOffsetY() {
            this._builder.clearContentOffsetY();
        }

        public final void clearCornerRadius() {
            this._builder.clearCornerRadius();
        }

        public final void clearHeight() {
            this._builder.clearHeight();
        }

        public final void clearHtmlText() {
            this._builder.clearHtmlText();
        }

        public final void clearInteractionEnabled() {
            this._builder.clearInteractionEnabled();
        }

        public final void clearIsBlur() {
            this._builder.clearIsBlur();
        }

        public final void clearIsVisible() {
            this._builder.clearIsVisible();
        }

        public final void clearKeyboardType() {
            this._builder.clearKeyboardType();
        }

        public final void clearPlaceholder() {
            this._builder.clearPlaceholder();
        }

        public final void clearSerializedText() {
            this._builder.clearSerializedText();
        }

        public final void clearShadow() {
            this._builder.clearShadow();
        }

        public final void clearText() {
            this._builder.clearText();
        }

        public final void clearWidth() {
            this._builder.clearWidth();
        }

        public final void clearX() {
            this._builder.clearX();
        }

        public final void clearY() {
            this._builder.clearY();
        }

        public final void clearZ() {
            this._builder.clearZ();
        }

        @JvmName(name = "getAlpha")
        public final float getAlpha() {
            return this._builder.getAlpha();
        }

        @JvmName(name = "getBackgroundColorHex")
        @NotNull
        public final String getBackgroundColorHex() {
            String backgroundColorHex = this._builder.getBackgroundColorHex();
            Intrinsics.checkNotNullExpressionValue(backgroundColorHex, "_builder.getBackgroundColorHex()");
            return backgroundColorHex;
        }

        @JvmName(name = "getBitmap")
        @NotNull
        public final ByteString getBitmap() {
            ByteString bitmap = this._builder.getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "_builder.getBitmap()");
            return bitmap;
        }

        @JvmName(name = "getBitmapHash")
        @NotNull
        public final String getBitmapHash() {
            String bitmapHash = this._builder.getBitmapHash();
            Intrinsics.checkNotNullExpressionValue(bitmapHash, "_builder.getBitmapHash()");
            return bitmapHash;
        }

        @JvmName(name = "getClipChildren")
        public final boolean getClipChildren() {
            return this._builder.getClipChildren();
        }

        @JvmName(name = "getContentOffsetX")
        public final int getContentOffsetX() {
            return this._builder.getContentOffsetX();
        }

        @JvmName(name = "getContentOffsetY")
        public final int getContentOffsetY() {
            return this._builder.getContentOffsetY();
        }

        @JvmName(name = "getCornerRadius")
        public final float getCornerRadius() {
            return this._builder.getCornerRadius();
        }

        @JvmName(name = "getHeight")
        public final int getHeight() {
            return this._builder.getHeight();
        }

        @JvmName(name = "getHtmlText")
        @NotNull
        public final SessionRecordingV1.ViewHtmlText getHtmlText() {
            SessionRecordingV1.ViewHtmlText htmlText = this._builder.getHtmlText();
            Intrinsics.checkNotNullExpressionValue(htmlText, "_builder.getHtmlText()");
            return htmlText;
        }

        @Nullable
        public final SessionRecordingV1.ViewHtmlText getHtmlTextOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ViewStyleKtKt.getHtmlTextOrNull(dsl._builder);
        }

        @JvmName(name = "getInteractionEnabled")
        public final boolean getInteractionEnabled() {
            return this._builder.getInteractionEnabled();
        }

        @JvmName(name = "getIsBlur")
        public final boolean getIsBlur() {
            return this._builder.getIsBlur();
        }

        @JvmName(name = "getIsVisible")
        public final boolean getIsVisible() {
            return this._builder.getIsVisible();
        }

        @JvmName(name = "getKeyboardType")
        @NotNull
        public final String getKeyboardType() {
            String keyboardType = this._builder.getKeyboardType();
            Intrinsics.checkNotNullExpressionValue(keyboardType, "_builder.getKeyboardType()");
            return keyboardType;
        }

        @JvmName(name = "getPlaceholder")
        @NotNull
        public final SessionRecordingV1.ViewStyle.Placeholder getPlaceholder() {
            SessionRecordingV1.ViewStyle.Placeholder placeholder = this._builder.getPlaceholder();
            Intrinsics.checkNotNullExpressionValue(placeholder, "_builder.getPlaceholder()");
            return placeholder;
        }

        @JvmName(name = "getPlaceholderValue")
        public final int getPlaceholderValue() {
            return this._builder.getPlaceholderValue();
        }

        @JvmName(name = "getSerializedText")
        @NotNull
        public final SessionRecordingV1.ViewHtmlText getSerializedText() {
            SessionRecordingV1.ViewHtmlText serializedText = this._builder.getSerializedText();
            Intrinsics.checkNotNullExpressionValue(serializedText, "_builder.getSerializedText()");
            return serializedText;
        }

        @Nullable
        public final SessionRecordingV1.ViewHtmlText getSerializedTextOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ViewStyleKtKt.getSerializedTextOrNull(dsl._builder);
        }

        @JvmName(name = "getShadow")
        @NotNull
        public final SessionRecordingV1.ViewShadow getShadow() {
            SessionRecordingV1.ViewShadow shadow = this._builder.getShadow();
            Intrinsics.checkNotNullExpressionValue(shadow, "_builder.getShadow()");
            return shadow;
        }

        @Nullable
        public final SessionRecordingV1.ViewShadow getShadowOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ViewStyleKtKt.getShadowOrNull(dsl._builder);
        }

        @JvmName(name = "getText")
        @NotNull
        public final SessionRecordingV1.ViewText getText() {
            SessionRecordingV1.ViewText text = this._builder.getText();
            Intrinsics.checkNotNullExpressionValue(text, "_builder.getText()");
            return text;
        }

        @Nullable
        public final SessionRecordingV1.ViewText getTextOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return ViewStyleKtKt.getTextOrNull(dsl._builder);
        }

        @JvmName(name = "getWidth")
        public final int getWidth() {
            return this._builder.getWidth();
        }

        @JvmName(name = "getX")
        public final int getX() {
            return this._builder.getX();
        }

        @JvmName(name = "getY")
        public final int getY() {
            return this._builder.getY();
        }

        @JvmName(name = "getZ")
        public final float getZ() {
            return this._builder.getZ();
        }

        public final boolean hasAlpha() {
            return this._builder.hasAlpha();
        }

        public final boolean hasBackgroundColorHex() {
            return this._builder.hasBackgroundColorHex();
        }

        public final boolean hasBitmap() {
            return this._builder.hasBitmap();
        }

        public final boolean hasBitmapHash() {
            return this._builder.hasBitmapHash();
        }

        public final boolean hasClipChildren() {
            return this._builder.hasClipChildren();
        }

        public final boolean hasContentOffsetX() {
            return this._builder.hasContentOffsetX();
        }

        public final boolean hasContentOffsetY() {
            return this._builder.hasContentOffsetY();
        }

        public final boolean hasCornerRadius() {
            return this._builder.hasCornerRadius();
        }

        public final boolean hasHeight() {
            return this._builder.hasHeight();
        }

        public final boolean hasHtmlText() {
            return this._builder.hasHtmlText();
        }

        public final boolean hasIsBlur() {
            return this._builder.hasIsBlur();
        }

        public final boolean hasIsVisible() {
            return this._builder.hasIsVisible();
        }

        public final boolean hasKeyboardType() {
            return this._builder.hasKeyboardType();
        }

        public final boolean hasPlaceholder() {
            return this._builder.hasPlaceholder();
        }

        public final boolean hasSerializedText() {
            return this._builder.hasSerializedText();
        }

        public final boolean hasShadow() {
            return this._builder.hasShadow();
        }

        public final boolean hasText() {
            return this._builder.hasText();
        }

        public final boolean hasWidth() {
            return this._builder.hasWidth();
        }

        public final boolean hasX() {
            return this._builder.hasX();
        }

        public final boolean hasY() {
            return this._builder.hasY();
        }

        public final boolean hasZ() {
            return this._builder.hasZ();
        }

        @JvmName(name = "setAlpha")
        public final void setAlpha(float f) {
            this._builder.setAlpha(f);
        }

        @JvmName(name = "setBackgroundColorHex")
        public final void setBackgroundColorHex(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setBackgroundColorHex(value);
        }

        @JvmName(name = "setBitmap")
        public final void setBitmap(ByteString value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setBitmap(value);
        }

        @JvmName(name = "setBitmapHash")
        public final void setBitmapHash(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setBitmapHash(value);
        }

        @JvmName(name = "setClipChildren")
        public final void setClipChildren(boolean z) {
            this._builder.setClipChildren(z);
        }

        @JvmName(name = "setContentOffsetX")
        public final void setContentOffsetX(int i) {
            this._builder.setContentOffsetX(i);
        }

        @JvmName(name = "setContentOffsetY")
        public final void setContentOffsetY(int i) {
            this._builder.setContentOffsetY(i);
        }

        @JvmName(name = "setCornerRadius")
        public final void setCornerRadius(float f) {
            this._builder.setCornerRadius(f);
        }

        @JvmName(name = "setHeight")
        public final void setHeight(int i) {
            this._builder.setHeight(i);
        }

        @JvmName(name = "setHtmlText")
        public final void setHtmlText(SessionRecordingV1.ViewHtmlText value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setHtmlText(value);
        }

        @JvmName(name = "setInteractionEnabled")
        public final void setInteractionEnabled(boolean z) {
            this._builder.setInteractionEnabled(z);
        }

        @JvmName(name = "setIsBlur")
        public final void setIsBlur(boolean z) {
            this._builder.setIsBlur(z);
        }

        @JvmName(name = "setIsVisible")
        public final void setIsVisible(boolean z) {
            this._builder.setIsVisible(z);
        }

        @JvmName(name = "setKeyboardType")
        public final void setKeyboardType(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setKeyboardType(value);
        }

        @JvmName(name = "setPlaceholder")
        public final void setPlaceholder(SessionRecordingV1.ViewStyle.Placeholder value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPlaceholder(value);
        }

        @JvmName(name = "setPlaceholderValue")
        public final void setPlaceholderValue(int i) {
            this._builder.setPlaceholderValue(i);
        }

        @JvmName(name = "setSerializedText")
        public final void setSerializedText(SessionRecordingV1.ViewHtmlText value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSerializedText(value);
        }

        @JvmName(name = "setShadow")
        public final void setShadow(SessionRecordingV1.ViewShadow value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setShadow(value);
        }

        @JvmName(name = "setText")
        public final void setText(SessionRecordingV1.ViewText value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setText(value);
        }

        @JvmName(name = "setWidth")
        public final void setWidth(int i) {
            this._builder.setWidth(i);
        }

        @JvmName(name = "setX")
        public final void setX(int i) {
            this._builder.setX(i);
        }

        @JvmName(name = "setY")
        public final void setY(int i) {
            this._builder.setY(i);
        }

        @JvmName(name = "setZ")
        public final void setZ(float f) {
            this._builder.setZ(f);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.ViewStyle.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private ViewStyleKt() {
    }
}
