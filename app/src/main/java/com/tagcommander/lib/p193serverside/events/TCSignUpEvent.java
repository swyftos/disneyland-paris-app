package com.tagcommander.lib.p193serverside.events;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.p193serverside.events.base.TCEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCSignUpEvent extends TCEvent {
    public String method;

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return true;
    }

    public TCSignUpEvent() {
        this.name = "sign_up";
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.method)) {
                jsonObject.put(TCEventPropertiesNames.TCE_METHOD, this.method);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSignUpEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
