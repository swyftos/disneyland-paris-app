package com.urbanairship.android.layout.environment;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "", "id", "", "triggerWhenStateMatches", "Lcom/urbanairship/json/JsonPredicate;", "resetWhenStateMatches", "onTrigger", "Lcom/urbanairship/android/layout/environment/TriggerActions;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonPredicate;Lcom/urbanairship/json/JsonPredicate;Lcom/urbanairship/android/layout/environment/TriggerActions;)V", "getId", "()Ljava/lang/String;", "getOnTrigger", "()Lcom/urbanairship/android/layout/environment/TriggerActions;", "getResetWhenStateMatches", "()Lcom/urbanairship/json/JsonPredicate;", "getTriggerWhenStateMatches", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ThomasStateTrigger {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String id;
    private final TriggerActions onTrigger;
    private final JsonPredicate resetWhenStateMatches;
    private final JsonPredicate triggerWhenStateMatches;

    public static /* synthetic */ ThomasStateTrigger copy$default(ThomasStateTrigger thomasStateTrigger, String str, JsonPredicate jsonPredicate, JsonPredicate jsonPredicate2, TriggerActions triggerActions, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thomasStateTrigger.id;
        }
        if ((i & 2) != 0) {
            jsonPredicate = thomasStateTrigger.triggerWhenStateMatches;
        }
        if ((i & 4) != 0) {
            jsonPredicate2 = thomasStateTrigger.resetWhenStateMatches;
        }
        if ((i & 8) != 0) {
            triggerActions = thomasStateTrigger.onTrigger;
        }
        return thomasStateTrigger.copy(str, jsonPredicate, jsonPredicate2, triggerActions);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final JsonPredicate getTriggerWhenStateMatches() {
        return this.triggerWhenStateMatches;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final JsonPredicate getResetWhenStateMatches() {
        return this.resetWhenStateMatches;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final TriggerActions getOnTrigger() {
        return this.onTrigger;
    }

    @NotNull
    public final ThomasStateTrigger copy(@NotNull String id, @NotNull JsonPredicate triggerWhenStateMatches, @Nullable JsonPredicate resetWhenStateMatches, @NotNull TriggerActions onTrigger) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(triggerWhenStateMatches, "triggerWhenStateMatches");
        Intrinsics.checkNotNullParameter(onTrigger, "onTrigger");
        return new ThomasStateTrigger(id, triggerWhenStateMatches, resetWhenStateMatches, onTrigger);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThomasStateTrigger)) {
            return false;
        }
        ThomasStateTrigger thomasStateTrigger = (ThomasStateTrigger) other;
        return Intrinsics.areEqual(this.id, thomasStateTrigger.id) && Intrinsics.areEqual(this.triggerWhenStateMatches, thomasStateTrigger.triggerWhenStateMatches) && Intrinsics.areEqual(this.resetWhenStateMatches, thomasStateTrigger.resetWhenStateMatches) && Intrinsics.areEqual(this.onTrigger, thomasStateTrigger.onTrigger);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.triggerWhenStateMatches.hashCode()) * 31;
        JsonPredicate jsonPredicate = this.resetWhenStateMatches;
        return ((iHashCode + (jsonPredicate == null ? 0 : jsonPredicate.hashCode())) * 31) + this.onTrigger.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThomasStateTrigger(id=" + this.id + ", triggerWhenStateMatches=" + this.triggerWhenStateMatches + ", resetWhenStateMatches=" + this.resetWhenStateMatches + ", onTrigger=" + this.onTrigger + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ThomasStateTrigger(@NotNull String id, @NotNull JsonPredicate triggerWhenStateMatches, @Nullable JsonPredicate jsonPredicate, @NotNull TriggerActions onTrigger) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(triggerWhenStateMatches, "triggerWhenStateMatches");
        Intrinsics.checkNotNullParameter(onTrigger, "onTrigger");
        this.id = id;
        this.triggerWhenStateMatches = triggerWhenStateMatches;
        this.resetWhenStateMatches = jsonPredicate;
        this.onTrigger = onTrigger;
    }

    public /* synthetic */ ThomasStateTrigger(String str, JsonPredicate jsonPredicate, JsonPredicate jsonPredicate2, TriggerActions triggerActions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonPredicate, (i & 4) != 0 ? null : jsonPredicate2, triggerActions);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final JsonPredicate getTriggerWhenStateMatches() {
        return this.triggerWhenStateMatches;
    }

    @Nullable
    public final JsonPredicate getResetWhenStateMatches() {
        return this.resetWhenStateMatches;
    }

    @NotNull
    public final TriggerActions getOnTrigger() {
        return this.onTrigger;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/environment/ThomasStateTrigger$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/environment/ThomasStateTrigger;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nThomasStateTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThomasStateTrigger.kt\ncom/urbanairship/android/layout/environment/ThomasStateTrigger$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,41:1\n44#2,15:42\n44#2,15:57\n44#2,15:72\n*S KotlinDebug\n*F\n+ 1 ThomasStateTrigger.kt\ncom/urbanairship/android/layout/environment/ThomasStateTrigger$Companion\n*L\n22#1:42,15\n23#1:57,15\n25#1:72,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:159:0x03e5  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0283  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.android.layout.environment.ThomasStateTrigger fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1155
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.environment.ThomasStateTrigger.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.android.layout.environment.ThomasStateTrigger");
        }
    }
}
