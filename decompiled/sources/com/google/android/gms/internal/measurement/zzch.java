package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzch implements zzcl {
    private static final Map zza = new ArrayMap();
    private static final String[] zzh = {"key", "value"};
    private final ContentResolver zzb;
    private final Uri zzc;
    private final ContentObserver zzd;
    private final Object zze;
    private volatile Map zzf;
    private final List zzg;

    private zzch(ContentResolver contentResolver, Uri uri) {
        zzcj zzcjVar = new zzcj(this, null);
        this.zzd = zzcjVar;
        this.zze = new Object();
        this.zzg = new ArrayList();
        this.zzb = contentResolver;
        this.zzc = uri;
        contentResolver.registerContentObserver(uri, false, zzcjVar);
    }

    public static zzch zza(ContentResolver contentResolver, Uri uri) {
        zzch zzchVar;
        synchronized (zzch.class) {
            Map map = zza;
            zzchVar = (zzch) map.get(uri);
            if (zzchVar == null) {
                try {
                    zzch zzchVar2 = new zzch(contentResolver, uri);
                    try {
                        map.put(uri, zzchVar2);
                    } catch (SecurityException unused) {
                    }
                    zzchVar = zzchVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzchVar;
    }

    public final Map<String, String> zza() {
        Map<String, String> mapZze = this.zzf;
        if (mapZze == null) {
            synchronized (this.zze) {
                try {
                    mapZze = this.zzf;
                    if (mapZze == null) {
                        mapZze = zze();
                        this.zzf = mapZze;
                    }
                } finally {
                }
            }
        }
        return mapZze != null ? mapZze : Collections.emptyMap();
    }

    public final void zzb() {
        synchronized (this.zze) {
            this.zzf = null;
            zzcv.zza();
        }
        synchronized (this) {
            try {
                Iterator it = this.zzg.iterator();
                while (it.hasNext()) {
                    ((zzcm) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final Map zze() {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzco.zza(new zzcn(this) { // from class: com.google.android.gms.internal.measurement.zzck
                    private final zzch zza;

                    {
                        this.zza = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzcn
                    public final Object zza() {
                        return this.zza.zzd();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static synchronized void zzc() {
        try {
            for (zzch zzchVar : zza.values()) {
                zzchVar.zzb.unregisterContentObserver(zzchVar.zzd);
            }
            zza.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcl
    public final /* synthetic */ Object zza(String str) {
        return zza().get(str);
    }

    final /* synthetic */ Map zzd() {
        Map map;
        Cursor cursorQuery = this.zzb.query(this.zzc, zzh, null, null, null);
        if (cursorQuery == null) {
            return Collections.emptyMap();
        }
        try {
            int count = cursorQuery.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                map = new ArrayMap(count);
            } else {
                map = new HashMap(count, 1.0f);
            }
            while (cursorQuery.moveToNext()) {
                map.put(cursorQuery.getString(0), cursorQuery.getString(1));
            }
            return map;
        } finally {
            cursorQuery.close();
        }
    }
}
