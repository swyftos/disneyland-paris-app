package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzhc implements zzhp {
    private final zzgw zza;
    private final zzih zzb;
    private final boolean zzc;
    private final zzfd zzd;

    private zzhc(zzih zzihVar, zzfd zzfdVar, zzgw zzgwVar) {
        this.zzb = zzihVar;
        this.zzc = zzfdVar.zza(zzgwVar);
        this.zzd = zzfdVar;
        this.zza = zzgwVar;
    }

    static zzhc zza(zzih zzihVar, zzfd zzfdVar, zzgw zzgwVar) {
        return new zzhc(zzihVar, zzfdVar, zzgwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final Object zza() {
        return this.zza.zzbr().zzu();
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final boolean zza(Object obj, Object obj2) {
        if (!this.zzb.zzb(obj).equals(this.zzb.zzb(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(obj).equals(this.zzd.zza(obj2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final int zza(Object obj) {
        int iHashCode = this.zzb.zzb(obj).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(obj).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final void zzb(Object obj, Object obj2) {
        zzhr.zza(this.zzb, obj, obj2);
        if (this.zzc) {
            zzhr.zza(this.zzd, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final void zza(Object obj, zzja zzjaVar) {
        Iterator itZzd = this.zzd.zza(obj).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzfg zzfgVar = (zzfg) entry.getKey();
            if (zzfgVar.zzc() != zzjb.MESSAGE || zzfgVar.zzd() || zzfgVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzgd) {
                zzjaVar.zza(zzfgVar.zza(), (Object) ((zzgd) entry).zza().zzc());
            } else {
                zzjaVar.zza(zzfgVar.zza(), entry.getValue());
            }
        }
        zzih zzihVar = this.zzb;
        zzihVar.zzb(zzihVar.zzb(obj), zzjaVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099 A[EDGE_INSN: B:56:0x0099->B:34:0x0099 BREAK  A[LOOP:1: B:18:0x0053->B:61:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzeb r14) throws com.google.android.gms.internal.measurement.zzfw {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzfo r0 = (com.google.android.gms.internal.measurement.zzfo) r0
            com.google.android.gms.internal.measurement.zzig r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzig r2 = com.google.android.gms.internal.measurement.zzig.zza()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.zzfo$zzb r10 = (com.google.android.gms.internal.measurement.zzfo.zzb) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.zzec.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.zzfd r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzfb r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzgw r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzfo$zzd r0 = (com.google.android.gms.internal.measurement.zzfo.zzd) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzec.zza(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.zzhl.zza()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L4c:
            int r12 = com.google.android.gms.internal.measurement.zzec.zza(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzec.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzec.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzeg r2 = (com.google.android.gms.internal.measurement.zzeg) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.zzhl.zza()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.zzec.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzfd r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzfb r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzgw r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzfo$zzd r0 = (com.google.android.gms.internal.measurement.zzfo.zzd) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.zzec.zza(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.zzfw r9 = com.google.android.gms.internal.measurement.zzfw.zzg()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhc.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzeb):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[LOOP:0: B:46:0x000c->B:54:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Object r11, com.google.android.gms.internal.measurement.zzhm r12, com.google.android.gms.internal.measurement.zzfb r13) {
        /*
            r10 = this;
            com.google.android.gms.internal.measurement.zzih r0 = r10.zzb
            com.google.android.gms.internal.measurement.zzfd r1 = r10.zzd
            java.lang.Object r2 = r0.zzc(r11)
            com.google.android.gms.internal.measurement.zzfe r3 = r1.zzb(r11)
        Lc:
            int r4 = r12.zza()     // Catch: java.lang.Throwable -> L34
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.zzb(r11, r2)
            return
        L19:
            int r4 = r12.zzb()     // Catch: java.lang.Throwable -> L34
            r6 = 11
            if (r4 == r6) goto L40
            r5 = r4 & 7
            r6 = 2
            if (r5 != r6) goto L3b
            com.google.android.gms.internal.measurement.zzgw r5 = r10.zza     // Catch: java.lang.Throwable -> L34
            int r4 = r4 >>> 3
            java.lang.Object r4 = r1.zza(r13, r5, r4)     // Catch: java.lang.Throwable -> L34
            if (r4 == 0) goto L36
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L34
            goto L85
        L34:
            r10 = move-exception
            goto L91
        L36:
            boolean r4 = r0.zza(r2, r12)     // Catch: java.lang.Throwable -> L34
            goto L86
        L3b:
            boolean r4 = r12.zzc()     // Catch: java.lang.Throwable -> L34
            goto L86
        L40:
            r4 = 0
            r6 = 0
            r7 = r6
            r6 = r4
        L44:
            int r8 = r12.zza()     // Catch: java.lang.Throwable -> L34
            if (r8 == r5) goto L72
            int r8 = r12.zzb()     // Catch: java.lang.Throwable -> L34
            r9 = 16
            if (r8 != r9) goto L5d
            int r7 = r12.zzo()     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.measurement.zzgw r4 = r10.zza     // Catch: java.lang.Throwable -> L34
            java.lang.Object r4 = r1.zza(r13, r4, r7)     // Catch: java.lang.Throwable -> L34
            goto L44
        L5d:
            r9 = 26
            if (r8 != r9) goto L6c
            if (r4 == 0) goto L67
            r1.zza(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L34
            goto L44
        L67:
            com.google.android.gms.internal.measurement.zzeg r6 = r12.zzn()     // Catch: java.lang.Throwable -> L34
            goto L44
        L6c:
            boolean r8 = r12.zzc()     // Catch: java.lang.Throwable -> L34
            if (r8 != 0) goto L44
        L72:
            int r5 = r12.zzb()     // Catch: java.lang.Throwable -> L34
            r8 = 12
            if (r5 != r8) goto L8c
            if (r6 == 0) goto L85
            if (r4 == 0) goto L82
            r1.zza(r6, r4, r13, r3)     // Catch: java.lang.Throwable -> L34
            goto L85
        L82:
            r0.zza(r2, r7, r6)     // Catch: java.lang.Throwable -> L34
        L85:
            r4 = 1
        L86:
            if (r4 != 0) goto Lc
            r0.zzb(r11, r2)
            return
        L8c:
            com.google.android.gms.internal.measurement.zzfw r10 = com.google.android.gms.internal.measurement.zzfw.zze()     // Catch: java.lang.Throwable -> L34
            throw r10     // Catch: java.lang.Throwable -> L34
        L91:
            r0.zzb(r11, r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhc.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhm, com.google.android.gms.internal.measurement.zzfb):void");
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final void zzc(Object obj) {
        this.zzb.zzd(obj);
        this.zzd.zzc(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final boolean zzd(Object obj) {
        return this.zzd.zza(obj).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhp
    public final int zzb(Object obj) {
        zzih zzihVar = this.zzb;
        int iZze = zzihVar.zze(zzihVar.zzb(obj));
        return this.zzc ? iZze + this.zzd.zza(obj).zzg() : iZze;
    }
}
