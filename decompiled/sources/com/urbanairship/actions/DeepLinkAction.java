package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.base.Supplier;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.Checks;

/* loaded from: classes4.dex */
public class DeepLinkAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "deep_link_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^d";
    private final Supplier airshipSupplier;

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    public DeepLinkAction() {
        this(new Supplier() { // from class: com.urbanairship.actions.DeepLinkAction.1
            @Override // com.urbanairship.base.Supplier
            public UAirship get() {
                return UAirship.shared();
            }
        });
    }

    DeepLinkAction(Supplier supplier) {
        this.airshipSupplier = supplier;
    }

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        String string = actionArguments.getValue().getString();
        UAirship uAirship = (UAirship) this.airshipSupplier.get();
        Checks.checkNotNull(string, "Missing feature.");
        Checks.checkNotNull(uAirship, "Missing airship.");
        UALog.i("Deep linking: %s", string);
        if (!uAirship.deepLink(string)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string)).addFlags(268435456).setPackage(UAirship.getPackageName());
            PushMessage pushMessage = (PushMessage) actionArguments.getMetadata().getParcelable(ActionArguments.PUSH_MESSAGE_METADATA);
            if (pushMessage != null) {
                intent.putExtra(PushManager.EXTRA_PUSH_MESSAGE_BUNDLE, pushMessage.getPushBundle());
            }
            UAirship.getApplicationContext().startActivity(intent);
        }
        return ActionResult.newResult(actionArguments.getValue());
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        int situation = actionArguments.getSituation();
        return (situation == 0 || situation == 6 || situation == 2 || situation == 3 || situation == 4) && actionArguments.getValue().getString() != null;
    }
}
