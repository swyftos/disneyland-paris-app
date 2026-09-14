package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.L7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2554L7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1837a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f1838b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final String f1839c;

    public C2554L7(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f1837a = preferencesStore;
        this.f1838b = new Logger("UserId");
        this.f1839c = "";
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final String m979a() {
        JSONObject jSONObject;
        try {
            String string = this.f1837a.getString(PreferencesKey.USER_ID, this.f1839c);
            jSONObject = (string == null || string.length() == 0) ? null : new JSONObject(string);
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1838b, "Cannot parse the user id.", e);
        }
        String strOptString = jSONObject != null ? jSONObject.optString("uid", this.f1839c) : null;
        return strOptString == null ? this.f1839c : strOptString;
    }
}
