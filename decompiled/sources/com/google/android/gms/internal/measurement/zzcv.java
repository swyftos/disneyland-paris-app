package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class zzcv<T> {
    private static volatile Context zzb;
    private static volatile zzdj zze;
    private final zzdb zzf;
    private final String zzg;
    private final Object zzh;
    private volatile int zzj;
    private volatile Object zzk;
    private final boolean zzl;
    private static final Object zza = new Object();
    private static final AtomicReference zzd = new AtomicReference();
    private static final AtomicInteger zzi = new AtomicInteger();

    @Deprecated
    public static void zza(Context context) {
        synchronized (zza) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                if (zzb != context) {
                    zzch.zzc();
                    zzde.zza();
                    zzcq.zza();
                    zze = zzdm.zza(zzcy.zza);
                    zzb = context;
                    zzi.incrementAndGet();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    abstract Object zza(Object obj);

    static void zza() {
        zzi.incrementAndGet();
    }

    private zzcv(zzdb zzdbVar, String str, Object obj, boolean z) {
        this.zzj = -1;
        if (zzdbVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzf = zzdbVar;
        this.zzg = str;
        this.zzh = obj;
        this.zzl = z;
    }

    private final String zza(String str) {
        if (str != null && str.isEmpty()) {
            return this.zzg;
        }
        String strValueOf = String.valueOf(str);
        String strValueOf2 = String.valueOf(this.zzg);
        return strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
    }

    public final String zzb() {
        return zza(this.zzf.zzd);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009f A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0023, B:19:0x0038, B:21:0x003e, B:23:0x004a, B:27:0x0063, B:29:0x006d, B:47:0x00be, B:49:0x00cc, B:51:0x00e0, B:52:0x00e3, B:53:0x00e7, B:40:0x009f, B:42:0x00b3, B:46:0x00bc, B:25:0x005b, B:30:0x0072, B:32:0x007b, B:34:0x008d, B:36:0x0098, B:35:0x0092, B:54:0x00ec, B:55:0x00f3, B:56:0x00f4), top: B:62:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0023, B:19:0x0038, B:21:0x003e, B:23:0x004a, B:27:0x0063, B:29:0x006d, B:47:0x00be, B:49:0x00cc, B:51:0x00e0, B:52:0x00e3, B:53:0x00e7, B:40:0x009f, B:42:0x00b3, B:46:0x00bc, B:25:0x005b, B:30:0x0072, B:32:0x007b, B:34:0x008d, B:36:0x0098, B:35:0x0092, B:54:0x00ec, B:55:0x00f3, B:56:0x00f4), top: B:62:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T zzc() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcv.zzc():java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcv zzb(zzdb zzdbVar, String str, long j, boolean z) {
        return new zzcx(zzdbVar, str, Long.valueOf(j), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcv zzb(zzdb zzdbVar, String str, boolean z, boolean z2) {
        return new zzda(zzdbVar, str, Boolean.valueOf(z), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcv zzb(zzdb zzdbVar, String str, double d, boolean z) {
        return new zzcz(zzdbVar, str, Double.valueOf(d), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzcv zzb(zzdb zzdbVar, String str, String str2, boolean z) {
        return new zzdc(zzdbVar, str, str2, true);
    }

    static final /* synthetic */ zzdi zzd() {
        new zzcu();
        return zzcu.zza(zzb);
    }

    /* synthetic */ zzcv(zzdb zzdbVar, String str, Object obj, boolean z, zzcx zzcxVar) {
        this(zzdbVar, str, obj, z);
    }
}
