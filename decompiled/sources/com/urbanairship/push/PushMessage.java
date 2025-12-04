package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.urbanairship.BuildConfig;
import com.urbanairship.UALog;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.messagecenter.actions.MessageCenterAction;
import com.urbanairship.util.UAMathUtil;
import com.urbanairship.util.UAStringUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public class PushMessage implements Parcelable, JsonSerializable {

    @NonNull
    public static final Parcelable.Creator<PushMessage> CREATOR = new Parcelable.Creator() { // from class: com.urbanairship.push.PushMessage.1
        @Override // android.os.Parcelable.Creator
        public PushMessage createFromParcel(Parcel parcel) {
            Bundle bundle = parcel.readBundle(PushMessage.class.getClassLoader());
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new PushMessage(bundle);
        }

        @Override // android.os.Parcelable.Creator
        public PushMessage[] newArray(int i) {
            return new PushMessage[i];
        }
    };

    @NonNull
    public static final String EXTRA_ACTIONS = "com.urbanairship.actions";

    @NonNull
    public static final String EXTRA_ALERT = "com.urbanairship.push.ALERT";

    @NonNull
    public static final String EXTRA_CATEGORY = "com.urbanairship.category";

    @NonNull
    public static final String EXTRA_DELIVERY_PRIORITY = "com.urbanairship.priority";

    @NonNull
    public static final String EXTRA_EXPIRATION = "com.urbanairship.push.EXPIRATION";

    @NonNull
    public static final String EXTRA_FOREGROUND_DISPLAY = "com.urbanairship.foreground_display";

    @NonNull
    public static final String EXTRA_ICON = "com.urbanairship.icon";

    @NonNull
    public static final String EXTRA_ICON_COLOR = "com.urbanairship.icon_color";

    @NonNull
    public static final String EXTRA_INTERACTIVE_ACTIONS = "com.urbanairship.interactive_actions";

    @NonNull
    public static final String EXTRA_INTERACTIVE_TYPE = "com.urbanairship.interactive_type";

    @NonNull
    public static final String EXTRA_IN_APP_MESSAGE = "com.urbanairship.in_app";

    @NonNull
    public static final String EXTRA_LIVE_UPDATE = "com.urbanairship.live_update";

    @NonNull
    public static final String EXTRA_LOCAL_ONLY = "com.urbanairship.local_only";

    @NonNull
    public static final String EXTRA_METADATA = "com.urbanairship.metadata";

    @NonNull
    public static final String EXTRA_NOTIFICATION_CHANNEL = "com.urbanairship.notification_channel";

    @NonNull
    public static final String EXTRA_NOTIFICATION_TAG = "com.urbanairship.notification_tag";

    @NonNull
    public static final String EXTRA_PRIORITY = "com.urbanairship.priority";

    @NonNull
    public static final String EXTRA_PUBLIC_NOTIFICATION = "com.urbanairship.public_notification";

    @NonNull
    public static final String EXTRA_PUSH_ID = "com.urbanairship.push.CANONICAL_PUSH_ID";

    @NonNull
    public static final String EXTRA_RICH_PUSH_ID = "_uamid";

    @NonNull
    public static final String EXTRA_SEND_ID = "com.urbanairship.push.PUSH_ID";

    @NonNull
    @Deprecated
    public static final String EXTRA_SOUND = "com.urbanairship.sound";

    @NonNull
    public static final String EXTRA_STYLE = "com.urbanairship.style";

    @NonNull
    public static final String EXTRA_SUMMARY = "com.urbanairship.summary";

    @NonNull
    public static final String EXTRA_TITLE = "com.urbanairship.title";

    @NonNull
    public static final String EXTRA_VISIBILITY = "com.urbanairship.visibility";

    @NonNull
    public static final String EXTRA_WEARABLE = "com.urbanairship.wearable";

    @NonNull
    public static final String PRIORITY_HIGH = "high";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public static final String REMOTE_DATA_UPDATE_KEY = "com.urbanairship.remote-data.update";
    private final Map data;
    private Bundle pushBundle;
    private Uri sound;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PushMessage(@NonNull Bundle bundle) {
        this.sound = null;
        this.pushBundle = bundle;
        this.data = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                this.data.put(str, String.valueOf(obj));
            }
        }
    }

    public PushMessage(@NonNull Map<String, String> map) {
        this.sound = null;
        this.data = new HashMap(map);
    }

    boolean isExpired() {
        String str = (String) this.data.get(EXTRA_EXPIRATION);
        if (!UAStringUtil.isEmpty(str)) {
            UALog.v("Notification expiration time is \"%s\"", str);
            try {
                if (Long.parseLong(str) * 1000 < System.currentTimeMillis()) {
                    return true;
                }
            } catch (NumberFormatException e) {
                UALog.d(e, "Ignoring malformed expiration time.", new Object[0]);
            }
        }
        return false;
    }

    boolean isPing() {
        return this.data.containsKey("com.urbanairship.push.PING");
    }

    @Nullable
    public String getExtra(@NonNull String str) {
        return (String) this.data.get(str);
    }

    @NonNull
    public String getExtra(@NonNull String str, @NonNull String str2) {
        String extra = getExtra(str);
        return extra == null ? str2 : extra;
    }

    public boolean containsAirshipKeys() {
        Iterator it = this.data.keySet().iterator();
        while (it.hasNext()) {
            if (((String) it.next()).startsWith(BuildConfig.LIBRARY_PACKAGE_NAME)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public String getCanonicalPushId() {
        return (String) this.data.get(EXTRA_PUSH_ID);
    }

    @Nullable
    public String getRichPushMessageId() {
        return (String) this.data.get(EXTRA_RICH_PUSH_ID);
    }

    @Nullable
    public String getAlert() {
        return (String) this.data.get(EXTRA_ALERT);
    }

    @Nullable
    public String getSendId() {
        return (String) this.data.get(EXTRA_SEND_ID);
    }

    @Nullable
    public String getMetadata() {
        return (String) this.data.get(EXTRA_METADATA);
    }

    @NonNull
    public Bundle getPushBundle() {
        if (this.pushBundle == null) {
            this.pushBundle = new Bundle();
            for (Map.Entry entry : this.data.entrySet()) {
                this.pushBundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return this.pushBundle;
    }

    public boolean isAccengageVisiblePush() {
        return this.data.containsKey("a4scontent");
    }

    public boolean isAccengagePush() {
        return this.data.containsKey("a4sid");
    }

    public boolean isAirshipPush() {
        return this.data.containsKey(EXTRA_SEND_ID) || this.data.containsKey(EXTRA_PUSH_ID) || this.data.containsKey(EXTRA_METADATA);
    }

    @NonNull
    public Map<String, ActionValue> getActions() {
        String str = (String) this.data.get(EXTRA_ACTIONS);
        HashMap map = new HashMap();
        try {
            JsonMap map2 = JsonValue.parseString(str).getMap();
            if (map2 != null) {
                Iterator<Map.Entry<String, JsonValue>> it = map2.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, JsonValue> next = it.next();
                    map.put(next.getKey(), new ActionValue(next.getValue()));
                }
            }
            if (!UAStringUtil.isEmpty(getRichPushMessageId())) {
                map.put(MessageCenterAction.DEFAULT_REGISTRY_SHORT_NAME, ActionValue.wrap(getRichPushMessageId()));
            }
            return map;
        } catch (JsonException unused) {
            UALog.e("Unable to parse action payload: %s", str);
            return map;
        }
    }

    @Nullable
    public String getInteractiveActionsPayload() {
        return (String) this.data.get(EXTRA_INTERACTIVE_ACTIONS);
    }

    @Nullable
    public String getInteractiveNotificationType() {
        return (String) this.data.get(EXTRA_INTERACTIVE_TYPE);
    }

    @Nullable
    public String getTitle() {
        return (String) this.data.get(EXTRA_TITLE);
    }

    @Nullable
    public String getSummary() {
        return (String) this.data.get(EXTRA_SUMMARY);
    }

    @Nullable
    public String getWearablePayload() {
        return (String) this.data.get(EXTRA_WEARABLE);
    }

    @Nullable
    public String getStylePayload() {
        return (String) this.data.get(EXTRA_STYLE);
    }

    public boolean isLocalOnly() {
        return Boolean.parseBoolean((String) this.data.get(EXTRA_LOCAL_ONLY));
    }

    public int getPriority() {
        try {
            String str = (String) this.data.get("com.urbanairship.priority");
            if (UAStringUtil.isEmpty(str)) {
                return 0;
            }
            return UAMathUtil.constrain(Integer.parseInt(str), -2, 2);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public int getVisibility() {
        try {
            String str = (String) this.data.get(EXTRA_VISIBILITY);
            if (UAStringUtil.isEmpty(str)) {
                return 1;
            }
            return UAMathUtil.constrain(Integer.parseInt(str), -1, 1);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    @Nullable
    public String getPublicNotificationPayload() {
        return (String) this.data.get(EXTRA_PUBLIC_NOTIFICATION);
    }

    @Nullable
    public String getCategory() {
        return (String) this.data.get(EXTRA_CATEGORY);
    }

    @Nullable
    @Deprecated
    public Uri getSound(@NonNull Context context) {
        if (this.sound == null && this.data.get(EXTRA_SOUND) != null) {
            String str = (String) this.data.get(EXTRA_SOUND);
            int identifier = context.getResources().getIdentifier(str, "raw", context.getPackageName());
            if (identifier != 0) {
                this.sound = Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier);
            } else if (!"default".equals(str)) {
                UALog.w("PushMessage - unable to find notification sound with name: %s", str);
            }
        }
        return this.sound;
    }

    public int getIconColor(int i) {
        String str = (String) this.data.get(EXTRA_ICON_COLOR);
        if (str != null) {
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                UALog.w("Unrecognized icon color string: %s. Using default color: %s", str, Integer.valueOf(i));
            }
        }
        return i;
    }

    @DrawableRes
    public int getIcon(@NonNull Context context, int i) {
        String str = (String) this.data.get(EXTRA_ICON);
        if (str != null) {
            int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            UALog.w("PushMessage - unable to find icon drawable with name: %s. Using default icon: %s", str, Integer.valueOf(i));
        }
        return i;
    }

    @Nullable
    public String getLiveUpdatePayload() {
        return (String) this.data.get(EXTRA_LIVE_UPDATE);
    }

    @Nullable
    public String getNotificationTag() {
        return (String) this.data.get(EXTRA_NOTIFICATION_TAG);
    }

    @Nullable
    public String getNotificationChannel() {
        return (String) this.data.get(EXTRA_NOTIFICATION_CHANNEL);
    }

    @Nullable
    public boolean isForegroundDisplayable() {
        String str = (String) this.data.get(EXTRA_FOREGROUND_DISPLAY);
        if (str != null) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    @Nullable
    public String getNotificationChannel(@Nullable String str) {
        String str2 = (String) this.data.get(EXTRA_NOTIFICATION_CHANNEL);
        return str2 == null ? str : str2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.data.equals(((PushMessage) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Nullable
    public static PushMessage fromIntent(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            Bundle bundleExtra = intent.getBundleExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE);
            if (bundleExtra == null) {
                return null;
            }
            return new PushMessage(bundleExtra);
        } catch (BadParcelableException e) {
            UALog.e(e, "Failed to parse push message from intent.", new Object[0]);
            return null;
        }
    }

    @NonNull
    public String toString() {
        return this.data.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeBundle(getPushBundle());
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonValue.wrapOpt(this.data);
    }

    @NonNull
    public static PushMessage fromJsonValue(@NonNull JsonValue jsonValue) {
        HashMap map = new HashMap();
        for (Map.Entry<String, JsonValue> entry : jsonValue.optMap().entrySet()) {
            if (entry.getValue().isString()) {
                map.put(entry.getKey(), entry.getValue().optString());
            } else {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return new PushMessage(map);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRemoteDataUpdate() {
        return this.data.containsKey(REMOTE_DATA_UPDATE_KEY);
    }

    public boolean containsKey(@NonNull String str) {
        return this.data.containsKey(str);
    }
}
