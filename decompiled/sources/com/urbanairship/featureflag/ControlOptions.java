package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001d\u001e\u001fB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions;", "Lcom/urbanairship/json/JsonSerializable;", "compoundAudience", "Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "reportingMetadata", "Lcom/urbanairship/json/JsonMap;", "controlType", "Lcom/urbanairship/featureflag/ControlOptions$Type;", "(Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/featureflag/ControlOptions$Type;)V", "getCompoundAudience", "()Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "getControlType", "()Lcom/urbanairship/featureflag/ControlOptions$Type;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonMap;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "OptionType", "Type", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ControlOptions implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final FeatureFlagCompoundAudience compoundAudience;
    private final Type controlType;
    private final JsonMap reportingMetadata;

    public static /* synthetic */ ControlOptions copy$default(ControlOptions controlOptions, FeatureFlagCompoundAudience featureFlagCompoundAudience, JsonMap jsonMap, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            featureFlagCompoundAudience = controlOptions.compoundAudience;
        }
        if ((i & 2) != 0) {
            jsonMap = controlOptions.reportingMetadata;
        }
        if ((i & 4) != 0) {
            type = controlOptions.controlType;
        }
        return controlOptions.copy(featureFlagCompoundAudience, jsonMap, type);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final FeatureFlagCompoundAudience getCompoundAudience() {
        return this.compoundAudience;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final Type getControlType() {
        return this.controlType;
    }

    @NotNull
    public final ControlOptions copy(@Nullable FeatureFlagCompoundAudience compoundAudience, @NotNull JsonMap reportingMetadata, @NotNull Type controlType) {
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        return new ControlOptions(compoundAudience, reportingMetadata, controlType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ControlOptions)) {
            return false;
        }
        ControlOptions controlOptions = (ControlOptions) other;
        return Intrinsics.areEqual(this.compoundAudience, controlOptions.compoundAudience) && Intrinsics.areEqual(this.reportingMetadata, controlOptions.reportingMetadata) && Intrinsics.areEqual(this.controlType, controlOptions.controlType);
    }

    public int hashCode() {
        FeatureFlagCompoundAudience featureFlagCompoundAudience = this.compoundAudience;
        return ((((featureFlagCompoundAudience == null ? 0 : featureFlagCompoundAudience.hashCode()) * 31) + this.reportingMetadata.hashCode()) * 31) + this.controlType.hashCode();
    }

    @NotNull
    public String toString() {
        return "ControlOptions(compoundAudience=" + this.compoundAudience + ", reportingMetadata=" + this.reportingMetadata + ", controlType=" + this.controlType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ControlOptions(@Nullable FeatureFlagCompoundAudience featureFlagCompoundAudience, @NotNull JsonMap reportingMetadata, @NotNull Type controlType) {
        Intrinsics.checkNotNullParameter(reportingMetadata, "reportingMetadata");
        Intrinsics.checkNotNullParameter(controlType, "controlType");
        this.compoundAudience = featureFlagCompoundAudience;
        this.reportingMetadata = reportingMetadata;
        this.controlType = controlType;
    }

    @Nullable
    public final FeatureFlagCompoundAudience getCompoundAudience() {
        return this.compoundAudience;
    }

    @NotNull
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    public final Type getControlType() {
        return this.controlType;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$Companion;", "", "()V", "COMPOUND_AUDIENCE", "", "REPORTING_METADATA", "fromJson", "Lcom/urbanairship/featureflag/ControlOptions;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFeatureFlagInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/ControlOptions$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,401:1\n1#2:402\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ControlOptions fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("compound_audience");
            return new ControlOptions(jsonValue != null ? FeatureFlagCompoundAudience.INSTANCE.fromJson(jsonValue) : null, JsonExtensionsKt.requireMap(jsonMapRequireMap, "reporting_metadata"), Type.INSTANCE.fromJson(value));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().putAll(this.controlType.getJsonValue().optMap()).putOpt("compound_audience", this.compoundAudience).put("reporting_metadata", this.reportingMetadata).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$Type;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/featureflag/ControlOptions$OptionType;", "(Lcom/urbanairship/featureflag/ControlOptions$OptionType;)V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Flag", "Variables", "Lcom/urbanairship/featureflag/ControlOptions$Type$Flag;", "Lcom/urbanairship/featureflag/ControlOptions$Type$Variables;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Type implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final OptionType type;

        public /* synthetic */ Type(OptionType optionType, DefaultConstructorMarker defaultConstructorMarker) {
            this(optionType);
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$Type$Flag;", "Lcom/urbanairship/featureflag/ControlOptions$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Flag extends Type {

            @NotNull
            public static final Flag INSTANCE = new Flag();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Flag);
            }

            public int hashCode() {
                return 1100033068;
            }

            @NotNull
            public String toString() {
                return "Flag";
            }

            private Flag() {
                super(OptionType.FLAG, null);
            }
        }

        private Type(OptionType optionType) {
            this.type = optionType;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$Type$Variables;", "Lcom/urbanairship/featureflag/ControlOptions$Type;", "data", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getData", "()Lcom/urbanairship/json/JsonMap;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Variables extends Type {
            private final JsonMap data;

            public static /* synthetic */ Variables copy$default(Variables variables, JsonMap jsonMap, int i, Object obj) {
                if ((i & 1) != 0) {
                    jsonMap = variables.data;
                }
                return variables.copy(jsonMap);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final JsonMap getData() {
                return this.data;
            }

            @NotNull
            public final Variables copy(@Nullable JsonMap data) {
                return new Variables(data);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Variables) && Intrinsics.areEqual(this.data, ((Variables) other).data);
            }

            public int hashCode() {
                JsonMap jsonMap = this.data;
                if (jsonMap == null) {
                    return 0;
                }
                return jsonMap.hashCode();
            }

            @NotNull
            public String toString() {
                return "Variables(data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Variables(@Nullable JsonMap jsonMap) {
                super(OptionType.VARIABLES, null);
                this.data = jsonMap;
            }

            @Nullable
            public final JsonMap getData() {
                return this.data;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$Type$Companion;", "", "()V", "DATA", "", "TYPE", "fromJson", "Lcom/urbanairship/featureflag/ControlOptions$Type;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[OptionType.values().length];
                    try {
                        iArr[OptionType.FLAG.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[OptionType.VARIABLES.ordinal()] = 2;
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
            public final Type fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                OptionType.Companion companion = OptionType.INSTANCE;
                JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                int i = WhenMappings.$EnumSwitchMapping$0[companion.fromJson(jsonValueRequire).ordinal()];
                if (i == 1) {
                    return Flag.INSTANCE;
                }
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                JsonValue jsonValue = jsonMapRequireMap.get("data");
                return new Variables(jsonValue != null ? jsonValue.requireMap() : null);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            if (Intrinsics.areEqual(this, Flag.INSTANCE)) {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", this.type)).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
            if (!(this instanceof Variables)) {
                throw new NoWhenBranchMatchedException();
            }
            JsonValue jsonValue2 = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", this.type), TuplesKt.to("data", ((Variables) this).getData())).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue2, "toJsonValue(...)");
            return jsonValue2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$OptionType;", "", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "FLAG", "VARIABLES", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OptionType implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OptionType[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final OptionType FLAG = new OptionType("FLAG", 0, "flag");
        public static final OptionType VARIABLES = new OptionType("VARIABLES", 1, "variables");
        private final String jsonValue;

        private static final /* synthetic */ OptionType[] $values() {
            return new OptionType[]{FLAG, VARIABLES};
        }

        @NotNull
        public static EnumEntries<OptionType> getEntries() {
            return $ENTRIES;
        }

        public static OptionType valueOf(String str) {
            return (OptionType) Enum.valueOf(OptionType.class, str);
        }

        public static OptionType[] values() {
            return (OptionType[]) $VALUES.clone();
        }

        private OptionType(String str, int i, String str2) {
            this.jsonValue = str2;
        }

        @NotNull
        public final String getJsonValue() {
            return this.jsonValue;
        }

        static {
            OptionType[] optionTypeArr$values = $values();
            $VALUES = optionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(optionTypeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/featureflag/ControlOptions$OptionType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/featureflag/ControlOptions$OptionType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nFeatureFlagInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/ControlOptions$OptionType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,401:1\n223#2,2:402\n*S KotlinDebug\n*F\n+ 1 FeatureFlagInfo.kt\ncom/urbanairship/featureflag/ControlOptions$OptionType$Companion\n*L\n391#1:402,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final OptionType fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                try {
                    for (OptionType optionType : OptionType.getEntries()) {
                        if (Intrinsics.areEqual(optionType.getJsonValue(), strRequireString)) {
                            return optionType;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                } catch (NoSuchElementException e) {
                    throw new JsonException("invalid control option", e);
                }
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.jsonValue);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }
}
