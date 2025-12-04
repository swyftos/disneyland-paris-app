package com.urbanairship.android.layout.environment;

import android.app.Activity;
import android.webkit.WebChromeClient;
import androidx.annotation.RestrictTo;
import com.urbanairship.Predicate;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.webkit.AirshipWebViewClient;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "", "isIgnoringSafeAreas", "", "()Z", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "hostingActivityPredicate", "Lcom/urbanairship/Predicate;", "Landroid/app/Activity;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "webChromeClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Landroid/webkit/WebChromeClient;", "webViewClientFactory", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface ViewEnvironment {
    @NotNull
    ActivityMonitor activityMonitor();

    @NotNull
    Predicate<Activity> hostingActivityPredicate();

    @Nullable
    ImageCache imageCache();

    boolean isIgnoringSafeAreas();

    @NotNull
    Factory<WebChromeClient> webChromeClientFactory();

    @NotNull
    Factory<AirshipWebViewClient> webViewClientFactory();
}
