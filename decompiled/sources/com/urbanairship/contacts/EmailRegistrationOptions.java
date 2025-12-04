package com.urbanairship.contacts;

import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/contacts/EmailRegistrationOptions;", "Lcom/urbanairship/json/JsonSerializable;", "transactionalOptedIn", "", "commercialOptedIn", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "isDoubleOptIn", "", "(JJLcom/urbanairship/json/JsonMap;Z)V", "getCommercialOptedIn", "()J", "()Z", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "getTransactionalOptedIn", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmailRegistrationOptions implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final long commercialOptedIn;
    private final boolean isDoubleOptIn;
    private final JsonMap properties;
    private final long transactionalOptedIn;

    public /* synthetic */ EmailRegistrationOptions(long j, long j2, JsonMap jsonMap, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, jsonMap, z);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions commercialOptions() {
        return INSTANCE.commercialOptions();
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions commercialOptions(@Nullable Date date) {
        return INSTANCE.commercialOptions(date);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions commercialOptions(@Nullable Date date, @Nullable Date date2) {
        return INSTANCE.commercialOptions(date, date2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions commercialOptions(@Nullable Date date, @Nullable Date date2, @Nullable JsonMap jsonMap) {
        return INSTANCE.commercialOptions(date, date2, jsonMap);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions options(@Nullable Date date, @Nullable JsonMap jsonMap, boolean z) {
        return INSTANCE.options(date, jsonMap, z);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions options(@Nullable Date date, boolean z) {
        return INSTANCE.options(date, z);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final EmailRegistrationOptions options(boolean z) {
        return INSTANCE.options(z);
    }

    private EmailRegistrationOptions(long j, long j2, JsonMap jsonMap, boolean z) {
        this.transactionalOptedIn = j;
        this.commercialOptedIn = j2;
        this.properties = jsonMap;
        this.isDoubleOptIn = z;
    }

    public final long getTransactionalOptedIn() {
        return this.transactionalOptedIn;
    }

    public final long getCommercialOptedIn() {
        return this.commercialOptedIn;
    }

    @Nullable
    public final JsonMap getProperties() {
        return this.properties;
    }

    /* renamed from: isDoubleOptIn, reason: from getter */
    public final boolean getIsDoubleOptIn() {
        return this.isDoubleOptIn;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().put("transactional_opted_in", this.transactionalOptedIn).put("commercial_opted_in", this.commercialOptedIn).put(CustomEvent.PROPERTIES, this.properties).put("double_opt_in", this.isDoubleOptIn).build().toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(EmailRegistrationOptions.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.EmailRegistrationOptions");
        EmailRegistrationOptions emailRegistrationOptions = (EmailRegistrationOptions) other;
        return this.transactionalOptedIn == emailRegistrationOptions.transactionalOptedIn && this.commercialOptedIn == emailRegistrationOptions.commercialOptedIn && Intrinsics.areEqual(this.properties, emailRegistrationOptions.properties) && this.isDoubleOptIn == emailRegistrationOptions.isDoubleOptIn;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Long.valueOf(this.transactionalOptedIn), Long.valueOf(this.commercialOptedIn), this.properties, Boolean.valueOf(this.isDoubleOptIn));
    }

    @NotNull
    public String toString() {
        return "EmailRegistrationOptions(transactionalOptedIn=" + this.transactionalOptedIn + ", commercialOptedIn=" + this.commercialOptedIn + ", properties=" + this.properties + ", isDoubleOptIn=" + this.isDoubleOptIn + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J(\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/contacts/EmailRegistrationOptions$Companion;", "", "()V", "COMMERCIAL_OPTED_IN_KEY", "", "DOUBLE_OPT_IN_KEY", "PROPERTIES_KEY", "TRANSACTIONAL_OPTED_IN_KEY", "commercialOptions", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "commercialOptedIn", "Ljava/util/Date;", "transactionalOptedIn", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", "fromJson$urbanairship_core_release", "options", "doubleOptIn", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions commercialOptions() {
            return commercialOptions$default(this, null, null, null, 7, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions commercialOptions(@Nullable Date date) {
            return commercialOptions$default(this, date, null, null, 6, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions commercialOptions(@Nullable Date date, @Nullable Date date2) {
            return commercialOptions$default(this, date, date2, null, 4, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions options(@Nullable Date date, boolean z) {
            return options$default(this, date, null, z, 2, null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions options(boolean z) {
            return options$default(this, null, null, z, 3, null);
        }

        private Companion() {
        }

        public static /* synthetic */ EmailRegistrationOptions commercialOptions$default(Companion companion, Date date, Date date2, JsonMap jsonMap, int i, Object obj) {
            if ((i & 1) != 0) {
                date = null;
            }
            if ((i & 2) != 0) {
                date2 = null;
            }
            if ((i & 4) != 0) {
                jsonMap = null;
            }
            return companion.commercialOptions(date, date2, jsonMap);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions commercialOptions(@Nullable Date commercialOptedIn, @Nullable Date transactionalOptedIn, @Nullable JsonMap properties) {
            return new EmailRegistrationOptions(transactionalOptedIn != null ? transactionalOptedIn.getTime() : -1L, commercialOptedIn != null ? commercialOptedIn.getTime() : -1L, properties, false, null);
        }

        public static /* synthetic */ EmailRegistrationOptions options$default(Companion companion, Date date, JsonMap jsonMap, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                date = null;
            }
            if ((i & 2) != 0) {
                jsonMap = null;
            }
            return companion.options(date, jsonMap, z);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final EmailRegistrationOptions options(@Nullable Date transactionalOptedIn, @Nullable JsonMap properties, boolean doubleOptIn) {
            return new EmailRegistrationOptions(transactionalOptedIn != null ? transactionalOptedIn.getTime() : -1L, -1L, properties, doubleOptIn, null);
        }

        @NotNull
        public final EmailRegistrationOptions fromJson$urbanairship_core_release(@NotNull JsonValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapOptMap = value.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            return new EmailRegistrationOptions(jsonMapOptMap.opt("transactional_opted_in").getLong(-1L), jsonMapOptMap.opt("commercial_opted_in").getLong(-1L), jsonMapOptMap.opt(CustomEvent.PROPERTIES).getMap(), jsonMapOptMap.opt("double_opt_in").getBoolean(false), null);
        }
    }
}
