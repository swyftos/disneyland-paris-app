package com.urbanairship.actions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public final class ActionResult {
    public static final int STATUS_ACTION_NOT_FOUND = 3;
    public static final int STATUS_COMPLETED = 1;
    public static final int STATUS_EXECUTION_ERROR = 4;
    public static final int STATUS_REJECTED_ARGUMENTS = 2;
    private final Exception exception;
    private final int status;
    private final ActionValue value;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    @NonNull
    public static ActionResult newEmptyResult() {
        return new ActionResult(null, null, 1);
    }

    @NonNull
    public static ActionResult newResult(@Nullable ActionValue actionValue) {
        return new ActionResult(actionValue, null, 1);
    }

    @NonNull
    public static ActionResult newErrorResult(@Nullable Exception exc) {
        return new ActionResult(null, exc, 4);
    }

    static ActionResult newEmptyResultWithStatus(int i) {
        return new ActionResult(null, null, i);
    }

    ActionResult(ActionValue actionValue, Exception exc, int i) {
        this.value = actionValue == null ? new ActionValue() : actionValue;
        this.exception = exc;
        this.status = i;
    }

    @NonNull
    public ActionValue getValue() {
        return this.value;
    }

    @Nullable
    public Exception getException() {
        return this.exception;
    }

    public int getStatus() {
        return this.status;
    }
}
