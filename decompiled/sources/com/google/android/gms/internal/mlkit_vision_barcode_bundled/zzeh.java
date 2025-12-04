package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class zzeh<MessageType extends zzeh<MessageType, BuilderType>, BuilderType extends zzeb<MessageType, BuilderType>> extends zzcq<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzgt zzc = zzgt.zzc();

    public static zzef zzI(zzfm zzfmVar, Object obj, zzfm zzfmVar2, zzek zzekVar, int i, zzhf zzhfVar, Class cls) {
        return new zzef(zzfmVar, obj, zzfmVar2, new zzee(null, i, zzhfVar, false, false), cls);
    }

    static zzeh zzJ(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzeh zzehVar = (zzeh) map.get(cls);
        if (zzehVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzehVar = (zzeh) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzehVar == null) {
            zzehVar = (zzeh) ((zzeh) zzgz.zze(cls)).zzg(6, null, null);
            if (zzehVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzehVar);
        }
        return zzehVar;
    }

    protected static zzeh zzL(zzeh zzehVar, byte[] bArr, zzds zzdsVar) throws zzer {
        zzeh zzehVarZze = zze(zzehVar, bArr, 0, bArr.length, zzdsVar);
        if (zzehVarZze == null || zzX(zzehVarZze, true)) {
            return zzehVarZze;
        }
        throw new zzgr(zzehVarZze).zza();
    }

    protected static zzem zzM() {
        return zzdz.zzf();
    }

    protected static zzem zzN(zzem zzemVar) {
        int size = zzemVar.size();
        return zzemVar.zzd(size == 0 ? 10 : size + size);
    }

    protected static zzen zzO() {
        return zzei.zzf();
    }

    protected static zzeo zzP() {
        return zzfv.zze();
    }

    protected static zzeo zzQ(zzeo zzeoVar) {
        int size = zzeoVar.size();
        return zzeoVar.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzR(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzS(zzfm zzfmVar, String str, Object[] objArr) {
        return new zzfw(zzfmVar, str, objArr);
    }

    protected static void zzV(Class cls, zzeh zzehVar) {
        zzehVar.zzU();
        zzb.put(cls, zzehVar);
    }

    protected static final boolean zzX(zzeh zzehVar, boolean z) {
        byte bByteValue = ((Byte) zzehVar.zzg(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzfu.zza().zzb(zzehVar.getClass()).zzk(zzehVar);
        if (z) {
            zzehVar.zzg(2, true != zZzk ? null : zzehVar, null);
        }
        return zZzk;
    }

    private final int zzc(zzge zzgeVar) {
        return zzfu.zza().zzb(getClass()).zza(this);
    }

    private static zzeh zze(zzeh zzehVar, byte[] bArr, int i, int i2, zzds zzdsVar) throws zzer {
        if (i2 == 0) {
            return zzehVar;
        }
        zzeh zzehVarZzK = zzehVar.zzK();
        try {
            zzge zzgeVarZzb = zzfu.zza().zzb(zzehVarZzK.getClass());
            zzgeVarZzb.zzh(zzehVarZzK, bArr, 0, i2, new zzcu(zzdsVar));
            zzgeVarZzb.zzf(zzehVarZzK);
            return zzehVarZzK;
        } catch (zzer e) {
            throw e;
        } catch (zzgr e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzer) {
                throw ((zzer) e3.getCause());
            }
            throw new zzer(e3);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzer("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzfu.zza().zzb(getClass()).zzj(this, (zzeh) obj);
    }

    public final int hashCode() {
        if (zzY()) {
            return zzE();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzE = zzE();
        this.zza = iZzE;
        return iZzE;
    }

    public final String toString() {
        return zzfo.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcq
    final int zzB(zzge zzgeVar) {
        if (zzY()) {
            int iZza = zzgeVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzgeVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzE() {
        return zzfu.zza().zzb(getClass()).zzb(this);
    }

    protected final zzeb zzG() {
        return (zzeb) zzg(5, null, null);
    }

    public final zzeb zzH() {
        zzeb zzebVar = (zzeb) zzg(5, null, null);
        zzebVar.zzg(this);
        return zzebVar;
    }

    final zzeh zzK() {
        return (zzeh) zzg(4, null, null);
    }

    protected final void zzT() {
        zzfu.zza().zzb(getClass()).zzf(this);
        zzU();
    }

    final void zzU() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final void zzW(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    final boolean zzY() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final /* synthetic */ zzfl zzZ() {
        return (zzeb) zzg(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final /* synthetic */ zzfl zzaa() {
        zzeb zzebVar = (zzeb) zzg(5, null, null);
        zzebVar.zzg(this);
        return zzebVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final void zzab(zzdn zzdnVar) throws IOException {
        zzfu.zza().zzb(getClass()).zzi(this, zzdo.zza(zzdnVar));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final /* synthetic */ zzfm zzac() {
        return (zzeh) zzg(6, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final boolean zzad() {
        return zzX(this, true);
    }

    protected abstract Object zzg(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final int zzF() {
        if (zzY()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZzc);
        }
        int iZzc2 = this.zzd & Integer.MAX_VALUE;
        if (iZzc2 == Integer.MAX_VALUE) {
            iZzc2 = zzc(null);
            if (iZzc2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
            }
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzc2;
        }
        return iZzc2;
    }
}
