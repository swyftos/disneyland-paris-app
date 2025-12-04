package org.devio.rn.splashscreen;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class SplashScreen {
    private static Boolean isAnimationFinished;
    private static WeakReference mActivity;
    private static Dialog mSplashDialog;
    private static Boolean waiting;

    static {
        Boolean bool = Boolean.FALSE;
        isAnimationFinished = bool;
        waiting = bool;
    }

    public static void show(final Activity activity, final int i, final int i2) {
        if (activity == null) {
            return;
        }
        mActivity = new WeakReference(activity);
        activity.runOnUiThread(new Runnable() { // from class: org.devio.rn.splashscreen.SplashScreen.1
            @Override // java.lang.Runnable
            public void run() {
                if (activity.isFinishing()) {
                    return;
                }
                SplashScreen.mSplashDialog = new Dialog(activity, i);
                SplashScreen.mSplashDialog.setContentView(R.layout.launch_screen);
                SplashScreen.mSplashDialog.setCancelable(false);
                ((LottieAnimationView) SplashScreen.mSplashDialog.findViewById(i2)).addAnimatorListener(new Animator.AnimatorListener() { // from class: org.devio.rn.splashscreen.SplashScreen.1.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        System.out.println("asdf");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        SplashScreen.setAnimationFinished(true);
                    }
                });
                if (SplashScreen.mSplashDialog.isShowing()) {
                    return;
                }
                SplashScreen.mSplashDialog.show();
            }
        });
    }

    public static void setAnimationFinished(boolean z) {
        if (mActivity == null) {
            return;
        }
        isAnimationFinished = Boolean.valueOf(z);
        final Activity activity = (Activity) mActivity.get();
        activity.runOnUiThread(new Runnable() { // from class: org.devio.rn.splashscreen.SplashScreen.2
            @Override // java.lang.Runnable
            public void run() {
                if (SplashScreen.mSplashDialog == null || !SplashScreen.mSplashDialog.isShowing()) {
                    return;
                }
                boolean zIsDestroyed = activity.isDestroyed();
                if (activity.isFinishing() || zIsDestroyed || !SplashScreen.waiting.booleanValue()) {
                    return;
                }
                SplashScreen.mSplashDialog.dismiss();
                SplashScreen.mSplashDialog = null;
            }
        });
    }

    public static void show(Activity activity, int i) {
        show(activity, R.style.SplashScreen_SplashTheme, i);
    }

    public static void hide(final Activity activity) {
        if (activity == null) {
            WeakReference weakReference = mActivity;
            if (weakReference == null) {
                return;
            } else {
                activity = (Activity) weakReference.get();
            }
        }
        if (activity == null) {
            return;
        }
        waiting = Boolean.TRUE;
        activity.runOnUiThread(new Runnable() { // from class: org.devio.rn.splashscreen.SplashScreen.3
            @Override // java.lang.Runnable
            public void run() {
                if (SplashScreen.mSplashDialog == null || !SplashScreen.mSplashDialog.isShowing()) {
                    return;
                }
                boolean zIsDestroyed = activity.isDestroyed();
                if (activity.isFinishing() || zIsDestroyed || !SplashScreen.isAnimationFinished.booleanValue()) {
                    return;
                }
                SplashScreen.mSplashDialog.dismiss();
                SplashScreen.mSplashDialog = null;
            }
        });
    }
}
