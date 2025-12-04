package com.urbanairship.android.framework.proxy;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.PrivacyManager;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\tH\u0007J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J7\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005¨\u0006&"}, d2 = {"Lcom/urbanairship/android/framework/proxy/Utils;", "", "()V", "featureNames", "", "", "features", "Lcom/urbanairship/PrivacyManager$Feature;", "getHexColor", "", "hexColor", "defaultColor", "getNamedResource", "context", "Landroid/content/Context;", "resourceName", "resourceFolder", "getNotificationId", "notificationId", "notificationTag", "logLevelString", "logLevel", "logPrivacyLevelString", "privacyLevel", "Lcom/urbanairship/AirshipConfigOptions$PrivacyLevel;", "notificationMap", "", "message", "Lcom/urbanairship/push/PushMessage;", "(Lcom/urbanairship/push/PushMessage;Ljava/lang/Integer;Ljava/lang/String;)Ljava/util/Map;", "parseFeatures", "value", "Lcom/urbanairship/json/JsonValue;", "parseLogLevel", "parseLogPrivacyLevel", "parseSite", "siteString", "site", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/urbanairship/android/framework/proxy/Utils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,188:1\n1603#2,9:189\n1855#2:198\n1856#2:200\n1612#2:201\n1#3:199\n1#3:202\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/urbanairship/android/framework/proxy/Utils\n*L\n139#1:189,9\n139#1:198\n139#1:200\n139#1:201\n139#1:199\n*E\n"})
/* loaded from: classes2.dex */
public final class Utils {

    @NotNull
    public static final Utils INSTANCE = new Utils();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AirshipConfigOptions.PrivacyLevel.values().length];
            try {
                iArr[AirshipConfigOptions.PrivacyLevel.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AirshipConfigOptions.PrivacyLevel.PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Utils() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int parseLogLevel(@NotNull String logLevel) throws JsonException {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        String lowerCase = logLevel.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = StringsKt.trim(lowerCase).toString();
        switch (string.hashCode()) {
            case 3237038:
                if (string.equals(OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO)) {
                    return 4;
                }
                break;
            case 3387192:
                if (string.equals("none")) {
                    return 7;
                }
                break;
            case 95458899:
                if (string.equals("debug")) {
                    return 3;
                }
                break;
            case 96784904:
                if (string.equals(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                    return 6;
                }
                break;
            case 351107458:
                if (string.equals("verbose")) {
                    return 2;
                }
                break;
            case 1124446108:
                if (string.equals("warning")) {
                    return 5;
                }
                break;
        }
        throw new JsonException("Invalid log level: " + logLevel);
    }

    @NotNull
    public final String logLevelString(int logLevel) throws JsonException {
        switch (logLevel) {
            case 2:
                return "verbose";
            case 3:
                return "debug";
            case 4:
                return OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO;
            case 5:
                return "warning";
            case 6:
                return Constants.IPC_BUNDLE_KEY_SEND_ERROR;
            case 7:
                return "none";
            default:
                throw new JsonException("Invalid log level: " + logLevel);
        }
    }

    @NotNull
    public final AirshipConfigOptions.PrivacyLevel parseLogPrivacyLevel(@NotNull String privacyLevel) throws JsonException {
        Intrinsics.checkNotNullParameter(privacyLevel, "privacyLevel");
        String lowerCase = privacyLevel.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = StringsKt.trim(lowerCase).toString();
        if (Intrinsics.areEqual(string, "public")) {
            return AirshipConfigOptions.PrivacyLevel.PUBLIC;
        }
        if (Intrinsics.areEqual(string, "private")) {
            return AirshipConfigOptions.PrivacyLevel.PRIVATE;
        }
        throw new JsonException("Invalid log privacy level: " + privacyLevel);
    }

    @NotNull
    public final String logPrivacyLevelString(@NotNull AirshipConfigOptions.PrivacyLevel privacyLevel) {
        Intrinsics.checkNotNullParameter(privacyLevel, "privacyLevel");
        int i = WhenMappings.$EnumSwitchMapping$0[privacyLevel.ordinal()];
        if (i == 1) {
            return "public";
        }
        if (i == 2) {
            return "private";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final PrivacyManager.Feature parseFeatures(@NotNull JsonValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.isJsonList()) {
            PrivacyManager.Feature featureFromJson = PrivacyManager.Feature.INSTANCE.fromJson(value);
            return featureFromJson == null ? PrivacyManager.Feature.NONE : featureFromJson;
        }
        return PrivacyManager.Feature.NONE;
    }

    @NotNull
    public final String parseSite(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        String lowerCase = value.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "eu")) {
            return AirshipConfigOptions.SITE_EU;
        }
        if (Intrinsics.areEqual(lowerCase, "us")) {
            return AirshipConfigOptions.SITE_US;
        }
        throw new IllegalArgumentException("Invalid site: " + value);
    }

    @NotNull
    public final String siteString(@NotNull String site) {
        Intrinsics.checkNotNullParameter(site, "site");
        String lowerCase = site.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @JvmStatic
    public static final int getNamedResource(@NotNull Context context, @NotNull String resourceName, @NotNull String resourceFolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceName, "resourceName");
        Intrinsics.checkNotNullParameter(resourceFolder, "resourceFolder");
        if (UAStringUtil.isEmpty(resourceName)) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier(resourceName, resourceFolder, context.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        ProxyLogger.error("Unable to find resource with name: %s", resourceName);
        return 0;
    }

    @JvmStatic
    @ColorInt
    public static final int getHexColor(@NotNull String hexColor, @ColorInt int defaultColor) {
        Intrinsics.checkNotNullParameter(hexColor, "hexColor");
        if (!UAStringUtil.isEmpty(hexColor)) {
            try {
                return Color.parseColor(hexColor);
            } catch (IllegalArgumentException e) {
                ProxyLogger.error(e, "Unable to parse color: %s", hexColor);
            }
        }
        return defaultColor;
    }

    @JvmStatic
    @NotNull
    public static final List<String> featureNames(@NotNull PrivacyManager.Feature features) {
        Intrinsics.checkNotNullParameter(features, "features");
        JsonList jsonListOptList = features.getJsonValue().optList();
        Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = jsonListOptList.iterator();
        while (it.hasNext()) {
            String string = it.next().getString();
            if (string != null) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    private final String getNotificationId(int notificationId, String notificationTag) {
        String strValueOf = String.valueOf(notificationId);
        if (UAStringUtil.isEmpty(notificationTag)) {
            return strValueOf;
        }
        return strValueOf + ":" + notificationTag;
    }

    public static /* synthetic */ Map notificationMap$default(Utils utils, PushMessage pushMessage, Integer num, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return utils.notificationMap(pushMessage, num, str);
    }

    @NotNull
    public final Map<String, Object> notificationMap(@NotNull PushMessage message, @Nullable Integer notificationId, @Nullable String notificationTag) {
        Intrinsics.checkNotNullParameter(message, "message");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str : message.getPushBundle().keySet()) {
            if (!Intrinsics.areEqual("android.support.content.wakelockid", str)) {
                if (Intrinsics.areEqual(Constants.MessagePayloadKeys.SENT_TIME, str)) {
                    Intrinsics.checkNotNull(str);
                    linkedHashMap2.put(str, String.valueOf(message.getPushBundle().getLong(str)));
                } else if (Intrinsics.areEqual(Constants.MessagePayloadKeys.TTL, str)) {
                    Intrinsics.checkNotNull(str);
                    linkedHashMap2.put(str, String.valueOf(message.getPushBundle().getInt(str)));
                } else {
                    String string = message.getPushBundle().getString(str);
                    if (string != null) {
                        Intrinsics.checkNotNull(str);
                        linkedHashMap2.put(str, string);
                    }
                }
            }
        }
        linkedHashMap.put("extras", linkedHashMap2);
        String title = message.getTitle();
        if (title != null) {
            linkedHashMap.put("title", title);
        }
        String alert = message.getAlert();
        if (alert != null) {
            linkedHashMap.put("alert", alert);
        }
        String summary = message.getSummary();
        if (summary != null) {
            linkedHashMap.put("subtitle", summary);
        }
        if (notificationId != null) {
            linkedHashMap.put("notificationId", INSTANCE.getNotificationId(notificationId.intValue(), notificationTag));
        }
        return linkedHashMap;
    }
}
