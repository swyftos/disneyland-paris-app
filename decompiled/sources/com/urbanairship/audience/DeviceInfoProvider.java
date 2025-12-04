package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
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
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 %2\u00020\u0001:\u0001%J\u000e\u0010\u001d\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 H¦@¢\u0006\u0002\u0010\u001eJ\u000e\u0010#\u001a\u00020$H¦@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\r¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/urbanairship/audience/DeviceInfoProvider;", "", "analyticsEnabled", "", "getAnalyticsEnabled", "()Z", "appVersionCode", "", "getAppVersionCode", "()J", "appVersionName", "", "getAppVersionName", "()Ljava/lang/String;", "channelCreated", "getChannelCreated", "channelTags", "", "getChannelTags", "()Ljava/util/Set;", "installDateMilliseconds", "getInstallDateMilliseconds", "isNotificationsOptedIn", Constants.LOCALE, "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", DeferredApiClient.KEY_PLATFORM, "getPlatform", "getChannelId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissionStatuses", "", "Lcom/urbanairship/permission/Permission;", "Lcom/urbanairship/permission/PermissionStatus;", "getStableContactInfo", "Lcom/urbanairship/contacts/StableContactInfo;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface DeviceInfoProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    static DeviceInfoProvider newCachingProvider(@Nullable String str) {
        return INSTANCE.newCachingProvider(str);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    static DeviceInfoProvider newProvider(@Nullable String str) {
        return INSTANCE.newProvider(str);
    }

    boolean getAnalyticsEnabled();

    long getAppVersionCode();

    @NotNull
    String getAppVersionName();

    boolean getChannelCreated();

    @Nullable
    Object getChannelId(@NotNull Continuation<? super String> continuation);

    @NotNull
    Set<String> getChannelTags();

    long getInstallDateMilliseconds();

    @NotNull
    Locale getLocale();

    @Nullable
    Object getPermissionStatuses(@NotNull Continuation<? super Map<Permission, ? extends PermissionStatus>> continuation);

    @NotNull
    String getPlatform();

    @Nullable
    Object getStableContactInfo(@NotNull Continuation<? super StableContactInfo> continuation);

    boolean isNotificationsOptedIn();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/audience/DeviceInfoProvider$Companion;", "", "()V", "newCachingProvider", "Lcom/urbanairship/audience/DeviceInfoProvider;", "contactId", "", "newProvider", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ DeviceInfoProvider newProvider$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newProvider(str);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final DeviceInfoProvider newProvider(@Nullable String contactId) {
            return new DeviceInfoProviderImpl(contactId);
        }

        public static /* synthetic */ DeviceInfoProvider newCachingProvider$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newCachingProvider(str);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final DeviceInfoProvider newCachingProvider(@Nullable String contactId) {
            return new CachingDeviceInfoProvider(new DeviceInfoProviderImpl(contactId));
        }
    }
}
