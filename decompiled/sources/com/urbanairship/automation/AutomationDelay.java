package com.urbanairship.automation;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.location.RegionEvent;
import com.urbanairship.automation.AutomationTrigger;
import com.urbanairship.automation.engine.triggerprocessor.TriggerExecutionType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lcom/urbanairship/automation/AutomationDelay;", "Lcom/urbanairship/json/JsonSerializable;", "seconds", "", "screens", "", "", "executionWindow", "Lcom/urbanairship/automation/ExecutionWindow;", "regionId", "appState", "Lcom/urbanairship/automation/AutomationAppState;", "cancellationTriggers", "Lcom/urbanairship/automation/AutomationTrigger;", "(Ljava/lang/Long;Ljava/util/List;Lcom/urbanairship/automation/ExecutionWindow;Ljava/lang/String;Lcom/urbanairship/automation/AutomationAppState;Ljava/util/List;)V", "getAppState", "()Lcom/urbanairship/automation/AutomationAppState;", "getCancellationTriggers", "()Ljava/util/List;", "getExecutionWindow$urbanairship_automation_release", "()Lcom/urbanairship/automation/ExecutionWindow;", "getRegionId", "()Ljava/lang/String;", "getScreens$urbanairship_automation_release", "getSeconds$urbanairship_automation_release", "()Ljava/lang/Long;", "Ljava/lang/Long;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationDelay implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AutomationAppState appState;
    private final List cancellationTriggers;
    private final ExecutionWindow executionWindow;
    private final String regionId;
    private final List screens;
    private final Long seconds;

    public AutomationDelay() {
        this(null, null, null, null, null, null, 63, null);
    }

    public AutomationDelay(@Nullable Long l, @Nullable List<String> list, @Nullable ExecutionWindow executionWindow, @Nullable String str, @Nullable AutomationAppState automationAppState, @Nullable List<? extends AutomationTrigger> list2) {
        this.seconds = l;
        this.screens = list;
        this.executionWindow = executionWindow;
        this.regionId = str;
        this.appState = automationAppState;
        this.cancellationTriggers = list2;
    }

    public /* synthetic */ AutomationDelay(Long l, List list, ExecutionWindow executionWindow, String str, AutomationAppState automationAppState, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : executionWindow, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : automationAppState, (i & 32) != 0 ? null : list2);
    }

    @Nullable
    /* renamed from: getSeconds$urbanairship_automation_release, reason: from getter */
    public final Long getSeconds() {
        return this.seconds;
    }

    @Nullable
    public final List<String> getScreens$urbanairship_automation_release() {
        return this.screens;
    }

    @Nullable
    /* renamed from: getExecutionWindow$urbanairship_automation_release, reason: from getter */
    public final ExecutionWindow getExecutionWindow() {
        return this.executionWindow;
    }

    @Nullable
    public final String getRegionId() {
        return this.regionId;
    }

    @Nullable
    public final AutomationAppState getAppState() {
        return this.appState;
    }

    @Nullable
    public final List<AutomationTrigger> getCancellationTriggers() {
        return this.cancellationTriggers;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/AutomationDelay$Companion;", "", "()V", "APP_STATE_KEY", "", "CANCELLATION_TRIGGERS_KEY", "EXECUTION_WINDOW_KEY", "REGION_ID_KEY", "SCREEN_KEY", "SECONDS_KEY", "fromJson", "Lcom/urbanairship/automation/AutomationDelay;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomationDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomationDelay.kt\ncom/urbanairship/automation/AutomationDelay$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1549#2:151\n1620#2,3:152\n1549#2:188\n1620#2,3:189\n79#3,16:155\n79#3,16:172\n1#4:171\n*S KotlinDebug\n*F\n+ 1 AutomationDelay.kt\ncom/urbanairship/automation/AutomationDelay$Companion\n*L\n105#1:151\n105#1:152,3\n113#1:188\n113#1:189,3\n109#1:155,16\n112#1:172,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationDelay fromJson(@NotNull JsonValue value) throws JsonException {
            List listListOf;
            JsonList jsonListRequireList;
            Long lValueOf;
            String strOptString;
            String str;
            ArrayList arrayList;
            JsonList jsonListRequireList2;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonList jsonListOptList = jsonMapRequireMap.opt("cancellation_triggers").optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
            if (CollectionsKt.count(jsonListOptList) > 10) {
                throw new IllegalArgumentException("No more than 10  cancellation triggers allowed.");
            }
            if (jsonMapRequireMap.opt(TCEventPropertiesNames.TCD_SCREEN).isString()) {
                listListOf = CollectionsKt.listOf(jsonMapRequireMap.opt(TCEventPropertiesNames.TCD_SCREEN).optString());
            } else {
                JsonValue jsonValue = jsonMapRequireMap.get(TCEventPropertiesNames.TCD_SCREEN);
                if (jsonValue == null || (jsonListRequireList = jsonValue.requireList()) == null) {
                    listListOf = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                    Iterator<JsonValue> it = jsonListRequireList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next().requireString());
                    }
                    listListOf = arrayList2;
                }
            }
            JsonValue jsonValue2 = jsonMapRequireMap.get("seconds");
            if (jsonValue2 == null) {
                lValueOf = null;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    lValueOf = (Long) jsonValue2.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    lValueOf = Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    lValueOf = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    lValueOf = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    lValueOf = (Long) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    lValueOf = (Long) jsonValue2.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    lValueOf = (Long) jsonValue2.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'seconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    lValueOf = (Long) jsonValue2.getJsonValue();
                }
            }
            JsonValue jsonValue3 = jsonMapRequireMap.get("app_state");
            AutomationAppState automationAppStateFromJson = jsonValue3 != null ? AutomationAppState.INSTANCE.fromJson(jsonValue3) : null;
            JsonValue jsonValue4 = jsonMapRequireMap.get(RegionEvent.REGION_ID);
            if (jsonValue4 == null) {
                str = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue4.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue4.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString = (String) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString = (String) jsonValue4.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString = (String) jsonValue4.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + RegionEvent.REGION_ID + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString = (String) jsonValue4.getJsonValue();
                }
                str = strOptString;
            }
            JsonValue jsonValue5 = jsonMapRequireMap.get("cancellation_triggers");
            if (jsonValue5 == null || (jsonListRequireList2 = jsonValue5.requireList()) == null) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList2, 10));
                for (JsonValue jsonValue6 : jsonListRequireList2) {
                    AutomationTrigger.Companion companion = AutomationTrigger.INSTANCE;
                    Intrinsics.checkNotNull(jsonValue6);
                    arrayList3.add(companion.fromJson(jsonValue6, TriggerExecutionType.DELAY_CANCELLATION));
                }
                arrayList = arrayList3;
            }
            JsonValue jsonValue7 = jsonMapRequireMap.get("execution_window");
            return new AutomationDelay(lValueOf, listListOf, jsonValue7 != null ? ExecutionWindow.INSTANCE.fromJson(jsonValue7) : null, str, automationAppStateFromJson, arrayList);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("seconds", this.seconds), TuplesKt.to("app_state", this.appState), TuplesKt.to(TCEventPropertiesNames.TCD_SCREEN, this.screens), TuplesKt.to(RegionEvent.REGION_ID, this.regionId), TuplesKt.to("cancellation_triggers", this.cancellationTriggers), TuplesKt.to("execution_window", this.executionWindow)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @NotNull
    public String toString() {
        String string = getJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AutomationDelay.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.AutomationDelay");
        AutomationDelay automationDelay = (AutomationDelay) other;
        if (Intrinsics.areEqual(this.seconds, automationDelay.seconds) && Intrinsics.areEqual(this.screens, automationDelay.screens) && Intrinsics.areEqual(this.regionId, automationDelay.regionId) && this.appState == automationDelay.appState && Intrinsics.areEqual(this.executionWindow, automationDelay.executionWindow)) {
            return Intrinsics.areEqual(this.cancellationTriggers, automationDelay.cancellationTriggers);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.seconds, this.screens, this.regionId, this.appState, this.cancellationTriggers, this.executionWindow);
    }
}
