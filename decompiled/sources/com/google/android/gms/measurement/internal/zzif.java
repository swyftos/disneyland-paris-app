package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzif implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzic zzc;
    private final String zzd;
    private final Map zze;
    private final /* synthetic */ zzid zzf;

    public zzif(zzid zzidVar, String str, URL url, byte[] bArr, Map map, zzic zzicVar) {
        this.zzf = zzidVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzicVar);
        this.zza = url;
        this.zzb = null;
        this.zzc = zzicVar;
        this.zzd = str;
        this.zze = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzid r0 = r7.zzf
            r0.zzc()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzid r2 = r7.zzf     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L87
            java.net.URL r3 = r7.zza     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L87
            java.net.HttpURLConnection r2 = r2.zza(r3)     // Catch: java.lang.Throwable -> L82 java.io.IOException -> L87
            java.util.Map r3 = r7.zze     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            if (r3 == 0) goto L43
            java.util.Set r3 = r3.entrySet()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
        L1b:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            if (r4 == 0) goto L43
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            java.lang.Object r5 = r4.getKey()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            r2.addRequestProperty(r5, r4)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            goto L1b
        L37:
            r3 = move-exception
            r4 = r3
        L39:
            r3 = r2
            r2 = r0
            goto L8c
        L3d:
            r3 = move-exception
            r4 = r3
        L3f:
            r3 = r2
            r2 = r0
            goto L95
        L43:
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestAboutToBeSent(r2)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            int r3 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L7d
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestHarvestable(r2)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L7d
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestAboutToBeSent(r2)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L79
            java.util.Map r1 = r2.getHeaderFields()     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L74
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.requestHarvestable(r2)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L74
            com.google.android.gms.measurement.internal.zzid r4 = r7.zzf     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L6a
            byte[] r4 = com.google.android.gms.measurement.internal.zzid.zza(r4, r2)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L6a
            r2.disconnect()
            r7.zzb(r3, r0, r4, r1)
            return
        L64:
            r4 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L8c
        L6a:
            r4 = move-exception
            r6 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            goto L95
        L70:
            r1 = move-exception
            r4 = r1
            r1 = r3
            goto L39
        L74:
            r1 = move-exception
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.networkError(r2, r1)     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L79
            throw r1     // Catch: java.lang.Throwable -> L70 java.io.IOException -> L79
        L79:
            r1 = move-exception
            r4 = r1
            r1 = r3
            goto L3f
        L7d:
            r3 = move-exception
            com.appdynamics.eumagent.runtime.InstrumentationCallbacks.networkError(r2, r3)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
            throw r3     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3d
        L82:
            r3 = move-exception
            r2 = r0
            r4 = r3
            r3 = r2
            goto L8c
        L87:
            r3 = move-exception
            r2 = r0
            r4 = r3
            r3 = r2
            goto L95
        L8c:
            if (r3 == 0) goto L91
            r3.disconnect()
        L91:
            r7.zzb(r1, r0, r0, r2)
            throw r4
        L95:
            if (r3 == 0) goto L9a
            r3.disconnect()
        L9a:
            r7.zzb(r1, r4, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzif.run():void");
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map map) throws IllegalStateException {
        this.zzf.zzq().zza(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.zzie
            private final zzif zza;
            private final int zzb;
            private final Exception zzc;
            private final byte[] zzd;
            private final Map zze;

            {
                this.zza = this;
                this.zzb = i;
                this.zzc = exc;
                this.zzd = bArr;
                this.zze = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
            }
        });
    }

    final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
