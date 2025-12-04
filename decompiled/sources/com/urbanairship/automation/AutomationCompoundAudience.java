package com.urbanairship.automation;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.CompoundAudienceSelector;
import com.urbanairship.automation.AutomationAudience;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/automation/AutomationCompoundAudience;", "Lcom/urbanairship/json/JsonSerializable;", "selector", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "missBehavior", "Lcom/urbanairship/automation/AutomationAudience$MissBehavior;", "(Lcom/urbanairship/audience/CompoundAudienceSelector;Lcom/urbanairship/automation/AutomationAudience$MissBehavior;)V", "getMissBehavior$urbanairship_automation_release", "()Lcom/urbanairship/automation/AutomationAudience$MissBehavior;", "getSelector$urbanairship_automation_release", "()Lcom/urbanairship/audience/CompoundAudienceSelector;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AutomationCompoundAudience implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AutomationAudience.MissBehavior missBehavior;
    private final CompoundAudienceSelector selector;

    public AutomationCompoundAudience(@NotNull CompoundAudienceSelector selector, @NotNull AutomationAudience.MissBehavior missBehavior) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(missBehavior, "missBehavior");
        this.selector = selector;
        this.missBehavior = missBehavior;
    }

    @NotNull
    /* renamed from: getSelector$urbanairship_automation_release, reason: from getter */
    public final CompoundAudienceSelector getSelector() {
        return this.selector;
    }

    @NotNull
    /* renamed from: getMissBehavior$urbanairship_automation_release, reason: from getter */
    public final AutomationAudience.MissBehavior getMissBehavior() {
        return this.missBehavior;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/automation/AutomationCompoundAudience$Companion;", "", "()V", "MISS_BEHAVIOR", "", "SELECTOR", "fromJson", "Lcom/urbanairship/automation/AutomationCompoundAudience;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AutomationCompoundAudience fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            CompoundAudienceSelector.Companion companion = CompoundAudienceSelector.INSTANCE;
            JsonValue jsonValueRequire = jsonMapRequireMap.require("selector");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            CompoundAudienceSelector compoundAudienceSelectorFromJson = companion.fromJson(jsonValueRequire);
            AutomationAudience.MissBehavior.Companion companion2 = AutomationAudience.MissBehavior.INSTANCE;
            JsonValue jsonValueRequire2 = jsonMapRequireMap.require("miss_behavior");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
            return new AutomationCompoundAudience(compoundAudienceSelectorFromJson, companion2.fromJson(jsonValueRequire2));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("selector", this.selector), TuplesKt.to("miss_behavior", this.missBehavior)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AutomationCompoundAudience.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.automation.AutomationCompoundAudience");
        AutomationCompoundAudience automationCompoundAudience = (AutomationCompoundAudience) other;
        return Intrinsics.areEqual(this.selector, automationCompoundAudience.selector) && this.missBehavior == automationCompoundAudience.missBehavior;
    }

    public int hashCode() {
        return Objects.hash(this.selector, this.missBehavior);
    }
}
