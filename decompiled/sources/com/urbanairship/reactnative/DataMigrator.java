package com.urbanairship.reactnative;

import android.content.Context;
import android.content.SharedPreferences;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.android.framework.proxy.NotificationConfig;
import com.urbanairship.android.framework.proxy.ProxyConfig;
import com.urbanairship.android.framework.proxy.ProxyLogger;
import com.urbanairship.android.framework.proxy.ProxyStore;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.PreferenceCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/reactnative/DataMigrator;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", PreferenceCenter.DEEP_LINK_HOST, "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "migrateData", "", "proxyStore", "Lcom/urbanairship/android/framework/proxy/ProxyStore;", "Companion", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDataMigrator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataMigrator.kt\ncom/urbanairship/reactnative/DataMigrator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,118:1\n1611#2,9:119\n1863#2:128\n1864#2:130\n1620#2:131\n1246#2,4:141\n1#3:129\n535#4:132\n520#4,6:133\n462#4:139\n412#4:140\n216#5,2:145\n*S KotlinDebug\n*F\n+ 1 DataMigrator.kt\ncom/urbanairship/reactnative/DataMigrator\n*L\n51#1:119,9\n51#1:128\n51#1:130\n51#1:131\n81#1:141,4\n51#1:129\n79#1:132\n79#1:133,6\n81#1:139\n81#1:140\n87#1:145,2\n*E\n"})
/* loaded from: classes5.dex */
public final class DataMigrator {
    private static final Map FEATURE_NAME_MAP = MapsKt.mapOf(TuplesKt.to("FEATURE_NONE", "none"), TuplesKt.to("FEATURE_IN_APP_AUTOMATION", AirshipConfigOptions.FEATURE_IN_APP_AUTOMATION), TuplesKt.to("FEATURE_MESSAGE_CENTER", AirshipConfigOptions.FEATURE_MESSAGE_CENTER), TuplesKt.to("FEATURE_PUSH", AirshipConfigOptions.FEATURE_PUSH), TuplesKt.to("FEATURE_CHAT", "chat"), TuplesKt.to("FEATURE_ANALYTICS", AirshipConfigOptions.FEATURE_ANALYTICS), TuplesKt.to("FEATURE_TAGS_AND_ATTRIBUTES", AirshipConfigOptions.FEATURE_TAGS_AND_ATTRIBUTES), TuplesKt.to("FEATURE_CONTACTS", AirshipConfigOptions.FEATURE_CONTACTS), TuplesKt.to("FEATURE_LOCATION", "location"), TuplesKt.to("FEATURE_ALL", AirshipConfigOptions.FEATURE_ALL));
    private final SharedPreferences preferences;

    public DataMigrator(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.preferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
    }

    public final void migrateData(@NotNull ProxyStore proxyStore) {
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(proxyStore, "proxyStore");
        if (this.preferences.contains("notification_icon") || this.preferences.contains("notification_large_icon") || this.preferences.contains("notification_accent_color") || this.preferences.contains("default_notification_channel_id")) {
            proxyStore.setNotificationConfig(new NotificationConfig(this.preferences.getString("notification_icon", null), this.preferences.getString("notification_large_icon", null), this.preferences.getString("notification_accent_color", null), this.preferences.getString("default_notification_channel_id", null)));
            this.preferences.edit().remove("notification_icon").remove("notification_large_icon").remove("notification_accent_color").remove("default_notification_channel_id").apply();
        }
        if (this.preferences.contains("airship_config")) {
            try {
                JsonMap jsonMapOptMap = JsonValue.parseString(this.preferences.getString("airship_config", null)).optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                JsonMap.Builder builderPutAll = JsonMap.newBuilder().putAll(jsonMapOptMap);
                Intrinsics.checkNotNullExpressionValue(builderPutAll, "putAll(...)");
                JsonValue jsonValue = jsonMapOptMap.get("enabledFeatures");
                if (jsonValue != null) {
                    JsonList jsonListOptList = jsonValue.optList();
                    Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                    ArrayList arrayList = new ArrayList();
                    Iterator<JsonValue> it = jsonListOptList.iterator();
                    while (it.hasNext()) {
                        String str = (String) FEATURE_NAME_MAP.get(it.next().optString());
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                    builderPutAll.putOpt("enabledFeatures", JsonValue.wrapOpt(arrayList));
                }
                JsonMap jsonMapBuild = builderPutAll.build();
                Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
                proxyStore.setAirshipConfig(new ProxyConfig(jsonMapBuild));
                this.preferences.edit().remove("airship_config").apply();
            } catch (Exception e) {
                ProxyLogger.error("Failed to migrate config", e);
            }
        }
        if (this.preferences.contains("com.urbanairship.auto_launch_message_center")) {
            proxyStore.setAutoLaunchMessageCenterEnabled(this.preferences.getBoolean("com.urbanairship.auto_launch_message_center", false));
            this.preferences.edit().remove("com.urbanairship.auto_launch_message_center").apply();
        }
        Map<String, ?> all = this.preferences.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
            if (StringsKt.startsWith$default(key, "preference_center_auto_launch_", false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key2 = entry2.getKey();
            if (entry2.getValue() instanceof Boolean) {
                Object value = entry2.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Boolean");
                zBooleanValue = ((Boolean) value).booleanValue();
            } else {
                zBooleanValue = true;
            }
            linkedHashMap2.put(key2, Boolean.valueOf(zBooleanValue));
        }
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            Object key3 = entry3.getKey();
            Intrinsics.checkNotNullExpressionValue(key3, "<get-key>(...)");
            proxyStore.setAutoLaunchPreferenceCenter(StringsKt.removePrefix((String) key3, (CharSequence) "preference_center_auto_launch_"), ((Boolean) entry3.getValue()).booleanValue());
            this.preferences.edit().remove((String) entry3.getKey()).apply();
        }
    }
}
