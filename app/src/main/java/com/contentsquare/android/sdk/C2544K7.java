package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.K7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2544K7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1795a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f1796b;

    public C2544K7(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f1795a = preferencesStore;
        this.f1796b = new Logger("UserConfigurationHelper");
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final String m966a() {
        this.f1796b.m834w("retrieving last USER ID config from preferences");
        PreferencesStore preferencesStore = this.f1795a;
        PreferencesKey preferencesKey = PreferencesKey.USER_ID;
        String str = null;
        String string = preferencesStore.getString(preferencesKey, null);
        if (string == null || string.length() == 0) {
            this.f1796b.m834w("last USER ID config is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (System.currentTimeMillis() - jSONObject.getLong("timestamp") > 33696000000L) {
                this.f1796b.m834w("last USER ID is outdated, returning null");
                this.f1795a.remove(preferencesKey, PreferencesKey.SESSION_ID, PreferencesKey.SCREEN_NUMBER, PreferencesKey.LAST_SEGMENT, PreferencesKey.IS_TRACKABLE);
            } else {
                String string2 = jSONObject.getString("uid");
                this.f1796b.m834w("last USER ID is valid, returning USER ID from preferences " + string2);
                str = string2;
            }
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1796b, "failed to deserialize last USER ID config with an exception", e);
        }
        return str;
    }
}
