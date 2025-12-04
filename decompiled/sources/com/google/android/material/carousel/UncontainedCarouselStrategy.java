package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.carousel.KeylineState;

/* loaded from: classes4.dex */
public final class UncontainedCarouselStrategy extends CarouselStrategy {
    @Override // com.google.android.material.carousel.CarouselStrategy
    boolean isContained() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UncontainedCarouselStrategy() {
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        float f;
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f2 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            float f3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
            f = f3;
        } else {
            f = f2;
        }
        float f4 = measuredHeight + f;
        float extraSmallSize = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f;
        float extraSmallSize2 = CarouselStrategyHelper.getExtraSmallSize(view.getContext()) + f;
        int iMax = Math.max(1, (int) Math.floor(containerWidth / f4));
        float f5 = containerWidth - (iMax * f4);
        if (carousel.getCarouselAlignment() == 1) {
            float f6 = f5 / 2.0f;
            return createCenterAlignedKeylineState(containerWidth, f, f4, iMax, Math.max(Math.min(3.0f * f6, f4), getSmallItemSizeMin() + f), extraSmallSize2, f6);
        }
        return createLeftAlignedKeylineState(view.getContext(), f, containerWidth, f4, iMax, calculateMediumChildSize(extraSmallSize, f4, f5), f5 > BitmapDescriptorFactory.HUE_RED ? 1 : 0, extraSmallSize2);
    }

    private float calculateMediumChildSize(float f, float f2, float f3) {
        float fMax = Math.max(1.5f * f3, f);
        float f4 = 0.85f * f2;
        if (fMax > f4) {
            fMax = Math.max(f4, f3 * 1.2f);
        }
        return Math.min(f2, fMax);
    }

    private KeylineState createCenterAlignedKeylineState(float f, float f2, float f3, int i, float f4, float f5, float f6) {
        float fMin = Math.min(f5, f3);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMin, f3, f2);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(f4, f3, f2);
        float f7 = f4 / 2.0f;
        float f8 = (f6 + BitmapDescriptorFactory.HUE_RED) - f7;
        float f9 = f8 + f7;
        float f10 = fMin / 2.0f;
        float f11 = (i * f3) + f9;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f3, f).addAnchorKeyline((f8 - f7) - f10, childMaskPercentage, fMin).addKeyline(f8, childMaskPercentage2, f4, false).addKeylineRange((f3 / 2.0f) + f9, BitmapDescriptorFactory.HUE_RED, f3, i, true);
        builderAddKeylineRange.addKeyline(f7 + f11, childMaskPercentage2, f4, false);
        builderAddKeylineRange.addAnchorKeyline(f11 + f4 + f10, childMaskPercentage, fMin);
        return builderAddKeylineRange.build();
    }

    private KeylineState createLeftAlignedKeylineState(Context context, float f, float f2, float f3, int i, float f4, int i2, float f5) {
        float fMin = Math.min(f5, f3);
        float fMax = Math.max(fMin, 0.5f * f4);
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(fMax, f3, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(fMin, f3, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(f4, f3, f);
        float f6 = BitmapDescriptorFactory.HUE_RED - (fMax / 2.0f);
        float f7 = (i * f3) + BitmapDescriptorFactory.HUE_RED;
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(f3, f2).addAnchorKeyline(f6, childMaskPercentage, fMax).addKeylineRange(f3 / 2.0f, BitmapDescriptorFactory.HUE_RED, f3, i, true);
        if (i2 > 0) {
            float f8 = (f4 / 2.0f) + f7;
            f7 += f4;
            builderAddKeylineRange.addKeyline(f8, childMaskPercentage3, f4, false);
        }
        builderAddKeylineRange.addAnchorKeyline(f7 + (CarouselStrategyHelper.getExtraSmallSize(context) / 2.0f), childMaskPercentage2, fMin);
        return builderAddKeylineRange.build();
    }
}
