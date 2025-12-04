package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/property/PageBranching;", "Lcom/urbanairship/json/JsonSerializable;", "nextPageSelectors", "", "Lcom/urbanairship/android/layout/property/PageBranching$PageSelector;", "(Ljava/util/List;)V", "getNextPageSelectors", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "PageSelector", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PageBranching implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List nextPageSelectors;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageBranching copy$default(PageBranching pageBranching, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pageBranching.nextPageSelectors;
        }
        return pageBranching.copy(list);
    }

    @Nullable
    public final List<PageSelector> component1() {
        return this.nextPageSelectors;
    }

    @NotNull
    public final PageBranching copy(@Nullable List<PageSelector> nextPageSelectors) {
        return new PageBranching(nextPageSelectors);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PageBranching) && Intrinsics.areEqual(this.nextPageSelectors, ((PageBranching) other).nextPageSelectors);
    }

    public int hashCode() {
        List list = this.nextPageSelectors;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "PageBranching(nextPageSelectors=" + this.nextPageSelectors + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PageBranching(@Nullable List<PageSelector> list) {
        this.nextPageSelectors = list;
    }

    @Nullable
    public final List<PageSelector> getNextPageSelectors() {
        return this.nextPageSelectors;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/PageBranching$Companion;", "", "()V", "NEXT_PAGE", "", "SELECTORS", "from", "Lcom/urbanairship/android/layout/property/PageBranching;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPagerControllerBranching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PageBranching$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1549#2:148\n1620#2,3:149\n*S KotlinDebug\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PageBranching$Companion\n*L\n106#1:148\n106#1:149,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PageBranching from(@NotNull JsonValue json) throws JsonException {
            ArrayList arrayList;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapRequireMap = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(jsonMapRequireMap, "next_page");
            if (jsonMapOptionalMap == null || (jsonListRequireList = JsonExtensionsKt.requireList(jsonMapOptionalMap, "selectors")) == null) {
                arrayList = null;
            } else {
                PageSelector.Companion companion = PageSelector.INSTANCE;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    arrayList.add(companion.from(it.next()));
                }
            }
            return new PageBranching(arrayList);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("next_page", JsonExtensionsKt.jsonMapOf(TuplesKt.to("selectors", this.nextPageSelectors)))).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/layout/property/PageBranching$PageSelector;", "Lcom/urbanairship/json/JsonSerializable;", "predicate", "Lcom/urbanairship/json/JsonPredicate;", "pageId", "", "(Lcom/urbanairship/json/JsonPredicate;Ljava/lang/String;)V", "getPageId", "()Ljava/lang/String;", "getPredicate", "()Lcom/urbanairship/json/JsonPredicate;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class PageSelector implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String pageId;
        private final JsonPredicate predicate;

        public static /* synthetic */ PageSelector copy$default(PageSelector pageSelector, JsonPredicate jsonPredicate, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonPredicate = pageSelector.predicate;
            }
            if ((i & 2) != 0) {
                str = pageSelector.pageId;
            }
            return pageSelector.copy(jsonPredicate, str);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final JsonPredicate getPredicate() {
            return this.predicate;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getPageId() {
            return this.pageId;
        }

        @NotNull
        public final PageSelector copy(@Nullable JsonPredicate predicate, @NotNull String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            return new PageSelector(predicate, pageId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageSelector)) {
                return false;
            }
            PageSelector pageSelector = (PageSelector) other;
            return Intrinsics.areEqual(this.predicate, pageSelector.predicate) && Intrinsics.areEqual(this.pageId, pageSelector.pageId);
        }

        public int hashCode() {
            JsonPredicate jsonPredicate = this.predicate;
            return ((jsonPredicate == null ? 0 : jsonPredicate.hashCode()) * 31) + this.pageId.hashCode();
        }

        @NotNull
        public String toString() {
            return "PageSelector(predicate=" + this.predicate + ", pageId=" + this.pageId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public PageSelector(@Nullable JsonPredicate jsonPredicate, @NotNull String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            this.predicate = jsonPredicate;
            this.pageId = pageId;
        }

        @Nullable
        public final JsonPredicate getPredicate() {
            return this.predicate;
        }

        @NotNull
        public final String getPageId() {
            return this.pageId;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/PageBranching$PageSelector$Companion;", "", "()V", "PAGE_ID", "", "WHEN_STATE_MATCHES", "from", "Lcom/urbanairship/android/layout/property/PageBranching$PageSelector;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPagerControllerBranching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PageBranching$PageSelector$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,147:1\n1#2:148\n44#3,15:149\n*S KotlinDebug\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PageBranching$PageSelector$Companion\n*L\n136#1:149,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final PageSelector from(@NotNull JsonValue json) throws JsonException {
                String strOptString;
                Intrinsics.checkNotNullParameter(json, "json");
                JsonMap jsonMapRequireMap = json.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("when_state_matches");
                JsonPredicate jsonPredicate = jsonValue != null ? JsonPredicate.parse(jsonValue) : null;
                JsonValue jsonValue2 = jsonMapRequireMap.get("page_id");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'page_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'page_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.toJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue3;
                }
                return new PageSelector(jsonPredicate, strOptString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("when_state_matches", this.predicate), TuplesKt.to("page_id", this.pageId)).toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
