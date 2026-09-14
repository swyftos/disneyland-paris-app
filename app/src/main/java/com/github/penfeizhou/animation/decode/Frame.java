package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Frame<R extends Reader, W extends Writer> {
    public int frameDuration;
    public int frameHeight;
    public int frameWidth;
    public int frameX;
    public int frameY;
    protected final R reader;
    protected final Rect srcRect = new Rect();
    protected final Rect dstRect = new Rect();

    public abstract Bitmap draw(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public Frame(R r) {
        this.reader = r;
    }
}
