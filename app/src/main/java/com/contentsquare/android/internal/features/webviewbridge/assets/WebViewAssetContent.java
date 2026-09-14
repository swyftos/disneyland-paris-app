package com.contentsquare.android.internal.features.webviewbridge.assets;

import android.util.Base64;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.C2599Q2;
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

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class WebViewAssetContent {

    @NotNull
    public static final C2430a Companion = new C2430a();

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Logger f1354d = new Logger("WebViewAssetContent");

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1355a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f1356b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final byte[] f1357c;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent$a */
    public static final class C2430a {
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
            PluginExceptionsKt.throwMissingFieldException(i, 3, WebViewAssetContent$$serializer.f1358a);
        }
        this.f1355a = str;
        this.f1356b = str2;
        if ((i & 4) != 0) {
            this.f1357c = bArr;
            return;
        }
        try {
            bArrDecode = Base64.decode(str2, 0);
        } catch (IllegalArgumentException e) {
            C2599Q2.m1011a(f1354d, "Cannot decode Base64 data", e);
            bArrDecode = null;
        }
        this.f1357c = bArrDecode;
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ void m848a(WebViewAssetContent webViewAssetContent, CompositeEncoder compositeEncoder, PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        byte[] bArrDecode;
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 0, webViewAssetContent.f1355a);
        compositeEncoder.encodeStringElement(pluginGeneratedSerialDescriptor, 1, webViewAssetContent.f1356b);
        if (!compositeEncoder.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 2)) {
            byte[] bArr = webViewAssetContent.f1357c;
            try {
                bArrDecode = Base64.decode(webViewAssetContent.f1356b, 0);
            } catch (IllegalArgumentException e) {
                C2599Q2.m1011a(f1354d, "Cannot decode Base64 data", e);
                bArrDecode = null;
            }
            if (Intrinsics.areEqual(bArr, bArrDecode)) {
                return;
            }
        }
        compositeEncoder.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, ByteArraySerializer.INSTANCE, webViewAssetContent.f1357c);
    }

    public WebViewAssetContent(@NotNull String data) {
        byte[] bArrDecode;
        Intrinsics.checkNotNullParameter("text/css", "mimeType");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f1355a = "text/css";
        this.f1356b = data;
        try {
            bArrDecode = Base64.decode(data, 0);
        } catch (IllegalArgumentException e) {
            C2599Q2.m1011a(f1354d, "Cannot decode Base64 data", e);
            bArrDecode = null;
        }
        this.f1357c = bArrDecode;
    }
}
