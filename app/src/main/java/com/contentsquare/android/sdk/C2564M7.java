package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.M7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2564M7 implements PreferencesStore.PreferencesStoreListener {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1872a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2544K7 f1873b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public String f1874c;

    public C2564M7(@NotNull PreferencesStore preferencesStore, @NotNull C2544K7 userConfigurationHelper) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(userConfigurationHelper, "userConfigurationHelper");
        this.f1872a = preferencesStore;
        this.f1873b = userConfigurationHelper;
        preferencesStore.registerOnChangedListener(this);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final String m987a() {
        if (this.f1874c == null) {
            String userId = this.f1873b.m966a();
            if (userId == null || userId.length() == 0) {
                userId = UUID.randomUUID().toString();
                C2544K7 c2544k7 = this.f1873b;
                c2544k7.getClass();
                Intrinsics.checkNotNullParameter(userId, "userId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uid", userId);
                jSONObject.put("timestamp", System.currentTimeMillis());
                try {
                    c2544k7.f1795a.putString(PreferencesKey.USER_ID, jSONObject.toString());
                    c2544k7.f1796b.m827d("Saving USER ID config to sharedPrefs.");
                } catch (JSONException e) {
                    C2599Q2.m1011a(c2544k7.f1796b, "Failed to serialize and store the USER ID config.", e);
                }
            }
            this.f1874c = userId;
        }
        if (this.f1872a.getBoolean(PreferencesKey.IS_OPT_OUT, false)) {
            return null;
        }
        return this.f1874c;
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreferencesKey preferencesKey = PreferencesKey.USER_ID;
        if (key != preferencesKey || this.f1872a.contains(preferencesKey)) {
            return;
        }
        this.f1874c = null;
    }
}
