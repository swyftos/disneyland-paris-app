package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.facebook.react.bridge.ReactContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class FeCompositeView extends FilterPrimitiveView {
    String mIn1;
    String mIn2;
    float mK1;
    float mK2;
    float mK3;
    float mK4;
    FilterProperties.FeCompositeOperator mOperator;

    public FeCompositeView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setIn1(String str) {
        this.mIn1 = str;
        invalidate();
    }

    public void setIn2(String str) {
        this.mIn2 = str;
        invalidate();
    }

    public void setK1(Float f) {
        this.mK1 = f.floatValue();
        invalidate();
    }

    public void setK2(Float f) {
        this.mK2 = f.floatValue();
        invalidate();
    }

    public void setK3(Float f) {
        this.mK3 = f.floatValue();
        invalidate();
    }

    public void setK4(Float f) {
        this.mK4 = f.floatValue();
        invalidate();
    }

    public void setOperator(String str) {
        this.mOperator = FilterProperties.FeCompositeOperator.getEnum(str);
        invalidate();
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public Bitmap applyFilter(HashMap<String, Bitmap> map, Bitmap bitmap) {
        Bitmap bitmap2;
        Canvas canvas;
        Bitmap source = FilterPrimitiveView.getSource(map, bitmap, this.mIn1);
        Bitmap source2 = FilterPrimitiveView.getSource(map, bitmap, this.mIn2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        canvas2.drawBitmap(source, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        switch (AnonymousClass1.$SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator[this.mOperator.ordinal()]) {
            case 1:
                bitmap2 = source2;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
                break;
            case 2:
                bitmap2 = source2;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                break;
            case 3:
                bitmap2 = source2;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                break;
            case 4:
                bitmap2 = source2;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                break;
            case 5:
                bitmap2 = source2;
                canvas = canvas2;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                break;
            case 6:
                int width = bitmapCreateBitmap.getWidth() * bitmapCreateBitmap.getHeight();
                int[] iArr = new int[width];
                int[] iArr2 = new int[width];
                bitmapCreateBitmap.getPixels(iArr, 0, bitmapCreateBitmap.getWidth(), 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                source2.getPixels(iArr2, 0, bitmapCreateBitmap.getWidth(), 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                int i = 0;
                while (i < width) {
                    int i2 = iArr[i];
                    int i3 = iArr2[i];
                    int i4 = width;
                    float f = this.mK1;
                    float f2 = (i2 >> 16) & 255;
                    float f3 = (i3 >> 16) & 255;
                    Bitmap bitmap3 = source2;
                    float f4 = this.mK2;
                    float f5 = (f * f2 * f3) + (f2 * f4);
                    float f6 = this.mK3;
                    float f7 = f5 + (f3 * f6);
                    float f8 = this.mK4;
                    Canvas canvas3 = canvas2;
                    float f9 = (i2 >> 8) & 255;
                    float f10 = (i3 >> 8) & 255;
                    int i5 = (int) ((f * f9 * f10) + (f9 * f4) + (f10 * f6) + f8);
                    float f11 = i2 & 255;
                    float f12 = i3 & 255;
                    int i6 = (int) ((f * f11 * f12) + (f11 * f4) + (f12 * f6) + f8);
                    float f13 = i2 >>> 24;
                    float f14 = i3 >>> 24;
                    iArr[i] = (Math.min(255, Math.max(0, (int) (((((f * f13) * f14) + (f4 * f13)) + (f6 * f14)) + f8))) << 24) | (Math.min(255, Math.max(0, (int) (f7 + f8))) << 16) | (Math.min(255, Math.max(0, i5)) << 8) | Math.min(255, Math.max(0, i6));
                    i++;
                    width = i4;
                    source2 = bitmap3;
                    canvas2 = canvas3;
                }
                bitmap2 = source2;
                canvas = canvas2;
                bitmapCreateBitmap.setPixels(iArr, 0, bitmapCreateBitmap.getWidth(), 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
                break;
            default:
                bitmap2 = source2;
                canvas = canvas2;
                break;
        }
        if (this.mOperator != FilterProperties.FeCompositeOperator.ARITHMETIC) {
            canvas.drawBitmap(bitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: com.horcrux.svg.FeCompositeView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator;

        static {
            int[] iArr = new int[FilterProperties.FeCompositeOperator.values().length];
            $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator = iArr;
            try {
                iArr[FilterProperties.FeCompositeOperator.OVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator[FilterProperties.FeCompositeOperator.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator[FilterProperties.FeCompositeOperator.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator[FilterProperties.FeCompositeOperator.ATOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator[FilterProperties.FeCompositeOperator.XOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeCompositeOperator[FilterProperties.FeCompositeOperator.ARITHMETIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }
}
