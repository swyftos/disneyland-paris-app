package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B+\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "", "actions", "", "", "Lcom/urbanairship/json/JsonValue;", "behaviors", "", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "(Ljava/util/Map;Ljava/util/List;)V", "getActions", "()Ljava/util/Map;", "getBehaviors", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PagerGestureBehavior {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Map actions;
    private final List behaviors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagerGestureBehavior copy$default(PagerGestureBehavior pagerGestureBehavior, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            map = pagerGestureBehavior.actions;
        }
        if ((i & 2) != 0) {
            list = pagerGestureBehavior.behaviors;
        }
        return pagerGestureBehavior.copy(map, list);
    }

    @Nullable
    public final Map<String, JsonValue> component1() {
        return this.actions;
    }

    @Nullable
    public final List<ButtonClickBehaviorType> component2() {
        return this.behaviors;
    }

    @NotNull
    public final PagerGestureBehavior copy(@Nullable Map<String, ? extends JsonValue> actions, @Nullable List<? extends ButtonClickBehaviorType> behaviors) {
        return new PagerGestureBehavior(actions, behaviors);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerGestureBehavior)) {
            return false;
        }
        PagerGestureBehavior pagerGestureBehavior = (PagerGestureBehavior) other;
        return Intrinsics.areEqual(this.actions, pagerGestureBehavior.actions) && Intrinsics.areEqual(this.behaviors, pagerGestureBehavior.behaviors);
    }

    public int hashCode() {
        Map map = this.actions;
        int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
        List list = this.behaviors;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PagerGestureBehavior(actions=" + this.actions + ", behaviors=" + this.behaviors + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerGestureBehavior$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/PagerGestureBehavior;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPagerGestures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGestureBehavior$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,163:1\n79#2,16:164\n79#2,16:180\n*S KotlinDebug\n*F\n+ 1 PagerGestures.kt\ncom/urbanairship/android/layout/property/PagerGestureBehavior$Companion\n*L\n86#1:164,16\n87#1:180,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PagerGestureBehavior from(@NotNull JsonMap json) throws JsonException {
            JsonMap jsonMapOptMap;
            JsonList jsonListOptList;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonValue jsonValue = json.get("actions");
            if (jsonValue == null) {
                jsonMapOptMap = null;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString = jsonValue.optString();
                    if (objOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString2 = jsonValue.optString();
                    if (objOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) objOptString2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList = jsonValue.optList();
                    if (jsonSerializableOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap = jsonValue.optMap();
                    if (jsonMapOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap = (JsonMap) jsonValue2;
                }
            }
            Map<String, JsonValue> map = jsonMapOptMap != null ? jsonMapOptMap.getMap() : null;
            JsonValue jsonValue3 = json.get("behaviors");
            if (jsonValue3 == null) {
                jsonListOptList = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonList.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue3.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue3.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) objOptString4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonListOptList = (JsonList) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonListOptList = (JsonList) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonListOptList = (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonListOptList = (JsonList) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonListOptList = (JsonList) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonListOptList = (JsonList) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonListOptList = (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonListOptList = jsonValue3.optList();
                    if (jsonListOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    JsonSerializable jsonSerializableOptMap = jsonValue3.optMap();
                    if (jsonSerializableOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) jsonSerializableOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field 'behaviors" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
                    if (jsonValue4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                    }
                    jsonListOptList = (JsonList) jsonValue4;
                }
            }
            return new PagerGestureBehavior(map, jsonListOptList != null ? ButtonClickBehaviorType.INSTANCE.fromList(jsonListOptList) : null);
        }

        private Companion() {
        }
    }

    public PagerGestureBehavior(@Nullable Map<String, ? extends JsonValue> map, @Nullable List<? extends ButtonClickBehaviorType> list) {
        this.actions = map;
        this.behaviors = list;
    }

    @Nullable
    public final Map<String, JsonValue> getActions() {
        return this.actions;
    }

    @Nullable
    public final List<ButtonClickBehaviorType> getBehaviors() {
        return this.behaviors;
    }
}
