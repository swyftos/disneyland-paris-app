package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCPageViewEvent extends TCEvent {
    public TCPageViewEvent() {
        this.name = "page_view";
    }

    public TCPageViewEvent(@NonNull String str) {
        this();
        this.pageType = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return testString(this.pageType);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.pageType)) {
                jsonObject.put(TCEventPropertiesNames.TCPAGE_TYPE, this.pageType);
            }
            if (testString(this.pageName)) {
                jsonObject.put(TCEventPropertiesNames.TCPAGE_NAME, this.pageName);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCPageViewEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
