package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012Jf\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\b\u0010+\u001a\u00020,H\u0016J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017¨\u0006."}, d2 = {"Lcom/urbanairship/android/framework/proxy/MessageCenterMessage;", "Lcom/urbanairship/json/JsonSerializable;", "message", "Lcom/urbanairship/messagecenter/Message;", "(Lcom/urbanairship/messagecenter/Message;)V", "title", "", "id", "sentDate", "", "listIconUrl", "isRead", "", "extras", "", "expirationDate", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/util/Map;Ljava/lang/Long;)V", "getExpirationDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "()Z", "getListIconUrl", "getSentDate", "()J", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ZLjava/util/Map;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/MessageCenterMessage;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MessageCenterMessage implements JsonSerializable {
    private final Long expirationDate;
    private final Map extras;
    private final String id;
    private final boolean isRead;
    private final String listIconUrl;
    private final long sentDate;
    private final String title;

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSentDate() {
        return this.sentDate;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getListIconUrl() {
        return this.listIconUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    @NotNull
    public final Map<String, String> component6() {
        return this.extras;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Long getExpirationDate() {
        return this.expirationDate;
    }

    @NotNull
    public final MessageCenterMessage copy(@NotNull String title, @NotNull String id, long sentDate, @Nullable String listIconUrl, boolean isRead, @NotNull Map<String, String> extras, @Nullable Long expirationDate) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return new MessageCenterMessage(title, id, sentDate, listIconUrl, isRead, extras, expirationDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageCenterMessage)) {
            return false;
        }
        MessageCenterMessage messageCenterMessage = (MessageCenterMessage) other;
        return Intrinsics.areEqual(this.title, messageCenterMessage.title) && Intrinsics.areEqual(this.id, messageCenterMessage.id) && this.sentDate == messageCenterMessage.sentDate && Intrinsics.areEqual(this.listIconUrl, messageCenterMessage.listIconUrl) && this.isRead == messageCenterMessage.isRead && Intrinsics.areEqual(this.extras, messageCenterMessage.extras) && Intrinsics.areEqual(this.expirationDate, messageCenterMessage.expirationDate);
    }

    public int hashCode() {
        int iHashCode = ((((this.title.hashCode() * 31) + this.id.hashCode()) * 31) + Long.hashCode(this.sentDate)) * 31;
        String str = this.listIconUrl;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isRead)) * 31) + this.extras.hashCode()) * 31;
        Long l = this.expirationDate;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MessageCenterMessage(title=" + this.title + ", id=" + this.id + ", sentDate=" + this.sentDate + ", listIconUrl=" + this.listIconUrl + ", isRead=" + this.isRead + ", extras=" + this.extras + ", expirationDate=" + this.expirationDate + ")";
    }

    public MessageCenterMessage(@NotNull String title, @NotNull String id, long j, @Nullable String str, boolean z, @NotNull Map<String, String> extras, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.title = title;
        this.id = id;
        this.sentDate = j;
        this.listIconUrl = str;
        this.isRead = z;
        this.extras = extras;
        this.expirationDate = l;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getSentDate() {
        return this.sentDate;
    }

    @Nullable
    public final String getListIconUrl() {
        return this.listIconUrl;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    @NotNull
    public final Map<String, String> getExtras() {
        return this.extras;
    }

    @Nullable
    public final Long getExpirationDate() {
        return this.expirationDate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MessageCenterMessage(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String title = message.getTitle();
        String id = message.getId();
        long time = message.getSentDate().getTime();
        String listIconUrl = message.getListIconUrl();
        boolean isRead = message.getIsRead();
        Map<String, String> extras = message.getExtras();
        Map<String, String> mapEmptyMap = extras == null ? MapsKt.emptyMap() : extras;
        Date expirationDate = message.getExpirationDate();
        this(title, id, time, listIconUrl, isRead, mapEmptyMap, expirationDate != null ? Long.valueOf(expirationDate.getTime()) : null);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().put("title", this.title).put("id", this.id).put("sentDate", this.sentDate).put("listIconUrl", this.listIconUrl).put("isRead", this.isRead).putOpt("extras", this.extras).putOpt("expirationDate", this.expirationDate).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
