package com.urbanairship.analytics.templates;

import com.google.android.gms.actions.SearchIntents;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/analytics/templates/SearchEventTemplate;", "", "()V", "Companion", "Properties", "Type", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class SearchEventTemplate {

    @NotNull
    public static final String TEMPLATE_NAME = "search";

    public /* synthetic */ SearchEventTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SearchEventTemplate() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/analytics/templates/SearchEventTemplate$Type;", "", "eventName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventName$urbanairship_core_release", "()Ljava/lang/String;", "SEARCH", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type SEARCH = new Type("SEARCH", 0, "search");
        private final String eventName;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SEARCH};
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/analytics/templates/SearchEventTemplate$Properties;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", SearchIntents.EXTRA_QUERY, "totalResults", "", "category", "type", "isLTV", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Z)V", "getCategory", "()Ljava/lang/String;", "getId", "()Z", "getQuery", "getTotalResults", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Builder", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Properties implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String category;
        private final String id;
        private final boolean isLTV;
        private final String query;
        private final Long totalResults;
        private final String type;

        public Properties() {
            this(null, null, null, null, null, false, 63, null);
        }

        @JvmStatic
        @NotNull
        public static final Builder newBuilder() {
            return INSTANCE.newBuilder();
        }

        public Properties(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable String str3, @Nullable String str4, boolean z) {
            this.id = str;
            this.query = str2;
            this.totalResults = l;
            this.category = str3;
            this.type = str4;
            this.isLTV = z;
        }

        public /* synthetic */ Properties(String str, String str2, Long l, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? false : z);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getQuery() {
            return this.query;
        }

        @Nullable
        public final Long getTotalResults() {
            return this.totalResults;
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

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/analytics/templates/SearchEventTemplate$Properties$Companion;", "", "()V", "CATEGORY", "", "ID", "IS_LTV", "QUERY", "TOTAL_RESULTS", "TYPE", "newBuilder", "Lcom/urbanairship/analytics/templates/SearchEventTemplate$Properties$Builder;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Builder newBuilder() {
                return new Builder(null, null, null, null, null, false, 63, null);
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/analytics/templates/SearchEventTemplate$Properties$Builder;", "", "id", "", SearchIntents.EXTRA_QUERY, "totalResults", "", "category", "type", "isLTV", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Z)V", "Ljava/lang/Long;", "build", "Lcom/urbanairship/analytics/templates/SearchEventTemplate$Properties;", "setCategory", "setId", "setIsLifetimeValue", "value", "setQuery", "setTotalResults", "setType", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nSearchEventTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchEventTemplate.kt\ncom/urbanairship/analytics/templates/SearchEventTemplate$Properties$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,140:1\n1#2:141\n*E\n"})
        public static final class Builder {
            private String category;
            private String id;
            private boolean isLTV;
            private String query;
            private Long totalResults;
            private String type;

            public Builder() {
                this(null, null, null, null, null, false, 63, null);
            }

            public Builder(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable String str3, @Nullable String str4, boolean z) {
                this.id = str;
                this.query = str2;
                this.totalResults = l;
                this.category = str3;
                this.type = str4;
                this.isLTV = z;
            }

            public /* synthetic */ Builder(String str, String str2, Long l, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? false : z);
            }

            @NotNull
            public final Builder setType(@Nullable String type) {
                this.type = type;
                return this;
            }

            @NotNull
            public final Builder setQuery(@Nullable String query) {
                this.query = query;
                return this;
            }

            @NotNull
            public final Builder setCategory(@Nullable String category) {
                this.category = category;
                return this;
            }

            @NotNull
            public final Builder setId(@Nullable String id) {
                this.id = id;
                return this;
            }

            @NotNull
            public final Builder setTotalResults(long totalResults) {
                this.totalResults = Long.valueOf(totalResults);
                return this;
            }

            @NotNull
            public final Builder setIsLifetimeValue(boolean value) {
                this.isLTV = value;
                return this;
            }

            @NotNull
            public final Properties build() {
                return new Properties(this.id, this.query, this.totalResults, this.category, this.type, this.isLTV);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to(SearchIntents.EXTRA_QUERY, this.query), TuplesKt.to("total_results", this.totalResults), TuplesKt.to("category", this.category), TuplesKt.to("type", this.type), TuplesKt.to("ltv", Boolean.valueOf(this.isLTV))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
