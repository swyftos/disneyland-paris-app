package com.urbanairship.audience;

import com.facebook.hermes.intl.Constants;
import com.urbanairship.contacts.StableContactInfo;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00102\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u00103J\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fH\u0096@¢\u0006\u0002\u00103J\u000e\u00105\u001a\u00020$H\u0096@¢\u0006\u0002\u00103R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\bR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\fR\u0014\u0010,\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\bR\u0014\u0010-\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0010¨\u00066"}, d2 = {"Lcom/urbanairship/audience/CachingDeviceInfoProvider;", "Lcom/urbanairship/audience/DeviceInfoProvider;", "deviceInfoProviderImpl", "Lcom/urbanairship/audience/DeviceInfoProviderImpl;", "(Lcom/urbanairship/audience/DeviceInfoProviderImpl;)V", "analyticsEnabled", "", "getAnalyticsEnabled", "()Z", "appVersionCode", "", "getAppVersionCode", "()J", "appVersionName", "", "getAppVersionName", "()Ljava/lang/String;", "cachedAnalyticsEnabled", "Lcom/urbanairship/audience/OneTimeValue;", "cachedAppVersionCode", "cachedAppVersionName", "cachedChannelCreated", "cachedChannelId", "Lcom/urbanairship/audience/OneTimeValueSus;", "cachedChannelTags", "", "cachedInstallDateMilliseconds", "cachedIsNotificationsOptedIn", "cachedLocale", "Ljava/util/Locale;", "cachedPermissionStatus", "", "Lcom/urbanairship/permission/Permission;", "Lcom/urbanairship/permission/PermissionStatus;", "cachedPlatform", "cachedStableContactInfo", "Lcom/urbanairship/contacts/StableContactInfo;", "channelCreated", "getChannelCreated", "channelTags", "getChannelTags", "()Ljava/util/Set;", "installDateMilliseconds", "getInstallDateMilliseconds", "isNotificationsOptedIn", Constants.LOCALE, "getLocale", "()Ljava/util/Locale;", DeferredApiClient.KEY_PLATFORM, "getPlatform", "getChannelId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissionStatuses", "getStableContactInfo", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CachingDeviceInfoProvider implements DeviceInfoProvider {
    private final OneTimeValue cachedAnalyticsEnabled;
    private final OneTimeValue cachedAppVersionCode;
    private final OneTimeValue cachedAppVersionName;
    private final OneTimeValue cachedChannelCreated;
    private final OneTimeValueSus cachedChannelId;
    private final OneTimeValue cachedChannelTags;
    private final OneTimeValue cachedInstallDateMilliseconds;
    private final OneTimeValue cachedIsNotificationsOptedIn;
    private final OneTimeValue cachedLocale;
    private final OneTimeValueSus cachedPermissionStatus;
    private final OneTimeValue cachedPlatform;
    private final OneTimeValueSus cachedStableContactInfo;
    private final DeviceInfoProviderImpl deviceInfoProviderImpl;

    public CachingDeviceInfoProvider(@NotNull DeviceInfoProviderImpl deviceInfoProviderImpl) {
        Intrinsics.checkNotNullParameter(deviceInfoProviderImpl, "deviceInfoProviderImpl");
        this.deviceInfoProviderImpl = deviceInfoProviderImpl;
        this.cachedPermissionStatus = new OneTimeValueSus(new CachingDeviceInfoProvider$cachedPermissionStatus$1(this, null));
        this.cachedStableContactInfo = new OneTimeValueSus(new CachingDeviceInfoProvider$cachedStableContactInfo$1(this, null));
        this.cachedChannelId = new OneTimeValueSus(new CachingDeviceInfoProvider$cachedChannelId$1(this, null));
        this.cachedIsNotificationsOptedIn = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedIsNotificationsOptedIn$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.deviceInfoProviderImpl.isNotificationsOptedIn());
            }
        });
        this.cachedChannelTags = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedChannelTags$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set invoke() {
                return this.this$0.deviceInfoProviderImpl.getChannelTags();
            }
        });
        this.cachedAppVersionName = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedAppVersionName$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.deviceInfoProviderImpl.getAppVersionName();
            }
        });
        this.cachedAppVersionCode = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedAppVersionCode$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(this.this$0.deviceInfoProviderImpl.getAppVersionCode());
            }
        });
        this.cachedPlatform = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedPlatform$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.deviceInfoProviderImpl.getPlatform();
            }
        });
        this.cachedChannelCreated = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedChannelCreated$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.deviceInfoProviderImpl.getChannelCreated());
            }
        });
        this.cachedAnalyticsEnabled = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedAnalyticsEnabled$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.deviceInfoProviderImpl.getAnalyticsEnabled());
            }
        });
        this.cachedInstallDateMilliseconds = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedInstallDateMilliseconds$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(this.this$0.deviceInfoProviderImpl.getInstallDateMilliseconds());
            }
        });
        this.cachedLocale = new OneTimeValue(new Function0() { // from class: com.urbanairship.audience.CachingDeviceInfoProvider$cachedLocale$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Locale invoke() {
                return this.this$0.deviceInfoProviderImpl.getLocale();
            }
        });
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @Nullable
    public Object getPermissionStatuses(@NotNull Continuation<? super Map<Permission, ? extends PermissionStatus>> continuation) {
        return this.cachedPermissionStatus.getValue(continuation);
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @Nullable
    public Object getStableContactInfo(@NotNull Continuation<? super StableContactInfo> continuation) {
        return this.cachedStableContactInfo.getValue(continuation);
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @Nullable
    public Object getChannelId(@NotNull Continuation<? super String> continuation) {
        return this.cachedChannelId.getValue(continuation);
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public boolean isNotificationsOptedIn() {
        return ((Boolean) this.cachedIsNotificationsOptedIn.getValue()).booleanValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public Set<String> getChannelTags() {
        return (Set) this.cachedChannelTags.getValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public String getAppVersionName() {
        return (String) this.cachedAppVersionName.getValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public long getAppVersionCode() {
        return ((Number) this.cachedAppVersionCode.getValue()).longValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public String getPlatform() {
        return (String) this.cachedPlatform.getValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public boolean getChannelCreated() {
        return ((Boolean) this.cachedChannelCreated.getValue()).booleanValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public boolean getAnalyticsEnabled() {
        return ((Boolean) this.cachedAnalyticsEnabled.getValue()).booleanValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public long getInstallDateMilliseconds() {
        return ((Number) this.cachedInstallDateMilliseconds.getValue()).longValue();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public Locale getLocale() {
        return (Locale) this.cachedLocale.getValue();
    }
}
