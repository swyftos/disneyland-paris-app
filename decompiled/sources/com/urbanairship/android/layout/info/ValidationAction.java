package com.urbanairship.android.layout.info;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u001b\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/android/layout/info/ValidationAction;", "", "json", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/json/JsonValue;)V", "actions", "", "Lcom/urbanairship/android/layout/property/StateAction;", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ValidationAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,944:1\n1549#2:945\n1620#2,3:946\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ValidationAction\n*L\n264#1:945\n264#1:946,3\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class ValidationAction {
    private final List actions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValidationAction copy$default(ValidationAction validationAction, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = validationAction.actions;
        }
        return validationAction.copy(list);
    }

    @Nullable
    public final List<StateAction> component1() {
        return this.actions;
    }

    @NotNull
    public final ValidationAction copy(@Nullable List<? extends StateAction> actions) {
        return new ValidationAction(actions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ValidationAction) && Intrinsics.areEqual(this.actions, ((ValidationAction) other).actions);
    }

    public int hashCode() {
        List list = this.actions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ValidationAction(actions=" + this.actions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ValidationAction(@Nullable List<? extends StateAction> list) {
        this.actions = list;
    }

    @Nullable
    public final List<StateAction> getActions() {
        return this.actions;
    }

    public ValidationAction(@NotNull JsonValue json) throws JsonException {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonMap jsonMapRequireMap = json.requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(jsonMapRequireMap, "state_actions");
        if (jsonListOptionalList != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
            for (JsonValue jsonValue : jsonListOptionalList) {
                StateAction.Companion companion = StateAction.INSTANCE;
                JsonMap jsonMapRequireMap2 = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                arrayList.add(companion.fromJson(jsonMapRequireMap2));
            }
        } else {
            arrayList = null;
        }
        this(arrayList);
    }
}
