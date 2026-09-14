package com.tagcommander.lib.p193serverside.events;

import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.p193serverside.events.base.TCEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCSelectContentEvent extends TCEvent {
    public String contentType;
    public String itemID;

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return true;
    }

    public TCSelectContentEvent() {
        this.name = "select_content";
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.contentType)) {
                jsonObject.put(TCEventPropertiesNames.TCE_CONTENTTYPE, this.contentType);
            }
            if (testString(this.itemID)) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMID, this.itemID);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSelectContentEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
