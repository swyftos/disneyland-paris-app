package com.urbanairship.android.layout.info;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "", "()V", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "Commercial", "Companion", "DoubleOptIn", "Transactional", "Type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Commercial;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$DoubleOptIn;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Transactional;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ThomasEmailRegistrationOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ThomasEmailRegistrationOptions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract Type getType();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "", "(Ljava/lang/String;I)V", "DOUBLE_OPT_IN", "COMMERCIAL", "TRANSACTIONAL", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DOUBLE_OPT_IN = new Type("DOUBLE_OPT_IN", 0);
        public static final Type COMMERCIAL = new Type("COMMERCIAL", 1);
        public static final Type TRANSACTIONAL = new Type("TRANSACTIONAL", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DOUBLE_OPT_IN, COMMERCIAL, TRANSACTIONAL};
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

    private ThomasEmailRegistrationOptions() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Commercial;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "optedIn", "", "(Lcom/urbanairship/json/JsonMap;Z)V", "getOptedIn", "()Z", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Commercial extends ThomasEmailRegistrationOptions {
        private final boolean optedIn;
        private final JsonMap properties;
        private final Type type;

        public static /* synthetic */ Commercial copy$default(Commercial commercial, JsonMap jsonMap, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonMap = commercial.properties;
            }
            if ((i & 2) != 0) {
                z = commercial.optedIn;
            }
            return commercial.copy(jsonMap, z);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final JsonMap getProperties() {
            return this.properties;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getOptedIn() {
            return this.optedIn;
        }

        @NotNull
        public final Commercial copy(@Nullable JsonMap properties, boolean optedIn) {
            return new Commercial(properties, optedIn);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Commercial)) {
                return false;
            }
            Commercial commercial = (Commercial) other;
            return Intrinsics.areEqual(this.properties, commercial.properties) && this.optedIn == commercial.optedIn;
        }

        public int hashCode() {
            JsonMap jsonMap = this.properties;
            return ((jsonMap == null ? 0 : jsonMap.hashCode()) * 31) + Boolean.hashCode(this.optedIn);
        }

        @NotNull
        public String toString() {
            return "Commercial(properties=" + this.properties + ", optedIn=" + this.optedIn + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Commercial(@Nullable JsonMap jsonMap, boolean z) {
            super(null);
            this.properties = jsonMap;
            this.optedIn = z;
            this.type = Type.COMMERCIAL;
        }

        public final boolean getOptedIn() {
            return this.optedIn;
        }

        @Nullable
        public final JsonMap getProperties() {
            return this.properties;
        }

        @Override // com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions
        @NotNull
        public Type getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Transactional;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Transactional extends ThomasEmailRegistrationOptions {
        private final JsonMap properties;
        private final Type type;

        public static /* synthetic */ Transactional copy$default(Transactional transactional, JsonMap jsonMap, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonMap = transactional.properties;
            }
            return transactional.copy(jsonMap);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final JsonMap getProperties() {
            return this.properties;
        }

        @NotNull
        public final Transactional copy(@Nullable JsonMap properties) {
            return new Transactional(properties);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Transactional) && Intrinsics.areEqual(this.properties, ((Transactional) other).properties);
        }

        public int hashCode() {
            JsonMap jsonMap = this.properties;
            if (jsonMap == null) {
                return 0;
            }
            return jsonMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "Transactional(properties=" + this.properties + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Transactional(@Nullable JsonMap jsonMap) {
            super(null);
            this.properties = jsonMap;
            this.type = Type.TRANSACTIONAL;
        }

        @Nullable
        public final JsonMap getProperties() {
            return this.properties;
        }

        @Override // com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions
        @NotNull
        public Type getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$DoubleOptIn;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DoubleOptIn extends ThomasEmailRegistrationOptions {
        private final JsonMap properties;
        private final Type type;

        public static /* synthetic */ DoubleOptIn copy$default(DoubleOptIn doubleOptIn, JsonMap jsonMap, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonMap = doubleOptIn.properties;
            }
            return doubleOptIn.copy(jsonMap);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final JsonMap getProperties() {
            return this.properties;
        }

        @NotNull
        public final DoubleOptIn copy(@Nullable JsonMap properties) {
            return new DoubleOptIn(properties);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DoubleOptIn) && Intrinsics.areEqual(this.properties, ((DoubleOptIn) other).properties);
        }

        public int hashCode() {
            JsonMap jsonMap = this.properties;
            if (jsonMap == null) {
                return 0;
            }
            return jsonMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "DoubleOptIn(properties=" + this.properties + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public DoubleOptIn(@Nullable JsonMap jsonMap) {
            super(null);
            this.properties = jsonMap;
            this.type = Type.DOUBLE_OPT_IN;
        }

        @Nullable
        public final JsonMap getProperties() {
            return this.properties;
        }

        @Override // com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions
        @NotNull
        public Type getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "value", "Lcom/urbanairship/json/JsonValue;", "parseType", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nEmailRegistrationOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmailRegistrationOptions.kt\ncom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,77:1\n44#2,15:78\n79#2,16:93\n44#2,15:109\n*S KotlinDebug\n*F\n+ 1 EmailRegistrationOptions.kt\ncom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Companion\n*L\n53#1:78,15\n54#1:93,16\n65#1:109,15\n*E\n"})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.DOUBLE_OPT_IN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.COMMERCIAL.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Type.TRANSACTIONAL.ordinal()] = 3;
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

        private final Type parseType(String value) throws JsonException {
            String lowerCase = value.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -3660193) {
                if (iHashCode != 448241545) {
                    if (iHashCode == 902347594 && lowerCase.equals("commercial")) {
                        return Type.COMMERCIAL;
                    }
                } else if (lowerCase.equals(AutomationSchedule.DEFAULT_MESSAGE_TYPE)) {
                    return Type.TRANSACTIONAL;
                }
            } else if (lowerCase.equals("double_opt_in")) {
                return Type.DOUBLE_OPT_IN;
            }
            throw new JsonException("Invalid email registration type: " + value);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x029a  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x0432  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r20) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1185
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.android.layout.info.ThomasEmailRegistrationOptions");
        }
    }
}
