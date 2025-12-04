package com.tagcommander.lib.serverside.events;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCSelectContentEvent extends TCEvent {
    public String contentType;
    public String itemID;

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return true;
    }

    public TCSelectContentEvent() {
        this.name = FirebaseAnalytics.Event.SELECT_CONTENT;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.contentType)) {
                jsonObject.put("content_type", this.contentType);
            }
            if (testString(this.itemID)) {
                jsonObject.put("item_id", this.itemID);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSelectContentEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
