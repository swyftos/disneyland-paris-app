package com.contentsquare.android.internal.features.webviewbridge.assets;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import java.security.MessageDigest;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class WebViewAsset {

    @NotNull
    public static final c Companion = new c();

    @NotNull
    public static final List<String> h = CollectionsKt.listOf((Object[]) new String[]{"http", "https"});

    @NotNull
    public static final Lazy<MessageDigest> i = LazyKt.lazy(b.a);

    @NotNull
    public static final Logger j = new Logger("WebViewAsset");

    @JvmField
    @NotNull
    public static final KSerializer<Object>[] k = {null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.AssetType", a.values()), null};

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    @NotNull
    public final String c;

    @Nullable
    public WebViewAssetContent d;

    @Nullable
    public final String e;

    @NotNull
    public final a f;

    @Nullable
    public String g;

    public enum a {
        DATA_CSS,
        DATA,
        REMOTE,
        UNSUPPORTED
    }

    public static final class b extends Lambda implements Function0<MessageDigest> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final MessageDigest invoke() {
            return MessageDigest.getInstance("SHA-256");
        }
    }

    public static final class c {
        @NotNull
        public final KSerializer<WebViewAsset> serializer() {
            return WebViewAsset$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public WebViewAsset(int i2, @SerialName("assetId") String str, @SerialName("assetRawPath") String str2, @SerialName("assetBasePath") String str3, @SerialName("retrievedAssetContent") WebViewAssetContent webViewAssetContent, String str4, a aVar, String str5) {
        String hexString;
        byte[] bArr;
        if (7 != (i2 & 7)) {
            WebViewAsset$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i2, 7, WebViewAsset$$serializer.a);
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        if ((i2 & 8) == 0) {
            this.d = null;
        } else {
            this.d = webViewAssetContent;
        }
        if ((i2 & 16) == 0) {
            WebViewAssetContent webViewAssetContent2 = this.d;
            if (webViewAssetContent2 == null || (bArr = webViewAssetContent2.c) == null) {
                hexString = null;
            } else {
                Companion.getClass();
                MessageDigest value = i.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-hashMessageDigest>(...)");
                byte[] bArrDigest = value.digest(bArr);
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "hashMessageDigest.digest(it)");
                hexString = ExtensionsKt.toHexString(bArrDigest);
            }
            this.e = hexString;
        } else {
            this.e = str4;
        }
        if ((i2 & 32) == 0) {
            this.f = b() ? a.DATA_CSS : a() ? a.DATA : c() ? a.REMOTE : a.UNSUPPORTED;
        } else {
            this.f = aVar;
        }
        if ((i2 & 64) == 0) {
            this.g = null;
        } else {
            this.g = str5;
        }
    }

    public final boolean a() {
        return (this.d == null && this.e == null) ? false : true;
    }

    public final boolean b() {
        if (!a()) {
            return false;
        }
        WebViewAssetContent webViewAssetContent = this.d;
        return Intrinsics.areEqual(webViewAssetContent != null ? webViewAssetContent.a : null, "text/css") || StringsKt.endsWith$default(this.a, ".css", false, 2, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c() {
        /*
            r7 = this;
            boolean r0 = r7.a()
            r1 = 0
            if (r0 != 0) goto L5d
            java.lang.String r7 = r7.a
            r0 = 1
            if (r7 == 0) goto L59
            kotlin.text.Regex r2 = new kotlin.text.Regex
            java.lang.String r3 = "^(.*?)://([^:/]+)(?:\\d+)?"
            r2.<init>(r3)
            r3 = 2
            r4 = 0
            kotlin.text.MatchResult r2 = kotlin.text.Regex.find$default(r2, r7, r1, r3, r4)
            if (r2 == 0) goto L28
            java.util.List r2 = r2.getGroupValues()
            if (r2 == 0) goto L28
            java.lang.Object r2 = kotlin.collections.CollectionsKt.getOrNull(r2, r0)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
        L28:
            if (r4 == 0) goto L59
            java.util.List<java.lang.String> r2 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.h
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r3 = r4.toLowerCase(r3)
            java.lang.String r5 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L5a
            com.contentsquare.android.core.features.logging.Logger r3 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.j
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Unsupported scheme found: "
            r5.<init>(r6)
            r5.append(r4)
            java.lang.String r4 = " in "
            r5.append(r4)
            r5.append(r7)
            java.lang.String r7 = r5.toString()
            r3.w(r7)
            goto L5a
        L59:
            r2 = r1
        L5a:
            if (r2 == 0) goto L5d
            r1 = r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.c():boolean");
    }

    public WebViewAsset(@NotNull String id, @NotNull String rawPath, @NotNull String basePath, @Nullable WebViewAssetContent webViewAssetContent) {
        String hexString;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rawPath, "rawPath");
        Intrinsics.checkNotNullParameter(basePath, "basePath");
        this.a = id;
        this.b = rawPath;
        this.c = basePath;
        this.d = webViewAssetContent;
        byte[] bArr = webViewAssetContent.c;
        if (bArr != null) {
            Companion.getClass();
            MessageDigest value = i.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-hashMessageDigest>(...)");
            byte[] bArrDigest = value.digest(bArr);
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "hashMessageDigest.digest(it)");
            hexString = ExtensionsKt.toHexString(bArrDigest);
        } else {
            hexString = null;
        }
        this.e = hexString;
        this.f = b() ? a.DATA_CSS : a() ? a.DATA : c() ? a.REMOTE : a.UNSUPPORTED;
    }
}
