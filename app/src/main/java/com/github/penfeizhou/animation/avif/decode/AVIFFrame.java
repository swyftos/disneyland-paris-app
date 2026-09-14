package com.github.penfeizhou.animation.avif.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.penfeizhou.animation.avif.p030io.AVIFReader;
import com.github.penfeizhou.animation.avif.p030io.AVIFWriter;
import com.github.penfeizhou.animation.decode.Frame;

/* JADX INFO: loaded from: classes3.dex */
public class AVIFFrame extends Frame<AVIFReader, AVIFWriter> {
    public int index;

    @Override // com.github.penfeizhou.animation.decode.Frame
    public Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, AVIFWriter aVIFWriter) {
        return null;
    }

    public AVIFFrame(AVIFReader aVIFReader) {
        super(aVIFReader);
        this.index = 0;
    }
}
