package io.cucumber.datatable.dependency.com.fasterxml.jackson.core.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
class ThreadLocalBufferManager {
    private final Object RELEASE_LOCK = new Object();
    private final Map _trackedRecyclers = new ConcurrentHashMap();
    private final ReferenceQueue _refQueue = new ReferenceQueue();

    private static final class ThreadLocalBufferManagerHolder {
        static final ThreadLocalBufferManager manager = new ThreadLocalBufferManager();
    }

    ThreadLocalBufferManager() {
    }

    public static ThreadLocalBufferManager instance() {
        return ThreadLocalBufferManagerHolder.manager;
    }

    public int releaseBuffers() {
        int i;
        synchronized (this.RELEASE_LOCK) {
            try {
                removeSoftRefsClearedByGc();
                Iterator it = this._trackedRecyclers.keySet().iterator();
                i = 0;
                while (it.hasNext()) {
                    ((SoftReference) it.next()).clear();
                    i++;
                }
                this._trackedRecyclers.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public SoftReference wrapAndTrack(BufferRecycler bufferRecycler) {
        SoftReference softReference = new SoftReference(bufferRecycler, this._refQueue);
        this._trackedRecyclers.put(softReference, Boolean.TRUE);
        removeSoftRefsClearedByGc();
        return softReference;
    }

    private void removeSoftRefsClearedByGc() {
        while (true) {
            SoftReference softReference = (SoftReference) this._refQueue.poll();
            if (softReference == null) {
                return;
            } else {
                this._trackedRecyclers.remove(softReference);
            }
        }
    }
}
