package com.bumptech.glide.load.engine.executor;

/* JADX INFO: loaded from: classes2.dex */
abstract class RuntimeCompat {
    static int availableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
}
