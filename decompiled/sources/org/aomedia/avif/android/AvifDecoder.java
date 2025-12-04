package org.aomedia.avif.android;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class AvifDecoder {

    public static class Info {
        public int depth;
        public int height;
        public int width;
    }

    public static native boolean decode(ByteBuffer byteBuffer, int i, Bitmap bitmap);

    public static native boolean getInfo(ByteBuffer byteBuffer, int i, Info info);

    private static native boolean isAvifImage(ByteBuffer byteBuffer, int i);

    static {
        try {
            System.loadLibrary("avif_android");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static boolean isAvifImage(ByteBuffer byteBuffer) {
        return isAvifImage(byteBuffer, byteBuffer.remaining());
    }
}
