package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.autofill.HintConstants;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.google.common.net.HttpHeaders;
import com.urbanairship.actions.RateAppAction;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b:\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0082\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\u0007J\u0018\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010\u0007J\u0010\u0010'\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001eH\u0002J\u0018\u0010(\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0010J\u000e\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001eJ\u000e\u0010+\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001eJ\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-\u0018\u00010EJ\u001e\u0010F\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IJ\u0018\u0010J\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010K\u001a\u0004\u0018\u00010\u0007J\u0016\u0010L\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\u0003J\n\u0010N\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010O\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010P\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010Q\u001a\u0004\u0018\u00010\u0010J\u001a\u0010R\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010Q\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010S\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010T\u001a\u0004\u0018\u00010\u0007J\u0016\u0010U\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0016\u0010W\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0018\u0010X\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010Y\u001a\u0004\u0018\u00010\u0007J\u0018\u0010Z\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010T\u001a\u0004\u0018\u00010\u0007J\u0016\u0010[\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010\\\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0018\u0010]\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010T\u001a\u0004\u0018\u00010\u0007J\u0016\u0010^\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010_\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010`\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010a\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010b\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010c\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010d\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0016\u0010e\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010f\u001a\u00020\u0003J\u0016\u0010g\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010h\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0018\u0010i\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010j\u001a\u0004\u0018\u00010\u0007J\u0018\u0010k\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010l\u001a\u0004\u0018\u00010\u0007J\u0016\u0010m\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0010\u0010n\u001a\u00020!2\b\u0010T\u001a\u0004\u0018\u00010\u0007J\u0016\u0010o\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0016\u0010p\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0010\u0010q\u001a\u00020!2\b\u0010T\u001a\u0004\u0018\u00010\u0007J\u0016\u0010r\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010s\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020-J\u0016\u0010t\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0018\u0010u\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010T\u001a\u0004\u0018\u00010IJ\u0016\u0010v\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0018\u0010w\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\b\u0010x\u001a\u0004\u0018\u00010\u0007J\u0016\u0010y\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010z\u001a\u00020\u0003J\u0016\u0010{\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010|\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010}\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010~\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010\u007f\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020-J\u0017\u0010\u0080\u0001\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0017\u0010\u0081\u0001\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0014\u00102\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0014\u00104\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0014\u00106\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0014\u00108\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0014\u0010:\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010/R\u0014\u0010<\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u0014\u0010>\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u0014\u0010@\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0014\u0010B\u001a\u00020-X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bC\u0010/¨\u0006\u0083\u0001"}, d2 = {"Lcom/reactnativecommunity/webview/RNCWebViewManagerImpl;", "", "newArch", "", "<init>", "(Z)V", "TAG", "", "mWebViewConfig", "Lcom/reactnativecommunity/webview/RNCWebViewConfig;", "mAllowsFullscreenVideo", "mAllowsProtectedMedia", "mDownloadingMessage", "mLackPermissionToDownloadMessage", "mHasOnOpenWindowEvent", "mPendingSource", "Lcom/facebook/react/bridge/ReadableMap;", "mUserAgent", "mUserAgentWithApplicationName", "HTML_ENCODING", "HTML_MIME_TYPE", "HTTP_METHOD_POST", "BLANK_URL", "DEFAULT_DOWNLOADING_MESSAGE", "DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE", "createRNCWebViewInstance", "Lcom/reactnativecommunity/webview/RNCWebView;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createViewInstance", "Lcom/reactnativecommunity/webview/RNCWebViewWrapper;", "webView", "setupWebChromeClient", "", "setUserAgent", "viewWrapper", "userAgent", "setApplicationNameForUserAgent", "applicationName", "setUserAgentString", "setBasicAuthCredential", "credential", "onAfterUpdateTransaction", "onDropViewInstance", "COMMAND_GO_BACK", "", "getCOMMAND_GO_BACK", "()I", "COMMAND_GO_FORWARD", "getCOMMAND_GO_FORWARD", "COMMAND_RELOAD", "getCOMMAND_RELOAD", "COMMAND_STOP_LOADING", "getCOMMAND_STOP_LOADING", "COMMAND_POST_MESSAGE", "getCOMMAND_POST_MESSAGE", "COMMAND_INJECT_JAVASCRIPT", "getCOMMAND_INJECT_JAVASCRIPT", "COMMAND_LOAD_URL", "getCOMMAND_LOAD_URL", "COMMAND_FOCUS", "getCOMMAND_FOCUS", "COMMAND_CLEAR_FORM_DATA", "getCOMMAND_CLEAR_FORM_DATA", "COMMAND_CLEAR_CACHE", "getCOMMAND_CLEAR_CACHE", "COMMAND_CLEAR_HISTORY", "getCOMMAND_CLEAR_HISTORY", "getCommandsMap", "", "receiveCommand", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setMixedContentMode", "mixedContentMode", "setAllowUniversalAccessFromFileURLs", "allow", "getDownloadingMessageOrDefault", "getLackPermissionToDownloadMessageOrDefault", "setSource", "source", "loadSource", "setMessagingModuleName", "value", "setCacheEnabled", "enabled", "setIncognito", "setInjectedJavaScript", "injectedJavaScript", "setInjectedJavaScriptBeforeContentLoaded", "setInjectedJavaScriptForMainFrameOnly", "setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly", "setInjectedJavaScriptObject", "setJavaScriptCanOpenWindowsAutomatically", "setShowsVerticalScrollIndicator", "setShowsHorizontalScrollIndicator", "setMessagingEnabled", "setMediaPlaybackRequiresUserAction", "setHasOnScroll", "setJavaScriptEnabled", "setAllowFileAccess", "allowFileAccess", "setAllowFileAccessFromFileURLs", "setAllowsFullscreenVideo", "setAndroidLayerType", "layerTypeString", "setCacheMode", "cacheModeString", "setDomStorageEnabled", "setDownloadingMessage", "setForceDarkOn", "setGeolocationEnabled", "setLackPermissionToDownloadMessage", "setHasOnOpenWindowEvent", "setMinimumFontSize", "setAllowsProtectedMedia", "setMenuCustomItems", "setNestedScrollEnabled", "setOverScrollMode", "overScrollModeString", "setSaveFormDataDisabled", "disabled", "setScalesPageToFit", "setSetBuiltInZoomControls", "setSetDisplayZoomControls", "setSetSupportMultipleWindows", "setTextZoom", "setThirdPartyCookiesEnabled", "setWebviewDebuggingEnabled", "Companion", "react-native-webview_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RNCWebViewManagerImpl {

    @NotNull
    public static final String NAME = "RNCWebView";

    @NotNull
    private final String BLANK_URL;
    private final int COMMAND_CLEAR_CACHE;
    private final int COMMAND_CLEAR_FORM_DATA;
    private final int COMMAND_CLEAR_HISTORY;
    private final int COMMAND_FOCUS;
    private final int COMMAND_GO_BACK;
    private final int COMMAND_GO_FORWARD;
    private final int COMMAND_INJECT_JAVASCRIPT;
    private final int COMMAND_LOAD_URL;
    private final int COMMAND_POST_MESSAGE;
    private final int COMMAND_RELOAD;
    private final int COMMAND_STOP_LOADING;

    @NotNull
    private final String DEFAULT_DOWNLOADING_MESSAGE;

    @NotNull
    private final String DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE;

    @NotNull
    private final String HTML_ENCODING;

    @NotNull
    private final String HTML_MIME_TYPE;

    @NotNull
    private final String HTTP_METHOD_POST;

    @NotNull
    private final String TAG;
    private boolean mAllowsFullscreenVideo;
    private boolean mAllowsProtectedMedia;

    @Nullable
    private String mDownloadingMessage;
    private boolean mHasOnOpenWindowEvent;

    @Nullable
    private String mLackPermissionToDownloadMessage;

    @Nullable
    private ReadableMap mPendingSource;

    @Nullable
    private String mUserAgent;

    @Nullable
    private String mUserAgentWithApplicationName;

    @NotNull
    private RNCWebViewConfig mWebViewConfig;
    private final boolean newArch;

    public RNCWebViewManagerImpl() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mWebViewConfig$lambda$0(WebView webView) {
    }

    public RNCWebViewManagerImpl(boolean z) {
        this.newArch = z;
        this.TAG = "RNCWebViewManagerImpl";
        this.mWebViewConfig = new RNCWebViewConfig() { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$$ExternalSyntheticLambda0
            @Override // com.reactnativecommunity.webview.RNCWebViewConfig
            public final void configWebView(WebView webView) {
                RNCWebViewManagerImpl.mWebViewConfig$lambda$0(webView);
            }
        };
        this.HTML_ENCODING = "UTF-8";
        this.HTML_MIME_TYPE = Mimetypes.MIMETYPE_HTML;
        this.HTTP_METHOD_POST = "POST";
        this.BLANK_URL = "about:blank";
        this.DEFAULT_DOWNLOADING_MESSAGE = "Downloading";
        this.DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE = "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.";
        this.COMMAND_GO_BACK = 1;
        this.COMMAND_GO_FORWARD = 2;
        this.COMMAND_RELOAD = 3;
        this.COMMAND_STOP_LOADING = 4;
        this.COMMAND_POST_MESSAGE = 5;
        this.COMMAND_INJECT_JAVASCRIPT = 6;
        this.COMMAND_LOAD_URL = 7;
        this.COMMAND_FOCUS = 8;
        this.COMMAND_CLEAR_FORM_DATA = 1000;
        this.COMMAND_CLEAR_CACHE = 1001;
        this.COMMAND_CLEAR_HISTORY = 1002;
    }

    public /* synthetic */ RNCWebViewManagerImpl(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @NotNull
    public final RNCWebView createRNCWebViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new RNCWebView(context);
    }

    @NotNull
    public final RNCWebViewWrapper createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return createViewInstance(context, createRNCWebViewInstance(context));
    }

    @NotNull
    public final RNCWebViewWrapper createViewInstance(@NotNull ThemedReactContext context, @NotNull final RNCWebView webView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        setupWebChromeClient(webView);
        context.addLifecycleEventListener(webView);
        this.mWebViewConfig.configWebView(webView);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMixedContentMode(1);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (ReactBuildConfig.DEBUG) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        webView.setDownloadListener(new DownloadListener() { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$$ExternalSyntheticLambda1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                RNCWebViewManagerImpl.createViewInstance$lambda$1(webView, this, str, str2, str3, str4, j);
            }
        });
        return new RNCWebViewWrapper(context, webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$1(RNCWebView rNCWebView, RNCWebViewManagerImpl rNCWebViewManagerImpl, String str, String str2, String str3, String str4, long j) {
        rNCWebView.setIgnoreErrFailedForThisURL(str);
        RNCWebViewModule rNCWebViewModule = (RNCWebViewModule) rNCWebView.getReactApplicationContext().getNativeModule(RNCWebViewModule.class);
        if (rNCWebViewModule == null) {
            return;
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            String strGuessFileName = URLUtil.guessFileName(str, str3, str4);
            Intrinsics.checkNotNull(strGuessFileName);
            String strReplace = RNCWebViewManagerImplKt.getInvalidCharRegex().replace(strGuessFileName, "_");
            String str5 = "Downloading " + strReplace;
            try {
                URL url = new URL(str);
                request.addRequestHeader(HttpHeaders.COOKIE, CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
            } catch (MalformedURLException e) {
                Log.w(rNCWebViewManagerImpl.TAG, "Error getting cookie for DownloadManager", e);
            }
            request.addRequestHeader("User-Agent", str2);
            request.setTitle(strReplace);
            request.setDescription(str5);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, strReplace);
            rNCWebViewModule.setDownloadRequest(request);
            if (rNCWebViewModule.grantFileDownloaderPermissions(rNCWebViewManagerImpl.getDownloadingMessageOrDefault(), rNCWebViewManagerImpl.getLackPermissionToDownloadMessageOrDefault())) {
                rNCWebViewModule.downloadFile(rNCWebViewManagerImpl.getDownloadingMessageOrDefault());
            }
        } catch (IllegalArgumentException e2) {
            Log.w(rNCWebViewManagerImpl.TAG, "Unsupported URI, aborting download", e2);
        }
    }

    private final void setupWebChromeClient(final RNCWebView webView) {
        final Activity currentActivity = webView.getThemedReactContext().getCurrentActivity();
        if (this.mAllowsFullscreenVideo && currentActivity != null) {
            final int requestedOrientation = currentActivity.getRequestedOrientation();
            RNCWebChromeClient rNCWebChromeClient = new RNCWebChromeClient(webView) { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1
                @Override // android.webkit.WebChromeClient
                public Bitmap getDefaultVideoPoster() {
                    return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    if (this.mVideoView != null) {
                        callback.onCustomViewHidden();
                        return;
                    }
                    this.mVideoView = view;
                    this.mCustomViewCallback = callback;
                    currentActivity.setRequestedOrientation(-1);
                    this.mVideoView.setSystemUiVisibility(7942);
                    currentActivity.getWindow().setFlags(512, 512);
                    this.mVideoView.setBackgroundColor(-16777216);
                    ViewGroup rootView = getRootView();
                    rootView.addView(this.mVideoView, RNCWebChromeClient.FULLSCREEN_LAYOUT_PARAMS);
                    if (rootView.getRootView() != this.mWebView.getRootView()) {
                        this.mWebView.getRootView().setVisibility(8);
                    } else {
                        this.mWebView.setVisibility(8);
                    }
                    this.mWebView.getThemedReactContext().addLifecycleEventListener(this);
                }

                @Override // android.webkit.WebChromeClient
                public void onHideCustomView() {
                    if (this.mVideoView == null) {
                        return;
                    }
                    ViewGroup rootView = getRootView();
                    if (rootView.getRootView() != this.mWebView.getRootView()) {
                        this.mWebView.getRootView().setVisibility(0);
                    } else {
                        this.mWebView.setVisibility(0);
                    }
                    currentActivity.getWindow().clearFlags(512);
                    rootView.removeView(this.mVideoView);
                    this.mCustomViewCallback.onCustomViewHidden();
                    this.mVideoView = null;
                    this.mCustomViewCallback = null;
                    currentActivity.setRequestedOrientation(requestedOrientation);
                    this.mWebView.getThemedReactContext().removeLifecycleEventListener(this);
                }
            };
            rNCWebChromeClient.setAllowsProtectedMedia(this.mAllowsProtectedMedia);
            rNCWebChromeClient.setHasOnOpenWindowEvent(this.mHasOnOpenWindowEvent);
            webView.setWebChromeClient(rNCWebChromeClient);
            return;
        }
        RNCWebChromeClient rNCWebChromeClient2 = (RNCWebChromeClient) webView.getWebChromeClient();
        if (rNCWebChromeClient2 != null) {
            rNCWebChromeClient2.onHideCustomView();
        }
        RNCWebChromeClient rNCWebChromeClient3 = new RNCWebChromeClient(webView) { // from class: com.reactnativecommunity.webview.RNCWebViewManagerImpl.setupWebChromeClient.1
            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
            }
        };
        rNCWebChromeClient3.setAllowsProtectedMedia(this.mAllowsProtectedMedia);
        rNCWebChromeClient3.setHasOnOpenWindowEvent(this.mHasOnOpenWindowEvent);
        webView.setWebChromeClient(rNCWebChromeClient3);
    }

    public final void setUserAgent(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String userAgent) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        this.mUserAgent = userAgent;
        setUserAgentString(viewWrapper);
    }

    public final void setApplicationNameForUserAgent(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String applicationName) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        if (applicationName != null) {
            this.mUserAgentWithApplicationName = WebSettings.getDefaultUserAgent(viewWrapper.getWebView().getContext()) + " " + applicationName;
        } else {
            this.mUserAgentWithApplicationName = null;
        }
        setUserAgentString(viewWrapper);
    }

    private final void setUserAgentString(RNCWebViewWrapper viewWrapper) {
        RNCWebView webView = viewWrapper.getWebView();
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    public final void setBasicAuthCredential(@NotNull RNCWebViewWrapper viewWrapper, @Nullable ReadableMap credential) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setBasicAuthCredential((credential != null && credential.hasKey("username") && credential.hasKey(HintConstants.AUTOFILL_HINT_PASSWORD)) ? new RNCBasicAuthCredential(credential.getString("username"), credential.getString(HintConstants.AUTOFILL_HINT_PASSWORD)) : null);
    }

    public final void onAfterUpdateTransaction(@NotNull RNCWebViewWrapper viewWrapper) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        ReadableMap readableMap = this.mPendingSource;
        if (readableMap != null) {
            loadSource(viewWrapper, readableMap);
        }
        this.mPendingSource = null;
    }

    public final void onDropViewInstance(@NotNull RNCWebViewWrapper viewWrapper) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        webView.getThemedReactContext().removeLifecycleEventListener(webView);
        webView.cleanupCallbacksAndDestroy();
        webView.mWebChromeClient = null;
    }

    public final int getCOMMAND_GO_BACK() {
        return this.COMMAND_GO_BACK;
    }

    public final int getCOMMAND_GO_FORWARD() {
        return this.COMMAND_GO_FORWARD;
    }

    public final int getCOMMAND_RELOAD() {
        return this.COMMAND_RELOAD;
    }

    public final int getCOMMAND_STOP_LOADING() {
        return this.COMMAND_STOP_LOADING;
    }

    public final int getCOMMAND_POST_MESSAGE() {
        return this.COMMAND_POST_MESSAGE;
    }

    public final int getCOMMAND_INJECT_JAVASCRIPT() {
        return this.COMMAND_INJECT_JAVASCRIPT;
    }

    public final int getCOMMAND_LOAD_URL() {
        return this.COMMAND_LOAD_URL;
    }

    public final int getCOMMAND_FOCUS() {
        return this.COMMAND_FOCUS;
    }

    public final int getCOMMAND_CLEAR_FORM_DATA() {
        return this.COMMAND_CLEAR_FORM_DATA;
    }

    public final int getCOMMAND_CLEAR_CACHE() {
        return this.COMMAND_CLEAR_CACHE;
    }

    public final int getCOMMAND_CLEAR_HISTORY() {
        return this.COMMAND_CLEAR_HISTORY;
    }

    @Nullable
    public final Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("goBack", Integer.valueOf(this.COMMAND_GO_BACK)).put("goForward", Integer.valueOf(this.COMMAND_GO_FORWARD)).put("reload", Integer.valueOf(this.COMMAND_RELOAD)).put("stopLoading", Integer.valueOf(this.COMMAND_STOP_LOADING)).put("postMessage", Integer.valueOf(this.COMMAND_POST_MESSAGE)).put("injectJavaScript", Integer.valueOf(this.COMMAND_INJECT_JAVASCRIPT)).put("loadUrl", Integer.valueOf(this.COMMAND_LOAD_URL)).put("requestFocus", Integer.valueOf(this.COMMAND_FOCUS)).put("clearFormData", Integer.valueOf(this.COMMAND_CLEAR_FORM_DATA)).put("clearCache", Integer.valueOf(this.COMMAND_CLEAR_CACHE)).put("clearHistory", Integer.valueOf(this.COMMAND_CLEAR_HISTORY)).build();
    }

    public final void receiveCommand(@NotNull RNCWebViewWrapper viewWrapper, @NotNull String commandId, @NotNull ReadableArray args) throws JSONException {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        Intrinsics.checkNotNullParameter(args, "args");
        RNCWebView webView = viewWrapper.getWebView();
        switch (commandId.hashCode()) {
            case -1241591313:
                if (commandId.equals("goBack")) {
                    webView.goBack();
                    return;
                }
                return;
            case -948122918:
                if (commandId.equals("stopLoading")) {
                    webView.stopLoading();
                    return;
                }
                return;
            case -934641255:
                if (commandId.equals("reload")) {
                    webView.reload();
                    return;
                }
                return;
            case -759238347:
                if (commandId.equals("clearCache")) {
                    webView.clearCache(args.getBoolean(0));
                    return;
                }
                return;
            case -318289731:
                if (commandId.equals("goForward")) {
                    webView.goForward();
                    return;
                }
                return;
            case -265032709:
                if (commandId.equals("clearFormData")) {
                    webView.clearFormData();
                    return;
                }
                return;
            case 336631465:
                if (commandId.equals("loadUrl")) {
                    String string = args.getString(0);
                    if (string == null) {
                        throw new RuntimeException("Arguments for loading an url are null!");
                    }
                    webView.progressChangedFilter.setWaitingForCommandLoadUrl(false);
                    InstrumentationCallbacks.loadUrlCalled(webView);
                    webView.loadUrl(string);
                    return;
                }
                return;
            case 903120263:
                if (commandId.equals("clearHistory")) {
                    webView.clearHistory();
                    return;
                }
                return;
            case 1280029577:
                if (commandId.equals("requestFocus")) {
                    webView.requestFocus();
                    return;
                }
                return;
            case 1490029383:
                if (commandId.equals("postMessage")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", args.getString(0));
                        webView.evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                        return;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                return;
            case 2104576510:
                if (commandId.equals("injectJavaScript")) {
                    webView.evaluateJavascriptWithFallback(args.getString(0));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setMixedContentMode(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String mixedContentMode) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (mixedContentMode == null || Intrinsics.areEqual(ReactScrollViewHelper.OVER_SCROLL_NEVER, mixedContentMode)) {
            webView.getSettings().setMixedContentMode(1);
        } else if (Intrinsics.areEqual(ReactScrollViewHelper.OVER_SCROLL_ALWAYS, mixedContentMode)) {
            webView.getSettings().setMixedContentMode(0);
        } else if (Intrinsics.areEqual("compatibility", mixedContentMode)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    public final void setAllowUniversalAccessFromFileURLs(@NotNull RNCWebViewWrapper viewWrapper, boolean allow) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowUniversalAccessFromFileURLs(allow);
    }

    private final String getDownloadingMessageOrDefault() {
        String str = this.mDownloadingMessage;
        return str == null ? this.DEFAULT_DOWNLOADING_MESSAGE : str;
    }

    private final String getLackPermissionToDownloadMessageOrDefault() {
        String str = this.mLackPermissionToDownloadMessage;
        return str == null ? this.DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE : str;
    }

    public final void setSource(@NotNull RNCWebViewWrapper viewWrapper, @Nullable ReadableMap source) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        this.mPendingSource = source;
    }

    private final void loadSource(RNCWebViewWrapper viewWrapper, ReadableMap source) {
        byte[] bytes;
        RNCWebView webView = viewWrapper.getWebView();
        if (source != null) {
            if (source.hasKey("html")) {
                String string = source.getString("html");
                String string2 = source.hasKey("baseUrl") ? source.getString("baseUrl") : "";
                Intrinsics.checkNotNull(string);
                String str = this.HTML_MIME_TYPE;
                String str2 = this.HTML_ENCODING;
                InstrumentationCallbacks.loadUrlCalled(webView);
                webView.loadDataWithBaseURL(string2, string, str, str2, null);
                return;
            }
            if (source.hasKey(ReactNativeBlobUtilConst.DATA_ENCODE_URI)) {
                String string3 = source.getString(ReactNativeBlobUtilConst.DATA_ENCODE_URI);
                String url = webView.getUrl();
                if (url == null || !Intrinsics.areEqual(url, string3)) {
                    if (source.hasKey("method") && StringsKt.equals(source.getString("method"), this.HTTP_METHOD_POST, true)) {
                        if (source.hasKey(RateAppAction.BODY_KEY)) {
                            String string4 = source.getString(RateAppAction.BODY_KEY);
                            try {
                                Intrinsics.checkNotNull(string4);
                                Charset charsetForName = Charset.forName("UTF-8");
                                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
                                bytes = string4.getBytes(charsetForName);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            } catch (UnsupportedEncodingException unused) {
                                Intrinsics.checkNotNull(string4);
                                bytes = string4.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            }
                        } else {
                            bytes = null;
                        }
                        if (bytes == null) {
                            bytes = new byte[0];
                        }
                        Intrinsics.checkNotNull(string3);
                        InstrumentationCallbacks.postUrlCalled(webView);
                        webView.postUrl(string3, bytes);
                        return;
                    }
                    HashMap map = new HashMap();
                    if (source.hasKey("headers")) {
                        if (this.newArch) {
                            ReadableArray array = source.getArray("headers");
                            Intrinsics.checkNotNull(array);
                            Iterator<Object> it = array.toArrayList().iterator();
                            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                            while (it.hasNext()) {
                                Object next = it.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                                HashMap map2 = (HashMap) next;
                                String str3 = (String) map2.get("name");
                                if (str3 == null) {
                                    str3 = "";
                                }
                                String str4 = (String) map2.get("value");
                                if (str4 == null) {
                                    str4 = "";
                                }
                                Locale ENGLISH = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                                String lowerCase = str3.toLowerCase(ENGLISH);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                if (Intrinsics.areEqual("user-agent", lowerCase)) {
                                    webView.getSettings().setUserAgentString(str4);
                                } else {
                                    map.put(str3, str4);
                                }
                            }
                        } else {
                            ReadableMap map3 = source.getMap("headers");
                            Intrinsics.checkNotNull(map3);
                            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map3.keySetIterator();
                            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                                Locale ENGLISH2 = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(ENGLISH2, "ENGLISH");
                                String lowerCase2 = strNextKey.toLowerCase(ENGLISH2);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                if (Intrinsics.areEqual("user-agent", lowerCase2)) {
                                    webView.getSettings().setUserAgentString(map3.getString(strNextKey));
                                } else {
                                    map.put(strNextKey, map3.getString(strNextKey));
                                }
                            }
                        }
                    }
                    Intrinsics.checkNotNull(string3);
                    InstrumentationCallbacks.loadUrlCalled(webView);
                    webView.loadUrl(string3, map);
                    return;
                }
                return;
            }
        }
        String str5 = this.BLANK_URL;
        InstrumentationCallbacks.loadUrlCalled(webView);
        webView.loadUrl(str5);
    }

    public final void setMessagingModuleName(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().messagingModuleName = value;
    }

    public final void setCacheEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setCacheMode(enabled ? -1 : 2);
    }

    public final void setIncognito(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (enabled) {
            CookieManager.getInstance().removeAllCookies(null);
            webView.getSettings().setCacheMode(2);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    public final void setInjectedJavaScript(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String injectedJavaScript) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJS = injectedJavaScript;
    }

    public final void setInjectedJavaScriptBeforeContentLoaded(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJSBeforeContentLoaded = value;
    }

    public final void setInjectedJavaScriptForMainFrameOnly(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJavaScriptForMainFrameOnly = value;
    }

    public final void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().injectedJavaScriptBeforeContentLoadedForMainFrameOnly = value;
    }

    public final void setInjectedJavaScriptObject(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setInjectedJavaScriptObject(value);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setJavaScriptCanOpenWindowsAutomatically(value);
    }

    public final void setShowsVerticalScrollIndicator(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setVerticalScrollBarEnabled(value);
    }

    public final void setShowsHorizontalScrollIndicator(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setHorizontalScrollBarEnabled(value);
    }

    public final void setMessagingEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setMessagingEnabled(value);
    }

    public final void setMediaPlaybackRequiresUserAction(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setMediaPlaybackRequiresUserGesture(value);
    }

    public final void setHasOnScroll(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().setHasScrollEvent(value);
    }

    public final void setJavaScriptEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setJavaScriptEnabled(enabled);
    }

    public final void setAllowFileAccess(@NotNull RNCWebViewWrapper viewWrapper, boolean allowFileAccess) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowFileAccess(allowFileAccess);
    }

    public final void setAllowFileAccessFromFileURLs(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setAllowFileAccessFromFileURLs(value);
    }

    public final void setAllowsFullscreenVideo(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        this.mAllowsFullscreenVideo = value;
        setupWebChromeClient(webView);
    }

    public final void setAndroidLayerType(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String layerTypeString) {
        int i;
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (Intrinsics.areEqual(layerTypeString, "hardware")) {
            i = 2;
        } else {
            i = Intrinsics.areEqual(layerTypeString, "software") ? 1 : 0;
        }
        webView.setLayerType(i, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void setCacheMode(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String cacheModeString) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        WebSettings settings = viewWrapper.getWebView().getSettings();
        int i = -1;
        if (cacheModeString != null) {
            switch (cacheModeString.hashCode()) {
                case -2059164003:
                    if (cacheModeString.equals("LOAD_NO_CACHE")) {
                        i = 2;
                        break;
                    }
                    break;
                case -1215135800:
                    cacheModeString.equals("LOAD_DEFAULT");
                    break;
                case -873877826:
                    if (cacheModeString.equals("LOAD_CACHE_ELSE_NETWORK")) {
                        i = 1;
                        break;
                    }
                    break;
                case 1548620642:
                    if (cacheModeString.equals("LOAD_CACHE_ONLY")) {
                        i = 3;
                        break;
                    }
                    break;
            }
        }
        settings.setCacheMode(i);
    }

    public final void setDomStorageEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setDomStorageEnabled(value);
    }

    public final void setDownloadingMessage(@Nullable String value) {
        this.mDownloadingMessage = value;
    }

    public final void setForceDarkOn(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
            WebSettingsCompat.setForceDark(webView.getSettings(), enabled ? 2 : 0);
        }
        if (enabled && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
            WebSettingsCompat.setForceDarkStrategy(webView.getSettings(), 2);
        }
    }

    public final void setGeolocationEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setGeolocationEnabled(value);
    }

    public final void setLackPermissionToDownloadMessage(@Nullable String value) {
        this.mLackPermissionToDownloadMessage = value;
    }

    public final void setHasOnOpenWindowEvent(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        this.mHasOnOpenWindowEvent = value;
        setupWebChromeClient(webView);
    }

    public final void setMinimumFontSize(@NotNull RNCWebViewWrapper viewWrapper, int value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setMinimumFontSize(value);
    }

    public final void setAllowsProtectedMedia(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        this.mAllowsProtectedMedia = enabled;
        WebChromeClient webChromeClient = webView.getWebChromeClient();
        if (webChromeClient == null || !(webChromeClient instanceof RNCWebChromeClient)) {
            return;
        }
        ((RNCWebChromeClient) webChromeClient).setAllowsProtectedMedia(enabled);
    }

    public final void setMenuCustomItems(@NotNull RNCWebViewWrapper viewWrapper, @Nullable ReadableArray value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        if (value == null) {
            webView.setMenuCustomItems(null);
            return;
        }
        ArrayList<Object> arrayList = value.toArrayList();
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>");
        webView.setMenuCustomItems(arrayList);
    }

    public final void setNestedScrollEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().nestedScrollEnabled = value;
    }

    public final void setOverScrollMode(@NotNull RNCWebViewWrapper viewWrapper, @Nullable String overScrollModeString) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        int i = 0;
        if (overScrollModeString != null) {
            int iHashCode = overScrollModeString.hashCode();
            if (iHashCode == -1414557169) {
                overScrollModeString.equals(ReactScrollViewHelper.OVER_SCROLL_ALWAYS);
            } else if (iHashCode != 104712844) {
                if (iHashCode == 951530617 && overScrollModeString.equals("content")) {
                    i = 1;
                }
            } else if (overScrollModeString.equals(ReactScrollViewHelper.OVER_SCROLL_NEVER)) {
                i = 2;
            }
        }
        webView.setOverScrollMode(i);
    }

    public final void setSaveFormDataDisabled(@NotNull RNCWebViewWrapper viewWrapper, boolean disabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setSaveFormData(!disabled);
    }

    public final void setScalesPageToFit(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        RNCWebView webView = viewWrapper.getWebView();
        webView.getSettings().setLoadWithOverviewMode(value);
        webView.getSettings().setUseWideViewPort(value);
    }

    public final void setSetBuiltInZoomControls(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setBuiltInZoomControls(value);
    }

    public final void setSetDisplayZoomControls(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setDisplayZoomControls(value);
    }

    public final void setSetSupportMultipleWindows(@NotNull RNCWebViewWrapper viewWrapper, boolean value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setSupportMultipleWindows(value);
    }

    public final void setTextZoom(@NotNull RNCWebViewWrapper viewWrapper, int value) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        viewWrapper.getWebView().getSettings().setTextZoom(value);
    }

    public final void setThirdPartyCookiesEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        CookieManager.getInstance().setAcceptThirdPartyCookies(viewWrapper.getWebView(), enabled);
    }

    public final void setWebviewDebuggingEnabled(@NotNull RNCWebViewWrapper viewWrapper, boolean enabled) {
        Intrinsics.checkNotNullParameter(viewWrapper, "viewWrapper");
        WebView.setWebContentsDebuggingEnabled(enabled);
    }
}
