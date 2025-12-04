package com.urbanairship.android.layout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.display.DisplayArgsLoader;
import com.urbanairship.android.layout.display.DisplayException;
import com.urbanairship.android.layout.display.DisplayRequest;
import com.urbanairship.android.layout.environment.ThomasActionRunner;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.android.layout.ui.BannerLayout;
import com.urbanairship.android.layout.ui.ModalActivity;
import com.urbanairship.android.layout.util.Factory;
import com.urbanairship.android.layout.util.ImageCache;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.json.JsonMap;
import com.urbanairship.webkit.AirshipWebViewClient;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J^\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007¨\u0006!"}, d2 = {"Lcom/urbanairship/android/layout/Thomas;", "", "()V", "MAX_SUPPORTED_VERSION", "", "getMAX_SUPPORTED_VERSION$annotations", "getMAX_SUPPORTED_VERSION", "()I", "MIN_SUPPORTED_VERSION", "getMIN_SUPPORTED_VERSION$annotations", "getMIN_SUPPORTED_VERSION", "isValid", "", "payload", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "prepareDisplay", "Lcom/urbanairship/android/layout/display/DisplayRequest;", Constants.FirelogAnalytics.PARAM_PRIORITY, "extras", "Lcom/urbanairship/json/JsonMap;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/android/layout/ThomasListenerInterface;", "actionRunner", "Lcom/urbanairship/android/layout/environment/ThomasActionRunner;", "imageCache", "Lcom/urbanairship/android/layout/util/ImageCache;", "webViewClientFactory", "Lcom/urbanairship/android/layout/util/Factory;", "Lcom/urbanairship/webkit/AirshipWebViewClient;", "embeddedViewManager", "Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class Thomas {

    @NotNull
    public static final Thomas INSTANCE = new Thomas();
    private static final int MAX_SUPPORTED_VERSION = 2;
    private static final int MIN_SUPPORTED_VERSION = 1;

    @VisibleForTesting
    public static /* synthetic */ void getMAX_SUPPORTED_VERSION$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getMIN_SUPPORTED_VERSION$annotations() {
    }

    private Thomas() {
    }

    public final int getMAX_SUPPORTED_VERSION() {
        return MAX_SUPPORTED_VERSION;
    }

    public final int getMIN_SUPPORTED_VERSION() {
        return MIN_SUPPORTED_VERSION;
    }

    @JvmStatic
    public static final boolean isValid(@NotNull LayoutInfo payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        int i = MIN_SUPPORTED_VERSION;
        int i2 = MAX_SUPPORTED_VERSION;
        int version = payload.getVersion();
        if (i > version || version > i2) {
            return false;
        }
        BasePresentation presentation = payload.getPresentation();
        return (presentation instanceof ModalPresentation) || (presentation instanceof BannerPresentation) || (presentation instanceof EmbeddedPresentation);
    }

    @JvmStatic
    @NotNull
    public static final DisplayRequest prepareDisplay(@NotNull LayoutInfo payload, final int priority, @NotNull final JsonMap extras, @NotNull final ActivityMonitor activityMonitor, @NotNull ThomasListenerInterface listener, @NotNull ThomasActionRunner actionRunner, @Nullable ImageCache imageCache, @Nullable Factory<AirshipWebViewClient> webViewClientFactory, @NotNull final AirshipEmbeddedViewManager embeddedViewManager) throws DisplayException {
        Function2 function2;
        Function2 function22;
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        Intrinsics.checkNotNullParameter(embeddedViewManager, "embeddedViewManager");
        if (!isValid(payload)) {
            throw new DisplayException("Payload is not valid: " + payload.getPresentation());
        }
        BasePresentation presentation = payload.getPresentation();
        if (presentation instanceof ModalPresentation) {
            function22 = new Function2() { // from class: com.urbanairship.android.layout.Thomas$prepareDisplay$callback$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Context) obj, (DisplayArgs) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context, DisplayArgs args) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intent intentPutExtra = new Intent(context, (Class<?>) ModalActivity.class).setFlags(268435456).putExtra(ModalActivity.EXTRA_DISPLAY_ARGS_LOADER, DisplayArgsLoader.newLoader(args));
                    Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
                    Activity activity = (Activity) CollectionsKt.lastOrNull((List) activityMonitor.getResumedActivities());
                    if (activity != null) {
                        activity.startActivity(intentPutExtra, ActivityOptions.makeSceneTransitionAnimation(activity, new Pair[0]).toBundle());
                    } else {
                        context.startActivity(intentPutExtra);
                    }
                }
            };
        } else {
            if (!(presentation instanceof BannerPresentation)) {
                if (presentation instanceof EmbeddedPresentation) {
                    function2 = new Function2() { // from class: com.urbanairship.android.layout.Thomas$prepareDisplay$callback$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Context) obj, (DisplayArgs) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Context context, DisplayArgs args) {
                            Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
                            Intrinsics.checkNotNullParameter(args, "args");
                            embeddedViewManager.addPending(args, priority, extras);
                        }
                    };
                    return new DisplayRequest(payload, activityMonitor, listener, actionRunner, imageCache, webViewClientFactory, function2);
                }
                throw new DisplayException("Presentation not supported: " + payload.getPresentation());
            }
            function22 = new Function2() { // from class: com.urbanairship.android.layout.Thomas$prepareDisplay$callback$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Context) obj, (DisplayArgs) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Context context, DisplayArgs args) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(args, "args");
                    new BannerLayout(context, args).display();
                }
            };
        }
        function2 = function22;
        return new DisplayRequest(payload, activityMonitor, listener, actionRunner, imageCache, webViewClientFactory, function2);
    }
}
