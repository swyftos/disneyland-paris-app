package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.horcrux.svg.FilterProperties;
import java.util.HashMap;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
class FeColorMatrixView extends FilterPrimitiveView {
    String mIn1;
    FilterProperties.FeColorMatrixType mType;
    ReadableArray mValues;

    public FeColorMatrixView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setIn1(String str) {
        this.mIn1 = str;
        invalidate();
    }

    public void setType(String str) {
        this.mType = FilterProperties.FeColorMatrixType.getEnum(str);
        invalidate();
    }

    public void setValues(ReadableArray readableArray) {
        this.mValues = readableArray;
        invalidate();
    }

    @Override // com.horcrux.svg.FilterPrimitiveView
    public Bitmap applyFilter(HashMap<String, Bitmap> map, Bitmap bitmap) {
        Bitmap source = FilterPrimitiveView.getSource(map, bitmap, this.mIn1);
        ColorMatrix colorMatrix = new ColorMatrix();
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$FilterProperties$FeColorMatrixType[this.mType.ordinal()];
        if (i == 1) {
            if (this.mValues.size() < 20) {
                return source;
            }
            float[] fArr = new float[this.mValues.size()];
            for (int i2 = 0; i2 < this.mValues.size(); i2++) {
                fArr[i2] = ((float) this.mValues.getDouble(i2)) * (i2 % 5 == 4 ? 255 : 1);
            }
            colorMatrix.set(fArr);
        } else if (i == 2) {
            if (this.mValues.size() != 1) {
                return source;
            }
            colorMatrix.setSaturation((float) this.mValues.getDouble(0));
        } else if (i == 3) {
            if (this.mValues.size() != 1) {
                return source;
            }
            double d = (((float) this.mValues.getDouble(0)) * 3.141592653589793d) / 180.0d;
            float fCos = (float) Math.cos(d);
            float fSin = (float) Math.sin(d);
            float f = 0.715f - (fCos * 0.715f);
            float f2 = fSin * 0.715f;
            float f3 = 0.072f - (fCos * 0.072f);
            float f4 = 0.213f - (fCos * 0.213f);
            colorMatrix.set(new float[]{((fCos * 0.787f) + 0.213f) - (fSin * 0.213f), f - f2, f3 + (fSin * 0.928f), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f4 + (0.143f * fSin), (0.285f * fCos) + 0.715f + (0.14f * fSin), f3 - (0.283f * fSin), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, f4 - (0.787f * fSin), f + f2, (fCos * 0.928f) + 0.072f + (fSin * 0.072f), BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, BitmapDescriptorFactory.HUE_RED});
        } else if (i == 4) {
            colorMatrix.set(new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 0.2125f, 0.7154f, 0.0721f, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED});
        }
        return FilterUtils.getBitmapWithColorMatrix(colorMatrix, source);
    }

    /* renamed from: com.horcrux.svg.FeColorMatrixView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$FilterProperties$FeColorMatrixType;

        static {
            int[] iArr = new int[FilterProperties.FeColorMatrixType.values().length];
            $SwitchMap$com$horcrux$svg$FilterProperties$FeColorMatrixType = iArr;
            try {
                iArr[FilterProperties.FeColorMatrixType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeColorMatrixType[FilterProperties.FeColorMatrixType.SATURATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeColorMatrixType[FilterProperties.FeColorMatrixType.HUE_ROTATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$horcrux$svg$FilterProperties$FeColorMatrixType[FilterProperties.FeColorMatrixType.LUMINANCE_TO_ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
