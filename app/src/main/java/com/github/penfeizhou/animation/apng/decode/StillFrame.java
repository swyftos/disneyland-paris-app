package com.github.penfeizhou.animation.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.penfeizhou.animation.apng.p029io.APNGReader;
import com.github.penfeizhou.animation.apng.p029io.APNGWriter;
import com.github.penfeizhou.animation.decode.Frame;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class StillFrame extends Frame<APNGReader, APNGWriter> {
    public StillFrame(APNGReader aPNGReader) {
        super(aPNGReader);
    }

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, APNGWriter aPNGWriter) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((APNGReader) this.reader).reset();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((APNGReader) this.reader).toInputStream(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((APNGReader) this.reader).toInputStream(), null, options2);
            }
            try {
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, paint);
                return bitmapDecodeStream;
            } catch (IOException e) {
                bitmap2 = bitmapDecodeStream;
                e = e;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }
}
