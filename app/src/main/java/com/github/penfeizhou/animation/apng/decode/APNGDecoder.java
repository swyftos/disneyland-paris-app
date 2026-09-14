package com.github.penfeizhou.animation.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import com.github.penfeizhou.animation.apng.p029io.APNGReader;
import com.github.penfeizhou.animation.apng.p029io.APNGWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.p032io.Reader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class APNGDecoder extends FrameSeqDecoder<APNGReader, APNGWriter> {
    private static final String TAG = "APNGDecoder";
    private APNGWriter apngWriter;
    private int mLoopCount;
    private final Paint paint;
    private final SnapShot snapShot;

    private static class SnapShot {
        ByteBuffer byteBuffer;
        byte dispose_op;
        Rect dstRect;

        private SnapShot() {
            this.dstRect = new Rect();
        }
    }

    public APNGDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener) {
        super(loader, renderListener);
        Paint paint = new Paint();
        this.paint = paint;
        this.snapShot = new SnapShot();
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public APNGWriter getWriter() {
        if (this.apngWriter == null) {
            this.apngWriter = new APNGWriter();
        }
        return this.apngWriter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public APNGReader getReader(Reader reader) {
        return new APNGReader(reader);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected int getLoopCount() {
        return this.mLoopCount;
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void release() {
        this.snapShot.byteBuffer = null;
        this.apngWriter = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    public Rect read(APNGReader aPNGReader) throws IOException {
        List<Chunk> list = APNGParser.parse(aPNGReader);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        APNGFrame aPNGFrame = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (Chunk chunk : list) {
            boolean z2 = chunk instanceof IENDChunk;
            if (z2) {
                Log.e(TAG, "chunk read reach to end");
                break;
            }
            if (chunk instanceof ACTLChunk) {
                this.mLoopCount = ((ACTLChunk) chunk).num_plays;
                z = true;
            } else if (chunk instanceof FCTLChunk) {
                aPNGFrame = new APNGFrame(aPNGReader, (FCTLChunk) chunk);
                aPNGFrame.prefixChunks = arrayList;
                aPNGFrame.ihdrData = bArr;
                this.frames.add(aPNGFrame);
            } else if (chunk instanceof FDATChunk) {
                if (aPNGFrame != null) {
                    aPNGFrame.imageChunks.add(chunk);
                }
            } else if (chunk instanceof IDATChunk) {
                if (!z) {
                    StillFrame stillFrame = new StillFrame(aPNGReader);
                    stillFrame.frameWidth = i;
                    stillFrame.frameHeight = i2;
                    this.frames.add(stillFrame);
                    this.mLoopCount = 1;
                    break;
                }
                if (aPNGFrame != null) {
                    aPNGFrame.imageChunks.add(chunk);
                }
            } else if (chunk instanceof IHDRChunk) {
                IHDRChunk iHDRChunk = (IHDRChunk) chunk;
                i = iHDRChunk.width;
                i2 = iHDRChunk.height;
                bArr = iHDRChunk.data;
            } else if (!z2) {
                arrayList.add(chunk);
            }
        }
        int i3 = i * i2;
        int i4 = this.sampleSize;
        this.frameBuffer = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
        SnapShot snapShot = this.snapShot;
        int i5 = this.sampleSize;
        snapShot.byteBuffer = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder
    protected void renderFrame(Frame<APNGReader, APNGWriter> frame) {
        if (frame == null || this.fullRect == null) {
            return;
        }
        try {
            Bitmap bitmapObtainBitmap = obtainBitmap(this.fullRect.width() / this.sampleSize, this.fullRect.height() / this.sampleSize);
            Canvas canvas = this.cachedCanvas.get(bitmapObtainBitmap);
            if (canvas == null) {
                canvas = new Canvas(bitmapObtainBitmap);
                this.cachedCanvas.put(bitmapObtainBitmap, canvas);
            }
            Canvas canvas2 = canvas;
            if (frame instanceof APNGFrame) {
                this.frameBuffer.rewind();
                bitmapObtainBitmap.copyPixelsFromBuffer(this.frameBuffer);
                if (this.frameIndex == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.snapShot.dstRect);
                    SnapShot snapShot = this.snapShot;
                    byte b = snapShot.dispose_op;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        snapShot.byteBuffer.rewind();
                        bitmapObtainBitmap.copyPixelsFromBuffer(this.snapShot.byteBuffer);
                    }
                    canvas2.restore();
                }
                if (((APNGFrame) frame).dispose_op == 2) {
                    SnapShot snapShot2 = this.snapShot;
                    if (snapShot2.dispose_op != 2) {
                        snapShot2.byteBuffer.rewind();
                        bitmapObtainBitmap.copyPixelsToBuffer(this.snapShot.byteBuffer);
                    }
                }
                this.snapShot.dispose_op = ((APNGFrame) frame).dispose_op;
                canvas2.save();
                if (((APNGFrame) frame).blend_op == 0) {
                    int i = frame.frameX;
                    int i2 = this.sampleSize;
                    int i3 = frame.frameY;
                    canvas2.clipRect(i / i2, i3 / i2, (i + frame.frameWidth) / i2, (i3 + frame.frameHeight) / i2);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                Rect rect = this.snapShot.dstRect;
                int i4 = frame.frameX;
                int i5 = this.sampleSize;
                int i6 = frame.frameY;
                rect.set(i4 / i5, i6 / i5, (i4 + frame.frameWidth) / i5, (i6 + frame.frameHeight) / i5);
                canvas2.restore();
            }
            Bitmap bitmapObtainBitmap2 = obtainBitmap(frame.frameWidth, frame.frameHeight);
            recycleBitmap(frame.draw(canvas2, this.paint, this.sampleSize, bitmapObtainBitmap2, getWriter()));
            recycleBitmap(bitmapObtainBitmap2);
            this.frameBuffer.rewind();
            bitmapObtainBitmap.copyPixelsToBuffer(this.frameBuffer);
            recycleBitmap(bitmapObtainBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
