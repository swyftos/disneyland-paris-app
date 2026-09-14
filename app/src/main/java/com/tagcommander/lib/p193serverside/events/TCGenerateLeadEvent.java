package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.p193serverside.events.base.TCEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCGenerateLeadEvent extends TCEvent {

    /* JADX INFO: renamed from: ID */
    public String f3703ID;
    public String currency;
    public Float value;

    public TCGenerateLeadEvent() {
        this.name = "generate_lead";
    }

    public TCGenerateLeadEvent(float f, @NonNull String str) {
        this();
        this.value = Float.valueOf(f);
        this.currency = str;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        if (this.value == null || TCUtils.testString(this.currency)) {
            return (this.value == null && TCUtils.testString(this.currency)) ? false : true;
        }
        return false;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            Float f = this.value;
            if (f != null) {
                jsonObject.put("value", f);
            }
            if (testString(this.currency)) {
                jsonObject.put(TCEventPropertiesNames.TCE_CURRENCY, this.currency);
            }
            if (testString(this.f3703ID)) {
                jsonObject.put("id", this.f3703ID);
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCGenerateLeadEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
