package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.graphics.ColorUtils;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* loaded from: classes4.dex */
public class RNInAppBrowser {
    private static RNInAppBrowser _inAppBrowser;
    private static final Pattern animationIdentifierPattern = Pattern.compile("^.+:.+/");
    private Activity currentActivity;
    private CustomTabsClient customTabsClient;
    private Boolean isLightTheme;
    private Promise mOpenBrowserPromise;

    public static RNInAppBrowser getInstance() {
        if (_inAppBrowser == null) {
            _inAppBrowser = new RNInAppBrowser();
        }
        return _inAppBrowser;
    }

    public Integer setColor(CustomTabsIntent.Builder builder, ReadableMap readableMap, String str, String str2, String str3) {
        String string;
        Integer numValueOf = null;
        try {
            try {
                if (!readableMap.hasKey(str)) {
                    return null;
                }
                string = readableMap.getString(str);
                try {
                    numValueOf = Integer.valueOf(Color.parseColor(string));
                    builder.getClass().getDeclaredMethod(str2, Integer.TYPE).invoke(builder, numValueOf);
                    return numValueOf;
                } catch (Exception e) {
                    e = e;
                    if (!(e instanceof IllegalArgumentException)) {
                        return numValueOf;
                    }
                    throw new JSApplicationIllegalArgumentException("Invalid " + str3 + " color '" + string + "': " + e.getMessage());
                }
            } catch (Throwable unused) {
                return numValueOf;
            }
        } catch (Exception e2) {
            e = e2;
            string = null;
        }
    }

    public void open(Context context, ReadableMap readableMap, Promise promise, Activity activity) throws SecurityException {
        ReadableMap map;
        String string = readableMap.getString("url");
        this.currentActivity = activity;
        if (this.mOpenBrowserPromise != null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", "cancel");
            this.mOpenBrowserPromise.resolve(writableMapCreateMap);
            this.mOpenBrowserPromise = null;
            return;
        }
        this.mOpenBrowserPromise = promise;
        if (activity == null) {
            promise.reject("InAppBrowser", "No activity");
            this.mOpenBrowserPromise = null;
            return;
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        this.isLightTheme = Boolean.FALSE;
        Integer color = setColor(builder, readableMap, "toolbarColor", "setToolbarColor", "toolbar");
        if (color != null) {
            this.isLightTheme = toolbarIsLight(color.intValue());
        }
        setColor(builder, readableMap, "secondaryToolbarColor", "setSecondaryToolbarColor", "secondary toolbar");
        setColor(builder, readableMap, "navigationBarColor", "setNavigationBarColor", "navigation bar");
        setColor(builder, readableMap, "navigationBarDividerColor", "setNavigationBarDividerColor", "navigation bar divider");
        if (readableMap.hasKey("enableDefaultShare") && readableMap.getBoolean("enableDefaultShare")) {
            builder.addDefaultShareMenuItem();
        }
        if (readableMap.hasKey("animations")) {
            applyAnimation(context, builder, readableMap.getMap("animations"));
        }
        if (readableMap.hasKey("hasBackButton") && readableMap.getBoolean("hasBackButton")) {
            builder.setCloseButtonIcon(BitmapFactory.decodeResource(context.getResources(), this.isLightTheme.booleanValue() ? R.drawable.ic_arrow_back_black : R.drawable.ic_arrow_back_white));
        }
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intent intent = customTabsIntentBuild.intent;
        if (readableMap.hasKey("headers") && (map = readableMap.getMap("headers")) != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
            if (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                Bundle bundle = new Bundle();
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    if (AnonymousClass2.$SwitchMap$com$facebook$react$bridge$ReadableType[map.getType(strNextKey).ordinal()] == 1) {
                        bundle.putString(strNextKey, map.getString(strNextKey));
                    }
                }
                intent.putExtra("com.android.browser.headers", bundle);
            }
        }
        if (readableMap.hasKey("forceCloseOnRedirection") && readableMap.getBoolean("forceCloseOnRedirection")) {
            intent.addFlags(268435456);
        }
        if (!readableMap.hasKey("showInRecents") || !readableMap.getBoolean("showInRecents")) {
            intent.addFlags(8388608);
            intent.addFlags(1073741824);
        }
        intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, readableMap.hasKey("enableUrlBarHiding") && readableMap.getBoolean("enableUrlBarHiding"));
        try {
            if (readableMap.hasKey("browserPackage")) {
                String string2 = readableMap.getString("browserPackage");
                if (!TextUtils.isEmpty(string2)) {
                    intent.setPackage(string2);
                }
            } else {
                intent.setPackage(getDefaultBrowser(this.currentActivity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        registerEventBus();
        intent.setData(Uri.parse(string));
        if (readableMap.hasKey("showTitle")) {
            builder.setShowTitle(readableMap.getBoolean("showTitle"));
        } else {
            intent.putExtra(CustomTabsIntent.EXTRA_TITLE_VISIBILITY_STATE, 0);
        }
        if (readableMap.hasKey("includeReferrer") && readableMap.getBoolean("includeReferrer")) {
            intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + context.getApplicationContext().getPackageName()));
        }
        Activity activity2 = this.currentActivity;
        activity2.startActivity(ChromeTabsManagerActivity.createStartIntent(activity2, intent), customTabsIntentBuild.startAnimationBundle);
    }

    /* renamed from: com.proyecto26.inappbrowser.RNInAppBrowser$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void close() {
        Promise promise = this.mOpenBrowserPromise;
        if (promise == null) {
            return;
        }
        if (this.currentActivity == null) {
            promise.reject("InAppBrowser", "No activity");
            this.mOpenBrowserPromise = null;
            return;
        }
        unRegisterEventBus();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "dismiss");
        this.mOpenBrowserPromise.resolve(writableMapCreateMap);
        this.mOpenBrowserPromise = null;
        Activity activity = this.currentActivity;
        activity.startActivity(ChromeTabsManagerActivity.createDismissIntent(activity));
    }

    public void isAvailable(Context context, Promise promise) {
        List preferredPackages = getPreferredPackages(context);
        promise.resolve(Boolean.valueOf((preferredPackages == null || preferredPackages.isEmpty()) ? false : true));
    }

    @Subscribe
    public void onEvent(ChromeTabsDismissedEvent chromeTabsDismissedEvent) {
        unRegisterEventBus();
        if (this.mOpenBrowserPromise == null) {
            return;
        }
        if (chromeTabsDismissedEvent.isError.booleanValue()) {
            this.mOpenBrowserPromise.reject("InAppBrowser", chromeTabsDismissedEvent.message);
        } else {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", chromeTabsDismissedEvent.resultType);
            writableMapCreateMap.putString("message", chromeTabsDismissedEvent.message);
            this.mOpenBrowserPromise.resolve(writableMapCreateMap);
        }
        this.mOpenBrowserPromise = null;
    }

    void applyAnimation(Context context, CustomTabsIntent.Builder builder, ReadableMap readableMap) {
        int iResolveAnimationIdentifierIfNeeded = readableMap.hasKey("startEnter") ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString("startEnter")) : -1;
        int iResolveAnimationIdentifierIfNeeded2 = readableMap.hasKey("startExit") ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString("startExit")) : -1;
        int iResolveAnimationIdentifierIfNeeded3 = readableMap.hasKey("endEnter") ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString("endEnter")) : -1;
        int iResolveAnimationIdentifierIfNeeded4 = readableMap.hasKey("endExit") ? resolveAnimationIdentifierIfNeeded(context, readableMap.getString("endExit")) : -1;
        if (iResolveAnimationIdentifierIfNeeded != -1 && iResolveAnimationIdentifierIfNeeded2 != -1) {
            builder.setStartAnimations(context, iResolveAnimationIdentifierIfNeeded, iResolveAnimationIdentifierIfNeeded2);
        }
        if (iResolveAnimationIdentifierIfNeeded3 == -1 || iResolveAnimationIdentifierIfNeeded4 == -1) {
            return;
        }
        builder.setExitAnimations(context, iResolveAnimationIdentifierIfNeeded3, iResolveAnimationIdentifierIfNeeded4);
    }

    private int resolveAnimationIdentifierIfNeeded(Context context, String str) {
        if (animationIdentifierPattern.matcher(str).find()) {
            return context.getResources().getIdentifier(str, null, null);
        }
        return context.getResources().getIdentifier(str, "anim", context.getPackageName());
    }

    private void registerEventBus() throws SecurityException {
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    private void unRegisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    private Boolean toolbarIsLight(int i) {
        return Boolean.valueOf(ColorUtils.calculateLuminance(i) > 0.5d);
    }

    private List getPreferredPackages(Context context) {
        return context.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
    }

    private String getDefaultBrowser(Context context) {
        List preferredPackages = getPreferredPackages(context);
        String packageName = CustomTabsClient.getPackageName(context, Arrays.asList("com.android.chrome", "com.chrome.beta", "com.chrome.dev", "com.google.android.apps.chrome"));
        return (packageName != null || preferredPackages == null || preferredPackages.size() <= 0) ? packageName : ((ResolveInfo) preferredPackages.get(0)).serviceInfo.packageName;
    }

    public void onStart(Activity activity) {
        final Context applicationContext = activity.getApplicationContext();
        CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() { // from class: com.proyecto26.inappbrowser.RNInAppBrowser.1
            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                RNInAppBrowser.this.customTabsClient = customTabsClient;
                if (!RNInAppBrowser.this.customTabsClient.warmup(0L)) {
                    System.err.println("Couldn't warmup custom tabs client");
                }
                applicationContext.unbindService(this);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                RNInAppBrowser.this.customTabsClient = null;
            }
        };
        String defaultBrowser = getDefaultBrowser(applicationContext);
        if (defaultBrowser != null) {
            CustomTabsClient.bindCustomTabsService(applicationContext, defaultBrowser, customTabsServiceConnection);
        } else {
            System.err.println("No browser supported to bind custom tab service");
        }
    }

    public void warmup(Promise promise) {
        CustomTabsClient customTabsClient = this.customTabsClient;
        if (customTabsClient != null) {
            promise.resolve(Boolean.valueOf(customTabsClient.warmup(0L)));
        }
        promise.resolve(Boolean.FALSE);
    }

    public void mayLaunchUrl(String str, ReadableArray readableArray) {
        CustomTabsSession customTabsSessionNewSession;
        CustomTabsClient customTabsClient = this.customTabsClient;
        if (customTabsClient == null || (customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback())) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            String string = readableArray.getString(i);
            if (string != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsService.KEY_URL, Uri.parse(string));
                arrayList.add(bundle);
            }
        }
        customTabsSessionNewSession.mayLaunchUrl(Uri.parse(str), null, arrayList);
    }
}
