package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.p193serverside.events.base.TCEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCPageViewEvent extends TCEvent {
    public TCPageViewEvent() {
        this.name = "page_view";
    }

    public TCPageViewEvent(@NonNull String str) {
        this();
        this.pageType = str;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return testString(this.pageType);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
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
