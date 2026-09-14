package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
abstract class BaseLayoutAnimation extends AbstractLayoutAnimation {
    abstract boolean isReverse();

    BaseLayoutAnimation() {
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    boolean isValid() {
        return this.mDurationMs > 0 && this.mAnimatedProperty != null;
    }

    /* JADX INFO: renamed from: com.facebook.react.uimanager.layoutanimation.BaseLayoutAnimation$1 */
    static /* synthetic */ class C33011 {

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$react$uimanager$layoutanimation$AnimatedPropertyType */
        static final /* synthetic */ int[] f3400x36728427;

        static {
            int[] iArr = new int[AnimatedPropertyType.values().length];
            f3400x36728427 = iArr;
            try {
                iArr[AnimatedPropertyType.OPACITY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3400x36728427[AnimatedPropertyType.SCALE_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3400x36728427[AnimatedPropertyType.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3400x36728427[AnimatedPropertyType.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.facebook.react.uimanager.layoutanimation.AbstractLayoutAnimation
    Animation createAnimationImpl(View view, int i, int i2, int i3, int i4) {
        AnimatedPropertyType animatedPropertyType = this.mAnimatedProperty;
        if (animatedPropertyType != null) {
            int i5 = C33011.f3400x36728427[animatedPropertyType.ordinal()];
            float alpha = BitmapDescriptorFactory.HUE_RED;
            if (i5 == 1) {
                float alpha2 = isReverse() ? view.getAlpha() : 0.0f;
                if (!isReverse()) {
                    alpha = view.getAlpha();
                }
                return new OpacityAnimation(view, alpha2, alpha);
            }
            if (i5 == 2) {
                float f = isReverse() ? 1.0f : 0.0f;
                float f2 = isReverse() ? 0.0f : 1.0f;
                return new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
            }
            if (i5 == 3) {
                return new ScaleAnimation(isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, BitmapDescriptorFactory.HUE_RED);
            }
            if (i5 == 4) {
                return new ScaleAnimation(1.0f, 1.0f, isReverse() ? 1.0f : 0.0f, isReverse() ? 0.0f : 1.0f, 1, BitmapDescriptorFactory.HUE_RED, 1, 0.5f);
            }
            throw new IllegalViewOperationException("Missing animation for property : " + this.mAnimatedProperty);
        }
        throw new IllegalViewOperationException("Missing animated property from animation config");
    }
}
