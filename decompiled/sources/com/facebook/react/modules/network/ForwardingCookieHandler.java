package com.facebook.react.modules.network;

import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J=\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bH\u0096\u0002J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bH\u0016J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u001c\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\nJ\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/facebook/react/modules/network/ForwardingCookieHandler;", "Ljava/net/CookieHandler;", "<init>", "()V", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "get", "", "", "", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Ljava/net/URI;", "headers", "put", "", "clearCookies", "callback", "Lcom/facebook/react/bridge/Callback;", "destroy", "addCookies", "url", "cookies", "addCookieAsync", "cookie", "cookieManager", "Landroid/webkit/CookieManager;", "getCookieManager", "()Landroid/webkit/CookieManager;", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ForwardingCookieHandler extends CookieHandler {

    @NotNull
    private static final String COOKIE_HEADER = "Cookie";

    @NotNull
    private static final Companion Companion = new Companion(null);

    @NotNull
    private static final String VERSION_ONE_HEADER = "Set-cookie2";

    @NotNull
    private static final String VERSION_ZERO_HEADER = "Set-cookie";

    @Nullable
    private CookieManager cookieManager;

    public final void destroy() {
    }

    public ForwardingCookieHandler() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use the default constructor", replaceWith = @ReplaceWith(expression = "ForwardingCookieHandler()", imports = {}))
    public ForwardingCookieHandler(@NotNull ReactContext reactContext) {
        this();
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @Override // java.net.CookieHandler
    @NotNull
    public Map<String, List<String>> get(@NotNull URI uri, @NotNull Map<String, ? extends List<String>> headers) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        CookieManager cookieManager = getCookieManager();
        String cookie = cookieManager != null ? cookieManager.getCookie(uri.toString()) : null;
        if (cookie == null || cookie.length() == 0) {
            return MapsKt.emptyMap();
        }
        return MapsKt.mapOf(TuplesKt.to("Cookie", CollectionsKt.listOf(cookie)));
    }

    @Override // java.net.CookieHandler
    public void put(@NotNull URI uri, @NotNull Map<String, ? extends List<String>> headers) throws IOException {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(headers, "headers");
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        for (Map.Entry<String, ? extends List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (Companion.isCookieHeader(key)) {
                addCookies(string, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCookies$lambda$0(Callback callback, Boolean bool) {
        callback.invoke(bool);
    }

    public final void clearCookies(@NotNull final Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.removeAllCookies(new ValueCallback() { // from class: com.facebook.react.modules.network.ForwardingCookieHandler$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    ForwardingCookieHandler.clearCookies$lambda$0(callback, (Boolean) obj);
                }
            });
        }
    }

    public final void addCookies(@NotNull String url, @NotNull List<String> cookies) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Iterator<String> it = cookies.iterator();
        while (it.hasNext()) {
            addCookieAsync(url, it.next());
        }
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.flush();
        }
    }

    private final void addCookieAsync(String url, String cookie) {
        CookieManager cookieManager = getCookieManager();
        if (cookieManager != null) {
            cookieManager.setCookie(url, cookie, null);
        }
    }

    private final CookieManager getCookieManager() {
        if (this.cookieManager == null) {
            try {
                this.cookieManager = CookieManager.getInstance();
            } catch (IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.cookieManager;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/react/modules/network/ForwardingCookieHandler$Companion;", "", "<init>", "()V", "VERSION_ZERO_HEADER", "", "VERSION_ONE_HEADER", "COOKIE_HEADER", "isCookieHeader", "", "name", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isCookieHeader(String name) {
            return StringsKt.equals(name, ForwardingCookieHandler.VERSION_ZERO_HEADER, true) || StringsKt.equals(name, ForwardingCookieHandler.VERSION_ONE_HEADER, true);
        }
    }
}
