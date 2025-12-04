package com.urbanairship.messagecenter.animator;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u000b\u001a\u00020\f*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u000e\u001a\u00020\f*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0001H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000f"}, d2 = {"shortAnimTime", "", "Landroid/view/View;", "getShortAnimTime", "(Landroid/view/View;)J", "slideInBottomAnimator", "Landroid/animation/ObjectAnimator;", "getSlideInBottomAnimator", "(Landroid/view/View;)Landroid/animation/ObjectAnimator;", "slideOutBottomAnimator", "getSlideOutBottomAnimator", "animateFadeIn", "Landroid/view/ViewPropertyAnimator;", TypedValues.TransitionType.S_DURATION, "animateFadeOut", "urbanairship-message-center_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimatorExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatorExtensions.kt\ncom/urbanairship/messagecenter/animator/AnimatorExtensionsKt\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,48:1\n41#2:49\n91#2,14:50\n41#2:64\n91#2,14:65\n30#2:79\n91#2,14:80\n*S KotlinDebug\n*F\n+ 1 AnimatorExtensions.kt\ncom/urbanairship/messagecenter/animator/AnimatorExtensionsKt\n*L\n19#1:49\n19#1:50,14\n32#1:64\n32#1:65,14\n36#1:79\n36#1:80,14\n*E\n"})
/* loaded from: classes5.dex */
public final class AnimatorExtensionsKt {
    private static final long getShortAnimTime(View view) {
        return view.getResources().getInteger(R.integer.config_shortAnimTime);
    }

    @NotNull
    public static final ObjectAnimator getSlideInBottomAnimator(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getHeight(), BitmapDescriptorFactory.HUE_RED);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.urbanairship.messagecenter.animator.AnimatorExtensionsKt$_get_slideInBottomAnimator_$lambda$1$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                view.setTranslationY(r2.getHeight());
                view.setVisibility(0);
            }
        });
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    @NotNull
    public static final ObjectAnimator getSlideOutBottomAnimator(@NotNull final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, BitmapDescriptorFactory.HUE_RED, view.getHeight());
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.urbanairship.messagecenter.animator.AnimatorExtensionsKt$_get_slideOutBottomAnimator_$lambda$4$$inlined$doOnStart$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
                view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
                view.setVisibility(0);
            }
        });
        objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.urbanairship.messagecenter.animator.AnimatorExtensionsKt$_get_slideOutBottomAnimator_$lambda$4$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator) {
                view.setVisibility(8);
            }
        });
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    public static /* synthetic */ ViewPropertyAnimator animateFadeIn$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = getShortAnimTime(view);
        }
        return animateFadeIn(view, j);
    }

    @NotNull
    public static final ViewPropertyAnimator animateFadeIn(@NotNull View view, long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewPropertyAnimator duration = view.animate().alpha(1.0f).setDuration(j);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        return duration;
    }

    public static /* synthetic */ ViewPropertyAnimator animateFadeOut$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = getShortAnimTime(view);
        }
        return animateFadeOut(view, j);
    }

    @NotNull
    public static final ViewPropertyAnimator animateFadeOut(@NotNull View view, long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewPropertyAnimator duration = view.animate().alpha(BitmapDescriptorFactory.HUE_RED).setDuration(j);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        return duration;
    }
}
