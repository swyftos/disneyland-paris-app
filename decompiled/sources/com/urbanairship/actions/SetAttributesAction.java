package com.urbanairship.actions;

import androidx.annotation.NonNull;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionRegistry;
import com.urbanairship.channel.AttributeEditor;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.JsonValue;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public class SetAttributesAction extends Action {

    @NonNull
    public static final String DEFAULT_REGISTRY_NAME = "set_attributes_action";

    @NonNull
    public static final String DEFAULT_REGISTRY_SHORT_NAME = "^a";

    @Override // com.urbanairship.actions.Action
    @NonNull
    public ActionResult perform(@NonNull ActionArguments actionArguments) throws IllegalArgumentException {
        if (actionArguments.getValue().getMap() != null) {
            if (actionArguments.getValue().getMap().containsKey(TCVideoEventPropertiesNames.TCV_CHANNEL)) {
                AttributeEditor attributeEditorEditAttributes = UAirship.shared().getChannel().editAttributes();
                Iterator<Map.Entry<String, JsonValue>> it = actionArguments.getValue().getMap().opt(TCVideoEventPropertiesNames.TCV_CHANNEL).optMap().getMap().entrySet().iterator();
                while (it.hasNext()) {
                    handleAttributeActions(attributeEditorEditAttributes, it.next());
                }
                attributeEditorEditAttributes.apply();
            }
            if (actionArguments.getValue().getMap().containsKey(FetchDeviceInfoAction.NAMED_USER_ID_KEY)) {
                AttributeEditor attributeEditorEditAttributes2 = UAirship.shared().getContact().editAttributes();
                Iterator<Map.Entry<String, JsonValue>> it2 = actionArguments.getValue().getMap().opt(FetchDeviceInfoAction.NAMED_USER_ID_KEY).optMap().getMap().entrySet().iterator();
                while (it2.hasNext()) {
                    handleAttributeActions(attributeEditorEditAttributes2, it2.next());
                }
                attributeEditorEditAttributes2.apply();
            }
        }
        return ActionResult.newEmptyResult();
    }

    @Override // com.urbanairship.actions.Action
    public boolean acceptsArguments(@NonNull ActionArguments actionArguments) {
        if (actionArguments.getValue().isNull() || actionArguments.getValue().getMap() == null) {
            return false;
        }
        JsonValue jsonValueOpt = actionArguments.getValue().getMap().opt(TCVideoEventPropertiesNames.TCV_CHANNEL);
        JsonValue jsonValue = JsonValue.NULL;
        if (jsonValueOpt != jsonValue && !areAttributeMutationsValid(jsonValueOpt)) {
            return false;
        }
        JsonValue jsonValueOpt2 = actionArguments.getValue().getMap().opt(FetchDeviceInfoAction.NAMED_USER_ID_KEY);
        if (jsonValueOpt2 == jsonValue || areAttributeMutationsValid(jsonValueOpt2)) {
            return (jsonValueOpt == jsonValue && jsonValueOpt2 == jsonValue) ? false : true;
        }
        return false;
    }

    private boolean areAttributeMutationsValid(JsonValue jsonValue) {
        if (jsonValue.getMap() == null) {
            return false;
        }
        JsonValue jsonValueOpt = jsonValue.optMap().opt(AttributeMutation.ATTRIBUTE_ACTION_SET);
        JsonValue jsonValue2 = JsonValue.NULL;
        if (jsonValueOpt != jsonValue2 && !isSetAttributeMutationValid(jsonValueOpt)) {
            return false;
        }
        JsonValue jsonValueOpt2 = jsonValue.optMap().opt(AttributeMutation.ATTRIBUTE_ACTION_REMOVE);
        return jsonValueOpt2 == jsonValue2 || isRemoveAttributeMutationValid(jsonValueOpt2);
    }

    private boolean isSetAttributeMutationValid(JsonValue jsonValue) {
        return jsonValue.getMap() != null;
    }

    private boolean isRemoveAttributeMutationValid(JsonValue jsonValue) {
        return jsonValue.getList() != null;
    }

    private void handleAttributeActions(AttributeEditor attributeEditor, Map.Entry entry) throws IllegalArgumentException {
        String str = (String) entry.getKey();
        str.hashCode();
        if (str.equals(AttributeMutation.ATTRIBUTE_ACTION_REMOVE)) {
            Iterator<JsonValue> it = ((JsonValue) entry.getValue()).optList().getList().iterator();
            while (it.hasNext()) {
                attributeEditor.removeAttribute(it.next().optString());
            }
        } else if (str.equals(AttributeMutation.ATTRIBUTE_ACTION_SET)) {
            for (Map.Entry<String, JsonValue> entry2 : ((JsonValue) entry.getValue()).optMap().entrySet()) {
                setAttribute(attributeEditor, entry2.getKey(), entry2.getValue().getValue());
            }
        }
    }

    private void setAttribute(AttributeEditor attributeEditor, String str, Object obj) throws IllegalArgumentException {
        if (obj instanceof Integer) {
            attributeEditor.setAttribute(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            attributeEditor.setAttribute(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            attributeEditor.setAttribute(str, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            attributeEditor.setAttribute(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            attributeEditor.setAttribute(str, (String) obj);
        } else if (obj instanceof Date) {
            attributeEditor.setAttribute(str, (Date) obj);
        } else {
            UALog.w("SetAttributesAction - Invalid value type for the key: %s", str);
        }
    }

    public static class SetAttributesPredicate implements ActionRegistry.Predicate {
        @Override // com.urbanairship.actions.ActionRegistry.Predicate
        public boolean apply(@NonNull ActionArguments actionArguments) {
            return 1 != actionArguments.getSituation();
        }
    }
}
