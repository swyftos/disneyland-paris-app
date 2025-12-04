package com.urbanairship.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionRegistry;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;

/* loaded from: classes4.dex */
public class ActionRunRequest {
    private Action action;
    private String actionName;
    private ActionValue actionValue;
    private Bundle metadata;
    private ActionRegistry registry;
    private Executor executor = AirshipExecutors.threadPoolExecutor();
    private int situation = 0;

    @NonNull
    public static ActionRunRequest createRequest(@NonNull String str) {
        return new ActionRunRequest(str, null);
    }

    @NonNull
    public static ActionRunRequest createRequest(@NonNull String str, @Nullable ActionRegistry actionRegistry) {
        return new ActionRunRequest(str, actionRegistry);
    }

    @NonNull
    public static ActionRunRequest createRequest(@NonNull Action action) {
        if (action == null) {
            throw new IllegalArgumentException("Unable to run null action");
        }
        return new ActionRunRequest(action);
    }

    private ActionRunRequest(String str, ActionRegistry actionRegistry) {
        this.actionName = str;
        this.registry = actionRegistry;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public ActionRunRequest(@NonNull Action action) {
        this.action = action;
    }

    @NonNull
    public ActionRunRequest setValue(@Nullable ActionValue actionValue) {
        this.actionValue = actionValue;
        return this;
    }

    @NonNull
    public ActionRunRequest setValue(@Nullable Object obj) {
        try {
            this.actionValue = ActionValue.wrap(obj);
            return this;
        } catch (ActionValueException e) {
            throw new IllegalArgumentException("Unable to wrap object: " + obj + " as an ActionValue.", e);
        }
    }

    @NonNull
    public ActionRunRequest setMetadata(@Nullable Bundle bundle) {
        this.metadata = bundle;
        return this;
    }

    @NonNull
    public ActionRunRequest setSituation(int i) {
        this.situation = i;
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ActionRunRequest setExecutor(@NonNull Executor executor) {
        this.executor = executor;
        return this;
    }

    @NonNull
    @WorkerThread
    public ActionResult runSync() throws InterruptedException {
        ActionArguments actionArgumentsCreateActionArguments = createActionArguments();
        final Semaphore semaphore = new Semaphore(0);
        ActionRunnable actionRunnable = new ActionRunnable(actionArgumentsCreateActionArguments) { // from class: com.urbanairship.actions.ActionRunRequest.1
            @Override // com.urbanairship.actions.ActionRunRequest.ActionRunnable
            void onFinish(ActionArguments actionArguments, ActionResult actionResult) {
                semaphore.release();
            }
        };
        if (shouldRunOnMain(actionArgumentsCreateActionArguments)) {
            new Handler(Looper.getMainLooper()).post(actionRunnable);
        } else {
            this.executor.execute(actionRunnable);
        }
        try {
            semaphore.acquire();
            return actionRunnable.result;
        } catch (InterruptedException e) {
            UALog.e("Failed to run action with arguments %s", actionArgumentsCreateActionArguments);
            Thread.currentThread().interrupt();
            return ActionResult.newErrorResult(e);
        }
    }

    public void run() {
        run(null, null);
    }

    public void run(@Nullable ActionCompletionCallback actionCompletionCallback) {
        run(null, actionCompletionCallback);
    }

    public void run(@Nullable Looper looper, @Nullable final ActionCompletionCallback actionCompletionCallback) {
        if (looper == null && (looper = Looper.myLooper()) == null) {
            looper = Looper.getMainLooper();
        }
        ActionArguments actionArgumentsCreateActionArguments = createActionArguments();
        final Handler handler = new Handler(looper);
        ActionRunnable actionRunnable = new ActionRunnable(actionArgumentsCreateActionArguments) { // from class: com.urbanairship.actions.ActionRunRequest.2
            @Override // com.urbanairship.actions.ActionRunRequest.ActionRunnable
            void onFinish(final ActionArguments actionArguments, final ActionResult actionResult) {
                if (actionCompletionCallback == null) {
                    return;
                }
                if (handler.getLooper() == Looper.myLooper()) {
                    actionCompletionCallback.onFinish(actionArguments, actionResult);
                } else {
                    handler.post(new Runnable() { // from class: com.urbanairship.actions.ActionRunRequest.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            actionCompletionCallback.onFinish(actionArguments, actionResult);
                        }
                    });
                }
            }
        };
        if (shouldRunOnMain(actionArgumentsCreateActionArguments)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                actionRunnable.run();
                return;
            } else {
                new Handler(Looper.getMainLooper()).post(actionRunnable);
                return;
            }
        }
        this.executor.execute(actionRunnable);
    }

    private ActionArguments createActionArguments() {
        Bundle bundle = this.metadata == null ? new Bundle() : new Bundle(this.metadata);
        String str = this.actionName;
        if (str != null) {
            bundle.putString(ActionArguments.REGISTRY_ACTION_NAME_METADATA, str);
        }
        return new ActionArguments(this.situation, this.actionValue, bundle);
    }

    private ActionRegistry.Entry lookUpAction(String str) {
        ActionRegistry actionRegistry = this.registry;
        if (actionRegistry != null) {
            return actionRegistry.getEntry(str);
        }
        return UAirship.shared().getActionRegistry().getEntry(str);
    }

    private boolean shouldRunOnMain(ActionArguments actionArguments) {
        Action action = this.action;
        if (action != null) {
            return action.shouldRunOnMainThread();
        }
        ActionRegistry.Entry entryLookUpAction = lookUpAction(this.actionName);
        return entryLookUpAction != null && entryLookUpAction.getActionForSituation(actionArguments.getSituation()).shouldRunOnMainThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ActionResult executeAction(ActionArguments actionArguments) {
        String str = this.actionName;
        if (str != null) {
            ActionRegistry.Entry entryLookUpAction = lookUpAction(str);
            if (entryLookUpAction == null) {
                return ActionResult.newEmptyResultWithStatus(3);
            }
            if (entryLookUpAction.getPredicate() != null && !entryLookUpAction.getPredicate().apply(actionArguments)) {
                UALog.i("Action %s will not be run. Registry predicate rejected the arguments: %s", this.actionName, actionArguments);
                return ActionResult.newEmptyResultWithStatus(2);
            }
            return entryLookUpAction.getActionForSituation(this.situation).run(actionArguments);
        }
        Action action = this.action;
        if (action != null) {
            return action.run(actionArguments);
        }
        return ActionResult.newEmptyResultWithStatus(3);
    }

    private abstract class ActionRunnable implements Runnable {
        private final ActionArguments arguments;
        private volatile ActionResult result;

        abstract void onFinish(ActionArguments actionArguments, ActionResult actionResult);

        public ActionRunnable(ActionArguments actionArguments) {
            this.arguments = actionArguments;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.result = ActionRunRequest.this.executeAction(this.arguments);
            onFinish(this.arguments, this.result);
        }
    }
}
