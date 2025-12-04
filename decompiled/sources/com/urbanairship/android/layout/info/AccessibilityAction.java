package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.android.layout.info.AccessibilityActionType;
import com.urbanairship.android.layout.property.ButtonClickBehaviorType;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/urbanairship/android/layout/info/AccessibilityAction;", "Lcom/urbanairship/android/layout/info/Accessible;", "Lcom/urbanairship/android/layout/info/Identifiable;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "accessibilityHidden", "", "getAccessibilityHidden", "()Ljava/lang/Boolean;", "actions", "", "", "Lcom/urbanairship/json/JsonValue;", "getActions", "()Ljava/util/Map;", "behaviors", "", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "getBehaviors", "()Ljava/util/List;", "contentDescription", "getContentDescription", "()Ljava/lang/String;", "identifier", "getIdentifier", "localizedContentDescription", "Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "getLocalizedContentDescription", "()Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "reportingMetadata", "getReportingMetadata", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/layout/info/AccessibilityActionType;", "getType", "()Lcom/urbanairship/android/layout/info/AccessibilityActionType;", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/AccessibilityAction\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n79#2,16:945\n79#2,16:961\n1#3:977\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/AccessibilityAction\n*L\n768#1:945,16\n769#1:961,16\n*E\n"})
/* loaded from: classes5.dex */
public final class AccessibilityAction implements Accessible, Identifiable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final /* synthetic */ Accessible $$delegate_0;
    private final Map actions;
    private final List behaviors;
    private final String identifier;
    private final JsonMap reportingMetadata;
    private final AccessibilityActionType type;

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public Boolean getAccessibilityHidden() {
        return this.$$delegate_0.getAccessibilityHidden();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public String getContentDescription() {
        return this.$$delegate_0.getContentDescription();
    }

    @Override // com.urbanairship.android.layout.info.Accessible
    @Nullable
    public LocalizedContentDescription getLocalizedContentDescription() {
        return this.$$delegate_0.getLocalizedContentDescription();
    }

    public AccessibilityAction(@NotNull JsonMap json) throws JsonException {
        String strOptString;
        JsonMap jsonMapOptMap;
        String fallback;
        Intrinsics.checkNotNullParameter(json, "json");
        this.$$delegate_0 = ViewInfoKt.accessible(json);
        AccessibilityActionType.Companion companion = AccessibilityActionType.INSTANCE;
        JsonValue jsonValue = json.get("type");
        if (jsonValue == null) {
            strOptString = null;
        } else {
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
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
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
        }
        this.type = companion.from(strOptString);
        JsonValue jsonValue3 = json.get("reporting_metadata");
        if (jsonValue3 == null) {
            jsonMapOptMap = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                jsonMapOptMap = (JsonMap) jsonValue3.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonMapOptMap = (JsonMap) jsonValue3.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap = jsonValue3.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'reporting_metadata" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonMapOptMap = (JsonMap) jsonValue3.getJsonValue();
            }
        }
        this.reportingMetadata = jsonMapOptMap;
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "actions");
        this.actions = jsonListOptionalList != null ? INSTANCE.parseActionsList(jsonListOptionalList) : null;
        JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(json, "behaviors");
        this.behaviors = jsonListOptionalList2 != null ? ButtonClickBehaviorType.INSTANCE.fromList(jsonListOptionalList2) : null;
        LocalizedContentDescription localizedContentDescription = getLocalizedContentDescription();
        if (localizedContentDescription == null || (fallback = localizedContentDescription.getFallback()) == null) {
            throw new JsonException("Missing 'fallback' in 'localized_content_description'");
        }
        this.identifier = fallback;
    }

    @Nullable
    public final AccessibilityActionType getType() {
        return this.type;
    }

    @Nullable
    public final JsonMap getReportingMetadata() {
        return this.reportingMetadata;
    }

    @Nullable
    public final Map<String, JsonValue> getActions() {
        return this.actions;
    }

    @Nullable
    public final List<ButtonClickBehaviorType> getBehaviors() {
        return this.behaviors;
    }

    @Override // com.urbanairship.android.layout.info.Identifiable
    @NotNull
    public String getIdentifier() {
        return this.identifier;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\nJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u000f\u001a\u00020\nH\u0002¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/info/AccessibilityAction$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/info/AccessibilityAction;", "json", "Lcom/urbanairship/json/JsonMap;", "fromList", "", "jsonList", "Lcom/urbanairship/json/JsonList;", "parseActionsList", "", "", "Lcom/urbanairship/json/JsonValue;", "actionsList", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/AccessibilityAction$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n1603#2,9:945\n1855#2:954\n1856#2:956\n1612#2:957\n1#3:955\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/AccessibilityAction$Companion\n*L\n795#1:945,9\n795#1:954\n795#1:956\n795#1:957\n795#1:955\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final AccessibilityAction from(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                return new AccessibilityAction(json);
            } catch (JsonException unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map parseActionsList(JsonList actionsList) throws JsonException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<JsonValue> it = actionsList.iterator();
            while (it.hasNext()) {
                JsonMap jsonMapRequireMap = it.next().requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                Map<String, JsonValue> map = jsonMapRequireMap.getMap();
                Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
                for (Map.Entry<String, JsonValue> entry : map.entrySet()) {
                    String key = entry.getKey();
                    JsonValue value = entry.getValue();
                    Intrinsics.checkNotNull(key);
                    Intrinsics.checkNotNull(value);
                    linkedHashMap.put(key, value);
                }
            }
            return linkedHashMap;
        }

        @NotNull
        public final List<AccessibilityAction> fromList(@NotNull JsonList jsonList) throws JsonException {
            Intrinsics.checkNotNullParameter(jsonList, "jsonList");
            ArrayList arrayList = new ArrayList();
            for (JsonValue jsonValue : jsonList) {
                Companion companion = AccessibilityAction.INSTANCE;
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                AccessibilityAction accessibilityActionFrom = companion.from(jsonMapRequireMap);
                if (accessibilityActionFrom != null) {
                    arrayList.add(accessibilityActionFrom);
                }
            }
            return arrayList;
        }
    }
}
