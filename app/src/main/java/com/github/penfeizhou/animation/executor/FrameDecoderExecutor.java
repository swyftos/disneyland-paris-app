package com.github.penfeizhou.animation.executor;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class FrameDecoderExecutor {
    private static int sPoolNumber = 4;
    private AtomicInteger counter;
    private ArrayList mHandlerThreadGroup;

    static class Inner {
        static final FrameDecoderExecutor sInstance = new FrameDecoderExecutor();
    }

    private FrameDecoderExecutor() {
        this.mHandlerThreadGroup = new ArrayList();
        this.counter = new AtomicInteger(0);
    }

    public void setPoolSize(int i) {
        sPoolNumber = i;
    }

    public static FrameDecoderExecutor getInstance() {
        return Inner.sInstance;
    }

    public Looper getLooper(int i) {
        int i2 = i % sPoolNumber;
        if (i2 >= this.mHandlerThreadGroup.size()) {
            HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor-" + i2);
            handlerThread.start();
            this.mHandlerThreadGroup.add(handlerThread);
            Looper looper = handlerThread.getLooper();
            return looper != null ? looper : Looper.getMainLooper();
        }
        if (this.mHandlerThreadGroup.get(i2) != null) {
            Looper looper2 = ((HandlerThread) this.mHandlerThreadGroup.get(i2)).getLooper();
            return looper2 != null ? looper2 : Looper.getMainLooper();
        }
        return Looper.getMainLooper();
    }

    public int generateTaskId() {
        return this.counter.getAndIncrement();
    }
}
