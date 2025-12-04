package com.urbanairship.iam.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.view.OneShotPreDrawListener;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.urbanairship.UAirship;
import com.urbanairship.iam.info.InAppMessageMediaInfo;
import com.urbanairship.images.ImageRequestOptions;
import com.urbanairship.util.ManifestUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/iam/view/MediaView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "defResStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chromeClient", "Landroid/webkit/WebChromeClient;", "webView", "Landroid/webkit/WebView;", "loadWebView", "", "mediaInfo", "Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "onPause", "onResume", "setChromeClient", "setMediaInfo", "cachedMediaUrl", "", "Companion", "MediaWebViewClient", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMediaView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaView.kt\ncom/urbanairship/iam/view/MediaView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,204:1\n1#2:205\n81#3:206\n*S KotlinDebug\n*F\n+ 1 MediaView.kt\ncom/urbanairship/iam/view/MediaView\n*L\n91#1:206\n*E\n"})
/* loaded from: classes5.dex */
public final class MediaView extends FrameLayout {
    private WebChromeClient chromeClient;
    private WebView webView;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppMessageMediaInfo.MediaType.values().length];
            try {
                iArr[InAppMessageMediaInfo.MediaType.YOUTUBE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppMessageMediaInfo.MediaType.VIMEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppMessageMediaInfo.MediaType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InAppMessageMediaInfo.MediaType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MediaView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MediaView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setChromeClient(@Nullable WebChromeClient chromeClient) {
        this.chromeClient = chromeClient;
        WebView webView = this.webView;
        if (webView != null) {
            webView.setWebChromeClient(chromeClient);
        }
    }

    public final void onPause() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onPause();
        }
    }

    public final void onResume() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.onResume();
        }
    }

    public final void setMediaInfo(@NotNull InAppMessageMediaInfo mediaInfo, @Nullable final String cachedMediaUrl) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        removeAllViewsInLayout();
        WebView webView = this.webView;
        if (webView != null) {
            webView.stopLoading();
            webView.setWebChromeClient(null);
            webView.destroy();
        }
        this.webView = null;
        int i = WhenMappings.$EnumSwitchMapping$0[mediaInfo.getType().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            loadWebView(mediaInfo);
            return;
        }
        if (i != 4) {
            return;
        }
        final ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAdjustViewBounds(true);
        imageView.setContentDescription(mediaInfo.getDescription());
        if (cachedMediaUrl == null) {
            cachedMediaUrl = mediaInfo.getUrl();
        }
        OneShotPreDrawListener.add(imageView, new Runnable() { // from class: com.urbanairship.iam.view.MediaView$setMediaInfo$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                UAirship.shared().getImageLoader().load(this.getContext(), imageView, ImageRequestOptions.newBuilder(cachedMediaUrl).build());
            }
        });
        addView(imageView);
    }

    private final void loadWebView(final InAppMessageMediaInfo mediaInfo) {
        WebView webView = new WebView(getContext());
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(webView, layoutParams);
        final ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.setId(R.id.progress);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        frameLayout.addView(progressBar, layoutParams2);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setMediaPlaybackRequiresUserGesture(true);
        settings.setJavaScriptEnabled(true);
        if (ManifestUtils.shouldEnableLocalStorage()) {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
        }
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        final WeakReference weakReference = new WeakReference(webView);
        Runnable runnable = new Runnable() { // from class: com.urbanairship.iam.view.MediaView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MediaView.loadWebView$lambda$4(weakReference, mediaInfo);
            }
        };
        webView.setWebChromeClient(this.chromeClient);
        webView.setContentDescription(mediaInfo.getDescription());
        webView.setVisibility(4);
        webView.setWebViewClient(new MediaWebViewClient(runnable) { // from class: com.urbanairship.iam.view.MediaView.loadWebView.2
            @Override // com.urbanairship.iam.view.MediaView.MediaWebViewClient
            protected void onPageFinished(@NotNull WebView webView2) {
                Intrinsics.checkNotNullParameter(webView2, "webView");
                webView2.setVisibility(0);
                progressBar.setVisibility(8);
            }
        });
        addView(frameLayout);
        runnable.run();
        this.webView = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadWebView$lambda$4(WeakReference webViewWeakReference, InAppMessageMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(webViewWeakReference, "$webViewWeakReference");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        WebView webView = (WebView) webViewWeakReference.get();
        if (webView == null) {
            return;
        }
        if (InAppMessageMediaInfo.MediaType.VIDEO == mediaInfo.getType()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ROOT, "<body style=\"margin:0\"><video playsinline controls height=\"100%%\" width=\"100%%\" src=\"%s\"></video></body>", Arrays.copyOf(new Object[]{mediaInfo.getUrl()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            webView.loadData(str, Mimetypes.MIMETYPE_HTML, "UTF-8");
            return;
        }
        String url = mediaInfo.getUrl();
        InstrumentationCallbacks.loadUrlCalled(webView);
        webView.loadUrl(url);
    }

    private static abstract class MediaWebViewClient extends WebViewClient {

        @NotNull
        public static final Companion Companion = new Companion(null);
        public static final long START_RETRY_DELAY = 1000;
        private boolean error;
        private final Runnable onRetry;
        private long retryDelay;

        protected abstract void onPageFinished(WebView webView);

        public MediaWebViewClient(Runnable onRetry) {
            Intrinsics.checkNotNullParameter(onRetry, "onRetry");
            this.onRetry = onRetry;
            this.retryDelay = 1000L;
        }

        public final boolean getError() {
            return this.error;
        }

        public final void setError(boolean z) {
            this.error = z;
        }

        public final long getRetryDelay() {
            return this.retryDelay;
        }

        public final void setRetryDelay(long j) {
            this.retryDelay = j;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@NotNull WebView view, @NotNull String url) {
            InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            if (this.error) {
                view.postDelayed(this.onRetry, this.retryDelay);
                this.retryDelay *= 2;
            } else {
                onPageFinished(view);
            }
            this.error = false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@NotNull WebView view, @NotNull WebResourceRequest request, @NotNull WebResourceError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(error, "error");
            super.onReceivedError(view, request, error);
            this.error = true;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/iam/view/MediaView$MediaWebViewClient$Companion;", "", "()V", "START_RETRY_DELAY", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
