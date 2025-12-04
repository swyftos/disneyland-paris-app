package com.urbanairship.android.layout.info;

import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001f\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/info/CommonViewOverrides;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", ViewProps.BACKGROUND_COLOR, "", "Lcom/urbanairship/android/layout/info/ViewPropertyOverride;", "Lcom/urbanairship/android/layout/property/Color;", "getBackgroundColor", "()Ljava/util/List;", "border", "Lcom/urbanairship/android/layout/property/Border;", "getBorder", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/CommonViewOverrides\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n1549#2:945\n1620#2,3:946\n1549#2:949\n1620#2,3:950\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/CommonViewOverrides\n*L\n186#1:945\n186#1:946,3\n190#1:949\n190#1:950,3\n*E\n"})
/* loaded from: classes5.dex */
public final class CommonViewOverrides {
    private final List backgroundColor;
    private final List border;

    public CommonViewOverrides(@NotNull JsonMap json) throws JsonException {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "background_color");
        ArrayList arrayList2 = null;
        if (jsonListOptionalList != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
            for (JsonValue jsonValue : jsonListOptionalList) {
                Intrinsics.checkNotNull(jsonValue);
                arrayList.add(new ViewPropertyOverride(jsonValue, new Function1() { // from class: com.urbanairship.android.layout.info.CommonViewOverrides$backgroundColor$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Color invoke(JsonValue json2) {
                        Intrinsics.checkNotNullParameter(json2, "json");
                        return Color.fromJson(json2.requireMap());
                    }
                }));
            }
        } else {
            arrayList = null;
        }
        this.backgroundColor = arrayList;
        JsonList jsonListOptionalList2 = JsonExtensionsKt.optionalList(json, "border");
        if (jsonListOptionalList2 != null) {
            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList2, 10));
            for (JsonValue jsonValue2 : jsonListOptionalList2) {
                Intrinsics.checkNotNull(jsonValue2);
                arrayList2.add(new ViewPropertyOverride(jsonValue2, new Function1() { // from class: com.urbanairship.android.layout.info.CommonViewOverrides$border$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Border invoke(JsonValue json2) throws JsonException {
                        Intrinsics.checkNotNullParameter(json2, "json");
                        Border.Companion companion = Border.INSTANCE;
                        JsonMap jsonMapRequireMap = json2.requireMap();
                        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                        return companion.fromJson(jsonMapRequireMap);
                    }
                }));
            }
        }
        this.border = arrayList2;
    }

    @Nullable
    public final List<ViewPropertyOverride<Color>> getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final List<ViewPropertyOverride<Border>> getBorder() {
        return this.border;
    }
}
