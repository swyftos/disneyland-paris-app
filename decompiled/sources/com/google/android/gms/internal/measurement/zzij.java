package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzij extends zzih {
    zzij() {
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final boolean zza(zzhm zzhmVar) {
        return false;
    }

    private static void zza(Object obj, zzig zzigVar) {
        ((zzfo) obj).zzb = zzigVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final void zzd(Object obj) {
        ((zzfo) obj).zzb.zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ int zzf(Object obj) {
        return ((zzig) obj).zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ int zze(Object obj) {
        return ((zzig) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzig zzigVar = (zzig) obj;
        zzig zzigVar2 = (zzig) obj2;
        return zzigVar2.equals(zzig.zza()) ? zzigVar : zzig.zza(zzigVar, zzigVar2);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zzb(Object obj, zzja zzjaVar) {
        ((zzig) obj).zza(zzjaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zza(Object obj, zzja zzjaVar) throws IOException {
        ((zzig) obj).zzb(zzjaVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzig) obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ Object zzc(Object obj) {
        zzig zzigVar = ((zzfo) obj).zzb;
        if (zzigVar != zzig.zza()) {
            return zzigVar;
        }
        zzig zzigVarZzb = zzig.zzb();
        zza(obj, zzigVarZzb);
        return zzigVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ Object zzb(Object obj) {
        return ((zzfo) obj).zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzig) obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ Object zza(Object obj) {
        zzig zzigVar = (zzig) obj;
        zzigVar.zzc();
        return zzigVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ Object zza() {
        return zzig.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzig) obj).zza((i << 3) | 3, (zzig) obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zza(Object obj, int i, zzeg zzegVar) {
        ((zzig) obj).zza((i << 3) | 2, zzegVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzig) obj).zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzig) obj).zza((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzig) obj).zza(i << 3, Long.valueOf(j));
    }
}
