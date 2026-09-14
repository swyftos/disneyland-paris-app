package com.urbanairship.android.layout.widget;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.property.Position;
import com.urbanairship.android.layout.property.VerticalPosition;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u00030\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1836d2 = {"Lcom/urbanairship/android/layout/widget/CropImageDelegate;", "", "view", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "offsetHorizontal", "", "offsetVertical", "parentHeightSpec", "", "parentWidthSpec", "weakView", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "applyCropOffset", "", "onSizeChanged", "setImageDrawable", "setImagePosition", ViewProps.POSITION, "Lcom/urbanairship/android/layout/property/Position;", "setParentLayoutParams", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nCropImageDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CropImageDelegate.kt\ncom/urbanairship/android/layout/widget/CropImageDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,118:1\n1#2:119\n*E\n"})
public final class CropImageDelegate {
    private float offsetHorizontal;
    private float offsetVertical;
    private int parentHeightSpec;
    private int parentWidthSpec;
    private final WeakReference weakView;

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    public final void setImagePosition(@Nullable Position position) {
        float f;
        ImageView imageView = (ImageView) this.weakView.get();
        if (imageView == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        HorizontalPosition horizontal = position != null ? position.getHorizontal() : null;
        int i = horizontal == null ? -1 : WhenMappings.$EnumSwitchMapping$0[horizontal.ordinal()];
        float f2 = BitmapDescriptorFactory.HUE_RED;
        if (i == -1) {
            f = 0.5f;
        } else if (i == 1) {
            f = 0.0f;
        } else if (i == 2) {
            f = 0.5f;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            f = 1.0f;
        }
        this.offsetHorizontal = f;
        VerticalPosition vertical = position != null ? position.getVertical() : null;
        int i2 = vertical == null ? -1 : WhenMappings.$EnumSwitchMapping$1[vertical.ordinal()];
        if (i2 == -1) {
            f2 = 0.5f;
        } else if (i2 != 1) {
            if (i2 == 2) {
                f2 = 0.5f;
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f2 = 1.0f;
            }
        }
        this.offsetVertical = f2;
        applyCropOffset();
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
