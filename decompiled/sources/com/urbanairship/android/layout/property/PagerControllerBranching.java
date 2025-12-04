package com.urbanairship.android.layout.property;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.StateAction;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "Lcom/urbanairship/json/JsonSerializable;", "completions", "", "Lcom/urbanairship/android/layout/property/PagerControllerBranching$Completion;", "(Ljava/util/List;)V", "getCompletions", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "Completion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PagerControllerBranching implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List completions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagerControllerBranching copy$default(PagerControllerBranching pagerControllerBranching, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pagerControllerBranching.completions;
        }
        return pagerControllerBranching.copy(list);
    }

    @NotNull
    public final List<Completion> component1() {
        return this.completions;
    }

    @NotNull
    public final PagerControllerBranching copy(@NotNull List<Completion> completions) {
        Intrinsics.checkNotNullParameter(completions, "completions");
        return new PagerControllerBranching(completions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PagerControllerBranching) && Intrinsics.areEqual(this.completions, ((PagerControllerBranching) other).completions);
    }

    public int hashCode() {
        return this.completions.hashCode();
    }

    @NotNull
    public String toString() {
        return "PagerControllerBranching(completions=" + this.completions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PagerControllerBranching(@NotNull List<Completion> completions) {
        Intrinsics.checkNotNullParameter(completions, "completions");
        this.completions = completions;
    }

    @NotNull
    public final List<Completion> getCompletions() {
        return this.completions;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerControllerBranching$Companion;", "", "()V", "PAGER_COMPLETIONS", "", "from", "Lcom/urbanairship/android/layout/property/PagerControllerBranching;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPagerControllerBranching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PagerControllerBranching$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1549#2:148\n1620#2,3:149\n*S KotlinDebug\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PagerControllerBranching$Companion\n*L\n35#1:148\n35#1:149,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PagerControllerBranching from(@NotNull JsonValue json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            JsonMap jsonMapRequireMap = json.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonList jsonListRequireList = JsonExtensionsKt.requireList(jsonMapRequireMap, "pager_completions");
            Completion.Companion companion = Completion.INSTANCE;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
            Iterator<JsonValue> it = jsonListRequireList.iterator();
            while (it.hasNext()) {
                arrayList.add(companion.from(it.next()));
            }
            return new PagerControllerBranching(arrayList);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pager_completions", this.completions)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerControllerBranching$Completion;", "Lcom/urbanairship/json/JsonSerializable;", "predicate", "Lcom/urbanairship/json/JsonPredicate;", "stateActions", "", "Lcom/urbanairship/android/layout/property/StateAction;", "(Lcom/urbanairship/json/JsonPredicate;Ljava/util/List;)V", "getPredicate", "()Lcom/urbanairship/json/JsonPredicate;", "getStateActions", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Completion implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonPredicate predicate;
        private final List stateActions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Completion copy$default(Completion completion, JsonPredicate jsonPredicate, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                jsonPredicate = completion.predicate;
            }
            if ((i & 2) != 0) {
                list = completion.stateActions;
            }
            return completion.copy(jsonPredicate, list);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final JsonPredicate getPredicate() {
            return this.predicate;
        }

        @Nullable
        public final List<StateAction> component2() {
            return this.stateActions;
        }

        @NotNull
        public final Completion copy(@Nullable JsonPredicate predicate, @Nullable List<? extends StateAction> stateActions) {
            return new Completion(predicate, stateActions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Completion)) {
                return false;
            }
            Completion completion = (Completion) other;
            return Intrinsics.areEqual(this.predicate, completion.predicate) && Intrinsics.areEqual(this.stateActions, completion.stateActions);
        }

        public int hashCode() {
            JsonPredicate jsonPredicate = this.predicate;
            int iHashCode = (jsonPredicate == null ? 0 : jsonPredicate.hashCode()) * 31;
            List list = this.stateActions;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Completion(predicate=" + this.predicate + ", stateActions=" + this.stateActions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Completion(@Nullable JsonPredicate jsonPredicate, @Nullable List<? extends StateAction> list) {
            this.predicate = jsonPredicate;
            this.stateActions = list;
        }

        @Nullable
        public final JsonPredicate getPredicate() {
            return this.predicate;
        }

        @Nullable
        public final List<StateAction> getStateActions() {
            return this.stateActions;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/PagerControllerBranching$Completion$Companion;", "", "()V", "STATE_ACTIONS", "", "WHEN_STATE_MATCHES", "from", "Lcom/urbanairship/android/layout/property/PagerControllerBranching$Completion;", "json", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPagerControllerBranching.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PagerControllerBranching$Completion$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1#2:148\n1549#3:149\n1620#3,3:150\n*S KotlinDebug\n*F\n+ 1 PagerControllerBranching.kt\ncom/urbanairship/android/layout/property/PagerControllerBranching$Completion$Companion\n*L\n69#1:149\n69#1:150,3\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Completion from(@NotNull JsonValue json) throws JsonException {
                Intrinsics.checkNotNullParameter(json, "json");
                JsonMap jsonMapRequireMap = json.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue = jsonMapRequireMap.get("when_state_matches");
                ArrayList arrayList = null;
                JsonPredicate jsonPredicate = jsonValue != null ? JsonPredicate.parse(jsonValue) : null;
                JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(jsonMapRequireMap, "state_actions");
                if (jsonListOptionalList != null) {
                    StateAction.Companion companion = StateAction.INSTANCE;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
                    Iterator<JsonValue> it = jsonListOptionalList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(companion.fromJson(it.next()));
                    }
                    arrayList = arrayList2;
                }
                return new Completion(jsonPredicate, arrayList);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("when_state_matches", this.predicate), TuplesKt.to("state_actions", this.stateActions)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
