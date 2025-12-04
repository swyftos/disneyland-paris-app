package com.urbanairship.android.layout.property;

import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/MarkdownAppearance;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "links", "Lcom/urbanairship/android/layout/property/MarkdownAppearance$LinkAppearance;", "getLinks", "()Lcom/urbanairship/android/layout/property/MarkdownAppearance$LinkAppearance;", "LinkAppearance", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMarkdownOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MarkdownOptions.kt\ncom/urbanairship/android/layout/property/MarkdownAppearance\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
/* loaded from: classes5.dex */
public final class MarkdownAppearance {
    private final LinkAppearance links;

    public MarkdownAppearance(@NotNull JsonMap json) throws JsonException {
        Intrinsics.checkNotNullParameter(json, "json");
        JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, "anchor");
        this.links = jsonMapOptionalMap != null ? new LinkAppearance(jsonMapOptionalMap) : null;
    }

    @Nullable
    public final LinkAppearance getLinks() {
        return this.links;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/layout/property/MarkdownAppearance$LinkAppearance;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "color", "Lcom/urbanairship/android/layout/property/Color;", "getColor", "()Lcom/urbanairship/android/layout/property/Color;", "styles", "", "Lcom/urbanairship/android/layout/property/TextStyle;", "getStyles", "()Ljava/util/List;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMarkdownOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MarkdownOptions.kt\ncom/urbanairship/android/layout/property/MarkdownAppearance$LinkAppearance\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1603#2,9:70\n1855#2:79\n1856#2:81\n1612#2:82\n766#2:83\n857#2,2:84\n1#3:80\n*S KotlinDebug\n*F\n+ 1 MarkdownOptions.kt\ncom/urbanairship/android/layout/property/MarkdownAppearance$LinkAppearance\n*L\n28#1:70,9\n28#1:79\n28#1:81\n28#1:82\n37#1:83\n37#1:84,2\n28#1:80\n*E\n"})
    public static final class LinkAppearance {
        private final Color color;
        private final List styles;

        public LinkAppearance(@NotNull JsonMap json) throws JsonException {
            TextStyle textStyleFrom;
            Intrinsics.checkNotNullParameter(json, "json");
            this.color = Color.fromJsonField(json, "color");
            JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "styles");
            ArrayList arrayList = null;
            if (jsonListOptionalList != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<JsonValue> it = jsonListOptionalList.iterator();
                while (it.hasNext()) {
                    try {
                        textStyleFrom = TextStyle.from(it.next().optString());
                    } catch (JsonException e) {
                        UALog.w("Failed to parse anchor styles: " + e.getMessage(), new Object[0]);
                        textStyleFrom = null;
                    }
                    if (textStyleFrom != null) {
                        arrayList2.add(textStyleFrom);
                    }
                }
                arrayList = new ArrayList();
                for (Object obj : arrayList2) {
                    if (((TextStyle) obj) == TextStyle.UNDERLINE) {
                        arrayList.add(obj);
                    }
                }
            }
            this.styles = arrayList;
        }

        @Nullable
        public final Color getColor() {
            return this.color;
        }

        @Nullable
        public final List<TextStyle> getStyles() {
            return this.styles;
        }
    }
}
