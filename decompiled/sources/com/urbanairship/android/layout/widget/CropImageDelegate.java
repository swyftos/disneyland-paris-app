package com.urbanairship.android.layout.widget;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.property.VerticalPosition;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/layout/widget/CropImageDelegate;", "", "view", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "offsetHorizontal", "", "offsetVertical", "parentHeightSpec", "", "parentWidthSpec", "weakView", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "applyCropOffset", "", "onSizeChanged", "setImageDrawable", "setImagePosition", ViewProps.POSITION, "Lcom/urbanairship/android/layout/property/Position;", "setParentLayoutParams", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCropImageDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CropImageDelegate.kt\ncom/urbanairship/android/layout/widget/CropImageDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n1#2:119\n*E\n"})
/* loaded from: classes5.dex */
public final class CropImageDelegate {
    private float offsetHorizontal;
    private float offsetVertical;
    private int parentHeightSpec;
    private int parentWidthSpec;
    private final WeakReference weakView;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[HorizontalPosition.values().length];
            try {
                iArr[HorizontalPosition.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HorizontalPosition.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HorizontalPosition.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VerticalPosition.values().length];
            try {
                iArr2[VerticalPosition.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[VerticalPosition.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[VerticalPosition.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public CropImageDelegate(@NotNull ImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.weakView = new WeakReference(view);
        this.offsetHorizontal = 0.5f;
        this.offsetVertical = 0.5f;
        view.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void onSizeChanged() {
        applyCropOffset();
    }

    public final void setImageDrawable() {
        applyCropOffset();
    }

    public final void setParentLayoutParams(@Nullable ViewGroup.LayoutParams layoutParams) {
        this.parentWidthSpec = layoutParams != null ? layoutParams.width : 0;
        this.parentHeightSpec = layoutParams != null ? layoutParams.height : 0;
        applyCropOffset();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setImagePosition(@org.jetbrains.annotations.Nullable com.urbanairship.android.layout.property.Position r10) {
        /*
            r9 = this;
            java.lang.ref.WeakReference r0 = r9.weakView
            java.lang.Object r0 = r0.get()
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 != 0) goto Lb
            return
        Lb:
            android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.MATRIX
            r0.setScaleType(r1)
            r0 = 0
            if (r10 == 0) goto L18
            com.urbanairship.android.layout.property.HorizontalPosition r1 = r10.getHorizontal()
            goto L19
        L18:
            r1 = r0
        L19:
            r2 = -1
            if (r1 != 0) goto L1e
            r1 = r2
            goto L26
        L1e:
            int[] r3 = com.urbanairship.android.layout.widget.CropImageDelegate.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
        L26:
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 1056964608(0x3f000000, float:0.5)
            if (r1 == r2) goto L3e
            if (r1 == r7) goto L40
            if (r1 == r6) goto L3e
            if (r1 != r5) goto L38
            r1 = r4
            goto L41
        L38:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L3e:
            r1 = r8
            goto L41
        L40:
            r1 = r3
        L41:
            r9.offsetHorizontal = r1
            if (r10 == 0) goto L49
            com.urbanairship.android.layout.property.VerticalPosition r0 = r10.getVertical()
        L49:
            if (r0 != 0) goto L4d
            r10 = r2
            goto L55
        L4d:
            int[] r10 = com.urbanairship.android.layout.widget.CropImageDelegate.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r10 = r10[r0]
        L55:
            if (r10 == r2) goto L65
            if (r10 == r7) goto L66
            if (r10 == r6) goto L65
            if (r10 != r5) goto L5f
            r3 = r4
            goto L66
        L5f:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        L65:
            r3 = r8
        L66:
            r9.offsetVertical = r3
            r9.applyCropOffset()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.widget.CropImageDelegate.setImagePosition(com.urbanairship.android.layout.property.Position):void");
    }

    private final void applyCropOffset() {
        Drawable drawable;
        float f;
        float f2;
        ImageView imageView = (ImageView) this.weakView.get();
        if (imageView == null || (drawable = imageView.getDrawable()) == null || imageView.getScaleType() != ImageView.ScaleType.MATRIX) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        int i = this.parentWidthSpec;
        if (!(i == -1 && this.parentHeightSpec == -2) && ((this.parentHeightSpec == -1 && i == -2) || intrinsicWidth * height > intrinsicHeight * width)) {
            f = height;
            f2 = intrinsicHeight;
        } else {
            f = width;
            f2 = intrinsicWidth;
        }
        float f3 = f / f2;
        float f4 = width;
        float f5 = f4 / f3;
        float f6 = height;
        float f7 = f6 / f3;
        float f8 = this.offsetHorizontal * (intrinsicWidth - f5);
        float f9 = this.offsetVertical * (intrinsicHeight - f7);
        RectF rectF = new RectF(f8, f9, f5 + f8, f7 + f9);
        RectF rectF2 = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f4, f6);
        Matrix imageMatrix = imageView.getImageMatrix();
        imageMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
        Intrinsics.checkNotNullExpressionValue(imageMatrix, "apply(...)");
        imageView.setImageMatrix(imageMatrix);
    }
}
