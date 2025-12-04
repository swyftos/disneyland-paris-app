package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class zzcg {
    private static HashMap zzf;
    private static Object zzk;
    private static boolean zzl;
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zze = new AtomicBoolean();
    private static final HashMap zzg = new HashMap();
    private static final HashMap zzh = new HashMap();
    private static final HashMap zzi = new HashMap();
    private static final HashMap zzj = new HashMap();
    private static String[] zzm = new String[0];

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzcg.class) {
            try {
                if (zzf == null) {
                    zze.set(false);
                    zzf = new HashMap();
                    zzk = new Object();
                    zzl = false;
                    contentResolver.registerContentObserver(zza, true, new zzcf(null));
                } else if (zze.getAndSet(false)) {
                    zzf.clear();
                    zzg.clear();
                    zzh.clear();
                    zzi.clear();
                    zzj.clear();
                    zzk = new Object();
                    zzl = false;
                }
                Object obj = zzk;
                if (zzf.containsKey(str)) {
                    String str3 = (String) zzf.get(str);
                    return str3 != null ? str3 : null;
                }
                for (String str4 : zzm) {
                    if (str.startsWith(str4)) {
                        if (!zzl || zzf.isEmpty()) {
                            zzf.putAll(zza(contentResolver, zzm));
                            zzl = true;
                            if (zzf.containsKey(str)) {
                                String str5 = (String) zzf.get(str);
                                return str5 != null ? str5 : null;
                            }
                        }
                        return null;
                    }
                }
                Cursor cursorQuery = contentResolver.query(zza, null, null, new String[]{str}, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                    }
                    return null;
                }
                try {
                    if (!cursorQuery.moveToFirst()) {
                        zza(obj, str, (String) null);
                        return null;
                    }
                    String string = cursorQuery.getString(1);
                    if (string != null && string.equals(null)) {
                        string = null;
                    }
                    zza(obj, str, string);
                    return string != null ? string : null;
                } finally {
                    cursorQuery.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzcg.class) {
            try {
                if (obj == zzk) {
                    zzf.put(str, str2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Map zza(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(zzd, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery == null) {
            return treeMap;
        }
        while (cursorQuery.moveToNext()) {
            try {
                treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            } finally {
                cursorQuery.close();
            }
        }
        return treeMap;
    }
}
