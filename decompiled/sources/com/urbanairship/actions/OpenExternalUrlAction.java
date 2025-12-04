package com.urbanairship.actions;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Supplier;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.UrlAllowList;
import com.urbanairship.util.UriUtils;

/* loaded from: classes4.dex */
public class OpenExternalUrlAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "open_external_url_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^u";
    private Supplier allowListSupplier;

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    public OpenExternalUrlAction() {
        this(new Supplier() { // from class: com.urbanairship.actions.OpenExternalUrlAction$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return OpenExternalUrlAction.lambda$new$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ UrlAllowList lambda$new$0() {
        return UAirship.shared().getUrlAllowList();
    }

    OpenExternalUrlAction(Supplier supplier) {
        this.allowListSupplier = supplier;
    }

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        Uri uri = UriUtils.parse(actionArguments.getValue().getString());
        UALog.i("Opening URI: %s", uri);
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268435456);
        UAirship.getApplicationContext().startActivity(intent);
        return ActionResult.newResult(actionArguments.getValue());
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        int situation = actionArguments.getSituation();
        if ((situation == 0 || situation == 6 || situation == 2 || situation == 3 || situation == 4) && UriUtils.parse(actionArguments.getValue().getString()) != null) {
            return ((UrlAllowList) this.allowListSupplier.get()).isAllowed(actionArguments.getValue().getString(), 2);
        }
        return false;
    }
}
