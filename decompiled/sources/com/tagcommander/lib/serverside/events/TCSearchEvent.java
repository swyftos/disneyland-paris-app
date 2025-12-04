package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCSearchEvent extends TCEvent {
    public String searchTerm;

    public TCSearchEvent() {
        this.name = "search";
    }

    public TCSearchEvent(@NonNull String str) {
        this();
        this.searchTerm = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.searchTerm);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.searchTerm)) {
                jsonObject.put("search_term", this.searchTerm);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSearchEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
