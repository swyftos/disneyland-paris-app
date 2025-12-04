package com.contentsquare.android.api;

import android.app.Application;
import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.NetworkInfoProvider;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.internal.features.initialize.CsRuntimeModule;
import com.contentsquare.android.sdk.M4;
import com.contentsquare.android.sdk.P8;
import com.contentsquare.android.sdk.Q8;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001e\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010!\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b$\u0010\"J\u000f\u0010'\u001a\u00020\rH\u0001¢\u0006\u0004\b&\u0010\u0014R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/contentsquare/android/api/CsWebViewTagInjector;", "", "", "tagId", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "userId", "Lcom/contentsquare/android/sdk/Q8;", "tagDownloader", "Lcom/contentsquare/android/core/system/NetworkInfoProvider;", "networkProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/contentsquare/android/sdk/Q8;Lcom/contentsquare/android/core/system/NetworkInfoProvider;)V", "Lkotlin/Function0;", "", "onTagDownloaded", "Lkotlin/Function1;", "onFetchLocalTag", "downloadTrackingTag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "sendTelemetry", "()V", "", "isLocal", "sendInjectionTelemetry", "(Z)V", "Landroid/webkit/WebView;", "view", "tagData", "injectLocalTag$library_release", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "injectLocalTag", "injectRemoteTag$library_release", "injectRemoteTag", "injectTag", "(Landroid/webkit/WebView;)V", "webView", "addWebViewFlag$library_release", "addWebViewFlag", "logTagNotAvailable$library_release", "logTagNotAvailable", "Ljava/lang/String;", "Lcom/contentsquare/android/sdk/Q8;", "Lcom/contentsquare/android/core/system/NetworkInfoProvider;", "Lcom/contentsquare/android/core/features/logging/Logger;", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "Companion", "library_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class CsWebViewTagInjector {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final Logger logger;

    @Nullable
    private final NetworkInfoProvider networkProvider;

    @NotNull
    private final String packageName;

    @NotNull
    private final Q8 tagDownloader;

    @Nullable
    private final String tagId;

    @Nullable
    private final String userId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/android/api/CsWebViewTagInjector$Companion;", "", "()V", "provideNetworkProvider", "Lcom/contentsquare/android/core/system/NetworkInfoProvider;", "provideTagId", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCsWebViewTagInjector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CsWebViewTagInjector.kt\ncom/contentsquare/android/api/CsWebViewTagInjector$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NetworkInfoProvider provideNetworkProvider() {
            Application application;
            CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
            Context baseContext = (csApplicationModule == null || (application = csApplicationModule.getApplication()) == null) ? null : application.getBaseContext();
            if (baseContext != null) {
                return new NetworkInfoProvider(baseContext, null, null, 6, null);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String provideTagId() {
            JsonConfig.ProjectConfiguration projectConfig;
            JsonConfig.WebView webView;
            CoreModule companion = CoreModule.INSTANCE.getInstance();
            Configuration configuration = companion != null ? companion.getConfiguration() : null;
            if (configuration == null || (projectConfig = configuration.getProjectConfig()) == null || (webView = projectConfig.getWebView()) == null) {
                return null;
            }
            return webView.getTagId();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Unit> {
        public a(Object obj) {
            super(0, obj, CsWebViewTagInjector.class, "logTagNotAvailable", "logTagNotAvailable$library_release()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((CsWebViewTagInjector) this.receiver).logTagNotAvailable$library_release();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WebView b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebView webView, String str) {
            super(0);
            this.b = webView;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            CsWebViewTagInjector.this.injectRemoteTag$library_release(this.b, this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ WebView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WebView webView) {
            super(1);
            this.b = webView;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(String str) {
            String data = str;
            Intrinsics.checkNotNullParameter(data, "data");
            CsWebViewTagInjector.this.injectLocalTag$library_release(this.b, data);
            return Unit.INSTANCE;
        }
    }

    public CsWebViewTagInjector() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addWebViewFlag$lambda$3(String str) {
    }

    private final void downloadTrackingTag(String tagId, Function0<Unit> onTagDownloaded, Function1<? super String, Unit> onFetchLocalTag) {
        Q8 q8 = this.tagDownloader;
        String packageName = this.packageName;
        String str = this.userId;
        a onTagNotAvailable = new a(this);
        q8.getClass();
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(onTagDownloaded, "onDownloaded");
        Intrinsics.checkNotNullParameter(onFetchLocalTag, "onFetchLocalTag");
        Intrinsics.checkNotNullParameter(onTagNotAvailable, "onTagNotAvailable");
        BuildersKt__Builders_commonKt.launch$default(q8.d, null, null, new P8(q8, tagId, str, packageName, onTagNotAvailable, onFetchLocalTag, onTagDownloaded, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void injectLocalTag$lambda$0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void injectRemoteTag$lambda$1(String str) {
    }

    private final void sendInjectionTelemetry(boolean isLocal) {
        ConnectionType connectionType;
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("injectionType", isLocal ? ImagesContract.LOCAL : "remote"));
        NetworkInfoProvider networkInfoProvider = this.networkProvider;
        mapMutableMapOf.put("connectionType", String.valueOf((networkInfoProvider == null || (connectionType = networkInfoProvider.getConnectionType()) == null) ? -1 : connectionType.getValue()));
        Telemetry.INSTANCE.collect$library_release("tag_injection", mapMutableMapOf);
    }

    public static /* synthetic */ void sendInjectionTelemetry$default(CsWebViewTagInjector csWebViewTagInjector, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        csWebViewTagInjector.sendInjectionTelemetry(z);
    }

    private final void sendTelemetry() {
        ConnectionType connectionType;
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("tagAvailable", String.valueOf(this.tagId != null)));
        NetworkInfoProvider networkInfoProvider = this.networkProvider;
        mapMutableMapOf.put("connectionType", String.valueOf((networkInfoProvider == null || (connectionType = networkInfoProvider.getConnectionType()) == null) ? -1 : connectionType.getValue()));
        Telemetry.INSTANCE.collect$library_release("tag_injection", mapMutableMapOf);
    }

    public final void addWebViewFlag$library_release(@Nullable WebView webView) {
        if (webView != null) {
            webView.evaluateJavascript("window.CS_isWebView = true;", new ValueCallback() { // from class: com.contentsquare.android.api.CsWebViewTagInjector$$ExternalSyntheticLambda0
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    CsWebViewTagInjector.addWebViewFlag$lambda$3((String) obj);
                }
            });
        }
    }

    public final void injectLocalTag$library_release(@Nullable WebView view, @NotNull String tagData) {
        Intrinsics.checkNotNullParameter(tagData, "tagData");
        this.logger.p("Injecting local tag into the WebView");
        sendInjectionTelemetry(true);
        addWebViewFlag$library_release(view);
        if (view != null) {
            view.evaluateJavascript("\n            if (!Array.from(document.getElementsByTagName(\"script\")).some(script => {\n            const src = script.src;\n            return src && src.includes(\"contentsquare.net\") && /t.*\\\\.contentsquare\\\\.net/.test(src);\n        })) {\n            window._uxa = window._uxa || [];           \n            window._uxa.push(['setOption', 'isWebView', true]);\n            " + tagData + "\n        }", new ValueCallback() { // from class: com.contentsquare.android.api.CsWebViewTagInjector$$ExternalSyntheticLambda2
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    CsWebViewTagInjector.injectLocalTag$lambda$0((String) obj);
                }
            });
        }
    }

    public final void injectRemoteTag$library_release(@Nullable WebView view, @NotNull String tagId) {
        Intrinsics.checkNotNullParameter(tagId, "tagId");
        this.logger.p("Injecting tag into the WebView");
        sendInjectionTelemetry(false);
        addWebViewFlag$library_release(view);
        if (view != null) {
            view.evaluateJavascript("(function () {\n    window._uxa = window._uxa || [];\n    window._uxa.push(['setOption', 'isWebView', true]);\n\n    var newScriptSrc = \"https://t.contentsquare.net/uxa/" + tagId + ".js\";\n    // match any subdomain of contentsquare.net in the old script's src\n    var oldScriptRegex = /https?:\\/\\/.*\\.contentsquare\\.net\\/wvt\\/web-view\\.js/;\n\n    var scripts = document.getElementsByTagName(\"script\");\n\n    // Remove old script if it matches the regex\n    for (var i = 0; i < scripts.length; i++) {\n        if (oldScriptRegex.test(scripts[i].src)) {\n            scripts[i].parentNode.removeChild(scripts[i]);\n            break; // Assuming there's only one instance of the old script\n        }\n    }\n\n    // Check if new script already exists\n    var scriptExists = Array.from(scripts).some(script => script.src === newScriptSrc);\n\n    // Inject new script if it doesn't exist\n    if (!scriptExists) {\n        var mt = document.createElement(\"script\");\n        mt.type = \"text/javascript\";\n        mt.async = true;\n        mt.src = newScriptSrc;\n        document.getElementsByTagName(\"head\")[0].appendChild(mt);\n    }\n})();", new ValueCallback() { // from class: com.contentsquare.android.api.CsWebViewTagInjector$$ExternalSyntheticLambda1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    CsWebViewTagInjector.injectRemoteTag$lambda$1((String) obj);
                }
            });
        }
    }

    public final void injectTag(@Nullable WebView view) {
        Unit unit;
        String str = this.tagId;
        if (str != null) {
            if (str.length() <= 0 || Intrinsics.areEqual(str, "null")) {
                logTagNotAvailable$library_release();
            } else {
                downloadTrackingTag(str, new b(view, str), new c(view));
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            logTagNotAvailable$library_release();
        }
    }

    @VisibleForTesting
    public final void logTagNotAvailable$library_release() {
        this.logger.p("Tracking tag is null or not available!");
        sendTelemetry();
    }

    public CsWebViewTagInjector(@Nullable String str, @NotNull String packageName, @Nullable String str2, @NotNull Q8 tagDownloader, @Nullable NetworkInfoProvider networkInfoProvider) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(tagDownloader, "tagDownloader");
        this.tagId = str;
        this.packageName = packageName;
        this.userId = str2;
        this.tagDownloader = tagDownloader;
        this.networkProvider = networkInfoProvider;
        this.logger = new Logger("CsWebViewTagInjector");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CsWebViewTagInjector(String str, String str2, String str3, Q8 q8, NetworkInfoProvider networkInfoProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        M4 runTime;
        Application application;
        str = (i & 1) != 0 ? INSTANCE.provideTagId() : str;
        String str4 = null;
        if ((i & 2) != 0) {
            CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
            str2 = (csApplicationModule == null || (application = csApplicationModule.getApplication()) == null) ? null : application.getPackageName();
            if (str2 == null) {
                str2 = "";
            }
        }
        String str5 = str2;
        if ((i & 4) == 0) {
            str4 = str3;
        } else {
            CsRuntimeModule csRuntimeModule = CsRuntimeModule.getInstance();
            if (csRuntimeModule != null && (runTime = csRuntimeModule.getRunTime()) != null) {
                str3 = runTime.a();
                str4 = str3;
            }
        }
        this(str, str5, str4, (i & 8) != 0 ? new Q8() : q8, (i & 16) != 0 ? INSTANCE.provideNetworkProvider() : networkInfoProvider);
    }
}
