package com.urbanairship.automation.engine.triggerprocessor;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/MatchResult;", "", "triggerId", "", "isTriggered", "", "(Ljava/lang/String;Z)V", "()Z", "getTriggerId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MatchResult {
    private final boolean isTriggered;
    private final String triggerId;

    public static /* synthetic */ MatchResult copy$default(MatchResult matchResult, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchResult.triggerId;
        }
        if ((i & 2) != 0) {
            z = matchResult.isTriggered;
        }
        return matchResult.copy(str, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTriggerId() {
        return this.triggerId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsTriggered() {
        return this.isTriggered;
    }

    @NotNull
    public final MatchResult copy(@NotNull String triggerId, boolean isTriggered) {
        Intrinsics.checkNotNullParameter(triggerId, "triggerId");
        return new MatchResult(triggerId, isTriggered);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchResult)) {
            return false;
        }
        MatchResult matchResult = (MatchResult) other;
        return Intrinsics.areEqual(this.triggerId, matchResult.triggerId) && this.isTriggered == matchResult.isTriggered;
    }

    public int hashCode() {
        return (this.triggerId.hashCode() * 31) + Boolean.hashCode(this.isTriggered);
    }

    @NotNull
    public String toString() {
        return "MatchResult(triggerId=" + this.triggerId + ", isTriggered=" + this.isTriggered + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public MatchResult(@NotNull String triggerId, boolean z) {
        Intrinsics.checkNotNullParameter(triggerId, "triggerId");
        this.triggerId = triggerId;
        this.isTriggered = z;
    }

    @NotNull
    public final String getTriggerId() {
        return this.triggerId;
    }

    public final boolean isTriggered() {
        return this.isTriggered;
    }
}
