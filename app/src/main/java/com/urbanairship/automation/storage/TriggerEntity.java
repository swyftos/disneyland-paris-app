package com.urbanairship.automation.storage;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonPredicate;

/* JADX INFO: loaded from: classes5.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"parentScheduleId"}, entity = ScheduleEntity.class, onDelete = 5, parentColumns = {"scheduleId"})}, indices = {@Index({"parentScheduleId"})}, tableName = "triggers")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TriggerEntity {
    public double goal;

    /* JADX INFO: renamed from: id */
    int f3749id;
    public boolean isCancellation;
    public JsonPredicate jsonPredicate;
    public String parentScheduleId;
    public double progress;
    public int triggerType;

    @Ignore
    public String toString() {
        return "TriggerEntity{id=" + this.f3749id + ", triggerType=" + this.triggerType + ", goal=" + this.goal + ", jsonPredicate=" + this.jsonPredicate + ", isCancellation=" + this.isCancellation + ", progress=" + this.progress + ", parentScheduleId='" + this.parentScheduleId + CoreConstants.SINGLE_QUOTE_CHAR + '}';
    }
}
