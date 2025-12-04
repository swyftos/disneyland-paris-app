package com.google.android.gms.internal.maps;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class zzbn implements Map, Serializable {
    private transient zzbo zza;
    private transient zzbo zzb;
    private transient zzbh zzc;

    zzbn() {
    }

    public static zzbn zzc(Iterable iterable) {
        zzbm zzbmVar = new zzbm(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        zzbmVar.zza(iterable);
        zzbl zzblVar = zzbmVar.zzc;
        if (zzblVar != null) {
            throw zzblVar.zza();
        }
        zzbv zzbvVarZzg = zzbv.zzg(zzbmVar.zzb, zzbmVar.zza, zzbmVar);
        zzbl zzblVar2 = zzbmVar.zzc;
        if (zzblVar2 == null) {
            return zzbvVarZzg;
        }
        throw zzblVar2.zza();
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzbx.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzbo zzboVar = this.zzb;
        if (zzboVar != null) {
            return zzboVar;
        }
        zzbo zzboVarZze = zze();
        this.zzb = zzboVarZze;
        return zzboVarZze;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    abstract zzbh zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzbh values() {
        zzbh zzbhVar = this.zzc;
        if (zzbhVar != null) {
            return zzbhVar;
        }
        zzbh zzbhVarZza = zza();
        this.zzc = zzbhVarZza;
        return zzbhVarZza;
    }

    abstract zzbo zzd();

    abstract zzbo zze();

    @Override // java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzbo entrySet() {
        zzbo zzboVar = this.zza;
        if (zzboVar != null) {
            return zzboVar;
        }
        zzbo zzboVarZzd = zzd();
        this.zza = zzboVarZzd;
        return zzboVarZzd;
    }
}
