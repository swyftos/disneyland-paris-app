package com.brentvatne.exoplayer;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.media3.common.Format;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0014J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aR$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/brentvatne/exoplayer/AspectRatioFrameLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "", "videoAspectRatio", "getVideoAspectRatio", "()F", "setVideoAspectRatio", "(F)V", "", ViewProps.RESIZE_MODE, "getResizeMode", "()I", "setResizeMode", "(I)V", "invalidateAspectRatio", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateAspectRatio", "format", "Landroidx/media3/common/Format;", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AspectRatioFrameLayout extends FrameLayout {
    private int resizeMode;
    private float videoAspectRatio;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectRatioFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final float getVideoAspectRatio() {
        return this.videoAspectRatio;
    }

    public final void setVideoAspectRatio(float f) {
        if (f == this.videoAspectRatio) {
            return;
        }
        this.videoAspectRatio = f;
        requestLayout();
    }

    public final int getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(int i) {
        if (i != this.resizeMode) {
            this.resizeMode = i;
            requestLayout();
        }
    }

    public final void invalidateAspectRatio() {
        setVideoAspectRatio(BitmapDescriptorFactory.HUE_RED);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f;
        float f2;
        float f3;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.videoAspectRatio == BitmapDescriptorFactory.HUE_RED) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f4 = measuredWidth;
        float f5 = measuredHeight;
        float f6 = (this.videoAspectRatio / (f4 / f5)) - 1;
        if (Math.abs(f6) <= 0.01f) {
            return;
        }
        int i = this.resizeMode;
        if (i == 1) {
            f = this.videoAspectRatio;
        } else {
            if (i == 2) {
                f3 = this.videoAspectRatio;
            } else {
                if (i != 3) {
                    if (i == 4) {
                        int i2 = (int) (this.videoAspectRatio * f5);
                        if (i2 < measuredWidth) {
                            float f7 = i2;
                            float f8 = f4 / f7;
                            measuredWidth = (int) (f7 * f8);
                            f2 = f8 * f5;
                            measuredHeight = (int) f2;
                        } else {
                            measuredWidth = i2;
                        }
                    } else if (f6 > BitmapDescriptorFactory.HUE_RED) {
                        f = this.videoAspectRatio;
                    } else {
                        f3 = this.videoAspectRatio;
                    }
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            measuredWidth = (int) (f5 * f3);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
        f2 = f4 / f;
        measuredHeight = (int) f2;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public final void updateAspectRatio(@NotNull Format format) {
        Intrinsics.checkNotNullParameter(format, "format");
        int i = format.rotationDegrees;
        if (i == 90 || i == 270) {
            int i2 = format.width;
            setVideoAspectRatio(i2 != 0 ? (format.height * format.pixelWidthHeightRatio) / i2 : 1.0f);
        } else {
            int i3 = format.height;
            setVideoAspectRatio(i3 != 0 ? (format.width * format.pixelWidthHeightRatio) / i3 : 1.0f);
        }
    }
}
