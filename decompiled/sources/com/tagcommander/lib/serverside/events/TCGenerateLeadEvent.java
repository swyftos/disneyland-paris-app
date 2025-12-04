package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCGenerateLeadEvent extends TCEvent {
    public String ID;
    public String currency;
    public Float value;

    public TCGenerateLeadEvent() {
        this.name = FirebaseAnalytics.Event.GENERATE_LEAD;
    }

    public TCGenerateLeadEvent(float f, @NonNull String str) {
        this();
        this.value = Float.valueOf(f);
        this.currency = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        if (this.value == null || TCUtils.testString(this.currency)) {
            return (this.value == null && TCUtils.testString(this.currency)) ? false : true;
        }
        return false;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            Float f = this.value;
            if (f != null) {
                jsonObject.put("value", f);
            }
            if (testString(this.currency)) {
                jsonObject.put("currency", this.currency);
            }
            if (testString(this.ID)) {
                jsonObject.put("id", this.ID);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCGenerateLeadEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
