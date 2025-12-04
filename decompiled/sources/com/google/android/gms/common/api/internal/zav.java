package com.google.android.gms.common.api.internal;

/* loaded from: classes3.dex */
final class zav implements Runnable {
    final /* synthetic */ zaaa zaa;

    zav(zaaa zaaaVar) {
        this.zaa = zaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zaa.zam.lock();
        try {
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
