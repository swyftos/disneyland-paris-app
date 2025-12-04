package com.urbanairship.android.layout.property;

import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \b2\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction;", "", "type", "Lcom/urbanairship/android/layout/property/StateAction$Type;", "(Lcom/urbanairship/android/layout/property/StateAction$Type;)V", "getType", "()Lcom/urbanairship/android/layout/property/StateAction$Type;", "ClearState", "Companion", "SetFormValue", "SetState", "Type", "Lcom/urbanairship/android/layout/property/StateAction$ClearState;", "Lcom/urbanairship/android/layout/property/StateAction$SetFormValue;", "Lcom/urbanairship/android/layout/property/StateAction$SetState;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class StateAction {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Type type;

    public /* synthetic */ StateAction(Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(type);
    }

    private StateAction(Type type) {
        this.type = type;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction$ClearState;", "Lcom/urbanairship/android/layout/property/StateAction;", "()V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ClearState extends StateAction {

        @NotNull
        public static final ClearState INSTANCE = new ClearState();

        private ClearState() {
            super(Type.CLEAR_STATE, null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0012J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0002\b\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction$SetState;", "Lcom/urbanairship/android/layout/property/StateAction;", "key", "", "value", "Lcom/urbanairship/json/JsonValue;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lkotlin/time/Duration;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKey", "()Ljava/lang/String;", "getTtl-FghU774", "()Lkotlin/time/Duration;", "getValue", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component3-FghU774", "copy", "copy-moChb0s", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SetState extends StateAction {
        private final String key;
        private final Duration ttl;
        private final JsonValue value;

        public /* synthetic */ SetState(String str, JsonValue jsonValue, Duration duration, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonValue, duration);
        }

        /* renamed from: copy-moChb0s$default, reason: not valid java name */
        public static /* synthetic */ SetState m2733copymoChb0s$default(SetState setState, String str, JsonValue jsonValue, Duration duration, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setState.key;
            }
            if ((i & 2) != 0) {
                jsonValue = setState.value;
            }
            if ((i & 4) != 0) {
                duration = setState.ttl;
            }
            return setState.m2735copymoChb0s(str, jsonValue, duration);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonValue getValue() {
            return this.value;
        }

        @Nullable
        /* renamed from: component3-FghU774, reason: not valid java name and from getter */
        public final Duration getTtl() {
            return this.ttl;
        }

        @NotNull
        /* renamed from: copy-moChb0s, reason: not valid java name */
        public final SetState m2735copymoChb0s(@NotNull String key, @Nullable JsonValue value, @Nullable Duration ttl) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new SetState(key, value, ttl, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SetState)) {
                return false;
            }
            SetState setState = (SetState) other;
            return Intrinsics.areEqual(this.key, setState.key) && Intrinsics.areEqual(this.value, setState.value) && Intrinsics.areEqual(this.ttl, setState.ttl);
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() * 31;
            JsonValue jsonValue = this.value;
            int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
            Duration duration = this.ttl;
            return iHashCode2 + (duration != null ? Duration.m3494hashCodeimpl(duration.getRawValue()) : 0);
        }

        @NotNull
        public String toString() {
            return "SetState(key=" + this.key + ", value=" + this.value + ", ttl=" + this.ttl + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public /* synthetic */ SetState(String str, JsonValue jsonValue, Duration duration, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonValue, (i & 4) != 0 ? null : duration, null);
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @Nullable
        public final JsonValue getValue() {
            return this.value;
        }

        @Nullable
        /* renamed from: getTtl-FghU774, reason: not valid java name */
        public final Duration m2736getTtlFghU774() {
            return this.ttl;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private SetState(String key, JsonValue jsonValue, Duration duration) throws JsonException {
            super(Type.SET_STATE, null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.value = jsonValue;
            this.ttl = duration;
            if ((jsonValue != null && jsonValue.isJsonList()) || (jsonValue != null && jsonValue.isJsonMap())) {
                throw new JsonException("State value must be a String, Number, or Boolean!");
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction$SetFormValue;", "Lcom/urbanairship/android/layout/property/StateAction;", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SetFormValue extends StateAction {
        private final String key;

        public static /* synthetic */ SetFormValue copy$default(SetFormValue setFormValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setFormValue.key;
            }
            return setFormValue.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final SetFormValue copy(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return new SetFormValue(key);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SetFormValue) && Intrinsics.areEqual(this.key, ((SetFormValue) other).key);
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        @NotNull
        public String toString() {
            return "SetFormValue(key=" + this.key + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetFormValue(@NotNull String key) {
            super(Type.SET_FORM_VALUE_STATE, null);
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLEAR_STATE", "SET_STATE", "SET_FORM_VALUE_STATE", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String value;
        public static final Type CLEAR_STATE = new Type("CLEAR_STATE", 0, "clear");
        public static final Type SET_STATE = new Type("SET_STATE", 1, AttributeMutation.ATTRIBUTE_ACTION_SET);
        public static final Type SET_FORM_VALUE_STATE = new Type("SET_FORM_VALUE_STATE", 2, "set_form_value");

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CLEAR_STATE, SET_STATE, SET_FORM_VALUE_STATE};
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
            this.value = str2;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction$Type$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/StateAction$Type;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nStateAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateAction.kt\ncom/urbanairship/android/layout/property/StateAction$Type$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,63:1\n288#2,2:64\n*S KotlinDebug\n*F\n+ 1 StateAction.kt\ncom/urbanairship/android/layout/property/StateAction$Type$Companion\n*L\n34#1:64,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Type from(@NotNull String value) throws JsonException {
                Type next;
                Intrinsics.checkNotNullParameter(value, "value");
                Iterator<Type> it = Type.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getValue(), value)) {
                        break;
                    }
                }
                Type type = next;
                if (type != null) {
                    return type;
                }
                throw new JsonException("Unknown StateAction type: '" + value + CoreConstants.SINGLE_QUOTE_CHAR);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/property/StateAction$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/StateAction;", "json", "Lcom/urbanairship/json/JsonMap;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStateAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateAction.kt\ncom/urbanairship/android/layout/property/StateAction$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,63:1\n44#2,15:64\n44#2,15:79\n44#2,15:94\n*S KotlinDebug\n*F\n+ 1 StateAction.kt\ncom/urbanairship/android/layout/property/StateAction$Companion\n*L\n49#1:64,15\n52#1:79,15\n57#1:94,15\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.CLEAR_STATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.SET_STATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Type.SET_FORM_VALUE_STATE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
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
        public final StateAction fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            return fromJson(jsonMapRequireMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:196:0x048b  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0165  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.android.layout.property.StateAction fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r20) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1234
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.property.StateAction.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.property.StateAction");
        }
    }
}
