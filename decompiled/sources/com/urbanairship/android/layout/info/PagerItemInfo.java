package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.property.AutomatedAction;
import com.urbanairship.android.layout.property.PageBranching;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/info/PagerItemInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo;", "Lcom/urbanairship/android/layout/info/Identifiable;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", ViewProps.ACCESSIBILITY_ACTIONS, "", "Lcom/urbanairship/android/layout/info/AccessibilityAction;", "getAccessibilityActions", "()Ljava/util/List;", "automatedActions", "Lcom/urbanairship/android/layout/property/AutomatedAction;", "getAutomatedActions", "branching", "Lcom/urbanairship/android/layout/property/PageBranching;", "getBranching", "()Lcom/urbanairship/android/layout/property/PageBranching;", "displayActions", "", "", "Lcom/urbanairship/json/JsonValue;", "getDisplayActions", "()Ljava/util/Map;", "identifier", "getIdentifier", "()Ljava/lang/String;", "stateActions", "Lcom/urbanairship/android/layout/property/StateAction;", "getStateActions", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/PagerItemInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n44#2,15:945\n1#3:960\n1549#4:961\n1620#4,3:962\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/PagerItemInfo\n*L\n812#1:945,15\n819#1:961\n819#1:962,3\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerItemInfo extends ItemInfo implements Identifiable {
    private final /* synthetic */ Identifiable $$delegate_0;
    private final List accessibilityActions;
    private final List automatedActions;
    private final PageBranching branching;
    private final Map displayActions;
    private final List stateActions;

    @Override // com.urbanairship.android.layout.info.Identifiable
    @NotNull
    public String getIdentifier() {
        return this.$$delegate_0.getIdentifier();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PagerItemInfo(@NotNull JsonMap json) throws JsonException {
        JsonMap jsonMapOptMap;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(json, "json");
        ViewInfo.Companion companion = ViewInfo.INSTANCE;
        JsonValue jsonValue = json.get("view");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'view" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
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
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
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
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'view" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonValue2;
        }
        super(companion.viewInfoFromJson(jsonMapOptMap), null);
        this.$$delegate_0 = ViewInfoKt.identifiable(json);
        JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, "display_actions");
        this.displayActions = jsonMapOptionalMap != null ? jsonMapOptionalMap.getMap() : null;
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "automated_actions");
        this.automatedActions = jsonListOptionalList != null ? AutomatedAction.INSTANCE.fromList(jsonListOptionalList) : null;
        JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(json, "accessibility_actions");
        this.accessibilityActions = jsonListOptionalList2 != null ? AccessibilityAction.INSTANCE.fromList(jsonListOptionalList2) : null;
        JsonList jsonListOptionalList3 = JsonExtensionsKt.optionalList(json, "state_actions");
        if (jsonListOptionalList3 != null) {
            StateAction.Companion companion2 = StateAction.INSTANCE;
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList3, 10));
            Iterator<JsonValue> it = jsonListOptionalList3.iterator();
            while (it.hasNext()) {
                arrayList.add(companion2.fromJson(it.next()));
            }
        } else {
            arrayList = null;
        }
        this.stateActions = arrayList;
        JsonValue jsonValue3 = json.get("branching");
        this.branching = jsonValue3 != null ? PageBranching.INSTANCE.from(jsonValue3) : null;
    }

    @Nullable
    public final Map<String, JsonValue> getDisplayActions() {
        return this.displayActions;
    }

    @Nullable
    public final List<AutomatedAction> getAutomatedActions() {
        return this.automatedActions;
    }

    @Nullable
    public final List<AccessibilityAction> getAccessibilityActions() {
        return this.accessibilityActions;
    }

    @Nullable
    public final List<StateAction> getStateActions() {
        return this.stateActions;
    }

    @Nullable
    public final PageBranching getBranching() {
        return this.branching;
    }
}
