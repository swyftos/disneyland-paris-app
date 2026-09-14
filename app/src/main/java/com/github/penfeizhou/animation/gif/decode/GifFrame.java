package com.github.penfeizhou.animation.gif.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.gif.p031io.GifReader;
import com.github.penfeizhou.animation.gif.p031io.GifWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GifFrame extends Frame<GifReader, GifWriter> {
    private static final int DEFAULT_DELAY = 10;
    private static final ThreadLocal<byte[]> sDataBlock;
    public final ColorTable colorTable;
    public final int disposalMethod;
    private final int imageDataOffset;
    private final boolean interlace;
    private final int lzwMinCodeSize;
    public final int transparentColorIndex;

    private native void uncompressLZW(GifReader gifReader, int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, boolean z, byte[] bArr);

    static {
        System.loadLibrary("animation-decoder-gif");
        sDataBlock = new ThreadLocal<>();
    }

    public GifFrame(GifReader gifReader, ColorTable colorTable, @Nullable GraphicControlExtension graphicControlExtension, ImageDescriptor imageDescriptor) {
        super(gifReader);
        if (graphicControlExtension != null) {
            this.disposalMethod = graphicControlExtension.disposalMethod();
            int i = graphicControlExtension.delayTime;
            this.frameDuration = (i <= 0 ? 10 : i) * 10;
            if (graphicControlExtension.transparencyFlag()) {
                this.transparentColorIndex = graphicControlExtension.transparentColorIndex;
            } else {
                this.transparentColorIndex = -1;
            }
        } else {
            this.disposalMethod = 0;
            this.transparentColorIndex = -1;
        }
        this.frameX = imageDescriptor.frameX;
        this.frameY = imageDescriptor.frameY;
        this.frameWidth = imageDescriptor.frameWidth;
        this.frameHeight = imageDescriptor.frameHeight;
        this.interlace = imageDescriptor.interlaceFlag();
        if (imageDescriptor.localColorTableFlag()) {
            this.colorTable = imageDescriptor.localColorTable;
        } else {
            this.colorTable = colorTable;
        }
        this.lzwMinCodeSize = imageDescriptor.lzwMinimumCodeSize;
        this.imageDataOffset = imageDescriptor.imageDataOffset;
    }

    public boolean transparencyFlag() {
        return this.transparentColorIndex >= 0;
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, GifWriter gifWriter) {
        try {
            gifWriter.reset((this.frameWidth * this.frameHeight) / (i * i));
            encode(gifWriter.asIntArray(), i);
            bitmap.copyPixelsFromBuffer(gifWriter.asBuffer().rewind());
            Rect rect = this.srcRect;
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmap.getWidth();
            this.srcRect.bottom = bitmap.getHeight();
            Rect rect2 = this.dstRect;
            int i2 = this.frameX;
            float f = i;
            rect2.left = (int) (i2 / f);
            rect2.top = (int) (this.frameY / f);
            rect2.right = (int) ((i2 / f) + bitmap.getWidth());
            this.dstRect.bottom = (int) ((this.frameY / f) + bitmap.getHeight());
            canvas.drawBitmap(bitmap, this.srcRect, this.dstRect, paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void encode(int[] iArr, int i) throws IOException {
        ((GifReader) this.reader).reset();
        ((GifReader) this.reader).skip(this.imageDataOffset);
        ThreadLocal<byte[]> threadLocal = sDataBlock;
        byte[] bArr = threadLocal.get();
        if (bArr == null) {
            bArr = new byte[255];
            threadLocal.set(bArr);
        }
        uncompressLZW((GifReader) this.reader, this.colorTable.getColorTable(), this.transparentColorIndex, iArr, this.frameWidth / i, this.frameHeight / i, this.lzwMinCodeSize, this.interlace, bArr);
    }
}
