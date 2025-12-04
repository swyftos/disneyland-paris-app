package com.urbanairship.android.framework.proxy;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.PreferenceCenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 N2\u00020\u0001:\u0001NB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0011¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R#\u0010*\u001a\n %*\u0004\u0018\u00010$0$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R(\u0010;\u001a\u0004\u0018\u00010+2\b\u0010\u0014\u001a\u0004\u0018\u00010+8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010A\u001a\u0004\u0018\u00010<2\b\u0010\u0014\u001a\u0004\u0018\u00010<8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R(\u0010H\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010B8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010J\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R$\u0010L\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u00101\"\u0004\bM\u00103¨\u0006O"}, d2 = {"Lcom/urbanairship/android/framework/proxy/ProxyStore;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "Lkotlin/Function1;", "Lcom/urbanairship/json/JsonValue;", "parser", "getJson", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "defaultValue", "getString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "getBoolean", "(Ljava/lang/String;Z)Z", "value", "", "setBoolean", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "Lcom/urbanairship/json/JsonSerializable;", "setJson", "(Ljava/lang/String;Lcom/urbanairship/json/JsonSerializable;)V", "preferenceId", "getAutoLaunchPreferenceCenterKey", "(Ljava/lang/String;)Ljava/lang/String;", "isAutoLaunchPreferenceCenterEnabled", "(Ljava/lang/String;)Z", "autoLaunch", "setAutoLaunchPreferenceCenter", "(Ljava/lang/String;Z)V", "Landroid/content/Context;", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "preferences$delegate", "Lkotlin/Lazy;", "getPreferences", "()Landroid/content/SharedPreferences;", PreferenceCenter.DEEP_LINK_HOST, "Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "_notificationConfig", "Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "defaultAutoLaunchMessageCenter", "Z", "getDefaultAutoLaunchMessageCenter", "()Z", "setDefaultAutoLaunchMessageCenter", "(Z)V", "defaultForegroundNotificationsEnabled", "getDefaultForegroundNotificationsEnabled", "setDefaultForegroundNotificationsEnabled", "getNotificationConfig", "()Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "setNotificationConfig", "(Lcom/urbanairship/android/framework/proxy/NotificationConfig;)V", "notificationConfig", "Lcom/urbanairship/android/framework/proxy/ProxyConfig;", "getAirshipConfig", "()Lcom/urbanairship/android/framework/proxy/ProxyConfig;", "setAirshipConfig", "(Lcom/urbanairship/android/framework/proxy/ProxyConfig;)V", "airshipConfig", "Lcom/urbanairship/android/framework/proxy/NotificationStatus;", "status", "getLastNotificationStatus", "()Lcom/urbanairship/android/framework/proxy/NotificationStatus;", "setLastNotificationStatus", "(Lcom/urbanairship/android/framework/proxy/NotificationStatus;)V", "lastNotificationStatus", "enabled", "isAutoLaunchMessageCenterEnabled", "setAutoLaunchMessageCenterEnabled", "isForegroundNotificationsEnabled", "setForegroundNotificationsEnabled", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProxyStore {
    private static volatile ProxyStore sharedInstance;
    private NotificationConfig _notificationConfig;
    private final Context context;
    private boolean defaultAutoLaunchMessageCenter;
    private boolean defaultForegroundNotificationsEnabled;

    /* renamed from: preferences$delegate, reason: from kotlin metadata */
    private final Lazy preferences;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Object sharedInstanceLock = new Object();

    public ProxyStore(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.preferences = LazyKt.lazy(new Function0() { // from class: com.urbanairship.android.framework.proxy.ProxyStore$preferences$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return this.this$0.context.getSharedPreferences("com.urbanairship.android.framework.proxy", 0);
            }
        });
        this.defaultAutoLaunchMessageCenter = true;
        this.defaultForegroundNotificationsEnabled = true;
    }

    private final SharedPreferences getPreferences() {
        return (SharedPreferences) this.preferences.getValue();
    }

    @Nullable
    public final NotificationConfig getNotificationConfig() {
        NotificationConfig notificationConfig = this._notificationConfig;
        if (notificationConfig != null) {
            return notificationConfig;
        }
        NotificationConfig notificationConfig2 = (NotificationConfig) getJson("NOTIFICATION_CONFIG", new Function1() { // from class: com.urbanairship.android.framework.proxy.ProxyStore$notificationConfig$fromStore$1
            @Override // kotlin.jvm.functions.Function1
            public final NotificationConfig invoke(JsonValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                JsonMap jsonMapOptMap = it.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                return new NotificationConfig(jsonMapOptMap);
            }
        });
        this._notificationConfig = notificationConfig2;
        return notificationConfig2;
    }

    public final void setNotificationConfig(@Nullable NotificationConfig notificationConfig) {
        setJson("NOTIFICATION_CONFIG", notificationConfig);
    }

    @Nullable
    public final ProxyConfig getAirshipConfig() {
        return (ProxyConfig) getJson("AIRSHIP_CONFIG", new Function1() { // from class: com.urbanairship.android.framework.proxy.ProxyStore$airshipConfig$1
            @Override // kotlin.jvm.functions.Function1
            public final ProxyConfig invoke(JsonValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                JsonMap jsonMapOptMap = it.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                return new ProxyConfig(jsonMapOptMap);
            }
        });
    }

    public final void setAirshipConfig(@Nullable ProxyConfig proxyConfig) {
        setJson("AIRSHIP_CONFIG", proxyConfig);
    }

    @Nullable
    public final NotificationStatus getLastNotificationStatus() {
        return (NotificationStatus) getJson("NOTIFICATION_STATUS", new Function1() { // from class: com.urbanairship.android.framework.proxy.ProxyStore$lastNotificationStatus$1
            @Override // kotlin.jvm.functions.Function1
            public final NotificationStatus invoke(JsonValue it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new NotificationStatus(it);
            }
        });
    }

    public final void setLastNotificationStatus(@Nullable NotificationStatus notificationStatus) {
        setJson("NOTIFICATION_STATUS", notificationStatus);
    }

    public final boolean getDefaultAutoLaunchMessageCenter() {
        return this.defaultAutoLaunchMessageCenter;
    }

    public final void setDefaultAutoLaunchMessageCenter(boolean z) {
        this.defaultAutoLaunchMessageCenter = z;
    }

    public final boolean isAutoLaunchMessageCenterEnabled() {
        return getBoolean("AUTO_LAUNCH_MESSAGE_CENTER", this.defaultAutoLaunchMessageCenter);
    }

    public final void setAutoLaunchMessageCenterEnabled(boolean z) {
        setBoolean("AUTO_LAUNCH_MESSAGE_CENTER", Boolean.valueOf(z));
    }

    public final boolean getDefaultForegroundNotificationsEnabled() {
        return this.defaultForegroundNotificationsEnabled;
    }

    public final void setDefaultForegroundNotificationsEnabled(boolean z) {
        this.defaultForegroundNotificationsEnabled = z;
    }

    public final boolean isForegroundNotificationsEnabled() {
        return getBoolean("FOREGROUND_NOTIFICATIONS", this.defaultForegroundNotificationsEnabled);
    }

    public final void setForegroundNotificationsEnabled(boolean z) {
        setBoolean("FOREGROUND_NOTIFICATIONS", Boolean.valueOf(z));
    }

    public final boolean isAutoLaunchPreferenceCenterEnabled(@NotNull String preferenceId) {
        Intrinsics.checkNotNullParameter(preferenceId, "preferenceId");
        return getBoolean(getAutoLaunchPreferenceCenterKey(preferenceId), true);
    }

    public final void setAutoLaunchPreferenceCenter(@NotNull String preferenceId, boolean autoLaunch) {
        Intrinsics.checkNotNullParameter(preferenceId, "preferenceId");
        setBoolean(getAutoLaunchPreferenceCenterKey(preferenceId), Boolean.valueOf(autoLaunch));
    }

    private final Object getJson(String key, Function1 parser) {
        String string = getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            JsonValue string2 = JsonValue.parseString(string);
            Intrinsics.checkNotNullExpressionValue(string2, "parseString(...)");
            return parser.invoke(string2);
        } catch (Exception e) {
            ProxyLogger.error("Failed to parse " + key + " in config.", e);
            return null;
        }
    }

    private final String getString(String key, String defaultValue) {
        return getPreferences().getString(key, defaultValue);
    }

    private final boolean getBoolean(String key, boolean defaultValue) {
        return getPreferences().getBoolean(key, defaultValue);
    }

    private final void setBoolean(String key, Boolean value) {
        if (value != null) {
            getPreferences().edit().putBoolean(key, value.booleanValue()).apply();
        } else {
            getPreferences().edit().remove(key).apply();
        }
    }

    private final void setJson(String key, JsonSerializable value) {
        if (value != null) {
            getPreferences().edit().putString(key, value.getJsonValue().toString()).apply();
        } else {
            getPreferences().edit().remove(key).apply();
        }
    }

    private final String getAutoLaunchPreferenceCenterKey(String preferenceId) {
        return "PREFERENCE_CENTER_AUTO_LAUNCH_" + preferenceId;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/framework/proxy/ProxyStore$Companion;", "", "()V", "AIRSHIP_CONFIG", "", "AUTO_LAUNCH_MESSAGE_CENTER", "FOREGROUND_NOTIFICATIONS", "NOTIFICATION_CONFIG", "NOTIFICATION_STATUS", "PREFERENCE_CENTER_AUTO_LAUNCH_PREFIX", "SHARED_PREFERENCES_FILE", "sharedInstance", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "sharedInstanceLock", "shared", "context", "Landroid/content/Context;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ProxyStore shared(@NotNull Context context) {
            ProxyStore proxyStore;
            Intrinsics.checkNotNullParameter(context, "context");
            synchronized (ProxyStore.sharedInstanceLock) {
                try {
                    if (ProxyStore.sharedInstance == null) {
                        ProxyStore.sharedInstance = new ProxyStore(context);
                    }
                    proxyStore = ProxyStore.sharedInstance;
                    Intrinsics.checkNotNull(proxyStore);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return proxyStore;
        }
    }
}
