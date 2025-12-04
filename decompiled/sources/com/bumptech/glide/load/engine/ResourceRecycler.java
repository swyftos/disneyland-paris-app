package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    ResourceRecycler() {
    }

    synchronized void recycle(Resource resource, boolean z) {
        try {
            if (this.isRecycling || z) {
                this.handler.obtainMessage(1, resource).sendToTarget();
            } else {
                this.isRecycling = true;
                resource.recycle();
                this.isRecycling = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static final class ResourceRecyclerCallback implements Handler.Callback {
        ResourceRecyclerCallback() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }
}
