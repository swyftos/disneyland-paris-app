package com.urbanairship.actions;

import androidx.annotation.NonNull;
import androidx.camera.video.AudioStats;
import com.urbanairship.UALog;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.Checks;

/* loaded from: classes4.dex */
public class AddCustomEventAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "add_custom_event_action";
    public static final String IN_APP_CONTEXT_METADATA_KEY = "in_app_metadata";

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) throws NumberFormatException {
        String string;
        JsonMap jsonMapOptMap = actionArguments.getValue().getJsonValue().optMap();
        String string2 = jsonMapOptMap.opt("event_name").getString();
        Checks.checkNotNull(string2, "Missing event name");
        String string3 = jsonMapOptMap.opt(CustomEvent.EVENT_VALUE).getString();
        double d = jsonMapOptMap.opt(CustomEvent.EVENT_VALUE).getDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        String string4 = jsonMapOptMap.opt("transaction_id").getString();
        String string5 = jsonMapOptMap.opt(CustomEvent.INTERACTION_TYPE).getString();
        String string6 = jsonMapOptMap.opt(CustomEvent.INTERACTION_ID).getString();
        JsonMap map = jsonMapOptMap.opt(CustomEvent.PROPERTIES).getMap();
        CustomEvent.Builder interaction = CustomEvent.newBuilder(string2).setTransactionId(string4).setAttribution((PushMessage) actionArguments.getMetadata().getParcelable(ActionArguments.PUSH_MESSAGE_METADATA)).setInteraction(string5, string6);
        if (string3 != null) {
            interaction.setEventValue(string3);
        } else {
            interaction.setEventValue(d);
        }
        String string7 = actionArguments.getMetadata().getString(IN_APP_CONTEXT_METADATA_KEY);
        if (string7 != null) {
            try {
                interaction.setInAppContext(JsonValue.parseString(string7));
            } catch (Exception e) {
                UALog.w("Failed to parse in-app context for custom event", e);
            }
        }
        if (string6 == null && string5 == null && (string = actionArguments.getMetadata().getString(ActionArguments.RICH_PUSH_ID_METADATA)) != null) {
            interaction.setMessageCenterInteraction(string);
        }
        if (map != null) {
            interaction.setProperties(map);
        }
        CustomEvent customEventBuild = interaction.build();
        customEventBuild.track();
        if (customEventBuild.isValid()) {
            return ActionResult.newEmptyResult();
        }
        return ActionResult.newErrorResult(new IllegalArgumentException("Unable to add custom event. Event is invalid."));
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        if (actionArguments.getValue().getMap() != null) {
            if (actionArguments.getValue().getMap().get("event_name") != null) {
                return true;
            }
            UALog.e("CustomEventAction requires an event name in the event data.", new Object[0]);
            return false;
        }
        UALog.e("CustomEventAction requires a map of event data.", new Object[0]);
        return false;
    }

    public static class AddCustomEventActionPredicate implements ActionRegistry.Predicate {
        @Override // com.urbanairship.actions.ActionRegistry.Predicate
        public boolean apply(@NonNull ActionArguments actionArguments) {
            return 1 != actionArguments.getSituation();
        }
    }
}
