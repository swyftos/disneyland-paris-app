package com.google.android.gms.internal.measurement;

import android.util.Log;

/* loaded from: classes3.dex */
final class zzda extends zzcv {
    zzda(zzdb zzdbVar, String str, Boolean bool, boolean z) {
        super(zzdbVar, str, bool, z, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzcg.zzb.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzcg.zzc.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String strZzb = super.zzb();
        String strValueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzb).length() + 28 + strValueOf.length());
        sb.append("Invalid boolean value for ");
        sb.append(strZzb);
        sb.append(": ");
        sb.append(strValueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
