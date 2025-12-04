package com.bumptech.glide.integration.webp;

import androidx.annotation.Keep;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;

@Keep
/* loaded from: classes2.dex */
public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;

    @Keep
    private long mNativePtr;
    private int mWidth;

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i);

    private native int nativeGetSizeInBytes();

    static {
        System.loadLibrary("glide-webp");
    }

    public static WebpImage create(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArr.length);
        byteBufferAllocateDirect.put(bArr);
        byteBufferAllocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(byteBufferAllocateDirect);
    }

    @Keep
    WebpImage(long j, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        if (j == 0) {
            throw new RuntimeException("internal error: native WebpImage is 0");
        }
        this.mWidth = i;
        this.mHeigth = i2;
        this.mFrameCount = i3;
        this.mDurationMs = i4;
        this.mFrameDurations = iArr;
        this.mLoopCount = i5;
        fixFrameDurations(iArr);
        this.mBackgroundColor = i6;
        this.mNativePtr = j;
    }

    private void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 11) {
                iArr[i] = 100;
            }
        }
    }

    protected void finalize() throws Throwable {
        nativeFinalize();
    }

    public void dispose() {
        nativeDispose();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public WebpFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    public WebpFrameInfo getFrameInfo(int i) {
        WebpFrame frame = getFrame(i);
        try {
            return new WebpFrameInfo(i, frame);
        } finally {
            frame.dispose();
        }
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }
}
