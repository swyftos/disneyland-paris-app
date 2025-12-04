package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCAddToWishlistEvent extends TCECommerceEvent {
    public Float value;

    public TCAddToWishlistEvent() {
        this.name = FirebaseAnalytics.Event.ADD_TO_WISHLIST;
    }

    public TCAddToWishlistEvent(@NonNull List<TCItem> list) {
        this();
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCECommerceEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return this.items.size() > 0;
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
            TCLogger.getInstance().logMessage("TCAddToWishlistEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
