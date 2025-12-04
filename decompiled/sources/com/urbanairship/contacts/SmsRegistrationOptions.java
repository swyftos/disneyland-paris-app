package com.urbanairship.contacts;

import androidx.core.util.ObjectsCompat;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/contacts/SmsRegistrationOptions;", "Lcom/urbanairship/json/JsonSerializable;", "senderId", "", "(Ljava/lang/String;)V", "getSenderId", "()Ljava/lang/String;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsRegistrationOptions implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String senderId;

    @JvmStatic
    @NotNull
    public static final SmsRegistrationOptions options(@NotNull String str) {
        return INSTANCE.options(str);
    }

    public SmsRegistrationOptions(@NotNull String senderId) {
        Intrinsics.checkNotNullParameter(senderId, "senderId");
        this.senderId = senderId;
    }

    @NotNull
    public final String getSenderId() {
        return this.senderId;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().put("sender_id", this.senderId).build().toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(SmsRegistrationOptions.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.SmsRegistrationOptions");
        return Intrinsics.areEqual(this.senderId, ((SmsRegistrationOptions) other).senderId);
    }

    public int hashCode() {
        return ObjectsCompat.hashCode(this.senderId);
    }

    @NotNull
    public String toString() {
        return "SmsRegistrationOptions(senderId='" + this.senderId + "')";
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/contacts/SmsRegistrationOptions$Companion;", "", "()V", "SENDER_ID_KEY", "", "fromJson", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "value", "Lcom/urbanairship/json/JsonValue;", "fromJson$urbanairship_core_release", "options", "senderId", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final SmsRegistrationOptions options(@NotNull String senderId) {
            Intrinsics.checkNotNullParameter(senderId, "senderId");
            return new SmsRegistrationOptions(senderId);
        }

        @NotNull
        public final SmsRegistrationOptions fromJson$urbanairship_core_release(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            String strRequireString = value.optMap().opt("sender_id").requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            return new SmsRegistrationOptions(strRequireString);
        }
    }
}
