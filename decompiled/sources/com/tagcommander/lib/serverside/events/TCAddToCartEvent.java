package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCAddToCartEvent extends TCECommerceEvent {
    public Float value;

    public TCAddToCartEvent() {
        this.name = FirebaseAnalytics.Event.ADD_TO_CART;
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

    @Override // com.tagcommander.lib.serverside.events.base.TCECommerceEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        boolean z = this.items.size() > 0;
        if (this.value == null || TCUtils.testString(this.currency)) {
            return z;
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
            if (this.items.size() > 0) {
                jsonObject.put("items", getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCAddToCartEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
