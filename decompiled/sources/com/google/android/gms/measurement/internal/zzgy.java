package com.google.android.gms.measurement.internal;

import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;

/* loaded from: classes4.dex */
public class zzgy {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", TCEventPropertiesNames.TCL_SESSION_NUMBER, TCEventPropertiesNames.TCL_SESSION_ID};
    public static final String[] zzb = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    protected zzgy() {
    }

    public static String zza(String str) {
        return zzig.zza(str, zza, zzb);
    }
}
