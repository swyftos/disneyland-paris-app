package com.urbanairship.automation.engine.triggerprocessor;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.engine.TriggeringInfo;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/automation/engine/triggerprocessor/TriggerResult;", "", "scheduleId", "", "triggerExecutionType", "Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "triggerInfo", "Lcom/urbanairship/automation/engine/TriggeringInfo;", "(Ljava/lang/String;Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;Lcom/urbanairship/automation/engine/TriggeringInfo;)V", "getScheduleId", "()Ljava/lang/String;", "getTriggerExecutionType", "()Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;", "setTriggerExecutionType", "(Lcom/urbanairship/automation/engine/triggerprocessor/TriggerExecutionType;)V", "getTriggerInfo", "()Lcom/urbanairship/automation/engine/TriggeringInfo;", "setTriggerInfo", "(Lcom/urbanairship/automation/engine/TriggeringInfo;)V", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TriggerResult {
    private final String scheduleId;
    private TriggerExecutionType triggerExecutionType;
    private TriggeringInfo triggerInfo;

    public static /* synthetic */ TriggerResult copy$default(TriggerResult triggerResult, String str, TriggerExecutionType triggerExecutionType, TriggeringInfo triggeringInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = triggerResult.scheduleId;
        }
        if ((i & 2) != 0) {
            triggerExecutionType = triggerResult.triggerExecutionType;
        }
        if ((i & 4) != 0) {
            triggeringInfo = triggerResult.triggerInfo;
        }
        return triggerResult.copy(str, triggerExecutionType, triggeringInfo);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final TriggerExecutionType getTriggerExecutionType() {
        return this.triggerExecutionType;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final TriggeringInfo getTriggerInfo() {
        return this.triggerInfo;
    }

    @NotNull
    public final TriggerResult copy(@NotNull String scheduleId, @NotNull TriggerExecutionType triggerExecutionType, @NotNull TriggeringInfo triggerInfo) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(triggerExecutionType, "triggerExecutionType");
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        return new TriggerResult(scheduleId, triggerExecutionType, triggerInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TriggerResult)) {
            return false;
        }
        TriggerResult triggerResult = (TriggerResult) other;
        return Intrinsics.areEqual(this.scheduleId, triggerResult.scheduleId) && this.triggerExecutionType == triggerResult.triggerExecutionType && Intrinsics.areEqual(this.triggerInfo, triggerResult.triggerInfo);
    }

    public int hashCode() {
        return (((this.scheduleId.hashCode() * 31) + this.triggerExecutionType.hashCode()) * 31) + this.triggerInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "TriggerResult(scheduleId=" + this.scheduleId + ", triggerExecutionType=" + this.triggerExecutionType + ", triggerInfo=" + this.triggerInfo + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public TriggerResult(@NotNull String scheduleId, @NotNull TriggerExecutionType triggerExecutionType, @NotNull TriggeringInfo triggerInfo) {
        Intrinsics.checkNotNullParameter(scheduleId, "scheduleId");
        Intrinsics.checkNotNullParameter(triggerExecutionType, "triggerExecutionType");
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        this.scheduleId = scheduleId;
        this.triggerExecutionType = triggerExecutionType;
        this.triggerInfo = triggerInfo;
    }

    @NotNull
    public final String getScheduleId() {
        return this.scheduleId;
    }

    @NotNull
    public final TriggerExecutionType getTriggerExecutionType() {
        return this.triggerExecutionType;
    }

    public final void setTriggerExecutionType(@NotNull TriggerExecutionType triggerExecutionType) {
        Intrinsics.checkNotNullParameter(triggerExecutionType, "<set-?>");
        this.triggerExecutionType = triggerExecutionType;
    }

    @NotNull
    public final TriggeringInfo getTriggerInfo() {
        return this.triggerInfo;
    }

    public final void setTriggerInfo(@NotNull TriggeringInfo triggeringInfo) {
        Intrinsics.checkNotNullParameter(triggeringInfo, "<set-?>");
        this.triggerInfo = triggeringInfo;
    }
}
