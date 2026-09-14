package com.github.penfeizhou.animation.gif.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.gif.p031io.GifReader;
import com.github.penfeizhou.animation.gif.p031io.GifWriter;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.p032io.Reader;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class GifDecoder extends FrameSeqDecoder<GifReader, GifWriter> {
    private int bgColor;
    private GifWriter mGifWriter;
    private int mLoopCount;
    private final Paint paint;
    private final SnapShot snapShot;

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected int getDesiredSample(int i, int i2) {
        return 1;
    }

    private static class SnapShot {
        ByteBuffer byteBuffer;

        private SnapShot() {
        }
    }

    public GifDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        this.mGifWriter = new GifWriter();
        Paint paint = new Paint();
        this.paint = paint;
        this.bgColor = 0;
        this.snapShot = new SnapShot();
        this.mLoopCount = 1;
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public GifWriter getWriter() {
        if (this.mGifWriter == null) {
            this.mGifWriter = new GifWriter();
        }
        return this.mGifWriter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public GifReader getReader(Reader reader) {
        return new GifReader(reader);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected int getLoopCount() {
        return this.mLoopCount;
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void release() {
        this.snapShot.byteBuffer = null;
        this.mGifWriter = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public Rect read(GifReader gifReader) throws IOException {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        ColorTable colorTable = null;
        GraphicControlExtension graphicControlExtension = null;
        for (Block block : GifParser.parse(gifReader)) {
            if (block instanceof LogicalScreenDescriptor) {
                LogicalScreenDescriptor logicalScreenDescriptor = (LogicalScreenDescriptor) block;
                i2 = logicalScreenDescriptor.screenWidth;
                i3 = logicalScreenDescriptor.screenHeight;
                if (logicalScreenDescriptor.gColorTableFlag()) {
                    i = logicalScreenDescriptor.bgColorIndex & 255;
                }
            } else if (block instanceof ColorTable) {
                colorTable = (ColorTable) block;
            } else if (block instanceof GraphicControlExtension) {
                graphicControlExtension = (GraphicControlExtension) block;
            } else if (block instanceof ImageDescriptor) {
                this.frames.add(new GifFrame(gifReader, colorTable, graphicControlExtension, (ImageDescriptor) block));
            } else if (block instanceof ApplicationExtension) {
                ApplicationExtension applicationExtension = (ApplicationExtension) block;
                if ("NETSCAPE2.0".equals(applicationExtension.identifier)) {
                    int i4 = applicationExtension.loopCount;
                    if (i4 == 0) {
                        this.mLoopCount = 0;
                    } else if (i4 > 0) {
                        this.mLoopCount = i4 + 1;
                    }
                }
            }
        }
        int i5 = this.sampleSize;
        long j = (((((long) i2) * ((long) i3)) / (((long) i5) * ((long) i5))) + 1) * 4;
        int i6 = (int) j;
        try {
            this.frameBuffer = ByteBuffer.allocate(i6);
            this.snapShot.byteBuffer = ByteBuffer.allocate(i6);
            if (colorTable != null && i >= 0 && i < colorTable.getColorTable().length) {
                int i7 = colorTable.getColorTable()[i];
                this.bgColor = Color.rgb(i7 & 255, (i7 >> 8) & 255, (i7 >> 16) & 255);
            }
            return new Rect(0, 0, i2, i3);
        } catch (OutOfMemoryError e) {
            Log.e("GifDecoder", String.format("OutOfMemoryError in GifDecoder: Buffer needed: %.2fMB (%,d bytes)", Double.valueOf(j / 1048576.0d), Long.valueOf(j)));
            this.frameBuffer = null;
            this.snapShot.byteBuffer = null;
            throw e;
        }
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void renderFrame(Frame<GifReader, GifWriter> frame) {
        GifFrame gifFrame = (GifFrame) frame;
        Bitmap bitmapObtainBitmap = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize);
        Canvas canvas = this.cachedCanvas.get(bitmapObtainBitmap);
        if (canvas == null) {
            canvas = new Canvas(bitmapObtainBitmap);
            this.cachedCanvas.put(bitmapObtainBitmap, canvas);
        }
        Canvas canvas2 = canvas;
        this.frameBuffer.rewind();
        bitmapObtainBitmap.copyPixelsFromBuffer(this.frameBuffer);
        int i = !gifFrame.transparencyFlag() ? this.bgColor : 0;
        int i2 = this.frameIndex;
        if (i2 == 0) {
            bitmapObtainBitmap.eraseColor(i);
        } else {
            GifFrame gifFrame2 = (GifFrame) this.frames.get(i2 - 1);
            canvas2.save();
            int i3 = gifFrame2.frameX;
            int i4 = this.sampleSize;
            int i5 = gifFrame2.frameY;
            canvas2.clipRect(i3 / i4, i5 / i4, (i3 + gifFrame2.frameWidth) / i4, (i5 + gifFrame2.frameHeight) / i4);
            int i6 = gifFrame2.disposalMethod;
            if (i6 == 2) {
                canvas2.drawColor(this.bgColor, PorterDuff.Mode.CLEAR);
            } else if (i6 == 3) {
                this.snapShot.byteBuffer.rewind();
                canvas2.drawColor(this.bgColor, PorterDuff.Mode.CLEAR);
                Bitmap bitmapObtainBitmap2 = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize);
                bitmapObtainBitmap2.copyPixelsFromBuffer(this.snapShot.byteBuffer);
                canvas2.drawBitmap(bitmapObtainBitmap2, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.paint);
                recycleBitmap(bitmapObtainBitmap2);
            }
            canvas2.restore();
            if (gifFrame.disposalMethod == 3 && gifFrame2.disposalMethod != 3) {
                this.frameBuffer.rewind();
                this.snapShot.byteBuffer.rewind();
                this.snapShot.byteBuffer.put(this.frameBuffer);
            }
        }
        int i7 = frame.frameWidth;
        int i8 = this.sampleSize;
        Bitmap bitmapObtainBitmap3 = obtainBitmap(i7 / i8, frame.frameHeight / i8);
        gifFrame.draw(canvas2, this.paint, this.sampleSize, bitmapObtainBitmap3, getWriter());
        canvas2.drawColor(i, PorterDuff.Mode.DST_OVER);
        recycleBitmap(bitmapObtainBitmap3);
        this.frameBuffer.rewind();
        bitmapObtainBitmap.copyPixelsToBuffer(this.frameBuffer);
        recycleBitmap(bitmapObtainBitmap);
    }
}
