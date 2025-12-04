package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class FeBlendView extends FilterPrimitiveView {
    String mIn1;
    String mIn2;
    FilterProperties.FeBlendMode mMode;

    public FeBlendView(ReactContext reactContext) {
        super(reactContext);
        this.mFilterSubregion.mX = new SVGLength(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mFilterSubregion.mY = new SVGLength(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.mFilterSubregion.mW = new SVGLength("100%");
        this.mFilterSubregion.mH = new SVGLength("100%");
    }

    public void setIn1(String str) {
        this.mIn1 = str;
        invalidate();
    }

    public void setIn2(String str) {
        this.mIn2 = str;
        invalidate();
    }

    public void setMode(String str) {
        this.mMode = FilterProperties.FeBlendMode.getEnum(str);
        invalidate();
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public Bitmap applyFilter(HashMap<String, Bitmap> map, Bitmap bitmap) {
        Bitmap source = FilterPrimitiveView.getSource(map, bitmap, this.mIn1);
        Bitmap source2 = FilterPrimitiveView.getSource(map, bitmap, this.mIn2);
        if (this.mMode == FilterProperties.FeBlendMode.MULTIPLY) {
            return CustomFilter.apply(source, source2, new CustomFilterFunction() { // from class: com.horcrux.svg.FeBlendView$$ExternalSyntheticLambda0
                @Override // com.horcrux.svg.CustomFilterFunction
                public final float[] execute(float[] fArr, float[] fArr2) {
                    return FeBlendView.lambda$applyFilter$0(fArr, fArr2);
                }
            });
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        canvas.drawBitmap(source, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[this.mMode.ordinal()];
        if (i == 1 || i == 2) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        } else if (i == 3) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        } else if (i == 4) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        } else if (i == 5) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
        }
        canvas.drawBitmap(source2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float[] lambda$applyFilter$0(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr2[0];
        float f3 = fArr[1];
        float f4 = fArr2[1];
        float f5 = (f3 * f * (1.0f - f2)) + (f4 * f2 * (1.0f - f)) + (f3 * f * f4 * f2);
        float f6 = fArr[2];
        float f7 = fArr2[2];
        float f8 = fArr[3];
        float f9 = fArr2[3];
        return new float[]{1.0f - ((1.0f - f) * (1.0f - f2)), f5, (f6 * f * (1.0f - f2)) + (f7 * f2 * (1.0f - f)) + (f6 * f * f7 * f2), (f8 * f * (1.0f - f2)) + (f9 * f2 * (1.0f - f)) + (f8 * f * f9 * f2)};
    }

    /* renamed from: com.horcrux.svg.FeBlendView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode;

        static {
            int[] iArr = new int[FilterProperties.FeBlendMode.values().length];
            $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode = iArr;
            try {
                iArr[FilterProperties.FeBlendMode.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties.FeBlendMode.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties.FeBlendMode.SCREEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties.FeBlendMode.LIGHTEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties.FeBlendMode.DARKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeBlendMode[FilterProperties.FeBlendMode.MULTIPLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
