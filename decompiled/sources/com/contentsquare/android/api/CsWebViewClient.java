package com.contentsquare.android.api;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.MustBeInvokedByOverriders;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message = "This class is no longer necessary and will be removed in future releases.")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/api/CsWebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "tagInjector", "Lcom/contentsquare/android/api/CsWebViewTagInjector;", "getTagInjector", "()Lcom/contentsquare/android/api/CsWebViewTagInjector;", "tagInjector$delegate", "Lkotlin/Lazy;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class CsWebViewClient extends WebViewClient {

    /* renamed from: tagInjector$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy tagInjector = LazyKt.lazy(a.a);

    public static final class a extends Lambda implements Function0<CsWebViewTagInjector> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CsWebViewTagInjector invoke() {
            return new CsWebViewTagInjector(null, null, null, null, null, 31, null);
        }
    }

    private final CsWebViewTagInjector getTagInjector() {
        return (CsWebViewTagInjector) this.tagInjector.getValue();
    }

    @Override // android.webkit.WebViewClient
    @MustBeInvokedByOverriders
    public void onPageFinished(@Nullable WebView view, @Nullable String url) {
        InstrumentationCallbacks.onPageFinishedCalled(this, view, url);
        super.onPageFinished(view, url);
        getTagInjector().injectTag(view);
    }
}
