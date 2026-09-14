package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.automation.AutomationSchedule;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "", "()V", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "Commercial", "Companion", "DoubleOptIn", "Transactional", "Type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Commercial;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$DoubleOptIn;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Transactional;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public abstract class ThomasEmailRegistrationOptions {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "", "(Ljava/lang/String;I)V", "DOUBLE_OPT_IN", "COMMERCIAL", "TRANSACTIONAL", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public enum Type {
        DOUBLE_OPT_IN,
        COMMERCIAL,
        TRANSACTIONAL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    public /* synthetic */ ThomasEmailRegistrationOptions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract Type getType();

    private ThomasEmailRegistrationOptions() {
    }

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Commercial;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "optedIn", "", "(Lcom/urbanairship/json/JsonMap;Z)V", "getOptedIn", "()Z", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final JsonMap getProperties() {
            return this.properties;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
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

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Transactional;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
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

    @Metadata(m1835d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$DoubleOptIn;", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "getType", "()Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
        /* JADX INFO: renamed from: component1, reason: from getter */
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

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0002¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions;", "value", "Lcom/urbanairship/json/JsonValue;", "parseType", "Lcom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Type;", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nEmailRegistrationOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EmailRegistrationOptions.kt\ncom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,77:1\n44#2,15:78\n79#2,16:93\n44#2,15:109\n*S KotlinDebug\n*F\n+ 1 EmailRegistrationOptions.kt\ncom/urbanairship/android/layout/info/ThomasEmailRegistrationOptions$Companion\n*L\n53#1:78,15\n54#1:93,16\n65#1:109,15\n*E\n"})
    public static final class Companion {

        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
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

        /* JADX WARN: Code duplicated, block: B:103:0x029a  */
        /* JADX WARN: Code duplicated, block: B:105:0x029d  */
        /* JADX WARN: Code duplicated, block: B:107:0x02a0  */
        /* JADX WARN: Code duplicated, block: B:109:0x02a6  */
        /* JADX WARN: Code duplicated, block: B:111:0x02ac  */
        /* JADX WARN: Code duplicated, block: B:113:0x02b6  */
        /* JADX WARN: Code duplicated, block: B:115:0x02c8  */
        /* JADX WARN: Code duplicated, block: B:117:0x02ce  */
        /* JADX WARN: Code duplicated, block: B:118:0x02d2  */
        /* JADX WARN: Code duplicated, block: B:120:0x02d8  */
        /* JADX WARN: Code duplicated, block: B:122:0x02e2  */
        /* JADX WARN: Code duplicated, block: B:124:0x02e8  */
        /* JADX WARN: Code duplicated, block: B:125:0x02ec  */
        /* JADX WARN: Code duplicated, block: B:127:0x02f2  */
        /* JADX WARN: Code duplicated, block: B:129:0x02fe  */
        /* JADX WARN: Code duplicated, block: B:130:0x0309  */
        /* JADX WARN: Code duplicated, block: B:132:0x0315  */
        /* JADX WARN: Code duplicated, block: B:133:0x0323  */
        /* JADX WARN: Code duplicated, block: B:135:0x032f  */
        /* JADX WARN: Code duplicated, block: B:136:0x033f  */
        /* JADX WARN: Code duplicated, block: B:138:0x034b  */
        /* JADX WARN: Code duplicated, block: B:139:0x0359  */
        /* JADX WARN: Code duplicated, block: B:141:0x0365  */
        /* JADX WARN: Code duplicated, block: B:142:0x0372  */
        /* JADX WARN: Code duplicated, block: B:144:0x037c  */
        /* JADX WARN: Code duplicated, block: B:145:0x0388  */
        /* JADX WARN: Code duplicated, block: B:147:0x0393  */
        /* JADX WARN: Code duplicated, block: B:148:0x03a2  */
        /* JADX WARN: Code duplicated, block: B:150:0x03ac  */
        /* JADX WARN: Code duplicated, block: B:152:0x03b2  */
        /* JADX WARN: Code duplicated, block: B:153:0x03b5  */
        /* JADX WARN: Code duplicated, block: B:155:0x03bb  */
        /* JADX WARN: Code duplicated, block: B:157:0x03c5  */
        /* JADX WARN: Code duplicated, block: B:159:0x03cb  */
        /* JADX WARN: Code duplicated, block: B:160:0x03ce  */
        /* JADX WARN: Code duplicated, block: B:162:0x03d4  */
        /* JADX WARN: Code duplicated, block: B:164:0x03de  */
        /* JADX WARN: Code duplicated, block: B:166:0x03e4  */
        /* JADX WARN: Code duplicated, block: B:169:0x03ee  */
        /* JADX WARN: Code duplicated, block: B:171:0x03f4  */
        /* JADX WARN: Code duplicated, block: B:173:0x0418  */
        /* JADX WARN: Code duplicated, block: B:175:0x0432  */
        /* JADX WARN: Instruction removed from duplicated block: B:171:0x03f4, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:173:0x0418, please report this as an issue */
        @NotNull
        public final ThomasEmailRegistrationOptions fromJson(@NotNull JsonValue value) throws JsonException {
            String strOptString;
            String str;
            JsonMap jsonMapOptMap;
            int i;
            JsonValue jsonValue;
            KClass orCreateKotlinClass;
            Object jsonValue2;
            Boolean boolValueOf;
            Object objOptMap;
            Object objOptList;
            Object objOptString;
            Object objOptString2;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue3 = jsonMapRequireMap.get("type");
            if (jsonValue3 == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue3.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue3.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList2 = jsonValue3.optList();
                if (objOptList2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap2 = jsonValue3.optMap();
                if (objOptMap2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap2;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue4 = jsonValue3.toJsonValue();
                if (jsonValue4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue4;
            }
            Type type = parseType(strOptString);
            JsonValue jsonValue5 = jsonMapRequireMap.get(CustomEvent.PROPERTIES);
            if (jsonValue5 == null) {
                jsonMapOptMap = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) && !Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "' for field '";
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue5.getLong(0L));
                    } else {
                        str = "' for field '";
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue5.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue5.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue5.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + CustomEvent.PROPERTIES + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonMapOptMap = (JsonMap) jsonValue5.toJsonValue();
                        }
                    }
                    i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                    if (i != 1) {
                        return new DoubleOptIn(jsonMapOptMap);
                    }
                    if (i != 2) {
                        if (i == 3) {
                            return new Transactional(jsonMapOptMap);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    jsonValue = jsonMapRequireMap.get("commercial_opted_in");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'commercial_opted_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString = jsonValue.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        boolValueOf = (Boolean) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        boolValueOf = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        boolValueOf = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue.optList();
                        if (objOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "commercial_opted_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue2 = jsonValue.toJsonValue();
                        if (jsonValue2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) jsonValue2;
                    }
                    return new Commercial(jsonMapOptMap, boolValueOf.booleanValue());
                }
                jsonMapOptMap = (JsonMap) jsonValue5.optString();
            }
            str = "' for field '";
            i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i != 1) {
                return new DoubleOptIn(jsonMapOptMap);
            }
            if (i != 2) {
                if (i == 3) {
                    return new Transactional(jsonMapOptMap);
                }
                throw new NoWhenBranchMatchedException();
            }
            jsonValue = jsonMapRequireMap.get("commercial_opted_in");
            if (jsonValue != null) {
                throw new JsonException("Missing required field: 'commercial_opted_in" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                objOptString2 = jsonValue.optString();
                if (objOptString2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                objOptString = jsonValue.optString();
                if (objOptString != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                boolValueOf = (Boolean) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                boolValueOf = (Boolean) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                boolValueOf = (Boolean) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                boolValueOf = (Boolean) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList = jsonValue.optList();
                if (objOptList != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap = jsonValue.optMap();
                if (objOptMap != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) objOptMap;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + str + "commercial_opted_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolValueOf = (Boolean) jsonValue2;
            }
            return new Commercial(jsonMapOptMap, boolValueOf.booleanValue());
        }
    }
}
