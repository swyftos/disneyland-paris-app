package com.urbanairship;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final class PreferenceDataStore {
    private static final String[] OBSOLETE_KEYS = {"com.urbanairship.TAG_GROUP_HISTORIAN_RECORDS", "com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE", "com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED", "com.urbanairship.push.iam.LAST_DISPLAYED_ID", "com.urbanairship.nameduser.CHANGE_TOKEN_KEY", "com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY", "com.urbanairship.iam.tags.TAG_PREFER_LOCAL_DATA_TIME", "com.urbanairship.chat.CHAT", "com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME", "com.urbanairship.push.LAST_REGISTRATION_TIME", "com.urbanairship.push.LAST_REGISTRATION_PAYLOAD", "com.urbanairship.remotedata.LAST_REFRESH_APP_VERSION", "com.urbanairship.remotedata.LAST_MODIFIED", "com.urbanairship.remotedata.LAST_REFRESH_TIME", "com.urbanairship.iam.data.last_payload_info", "com.urbanairship.iam.data.LAST_PAYLOAD_METADATA", "com.urbanairship.iam.data.contact_last_payload_info"};
    private final PreferenceDataDao dao;
    private final PreferenceDataDatabase db;
    Executor executor = AirshipExecutors.newSerialExecutor();
    private final Map preferences = new HashMap();
    private final List listeners = new ArrayList();

    public interface PreferenceChangeListener {
        void onPreferenceChange(@NonNull String str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static PreferenceDataStore loadDataStore(@NonNull Context context, @NonNull AirshipConfigOptions airshipConfigOptions) {
        PreferenceDataDatabase preferenceDataDatabaseCreateDatabase = PreferenceDataDatabase.createDatabase(context, airshipConfigOptions);
        PreferenceDataStore preferenceDataStore = new PreferenceDataStore(preferenceDataDatabaseCreateDatabase);
        if (preferenceDataDatabaseCreateDatabase.exists(context)) {
            preferenceDataStore.loadPreferences();
        }
        return preferenceDataStore;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public static PreferenceDataStore inMemoryStore(@NonNull Context context) {
        return new PreferenceDataStore(PreferenceDataDatabase.createInMemoryDatabase(context));
    }

    PreferenceDataStore(PreferenceDataDatabase preferenceDataDatabase) {
        this.db = preferenceDataDatabase;
        this.dao = preferenceDataDatabase.getDao();
    }

    public void addListener(@NonNull PreferenceChangeListener preferenceChangeListener) {
        synchronized (this.listeners) {
            this.listeners.add(preferenceChangeListener);
        }
    }

    public void removeListener(@NonNull PreferenceChangeListener preferenceChangeListener) {
        synchronized (this.listeners) {
            this.listeners.remove(preferenceChangeListener);
        }
    }

    private void loadPreferences() {
        try {
            List<PreferenceData> preferences = this.dao.getPreferences();
            ArrayList arrayList = new ArrayList();
            for (PreferenceData preferenceData : preferences) {
                arrayList.add(new Preference(preferenceData.getKey(), preferenceData.getValue()));
            }
            finishLoad(arrayList);
        } catch (Exception e) {
            UALog.e(e, "Failed to load preferences. Retrying with fallback loading.", new Object[0]);
            fallbackLoad();
        }
    }

    private void fallbackLoad() {
        List<String> listQueryKeys;
        try {
            listQueryKeys = this.dao.queryKeys();
        } catch (Exception e) {
            UALog.e(e, "Failed to load keys.", new Object[0]);
            listQueryKeys = null;
        }
        if (listQueryKeys == null || listQueryKeys.isEmpty()) {
            UALog.e("Unable to load keys, deleting preference store.", new Object[0]);
            try {
                this.dao.deleteAll();
                return;
            } catch (Exception e2) {
                UALog.e(e2, "Failed to delete preferences.", new Object[0]);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str : listQueryKeys) {
            try {
                PreferenceData preferenceDataQueryValue = this.dao.queryValue(str);
                if (preferenceDataQueryValue.value == null) {
                    UALog.e("Unable to fetch preference value. Deleting: %s", str);
                    this.dao.delete(str);
                } else {
                    arrayList.add(new Preference(preferenceDataQueryValue.getKey(), preferenceDataQueryValue.getValue()));
                }
            } catch (Exception e3) {
                UALog.e(e3, "Failed to delete preference %s", str);
            }
        }
        finishLoad(arrayList);
    }

    private void finishLoad(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Preference preference = (Preference) it.next();
            this.preferences.put(preference.key, preference);
        }
        for (String str : OBSOLETE_KEYS) {
            remove(str);
        }
    }

    public void tearDown() {
        this.listeners.clear();
        this.db.close();
    }

    public boolean isSet(@NonNull String str) {
        return getPreference(str).get() != null;
    }

    public boolean getBoolean(@NonNull String str, boolean z) {
        String str2 = getPreference(str).get();
        return str2 == null ? z : Boolean.parseBoolean(str2);
    }

    @Nullable
    public String getString(@NonNull String str, @Nullable String str2) {
        String str3 = getPreference(str).get();
        return str3 == null ? str2 : str3;
    }

    public long getLong(@NonNull String str, long j) {
        String str2 = getPreference(str).get();
        if (str2 == null) {
            return j;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public int getInt(@NonNull String str, int i) {
        String str2 = getPreference(str).get();
        if (str2 == null) {
            return i;
        }
        try {
            return Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    @NonNull
    public JsonValue getJsonValue(@NonNull String str) {
        try {
            return JsonValue.parseString(getPreference(str).get());
        } catch (JsonException e) {
            UALog.d(e, "Unable to parse preference value: %s", str);
            return JsonValue.NULL;
        }
    }

    @Nullable
    public JsonValue optJsonValue(@NonNull String str) {
        try {
            return JsonValue.parseString(getPreference(str).get());
        } catch (JsonException e) {
            UALog.d(e, "Unable to parse preference value: %s", str);
            return null;
        }
    }

    public void remove(@NonNull String str) {
        Preference preference;
        synchronized (this.preferences) {
            try {
                preference = this.preferences.containsKey(str) ? (Preference) this.preferences.get(str) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (preference != null) {
            preference.put(null);
        }
    }

    public void put(@NonNull String str, @Nullable String str2) {
        if (str2 == null) {
            remove(str);
        } else {
            getPreference(str).put(str2);
        }
    }

    public void put(@NonNull String str, long j) {
        getPreference(str).put(String.valueOf(j));
    }

    public void put(@NonNull String str, int i) {
        getPreference(str).put(String.valueOf(i));
    }

    public void put(@NonNull String str, boolean z) {
        getPreference(str).put(String.valueOf(z));
    }

    public void put(@NonNull String str, @Nullable JsonValue jsonValue) {
        if (jsonValue == null) {
            remove(str);
        } else {
            getPreference(str).put(jsonValue.toString());
        }
    }

    public void put(@NonNull String str, @Nullable JsonSerializable jsonSerializable) {
        if (jsonSerializable == null) {
            remove(str);
        } else {
            put(str, jsonSerializable.getJsonValue());
        }
    }

    public boolean putSync(@NonNull String str, @Nullable String str2) {
        return getPreference(str).putSync(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreferenceChanged(String str) {
        synchronized (this.listeners) {
            try {
                Iterator it = this.listeners.iterator();
                while (it.hasNext()) {
                    ((PreferenceChangeListener) it.next()).onPreferenceChange(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Preference getPreference(String str) {
        Preference preference;
        synchronized (this.preferences) {
            try {
                preference = (Preference) this.preferences.get(str);
                if (preference == null) {
                    preference = new Preference(str, null);
                    this.preferences.put(str, preference);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return preference;
    }

    private class Preference {
        private final String key;
        private String value;

        Preference(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        String get() {
            String str;
            synchronized (this) {
                str = this.value;
            }
            return str;
        }

        void put(final String str) {
            if (setValue(str)) {
                PreferenceDataStore.this.executor.execute(new Runnable() { // from class: com.urbanairship.PreferenceDataStore.Preference.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Preference.this.writeValue(str);
                    }
                });
            }
        }

        boolean putSync(String str) {
            synchronized (this) {
                try {
                    if (!writeValue(str)) {
                        return false;
                    }
                    setValue(str);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private boolean setValue(String str) {
            synchronized (this) {
                try {
                    if (UAStringUtil.equals(str, this.value)) {
                        return false;
                    }
                    this.value = str;
                    UALog.v("Preference updated: %s", this.key);
                    PreferenceDataStore.this.onPreferenceChanged(this.key);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean writeValue(String str) {
            synchronized (this) {
                try {
                    try {
                        if (str == null) {
                            UALog.v("Removing preference: %s", this.key);
                            PreferenceDataStore.this.dao.delete(this.key);
                        } else {
                            UALog.v("Saving preference: %s value: %s", this.key, str);
                            PreferenceDataStore.this.dao.upsert(new PreferenceData(this.key, str));
                        }
                    } catch (Exception e) {
                        UALog.e(e, "Failed to write preference %s:%s", this.key, str);
                        return false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
    }
}
