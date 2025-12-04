package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class L7 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Logger b;

    @NotNull
    public final String c;

    public L7(@NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = preferencesStore;
        this.b = new Logger("UserId");
        this.c = "";
    }

    @NotNull
    public final String a() {
        String string;
        try {
            string = this.a.getString(PreferencesKey.USER_ID, this.c);
        } catch (JSONException e) {
            Q2.a(this.b, "Cannot parse the user id.", e);
        }
        JSONObject jSONObject = (string == null || string.length() == 0) ? null : new JSONObject(string);
        String strOptString = jSONObject != null ? jSONObject.optString("uid", this.c) : null;
        return strOptString == null ? this.c : strOptString;
    }
}
