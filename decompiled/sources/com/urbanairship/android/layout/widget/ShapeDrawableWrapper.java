package com.urbanairship.android.layout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.android.layout.property.HorizontalPosition;
import com.urbanairship.android.layout.shape.Shape;
import com.urbanairship.android.layout.widget.DrawableWrapper;

/* loaded from: classes5.dex */
public class ShapeDrawableWrapper extends DrawableWrapper {
    private HorizontalPosition gravityPosition;
    private final ShapeState state;
    private final Rect tempRect;

    @Override // com.urbanairship.android.layout.widget.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.urbanairship.android.layout.widget.DrawableWrapper, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    /* synthetic */ ShapeDrawableWrapper(ShapeState shapeState, Resources resources, AnonymousClass1 anonymousClass1) {
        this(shapeState, resources);
    }

    public ShapeDrawableWrapper(@NonNull Context context, @NonNull Shape shape) {
        this(shape.getDrawable(context), shape.getAspectRatio(), shape.getScale(), null);
    }

    public ShapeDrawableWrapper(@NonNull Drawable drawable, float f, float f2, @Nullable HorizontalPosition horizontalPosition) {
        this(new ShapeState(null), (Resources) null);
        if (horizontalPosition != null) {
            this.gravityPosition = horizontalPosition;
        } else {
            this.gravityPosition = HorizontalPosition.CENTER;
        }
        ShapeState shapeState = this.state;
        shapeState.aspectRatio = f;
        shapeState.scale = f2;
        setDrawable(drawable);
    }

    @Override // com.urbanairship.android.layout.widget.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        int iWidth;
        int iHeight;
        Rect rect2 = this.tempRect;
        rect2.set(rect);
        float f = this.state.aspectRatio;
        if (f == 1.0f) {
            iWidth = Math.min(rect.width(), rect.height());
            iHeight = iWidth;
        } else if (f > 1.0f) {
            iWidth = rect.width();
            iHeight = (int) (rect.height() / this.state.aspectRatio);
        } else {
            iWidth = (int) (rect.width() * this.state.aspectRatio);
            iHeight = rect.height();
        }
        float f2 = this.state.scale;
        int i = (int) (iHeight * f2);
        int iWidth2 = (rect.width() - ((int) (iWidth * f2))) / 2;
        int iHeight2 = (rect.height() - i) / 2;
        int i2 = AnonymousClass1.$SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition[this.gravityPosition.ordinal()];
        if (i2 == 1) {
            rect2.left += iWidth2;
            rect2.right -= iWidth2;
        } else if (i2 == 2) {
            rect2.right -= iWidth2 * 2;
        } else if (i2 == 3) {
            rect2.left += iWidth2 * 2;
        }
        rect2.top += iHeight2;
        rect2.bottom -= iHeight2;
        super.onBoundsChange(rect2);
    }

    /* renamed from: com.urbanairship.android.layout.widget.ShapeDrawableWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition;

        static {
            int[] iArr = new int[HorizontalPosition.values().length];
            $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition = iArr;
            try {
                iArr[HorizontalPosition.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition[HorizontalPosition.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$urbanairship$android$layout$property$HorizontalPosition[HorizontalPosition.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        this.state.isChangingConfigurations |= getChangingConfigurations();
        return this.state;
    }

    static final class ShapeState extends DrawableWrapper.DrawableWrapperState {
        float aspectRatio;
        Drawable cachedDrawable;
        Drawable.ConstantState drawableState;
        int isChangingConfigurations;
        float scale;

        ShapeState(ShapeState shapeState) {
            super(shapeState, null);
            if (shapeState != null) {
                this.isChangingConfigurations = shapeState.isChangingConfigurations;
                this.drawableState = shapeState.drawableState;
                this.cachedDrawable = shapeState.cachedDrawable;
                this.scale = shapeState.scale;
                this.aspectRatio = shapeState.aspectRatio;
            }
        }

        @Override // com.urbanairship.android.layout.widget.DrawableWrapper.DrawableWrapperState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ShapeDrawableWrapper(this, resources, null);
        }
    }

    private ShapeDrawableWrapper(ShapeState shapeState, Resources resources) {
        super(shapeState, resources);
        this.tempRect = new Rect();
        this.state = shapeState;
        this.gravityPosition = HorizontalPosition.CENTER;
        updateLocalState();
    }

    private void updateLocalState() {
        Drawable drawable;
        ShapeState shapeState = this.state;
        if (shapeState == null || (drawable = shapeState.cachedDrawable) == null) {
            return;
        }
        setDrawable(drawable);
    }
}
