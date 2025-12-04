package com.urbanairship.contacts;

import androidx.autofill.HintConstants;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.contacts.EmailRegistrationOptions;
import com.urbanairship.contacts.OpenChannelRegistrationOptions;
import com.urbanairship.contacts.SmsRegistrationOptions;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \t2\u00020\u0001:\r\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u000b\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/urbanairship/contacts/ContactOperation;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/contacts/ContactOperation$Type;", "payload", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/contacts/ContactOperation$Type;Lcom/urbanairship/json/JsonValue;)V", "toJsonValue", "AssociateChannel", "Companion", "DisassociateChannel", "Identify", "RegisterEmail", "RegisterOpen", "RegisterSms", "Resend", "Reset", "Resolve", "Type", "Update", "Verify", "Lcom/urbanairship/contacts/ContactOperation$AssociateChannel;", "Lcom/urbanairship/contacts/ContactOperation$DisassociateChannel;", "Lcom/urbanairship/contacts/ContactOperation$Identify;", "Lcom/urbanairship/contacts/ContactOperation$RegisterEmail;", "Lcom/urbanairship/contacts/ContactOperation$RegisterOpen;", "Lcom/urbanairship/contacts/ContactOperation$RegisterSms;", "Lcom/urbanairship/contacts/ContactOperation$Resend;", "Lcom/urbanairship/contacts/ContactOperation$Reset;", "Lcom/urbanairship/contacts/ContactOperation$Resolve;", "Lcom/urbanairship/contacts/ContactOperation$Update;", "Lcom/urbanairship/contacts/ContactOperation$Verify;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ContactOperation implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String PAYLOAD_KEY = "PAYLOAD_KEY";

    @NotNull
    public static final String TYPE_KEY = "TYPE_KEY";
    private final JsonValue payload;
    private final Type type;

    public /* synthetic */ ContactOperation(Type type, JsonValue jsonValue, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, jsonValue);
    }

    @JvmStatic
    @NotNull
    public static final ContactOperation fromJson(@NotNull JsonValue jsonValue) {
        return INSTANCE.fromJson(jsonValue);
    }

    private ContactOperation(Type type, JsonValue jsonValue) {
        this.type = type;
        this.payload = jsonValue;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(TYPE_KEY, this.type.name()), TuplesKt.to(PAYLOAD_KEY, this.payload)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Resolve;", "Lcom/urbanairship/contacts/ContactOperation;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Resolve extends ContactOperation {

        @NotNull
        public static final Resolve INSTANCE = new Resolve();

        private Resolve() {
            super(Type.RESOLVE, null, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Reset;", "Lcom/urbanairship/contacts/ContactOperation;", "()V", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Reset extends ContactOperation {

        @NotNull
        public static final Reset INSTANCE = new Reset();

        private Reset() {
            super(Type.RESET, null, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Verify;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "dateMs", "", "required", "", "(JZ)V", "getDateMs", "()J", "getRequired", "()Z", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$Verify\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n44#2,15:219\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$Verify\n*L\n36#1:204,15\n37#1:219,15\n*E\n"})
    public static final /* data */ class Verify extends ContactOperation {
        private final long dateMs;
        private final boolean required;

        public static /* synthetic */ Verify copy$default(Verify verify, long j, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                j = verify.dateMs;
            }
            if ((i & 2) != 0) {
                z = verify.required;
            }
            return verify.copy(j, z);
        }

        /* renamed from: component1, reason: from getter */
        public final long getDateMs() {
            return this.dateMs;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRequired() {
            return this.required;
        }

        @NotNull
        public final Verify copy(long dateMs, boolean required) {
            return new Verify(dateMs, required);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Verify)) {
                return false;
            }
            Verify verify = (Verify) other;
            return this.dateMs == verify.dateMs && this.required == verify.required;
        }

        public int hashCode() {
            return (Long.hashCode(this.dateMs) * 31) + Boolean.hashCode(this.required);
        }

        @NotNull
        public String toString() {
            return "Verify(dateMs=" + this.dateMs + ", required=" + this.required + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Verify(long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? false : z);
        }

        public final long getDateMs() {
            return this.dateMs;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public Verify(long j, boolean z) {
            super(Type.VERIFY, JsonExtensionsKt.jsonMapOf(TuplesKt.to("DATE", Long.valueOf(j)), TuplesKt.to("REQUIRED", Boolean.valueOf(z))).getJsonValue(), null);
            this.dateMs = j;
            this.required = z;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Removed duplicated region for block: B:121:0x02d9  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x016c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Verify(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 823
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactOperation.Verify.<init>(com.urbanairship.json.JsonMap):void");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Identify;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "identifier", "", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Identify extends ContactOperation {
        private final String identifier;

        public static /* synthetic */ Identify copy$default(Identify identify, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = identify.identifier;
            }
            return identify.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final Identify copy(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new Identify(identifier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Identify) && Intrinsics.areEqual(this.identifier, ((Identify) other).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        @NotNull
        public String toString() {
            return "Identify(identifier=" + this.identifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Identify(@NotNull String identifier) {
            super(Type.IDENTIFY, JsonValue.wrapOpt(identifier), null);
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Identify(@NotNull JsonValue json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            String strRequireString = json.requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            this(strRequireString);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$AssociateChannel;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "channelId", "", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "(Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;)V", "getChannelId", "()Ljava/lang/String;", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$AssociateChannel\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n44#2,15:219\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$AssociateChannel\n*L\n99#1:204,15\n100#1:219,15\n*E\n"})
    public static final /* data */ class AssociateChannel extends ContactOperation {
        private final String channelId;
        private final ChannelType channelType;

        public static /* synthetic */ AssociateChannel copy$default(AssociateChannel associateChannel, String str, ChannelType channelType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = associateChannel.channelId;
            }
            if ((i & 2) != 0) {
                channelType = associateChannel.channelType;
            }
            return associateChannel.copy(str, channelType);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final ChannelType getChannelType() {
            return this.channelType;
        }

        @NotNull
        public final AssociateChannel copy(@NotNull String channelId, @NotNull ChannelType channelType) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(channelType, "channelType");
            return new AssociateChannel(channelId, channelType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AssociateChannel)) {
                return false;
            }
            AssociateChannel associateChannel = (AssociateChannel) other;
            return Intrinsics.areEqual(this.channelId, associateChannel.channelId) && this.channelType == associateChannel.channelType;
        }

        public int hashCode() {
            return (this.channelId.hashCode() * 31) + this.channelType.hashCode();
        }

        @NotNull
        public String toString() {
            return "AssociateChannel(channelId=" + this.channelId + ", channelType=" + this.channelType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Removed duplicated region for block: B:123:0x02c3 A[Catch: IllegalArgumentException -> 0x017e, TryCatch #0 {IllegalArgumentException -> 0x017e, blocks: (B:58:0x0157, B:60:0x015f, B:62:0x0170, B:116:0x028f, B:65:0x0178, B:66:0x017d, B:69:0x0181, B:71:0x018b, B:74:0x0193, B:75:0x0198, B:76:0x0199, B:78:0x01a5, B:79:0x01b2, B:81:0x01be, B:82:0x01cc, B:84:0x01d6, B:85:0x01e8, B:87:0x01f4, B:88:0x0202, B:90:0x020e, B:91:0x021b, B:93:0x0225, B:94:0x0231, B:96:0x023b, B:97:0x024b, B:99:0x0255, B:101:0x025b, B:102:0x025e, B:103:0x0263, B:104:0x0264, B:106:0x026e, B:108:0x0274, B:109:0x0277, B:110:0x027c, B:111:0x027d, B:113:0x0287, B:115:0x028d, B:119:0x0299, B:120:0x029e, B:121:0x029f, B:122:0x02c2, B:123:0x02c3, B:124:0x02dc), top: B:133:0x0157 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x015f A[Catch: IllegalArgumentException -> 0x017e, TryCatch #0 {IllegalArgumentException -> 0x017e, blocks: (B:58:0x0157, B:60:0x015f, B:62:0x0170, B:116:0x028f, B:65:0x0178, B:66:0x017d, B:69:0x0181, B:71:0x018b, B:74:0x0193, B:75:0x0198, B:76:0x0199, B:78:0x01a5, B:79:0x01b2, B:81:0x01be, B:82:0x01cc, B:84:0x01d6, B:85:0x01e8, B:87:0x01f4, B:88:0x0202, B:90:0x020e, B:91:0x021b, B:93:0x0225, B:94:0x0231, B:96:0x023b, B:97:0x024b, B:99:0x0255, B:101:0x025b, B:102:0x025e, B:103:0x0263, B:104:0x0264, B:106:0x026e, B:108:0x0274, B:109:0x0277, B:110:0x027c, B:111:0x027d, B:113:0x0287, B:115:0x028d, B:119:0x0299, B:120:0x029e, B:121:0x029f, B:122:0x02c2, B:123:0x02c3, B:124:0x02dc), top: B:133:0x0157 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public AssociateChannel(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r24) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 824
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactOperation.AssociateChannel.<init>(com.urbanairship.json.JsonMap):void");
        }

        @NotNull
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        public final ChannelType getChannelType() {
            return this.channelType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AssociateChannel(@NotNull String channelId, @NotNull ChannelType channelType) {
            super(Type.ASSOCIATE_CHANNEL, JsonExtensionsKt.jsonMapOf(TuplesKt.to("CHANNEL_ID", channelId), TuplesKt.to("CHANNEL_TYPE", channelType.name())).getJsonValue(), null);
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(channelType, "channelType");
            this.channelId = channelId;
            this.channelType = channelType;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$RegisterEmail;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS, "", "options", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/EmailRegistrationOptions;)V", "getEmailAddress", "()Ljava/lang/String;", "getOptions", "()Lcom/urbanairship/contacts/EmailRegistrationOptions;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$RegisterEmail\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n44#2,15:219\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$RegisterEmail\n*L\n118#1:204,15\n119#1:219,15\n*E\n"})
    public static final /* data */ class RegisterEmail extends ContactOperation {
        private final String emailAddress;
        private final EmailRegistrationOptions options;

        public static /* synthetic */ RegisterEmail copy$default(RegisterEmail registerEmail, String str, EmailRegistrationOptions emailRegistrationOptions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = registerEmail.emailAddress;
            }
            if ((i & 2) != 0) {
                emailRegistrationOptions = registerEmail.options;
            }
            return registerEmail.copy(str, emailRegistrationOptions);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getEmailAddress() {
            return this.emailAddress;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final EmailRegistrationOptions getOptions() {
            return this.options;
        }

        @NotNull
        public final RegisterEmail copy(@NotNull String emailAddress, @NotNull EmailRegistrationOptions options) {
            Intrinsics.checkNotNullParameter(emailAddress, "emailAddress");
            Intrinsics.checkNotNullParameter(options, "options");
            return new RegisterEmail(emailAddress, options);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RegisterEmail)) {
                return false;
            }
            RegisterEmail registerEmail = (RegisterEmail) other;
            return Intrinsics.areEqual(this.emailAddress, registerEmail.emailAddress) && Intrinsics.areEqual(this.options, registerEmail.options);
        }

        public int hashCode() {
            return (this.emailAddress.hashCode() * 31) + this.options.hashCode();
        }

        @NotNull
        public String toString() {
            return "RegisterEmail(emailAddress=" + this.emailAddress + ", options=" + this.options + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public RegisterEmail(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            JsonValue jsonValue;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue2 = json.get("EMAIL_ADDRESS");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'EMAIL_ADDRESS" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue2);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
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
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue2.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue2.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'EMAIL_ADDRESS" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue3 = jsonValue2.getJsonValue();
                if (jsonValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue3;
            }
            EmailRegistrationOptions.Companion companion = EmailRegistrationOptions.INSTANCE;
            JsonValue jsonValue4 = json.get("OPTIONS");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'OPTIONS" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonValue = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                if (jsonSerializableOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'OPTIONS" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue = jsonValue4.getJsonValue();
                if (jsonValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
            }
            this(strOptString, companion.fromJson$urbanairship_core_release(jsonValue));
        }

        @NotNull
        public final String getEmailAddress() {
            return this.emailAddress;
        }

        @NotNull
        public final EmailRegistrationOptions getOptions() {
            return this.options;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RegisterEmail(@NotNull String emailAddress, @NotNull EmailRegistrationOptions options) {
            super(Type.REGISTER_EMAIL, JsonExtensionsKt.jsonMapOf(TuplesKt.to("EMAIL_ADDRESS", emailAddress), TuplesKt.to("OPTIONS", options)).getJsonValue(), null);
            Intrinsics.checkNotNullParameter(emailAddress, "emailAddress");
            Intrinsics.checkNotNullParameter(options, "options");
            this.emailAddress = emailAddress;
            this.options = options;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$RegisterOpen;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "address", "", "options", "Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;)V", "getAddress", "()Ljava/lang/String;", "getOptions", "()Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$RegisterOpen\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n44#2,15:219\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$RegisterOpen\n*L\n150#1:204,15\n151#1:219,15\n*E\n"})
    public static final /* data */ class RegisterOpen extends ContactOperation {
        private final String address;
        private final OpenChannelRegistrationOptions options;

        public static /* synthetic */ RegisterOpen copy$default(RegisterOpen registerOpen, String str, OpenChannelRegistrationOptions openChannelRegistrationOptions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = registerOpen.address;
            }
            if ((i & 2) != 0) {
                openChannelRegistrationOptions = registerOpen.options;
            }
            return registerOpen.copy(str, openChannelRegistrationOptions);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final OpenChannelRegistrationOptions getOptions() {
            return this.options;
        }

        @NotNull
        public final RegisterOpen copy(@NotNull String address, @NotNull OpenChannelRegistrationOptions options) {
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(options, "options");
            return new RegisterOpen(address, options);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RegisterOpen)) {
                return false;
            }
            RegisterOpen registerOpen = (RegisterOpen) other;
            return Intrinsics.areEqual(this.address, registerOpen.address) && Intrinsics.areEqual(this.options, registerOpen.options);
        }

        public int hashCode() {
            return (this.address.hashCode() * 31) + this.options.hashCode();
        }

        @NotNull
        public String toString() {
            return "RegisterOpen(address=" + this.address + ", options=" + this.options + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public RegisterOpen(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            JsonValue jsonValue;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue2 = json.get("MSISDN");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'MSISDN" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue2);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
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
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue2.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue2.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'MSISDN" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue3 = jsonValue2.getJsonValue();
                if (jsonValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue3;
            }
            OpenChannelRegistrationOptions.Companion companion = OpenChannelRegistrationOptions.INSTANCE;
            JsonValue jsonValue4 = json.get("OPTIONS");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'OPTIONS" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonValue = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                if (jsonSerializableOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'OPTIONS" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue = jsonValue4.getJsonValue();
                if (jsonValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
            }
            this(strOptString, companion.fromJson$urbanairship_core_release(jsonValue));
        }

        @NotNull
        public final String getAddress() {
            return this.address;
        }

        @NotNull
        public final OpenChannelRegistrationOptions getOptions() {
            return this.options;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RegisterOpen(@NotNull String address, @NotNull OpenChannelRegistrationOptions options) {
            super(Type.REGISTER_EMAIL, JsonExtensionsKt.jsonMapOf(TuplesKt.to("ADDRESS", address), TuplesKt.to("OPTIONS", options)).getJsonValue(), null);
            Intrinsics.checkNotNullParameter(address, "address");
            Intrinsics.checkNotNullParameter(options, "options");
            this.address = address;
            this.options = options;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$RegisterSms;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "msisdn", "", "options", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "(Ljava/lang/String;Lcom/urbanairship/contacts/SmsRegistrationOptions;)V", "getMsisdn", "()Ljava/lang/String;", "getOptions", "()Lcom/urbanairship/contacts/SmsRegistrationOptions;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$RegisterSms\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n44#2,15:219\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$RegisterSms\n*L\n134#1:204,15\n135#1:219,15\n*E\n"})
    public static final /* data */ class RegisterSms extends ContactOperation {
        private final String msisdn;
        private final SmsRegistrationOptions options;

        public static /* synthetic */ RegisterSms copy$default(RegisterSms registerSms, String str, SmsRegistrationOptions smsRegistrationOptions, int i, Object obj) {
            if ((i & 1) != 0) {
                str = registerSms.msisdn;
            }
            if ((i & 2) != 0) {
                smsRegistrationOptions = registerSms.options;
            }
            return registerSms.copy(str, smsRegistrationOptions);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getMsisdn() {
            return this.msisdn;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final SmsRegistrationOptions getOptions() {
            return this.options;
        }

        @NotNull
        public final RegisterSms copy(@NotNull String msisdn, @NotNull SmsRegistrationOptions options) {
            Intrinsics.checkNotNullParameter(msisdn, "msisdn");
            Intrinsics.checkNotNullParameter(options, "options");
            return new RegisterSms(msisdn, options);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RegisterSms)) {
                return false;
            }
            RegisterSms registerSms = (RegisterSms) other;
            return Intrinsics.areEqual(this.msisdn, registerSms.msisdn) && Intrinsics.areEqual(this.options, registerSms.options);
        }

        public int hashCode() {
            return (this.msisdn.hashCode() * 31) + this.options.hashCode();
        }

        @NotNull
        public String toString() {
            return "RegisterSms(msisdn=" + this.msisdn + ", options=" + this.options + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public RegisterSms(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            JsonValue jsonValue;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue2 = json.get("MSISDN");
            if (jsonValue2 == null) {
                throw new JsonException("Missing required field: 'MSISDN" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue2);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
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
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue2.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue2.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'MSISDN" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue3 = jsonValue2.getJsonValue();
                if (jsonValue3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue3;
            }
            SmsRegistrationOptions.Companion companion = SmsRegistrationOptions.INSTANCE;
            JsonValue jsonValue4 = json.get("OPTIONS");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'OPTIONS" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonValue = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                if (jsonSerializableOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
                jsonValue = (JsonValue) jsonSerializableOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'OPTIONS" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue = jsonValue4.getJsonValue();
                if (jsonValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                }
            }
            this(strOptString, companion.fromJson$urbanairship_core_release(jsonValue));
        }

        @NotNull
        public final String getMsisdn() {
            return this.msisdn;
        }

        @NotNull
        public final SmsRegistrationOptions getOptions() {
            return this.options;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RegisterSms(@NotNull String msisdn, @NotNull SmsRegistrationOptions options) {
            super(Type.REGISTER_SMS, JsonExtensionsKt.jsonMapOf(TuplesKt.to("MSISDN", msisdn), TuplesKt.to("OPTIONS", options)).getJsonValue(), null);
            Intrinsics.checkNotNullParameter(msisdn, "msisdn");
            Intrinsics.checkNotNullParameter(options, "options");
            this.msisdn = msisdn;
            this.options = options;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$DisassociateChannel;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "optOut", "", "(Lcom/urbanairship/contacts/ContactChannel;Z)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getOptOut", "()Z", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$DisassociateChannel\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$DisassociateChannel\n*L\n57#1:204,15\n*E\n"})
    public static final /* data */ class DisassociateChannel extends ContactOperation {
        private final ContactChannel channel;
        private final boolean optOut;

        public static /* synthetic */ DisassociateChannel copy$default(DisassociateChannel disassociateChannel, ContactChannel contactChannel, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                contactChannel = disassociateChannel.channel;
            }
            if ((i & 2) != 0) {
                z = disassociateChannel.optOut;
            }
            return disassociateChannel.copy(contactChannel, z);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ContactChannel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOptOut() {
            return this.optOut;
        }

        @NotNull
        public final DisassociateChannel copy(@NotNull ContactChannel channel, boolean optOut) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            return new DisassociateChannel(channel, optOut);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DisassociateChannel)) {
                return false;
            }
            DisassociateChannel disassociateChannel = (DisassociateChannel) other;
            return Intrinsics.areEqual(this.channel, disassociateChannel.channel) && this.optOut == disassociateChannel.optOut;
        }

        public int hashCode() {
            return (this.channel.hashCode() * 31) + Boolean.hashCode(this.optOut);
        }

        @NotNull
        public String toString() {
            return "DisassociateChannel(channel=" + this.channel + ", optOut=" + this.optOut + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final ContactChannel getChannel() {
            return this.channel;
        }

        public final boolean getOptOut() {
            return this.optOut;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DisassociateChannel(@NotNull ContactChannel channel, boolean z) {
            super(Type.DISASSOCIATE_CHANNEL, JsonExtensionsKt.jsonMapOf(TuplesKt.to("CHANNEL", channel), TuplesKt.to("OPT_OUT", Boolean.valueOf(z))).getJsonValue(), null);
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.optOut = z;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public DisassociateChannel(@NotNull JsonValue json) throws JsonException {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(json, "json");
            ContactChannel.Companion companion = ContactChannel.INSTANCE;
            JsonValue jsonValueRequire = json.requireMap().require("CHANNEL");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            ContactChannel contactChannelFromJson = companion.fromJson(jsonValueRequire);
            JsonMap jsonMapRequireMap = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("OPT_OUT");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'OPT_OUT" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                boolValueOf = (Boolean) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                boolValueOf = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                boolValueOf = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'OPT_OUT" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jsonValue2;
            }
            this(contactChannelFromJson, boolValueOf.booleanValue());
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Resend;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Resend extends ContactOperation {
        private final ContactChannel channel;

        public static /* synthetic */ Resend copy$default(Resend resend, ContactChannel contactChannel, int i, Object obj) {
            if ((i & 1) != 0) {
                contactChannel = resend.channel;
            }
            return resend.copy(contactChannel);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ContactChannel getChannel() {
            return this.channel;
        }

        @NotNull
        public final Resend copy(@NotNull ContactChannel channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            return new Resend(channel);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Resend) && Intrinsics.areEqual(this.channel, ((Resend) other).channel);
        }

        public int hashCode() {
            return this.channel.hashCode();
        }

        @NotNull
        public String toString() {
            return "Resend(channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @NotNull
        public final ContactChannel getChannel() {
            return this.channel;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Resend(@NotNull ContactChannel channel) {
            super(Type.RESEND, JsonValue.wrapOpt(channel), null);
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Resend(@NotNull JsonValue json) {
            this(ContactChannel.INSTANCE.fromJson(json));
            Intrinsics.checkNotNullParameter(json, "json");
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B;\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Update;", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", FetchDeviceInfoAction.TAGS_KEY, "", "Lcom/urbanairship/channel/TagGroupsMutation;", "attributes", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptions", "Lcom/urbanairship/contacts/ScopedSubscriptionListMutation;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAttributes", "()Ljava/util/List;", "getSubscriptions", "getTags", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$Update\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n1#2:204\n*E\n"})
    public static final /* data */ class Update extends ContactOperation {
        private final List attributes;
        private final List subscriptions;
        private final List tags;

        public Update() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Update copy$default(Update update, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = update.tags;
            }
            if ((i & 2) != 0) {
                list2 = update.attributes;
            }
            if ((i & 4) != 0) {
                list3 = update.subscriptions;
            }
            return update.copy(list, list2, list3);
        }

        @Nullable
        public final List<TagGroupsMutation> component1() {
            return this.tags;
        }

        @Nullable
        public final List<AttributeMutation> component2() {
            return this.attributes;
        }

        @Nullable
        public final List<ScopedSubscriptionListMutation> component3() {
            return this.subscriptions;
        }

        @NotNull
        public final Update copy(@Nullable List<? extends TagGroupsMutation> tags, @Nullable List<? extends AttributeMutation> attributes, @Nullable List<? extends ScopedSubscriptionListMutation> subscriptions) {
            return new Update(tags, attributes, subscriptions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Update)) {
                return false;
            }
            Update update = (Update) other;
            return Intrinsics.areEqual(this.tags, update.tags) && Intrinsics.areEqual(this.attributes, update.attributes) && Intrinsics.areEqual(this.subscriptions, update.subscriptions);
        }

        public int hashCode() {
            List list = this.tags;
            int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
            List list2 = this.attributes;
            int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
            List list3 = this.subscriptions;
            return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Update(tags=" + this.tags + ", attributes=" + this.attributes + ", subscriptions=" + this.subscriptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ Update(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
        }

        @Nullable
        public final List<TagGroupsMutation> getTags() {
            return this.tags;
        }

        @Nullable
        public final List<AttributeMutation> getAttributes() {
            return this.attributes;
        }

        @Nullable
        public final List<ScopedSubscriptionListMutation> getSubscriptions() {
            return this.subscriptions;
        }

        public Update(@Nullable List<? extends TagGroupsMutation> list, @Nullable List<? extends AttributeMutation> list2, @Nullable List<? extends ScopedSubscriptionListMutation> list3) {
            super(Type.UPDATE, JsonExtensionsKt.jsonMapOf(TuplesKt.to("TAG_GROUP_MUTATIONS_KEY", list), TuplesKt.to("ATTRIBUTE_MUTATIONS_KEY", list2), TuplesKt.to("SUBSCRIPTION_LISTS_MUTATIONS_KEY", list3)).getJsonValue(), null);
            this.tags = list;
            this.attributes = list2;
            this.subscriptions = list3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Update(@NotNull JsonMap json) {
            Intrinsics.checkNotNullParameter(json, "json");
            List<TagGroupsMutation> listFromJsonList = TagGroupsMutation.fromJsonList(json.opt("TAG_GROUP_MUTATIONS_KEY").optList());
            listFromJsonList = listFromJsonList.isEmpty() ? null : listFromJsonList;
            List<AttributeMutation> listFromJsonList2 = AttributeMutation.fromJsonList(json.opt("ATTRIBUTE_MUTATIONS_KEY").optList());
            listFromJsonList2 = listFromJsonList2.isEmpty() ? null : listFromJsonList2;
            List<ScopedSubscriptionListMutation> listFromJsonList3 = ScopedSubscriptionListMutation.fromJsonList(json.opt("SUBSCRIPTION_LISTS_MUTATIONS_KEY").optList());
            this(listFromJsonList, listFromJsonList2, listFromJsonList3.isEmpty() ? null : listFromJsonList3);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Type;", "", "(Ljava/lang/String;I)V", "UPDATE", "IDENTIFY", "RESOLVE", "RESET", "REGISTER_EMAIL", "REGISTER_SMS", "REGISTER_OPEN_CHANNEL", "ASSOCIATE_CHANNEL", "VERIFY", "RESEND", "DISASSOCIATE_CHANNEL", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type UPDATE = new Type("UPDATE", 0);
        public static final Type IDENTIFY = new Type("IDENTIFY", 1);
        public static final Type RESOLVE = new Type("RESOLVE", 2);
        public static final Type RESET = new Type("RESET", 3);
        public static final Type REGISTER_EMAIL = new Type("REGISTER_EMAIL", 4);
        public static final Type REGISTER_SMS = new Type("REGISTER_SMS", 5);
        public static final Type REGISTER_OPEN_CHANNEL = new Type("REGISTER_OPEN_CHANNEL", 6);
        public static final Type ASSOCIATE_CHANNEL = new Type("ASSOCIATE_CHANNEL", 7);
        public static final Type VERIFY = new Type("VERIFY", 8);
        public static final Type RESEND = new Type("RESEND", 9);
        public static final Type DISASSOCIATE_CHANNEL = new Type("DISASSOCIATE_CHANNEL", 10);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{UPDATE, IDENTIFY, RESOLVE, RESET, REGISTER_EMAIL, REGISTER_SMS, REGISTER_OPEN_CHANNEL, ASSOCIATE_CHANNEL, VERIFY, RESEND, DISASSOCIATE_CHANNEL};
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i) {
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/contacts/ContactOperation$Companion;", "", "()V", "ADDRESS_KEY", "", "ATTRIBUTE_MUTATIONS_KEY", "CHANNEL_ID_KEY", "CHANNEL_KEY", "CHANNEL_TYPE_KEY", "DATE_KEY", "EMAIL_ADDRESS_KEY", "MSISDN_KEY", "OPTIONS_KEY", "OPT_OUT_KEY", ContactOperation.PAYLOAD_KEY, "REQUIRED_KEY", "SUBSCRIPTION_LISTS_MUTATIONS_KEY", "TAG_GROUP_MUTATIONS_KEY", ContactOperation.TYPE_KEY, "fromJson", "Lcom/urbanairship/contacts/ContactOperation;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,203:1\n44#2,15:204\n44#2,15:219\n44#2,15:234\n44#2,15:249\n44#2,15:264\n44#2,15:279\n44#2,15:294\n44#2,15:309\n*S KotlinDebug\n*F\n+ 1 ContactOperation.kt\ncom/urbanairship/contacts/ContactOperation$Companion\n*L\n165#1:204,15\n172#1:219,15\n174#1:234,15\n175#1:249,15\n176#1:264,15\n177#1:279,15\n178#1:294,15\n179#1:309,15\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.RESOLVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.IDENTIFY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Type.RESET.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Type.UPDATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Type.ASSOCIATE_CHANNEL.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Type.REGISTER_EMAIL.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Type.REGISTER_OPEN_CHANNEL.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[Type.REGISTER_SMS.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[Type.VERIFY.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[Type.RESEND.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[Type.DISASSOCIATE_CHANNEL.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ContactOperation fromJson(@NotNull JsonValue json) {
            String strOptString;
            ContactOperation identify;
            JsonValue jsonValue;
            JsonMap jsonMapOptMap;
            JsonMap jsonMapOptMap2;
            JsonMap jsonMapOptMap3;
            JsonMap jsonMapOptMap4;
            JsonMap jsonMapOptMap5;
            JsonMap jsonMapOptMap6;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapRequireMap = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            try {
                JsonValue jsonValue2 = jsonMapRequireMap.get("type");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue2);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
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
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue3;
                }
                switch (WhenMappings.$EnumSwitchMapping$0[Type.valueOf(strOptString).ordinal()]) {
                    case 1:
                        return Resolve.INSTANCE;
                    case 2:
                        JsonValue jsonValue4 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue4 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue4);
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString = jsonValue4.optString();
                            if (objOptString == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                            }
                            jsonValue = (JsonValue) objOptString;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString2 = jsonValue4.optString();
                            if (objOptString2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                            }
                            jsonValue = (JsonValue) objOptString2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonValue = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonValue = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonValue = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonValue = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonValue = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                            if (jsonSerializableOptList == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                            }
                            jsonValue = (JsonValue) jsonSerializableOptList;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            JsonSerializable jsonSerializableOptMap = jsonValue4.optMap();
                            if (jsonSerializableOptMap == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                            }
                            jsonValue = (JsonValue) jsonSerializableOptMap;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue = jsonValue4.getJsonValue();
                            if (jsonValue == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                            }
                        }
                        identify = new Identify(jsonValue);
                        break;
                    case 3:
                        return Reset.INSTANCE;
                    case 4:
                        JsonValue jsonValue5 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue5 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue5);
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString3 = jsonValue5.optString();
                            if (objOptString3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap = (JsonMap) objOptString3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString4 = jsonValue5.optString();
                            if (objOptString4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap = (JsonMap) objOptString4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue5.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue5.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue5.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList2 = jsonValue5.optList();
                            if (jsonSerializableOptList2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap = (JsonMap) jsonSerializableOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue5.optMap();
                            if (jsonMapOptMap == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            JsonSerializable jsonValue6 = jsonValue5.getJsonValue();
                            if (jsonValue6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap = (JsonMap) jsonValue6;
                        }
                        identify = new Update(jsonMapOptMap);
                        break;
                    case 5:
                        JsonValue jsonValue7 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue7 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue7);
                        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString5 = jsonValue7.optString();
                            if (objOptString5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap2 = (JsonMap) objOptString5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString6 = jsonValue7.optString();
                            if (objOptString6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap2 = (JsonMap) objOptString6;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue7.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue7.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap2 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue7.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap2 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList3 = jsonValue7.optList();
                            if (jsonSerializableOptList3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap2 = (JsonMap) jsonSerializableOptList3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap2 = jsonValue7.optMap();
                            if (jsonMapOptMap2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            JsonSerializable jsonValue8 = jsonValue7.getJsonValue();
                            if (jsonValue8 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap2 = (JsonMap) jsonValue8;
                        }
                        identify = new AssociateChannel(jsonMapOptMap2);
                        break;
                    case 6:
                        JsonValue jsonValue9 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue9 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue9);
                        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString7 = jsonValue9.optString();
                            if (objOptString7 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap3 = (JsonMap) objOptString7;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString8 = jsonValue9.optString();
                            if (objOptString8 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap3 = (JsonMap) objOptString8;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap3 = (JsonMap) Boolean.valueOf(jsonValue9.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap3 = (JsonMap) Long.valueOf(jsonValue9.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap3 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap3 = (JsonMap) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap3 = (JsonMap) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonMapOptMap3 = (JsonMap) Integer.valueOf(jsonValue9.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap3 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList4 = jsonValue9.optList();
                            if (jsonSerializableOptList4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap3 = (JsonMap) jsonSerializableOptList4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap3 = jsonValue9.optMap();
                            if (jsonMapOptMap3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            JsonSerializable jsonValue10 = jsonValue9.getJsonValue();
                            if (jsonValue10 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap3 = (JsonMap) jsonValue10;
                        }
                        identify = new RegisterEmail(jsonMapOptMap3);
                        break;
                    case 7:
                        JsonValue jsonValue11 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue11 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue11);
                        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString9 = jsonValue11.optString();
                            if (objOptString9 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap4 = (JsonMap) objOptString9;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString10 = jsonValue11.optString();
                            if (objOptString10 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap4 = (JsonMap) objOptString10;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap4 = (JsonMap) Boolean.valueOf(jsonValue11.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap4 = (JsonMap) Long.valueOf(jsonValue11.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap4 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue11.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap4 = (JsonMap) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap4 = (JsonMap) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonMapOptMap4 = (JsonMap) Integer.valueOf(jsonValue11.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap4 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue11.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList5 = jsonValue11.optList();
                            if (jsonSerializableOptList5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap4 = (JsonMap) jsonSerializableOptList5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap4 = jsonValue11.optMap();
                            if (jsonMapOptMap4 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            JsonSerializable jsonValue12 = jsonValue11.getJsonValue();
                            if (jsonValue12 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap4 = (JsonMap) jsonValue12;
                        }
                        identify = new RegisterOpen(jsonMapOptMap4);
                        break;
                    case 8:
                        JsonValue jsonValue13 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue13 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue13);
                        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString11 = jsonValue13.optString();
                            if (objOptString11 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap5 = (JsonMap) objOptString11;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString12 = jsonValue13.optString();
                            if (objOptString12 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap5 = (JsonMap) objOptString12;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap5 = (JsonMap) Boolean.valueOf(jsonValue13.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap5 = (JsonMap) Long.valueOf(jsonValue13.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap5 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue13.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap5 = (JsonMap) Double.valueOf(jsonValue13.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap5 = (JsonMap) Float.valueOf(jsonValue13.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonMapOptMap5 = (JsonMap) Integer.valueOf(jsonValue13.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap5 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue13.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList6 = jsonValue13.optList();
                            if (jsonSerializableOptList6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap5 = (JsonMap) jsonSerializableOptList6;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap5 = jsonValue13.optMap();
                            if (jsonMapOptMap5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            JsonSerializable jsonValue14 = jsonValue13.getJsonValue();
                            if (jsonValue14 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap5 = (JsonMap) jsonValue14;
                        }
                        identify = new RegisterSms(jsonMapOptMap5);
                        break;
                    case 9:
                        JsonValue jsonValue15 = jsonMapRequireMap.get(ContactOperation.PAYLOAD_KEY);
                        if (jsonValue15 == null) {
                            throw new JsonException("Missing required field: '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue15);
                        KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                            Object objOptString13 = jsonValue15.optString();
                            if (objOptString13 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap6 = (JsonMap) objOptString13;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            Object objOptString14 = jsonValue15.optString();
                            if (objOptString14 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap6 = (JsonMap) objOptString14;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap6 = (JsonMap) Boolean.valueOf(jsonValue15.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap6 = (JsonMap) Long.valueOf(jsonValue15.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap6 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue15.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap6 = (JsonMap) Double.valueOf(jsonValue15.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap6 = (JsonMap) Float.valueOf(jsonValue15.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            jsonMapOptMap6 = (JsonMap) Integer.valueOf(jsonValue15.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap6 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue15.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            JsonSerializable jsonSerializableOptList7 = jsonValue15.optList();
                            if (jsonSerializableOptList7 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap6 = (JsonMap) jsonSerializableOptList7;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap6 = jsonValue15.optMap();
                            if (jsonMapOptMap6 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + ContactOperation.PAYLOAD_KEY + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            JsonSerializable jsonValue16 = jsonValue15.getJsonValue();
                            if (jsonValue16 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                            }
                            jsonMapOptMap6 = (JsonMap) jsonValue16;
                        }
                        identify = new Verify(jsonMapOptMap6);
                        break;
                    case 10:
                        JsonValue jsonValueRequire = jsonMapRequireMap.require(ContactOperation.PAYLOAD_KEY);
                        Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                        return new Resend(jsonValueRequire);
                    case 11:
                        JsonValue jsonValueRequire2 = jsonMapRequireMap.require(ContactOperation.PAYLOAD_KEY);
                        Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
                        return new DisassociateChannel(jsonValueRequire2);
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return identify;
            } catch (Exception e) {
                throw new JsonException("Unknown type! " + jsonMapRequireMap, e);
            }
        }
    }
}
