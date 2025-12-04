package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class K7 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Logger b;

    public K7(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = preferencesStore;
        this.b = new Logger("UserConfigurationHelper");
    }

    @Nullable
    public final String a() throws JSONException {
        this.b.w("retrieving last USER ID config from preferences");
        PreferencesStore preferencesStore = this.a;
        PreferencesKey preferencesKey = PreferencesKey.USER_ID;
        String str = null;
        String string = preferencesStore.getString(preferencesKey, null);
        if (string == null || string.length() == 0) {
            this.b.w("last USER ID config is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (System.currentTimeMillis() - jSONObject.getLong("timestamp") > 33696000000L) {
                this.b.w("last USER ID is outdated, returning null");
                this.a.remove(preferencesKey, PreferencesKey.SESSION_ID, PreferencesKey.SCREEN_NUMBER, PreferencesKey.LAST_SEGMENT, PreferencesKey.IS_TRACKABLE);
            } else {
                String string2 = jSONObject.getString("uid");
                this.b.w("last USER ID is valid, returning USER ID from preferences " + string2);
                str = string2;
            }
        } catch (JSONException e) {
            Q2.a(this.b, "failed to deserialize last USER ID config with an exception", e);
        }
        return str;
    }
}
