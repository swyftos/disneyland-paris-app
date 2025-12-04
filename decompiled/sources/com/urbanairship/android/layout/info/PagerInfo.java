package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.DisableSwipeSelector;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.PagerGesture;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
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

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b#\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0012R\u001a\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0010X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010\u0012R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u0004\u0018\u000100X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/urbanairship/android/layout/info/PagerInfo;", "Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "Lcom/urbanairship/android/layout/info/PagerItemInfo;", "Lcom/urbanairship/android/layout/info/View;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Lcom/urbanairship/android/layout/property/Color;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "()Lcom/urbanairship/android/layout/property/Border;", "children", "", "getChildren", "()Ljava/util/List;", "commonViewOverrides", "Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "getCommonViewOverrides", "()Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "disableSwipeWhen", "Lcom/urbanairship/android/layout/property/DisableSwipeSelector;", "getDisableSwipeWhen", "enableBehaviors", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getEnableBehaviors", "eventHandlers", "Lcom/urbanairship/android/layout/property/EventHandler;", "getEventHandlers", "gestures", "Lcom/urbanairship/android/layout/property/PagerGesture;", "getGestures", "isSwipeDisabled", "", "()Z", "items", "getItems", "stateTriggers", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "getStateTriggers", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "visibility", "Lcom/urbanairship/android/layout/info/VisibilityInfo;", "getVisibility", "()Lcom/urbanairship/android/layout/info/VisibilityInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/PagerInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n44#2,15:945\n79#2,16:964\n1549#3:960\n1620#3,3:961\n1549#3:981\n1620#3,3:982\n1#4:980\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/PagerInfo\n*L\n701#1:945,15\n702#1:964,16\n701#1:960\n701#1:961,3\n705#1:981\n705#1:982,3\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerInfo extends ViewGroupInfo<PagerItemInfo> implements View {
    private final /* synthetic */ View $$delegate_0;
    private final List children;
    private final List disableSwipeWhen;
    private final List gestures;
    private final boolean isSwipeDisabled;
    private final List items;

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Color getBackgroundColor() {
        return this.$$delegate_0.getBackgroundColor();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public Border getBorder() {
        return this.$$delegate_0.getBorder();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public CommonViewOverrides getCommonViewOverrides() {
        return this.$$delegate_0.getCommonViewOverrides();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EnableBehaviorType> getEnableBehaviors() {
        return this.$$delegate_0.getEnableBehaviors();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<EventHandler> getEventHandlers() {
        return this.$$delegate_0.getEventHandlers();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public List<ThomasStateTrigger> getStateTriggers() {
        return this.$$delegate_0.getStateTriggers();
    }

    @Override // com.urbanairship.android.layout.info.View
    @NotNull
    public ViewType getType() {
        return this.$$delegate_0.getType();
    }

    @Override // com.urbanairship.android.layout.info.View
    @Nullable
    public VisibilityInfo getVisibility() {
        return this.$$delegate_0.getVisibility();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerInfo(@NotNull JsonMap json) throws JsonException {
        JsonList jsonListOptList;
        Boolean boolValueOf;
        ArrayList arrayList;
        super(null);
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.view(json);
        JsonValue jsonValue = json.get("items");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'items" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonList.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonListOptList = (JsonList) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonListOptList = (JsonList) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonListOptList = (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonListOptList = (JsonList) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonListOptList = (JsonList) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonListOptList = (JsonList) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonListOptList = (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            jsonListOptList = jsonValue.optList();
            if (jsonListOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonSerializable jsonSerializableOptMap = jsonValue.optMap();
            if (jsonSerializableOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) jsonSerializableOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field 'items" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) jsonValue2;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
        Iterator<JsonValue> it = jsonListOptList.iterator();
        while (it.hasNext()) {
            JsonMap jsonMapRequireMap = it.next().requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            arrayList2.add(new PagerItemInfo(jsonMapRequireMap));
        }
        this.items = arrayList2;
        JsonValue jsonValue3 = json.get("disable_swipe");
        if (jsonValue3 == null) {
            boolValueOf = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                boolValueOf = (Boolean) jsonValue3.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                boolValueOf = Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                boolValueOf = (Boolean) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                boolValueOf = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                boolValueOf = (Boolean) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                boolValueOf = (Boolean) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                boolValueOf = (Boolean) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                boolValueOf = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                boolValueOf = (Boolean) jsonValue3.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                boolValueOf = (Boolean) jsonValue3.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'disable_swipe" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                boolValueOf = (Boolean) jsonValue3.getJsonValue();
            }
        }
        this.isSwipeDisabled = boolValueOf != null ? boolValueOf.booleanValue() : false;
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "gestures");
        this.gestures = jsonListOptionalList != null ? PagerGesture.INSTANCE.fromList(jsonListOptionalList) : null;
        JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(json, "disable_swipe_when");
        if (jsonListOptionalList2 != null) {
            DisableSwipeSelector.Companion companion = DisableSwipeSelector.INSTANCE;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList2, 10));
            Iterator<JsonValue> it2 = jsonListOptionalList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(companion.fromJson(it2.next()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        this.disableSwipeWhen = arrayList;
        this.children = this.items;
    }

    @NotNull
    public final List<PagerItemInfo> getItems() {
        return this.items;
    }

    /* renamed from: isSwipeDisabled, reason: from getter */
    public final boolean getIsSwipeDisabled() {
        return this.isSwipeDisabled;
    }

    @Nullable
    public final List<PagerGesture> getGestures() {
        return this.gestures;
    }

    @Nullable
    public final List<DisableSwipeSelector> getDisableSwipeWhen() {
        return this.disableSwipeWhen;
    }

    @Override // com.urbanairship.android.layout.info.ViewGroupInfo
    @NotNull
    public List<PagerItemInfo> getChildren() {
        return this.children;
    }
}
