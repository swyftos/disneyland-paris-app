package com.google.android.gms.internal.measurement;

import java.util.Map;

/* loaded from: classes3.dex */
final class zzgd implements Map.Entry {
    private Map.Entry zza;

    private zzgd(Map.Entry entry) {
        this.zza = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzgb) this.zza.getValue()) == null) {
            return null;
        }
        return zzgb.zza();
    }

    public final zzgb zza() {
        return (zzgb) this.zza.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzgw)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return ((zzgb) this.zza.getValue()).zza((zzgw) obj);
    }
}
