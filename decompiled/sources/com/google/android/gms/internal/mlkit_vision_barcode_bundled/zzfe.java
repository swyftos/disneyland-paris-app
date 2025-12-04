package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
final class zzfe implements zzgf {
    private static final zzfk zza = new zzfc();
    private final zzfk zzb;

    public zzfe() {
        zzea zzeaVarZza = zzea.zza();
        int i = zzfu.$r8$clinit;
        zzfd zzfdVar = new zzfd(zzeaVarZza, zza);
        byte[] bArr = zzep.zzb;
        this.zzb = zzfdVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgf
    public final zzge zza(Class cls) {
        int i = zzgg.$r8$clinit;
        if (!zzeh.class.isAssignableFrom(cls)) {
            int i2 = zzfu.$r8$clinit;
        }
        zzfj zzfjVarZzb = this.zzb.zzb(cls);
        if (zzfjVarZzb.zzb()) {
            int i3 = zzfu.$r8$clinit;
            return zzfq.zzc(zzgg.zzm(), zzdv.zza(), zzfjVarZzb.zza());
        }
        int i4 = zzfu.$r8$clinit;
        return zzfp.zzl(cls, zzfjVarZzb, zzft.zza(), zzfa.zza(), zzgg.zzm(), zzfjVarZzb.zzc() + (-1) != 1 ? zzdv.zza() : null, zzfi.zza());
    }
}
