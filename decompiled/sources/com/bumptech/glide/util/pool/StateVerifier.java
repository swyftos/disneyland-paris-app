package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public abstract class StateVerifier {
    abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    @NonNull
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    private StateVerifier() {
    }

    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        DefaultStateVerifier() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }
    }
}
