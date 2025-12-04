package com.urbanairship.actions;

import androidx.annotation.NonNull;
import com.urbanairship.UALog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public abstract class Action {
    public static final int SITUATION_AUTOMATION = 6;
    public static final int SITUATION_BACKGROUND_NOTIFICATION_ACTION_BUTTON = 5;
    public static final int SITUATION_FOREGROUND_NOTIFICATION_ACTION_BUTTON = 4;
    public static final int SITUATION_MANUAL_INVOCATION = 0;
    public static final int SITUATION_PUSH_OPENED = 2;
    public static final int SITUATION_PUSH_RECEIVED = 1;
    public static final int SITUATION_WEB_VIEW_INVOCATION = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Situation {
    }

    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        return true;
    }

    public void onFinish(@NonNull ActionArguments actionArguments, @NonNull ActionResult actionResult) {
    }

    public void onStart(@NonNull ActionArguments actionArguments) {
    }

    @NonNull
    public abstract ActionResult perform(@NonNull ActionArguments actionArguments);

    public boolean shouldRunOnMainThread() {
        return false;
    }

    final ActionResult run(ActionArguments actionArguments) {
        try {
            if (!acceptsArguments(actionArguments)) {
                UALog.d("Action %s is unable to accept arguments: %s", this, actionArguments);
                return ActionResult.newEmptyResultWithStatus(2);
            }
            UALog.i("Running action: %s arguments: %s", this, actionArguments);
            onStart(actionArguments);
            ActionResult actionResultPerform = perform(actionArguments);
            if (actionResultPerform == null) {
                actionResultPerform = ActionResult.newEmptyResult();
            }
            onFinish(actionArguments, actionResultPerform);
            return actionResultPerform;
        } catch (Exception e) {
            UALog.e(e, "Failed to run action %s", this);
            return ActionResult.newErrorResult(e);
        }
    }
}
