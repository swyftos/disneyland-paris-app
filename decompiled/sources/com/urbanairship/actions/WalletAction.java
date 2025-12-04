package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;

/* loaded from: classes4.dex */
public class WalletAction extends OpenExternalUrlAction {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "wallet_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^w";

    @Override // com.urbanairship.actions.OpenExternalUrlAction, com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        UALog.i("Processing Wallet adaptive link.", new Object[0]);
        Intent intent = new Intent(UAirship.getApplicationContext(), (Class<?>) WalletLoadingActivity.class);
        intent.addFlags(268435456);
        intent.setData(Uri.parse(actionArguments.getValue().getString()));
        UAirship.getApplicationContext().startActivity(intent);
        return ActionResult.newEmptyResult();
    }

    @Override // com.urbanairship.actions.OpenExternalUrlAction, com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        if (UAirship.shared().getPlatformType() != 2) {
            return false;
        }
        return super.acceptsArguments(actionArguments);
    }
}
