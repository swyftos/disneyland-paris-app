package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* loaded from: classes2.dex */
public interface WebViewProviderFactory {
    @NonNull
    WebViewProviderBoundaryInterface createWebView(@NonNull WebView webView);

    @NonNull
    DropDataContentProviderBoundaryInterface getDropDataProvider();

    @NonNull
    ProfileStoreBoundaryInterface getProfileStore();

    @NonNull
    ProxyControllerBoundaryInterface getProxyController();

    @NonNull
    ServiceWorkerControllerBoundaryInterface getServiceWorkerController();

    @NonNull
    StaticsBoundaryInterface getStatics();

    @NonNull
    TracingControllerBoundaryInterface getTracingController();

    @NonNull
    String[] getWebViewFeatures();

    @NonNull
    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();
}
