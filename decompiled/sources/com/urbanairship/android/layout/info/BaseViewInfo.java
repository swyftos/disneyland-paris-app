package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/urbanairship/android/layout/info/BaseViewInfo;", "Lcom/urbanairship/android/layout/info/View;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "enableBehaviors", "", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "()Ljava/util/List;", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/BaseViewInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n44#2,15:945\n1549#3:960\n1620#3,3:961\n1549#3:964\n1620#3,3:965\n1549#3:968\n1620#3,3:969\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/BaseViewInfo\n*L\n196#1:945,15\n210#1:960\n210#1:961,3\n214#1:964\n214#1:965,3\n222#1:968\n222#1:969,3\n*E\n"})
/* loaded from: classes5.dex */
public final class BaseViewInfo implements View {
    private final Color backgroundColor;
    private final Border border;
    private final CommonViewOverrides commonViewOverrides;
    private final List enableBehaviors;
    private final List eventHandlers;
    private final List stateTriggers;
    private final ViewType type;
    private final VisibilityInfo visibility;

    public BaseViewInfo(@NotNull JsonMap json) throws JsonException {
        String strOptString;
        ArrayList arrayList;
        ArrayList arrayList2;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue = json.get("type");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue2;
        }
        ViewType viewTypeFrom = ViewType.from(strOptString);
        Intrinsics.checkNotNullExpressionValue(viewTypeFrom, "from(...)");
        this.type = viewTypeFrom;
        JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, "background_color");
        ArrayList arrayList3 = null;
        this.backgroundColor = jsonMapOptionalMap != null ? Color.fromJson(jsonMapOptionalMap) : null;
        JsonMap jsonMapOptionalMap2 = JsonExtensionsKt.optionalMap(json, "border");
        this.border = jsonMapOptionalMap2 != null ? Border.INSTANCE.fromJson(jsonMapOptionalMap2) : null;
        JsonMap jsonMapOptionalMap3 = JsonExtensionsKt.optionalMap(json, "visibility");
        this.visibility = jsonMapOptionalMap3 != null ? new VisibilityInfo(jsonMapOptionalMap3) : null;
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "event_handlers");
        if (jsonListOptionalList != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
            Iterator<JsonValue> it = jsonListOptionalList.iterator();
            while (it.hasNext()) {
                JsonMap jsonMapRequireMap = it.next().requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                arrayList.add(new EventHandler(jsonMapRequireMap));
            }
        } else {
            arrayList = null;
        }
        this.eventHandlers = arrayList;
        JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(json, "enabled");
        if (jsonListOptionalList2 != null) {
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList2, 10));
            for (JsonValue jsonValue3 : jsonListOptionalList2) {
                EnableBehaviorType.Companion companion = EnableBehaviorType.INSTANCE;
                String strRequireString = jsonValue3.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                arrayList2.add(companion.from(strRequireString));
            }
        } else {
            arrayList2 = null;
        }
        this.enableBehaviors = arrayList2;
        JsonMap jsonMapOptionalMap4 = JsonExtensionsKt.optionalMap(json, "view_overrides");
        this.commonViewOverrides = jsonMapOptionalMap4 != null ? new CommonViewOverrides(jsonMapOptionalMap4) : null;
        JsonList jsonListOptionalList3 = JsonExtensionsKt.optionalList(json, "state_triggers");
        if (jsonListOptionalList3 != null) {
            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList3, 10));
            for (JsonValue jsonValue4 : jsonListOptionalList3) {
                ThomasStateTrigger.Companion companion2 = ThomasStateTrigger.INSTANCE;
                JsonMap jsonMapRequireMap2 = jsonValue4.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                arrayList3.add(companion2.fromJson(jsonMapRequireMap2));
            }
        }
        this.stateTriggers = arrayList3;
    }

    @Override // com.urbanairship.android.layout.info.View
    @NotNull
    public ViewType getType() {
        return this.type;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Border getBorder() {
        return this.border;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.visibility;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EventHandler> getEventHandlers() {
        return this.eventHandlers;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EnableBehaviorType> getEnableBehaviors() {
        return this.enableBehaviors;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public CommonViewOverrides getCommonViewOverrides() {
        return this.commonViewOverrides;
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<ThomasStateTrigger> getStateTriggers() {
        return this.stateTriggers;
    }
}
