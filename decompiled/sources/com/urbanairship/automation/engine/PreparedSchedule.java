package com.urbanairship.automation.engine;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.automation.limits.FrequencyChecker;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u0014J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/automation/engine/PreparedSchedule;", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "data", "Lcom/urbanairship/automation/engine/PreparedScheduleData;", "frequencyChecker", "Lcom/urbanairship/automation/limits/FrequencyChecker;", "(Lcom/urbanairship/automation/engine/PreparedScheduleInfo;Lcom/urbanairship/automation/engine/PreparedScheduleData;Lcom/urbanairship/automation/limits/FrequencyChecker;)V", "getData$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/PreparedScheduleData;", "getFrequencyChecker$urbanairship_automation_release", "()Lcom/urbanairship/automation/limits/FrequencyChecker;", "getInfo$urbanairship_automation_release", "()Lcom/urbanairship/automation/engine/PreparedScheduleInfo;", "component1", "component1$urbanairship_automation_release", "component2", "component2$urbanairship_automation_release", "component3", "component3$urbanairship_automation_release", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class PreparedSchedule {
    private final PreparedScheduleData data;
    private final FrequencyChecker frequencyChecker;
    private final PreparedScheduleInfo info;

    public static /* synthetic */ PreparedSchedule copy$default(PreparedSchedule preparedSchedule, PreparedScheduleInfo preparedScheduleInfo, PreparedScheduleData preparedScheduleData, FrequencyChecker frequencyChecker, int i, Object obj) {
        if ((i & 1) != 0) {
            preparedScheduleInfo = preparedSchedule.info;
        }
        if ((i & 2) != 0) {
            preparedScheduleData = preparedSchedule.data;
        }
        if ((i & 4) != 0) {
            frequencyChecker = preparedSchedule.frequencyChecker;
        }
        return preparedSchedule.copy(preparedScheduleInfo, preparedScheduleData, frequencyChecker);
    }

    @NotNull
    /* renamed from: component1$urbanairship_automation_release, reason: from getter */
    public final PreparedScheduleInfo getInfo() {
        return this.info;
    }

    @NotNull
    /* renamed from: component2$urbanairship_automation_release, reason: from getter */
    public final PreparedScheduleData getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component3$urbanairship_automation_release, reason: from getter */
    public final FrequencyChecker getFrequencyChecker() {
        return this.frequencyChecker;
    }

    @NotNull
    public final PreparedSchedule copy(@NotNull PreparedScheduleInfo info, @NotNull PreparedScheduleData data, @Nullable FrequencyChecker frequencyChecker) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(data, "data");
        return new PreparedSchedule(info, data, frequencyChecker);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreparedSchedule)) {
            return false;
        }
        PreparedSchedule preparedSchedule = (PreparedSchedule) other;
        return Intrinsics.areEqual(this.info, preparedSchedule.info) && Intrinsics.areEqual(this.data, preparedSchedule.data) && Intrinsics.areEqual(this.frequencyChecker, preparedSchedule.frequencyChecker);
    }

    public int hashCode() {
        int iHashCode = ((this.info.hashCode() * 31) + this.data.hashCode()) * 31;
        FrequencyChecker frequencyChecker = this.frequencyChecker;
        return iHashCode + (frequencyChecker == null ? 0 : frequencyChecker.hashCode());
    }

    @NotNull
    public String toString() {
        return "PreparedSchedule(info=" + this.info + ", data=" + this.data + ", frequencyChecker=" + this.frequencyChecker + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PreparedSchedule(@NotNull PreparedScheduleInfo info, @NotNull PreparedScheduleData data, @Nullable FrequencyChecker frequencyChecker) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(data, "data");
        this.info = info;
        this.data = data;
        this.frequencyChecker = frequencyChecker;
    }

    @NotNull
    public final PreparedScheduleInfo getInfo$urbanairship_automation_release() {
        return this.info;
    }

    @NotNull
    public final PreparedScheduleData getData$urbanairship_automation_release() {
        return this.data;
    }

    @Nullable
    public final FrequencyChecker getFrequencyChecker$urbanairship_automation_release() {
        return this.frequencyChecker;
    }
}
