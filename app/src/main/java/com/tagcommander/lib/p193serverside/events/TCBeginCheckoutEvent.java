package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.p193serverside.schemas.TCItem;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCBeginCheckoutEvent extends TCECommerceEvent {
    public String coupon;
    public Float revenue;
    public Float value;

    public TCBeginCheckoutEvent() {
        this.name = "begin_checkout";
    }

    public TCBeginCheckoutEvent(float f, float f2, @NonNull String str, @NonNull List<TCItem> list) {
        this();
        this.revenue = Float.valueOf(f);
        this.value = Float.valueOf(f2);
        this.currency = str;
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent, com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.currency) & (this.items.size() > 0) & (this.revenue != null) & (this.value != null);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
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
                jsonObject.put(TCEventPropertiesNames.TCE_CURRENCY, this.currency);
            }
            if (testString(this.coupon)) {
                jsonObject.put("coupon", this.coupon);
            }
            if (this.items.size() > 0) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMS, getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCBeginCheckoutEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
