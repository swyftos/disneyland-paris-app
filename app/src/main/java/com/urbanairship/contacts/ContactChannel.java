package com.urbanairship.contacts;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.AudioStats;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.tagcommander.lib.p193serverside.ETCPurchaseStatus;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "isRegistered", "", "()Z", "maskedAddress", "", "getMaskedAddress", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Email", "Sms", "Lcom/urbanairship/contacts/ContactChannel$Email;", "Lcom/urbanairship/contacts/ContactChannel$Sms;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public abstract class ContactChannel implements JsonSerializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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
        Pair pairM1842to = TuplesKt.m1842to("type", getChannelType().name());
        if (this instanceof Sms) {
            registrationInfo = ((Sms) this).getRegistrationInfo();
        } else {
            if (!(this instanceof Email)) {
                throw new NoWhenBranchMatchedException();
            }
            registrationInfo = ((Email) this).getRegistrationInfo();
        }
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pairM1842to, TuplesKt.m1842to(OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, registrationInfo)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Companion;", "", "()V", "ADDRESS_KEY", "", "CHANNEL_ID_KEY", "COMMERCIAL_OPTED_IN_KEY", "COMMERCIAL_OPTED_OUT_KEY", "INFO_KEY", "OPTIONS_KEY", "OPT_IN_KEY", "PENDING_TYPE", "REGISTERED_TYPE", "SENDER_ID_KEY", "TRANSACTIONAL_OPTED_IN_KEY", "TRANSACTIONAL_OPTED_OUT_KEY", ContactOperation.TYPE_KEY, "fromJson", "Lcom/urbanairship/contacts/ContactChannel;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

    @Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001b"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms;", "Lcom/urbanairship/contacts/ContactChannel;", "registrationInfo", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "(Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;)V", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "isRegistered", "", "()Z", "maskedAddress", "", "getMaskedAddress", "()Ljava/lang/String;", "getRegistrationInfo", "()Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "senderId", "getSenderId", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "RegistrationInfo", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

        @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0002\b\t¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Pending", "Registered", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Registered;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static abstract class RegistrationInfo implements JsonSerializable {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ RegistrationInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private RegistrationInfo() {
            }

            @Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0014"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Registered;", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "channelId", "", "maskedAddress", "isOptIn", "", "senderId", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "()Z", "getMaskedAddress", "getSenderId", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

                /* JADX INFO: renamed from: isOptIn, reason: from getter */
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

            @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "address", "", "registrationOptions", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/SmsRegistrationOptions;)V", "getAddress", "()Ljava/lang/String;", "getRegistrationOptions", "()Lcom/urbanairship/contacts/SmsRegistrationOptions;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", ETCPurchaseStatus.PENDING), TuplesKt.m1842to("address", pending.getAddress()), TuplesKt.m1842to("options", pending.getRegistrationOptions()));
                } else {
                    if (!(this instanceof Registered)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Registered registered = (Registered) this;
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", "registered"), TuplesKt.m1842to("address", registered.getMaskedAddress()), TuplesKt.m1842to("opt_in", Boolean.valueOf(registered.getIsOptIn())), TuplesKt.m1842to("channel_id", registered.getChannelId()), TuplesKt.m1842to("sender", registered.getSenderId()));
                }
                JsonValue jsonValue = jsonMapJsonMapOf.toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }

            @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nContactChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,522:1\n44#2,15:523\n44#2,15:538\n44#2,15:553\n44#2,15:568\n44#2,15:583\n44#2,15:598\n*S KotlinDebug\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Sms$RegistrationInfo$Companion\n*L\n249#1:523,15\n251#1:538,15\n258#1:553,15\n259#1:568,15\n260#1:583,15\n261#1:598,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Code duplicated, block: B:101:0x026b  */
                /* JADX WARN: Code duplicated, block: B:102:0x026e  */
                /* JADX WARN: Code duplicated, block: B:104:0x0274  */
                /* JADX WARN: Code duplicated, block: B:106:0x027e  */
                /* JADX WARN: Code duplicated, block: B:108:0x0284  */
                /* JADX WARN: Code duplicated, block: B:109:0x0287  */
                /* JADX WARN: Code duplicated, block: B:111:0x028d  */
                /* JADX WARN: Code duplicated, block: B:113:0x0297  */
                /* JADX WARN: Code duplicated, block: B:115:0x029d  */
                /* JADX WARN: Code duplicated, block: B:117:0x02b5  */
                /* JADX WARN: Code duplicated, block: B:119:0x02bb  */
                /* JADX WARN: Code duplicated, block: B:121:0x02df  */
                /* JADX WARN: Code duplicated, block: B:123:0x02f9  */
                /* JADX WARN: Code duplicated, block: B:125:0x0301  */
                /* JADX WARN: Code duplicated, block: B:127:0x0307  */
                /* JADX WARN: Code duplicated, block: B:129:0x0318  */
                /* JADX WARN: Code duplicated, block: B:132:0x0320  */
                /* JADX WARN: Code duplicated, block: B:134:0x0326  */
                /* JADX WARN: Code duplicated, block: B:136:0x0330  */
                /* JADX WARN: Code duplicated, block: B:139:0x0338  */
                /* JADX WARN: Code duplicated, block: B:141:0x033e  */
                /* JADX WARN: Code duplicated, block: B:143:0x034a  */
                /* JADX WARN: Code duplicated, block: B:144:0x0357  */
                /* JADX WARN: Code duplicated, block: B:146:0x0363  */
                /* JADX WARN: Code duplicated, block: B:147:0x0371  */
                /* JADX WARN: Code duplicated, block: B:149:0x037d  */
                /* JADX WARN: Code duplicated, block: B:150:0x038d  */
                /* JADX WARN: Code duplicated, block: B:152:0x0399  */
                /* JADX WARN: Code duplicated, block: B:153:0x03a7  */
                /* JADX WARN: Code duplicated, block: B:155:0x03b3  */
                /* JADX WARN: Code duplicated, block: B:156:0x03c0  */
                /* JADX WARN: Code duplicated, block: B:158:0x03ca  */
                /* JADX WARN: Code duplicated, block: B:159:0x03d6  */
                /* JADX WARN: Code duplicated, block: B:161:0x03e1  */
                /* JADX WARN: Code duplicated, block: B:162:0x03f0  */
                /* JADX WARN: Code duplicated, block: B:164:0x03fa  */
                /* JADX WARN: Code duplicated, block: B:166:0x0400  */
                /* JADX WARN: Code duplicated, block: B:167:0x0403  */
                /* JADX WARN: Code duplicated, block: B:169:0x0409  */
                /* JADX WARN: Code duplicated, block: B:171:0x0413  */
                /* JADX WARN: Code duplicated, block: B:173:0x0419  */
                /* JADX WARN: Code duplicated, block: B:174:0x041c  */
                /* JADX WARN: Code duplicated, block: B:176:0x0422  */
                /* JADX WARN: Code duplicated, block: B:178:0x042c  */
                /* JADX WARN: Code duplicated, block: B:180:0x0432  */
                /* JADX WARN: Code duplicated, block: B:183:0x043c  */
                /* JADX WARN: Code duplicated, block: B:185:0x0453  */
                /* JADX WARN: Code duplicated, block: B:187:0x0459  */
                /* JADX WARN: Code duplicated, block: B:189:0x0460  */
                /* JADX WARN: Code duplicated, block: B:191:0x0466  */
                /* JADX WARN: Code duplicated, block: B:193:0x0470  */
                /* JADX WARN: Code duplicated, block: B:195:0x0476  */
                /* JADX WARN: Code duplicated, block: B:196:0x0479  */
                /* JADX WARN: Code duplicated, block: B:198:0x047f  */
                /* JADX WARN: Code duplicated, block: B:200:0x048b  */
                /* JADX WARN: Code duplicated, block: B:201:0x0495  */
                /* JADX WARN: Code duplicated, block: B:203:0x04a1  */
                /* JADX WARN: Code duplicated, block: B:204:0x04b3  */
                /* JADX WARN: Code duplicated, block: B:206:0x04c0  */
                /* JADX WARN: Code duplicated, block: B:207:0x04d3  */
                /* JADX WARN: Code duplicated, block: B:209:0x04df  */
                /* JADX WARN: Code duplicated, block: B:210:0x04ee  */
                /* JADX WARN: Code duplicated, block: B:212:0x04fa  */
                /* JADX WARN: Code duplicated, block: B:213:0x0508  */
                /* JADX WARN: Code duplicated, block: B:215:0x0512  */
                /* JADX WARN: Code duplicated, block: B:216:0x051f  */
                /* JADX WARN: Code duplicated, block: B:218:0x052a  */
                /* JADX WARN: Code duplicated, block: B:219:0x053a  */
                /* JADX WARN: Code duplicated, block: B:221:0x0544  */
                /* JADX WARN: Code duplicated, block: B:223:0x054a  */
                /* JADX WARN: Code duplicated, block: B:224:0x054e  */
                /* JADX WARN: Code duplicated, block: B:226:0x0554  */
                /* JADX WARN: Code duplicated, block: B:228:0x055e  */
                /* JADX WARN: Code duplicated, block: B:230:0x0564  */
                /* JADX WARN: Code duplicated, block: B:231:0x0568  */
                /* JADX WARN: Code duplicated, block: B:233:0x056e  */
                /* JADX WARN: Code duplicated, block: B:235:0x0578  */
                /* JADX WARN: Code duplicated, block: B:237:0x057e  */
                /* JADX WARN: Code duplicated, block: B:240:0x058d  */
                /* JADX WARN: Code duplicated, block: B:242:0x059e  */
                /* JADX WARN: Code duplicated, block: B:244:0x05a4  */
                /* JADX WARN: Code duplicated, block: B:246:0x05a8  */
                /* JADX WARN: Code duplicated, block: B:248:0x05af  */
                /* JADX WARN: Code duplicated, block: B:250:0x05ba  */
                /* JADX WARN: Code duplicated, block: B:253:0x05c1  */
                /* JADX WARN: Code duplicated, block: B:255:0x05c7  */
                /* JADX WARN: Code duplicated, block: B:257:0x05d3  */
                /* JADX WARN: Code duplicated, block: B:258:0x05df  */
                /* JADX WARN: Code duplicated, block: B:260:0x05eb  */
                /* JADX WARN: Code duplicated, block: B:261:0x05fa  */
                /* JADX WARN: Code duplicated, block: B:263:0x0605  */
                /* JADX WARN: Code duplicated, block: B:264:0x0617  */
                /* JADX WARN: Code duplicated, block: B:266:0x0623  */
                /* JADX WARN: Code duplicated, block: B:267:0x0631  */
                /* JADX WARN: Code duplicated, block: B:269:0x063d  */
                /* JADX WARN: Code duplicated, block: B:270:0x064a  */
                /* JADX WARN: Code duplicated, block: B:272:0x0654  */
                /* JADX WARN: Code duplicated, block: B:273:0x0660  */
                /* JADX WARN: Code duplicated, block: B:275:0x066b  */
                /* JADX WARN: Code duplicated, block: B:276:0x067a  */
                /* JADX WARN: Code duplicated, block: B:278:0x0684  */
                /* JADX WARN: Code duplicated, block: B:280:0x068a  */
                /* JADX WARN: Code duplicated, block: B:281:0x068d  */
                /* JADX WARN: Code duplicated, block: B:283:0x0693  */
                /* JADX WARN: Code duplicated, block: B:285:0x069d  */
                /* JADX WARN: Code duplicated, block: B:287:0x06a3  */
                /* JADX WARN: Code duplicated, block: B:288:0x06a6  */
                /* JADX WARN: Code duplicated, block: B:290:0x06ac  */
                /* JADX WARN: Code duplicated, block: B:292:0x06b6  */
                /* JADX WARN: Code duplicated, block: B:294:0x06bc  */
                /* JADX WARN: Code duplicated, block: B:297:0x06c6  */
                /* JADX WARN: Code duplicated, block: B:299:0x06d7  */
                /* JADX WARN: Code duplicated, block: B:302:0x06df  */
                /* JADX WARN: Code duplicated, block: B:304:0x06e5  */
                /* JADX WARN: Code duplicated, block: B:306:0x06ef  */
                /* JADX WARN: Code duplicated, block: B:309:0x06f7  */
                /* JADX WARN: Code duplicated, block: B:311:0x06fd  */
                /* JADX WARN: Code duplicated, block: B:313:0x0709  */
                /* JADX WARN: Code duplicated, block: B:314:0x0716  */
                /* JADX WARN: Code duplicated, block: B:316:0x0722  */
                /* JADX WARN: Code duplicated, block: B:317:0x0730  */
                /* JADX WARN: Code duplicated, block: B:319:0x073a  */
                /* JADX WARN: Code duplicated, block: B:320:0x074c  */
                /* JADX WARN: Code duplicated, block: B:322:0x0758  */
                /* JADX WARN: Code duplicated, block: B:323:0x0766  */
                /* JADX WARN: Code duplicated, block: B:325:0x0772  */
                /* JADX WARN: Code duplicated, block: B:326:0x077f  */
                /* JADX WARN: Code duplicated, block: B:328:0x0789  */
                /* JADX WARN: Code duplicated, block: B:329:0x0795  */
                /* JADX WARN: Code duplicated, block: B:331:0x07a0  */
                /* JADX WARN: Code duplicated, block: B:332:0x07af  */
                /* JADX WARN: Code duplicated, block: B:334:0x07b9  */
                /* JADX WARN: Code duplicated, block: B:336:0x07bf  */
                /* JADX WARN: Code duplicated, block: B:337:0x07c2  */
                /* JADX WARN: Code duplicated, block: B:339:0x07c8  */
                /* JADX WARN: Code duplicated, block: B:341:0x07d2  */
                /* JADX WARN: Code duplicated, block: B:343:0x07d8  */
                /* JADX WARN: Code duplicated, block: B:344:0x07db  */
                /* JADX WARN: Code duplicated, block: B:346:0x07e1  */
                /* JADX WARN: Code duplicated, block: B:348:0x07eb  */
                /* JADX WARN: Code duplicated, block: B:350:0x07f1  */
                /* JADX WARN: Code duplicated, block: B:353:0x07fa  */
                /* JADX WARN: Code duplicated, block: B:355:0x0800  */
                /* JADX WARN: Code duplicated, block: B:357:0x0825  */
                /* JADX WARN: Code duplicated, block: B:359:0x0841  */
                /* JADX WARN: Code duplicated, block: B:361:0x0847  */
                /* JADX WARN: Code duplicated, block: B:363:0x086c  */
                /* JADX WARN: Code duplicated, block: B:365:0x0888  */
                /* JADX WARN: Code duplicated, block: B:367:0x088e  */
                /* JADX WARN: Code duplicated, block: B:369:0x08b5  */
                /* JADX WARN: Code duplicated, block: B:371:0x08d0  */
                /* JADX WARN: Code duplicated, block: B:373:0x08d7  */
                /* JADX WARN: Code duplicated, block: B:375:0x08fc  */
                /* JADX WARN: Code duplicated, block: B:377:0x0917  */
                /* JADX WARN: Code duplicated, block: B:60:0x016a  */
                /* JADX WARN: Code duplicated, block: B:62:0x0172  */
                /* JADX WARN: Code duplicated, block: B:64:0x0183  */
                /* JADX WARN: Code duplicated, block: B:67:0x018b  */
                /* JADX WARN: Code duplicated, block: B:69:0x0191  */
                /* JADX WARN: Code duplicated, block: B:71:0x019b  */
                /* JADX WARN: Code duplicated, block: B:74:0x01a3  */
                /* JADX WARN: Code duplicated, block: B:76:0x01a9  */
                /* JADX WARN: Code duplicated, block: B:78:0x01b5  */
                /* JADX WARN: Code duplicated, block: B:79:0x01c2  */
                /* JADX WARN: Code duplicated, block: B:81:0x01ce  */
                /* JADX WARN: Code duplicated, block: B:82:0x01dc  */
                /* JADX WARN: Code duplicated, block: B:84:0x01e8  */
                /* JADX WARN: Code duplicated, block: B:85:0x01f8  */
                /* JADX WARN: Code duplicated, block: B:87:0x0204  */
                /* JADX WARN: Code duplicated, block: B:88:0x0212  */
                /* JADX WARN: Code duplicated, block: B:90:0x021e  */
                /* JADX WARN: Code duplicated, block: B:91:0x022b  */
                /* JADX WARN: Code duplicated, block: B:93:0x0235  */
                /* JADX WARN: Code duplicated, block: B:94:0x0241  */
                /* JADX WARN: Code duplicated, block: B:96:0x024c  */
                /* JADX WARN: Code duplicated, block: B:97:0x025b  */
                /* JADX WARN: Code duplicated, block: B:99:0x0265  */
                /* JADX WARN: Instruction removed from duplicated block: B:119:0x02bb, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:121:0x02df, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:355:0x0800, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:357:0x0825, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:361:0x0847, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:363:0x086c, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:367:0x088e, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:369:0x08b5, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:373:0x08d7, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:375:0x08fc, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:377:0x0917, please report this as an issue */
                @NotNull
                public final RegistrationInfo fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                    String str;
                    String strOptString;
                    JsonValue jsonValue2;
                    KClass orCreateKotlinClass;
                    Object jsonValue3;
                    String strOptString2;
                    Object objOptMap;
                    Object objOptList;
                    JsonValue jsonValue4;
                    KClass orCreateKotlinClass2;
                    String str2;
                    String str3;
                    Object jsonValue5;
                    Boolean boolValueOf;
                    Object objOptMap2;
                    Object objOptList2;
                    Object objOptString;
                    boolean zBooleanValue;
                    JsonValue jsonValue6;
                    KClass orCreateKotlinClass3;
                    String str4;
                    String str5;
                    Object jsonValue7;
                    String strOptString3;
                    Object objOptMap3;
                    Object objOptList3;
                    JsonValue jsonValue8;
                    KClass orCreateKotlinClass4;
                    Object jsonValue9;
                    String strOptString4;
                    Object objOptMap4;
                    Object objOptList4;
                    Object objOptString2;
                    JsonValue jsonValue10;
                    KClass orCreateKotlinClass5;
                    Object jsonValue11;
                    String strOptString5;
                    Object objOptMap5;
                    Object objOptList5;
                    Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                    JsonMap jsonMapRequireMap = jsonValue.requireMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                    JsonValue jsonValue12 = jsonMapRequireMap.get("type");
                    if (jsonValue12 == null) {
                        throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue12);
                    KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue12.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString = (String) Boolean.valueOf(jsonValue12.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str = "' for field '";
                                strOptString = (String) Long.valueOf(jsonValue12.getLong(0L));
                            } else {
                                str = "' for field '";
                                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue12.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString = (String) Double.valueOf(jsonValue12.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString = (String) Float.valueOf(jsonValue12.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString = (String) Integer.valueOf(jsonValue12.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue12.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    Object objOptList6 = jsonValue12.optList();
                                    if (objOptList6 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString = (String) objOptList6;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    Object objOptMap6 = jsonValue12.optMap();
                                    if (objOptMap6 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString = (String) objOptMap6;
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Object jsonValue13 = jsonValue12.toJsonValue();
                                    if (jsonValue13 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString = (String) jsonValue13;
                                }
                            }
                            if (Intrinsics.areEqual(strOptString, ETCPurchaseStatus.PENDING)) {
                                jsonValue10 = jsonMapRequireMap.get("address");
                                if (jsonValue10 != null) {
                                    throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue10);
                                orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                                    strOptString5 = jsonValue10.optString();
                                    if (strOptString5 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    strOptString5 = jsonValue10.optString();
                                    if (strOptString5 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString5 = (String) Boolean.valueOf(jsonValue10.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    strOptString5 = (String) Long.valueOf(jsonValue10.getLong(0L));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString5 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue10.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString5 = (String) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString5 = (String) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString5 = (String) Integer.valueOf(jsonValue10.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString5 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue10.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList5 = jsonValue10.optList();
                                    if (objOptList5 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString5 = (String) objOptList5;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap5 = jsonValue10.optMap();
                                    if (objOptMap5 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString5 = (String) objOptMap5;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue11 = jsonValue10.toJsonValue();
                                    if (jsonValue11 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString5 = (String) jsonValue11;
                                }
                                SmsRegistrationOptions.Companion companion = SmsRegistrationOptions.INSTANCE;
                                JsonValue jsonValueRequire = jsonMapRequireMap.require("options");
                                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                                return new Pending(strOptString5, companion.fromJson$urbanairship_core_release(jsonValueRequire));
                            }
                            if (Intrinsics.areEqual(strOptString, "registered")) {
                                throw new JsonException("Unexpected type " + strOptString);
                            }
                            jsonValue2 = jsonMapRequireMap.get("address");
                            if (jsonValue2 != null) {
                                throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue2);
                            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString2 = jsonValue2.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString2 = jsonValue2.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString2 = (String) Long.valueOf(jsonValue2.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString2 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString2 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString2 = (String) Integer.valueOf(jsonValue2.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList = jsonValue2.optList();
                                if (objOptList != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) objOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap = jsonValue2.optMap();
                                if (objOptMap != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) objOptMap;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue3 = jsonValue2.toJsonValue();
                                if (jsonValue3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) jsonValue3;
                            }
                            jsonValue4 = jsonMapRequireMap.get("opt_in");
                            if (jsonValue4 != null) {
                                throw new JsonException("Missing required field: 'opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue4);
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                objOptString2 = jsonValue4.optString();
                                if (objOptString2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        boolValueOf = Boolean.valueOf(jsonValue4.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str2 = "Missing required field: '";
                                        str3 = "null cannot be cast to non-null type kotlin.String";
                                        boolValueOf = (Boolean) Long.valueOf(jsonValue4.getLong(0L));
                                    } else {
                                        str2 = "Missing required field: '";
                                        str3 = "null cannot be cast to non-null type kotlin.String";
                                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                            boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            boolValueOf = (Boolean) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            boolValueOf = (Boolean) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                            boolValueOf = (Boolean) Integer.valueOf(jsonValue4.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            objOptList2 = jsonValue4.optList();
                                            if (objOptList2 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) objOptList2;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            objOptMap2 = jsonValue4.optMap();
                                            if (objOptMap2 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) objOptMap2;
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue5 = jsonValue4.toJsonValue();
                                            if (jsonValue5 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) jsonValue5;
                                        }
                                    }
                                    zBooleanValue = boolValueOf.booleanValue();
                                    jsonValue6 = jsonMapRequireMap.get("channel_id");
                                    if (jsonValue6 != null) {
                                        throw new JsonException(str2 + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Intrinsics.checkNotNull(jsonValue6);
                                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString3 = jsonValue6.optString();
                                        if (strOptString3 != null) {
                                            throw new NullPointerException(str3);
                                        }
                                        str4 = str3;
                                    } else {
                                        str4 = str3;
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                                strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                str5 = "Invalid type '";
                                                strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                                            } else {
                                                str5 = "Invalid type '";
                                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                                    strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                    strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                    strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                                    strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                                    strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                                    objOptList3 = jsonValue6.optList();
                                                    if (objOptList3 != null) {
                                                        throw new NullPointerException(str4);
                                                    }
                                                    strOptString3 = (String) objOptList3;
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                                    objOptMap3 = jsonValue6.optMap();
                                                    if (objOptMap3 != null) {
                                                        throw new NullPointerException(str4);
                                                    }
                                                    strOptString3 = (String) objOptMap3;
                                                } else {
                                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                        throw new JsonException(str5 + String.class.getSimpleName() + str + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                                    }
                                                    jsonValue7 = jsonValue6.toJsonValue();
                                                    if (jsonValue7 != null) {
                                                        throw new NullPointerException(str4);
                                                    }
                                                    strOptString3 = (String) jsonValue7;
                                                }
                                            }
                                            jsonValue8 = jsonMapRequireMap.get("sender");
                                            if (jsonValue8 != null) {
                                                throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            Intrinsics.checkNotNull(jsonValue8);
                                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                                strOptString4 = jsonValue8.optString();
                                                if (strOptString4 == null) {
                                                    throw new NullPointerException(str4);
                                                }
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                                strOptString4 = jsonValue8.optString();
                                                if (strOptString4 == null) {
                                                    throw new NullPointerException(str4);
                                                }
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                                objOptList4 = jsonValue8.optList();
                                                if (objOptList4 != null) {
                                                    throw new NullPointerException(str4);
                                                }
                                                strOptString4 = (String) objOptList4;
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                                objOptMap4 = jsonValue8.optMap();
                                                if (objOptMap4 != null) {
                                                    throw new NullPointerException(str4);
                                                }
                                                strOptString4 = (String) objOptMap4;
                                            } else {
                                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                    throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                                }
                                                jsonValue9 = jsonValue8.toJsonValue();
                                                if (jsonValue9 != null) {
                                                    throw new NullPointerException(str4);
                                                }
                                                strOptString4 = (String) jsonValue9;
                                            }
                                            return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                                        }
                                        strOptString3 = jsonValue6.optString();
                                        if (strOptString3 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    }
                                    str5 = "Invalid type '";
                                    jsonValue8 = jsonMapRequireMap.get("sender");
                                    if (jsonValue8 != null) {
                                        throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Intrinsics.checkNotNull(jsonValue8);
                                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList4 = jsonValue8.optList();
                                        if (objOptList4 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) objOptList4;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap4 = jsonValue8.optMap();
                                        if (objOptMap4 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) objOptMap4;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue9 = jsonValue8.toJsonValue();
                                        if (jsonValue9 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) jsonValue9;
                                    }
                                    return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                                }
                                objOptString = jsonValue4.optString();
                                if (objOptString != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString;
                            }
                            str2 = "Missing required field: '";
                            str3 = "null cannot be cast to non-null type kotlin.String";
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue6 = jsonMapRequireMap.get("channel_id");
                            if (jsonValue6 != null) {
                                throw new JsonException(str2 + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue6);
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 != null) {
                                    throw new NullPointerException(str3);
                                }
                                str4 = str3;
                            } else {
                                str4 = str3;
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str5 = "Invalid type '";
                                        strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                                    } else {
                                        str5 = "Invalid type '";
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                            strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                            strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            objOptList3 = jsonValue6.optList();
                                            if (objOptList3 != null) {
                                                throw new NullPointerException(str4);
                                            }
                                            strOptString3 = (String) objOptList3;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            objOptMap3 = jsonValue6.optMap();
                                            if (objOptMap3 != null) {
                                                throw new NullPointerException(str4);
                                            }
                                            strOptString3 = (String) objOptMap3;
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException(str5 + String.class.getSimpleName() + str + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue7 = jsonValue6.toJsonValue();
                                            if (jsonValue7 != null) {
                                                throw new NullPointerException(str4);
                                            }
                                            strOptString3 = (String) jsonValue7;
                                        }
                                    }
                                    jsonValue8 = jsonMapRequireMap.get("sender");
                                    if (jsonValue8 != null) {
                                        throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Intrinsics.checkNotNull(jsonValue8);
                                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList4 = jsonValue8.optList();
                                        if (objOptList4 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) objOptList4;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap4 = jsonValue8.optMap();
                                        if (objOptMap4 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) objOptMap4;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue9 = jsonValue8.toJsonValue();
                                        if (jsonValue9 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) jsonValue9;
                                    }
                                    return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                                }
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException(str4);
                                }
                            }
                            str5 = "Invalid type '";
                            jsonValue8 = jsonMapRequireMap.get("sender");
                            if (jsonValue8 != null) {
                                throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue8);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str4);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str4);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue8.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue8.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue9 = jsonValue8.toJsonValue();
                                if (jsonValue9 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) jsonValue9;
                            }
                            return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                        }
                        strOptString = jsonValue12.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    str = "' for field '";
                    if (Intrinsics.areEqual(strOptString, ETCPurchaseStatus.PENDING)) {
                        jsonValue10 = jsonMapRequireMap.get("address");
                        if (jsonValue10 != null) {
                            throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue10);
                        orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString5 = jsonValue10.optString();
                            if (strOptString5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString5 = jsonValue10.optString();
                            if (strOptString5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString5 = (String) Boolean.valueOf(jsonValue10.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString5 = (String) Long.valueOf(jsonValue10.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString5 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue10.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString5 = (String) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString5 = (String) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString5 = (String) Integer.valueOf(jsonValue10.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString5 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue10.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList5 = jsonValue10.optList();
                            if (objOptList5 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString5 = (String) objOptList5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap5 = jsonValue10.optMap();
                            if (objOptMap5 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString5 = (String) objOptMap5;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue11 = jsonValue10.toJsonValue();
                            if (jsonValue11 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString5 = (String) jsonValue11;
                        }
                        SmsRegistrationOptions.Companion companion2 = SmsRegistrationOptions.INSTANCE;
                        JsonValue jsonValueRequire2 = jsonMapRequireMap.require("options");
                        Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                        return new Pending(strOptString5, companion2.fromJson$urbanairship_core_release(jsonValueRequire2));
                    }
                    if (Intrinsics.areEqual(strOptString, "registered")) {
                        throw new JsonException("Unexpected type " + strOptString);
                    }
                    jsonValue2 = jsonMapRequireMap.get("address");
                    if (jsonValue2 != null) {
                        throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue2);
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue2.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue2.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue2.optList();
                        if (objOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue2.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue3 = jsonValue2.toJsonValue();
                        if (jsonValue3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) jsonValue3;
                    }
                    jsonValue4 = jsonMapRequireMap.get("opt_in");
                    if (jsonValue4 != null) {
                        throw new JsonException("Missing required field: 'opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue4);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue4.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptString2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                boolValueOf = Boolean.valueOf(jsonValue4.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str2 = "Missing required field: '";
                                str3 = "null cannot be cast to non-null type kotlin.String";
                                boolValueOf = (Boolean) Long.valueOf(jsonValue4.getLong(0L));
                            } else {
                                str2 = "Missing required field: '";
                                str3 = "null cannot be cast to non-null type kotlin.String";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    boolValueOf = (Boolean) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    boolValueOf = (Boolean) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    boolValueOf = (Boolean) Integer.valueOf(jsonValue4.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList2 = jsonValue4.optList();
                                    if (objOptList2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptList2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap2 = jsonValue4.optMap();
                                    if (objOptMap2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptMap2;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue5 = jsonValue4.toJsonValue();
                                    if (jsonValue5 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) jsonValue5;
                                }
                            }
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue6 = jsonMapRequireMap.get("channel_id");
                            if (jsonValue6 != null) {
                                throw new JsonException(str2 + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue6);
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 != null) {
                                    throw new NullPointerException(str3);
                                }
                                str4 = str3;
                            } else {
                                str4 = str3;
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str5 = "Invalid type '";
                                        strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                                    } else {
                                        str5 = "Invalid type '";
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                            strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                            strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            objOptList3 = jsonValue6.optList();
                                            if (objOptList3 != null) {
                                                throw new NullPointerException(str4);
                                            }
                                            strOptString3 = (String) objOptList3;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            objOptMap3 = jsonValue6.optMap();
                                            if (objOptMap3 != null) {
                                                throw new NullPointerException(str4);
                                            }
                                            strOptString3 = (String) objOptMap3;
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException(str5 + String.class.getSimpleName() + str + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue7 = jsonValue6.toJsonValue();
                                            if (jsonValue7 != null) {
                                                throw new NullPointerException(str4);
                                            }
                                            strOptString3 = (String) jsonValue7;
                                        }
                                    }
                                    jsonValue8 = jsonMapRequireMap.get("sender");
                                    if (jsonValue8 != null) {
                                        throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Intrinsics.checkNotNull(jsonValue8);
                                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString4 = jsonValue8.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str4);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList4 = jsonValue8.optList();
                                        if (objOptList4 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) objOptList4;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap4 = jsonValue8.optMap();
                                        if (objOptMap4 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) objOptMap4;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue9 = jsonValue8.toJsonValue();
                                        if (jsonValue9 != null) {
                                            throw new NullPointerException(str4);
                                        }
                                        strOptString4 = (String) jsonValue9;
                                    }
                                    return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                                }
                                strOptString3 = jsonValue6.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException(str4);
                                }
                            }
                            str5 = "Invalid type '";
                            jsonValue8 = jsonMapRequireMap.get("sender");
                            if (jsonValue8 != null) {
                                throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue8);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str4);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str4);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue8.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue8.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue9 = jsonValue8.toJsonValue();
                                if (jsonValue9 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) jsonValue9;
                            }
                            return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                        }
                        objOptString = jsonValue4.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptString;
                    }
                    str2 = "Missing required field: '";
                    str3 = "null cannot be cast to non-null type kotlin.String";
                    zBooleanValue = boolValueOf.booleanValue();
                    jsonValue6 = jsonMapRequireMap.get("channel_id");
                    if (jsonValue6 != null) {
                        throw new JsonException(str2 + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue6);
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue6.optString();
                        if (strOptString3 != null) {
                            throw new NullPointerException(str3);
                        }
                        str4 = str3;
                    } else {
                        str4 = str3;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str5 = "Invalid type '";
                                strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                            } else {
                                str5 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList3 = jsonValue6.optList();
                                    if (objOptList3 != null) {
                                        throw new NullPointerException(str4);
                                    }
                                    strOptString3 = (String) objOptList3;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap3 = jsonValue6.optMap();
                                    if (objOptMap3 != null) {
                                        throw new NullPointerException(str4);
                                    }
                                    strOptString3 = (String) objOptMap3;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + String.class.getSimpleName() + str + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue7 = jsonValue6.toJsonValue();
                                    if (jsonValue7 != null) {
                                        throw new NullPointerException(str4);
                                    }
                                    strOptString3 = (String) jsonValue7;
                                }
                            }
                            jsonValue8 = jsonMapRequireMap.get("sender");
                            if (jsonValue8 != null) {
                                throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue8);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str4);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue8.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str4);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue8.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue8.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue9 = jsonValue8.toJsonValue();
                                if (jsonValue9 != null) {
                                    throw new NullPointerException(str4);
                                }
                                strOptString4 = (String) jsonValue9;
                            }
                            return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
                        }
                        strOptString3 = jsonValue6.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str4);
                        }
                    }
                    str5 = "Invalid type '";
                    jsonValue8 = jsonMapRequireMap.get("sender");
                    if (jsonValue8 != null) {
                        throw new JsonException(str2 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue8);
                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString4 = jsonValue8.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException(str4);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString4 = jsonValue8.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException(str4);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList4 = jsonValue8.optList();
                        if (objOptList4 != null) {
                            throw new NullPointerException(str4);
                        }
                        strOptString4 = (String) objOptList4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap4 = jsonValue8.optMap();
                        if (objOptMap4 != null) {
                            throw new NullPointerException(str4);
                        }
                        strOptString4 = (String) objOptMap4;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str5 + String.class.getSimpleName() + str + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue9 = jsonValue8.toJsonValue();
                        if (jsonValue9 != null) {
                            throw new NullPointerException(str4);
                        }
                        strOptString4 = (String) jsonValue9;
                    }
                    return new Registered(strOptString3, strOptString2, zBooleanValue, strOptString4);
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

    @Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email;", "Lcom/urbanairship/contacts/ContactChannel;", "registrationInfo", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "(Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;)V", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "isRegistered", "", "()Z", "maskedAddress", "", "getMaskedAddress", "()Ljava/lang/String;", "getRegistrationInfo", "()Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "RegistrationInfo", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

        @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0002\b\t¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Pending", "Registered", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Registered;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        public static abstract class RegistrationInfo implements JsonSerializable {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ RegistrationInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private RegistrationInfo() {
            }

            @Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001b"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Registered;", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "channelId", "", "maskedAddress", "transactionalOptedIn", "", "transactionalOptedOut", "commercialOptedIn", "commercialOptedOut", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getChannelId", "()Ljava/lang/String;", "getCommercialOptedIn", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommercialOptedOut", "getMaskedAddress", "getTransactionalOptedIn", "getTransactionalOptedOut", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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

            @Metadata(m1835d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Pending;", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "address", "", "registrationOptions", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/EmailRegistrationOptions;)V", "getAddress", "()Ljava/lang/String;", "getRegistrationOptions", "()Lcom/urbanairship/contacts/EmailRegistrationOptions;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("type", ETCPurchaseStatus.PENDING), TuplesKt.m1842to("address", pending.getAddress()), TuplesKt.m1842to("options", pending.getRegistrationOptions()));
                } else {
                    if (!(this instanceof Registered)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Pair pairM1842to = TuplesKt.m1842to("type", "registered");
                    Registered registered = (Registered) this;
                    Pair pairM1842to2 = TuplesKt.m1842to("address", registered.getMaskedAddress());
                    Pair pairM1842to3 = TuplesKt.m1842to("channel_id", registered.getChannelId());
                    Long commercialOptedIn = registered.getCommercialOptedIn();
                    Pair pairM1842to4 = TuplesKt.m1842to("commercial_opted_in", commercialOptedIn != null ? DateUtils.createIso8601TimeStamp(commercialOptedIn.longValue()) : null);
                    Long commercialOptedOut = registered.getCommercialOptedOut();
                    Pair pairM1842to5 = TuplesKt.m1842to("commercial_opted_out", commercialOptedOut != null ? DateUtils.createIso8601TimeStamp(commercialOptedOut.longValue()) : null);
                    Long transactionalOptedIn = registered.getTransactionalOptedIn();
                    Pair pairM1842to6 = TuplesKt.m1842to("transactional_opted_in", transactionalOptedIn != null ? DateUtils.createIso8601TimeStamp(transactionalOptedIn.longValue()) : null);
                    Long transactionalOptedOut = registered.getTransactionalOptedOut();
                    jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(pairM1842to, pairM1842to2, pairM1842to3, pairM1842to4, pairM1842to5, pairM1842to6, TuplesKt.m1842to("transactional_opted_out", transactionalOptedOut != null ? DateUtils.createIso8601TimeStamp(transactionalOptedOut.longValue()) : null));
                }
                JsonValue jsonValue = jsonMapJsonMapOf.toJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }

            @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nContactChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,522:1\n44#2,15:523\n44#2,15:538\n44#2,15:553\n44#2,15:568\n*S KotlinDebug\n*F\n+ 1 ContactChannel.kt\ncom/urbanairship/contacts/ContactChannel$Email$RegistrationInfo$Companion\n*L\n469#1:523,15\n471#1:538,15\n478#1:553,15\n479#1:568,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Code duplicated, block: B:101:0x026b  */
                /* JADX WARN: Code duplicated, block: B:102:0x026e  */
                /* JADX WARN: Code duplicated, block: B:104:0x0274  */
                /* JADX WARN: Code duplicated, block: B:106:0x027e  */
                /* JADX WARN: Code duplicated, block: B:108:0x0284  */
                /* JADX WARN: Code duplicated, block: B:109:0x0287  */
                /* JADX WARN: Code duplicated, block: B:111:0x028d  */
                /* JADX WARN: Code duplicated, block: B:113:0x0297  */
                /* JADX WARN: Code duplicated, block: B:115:0x029d  */
                /* JADX WARN: Code duplicated, block: B:117:0x02b5  */
                /* JADX WARN: Code duplicated, block: B:119:0x02bb  */
                /* JADX WARN: Code duplicated, block: B:121:0x02df  */
                /* JADX WARN: Code duplicated, block: B:123:0x02f9  */
                /* JADX WARN: Code duplicated, block: B:125:0x0301  */
                /* JADX WARN: Code duplicated, block: B:127:0x0307  */
                /* JADX WARN: Code duplicated, block: B:129:0x0318  */
                /* JADX WARN: Code duplicated, block: B:132:0x0322  */
                /* JADX WARN: Code duplicated, block: B:134:0x0328  */
                /* JADX WARN: Code duplicated, block: B:136:0x0332  */
                /* JADX WARN: Code duplicated, block: B:139:0x0339  */
                /* JADX WARN: Code duplicated, block: B:141:0x033f  */
                /* JADX WARN: Code duplicated, block: B:143:0x034b  */
                /* JADX WARN: Code duplicated, block: B:144:0x0357  */
                /* JADX WARN: Code duplicated, block: B:146:0x0363  */
                /* JADX WARN: Code duplicated, block: B:147:0x0370  */
                /* JADX WARN: Code duplicated, block: B:149:0x037c  */
                /* JADX WARN: Code duplicated, block: B:150:0x038b  */
                /* JADX WARN: Code duplicated, block: B:152:0x0397  */
                /* JADX WARN: Code duplicated, block: B:153:0x03a5  */
                /* JADX WARN: Code duplicated, block: B:155:0x03b1  */
                /* JADX WARN: Code duplicated, block: B:156:0x03be  */
                /* JADX WARN: Code duplicated, block: B:158:0x03c8  */
                /* JADX WARN: Code duplicated, block: B:159:0x03d5  */
                /* JADX WARN: Code duplicated, block: B:161:0x03e0  */
                /* JADX WARN: Code duplicated, block: B:162:0x03f0  */
                /* JADX WARN: Code duplicated, block: B:164:0x03fa  */
                /* JADX WARN: Code duplicated, block: B:166:0x0400  */
                /* JADX WARN: Code duplicated, block: B:167:0x0404  */
                /* JADX WARN: Code duplicated, block: B:169:0x040a  */
                /* JADX WARN: Code duplicated, block: B:171:0x0414  */
                /* JADX WARN: Code duplicated, block: B:173:0x041a  */
                /* JADX WARN: Code duplicated, block: B:174:0x041e  */
                /* JADX WARN: Code duplicated, block: B:176:0x0424  */
                /* JADX WARN: Code duplicated, block: B:178:0x042e  */
                /* JADX WARN: Code duplicated, block: B:180:0x0434  */
                /* JADX WARN: Code duplicated, block: B:183:0x0440  */
                /* JADX WARN: Code duplicated, block: B:185:0x0451  */
                /* JADX WARN: Code duplicated, block: B:188:0x045b  */
                /* JADX WARN: Code duplicated, block: B:190:0x0461  */
                /* JADX WARN: Code duplicated, block: B:192:0x046b  */
                /* JADX WARN: Code duplicated, block: B:195:0x0472  */
                /* JADX WARN: Code duplicated, block: B:197:0x0478  */
                /* JADX WARN: Code duplicated, block: B:199:0x0484  */
                /* JADX WARN: Code duplicated, block: B:200:0x0490  */
                /* JADX WARN: Code duplicated, block: B:202:0x049c  */
                /* JADX WARN: Code duplicated, block: B:203:0x04a9  */
                /* JADX WARN: Code duplicated, block: B:205:0x04b5  */
                /* JADX WARN: Code duplicated, block: B:206:0x04c4  */
                /* JADX WARN: Code duplicated, block: B:208:0x04d0  */
                /* JADX WARN: Code duplicated, block: B:209:0x04de  */
                /* JADX WARN: Code duplicated, block: B:211:0x04ea  */
                /* JADX WARN: Code duplicated, block: B:212:0x04f7  */
                /* JADX WARN: Code duplicated, block: B:214:0x0501  */
                /* JADX WARN: Code duplicated, block: B:215:0x050e  */
                /* JADX WARN: Code duplicated, block: B:217:0x0519  */
                /* JADX WARN: Code duplicated, block: B:218:0x0529  */
                /* JADX WARN: Code duplicated, block: B:220:0x0533  */
                /* JADX WARN: Code duplicated, block: B:222:0x0539  */
                /* JADX WARN: Code duplicated, block: B:223:0x053d  */
                /* JADX WARN: Code duplicated, block: B:225:0x0543  */
                /* JADX WARN: Code duplicated, block: B:227:0x054d  */
                /* JADX WARN: Code duplicated, block: B:229:0x0553  */
                /* JADX WARN: Code duplicated, block: B:230:0x0557  */
                /* JADX WARN: Code duplicated, block: B:232:0x055d  */
                /* JADX WARN: Code duplicated, block: B:234:0x0567  */
                /* JADX WARN: Code duplicated, block: B:236:0x056d  */
                /* JADX WARN: Code duplicated, block: B:239:0x0593  */
                /* JADX WARN: Code duplicated, block: B:241:0x0599  */
                /* JADX WARN: Code duplicated, block: B:243:0x05bd  */
                /* JADX WARN: Code duplicated, block: B:245:0x05d7  */
                /* JADX WARN: Code duplicated, block: B:247:0x05dd  */
                /* JADX WARN: Code duplicated, block: B:249:0x0601  */
                /* JADX WARN: Code duplicated, block: B:251:0x061b  */
                /* JADX WARN: Code duplicated, block: B:60:0x016a  */
                /* JADX WARN: Code duplicated, block: B:62:0x0172  */
                /* JADX WARN: Code duplicated, block: B:64:0x0183  */
                /* JADX WARN: Code duplicated, block: B:67:0x018b  */
                /* JADX WARN: Code duplicated, block: B:69:0x0191  */
                /* JADX WARN: Code duplicated, block: B:71:0x019b  */
                /* JADX WARN: Code duplicated, block: B:74:0x01a3  */
                /* JADX WARN: Code duplicated, block: B:76:0x01a9  */
                /* JADX WARN: Code duplicated, block: B:78:0x01b5  */
                /* JADX WARN: Code duplicated, block: B:79:0x01c2  */
                /* JADX WARN: Code duplicated, block: B:81:0x01ce  */
                /* JADX WARN: Code duplicated, block: B:82:0x01dc  */
                /* JADX WARN: Code duplicated, block: B:84:0x01e8  */
                /* JADX WARN: Code duplicated, block: B:85:0x01f8  */
                /* JADX WARN: Code duplicated, block: B:87:0x0204  */
                /* JADX WARN: Code duplicated, block: B:88:0x0212  */
                /* JADX WARN: Code duplicated, block: B:90:0x021e  */
                /* JADX WARN: Code duplicated, block: B:91:0x022b  */
                /* JADX WARN: Code duplicated, block: B:93:0x0235  */
                /* JADX WARN: Code duplicated, block: B:94:0x0241  */
                /* JADX WARN: Code duplicated, block: B:96:0x024c  */
                /* JADX WARN: Code duplicated, block: B:97:0x025b  */
                /* JADX WARN: Code duplicated, block: B:99:0x0265  */
                /* JADX WARN: Instruction removed from duplicated block: B:119:0x02bb, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:121:0x02df, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:241:0x0599, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:243:0x05bd, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:247:0x05dd, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:249:0x0601, please report this as an issue */
                /* JADX WARN: Instruction removed from duplicated block: B:251:0x061b, please report this as an issue */
                @NotNull
                public final RegistrationInfo fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                    String str;
                    String strOptString;
                    JsonValue jsonValue2;
                    KClass orCreateKotlinClass;
                    Object jsonValue3;
                    String strOptString2;
                    Object objOptMap;
                    Object objOptList;
                    String str2;
                    JsonValue jsonValue4;
                    KClass orCreateKotlinClass2;
                    Object jsonValue5;
                    String strOptString3;
                    Object objOptMap2;
                    Object objOptList2;
                    JsonValue jsonValue6;
                    KClass orCreateKotlinClass3;
                    Object jsonValue7;
                    String strOptString4;
                    Object objOptMap3;
                    Object objOptList3;
                    Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                    JsonMap jsonMapRequireMap = jsonValue.requireMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                    JsonValue jsonValue8 = jsonMapRequireMap.get("type");
                    if (jsonValue8 == null) {
                        throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue8);
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue8.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str = "' for field '";
                                strOptString = (String) Long.valueOf(jsonValue8.getLong(0L));
                            } else {
                                str = "' for field '";
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString = (String) Integer.valueOf(jsonValue8.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    Object objOptList4 = jsonValue8.optList();
                                    if (objOptList4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString = (String) objOptList4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    Object objOptMap4 = jsonValue8.optMap();
                                    if (objOptMap4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString = (String) objOptMap4;
                                } else {
                                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Object jsonValue9 = jsonValue8.toJsonValue();
                                    if (jsonValue9 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString = (String) jsonValue9;
                                }
                            }
                            if (Intrinsics.areEqual(strOptString, ETCPurchaseStatus.PENDING)) {
                                jsonValue6 = jsonMapRequireMap.get("address");
                                if (jsonValue6 != null) {
                                    throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue6);
                                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                    strOptString4 = jsonValue6.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    strOptString4 = jsonValue6.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString4 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    strOptString4 = (String) Long.valueOf(jsonValue6.getLong(0L));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString4 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString4 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString4 = (String) Integer.valueOf(jsonValue6.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList3 = jsonValue6.optList();
                                    if (objOptList3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString4 = (String) objOptList3;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap3 = jsonValue6.optMap();
                                    if (objOptMap3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString4 = (String) objOptMap3;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue7 = jsonValue6.toJsonValue();
                                    if (jsonValue7 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    strOptString4 = (String) jsonValue7;
                                }
                                EmailRegistrationOptions.Companion companion = EmailRegistrationOptions.INSTANCE;
                                JsonValue jsonValueRequire = jsonMapRequireMap.require("options");
                                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                                return new Pending(strOptString4, companion.fromJson$urbanairship_core_release(jsonValueRequire));
                            }
                            if (Intrinsics.areEqual(strOptString, "registered")) {
                                throw new JsonException("Unexpected type " + strOptString);
                            }
                            jsonValue2 = jsonMapRequireMap.get("address");
                            if (jsonValue2 != null) {
                                throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue2);
                            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString2 = jsonValue2.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString2 = jsonValue2.optString();
                                if (strOptString2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString2 = (String) Long.valueOf(jsonValue2.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString2 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString2 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString2 = (String) Integer.valueOf(jsonValue2.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList = jsonValue2.optList();
                                if (objOptList != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) objOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap = jsonValue2.optMap();
                                if (objOptMap != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) objOptMap;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue3 = jsonValue2.toJsonValue();
                                if (jsonValue3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString2 = (String) jsonValue3;
                            }
                            str2 = strOptString2;
                            jsonValue4 = jsonMapRequireMap.get("channel_id");
                            if (jsonValue4 != null) {
                                throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue4);
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue4.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue4.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString3 = (String) Long.valueOf(jsonValue4.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue4.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue4.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue4.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue5 = jsonValue4.toJsonValue();
                                if (jsonValue5 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                strOptString3 = (String) jsonValue5;
                            }
                            return new Registered(strOptString3, str2, JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "transactional_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "transactional_opted_out", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "commercial_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "commercial_opted_out", null, 2, null));
                        }
                        strOptString = jsonValue8.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    str = "' for field '";
                    if (Intrinsics.areEqual(strOptString, ETCPurchaseStatus.PENDING)) {
                        jsonValue6 = jsonMapRequireMap.get("address");
                        if (jsonValue6 != null) {
                            throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue6);
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString4 = jsonValue6.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString4 = jsonValue6.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString4 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString4 = (String) Long.valueOf(jsonValue6.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString4 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString4 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString4 = (String) Integer.valueOf(jsonValue6.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList3 = jsonValue6.optList();
                            if (objOptList3 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString4 = (String) objOptList3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap3 = jsonValue6.optMap();
                            if (objOptMap3 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString4 = (String) objOptMap3;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue7 = jsonValue6.toJsonValue();
                            if (jsonValue7 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            strOptString4 = (String) jsonValue7;
                        }
                        EmailRegistrationOptions.Companion companion2 = EmailRegistrationOptions.INSTANCE;
                        JsonValue jsonValueRequire2 = jsonMapRequireMap.require("options");
                        Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                        return new Pending(strOptString4, companion2.fromJson$urbanairship_core_release(jsonValueRequire2));
                    }
                    if (Intrinsics.areEqual(strOptString, "registered")) {
                        throw new JsonException("Unexpected type " + strOptString);
                    }
                    jsonValue2 = jsonMapRequireMap.get("address");
                    if (jsonValue2 != null) {
                        throw new JsonException("Missing required field: 'address" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue2);
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue2.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue2.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue2.optList();
                        if (objOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue2.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue3 = jsonValue2.toJsonValue();
                        if (jsonValue3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) jsonValue3;
                    }
                    str2 = strOptString2;
                    jsonValue4 = jsonMapRequireMap.get("channel_id");
                    if (jsonValue4 != null) {
                        throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue4);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue4.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue4.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString3 = (String) Long.valueOf(jsonValue4.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue4.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList2 = jsonValue4.optList();
                        if (objOptList2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap2 = jsonValue4.optMap();
                        if (objOptMap2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptMap2;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue5 = jsonValue4.toJsonValue();
                        if (jsonValue5 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) jsonValue5;
                    }
                    return new Registered(strOptString3, str2, JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "transactional_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "transactional_opted_out", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "commercial_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMapRequireMap, "commercial_opted_out", null, 2, null));
                }
            }
        }
    }
}
