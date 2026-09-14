package com.github.penfeizhou.animation.avif.decode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.github.penfeizhou.animation.avif.p030io.AVIFReader;
import com.github.penfeizhou.animation.avif.p030io.AVIFWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.p032io.Reader;
import java.io.IOException;
import org.aomedia.avif.android.AvifDecoder;

/* JADX INFO: loaded from: classes3.dex */
public class AVIFDecoder extends FrameSeqDecoder<AVIFReader, AVIFWriter> {
    private AvifDecoder avifDecoder;

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public int getSampleSize() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public AVIFWriter getWriter() {
        return null;
    }

    public AVIFDecoder(Loader loader, @Nullable FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        this.avifDecoder = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public AVIFReader getReader(Reader reader) {
        return new AVIFReader(reader);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected int getLoopCount() {
        AvifDecoder avifDecoder = this.avifDecoder;
        if (avifDecoder == null) {
            return 0;
        }
        if (avifDecoder.getFrameCount() == 1) {
            return 1;
        }
        return this.avifDecoder.getRepetitionCount();
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void release() {
        AvifDecoder avifDecoder = this.avifDecoder;
        if (avifDecoder != null) {
            avifDecoder.release();
            this.avifDecoder = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public Rect read(AVIFReader aVIFReader) throws IOException {
        this.avifDecoder = AvifDecoder.create(aVIFReader.toDirectByteBuffer());
        return new Rect(0, 0, this.avifDecoder.getWidth(), this.avifDecoder.getHeight());
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public int getFrameCount() {
        AvifDecoder avifDecoder = this.avifDecoder;
        if (avifDecoder == null) {
            return 0;
        }
        return avifDecoder.getFrameCount();
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public Bitmap getFrameBitmap(int i) throws IOException {
        if (this.avifDecoder == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getBounds().width() / getSampleSize(), getBounds().height() / getSampleSize(), Bitmap.Config.ARGB_8888);
        this.avifDecoder.nthFrame(i, bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public Frame<AVIFReader, AVIFWriter> getFrame(int i) {
        AVIFFrame aVIFFrame = new AVIFFrame(null);
        aVIFFrame.index = i;
        aVIFFrame.frameDuration = (int) (this.avifDecoder.getFrameDurations()[i] * 1000.0d);
        return aVIFFrame;
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void renderFrame(Frame<AVIFReader, AVIFWriter> frame) {
        Bitmap bitmapObtainBitmap = obtainBitmap(this.avifDecoder.getWidth(), this.avifDecoder.getHeight());
        AvifDecoder avifDecoder = this.avifDecoder;
        if (avifDecoder == null) {
            return;
        }
        int i = this.frameIndex;
        int i2 = ((AVIFFrame) frame).index;
        if (i != i2) {
            avifDecoder.nthFrame(i2, bitmapObtainBitmap);
        } else if (i == 0) {
            avifDecoder.nthFrame(0, bitmapObtainBitmap);
        } else {
            avifDecoder.nextFrame(bitmapObtainBitmap);
        }
        this.frameBuffer.rewind();
        try {
            bitmapObtainBitmap.copyPixelsToBuffer(this.frameBuffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        recycleBitmap(bitmapObtainBitmap);
    }
}
