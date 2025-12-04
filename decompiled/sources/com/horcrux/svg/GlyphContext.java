package com.horcrux.svg;

import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
class GlyphContext {
    private double mDX;
    private int mDXIndex;
    private final ArrayList<Integer> mDXIndices;
    private SVGLength[] mDXs;
    private final ArrayList<SVGLength[]> mDXsContext;
    private int mDXsIndex;
    private final ArrayList<Integer> mDXsIndices;
    private double mDY;
    private int mDYIndex;
    private final ArrayList<Integer> mDYIndices;
    private SVGLength[] mDYs;
    private final ArrayList<SVGLength[]> mDYsContext;
    private int mDYsIndex;
    private final ArrayList<Integer> mDYsIndices;
    final ArrayList<FontData> mFontContext;
    private double mFontSize;
    private final float mHeight;
    private int mRIndex;
    private final ArrayList<Integer> mRIndices;
    private double[] mRs;
    private final ArrayList<double[]> mRsContext;
    private int mRsIndex;
    private final ArrayList<Integer> mRsIndices;
    private final float mScale;
    private int mTop;
    private final float mWidth;
    private double mX;
    private int mXIndex;
    private final ArrayList<Integer> mXIndices;
    private SVGLength[] mXs;
    private final ArrayList<SVGLength[]> mXsContext;
    private int mXsIndex;
    private final ArrayList<Integer> mXsIndices;
    private double mY;
    private int mYIndex;
    private final ArrayList<Integer> mYIndices;
    private SVGLength[] mYs;
    private final ArrayList<SVGLength[]> mYsContext;
    private int mYsIndex;
    private final ArrayList<Integer> mYsIndices;
    private FontData topFont;

    private void pushIndices() {
        this.mXsIndices.add(Integer.valueOf(this.mXsIndex));
        this.mYsIndices.add(Integer.valueOf(this.mYsIndex));
        this.mDXsIndices.add(Integer.valueOf(this.mDXsIndex));
        this.mDYsIndices.add(Integer.valueOf(this.mDYsIndex));
        this.mRsIndices.add(Integer.valueOf(this.mRsIndex));
    }

    GlyphContext(float f, float f2, float f3) {
        ArrayList<FontData> arrayList = new ArrayList<>();
        this.mFontContext = arrayList;
        ArrayList<SVGLength[]> arrayList2 = new ArrayList<>();
        this.mXsContext = arrayList2;
        ArrayList<SVGLength[]> arrayList3 = new ArrayList<>();
        this.mYsContext = arrayList3;
        ArrayList<SVGLength[]> arrayList4 = new ArrayList<>();
        this.mDXsContext = arrayList4;
        ArrayList<SVGLength[]> arrayList5 = new ArrayList<>();
        this.mDYsContext = arrayList5;
        ArrayList<double[]> arrayList6 = new ArrayList<>();
        this.mRsContext = arrayList6;
        ArrayList<Integer> arrayList7 = new ArrayList<>();
        this.mXIndices = arrayList7;
        ArrayList<Integer> arrayList8 = new ArrayList<>();
        this.mYIndices = arrayList8;
        ArrayList<Integer> arrayList9 = new ArrayList<>();
        this.mDXIndices = arrayList9;
        ArrayList<Integer> arrayList10 = new ArrayList<>();
        this.mDYIndices = arrayList10;
        ArrayList<Integer> arrayList11 = new ArrayList<>();
        this.mRIndices = arrayList11;
        this.mXsIndices = new ArrayList<>();
        this.mYsIndices = new ArrayList<>();
        this.mDXsIndices = new ArrayList<>();
        this.mDYsIndices = new ArrayList<>();
        this.mRsIndices = new ArrayList<>();
        this.mFontSize = 12.0d;
        this.topFont = FontData.Defaults;
        SVGLength[] sVGLengthArr = new SVGLength[0];
        this.mXs = sVGLengthArr;
        this.mYs = new SVGLength[0];
        this.mDXs = new SVGLength[0];
        this.mDYs = new SVGLength[0];
        this.mRs = new double[]{AudioStats.AUDIO_AMPLITUDE_NONE};
        this.mXIndex = -1;
        this.mYIndex = -1;
        this.mDXIndex = -1;
        this.mDYIndex = -1;
        this.mRIndex = -1;
        this.mScale = f;
        this.mWidth = f2;
        this.mHeight = f3;
        arrayList2.add(sVGLengthArr);
        arrayList3.add(this.mYs);
        arrayList4.add(this.mDXs);
        arrayList5.add(this.mDYs);
        arrayList6.add(this.mRs);
        arrayList7.add(Integer.valueOf(this.mXIndex));
        arrayList8.add(Integer.valueOf(this.mYIndex));
        arrayList9.add(Integer.valueOf(this.mDXIndex));
        arrayList10.add(Integer.valueOf(this.mDYIndex));
        arrayList11.add(Integer.valueOf(this.mRIndex));
        arrayList.add(this.topFont);
        pushIndices();
    }

    private void reset() {
        this.mRsIndex = 0;
        this.mDYsIndex = 0;
        this.mDXsIndex = 0;
        this.mYsIndex = 0;
        this.mXsIndex = 0;
        this.mRIndex = -1;
        this.mDYIndex = -1;
        this.mDXIndex = -1;
        this.mYIndex = -1;
        this.mXIndex = -1;
        this.mDY = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mDX = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mY = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mX = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    FontData getFont() {
        return this.topFont;
    }

    private FontData getTopOrParentFont(GroupView groupView) {
        if (this.mTop > 0) {
            return this.topFont;
        }
        for (GroupView parentTextRoot = groupView.getParentTextRoot(); parentTextRoot != null; parentTextRoot = parentTextRoot.getParentTextRoot()) {
            FontData font = parentTextRoot.getGlyphContext().getFont();
            if (font != FontData.Defaults) {
                return font;
            }
        }
        return FontData.Defaults;
    }

    private void pushNodeAndFont(GroupView groupView, @Nullable ReadableMap readableMap) {
        FontData topOrParentFont = getTopOrParentFont(groupView);
        this.mTop++;
        if (readableMap == null) {
            this.mFontContext.add(topOrParentFont);
            return;
        }
        FontData fontData = new FontData(readableMap, topOrParentFont, this.mScale);
        this.mFontSize = fontData.fontSize;
        this.mFontContext.add(fontData);
        this.topFont = fontData;
    }

    void pushContext(GroupView groupView, @Nullable ReadableMap readableMap) {
        pushNodeAndFont(groupView, readableMap);
        pushIndices();
    }

    private SVGLength[] getStringArrayFromReadableArray(ArrayList<SVGLength> arrayList) {
        int size = arrayList.size();
        SVGLength[] sVGLengthArr = new SVGLength[size];
        for (int i = 0; i < size; i++) {
            sVGLengthArr[i] = arrayList.get(i);
        }
        return sVGLengthArr;
    }

    private double[] getDoubleArrayFromReadableArray(ArrayList<SVGLength> arrayList) {
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = arrayList.get(i).value;
        }
        return dArr;
    }

    void pushContext(boolean z, TextView textView, @Nullable ReadableMap readableMap, @Nullable ArrayList<SVGLength> arrayList, @Nullable ArrayList<SVGLength> arrayList2, @Nullable ArrayList<SVGLength> arrayList3, @Nullable ArrayList<SVGLength> arrayList4, @Nullable ArrayList<SVGLength> arrayList5) {
        if (z) {
            reset();
        }
        pushNodeAndFont(textView, readableMap);
        if (arrayList != null && arrayList.size() != 0) {
            this.mXsIndex++;
            this.mXIndex = -1;
            this.mXIndices.add(-1);
            SVGLength[] stringArrayFromReadableArray = getStringArrayFromReadableArray(arrayList);
            this.mXs = stringArrayFromReadableArray;
            this.mXsContext.add(stringArrayFromReadableArray);
        }
        if (arrayList2 != null && arrayList2.size() != 0) {
            this.mYsIndex++;
            this.mYIndex = -1;
            this.mYIndices.add(-1);
            SVGLength[] stringArrayFromReadableArray2 = getStringArrayFromReadableArray(arrayList2);
            this.mYs = stringArrayFromReadableArray2;
            this.mYsContext.add(stringArrayFromReadableArray2);
        }
        if (arrayList3 != null && arrayList3.size() != 0) {
            this.mDXsIndex++;
            this.mDXIndex = -1;
            this.mDXIndices.add(-1);
            SVGLength[] stringArrayFromReadableArray3 = getStringArrayFromReadableArray(arrayList3);
            this.mDXs = stringArrayFromReadableArray3;
            this.mDXsContext.add(stringArrayFromReadableArray3);
        }
        if (arrayList4 != null && arrayList4.size() != 0) {
            this.mDYsIndex++;
            this.mDYIndex = -1;
            this.mDYIndices.add(-1);
            SVGLength[] stringArrayFromReadableArray4 = getStringArrayFromReadableArray(arrayList4);
            this.mDYs = stringArrayFromReadableArray4;
            this.mDYsContext.add(stringArrayFromReadableArray4);
        }
        if (arrayList5 != null && arrayList5.size() != 0) {
            this.mRsIndex++;
            this.mRIndex = -1;
            this.mRIndices.add(-1);
            double[] doubleArrayFromReadableArray = getDoubleArrayFromReadableArray(arrayList5);
            this.mRs = doubleArrayFromReadableArray;
            this.mRsContext.add(doubleArrayFromReadableArray);
        }
        pushIndices();
    }

    void popContext() {
        this.mFontContext.remove(this.mTop);
        this.mXsIndices.remove(this.mTop);
        this.mYsIndices.remove(this.mTop);
        this.mDXsIndices.remove(this.mTop);
        this.mDYsIndices.remove(this.mTop);
        this.mRsIndices.remove(this.mTop);
        int i = this.mTop - 1;
        this.mTop = i;
        int i2 = this.mXsIndex;
        int i3 = this.mYsIndex;
        int i4 = this.mDXsIndex;
        int i5 = this.mDYsIndex;
        int i6 = this.mRsIndex;
        this.topFont = this.mFontContext.get(i);
        this.mXsIndex = this.mXsIndices.get(this.mTop).intValue();
        this.mYsIndex = this.mYsIndices.get(this.mTop).intValue();
        this.mDXsIndex = this.mDXsIndices.get(this.mTop).intValue();
        this.mDYsIndex = this.mDYsIndices.get(this.mTop).intValue();
        this.mRsIndex = this.mRsIndices.get(this.mTop).intValue();
        if (i2 != this.mXsIndex) {
            this.mXsContext.remove(i2);
            this.mXs = this.mXsContext.get(this.mXsIndex);
            this.mXIndex = this.mXIndices.get(this.mXsIndex).intValue();
        }
        if (i3 != this.mYsIndex) {
            this.mYsContext.remove(i3);
            this.mYs = this.mYsContext.get(this.mYsIndex);
            this.mYIndex = this.mYIndices.get(this.mYsIndex).intValue();
        }
        if (i4 != this.mDXsIndex) {
            this.mDXsContext.remove(i4);
            this.mDXs = this.mDXsContext.get(this.mDXsIndex);
            this.mDXIndex = this.mDXIndices.get(this.mDXsIndex).intValue();
        }
        if (i5 != this.mDYsIndex) {
            this.mDYsContext.remove(i5);
            this.mDYs = this.mDYsContext.get(this.mDYsIndex);
            this.mDYIndex = this.mDYIndices.get(this.mDYsIndex).intValue();
        }
        if (i6 != this.mRsIndex) {
            this.mRsContext.remove(i6);
            this.mRs = this.mRsContext.get(this.mRsIndex);
            this.mRIndex = this.mRIndices.get(this.mRsIndex).intValue();
        }
    }

    private static void incrementIndices(ArrayList<Integer> arrayList, int i) {
        while (i >= 0) {
            arrayList.set(i, Integer.valueOf(arrayList.get(i).intValue() + 1));
            i--;
        }
    }

    double getFontSize() {
        return this.mFontSize;
    }

    double nextX(double d) {
        incrementIndices(this.mXIndices, this.mXsIndex);
        int i = this.mXIndex + 1;
        SVGLength[] sVGLengthArr = this.mXs;
        if (i < sVGLengthArr.length) {
            this.mDX = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.mXIndex = i;
            this.mX = PropHelper.fromRelative(sVGLengthArr[i], this.mWidth, AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, this.mFontSize);
        }
        double d2 = this.mX + d;
        this.mX = d2;
        return d2;
    }

    double nextY() {
        incrementIndices(this.mYIndices, this.mYsIndex);
        int i = this.mYIndex + 1;
        SVGLength[] sVGLengthArr = this.mYs;
        if (i < sVGLengthArr.length) {
            this.mDY = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.mYIndex = i;
            this.mY = PropHelper.fromRelative(sVGLengthArr[i], this.mHeight, AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, this.mFontSize);
        }
        return this.mY;
    }

    double nextDeltaX() {
        incrementIndices(this.mDXIndices, this.mDXsIndex);
        int i = this.mDXIndex + 1;
        SVGLength[] sVGLengthArr = this.mDXs;
        if (i < sVGLengthArr.length) {
            this.mDXIndex = i;
            this.mDX += PropHelper.fromRelative(sVGLengthArr[i], this.mWidth, AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, this.mFontSize);
        }
        return this.mDX;
    }

    double nextDeltaY() {
        incrementIndices(this.mDYIndices, this.mDYsIndex);
        int i = this.mDYIndex + 1;
        SVGLength[] sVGLengthArr = this.mDYs;
        if (i < sVGLengthArr.length) {
            this.mDYIndex = i;
            this.mDY += PropHelper.fromRelative(sVGLengthArr[i], this.mHeight, AudioStats.AUDIO_AMPLITUDE_NONE, this.mScale, this.mFontSize);
        }
        return this.mDY;
    }

    double nextRotation() {
        incrementIndices(this.mRIndices, this.mRsIndex);
        int iMin = Math.min(this.mRIndex + 1, this.mRs.length - 1);
        this.mRIndex = iMin;
        return this.mRs[iMin];
    }

    float getWidth() {
        return this.mWidth;
    }

    float getHeight() {
        return this.mHeight;
    }
}
