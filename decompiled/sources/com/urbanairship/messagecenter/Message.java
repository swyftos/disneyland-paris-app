package com.urbanairship.messagecenter;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 I2\u00020\u0001:\u0001IB}\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0013J\b\u0010;\u001a\u00020<H\u0007J\t\u0010=\u001a\u00020>HÖ\u0001J\u0013\u0010?\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010AH\u0096\u0002J\b\u0010B\u001a\u00020>H\u0016J\b\u0010C\u001a\u00020<H\u0007J\b\u0010D\u001a\u00020<H\u0007J\u0019\u0010E\u001a\u00020<2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020>HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\u00020\n8F¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\"R\u001a\u0010\u0012\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%R\u0017\u0010&\u001a\u00020\n8F¢\u0006\f\u0012\u0004\b'\u0010!\u001a\u0004\b&\u0010\"R\u0017\u0010(\u001a\u00020\n¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b(\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\"R\u001a\u0010\u0011\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010%R#\u0010,\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b-\u0010!\u001a\u0004\b.\u0010\u0015R\u0014\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0015R\u0014\u0010\u0010\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0017R#\u00106\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b9\u00100\u0012\u0004\b7\u0010!\u001a\u0004\b8\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0015¨\u0006J"}, d2 = {"Lcom/urbanairship/messagecenter/Message;", "Landroid/os/Parcelable;", "id", "", "title", "bodyUrl", "sentDate", "Ljava/util/Date;", "expirationDate", "isUnread", "", "extras", "", "messageUrl", OneIDTrackerEvent.EVENT_PARAM_REPORTING, "Lcom/urbanairship/json/JsonValue;", "rawMessageJson", "isUnreadClient", "isDeletedClient", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;ZLjava/util/Map;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonValue;ZZ)V", "getBodyUrl", "()Ljava/lang/String;", "getExpirationDate", "()Ljava/util/Date;", "getExtras", "()Ljava/util/Map;", "getId", "inbox", "Lcom/urbanairship/messagecenter/Inbox;", "getInbox", "()Lcom/urbanairship/messagecenter/Inbox;", "isDeleted", "isDeleted$annotations", "()V", "()Z", "isDeletedClient$urbanairship_message_center_release", "setDeletedClient$urbanairship_message_center_release", "(Z)V", "isExpired", "isExpired$annotations", "isRead", "isRead$annotations", "isUnreadClient$urbanairship_message_center_release", "setUnreadClient$urbanairship_message_center_release", "listIconUrl", "getListIconUrl$annotations", "getListIconUrl", "listIconUrl$delegate", "Lkotlin/Lazy;", "getMessageUrl$urbanairship_message_center_release", "getRawMessageJson$urbanairship_message_center_release", "()Lcom/urbanairship/json/JsonValue;", "getReporting$urbanairship_message_center_release", "getSentDate", "subtitle", "getSubtitle$annotations", "getSubtitle", "subtitle$delegate", "getTitle", "delete", "", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "markRead", "markUnread", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Message implements Parcelable {

    @NotNull
    public static final String EXTRA_SUBTITLE = "com.urbanairship.listing.field1";

    @NotNull
    public static final String KEY_BODY_URL = "message_body_url";

    @NotNull
    public static final String KEY_EXPIRATION_DATE = "message_expiry";

    @NotNull
    public static final String KEY_EXTRAS = "extra";

    @NotNull
    public static final String KEY_ICONS = "icons";

    @NotNull
    public static final String KEY_ID = "message_id";

    @NotNull
    public static final String KEY_IS_UNREAD = "unread";

    @NotNull
    public static final String KEY_LIST_ICON = "list_icon";

    @NotNull
    public static final String KEY_MESSAGE_READ_URL = "message_read_url";

    @NotNull
    public static final String KEY_MESSAGE_REPORTING = "message_reporting";

    @NotNull
    public static final String KEY_MESSAGE_URL = "message_url";

    @NotNull
    public static final String KEY_SENT_DATE = "message_sent";

    @NotNull
    public static final String KEY_TITLE = "title";
    private final String bodyUrl;
    private final Date expirationDate;
    private final Map extras;
    private final String id;
    private boolean isDeletedClient;
    private final boolean isRead;
    private final boolean isUnread;
    private boolean isUnreadClient;

    /* renamed from: listIconUrl$delegate, reason: from kotlin metadata */
    private final Lazy listIconUrl;
    private final String messageUrl;
    private final JsonValue rawMessageJson;
    private final JsonValue reporting;
    private final Date sentDate;

    /* renamed from: subtitle$delegate, reason: from kotlin metadata */
    private final Lazy subtitle;
    private final String title;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<Message> CREATOR = new Creator();
    private static final Comparator SENT_DATE_COMPARATOR = new Comparator() { // from class: com.urbanairship.messagecenter.Message$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Message.SENT_DATE_COMPARATOR$lambda$0((Message) obj, (Message) obj2);
        }
    };

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Message> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Message createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Date date = (Date) parcel.readSerializable();
            Date date2 = (Date) parcel.readSerializable();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(i);
                for (int i2 = 0; i2 != i; i2++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readString());
                }
                linkedHashMap = linkedHashMap2;
            }
            return new Message(string, string2, string3, date, date2, z, linkedHashMap, parcel.readString(), (JsonValue) parcel.readParcelable(Message.class.getClassLoader()), (JsonValue) parcel.readParcelable(Message.class.getClassLoader()), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Message[] newArray(int i) {
            return new Message[i];
        }
    }

    public static /* synthetic */ void getListIconUrl$annotations() {
    }

    @NotNull
    public static final Comparator<Message> getSENT_DATE_COMPARATOR() {
        return INSTANCE.getSENT_DATE_COMPARATOR();
    }

    public static /* synthetic */ void getSubtitle$annotations() {
    }

    public static /* synthetic */ void isDeleted$annotations() {
    }

    public static /* synthetic */ void isExpired$annotations() {
    }

    public static /* synthetic */ void isRead$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.bodyUrl);
        parcel.writeSerializable(this.sentDate);
        parcel.writeSerializable(this.expirationDate);
        parcel.writeInt(this.isUnread ? 1 : 0);
        Map map = this.extras;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry entry : map.entrySet()) {
                parcel.writeString((String) entry.getKey());
                parcel.writeString((String) entry.getValue());
            }
        }
        parcel.writeString(this.messageUrl);
        parcel.writeParcelable(this.reporting, flags);
        parcel.writeParcelable(this.rawMessageJson, flags);
        parcel.writeInt(this.isUnreadClient ? 1 : 0);
        parcel.writeInt(this.isDeletedClient ? 1 : 0);
    }

    public Message(@NotNull String id, @NotNull String title, @NotNull String bodyUrl, @NotNull Date sentDate, @Nullable Date date, boolean z, @Nullable Map<String, String> map, @NotNull String messageUrl, @Nullable JsonValue jsonValue, @NotNull JsonValue rawMessageJson, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bodyUrl, "bodyUrl");
        Intrinsics.checkNotNullParameter(sentDate, "sentDate");
        Intrinsics.checkNotNullParameter(messageUrl, "messageUrl");
        Intrinsics.checkNotNullParameter(rawMessageJson, "rawMessageJson");
        this.id = id;
        this.title = title;
        this.bodyUrl = bodyUrl;
        this.sentDate = sentDate;
        this.expirationDate = date;
        this.isUnread = z;
        this.extras = map;
        this.messageUrl = messageUrl;
        this.reporting = jsonValue;
        this.rawMessageJson = rawMessageJson;
        this.isUnreadClient = z2;
        this.isDeletedClient = z3;
        this.isRead = !z2;
        this.listIconUrl = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.Message$listIconUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() throws JsonException {
                JsonValue jsonValue2;
                String strOptString;
                try {
                    JsonMap jsonMapOptMap = this.this$0.getRawMessageJson().optMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                    JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(jsonMapOptMap, Message.KEY_ICONS);
                    if (jsonMapOptionalMap != null && (jsonValue2 = jsonMapOptionalMap.get(Message.KEY_LIST_ICON)) != null) {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString = jsonValue2.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString = (String) jsonValue2.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString = (String) jsonValue2.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + Message.KEY_LIST_ICON + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString = (String) jsonValue2.toJsonValue();
                        }
                        return strOptString;
                    }
                    return null;
                } catch (Exception e) {
                    UALog.w(e, "Failed to get Message Center Message list icon!", new Object[0]);
                    return null;
                }
            }
        });
        this.subtitle = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.Message$subtitle$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Map<String, String> extras = this.this$0.getExtras();
                if (extras != null) {
                    return extras.get(Message.EXTRA_SUBTITLE);
                }
                return null;
            }
        });
    }

    public /* synthetic */ Message(String str, String str2, String str3, Date date, Date date2, boolean z, Map map, String str4, JsonValue jsonValue, JsonValue jsonValue2, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, date, date2, z, map, str4, jsonValue, jsonValue2, (i & 1024) != 0 ? z : z2, z3);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getBodyUrl() {
        return this.bodyUrl;
    }

    @NotNull
    public final Date getSentDate() {
        return this.sentDate;
    }

    @Nullable
    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    /* renamed from: isUnread, reason: from getter */
    public final boolean getIsUnread() {
        return this.isUnread;
    }

    @Nullable
    public final Map<String, String> getExtras() {
        return this.extras;
    }

    @NotNull
    /* renamed from: getMessageUrl$urbanairship_message_center_release, reason: from getter */
    public final String getMessageUrl() {
        return this.messageUrl;
    }

    @Nullable
    /* renamed from: getReporting$urbanairship_message_center_release, reason: from getter */
    public final JsonValue getReporting() {
        return this.reporting;
    }

    @NotNull
    /* renamed from: getRawMessageJson$urbanairship_message_center_release, reason: from getter */
    public final JsonValue getRawMessageJson() {
        return this.rawMessageJson;
    }

    /* renamed from: isUnreadClient$urbanairship_message_center_release, reason: from getter */
    public final boolean getIsUnreadClient() {
        return this.isUnreadClient;
    }

    public final void setUnreadClient$urbanairship_message_center_release(boolean z) {
        this.isUnreadClient = z;
    }

    public final boolean isDeletedClient$urbanairship_message_center_release() {
        return this.isDeletedClient;
    }

    public final void setDeletedClient$urbanairship_message_center_release(boolean z) {
        this.isDeletedClient = z;
    }

    /* renamed from: isRead, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    public final boolean isExpired() {
        Date date = this.expirationDate;
        if (date != null) {
            return date.before(new Date());
        }
        return false;
    }

    /* renamed from: isDeleted, reason: from getter */
    public final boolean getIsDeletedClient() {
        return this.isDeletedClient;
    }

    @Nullable
    public final String getListIconUrl() {
        return (String) this.listIconUrl.getValue();
    }

    @Nullable
    public final String getSubtitle() {
        return (String) this.subtitle.getValue();
    }

    private final Inbox getInbox() {
        return MessageCenter.INSTANCE.shared().getInbox();
    }

    @Deprecated(message = "Replace with Inbox.markMessagesRead(message.id, ...)", replaceWith = @ReplaceWith(expression = "MessageCenter.shared().inbox.markMessagesRead(message.id)", imports = {}))
    public final void markRead() {
        if (this.isUnreadClient) {
            this.isUnreadClient = false;
            getInbox().markMessagesRead(this.id);
        }
    }

    @Deprecated(message = "Replace with Inbox.markMessagesUnread(message.id, ...)", replaceWith = @ReplaceWith(expression = "MessageCenter.shared().inbox.markMessagesUnread(message.id)", imports = {}))
    public final void markUnread() {
        if (this.isUnreadClient) {
            return;
        }
        this.isUnreadClient = true;
        getInbox().markMessagesRead(this.id);
    }

    @Deprecated(message = "Replace with Inbox.deleteMessages(message.id, ...)", replaceWith = @ReplaceWith(expression = "MessageCenter.shared().inbox.deleteMessages(message.id)", imports = {}))
    public final void delete() {
        if (this.isDeletedClient) {
            return;
        }
        this.isDeletedClient = true;
        getInbox().deleteMessages(this.id);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Message.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.messagecenter.Message");
        Message message = (Message) other;
        return Intrinsics.areEqual(this.id, message.id) && Intrinsics.areEqual(this.title, message.title) && Intrinsics.areEqual(this.extras, message.extras) && Intrinsics.areEqual(this.bodyUrl, message.bodyUrl) && Intrinsics.areEqual(this.sentDate, message.sentDate) && Intrinsics.areEqual(this.expirationDate, message.expirationDate) && this.isUnread == message.isUnread && Intrinsics.areEqual(this.messageUrl, message.messageUrl) && Intrinsics.areEqual(this.reporting, message.reporting) && Intrinsics.areEqual(this.rawMessageJson, message.rawMessageJson) && this.isUnreadClient == message.isUnreadClient && this.isDeletedClient == message.isDeletedClient && this.isRead == message.isRead;
    }

    public int hashCode() {
        return Objects.hash(this.id, this.title, this.extras, this.bodyUrl, this.sentDate, this.expirationDate, Boolean.valueOf(this.isUnread), this.messageUrl, this.reporting, this.rawMessageJson, Boolean.valueOf(this.isUnreadClient), Boolean.valueOf(this.isDeletedClient), Boolean.valueOf(this.isRead));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R,\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/messagecenter/Message$Companion;", "", "()V", "EXTRA_SUBTITLE", "", "KEY_BODY_URL", "KEY_EXPIRATION_DATE", "KEY_EXTRAS", "KEY_ICONS", "KEY_ID", "KEY_IS_UNREAD", "KEY_LIST_ICON", "KEY_MESSAGE_READ_URL", "KEY_MESSAGE_REPORTING", "KEY_MESSAGE_URL", "KEY_SENT_DATE", "KEY_TITLE", "SENT_DATE_COMPARATOR", "Ljava/util/Comparator;", "Lcom/urbanairship/messagecenter/Message;", "Lkotlin/Comparator;", "getSENT_DATE_COMPARATOR$annotations", "getSENT_DATE_COMPARATOR", "()Ljava/util/Comparator;", "create", "payload", "Lcom/urbanairship/json/JsonValue;", "isUnreadClient", "", "isDeleted", "create$urbanairship_message_center_release", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Message.kt\ncom/urbanairship/messagecenter/Message$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,206:1\n44#2,15:207\n44#2,15:222\n44#2,15:243\n79#2,16:258\n79#2,16:275\n79#2,16:291\n44#2,15:307\n453#3:237\n403#3:238\n1238#4,4:239\n1#5:274\n*S KotlinDebug\n*F\n+ 1 Message.kt\ncom/urbanairship/messagecenter/Message$Companion\n*L\n175#1:207,15\n176#1:222,15\n178#1:243,15\n179#1:258,16\n181#1:275,16\n183#1:291,16\n184#1:307,15\n177#1:237\n177#1:238\n177#1:239,4\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSENT_DATE_COMPARATOR$annotations() {
        }

        private Companion() {
        }

        @Nullable
        public final Message create$urbanairship_message_center_release(@NotNull JsonValue payload, boolean isUnreadClient, boolean isDeleted) throws JsonException {
            String strOptString;
            String strOptString2;
            LinkedHashMap linkedHashMap;
            String strOptString3;
            String strOptString4;
            String strOptString5;
            Boolean boolValueOf;
            String strOptString6;
            Map<String, JsonValue> map;
            Intrinsics.checkNotNullParameter(payload, "payload");
            try {
                JsonMap jsonMapRequireMap = payload.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("message_id");
                if (jsonValue == null) {
                    throw new JsonException("Missing required field: 'message_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'message_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.toJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
                String str = strOptString;
                JsonValue jsonValue3 = jsonMapRequireMap.get("title");
                if (jsonValue3 == null) {
                    throw new JsonException("Missing required field: 'title" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString2 = jsonValue3.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue3.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList2 = jsonValue3.optList();
                    if (objOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap2 = jsonValue3.optMap();
                    if (objOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'title" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue4 = jsonValue3.toJsonValue();
                    if (jsonValue4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) jsonValue4;
                }
                String str2 = strOptString2;
                JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(jsonMapRequireMap, Message.KEY_EXTRAS);
                if (jsonMapOptionalMap == null || (map = jsonMapOptionalMap.getMap()) == null) {
                    linkedHashMap = null;
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                    for (Object obj : map.entrySet()) {
                        linkedHashMap2.put(((Map.Entry) obj).getKey(), ((JsonValue) ((Map.Entry) obj).getValue()).coerceString());
                    }
                    linkedHashMap = linkedHashMap2;
                }
                JsonValue jsonValue5 = jsonMapRequireMap.get(Message.KEY_BODY_URL);
                if (jsonValue5 == null) {
                    throw new JsonException("Missing required field: '" + Message.KEY_BODY_URL + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString3 = jsonValue5.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString3 = jsonValue5.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString3 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString3 = (String) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString3 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString3 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString3 = (String) Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList3 = jsonValue5.optList();
                    if (objOptList3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString3 = (String) objOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap3 = jsonValue5.optMap();
                    if (objOptMap3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString3 = (String) objOptMap3;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + Message.KEY_BODY_URL + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue6 = jsonValue5.toJsonValue();
                    if (jsonValue6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString3 = (String) jsonValue6;
                }
                String str3 = strOptString3;
                JsonValue jsonValue7 = jsonMapRequireMap.get(Message.KEY_SENT_DATE);
                if (jsonValue7 == null) {
                    strOptString4 = null;
                } else {
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString4 = jsonValue7.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString4 = jsonValue7.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString4 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString4 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList4 = jsonValue7.optList();
                        if (objOptList4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) objOptList4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap4 = jsonValue7.optMap();
                        if (objOptMap4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) objOptMap4;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + Message.KEY_SENT_DATE + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue8 = jsonValue7.toJsonValue();
                        if (jsonValue8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) jsonValue8;
                    }
                }
                Date date = strOptString4 != null ? new Date(DateUtils.parseIso8601(strOptString4)) : new Date();
                JsonValue jsonValue9 = jsonMapRequireMap.get(Message.KEY_EXPIRATION_DATE);
                if (jsonValue9 == null) {
                    strOptString5 = null;
                } else {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString5 = jsonValue9.optString();
                        if (strOptString5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString5 = jsonValue9.optString();
                        if (strOptString5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString5 = (String) Boolean.valueOf(jsonValue9.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString5 = (String) Long.valueOf(jsonValue9.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString5 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString5 = (String) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString5 = (String) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString5 = (String) Integer.valueOf(jsonValue9.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString5 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList5 = jsonValue9.optList();
                        if (objOptList5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString5 = (String) objOptList5;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap5 = jsonValue9.optMap();
                        if (objOptMap5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString5 = (String) objOptMap5;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + Message.KEY_EXPIRATION_DATE + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue10 = jsonValue9.toJsonValue();
                        if (jsonValue10 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString5 = (String) jsonValue10;
                    }
                }
                Date date2 = strOptString5 != null ? new Date(DateUtils.parseIso8601(strOptString5, Long.MAX_VALUE)) : null;
                JsonValue jsonValue11 = jsonMapRequireMap.get(Message.KEY_IS_UNREAD);
                if (jsonValue11 == null) {
                    boolValueOf = null;
                } else {
                    KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        boolValueOf = (Boolean) jsonValue11.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(jsonValue11.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        boolValueOf = (Boolean) Long.valueOf(jsonValue11.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue11.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        boolValueOf = (Boolean) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        boolValueOf = (Boolean) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        boolValueOf = (Boolean) Integer.valueOf(jsonValue11.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue11.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        boolValueOf = (Boolean) jsonValue11.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        boolValueOf = (Boolean) jsonValue11.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field '" + Message.KEY_IS_UNREAD + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        boolValueOf = (Boolean) jsonValue11.toJsonValue();
                    }
                }
                boolean zBooleanValue = boolValueOf != null ? boolValueOf.booleanValue() : false;
                JsonValue jsonValue12 = jsonMapRequireMap.get(Message.KEY_MESSAGE_URL);
                if (jsonValue12 == null) {
                    throw new JsonException("Missing required field: '" + Message.KEY_MESSAGE_URL + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString6 = jsonValue12.optString();
                    if (strOptString6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString6 = jsonValue12.optString();
                    if (strOptString6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString6 = (String) Boolean.valueOf(jsonValue12.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString6 = (String) Long.valueOf(jsonValue12.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString6 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue12.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString6 = (String) Double.valueOf(jsonValue12.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString6 = (String) Float.valueOf(jsonValue12.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString6 = (String) Integer.valueOf(jsonValue12.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString6 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue12.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList6 = jsonValue12.optList();
                    if (objOptList6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString6 = (String) objOptList6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap6 = jsonValue12.optMap();
                    if (objOptMap6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString6 = (String) objOptMap6;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + Message.KEY_MESSAGE_URL + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue13 = jsonValue12.toJsonValue();
                    if (jsonValue13 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString6 = (String) jsonValue13;
                }
                String str4 = strOptString6;
                JsonValue jsonValue14 = jsonMapRequireMap.get(Message.KEY_MESSAGE_REPORTING);
                JsonValue jsonValue15 = jsonMapRequireMap.toJsonValue();
                Intrinsics.checkNotNull(jsonValue15);
                return new Message(str, str2, str3, date, date2, zBooleanValue, linkedHashMap, str4, jsonValue14, jsonValue15, isUnreadClient, isDeleted);
            } catch (Exception e) {
                UALog.e(e, "Failed to create message from payload: " + payload, new Object[0]);
                return null;
            }
        }

        @NotNull
        public final Comparator<Message> getSENT_DATE_COMPARATOR() {
            return Message.SENT_DATE_COMPARATOR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SENT_DATE_COMPARATOR$lambda$0(Message message, Message message2) {
        if (Intrinsics.areEqual(message2.sentDate, message.sentDate)) {
            return message.id.compareTo(message2.id);
        }
        return message2.sentDate.compareTo(message.sentDate);
    }
}
