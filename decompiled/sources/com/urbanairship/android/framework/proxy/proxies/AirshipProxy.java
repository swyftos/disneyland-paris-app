package com.urbanairship.android.framework.proxy.proxies;

import android.content.Context;
import com.facebook.hermes.intl.Constants;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Autopilot;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.DefaultActionRunner;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.android.framework.proxy.ProxyConfig;
import com.urbanairship.android.framework.proxy.ProxyStore;
import com.urbanairship.automation.InAppAutomation;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.contacts.Contact;
import com.urbanairship.featureflag.FeatureFlagManager;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.liveupdate.LiveUpdateManager;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.messagecenter.MessageCenter;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.preferencecenter.PreferenceCenter;
import com.urbanairship.push.PushManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u00109\u001a\u00020:H\u0002J\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020?J\u000e\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020@R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006B"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/AirshipProxy;", "", "context", "Landroid/content/Context;", "proxyStore", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "(Landroid/content/Context;Lcom/urbanairship/android/framework/proxy/ProxyStore;)V", "actions", "Lcom/urbanairship/android/framework/proxy/proxies/ActionProxy;", "getActions", "()Lcom/urbanairship/android/framework/proxy/proxies/ActionProxy;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/android/framework/proxy/proxies/AnalyticsProxy;", "getAnalytics", "()Lcom/urbanairship/android/framework/proxy/proxies/AnalyticsProxy;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/android/framework/proxy/proxies/ChannelProxy;", "getChannel", "()Lcom/urbanairship/android/framework/proxy/proxies/ChannelProxy;", "contact", "Lcom/urbanairship/android/framework/proxy/proxies/ContactProxy;", "getContact", "()Lcom/urbanairship/android/framework/proxy/proxies/ContactProxy;", "featureFlagManager", "Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy;", "getFeatureFlagManager", "()Lcom/urbanairship/android/framework/proxy/proxies/FeatureFlagManagerProxy;", "inApp", "Lcom/urbanairship/android/framework/proxy/proxies/InAppProxy;", "getInApp", "()Lcom/urbanairship/android/framework/proxy/proxies/InAppProxy;", "liveUpdateManager", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy;", "getLiveUpdateManager", "()Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy;", Constants.LOCALE, "Lcom/urbanairship/android/framework/proxy/proxies/LocaleProxy;", "getLocale", "()Lcom/urbanairship/android/framework/proxy/proxies/LocaleProxy;", "messageCenter", "Lcom/urbanairship/android/framework/proxy/proxies/MessageCenterProxy;", "getMessageCenter", "()Lcom/urbanairship/android/framework/proxy/proxies/MessageCenterProxy;", "preferenceCenter", "Lcom/urbanairship/android/framework/proxy/proxies/PreferenceCenterProxy;", "getPreferenceCenter", "()Lcom/urbanairship/android/framework/proxy/proxies/PreferenceCenterProxy;", "privacyManager", "Lcom/urbanairship/android/framework/proxy/proxies/PrivacyManagerProxy;", "getPrivacyManager", "()Lcom/urbanairship/android/framework/proxy/proxies/PrivacyManagerProxy;", "getProxyStore$airship_framework_proxy_release", "()Lcom/urbanairship/android/framework/proxy/ProxyStore;", AirshipConfigOptions.FEATURE_PUSH, "Lcom/urbanairship/android/framework/proxy/proxies/PushProxy;", "getPush", "()Lcom/urbanairship/android/framework/proxy/proxies/PushProxy;", "ensureTakeOff", "", "isFlying", "", "takeOff", "config", "Lcom/urbanairship/android/framework/proxy/ProxyConfig;", "Lcom/urbanairship/json/JsonValue;", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AirshipProxy {
    private static volatile AirshipProxy sharedInstance;
    private final ActionProxy actions;
    private final AnalyticsProxy analytics;
    private final ChannelProxy channel;
    private final ContactProxy contact;
    private final Context context;
    private final FeatureFlagManagerProxy featureFlagManager;
    private final InAppProxy inApp;
    private final LiveUpdatesManagerProxy liveUpdateManager;
    private final LocaleProxy locale;
    private final MessageCenterProxy messageCenter;
    private final PreferenceCenterProxy preferenceCenter;
    private final PrivacyManagerProxy privacyManager;
    private final ProxyStore proxyStore;
    private final PushProxy push;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final Object sharedInstanceLock = new Object();

    @JvmStatic
    @NotNull
    public static final AirshipProxy shared(@NotNull Context context) {
        return INSTANCE.shared(context);
    }

    public AirshipProxy(@NotNull Context context, @NotNull ProxyStore proxyStore) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(proxyStore, "proxyStore");
        this.context = context;
        this.proxyStore = proxyStore;
        this.actions = new ActionProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$actions$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ActionRunner invoke() {
                this.this$0.ensureTakeOff();
                return DefaultActionRunner.INSTANCE;
            }
        });
        this.analytics = new AnalyticsProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$analytics$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Analytics invoke() {
                this.this$0.ensureTakeOff();
                Analytics analytics = UAirship.shared().getAnalytics();
                Intrinsics.checkNotNullExpressionValue(analytics, "getAnalytics(...)");
                return analytics;
            }
        });
        this.channel = new ChannelProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$channel$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AirshipChannel invoke() {
                this.this$0.ensureTakeOff();
                AirshipChannel channel = UAirship.shared().getChannel();
                Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
                return channel;
            }
        });
        this.contact = new ContactProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$contact$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Contact invoke() {
                this.this$0.ensureTakeOff();
                Contact contact = UAirship.shared().getContact();
                Intrinsics.checkNotNullExpressionValue(contact, "getContact(...)");
                return contact;
            }
        });
        this.inApp = new InAppProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$inApp$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final InAppAutomation invoke() {
                this.this$0.ensureTakeOff();
                return InAppAutomation.INSTANCE.shared();
            }
        });
        this.locale = new LocaleProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$locale$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LocaleManager invoke() {
                this.this$0.ensureTakeOff();
                LocaleManager localeManager = UAirship.shared().getLocaleManager();
                Intrinsics.checkNotNullExpressionValue(localeManager, "getLocaleManager(...)");
                return localeManager;
            }
        });
        this.liveUpdateManager = new LiveUpdatesManagerProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$liveUpdateManager$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LiveUpdateManager invoke() {
                this.this$0.ensureTakeOff();
                return LiveUpdateManager.INSTANCE.shared();
            }
        });
        this.messageCenter = new MessageCenterProxy(proxyStore, new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$messageCenter$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MessageCenter invoke() {
                this.this$0.ensureTakeOff();
                return MessageCenter.INSTANCE.shared();
            }
        });
        this.preferenceCenter = new PreferenceCenterProxy(proxyStore, new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$preferenceCenter$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PreferenceCenter invoke() {
                this.this$0.ensureTakeOff();
                return PreferenceCenter.INSTANCE.shared();
            }
        });
        this.privacyManager = new PrivacyManagerProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$privacyManager$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PrivacyManager invoke() {
                this.this$0.ensureTakeOff();
                PrivacyManager privacyManager = UAirship.shared().getPrivacyManager();
                Intrinsics.checkNotNullExpressionValue(privacyManager, "getPrivacyManager(...)");
                return privacyManager;
            }
        });
        this.push = new PushProxy(context, proxyStore, new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$push$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PermissionsManager invoke() {
                this.this$0.ensureTakeOff();
                PermissionsManager permissionsManager = UAirship.shared().getPermissionsManager();
                Intrinsics.checkNotNullExpressionValue(permissionsManager, "getPermissionsManager(...)");
                return permissionsManager;
            }
        }, new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$push$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PushManager invoke() {
                this.this$0.ensureTakeOff();
                PushManager pushManager = UAirship.shared().getPushManager();
                Intrinsics.checkNotNullExpressionValue(pushManager, "getPushManager(...)");
                return pushManager;
            }
        });
        this.featureFlagManager = new FeatureFlagManagerProxy(new Function0() { // from class: com.urbanairship.android.framework.proxy.proxies.AirshipProxy$featureFlagManager$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FeatureFlagManager invoke() {
                this.this$0.ensureTakeOff();
                return FeatureFlagManager.INSTANCE.shared();
            }
        });
    }

    @NotNull
    /* renamed from: getProxyStore$airship_framework_proxy_release, reason: from getter */
    public final ProxyStore getProxyStore() {
        return this.proxyStore;
    }

    @NotNull
    public final ActionProxy getActions() {
        return this.actions;
    }

    @NotNull
    public final AnalyticsProxy getAnalytics() {
        return this.analytics;
    }

    @NotNull
    public final ChannelProxy getChannel() {
        return this.channel;
    }

    @NotNull
    public final ContactProxy getContact() {
        return this.contact;
    }

    @NotNull
    public final InAppProxy getInApp() {
        return this.inApp;
    }

    @NotNull
    public final LocaleProxy getLocale() {
        return this.locale;
    }

    @NotNull
    public final LiveUpdatesManagerProxy getLiveUpdateManager() {
        return this.liveUpdateManager;
    }

    @NotNull
    public final MessageCenterProxy getMessageCenter() {
        return this.messageCenter;
    }

    @NotNull
    public final PreferenceCenterProxy getPreferenceCenter() {
        return this.preferenceCenter;
    }

    @NotNull
    public final PrivacyManagerProxy getPrivacyManager() {
        return this.privacyManager;
    }

    @NotNull
    public final PushProxy getPush() {
        return this.push;
    }

    @NotNull
    public final FeatureFlagManagerProxy getFeatureFlagManager() {
        return this.featureFlagManager;
    }

    public final boolean takeOff(@NotNull JsonValue config) {
        Intrinsics.checkNotNullParameter(config, "config");
        JsonMap jsonMapOptMap = config.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
        return takeOff(new ProxyConfig(jsonMapOptMap));
    }

    public final boolean takeOff(@NotNull ProxyConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.proxyStore.setAirshipConfig(config);
        Autopilot.automaticTakeOff(this.context);
        return isFlying();
    }

    public final boolean isFlying() {
        return UAirship.isFlying() || UAirship.isTakingOff();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/AirshipProxy$Companion;", "", "()V", "sharedInstance", "Lcom/urbanairship/android/framework/proxy/proxies/AirshipProxy;", "sharedInstanceLock", "shared", "context", "Landroid/content/Context;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final AirshipProxy shared(@NotNull Context context) {
            AirshipProxy airshipProxy;
            Intrinsics.checkNotNullParameter(context, "context");
            synchronized (AirshipProxy.sharedInstanceLock) {
                try {
                    if (AirshipProxy.sharedInstance == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        Context applicationContext2 = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                        AirshipProxy.sharedInstance = new AirshipProxy(applicationContext, new ProxyStore(applicationContext2));
                    }
                    airshipProxy = AirshipProxy.sharedInstance;
                    Intrinsics.checkNotNull(airshipProxy);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return airshipProxy;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureTakeOff() {
        if (!UAirship.isFlying() && !UAirship.isTakingOff()) {
            throw new IllegalStateException("Takeoff not called.");
        }
    }
}
