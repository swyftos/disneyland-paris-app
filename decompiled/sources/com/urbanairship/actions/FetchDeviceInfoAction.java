package com.urbanairship.actions;

import androidx.annotation.NonNull;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.modules.location.AirshipLocationClient;
import java.util.Set;

/* loaded from: classes4.dex */
public class FetchDeviceInfoAction extends Action {

    @NonNull
    public static final String CHANNEL_ID_KEY = "channel_id";

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "fetch_device_info";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^fdi";

    @NonNull
    public static final String LOCATION_ENABLED_KEY = "location_enabled";

    @NonNull
    public static final String NAMED_USER_ID_KEY = "named_user";

    @NonNull
    public static final String PUSH_OPT_IN_KEY = "push_opt_in";

    @NonNull
    public static final String TAGS_KEY = "tags";

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) {
        AirshipLocationClient locationClient = UAirship.shared().getLocationClient();
        JsonMap.Builder builderPutOpt = JsonMap.newBuilder().put("channel_id", UAirship.shared().getChannel().getId()).put(PUSH_OPT_IN_KEY, UAirship.shared().getPushManager().isOptIn()).put(LOCATION_ENABLED_KEY, locationClient != null && locationClient.isLocationUpdatesEnabled()).putOpt(NAMED_USER_ID_KEY, UAirship.shared().getContact().getNamedUserId());
        Set<String> tags = UAirship.shared().getChannel().getTags();
        if (!tags.isEmpty()) {
            builderPutOpt.put(TAGS_KEY, JsonValue.wrapOpt(tags));
        }
        return ActionResult.newResult(new ActionValue(builderPutOpt.build().getJsonValue()));
    }

    public static class FetchDeviceInfoPredicate implements ActionRegistry.Predicate {
        @Override // com.urbanairship.actions.ActionRegistry.Predicate
        public boolean apply(@NonNull ActionArguments actionArguments) {
            return actionArguments.getSituation() == 3 || actionArguments.getSituation() == 0;
        }
    }
}
