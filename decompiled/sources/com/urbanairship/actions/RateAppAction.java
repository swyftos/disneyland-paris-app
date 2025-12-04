package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonMap;
import com.urbanairship.util.AppStoreUtils;

/* loaded from: classes4.dex */
public class RateAppAction extends Action {

    @NonNull
    public static final String BODY_KEY = "body";

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "rate_app_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^ra";

    @NonNull
    public static final String SHOW_LINK_PROMPT_KEY = "show_link_prompt";

    @NonNull
    public static final String SHOW_RATE_APP_INTENT_ACTION = "com.urbanairship.actions.SHOW_RATE_APP_INTENT_ACTION";

    @NonNull
    public static final String TITLE_KEY = "title";

    @Override // com.urbanairship.actions.Action
    public boolean shouldRunOnMainThread() {
        return true;
    }

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        if (actionArguments.getValue().getJsonValue().optMap().opt(SHOW_LINK_PROMPT_KEY).getBoolean(false)) {
            startRateAppActivity(actionArguments);
        } else {
            UAirship uAirshipShared = UAirship.shared();
            UAirship.getApplicationContext().startActivity(AppStoreUtils.getAppStoreIntent(UAirship.getApplicationContext(), uAirshipShared.getPlatformType(), uAirshipShared.getAirshipConfigOptions()).setFlags(268435456));
        }
        return ActionResult.newEmptyResult();
    }

    private void startRateAppActivity(ActionArguments actionArguments) {
        Context applicationContext = UAirship.getApplicationContext();
        JsonMap jsonMapOptMap = actionArguments.getValue().getJsonValue().optMap();
        Intent intent = new Intent(SHOW_RATE_APP_INTENT_ACTION).addFlags(805306368).setPackage(UAirship.getPackageName());
        if (jsonMapOptMap.opt("title").isString()) {
            intent.putExtra("title", jsonMapOptMap.opt("title").getString());
        }
        if (jsonMapOptMap.opt(BODY_KEY).isString()) {
            intent.putExtra(BODY_KEY, jsonMapOptMap.opt(BODY_KEY).getString());
        }
        applicationContext.startActivity(intent);
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        int situation = actionArguments.getSituation();
        return situation == 0 || situation == 6 || situation == 2 || situation == 3 || situation == 4;
    }
}
