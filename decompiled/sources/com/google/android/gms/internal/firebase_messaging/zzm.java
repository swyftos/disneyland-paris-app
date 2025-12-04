package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class zzm {
    private final ConcurrentHashMap zza = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue zzb = new ReferenceQueue();

    zzm() {
    }

    public final List zza(Throwable th, boolean z) {
        Reference referencePoll = this.zzb.poll();
        while (referencePoll != null) {
            this.zza.remove(referencePoll);
            referencePoll = this.zzb.poll();
        }
        List list = (List) this.zza.get(new zzp(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List list2 = (List) this.zza.putIfAbsent(new zzp(th, this.zzb), vector);
        return list2 == null ? vector : list2;
    }
}
