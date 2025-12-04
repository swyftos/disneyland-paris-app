package com.BV.LinearGradient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes2.dex */
public class LinearGradientView extends View {
    private float mAngle;
    private float[] mAngleCenter;
    private float[] mBorderRadii;
    private int[] mColors;
    private float[] mEndPoint;
    private float[] mLocations;
    private final Paint mPaint;
    private Path mPathForBorderRadius;
    private LinearGradient mShader;
    private int[] mSize;
    private float[] mStartPoint;
    private RectF mTempRectForBorderRadius;
    private boolean mUseAngle;

    public LinearGradientView(Context context) {
        super(context);
        this.mPaint = new Paint(1);
        this.mStartPoint = new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
        this.mEndPoint = new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f};
        this.mUseAngle = false;
        this.mAngleCenter = new float[]{0.5f, 0.5f};
        this.mAngle = 45.0f;
        this.mSize = new int[]{0, 0};
        this.mBorderRadii = new float[]{BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED};
    }

    private static float[] getStartCornerToIntersect(float f, int[] iArr) {
        float f2 = iArr[0] / 2.0f;
        float f3 = iArr[1] / 2.0f;
        if (f < 90.0f) {
            return new float[]{-f2, -f3};
        }
        if (f < 180.0f) {
            return new float[]{f2, -f3};
        }
        if (f < 270.0f) {
            return new float[]{f2, f3};
        }
        return new float[]{-f2, f3};
    }

    private static float[] getHorizontalOrVerticalStartPoint(float f, int[] iArr) {
        float f2 = iArr[0] / 2.0f;
        float f3 = iArr[1] / 2.0f;
        if (f == BitmapDescriptorFactory.HUE_RED) {
            return new float[]{-f2, BitmapDescriptorFactory.HUE_RED};
        }
        if (f == 90.0f) {
            return new float[]{BitmapDescriptorFactory.HUE_RED, -f3};
        }
        if (f == 180.0f) {
            return new float[]{f2, BitmapDescriptorFactory.HUE_RED};
        }
        return new float[]{BitmapDescriptorFactory.HUE_RED, f3};
    }

    private static float[] getGradientStartPoint(float f, int[] iArr) {
        float f2 = f % 360.0f;
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            f2 += 360.0f;
        }
        if (f2 % 90.0f == BitmapDescriptorFactory.HUE_RED) {
            return getHorizontalOrVerticalStartPoint(f2, iArr);
        }
        float fTan = (float) Math.tan((f2 * 3.141592653589793d) / 180.0d);
        float f3 = (-1.0f) / fTan;
        float[] startCornerToIntersect = getStartCornerToIntersect(f2, iArr);
        float f4 = (startCornerToIntersect[1] - (startCornerToIntersect[0] * f3)) / (fTan - f3);
        return new float[]{f4, fTan * f4};
    }

    public void setStartPoint(ReadableArray readableArray) {
        this.mStartPoint = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setEndPoint(ReadableArray readableArray) {
        this.mEndPoint = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setColors(ReadableArray readableArray) {
        int iIntValue;
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            if (readableArray.getType(i) == ReadableType.Map) {
                iIntValue = ColorPropConverter.getColor(readableArray.getMap(i), getContext()).intValue();
            } else {
                iIntValue = readableArray.getInt(i);
            }
            iArr[i] = iIntValue;
        }
        this.mColors = iArr;
        drawGradient();
    }

    public void setLocations(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.mLocations = fArr;
        drawGradient();
    }

    public void setUseAngle(boolean z) {
        this.mUseAngle = z;
        drawGradient();
    }

    public void setAngleCenter(ReadableArray readableArray) {
        this.mAngleCenter = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setAngle(float f) {
        this.mAngle = f;
        drawGradient();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        int size = readableArray.size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = PixelUtil.toPixelFromDIP((float) readableArray.getDouble(i));
        }
        this.mBorderRadii = fArr;
        updatePath();
        drawGradient();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSize = new int[]{i, i2};
        updatePath();
        drawGradient();
    }

    private void drawGradient() {
        float[] fArr;
        float[] fArr2;
        int[] iArr = this.mColors;
        if (iArr != null) {
            float[] fArr3 = this.mLocations;
            if (fArr3 == null || iArr.length == fArr3.length) {
                if (this.mUseAngle && this.mAngleCenter != null) {
                    float[] gradientStartPoint = getGradientStartPoint(90.0f - this.mAngle, this.mSize);
                    float[] fArr4 = this.mAngleCenter;
                    float f = fArr4[0];
                    int[] iArr2 = this.mSize;
                    float[] fArr5 = {f * iArr2[0], fArr4[1] * iArr2[1]};
                    fArr = new float[]{fArr5[0] + gradientStartPoint[0], fArr5[1] - gradientStartPoint[1]};
                    fArr2 = new float[]{fArr5[0] - gradientStartPoint[0], fArr5[1] + gradientStartPoint[1]};
                } else {
                    float[] fArr6 = this.mStartPoint;
                    float f2 = fArr6[0];
                    int[] iArr3 = this.mSize;
                    int i = iArr3[0];
                    float f3 = fArr6[1];
                    int i2 = iArr3[1];
                    fArr = new float[]{f2 * i, f3 * i2};
                    float[] fArr7 = this.mEndPoint;
                    fArr2 = new float[]{fArr7[0] * i, fArr7[1] * i2};
                }
                LinearGradient linearGradient = new LinearGradient(fArr[0], fArr[1], fArr2[0], fArr2[1], this.mColors, this.mLocations, Shader.TileMode.CLAMP);
                this.mShader = linearGradient;
                this.mPaint.setShader(linearGradient);
                invalidate();
            }
        }
    }

    private void updatePath() {
        if (this.mPathForBorderRadius == null) {
            this.mPathForBorderRadius = new Path();
            this.mTempRectForBorderRadius = new RectF();
        }
        this.mPathForBorderRadius.reset();
        RectF rectF = this.mTempRectForBorderRadius;
        int[] iArr = this.mSize;
        rectF.set(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, iArr[0], iArr[1]);
        this.mPathForBorderRadius.addRoundRect(this.mTempRectForBorderRadius, this.mBorderRadii, Path.Direction.CW);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.mPathForBorderRadius;
        if (path == null) {
            canvas.drawPaint(this.mPaint);
        } else {
            canvas.drawPath(path, this.mPaint);
        }
    }
}
