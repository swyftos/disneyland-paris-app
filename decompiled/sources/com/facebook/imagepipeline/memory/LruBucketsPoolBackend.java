package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.Nullsafe;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public abstract class LruBucketsPoolBackend<T> implements PoolBackend<T> {
    private final Set mCurrentItems = new HashSet();
    private final BucketMap mMap = new BucketMap();

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public T get(int i) {
        return (T) maybeRemoveFromCurrentItems(this.mMap.acquire(i));
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public void put(T t) {
        boolean zAdd;
        synchronized (this) {
            zAdd = this.mCurrentItems.add(t);
        }
        if (zAdd) {
            this.mMap.release(getSize(t), t);
        }
    }

    @Override // com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public T pop() {
        return (T) maybeRemoveFromCurrentItems(this.mMap.removeFromEnd());
    }

    private Object maybeRemoveFromCurrentItems(Object obj) {
        if (obj != null) {
            synchronized (this) {
                this.mCurrentItems.remove(obj);
            }
        }
        return obj;
    }
}
