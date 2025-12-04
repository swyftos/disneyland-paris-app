package com.disney.id.android.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.appdynamics.eumagent.runtime.networkrequests.OkHttp3;
import com.disney.id.android.Guest;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.OneIDRecoveryContext;
import com.disney.id.android.RecoveryContext;
import com.disney.id.android.Token;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/disney/id/android/services/AuthorizationInterceptor;", "Lokhttp3/Interceptor;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAppContext", "()Landroid/content/Context;", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", OneIDRecoveryContext.RECOVERY_CONTEXT, "Lcom/disney/id/android/RecoveryContext;", "getRecoveryContext$OneID_release", "()Lcom/disney/id/android/RecoveryContext;", "setRecoveryContext$OneID_release", "(Lcom/disney/id/android/RecoveryContext;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthorizationInterceptor implements Interceptor {
    private static final String TAG = AuthorizationInterceptor.class.getSimpleName();
    private final Context appContext;

    @Inject
    public GuestHandler guestHandler;

    @Inject
    public Logger logger;

    @Inject
    public RecoveryContext recoveryContext;

    public AuthorizationInterceptor(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final Context getAppContext() {
        return this.appContext;
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final GuestHandler getGuestHandler$OneID_release() {
        GuestHandler guestHandler = this.guestHandler;
        if (guestHandler != null) {
            return guestHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guestHandler");
        return null;
    }

    public final void setGuestHandler$OneID_release(@NotNull GuestHandler guestHandler) {
        Intrinsics.checkNotNullParameter(guestHandler, "<set-?>");
        this.guestHandler = guestHandler;
    }

    @NotNull
    public final RecoveryContext getRecoveryContext$OneID_release() {
        RecoveryContext recoveryContext = this.recoveryContext;
        if (recoveryContext != null) {
            return recoveryContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException(OneIDRecoveryContext.RECOVERY_CONTEXT);
        return null;
    }

    public final void setRecoveryContext$OneID_release(@NotNull RecoveryContext recoveryContext) {
        Intrinsics.checkNotNullParameter(recoveryContext, "<set-?>");
        this.recoveryContext = recoveryContext;
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String accessToken;
        Token token$OneID_release;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(chain, "chain");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.appContext);
        Request request = chain.request();
        Intrinsics.checkNotNullExpressionValue(request, "request(...)");
        String str = null;
        if (StringsKt.equals$default(request.headers().get("Authorization"), "replaceWithApiKey", false, 2, null)) {
            String string = defaultSharedPreferences.getString("api-key", null);
            if (string != null) {
                str = "APIKEY " + string;
            }
        } else if (StringsKt.equals$default(request.headers().get("Authorization"), "replaceWithRecoveryToken", false, 2, null)) {
            String accessToken2 = getRecoveryContext$OneID_release().getAccessToken();
            if (accessToken2 != null) {
                str = "BEARER " + accessToken2;
            }
        } else {
            JsonElement transientToken = getGuestHandler$OneID_release().getTransientToken();
            if (transientToken == null || (asJsonObject = transientToken.getAsJsonObject()) == null || (jsonElement = asJsonObject.get(Token.ACCESS_TOKEN)) == null || (accessToken = jsonElement.getAsString()) == null) {
                Guest guest = getGuestHandler$OneID_release().get();
                accessToken = (guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) ? null : token$OneID_release.getAccessToken();
            }
            if (accessToken != null) {
                str = "BEARER " + accessToken;
            } else {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                Logger.DefaultImpls.wtf$default(logger$OneID_release, TAG2, "Attempting to use access token for GC call but no logged in guest.  Should this call use API key?", null, 4, null);
            }
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        builderNewBuilder.removeHeader("Authorization");
        if (str != null) {
            builderNewBuilder.header("Authorization", str);
        }
        OkHttp3.Request.Builder.build.Enter(builderNewBuilder);
        Request requestBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(requestBuild, "with(...)");
        Response responseProceed = chain.proceed(requestBuild);
        String str2 = responseProceed.headers().get("api-key");
        if (str2 != null) {
            defaultSharedPreferences.edit().putString("api-key", str2).apply();
        }
        Intrinsics.checkNotNull(responseProceed);
        return responseProceed;
    }
}
