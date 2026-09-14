package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.p193serverside.events.base.TCEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCSearchEvent extends TCEvent {
    public String searchTerm;

    public TCSearchEvent() {
        this.name = "search";
    }

    public TCSearchEvent(@NonNull String str) {
        this();
        this.searchTerm = str;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.searchTerm);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.searchTerm)) {
                jsonObject.put(TCEventPropertiesNames.TCE_SEARCHTERM, this.searchTerm);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSearchEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
