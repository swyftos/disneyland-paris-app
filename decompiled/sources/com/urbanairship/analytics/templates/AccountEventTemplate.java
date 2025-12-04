package com.urbanairship.analytics.templates;

import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/analytics/templates/AccountEventTemplate;", "", "()V", "Companion", "Properties", "Type", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AccountEventTemplate {

    @NotNull
    public static final String TEMPLATE_NAME = "account";

    public /* synthetic */ AccountEventTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccountEventTemplate() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/analytics/templates/AccountEventTemplate$Type;", "", "eventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName$urbanairship_core_release", "()Ljava/lang/String;", "REGISTERED", "LOGGED_IN", "LOGGED_OUT", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        private final String eventName;
        public static final Type REGISTERED = new Type("REGISTERED", 0, com.urbanairship.analytics.AccountEventTemplate.REGISTERED_ACCOUNT_EVENT);
        public static final Type LOGGED_IN = new Type("LOGGED_IN", 1, com.urbanairship.analytics.AccountEventTemplate.LOGGED_IN);
        public static final Type LOGGED_OUT = new Type("LOGGED_OUT", 2, com.urbanairship.analytics.AccountEventTemplate.LOGGED_OUT);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{REGISTERED, LOGGED_IN, LOGGED_OUT};
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

        private Type(String str, int i, String str2) {
            this.eventName = str2;
        }

        @NotNull
        /* renamed from: getEventName$urbanairship_core_release, reason: from getter */
        public final String getEventName() {
            return this.eventName;
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/analytics/templates/AccountEventTemplate$Properties;", "Lcom/urbanairship/json/JsonSerializable;", "userId", "", "category", "type", "isLTV", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCategory", "()Ljava/lang/String;", "()Z", "getType", "getUserId", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Builder", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Properties implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String category;
        private final boolean isLTV;
        private final String type;
        private final String userId;

        public Properties() {
            this(null, null, null, false, 15, null);
        }

        @JvmStatic
        @NotNull
        public static final Builder newBuilder() {
            return INSTANCE.newBuilder();
        }

        public Properties(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
            this.userId = str;
            this.category = str2;
            this.type = str3;
            this.isLTV = z;
        }

        public /* synthetic */ Properties(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z);
        }

        @Nullable
        public final String getUserId() {
            return this.userId;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        /* renamed from: isLTV, reason: from getter */
        public final boolean getIsLTV() {
            return this.isLTV;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/analytics/templates/AccountEventTemplate$Properties$Companion;", "", "()V", "CATEGORY", "", "IS_LTV", "TYPE", "USER_ID", "newBuilder", "Lcom/urbanairship/analytics/templates/AccountEventTemplate$Properties$Builder;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Builder newBuilder() {
                return new Builder(null, null, null, false, 15, null);
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/analytics/templates/AccountEventTemplate$Properties$Builder;", "", "userId", "", "category", "type", "isLTV", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "build", "Lcom/urbanairship/analytics/templates/AccountEventTemplate$Properties;", "setCategory", "setIsLifetimeValue", "value", "setType", "setUserId", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nAccountEventTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountEventTemplate.kt\ncom/urbanairship/analytics/templates/AccountEventTemplate$Properties$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
        public static final class Builder {
            private String category;
            private boolean isLTV;
            private String type;
            private String userId;

            public Builder() {
                this(null, null, null, false, 15, null);
            }

            public Builder(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
                this.userId = str;
                this.category = str2;
                this.type = str3;
                this.isLTV = z;
            }

            public /* synthetic */ Builder(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? false : z);
            }

            @NotNull
            public final Builder setCategory(@Nullable String category) {
                this.category = category;
                return this;
            }

            @NotNull
            public final Builder setUserId(@Nullable String userId) {
                this.userId = userId;
                return this;
            }

            @NotNull
            public final Builder setType(@Nullable String type) {
                this.type = type;
                return this;
            }

            @NotNull
            public final Builder setIsLifetimeValue(boolean value) {
                this.isLTV = value;
                return this;
            }

            @NotNull
            public final Properties build() {
                return new Properties(this.userId, this.category, this.type, this.isLTV);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("user_id", this.userId), TuplesKt.to("category", this.category), TuplesKt.to("type", this.type), TuplesKt.to("ltv", Boolean.valueOf(this.isLTV))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
