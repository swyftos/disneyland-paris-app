package com.urbanairship.push.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.provider.Settings;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.AttributeSetConfigParser;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class NotificationChannelCompat implements JsonSerializable {
    private boolean bypassDnd;
    private String description;
    private String group;
    private final String identifier;
    private int importance;
    private int lightColor;
    private int lockscreenVisibility;
    private CharSequence name;
    private boolean shouldVibrate;
    private boolean showBadge;
    private boolean showLights;
    private Uri sound;
    private long[] vibrationPattern;

    @RequiresApi(api = 26)
    public NotificationChannelCompat(@NonNull NotificationChannel notificationChannel) {
        this.bypassDnd = false;
        this.showBadge = true;
        this.showLights = false;
        this.shouldVibrate = false;
        this.description = null;
        this.group = null;
        this.sound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.lightColor = 0;
        this.lockscreenVisibility = -1000;
        this.vibrationPattern = null;
        this.bypassDnd = notificationChannel.canBypassDnd();
        this.showBadge = notificationChannel.canShowBadge();
        this.showLights = notificationChannel.shouldShowLights();
        this.shouldVibrate = notificationChannel.shouldVibrate();
        this.description = notificationChannel.getDescription();
        this.group = notificationChannel.getGroup();
        this.identifier = notificationChannel.getId();
        this.name = notificationChannel.getName();
        this.sound = notificationChannel.getSound();
        this.importance = notificationChannel.getImportance();
        this.lightColor = notificationChannel.getLightColor();
        this.lockscreenVisibility = notificationChannel.getLockscreenVisibility();
        this.vibrationPattern = notificationChannel.getVibrationPattern();
    }

    public NotificationChannelCompat(@NonNull String str, @NonNull CharSequence charSequence, int i) {
        this.bypassDnd = false;
        this.showBadge = true;
        this.showLights = false;
        this.shouldVibrate = false;
        this.description = null;
        this.group = null;
        this.sound = Settings.System.DEFAULT_NOTIFICATION_URI;
        this.lightColor = 0;
        this.lockscreenVisibility = -1000;
        this.vibrationPattern = null;
        this.identifier = str;
        this.name = charSequence;
        this.importance = i;
    }

    @NonNull
    @RequiresApi(api = 26)
    public NotificationChannel toNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(this.identifier, this.name, this.importance);
        notificationChannel.setBypassDnd(this.bypassDnd);
        notificationChannel.setShowBadge(this.showBadge);
        notificationChannel.enableLights(this.showLights);
        notificationChannel.enableVibration(this.shouldVibrate);
        notificationChannel.setDescription(this.description);
        notificationChannel.setGroup(this.group);
        notificationChannel.setLightColor(this.lightColor);
        notificationChannel.setVibrationPattern(this.vibrationPattern);
        notificationChannel.setLockscreenVisibility(this.lockscreenVisibility);
        notificationChannel.setSound(this.sound, Notification.AUDIO_ATTRIBUTES_DEFAULT);
        return notificationChannel;
    }

    public boolean getBypassDnd() {
        return this.bypassDnd;
    }

    public void setBypassDnd(boolean z) {
        this.bypassDnd = z;
    }

    public boolean getShowBadge() {
        return this.showBadge;
    }

    public void setShowBadge(boolean z) {
        this.showBadge = z;
    }

    public boolean shouldShowLights() {
        return this.showLights;
    }

    public void enableLights(boolean z) {
        this.showLights = z;
    }

    public boolean shouldVibrate() {
        return this.shouldVibrate;
    }

    public void enableVibration(boolean z) {
        this.shouldVibrate = z;
    }

    @Nullable
    public String getDescription() {
        return this.description;
    }

    public void setDescription(@Nullable String str) {
        this.description = str;
    }

    @Nullable
    public String getGroup() {
        return this.group;
    }

    public void setGroup(@Nullable String str) {
        this.group = str;
    }

    @NonNull
    public String getId() {
        return this.identifier;
    }

    public int getImportance() {
        return this.importance;
    }

    public void setImportance(int i) {
        this.importance = i;
    }

    public int getLightColor() {
        return this.lightColor;
    }

    public void setLightColor(int i) {
        this.lightColor = i;
    }

    public int getLockscreenVisibility() {
        return this.lockscreenVisibility;
    }

    public void setLockscreenVisibility(int i) {
        this.lockscreenVisibility = i;
    }

    @NonNull
    public CharSequence getName() {
        return this.name;
    }

    public void setName(@NonNull CharSequence charSequence) {
        this.name = charSequence;
    }

    @Nullable
    public Uri getSound() {
        return this.sound;
    }

    public void setSound(@Nullable Uri uri) {
        this.sound = uri;
    }

    @Nullable
    public long[] getVibrationPattern() {
        return this.vibrationPattern;
    }

    public void setVibrationPattern(@Nullable long[] jArr) {
        this.vibrationPattern = jArr;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        return JsonMap.newBuilder().putOpt("can_bypass_dnd", Boolean.valueOf(getBypassDnd())).putOpt("can_show_badge", Boolean.valueOf(getShowBadge())).putOpt("should_show_lights", Boolean.valueOf(shouldShowLights())).putOpt("should_vibrate", Boolean.valueOf(shouldVibrate())).putOpt("description", getDescription()).putOpt("group", getGroup()).putOpt("id", getId()).putOpt("importance", Integer.valueOf(getImportance())).putOpt("light_color", Integer.valueOf(getLightColor())).putOpt("lockscreen_visibility", Integer.valueOf(getLockscreenVisibility())).putOpt("name", getName().toString()).putOpt(TCVideoEventPropertiesNames.TCV_SOUND, getSound() != null ? getSound().toString() : null).putOpt("vibration_pattern", JsonValue.wrapOpt(getVibrationPattern())).build().getJsonValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NotificationChannelCompat notificationChannelCompat = (NotificationChannelCompat) obj;
        if (this.bypassDnd != notificationChannelCompat.bypassDnd || this.showBadge != notificationChannelCompat.showBadge || this.showLights != notificationChannelCompat.showLights || this.shouldVibrate != notificationChannelCompat.shouldVibrate || this.importance != notificationChannelCompat.importance || this.lightColor != notificationChannelCompat.lightColor || this.lockscreenVisibility != notificationChannelCompat.lockscreenVisibility) {
            return false;
        }
        String str = this.description;
        if (str == null ? notificationChannelCompat.description != null : !str.equals(notificationChannelCompat.description)) {
            return false;
        }
        String str2 = this.group;
        if (str2 == null ? notificationChannelCompat.group != null : !str2.equals(notificationChannelCompat.group)) {
            return false;
        }
        String str3 = this.identifier;
        if (str3 == null ? notificationChannelCompat.identifier != null : !str3.equals(notificationChannelCompat.identifier)) {
            return false;
        }
        CharSequence charSequence = this.name;
        if (charSequence == null ? notificationChannelCompat.name != null : !charSequence.equals(notificationChannelCompat.name)) {
            return false;
        }
        Uri uri = this.sound;
        if (uri == null ? notificationChannelCompat.sound == null : uri.equals(notificationChannelCompat.sound)) {
            return Arrays.equals(this.vibrationPattern, notificationChannelCompat.vibrationPattern);
        }
        return false;
    }

    public int hashCode() {
        int i = (((((((this.bypassDnd ? 1 : 0) * 31) + (this.showBadge ? 1 : 0)) * 31) + (this.showLights ? 1 : 0)) * 31) + (this.shouldVibrate ? 1 : 0)) * 31;
        String str = this.description;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.group;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.identifier;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        CharSequence charSequence = this.name;
        int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Uri uri = this.sound;
        return ((((((((iHashCode4 + (uri != null ? uri.hashCode() : 0)) * 31) + this.importance) * 31) + this.lightColor) * 31) + this.lockscreenVisibility) * 31) + Arrays.hashCode(this.vibrationPattern);
    }

    @NonNull
    public String toString() {
        return "NotificationChannelCompat{bypassDnd=" + this.bypassDnd + ", showBadge=" + this.showBadge + ", showLights=" + this.showLights + ", shouldVibrate=" + this.shouldVibrate + ", description='" + this.description + CoreConstants.SINGLE_QUOTE_CHAR + ", group='" + this.group + CoreConstants.SINGLE_QUOTE_CHAR + ", identifier='" + this.identifier + CoreConstants.SINGLE_QUOTE_CHAR + ", name=" + ((Object) this.name) + ", sound=" + this.sound + ", importance=" + this.importance + ", lightColor=" + this.lightColor + ", lockscreenVisibility=" + this.lockscreenVisibility + ", vibrationPattern=" + Arrays.toString(this.vibrationPattern) + '}';
    }

    @Nullable
    public static NotificationChannelCompat fromJson(@NonNull JsonValue jsonValue) {
        JsonMap map = jsonValue.getMap();
        if (map != null) {
            String string = map.opt("id").getString();
            String string2 = map.opt("name").getString();
            int i = map.opt("importance").getInt(-1);
            if (string != null && string2 != null && i != -1) {
                NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat(string, string2, i);
                notificationChannelCompat.setBypassDnd(map.opt("can_bypass_dnd").getBoolean(false));
                notificationChannelCompat.setShowBadge(map.opt("can_show_badge").getBoolean(true));
                notificationChannelCompat.enableLights(map.opt("should_show_lights").getBoolean(false));
                notificationChannelCompat.enableVibration(map.opt("should_vibrate").getBoolean(false));
                notificationChannelCompat.setDescription(map.opt("description").getString());
                notificationChannelCompat.setGroup(map.opt("group").getString());
                notificationChannelCompat.setLightColor(map.opt("light_color").getInt(0));
                notificationChannelCompat.setLockscreenVisibility(map.opt("lockscreen_visibility").getInt(-1000));
                notificationChannelCompat.setName(map.opt("name").optString());
                String string3 = map.opt(TCVideoEventPropertiesNames.TCV_SOUND).getString();
                if (!UAStringUtil.isEmpty(string3)) {
                    notificationChannelCompat.setSound(Uri.parse(string3));
                }
                JsonList list = map.opt("vibration_pattern").getList();
                if (list != null) {
                    long[] jArr = new long[list.size()];
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        jArr[i2] = list.get(i2).getLong(0L);
                    }
                    notificationChannelCompat.setVibrationPattern(jArr);
                }
                return notificationChannelCompat;
            }
        }
        UALog.e("Unable to deserialize notification channel: %s", jsonValue);
        return null;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static List<NotificationChannelCompat> fromXml(@NonNull Context context, @XmlRes int i) throws Resources.NotFoundException {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            try {
                return parseChannels(context, xml);
            } catch (Exception e) {
                UALog.e(e, "Failed to parse channels", new Object[0]);
                xml.close();
                return Collections.emptyList();
            }
        } finally {
            xml.close();
        }
    }

    private static List parseChannels(Context context, XmlResourceParser xmlResourceParser) {
        ArrayList arrayList = new ArrayList();
        while (1 != xmlResourceParser.next()) {
            if (2 == xmlResourceParser.getEventType() && "NotificationChannel".equals(xmlResourceParser.getName())) {
                AttributeSetConfigParser attributeSetConfigParser = new AttributeSetConfigParser(context, Xml.asAttributeSet(xmlResourceParser));
                String string = attributeSetConfigParser.getString("name");
                String string2 = attributeSetConfigParser.getString("id");
                int i = attributeSetConfigParser.getInt("importance", -1);
                if (UAStringUtil.isEmpty(string) || UAStringUtil.isEmpty(string2) || i == -1) {
                    UALog.e("Invalid notification channel. Missing name (%s), id (%s), or importance (%s)", string, string2, Integer.valueOf(i));
                } else {
                    NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat(string2, string, i);
                    notificationChannelCompat.setBypassDnd(attributeSetConfigParser.getBoolean("can_bypass_dnd", false));
                    notificationChannelCompat.setShowBadge(attributeSetConfigParser.getBoolean("can_show_badge", true));
                    notificationChannelCompat.enableLights(attributeSetConfigParser.getBoolean("should_show_lights", false));
                    notificationChannelCompat.enableVibration(attributeSetConfigParser.getBoolean("should_vibrate", false));
                    notificationChannelCompat.setDescription(attributeSetConfigParser.getString("description"));
                    notificationChannelCompat.setGroup(attributeSetConfigParser.getString("group"));
                    notificationChannelCompat.setLightColor(attributeSetConfigParser.getColor("light_color", 0));
                    notificationChannelCompat.setLockscreenVisibility(attributeSetConfigParser.getInt("lockscreen_visibility", -1000));
                    int rawResourceId = attributeSetConfigParser.getRawResourceId(TCVideoEventPropertiesNames.TCV_SOUND);
                    if (rawResourceId != 0) {
                        notificationChannelCompat.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + context.getResources().getResourceEntryName(rawResourceId)));
                    } else {
                        String string3 = attributeSetConfigParser.getString(TCVideoEventPropertiesNames.TCV_SOUND);
                        if (!UAStringUtil.isEmpty(string3)) {
                            notificationChannelCompat.setSound(Uri.parse(string3));
                        }
                    }
                    String string4 = attributeSetConfigParser.getString("vibration_pattern");
                    if (!UAStringUtil.isEmpty(string4)) {
                        String[] strArrSplit = string4.split(",");
                        long[] jArr = new long[strArrSplit.length];
                        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                            jArr[i2] = Long.parseLong(strArrSplit[i2]);
                        }
                        notificationChannelCompat.setVibrationPattern(jArr);
                    }
                    arrayList.add(notificationChannelCompat);
                }
            }
        }
        return arrayList;
    }
}
