package com.urbanairship.featureflag;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.audience.CompoundAudienceSelector;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "Lcom/urbanairship/json/JsonSerializable;", "selector", "Lcom/urbanairship/audience/CompoundAudienceSelector;", "(Lcom/urbanairship/audience/CompoundAudienceSelector;)V", "getSelector", "()Lcom/urbanairship/audience/CompoundAudienceSelector;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FeatureFlagCompoundAudience implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String SELECTOR = "selector";
    private final CompoundAudienceSelector selector;

    public static /* synthetic */ FeatureFlagCompoundAudience copy$default(FeatureFlagCompoundAudience featureFlagCompoundAudience, CompoundAudienceSelector compoundAudienceSelector, int i, Object obj) {
        if ((i & 1) != 0) {
            compoundAudienceSelector = featureFlagCompoundAudience.selector;
        }
        return featureFlagCompoundAudience.copy(compoundAudienceSelector);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final CompoundAudienceSelector getSelector() {
        return this.selector;
    }

    @NotNull
    public final FeatureFlagCompoundAudience copy(@NotNull CompoundAudienceSelector selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new FeatureFlagCompoundAudience(selector);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FeatureFlagCompoundAudience) && Intrinsics.areEqual(this.selector, ((FeatureFlagCompoundAudience) other).selector);
    }

    public int hashCode() {
        return this.selector.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeatureFlagCompoundAudience(selector=" + this.selector + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public FeatureFlagCompoundAudience(@NotNull CompoundAudienceSelector selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    @NotNull
    public final CompoundAudienceSelector getSelector() {
        return this.selector;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience$Companion;", "", "()V", "SELECTOR", "", "fromJson", "Lcom/urbanairship/featureflag/FeatureFlagCompoundAudience;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final FeatureFlagCompoundAudience fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            CompoundAudienceSelector.Companion companion = CompoundAudienceSelector.INSTANCE;
            JsonValue jsonValueRequire = jsonMapRequireMap.require(FeatureFlagCompoundAudience.SELECTOR);
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            return new FeatureFlagCompoundAudience(companion.fromJson(jsonValueRequire));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to(SELECTOR, this.selector)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
