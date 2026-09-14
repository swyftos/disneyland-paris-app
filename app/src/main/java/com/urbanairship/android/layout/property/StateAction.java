package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \b2\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction;", "", "type", "Lcom/urbanairship/android/layout/property/StateAction$Type;", "(Lcom/urbanairship/android/layout/property/StateAction$Type;)V", "getType", "()Lcom/urbanairship/android/layout/property/StateAction$Type;", "ClearState", "Companion", "SetFormValue", "SetState", "Type", "Lcom/urbanairship/android/layout/property/StateAction$ClearState;", "Lcom/urbanairship/android/layout/property/StateAction$SetFormValue;", "Lcom/urbanairship/android/layout/property/StateAction$SetState;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public abstract class StateAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction$ClearState;", "Lcom/urbanairship/android/layout/property/StateAction;", "()V", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class ClearState extends StateAction {

        @NotNull
        public static final ClearState INSTANCE = new ClearState();

        private ClearState() {
            super(Type.CLEAR_STATE, null);
        }
    }

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0012J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0002\b\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction$SetState;", "Lcom/urbanairship/android/layout/property/StateAction;", "key", "", "value", "Lcom/urbanairship/json/JsonValue;", Constants.FirelogAnalytics.PARAM_TTL, "Lkotlin/time/Duration;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lkotlin/time/Duration;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getKey", "()Ljava/lang/String;", "getTtl-FghU774", "()Lkotlin/time/Duration;", "getValue", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component3-FghU774", "copy", "copy-moChb0s", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class SetState extends StateAction {
        private final String key;
        private final Duration ttl;
        private final JsonValue value;

        public /* synthetic */ SetState(String str, JsonValue jsonValue, Duration duration, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonValue, duration);
        }

        /* JADX INFO: renamed from: copy-moChb0s$default, reason: not valid java name */
        public static /* synthetic */ SetState m4975copymoChb0s$default(SetState setState, String str, JsonValue jsonValue, Duration duration, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setState.key;
            }
            if ((i & 2) != 0) {
                jsonValue = setState.value;
            }
            if ((i & 4) != 0) {
                duration = setState.ttl;
            }
            return setState.m4977copymoChb0s(str, jsonValue, duration);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final JsonValue getValue() {
            return this.value;
        }

        @Nullable
        /* JADX INFO: renamed from: component3-FghU774, reason: not valid java name and from getter */
        public final Duration getTtl() {
            return this.ttl;
        }

        @NotNull
        /* JADX INFO: renamed from: copy-moChb0s, reason: not valid java name */
        public final SetState m4977copymoChb0s(@NotNull String key, @Nullable JsonValue value, @Nullable Duration ttl) {
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
            return iHashCode2 + (duration != null ? Duration.m5799hashCodeimpl(duration.getRawValue()) : 0);
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
        /* JADX INFO: renamed from: getTtl-FghU774, reason: not valid java name */
        public final Duration m4978getTtlFghU774() {
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

    @Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction$SetFormValue;", "Lcom/urbanairship/android/layout/property/StateAction;", "key", "", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final /* data */ class SetFormValue extends StateAction {
        private final String key;

        public static /* synthetic */ SetFormValue copy$default(SetFormValue setFormValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setFormValue.key;
            }
            return setFormValue.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
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

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CLEAR_STATE", "SET_STATE", "SET_FORM_VALUE_STATE", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum Type {
        CLEAR_STATE("clear"),
        SET_STATE(AttributeMutation.ATTRIBUTE_ACTION_SET),
        SET_FORM_VALUE_STATE("set_form_value");

        private final String value;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        Type(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction$Type$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/StateAction$Type;", "value", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(next.getValue(), value));
                Type type = next;
                if (type != null) {
                    return type;
                }
                throw new JsonException("Unknown StateAction type: '" + value + CoreConstants.SINGLE_QUOTE_CHAR);
            }
        }
    }

    @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StateAction$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/StateAction;", "json", "Lcom/urbanairship/json/JsonMap;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nStateAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateAction.kt\ncom/urbanairship/android/layout/property/StateAction$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,63:1\n44#2,15:64\n44#2,15:79\n44#2,15:94\n*S KotlinDebug\n*F\n+ 1 StateAction.kt\ncom/urbanairship/android/layout/property/StateAction$Companion\n*L\n49#1:64,15\n52#1:79,15\n57#1:94,15\n*E\n"})
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

        /* JADX WARN: Code duplicated, block: B:100:0x024c  */
        /* JADX WARN: Code duplicated, block: B:101:0x025b  */
        /* JADX WARN: Code duplicated, block: B:103:0x0265  */
        /* JADX WARN: Code duplicated, block: B:105:0x026b  */
        /* JADX WARN: Code duplicated, block: B:106:0x026e  */
        /* JADX WARN: Code duplicated, block: B:108:0x0274  */
        /* JADX WARN: Code duplicated, block: B:110:0x027e  */
        /* JADX WARN: Code duplicated, block: B:112:0x0284  */
        /* JADX WARN: Code duplicated, block: B:113:0x0287  */
        /* JADX WARN: Code duplicated, block: B:115:0x028d  */
        /* JADX WARN: Code duplicated, block: B:117:0x0297  */
        /* JADX WARN: Code duplicated, block: B:119:0x029d  */
        /* JADX WARN: Code duplicated, block: B:121:0x02a4  */
        /* JADX WARN: Code duplicated, block: B:123:0x02aa  */
        /* JADX WARN: Code duplicated, block: B:125:0x02ce  */
        /* JADX WARN: Code duplicated, block: B:127:0x02e8  */
        /* JADX WARN: Code duplicated, block: B:129:0x02ee  */
        /* JADX WARN: Code duplicated, block: B:131:0x02f6  */
        /* JADX WARN: Code duplicated, block: B:133:0x0304  */
        /* JADX WARN: Code duplicated, block: B:136:0x030c  */
        /* JADX WARN: Code duplicated, block: B:138:0x0312  */
        /* JADX WARN: Code duplicated, block: B:140:0x031c  */
        /* JADX WARN: Code duplicated, block: B:143:0x0324  */
        /* JADX WARN: Code duplicated, block: B:145:0x032a  */
        /* JADX WARN: Code duplicated, block: B:147:0x0336  */
        /* JADX WARN: Code duplicated, block: B:148:0x0343  */
        /* JADX WARN: Code duplicated, block: B:150:0x034f  */
        /* JADX WARN: Code duplicated, block: B:151:0x035d  */
        /* JADX WARN: Code duplicated, block: B:153:0x0369  */
        /* JADX WARN: Code duplicated, block: B:154:0x0379  */
        /* JADX WARN: Code duplicated, block: B:156:0x0385  */
        /* JADX WARN: Code duplicated, block: B:157:0x0393  */
        /* JADX WARN: Code duplicated, block: B:159:0x039f  */
        /* JADX WARN: Code duplicated, block: B:160:0x03ac  */
        /* JADX WARN: Code duplicated, block: B:162:0x03b6  */
        /* JADX WARN: Code duplicated, block: B:163:0x03c2  */
        /* JADX WARN: Code duplicated, block: B:165:0x03cd  */
        /* JADX WARN: Code duplicated, block: B:166:0x03dc  */
        /* JADX WARN: Code duplicated, block: B:168:0x03e6  */
        /* JADX WARN: Code duplicated, block: B:170:0x03ec  */
        /* JADX WARN: Code duplicated, block: B:171:0x03ef  */
        /* JADX WARN: Code duplicated, block: B:173:0x03f5  */
        /* JADX WARN: Code duplicated, block: B:175:0x03ff  */
        /* JADX WARN: Code duplicated, block: B:177:0x0405  */
        /* JADX WARN: Code duplicated, block: B:178:0x0408  */
        /* JADX WARN: Code duplicated, block: B:180:0x040e  */
        /* JADX WARN: Code duplicated, block: B:182:0x0418  */
        /* JADX WARN: Code duplicated, block: B:184:0x041e  */
        /* JADX WARN: Code duplicated, block: B:187:0x042f  */
        /* JADX WARN: Code duplicated, block: B:188:0x0442  */
        /* JADX WARN: Code duplicated, block: B:190:0x0447  */
        /* JADX WARN: Code duplicated, block: B:192:0x044d  */
        /* JADX WARN: Code duplicated, block: B:194:0x0471  */
        /* JADX WARN: Code duplicated, block: B:196:0x048b  */
        /* JADX WARN: Code duplicated, block: B:60:0x0165  */
        /* JADX WARN: Code duplicated, block: B:62:0x016a  */
        /* JADX WARN: Code duplicated, block: B:64:0x016d  */
        /* JADX WARN: Code duplicated, block: B:66:0x0175  */
        /* JADX WARN: Code duplicated, block: B:68:0x0183  */
        /* JADX WARN: Code duplicated, block: B:71:0x018b  */
        /* JADX WARN: Code duplicated, block: B:73:0x0191  */
        /* JADX WARN: Code duplicated, block: B:75:0x019b  */
        /* JADX WARN: Code duplicated, block: B:78:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:80:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:82:0x01b5  */
        /* JADX WARN: Code duplicated, block: B:83:0x01c2  */
        /* JADX WARN: Code duplicated, block: B:85:0x01ce  */
        /* JADX WARN: Code duplicated, block: B:86:0x01dc  */
        /* JADX WARN: Code duplicated, block: B:88:0x01e8  */
        /* JADX WARN: Code duplicated, block: B:89:0x01f8  */
        /* JADX WARN: Code duplicated, block: B:91:0x0204  */
        /* JADX WARN: Code duplicated, block: B:92:0x0212  */
        /* JADX WARN: Code duplicated, block: B:94:0x021e  */
        /* JADX WARN: Code duplicated, block: B:95:0x022b  */
        /* JADX WARN: Code duplicated, block: B:97:0x0235  */
        /* JADX WARN: Code duplicated, block: B:98:0x0241  */
        /* JADX WARN: Instruction removed from duplicated block: B:123:0x02aa, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:125:0x02ce, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:192:0x044d, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:194:0x0471, please report this as an issue */
        @NotNull
        public final StateAction fromJson(@NotNull JsonMap json) throws JsonException {
            String str;
            String strOptString;
            int i;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            Object jsonValue2;
            String strOptString2;
            Object objOptMap;
            Object objOptList;
            JsonValue jsonValue3;
            Duration durationM5770boximpl;
            JsonValue jsonValue4;
            KClass orCreateKotlinClass2;
            Object jsonValue5;
            String strOptString3;
            Object objOptMap2;
            Object objOptList2;
            Intrinsics.checkNotNullParameter(json, "json");
            Type.Companion companion = Type.INSTANCE;
            JsonValue jsonValue6 = json.get("type");
            if (jsonValue6 == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue6.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "null cannot be cast to non-null type kotlin.String";
                        strOptString = (String) Long.valueOf(jsonValue6.getLong(0L));
                    } else {
                        str = "null cannot be cast to non-null type kotlin.String";
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString = (String) Integer.valueOf(jsonValue6.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList3 = jsonValue6.optList();
                            if (objOptList3 == null) {
                                throw new NullPointerException(str);
                            }
                            strOptString = (String) objOptList3;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap3 = jsonValue6.optMap();
                            if (objOptMap3 == null) {
                                throw new NullPointerException(str);
                            }
                            strOptString = (String) objOptMap3;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue7 = jsonValue6.getJsonValue();
                            if (jsonValue7 == null) {
                                throw new NullPointerException(str);
                            }
                            strOptString = (String) jsonValue7;
                        }
                    }
                    i = WhenMappings.$EnumSwitchMapping$0[companion.from(strOptString).ordinal()];
                    if (i != 1) {
                        return ClearState.INSTANCE;
                    }
                    if (i != 2) {
                        if (i == 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        jsonValue4 = json.get("key");
                        if (jsonValue4 != null) {
                            throw new JsonException("Missing required field: 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString3 = jsonValue4.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString3 = jsonValue4.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException(str);
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
                                throw new NullPointerException(str);
                            }
                            strOptString3 = (String) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap2 = jsonValue4.optMap();
                            if (objOptMap2 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString3 = (String) objOptMap2;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue5 = jsonValue4.getJsonValue();
                            if (jsonValue5 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString3 = (String) jsonValue5;
                        }
                        return new SetFormValue(strOptString3);
                    }
                    jsonValue = json.get("key");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue.optList();
                        if (objOptList != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) jsonValue2;
                    }
                    JsonValue jsonValue8 = json.get("value");
                    jsonValue3 = json.get("ttl_seconds");
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    if (jsonValue3 != null) {
                        long j = jsonValue3.getLong(0L);
                        Duration.Companion companion2 = Duration.INSTANCE;
                        durationM5770boximpl = Duration.m5770boximpl(DurationKt.toDuration(j, DurationUnit.SECONDS));
                    } else {
                        durationM5770boximpl = null;
                    }
                    return new SetState(strOptString2, jsonValue8, durationM5770boximpl, defaultConstructorMarker);
                }
                strOptString = jsonValue6.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            str = "null cannot be cast to non-null type kotlin.String";
            i = WhenMappings.$EnumSwitchMapping$0[companion.from(strOptString).ordinal()];
            if (i != 1) {
                return ClearState.INSTANCE;
            }
            if (i != 2) {
                if (i == 3) {
                    throw new NoWhenBranchMatchedException();
                }
                jsonValue4 = json.get("key");
                if (jsonValue4 != null) {
                    throw new JsonException("Missing required field: 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString3 = jsonValue4.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException(str);
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString3 = jsonValue4.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException(str);
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
                        throw new NullPointerException(str);
                    }
                    strOptString3 = (String) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap2 = jsonValue4.optMap();
                    if (objOptMap2 != null) {
                        throw new NullPointerException(str);
                    }
                    strOptString3 = (String) objOptMap2;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue5 = jsonValue4.getJsonValue();
                    if (jsonValue5 != null) {
                        throw new NullPointerException(str);
                    }
                    strOptString3 = (String) jsonValue5;
                }
                return new SetFormValue(strOptString3);
            }
            jsonValue = json.get("key");
            if (jsonValue != null) {
                throw new JsonException("Missing required field: 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException(str);
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException(str);
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList = jsonValue.optList();
                if (objOptList != null) {
                    throw new NullPointerException(str);
                }
                strOptString2 = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap = jsonValue.optMap();
                if (objOptMap != null) {
                    throw new NullPointerException(str);
                }
                strOptString2 = (String) objOptMap;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 != null) {
                    throw new NullPointerException(str);
                }
                strOptString2 = (String) jsonValue2;
            }
            JsonValue jsonValue9 = json.get("value");
            jsonValue3 = json.get("ttl_seconds");
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            if (jsonValue3 != null) {
                long j2 = jsonValue3.getLong(0L);
                Duration.Companion companion3 = Duration.INSTANCE;
                durationM5770boximpl = Duration.m5770boximpl(DurationKt.toDuration(j2, DurationUnit.SECONDS));
            } else {
                durationM5770boximpl = null;
            }
            return new SetState(strOptString2, jsonValue9, durationM5770boximpl, defaultConstructorMarker2);
        }
    }
}
