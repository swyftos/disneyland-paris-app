package com.urbanairship.audience;

import android.content.pm.PackageInfo;
import com.facebook.hermes.intl.Constants;
import com.urbanairship.UAirship;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.util.PlatformUtils;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001f\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"H\u0096@¢\u0006\u0002\u0010 J\u000e\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010 R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000f¨\u0006'"}, d2 = {"Lcom/urbanairship/audience/DeviceInfoProviderImpl;", "Lcom/urbanairship/audience/DeviceInfoProvider;", "contactId", "", "(Ljava/lang/String;)V", "analyticsEnabled", "", "getAnalyticsEnabled", "()Z", "appVersionCode", "", "getAppVersionCode", "()J", "appVersionName", "getAppVersionName", "()Ljava/lang/String;", "channelCreated", "getChannelCreated", "channelTags", "", "getChannelTags", "()Ljava/util/Set;", "installDateMilliseconds", "getInstallDateMilliseconds", "isNotificationsOptedIn", Constants.LOCALE, "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", DeferredApiClient.KEY_PLATFORM, "getPlatform", "getChannelId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPermissionStatuses", "", "Lcom/urbanairship/permission/Permission;", "Lcom/urbanairship/permission/PermissionStatus;", "getStableContactInfo", "Lcom/urbanairship/contacts/StableContactInfo;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDeviceInfoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeviceInfoProvider.kt\ncom/urbanairship/audience/DeviceInfoProviderImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n1271#2,2:217\n1285#2,4:219\n*S KotlinDebug\n*F\n+ 1 DeviceInfoProvider.kt\ncom/urbanairship/audience/DeviceInfoProviderImpl\n*L\n93#1:217,2\n93#1:219,4\n*E\n"})
/* loaded from: classes5.dex */
public final class DeviceInfoProviderImpl implements DeviceInfoProvider {
    private final String contactId;

    /* renamed from: com.urbanairship.audience.DeviceInfoProviderImpl$getPermissionStatuses$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceInfoProviderImpl.this.getPermissionStatuses(this);
        }
    }

    /* renamed from: com.urbanairship.audience.DeviceInfoProviderImpl$getStableContactInfo$1, reason: invalid class name and case insensitive filesystem */
    static final class C09821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09821(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceInfoProviderImpl.this.getStableContactInfo(this);
        }
    }

    public DeviceInfoProviderImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DeviceInfoProviderImpl(@Nullable String str) {
        this.contactId = str;
    }

    public /* synthetic */ DeviceInfoProviderImpl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public long getInstallDateMilliseconds() {
        PackageInfo packageInfo = UAirship.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo.firstInstallTime;
        }
        return 0L;
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public boolean isNotificationsOptedIn() {
        return UAirship.shared().getPushManager().areNotificationsOptedIn();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public Set<String> getChannelTags() {
        return UAirship.shared().getChannel().getTags();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public String getAppVersionName() {
        PackageInfo packageInfo = UAirship.getPackageInfo();
        String str = packageInfo != null ? packageInfo.versionName : null;
        return str == null ? "" : str;
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public long getAppVersionCode() {
        return UAirship.getAppVersion();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public String getPlatform() {
        String strAsString = PlatformUtils.asString(UAirship.shared().getPlatformType());
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public boolean getChannelCreated() {
        return UAirship.shared().getChannel().getId() != null;
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    public boolean getAnalyticsEnabled() {
        return UAirship.shared().getAnalytics().isEnabled();
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @NotNull
    public Locale getLocale() {
        Locale locale = UAirship.shared().getLocaleManager().getLocale();
        Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
        return locale;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0093 -> B:21:0x0094). Please report as a decompilation issue!!! */
    @Override // com.urbanairship.audience.DeviceInfoProvider
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getPermissionStatuses(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<com.urbanairship.permission.Permission, ? extends com.urbanairship.permission.PermissionStatus>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.urbanairship.audience.DeviceInfoProviderImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.urbanairship.audience.DeviceInfoProviderImpl$getPermissionStatuses$1 r0 = (com.urbanairship.audience.DeviceInfoProviderImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.DeviceInfoProviderImpl$getPermissionStatuses$1 r0 = new com.urbanairship.audience.DeviceInfoProviderImpl$getPermissionStatuses$1
            r0.<init>(r8)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L43
            if (r1 != r2) goto L3b
            java.lang.Object r1 = r0.L$4
            java.lang.Object r3 = r0.L$3
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r4 = r0.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$1
            java.util.LinkedHashMap r5 = (java.util.LinkedHashMap) r5
            java.lang.Object r6 = r0.L$0
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L94
        L3b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L43:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.audience.DeviceInfoProviderImpl$getPermissionStatuses$resolver$1 r7 = new com.urbanairship.audience.DeviceInfoProviderImpl$getPermissionStatuses$resolver$1
            r1 = 0
            r7.<init>(r1)
            com.urbanairship.UAirship r1 = com.urbanairship.UAirship.shared()
            com.urbanairship.permission.PermissionsManager r1 = r1.getPermissionsManager()
            java.util.Set r1 = r1.getConfiguredPermissions()
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            int r4 = kotlin.collections.MapsKt.mapCapacity(r4)
            r5 = 16
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast(r4, r5)
            r3.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
            r6 = r7
            r4 = r1
        L73:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L9b
            java.lang.Object r1 = r4.next()
            r7 = r1
            com.urbanairship.permission.Permission r7 = (com.urbanairship.permission.Permission) r7
            r0.L$0 = r6
            r0.L$1 = r3
            r0.L$2 = r4
            r0.L$3 = r3
            r0.L$4 = r1
            r0.label = r2
            java.lang.Object r7 = r6.invoke(r7, r0)
            if (r7 != r8) goto L93
            return r8
        L93:
            r5 = r3
        L94:
            com.urbanairship.permission.PermissionStatus r7 = (com.urbanairship.permission.PermissionStatus) r7
            r3.put(r1, r7)
            r3 = r5
            goto L73
        L9b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.DeviceInfoProviderImpl.getPermissionStatuses(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.audience.DeviceInfoProvider
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getStableContactInfo(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.contacts.StableContactInfo> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.audience.DeviceInfoProviderImpl.C09821
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.audience.DeviceInfoProviderImpl$getStableContactInfo$1 r0 = (com.urbanairship.audience.DeviceInfoProviderImpl.C09821) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.audience.DeviceInfoProviderImpl$getStableContactInfo$1 r0 = new com.urbanairship.audience.DeviceInfoProviderImpl$getStableContactInfo$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            com.urbanairship.audience.DeviceInfoProviderImpl r4 = (com.urbanairship.audience.DeviceInfoProviderImpl) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4b
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            com.urbanairship.UAirship r5 = com.urbanairship.UAirship.shared()
            com.urbanairship.contacts.Contact r5 = r5.getContact()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.stableContactInfo$urbanairship_core_release(r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            com.urbanairship.contacts.StableContactInfo r5 = (com.urbanairship.contacts.StableContactInfo) r5
            java.lang.String r0 = r4.contactId
            if (r0 == 0) goto L65
            java.lang.String r0 = r5.getContactId()
            java.lang.String r1 = r4.contactId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L65
            com.urbanairship.contacts.StableContactInfo r5 = new com.urbanairship.contacts.StableContactInfo
            java.lang.String r4 = r4.contactId
            r0 = 0
            r5.<init>(r4, r0)
        L65:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.audience.DeviceInfoProviderImpl.getStableContactInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.urbanairship.audience.DeviceInfoProvider
    @Nullable
    public Object getChannelId(@NotNull Continuation<? super String> continuation) {
        return FlowKt.first(FlowKt.filterNotNull(UAirship.shared().getChannel().getChannelIdFlow()), continuation);
    }
}
