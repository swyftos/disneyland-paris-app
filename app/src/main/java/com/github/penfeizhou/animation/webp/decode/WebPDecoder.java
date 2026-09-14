package com.github.penfeizhou.animation.webp.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.webp.p033io.WebPReader;
import com.github.penfeizhou.animation.webp.p033io.WebPWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class WebPDecoder extends FrameSeqDecoder<WebPReader, WebPWriter> {
    private boolean alpha;
    private int backgroundColor;
    private int canvasHeight;
    private int canvasWidth;
    private int loopCount;
    private final Paint mTransparentFillPaint;
    private WebPWriter mWriter;
    private Paint paint;

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void release() {
    }

    public WebPDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        Paint paint = new Paint();
        this.mTransparentFillPaint = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public WebPWriter getWriter() {
        if (this.mWriter == null) {
            this.mWriter = new WebPWriter();
        }
        return this.mWriter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public WebPReader getReader(Reader reader) {
        return new WebPReader(reader);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected int getLoopCount() {
        return this.loopCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public Rect read(WebPReader webPReader) throws IOException {
        boolean z = false;
        boolean z2 = false;
        for (BaseChunk baseChunk : WebPParser.parse(webPReader)) {
            if (baseChunk instanceof VP8XChunk) {
                VP8XChunk vP8XChunk = (VP8XChunk) baseChunk;
                this.canvasWidth = vP8XChunk.canvasWidth;
                this.canvasHeight = vP8XChunk.canvasHeight;
                this.alpha = vP8XChunk.alpha();
                z2 = true;
            } else if (baseChunk instanceof ANIMChunk) {
                ANIMChunk aNIMChunk = (ANIMChunk) baseChunk;
                this.backgroundColor = aNIMChunk.backgroundColor;
                this.loopCount = aNIMChunk.loopCount;
                z = true;
            } else if (baseChunk instanceof ANMFChunk) {
                this.frames.add(new AnimationFrame(webPReader, (ANMFChunk) baseChunk));
            }
        }
        if (!z) {
            if (!z2) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(webPReader.toInputStream(), null, options);
                this.canvasWidth = options.outWidth;
                this.canvasHeight = options.outHeight;
            }
            this.frames.add(new StillFrame(webPReader, this.canvasWidth, this.canvasHeight));
            this.loopCount = 1;
        }
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        if (!this.alpha) {
            this.mTransparentFillPaint.setColor(this.backgroundColor);
        }
        return new Rect(0, 0, this.canvasWidth, this.canvasHeight);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void renderFrame(Frame<WebPReader, WebPWriter> frame) {
        Bitmap bitmapObtainBitmap;
        Bitmap bitmapObtainBitmap2;
        int i;
        if (frame == null || this.fullRect == null || this.fullRect.width() <= 0 || this.fullRect.height() <= 0 || (bitmapObtainBitmap = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize)) == null) {
            return;
        }
        Canvas canvas = this.cachedCanvas.get(bitmapObtainBitmap);
        if (canvas == null) {
            canvas = new Canvas(bitmapObtainBitmap);
            this.cachedCanvas.put(bitmapObtainBitmap, canvas);
        }
        this.frameBuffer.rewind();
        bitmapObtainBitmap.copyPixelsFromBuffer(this.frameBuffer);
        int i2 = this.frameIndex;
        if (i2 == 0) {
            if (this.alpha) {
                canvas.drawColor(0, PorterDuff.Mode.SRC);
            } else {
                canvas.drawColor(this.backgroundColor, PorterDuff.Mode.SRC);
            }
        } else {
            Frame frame2 = (Frame) this.frames.get(i2 - 1);
            if ((frame2 instanceof AnimationFrame) && ((AnimationFrame) frame2).disposalMethod) {
                int i3 = frame2.frameX;
                int i4 = this.sampleSize;
                int i5 = frame2.frameY;
                canvas.drawRect((i3 * 2.0f) / i4, (i5 * 2.0f) / i4, ((i3 * 2) + frame2.frameWidth) / i4, ((i5 * 2) + frame2.frameHeight) / i4, this.mTransparentFillPaint);
            }
        }
        int i6 = frame.frameWidth;
        if (i6 <= 0 || (i = frame.frameHeight) <= 0) {
            bitmapObtainBitmap2 = null;
        } else {
            int i7 = this.sampleSize;
            bitmapObtainBitmap2 = obtainBitmap(i6 / i7, i / i7);
        }
        recycleBitmap(frame.draw(canvas, this.paint, this.sampleSize, bitmapObtainBitmap2, getWriter()));
        recycleBitmap(bitmapObtainBitmap2);
        this.frameBuffer.rewind();
        bitmapObtainBitmap.copyPixelsToBuffer(this.frameBuffer);
        recycleBitmap(bitmapObtainBitmap);
    }
}
