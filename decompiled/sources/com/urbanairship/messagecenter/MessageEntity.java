package com.urbanairship.messagecenter;

import androidx.room.Entity;
import androidx.room.Index;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(indices = {@Index(unique = true, value = {"message_id"}), @Index({Message.KEY_IS_UNREAD}), @Index({"deleted"}), @Index({"expiration_timestamp"})}, tableName = "richpush")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 =2\u00020\u0001:\u0001=B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\fHÆ\u0003J\u0099\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\b\u0010:\u001a\u0004\u0018\u00010;J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0014R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014¨\u0006>"}, d2 = {"Lcom/urbanairship/messagecenter/MessageEntity;", "", "id", "", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "messageUrl", "messageBodyUrl", "messageReadUrl", "title", Message.KEY_EXTRAS, Message.KEY_IS_UNREAD, "", "unreadOrig", "deleted", "timestamp", "rawMessageObject", "expirationTimestamp", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeleted", "()Z", "getExpirationTimestamp", "()Ljava/lang/String;", "getExtra", "getId", "()I", "getMessageBodyUrl", "getMessageId", "getMessageReadUrl", "messageReporting", "Lcom/urbanairship/json/JsonValue;", "getMessageReporting", "()Lcom/urbanairship/json/JsonValue;", "messageReporting$delegate", "Lkotlin/Lazy;", "getMessageUrl", "getRawMessageObject", "getTimestamp", "getTitle", "getUnread", "getUnreadOrig", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toMessage", "Lcom/urbanairship/messagecenter/Message;", "toString", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MessageEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean deleted;
    private final String expirationTimestamp;
    private final String extra;
    private final int id;
    private final String messageBodyUrl;
    private final String messageId;
    private final String messageReadUrl;

    /* renamed from: messageReporting$delegate, reason: from kotlin metadata */
    private final Lazy messageReporting;
    private final String messageUrl;
    private final String rawMessageObject;
    private final String timestamp;
    private final String title;
    private final boolean unread;
    private final boolean unreadOrig;

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getDeleted() {
        return this.deleted;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    /* renamed from: component12, reason: from getter */
    public final String getRawMessageObject() {
        return this.rawMessageObject;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMessageUrl() {
        return this.messageUrl;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getMessageBodyUrl() {
        return this.messageBodyUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getMessageReadUrl() {
        return this.messageReadUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getUnread() {
        return this.unread;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getUnreadOrig() {
        return this.unreadOrig;
    }

    @NotNull
    public final MessageEntity copy(int id, @NotNull String messageId, @Nullable String messageUrl, @Nullable String messageBodyUrl, @Nullable String messageReadUrl, @Nullable String title, @Nullable String extra, boolean unread, boolean unreadOrig, boolean deleted, @Nullable String timestamp, @NotNull String rawMessageObject, @Nullable String expirationTimestamp) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(rawMessageObject, "rawMessageObject");
        return new MessageEntity(id, messageId, messageUrl, messageBodyUrl, messageReadUrl, title, extra, unread, unreadOrig, deleted, timestamp, rawMessageObject, expirationTimestamp);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntity)) {
            return false;
        }
        MessageEntity messageEntity = (MessageEntity) other;
        return this.id == messageEntity.id && Intrinsics.areEqual(this.messageId, messageEntity.messageId) && Intrinsics.areEqual(this.messageUrl, messageEntity.messageUrl) && Intrinsics.areEqual(this.messageBodyUrl, messageEntity.messageBodyUrl) && Intrinsics.areEqual(this.messageReadUrl, messageEntity.messageReadUrl) && Intrinsics.areEqual(this.title, messageEntity.title) && Intrinsics.areEqual(this.extra, messageEntity.extra) && this.unread == messageEntity.unread && this.unreadOrig == messageEntity.unreadOrig && this.deleted == messageEntity.deleted && Intrinsics.areEqual(this.timestamp, messageEntity.timestamp) && Intrinsics.areEqual(this.rawMessageObject, messageEntity.rawMessageObject) && Intrinsics.areEqual(this.expirationTimestamp, messageEntity.expirationTimestamp);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.id) * 31) + this.messageId.hashCode()) * 31;
        String str = this.messageUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.messageBodyUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.messageReadUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.extra;
        int iHashCode6 = (((((((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Boolean.hashCode(this.unread)) * 31) + Boolean.hashCode(this.unreadOrig)) * 31) + Boolean.hashCode(this.deleted)) * 31;
        String str6 = this.timestamp;
        int iHashCode7 = (((iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.rawMessageObject.hashCode()) * 31;
        String str7 = this.expirationTimestamp;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "MessageEntity(id=" + this.id + ", messageId=" + this.messageId + ", messageUrl=" + this.messageUrl + ", messageBodyUrl=" + this.messageBodyUrl + ", messageReadUrl=" + this.messageReadUrl + ", title=" + this.title + ", extra=" + this.extra + ", unread=" + this.unread + ", unreadOrig=" + this.unreadOrig + ", deleted=" + this.deleted + ", timestamp=" + this.timestamp + ", rawMessageObject=" + this.rawMessageObject + ", expirationTimestamp=" + this.expirationTimestamp + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MessageEntity(int i, @NotNull String messageId, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, boolean z, boolean z2, boolean z3, @Nullable String str6, @NotNull String rawMessageObject, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(rawMessageObject, "rawMessageObject");
        this.id = i;
        this.messageId = messageId;
        this.messageUrl = str;
        this.messageBodyUrl = str2;
        this.messageReadUrl = str3;
        this.title = str4;
        this.extra = str5;
        this.unread = z;
        this.unreadOrig = z2;
        this.deleted = z3;
        this.timestamp = str6;
        this.rawMessageObject = rawMessageObject;
        this.expirationTimestamp = str7;
        this.messageReporting = LazyKt.lazy(new Function0() { // from class: com.urbanairship.messagecenter.MessageEntity$messageReporting$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final JsonValue invoke() {
                try {
                    JsonMap map = JsonValue.parseString(this.this$0.getRawMessageObject()).getMap();
                    if (map != null) {
                        return map.get(Message.KEY_MESSAGE_REPORTING);
                    }
                    return null;
                } catch (JsonException e) {
                    UALog.e(e, new Function0() { // from class: com.urbanairship.messagecenter.MessageEntity$messageReporting$2.2
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "MessageEntity - Failed to parse Message reporting.";
                        }
                    });
                    return null;
                }
            }
        });
    }

    public /* synthetic */ MessageEntity(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, String str8, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, str, str2, str3, str4, str5, str6, z, z2, z3, str7, str8, str9);
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getMessageId() {
        return this.messageId;
    }

    @Nullable
    public final String getMessageUrl() {
        return this.messageUrl;
    }

    @Nullable
    public final String getMessageBodyUrl() {
        return this.messageBodyUrl;
    }

    @Nullable
    public final String getMessageReadUrl() {
        return this.messageReadUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getExtra() {
        return this.extra;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    public final boolean getUnreadOrig() {
        return this.unreadOrig;
    }

    public final boolean getDeleted() {
        return this.deleted;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getRawMessageObject() {
        return this.rawMessageObject;
    }

    @Nullable
    public final String getExpirationTimestamp() {
        return this.expirationTimestamp;
    }

    @Nullable
    public final JsonValue getMessageReporting() {
        return (JsonValue) this.messageReporting.getValue();
    }

    @Nullable
    public final Message toMessage() {
        try {
            Message.Companion companion = Message.INSTANCE;
            JsonValue string = JsonValue.parseString(this.rawMessageObject);
            Intrinsics.checkNotNullExpressionValue(string, "parseString(...)");
            return companion.create$urbanairship_message_center_release(string, this.unread, this.deleted);
        } catch (JsonException e) {
            UALog.e(e, new Function0() { // from class: com.urbanairship.messagecenter.MessageEntity.toMessage.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to create Message from JSON";
                }
            });
            return null;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/messagecenter/MessageEntity$Companion;", "", "()V", "createMessageFromPayload", "Lcom/urbanairship/messagecenter/MessageEntity;", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "", "messagePayload", "Lcom/urbanairship/json/JsonMap;", "payload", "Lcom/urbanairship/json/JsonValue;", "createMessagesFromPayload", "", "messagePayloads", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final MessageEntity createMessageFromPayload(@Nullable String messageId, @NotNull JsonValue payload) throws JsonException {
            Intrinsics.checkNotNullParameter(payload, "payload");
            JsonMap jsonMapOptMap = payload.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            return createMessageFromPayload(messageId, jsonMapOptMap);
        }

        @Nullable
        public final MessageEntity createMessageFromPayload(@Nullable String messageId, @NotNull final JsonMap messagePayload) throws JsonException {
            String str;
            Intrinsics.checkNotNullParameter(messagePayload, "messagePayload");
            if (UAStringUtil.isEmpty(messagePayload.opt("message_id").getString())) {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.messagecenter.MessageEntity$Companion$createMessageFromPayload$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "MessageEntity - Message is missing an ID: " + messagePayload;
                    }
                }, 1, null);
                return null;
            }
            if (messageId == null) {
                String strRequireString = messagePayload.opt("message_id").requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                str = strRequireString;
            } else {
                str = messageId;
            }
            String string = messagePayload.opt(Message.KEY_MESSAGE_URL).getString();
            String string2 = messagePayload.opt(Message.KEY_BODY_URL).getString();
            String string3 = messagePayload.opt(Message.KEY_MESSAGE_READ_URL).getString();
            String string4 = messagePayload.opt("title").getString();
            String string5 = messagePayload.opt(Message.KEY_EXTRAS).getString();
            boolean z = messagePayload.opt(Message.KEY_IS_UNREAD).getBoolean(true);
            boolean z2 = messagePayload.opt(Message.KEY_IS_UNREAD).getBoolean(true);
            String string6 = messagePayload.opt(Message.KEY_SENT_DATE).getString();
            String string7 = messagePayload.toString();
            Intrinsics.checkNotNullExpressionValue(string7, "toString(...)");
            return new MessageEntity(0, str, string, string2, string3, string4, string5, z, z2, false, string6, string7, messagePayload.opt(Message.KEY_EXPIRATION_DATE).getString(), 1, null);
        }

        @NotNull
        public final List<MessageEntity> createMessagesFromPayload(@NotNull List<? extends JsonValue> messagePayloads) throws JsonException {
            Intrinsics.checkNotNullParameter(messagePayloads, "messagePayloads");
            ArrayList arrayList = new ArrayList();
            Iterator<? extends JsonValue> it = messagePayloads.iterator();
            while (it.hasNext()) {
                MessageEntity messageEntityCreateMessageFromPayload = createMessageFromPayload((String) null, it.next());
                if (messageEntityCreateMessageFromPayload != null) {
                    arrayList.add(messageEntityCreateMessageFromPayload);
                }
            }
            return arrayList;
        }
    }
}
