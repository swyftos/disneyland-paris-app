package com.urbanairship.reactnative;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public abstract class NativeRNAirshipSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNAirship";

    @DoNotStrip
    @ReactMethod
    public abstract void actionRun(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addCustomEvent(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void airshipListenerAdded(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void analyticsAssociateIdentifier(String str, @Nullable String str2, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void analyticsGetSessionId(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void analyticsTrackScreen(@Nullable String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelAddTag(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelEditAttributes(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelEditSubscriptionLists(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelEditTagGroups(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelEditTags(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelEnableChannelCreation(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelGetChannelId(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelGetSubscriptionLists(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelGetTags(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelRemoveTag(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void channelWaitForChannelId(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactEditAttributes(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactEditSubscriptionLists(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactEditTagGroups(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactGetNamedUserId(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactGetSubscriptionLists(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactIdentify(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactNotifyRemoteLogin(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void contactReset(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void featureFlagManagerFlag(String str, boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void featureFlagManagerResultCacheGetFlag(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void featureFlagManagerResultCacheRemoveFlag(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void featureFlagManagerResultCacheSetFlag(ReadableMap readableMap, double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void featureFlagManagerTrackInteraction(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void inAppGetDisplayInterval(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void inAppIsPaused(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void inAppResendPendingEmbeddedEvent();

    @DoNotStrip
    @ReactMethod
    public abstract void inAppSetDisplayInterval(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void inAppSetPaused(boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void isFlying(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveActivityEnd(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveActivityList(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveActivityListAll(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveActivityStart(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveActivityUpdate(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveUpdateClearAll(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveUpdateEnd(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveUpdateList(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveUpdateListAll(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveUpdateStart(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void liveUpdateUpdate(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void localeClearLocaleOverride(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void localeGetLocale(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void localeSetLocaleOverride(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterDeleteMessage(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterDismiss(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterDisplay(@Nullable String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterGetMessages(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterGetUnreadCount(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterMarkMessageRead(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterRefresh(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterSetAutoLaunchDefaultMessageCenter(boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterShowMessageCenter(@Nullable String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void messageCenterShowMessageView(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void preferenceCenterAutoLaunchDefaultPreferenceCenter(String str, boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void preferenceCenterDisplay(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void preferenceCenterGetConfig(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void privacyManagerDisableFeature(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void privacyManagerEnableFeature(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void privacyManagerGetEnabledFeatures(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void privacyManagerIsFeatureEnabled(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void privacyManagerSetEnabledFeatures(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushAndroidIsNotificationChannelEnabled(String str, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushAndroidIsOverrideForegroundDisplayEnabled(boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void pushAndroidOverrideForegroundDisplay(String str, boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void pushAndroidSetNotificationConfig(ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void pushClearNotification(String str);

    @DoNotStrip
    @ReactMethod
    public abstract void pushClearNotifications();

    @DoNotStrip
    @ReactMethod
    public abstract void pushEnableUserNotifications(@Nullable ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushGetActiveNotifications(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushGetNotificationStatus(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushGetRegistrationToken(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosGetAuthorizedNotificationSettings(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosGetAuthorizedNotificationStatus(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosGetBadgeNumber(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosIsAutobadgeEnabled(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosIsOverridePresentationOptionsEnabled(boolean z);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosOverridePresentationOptions(String str, @Nullable ReadableArray readableArray);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosSetAutobadgeEnabled(boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosSetBadgeNumber(double d, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosSetForegroundPresentationOptions(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIosSetNotificationOptions(ReadableArray readableArray, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushIsUserNotificationsEnabled(Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void pushSetUserNotificationsEnabled(boolean z, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d);

    @DoNotStrip
    @ReactMethod
    public abstract void takeOff(ReadableMap readableMap, Promise promise);

    @DoNotStrip
    @ReactMethod
    public abstract void takePendingEvents(String str, boolean z, Promise promise);

    public NativeRNAirshipSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNAirship";
    }
}
