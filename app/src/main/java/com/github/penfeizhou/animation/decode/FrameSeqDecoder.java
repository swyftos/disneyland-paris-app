package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.github.penfeizhou.animation.executor.FrameDecoderExecutor;
import com.github.penfeizhou.animation.loader.Loader;
import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public abstract class FrameSeqDecoder<R extends Reader, W extends Writer> {
    public static final boolean DEBUG = false;

    /* JADX INFO: renamed from: MB */
    protected static final double f3438MB = 1048576.0d;
    private static final Rect RECT_EMPTY = new Rect();
    private static final String TAG = "FrameSeqDecoder";
    private final Set cacheBitmaps;
    private final Object cacheBitmapsLock;
    protected Map<Bitmap, Canvas> cachedCanvas;
    private boolean finished;
    protected ByteBuffer frameBuffer;
    protected volatile Rect fullRect;
    private final Loader mLoader;
    private Reader mReader;
    private volatile State mState;
    private Writer mWriter;
    private final AtomicBoolean paused;
    private int playCount;
    private final Set renderListeners;
    private final Runnable renderTask;
    protected int sampleSize;
    private final int taskId;
    private final Handler workerHandler;
    protected List<Frame<R, W>> frames = new ArrayList();
    protected int frameIndex = -1;
    private Integer loopLimit = null;

    public interface RenderListener {
        void onEnd();

        void onRender(ByteBuffer byteBuffer);

        void onStart();
    }

    private enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    protected abstract int getLoopCount();

    protected abstract R getReader(Reader reader);

    protected abstract W getWriter();

    protected abstract Rect read(R r) throws IOException;

    protected abstract void release();

    protected abstract void renderFrame(Frame<R, W> frame);

    protected Bitmap obtainBitmap(int i, int i2) {
        synchronized (this.cacheBitmapsLock) {
            try {
                Iterator it = this.cacheBitmaps.iterator();
                Bitmap bitmapCreateBitmap = null;
                while (it.hasNext()) {
                    int i3 = i * i2 * 4;
                    Bitmap bitmap = (Bitmap) it.next();
                    if (bitmap != null && bitmap.getAllocationByteCount() >= i3) {
                        it.remove();
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            if (i > 0 && i2 > 0) {
                                bitmap.reconfigure(i, i2, Bitmap.Config.ARGB_8888);
                            }
                        }
                        bitmap.eraseColor(0);
                        return bitmap;
                    }
                    bitmapCreateBitmap = bitmap;
                }
                if (i <= 0 || i2 <= 0) {
                    return null;
                }
                try {
                    try {
                        bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return bitmapCreateBitmap;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void recycleBitmap(Bitmap bitmap) {
        synchronized (this.cacheBitmapsLock) {
            if (bitmap != null) {
                try {
                    this.cacheBitmaps.add(bitmap);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public FrameSeqDecoder(Loader loader, @Nullable RenderListener renderListener) {
        HashSet hashSet = new HashSet();
        this.renderListeners = hashSet;
        this.paused = new AtomicBoolean(true);
        this.renderTask = new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                if (FrameSeqDecoder.this.paused.get()) {
                    return;
                }
                if (FrameSeqDecoder.this.canStep()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long jStep = FrameSeqDecoder.this.step();
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    FrameSeqDecoder.this.workerHandler.removeCallbacks(FrameSeqDecoder.this.renderTask);
                    FrameSeqDecoder.this.workerHandler.postDelayed(this, Math.max(0L, jStep - jCurrentTimeMillis2));
                    for (RenderListener renderListener2 : FrameSeqDecoder.this.renderListeners) {
                        ByteBuffer byteBuffer = FrameSeqDecoder.this.frameBuffer;
                        if (byteBuffer != null) {
                            renderListener2.onRender(byteBuffer);
                        }
                    }
                    return;
                }
                FrameSeqDecoder.this.stop();
            }
        };
        this.sampleSize = 1;
        this.cacheBitmaps = new HashSet();
        this.cacheBitmapsLock = new Object();
        this.cachedCanvas = new WeakHashMap();
        this.mWriter = getWriter();
        this.mReader = null;
        this.finished = false;
        this.mState = State.IDLE;
        this.mLoader = loader;
        if (renderListener != null) {
            hashSet.add(renderListener);
        }
        int iGenerateTaskId = FrameDecoderExecutor.getInstance().generateTaskId();
        this.taskId = iGenerateTaskId;
        this.workerHandler = new Handler(FrameDecoderExecutor.getInstance().getLooper(iGenerateTaskId));
    }

    public void addRenderListener(final RenderListener renderListener) {
        this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.2
            @Override // java.lang.Runnable
            public void run() {
                FrameSeqDecoder.this.renderListeners.add(renderListener);
            }
        });
    }

    public void removeRenderListener(final RenderListener renderListener) {
        this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.3
            @Override // java.lang.Runnable
            public void run() {
                FrameSeqDecoder.this.renderListeners.remove(renderListener);
            }
        });
    }

    public void stopIfNeeded() {
        this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.4
            @Override // java.lang.Runnable
            public void run() {
                if (FrameSeqDecoder.this.renderListeners.size() == 0) {
                    FrameSeqDecoder.this.stop();
                }
            }
        });
    }

    public Rect getBounds() {
        if (this.fullRect == null) {
            if (this.mState == State.FINISHING) {
                Log.e(TAG, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (FrameSeqDecoder.this.fullRect == null) {
                                if (FrameSeqDecoder.this.mReader != null) {
                                    FrameSeqDecoder.this.mReader.reset();
                                } else {
                                    FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                                    frameSeqDecoder.mReader = frameSeqDecoder.getReader(frameSeqDecoder.mLoader.obtain());
                                }
                                FrameSeqDecoder frameSeqDecoder2 = FrameSeqDecoder.this;
                                frameSeqDecoder2.initCanvasBounds(frameSeqDecoder2.read(frameSeqDecoder2.mReader));
                            }
                        } catch (Exception | OutOfMemoryError e) {
                            e.printStackTrace();
                            FrameSeqDecoder.this.fullRect = FrameSeqDecoder.RECT_EMPTY;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.fullRect == null ? RECT_EMPTY : this.fullRect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCanvasBounds(Rect rect) {
        this.fullRect = rect;
        long jWidth = ((long) rect.width()) * ((long) rect.height());
        int i = this.sampleSize;
        long j = ((jWidth / (((long) i) * ((long) i))) + 1) * 4;
        try {
            this.frameBuffer = ByteBuffer.allocate((int) j);
            if (this.mWriter == null) {
                this.mWriter = getWriter();
            }
        } catch (OutOfMemoryError e) {
            Log.e(TAG, String.format("OutOfMemoryError in FrameSeqDecoder: Buffer needed: %.2fMB (%,d bytes)", Double.valueOf(j / f3438MB), Long.valueOf(j)));
            this.frameBuffer = null;
            this.fullRect = RECT_EMPTY;
            throw e;
        }
    }

    public int getFrameCount() {
        return this.frames.size();
    }

    public int getFrameIndex() {
        return this.frameIndex;
    }

    public void start() {
        if (this.fullRect == RECT_EMPTY) {
            return;
        }
        if (this.mState != State.RUNNING) {
            State state = this.mState;
            State state2 = State.INITIALIZING;
            if (state != state2) {
                if (this.mState == State.FINISHING) {
                    Log.e(TAG, debugInfo() + " Processing,wait for finish at " + this.mState);
                }
                this.mState = state2;
                if (Looper.myLooper() == this.workerHandler.getLooper()) {
                    innerStart();
                    return;
                } else {
                    this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FrameSeqDecoder.this.innerStart();
                        }
                    });
                    return;
                }
            }
        }
        Log.i(TAG, debugInfo() + " Already started");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStart() {
        this.paused.compareAndSet(true, false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (getFrameCount() == 0) {
                try {
                    Reader reader = this.mReader;
                    if (reader == null) {
                        this.mReader = getReader(this.mLoader.obtain());
                    } else {
                        reader.reset();
                    }
                    initCanvasBounds(read(this.mReader));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            String str = TAG;
            Log.i(str, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.mState = State.RUNNING;
            if (getNumPlays() == 0 || !this.finished) {
                this.frameIndex = -1;
                this.workerHandler.removeCallbacks(this.renderTask);
                this.renderTask.run();
                Iterator it = this.renderListeners.iterator();
                while (it.hasNext()) {
                    ((RenderListener) it.next()).onStart();
                }
                return;
            }
            Log.i(str, debugInfo() + " No need to started");
        } catch (Throwable th2) {
            Log.i(TAG, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.mState = State.RUNNING;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerStop() {
        this.workerHandler.removeCallbacks(this.renderTask);
        this.frames.clear();
        synchronized (this.cacheBitmapsLock) {
            try {
                for (Bitmap bitmap : this.cacheBitmaps) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
                this.cacheBitmaps.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.frameBuffer != null) {
            this.frameBuffer = null;
        }
        this.cachedCanvas.clear();
        try {
            Reader reader = this.mReader;
            if (reader != null) {
                reader.close();
                this.mReader = null;
            }
            Writer writer = this.mWriter;
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        release();
        this.mState = State.IDLE;
        Iterator it = this.renderListeners.iterator();
        while (it.hasNext()) {
            ((RenderListener) it.next()).onEnd();
        }
    }

    public void stop() {
        if (this.fullRect == RECT_EMPTY) {
            return;
        }
        State state = this.mState;
        State state2 = State.FINISHING;
        if (state == state2 || this.mState == State.IDLE) {
            Log.i(TAG, debugInfo() + "No need to stop");
            return;
        }
        if (this.mState == State.INITIALIZING) {
            Log.e(TAG, debugInfo() + "Processing,wait for finish at " + this.mState);
        }
        this.mState = state2;
        if (Looper.myLooper() == this.workerHandler.getLooper()) {
            innerStop();
        } else {
            this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.7
                @Override // java.lang.Runnable
                public void run() {
                    FrameSeqDecoder.this.innerStop();
                }
            });
        }
    }

    private String debugInfo() {
        return "";
    }

    public boolean isRunning() {
        return this.mState == State.RUNNING || this.mState == State.INITIALIZING;
    }

    public boolean isPaused() {
        return this.paused.get();
    }

    public void setLoopLimit(int i) {
        this.loopLimit = Integer.valueOf(i);
    }

    public void reset() {
        this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.8
            @Override // java.lang.Runnable
            public void run() {
                FrameSeqDecoder.this.playCount = 0;
                FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                frameSeqDecoder.frameIndex = -1;
                frameSeqDecoder.finished = false;
            }
        });
    }

    public void pause() {
        this.workerHandler.removeCallbacks(this.renderTask);
        this.paused.compareAndSet(false, true);
    }

    public void resume() {
        this.paused.compareAndSet(true, false);
        this.workerHandler.removeCallbacks(this.renderTask);
        this.workerHandler.post(this.renderTask);
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public int setDesiredSize(int i, int i2) {
        final int desiredSample = getDesiredSample(i, i2);
        if (desiredSample != getSampleSize()) {
            final boolean zIsRunning = isRunning();
            this.workerHandler.removeCallbacks(this.renderTask);
            this.workerHandler.post(new Runnable() { // from class: com.github.penfeizhou.animation.decode.FrameSeqDecoder.9
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    FrameSeqDecoder.this.innerStop();
                    try {
                        FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                        frameSeqDecoder.sampleSize = desiredSample;
                        frameSeqDecoder.initCanvasBounds(frameSeqDecoder.read(frameSeqDecoder.getReader(frameSeqDecoder.mLoader.obtain())));
                        if (zIsRunning) {
                            FrameSeqDecoder.this.innerStart();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return desiredSample;
    }

    protected int getDesiredSample(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(getBounds().width() / i, getBounds().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    private int getNumPlays() {
        Integer num = this.loopLimit;
        return num != null ? num.intValue() : getLoopCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canStep() {
        if (!isRunning() || getFrameCount() == 0) {
            return false;
        }
        if (getNumPlays() <= 0 || this.playCount < getNumPlays() - 1) {
            return true;
        }
        if (this.playCount == getNumPlays() - 1 && this.frameIndex < getFrameCount() - 1) {
            return true;
        }
        this.finished = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long step() {
        int i = this.frameIndex + 1;
        this.frameIndex = i;
        if (i >= getFrameCount()) {
            this.frameIndex = 0;
            this.playCount++;
        }
        Frame<R, W> frame = getFrame(this.frameIndex);
        if (frame == null) {
            return 0L;
        }
        renderFrame(frame);
        return frame.frameDuration;
    }

    public Frame<R, W> getFrame(int i) {
        if (i < 0 || i >= this.frames.size()) {
            return null;
        }
        return this.frames.get(i);
    }

    public Bitmap getFrameBitmap(int i) throws IOException {
        if (this.mState != State.IDLE) {
            Log.e(TAG, debugInfo() + ",stop first");
            return null;
        }
        this.mState = State.RUNNING;
        this.paused.compareAndSet(true, false);
        if (this.frames.size() == 0) {
            Reader reader = this.mReader;
            if (reader == null) {
                this.mReader = getReader(this.mLoader.obtain());
            } else {
                reader.reset();
            }
            initCanvasBounds(read(this.mReader));
        }
        if (i < 0) {
            i += this.frames.size();
        }
        int i2 = i >= 0 ? i : 0;
        this.frameIndex = -1;
        while (this.frameIndex < i2 && canStep()) {
            step();
        }
        this.frameBuffer.rewind();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getBounds().width() / getSampleSize(), getBounds().height() / getSampleSize(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.copyPixelsFromBuffer(this.frameBuffer);
        innerStop();
        return bitmapCreateBitmap;
    }

    public int getMemorySize() {
        int iCapacity;
        synchronized (this.cacheBitmapsLock) {
            try {
                iCapacity = 0;
                for (Bitmap bitmap : this.cacheBitmaps) {
                    if (!bitmap.isRecycled()) {
                        iCapacity += bitmap.getAllocationByteCount();
                    }
                }
                ByteBuffer byteBuffer = this.frameBuffer;
                if (byteBuffer != null) {
                    iCapacity += byteBuffer.capacity();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iCapacity;
    }
}
