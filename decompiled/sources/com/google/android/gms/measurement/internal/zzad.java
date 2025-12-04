package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.contentsquare.android.core.utils.UriBuilder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzad extends zzkg {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzae zzj;
    private final zzkc zzk;

    zzad(zzkj zzkjVar) {
        super(zzkjVar);
        this.zzk = new zzkc(zzm());
        this.zzj = new zzae(this, zzn(), "google_app_measurement.db");
    }

    @Override // com.google.android.gms.measurement.internal.zzkg
    protected final boolean zze() {
        return false;
    }

    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j2 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j2;
                }
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                this.zzr().zzf().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzak zza(java.lang.String r29, java.lang.String r30) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzak");
    }

    public final void zza(zzak zzakVar) {
        Preconditions.checkNotNull(zzakVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzakVar.zza);
        contentValues.put("name", zzakVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzakVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzakVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzakVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzakVar.zzg));
        contentValues.put("last_bundled_day", zzakVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzakVar.zzi);
        contentValues.put("last_sampling_rate", zzakVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzakVar.zze));
        Boolean bool = zzakVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict(UriBuilder.ANALYTICS_EVENT_ENDPOINT, null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzeu.zza(zzakVar.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzeu.zza(zzakVar.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user property. appId", zzeu.zza(str), zzo().zzc(str2), e);
        }
    }

    public final boolean zza(zzks zzksVar) {
        Preconditions.checkNotNull(zzksVar);
        zzd();
        zzak();
        if (zzc(zzksVar.zza, zzksVar.zzc) == null) {
            if (zzkr.zza(zzksVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzksVar.zza}) >= zzt().zzd(zzksVar.zza)) {
                    return false;
                }
            } else if (!"_npa".equals(zzksVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzksVar.zza, zzksVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzksVar.zza);
        contentValues.put("origin", zzksVar.zzb);
        contentValues.put("name", zzksVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzksVar.zzd));
        zza(contentValues, "value", zzksVar.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzeu.zza(zzksVar.zza));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzeu.zza(zzksVar.zza), e);
            return true;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0064: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:14:0x0064 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzks zzc(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r10.zzd()
            r10.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.c_()     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            java.lang.String r4 = "app_id=? and name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L6c android.database.sqlite.SQLiteException -> L6e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            if (r2 != 0) goto L34
            r1.close()
            return r0
        L34:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            r2 = 1
            java.lang.Object r9 = r10.zza(r1, r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            com.google.android.gms.measurement.internal.zzks r2 = new com.google.android.gms.measurement.internal.zzks     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            if (r3 == 0) goto L68
            com.google.android.gms.measurement.internal.zzeu r3 = r10.zzr()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zza(r11)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            r3.zza(r4, r5)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L66
            goto L68
        L63:
            r10 = move-exception
            r0 = r1
            goto L8f
        L66:
            r2 = move-exception
            goto L70
        L68:
            r1.close()
            return r2
        L6c:
            r10 = move-exception
            goto L8f
        L6e:
            r2 = move-exception
            r1 = r0
        L70:
            com.google.android.gms.measurement.internal.zzeu r3 = r10.zzr()     // Catch: java.lang.Throwable -> L63
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L63
            java.lang.String r4 = "Error querying user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeu.zza(r11)     // Catch: java.lang.Throwable -> L63
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzo()     // Catch: java.lang.Throwable -> L63
            java.lang.String r10 = r10.zzc(r12)     // Catch: java.lang.Throwable -> L63
            r3.zza(r4, r11, r10, r2)     // Catch: java.lang.Throwable -> L63
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            return r0
        L8f:
            if (r0 == 0) goto L94
            r0.close()
        L94:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzks");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzd()
            r11.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.c_()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L85
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L85
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L85
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L85
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            if (r3 != 0) goto L3b
            r2.close()
            return r0
        L3b:
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            r3 = 1
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            if (r3 != 0) goto L49
            java.lang.String r3 = ""
        L49:
            r6 = r3
            goto L51
        L4b:
            r11 = move-exception
            r1 = r2
            goto Lba
        L4f:
            r0 = move-exception
            goto L87
        L51:
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            r3 = 3
            java.lang.Object r10 = r11.zza(r2, r3)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            if (r10 != 0) goto L6f
            com.google.android.gms.measurement.internal.zzeu r3 = r11.zzr()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zza(r12)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            r3.zza(r4, r5)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            goto L79
        L6f:
            com.google.android.gms.measurement.internal.zzks r3 = new com.google.android.gms.measurement.internal.zzks     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            r4 = r3
            r5 = r12
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            r0.add(r3)     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
        L79:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L4b android.database.sqlite.SQLiteException -> L4f
            if (r3 != 0) goto L3b
            r2.close()
            return r0
        L83:
            r11 = move-exception
            goto Lba
        L85:
            r0 = move-exception
            r2 = r1
        L87:
            com.google.android.gms.measurement.internal.zzeu r3 = r11.zzr()     // Catch: java.lang.Throwable -> L4b
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zza(r12)     // Catch: java.lang.Throwable -> L4b
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> L4b
            boolean r0 = com.google.android.gms.internal.measurement.zzku.zzb()     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto Lb4
            com.google.android.gms.measurement.internal.zzy r11 = r11.zzt()     // Catch: java.lang.Throwable -> L4b
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch: java.lang.Throwable -> L4b
            boolean r11 = r11.zze(r12, r0)     // Catch: java.lang.Throwable -> L4b
            if (r11 == 0) goto Lb4
            java.util.List r11 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L4b
            if (r2 == 0) goto Lb3
            r2.close()
        Lb3:
            return r11
        Lb4:
            if (r2 == 0) goto Lb9
            r2.close()
        Lb9:
            return r1
        Lba:
            if (r1 == 0) goto Lbf
            r1.close()
        Lbf:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0096, code lost:
    
        zzr().zzf().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zza(zzw zzwVar) {
        Preconditions.checkNotNull(zzwVar);
        zzd();
        zzak();
        if (zzc(zzwVar.zza, zzwVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzwVar.zza}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzwVar.zza);
        contentValues.put("origin", zzwVar.zzb);
        contentValues.put("name", zzwVar.zzc.zza);
        zza(contentValues, "value", zzwVar.zzc.zza());
        contentValues.put("active", Boolean.valueOf(zzwVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzwVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzwVar.zzh));
        zzp();
        contentValues.put("timed_out_event", zzkr.zza((Parcelable) zzwVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzwVar.zzd));
        zzp();
        contentValues.put("triggered_event", zzkr.zza((Parcelable) zzwVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzwVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzwVar.zzj));
        zzp();
        contentValues.put("expired_event", zzkr.zza((Parcelable) zzwVar.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzeu.zza(zzwVar.zza));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzeu.zza(zzwVar.zza), e);
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzw zzd(java.lang.String r27, java.lang.String r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzw");
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            this.zzr().zzf().zza("Error deleting conditional property", zzeu.zza(str), this.zzo().zzc(str2), e);
            return 0;
        }
    }

    public final List zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        zzr().zzf().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00d8: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:17:0x00d8 */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0225  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public final void zza(zzf zzfVar) {
        Preconditions.checkNotNull(zzfVar);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfVar.zzc());
        contentValues.put("app_instance_id", zzfVar.zzd());
        contentValues.put("gmp_app_id", zzfVar.zze());
        contentValues.put("resettable_device_id_hash", zzfVar.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzfVar.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzfVar.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzfVar.zzk()));
        contentValues.put("app_version", zzfVar.zzl());
        contentValues.put("app_store", zzfVar.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzfVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzfVar.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzfVar.zzr()));
        contentValues.put("day", Long.valueOf(zzfVar.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzfVar.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzfVar.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzfVar.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzfVar.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzfVar.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzfVar.zzm()));
        contentValues.put("firebase_instance_id", zzfVar.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzfVar.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzfVar.zzaa()));
        contentValues.put("health_monitor_sample", zzfVar.zzac());
        contentValues.put("android_id", Long.valueOf(zzfVar.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzfVar.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzfVar.zzag()));
        contentValues.put("admob_app_id", zzfVar.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzfVar.zzq()));
        if (zzfVar.zzai() != null) {
            if (zzfVar.zzai().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzfVar.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzfVar.zzai()));
            }
        }
        if (zzlm.zzb() && zzt().zze(zzfVar.zzc(), zzaq.zzbn)) {
            contentValues.put("ga_app_id", zzfVar.zzg());
        }
        try {
            SQLiteDatabase sQLiteDatabaseC_ = c_();
            if (sQLiteDatabaseC_.update("apps", contentValues, "app_id = ?", new String[]{zzfVar.zzc()}) == 0 && sQLiteDatabaseC_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzeu.zza(zzfVar.zzc()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzeu.zza(zzfVar.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzaq.zzo))))});
        } catch (SQLiteException e) {
            this.zzr().zzf().zza("Error deleting over the limit events. appId", zzeu.zza(str), e);
            return 0L;
        }
    }

    public final zzac zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1L, false, false, z3, false, z5);
    }

    public final zzac zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        String[] strArr = {str};
        zzac zzacVar = new zzac();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseC_ = c_();
                Cursor cursorQuery = sQLiteDatabaseC_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzr().zzi().zza("Not updating daily counts, app is not known. appId", zzeu.zza(str));
                    cursorQuery.close();
                    return zzacVar;
                }
                if (cursorQuery.getLong(0) == j) {
                    zzacVar.zzb = cursorQuery.getLong(1);
                    zzacVar.zza = cursorQuery.getLong(2);
                    zzacVar.zzc = cursorQuery.getLong(3);
                    zzacVar.zzd = cursorQuery.getLong(4);
                    zzacVar.zze = cursorQuery.getLong(5);
                }
                if (z) {
                    zzacVar.zzb += j2;
                }
                if (z2) {
                    zzacVar.zza += j2;
                }
                if (z3) {
                    zzacVar.zzc += j2;
                }
                if (z4) {
                    zzacVar.zzd += j2;
                }
                if (z5) {
                    zzacVar.zze += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzacVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzacVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzacVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzacVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzacVar.zze));
                sQLiteDatabaseC_.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return zzacVar;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error updating daily counts. appId", zzeu.zza(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return zzacVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:14:0x004b */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] zzd(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r9.zzd()
            r9.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.c_()     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L53 android.database.sqlite.SQLiteException -> L55
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            if (r2 != 0) goto L2d
            r1.close()
            return r0
        L2d:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            if (r3 == 0) goto L4f
            com.google.android.gms.measurement.internal.zzeu r3 = r9.zzr()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zza(r10)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            r3.zza(r4, r5)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteException -> L4d
            goto L4f
        L4a:
            r9 = move-exception
            r0 = r1
            goto L6e
        L4d:
            r2 = move-exception
            goto L57
        L4f:
            r1.close()
            return r2
        L53:
            r9 = move-exception
            goto L6e
        L55:
            r2 = move-exception
            r1 = r0
        L57:
            com.google.android.gms.measurement.internal.zzeu r9 = r9.zzr()     // Catch: java.lang.Throwable -> L4a
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzf()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = "Error querying remote config. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeu.zza(r10)     // Catch: java.lang.Throwable -> L4a
            r9.zza(r3, r10, r2)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L6d
            r1.close()
        L6d:
            return r0
        L6e:
            if (r0 == 0) goto L73
            r0.close()
        L73:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzd(java.lang.String):byte[]");
    }

    public final boolean zza(zzcb.zzg zzgVar, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        Preconditions.checkState(zzgVar.zzk());
        zzv();
        long jCurrentTimeMillis = zzm().currentTimeMillis();
        if (zzgVar.zzl() < jCurrentTimeMillis - zzy.zzk() || zzgVar.zzl() > zzy.zzk() + jCurrentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeu.zza(zzgVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgVar.zzl()));
        }
        try {
            byte[] bArrZzc = zzg().zzc(zzgVar.zzbi());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(bArrZzc.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zzl()));
            contentValues.put("data", bArrZzc);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzba()));
            }
            try {
                if (c_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzeu.zza(zzgVar.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzeu.zza(zzgVar.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzeu.zza(zzgVar.zzx()), e2);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String d_() throws java.lang.Throwable {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteException -> L25
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1d
            if (r2 == 0) goto L1f
            r2 = 0
            java.lang.String r4 = r0.getString(r2)     // Catch: java.lang.Throwable -> L1a android.database.sqlite.SQLiteException -> L1d
            r0.close()
            return r4
        L1a:
            r4 = move-exception
            r1 = r0
            goto L3a
        L1d:
            r2 = move-exception
            goto L27
        L1f:
            r0.close()
            return r1
        L23:
            r4 = move-exception
            goto L3a
        L25:
            r2 = move-exception
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.zzeu r4 = r4.zzr()     // Catch: java.lang.Throwable -> L1a
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzf()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r3 = "Database error getting next bundle app id"
            r4.zza(r3, r2)     // Catch: java.lang.Throwable -> L1a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            if (r1 == 0) goto L3f
            r1.close()
        L3f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.d_():java.lang.String");
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final List zza(String str, int i, int i2) {
        byte[] bArrZzb;
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!cursorQuery.moveToFirst()) {
                    List listEmptyList = Collections.emptyList();
                    cursorQuery.close();
                    return listEmptyList;
                }
                ArrayList arrayList = new ArrayList();
                int length = 0;
                do {
                    long j = cursorQuery.getLong(0);
                    try {
                        bArrZzb = zzg().zzb(cursorQuery.getBlob(1));
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to unzip queued bundle. appId", zzeu.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && bArrZzb.length + length > i2) {
                        break;
                    }
                    try {
                        zzcb.zzg.zza zzaVar = (zzcb.zzg.zza) zzkn.zza(zzcb.zzg.zzbf(), bArrZzb);
                        if (!cursorQuery.isNull(2)) {
                            zzaVar.zzi(cursorQuery.getInt(2));
                        }
                        length += bArrZzb.length;
                        arrayList.add(Pair.create((zzcb.zzg) ((com.google.android.gms.internal.measurement.zzfo) zzaVar.zzv()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzeu.zza(str), e2);
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                } while (length <= i2);
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e3) {
                zzr().zzf().zza("Error querying bundles. appId", zzeu.zza(str), e3);
                List listEmptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return listEmptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final void zzv() {
        int iDelete;
        zzd();
        zzak();
        if (zzam()) {
            long jZza = zzs().zzf.zza();
            long jElapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzaq.zzx.zza(null).longValue()) {
                zzs().zzf.zza(jElapsedRealtime);
                zzd();
                zzak();
                if (!zzam() || (iDelete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzy.zzk())})) <= 0) {
                    return;
                }
                zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    final void zza(List list) throws SQLException {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb2.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseC_ = c_();
                StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseC_.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbt.zzb zzbVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzc())) {
            zzr().zzi().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzeu.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbi = zzbVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzc());
        contentValues.put("session_scoped", zzbVar.zzj() ? Boolean.valueOf(zzbVar.zzk()) : null);
        contentValues.put("data", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzeu.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzeu.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbt.zze zzeVar) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzc())) {
            zzr().zzi().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzeu.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbi = zzeVar.zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null);
        contentValues.put("property_name", zzeVar.zzc());
        contentValues.put("session_scoped", zzeVar.zzg() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzeu.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzeu.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map zzf(java.lang.String r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            r10 = this;
            r10.zzak()
            r10.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r10.c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteException -> L97
            java.lang.String r4 = "app_id=? AND event_name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteException -> L97
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            if (r1 != 0) goto L41
            java.util.Map r10 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r12.close()
            return r10
        L3b:
            r10 = move-exception
            r9 = r12
            goto Lcc
        L3f:
            r0 = move-exception
            goto L99
        L41:
            r1 = 1
            byte[] r1 = r12.getBlob(r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            com.google.android.gms.internal.measurement.zzbt$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbt.zzb.zzl()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzgz r1 = com.google.android.gms.measurement.internal.zzkn.zza(r2, r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzbt$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbt.zzb.zza) r1     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzgw r1 = r1.zzv()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzfo r1 = (com.google.android.gms.internal.measurement.zzfo) r1     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzbt$zzb r1 = (com.google.android.gms.internal.measurement.zzbt.zzb) r1     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            r2 = 0
            int r2 = r12.getInt(r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.Object r3 = r0.get(r3)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            if (r3 != 0) goto L75
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r3.<init>()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
        L75:
            r3.add(r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            goto L8b
        L79:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeu r2 = r10.zzr()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzf()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zza(r11)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r2.zza(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
        L8b:
            boolean r1 = r12.moveToNext()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            if (r1 != 0) goto L41
            r12.close()
            return r0
        L95:
            r10 = move-exception
            goto Lcc
        L97:
            r0 = move-exception
            r12 = r9
        L99:
            com.google.android.gms.measurement.internal.zzeu r1 = r10.zzr()     // Catch: java.lang.Throwable -> L3b
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzf()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zza(r11)     // Catch: java.lang.Throwable -> L3b
            r1.zza(r2, r3, r0)     // Catch: java.lang.Throwable -> L3b
            boolean r0 = com.google.android.gms.internal.measurement.zzku.zzb()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto Lc6
            com.google.android.gms.measurement.internal.zzy r10 = r10.zzt()     // Catch: java.lang.Throwable -> L3b
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch: java.lang.Throwable -> L3b
            boolean r10 = r10.zze(r11, r0)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto Lc6
            java.util.Map r10 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L3b
            if (r12 == 0) goto Lc5
            r12.close()
        Lc5:
            return r10
        Lc6:
            if (r12 == 0) goto Lcb
            r12.close()
        Lcb:
            return r9
        Lcc:
            if (r9 == 0) goto Ld1
            r9.close()
        Ld1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    final Map zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzbt.zzb zzbVar = (zzbt.zzb) ((com.google.android.gms.internal.measurement.zzfo) ((zzbt.zzb.zza) zzkn.zza(zzbt.zzb.zzl(), cursorQuery.getBlob(1))).zzv());
                        if (zzbVar.zzf()) {
                            int i = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge filter. appId", zzeu.zza(str), e);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e2) {
                zzr().zzf().zza("Database error querying filters. appId", zzeu.zza(str), e2);
                Map mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map zzg(java.lang.String r11, java.lang.String r12) throws java.lang.Throwable {
        /*
            r10 = this;
            r10.zzak()
            r10.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r10.c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteException -> L97
            java.lang.String r4 = "app_id=? AND property_name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteException -> L97
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L95 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            if (r1 != 0) goto L41
            java.util.Map r10 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r12.close()
            return r10
        L3b:
            r10 = move-exception
            r9 = r12
            goto Lcc
        L3f:
            r0 = move-exception
            goto L99
        L41:
            r1 = 1
            byte[] r1 = r12.getBlob(r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            com.google.android.gms.internal.measurement.zzbt$zze$zza r2 = com.google.android.gms.internal.measurement.zzbt.zze.zzi()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzgz r1 = com.google.android.gms.measurement.internal.zzkn.zza(r2, r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzbt$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbt.zze.zza) r1     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzgw r1 = r1.zzv()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzfo r1 = (com.google.android.gms.internal.measurement.zzfo) r1     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            com.google.android.gms.internal.measurement.zzbt$zze r1 = (com.google.android.gms.internal.measurement.zzbt.zze) r1     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f java.io.IOException -> L79
            r2 = 0
            int r2 = r12.getInt(r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.Object r3 = r0.get(r3)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            if (r3 != 0) goto L75
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r3.<init>()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
        L75:
            r3.add(r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            goto L8b
        L79:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeu r2 = r10.zzr()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzf()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zza(r11)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            r2.zza(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
        L8b:
            boolean r1 = r12.moveToNext()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteException -> L3f
            if (r1 != 0) goto L41
            r12.close()
            return r0
        L95:
            r10 = move-exception
            goto Lcc
        L97:
            r0 = move-exception
            r12 = r9
        L99:
            com.google.android.gms.measurement.internal.zzeu r1 = r10.zzr()     // Catch: java.lang.Throwable -> L3b
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzf()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeu.zza(r11)     // Catch: java.lang.Throwable -> L3b
            r1.zza(r2, r3, r0)     // Catch: java.lang.Throwable -> L3b
            boolean r0 = com.google.android.gms.internal.measurement.zzku.zzb()     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto Lc6
            com.google.android.gms.measurement.internal.zzy r10 = r10.zzt()     // Catch: java.lang.Throwable -> L3b
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch: java.lang.Throwable -> L3b
            boolean r10 = r10.zze(r11, r0)     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto Lc6
            java.util.Map r10 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L3b
            if (r12 == 0) goto Lc5
            r12.close()
        Lc5:
            return r10
        Lc6:
            if (r12 == 0) goto Lcb
            r12.close()
        Lcb:
            return r9
        Lcc:
            if (r9 == 0) goto Ld1
            r9.close()
        Ld1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map zzf(java.lang.String r7) throws java.lang.Throwable {
        /*
            r6 = this;
            r6.zzak()
            r6.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r6.c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            java.lang.String[] r4 = new java.lang.String[]{r7, r7}     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L63 android.database.sqlite.SQLiteException -> L65
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            if (r3 != 0) goto L30
            java.util.Map r6 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            r1.close()
            return r6
        L2b:
            r6 = move-exception
            r2 = r1
            goto L9a
        L2e:
            r0 = move-exception
            goto L67
        L30:
            r3 = 0
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            java.lang.Object r4 = r0.get(r4)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            if (r4 != 0) goto L4d
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            r4.<init>()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            r0.put(r3, r4)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
        L4d:
            r3 = 1
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            r4.add(r3)     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2b android.database.sqlite.SQLiteException -> L2e
            if (r3 != 0) goto L30
            r1.close()
            return r0
        L63:
            r6 = move-exception
            goto L9a
        L65:
            r0 = move-exception
            r1 = r2
        L67:
            com.google.android.gms.measurement.internal.zzeu r3 = r6.zzr()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeu.zza(r7)     // Catch: java.lang.Throwable -> L2b
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> L2b
            boolean r0 = com.google.android.gms.internal.measurement.zzku.zzb()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L94
            com.google.android.gms.measurement.internal.zzy r6 = r6.zzt()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r0 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch: java.lang.Throwable -> L2b
            boolean r6 = r6.zze(r7, r0)     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L94
            java.util.Map r6 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L2b
            if (r1 == 0) goto L93
            r1.close()
        L93:
            return r6
        L94:
            if (r1 == 0) goto L99
            r1.close()
        L99:
            return r2
        L9a:
            if (r2 == 0) goto L9f
            r2.close()
        L9f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzf(java.lang.String):java.util.Map");
    }

    private final boolean zzb(String str, List list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zzt().zzb(str, zzaq.zzae)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = (Integer) list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String strJoin = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 140);
            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb2.append(string);
            sb2.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseC_.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzeu.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d1  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.Map zzg(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r9.zzak()
            r9.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            if (r1 != 0) goto L4f
            boolean r1 = com.google.android.gms.internal.measurement.zzku.zzb()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            if (r1 == 0) goto L4b
            com.google.android.gms.measurement.internal.zzy r1 = r9.zzt()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            boolean r1 = r1.zze(r10, r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            if (r1 == 0) goto L4b
            java.util.Map r9 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            r0.close()
            return r9
        L45:
            r9 = move-exception
            r8 = r0
            goto Lcf
        L49:
            r1 = move-exception
            goto L9c
        L4b:
            r0.close()
            return r8
        L4f:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            r1.<init>()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
        L54:
            r2 = 0
            int r2 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            r3 = 1
            byte[] r3 = r0.getBlob(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            com.google.android.gms.internal.measurement.zzcb$zzi$zza r4 = com.google.android.gms.internal.measurement.zzcb.zzi.zzi()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49 java.io.IOException -> L78
            com.google.android.gms.internal.measurement.zzgz r3 = com.google.android.gms.measurement.internal.zzkn.zza(r4, r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49 java.io.IOException -> L78
            com.google.android.gms.internal.measurement.zzcb$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzcb.zzi.zza) r3     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49 java.io.IOException -> L78
            com.google.android.gms.internal.measurement.zzgw r3 = r3.zzv()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49 java.io.IOException -> L78
            com.google.android.gms.internal.measurement.zzfo r3 = (com.google.android.gms.internal.measurement.zzfo) r3     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49 java.io.IOException -> L78
            com.google.android.gms.internal.measurement.zzcb$zzi r3 = (com.google.android.gms.internal.measurement.zzcb.zzi) r3     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49 java.io.IOException -> L78
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            goto L8e
        L78:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzeu r4 = r9.zzr()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzf()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeu.zza(r10)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            r4.zza(r5, r6, r2, r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
        L8e:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteException -> L49
            if (r2 != 0) goto L54
            r0.close()
            return r1
        L98:
            r9 = move-exception
            goto Lcf
        L9a:
            r1 = move-exception
            r0 = r8
        L9c:
            com.google.android.gms.measurement.internal.zzeu r2 = r9.zzr()     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzf()     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeu.zza(r10)     // Catch: java.lang.Throwable -> L45
            r2.zza(r3, r4, r1)     // Catch: java.lang.Throwable -> L45
            boolean r1 = com.google.android.gms.internal.measurement.zzku.zzb()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto Lc9
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzt()     // Catch: java.lang.Throwable -> L45
            com.google.android.gms.measurement.internal.zzen<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaq.zzcs     // Catch: java.lang.Throwable -> L45
            boolean r9 = r9.zze(r10, r1)     // Catch: java.lang.Throwable -> L45
            if (r9 == 0) goto Lc9
            java.util.Map r9 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto Lc8
            r0.close()
        Lc8:
            return r9
        Lc9:
            if (r0 == 0) goto Lce
            r0.close()
        Lce:
            return r8
        Lcf:
            if (r8 == 0) goto Ld4
            r8.close()
        Ld4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzg(java.lang.String):java.util.Map");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type == 4) {
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
        zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
        return null;
    }

    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    protected final long zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        long j = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
                sb.append("select ");
                sb.append(str2);
                sb.append(" from app2 where app_id=?");
                long jZza = zza(sb.toString(), new String[]{str}, -1L);
                if (jZza == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseC_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzeu.zza(str), str2);
                        return -1L;
                    }
                    jZza = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put(str2, Long.valueOf(1 + jZza));
                    if (sQLiteDatabaseC_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzr().zzf().zza("Failed to update column (got 0). appId", zzeu.zza(str), str2);
                        return -1L;
                    }
                    sQLiteDatabaseC_.setTransactionSuccessful();
                    return jZza;
                } catch (SQLiteException e) {
                    long j2 = jZza;
                    e = e;
                    j = j2;
                    zzr().zzf().zza("Error inserting column. appId", zzeu.zza(str), str2, e);
                    sQLiteDatabaseC_.endTransaction();
                    return j;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } finally {
            sQLiteDatabaseC_.endTransaction();
        }
    }

    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zza(zzcb.zzg zzgVar) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        byte[] bArrZzbi = zzgVar.zzbi();
        long jZza = zzg().zza(bArrZzbi);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put("metadata", bArrZzbi);
        try {
            c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzeu.zza(zzgVar.zzx()), e);
            throw e;
        }
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(long r4) throws java.lang.Throwable {
        /*
            r3 = this;
            r3.zzd()
            r3.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r3.c_()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            android.database.Cursor r4 = r1.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteException -> L40
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            if (r5 != 0) goto L35
            com.google.android.gms.measurement.internal.zzeu r5 = r3.zzr()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzx()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r1 = "No expired configs for apps with pending events"
            r5.zza(r1)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r4.close()
            return r0
        L30:
            r3 = move-exception
            r0 = r4
            goto L55
        L33:
            r5 = move-exception
            goto L42
        L35:
            r5 = 0
            java.lang.String r3 = r4.getString(r5)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r4.close()
            return r3
        L3e:
            r3 = move-exception
            goto L55
        L40:
            r5 = move-exception
            r4 = r0
        L42:
            com.google.android.gms.measurement.internal.zzeu r3 = r3.zzr()     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L30
            java.lang.String r1 = "Error selecting expired configs"
            r3.zza(r1, r5)     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L54
            r4.close()
        L54:
            return r0
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(long):java.lang.String");
    }

    public final long zzaa() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error querying raw events", e);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:10:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair zza(java.lang.String r6, java.lang.Long r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.zzd()
            r5.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.c_()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            java.lang.String r3 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String[] r3 = new java.lang.String[]{r6, r3}     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.zzeu r6 = r5.zzr()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzx()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r7 = "Main event not found"
            r6.zza(r7)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r0
        L30:
            r5 = move-exception
            r0 = r1
            goto L8a
        L33:
            r6 = move-exception
            goto L77
        L35:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r3 = 1
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.internal.measurement.zzcb$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcb.zzc.zzj()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzgz r2 = com.google.android.gms.measurement.internal.zzkn.zza(r4, r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzcb$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcb.zzc.zza) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzgw r2 = r2.zzv()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            com.google.android.gms.internal.measurement.zzcb$zzc r2 = (com.google.android.gms.internal.measurement.zzcb.zzc) r2     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33 java.io.IOException -> L5d
            android.util.Pair r5 = android.util.Pair.create(r2, r3)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r5
        L5d:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeu r3 = r5.zzr()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeu.zza(r6)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r3.zza(r4, r6, r7, r2)     // Catch: java.lang.Throwable -> L30 android.database.sqlite.SQLiteException -> L33
            r1.close()
            return r0
        L73:
            r5 = move-exception
            goto L8a
        L75:
            r6 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.zzeu r5 = r5.zzr()     // Catch: java.lang.Throwable -> L30
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzf()     // Catch: java.lang.Throwable -> L30
            java.lang.String r7 = "Error selecting main event"
            r5.zza(r7, r6)     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            if (r0 == 0) goto L8f
            r0.close()
        L8f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzcb.zzc zzcVar) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] bArrZzbi = zzcVar.zzbi();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(bArrZzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(TCEventPropertiesNames.TCE_EVENTID, l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzeu.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzeu.zza(str), e);
            return false;
        }
    }

    final boolean zza(String str, Bundle bundle) {
        zzd();
        zzak();
        byte[] bArrZzbi = zzg().zza(new zzal(this.zzy, "", str, "dep", 0L, 0L, bundle)).zzbi();
        zzr().zzx().zza("Saving default event parameters, appId, data size", zzo().zza(str), Integer.valueOf(bArrZzbi.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbi);
        try {
            if (c_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert default event parameters (got -1). appId", zzeu.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing default event parameters. appId", zzeu.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002d: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:10:0x002d */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzi(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> Lbc android.database.sqlite.SQLiteException -> Lbe
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            if (r2 != 0) goto L33
            com.google.android.gms.measurement.internal.zzeu r8 = r7.zzr()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            com.google.android.gms.measurement.internal.zzew r8 = r8.zzx()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r1.close()
            return r0
        L2c:
            r7 = move-exception
            r0 = r1
            goto Ld3
        L30:
            r8 = move-exception
            goto Lc0
        L33:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            com.google.android.gms.internal.measurement.zzcb$zzc$zza r3 = com.google.android.gms.internal.measurement.zzcb.zzc.zzj()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30 java.io.IOException -> La6
            com.google.android.gms.internal.measurement.zzgz r2 = com.google.android.gms.measurement.internal.zzkn.zza(r3, r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30 java.io.IOException -> La6
            com.google.android.gms.internal.measurement.zzcb$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcb.zzc.zza) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30 java.io.IOException -> La6
            com.google.android.gms.internal.measurement.zzgw r2 = r2.zzv()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30 java.io.IOException -> La6
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30 java.io.IOException -> La6
            com.google.android.gms.internal.measurement.zzcb$zzc r2 = (com.google.android.gms.internal.measurement.zzcb.zzc) r2     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30 java.io.IOException -> La6
            r7.zzg()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            java.util.List r8 = r2.zza()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r2.<init>()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
        L5a:
            boolean r3 = r8.hasNext()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            if (r3 == 0) goto La2
            java.lang.Object r3 = r8.next()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            com.google.android.gms.internal.measurement.zzcb$zze r3 = (com.google.android.gms.internal.measurement.zzcb.zze) r3     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            java.lang.String r4 = r3.zzb()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            boolean r5 = r3.zzi()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            if (r5 == 0) goto L78
            double r5 = r3.zzj()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r2.putDouble(r4, r5)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            goto L5a
        L78:
            boolean r5 = r3.zzg()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            if (r5 == 0) goto L86
            float r3 = r3.zzh()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r2.putFloat(r4, r3)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            goto L5a
        L86:
            boolean r5 = r3.zzc()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            if (r5 == 0) goto L94
            java.lang.String r3 = r3.zzd()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r2.putString(r4, r3)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            goto L5a
        L94:
            boolean r5 = r3.zze()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            if (r5 == 0) goto L5a
            long r5 = r3.zzf()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r2.putLong(r4, r5)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            goto L5a
        La2:
            r1.close()
            return r2
        La6:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeu r3 = r7.zzr()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzf()     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeu.zza(r8)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r3.zza(r4, r8, r2)     // Catch: java.lang.Throwable -> L2c android.database.sqlite.SQLiteException -> L30
            r1.close()
            return r0
        Lbc:
            r7 = move-exception
            goto Ld3
        Lbe:
            r8 = move-exception
            r1 = r0
        Lc0:
            com.google.android.gms.measurement.internal.zzeu r7 = r7.zzr()     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzf()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = "Error selecting default event parameters"
            r7.zza(r2, r8)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto Ld2
            r1.close()
        Ld2:
            return r0
        Ld3:
            if (r0 == 0) goto Ld8
            r0.close()
        Ld8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzi(java.lang.String):android.os.Bundle");
    }

    public final boolean zza(zzal zzalVar, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzalVar);
        Preconditions.checkNotEmpty(zzalVar.zza);
        byte[] bArrZzbi = zzg().zza(zzalVar).zzbi();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzalVar.zza);
        contentValues.put("name", zzalVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzalVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", bArrZzbi);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzeu.zza(zzalVar.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzeu.zza(zzalVar.zza), e);
            return false;
        }
    }

    final void zza(String str, List list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbt.zza.C0063zza c0063zzaZzbl = ((zzbt.zza) list.get(i)).zzbl();
            if (c0063zzaZzbl.zzb() != 0) {
                for (int i2 = 0; i2 < c0063zzaZzbl.zzb(); i2++) {
                    zzbt.zzb.zza zzaVarZzbl = c0063zzaZzbl.zzb(i2).zzbl();
                    zzbt.zzb.zza zzaVar = (zzbt.zzb.zza) ((zzfo.zza) zzaVarZzbl.clone());
                    String strZzb = zzgw.zzb(zzaVarZzbl.zza());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzaVarZzbl.zzb(); i3++) {
                        zzbt.zzc zzcVarZza = zzaVarZzbl.zza(i3);
                        String strZza = zzgz.zza(zzcVarZza.zzh());
                        if (strZza != null) {
                            zzaVar.zza(i3, (zzbt.zzc) ((com.google.android.gms.internal.measurement.zzfo) zzcVarZza.zzbl().zza(strZza).zzv()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zzbt.zza.C0063zza c0063zzaZza = c0063zzaZzbl.zza(i2, zzaVar);
                        list.set(i, (zzbt.zza) ((com.google.android.gms.internal.measurement.zzfo) c0063zzaZza.zzv()));
                        c0063zzaZzbl = c0063zzaZza;
                    }
                }
            }
            if (c0063zzaZzbl.zza() != 0) {
                for (int i4 = 0; i4 < c0063zzaZzbl.zza(); i4++) {
                    zzbt.zze zzeVarZza = c0063zzaZzbl.zza(i4);
                    String strZza2 = zzgy.zza(zzeVarZza.zzc());
                    if (strZza2 != null) {
                        c0063zzaZzbl = c0063zzaZzbl.zza(i4, zzeVarZza.zzbl().zza(strZza2));
                        list.set(i, (zzbt.zza) ((com.google.android.gms.internal.measurement.zzfo) c0063zzaZzbl.zzv()));
                    }
                }
            }
        }
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseC_ = c_();
        sQLiteDatabaseC_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseC_2 = c_();
            sQLiteDatabaseC_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseC_2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzbt.zza zzaVar2 = (zzbt.zza) it.next();
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzeu.zza(str));
                } else {
                    int iZzb = zzaVar2.zzb();
                    Iterator<zzbt.zzb> it2 = zzaVar2.zze().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().zza()) {
                                zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzeu.zza(str), Integer.valueOf(iZzb));
                                break;
                            }
                        } else {
                            Iterator<zzbt.zze> it3 = zzaVar2.zzc().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!it3.next().zza()) {
                                        zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzeu.zza(str), Integer.valueOf(iZzb));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbt.zzb> it4 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            if (!zza(str, iZzb, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbt.zze> it5 = zzaVar2.zzc().iterator();
                                        while (true) {
                                            if (it5.hasNext()) {
                                                if (!zza(str, iZzb, it5.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseC_3 = c_();
                                        sQLiteDatabaseC_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                        sQLiteDatabaseC_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZzb)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                zzbt.zza zzaVar3 = (zzbt.zza) it6.next();
                arrayList.add(zzaVar3.zza() ? Integer.valueOf(zzaVar3.zzb()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseC_.setTransactionSuccessful();
            sQLiteDatabaseC_.endTransaction();
        } catch (Throwable th) {
            sQLiteDatabaseC_.endTransaction();
            throw th;
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }
}
