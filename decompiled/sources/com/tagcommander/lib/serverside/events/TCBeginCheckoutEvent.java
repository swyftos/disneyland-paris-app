package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCBeginCheckoutEvent extends TCECommerceEvent {
    public String coupon;
    public Float revenue;
    public Float value;

    public TCBeginCheckoutEvent() {
        this.name = FirebaseAnalytics.Event.BEGIN_CHECKOUT;
    }

    public TCBeginCheckoutEvent(float f, float f2, @NonNull String str, @NonNull List<TCItem> list) {
        this();
        this.revenue = Float.valueOf(f);
        this.value = Float.valueOf(f2);
        this.currency = str;
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCECommerceEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.currency) & (this.items.size() > 0) & (this.revenue != null) & (this.value != null);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            Float f = this.revenue;
            if (f != null) {
                jsonObject.put(TCEventPropertiesNames.TCE_REVENUE, f);
            }
            Float f2 = this.value;
            if (f2 != null) {
                jsonObject.put("value", f2);
            }
            if (testString(this.currency)) {
                jsonObject.put("currency", this.currency);
            }
            if (testString(this.coupon)) {
                jsonObject.put("coupon", this.coupon);
            }
            if (this.items.size() > 0) {
                jsonObject.put("items", getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCBeginCheckoutEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
