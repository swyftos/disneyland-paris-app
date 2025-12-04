package com.tagcommander.lib.serverside.events.base;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCDynamicStore;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class TCEvent extends TCAdditionalProperties {
    protected String name;
    public String pageName;
    public String pageType;

    public abstract boolean verifyEvent();

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("event_name", this.name);
            jSONObject2.put(TCEventPropertiesNames.TCE_EVENTID, UUID.randomUUID().toString());
            jSONObject.put("context", jSONObject2);
            if (testString(this.pageType)) {
                jSONObject.put(TCEventPropertiesNames.TCPAGE_TYPE, this.pageType);
            }
            if (testString(this.pageName)) {
                jSONObject.put(TCEventPropertiesNames.TCPAGE_NAME, this.pageName);
            }
        } catch (JSONException e) {
            TCLogger.getInstance().logMessage("Error converting event to JSON: " + e.getLocalizedMessage(), 6);
        }
        return jSONObject;
    }

    public boolean testString(String str) {
        return TCUtils.testString(str);
    }

    public String getName() {
        return this.name;
    }

    public JSONArray getItemListAsJson(List<TCItem> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(i, list.get(i).getJsonObject());
            } catch (JSONException e) {
                TCLogger.getInstance().logMessage("Error converting item list to JSON: " + e.getLocalizedMessage(), 6);
            }
        }
        return jSONArray;
    }

    public JSONArray getListAsJson(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(i, list.get(i));
            } catch (JSONException e) {
                TCLogger.getInstance().logMessage("Error converting string list to JSON: " + e.getLocalizedMessage(), 6);
            }
        }
        return jSONArray;
    }

    @Deprecated
    public void addAdditionalParameter(TCDynamicStore tCDynamicStore) {
        addAdditionalProperty(tCDynamicStore);
    }

    @Deprecated
    public void addAdditionalParameter(String str, String str2) {
        addAdditionalProperty(str, str2);
    }

    @Deprecated
    public void addAdditionalParameter(String str, JSONObject jSONObject) {
        addAdditionalProperty(str, jSONObject);
    }
}
