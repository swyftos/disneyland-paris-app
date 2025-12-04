package com.urbanairship.contacts;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import com.urbanairship.contacts.ChannelType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "isRegistered", "", "()Z", "maskedAddress", "", "getMaskedAddress", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Email", "Sms", "Lcom/urbanairship/contacts/ContactChannel$Email;", "Lcom/urbanairship/contacts/ContactChannel$Sms;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ContactChannel implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ContactChannel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract ChannelType getChannelType();

    @NotNull
    public abstract String getMaskedAddress();

    public abstract boolean isRegistered();

    private ContactChannel() {
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() throws JsonException {
        Object registrationInfo;
        Pair pair = TuplesKt.to("type", getChannelType().name());
        if (this instanceof Sms) {
            registrationInfo = ((Sms) this).getRegistrationInfo();
        } else {
            if (!(this instanceof Email)) {
                throw new NoWhenBranchMatchedException();
            }
            registrationInfo = ((Email) this).getRegistrationInfo();
        }
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, TuplesKt.to(OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, registrationInfo)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Companion;", "", "()V", "ADDRESS_KEY", "", "CHANNEL_ID_KEY", "COMMERCIAL_OPTED_IN_KEY", "COMMERCIAL_OPTED_OUT_KEY", "INFO_KEY", "OPTIONS_KEY", "OPT_IN_KEY", "PENDING_TYPE", "REGISTERED_TYPE", "SENDER_ID_KEY", "TRANSACTIONAL_OPTED_IN_KEY", "TRANSACTIONAL_OPTED_OUT_KEY", ContactOperation.TYPE_KEY, "fromJson", "Lcom/urbanairship/contacts/ContactChannel;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ChannelType.values().length];
                try {
                    iArr[ChannelType.SMS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ChannelType.EMAIL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ContactChannel fromJson(@NotNull JsonValue jsonValue) throws JsonException {
            Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
            JsonMap jsonMapRequireMap = jsonValue.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            ChannelType.Companion companion = ChannelType.INSTANCE;
            JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            ChannelType channelTypeFromJson = companion.fromJson(jsonValueRequire);
            int i = WhenMappings.$EnumSwitchMapping$0[channelTypeFromJson.ordinal()];
            if (i == 1) {
                Sms.RegistrationInfo.Companion companion2 = Sms.RegistrationInfo.INSTANCE;
                JsonValue jsonValueRequire2 = jsonMapRequireMap.require(OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO);
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                return new Sms(companion2.fromJson(jsonValueRequire2));
            }
            if (i == 2) {
                Email.RegistrationInfo.Companion companion3 = Email.RegistrationInfo.INSTANCE;
                JsonValue jsonValueRequire3 = jsonMapRequireMap.require(OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO);
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire3, "require(...)");
                return new Email(companion3.fromJson(jsonValueRequire3));
            }
            throw new JsonException("unexpected type " + channelTypeFromJson);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms;", "Lcom/urbanairship/contacts/ContactChannel;", "registrationInfo", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "(Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;)V", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "isRegistered", "", "()Z", "maskedAddress", "", "getMaskedAddress", "()Ljava/lang/String;", "getRegistrationInfo", "()Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "senderId", "getSenderId", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "RegistrationInfo", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Sms extends ContactChannel {
        private final ChannelType channelType;
        private final RegistrationInfo registrationInfo;

        @NotNull
        public final RegistrationInfo getRegistrationInfo() {
            return this.registrationInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public Sms(@NotNull RegistrationInfo registrationInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(registrationInfo, "registrationInfo");
            this.registrationInfo = registrationInfo;
            this.channelType = ChannelType.SMS;
        }

        @Override // com.urbanairship.contacts.ContactChannel
        @NotNull
        public ChannelType getChannelType() {
            return this.channelType;
        }

        @Override // com.urbanairship.contacts.ContactChannel
        @NotNull
        public String getMaskedAddress() {
            RegistrationInfo registrationInfo = this.registrationInfo;
            if (registrationInfo instanceof RegistrationInfo.Pending) {
                return ContactChannelKt.maskPhoneNumber(((RegistrationInfo.Pending) registrationInfo).getAddress());
            }
            if (registrationInfo instanceof RegistrationInfo.Registered) {
                return ContactChannelKt.replaceAsterisks(((RegistrationInfo.Registered) registrationInfo).getMaskedAddress());
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.urbanairship.contacts.ContactChannel
        public boolean isRegistered() {
            RegistrationInfo registrationInfo = this.registrationInfo;
            if (registrationInfo instanceof RegistrationInfo.Pending) {
                return false;
            }
            if (registrationInfo instanceof RegistrationInfo.Registered) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        public final String getSenderId() {
            RegistrationInfo registrationInfo = this.registrationInfo;
            if (registrationInfo instanceof RegistrationInfo.Pending) {
                return ((RegistrationInfo.Pending) registrationInfo).getRegistrationOptions().getSenderId();
            }
            if (registrationInfo instanceof RegistrationInfo.Registered) {
                return ((RegistrationInfo.Registered) registrationInfo).getSenderId();
            }
            throw new NoWhenBranchMatchedException();
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Pending", "Registered", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Registered;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class RegistrationInfo implements JsonSerializable {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ RegistrationInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private RegistrationInfo() {
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Registered;", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "channelId", "", "maskedAddress", "isOptIn", "", "senderId", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "()Z", "getMaskedAddress", "getSenderId", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Registered extends RegistrationInfo {
                private final String channelId;
                private final boolean isOptIn;
                private final String maskedAddress;
                private final String senderId;

                @NotNull
                public final String getChannelId() {
                    return this.channelId;
                }

                @NotNull
                public final String getMaskedAddress() {
                    return this.maskedAddress;
                }

                /* renamed from: isOptIn, reason: from getter */
                public final boolean getIsOptIn() {
                    return this.isOptIn;
                }

                @NotNull
                public final String getSenderId() {
                    return this.senderId;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
                @VisibleForTesting
                public Registered(@NotNull String channelId, @NotNull String maskedAddress, boolean z, @NotNull String senderId) {
                    super(null);
                    Intrinsics.checkNotNullParameter(channelId, "channelId");
                    Intrinsics.checkNotNullParameter(maskedAddress, "maskedAddress");
                    Intrinsics.checkNotNullParameter(senderId, "senderId");
                    this.channelId = channelId;
                    this.maskedAddress = maskedAddress;
                    this.isOptIn = z;
                    this.senderId = senderId;
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!Intrinsics.areEqual(Registered.class, other != null ? other.getClass() : null)) {
                        return false;
                    }
                    Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Sms.RegistrationInfo.Registered");
                    Registered registered = (Registered) other;
                    return Intrinsics.areEqual(this.channelId, registered.channelId) && Intrinsics.areEqual(this.maskedAddress, registered.maskedAddress) && this.isOptIn == registered.isOptIn && Intrinsics.areEqual(this.senderId, registered.senderId);
                }

                public int hashCode() {
                    return ObjectsCompat.hash(this.channelId, this.maskedAddress, Boolean.valueOf(this.isOptIn), this.senderId);
                }

                @NotNull
                public String toString() {
                    return "Registered(channelId='" + this.channelId + "', maskedAddress='" + this.maskedAddress + "', isOptIn=" + this.isOptIn + ", senderId='" + this.senderId + "')";
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "address", "", "registrationOptions", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/SmsRegistrationOptions;)V", "getAddress", "()Ljava/lang/String;", "getRegistrationOptions", "()Lcom/urbanairship/contacts/SmsRegistrationOptions;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Pending extends RegistrationInfo {
                private final String address;
                private final SmsRegistrationOptions registrationOptions;

                @NotNull
                public final String getAddress() {
                    return this.address;
                }

                @NotNull
                public final SmsRegistrationOptions getRegistrationOptions() {
                    return this.registrationOptions;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
                @VisibleForTesting
                public Pending(@NotNull String address, @NotNull SmsRegistrationOptions registrationOptions) {
                    super(null);
                    Intrinsics.checkNotNullParameter(address, "address");
                    Intrinsics.checkNotNullParameter(registrationOptions, "registrationOptions");
                    this.address = address;
                    this.registrationOptions = registrationOptions;
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!Intrinsics.areEqual(Pending.class, other != null ? other.getClass() : null)) {
                        return false;
                    }
                    Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Sms.RegistrationInfo.Pending");
                    Pending pending = (Pending) other;
                    return Intrinsics.areEqual(this.address, pending.address) && Intrinsics.areEqual(this.registrationOptions, pending.registrationOptions);
                }

                public int hashCode() {
                    return ObjectsCompat.hash(this.address, this.registrationOptions);
                }

                @NotNull
                public String toString() {
                    return "Pending(address='" + this.address + "', registrationOptions=" + this.registrationOptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() throws JsonException {
                JsonMap jsonMapJsonMapOf;
                if (this instanceof Pending) {
                    Pending pending = (Pending) this;
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ETCPurchaseStatus.PENDING), TuplesKt.to("address", pending.getAddress()), TuplesKt.to("options", pending.getRegistrationOptions()));
                } else {
                    if (!(this instanceof Registered)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Registered registered = (Registered) this;
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", "registered"), TuplesKt.to("address", registered.getMaskedAddress()), TuplesKt.to("opt_in", Boolean.valueOf(registered.getIsOptIn())), TuplesKt.to("channel_id", registered.getChannelId()), TuplesKt.to("sender", registered.getSenderId()));
                }
                JsonValue jsonValue = jsonMapJsonMapOf.toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nContactChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,522:1\n44#2,15:523\n44#2,15:538\n44#2,15:553\n44#2,15:568\n44#2,15:583\n44#2,15:598\n*S KotlinDebug\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Companion\n*L\n249#1:523,15\n251#1:538,15\n258#1:553,15\n259#1:568,15\n260#1:583,15\n261#1:598,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Removed duplicated region for block: B:123:0x02f9  */
                /* JADX WARN: Removed duplicated region for block: B:240:0x058d  */
                /* JADX WARN: Removed duplicated region for block: B:297:0x06c6  */
                /* JADX WARN: Removed duplicated region for block: B:357:0x0825  */
                /* JADX WARN: Removed duplicated region for block: B:363:0x086c  */
                /* JADX WARN: Removed duplicated region for block: B:60:0x016a  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.contacts.ContactChannel.Sms.RegistrationInfo fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r21) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 2421
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactChannel.Sms.RegistrationInfo.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.contacts.ContactChannel$Sms$RegistrationInfo");
                }
            }
        }

        @NotNull
        public String toString() {
            return "Sms(registrationInfo=" + this.registrationInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Sms.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Sms");
            Sms sms = (Sms) other;
            return Intrinsics.areEqual(this.registrationInfo, sms.registrationInfo) && getChannelType() == sms.getChannelType();
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.registrationInfo);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email;", "Lcom/urbanairship/contacts/ContactChannel;", "registrationInfo", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "(Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;)V", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "isRegistered", "", "()Z", "maskedAddress", "", "getMaskedAddress", "()Ljava/lang/String;", "getRegistrationInfo", "()Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "RegistrationInfo", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Email extends ContactChannel {
        private final ChannelType channelType;
        private final RegistrationInfo registrationInfo;

        @NotNull
        public final RegistrationInfo getRegistrationInfo() {
            return this.registrationInfo;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @VisibleForTesting
        public Email(@NotNull RegistrationInfo registrationInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(registrationInfo, "registrationInfo");
            this.registrationInfo = registrationInfo;
            this.channelType = ChannelType.EMAIL;
        }

        @Override // com.urbanairship.contacts.ContactChannel
        @NotNull
        public ChannelType getChannelType() {
            return this.channelType;
        }

        @Override // com.urbanairship.contacts.ContactChannel
        @NotNull
        public String getMaskedAddress() {
            RegistrationInfo registrationInfo = this.registrationInfo;
            if (registrationInfo instanceof RegistrationInfo.Pending) {
                return ContactChannelKt.maskEmail(((RegistrationInfo.Pending) registrationInfo).getAddress());
            }
            if (registrationInfo instanceof RegistrationInfo.Registered) {
                return ContactChannelKt.replaceAsterisks(((RegistrationInfo.Registered) registrationInfo).getMaskedAddress());
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.urbanairship.contacts.ContactChannel
        public boolean isRegistered() {
            RegistrationInfo registrationInfo = this.registrationInfo;
            if (registrationInfo instanceof RegistrationInfo.Pending) {
                return false;
            }
            if (registrationInfo instanceof RegistrationInfo.Registered) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Email.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Email");
            Email email = (Email) other;
            return Intrinsics.areEqual(this.registrationInfo, email.registrationInfo) && getChannelType() == email.getChannelType();
        }

        public int hashCode() {
            return ObjectsCompat.hashCode(this.registrationInfo);
        }

        @NotNull
        public String toString() {
            return "Email(registrationInfo=" + this.registrationInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Pending", "Registered", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Registered;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class RegistrationInfo implements JsonSerializable {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ RegistrationInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private RegistrationInfo() {
            }

            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Registered;", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "channelId", "", "maskedAddress", "transactionalOptedIn", "", "transactionalOptedOut", "commercialOptedIn", "commercialOptedOut", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getChannelId", "()Ljava/lang/String;", "getCommercialOptedIn", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommercialOptedOut", "getMaskedAddress", "getTransactionalOptedIn", "getTransactionalOptedOut", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Registered extends RegistrationInfo {
                private final String channelId;
                private final Long commercialOptedIn;
                private final Long commercialOptedOut;
                private final String maskedAddress;
                private final Long transactionalOptedIn;
                private final Long transactionalOptedOut;

                public /* synthetic */ Registered(String str, String str2, Long l, Long l2, Long l3, Long l4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2, (i & 16) != 0 ? null : l3, (i & 32) != 0 ? null : l4);
                }

                @NotNull
                public final String getChannelId() {
                    return this.channelId;
                }

                @NotNull
                public final String getMaskedAddress() {
                    return this.maskedAddress;
                }

                @Nullable
                public final Long getTransactionalOptedIn() {
                    return this.transactionalOptedIn;
                }

                @Nullable
                public final Long getTransactionalOptedOut() {
                    return this.transactionalOptedOut;
                }

                @Nullable
                public final Long getCommercialOptedIn() {
                    return this.commercialOptedIn;
                }

                @Nullable
                public final Long getCommercialOptedOut() {
                    return this.commercialOptedOut;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
                @VisibleForTesting
                public Registered(@NotNull String channelId, @NotNull String maskedAddress, @Nullable Long l, @Nullable Long l2, @Nullable Long l3, @Nullable Long l4) {
                    super(null);
                    Intrinsics.checkNotNullParameter(channelId, "channelId");
                    Intrinsics.checkNotNullParameter(maskedAddress, "maskedAddress");
                    this.channelId = channelId;
                    this.maskedAddress = maskedAddress;
                    this.transactionalOptedIn = l;
                    this.transactionalOptedOut = l2;
                    this.commercialOptedIn = l3;
                    this.commercialOptedOut = l4;
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!Intrinsics.areEqual(Registered.class, other != null ? other.getClass() : null)) {
                        return false;
                    }
                    Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Email.RegistrationInfo.Registered");
                    Registered registered = (Registered) other;
                    return Intrinsics.areEqual(this.channelId, registered.channelId) && Intrinsics.areEqual(this.maskedAddress, registered.maskedAddress) && Intrinsics.areEqual(this.transactionalOptedIn, registered.transactionalOptedIn) && Intrinsics.areEqual(this.transactionalOptedOut, registered.transactionalOptedOut) && Intrinsics.areEqual(this.commercialOptedIn, registered.commercialOptedIn) && Intrinsics.areEqual(this.commercialOptedOut, registered.commercialOptedOut);
                }

                public int hashCode() {
                    return ObjectsCompat.hash(this.channelId, this.maskedAddress, this.transactionalOptedIn, this.transactionalOptedOut, this.commercialOptedIn, this.commercialOptedOut);
                }

                @NotNull
                public String toString() {
                    return "Registered(channelId='" + this.channelId + "', maskedAddress='" + this.maskedAddress + "', transactionalOptedIn=" + this.transactionalOptedIn + ", transactionalOptedOut=" + this.transactionalOptedOut + ", commercialOptedIn=" + this.commercialOptedIn + ", commercialOptedOut=" + this.commercialOptedOut + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "address", "", "registrationOptions", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/EmailRegistrationOptions;)V", "getAddress", "()Ljava/lang/String;", "getRegistrationOptions", "()Lcom/urbanairship/contacts/EmailRegistrationOptions;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class Pending extends RegistrationInfo {
                private final String address;
                private final EmailRegistrationOptions registrationOptions;

                @NotNull
                public final String getAddress() {
                    return this.address;
                }

                @NotNull
                public final EmailRegistrationOptions getRegistrationOptions() {
                    return this.registrationOptions;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
                @VisibleForTesting
                public Pending(@NotNull String address, @NotNull EmailRegistrationOptions registrationOptions) {
                    super(null);
                    Intrinsics.checkNotNullParameter(address, "address");
                    Intrinsics.checkNotNullParameter(registrationOptions, "registrationOptions");
                    this.address = address;
                    this.registrationOptions = registrationOptions;
                }

                @NotNull
                public String toString() {
                    return "Pending(address='" + this.address + "', registrationOptions=" + this.registrationOptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!Intrinsics.areEqual(Pending.class, other != null ? other.getClass() : null)) {
                        return false;
                    }
                    Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.ContactChannel.Email.RegistrationInfo.Pending");
                    Pending pending = (Pending) other;
                    return Intrinsics.areEqual(this.address, pending.address) && Intrinsics.areEqual(this.registrationOptions, pending.registrationOptions);
                }

                public int hashCode() {
                    return ObjectsCompat.hash(this.address, this.registrationOptions);
                }
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            public JsonValue toJsonValue() throws JsonException {
                JsonMap jsonMapJsonMapOf;
                if (this instanceof Pending) {
                    Pending pending = (Pending) this;
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ETCPurchaseStatus.PENDING), TuplesKt.to("address", pending.getAddress()), TuplesKt.to("options", pending.getRegistrationOptions()));
                } else {
                    if (!(this instanceof Registered)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Pair pair = TuplesKt.to("type", "registered");
                    Registered registered = (Registered) this;
                    Pair pair2 = TuplesKt.to("address", registered.getMaskedAddress());
                    Pair pair3 = TuplesKt.to("channel_id", registered.getChannelId());
                    Long commercialOptedIn = registered.getCommercialOptedIn();
                    Pair pair4 = TuplesKt.to("commercial_opted_in", commercialOptedIn != null ? DateUtils.createIso8601TimeStamp(commercialOptedIn.longValue()) : null);
                    Long commercialOptedOut = registered.getCommercialOptedOut();
                    Pair pair5 = TuplesKt.to("commercial_opted_out", commercialOptedOut != null ? DateUtils.createIso8601TimeStamp(commercialOptedOut.longValue()) : null);
                    Long transactionalOptedIn = registered.getTransactionalOptedIn();
                    Pair pair6 = TuplesKt.to("transactional_opted_in", transactionalOptedIn != null ? DateUtils.createIso8601TimeStamp(transactionalOptedIn.longValue()) : null);
                    Long transactionalOptedOut = registered.getTransactionalOptedOut();
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, pair5, pair6, TuplesKt.to("transactional_opted_out", transactionalOptedOut != null ? DateUtils.createIso8601TimeStamp(transactionalOptedOut.longValue()) : null));
                }
                JsonValue jsonValue = jsonMapJsonMapOf.toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nContactChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,522:1\n44#2,15:523\n44#2,15:538\n44#2,15:553\n44#2,15:568\n*S KotlinDebug\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Companion\n*L\n469#1:523,15\n471#1:538,15\n478#1:553,15\n479#1:568,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Removed duplicated region for block: B:123:0x02f9  */
                /* JADX WARN: Removed duplicated region for block: B:60:0x016a  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.contacts.ContactChannel.Email.RegistrationInfo fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r26) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 1654
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactChannel.Email.RegistrationInfo.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.contacts.ContactChannel$Email$RegistrationInfo");
                }
            }
        }
    }
}
