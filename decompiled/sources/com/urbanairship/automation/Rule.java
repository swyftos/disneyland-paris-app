package com.urbanairship.automation;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SimpleTimeZone;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00152\u00020\u0001:\u0007\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH ¢\u0006\u0002\b\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0003\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/automation/Rule;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/automation/Rule$Type;", "timeZone", "Lcom/urbanairship/automation/Rule$TimeZone;", "(Lcom/urbanairship/automation/Rule$Type;Lcom/urbanairship/automation/Rule$TimeZone;)V", "getTimeZone$urbanairship_automation_release", "()Lcom/urbanairship/automation/Rule$TimeZone;", "getType$urbanairship_automation_release", "()Lcom/urbanairship/automation/Rule$Type;", "calendar", "Lcom/urbanairship/automation/AirshipCalendar;", "current", "Ljava/util/TimeZone;", "calendar$urbanairship_automation_release", "resolve", "Lcom/urbanairship/automation/DateRange;", "date", "Ljava/util/Date;", "resolve$urbanairship_automation_release", "Companion", "Daily", "Monthly", "TimeRange", "TimeZone", "Type", "Weekly", "Lcom/urbanairship/automation/Rule$Daily;", "Lcom/urbanairship/automation/Rule$Monthly;", "Lcom/urbanairship/automation/Rule$Weekly;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class Rule implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final TimeZone timeZone;
    private final Type type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimeZone.FailureMode.values().length];
            try {
                iArr[TimeZone.FailureMode.SKIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeZone.FailureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ Rule(Type type, TimeZone timeZone, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, timeZone);
    }

    @Nullable
    public abstract DateRange resolve$urbanairship_automation_release(@NotNull Date date, @NotNull java.util.TimeZone current) throws IllegalArgumentException;

    private Rule(Type type, TimeZone timeZone) {
        this.type = type;
        this.timeZone = timeZone;
    }

    @NotNull
    /* renamed from: getType$urbanairship_automation_release, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: getTimeZone$urbanairship_automation_release, reason: from getter */
    public final TimeZone getTimeZone() {
        return this.timeZone;
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/automation/Rule$Daily;", "Lcom/urbanairship/automation/Rule;", "timeRange", "Lcom/urbanairship/automation/Rule$TimeRange;", "timeZone", "Lcom/urbanairship/automation/Rule$TimeZone;", "(Lcom/urbanairship/automation/Rule$TimeRange;Lcom/urbanairship/automation/Rule$TimeZone;)V", "getTimeRange", "()Lcom/urbanairship/automation/Rule$TimeRange;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "resolve", "Lcom/urbanairship/automation/DateRange;", "date", "Ljava/util/Date;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Daily extends Rule {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final TimeRange timeRange;

        public /* synthetic */ Daily(TimeRange timeRange, TimeZone timeZone, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(timeRange, (i & 2) != 0 ? null : timeZone);
        }

        @NotNull
        public final TimeRange getTimeRange() {
            return this.timeRange;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Daily(@NotNull TimeRange timeRange, @Nullable TimeZone timeZone) {
            super(Type.DAILY, timeZone, null);
            Intrinsics.checkNotNullParameter(timeRange, "timeRange");
            this.timeRange = timeRange;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$Daily$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/Rule$Daily;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Daily$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n1#2:892\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Daily fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                TimeRange.Companion companion = TimeRange.INSTANCE;
                JsonValue jsonValueRequire = jsonMapRequireMap.require("time_range");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                TimeRange timeRangeFromJson = companion.fromJson(jsonValueRequire);
                JsonValue jsonValue = jsonMapRequireMap.get("time_zone");
                return new Daily(timeRangeFromJson, jsonValue != null ? TimeZone.INSTANCE.fromJson(jsonValue) : null);
            }
        }

        @Override // com.urbanairship.automation.Rule
        @Nullable
        public DateRange resolve$urbanairship_automation_release(@NotNull Date date, @NotNull java.util.TimeZone current) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(current, "current");
            AirshipCalendar airshipCalendarCalendar$urbanairship_automation_release = calendar$urbanairship_automation_release(getTimeZone(), current);
            if (airshipCalendarCalendar$urbanairship_automation_release != null) {
                return airshipCalendarCalendar$urbanairship_automation_release.dateInterval(date, this.timeRange);
            }
            return null;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType()), TuplesKt.to("time_range", this.timeRange), TuplesKt.to("time_zone", getTimeZone())).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Daily.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.Rule.Daily");
            Daily daily = (Daily) other;
            return Intrinsics.areEqual(this.timeRange, daily.timeRange) && Intrinsics.areEqual(getTimeZone(), daily.getTimeZone());
        }

        public int hashCode() {
            return Objects.hash(this.timeRange, getTimeZone());
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0010¢\u0006\u0002\b\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/automation/Rule$Weekly;", "Lcom/urbanairship/automation/Rule;", "daysOfWeek", "", "", "timeRange", "Lcom/urbanairship/automation/Rule$TimeRange;", "timeZone", "Lcom/urbanairship/automation/Rule$TimeZone;", "(Ljava/util/List;Lcom/urbanairship/automation/Rule$TimeRange;Lcom/urbanairship/automation/Rule$TimeZone;)V", "getDaysOfWeek", "()Ljava/util/List;", "getTimeRange", "()Lcom/urbanairship/automation/Rule$TimeRange;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "resolve", "Lcom/urbanairship/automation/DateRange;", "date", "Ljava/util/Date;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Weekly\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n1726#2,3:892\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Weekly\n*L\n205#1:892,3\n*E\n"})
    public static final class Weekly extends Rule {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final List daysOfWeek;
        private final TimeRange timeRange;

        public /* synthetic */ Weekly(List list, TimeRange timeRange, TimeZone timeZone, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? null : timeRange, (i & 4) != 0 ? null : timeZone);
        }

        @NotNull
        public final List<Integer> getDaysOfWeek() {
            return this.daysOfWeek;
        }

        @Nullable
        public final TimeRange getTimeRange() {
            return this.timeRange;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Weekly(@NotNull List<Integer> daysOfWeek, @Nullable TimeRange timeRange, @Nullable TimeZone timeZone) {
            super(Type.WEEKLY, timeZone, null);
            Intrinsics.checkNotNullParameter(daysOfWeek, "daysOfWeek");
            this.daysOfWeek = daysOfWeek;
            this.timeRange = timeRange;
            if (daysOfWeek.isEmpty()) {
                throw new IllegalArgumentException("Invalid daysOfWeek, must contain at least 1 day of week");
            }
            if (daysOfWeek == null || !daysOfWeek.isEmpty()) {
                Iterator<T> it = daysOfWeek.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (1 > iIntValue || iIntValue >= 8) {
                        throw new IllegalArgumentException(("Invalid daysOfWeek: " + this.daysOfWeek + ", all values must be [1-7]").toString());
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$Weekly$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/Rule$Weekly;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Weekly$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n1603#2,9:892\n1855#2:901\n1856#2:903\n1612#2:904\n1#3:902\n1#3:905\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Weekly$Companion\n*L\n190#1:892,9\n190#1:901\n190#1:903\n190#1:904\n190#1:902\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Weekly fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                try {
                    JsonList jsonListRequireList = jsonMapRequireMap.require("days_of_week").requireList();
                    Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
                    ArrayList arrayList = new ArrayList();
                    Iterator<JsonValue> it = jsonListRequireList.iterator();
                    while (it.hasNext()) {
                        Integer integer = it.next().getInteger();
                        if (integer != null) {
                            arrayList.add(integer);
                        }
                    }
                    JsonValue jsonValue = jsonMapRequireMap.get("time_range");
                    TimeRange timeRangeFromJson = jsonValue != null ? TimeRange.INSTANCE.fromJson(jsonValue) : null;
                    JsonValue jsonValue2 = jsonMapRequireMap.get("time_zone");
                    return new Weekly(arrayList, timeRangeFromJson, jsonValue2 != null ? TimeZone.INSTANCE.fromJson(jsonValue2) : null);
                } catch (IllegalArgumentException e) {
                    throw new JsonException("Invalid parameter", e);
                }
            }
        }

        @Override // com.urbanairship.automation.Rule
        @Nullable
        public DateRange resolve$urbanairship_automation_release(@NotNull Date date, @NotNull java.util.TimeZone current) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(current, "current");
            AirshipCalendar airshipCalendarCalendar$urbanairship_automation_release = calendar$urbanairship_automation_release(getTimeZone(), current);
            if (airshipCalendarCalendar$urbanairship_automation_release == null) {
                return null;
            }
            Date dateNextDate = airshipCalendarCalendar$urbanairship_automation_release.nextDate(date, this.daysOfWeek);
            if (this.timeRange == null) {
                return airshipCalendarCalendar$urbanairship_automation_release.remainingDay(dateNextDate);
            }
            while (true) {
                DateRange dateRangeIntersection = airshipCalendarCalendar$urbanairship_automation_release.dateInterval(dateNextDate, this.timeRange).intersection(airshipCalendarCalendar$urbanairship_automation_release.remainingDay(dateNextDate));
                if (dateRangeIntersection != null) {
                    return dateRangeIntersection;
                }
                Date time = airshipCalendarCalendar$urbanairship_automation_release.startOfDay(date, 1).getTime();
                Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                dateNextDate = airshipCalendarCalendar$urbanairship_automation_release.nextDate(time, this.daysOfWeek);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType()), TuplesKt.to("days_of_week", this.daysOfWeek), TuplesKt.to("time_range", this.timeRange), TuplesKt.to("time_zone", getTimeZone())).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Weekly.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.Rule.Weekly");
            Weekly weekly = (Weekly) other;
            return Intrinsics.areEqual(this.daysOfWeek, weekly.daysOfWeek) && Intrinsics.areEqual(this.timeRange, weekly.timeRange) && Intrinsics.areEqual(getTimeZone(), weekly.getTimeZone());
        }

        public int hashCode() {
            return Objects.hash(this.daysOfWeek, this.timeRange, getTimeZone());
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBA\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/automation/Rule$Monthly;", "Lcom/urbanairship/automation/Rule;", "months", "", "", "daysOfMonth", "timeRange", "Lcom/urbanairship/automation/Rule$TimeRange;", "timeZone", "Lcom/urbanairship/automation/Rule$TimeZone;", "(Ljava/util/List;Ljava/util/List;Lcom/urbanairship/automation/Rule$TimeRange;Lcom/urbanairship/automation/Rule$TimeZone;)V", "getDaysOfMonth", "()Ljava/util/List;", "getMonths", "getTimeRange", "()Lcom/urbanairship/automation/Rule$TimeRange;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "resolve", "Lcom/urbanairship/automation/DateRange;", "date", "Ljava/util/Date;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Monthly\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n1726#2,3:892\n1726#2,3:895\n1549#2:898\n1620#2,3:899\n1549#2:902\n1620#2,3:903\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Monthly\n*L\n294#1:892,3\n300#1:895,3\n307#1:898\n307#1:899,3\n336#1:902\n336#1:903,3\n*E\n"})
    public static final class Monthly extends Rule {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final List daysOfMonth;
        private final List months;
        private final TimeRange timeRange;

        public Monthly() {
            this(null, null, null, null, 15, null);
        }

        public /* synthetic */ Monthly(List list, List list2, TimeRange timeRange, TimeZone timeZone, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : timeRange, (i & 8) != 0 ? null : timeZone);
        }

        @Nullable
        public final List<Integer> getMonths() {
            return this.months;
        }

        @Nullable
        public final List<Integer> getDaysOfMonth() {
            return this.daysOfMonth;
        }

        @Nullable
        public final TimeRange getTimeRange() {
            return this.timeRange;
        }

        public Monthly(@Nullable List<Integer> list, @Nullable List<Integer> list2, @Nullable TimeRange timeRange, @Nullable TimeZone timeZone) {
            super(Type.MONTHLY, timeZone, null);
            this.months = list;
            this.daysOfMonth = list2;
            this.timeRange = timeRange;
            if ((list2 == null || !(!list2.isEmpty())) && (list == null || !(!list.isEmpty()))) {
                throw new IllegalArgumentException("monthly rule must define either months or days of month");
            }
            if (list != null && !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (1 > iIntValue || iIntValue >= 13) {
                        throw new IllegalArgumentException(("Invalid month: " + list + ", all values must be [1-12]").toString());
                    }
                }
            }
            List list3 = this.daysOfMonth;
            if (list3 == null || list3.isEmpty()) {
                return;
            }
            Iterator it2 = list3.iterator();
            while (it2.hasNext()) {
                int iIntValue2 = ((Number) it2.next()).intValue();
                if (1 > iIntValue2 || iIntValue2 >= 32) {
                    throw new IllegalArgumentException(("Invalid days of month: " + list3 + ", all values must be [1-31]").toString());
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$Monthly$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/Rule$Monthly;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Monthly$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n1603#2,9:892\n1855#2:901\n1856#2:903\n1612#2:904\n1549#2:905\n1620#2,3:906\n1603#2,9:909\n1855#2:918\n1856#2:920\n1612#2:921\n1#3:902\n1#3:919\n1#3:922\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Monthly$Companion\n*L\n276#1:892,9\n276#1:901\n276#1:903\n276#1:904\n277#1:905\n277#1:906,3\n278#1:909,9\n278#1:918\n278#1:920\n278#1:921\n276#1:902\n278#1:919\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Monthly fromJson(@NotNull JsonValue value) throws JsonException {
                ArrayList arrayList;
                ArrayList arrayList2;
                JsonList jsonListRequireList;
                JsonList jsonListRequireList2;
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                try {
                    JsonValue jsonValue = jsonMapRequireMap.get("months");
                    if (jsonValue == null || (jsonListRequireList2 = jsonValue.requireList()) == null) {
                        arrayList = null;
                    } else {
                        ArrayList<Integer> arrayList3 = new ArrayList();
                        Iterator<JsonValue> it = jsonListRequireList2.iterator();
                        while (it.hasNext()) {
                            Integer integer = it.next().getInteger();
                            if (integer != null) {
                                arrayList3.add(integer);
                            }
                        }
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                        for (Integer num : arrayList3) {
                            Intrinsics.checkNotNull(num);
                            num.intValue();
                            arrayList.add(num);
                        }
                    }
                    JsonValue jsonValue2 = jsonMapRequireMap.get("days_of_month");
                    if (jsonValue2 == null || (jsonListRequireList = jsonValue2.requireList()) == null) {
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList();
                        Iterator<JsonValue> it2 = jsonListRequireList.iterator();
                        while (it2.hasNext()) {
                            Integer integer2 = it2.next().getInteger();
                            if (integer2 != null) {
                                arrayList2.add(integer2);
                            }
                        }
                    }
                    JsonValue jsonValue3 = jsonMapRequireMap.get("time_range");
                    TimeRange timeRangeFromJson = jsonValue3 != null ? TimeRange.INSTANCE.fromJson(jsonValue3) : null;
                    JsonValue jsonValue4 = jsonMapRequireMap.get("time_zone");
                    return new Monthly(arrayList, arrayList2, timeRangeFromJson, jsonValue4 != null ? TimeZone.INSTANCE.fromJson(jsonValue4) : null);
                } catch (IllegalArgumentException e) {
                    throw new JsonException("Invalid parameter", e);
                }
            }
        }

        @Override // com.urbanairship.automation.Rule
        @Nullable
        public DateRange resolve$urbanairship_automation_release(@NotNull Date date, @NotNull java.util.TimeZone current) throws IllegalArgumentException {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(current, "current");
            List list = this.months;
            if (list != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((Number) it.next()).intValue() - 1));
                }
            } else {
                arrayList = null;
            }
            AirshipCalendar airshipCalendarCalendar$urbanairship_automation_release = calendar$urbanairship_automation_release(getTimeZone(), current);
            if (airshipCalendarCalendar$urbanairship_automation_release == null) {
                return null;
            }
            Date dateNextDate = airshipCalendarCalendar$urbanairship_automation_release.nextDate(date, arrayList, this.daysOfMonth);
            if (this.timeRange == null) {
                return airshipCalendarCalendar$urbanairship_automation_release.remainingDay(dateNextDate);
            }
            while (true) {
                DateRange dateRangeIntersection = airshipCalendarCalendar$urbanairship_automation_release.dateInterval(dateNextDate, this.timeRange).intersection(airshipCalendarCalendar$urbanairship_automation_release.remainingDay(dateNextDate));
                if (dateRangeIntersection != null) {
                    return dateRangeIntersection;
                }
                Date time = airshipCalendarCalendar$urbanairship_automation_release.startOfDay(date, 1).getTime();
                Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                dateNextDate = airshipCalendarCalendar$urbanairship_automation_release.nextDate(time, arrayList, this.daysOfMonth);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            ArrayList arrayList;
            Pair pair = TuplesKt.to("type", getType());
            List list = this.months;
            if (list != null) {
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(((Number) it.next()).intValue()));
                }
            } else {
                arrayList = null;
            }
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, TuplesKt.to("months", arrayList), TuplesKt.to("days_of_month", this.daysOfMonth), TuplesKt.to("time_range", this.timeRange), TuplesKt.to("time_zone", getTimeZone())).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Monthly.class, other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.Rule.Monthly");
            Monthly monthly = (Monthly) other;
            return Intrinsics.areEqual(this.months, monthly.months) && Intrinsics.areEqual(this.daysOfMonth, monthly.daysOfMonth) && Intrinsics.areEqual(this.timeRange, monthly.timeRange) && Intrinsics.areEqual(getTimeZone(), monthly.getTimeZone());
        }

        public int hashCode() {
            return Objects.hash(this.months, this.daysOfMonth, this.timeRange, getTimeZone());
        }
    }

    @Nullable
    public final AirshipCalendar calendar$urbanairship_automation_release(@Nullable TimeZone timeZone, @NotNull java.util.TimeZone current) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(current, "current");
        if (timeZone == null) {
            return new AirshipCalendar(current);
        }
        TimeZone.Resolution resolutionResolve$urbanairship_automation_release = timeZone.resolve$urbanairship_automation_release(current);
        if (resolutionResolve$urbanairship_automation_release instanceof TimeZone.Resolution.Resolved) {
            return new AirshipCalendar(((TimeZone.Resolution.Resolved) resolutionResolve$urbanairship_automation_release).getTimeZone());
        }
        if (resolutionResolve$urbanairship_automation_release instanceof TimeZone.Resolution.Error) {
            int i = WhenMappings.$EnumSwitchMapping$0[((TimeZone.Resolution.Error) resolutionResolve$urbanairship_automation_release).getMode().ordinal()];
            if (i == 1) {
                return null;
            }
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalArgumentException("Unable to resolve time zone: " + timeZone);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/Rule$Companion;", "", "()V", "DAYS_OF_MONTH", "", "DAYS_OF_WEEK", "MONTHS", "TIME_RANGE", "TIME_ZONE", "TYPE", "fromJson", "Lcom/urbanairship/automation/Rule;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.DAILY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.WEEKLY.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Type.MONTHLY.ordinal()] = 3;
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
        public final Rule fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            try {
                Type.Companion companion = Type.INSTANCE;
                JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                int i = WhenMappings.$EnumSwitchMapping$0[companion.fromJson(jsonValueRequire).ordinal()];
                if (i == 1) {
                    return Daily.INSTANCE.fromJson(value);
                }
                if (i == 2) {
                    return Weekly.INSTANCE.fromJson(value);
                }
                if (i == 3) {
                    return Monthly.INSTANCE.fromJson(value);
                }
                throw new NoWhenBranchMatchedException();
            } catch (IllegalArgumentException e) {
                throw new JsonException("Invalid parameter", e);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/Rule$Type;", "", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "DAILY", "WEEKLY", "MONTHLY", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String jsonValue;
        public static final Type DAILY = new Type("DAILY", 0, "daily");
        public static final Type WEEKLY = new Type("WEEKLY", 1, "weekly");
        public static final Type MONTHLY = new Type("MONTHLY", 2, "monthly");

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DAILY, WEEKLY, MONTHLY};
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
            this.jsonValue = str2;
        }

        @NotNull
        public final String getJsonValue() {
            return this.jsonValue;
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.jsonValue);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$Type$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/Rule$Type;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Type$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n223#2,2:892\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$Type$Companion\n*L\n416#1:892,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Type fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                try {
                    for (Type type : Type.getEntries()) {
                        if (Intrinsics.areEqual(type.getJsonValue(), value.requireString())) {
                            return type;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                } catch (NoSuchElementException e) {
                    throw new JsonException("Invalid rule type " + value, e);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0014J\u000e\u0010\u0015\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0016J\u000e\u0010\u0017\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0018J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006$"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeRange;", "Lcom/urbanairship/json/JsonSerializable;", "startHour", "", "startMinute", "endHour", "endMinute", "(IIII)V", ViewProps.END, "getEnd", "()I", "getEndHour$urbanairship_automation_release", "getEndMinute$urbanairship_automation_release", ViewProps.START, "getStart", "getStartHour$urbanairship_automation_release", "getStartMinute$urbanairship_automation_release", "component1", "component1$urbanairship_automation_release", "component2", "component2$urbanairship_automation_release", "component3", "component3$urbanairship_automation_release", "component4", "component4$urbanairship_automation_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class TimeRange implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int endHour;
        private final int endMinute;
        private final int startHour;
        private final int startMinute;

        public static /* synthetic */ TimeRange copy$default(TimeRange timeRange, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = timeRange.startHour;
            }
            if ((i5 & 2) != 0) {
                i2 = timeRange.startMinute;
            }
            if ((i5 & 4) != 0) {
                i3 = timeRange.endHour;
            }
            if ((i5 & 8) != 0) {
                i4 = timeRange.endMinute;
            }
            return timeRange.copy(i, i2, i3, i4);
        }

        /* renamed from: component1$urbanairship_automation_release, reason: from getter */
        public final int getStartHour() {
            return this.startHour;
        }

        /* renamed from: component2$urbanairship_automation_release, reason: from getter */
        public final int getStartMinute() {
            return this.startMinute;
        }

        /* renamed from: component3$urbanairship_automation_release, reason: from getter */
        public final int getEndHour() {
            return this.endHour;
        }

        /* renamed from: component4$urbanairship_automation_release, reason: from getter */
        public final int getEndMinute() {
            return this.endMinute;
        }

        @NotNull
        public final TimeRange copy(int startHour, int startMinute, int endHour, int endMinute) {
            return new TimeRange(startHour, startMinute, endHour, endMinute);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimeRange)) {
                return false;
            }
            TimeRange timeRange = (TimeRange) other;
            return this.startHour == timeRange.startHour && this.startMinute == timeRange.startMinute && this.endHour == timeRange.endHour && this.endMinute == timeRange.endMinute;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.startHour) * 31) + Integer.hashCode(this.startMinute)) * 31) + Integer.hashCode(this.endHour)) * 31) + Integer.hashCode(this.endMinute);
        }

        @NotNull
        public String toString() {
            return "TimeRange(startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", endHour=" + this.endHour + ", endMinute=" + this.endMinute + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public TimeRange(int i, int i2, int i3, int i4) {
            this.startHour = i;
            this.startMinute = i2;
            this.endHour = i3;
            this.endMinute = i4;
            if (i < 0 || i >= 24) {
                throw new IllegalArgumentException(("Invalid startHour (" + i + "), must be [0-23]").toString());
            }
            if (i2 < 0 || i2 >= 60) {
                throw new IllegalArgumentException(("Invalid startMinute (" + i2 + "), must be [0-59]").toString());
            }
            if (i3 < 0 || i3 >= 24) {
                throw new IllegalArgumentException(("Invalid endHour (" + i3 + "), must be [0-23]").toString());
            }
            if (i4 < 0 || i4 >= 60) {
                throw new IllegalArgumentException(("Invalid endMinute (" + i4 + "), must be [0-59]").toString());
            }
        }

        public /* synthetic */ TimeRange(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i5 & 2) != 0 ? 0 : i2, i3, (i5 & 8) != 0 ? 0 : i4);
        }

        public final int getStartHour$urbanairship_automation_release() {
            return this.startHour;
        }

        public final int getStartMinute$urbanairship_automation_release() {
            return this.startMinute;
        }

        public final int getEndHour$urbanairship_automation_release() {
            return this.endHour;
        }

        public final int getEndMinute$urbanairship_automation_release() {
            return this.endMinute;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeRange$Companion;", "", "()V", "END_HOUR", "", "END_MINUTE", "START_HOUR", "START_MINUTE", "fromJson", "Lcom/urbanairship/automation/Rule$TimeRange;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeRange$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,891:1\n44#2,15:892\n79#2,16:907\n44#2,15:923\n79#2,16:938\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeRange$Companion\n*L\n443#1:892,15\n444#1:907,16\n445#1:923,15\n446#1:938,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:108:0x029e A[Catch: IllegalArgumentException -> 0x004e, TryCatch #0 {IllegalArgumentException -> 0x004e, blocks: (B:3:0x0014, B:6:0x0020, B:9:0x0042, B:11:0x0048, B:64:0x0169, B:108:0x029e, B:110:0x02a4, B:112:0x02ac, B:114:0x02ba, B:116:0x02c0, B:167:0x03dc, B:212:0x0510, B:214:0x0516, B:170:0x03ec, B:172:0x03fa, B:174:0x0404, B:176:0x040e, B:177:0x0415, B:179:0x0421, B:180:0x042d, B:182:0x0439, B:183:0x0446, B:185:0x0450, B:186:0x0461, B:188:0x046d, B:189:0x047a, B:191:0x0486, B:192:0x0493, B:194:0x049d, B:195:0x04a8, B:197:0x04b4, B:198:0x04bf, B:200:0x04c9, B:202:0x04da, B:204:0x04e5, B:205:0x04ec, B:207:0x04f6, B:208:0x04fd, B:210:0x0507, B:216:0x051a, B:217:0x0541, B:118:0x02c6, B:119:0x02cb, B:120:0x02cc, B:122:0x02d6, B:124:0x02dc, B:125:0x02df, B:126:0x02e4, B:127:0x02e5, B:129:0x02f1, B:130:0x02fd, B:132:0x0309, B:133:0x0319, B:135:0x0325, B:136:0x0337, B:138:0x0343, B:139:0x0351, B:141:0x035d, B:142:0x036a, B:144:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x0398, B:150:0x03a2, B:152:0x03a8, B:153:0x03ab, B:154:0x03b0, B:155:0x03b1, B:157:0x03bb, B:159:0x03c1, B:160:0x03c4, B:161:0x03c9, B:162:0x03ca, B:164:0x03d4, B:166:0x03da, B:218:0x0542, B:219:0x0547, B:220:0x0548, B:221:0x056f, B:222:0x0570, B:223:0x0589, B:67:0x0179, B:69:0x0187, B:71:0x0190, B:73:0x019a, B:74:0x01a1, B:76:0x01ad, B:77:0x01b9, B:79:0x01c5, B:80:0x01d4, B:82:0x01e1, B:83:0x01f3, B:85:0x01ff, B:86:0x020d, B:88:0x0219, B:89:0x0226, B:91:0x0230, B:92:0x023a, B:94:0x0246, B:95:0x0250, B:97:0x025a, B:98:0x026a, B:100:0x0274, B:101:0x027b, B:103:0x0285, B:104:0x028c, B:106:0x0296, B:224:0x058a, B:225:0x05b2, B:15:0x0051, B:16:0x0056, B:17:0x0057, B:19:0x0063, B:21:0x0069, B:22:0x006c, B:23:0x0071, B:24:0x0072, B:26:0x007e, B:27:0x008a, B:29:0x0096, B:30:0x00a6, B:32:0x00b2, B:33:0x00c4, B:35:0x00d0, B:36:0x00de, B:38:0x00ea, B:39:0x00f7, B:41:0x0101, B:42:0x010b, B:44:0x0115, B:45:0x0125, B:47:0x012f, B:49:0x0135, B:50:0x0138, B:51:0x013d, B:52:0x013e, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:58:0x0156, B:59:0x0157, B:61:0x0161, B:63:0x0167, B:226:0x05b3, B:227:0x05b8, B:228:0x05b9, B:229:0x05df, B:230:0x05e0, B:231:0x05fa), top: B:234:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:109:0x02a3  */
            /* JADX WARN: Removed duplicated region for block: B:112:0x02ac A[Catch: IllegalArgumentException -> 0x004e, TryCatch #0 {IllegalArgumentException -> 0x004e, blocks: (B:3:0x0014, B:6:0x0020, B:9:0x0042, B:11:0x0048, B:64:0x0169, B:108:0x029e, B:110:0x02a4, B:112:0x02ac, B:114:0x02ba, B:116:0x02c0, B:167:0x03dc, B:212:0x0510, B:214:0x0516, B:170:0x03ec, B:172:0x03fa, B:174:0x0404, B:176:0x040e, B:177:0x0415, B:179:0x0421, B:180:0x042d, B:182:0x0439, B:183:0x0446, B:185:0x0450, B:186:0x0461, B:188:0x046d, B:189:0x047a, B:191:0x0486, B:192:0x0493, B:194:0x049d, B:195:0x04a8, B:197:0x04b4, B:198:0x04bf, B:200:0x04c9, B:202:0x04da, B:204:0x04e5, B:205:0x04ec, B:207:0x04f6, B:208:0x04fd, B:210:0x0507, B:216:0x051a, B:217:0x0541, B:118:0x02c6, B:119:0x02cb, B:120:0x02cc, B:122:0x02d6, B:124:0x02dc, B:125:0x02df, B:126:0x02e4, B:127:0x02e5, B:129:0x02f1, B:130:0x02fd, B:132:0x0309, B:133:0x0319, B:135:0x0325, B:136:0x0337, B:138:0x0343, B:139:0x0351, B:141:0x035d, B:142:0x036a, B:144:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x0398, B:150:0x03a2, B:152:0x03a8, B:153:0x03ab, B:154:0x03b0, B:155:0x03b1, B:157:0x03bb, B:159:0x03c1, B:160:0x03c4, B:161:0x03c9, B:162:0x03ca, B:164:0x03d4, B:166:0x03da, B:218:0x0542, B:219:0x0547, B:220:0x0548, B:221:0x056f, B:222:0x0570, B:223:0x0589, B:67:0x0179, B:69:0x0187, B:71:0x0190, B:73:0x019a, B:74:0x01a1, B:76:0x01ad, B:77:0x01b9, B:79:0x01c5, B:80:0x01d4, B:82:0x01e1, B:83:0x01f3, B:85:0x01ff, B:86:0x020d, B:88:0x0219, B:89:0x0226, B:91:0x0230, B:92:0x023a, B:94:0x0246, B:95:0x0250, B:97:0x025a, B:98:0x026a, B:100:0x0274, B:101:0x027b, B:103:0x0285, B:104:0x028c, B:106:0x0296, B:224:0x058a, B:225:0x05b2, B:15:0x0051, B:16:0x0056, B:17:0x0057, B:19:0x0063, B:21:0x0069, B:22:0x006c, B:23:0x0071, B:24:0x0072, B:26:0x007e, B:27:0x008a, B:29:0x0096, B:30:0x00a6, B:32:0x00b2, B:33:0x00c4, B:35:0x00d0, B:36:0x00de, B:38:0x00ea, B:39:0x00f7, B:41:0x0101, B:42:0x010b, B:44:0x0115, B:45:0x0125, B:47:0x012f, B:49:0x0135, B:50:0x0138, B:51:0x013d, B:52:0x013e, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:58:0x0156, B:59:0x0157, B:61:0x0161, B:63:0x0167, B:226:0x05b3, B:227:0x05b8, B:228:0x05b9, B:229:0x05df, B:230:0x05e0, B:231:0x05fa), top: B:234:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:169:0x03e8  */
            /* JADX WARN: Removed duplicated region for block: B:170:0x03ec A[Catch: IllegalArgumentException -> 0x004e, TryCatch #0 {IllegalArgumentException -> 0x004e, blocks: (B:3:0x0014, B:6:0x0020, B:9:0x0042, B:11:0x0048, B:64:0x0169, B:108:0x029e, B:110:0x02a4, B:112:0x02ac, B:114:0x02ba, B:116:0x02c0, B:167:0x03dc, B:212:0x0510, B:214:0x0516, B:170:0x03ec, B:172:0x03fa, B:174:0x0404, B:176:0x040e, B:177:0x0415, B:179:0x0421, B:180:0x042d, B:182:0x0439, B:183:0x0446, B:185:0x0450, B:186:0x0461, B:188:0x046d, B:189:0x047a, B:191:0x0486, B:192:0x0493, B:194:0x049d, B:195:0x04a8, B:197:0x04b4, B:198:0x04bf, B:200:0x04c9, B:202:0x04da, B:204:0x04e5, B:205:0x04ec, B:207:0x04f6, B:208:0x04fd, B:210:0x0507, B:216:0x051a, B:217:0x0541, B:118:0x02c6, B:119:0x02cb, B:120:0x02cc, B:122:0x02d6, B:124:0x02dc, B:125:0x02df, B:126:0x02e4, B:127:0x02e5, B:129:0x02f1, B:130:0x02fd, B:132:0x0309, B:133:0x0319, B:135:0x0325, B:136:0x0337, B:138:0x0343, B:139:0x0351, B:141:0x035d, B:142:0x036a, B:144:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x0398, B:150:0x03a2, B:152:0x03a8, B:153:0x03ab, B:154:0x03b0, B:155:0x03b1, B:157:0x03bb, B:159:0x03c1, B:160:0x03c4, B:161:0x03c9, B:162:0x03ca, B:164:0x03d4, B:166:0x03da, B:218:0x0542, B:219:0x0547, B:220:0x0548, B:221:0x056f, B:222:0x0570, B:223:0x0589, B:67:0x0179, B:69:0x0187, B:71:0x0190, B:73:0x019a, B:74:0x01a1, B:76:0x01ad, B:77:0x01b9, B:79:0x01c5, B:80:0x01d4, B:82:0x01e1, B:83:0x01f3, B:85:0x01ff, B:86:0x020d, B:88:0x0219, B:89:0x0226, B:91:0x0230, B:92:0x023a, B:94:0x0246, B:95:0x0250, B:97:0x025a, B:98:0x026a, B:100:0x0274, B:101:0x027b, B:103:0x0285, B:104:0x028c, B:106:0x0296, B:224:0x058a, B:225:0x05b2, B:15:0x0051, B:16:0x0056, B:17:0x0057, B:19:0x0063, B:21:0x0069, B:22:0x006c, B:23:0x0071, B:24:0x0072, B:26:0x007e, B:27:0x008a, B:29:0x0096, B:30:0x00a6, B:32:0x00b2, B:33:0x00c4, B:35:0x00d0, B:36:0x00de, B:38:0x00ea, B:39:0x00f7, B:41:0x0101, B:42:0x010b, B:44:0x0115, B:45:0x0125, B:47:0x012f, B:49:0x0135, B:50:0x0138, B:51:0x013d, B:52:0x013e, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:58:0x0156, B:59:0x0157, B:61:0x0161, B:63:0x0167, B:226:0x05b3, B:227:0x05b8, B:228:0x05b9, B:229:0x05df, B:230:0x05e0, B:231:0x05fa), top: B:234:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:212:0x0510 A[Catch: IllegalArgumentException -> 0x004e, TryCatch #0 {IllegalArgumentException -> 0x004e, blocks: (B:3:0x0014, B:6:0x0020, B:9:0x0042, B:11:0x0048, B:64:0x0169, B:108:0x029e, B:110:0x02a4, B:112:0x02ac, B:114:0x02ba, B:116:0x02c0, B:167:0x03dc, B:212:0x0510, B:214:0x0516, B:170:0x03ec, B:172:0x03fa, B:174:0x0404, B:176:0x040e, B:177:0x0415, B:179:0x0421, B:180:0x042d, B:182:0x0439, B:183:0x0446, B:185:0x0450, B:186:0x0461, B:188:0x046d, B:189:0x047a, B:191:0x0486, B:192:0x0493, B:194:0x049d, B:195:0x04a8, B:197:0x04b4, B:198:0x04bf, B:200:0x04c9, B:202:0x04da, B:204:0x04e5, B:205:0x04ec, B:207:0x04f6, B:208:0x04fd, B:210:0x0507, B:216:0x051a, B:217:0x0541, B:118:0x02c6, B:119:0x02cb, B:120:0x02cc, B:122:0x02d6, B:124:0x02dc, B:125:0x02df, B:126:0x02e4, B:127:0x02e5, B:129:0x02f1, B:130:0x02fd, B:132:0x0309, B:133:0x0319, B:135:0x0325, B:136:0x0337, B:138:0x0343, B:139:0x0351, B:141:0x035d, B:142:0x036a, B:144:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x0398, B:150:0x03a2, B:152:0x03a8, B:153:0x03ab, B:154:0x03b0, B:155:0x03b1, B:157:0x03bb, B:159:0x03c1, B:160:0x03c4, B:161:0x03c9, B:162:0x03ca, B:164:0x03d4, B:166:0x03da, B:218:0x0542, B:219:0x0547, B:220:0x0548, B:221:0x056f, B:222:0x0570, B:223:0x0589, B:67:0x0179, B:69:0x0187, B:71:0x0190, B:73:0x019a, B:74:0x01a1, B:76:0x01ad, B:77:0x01b9, B:79:0x01c5, B:80:0x01d4, B:82:0x01e1, B:83:0x01f3, B:85:0x01ff, B:86:0x020d, B:88:0x0219, B:89:0x0226, B:91:0x0230, B:92:0x023a, B:94:0x0246, B:95:0x0250, B:97:0x025a, B:98:0x026a, B:100:0x0274, B:101:0x027b, B:103:0x0285, B:104:0x028c, B:106:0x0296, B:224:0x058a, B:225:0x05b2, B:15:0x0051, B:16:0x0056, B:17:0x0057, B:19:0x0063, B:21:0x0069, B:22:0x006c, B:23:0x0071, B:24:0x0072, B:26:0x007e, B:27:0x008a, B:29:0x0096, B:30:0x00a6, B:32:0x00b2, B:33:0x00c4, B:35:0x00d0, B:36:0x00de, B:38:0x00ea, B:39:0x00f7, B:41:0x0101, B:42:0x010b, B:44:0x0115, B:45:0x0125, B:47:0x012f, B:49:0x0135, B:50:0x0138, B:51:0x013d, B:52:0x013e, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:58:0x0156, B:59:0x0157, B:61:0x0161, B:63:0x0167, B:226:0x05b3, B:227:0x05b8, B:228:0x05b9, B:229:0x05df, B:230:0x05e0, B:231:0x05fa), top: B:234:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:213:0x0515  */
            /* JADX WARN: Removed duplicated region for block: B:222:0x0570 A[Catch: IllegalArgumentException -> 0x004e, TryCatch #0 {IllegalArgumentException -> 0x004e, blocks: (B:3:0x0014, B:6:0x0020, B:9:0x0042, B:11:0x0048, B:64:0x0169, B:108:0x029e, B:110:0x02a4, B:112:0x02ac, B:114:0x02ba, B:116:0x02c0, B:167:0x03dc, B:212:0x0510, B:214:0x0516, B:170:0x03ec, B:172:0x03fa, B:174:0x0404, B:176:0x040e, B:177:0x0415, B:179:0x0421, B:180:0x042d, B:182:0x0439, B:183:0x0446, B:185:0x0450, B:186:0x0461, B:188:0x046d, B:189:0x047a, B:191:0x0486, B:192:0x0493, B:194:0x049d, B:195:0x04a8, B:197:0x04b4, B:198:0x04bf, B:200:0x04c9, B:202:0x04da, B:204:0x04e5, B:205:0x04ec, B:207:0x04f6, B:208:0x04fd, B:210:0x0507, B:216:0x051a, B:217:0x0541, B:118:0x02c6, B:119:0x02cb, B:120:0x02cc, B:122:0x02d6, B:124:0x02dc, B:125:0x02df, B:126:0x02e4, B:127:0x02e5, B:129:0x02f1, B:130:0x02fd, B:132:0x0309, B:133:0x0319, B:135:0x0325, B:136:0x0337, B:138:0x0343, B:139:0x0351, B:141:0x035d, B:142:0x036a, B:144:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x0398, B:150:0x03a2, B:152:0x03a8, B:153:0x03ab, B:154:0x03b0, B:155:0x03b1, B:157:0x03bb, B:159:0x03c1, B:160:0x03c4, B:161:0x03c9, B:162:0x03ca, B:164:0x03d4, B:166:0x03da, B:218:0x0542, B:219:0x0547, B:220:0x0548, B:221:0x056f, B:222:0x0570, B:223:0x0589, B:67:0x0179, B:69:0x0187, B:71:0x0190, B:73:0x019a, B:74:0x01a1, B:76:0x01ad, B:77:0x01b9, B:79:0x01c5, B:80:0x01d4, B:82:0x01e1, B:83:0x01f3, B:85:0x01ff, B:86:0x020d, B:88:0x0219, B:89:0x0226, B:91:0x0230, B:92:0x023a, B:94:0x0246, B:95:0x0250, B:97:0x025a, B:98:0x026a, B:100:0x0274, B:101:0x027b, B:103:0x0285, B:104:0x028c, B:106:0x0296, B:224:0x058a, B:225:0x05b2, B:15:0x0051, B:16:0x0056, B:17:0x0057, B:19:0x0063, B:21:0x0069, B:22:0x006c, B:23:0x0071, B:24:0x0072, B:26:0x007e, B:27:0x008a, B:29:0x0096, B:30:0x00a6, B:32:0x00b2, B:33:0x00c4, B:35:0x00d0, B:36:0x00de, B:38:0x00ea, B:39:0x00f7, B:41:0x0101, B:42:0x010b, B:44:0x0115, B:45:0x0125, B:47:0x012f, B:49:0x0135, B:50:0x0138, B:51:0x013d, B:52:0x013e, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:58:0x0156, B:59:0x0157, B:61:0x0161, B:63:0x0167, B:226:0x05b3, B:227:0x05b8, B:228:0x05b9, B:229:0x05df, B:230:0x05e0, B:231:0x05fa), top: B:234:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:66:0x0175  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0179 A[Catch: IllegalArgumentException -> 0x004e, TryCatch #0 {IllegalArgumentException -> 0x004e, blocks: (B:3:0x0014, B:6:0x0020, B:9:0x0042, B:11:0x0048, B:64:0x0169, B:108:0x029e, B:110:0x02a4, B:112:0x02ac, B:114:0x02ba, B:116:0x02c0, B:167:0x03dc, B:212:0x0510, B:214:0x0516, B:170:0x03ec, B:172:0x03fa, B:174:0x0404, B:176:0x040e, B:177:0x0415, B:179:0x0421, B:180:0x042d, B:182:0x0439, B:183:0x0446, B:185:0x0450, B:186:0x0461, B:188:0x046d, B:189:0x047a, B:191:0x0486, B:192:0x0493, B:194:0x049d, B:195:0x04a8, B:197:0x04b4, B:198:0x04bf, B:200:0x04c9, B:202:0x04da, B:204:0x04e5, B:205:0x04ec, B:207:0x04f6, B:208:0x04fd, B:210:0x0507, B:216:0x051a, B:217:0x0541, B:118:0x02c6, B:119:0x02cb, B:120:0x02cc, B:122:0x02d6, B:124:0x02dc, B:125:0x02df, B:126:0x02e4, B:127:0x02e5, B:129:0x02f1, B:130:0x02fd, B:132:0x0309, B:133:0x0319, B:135:0x0325, B:136:0x0337, B:138:0x0343, B:139:0x0351, B:141:0x035d, B:142:0x036a, B:144:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x0398, B:150:0x03a2, B:152:0x03a8, B:153:0x03ab, B:154:0x03b0, B:155:0x03b1, B:157:0x03bb, B:159:0x03c1, B:160:0x03c4, B:161:0x03c9, B:162:0x03ca, B:164:0x03d4, B:166:0x03da, B:218:0x0542, B:219:0x0547, B:220:0x0548, B:221:0x056f, B:222:0x0570, B:223:0x0589, B:67:0x0179, B:69:0x0187, B:71:0x0190, B:73:0x019a, B:74:0x01a1, B:76:0x01ad, B:77:0x01b9, B:79:0x01c5, B:80:0x01d4, B:82:0x01e1, B:83:0x01f3, B:85:0x01ff, B:86:0x020d, B:88:0x0219, B:89:0x0226, B:91:0x0230, B:92:0x023a, B:94:0x0246, B:95:0x0250, B:97:0x025a, B:98:0x026a, B:100:0x0274, B:101:0x027b, B:103:0x0285, B:104:0x028c, B:106:0x0296, B:224:0x058a, B:225:0x05b2, B:15:0x0051, B:16:0x0056, B:17:0x0057, B:19:0x0063, B:21:0x0069, B:22:0x006c, B:23:0x0071, B:24:0x0072, B:26:0x007e, B:27:0x008a, B:29:0x0096, B:30:0x00a6, B:32:0x00b2, B:33:0x00c4, B:35:0x00d0, B:36:0x00de, B:38:0x00ea, B:39:0x00f7, B:41:0x0101, B:42:0x010b, B:44:0x0115, B:45:0x0125, B:47:0x012f, B:49:0x0135, B:50:0x0138, B:51:0x013d, B:52:0x013e, B:54:0x0148, B:56:0x014e, B:57:0x0151, B:58:0x0156, B:59:0x0157, B:61:0x0161, B:63:0x0167, B:226:0x05b3, B:227:0x05b8, B:228:0x05b9, B:229:0x05df, B:230:0x05e0, B:231:0x05fa), top: B:234:0x0014 }] */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.automation.Rule.TimeRange fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r21) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1539
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.automation.Rule.TimeRange.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.automation.Rule$TimeRange");
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("start_hour", Integer.valueOf(this.startHour)), TuplesKt.to("start_minute", Integer.valueOf(this.startMinute)), TuplesKt.to("end_hour", Integer.valueOf(this.endHour)), TuplesKt.to("end_minute", Integer.valueOf(this.endMinute))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }

        public final int getStart() {
            return (this.startHour * 3600) + (this.startMinute * 60);
        }

        public final int getEnd() {
            return (this.endHour * 3600) + (this.endMinute * 60);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \f2\u00020\u0001:\u0007\f\r\u000e\u000f\u0010\u0011\u0012B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH ¢\u0006\u0002\b\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/automation/Rule$TimeZone$Type;", "(Lcom/urbanairship/automation/Rule$TimeZone$Type;)V", "getType$urbanairship_automation_release", "()Lcom/urbanairship/automation/Rule$TimeZone$Type;", "resolve", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "Companion", "FailureMode", "Identifiers", "Local", "Resolution", "Type", "Utc", "Lcom/urbanairship/automation/Rule$TimeZone$Identifiers;", "Lcom/urbanairship/automation/Rule$TimeZone$Local;", "Lcom/urbanairship/automation/Rule$TimeZone$Utc;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static abstract class TimeZone implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final Type type;

        public /* synthetic */ TimeZone(Type type, DefaultConstructorMarker defaultConstructorMarker) {
            this(type);
        }

        @NotNull
        public abstract Resolution resolve$urbanairship_automation_release(@NotNull java.util.TimeZone current);

        private TimeZone(Type type) {
            this.type = type;
        }

        @NotNull
        /* renamed from: getType$urbanairship_automation_release, reason: from getter */
        public final Type getType() {
            return this.type;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "", "()V", "Error", "Resolved", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution$Error;", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution$Resolved;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class Resolution {
            public /* synthetic */ Resolution(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Resolution$Resolved;", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "timeZone", "Ljava/util/TimeZone;", "(Ljava/util/TimeZone;)V", "getTimeZone", "()Ljava/util/TimeZone;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Resolved extends Resolution {
                private final java.util.TimeZone timeZone;

                public static /* synthetic */ Resolved copy$default(Resolved resolved, java.util.TimeZone timeZone, int i, Object obj) {
                    if ((i & 1) != 0) {
                        timeZone = resolved.timeZone;
                    }
                    return resolved.copy(timeZone);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final java.util.TimeZone getTimeZone() {
                    return this.timeZone;
                }

                @NotNull
                public final Resolved copy(@NotNull java.util.TimeZone timeZone) {
                    Intrinsics.checkNotNullParameter(timeZone, "timeZone");
                    return new Resolved(timeZone);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Resolved) && Intrinsics.areEqual(this.timeZone, ((Resolved) other).timeZone);
                }

                public int hashCode() {
                    return this.timeZone.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Resolved(timeZone=" + this.timeZone + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Resolved(@NotNull java.util.TimeZone timeZone) {
                    super(null);
                    Intrinsics.checkNotNullParameter(timeZone, "timeZone");
                    this.timeZone = timeZone;
                }

                @NotNull
                public final java.util.TimeZone getTimeZone() {
                    return this.timeZone;
                }
            }

            private Resolution() {
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Resolution$Error;", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "mode", "Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;", "(Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;)V", "getMode", "()Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Error extends Resolution {
                private final FailureMode mode;

                public static /* synthetic */ Error copy$default(Error error, FailureMode failureMode, int i, Object obj) {
                    if ((i & 1) != 0) {
                        failureMode = error.mode;
                    }
                    return error.copy(failureMode);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final FailureMode getMode() {
                    return this.mode;
                }

                @NotNull
                public final Error copy(@NotNull FailureMode mode) {
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    return new Error(mode);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Error) && this.mode == ((Error) other).mode;
                }

                public int hashCode() {
                    return this.mode.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Error(mode=" + this.mode + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Error(@NotNull FailureMode mode) {
                    super(null);
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    this.mode = mode;
                }

                @NotNull
                public final FailureMode getMode() {
                    return this.mode;
                }
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Utc;", "Lcom/urbanairship/automation/Rule$TimeZone;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "resolve", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Utc extends TimeZone {

            @NotNull
            public static final Utc INSTANCE = new Utc();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Utc);
            }

            public int hashCode() {
                return -1839117225;
            }

            @NotNull
            public String toString() {
                return "Utc";
            }

            private Utc() {
                super(Type.UTC, null);
            }

            @Override // com.urbanairship.automation.Rule.TimeZone
            @NotNull
            public Resolution resolve$urbanairship_automation_release(@NotNull java.util.TimeZone current) {
                Intrinsics.checkNotNullParameter(current, "current");
                return new Resolution.Resolved(new SimpleTimeZone(0, "UTC"));
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            /* renamed from: toJsonValue */
            public JsonValue getJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType())).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 $2\u00020\u0001:\u0001$B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001ø\u0001\u0000¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0010¢\u0006\u0002\b J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Identifiers;", "Lcom/urbanairship/automation/Rule$TimeZone;", "ids", "", "", "secondsFromUtc", "Lkotlin/time/Duration;", "onFailure", "Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;", "(Ljava/util/List;Lkotlin/time/Duration;Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIds", "()Ljava/util/List;", "getOnFailure", "()Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;", "getSecondsFromUtc-FghU774", "()Lkotlin/time/Duration;", "component1", "component2", "component2-FghU774", "component3", "copy", "copy-Kx4hsE0", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "resolve", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$Identifiers\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n288#2,2:892\n1#3:894\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$Identifiers\n*L\n532#1:892,2\n*E\n"})
        public static final /* data */ class Identifiers extends TimeZone {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final List ids;
            private final FailureMode onFailure;
            private final Duration secondsFromUtc;

            public /* synthetic */ Identifiers(List list, Duration duration, FailureMode failureMode, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, duration, failureMode);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: copy-Kx4hsE0$default, reason: not valid java name */
            public static /* synthetic */ Identifiers m2786copyKx4hsE0$default(Identifiers identifiers, List list, Duration duration, FailureMode failureMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = identifiers.ids;
                }
                if ((i & 2) != 0) {
                    duration = identifiers.secondsFromUtc;
                }
                if ((i & 4) != 0) {
                    failureMode = identifiers.onFailure;
                }
                return identifiers.m2788copyKx4hsE0(list, duration, failureMode);
            }

            @NotNull
            public final List<String> component1() {
                return this.ids;
            }

            @Nullable
            /* renamed from: component2-FghU774, reason: not valid java name and from getter */
            public final Duration getSecondsFromUtc() {
                return this.secondsFromUtc;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final FailureMode getOnFailure() {
                return this.onFailure;
            }

            @NotNull
            /* renamed from: copy-Kx4hsE0, reason: not valid java name */
            public final Identifiers m2788copyKx4hsE0(@NotNull List<String> ids, @Nullable Duration secondsFromUtc, @NotNull FailureMode onFailure) {
                Intrinsics.checkNotNullParameter(ids, "ids");
                Intrinsics.checkNotNullParameter(onFailure, "onFailure");
                return new Identifiers(ids, secondsFromUtc, onFailure, null);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Identifiers)) {
                    return false;
                }
                Identifiers identifiers = (Identifiers) other;
                return Intrinsics.areEqual(this.ids, identifiers.ids) && Intrinsics.areEqual(this.secondsFromUtc, identifiers.secondsFromUtc) && this.onFailure == identifiers.onFailure;
            }

            public int hashCode() {
                int iHashCode = this.ids.hashCode() * 31;
                Duration duration = this.secondsFromUtc;
                return ((iHashCode + (duration == null ? 0 : Duration.m3494hashCodeimpl(duration.getRawValue()))) * 31) + this.onFailure.hashCode();
            }

            @NotNull
            public String toString() {
                return "Identifiers(ids=" + this.ids + ", secondsFromUtc=" + this.secondsFromUtc + ", onFailure=" + this.onFailure + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final List<String> getIds() {
                return this.ids;
            }

            @Nullable
            /* renamed from: getSecondsFromUtc-FghU774, reason: not valid java name */
            public final Duration m2789getSecondsFromUtcFghU774() {
                return this.secondsFromUtc;
            }

            public /* synthetic */ Identifiers(List list, Duration duration, FailureMode failureMode, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(list, (i & 2) != 0 ? null : duration, (i & 4) != 0 ? FailureMode.ERROR : failureMode, null);
            }

            @NotNull
            public final FailureMode getOnFailure() {
                return this.onFailure;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            private Identifiers(List ids, Duration duration, FailureMode onFailure) {
                super(Type.IDENTIFIER, null);
                Intrinsics.checkNotNullParameter(ids, "ids");
                Intrinsics.checkNotNullParameter(onFailure, "onFailure");
                this.ids = ids;
                this.secondsFromUtc = duration;
                this.onFailure = onFailure;
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            /* renamed from: toJsonValue */
            public JsonValue getJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType()), TuplesKt.to("identifiers", this.ids), TuplesKt.to("fallback_seconds_from_utc", this.secondsFromUtc), TuplesKt.to("on_failure", this.onFailure)).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Identifiers$Companion;", "", "()V", "FALLBACK_SECONDS_FROM_UTC", "", "IDENTIFIERS", "ON_FAILURE", "fromJson", "Lcom/urbanairship/automation/Rule$TimeZone$Identifiers;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$Identifiers$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n1549#2:892\n1620#2,3:893\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$Identifiers$Companion\n*L\n523#1:892\n523#1:893,3\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Identifiers fromJson(@NotNull JsonValue value) throws JsonException {
                    Duration durationM3465boximpl;
                    Intrinsics.checkNotNullParameter(value, "value");
                    JsonMap jsonMapRequireMap = value.requireMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                    JsonList jsonListRequireList = jsonMapRequireMap.require("identifiers").requireList();
                    Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                    Iterator<JsonValue> it = jsonListRequireList.iterator();
                    while (it.hasNext()) {
                        String strRequireString = it.next().requireString();
                        Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                        arrayList.add(strRequireString);
                    }
                    JsonValue jsonValue = jsonMapRequireMap.get("fallback_seconds_from_utc");
                    DefaultConstructorMarker defaultConstructorMarker = null;
                    if (jsonValue != null) {
                        int i = jsonValue.getInt(0);
                        Duration.Companion companion = Duration.INSTANCE;
                        durationM3465boximpl = Duration.m3465boximpl(DurationKt.toDuration(i, DurationUnit.SECONDS));
                    } else {
                        durationM3465boximpl = null;
                    }
                    FailureMode.Companion companion2 = FailureMode.INSTANCE;
                    JsonValue jsonValueRequire = jsonMapRequireMap.require("on_failure");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                    return new Identifiers(arrayList, durationM3465boximpl, companion2.fromJson(jsonValueRequire), defaultConstructorMarker);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v6, types: [java.util.TimeZone] */
            @Override // com.urbanairship.automation.Rule.TimeZone
            @NotNull
            public Resolution resolve$urbanairship_automation_release(@NotNull java.util.TimeZone current) {
                SimpleTimeZone simpleTimeZone;
                Object next;
                ?? timeZone;
                Intrinsics.checkNotNullParameter(current, "current");
                String[] availableIDs = java.util.TimeZone.getAvailableIDs();
                Iterator it = this.ids.iterator();
                while (true) {
                    simpleTimeZone = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Intrinsics.checkNotNull(availableIDs);
                    if (ArraysKt.contains(availableIDs, (String) next)) {
                        break;
                    }
                }
                String str = (String) next;
                if (str == null || (timeZone = java.util.TimeZone.getTimeZone(str)) == 0) {
                    Duration duration = this.secondsFromUtc;
                    if (duration != null) {
                        duration.getRawValue();
                        simpleTimeZone = new SimpleTimeZone((int) Duration.m3485getInWholeMillisecondsimpl(this.secondsFromUtc.getRawValue()), "USR");
                    }
                } else {
                    simpleTimeZone = timeZone;
                }
                return simpleTimeZone != null ? new Resolution.Resolved(simpleTimeZone) : new Resolution.Error(this.onFailure);
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Local;", "Lcom/urbanairship/automation/Rule$TimeZone;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "resolve", "Lcom/urbanairship/automation/Rule$TimeZone$Resolution;", "current", "Ljava/util/TimeZone;", "resolve$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Local extends TimeZone {

            @NotNull
            public static final Local INSTANCE = new Local();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Local);
            }

            public int hashCode() {
                return 2126415198;
            }

            @NotNull
            public String toString() {
                return "Local";
            }

            private Local() {
                super(Type.LOCAL, null);
            }

            @Override // com.urbanairship.automation.Rule.TimeZone
            @NotNull
            public Resolution resolve$urbanairship_automation_release(@NotNull java.util.TimeZone current) {
                Intrinsics.checkNotNullParameter(current, "current");
                java.util.TimeZone timeZone = java.util.TimeZone.getDefault();
                Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
                return new Resolution.Resolved(timeZone);
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            /* renamed from: toJsonValue */
            public JsonValue getJsonValue() {
                JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", getType())).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return jsonValue;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Companion;", "", "()V", "TYPE", "", "fromJson", "Lcom/urbanairship/automation/Rule$TimeZone;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Type.values().length];
                    try {
                        iArr[Type.UTC.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Type.LOCAL.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Type.IDENTIFIER.ordinal()] = 3;
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
            public final TimeZone fromJson(@NotNull JsonValue value) throws JsonException {
                Intrinsics.checkNotNullParameter(value, "value");
                JsonMap jsonMapRequireMap = value.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                Type.Companion companion = Type.INSTANCE;
                JsonValue jsonValueRequire = jsonMapRequireMap.require("type");
                Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                int i = WhenMappings.$EnumSwitchMapping$0[companion.fromJson(jsonValueRequire).ordinal()];
                if (i == 1) {
                    return Utc.INSTANCE;
                }
                if (i == 2) {
                    return Local.INSTANCE;
                }
                if (i == 3) {
                    return Identifiers.INSTANCE.fromJson(value);
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Type;", "", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "UTC", "LOCAL", "IDENTIFIER", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Type implements JsonSerializable {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Type[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            private final String jsonValue;
            public static final Type UTC = new Type("UTC", 0, "utc");
            public static final Type LOCAL = new Type("LOCAL", 1, ImagesContract.LOCAL);
            public static final Type IDENTIFIER = new Type("IDENTIFIER", 2, "identifiers");

            private static final /* synthetic */ Type[] $values() {
                return new Type[]{UTC, LOCAL, IDENTIFIER};
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
                this.jsonValue = str2;
            }

            @NotNull
            public final String getJsonValue() {
                return this.jsonValue;
            }

            static {
                Type[] typeArr$values = $values();
                $VALUES = typeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
                INSTANCE = new Companion(null);
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            /* renamed from: toJsonValue */
            public JsonValue getJsonValue() {
                JsonValue jsonValueWrap = JsonValue.wrap(this.jsonValue);
                Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
                return jsonValueWrap;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$Type$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/Rule$TimeZone$Type;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$Type$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n223#2,2:892\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$Type$Companion\n*L\n577#1:892,2\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Type fromJson(@NotNull JsonValue value) throws JsonException {
                    Intrinsics.checkNotNullParameter(value, "value");
                    try {
                        for (Type type : Type.getEntries()) {
                            if (Intrinsics.areEqual(type.getJsonValue(), value.requireString())) {
                                return type;
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    } catch (NoSuchElementException e) {
                        throw new JsonException("Invalid failure timezone type " + value, e);
                    }
                }
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;", "", "Lcom/urbanairship/json/JsonSerializable;", "jsonValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJsonValue", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "ERROR", "SKIP", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class FailureMode implements JsonSerializable {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ FailureMode[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final FailureMode ERROR = new FailureMode("ERROR", 0, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            public static final FailureMode SKIP = new FailureMode("SKIP", 1, "skip");
            private final String jsonValue;

            private static final /* synthetic */ FailureMode[] $values() {
                return new FailureMode[]{ERROR, SKIP};
            }

            @NotNull
            public static EnumEntries<FailureMode> getEntries() {
                return $ENTRIES;
            }

            public static FailureMode valueOf(String str) {
                return (FailureMode) Enum.valueOf(FailureMode.class, str);
            }

            public static FailureMode[] values() {
                return (FailureMode[]) $VALUES.clone();
            }

            private FailureMode(String str, int i, String str2) {
                this.jsonValue = str2;
            }

            @NotNull
            public final String getJsonValue() {
                return this.jsonValue;
            }

            static {
                FailureMode[] failureModeArr$values = $values();
                $VALUES = failureModeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(failureModeArr$values);
                INSTANCE = new Companion(null);
            }

            @Override // com.urbanairship.json.JsonSerializable
            @NotNull
            /* renamed from: toJsonValue */
            public JsonValue getJsonValue() {
                JsonValue jsonValueWrap = JsonValue.wrap(this.jsonValue);
                Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
                return jsonValueWrap;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/Rule$TimeZone$FailureMode$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/automation/Rule$TimeZone$FailureMode;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$FailureMode$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,891:1\n223#2,2:892\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/Rule$TimeZone$FailureMode$Companion\n*L\n595#1:892,2\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final FailureMode fromJson(@NotNull JsonValue value) throws JsonException {
                    Intrinsics.checkNotNullParameter(value, "value");
                    try {
                        for (FailureMode failureMode : FailureMode.getEntries()) {
                            if (Intrinsics.areEqual(failureMode.getJsonValue(), value.requireString())) {
                                return failureMode;
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    } catch (NoSuchElementException e) {
                        throw new JsonException("Invalid failure mode " + value, e);
                    }
                }
            }
        }
    }
}
