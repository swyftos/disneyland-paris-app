package com.urbanairship.android.layout.display;

import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.android.layout.ThomasListenerInterface;
import com.urbanairship.android.layout.environment.ThomasActionRunner;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.webkit.AirshipWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/display/DisplayArgs;", "", "payload", "Lcom/urbanairship/android/layout/info/LayoutInfo;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "inAppActivityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "actionRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "webViewClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "(Lcom/urbanairship/android/layout/info/LayoutInfo;Lcom/urbanairship/android/layout/ThomasListenerInterface;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/android/layout/environment/ThomasActionRunner;Lcom/urbanairship/android/layout/util/Factory;Lcom/urbanairship/android/layout/util/ImageCache;)V", "getActionRunner", "()Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "getImageCache", "()Lcom/urbanairship/android/layout/util/ImageCache;", "getInAppActivityMonitor", "()Lcom/urbanairship/app/ActivityMonitor;", "getListener", "()Lcom/urbanairship/android/layout/ThomasListenerInterface;", "getPayload", "()Lcom/urbanairship/android/layout/info/LayoutInfo;", "getWebViewClientFactory", "()Lcom/urbanairship/android/layout/util/Factory;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public final class DisplayArgs {
    private final ThomasActionRunner actionRunner;
    private final ImageCache imageCache;
    private final ActivityMonitor inAppActivityMonitor;
    private final ThomasListenerInterface listener;
    private final LayoutInfo payload;
    private final Factory webViewClientFactory;

    public DisplayArgs(@NotNull LayoutInfo payload, @NotNull ThomasListenerInterface listener, @NotNull ActivityMonitor inAppActivityMonitor, @NotNull ThomasActionRunner actionRunner, @Nullable Factory<AirshipWebViewClient> factory, @Nullable ImageCache imageCache) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(inAppActivityMonitor, "inAppActivityMonitor");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.payload = payload;
        this.listener = listener;
        this.inAppActivityMonitor = inAppActivityMonitor;
        this.actionRunner = actionRunner;
        this.webViewClientFactory = factory;
        this.imageCache = imageCache;
    }

    public /* synthetic */ DisplayArgs(LayoutInfo layoutInfo, ThomasListenerInterface thomasListenerInterface, ActivityMonitor activityMonitor, ThomasActionRunner thomasActionRunner, Factory factory, ImageCache imageCache, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutInfo, thomasListenerInterface, activityMonitor, thomasActionRunner, (i & 16) != 0 ? null : factory, (i & 32) != 0 ? null : imageCache);
    }

    @NotNull
    public final LayoutInfo getPayload() {
        return this.payload;
    }

    @NotNull
    public final ThomasListenerInterface getListener() {
        return this.listener;
    }

    @NotNull
    public final ActivityMonitor getInAppActivityMonitor() {
        return this.inAppActivityMonitor;
    }

    @NotNull
    public final ThomasActionRunner getActionRunner() {
        return this.actionRunner;
    }

    @Nullable
    public final Factory<AirshipWebViewClient> getWebViewClientFactory() {
        return this.webViewClientFactory;
    }

    @Nullable
    public final ImageCache getImageCache() {
        return this.imageCache;
    }
}
