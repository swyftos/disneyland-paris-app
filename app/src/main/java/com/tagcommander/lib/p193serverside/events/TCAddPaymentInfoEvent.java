package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCAddPaymentInfoEvent extends TCECommerceEvent {
    public String coupon;
    public String paymentMethod;
    public Float revenue;

    public TCAddPaymentInfoEvent() {
        this.name = "add_payment_info";
    }

    public TCAddPaymentInfoEvent(@NonNull String str) {
        this();
        this.paymentMethod = str;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent, com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.paymentMethod);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.paymentMethod)) {
                jsonObject.put(TCEventPropertiesNames.TCE_PAYMENTMETHOD, this.paymentMethod);
            }
            if (testString(this.coupon)) {
                jsonObject.put("coupon", this.coupon);
            }
            Float f = this.revenue;
            if (f != null) {
                jsonObject.put(TCEventPropertiesNames.TCE_REVENUE, f);
            }
            if (testString(this.currency)) {
                jsonObject.put(TCEventPropertiesNames.TCE_CURRENCY, this.currency);
            }
            if (this.items.size() > 0) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMS, getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCAddPaymentInfoEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
