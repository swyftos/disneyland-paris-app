package com.urbanairship.automation;

import androidx.annotation.RestrictTo;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.ExecutionWindowResult;
import com.urbanairship.automation.Rule;
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
import java.util.Objects;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/automation/ExecutionWindow;", "Lcom/urbanairship/json/JsonSerializable;", "includes", "", "Lcom/urbanairship/automation/Rule;", "excludes", "(Ljava/util/List;Ljava/util/List;)V", "getExcludes$urbanairship_automation_release", "()Ljava/util/List;", "getIncludes$urbanairship_automation_release", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "nextAvailability", "Lcom/urbanairship/automation/ExecutionWindowResult;", "date", "Ljava/util/Date;", "currentTimeZone", "Ljava/util/TimeZone;", "nextAvailability$urbanairship_automation_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/ExecutionWindow\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n1603#2,9:892\n1855#2:901\n1856#2:903\n1612#2:904\n766#2:905\n857#2,2:906\n2333#2,14:908\n1603#2,9:922\n1855#2:931\n1856#2:933\n1612#2:934\n2333#2,14:935\n1#3:902\n1#3:932\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/ExecutionWindow\n*L\n55#1:892,9\n55#1:901\n55#1:903\n55#1:904\n56#1:905\n56#1:906,2\n57#1:908,14\n66#1:922,9\n66#1:931\n66#1:933\n66#1:934\n67#1:935,14\n55#1:902\n66#1:932\n*E\n"})
/* loaded from: classes5.dex */
public final class ExecutionWindow implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List excludes;
    private final List includes;

    public ExecutionWindow() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ExecutionWindow(@Nullable List<? extends Rule> list, @Nullable List<? extends Rule> list2) {
        this.includes = list;
        this.excludes = list2;
    }

    public /* synthetic */ ExecutionWindow(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    @Nullable
    public final List<Rule> getIncludes$urbanairship_automation_release() {
        return this.includes;
    }

    @Nullable
    public final List<Rule> getExcludes$urbanairship_automation_release() {
        return this.excludes;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/ExecutionWindow$Companion;", "", "()V", "EXCLUDES", "", "INCLUDES", "fromJson", "Lcom/urbanairship/automation/ExecutionWindow;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nExecutionWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/ExecutionWindow$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,891:1\n1603#2,9:892\n1855#2:901\n1856#2:903\n1612#2:904\n1603#2,9:905\n1855#2:914\n1856#2:916\n1612#2:917\n1#3:902\n1#3:915\n*S KotlinDebug\n*F\n+ 1 ExecutionWindow.kt\ncom/urbanairship/automation/ExecutionWindow$Companion\n*L\n36#1:892,9\n36#1:901\n36#1:903\n36#1:904\n37#1:905,9\n37#1:914\n37#1:916\n37#1:917\n36#1:902\n37#1:915\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ExecutionWindow fromJson(@NotNull JsonValue value) throws JsonException {
            ArrayList arrayList;
            JsonList jsonListRequireList;
            JsonList jsonListRequireList2;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("include");
            ArrayList arrayList2 = null;
            if (jsonValue == null || (jsonListRequireList2 = jsonValue.requireList()) == null) {
                arrayList = null;
            } else {
                Rule.Companion companion = Rule.INSTANCE;
                arrayList = new ArrayList();
                Iterator<JsonValue> it = jsonListRequireList2.iterator();
                while (it.hasNext()) {
                    Rule ruleFromJson = companion.fromJson(it.next());
                    if (ruleFromJson != null) {
                        arrayList.add(ruleFromJson);
                    }
                }
            }
            JsonValue jsonValue2 = jsonMapRequireMap.get("exclude");
            if (jsonValue2 != null && (jsonListRequireList = jsonValue2.requireList()) != null) {
                Rule.Companion companion2 = Rule.INSTANCE;
                arrayList2 = new ArrayList();
                Iterator<JsonValue> it2 = jsonListRequireList.iterator();
                while (it2.hasNext()) {
                    Rule ruleFromJson2 = companion2.fromJson(it2.next());
                    if (ruleFromJson2 != null) {
                        arrayList2.add(ruleFromJson2);
                    }
                }
            }
            return new ExecutionWindow(arrayList, arrayList2);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("include", this.includes), TuplesKt.to("exclude", this.excludes)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public static /* synthetic */ ExecutionWindowResult nextAvailability$urbanairship_automation_release$default(ExecutionWindow executionWindow, Date date, TimeZone timeZone, int i, Object obj) throws IllegalArgumentException {
        if ((i & 2) != 0) {
            timeZone = null;
        }
        return executionWindow.nextAvailability$urbanairship_automation_release(date, timeZone);
    }

    @NotNull
    public final ExecutionWindowResult nextAvailability$urbanairship_automation_release(@NotNull Date date, @Nullable TimeZone currentTimeZone) throws IllegalArgumentException {
        DateRange dateRange;
        DateRange dateRange2;
        Object next;
        Object next2;
        Intrinsics.checkNotNullParameter(date, "date");
        if (currentTimeZone == null) {
            currentTimeZone = TimeZone.getDefault();
        }
        List<Rule> list = this.excludes;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Rule rule : list) {
                Intrinsics.checkNotNull(currentTimeZone);
                DateRange dateRangeResolve$urbanairship_automation_release = rule.resolve$urbanairship_automation_release(date, currentTimeZone);
                if (dateRangeResolve$urbanairship_automation_release != null) {
                    arrayList.add(dateRangeResolve$urbanairship_automation_release);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((DateRange) obj).contains(date)) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                next2 = it.next();
                if (it.hasNext()) {
                    Date endDate = ((DateRange) next2).getEndDate();
                    do {
                        Object next3 = it.next();
                        Date endDate2 = ((DateRange) next3).getEndDate();
                        if (endDate.compareTo(endDate2) > 0) {
                            next2 = next3;
                            endDate = endDate2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next2 = null;
            }
            dateRange = (DateRange) next2;
        } else {
            dateRange = null;
        }
        if (dateRange != null) {
            Duration.Companion companion = Duration.INSTANCE;
            return new ExecutionWindowResult.Retry(((Duration) ComparisonsKt.maxOf(Duration.m3465boximpl(DurationKt.toDuration(1, DurationUnit.SECONDS)), Duration.m3465boximpl(ExecutionWindowKt.durationSince(dateRange.getEndDate(), date)))).getRawValue(), null);
        }
        List<Rule> list2 = this.includes;
        if (list2 != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Rule rule2 : list2) {
                Intrinsics.checkNotNull(currentTimeZone);
                DateRange dateRangeResolve$urbanairship_automation_release2 = rule2.resolve$urbanairship_automation_release(date, currentTimeZone);
                if (dateRangeResolve$urbanairship_automation_release2 != null) {
                    arrayList3.add(dateRangeResolve$urbanairship_automation_release2);
                }
            }
            Iterator it2 = arrayList3.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    Date startDate = ((DateRange) next).getStartDate();
                    do {
                        Object next4 = it2.next();
                        Date startDate2 = ((DateRange) next4).getStartDate();
                        if (startDate.compareTo(startDate2) > 0) {
                            next = next4;
                            startDate = startDate2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            dateRange2 = (DateRange) next;
        } else {
            dateRange2 = null;
        }
        if (dateRange2 == null || dateRange2.contains(date)) {
            return ExecutionWindowResult.Now.INSTANCE;
        }
        Duration.Companion companion2 = Duration.INSTANCE;
        return new ExecutionWindowResult.Retry(((Duration) ComparisonsKt.maxOf(Duration.m3465boximpl(DurationKt.toDuration(1, DurationUnit.SECONDS)), Duration.m3465boximpl(ExecutionWindowKt.durationSince(dateRange2.getStartDate(), date)))).getRawValue(), null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(ExecutionWindow.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.ExecutionWindow");
        ExecutionWindow executionWindow = (ExecutionWindow) other;
        return Intrinsics.areEqual(this.includes, executionWindow.includes) && Intrinsics.areEqual(this.excludes, executionWindow.excludes);
    }

    public int hashCode() {
        return Objects.hash(this.includes, this.excludes);
    }
}
