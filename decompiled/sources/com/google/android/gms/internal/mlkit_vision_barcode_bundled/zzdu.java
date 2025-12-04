package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Map;

/* loaded from: classes3.dex */
final class zzdu extends zzdt {
    zzdu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt
    final void zza(Object obj) {
        ((zzed) obj).zzb.zzg();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdt
    final void zzb(zzhh zzhhVar, Map.Entry entry) {
        zzee zzeeVar = (zzee) entry.getKey();
        zzhf zzhfVar = zzhf.zza;
        switch (zzeeVar.zzb.ordinal()) {
            case 0:
                zzhhVar.zzf(zzeeVar.zza, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                zzhhVar.zzo(zzeeVar.zza, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                zzhhVar.zzt(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                zzhhVar.zzK(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                zzhhVar.zzr(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                zzhhVar.zzm(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                zzhhVar.zzk(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                zzhhVar.zzb(zzeeVar.zza, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                zzhhVar.zzG(zzeeVar.zza, (String) entry.getValue());
                break;
            case 9:
                zzhhVar.zzq(zzeeVar.zza, entry.getValue(), zzfu.zza().zzb(entry.getValue().getClass()));
                break;
            case 10:
                zzhhVar.zzv(zzeeVar.zza, entry.getValue(), zzfu.zza().zzb(entry.getValue().getClass()));
                break;
            case 11:
                zzhhVar.zzd(zzeeVar.zza, (zzdf) entry.getValue());
                break;
            case 12:
                zzhhVar.zzI(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                zzhhVar.zzr(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                zzhhVar.zzx(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                zzhhVar.zzz(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                zzhhVar.zzB(zzeeVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                zzhhVar.zzD(zzeeVar.zza, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
