package com.contentsquare.android.internal.features.webviewbridge.assets;

import android.util.Base64;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.Q2;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class WebViewAssetContent {

    @NotNull
    public static final a Companion = new a();

    @NotNull
    public static final Logger d = new Logger("WebViewAssetContent");

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    @Nullable
    public final byte[] c;

    public static final class a {
        @NotNull
        public final KSerializer<WebViewAssetContent> serializer() {
            return WebViewAssetContent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public WebViewAssetContent(int i, String str, String str2, byte[] bArr) {
        byte[] bArrDecode;
        if (3 != (i & 3)) {
            WebViewAssetContent$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, WebViewAssetContent$$serializer.a);
        }
        this.a = str;
        this.b = str2;
        if ((i & 4) != 0) {
            this.c = bArr;
            return;
        }
        try {
            bArrDecode = Base64.decode(str2, 0);
        } catch (IllegalArgumentException e) {
            Q2.a(d, "Cannot decode Base64 data", e);
            bArrDecode = null;
        }
        this.c = bArrDecode;
    }

    @JvmStatic
    public static final /* synthetic */ void a(WebViewAssetContent webViewAssetContent, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        byte[] bArrDecode;
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, webViewAssetContent.a);
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 1, webViewAssetContent.b);
        if (!compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 2)) {
            byte[] bArr = webViewAssetContent.c;
            try {
                bArrDecode = Base64.decode(webViewAssetContent.b, 0);
            } catch (IllegalArgumentException e) {
                Q2.a(d, "Cannot decode Base64 data", e);
                bArrDecode = null;
            }
            if (Intrinsics.areEqual(bArr, bArrDecode)) {
                return;
            }
        }
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, ByteArraySerializer.INSTANCE, webViewAssetContent.c);
    }

    public WebViewAssetContent(@NotNull String data) {
        byte[] bArrDecode;
        Intrinsics.checkNotNullParameter("text/css", "mimeType");
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = "text/css";
        this.b = data;
        try {
            bArrDecode = Base64.decode(data, 0);
        } catch (IllegalArgumentException e) {
            Q2.a(d, "Cannot decode Base64 data", e);
            bArrDecode = null;
        }
        this.c = bArrDecode;
    }
}
