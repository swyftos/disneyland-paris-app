package io.legere.pdfiumandroid.util;

import java.util.concurrent.Semaphore;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1836d2 = {"Lio/legere/pdfiumandroid/util/InitLock;", "", "<init>", "()V", "semaphore", "Ljava/util/concurrent/Semaphore;", "isInitialized", "", "markReady", "", "waitForReady", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class InitLock {
    private boolean isInitialized;

    @NotNull
    private final Semaphore semaphore = new Semaphore(0);

    public final void markReady() {
        this.isInitialized = true;
        this.semaphore.release();
    }

    public final synchronized void waitForReady() {
        if (!this.isInitialized) {
            this.semaphore.acquire();
        }
    }
}
