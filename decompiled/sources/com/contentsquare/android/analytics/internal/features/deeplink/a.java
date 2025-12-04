package com.contentsquare.android.analytics.internal.features.deeplink;

import android.content.Context;
import android.net.Uri;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.sdk.C0857y0;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class a {

    @NotNull
    public static final Logger e = new Logger(null, 1, null);

    @NotNull
    public final InterfaceC0039a a;

    @NotNull
    public final Configuration b;

    @NotNull
    public final C0857y0 c;

    @NotNull
    public final Context d;

    /* renamed from: com.contentsquare.android.analytics.internal.features.deeplink.a$a, reason: collision with other inner class name */
    public interface InterfaceC0039a {
        void a();
    }

    public a(@NotNull Context context, @NotNull InterfaceC0039a events, @NotNull Configuration configuration, @NotNull C0857y0 configureFromDeepLink) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(events, "events");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(configureFromDeepLink, "configureFromDeepLink");
        this.a = events;
        this.b = configuration;
        this.c = configureFromDeepLink;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.d = applicationContext;
    }

    public final void a(@NotNull Uri data) {
        JsonConfig.ProjectConfiguration projectConfig;
        JsonConfig.InAppConfig inAppConfig;
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual("cs-" + this.d.getPackageName(), data.getScheme())) {
            String queryParameter = data.getQueryParameter("activationKey");
            String userId = data.getQueryParameter("userId");
            String configEntries = data.getQueryParameter("configure");
            if (queryParameter == null || userId == null) {
                return;
            }
            C0857y0 c0857y0 = this.c;
            c0857y0.getClass();
            Intrinsics.checkNotNullParameter(userId, "userId");
            c0857y0.a.putString(PreferencesKey.INAPP_USER_ID, userId);
            if (configEntries == null) {
                if (queryParameter.length() <= 0 || userId.length() <= 0 || (projectConfig = this.b.getProjectConfig()) == null || (inAppConfig = projectConfig.getInAppConfig()) == null) {
                    return;
                }
                String activationKey = inAppConfig.getActivationKey();
                if (activationKey.length() <= 0 || !Intrinsics.areEqual(activationKey, queryParameter)) {
                    return;
                }
                if (inAppConfig.getEnabled()) {
                    this.a.a();
                    return;
                } else {
                    e.i("Contentsquare in-app features is disabled in the project configuration");
                    return;
                }
            }
            if (Intrinsics.areEqual(queryParameter, "weballwin") && Intrinsics.areEqual(userId, "iamjenkins")) {
                C0857y0 c0857y02 = this.c;
                c0857y02.getClass();
                Intrinsics.checkNotNullParameter(configEntries, "configEntries");
                c0857y02.b.i("Configuration in progress...");
                for (String str : StringsKt.split$default((CharSequence) configEntries, new String[]{","}, false, 0, 6, (Object) null)) {
                    List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"="}, false, 0, 6, (Object) null);
                    Pair pair = null;
                    if (listSplit$default.size() != 2) {
                        c0857y02.b.e("Skipping invalid entry: " + str);
                    } else {
                        String str2 = (String) listSplit$default.get(0);
                        try {
                            pair = new Pair(PreferencesKey.valueOf(str2), (String) listSplit$default.get(1));
                        } catch (IllegalArgumentException e2) {
                            c0857y02.b.e(e2, "Skipping invalid key = " + str2 + " in " + str);
                        }
                    }
                    if (pair != null) {
                        PreferencesKey preferencesKey = (PreferencesKey) pair.component1();
                        String str3 = (String) pair.component2();
                        c0857y02.b.i("Applying: key = " + preferencesKey + ", value = " + str3);
                        if (StringsKt.toBooleanStrictOrNull(str3) != null) {
                            c0857y02.a.putBoolean(preferencesKey, Boolean.parseBoolean(str3));
                        } else if (StringsKt.toIntOrNull(str3) != null) {
                            c0857y02.a.putInt(preferencesKey, Integer.parseInt(str3));
                        } else {
                            c0857y02.a.putString(preferencesKey, str3);
                        }
                    }
                }
                c0857y02.b.i("Configuration is done.");
            }
        }
    }
}
