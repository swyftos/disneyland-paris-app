package com.urbanairship.automation.limits;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.limits.storage.ConstraintEntity;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Lcom/urbanairship/automation/limits/FrequencyConstraint;", "", "identifier", "", "range", "Lkotlin/time/Duration;", "count", "", "(Ljava/lang/String;JILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCount", "()I", "getIdentifier", "()Ljava/lang/String;", "getRange-UwyO8pc", "()J", "J", "component1", "component2", "component2-UwyO8pc", "component3", "copy", "copy-8Mi8wO0", "(Ljava/lang/String;JI)Lcom/urbanairship/automation/limits/FrequencyConstraint;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "makeEntity", "Lcom/urbanairship/automation/limits/storage/ConstraintEntity;", "makeEntity$urbanairship_automation_release", "toString", "Companion", "Period", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FrequencyConstraint {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int count;
    private final String identifier;
    private final long range;

    public /* synthetic */ FrequencyConstraint(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, i);
    }

    /* renamed from: copy-8Mi8wO0$default, reason: not valid java name */
    public static /* synthetic */ FrequencyConstraint m2810copy8Mi8wO0$default(FrequencyConstraint frequencyConstraint, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = frequencyConstraint.identifier;
        }
        if ((i2 & 2) != 0) {
            j = frequencyConstraint.range;
        }
        if ((i2 & 4) != 0) {
            i = frequencyConstraint.count;
        }
        return frequencyConstraint.m2812copy8Mi8wO0(str, j, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component2-UwyO8pc, reason: not valid java name and from getter */
    public final long getRange() {
        return this.range;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    /* renamed from: copy-8Mi8wO0, reason: not valid java name */
    public final FrequencyConstraint m2812copy8Mi8wO0(@NotNull String identifier, long range, int count) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new FrequencyConstraint(identifier, range, count, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrequencyConstraint)) {
            return false;
        }
        FrequencyConstraint frequencyConstraint = (FrequencyConstraint) other;
        return Intrinsics.areEqual(this.identifier, frequencyConstraint.identifier) && Duration.m3472equalsimpl0(this.range, frequencyConstraint.range) && this.count == frequencyConstraint.count;
    }

    public int hashCode() {
        return (((this.identifier.hashCode() * 31) + Duration.m3494hashCodeimpl(this.range)) * 31) + Integer.hashCode(this.count);
    }

    @NotNull
    public String toString() {
        return "FrequencyConstraint(identifier=" + this.identifier + ", range=" + ((Object) Duration.m3515toStringimpl(this.range)) + ", count=" + this.count + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    private FrequencyConstraint(String identifier, long j, int i) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.range = j;
        this.count = i;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: getRange-UwyO8pc, reason: not valid java name */
    public final long m2813getRangeUwyO8pc() {
        return this.range;
    }

    public final int getCount() {
        return this.count;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/automation/limits/FrequencyConstraint$Companion;", "", "()V", "BOUNDARY", "", "IDENTIFIER", "PERIOD", "RANGE", "fromJson", "Lcom/urbanairship/automation/limits/FrequencyConstraint;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFrequencyConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrequencyConstraint.kt\ncom/urbanairship/automation/limits/FrequencyConstraint$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,77:1\n44#2,15:78\n44#2,15:93\n44#2,15:108\n*S KotlinDebug\n*F\n+ 1 FrequencyConstraint.kt\ncom/urbanairship/automation/limits/FrequencyConstraint$Companion\n*L\n26#1:78,15\n30#1:93,15\n32#1:108,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:118:0x02c5  */
        /* JADX WARN: Removed duplicated region for block: B:178:0x042d  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.automation.limits.FrequencyConstraint fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r28) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1242
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.limits.FrequencyConstraint.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.automation.limits.FrequencyConstraint");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static final class Period {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Period[] $VALUES;
        public static final Companion Companion;
        private final String json;
        public static final Period SECONDS = new Period("SECONDS", 0, "seconds");
        public static final Period MINUTES = new Period("MINUTES", 1, "minutes");
        public static final Period HOURS = new Period("HOURS", 2, "hours");
        public static final Period DAYS = new Period("DAYS", 3, "days");
        public static final Period WEEKS = new Period("WEEKS", 4, "weeks");
        public static final Period MONTHS = new Period("MONTHS", 5, "months");
        public static final Period YEARS = new Period("YEARS", 6, "years");

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Period.values().length];
                try {
                    iArr[Period.SECONDS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Period.MINUTES.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Period.HOURS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Period.DAYS.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Period.WEEKS.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Period.MONTHS.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Period.YEARS.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ Period[] $values() {
            return new Period[]{SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS};
        }

        public static EnumEntries getEntries() {
            return $ENTRIES;
        }

        public static Period valueOf(String str) {
            return (Period) Enum.valueOf(Period.class, str);
        }

        public static Period[] values() {
            return (Period[]) $VALUES.clone();
        }

        private Period(String str, int i, String str2) {
            this.json = str2;
        }

        public final String getJson() {
            return this.json;
        }

        static {
            Period[] periodArr$values = $values();
            $VALUES = periodArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(periodArr$values);
            Companion = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/limits/FrequencyConstraint$Period$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/limits/FrequencyConstraint$Period;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nFrequencyConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FrequencyConstraint.kt\ncom/urbanairship/automation/limits/FrequencyConstraint$Period$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,77:1\n288#2,2:78\n*S KotlinDebug\n*F\n+ 1 FrequencyConstraint.kt\ncom/urbanairship/automation/limits/FrequencyConstraint$Period$Companion\n*L\n51#1:78,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Period fromJson(@NotNull JsonValue value) throws JsonException {
                Object next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<E> it = Period.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((Period) next).getJson(), strRequireString)) {
                        break;
                    }
                }
                Period period = (Period) next;
                if (period != null) {
                    return period;
                }
                throw new JsonException("Invalid period " + strRequireString);
            }
        }

        /* renamed from: toSeconds-5sfh64U, reason: not valid java name */
        public final long m2814toSeconds5sfh64U(long j) {
            long j2;
            int i;
            Duration.Companion companion = Duration.INSTANCE;
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                case 2:
                    j2 = 60;
                    j *= j2;
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                case 3:
                    j2 = 60;
                    j *= j2;
                    j *= j2;
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                case 4:
                    long j3 = 60;
                    j = j * j3 * j3;
                    j2 = 24;
                    j *= j2;
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                case 5:
                    long j4 = 60;
                    j = j * j4 * j4 * 24;
                    i = 7;
                    j2 = i;
                    j *= j2;
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                case 6:
                    long j5 = 60;
                    j = j * j5 * j5 * 24;
                    i = 30;
                    j2 = i;
                    j *= j2;
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                case 7:
                    long j6 = 60;
                    j = j * j6 * j6 * 24;
                    i = 365;
                    j2 = i;
                    j *= j2;
                    return DurationKt.toDuration(j, DurationUnit.SECONDS);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    @NotNull
    public final ConstraintEntity makeEntity$urbanairship_automation_release() {
        ConstraintEntity constraintEntity = new ConstraintEntity();
        constraintEntity.setConstraintId(this.identifier);
        constraintEntity.m2818setRangeLRDsOJo(this.range);
        constraintEntity.setCount(this.count);
        return constraintEntity;
    }
}
