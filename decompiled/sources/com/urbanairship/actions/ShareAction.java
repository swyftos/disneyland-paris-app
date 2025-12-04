package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.urbanairship.R;
import com.urbanairship.UAirship;

/* loaded from: classes4.dex */
public class ShareAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "share_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^s";

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        int situation = actionArguments.getSituation();
        return (situation == 0 || situation == 6 || situation == 2 || situation == 3 || situation == 4) && actionArguments.getValue().getString() != null;
    }

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        Context applicationContext = UAirship.getApplicationContext();
        applicationContext.startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", actionArguments.getValue().getString()), applicationContext.getString(R.string.ua_share_dialog_title)).setFlags(268435456));
        return ActionResult.newEmptyResult();
    }
}
