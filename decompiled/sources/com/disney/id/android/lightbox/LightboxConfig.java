package com.disney.id.android.lightbox;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.Keep;
import com.disney.id.android.BiometricSupport;
import com.disney.id.android.Guest;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.OneID;
import com.disney.id.android.Profile;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import com.urbanairship.deferred.DeferredApiClient;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0001\u0018\u0000 I2\u00020\u0001:\u0001IB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010E\u001a\u00020\u000bH\u0002J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010G\u001a\u00020\u0006H\u0002J\u0010\u0010H\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001e\u0010!\u001a\u00020\"8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00103\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0019R\u0014\u00105\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000eR\u0014\u00107\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000eR\u001a\u00109\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001bR\u001a\u0010<\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u001c\u0010?\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010\u0010R\u001c\u0010B\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010\u0010¨\u0006J"}, d2 = {"Lcom/disney/id/android/lightbox/LightboxConfig;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", LightboxConfig.JWTENABLED_KEY, "", "getJWTEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "ageBand", "", "biometricAuthType", "getBiometricAuthType", "()Ljava/lang/String;", "setBiometricAuthType", "(Ljava/lang/String;)V", "biometricSupport", "Lcom/disney/id/android/BiometricSupport;", "getBiometricSupport$OneID_release", "()Lcom/disney/id/android/BiometricSupport;", "setBiometricSupport$OneID_release", "(Lcom/disney/id/android/BiometricSupport;)V", "biometricsEnabled", "getBiometricsEnabled", "()Z", "setBiometricsEnabled", "(Z)V", "biometricsOptOut", "getBiometricsOptOut", "setBiometricsOptOut", "debug", "getDebug", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "oneIdStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "getOneIdStorage$OneID_release", "()Lcom/disney/id/android/localdata/ExposedStorage;", "setOneIdStorage$OneID_release", "(Lcom/disney/id/android/localdata/ExposedStorage;)V", "openUrlAvailable", "getOpenUrlAvailable", DeferredApiClient.KEY_PLATFORM, "getPlatform", "sdkVersion", "getSdkVersion", "touchEnabled", "getTouchEnabled", "setTouchEnabled", "touchOptOut", "getTouchOptOut", "setTouchOptOut", OneID.UNID, "getUnid", "setUnid", OneID.UNID_REASON, "getUnidReason", "setUnidReason", "determineBiometricAuthType", "isBiometricEnabled", "isBiometricOptedOut", "isOpenUrlAvailable", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LightboxConfig {

    @NotNull
    private static final String BIO_AUTH_TYPE_FINGERPRINT = "fingerprint";

    @NotNull
    private static final String BIO_AUTH_TYPE_NONE = "none";

    @NotNull
    private static final String JWTENABLED_KEY = "JWTEnabled";

    @Nullable
    private final Boolean JWTEnabled;

    @Nullable
    private String ageBand;

    @Nullable
    private String biometricAuthType;

    @Inject
    public BiometricSupport biometricSupport;
    private boolean biometricsEnabled;
    private boolean biometricsOptOut;
    private final boolean debug;

    @Inject
    public GuestHandler guestHandler;

    @Inject
    public Logger logger;

    @Inject
    public ExposedStorage oneIdStorage;
    private final boolean openUrlAvailable;

    @NotNull
    private final String platform;

    @NotNull
    private final String sdkVersion;
    private boolean touchEnabled;
    private boolean touchOptOut;

    @Nullable
    private String unid;

    @Nullable
    private String unidReason;

    public LightboxConfig(@NotNull Context context) {
        Profile profile;
        Intrinsics.checkNotNullParameter(context, "context");
        this.platform = "android";
        this.sdkVersion = "4.12.5";
        OneIDDagger.getComponent().inject(this);
        this.debug = getLogger$OneID_release().getLogLevel() == OneID.LogLevel.DEBUG;
        this.touchEnabled = isBiometricEnabled(context);
        this.touchOptOut = isBiometricOptedOut();
        this.biometricsEnabled = isBiometricEnabled(context);
        this.biometricsOptOut = isBiometricOptedOut();
        this.biometricAuthType = determineBiometricAuthType();
        this.openUrlAvailable = isOpenUrlAvailable(context);
        Guest guest = getGuestHandler$OneID_release().get();
        this.ageBand = (guest == null || (profile = guest.getProfile()) == null) ? null : profile.getAgeBand();
        this.JWTEnabled = getOneIdStorage$OneID_release().getOptionalBoolean(JWTENABLED_KEY, null);
        this.unid = "UNID Deprecated";
        this.unidReason = "UNID Deprecated";
    }

    @NotNull
    public final ExposedStorage getOneIdStorage$OneID_release() {
        ExposedStorage exposedStorage = this.oneIdStorage;
        if (exposedStorage != null) {
            return exposedStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIdStorage");
        return null;
    }

    public final void setOneIdStorage$OneID_release(@NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(exposedStorage, "<set-?>");
        this.oneIdStorage = exposedStorage;
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
    public final BiometricSupport getBiometricSupport$OneID_release() {
        BiometricSupport biometricSupport = this.biometricSupport;
        if (biometricSupport != null) {
            return biometricSupport;
        }
        Intrinsics.throwUninitializedPropertyAccessException("biometricSupport");
        return null;
    }

    public final void setBiometricSupport$OneID_release(@NotNull BiometricSupport biometricSupport) {
        Intrinsics.checkNotNullParameter(biometricSupport, "<set-?>");
        this.biometricSupport = biometricSupport;
    }

    @Nullable
    public final String getBiometricAuthType() {
        return this.biometricAuthType;
    }

    public final void setBiometricAuthType(@Nullable String str) {
        this.biometricAuthType = str;
    }

    public final boolean getTouchOptOut() {
        return this.touchOptOut;
    }

    public final void setTouchOptOut(boolean z) {
        this.touchOptOut = z;
    }

    public final boolean getBiometricsOptOut() {
        return this.biometricsOptOut;
    }

    public final void setBiometricsOptOut(boolean z) {
        this.biometricsOptOut = z;
    }

    public final boolean getTouchEnabled() {
        return this.touchEnabled;
    }

    public final void setTouchEnabled(boolean z) {
        this.touchEnabled = z;
    }

    public final boolean getBiometricsEnabled() {
        return this.biometricsEnabled;
    }

    public final void setBiometricsEnabled(boolean z) {
        this.biometricsEnabled = z;
    }

    @NotNull
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final boolean getOpenUrlAvailable() {
        return this.openUrlAvailable;
    }

    @Nullable
    public final String getUnid() {
        return this.unid;
    }

    public final void setUnid(@Nullable String str) {
        this.unid = str;
    }

    @Nullable
    public final String getUnidReason() {
        return this.unidReason;
    }

    public final void setUnidReason(@Nullable String str) {
        this.unidReason = str;
    }

    @Nullable
    public final Boolean getJWTEnabled() {
        return this.JWTEnabled;
    }

    private final boolean isOpenUrlAvailable(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://127.0.0.1"));
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities.size() > 0;
    }

    private final boolean isBiometricEnabled(Context context) {
        return BiometricSupport.DefaultImpls.isBiometricEnabled$default(getBiometricSupport$OneID_release(), context, null, 2, null);
    }

    private final boolean isBiometricOptedOut() {
        return getBiometricSupport$OneID_release().isOptedOut();
    }

    private final String determineBiometricAuthType() {
        return this.biometricsEnabled ? BIO_AUTH_TYPE_FINGERPRINT : "none";
    }
}
