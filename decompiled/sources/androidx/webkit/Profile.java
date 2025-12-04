package androidx.webkit;

import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.WebStorage;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface Profile {
    public static final String DEFAULT_PROFILE_NAME = "Default";

    @NonNull
    CookieManager getCookieManager();

    @NonNull
    GeolocationPermissions getGeolocationPermissions();

    @NonNull
    String getName();

    @NonNull
    ServiceWorkerController getServiceWorkerController();

    @NonNull
    WebStorage getWebStorage();
}
