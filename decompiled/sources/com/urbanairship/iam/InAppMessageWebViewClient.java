package com.urbanairship.iam;

import android.webkit.WebView;
import androidx.annotation.CallSuper;
import com.urbanairship.javascript.JavaScriptEnvironment;
import com.urbanairship.javascript.NativeBridge;
import com.urbanairship.json.JsonMap;
import com.urbanairship.webkit.AirshipWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0015R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/InAppMessageWebViewClient;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "messageExtras", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "nativeBridge", "Lcom/urbanairship/javascript/NativeBridge;", "extras", "(Lcom/urbanairship/javascript/NativeBridge;Lcom/urbanairship/json/JsonMap;)V", "extendJavascriptEnvironment", "Lcom/urbanairship/javascript/JavaScriptEnvironment$Builder;", "builder", "webView", "Landroid/webkit/WebView;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public class InAppMessageWebViewClient extends AirshipWebViewClient {
    private final JsonMap messageExtras;

    public InAppMessageWebViewClient(@Nullable JsonMap jsonMap) {
        this.messageExtras = jsonMap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageWebViewClient(@NotNull NativeBridge nativeBridge, @Nullable JsonMap jsonMap) {
        super(nativeBridge);
        Intrinsics.checkNotNullParameter(nativeBridge, "nativeBridge");
        this.messageExtras = jsonMap;
    }

    @Override // com.urbanairship.webkit.AirshipWebViewClient
    @CallSuper
    @NotNull
    protected JavaScriptEnvironment.Builder extendJavascriptEnvironment(@NotNull JavaScriptEnvironment.Builder builder, @NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(webView, "webView");
        JavaScriptEnvironment.Builder builderAddGetter = super.extendJavascriptEnvironment(builder, webView).addGetter("getMessageExtras", this.messageExtras);
        Intrinsics.checkNotNullExpressionValue(builderAddGetter, "addGetter(...)");
        return builderAddGetter;
    }
}
