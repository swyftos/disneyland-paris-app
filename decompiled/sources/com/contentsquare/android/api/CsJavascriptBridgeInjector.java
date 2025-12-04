package com.contentsquare.android.api;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.sdk.M0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010\fR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/contentsquare/android/api/CsJavascriptBridgeInjector;", "", "<init>", "()V", "Landroid/webkit/WebView;", "webView", "Lcom/contentsquare/android/sdk/M0;", "jsInterface", "", "jsInterfaceName", "", "injectJavascriptBridge", "(Landroid/webkit/WebView;Lcom/contentsquare/android/sdk/M0;Ljava/lang/String;)V", "serializeJavascriptInterface", "(Lcom/contentsquare/android/sdk/M0;Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "jsBuilder", "addCSJavascriptBridgeObject", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "initializeBridge", "(Landroid/webkit/WebView;Lcom/contentsquare/android/sdk/M0;)V", "Landroid/webkit/WebMessage;", "webMessage", "handleMessage", "(Landroid/webkit/WebMessage;Lcom/contentsquare/android/sdk/M0;)V", "methodName", "Lorg/json/JSONArray;", "jsonArgs", "evaluateMethod", "(Ljava/lang/String;Lorg/json/JSONArray;Lcom/contentsquare/android/sdk/M0;)V", "ensureBridgeInjected", "Lcom/contentsquare/android/core/features/logging/Logger;", "logger$delegate", "Lkotlin/Lazy;", "getLogger", "()Lcom/contentsquare/android/core/features/logging/Logger;", "logger", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class CsJavascriptBridgeInjector {

    @NotNull
    public static final CsJavascriptBridgeInjector INSTANCE = new CsJavascriptBridgeInjector();

    /* renamed from: logger$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy logger = LazyKt.lazy(a.a);

    public static final class a extends Lambda implements Function0<Logger> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Logger invoke() {
            return new Logger("CsJavascriptBridgeInjector");
        }
    }

    private CsJavascriptBridgeInjector() {
    }

    private final void addCSJavascriptBridgeObject(StringBuilder jsBuilder, String jsInterfaceName) {
        jsBuilder.append(StringsKt.trimIndent("\n    var csBridgePort = null;\n    window.addEventListener('message', function(event) {\n        var ports = event.ports;\n        if (Array.isArray(ports) && ports.length > 0 && event.data == 'cs:bridge:initialize') {\n            csBridgePort = ports[0];\n            window.CSJavascriptBridge._sendTemp();\n        }\n    }, false);\n    window." + jsInterfaceName + " = {\n        _tempMessages: [],\n        _sendTemp: function() {\n            if (window.CSJavascriptBridge._tempMessages.length > 0) {\n                for (var message of window.CSJavascriptBridge._tempMessages) {\n                    csBridgePort.postMessage(message);\n                }\n                window.CSJavascriptBridge._tempMessages = [];\n            }\n        },\n        _csCall: function(methodName, methodArgs) {\n            var args = new Array();\n            for (var i = 0; i < methodArgs.length; i++) {\n                args.push(methodArgs[i].toString());\n            }\n            var data = { method: methodName, len: args.length, args: args };\n            var json = JSON.stringify(data);\n            if (csBridgePort) {\n                window.CSJavascriptBridge._sendTemp();\n                csBridgePort.postMessage(json);\n            } else {\n                window.CSJavascriptBridge._tempMessages.push(json);\n            }\n        }\n    };\n"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureBridgeInjected$lambda$0(WebView webView, M0 jsInterface, String jsInterfaceName, String str) {
        Intrinsics.checkNotNullParameter(webView, "$webView");
        Intrinsics.checkNotNullParameter(jsInterface, "$jsInterface");
        Intrinsics.checkNotNullParameter(jsInterfaceName, "$jsInterfaceName");
        if (!TextUtils.isEmpty(str) && !str.equals("undefined") && !str.equals("null")) {
            INSTANCE.getLogger().i("Javascript bridge already injected");
            return;
        }
        CsJavascriptBridgeInjector csJavascriptBridgeInjector = INSTANCE;
        csJavascriptBridgeInjector.getLogger().i("Injecting Javascript bridge");
        csJavascriptBridgeInjector.injectJavascriptBridge(webView, jsInterface, jsInterfaceName);
    }

    private final void evaluateMethod(String methodName, JSONArray jsonArgs, M0 jsInterface) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method[] methods = jsInterface.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "jsInterface.javaClass.methods");
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                int length = jsonArgs.length();
                Object[] objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = jsonArgs.get(i);
                }
                method.setAccessible(true);
                method.invoke(jsInterface, Arrays.copyOf(objArr, length));
                return;
            }
        }
    }

    private final Logger getLogger() {
        return (Logger) logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleMessage(WebMessage webMessage, M0 jsInterface) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String data = webMessage.getData();
        if (TextUtils.isEmpty(data)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(data);
            String methodName = jSONObject.getString("method");
            JSONArray jsonArgs = jSONObject.getJSONArray("args");
            Intrinsics.checkNotNullExpressionValue(methodName, "methodName");
            Intrinsics.checkNotNullExpressionValue(jsonArgs, "jsonArgs");
            evaluateMethod(methodName, jsonArgs, jsInterface);
        } catch (JSONException e) {
            getLogger().e(e.getMessage());
        }
    }

    @SuppressLint({"WebViewApiAvailability"})
    private final void initializeBridge(WebView webView, final M0 jsInterface) {
        WebMessagePort[] webMessagePortArrCreateWebMessageChannel = webView.createWebMessageChannel();
        Intrinsics.checkNotNullExpressionValue(webMessagePortArrCreateWebMessageChannel, "webView.createWebMessageChannel()");
        WebMessagePort webMessagePort = webMessagePortArrCreateWebMessageChannel[0];
        WebMessagePort webMessagePort2 = webMessagePortArrCreateWebMessageChannel[1];
        webMessagePort.setWebMessageCallback(new WebMessagePort.WebMessageCallback() { // from class: com.contentsquare.android.api.CsJavascriptBridgeInjector.initializeBridge.1
            @Override // android.webkit.WebMessagePort.WebMessageCallback
            public void onMessage(@Nullable WebMessagePort port, @Nullable WebMessage message) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
                super.onMessage(port, message);
                if (message != null) {
                    CsJavascriptBridgeInjector.INSTANCE.handleMessage(message, jsInterface);
                }
            }
        });
        webView.postWebMessage(new WebMessage("cs:bridge:initialize", new WebMessagePort[]{webMessagePort2}), Uri.EMPTY);
    }

    private final void injectJavascriptBridge(WebView webView, M0 jsInterface, String jsInterfaceName) {
        String str = "javascript: " + serializeJavascriptInterface(jsInterface, jsInterfaceName);
        InstrumentationCallbacks.loadUrlCalled(webView);
        webView.loadUrl(str);
        initializeBridge(webView, jsInterface);
    }

    private final String serializeJavascriptInterface(M0 jsInterface, String jsInterfaceName) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        addCSJavascriptBridgeObject(sb2, jsInterfaceName);
        Method[] methods = jsInterface.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "jsInterface.javaClass.methods");
        for (Method method : methods) {
            if (method.isAnnotationPresent(JavascriptInterface.class)) {
                String name = method.getName();
                Object string = null;
                if (Intrinsics.areEqual(name, "getVersion")) {
                    string = method.invoke(jsInterface, null);
                } else if (Intrinsics.areEqual(name, "getAssetTransformerMode") && (objInvoke = method.invoke(jsInterface, null)) != null) {
                    string = objInvoke.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("window." + jsInterfaceName);
                sb3.append(InstructionFileId.DOT);
                sb3.append(method.getName());
                sb3.append(" = function() { this._csCall('");
                sb3.append(method.getName());
                sb3.append("', arguments);");
                if (string != null) {
                    if (string instanceof Number) {
                        sb = new StringBuilder(" return ");
                        sb.append(string);
                        sb.append(';');
                    } else {
                        sb = new StringBuilder(" return '");
                        sb.append(string);
                        sb.append("';");
                    }
                    sb3.append(sb.toString());
                }
                sb3.append(" };");
                sb2.append((CharSequence) sb3);
            }
        }
        sb2.append("console.log('CSLIB JS Bridge Injected', JSON.stringify(window." + jsInterfaceName + "));");
        String string2 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "jsBuilder.toString()");
        return string2;
    }

    public final void ensureBridgeInjected(@NotNull final WebView webView, @NotNull final M0 jsInterface, @NotNull final String jsInterfaceName) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(jsInterface, "jsInterface");
        Intrinsics.checkNotNullParameter(jsInterfaceName, "jsInterfaceName");
        webView.evaluateJavascript("window." + jsInterfaceName, new ValueCallback() { // from class: com.contentsquare.android.api.CsJavascriptBridgeInjector$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                CsJavascriptBridgeInjector.ensureBridgeInjected$lambda$0(webView, jsInterface, jsInterfaceName, (String) obj);
            }
        });
    }
}
