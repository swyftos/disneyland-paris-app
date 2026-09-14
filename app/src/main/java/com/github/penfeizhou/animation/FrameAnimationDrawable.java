package com.github.penfeizhou.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.Loader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FrameAnimationDrawable<Decoder extends FrameSeqDecoder<?, ?>> extends Drawable implements Animatable2Compat, FrameSeqDecoder.RenderListener {
    private static final String TAG = "FrameAnimationDrawable";
    private final Set animationCallbacks;
    private boolean autoPlay;
    private Bitmap bitmap;
    private final DrawFilter drawFilter;
    private final FrameSeqDecoder frameSeqDecoder;
    private final Runnable invalidateRunnable;
    private final Matrix matrix;
    private boolean noMeasure;
    private final Set obtainedCallbacks;
    private final Paint paint;
    private final Handler uiHandler;

    protected abstract Decoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FrameAnimationDrawable(Decoder decoder) {
        Paint paint = new Paint();
        this.paint = paint;
        this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        this.matrix = new Matrix();
        this.animationCallbacks = new HashSet();
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: com.github.penfeizhou.animation.FrameAnimationDrawable.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(FrameAnimationDrawable.this.animationCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it.next()).onAnimationStart(FrameAnimationDrawable.this);
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(FrameAnimationDrawable.this.animationCallbacks).iterator();
                    while (it2.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it2.next()).onAnimationEnd(FrameAnimationDrawable.this);
                    }
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: com.github.penfeizhou.animation.FrameAnimationDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationDrawable.this.invalidateSelf();
            }
        };
        this.autoPlay = true;
        this.obtainedCallbacks = new HashSet();
        this.noMeasure = false;
        paint.setAntiAlias(true);
        this.frameSeqDecoder = decoder;
    }

    public FrameAnimationDrawable(Loader loader) {
        Paint paint = new Paint();
        this.paint = paint;
        this.drawFilter = new PaintFlagsDrawFilter(0, 3);
        this.matrix = new Matrix();
        this.animationCallbacks = new HashSet();
        this.uiHandler = new Handler(Looper.getMainLooper()) { // from class: com.github.penfeizhou.animation.FrameAnimationDrawable.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    Iterator it = new ArrayList(FrameAnimationDrawable.this.animationCallbacks).iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it.next()).onAnimationStart(FrameAnimationDrawable.this);
                    }
                } else {
                    if (i != 2) {
                        return;
                    }
                    Iterator it2 = new ArrayList(FrameAnimationDrawable.this.animationCallbacks).iterator();
                    while (it2.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it2.next()).onAnimationEnd(FrameAnimationDrawable.this);
                    }
                }
            }
        };
        this.invalidateRunnable = new Runnable() { // from class: com.github.penfeizhou.animation.FrameAnimationDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                FrameAnimationDrawable.this.invalidateSelf();
            }
        };
        this.autoPlay = true;
        this.obtainedCallbacks = new HashSet();
        this.noMeasure = false;
        paint.setAntiAlias(true);
        this.frameSeqDecoder = createFrameSeqDecoder(loader, this);
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public void setNoMeasure(boolean z) {
        this.noMeasure = z;
    }

    public void setLoopLimit(int i) {
        this.frameSeqDecoder.setLoopLimit(i);
    }

    public void reset() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.eraseColor(0);
        }
        this.frameSeqDecoder.reset();
    }

    public void pause() {
        this.frameSeqDecoder.pause();
    }

    public void resume() {
        this.frameSeqDecoder.resume();
    }

    public boolean isPaused() {
        return this.frameSeqDecoder.isPaused();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.frameSeqDecoder.isRunning()) {
            this.frameSeqDecoder.stop();
        }
        this.frameSeqDecoder.reset();
        innerStart();
    }

    private void innerStart() {
        this.frameSeqDecoder.addRenderListener(this);
        if (this.autoPlay) {
            this.frameSeqDecoder.start();
        } else {
            if (this.frameSeqDecoder.isRunning()) {
                return;
            }
            this.frameSeqDecoder.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        innerStop();
    }

    private void innerStop() {
        this.frameSeqDecoder.removeRenderListener(this);
        if (this.autoPlay) {
            this.frameSeqDecoder.stop();
        } else {
            this.frameSeqDecoder.stopIfNeeded();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.frameSeqDecoder.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.setDrawFilter(this.drawFilter);
        canvas.drawBitmap(this.bitmap, this.matrix, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int sampleSize = this.frameSeqDecoder.getSampleSize();
        int desiredSize = this.frameSeqDecoder.setDesiredSize(getBounds().width(), getBounds().height());
        float f = desiredSize;
        this.matrix.setScale(((getBounds().width() * 1.0f) * f) / this.frameSeqDecoder.getBounds().width(), ((getBounds().height() * 1.0f) * f) / this.frameSeqDecoder.getBounds().height());
        if (desiredSize != sampleSize) {
            this.bitmap = Bitmap.createBitmap(this.frameSeqDecoder.getBounds().width() / desiredSize, this.frameSeqDecoder.getBounds().height() / desiredSize, Bitmap.Config.ARGB_8888);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder.RenderListener
    public void onStart() {
        Message.obtain(this.uiHandler, 1).sendToTarget();
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder.RenderListener
    public void onRender(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap = this.bitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                this.bitmap = Bitmap.createBitmap(this.frameSeqDecoder.getBounds().width() / this.frameSeqDecoder.getSampleSize(), this.frameSeqDecoder.getBounds().height() / this.frameSeqDecoder.getSampleSize(), Bitmap.Config.ARGB_8888);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.bitmap.getByteCount()) {
                Log.e(TAG, "onRender:Buffer not large enough for pixels");
            } else {
                this.bitmap.copyPixelsFromBuffer(byteBuffer);
                this.uiHandler.post(this.invalidateRunnable);
            }
        }
    }

    @Override // com.github.penfeizhou.animation.decode.FrameSeqDecoder.RenderListener
    public void onEnd() {
        Message.obtain(this.uiHandler, 2).sendToTarget();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        hookRecordCallbacks();
        if (this.autoPlay) {
            if (z) {
                if (!isRunning()) {
                    innerStart();
                }
            } else if (isRunning()) {
                innerStop();
            }
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.noMeasure) {
            return -1;
        }
        try {
            return this.frameSeqDecoder.getBounds().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.noMeasure) {
            return -1;
        }
        try {
            return this.frameSeqDecoder.getBounds().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.animationCallbacks.add(animationCallback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return this.animationCallbacks.remove(animationCallback);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
    }

    public int getMemorySize() {
        int memorySize = this.frameSeqDecoder.getMemorySize();
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            memorySize += this.bitmap.getAllocationByteCount();
        }
        return Math.max(1, memorySize);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void hookRecordCallbacks() {
        ArrayList arrayList = new ArrayList();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.obtainedCallbacks)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.obtainedCallbacks.remove((WeakReference) it.next());
        }
        if (z) {
            return;
        }
        this.obtainedCallbacks.add(new WeakReference(callback));
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        Iterator it = new HashSet(this.obtainedCallbacks).iterator();
        while (it.hasNext()) {
            Drawable.Callback callback = (Drawable.Callback) ((WeakReference) it.next()).get();
            if (callback != null && callback != getCallback()) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Decoder getFrameSeqDecoder() {
        return (Decoder) this.frameSeqDecoder;
    }
}
