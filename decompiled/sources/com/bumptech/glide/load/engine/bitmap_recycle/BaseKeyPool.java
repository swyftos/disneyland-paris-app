package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes2.dex */
abstract class BaseKeyPool {
    private final Queue keyPool = Util.createQueue(20);

    abstract Poolable create();

    BaseKeyPool() {
    }

    Poolable get() {
        Poolable poolable = (Poolable) this.keyPool.poll();
        return poolable == null ? create() : poolable;
    }

    public void offer(Poolable poolable) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(poolable);
        }
    }
}
