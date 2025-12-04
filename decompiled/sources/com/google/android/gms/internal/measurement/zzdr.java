package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
final class zzdr extends WeakReference {
    private final int zza;

    public zzdr(Throwable th, ReferenceQueue referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zza = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzdr.class) {
            if (this == obj) {
                return true;
            }
            zzdr zzdrVar = (zzdr) obj;
            if (this.zza == zzdrVar.zza && get() == zzdrVar.get()) {
                return true;
            }
        }
        return false;
    }
}
