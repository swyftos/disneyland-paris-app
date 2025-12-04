package com.urbanairship.android.layout.environment;

import android.app.Activity;
import android.webkit.WebChromeClient;
import androidx.annotation.RestrictTo;
import com.urbanairship.Predicate;
import com.urbanairship.android.layout.util.CachedImage;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.webkit.AirshipWebChromeClient;
import com.urbanairship.webkit.AirshipWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/layout/environment/DefaultViewEnvironment;", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "activity", "Landroid/app/Activity;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "webViewClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "isIgnoringSafeAreas", "", "(Landroid/app/Activity;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/android/layout/util/Factory;Lcom/urbanairship/android/layout/util/ImageCache;Z)V", "()Z", "webChromeClientFactory", "Landroid/webkit/WebChromeClient;", "hostingActivityPredicate", "Lcom/urbanairship/Predicate;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class DefaultViewEnvironment implements ViewEnvironment {
    private final Activity activity;
    private final ActivityMonitor activityMonitor;
    private final ImageCache imageCache;
    private final boolean isIgnoringSafeAreas;
    private final Factory webChromeClientFactory;
    private final Factory webViewClientFactory;

    /* JADX INFO: Access modifiers changed from: private */
    public static final CachedImage imageCache$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }

    public DefaultViewEnvironment(@NotNull Activity activity, @NotNull ActivityMonitor activityMonitor, @Nullable Factory<AirshipWebViewClient> factory, @Nullable ImageCache imageCache, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        this.activity = activity;
        this.activityMonitor = activityMonitor;
        this.isIgnoringSafeAreas = z;
        this.webChromeClientFactory = new Factory() { // from class: com.urbanairship.android.layout.environment.DefaultViewEnvironment$$ExternalSyntheticLambda0
            @Override // com.urbanairship.android.layout.util.Factory
            public final Object create() {
                return DefaultViewEnvironment.webChromeClientFactory$lambda$0(this.f$0);
            }
        };
        this.webViewClientFactory = factory == null ? new Factory() { // from class: com.urbanairship.android.layout.environment.DefaultViewEnvironment$$ExternalSyntheticLambda1
            @Override // com.urbanairship.android.layout.util.Factory
            public final Object create() {
                return DefaultViewEnvironment.webViewClientFactory$lambda$1();
            }
        } : factory;
        this.imageCache = imageCache == null ? new ImageCache() { // from class: com.urbanairship.android.layout.environment.DefaultViewEnvironment$$ExternalSyntheticLambda2
            @Override // com.urbanairship.android.layout.util.ImageCache
            public final CachedImage get(String str) {
                return DefaultViewEnvironment.imageCache$lambda$2(str);
            }
        } : imageCache;
    }

    @Override // com.urbanairship.android.layout.environment.ViewEnvironment
    /* renamed from: isIgnoringSafeAreas, reason: from getter */
    public boolean getIsIgnoringSafeAreas() {
        return this.isIgnoringSafeAreas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebChromeClient webChromeClientFactory$lambda$0(DefaultViewEnvironment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return new AirshipWebChromeClient(this$0.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AirshipWebViewClient webViewClientFactory$lambda$1() {
        return new AirshipWebViewClient();
    }

    @Override // com.urbanairship.android.layout.environment.ViewEnvironment
    @NotNull
    /* renamed from: activityMonitor, reason: from getter */
    public ActivityMonitor getActivityMonitor() {
        return this.activityMonitor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hostingActivityPredicate$lambda$3(DefaultViewEnvironment this$0, Activity activityToCheck) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityToCheck, "activityToCheck");
        return activityToCheck == this$0.activity;
    }

    @Override // com.urbanairship.android.layout.environment.ViewEnvironment
    @NotNull
    public Predicate<Activity> hostingActivityPredicate() {
        return new Predicate() { // from class: com.urbanairship.android.layout.environment.DefaultViewEnvironment$$ExternalSyntheticLambda3
            @Override // com.urbanairship.Predicate
            public final boolean apply(Object obj) {
                return DefaultViewEnvironment.hostingActivityPredicate$lambda$3(this.f$0, (Activity) obj);
            }
        };
    }

    @Override // com.urbanairship.android.layout.environment.ViewEnvironment
    @NotNull
    public Factory<WebChromeClient> webChromeClientFactory() {
        return this.webChromeClientFactory;
    }

    @Override // com.urbanairship.android.layout.environment.ViewEnvironment
    @NotNull
    public Factory<AirshipWebViewClient> webViewClientFactory() {
        return this.webViewClientFactory;
    }

    @Override // com.urbanairship.android.layout.environment.ViewEnvironment
    @NotNull
    /* renamed from: imageCache, reason: from getter */
    public ImageCache getImageCache() {
        return this.imageCache;
    }
}
