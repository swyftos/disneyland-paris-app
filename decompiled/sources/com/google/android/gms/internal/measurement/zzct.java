package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;

/* loaded from: classes3.dex */
public final class zzct {
    private static volatile zzdi zza = zzdi.zzc();
    private static final Object zzb = new Object();

    private static boolean zza(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & TsExtractor.TS_STREAM_TYPE_AC3) != 0;
    }

    public static boolean zza(Context context, Uri uri) {
        ProviderInfo providerInfoResolveContentProvider;
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb = new StringBuilder(String.valueOf(authority).length() + 91);
            sb.append(authority);
            sb.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            Log.e("PhenotypeClientHelper", sb.toString());
            return false;
        }
        if (zza.zza()) {
            return ((Boolean) zza.zzb()).booleanValue();
        }
        synchronized (zzb) {
            try {
                if (zza.zza()) {
                    return ((Boolean) zza.zzb()).booleanValue();
                }
                if ("com.google.android.gms".equals(context.getPackageName()) || ((providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName))) {
                    if (zza(context)) {
                        z = true;
                    }
                }
                zza = zzdi.zza(Boolean.valueOf(z));
                return ((Boolean) zza.zzb()).booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
