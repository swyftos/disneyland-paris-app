package com.github.penfeizhou.animation.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.fasterxml.jackson.dataformat.cbor.CBORConstants;
import com.github.penfeizhou.animation.apng.p029io.APNGReader;
import com.github.penfeizhou.animation.apng.p029io.APNGWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public class APNGFrame extends Frame<APNGReader, APNGWriter> {
    public final byte blend_op;
    public final byte dispose_op;
    byte[] ihdrData;
    List imageChunks;
    List prefixChunks;
    private static final byte[] sPNGSignatures = {-119, 80, 78, 71, Ascii.f3522CR, 10, Ascii.SUB, 10};
    private static final byte[] sPNGEndChunk = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, CBORConstants.BYTE_EMPTY_STRING, CBORConstants.BYTE_ARRAY_2_ELEMENTS};
    private static final ThreadLocal sCRC32 = new ThreadLocal();

    private CRC32 getCRC32() {
        ThreadLocal threadLocal = sCRC32;
        CRC32 crc32 = (CRC32) threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc33 = new CRC32();
        threadLocal.set(crc33);
        return crc33;
    }

    public APNGFrame(APNGReader aPNGReader, FCTLChunk fCTLChunk) {
        super(aPNGReader);
        this.imageChunks = new ArrayList();
        this.prefixChunks = new ArrayList();
        this.blend_op = fCTLChunk.blend_op;
        this.dispose_op = fCTLChunk.dispose_op;
        int i = fCTLChunk.delay_num * 1000;
        short s = fCTLChunk.delay_den;
        int i2 = i / (s == 0 ? (short) 100 : s);
        this.frameDuration = i2;
        if (i2 < 10) {
            this.frameDuration = 100;
        }
        this.frameWidth = fCTLChunk.width;
        this.frameHeight = fCTLChunk.height;
        this.frameX = fCTLChunk.x_offset;
        this.frameY = fCTLChunk.y_offset;
    }

    private int encode(APNGWriter aPNGWriter) throws IOException {
        int i;
        Iterator it = this.prefixChunks.iterator();
        int i2 = 33;
        while (it.hasNext()) {
            i2 += ((Chunk) it.next()).length + 12;
        }
        for (Chunk chunk : this.imageChunks) {
            if (chunk instanceof IDATChunk) {
                i = chunk.length + 12;
            } else if (chunk instanceof FDATChunk) {
                i = chunk.length + 8;
            }
            i2 += i;
        }
        int length = i2 + sPNGEndChunk.length;
        aPNGWriter.reset(length);
        aPNGWriter.putBytes(sPNGSignatures);
        aPNGWriter.writeInt(13);
        int iPosition = aPNGWriter.position();
        aPNGWriter.writeFourCC(IHDRChunk.f3437ID);
        aPNGWriter.writeInt(this.frameWidth);
        aPNGWriter.writeInt(this.frameHeight);
        aPNGWriter.putBytes(this.ihdrData);
        CRC32 crc32 = getCRC32();
        crc32.reset();
        crc32.update(aPNGWriter.toByteArray(), iPosition, 17);
        aPNGWriter.writeInt((int) crc32.getValue());
        for (Chunk chunk2 : this.prefixChunks) {
            if (!(chunk2 instanceof IENDChunk)) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk2.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk2.length + 12);
                aPNGWriter.skip(chunk2.length + 12);
            }
        }
        for (Chunk chunk3 : this.imageChunks) {
            if (chunk3 instanceof IDATChunk) {
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk3.offset);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk3.length + 12);
                aPNGWriter.skip(chunk3.length + 12);
            } else if (chunk3 instanceof FDATChunk) {
                aPNGWriter.writeInt(chunk3.length - 4);
                int iPosition2 = aPNGWriter.position();
                aPNGWriter.writeFourCC(IDATChunk.f3435ID);
                ((APNGReader) this.reader).reset();
                ((APNGReader) this.reader).skip(chunk3.offset + 12);
                ((APNGReader) this.reader).read(aPNGWriter.toByteArray(), aPNGWriter.position(), chunk3.length - 4);
                aPNGWriter.skip(chunk3.length - 4);
                crc32.reset();
                crc32.update(aPNGWriter.toByteArray(), iPosition2, chunk3.length);
                aPNGWriter.writeInt((int) crc32.getValue());
            }
        }
        aPNGWriter.putBytes(sPNGEndChunk);
        return length;
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, APNGWriter aPNGWriter) {
        Bitmap bitmapDecodeByteArray;
        try {
            int iEncode = encode(aPNGWriter);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] byteArray = aPNGWriter.toByteArray();
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, iEncode, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, iEncode, options2);
            }
            Rect rect = this.srcRect;
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmapDecodeByteArray.getWidth();
            this.srcRect.bottom = bitmapDecodeByteArray.getHeight();
            Rect rect2 = this.dstRect;
            int i2 = this.frameX;
            float f = i;
            rect2.left = (int) (i2 / f);
            rect2.top = (int) (this.frameY / f);
            rect2.right = (int) ((i2 / f) + bitmapDecodeByteArray.getWidth());
            this.dstRect.bottom = (int) ((this.frameY / f) + bitmapDecodeByteArray.getHeight());
            canvas.drawBitmap(bitmapDecodeByteArray, this.srcRect, this.dstRect, paint);
            return bitmapDecodeByteArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
