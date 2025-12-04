package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCAddPaymentInfoEvent extends TCECommerceEvent {
    public String coupon;
    public String paymentMethod;
    public Float revenue;

    public TCAddPaymentInfoEvent() {
        this.name = FirebaseAnalytics.Event.ADD_PAYMENT_INFO;
    }

    public TCAddPaymentInfoEvent(@NonNull String str) {
        this();
        this.paymentMethod = str;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCECommerceEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.paymentMethod);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
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
                jsonObject.put("currency", this.currency);
            }
            if (this.items.size() > 0) {
                jsonObject.put("items", getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCAddPaymentInfoEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
