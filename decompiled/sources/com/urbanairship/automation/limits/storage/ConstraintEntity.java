package com.urbanairship.automation.limits.storage;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.Nullable;

@Entity(indices = {@Index(unique = true, value = {"constraintId"})}, tableName = "constraints")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R*\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00198G@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/automation/limits/storage/ConstraintEntity;", "", "()V", "_rawRange", "", "get_rawRange", "()J", "set_rawRange", "(J)V", "constraintId", "", "getConstraintId", "()Ljava/lang/String;", "setConstraintId", "(Ljava/lang/String;)V", "count", "", "getCount", "()I", "setCount", "(I)V", "id", "getId", "setId", "value", "Lkotlin/time/Duration;", "range", "getRange-UwyO8pc", "setRange-LRDsOJo", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConstraintEntity {
    private long _rawRange;
    private String constraintId;
    private int count;
    private int id;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    @Nullable
    public final String getConstraintId() {
        return this.constraintId;
    }

    public final void setConstraintId(@Nullable String str) {
        this.constraintId = str;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final long get_rawRange() {
        return this._rawRange;
    }

    public final void set_rawRange(long j) {
        this._rawRange = j;
    }

    @Ignore
    /* renamed from: getRange-UwyO8pc, reason: not valid java name */
    public final long m2817getRangeUwyO8pc() {
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(this._rawRange, DurationUnit.SECONDS);
    }

    /* renamed from: setRange-LRDsOJo, reason: not valid java name */
    public final void m2818setRangeLRDsOJo(long j) {
        this._rawRange = Duration.m3488getInWholeSecondsimpl(j);
    }
}
