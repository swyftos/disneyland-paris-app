package com.urbanairship.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.annotation.NonNull;
import com.urbanairship.UAirship;

/* loaded from: classes4.dex */
public class ClipboardAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "clipboard_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^c";

    @NonNull
    public static final String LABEL_KEY = "label";

    @NonNull
    public static final String TEXT_KEY = "text";

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return false;
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
        String string2;
        if (actionArguments.getValue().getMap() != null) {
            string = actionArguments.getValue().getMap().opt("text").getString();
            string2 = actionArguments.getValue().getMap().opt("label").getString();
        } else {
            string = actionArguments.getValue().getString();
            string2 = null;
        }
        ((ClipboardManager) UAirship.getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(string2, string));
        return ActionResult.newResult(actionArguments.getValue());
    }
}
