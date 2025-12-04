package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class zabd extends zabw {
    private final WeakReference zaa;

    zabd(zabe zabeVar) {
        this.zaa = new WeakReference(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.zaa.get();
        if (zabeVar == null) {
            return;
        }
        zabe.zai(zabeVar);
    }
}
