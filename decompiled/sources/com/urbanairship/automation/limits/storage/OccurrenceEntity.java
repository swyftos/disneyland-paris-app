package com.urbanairship.automation.limits.storage;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"parentConstraintId"}, entity = ConstraintEntity.class, onDelete = 5, parentColumns = {"constraintId"})}, indices = {@Index({"parentConstraintId"})}, tableName = "occurrences")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/automation/limits/storage/OccurrenceEntity;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "parentConstraintId", "", "getParentConstraintId", "()Ljava/lang/String;", "setParentConstraintId", "(Ljava/lang/String;)V", "timeStamp", "", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "Comparator", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OccurrenceEntity {
    private int id;
    private String parentConstraintId;
    private long timeStamp;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    @Nullable
    public final String getParentConstraintId() {
        return this.parentConstraintId;
    }

    public final void setParentConstraintId(@Nullable String str) {
        this.parentConstraintId = str;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/urbanairship/automation/limits/storage/OccurrenceEntity$Comparator;", "Ljava/util/Comparator;", "Lcom/urbanairship/automation/limits/storage/OccurrenceEntity;", "Lkotlin/Comparator;", "()V", "compare", "", "self", ETCPaymentMethod.OTHER, "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Comparator implements java.util.Comparator<OccurrenceEntity> {
        @Override // java.util.Comparator
        public int compare(@NotNull OccurrenceEntity self, @NotNull OccurrenceEntity other) {
            Intrinsics.checkNotNullParameter(self, "self");
            Intrinsics.checkNotNullParameter(other, "other");
            return Intrinsics.compare(self.getTimeStamp(), other.getTimeStamp());
        }
    }
}
