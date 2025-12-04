package com.urbanairship.android.layout.display;

import android.content.Context;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00126\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R>\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/display/DisplayRequest;", "", "payload", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "actionRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "webViewClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "onDisplay", "Lkotlin/Function2;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "Lcom/urbanairship/android/layout/display/DisplayArgs;", "displayArgs", "", "(Lcom/urbanairship/android/layout/info/LayoutInfo;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/android/layout/ThomasListenerInterface;Lcom/urbanairship/android/layout/environment/ThomasActionRunner;Lcom/urbanairship/android/layout/util/ImageCache;Lcom/urbanairship/android/layout/util/Factory;Lkotlin/jvm/functions/Function2;)V", "display", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class DisplayRequest {
    private ThomasActionRunner actionRunner;
    private ActivityMonitor activityMonitor;
    private ImageCache imageCache;
    private ThomasListenerInterface listener;
    private final Function2 onDisplay;
    private final LayoutInfo payload;
    private Factory webViewClientFactory;

    public DisplayRequest(@NotNull LayoutInfo payload, @NotNull ActivityMonitor activityMonitor, @NotNull ThomasListenerInterface listener, @NotNull ThomasActionRunner actionRunner, @Nullable ImageCache imageCache, @Nullable Factory<AirshipWebViewClient> factory, @NotNull Function2<? super Context, ? super DisplayArgs, Unit> onDisplay) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        Intrinsics.checkNotNullParameter(onDisplay, "onDisplay");
        this.payload = payload;
        this.activityMonitor = activityMonitor;
        this.listener = listener;
        this.actionRunner = actionRunner;
        this.imageCache = imageCache;
        this.webViewClientFactory = factory;
        this.onDisplay = onDisplay;
    }

    public /* synthetic */ DisplayRequest(LayoutInfo layoutInfo, ActivityMonitor activityMonitor, ThomasListenerInterface thomasListenerInterface, ThomasActionRunner thomasActionRunner, ImageCache imageCache, Factory factory, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutInfo, activityMonitor, thomasListenerInterface, thomasActionRunner, (i & 16) != 0 ? null : imageCache, (i & 32) != 0 ? null : factory, function2);
    }

    public final void display(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.onDisplay.invoke(context, new DisplayArgs(this.payload, this.listener, this.activityMonitor, this.actionRunner, this.webViewClientFactory, this.imageCache));
    }
}
