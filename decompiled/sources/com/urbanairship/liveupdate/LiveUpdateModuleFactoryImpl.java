package com.urbanairship.liveupdate;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.modules.Module;
import com.urbanairship.modules.liveupdate.LiveUpdateModuleFactory;
import com.urbanairship.push.PushManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateModuleFactoryImpl;", "Lcom/urbanairship/modules/liveupdate/LiveUpdateModuleFactory;", "()V", "airshipVersion", "", "getAirshipVersion", "()Ljava/lang/String;", "packageVersion", "getPackageVersion", "build", "Lcom/urbanairship/modules/Module;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "airshipChannel", "Lcom/urbanairship/channel/AirshipChannel;", "pushManager", "Lcom/urbanairship/push/PushManager;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class LiveUpdateModuleFactoryImpl implements LiveUpdateModuleFactory {
    private final String airshipVersion = "19.9.1";
    private final String packageVersion = com.urbanairship.BuildConfig.SDK_VERSION;

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getAirshipVersion() {
        return this.airshipVersion;
    }

    @Override // com.urbanairship.AirshipVersionInfo
    @NotNull
    public String getPackageVersion() {
        return this.packageVersion;
    }

    @Override // com.urbanairship.modules.liveupdate.LiveUpdateModuleFactory
    @NotNull
    public Module build(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel airshipChannel, @NotNull PushManager pushManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Module moduleSingleComponent = Module.singleComponent(new LiveUpdateManager(context, dataStore, config, privacyManager, airshipChannel, pushManager), 0);
        Intrinsics.checkNotNullExpressionValue(moduleSingleComponent, "singleComponent(...)");
        return moduleSingleComponent;
    }
}
