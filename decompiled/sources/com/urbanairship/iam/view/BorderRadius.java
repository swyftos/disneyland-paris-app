package com.urbanairship.iam.view;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.contentsquare.android.api.Currencies;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/view/BorderRadius;", "", "()V", "ALL", "", "BOTTOM", "BOTTOM_LEFT", "BOTTOM_RIGHT", "LEFT", "RIGHT", Currencies.AlphabeticCode.TOP_STR, "TOP_LEFT", "TOP_RIGHT", "applyBorderRadiusPadding", "", "view", "Landroid/view/View;", "borderRadius", "", "borderRadiusFlag", "createRadiiArray", "", "pixels", "BorderRadiusFlag", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BorderRadius {
    public static final int ALL = 15;
    public static final int BOTTOM = 12;
    public static final int BOTTOM_LEFT = 8;
    public static final int BOTTOM_RIGHT = 4;

    @NotNull
    public static final BorderRadius INSTANCE = new BorderRadius();
    public static final int LEFT = 9;
    public static final int RIGHT = 6;
    public static final int TOP = 3;
    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 2;

    @Target({ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/urbanairship/iam/view/BorderRadius$BorderRadiusFlag;", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface BorderRadiusFlag {
    }

    private BorderRadius() {
    }

    @NotNull
    public final float[] createRadiiArray(float pixels, int borderRadiusFlag) {
        float[] fArr = new float[8];
        if ((borderRadiusFlag & 1) == 1) {
            fArr[0] = pixels;
            fArr[1] = pixels;
        }
        if ((borderRadiusFlag & 2) == 2) {
            fArr[2] = pixels;
            fArr[3] = pixels;
        }
        if ((borderRadiusFlag & 4) == 4) {
            fArr[4] = pixels;
            fArr[5] = pixels;
        }
        if ((borderRadiusFlag & 8) == 8) {
            fArr[6] = pixels;
            fArr[7] = pixels;
        }
        return fArr;
    }

    public final void applyBorderRadiusPadding(@NotNull View view, final float borderRadius, final int borderRadiusFlag) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getWidth() == 0) {
            final WeakReference weakReference = new WeakReference(view);
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.iam.view.BorderRadius.applyBorderRadiusPadding.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    View view2 = (View) weakReference.get();
                    if (view2 == null) {
                        return false;
                    }
                    BorderRadius.INSTANCE.applyBorderRadiusPadding(view2, borderRadius, borderRadiusFlag);
                    view2.getViewTreeObserver().removeOnPreDrawListener(this);
                    return false;
                }
            });
        }
        float fMin = Math.min(TypedValue.applyDimension(1, borderRadius, view.getResources().getDisplayMetrics()), RangesKt.coerceAtMost(view.getHeight() / 2, view.getWidth() / 2));
        float fSin = ((float) Math.sin(Math.toRadians(45.0d))) * fMin;
        float fSin2 = ((float) Math.sin(Math.toRadians(45.0d))) * fMin;
        int iRound = Math.round(fMin - fSin);
        int iRound2 = Math.round(fMin - fSin2);
        int i4 = 0;
        if ((borderRadiusFlag & 1) == 1) {
            i2 = iRound2;
            i = iRound;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((borderRadiusFlag & 2) == 2) {
            i2 = iRound2;
            i3 = iRound;
        } else {
            i3 = 0;
        }
        if ((borderRadiusFlag & 4) == 4) {
            i4 = iRound2;
            i3 = iRound;
        }
        if ((borderRadiusFlag & 8) != 8) {
            iRound = i;
            iRound2 = i4;
        }
        view.setPadding(view.getPaddingLeft() + iRound, view.getPaddingTop() + i2, view.getPaddingRight() + i3, view.getPaddingBottom() + iRound2);
    }
}
