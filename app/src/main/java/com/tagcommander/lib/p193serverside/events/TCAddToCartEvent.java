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
public class TCAddToCartEvent extends TCECommerceEvent {
    public Float value;

    public TCAddToCartEvent() {
        this.name = "add_to_cart";
    }

    public TCAddToCartEvent(@NonNull List<TCItem> list) {
        this();
        this.items.addAll(list);
    }

    public TCAddToCartEvent(float f, @NonNull String str, @NonNull List<TCItem> list) {
        this();
        this.value = Float.valueOf(f);
        this.currency = str;
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent, com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        boolean z = this.items.size() > 0;
        if (this.value == null || TCUtils.testString(this.currency)) {
            return z;
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
            if (this.items.size() > 0) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMS, getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCAddToCartEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
