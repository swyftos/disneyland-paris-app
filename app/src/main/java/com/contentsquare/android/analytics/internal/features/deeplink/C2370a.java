package com.contentsquare.android.analytics.internal.features.deeplink;

import android.content.Context;
import android.net.Uri;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.sdk.C2931y0;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.deeplink.a */
/* JADX INFO: loaded from: classes2.dex */
public final class C2370a {

    /* JADX INFO: renamed from: e */
    @NotNull
    public static final Logger f1198e = new Logger(null, 1, null);

    /* JADX INFO: renamed from: a */
    @NotNull
    public final a f1199a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Configuration f1200b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2931y0 f1201c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Context f1202d;

    /* JADX INFO: renamed from: com.contentsquare.android.analytics.internal.features.deeplink.a$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo792a();
    }

    public C2370a(@NotNull Context context, @NotNull a events, @NotNull Configuration configuration, @NotNull C2931y0 configureFromDeepLink) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(configureFromDeepLink, "configureFromDeepLink");
        this.f1199a = events;
        this.f1200b = configuration;
        this.f1201c = configureFromDeepLink;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.f1202d = applicationContext;
    }

    /* JADX INFO: renamed from: a */
    public final void m793a(@NotNull Uri data) {
        JsonConfig.ProjectConfiguration projectConfig;
        JsonConfig.InAppConfig inAppConfig;
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual("cs-" + this.f1202d.getPackageName(), data.getScheme())) {
            String queryParameter = data.getQueryParameter("activationKey");
            String userId = data.getQueryParameter("userId");
            String configEntries = data.getQueryParameter("configure");
            if (queryParameter == null || userId == null) {
                return;
            }
            C2931y0 c2931y0 = this.f1201c;
            c2931y0.getClass();
            Intrinsics.checkNotNullParameter(userId, "userId");
            c2931y0.f3257a.putString(PreferencesKey.INAPP_USER_ID, userId);
            if (configEntries == null) {
                if (queryParameter.length() <= 0 || userId.length() <= 0 || (projectConfig = this.f1200b.getProjectConfig()) == null || (inAppConfig = projectConfig.getInAppConfig()) == null) {
                    return;
                }
                String activationKey = inAppConfig.getActivationKey();
                if (activationKey.length() <= 0 || !Intrinsics.areEqual(activationKey, queryParameter)) {
                    return;
                }
                if (inAppConfig.getEnabled()) {
                    this.f1199a.mo792a();
                    return;
                } else {
                    f1198e.m831i("Contentsquare in-app features is disabled in the project configuration");
                    return;
                }
            }
            if (Intrinsics.areEqual(queryParameter, "weballwin") && Intrinsics.areEqual(userId, "iamjenkins")) {
                C2931y0 c2931y1 = this.f1201c;
                c2931y1.getClass();
                Intrinsics.checkNotNullParameter(configEntries, "configEntries");
                c2931y1.f3258b.m831i("Configuration in progress...");
                for (String str : StringsKt.split$default((CharSequence) configEntries, new String[]{","}, false, 0, 6, (Object) null)) {
                    List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null);
                    Pair pair = null;
                    if (listSplit$default.size() != 2) {
                        c2931y1.f3258b.m829e("Skipping invalid entry: " + str);
                    } else {
                        String str2 = (String) listSplit$default.get(0);
                        try {
                            pair = new Pair(PreferencesKey.valueOf(str2), (String) listSplit$default.get(1));
                        } catch (IllegalArgumentException e) {
                            c2931y1.f3258b.m830e(e, "Skipping invalid key = " + str2 + " in " + str);
                        }
                    }
                    if (pair != null) {
                        PreferencesKey preferencesKey = (PreferencesKey) pair.component1();
                        String str3 = (String) pair.component2();
                        c2931y1.f3258b.m831i("Applying: key = " + preferencesKey + ", value = " + str3);
                        if (StringsKt.toBooleanStrictOrNull(str3) != null) {
                            c2931y1.f3257a.putBoolean(preferencesKey, Boolean.parseBoolean(str3));
                        } else if (StringsKt.toIntOrNull(str3) != null) {
                            c2931y1.f3257a.putInt(preferencesKey, Integer.parseInt(str3));
                        } else {
                            c2931y1.f3257a.putString(preferencesKey, str3);
                        }
                    }
                }
                c2931y1.f3258b.m831i("Configuration is done.");
            }
        }
    }
}
