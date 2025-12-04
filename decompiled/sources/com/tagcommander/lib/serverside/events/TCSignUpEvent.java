package com.tagcommander.lib.serverside.events;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCSignUpEvent extends TCEvent {
    public String method;

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return true;
    }

    public TCSignUpEvent() {
        this.name = FirebaseAnalytics.Event.SIGN_UP;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.method)) {
                jsonObject.put("method", this.method);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSignUpEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
