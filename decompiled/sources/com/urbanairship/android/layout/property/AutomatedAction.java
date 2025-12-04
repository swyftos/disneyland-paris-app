package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.info.Identifiable;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u0000 $2\u00020\u0001:\u0001$BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003JS\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/urbanairship/android/layout/property/AutomatedAction;", "Lcom/urbanairship/android/layout/info/Identifiable;", "identifier", "", "delay", "", "actions", "", "Lcom/urbanairship/json/JsonValue;", "behaviors", "", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "reportingMetadata", "(Ljava/lang/String;ILjava/util/Map;Ljava/util/List;Lcom/urbanairship/json/JsonValue;)V", "getActions", "()Ljava/util/Map;", "getBehaviors", "()Ljava/util/List;", "getDelay", "()I", "getIdentifier", "()Ljava/lang/String;", "getReportingMetadata", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AutomatedAction implements Identifiable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Map actions;
    private final List behaviors;
    private final int delay;
    private final String identifier;
    private final JsonValue reportingMetadata;

    public static /* synthetic */ AutomatedAction copy$default(AutomatedAction automatedAction, String str, int i, Map map, List list, JsonValue jsonValue, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = automatedAction.identifier;
        }
        if ((i2 & 2) != 0) {
            i = automatedAction.delay;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            map = automatedAction.actions;
        }
        Map map2 = map;
        if ((i2 & 8) != 0) {
            list = automatedAction.behaviors;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            jsonValue = automatedAction.reportingMetadata;
        }
        return automatedAction.copy(str, i3, map2, list2, jsonValue);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    @Nullable
    public final Map<String, JsonValue> component3() {
        return this.actions;
    }

    @Nullable
    public final List<ButtonClickBehaviorType> component4() {
        return this.behaviors;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonValue getReportingMetadata() {
        return this.reportingMetadata;
    }

    @NotNull
    public final AutomatedAction copy(@NotNull String identifier, int delay, @Nullable Map<String, ? extends JsonValue> actions, @Nullable List<? extends ButtonClickBehaviorType> behaviors, @Nullable JsonValue reportingMetadata) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        return new AutomatedAction(identifier, delay, actions, behaviors, reportingMetadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutomatedAction)) {
            return false;
        }
        AutomatedAction automatedAction = (AutomatedAction) other;
        return Intrinsics.areEqual(this.identifier, automatedAction.identifier) && this.delay == automatedAction.delay && Intrinsics.areEqual(this.actions, automatedAction.actions) && Intrinsics.areEqual(this.behaviors, automatedAction.behaviors) && Intrinsics.areEqual(this.reportingMetadata, automatedAction.reportingMetadata);
    }

    public int hashCode() {
        int iHashCode = ((this.identifier.hashCode() * 31) + Integer.hashCode(this.delay)) * 31;
        Map map = this.actions;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        List list = this.behaviors;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        JsonValue jsonValue = this.reportingMetadata;
        return iHashCode3 + (jsonValue != null ? jsonValue.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AutomatedAction(identifier=" + this.identifier + ", delay=" + this.delay + ", actions=" + this.actions + ", behaviors=" + this.behaviors + ", reportingMetadata=" + this.reportingMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AutomatedAction(@NotNull String identifier, int i, @Nullable Map<String, ? extends JsonValue> map, @Nullable List<? extends ButtonClickBehaviorType> list, @Nullable JsonValue jsonValue) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        this.identifier = identifier;
        this.delay = i;
        this.actions = map;
        this.behaviors = list;
        this.reportingMetadata = jsonValue;
    }

    public /* synthetic */ AutomatedAction(String str, int i, Map map, List list, JsonValue jsonValue, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : map, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : jsonValue);
    }

    @Override // com.urbanairship.android.layout.info.Identifiable
    @NotNull
    public String getIdentifier() {
        return this.identifier;
    }

    public final int getDelay() {
        return this.delay;
    }

    @Nullable
    public final Map<String, JsonValue> getActions() {
        return this.actions;
    }

    @Nullable
    public final List<ButtonClickBehaviorType> getBehaviors() {
        return this.behaviors;
    }

    @Nullable
    public final JsonValue getReportingMetadata() {
        return this.reportingMetadata;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0005\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/AutomatedAction$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/AutomatedAction;", "json", "Lcom/urbanairship/json/JsonMap;", "fromList", "", "Lcom/urbanairship/json/JsonList;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAutomatedAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomatedAction.kt\ncom/urbanairship/android/layout/property/AutomatedAction$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n44#2,15:54\n79#2,16:69\n79#2,16:85\n79#2,16:101\n79#2,16:117\n1549#3:133\n1620#3,3:134\n1045#3:137\n*S KotlinDebug\n*F\n+ 1 AutomatedAction.kt\ncom/urbanairship/android/layout/property/AutomatedAction$Companion\n*L\n19#1:54,15\n20#1:69,16\n21#1:85,16\n22#1:101,16\n25#1:117,16\n29#1:133\n29#1:134,3\n29#1:137\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomatedAction from(@NotNull JsonMap json) throws JsonException {
            String strOptString;
            Integer numValueOf;
            JsonMap jsonMapOptMap;
            JsonList jsonListOptList;
            JsonValue jsonValue;
            JsonValue jsonValue2;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue3 = json.get("identifier");
            if (jsonValue3 == null) {
                throw new JsonException("Missing required field: 'identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue3.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue3.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue3.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue3.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue4 = jsonValue3.getJsonValue();
                if (jsonValue4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue4;
            }
            String str = strOptString;
            JsonValue jsonValue5 = json.get("delay");
            if (jsonValue5 == null) {
                numValueOf = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue5.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue5.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    numValueOf = (Integer) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    numValueOf = (Integer) Long.valueOf(jsonValue5.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    numValueOf = (Integer) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    numValueOf = (Integer) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    numValueOf = (Integer) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    numValueOf = Integer.valueOf(jsonValue5.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    numValueOf = (Integer) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList2 = jsonValue5.optList();
                    if (objOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap2 = jsonValue5.optMap();
                    if (objOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) objOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Integer.class.getSimpleName() + "' for field 'delay" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue6 = jsonValue5.getJsonValue();
                    if (jsonValue6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    numValueOf = (Integer) jsonValue6;
                }
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
            JsonValue jsonValue7 = json.get("actions");
            if (jsonValue7 == null) {
                jsonMapOptMap = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue7.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue7.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue7.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue7.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue7.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue7.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue7.optMap();
                    if (jsonMapOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue8 = jsonValue7.getJsonValue();
                    if (jsonValue8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonValue8;
                }
            }
            Map<String, JsonValue> map = jsonMapOptMap != null ? jsonMapOptMap.getMap() : null;
            JsonValue jsonValue9 = json.get("behaviors");
            if (jsonValue9 == null) {
                jsonListOptList = null;
            } else {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JsonList.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString5 = jsonValue9.optString();
                    if (objOptString5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) objOptString5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString6 = jsonValue9.optString();
                    if (objOptString6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) objOptString6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonListOptList = (JsonList) Boolean.valueOf(jsonValue9.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonListOptList = (JsonList) Long.valueOf(jsonValue9.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonListOptList = (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonListOptList = (JsonList) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonListOptList = (JsonList) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonListOptList = (JsonList) Integer.valueOf(jsonValue9.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonListOptList = (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonListOptList = jsonValue9.optList();
                    if (jsonListOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    JsonSerializable jsonSerializableOptMap = jsonValue9.optMap();
                    if (jsonSerializableOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) jsonSerializableOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field 'behaviors" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue10 = jsonValue9.getJsonValue();
                    if (jsonValue10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) jsonValue10;
                }
            }
            List<ButtonClickBehaviorType> listFromList = jsonListOptList != null ? ButtonClickBehaviorType.INSTANCE.fromList(jsonListOptList) : null;
            JsonValue jsonValue11 = json.get("reporting_metadata");
            if (jsonValue11 == null) {
                jsonValue2 = null;
            } else {
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(JsonValue.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString7 = jsonValue11.optString();
                    if (objOptString7 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) objOptString7;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString8 = jsonValue11.optString();
                    if (objOptString8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) objOptString8;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonValue = (JsonValue) Boolean.valueOf(jsonValue11.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonValue = (JsonValue) Long.valueOf(jsonValue11.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue11.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonValue = (JsonValue) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonValue = (JsonValue) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonValue = (JsonValue) Integer.valueOf(jsonValue11.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue11.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList2 = jsonValue11.optList();
                    if (jsonSerializableOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) jsonSerializableOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    JsonSerializable jsonSerializableOptMap2 = jsonValue11.optMap();
                    if (jsonSerializableOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                    jsonValue = (JsonValue) jsonSerializableOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue = jsonValue11.getJsonValue();
                    if (jsonValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
                    }
                }
                jsonValue2 = jsonValue;
            }
            return new AutomatedAction(str, iIntValue, map, listFromList, jsonValue2);
        }

        @NotNull
        public final List<AutomatedAction> fromList(@NotNull JsonList json) {
            Intrinsics.checkNotNullParameter(json, "json");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(json, 10));
            for (JsonValue jsonValue : json) {
                Companion companion = AutomatedAction.INSTANCE;
                JsonMap jsonMapOptMap = jsonValue.optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                arrayList.add(companion.from(jsonMapOptMap));
            }
            return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.urbanairship.android.layout.property.AutomatedAction$Companion$fromList$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((AutomatedAction) t).getDelay()), Integer.valueOf(((AutomatedAction) t2).getDelay()));
                }
            });
        }
    }
}
