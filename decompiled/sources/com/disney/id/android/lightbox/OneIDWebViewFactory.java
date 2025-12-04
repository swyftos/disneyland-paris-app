package com.disney.id.android.lightbox;

import android.content.Context;
import android.os.Looper;
import com.disney.id.android.SWID;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/disney/id/android/lightbox/OneIDWebViewFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "webView", "Lcom/disney/id/android/lightbox/LightboxWebView;", "getOneIDWebView", "conversationId", "", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDWebView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDWebView.kt\ncom/disney/id/android/lightbox/OneIDWebViewFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,630:1\n1#2:631\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDWebViewFactory {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = OneIDWebViewFactory.class.getSimpleName();
    private final Context context;

    @Inject
    public Logger logger;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private volatile LightboxWebView webView;

    public OneIDWebViewFactory(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/disney/id/android/lightbox/OneIDWebViewFactory$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$OneID_release", "()Ljava/lang/String;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$OneID_release() {
            return OneIDWebViewFactory.TAG;
        }
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    public static /* synthetic */ LightboxWebView getOneIDWebView$default(OneIDWebViewFactory oneIDWebViewFactory, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return oneIDWebViewFactory.getOneIDWebView(str);
    }

    @Nullable
    public final LightboxWebView getOneIDWebView(@Nullable String conversationId) {
        LightboxWebView oneIDWebView = this.webView;
        if (oneIDWebView == null) {
            synchronized (this) {
                LightboxWebView lightboxWebView = null;
                if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                    Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), conversationId, false, EventAction.LOG_INSTANTIATE_WEBVIEW, getSwid$OneID_release().get(), null, null, "onuithread(false)", null, false, 178, null);
                } else {
                    try {
                        oneIDWebView = this.webView;
                        if (oneIDWebView == null) {
                            oneIDWebView = new OneIDWebView(this.context);
                            this.webView = oneIDWebView;
                        }
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Logger logger$OneID_release = getLogger$OneID_release();
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        logger$OneID_release.e(TAG2, "Webview instantiation failed, will retry // " + message, e);
                        Thread.sleep(1000L);
                        try {
                            LightboxWebView oneIDWebView2 = this.webView;
                            if (oneIDWebView2 == null) {
                                oneIDWebView2 = new OneIDWebView(this.context);
                                this.webView = oneIDWebView2;
                            }
                            Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), conversationId, false, EventAction.LOG_INSTANTIATE_WEBVIEW, getSwid$OneID_release().get(), null, null, "retry(success),firsttry(" + message + ")", null, false, 178, null);
                            lightboxWebView = oneIDWebView2;
                        } catch (Exception e2) {
                            String message2 = e2.getMessage();
                            Logger logger$OneID_release2 = getLogger$OneID_release();
                            String TAG3 = TAG;
                            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                            logger$OneID_release2.e(TAG3, "Webview instantiation failed on retry // " + message2, e2);
                            Tracker.DefaultImpls.trackInstantEvent$default(getTracker$OneID_release(), conversationId, false, EventAction.LOG_INSTANTIATE_WEBVIEW, getSwid$OneID_release().get(), null, null, "retry(failure),firsttry(" + message + "),secondtry(" + message2 + ")", null, false, 178, null);
                        }
                    }
                }
                oneIDWebView = lightboxWebView;
            }
        }
        return oneIDWebView;
    }
}
