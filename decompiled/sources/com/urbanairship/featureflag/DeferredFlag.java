package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00032\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlag;", "Lcom/urbanairship/json/JsonSerializable;", "()V", "Companion", "Found", "NotFound", "ResultType", "Lcom/urbanairship/featureflag/DeferredFlag$Found;", "Lcom/urbanairship/featureflag/DeferredFlag$NotFound;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class DeferredFlag implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ DeferredFlag(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeferredFlag() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$ResultType;", "", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "FOUND", "NOT_FOUND", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResultType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResultType[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final ResultType FOUND = new ResultType("FOUND", 0, "found");
        public static final ResultType NOT_FOUND = new ResultType("NOT_FOUND", 1, "not_found");
        private final String jsonValue;

        private static final /* synthetic */ ResultType[] $values() {
            return new ResultType[]{FOUND, NOT_FOUND};
        }

        @NotNull
        public static EnumEntries<ResultType> getEntries() {
            return $ENTRIES;
        }

        public static ResultType valueOf(String str) {
            return (ResultType) Enum.valueOf(ResultType.class, str);
        }

        public static ResultType[] values() {
            return (ResultType[]) $VALUES.clone();
        }

        private ResultType(String str, int i, String str2) {
            this.jsonValue = str2;
        }

        @NotNull
        public final String getJsonValue() {
            return this.jsonValue;
        }

        static {
            ResultType[] resultTypeArr$values = $values();
            $VALUES = resultTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(resultTypeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$ResultType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/featureflag/DeferredFlag$ResultType;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$ResultType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n288#2,2:219\n*S KotlinDebug\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$ResultType$Companion\n*L\n154#1:219,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final ResultType fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                ResultType next;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                String strRequireString = jsonValue.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<ResultType> it = ResultType.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJsonValue(), strRequireString)) {
                        break;
                    }
                }
                ResultType resultType = next;
                if (resultType != null) {
                    return resultType;
                }
                throw new JsonException("Invalid result type: " + jsonValue);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$Companion;", "", "()V", "KEY_FLAG", "", "KEY_TYPE", "fromJson", "Lcom/urbanairship/featureflag/DeferredFlag;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFlagDeferredResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,218:1\n44#2,15:219\n44#2,15:234\n*S KotlinDebug\n*F\n+ 1 FlagDeferredResolver.kt\ncom/urbanairship/featureflag/DeferredFlag$Companion\n*L\n165#1:219,15\n167#1:234,15\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ResultType.values().length];
                try {
                    iArr[ResultType.NOT_FOUND.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ResultType.FOUND.ordinal()] = 2;
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

        /* JADX WARN: Removed duplicated region for block: B:126:0x02fd  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0170  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.featureflag.DeferredFlag fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r19) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 836
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.featureflag.DeferredFlag.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.featureflag.DeferredFlag");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$Found;", "Lcom/urbanairship/featureflag/DeferredFlag;", "flagInfo", "Lcom/urbanairship/featureflag/DeferredFlagInfo;", "(Lcom/urbanairship/featureflag/DeferredFlagInfo;)V", "getFlagInfo", "()Lcom/urbanairship/featureflag/DeferredFlagInfo;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Found extends DeferredFlag {
        private final DeferredFlagInfo flagInfo;

        public static /* synthetic */ Found copy$default(Found found, DeferredFlagInfo deferredFlagInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                deferredFlagInfo = found.flagInfo;
            }
            return found.copy(deferredFlagInfo);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final DeferredFlagInfo getFlagInfo() {
            return this.flagInfo;
        }

        @NotNull
        public final Found copy(@NotNull DeferredFlagInfo flagInfo) {
            Intrinsics.checkNotNullParameter(flagInfo, "flagInfo");
            return new Found(flagInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Found) && Intrinsics.areEqual(this.flagInfo, ((Found) other).flagInfo);
        }

        public int hashCode() {
            return this.flagInfo.hashCode();
        }

        @NotNull
        public String toString() {
            return "Found(flagInfo=" + this.flagInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Found(@NotNull DeferredFlagInfo flagInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(flagInfo, "flagInfo");
            this.flagInfo = flagInfo;
        }

        @NotNull
        public final DeferredFlagInfo getFlagInfo() {
            return this.flagInfo;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ResultType.FOUND.getJsonValue()), TuplesKt.to("flag", this.flagInfo)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/urbanairship/featureflag/DeferredFlag$NotFound;", "Lcom/urbanairship/featureflag/DeferredFlag;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NotFound extends DeferredFlag {

        @NotNull
        public static final NotFound INSTANCE = new NotFound();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof NotFound);
        }

        public int hashCode() {
            return 1957115929;
        }

        @NotNull
        public String toString() {
            return "NotFound";
        }

        private NotFound() {
            super(null);
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() throws JsonException {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", ResultType.NOT_FOUND.getJsonValue())).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
