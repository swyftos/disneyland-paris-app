package com.urbanairship.android.layout.environment;

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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/environment/TriggerActions;", "", "stateActions", "", "Lcom/urbanairship/android/layout/property/StateAction;", "(Ljava/util/List;)V", "getStateActions", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TriggerActions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List stateActions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TriggerActions copy$default(TriggerActions triggerActions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = triggerActions.stateActions;
        }
        return triggerActions.copy(list);
    }

    @Nullable
    public final List<StateAction> component1() {
        return this.stateActions;
    }

    @NotNull
    public final TriggerActions copy(@Nullable List<? extends StateAction> stateActions) {
        return new TriggerActions(stateActions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TriggerActions) && Intrinsics.areEqual(this.stateActions, ((TriggerActions) other).stateActions);
    }

    public int hashCode() {
        List list = this.stateActions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "TriggerActions(stateActions=" + this.stateActions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TriggerActions(@Nullable List<? extends StateAction> list) {
        this.stateActions = list;
    }

    @Nullable
    public final List<StateAction> getStateActions() {
        return this.stateActions;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/environment/TriggerActions$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/environment/TriggerActions;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nThomasStateTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasStateTrigger.kt\ncom/urbanairship/android/layout/environment/TriggerActions$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n1549#2:42\n1620#2,3:43\n*S KotlinDebug\n*F\n+ 1 ThomasStateTrigger.kt\ncom/urbanairship/android/layout/environment/TriggerActions$Companion\n*L\n36#1:42\n36#1:43,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final TriggerActions fromJson(@NotNull JsonMap json) throws JsonException {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(json, "json");
            JsonList jsonListOptionalList = JsonExtensionsKt.optionalList(json, "state_actions");
            if (jsonListOptionalList != null) {
                StateAction.Companion companion = StateAction.INSTANCE;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptionalList, 10));
                Iterator<JsonValue> it = jsonListOptionalList.iterator();
                while (it.hasNext()) {
                    arrayList.add(companion.fromJson(it.next()));
                }
            } else {
                arrayList = null;
            }
            return new TriggerActions(arrayList);
        }
    }
}
