package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class M7 implements PreferencesStore.PreferencesStoreListener {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final K7 b;

    @Nullable
    public String c;

    public M7(@NotNull PreferencesStore preferencesStore, @NotNull K7 userConfigurationHelper) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(userConfigurationHelper, "userConfigurationHelper");
        this.a = preferencesStore;
        this.b = userConfigurationHelper;
        preferencesStore.registerOnChangedListener(this);
    }

    @Nullable
    public final String a() {
        if (this.c == null) {
            String userId = this.b.a();
            if (userId == null || userId.length() == 0) {
                userId = UUID.randomUUID().toString();
                K7 k7 = this.b;
                k7.getClass();
                Intrinsics.checkNotNullParameter(userId, "userId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uid", userId);
                jSONObject.put("timestamp", System.currentTimeMillis());
                try {
                    k7.a.putString(PreferencesKey.USER_ID, jSONObject.toString());
                    k7.b.d("Saving USER ID config to sharedPrefs.");
                } catch (JSONException e) {
                    Q2.a(k7.b, "Failed to serialize and store the USER ID config.", e);
                }
            }
            this.c = userId;
        }
        if (this.a.getBoolean(PreferencesKey.IS_OPT_OUT, false)) {
            return null;
        }
        return this.c;
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreferencesKey preferencesKey = PreferencesKey.USER_ID;
        if (key != preferencesKey || this.a.contains(preferencesKey)) {
            return;
        }
        this.c = null;
    }
}
