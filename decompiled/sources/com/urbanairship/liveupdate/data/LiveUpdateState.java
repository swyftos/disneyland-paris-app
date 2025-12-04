package com.urbanairship.liveupdate.data;

import androidx.room.Entity;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(tableName = "live_update_state")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJB\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006 "}, d2 = {"Lcom/urbanairship/liveupdate/data/LiveUpdateState;", "", "name", "", "type", "isActive", "", "timestamp", "", "dismissalDate", "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/Long;)V", "getDismissalDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/Long;)Lcom/urbanairship/liveupdate/data/LiveUpdateState;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LiveUpdateState {
    private final Long dismissalDate;
    private final boolean isActive;
    private final String name;
    private final long timestamp;
    private final String type;

    public static /* synthetic */ LiveUpdateState copy$default(LiveUpdateState liveUpdateState, String str, String str2, boolean z, long j, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveUpdateState.name;
        }
        if ((i & 2) != 0) {
            str2 = liveUpdateState.type;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = liveUpdateState.isActive;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = liveUpdateState.timestamp;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            l = liveUpdateState.dismissalDate;
        }
        return liveUpdateState.copy(str, str3, z2, j2, l);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Long getDismissalDate() {
        return this.dismissalDate;
    }

    @NotNull
    public final LiveUpdateState copy(@NotNull String name, @NotNull String type, boolean isActive, long timestamp, @Nullable Long dismissalDate) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new LiveUpdateState(name, type, isActive, timestamp, dismissalDate);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveUpdateState)) {
            return false;
        }
        LiveUpdateState liveUpdateState = (LiveUpdateState) other;
        return Intrinsics.areEqual(this.name, liveUpdateState.name) && Intrinsics.areEqual(this.type, liveUpdateState.type) && this.isActive == liveUpdateState.isActive && this.timestamp == liveUpdateState.timestamp && Intrinsics.areEqual(this.dismissalDate, liveUpdateState.dismissalDate);
    }

    public int hashCode() {
        int iHashCode = ((((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isActive)) * 31) + Long.hashCode(this.timestamp)) * 31;
        Long l = this.dismissalDate;
        return iHashCode + (l == null ? 0 : l.hashCode());
    }

    @NotNull
    public String toString() {
        return "LiveUpdateState(name=" + this.name + ", type=" + this.type + ", isActive=" + this.isActive + ", timestamp=" + this.timestamp + ", dismissalDate=" + this.dismissalDate + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public LiveUpdateState(@NotNull String name, @NotNull String type, boolean z, long j, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.type = type;
        this.isActive = z;
        this.timestamp = j;
        this.dismissalDate = l;
    }

    public /* synthetic */ LiveUpdateState(String str, String str2, boolean z, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, j, (i & 16) != 0 ? null : l);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Nullable
    public final Long getDismissalDate() {
        return this.dismissalDate;
    }
}
