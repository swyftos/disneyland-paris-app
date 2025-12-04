package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzfl {
    private final String zza;
    private final Bundle zzb;
    private boolean zzc;
    private Bundle zzd;
    private final /* synthetic */ zzfg zze;

    public zzfl(zzfg zzfgVar, String str, Bundle bundle) {
        this.zze = zzfgVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[Catch: NumberFormatException | JSONException -> 0x00a1, NumberFormatException | JSONException -> 0x00a1, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x00a1, blocks: (B:9:0x0028, B:30:0x0071, B:30:0x0071, B:31:0x0081, B:31:0x0081, B:32:0x008d, B:32:0x008d, B:33:0x0099, B:33:0x0099, B:16:0x004a, B:19:0x0054, B:22:0x005e), top: B:47:0x0028, outer: #0 }] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zza() throws org.json.JSONException {
        /*
            r11 = this;
            boolean r0 = r11.zzc
            if (r0 != 0) goto Lce
            r0 = 1
            r11.zzc = r0
            com.google.android.gms.measurement.internal.zzfg r1 = r11.zze
            android.content.SharedPreferences r1 = r1.zzg()
            java.lang.String r2 = r11.zza
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)
            if (r1 == 0) goto Lc6
            android.os.Bundle r2 = new android.os.Bundle     // Catch: org.json.JSONException -> Lb7
            r2.<init>()     // Catch: org.json.JSONException -> Lb7
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch: org.json.JSONException -> Lb7
            r3.<init>(r1)     // Catch: org.json.JSONException -> Lb7
            r1 = 0
            r4 = r1
        L22:
            int r5 = r3.length()     // Catch: org.json.JSONException -> Lb7
            if (r4 >= r5) goto Lb4
            org.json.JSONObject r5 = r3.getJSONObject(r4)     // Catch: java.lang.Throwable -> La1
            java.lang.String r6 = "n"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.lang.Throwable -> La1
            java.lang.String r7 = "t"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.lang.Throwable -> La1
            int r8 = r7.hashCode()     // Catch: java.lang.Throwable -> La1
            r9 = 100
            r10 = 2
            if (r8 == r9) goto L5e
            r9 = 108(0x6c, float:1.51E-43)
            if (r8 == r9) goto L54
            r9 = 115(0x73, float:1.61E-43)
            if (r8 == r9) goto L4a
            goto L68
        L4a:
            java.lang.String r8 = "s"
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto L68
            r8 = r1
            goto L69
        L54:
            java.lang.String r8 = "l"
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto L68
            r8 = r10
            goto L69
        L5e:
            java.lang.String r8 = "d"
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Throwable -> La1
            if (r8 == 0) goto L68
            r8 = r0
            goto L69
        L68:
            r8 = -1
        L69:
            java.lang.String r9 = "v"
            if (r8 == 0) goto L99
            if (r8 == r0) goto L8d
            if (r8 == r10) goto L81
            com.google.android.gms.measurement.internal.zzfg r5 = r11.zze     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzr()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzf()     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            java.lang.String r6 = "Unrecognized persisted bundle type. Type"
            r5.zza(r6, r7)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            goto Lb0
        L81:
            java.lang.String r5 = r5.getString(r9)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            long r7 = java.lang.Long.parseLong(r5)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            r2.putLong(r6, r7)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            goto Lb0
        L8d:
            java.lang.String r5 = r5.getString(r9)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            double r7 = java.lang.Double.parseDouble(r5)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            r2.putDouble(r6, r7)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            goto Lb0
        L99:
            java.lang.String r5 = r5.getString(r9)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            r2.putString(r6, r5)     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            goto Lb0
        La1:
            com.google.android.gms.measurement.internal.zzfg r5 = r11.zze     // Catch: org.json.JSONException -> Lb7
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzr()     // Catch: org.json.JSONException -> Lb7
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzf()     // Catch: org.json.JSONException -> Lb7
            java.lang.String r6 = "Error reading value from SharedPreferences. Value dropped"
            r5.zza(r6)     // Catch: org.json.JSONException -> Lb7
        Lb0:
            int r4 = r4 + 1
            goto L22
        Lb4:
            r11.zzd = r2     // Catch: org.json.JSONException -> Lb7
            goto Lc6
        Lb7:
            com.google.android.gms.measurement.internal.zzfg r0 = r11.zze
            com.google.android.gms.measurement.internal.zzeu r0 = r0.zzr()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzf()
            java.lang.String r1 = "Error loading bundle from SharedPreferences. Values will be lost"
            r0.zza(r1)
        Lc6:
            android.os.Bundle r0 = r11.zzd
            if (r0 != 0) goto Lce
            android.os.Bundle r0 = r11.zzb
            r11.zzd = r0
        Lce:
            android.os.Bundle r11 = r11.zzd
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfl.zza():android.os.Bundle");
    }

    @WorkerThread
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.zze.zzg().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.zza);
        } else {
            editorEdit.putString(this.zza, zzb(bundle));
        }
        editorEdit.apply();
        this.zzd = bundle;
    }

    private final String zzb(Bundle bundle) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", CmcdData.Factory.STREAMING_FORMAT_SS);
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", CmcdData.Factory.STREAM_TYPE_LIVE);
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        this.zze.zzr().zzf().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    this.zze.zzr().zzf().zza("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }
}
