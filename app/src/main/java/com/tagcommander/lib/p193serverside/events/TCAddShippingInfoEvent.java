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
public class TCAddShippingInfoEvent extends TCECommerceEvent {
    public String coupon;
    public String shippingTier;
    public Float value;

    public TCAddShippingInfoEvent() {
        this.name = "add_shipping_info";
    }

    public TCAddShippingInfoEvent(@NonNull List<TCItem> list, float f, @NonNull String str) {
        this();
        this.value = Float.valueOf(f);
        this.currency = str;
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent, com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return (this.items.size() > 0) & TCUtils.testString(this.currency) & (this.value != null);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.currency)) {
                jsonObject.put(TCEventPropertiesNames.TCE_CURRENCY, this.currency);
            }
            Float f = this.value;
            if (f != null) {
                jsonObject.put("value", f);
            }
            if (testString(this.coupon)) {
                jsonObject.put("coupon", this.coupon);
            }
            if (testString(this.shippingTier)) {
                jsonObject.put(TCEventPropertiesNames.TCE_SHIPPINGTIER, this.shippingTier);
            }
            if (this.items.size() > 0) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMS, getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCAddShippingInfoEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
