package com.urbanairship.messagecenter.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.messagecenter.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u00020\u000b2\b\b\u0001\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0014\u0010\rR\u001b\u0010\u0016\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0017\u0010\rR\u001b\u0010\u0019\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001a\u0010\rR\u001b\u0010\u001c\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001d\u0010\rR\u000e\u0010\u001f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbanairship/messagecenter/ui/widget/MessageListItemAnimator;", "", "context", "Landroid/content/Context;", "unreadContainer", "Landroid/view/View;", "checkable", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;)V", "editingAnimatorSet", "Landroid/animation/AnimatorSet;", "fadeIn", "Landroid/animation/Animator;", "getFadeIn", "()Landroid/animation/Animator;", "fadeIn$delegate", "Lkotlin/Lazy;", "fadeOut", "getFadeOut", "fadeOut$delegate", "flipLeftIn", "getFlipLeftIn", "flipLeftIn$delegate", "flipLeftOut", "getFlipLeftOut", "flipLeftOut$delegate", "flipRightIn", "getFlipRightIn", "flipRightIn$delegate", "flipRightOut", "getFlipRightOut", "flipRightOut$delegate", "notEditingAnimatorSet", "animateEditMode", "", "isEditing", "", "loadAnimator", "animatorRes", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMessageListItemAnimator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageListItemAnimator.kt\ncom/urbanairship/messagecenter/ui/widget/MessageListItemAnimator\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,89:1\n41#2:90\n91#2,14:91\n30#2:105\n91#2,14:106\n256#3,2:120\n*S KotlinDebug\n*F\n+ 1 MessageListItemAnimator.kt\ncom/urbanairship/messagecenter/ui/widget/MessageListItemAnimator\n*L\n50#1:90\n50#1:91,14\n67#1:105\n67#1:106,14\n76#1:120,2\n*E\n"})
/* loaded from: classes5.dex */
public final class MessageListItemAnimator {
    private final View checkable;
    private final Context context;
    private final AnimatorSet editingAnimatorSet;

    /* renamed from: fadeIn$delegate, reason: from kotlin metadata */
    private final Lazy fadeIn;

    /* renamed from: fadeOut$delegate, reason: from kotlin metadata */
    private final Lazy fadeOut;

    /* renamed from: flipLeftIn$delegate, reason: from kotlin metadata */
    private final Lazy flipLeftIn;

    /* renamed from: flipLeftOut$delegate, reason: from kotlin metadata */
    private final Lazy flipLeftOut;

    /* renamed from: flipRightIn$delegate, reason: from kotlin metadata */
    private final Lazy flipRightIn;

    /* renamed from: flipRightOut$delegate, reason: from kotlin metadata */
    private final Lazy flipRightOut;
    private final AnimatorSet notEditingAnimatorSet;
    private final View unreadContainer;

    public MessageListItemAnimator(@NotNull Context context, @NotNull View unreadContainer, @NotNull View checkable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(unreadContainer, "unreadContainer");
        Intrinsics.checkNotNullParameter(checkable, "checkable");
        this.context = context;
        this.unreadContainer = unreadContainer;
        this.checkable = checkable;
        this.flipRightOut = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$flipRightOut$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animator invoke() throws Resources.NotFoundException {
                Animator animatorLoadAnimator = this.this$0.loadAnimator(R.animator.flip_right_out);
                animatorLoadAnimator.setTarget(this.this$0.unreadContainer);
                return animatorLoadAnimator;
            }
        });
        this.flipLeftIn = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$flipLeftIn$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animator invoke() throws Resources.NotFoundException {
                Animator animatorLoadAnimator = this.this$0.loadAnimator(R.animator.flip_left_in);
                animatorLoadAnimator.setTarget(this.this$0.unreadContainer);
                return animatorLoadAnimator;
            }
        });
        this.flipRightIn = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$flipRightIn$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animator invoke() throws Resources.NotFoundException {
                Animator animatorLoadAnimator = this.this$0.loadAnimator(R.animator.flip_right_in);
                animatorLoadAnimator.setTarget(this.this$0.checkable);
                return animatorLoadAnimator;
            }
        });
        this.flipLeftOut = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$flipLeftOut$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animator invoke() throws Resources.NotFoundException {
                Animator animatorLoadAnimator = this.this$0.loadAnimator(R.animator.flip_left_out);
                animatorLoadAnimator.setTarget(this.this$0.checkable);
                return animatorLoadAnimator;
            }
        });
        this.fadeIn = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$fadeIn$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animator invoke() throws Resources.NotFoundException {
                Animator animatorLoadAnimator = this.this$0.loadAnimator(R.animator.fade_in);
                animatorLoadAnimator.setTarget(this.this$0.checkable);
                return animatorLoadAnimator;
            }
        });
        this.fadeOut = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$fadeOut$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Animator invoke() throws Resources.NotFoundException {
                Animator animatorLoadAnimator = this.this$0.loadAnimator(R.animator.fade_out);
                animatorLoadAnimator.setTarget(this.this$0.checkable);
                return animatorLoadAnimator;
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(getFlipRightIn(), getFlipRightOut(), getFadeIn());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$editingAnimatorSet$lambda$1$$inlined$doOnStart$1
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
                this.this$0.checkable.setAlpha(BitmapDescriptorFactory.HUE_RED);
                this.this$0.checkable.setVisibility(0);
            }
        });
        this.editingAnimatorSet = animatorSet;
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(getFlipLeftIn(), getFlipLeftOut(), getFadeOut());
        animatorSet2.addListener(new Animator.AnimatorListener() { // from class: com.urbanairship.messagecenter.ui.widget.MessageListItemAnimator$notEditingAnimatorSet$lambda$3$$inlined$doOnEnd$1
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
                this.this$0.checkable.setVisibility(8);
            }
        });
        this.notEditingAnimatorSet = animatorSet2;
    }

    private final Animator getFlipRightOut() {
        return (Animator) this.flipRightOut.getValue();
    }

    private final Animator getFlipLeftIn() {
        return (Animator) this.flipLeftIn.getValue();
    }

    private final Animator getFlipRightIn() {
        return (Animator) this.flipRightIn.getValue();
    }

    private final Animator getFlipLeftOut() {
        return (Animator) this.flipLeftOut.getValue();
    }

    private final Animator getFadeIn() {
        return (Animator) this.fadeIn.getValue();
    }

    private final Animator getFadeOut() {
        return (Animator) this.fadeOut.getValue();
    }

    public final void animateEditMode(boolean isEditing) {
        this.unreadContainer.setVisibility(0);
        if (isEditing) {
            this.editingAnimatorSet.start();
        } else {
            this.notEditingAnimatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Animator loadAnimator(int animatorRes) throws Resources.NotFoundException {
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.context, animatorRes);
        Intrinsics.checkNotNullExpressionValue(animatorLoadAnimator, "loadAnimator(...)");
        return animatorLoadAnimator;
    }
}
