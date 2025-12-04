package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/framework/proxy/NotificationConfig;", "Lcom/urbanairship/json/JsonSerializable;", "config", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "icon", "", "largeIcon", "accentColor", "defaultChannelId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccentColor", "()Ljava/lang/String;", "getDefaultChannelId", "getIcon", "getLargeIcon", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NotificationConfig implements JsonSerializable {
    private final String accentColor;
    private final String defaultChannelId;
    private final String icon;
    private final String largeIcon;

    public static /* synthetic */ NotificationConfig copy$default(NotificationConfig notificationConfig, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationConfig.icon;
        }
        if ((i & 2) != 0) {
            str2 = notificationConfig.largeIcon;
        }
        if ((i & 4) != 0) {
            str3 = notificationConfig.accentColor;
        }
        if ((i & 8) != 0) {
            str4 = notificationConfig.defaultChannelId;
        }
        return notificationConfig.copy(str, str2, str3, str4);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getLargeIcon() {
        return this.largeIcon;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAccentColor() {
        return this.accentColor;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getDefaultChannelId() {
        return this.defaultChannelId;
    }

    @NotNull
    public final NotificationConfig copy(@Nullable String icon, @Nullable String largeIcon, @Nullable String accentColor, @Nullable String defaultChannelId) {
        return new NotificationConfig(icon, largeIcon, accentColor, defaultChannelId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationConfig)) {
            return false;
        }
        NotificationConfig notificationConfig = (NotificationConfig) other;
        return Intrinsics.areEqual(this.icon, notificationConfig.icon) && Intrinsics.areEqual(this.largeIcon, notificationConfig.largeIcon) && Intrinsics.areEqual(this.accentColor, notificationConfig.accentColor) && Intrinsics.areEqual(this.defaultChannelId, notificationConfig.defaultChannelId);
    }

    public int hashCode() {
        String str = this.icon;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.largeIcon;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accentColor;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.defaultChannelId;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NotificationConfig(icon=" + this.icon + ", largeIcon=" + this.largeIcon + ", accentColor=" + this.accentColor + ", defaultChannelId=" + this.defaultChannelId + ")";
    }

    public NotificationConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.icon = str;
        this.largeIcon = str2;
        this.accentColor = str3;
        this.defaultChannelId = str4;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getLargeIcon() {
        return this.largeIcon;
    }

    @Nullable
    public final String getAccentColor() {
        return this.accentColor;
    }

    @Nullable
    public final String getDefaultChannelId() {
        return this.defaultChannelId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NotificationConfig(@NotNull JsonMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        JsonValue jsonValue = config.get("icon");
        String string = jsonValue != null ? jsonValue.getString() : null;
        JsonValue jsonValue2 = config.get("largeIcon");
        String string2 = jsonValue2 != null ? jsonValue2.getString() : null;
        JsonValue jsonValue3 = config.get("accentColor");
        String string3 = jsonValue3 != null ? jsonValue3.getString() : null;
        JsonValue jsonValue4 = config.get("defaultChannelId");
        this(string, string2, string3, jsonValue4 != null ? jsonValue4.getString() : null);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().putOpt("icon", this.icon).putOpt("largeIcon", this.largeIcon).putOpt("accentColor", this.accentColor).putOpt("defaultChannelId", this.defaultChannelId).build().toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
