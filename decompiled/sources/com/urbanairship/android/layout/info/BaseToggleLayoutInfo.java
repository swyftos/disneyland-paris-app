package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.info.ItemInfo;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001<B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0019\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u001a\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u0018R\u0012\u0010#\u001a\u00020$X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u001a\u0010-\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u0010\u0018R\u0012\u00100\u001a\u000201X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0004\u0018\u000109X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo;", "Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo$ViewItemInfo;", "Lcom/urbanairship/android/layout/info/Identifiable;", "Lcom/urbanairship/android/layout/info/View;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "attributeValue", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "getAttributeValue", "()Lcom/urbanairship/json/JsonValue;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "children", "", "getChildren", "()Ljava/util/List;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "enableBehaviors", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "onToggleOff", "Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo$ToggleActions;", "getOnToggleOff", "()Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo$ToggleActions;", "onToggleOn", "getOnToggleOn", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "view", "Lcom/urbanairship/android/layout/info/ViewInfo;", "getView", "()Lcom/urbanairship/android/layout/info/ViewInfo;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "ToggleActions", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/BaseToggleLayoutInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n1549#2:945\n1620#2,3:946\n1549#2:949\n1620#2,3:950\n79#3,16:953\n44#3,15:969\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/BaseToggleLayoutInfo\n*L\n882#1:945\n882#1:946,3\n888#1:949\n888#1:950,3\n891#1:953,16\n892#1:969,15\n*E\n"})
/* loaded from: classes5.dex */
public class BaseToggleLayoutInfo extends ViewGroupInfo<ItemInfo.ViewItemInfo> implements Identifiable, View {
    private final /* synthetic */ Identifiable $$delegate_0;
    private final /* synthetic */ View $$delegate_1;
    private final JsonValue attributeValue;
    private final List children;
    private final ToggleActions onToggleOff;
    private final ToggleActions onToggleOn;
    private final ViewInfo view;

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Color getBackgroundColor() {
        return this.$$delegate_1.getBackgroundColor();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Border getBorder() {
        return this.$$delegate_1.getBorder();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public CommonViewOverrides getCommonViewOverrides() {
        return this.$$delegate_1.getCommonViewOverrides();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EnableBehaviorType> getEnableBehaviors() {
        return this.$$delegate_1.getEnableBehaviors();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EventHandler> getEventHandlers() {
        return this.$$delegate_1.getEventHandlers();
    }

    @Override // com.urbanairship.android.layout.info.Identifiable
    @NotNull
    public String getIdentifier() {
        return this.$$delegate_0.getIdentifier();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<ThomasStateTrigger> getStateTriggers() {
        return this.$$delegate_1.getStateTriggers();
    }

    @Override // com.urbanairship.android.layout.info.View
    @NotNull
    public ViewType getType() {
        return this.$$delegate_1.getType();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.$$delegate_1.getVisibility();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseToggleLayoutInfo(@NotNull JsonMap json) throws JsonException {
        ArrayList arrayList;
        ArrayList arrayList2;
        JsonValue jsonValue;
        JsonValue jsonValue2;
        JsonMap jsonMapOptMap;
        super(null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.identifiable(json);
        this.$$delegate_1 = ViewInfoKt.view(json);
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(JsonExtensionsKt.requireMap(json, "on_toggle_on"), "state_actions");
        if (jsonListOptionalList != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
            for (JsonValue jsonValue3 : jsonListOptionalList) {
                StateAction.Companion companion = StateAction.INSTANCE;
                JsonMap jsonMapRequireMap = jsonValue3.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                arrayList.add(companion.fromJson(jsonMapRequireMap));
            }
        } else {
            arrayList = null;
        }
        this.onToggleOn = new ToggleActions(arrayList);
        JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(JsonExtensionsKt.requireMap(json, "on_toggle_off"), "state_actions");
        if (jsonListOptionalList2 != null) {
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList2, 10));
            for (JsonValue jsonValue4 : jsonListOptionalList2) {
                StateAction.Companion companion2 = StateAction.INSTANCE;
                JsonMap jsonMapRequireMap2 = jsonValue4.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                arrayList2.add(companion2.fromJson(jsonMapRequireMap2));
            }
        } else {
            arrayList2 = null;
        }
        this.onToggleOff = new ToggleActions(arrayList2);
        JsonValue jsonValue5 = json.get("attribute_value");
        if (jsonValue5 == null) {
            jsonValue = null;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                jsonValue2 = (JsonValue) jsonValue5.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue2 = (JsonValue) Boolean.valueOf(jsonValue5.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue2 = (JsonValue) Long.valueOf(jsonValue5.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue2 = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue = (JsonValue) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue = (JsonValue) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jsonValue = (JsonValue) Integer.valueOf(jsonValue5.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonValue = (JsonValue) jsonValue5.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonValue = (JsonValue) jsonValue5.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'attribute_value" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue = jsonValue5.getJsonValue();
            }
            jsonValue = jsonValue2;
        }
        this.attributeValue = jsonValue;
        ViewInfo.Companion companion3 = ViewInfo.INSTANCE;
        JsonValue jsonValue6 = json.get("view");
        if (jsonValue6 == null) {
            throw new JsonException("Missing required field: 'view" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue6.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue6.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue6.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue6.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue6.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue6.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonMapOptMap = jsonValue6.optMap();
            if (jsonMapOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'view" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue7 = jsonValue6.getJsonValue();
            if (jsonValue7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonValue7;
        }
        ViewInfo viewInfoViewInfoFromJson = companion3.viewInfoFromJson(jsonMapOptMap);
        this.view = viewInfoViewInfoFromJson;
        this.children = CollectionsKt.listOf(new ItemInfo.ViewItemInfo(viewInfoViewInfoFromJson));
    }

    @NotNull
    public final ToggleActions getOnToggleOn() {
        return this.onToggleOn;
    }

    @NotNull
    public final ToggleActions getOnToggleOff() {
        return this.onToggleOff;
    }

    @Nullable
    public final JsonValue getAttributeValue() {
        return this.attributeValue;
    }

    @NotNull
    public final ViewInfo getView() {
        return this.view;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo$ToggleActions;", "", "stateActions", "", "Lcom/urbanairship/android/layout/property/StateAction;", "(Ljava/util/List;)V", "getStateActions", "()Ljava/util/List;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ToggleActions {
        private final List stateActions;

        public ToggleActions(@Nullable List<? extends StateAction> list) {
            this.stateActions = list;
        }

        @Nullable
        public final List<StateAction> getStateActions() {
            return this.stateActions;
        }
    }

    @Override // com.urbanairship.android.layout.info.ViewGroupInfo
    @NotNull
    public List<ItemInfo.ViewItemInfo> getChildren() {
        return this.children;
    }
}
