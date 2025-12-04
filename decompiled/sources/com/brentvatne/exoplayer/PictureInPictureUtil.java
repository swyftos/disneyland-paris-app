package com.brentvatne.exoplayer;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Process;
import android.util.Rational;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.annotation.RequiresApi;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.R;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.receiver.PictureInPictureReceiver;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b \u0010\u000fJ7\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b'\u0010(J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020)H\u0007¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0014H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0014H\u0003¢\u0006\u0004\b2\u00101J\u0017\u00103\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b3\u0010/J\u0017\u00104\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u0010/¨\u00065"}, d2 = {"Lcom/brentvatne/exoplayer/PictureInPictureUtil;", "", "<init>", "()V", "Lcom/facebook/react/uimanager/ThemedReactContext;", "context", "Lcom/brentvatne/exoplayer/ReactExoplayerView;", "view", "Ljava/lang/Runnable;", "addLifecycleEventListener", "(Lcom/facebook/react/uimanager/ThemedReactContext;Lcom/brentvatne/exoplayer/ReactExoplayerView;)Ljava/lang/Runnable;", "Landroid/app/PictureInPictureParams;", "pictureInPictureParams", "", "enterPictureInPictureMode", "(Lcom/facebook/react/uimanager/ThemedReactContext;Landroid/app/PictureInPictureParams;)V", "Landroid/app/PictureInPictureParams$Builder;", "pipParamsBuilder", "Lcom/brentvatne/receiver/PictureInPictureReceiver;", "receiver", "", "isPaused", "applyPlayingStatus", "(Lcom/facebook/react/uimanager/ThemedReactContext;Landroid/app/PictureInPictureParams$Builder;Lcom/brentvatne/receiver/PictureInPictureReceiver;Z)V", "autoEnterEnabled", "applyAutoEnterEnabled", "(Lcom/facebook/react/uimanager/ThemedReactContext;Landroid/app/PictureInPictureParams$Builder;Z)V", "Lcom/brentvatne/exoplayer/ExoPlayerView;", "playerView", "applySourceRectHint", "(Lcom/facebook/react/uimanager/ThemedReactContext;Landroid/app/PictureInPictureParams$Builder;Lcom/brentvatne/exoplayer/ExoPlayerView;)V", "pipParams", "updatePictureInPictureActions", "Ljava/util/ArrayList;", "Landroid/app/RemoteAction;", "Lkotlin/collections/ArrayList;", "getPictureInPictureActions", "(Lcom/facebook/react/uimanager/ThemedReactContext;ZLcom/brentvatne/receiver/PictureInPictureReceiver;)Ljava/util/ArrayList;", "Landroid/graphics/Rect;", "calcRectHint", "(Lcom/brentvatne/exoplayer/ExoPlayerView;)Landroid/graphics/Rect;", "Landroidx/media3/exoplayer/ExoPlayer;", "player", "Landroid/util/Rational;", "calcPictureInPictureAspectRatio", "(Landroidx/media3/exoplayer/ExoPlayer;)Landroid/util/Rational;", "isSupportPictureInPicture", "(Lcom/facebook/react/uimanager/ThemedReactContext;)Z", "isSupportPictureInPictureAction", "()Z", "checkIsApiSupport", "checkIsSystemSupportPIP", "checkIsUserAllowPIP", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PictureInPictureUtil {

    @NotNull
    public static final PictureInPictureUtil INSTANCE = new PictureInPictureUtil();

    private final boolean checkIsApiSupport() {
        return true;
    }

    private final boolean isSupportPictureInPictureAction() {
        return true;
    }

    private PictureInPictureUtil() {
    }

    @JvmStatic
    @NotNull
    public static final Runnable addLifecycleEventListener(@NotNull ThemedReactContext context, @NotNull final ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        final ComponentActivity componentActivityFindActivity = PictureInPictureUtilKt.findActivity(context);
        final Consumer<PictureInPictureModeChangedInfo> consumer = new Consumer() { // from class: com.brentvatne.exoplayer.PictureInPictureUtil$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                PictureInPictureUtil.addLifecycleEventListener$lambda$0(view, componentActivityFindActivity, (PictureInPictureModeChangedInfo) obj);
            }
        };
        final Runnable runnable = new Runnable() { // from class: com.brentvatne.exoplayer.PictureInPictureUtil$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PictureInPictureUtil.addLifecycleEventListener$lambda$1(view);
            }
        };
        componentActivityFindActivity.addOnPictureInPictureModeChangedListener(consumer);
        if (Build.VERSION.SDK_INT < 31) {
            componentActivityFindActivity.addOnUserLeaveHintListener(runnable);
        }
        return new Runnable() { // from class: com.brentvatne.exoplayer.PictureInPictureUtil$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PictureInPictureUtil.addLifecycleEventListener$lambda$3(componentActivityFindActivity, consumer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLifecycleEventListener$lambda$0(ReactExoplayerView reactExoplayerView, ComponentActivity componentActivity, PictureInPictureModeChangedInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        reactExoplayerView.setIsInPictureInPicture(info.getIsInPictureInPictureMode());
        if (info.getIsInPictureInPictureMode() || componentActivity.getLifecycle().getState() != Lifecycle.State.CREATED || reactExoplayerView.playInBackground) {
            return;
        }
        reactExoplayerView.setPausedModifier(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLifecycleEventListener$lambda$1(ReactExoplayerView reactExoplayerView) {
        if (reactExoplayerView.enterPictureInPictureOnLeave) {
            reactExoplayerView.enterPictureInPictureMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLifecycleEventListener$lambda$3(ComponentActivity componentActivity, Consumer consumer, Runnable runnable) {
        componentActivity.removeOnPictureInPictureModeChangedListener(consumer);
        componentActivity.removeOnUserLeaveHintListener(runnable);
    }

    @JvmStatic
    public static final void enterPictureInPictureMode(@NotNull ThemedReactContext context, @Nullable PictureInPictureParams pictureInPictureParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        PictureInPictureUtil pictureInPictureUtil = INSTANCE;
        if (pictureInPictureUtil.isSupportPictureInPicture(context)) {
            if (pictureInPictureUtil.isSupportPictureInPictureAction() && pictureInPictureParams != null) {
                try {
                    PictureInPictureUtilKt.findActivity(context).enterPictureInPictureMode(pictureInPictureParams);
                    return;
                } catch (IllegalStateException e) {
                    DebugLog.e("PictureInPictureUtil", e.toString());
                    return;
                }
            }
            try {
                PictureInPictureUtilKt.findActivity(context).enterPictureInPictureMode();
            } catch (IllegalStateException e2) {
                DebugLog.e("PictureInPictureUtil", e2.toString());
            }
        }
    }

    @JvmStatic
    public static final void applyPlayingStatus(@NotNull ThemedReactContext context, @Nullable PictureInPictureParams.Builder pipParamsBuilder, @NotNull PictureInPictureReceiver receiver, boolean isPaused) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        if (pipParamsBuilder != null) {
            pipParamsBuilder.setActions(getPictureInPictureActions(context, isPaused, receiver));
            PictureInPictureUtil pictureInPictureUtil = INSTANCE;
            PictureInPictureParams pictureInPictureParamsBuild = pipParamsBuilder.build();
            Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
            pictureInPictureUtil.updatePictureInPictureActions(context, pictureInPictureParamsBuild);
        }
    }

    @JvmStatic
    public static final void applyAutoEnterEnabled(@NotNull ThemedReactContext context, @Nullable PictureInPictureParams.Builder pipParamsBuilder, boolean autoEnterEnabled) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (pipParamsBuilder == null || Build.VERSION.SDK_INT < 31) {
            return;
        }
        pipParamsBuilder.setAutoEnterEnabled(autoEnterEnabled);
        PictureInPictureUtil pictureInPictureUtil = INSTANCE;
        PictureInPictureParams pictureInPictureParamsBuild = pipParamsBuilder.build();
        Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
        pictureInPictureUtil.updatePictureInPictureActions(context, pictureInPictureParamsBuild);
    }

    @JvmStatic
    public static final void applySourceRectHint(@NotNull ThemedReactContext context, @Nullable PictureInPictureParams.Builder pipParamsBuilder, @NotNull ExoPlayerView playerView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        if (pipParamsBuilder != null) {
            pipParamsBuilder.setSourceRectHint(calcRectHint(playerView));
            PictureInPictureUtil pictureInPictureUtil = INSTANCE;
            PictureInPictureParams pictureInPictureParamsBuild = pipParamsBuilder.build();
            Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
            pictureInPictureUtil.updatePictureInPictureActions(context, pictureInPictureParamsBuild);
        }
    }

    private final void updatePictureInPictureActions(ThemedReactContext context, PictureInPictureParams pipParams) {
        if (isSupportPictureInPictureAction() && isSupportPictureInPicture(context)) {
            try {
                PictureInPictureUtilKt.findActivity(context).setPictureInPictureParams(pipParams);
            } catch (IllegalStateException e) {
                DebugLog.e("PictureInPictureUtil", e.toString());
            }
        }
    }

    @JvmStatic
    @RequiresApi(26)
    @NotNull
    public static final ArrayList<RemoteAction> getPictureInPictureActions(@NotNull ThemedReactContext context, boolean isPaused, @NotNull PictureInPictureReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        PendingIntent pipActionIntent = receiver.getPipActionIntent(isPaused);
        Icon iconCreateWithResource = Icon.createWithResource(context, isPaused ? R.drawable.exo_icon_play : R.drawable.exo_icon_pause);
        Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(...)");
        String str = isPaused ? "play" : "pause";
        return CollectionsKt.arrayListOf(new RemoteAction(iconCreateWithResource, str, str, pipActionIntent));
    }

    private static final Rect calcRectHint(ExoPlayerView playerView) {
        Rect rect = new Rect();
        View surfaceView = playerView.getSurfaceView();
        if (surfaceView != null) {
            surfaceView.getGlobalVisibleRect(rect);
        }
        int[] iArr = new int[2];
        View surfaceView2 = playerView.getSurfaceView();
        if (surfaceView2 != null) {
            surfaceView2.getLocationOnScreen(iArr);
        }
        int i = rect.bottom - rect.top;
        int i2 = iArr[1];
        rect.top = i2;
        rect.bottom = i2 + i;
        return rect;
    }

    @JvmStatic
    @RequiresApi(26)
    @NotNull
    public static final Rational calcPictureInPictureAspectRatio(@NotNull ExoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        Rational rational = new Rational(player.getVideoSize().width, player.getVideoSize().height);
        Rational rational2 = new Rational(239, 100);
        Rational rational3 = new Rational(100, 239);
        return rational.floatValue() > rational2.floatValue() ? rational2 : rational.floatValue() < rational3.floatValue() ? rational3 : rational;
    }

    private final boolean isSupportPictureInPicture(ThemedReactContext context) {
        return checkIsApiSupport() && checkIsSystemSupportPIP(context) && checkIsUserAllowPIP(context);
    }

    private final boolean checkIsSystemSupportPIP(ThemedReactContext context) throws PackageManager.NameNotFoundException {
        ComponentActivity componentActivityFindActivity = PictureInPictureUtilKt.findActivity(context);
        if (componentActivityFindActivity == null) {
            return false;
        }
        ActivityInfo activityInfo = componentActivityFindActivity.getPackageManager().getActivityInfo(componentActivityFindActivity.getComponentName(), 128);
        Intrinsics.checkNotNullExpressionValue(activityInfo, "getActivityInfo(...)");
        return ((activityInfo.flags & 4194304) != 0) && componentActivityFindActivity.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    private final boolean checkIsUserAllowPIP(ThemedReactContext context) {
        Activity currentActivity = context.getCurrentActivity();
        return currentActivity != null && AppOpsManagerCompat.noteOpNoThrow(currentActivity, "android:picture_in_picture", Process.myUid(), currentActivity.getPackageName()) == 0;
    }
}
