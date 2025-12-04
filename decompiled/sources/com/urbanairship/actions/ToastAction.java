package com.urbanairship.actions;

import android.widget.Toast;
import androidx.annotation.NonNull;
import com.urbanairship.UAirship;

/* loaded from: classes4.dex */
public class ToastAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "toast_action";

    @NonNull
    public static final String LENGTH_KEY = "length";

    @NonNull
    public static final String TEXT_KEY = "text";

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        int situation = actionArguments.getSituation();
        if (situation != 0 && situation != 2 && situation != 3 && situation != 4 && situation != 5 && situation != 6) {
            return false;
        }
        if (actionArguments.getValue().getMap() != null) {
            return actionArguments.getValue().getMap().opt("text").isString();
        }
        return actionArguments.getValue().getString() != null;
    }

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        String string;
        int i;
        if (actionArguments.getValue().getMap() != null) {
            i = actionArguments.getValue().getMap().opt(LENGTH_KEY).getInt(0);
            string = actionArguments.getValue().getMap().opt("text").getString();
        } else {
            string = actionArguments.getValue().getString();
            i = 0;
        }
        if (i == 1) {
            Toast.makeText(UAirship.getApplicationContext(), string, 1).show();
        } else {
            Toast.makeText(UAirship.getApplicationContext(), string, 0).show();
        }
        return ActionResult.newResult(actionArguments.getValue());
    }
}
