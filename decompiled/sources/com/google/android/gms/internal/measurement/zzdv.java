package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdv;
import com.google.android.gms.internal.measurement.zzdw;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class zzdv<MessageType extends zzdw<MessageType, BuilderType>, BuilderType extends zzdv<MessageType, BuilderType>> implements zzgz {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzes zzesVar, zzfb zzfbVar) throws IOException;

    @Override // 
    /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzfw {
        try {
            zzes zzesVarZza = zzes.zza(bArr, 0, i2, false);
            zza(zzesVarZza, zzfb.zza());
            zzesVarZza.zza(0);
            return this;
        } catch (zzfw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzfb zzfbVar) throws zzfw {
        try {
            zzes zzesVarZza = zzes.zza(bArr, 0, i2, false);
            zza(zzesVarZza, zzfbVar);
            zzesVarZza.zza(0);
            return this;
        } catch (zzfw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(name.length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final /* synthetic */ zzgz zza(zzgw zzgwVar) {
        if (!h_().getClass().isInstance(zzgwVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzdv<MessageType, BuilderType>) zzgwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final /* synthetic */ zzgz zza(byte[] bArr, zzfb zzfbVar) throws zzfw {
        return zza(bArr, 0, bArr.length, zzfbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgz
    public final /* synthetic */ zzgz zza(byte[] bArr) throws zzfw {
        return zza(bArr, 0, bArr.length);
    }
}
