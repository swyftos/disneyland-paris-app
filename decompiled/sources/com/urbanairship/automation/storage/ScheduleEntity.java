package com.urbanairship.automation.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.List;

@Entity(indices = {@Index(unique = true, value = {"scheduleId"})}, tableName = "schedules")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class ScheduleEntity {
    public int appState;

    @Nullable
    public String audience;
    public boolean bypassHoldoutGroups;
    public JsonValue campaigns;
    public int count;
    public JsonValue data;
    public long editGracePeriod;
    public int executionState;
    public long executionStateChangeDate;
    public List<String> frequencyConstraintIds;

    @Nullable
    public String group;

    @PrimaryKey(autoGenerate = true)
    public int id;
    public long interval;
    public int limit;

    @Nullable
    public String messageType;
    public JsonMap metadata;
    public long newUserEvaluationDate;
    public int priority;

    @Nullable
    public String productId;

    @Nullable
    public String regionId;
    public JsonValue reportingContext;
    public long scheduleEnd;
    public String scheduleId;
    public long scheduleStart;
    public String scheduleType;
    public List<String> screens;
    public long seconds;

    @Nullable
    public String triggerContext;
    public long triggeredTime;

    @NonNull
    public String toString() {
        return "ScheduleEntity{id=" + this.id + ", scheduleId='" + this.scheduleId + CoreConstants.SINGLE_QUOTE_CHAR + ", group='" + this.group + CoreConstants.SINGLE_QUOTE_CHAR + ", metadata=" + this.metadata + ", limit=" + this.limit + ", priority=" + this.priority + ", triggeredTime=" + this.triggeredTime + ", scheduleStart=" + this.scheduleStart + ", scheduleEnd=" + this.scheduleEnd + ", editGracePeriod=" + this.editGracePeriod + ", interval=" + this.interval + ", scheduleType='" + this.scheduleType + CoreConstants.SINGLE_QUOTE_CHAR + ", data=" + this.data + ", count=" + this.count + ", executionState=" + this.executionState + ", executionStateChangeDate=" + this.executionStateChangeDate + ", triggerContext=" + this.triggerContext + ", appState=" + this.appState + ", screens=" + this.screens + ", seconds=" + this.seconds + ", regionId='" + this.regionId + CoreConstants.SINGLE_QUOTE_CHAR + ", audience=" + this.audience + ", campaigns=" + this.campaigns + ", reportingContext=" + this.reportingContext + ", frequencyConstraintIds=" + this.frequencyConstraintIds + ", messageType=" + this.messageType + ", bypassHoldoutGroups=" + this.bypassHoldoutGroups + ", newUserEvaluationDate=" + this.newUserEvaluationDate + ", productId=" + this.productId + '}';
    }
}
