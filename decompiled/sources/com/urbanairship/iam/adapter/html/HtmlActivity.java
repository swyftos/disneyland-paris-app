package com.urbanairship.iam.adapter.html;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.DrawableCompat;
import com.amazonaws.services.s3.util.Mimetypes;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.messaging.Constants;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.automation.R;
import com.urbanairship.iam.InAppMessageActivity;
import com.urbanairship.iam.adapter.InAppMessageDisplayListener;
import com.urbanairship.iam.content.HTML;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.view.BoundedFrameLayout;
import com.urbanairship.javascript.NativeBridge;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.webkit.AirshipWebChromeClient;
import com.urbanairship.webkit.AirshipWebView;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/urbanairship/iam/adapter/html/HtmlActivity;", "Lcom/urbanairship/iam/InAppMessageActivity;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent$HTMLContent;", "()V", "delayedLoadRunnable", "Ljava/lang/Runnable;", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "Ljava/lang/Integer;", "handler", "Landroid/os/Handler;", "url", "", "webView", "Lcom/urbanairship/webkit/AirshipWebView;", "applySizeConstraints", "", "html", "Lcom/urbanairship/iam/content/HTML;", "crossFade", "inView", "Landroid/view/View;", "outView", "isFullScreen", "", "load", "delay", "", "onCreateMessage", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "reportButtonTap", "json", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHtmlActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HtmlActivity.kt\ncom/urbanairship/iam/adapter/html/HtmlActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
/* loaded from: classes5.dex */
public final class HtmlActivity extends InAppMessageActivity<InAppMessageDisplayContent.HTMLContent> {
    private final Runnable delayedLoadRunnable = new Runnable() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            HtmlActivity.delayedLoadRunnable$lambda$0(this.f$0);
        }
    };
    private Integer error;
    private Handler handler;
    private String url;
    private AirshipWebView webView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delayedLoadRunnable$lambda$0(HtmlActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        load$default(this$0, 0L, 1, null);
    }

    @Override // com.urbanairship.iam.InAppMessageActivity
    protected void onCreateMessage(@Nullable Bundle savedInstanceState) {
        float borderRadius;
        InAppMessageDisplayContent.HTMLContent displayContent = getDisplayContent();
        HTML html = displayContent != null ? displayContent.getHtml() : null;
        if (html == null) {
            finish();
            return;
        }
        if (isFullScreen(html)) {
            setTheme(R.style.UrbanAirship_InAppHtml_Activity_Fullscreen);
            setContentView(R.layout.ua_iam_html_fullscreen);
            borderRadius = 0.0f;
        } else {
            setContentView(R.layout.ua_iam_html);
            borderRadius = html.getBorderRadius();
        }
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        ImageButton imageButton = (ImageButton) findViewById(R.id.dismiss);
        BoundedFrameLayout boundedFrameLayout = (BoundedFrameLayout) findViewById(R.id.content_holder);
        applySizeConstraints(html);
        AirshipWebView airshipWebView = (AirshipWebView) findViewById(R.id.web_view);
        this.webView = airshipWebView;
        this.handler = new Handler(Looper.getMainLooper());
        this.url = html.getUrl();
        if (!UAirship.shared().getUrlAllowList().isAllowed(this.url, 2)) {
            UALog.e("HTML in-app message URL is not allowed. Unable to display message.", new Object[0]);
            finish();
            return;
        }
        JsonMap extras = getArgs().getExtras();
        if (extras == null) {
            extras = JsonExtensionsKt.emptyJsonMap();
        }
        airshipWebView.setWebViewClient(new HtmlWebViewClient(extras, new NativeBridge(getArgs().getActionRunner())) { // from class: com.urbanairship.iam.adapter.html.HtmlActivity.onCreateMessage.1
            @Override // com.urbanairship.iam.adapter.html.HtmlWebViewClient
            public void onMessageDismissed(@NotNull JsonValue argument) {
                Intrinsics.checkNotNullParameter(argument, "argument");
                this.reportButtonTap(argument);
                this.finish();
            }

            @Override // com.urbanairship.webkit.AirshipWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(@Nullable WebView view, @Nullable String url) {
                InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
                super.onPageFinished(view, url);
                if (this.error == null) {
                    this.crossFade(view, progressBar);
                    return;
                }
                Integer num = this.error;
                if ((num != null && num.intValue() == -6) || ((num != null && num.intValue() == -8) || (num != null && num.intValue() == -1))) {
                    this.load(20000L);
                    return;
                }
                this.error = null;
                if (view != null) {
                    view.loadData("", Mimetypes.MIMETYPE_HTML, null);
                }
            }

            @Override // android.webkit.WebViewClient
            @Deprecated(message = "Deprecated in Java")
            public void onReceivedError(@NotNull WebView view, final int errorCode, @NotNull final String description, @NotNull final String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(description, "description");
                Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
                if (Intrinsics.areEqual(failingUrl, this.getIntent().getDataString())) {
                    UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity$onCreateMessage$1$onReceivedError$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "HtmlActivity - Failed to load page " + failingUrl + " with error " + errorCode + ' ' + description;
                        }
                    }, 1, null);
                    this.error = Integer.valueOf(errorCode);
                }
            }
        });
        airshipWebView.setAlpha(BitmapDescriptorFactory.HUE_RED);
        airshipWebView.getSettings().setSupportMultipleWindows(true);
        airshipWebView.setWebChromeClient(new AirshipWebChromeClient(this));
        Drawable drawableMutate = DrawableCompat.wrap(imageButton.getDrawable()).mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        DrawableCompat.setTint(drawableMutate, html.getDismissButtonColor().getColor());
        imageButton.setImageDrawable(drawableMutate);
        InstrumentationCallbacks.setOnClickListenerCalled(imageButton, new View.OnClickListener() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HtmlActivity.onCreateMessage$lambda$1(this.f$0, view);
            }
        });
        int color = html.getBackgroundColor().getColor();
        boundedFrameLayout.setBackgroundColor(color);
        airshipWebView.setBackgroundColor(color);
        if (Color.alpha(color) != 255 || borderRadius <= BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        boundedFrameLayout.setClipPathBorderRadius(borderRadius);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateMessage$lambda$1(HtmlActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InAppMessageDisplayListener displayListener = this$0.getDisplayListener();
        if (displayListener != null) {
            displayListener.onUserDismissed();
        }
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportButtonTap(JsonValue json) {
        InAppMessageButtonInfo inAppMessageButtonInfoFromJson;
        InAppMessageDisplayListener displayListener;
        try {
            JsonValue jsonValue = json.optMap().get("button_info");
            if (jsonValue == null || (inAppMessageButtonInfoFromJson = InAppMessageButtonInfo.INSTANCE.fromJson(jsonValue)) == null || (displayListener = getDisplayListener()) == null) {
                return;
            }
            displayListener.onButtonDismissed(inAppMessageButtonInfoFromJson);
        } catch (JsonException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity.reportButtonTap.3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Unable to parse message resolution JSON";
                }
            });
        }
    }

    private final boolean isFullScreen(HTML html) {
        if (!html.getAllowFullscreenDisplay()) {
            return false;
        }
        try {
            return getResources().getBoolean(R.bool.ua_iam_html_allow_fullscreen_display);
        } catch (Resources.NotFoundException unused) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity.isFullScreen.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to load 'R.bool.ua_iam_html_allow_fullscreen_display'!";
                }
            }, 1, null);
            return false;
        }
    }

    @Override // com.urbanairship.iam.InAppMessageActivity, com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AirshipWebView airshipWebView = this.webView;
        if (airshipWebView != null) {
            airshipWebView.onResume();
        }
        load$default(this, 0L, 1, null);
    }

    @Override // com.urbanairship.iam.InAppMessageActivity, com.urbanairship.activity.ThemedActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        AirshipWebView airshipWebView = this.webView;
        if (airshipWebView != null) {
            airshipWebView.onPause();
        }
        AirshipWebView airshipWebView2 = this.webView;
        if (airshipWebView2 != null) {
            airshipWebView2.stopLoading();
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.delayedLoadRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void crossFade(View inView, final View outView) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2;
        if (inView != null && (viewPropertyAnimatorAnimate2 = inView.animate()) != null && (viewPropertyAnimatorAlpha2 = viewPropertyAnimatorAnimate2.alpha(1.0f)) != null) {
            viewPropertyAnimatorAlpha2.setDuration(200L);
        }
        if (outView == null || (viewPropertyAnimatorAnimate = outView.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(BitmapDescriptorFactory.HUE_RED)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(200L)) == null) {
            return;
        }
        duration.setListener(new AnimatorListenerAdapter() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity.crossFade.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                outView.setVisibility(8);
            }
        });
    }

    static /* synthetic */ void load$default(HtmlActivity htmlActivity, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        htmlActivity.load(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void load(long r3) {
        /*
            r2 = this;
            com.urbanairship.webkit.AirshipWebView r0 = r2.webView
            if (r0 == 0) goto L7
            r0.stopLoading()
        L7:
            r0 = 0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L17
            android.os.Handler r0 = r2.handler
            if (r0 == 0) goto L3d
            java.lang.Runnable r2 = r2.delayedLoadRunnable
            r0.postDelayed(r2, r3)
            goto L3d
        L17:
            java.lang.String r3 = r2.url
            r4 = 0
            if (r3 == 0) goto L34
            java.lang.String r0 = "Loading url: %s"
            java.lang.Object[] r1 = new java.lang.Object[]{r3}
            com.urbanairship.UALog.i(r0, r1)
            r2.error = r4
            com.urbanairship.webkit.AirshipWebView r2 = r2.webView
            if (r2 == 0) goto L34
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.loadUrlCalled(r2)
            r2.loadUrl(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L35
        L34:
            r2 = r4
        L35:
            if (r2 != 0) goto L3d
            com.urbanairship.iam.adapter.html.HtmlActivity$load$2 r2 = new kotlin.jvm.functions.Function0() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity.load.2
                static {
                    /*
                        com.urbanairship.iam.adapter.html.HtmlActivity$load$2 r0 = new com.urbanairship.iam.adapter.html.HtmlActivity$load$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.urbanairship.iam.adapter.html.HtmlActivity$load$2) com.urbanairship.iam.adapter.html.HtmlActivity.load.2.INSTANCE com.urbanairship.iam.adapter.html.HtmlActivity$load$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.html.HtmlActivity.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.html.HtmlActivity.AnonymousClass2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.Object invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = r0.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.html.HtmlActivity.AnonymousClass2.invoke():java.lang.Object");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r0 = this;
                        java.lang.String r0 = "Unable to load HTML for in-app message. URL is null!"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.html.HtmlActivity.AnonymousClass2.invoke():java.lang.String");
                }
            }
            r3 = 1
            com.urbanairship.UALog.w$default(r4, r2, r3, r4)
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.adapter.html.HtmlActivity.load(long):void");
    }

    private final void applySizeConstraints(HTML html) {
        View viewFindViewById;
        if ((html.getWidth() == 0 && html.getHeight() == 0) || (viewFindViewById = findViewById(R.id.content_holder)) == null) {
            return;
        }
        final int iApplyDimension = (int) TypedValue.applyDimension(1, html.getWidth(), getResources().getDisplayMetrics());
        final int iApplyDimension2 = (int) TypedValue.applyDimension(1, html.getHeight(), getResources().getDisplayMetrics());
        final boolean zAreEqual = Intrinsics.areEqual(html.getAspectLock(), Boolean.TRUE);
        final WeakReference weakReference = new WeakReference(viewFindViewById);
        viewFindViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.iam.adapter.html.HtmlActivity.applySizeConstraints.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                int i;
                View view = (View) weakReference.get();
                if (view == null) {
                    return true;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int iMin = Math.min(measuredWidth, iApplyDimension);
                int iMin2 = Math.min(measuredHeight, iApplyDimension2);
                if (zAreEqual && (iMin != (i = iApplyDimension) || iMin2 != iApplyDimension2)) {
                    int i2 = iApplyDimension2;
                    float f = measuredWidth;
                    float f2 = measuredHeight;
                    if (f / f2 > i / i2) {
                        iMin = (int) ((i * f2) / i2);
                    } else {
                        iMin2 = (int) ((i2 * f) / i);
                    }
                }
                if (iMin2 > 0) {
                    layoutParams.height = iMin2;
                }
                if (iMin > 0) {
                    layoutParams.width = iMin;
                }
                view.setLayoutParams(layoutParams);
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }
}
