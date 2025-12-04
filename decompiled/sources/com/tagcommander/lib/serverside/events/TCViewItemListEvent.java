package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.serverside.events.base.TCEvent;
import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCViewItemListEvent extends TCEvent {
    public String itemListName;
    public List<TCItem> items;

    public TCViewItemListEvent() {
        this.name = FirebaseAnalytics.Event.VIEW_ITEM_LIST;
        this.items = new ArrayList();
    }

    public TCViewItemListEvent(@NonNull List<TCItem> list) {
        this();
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return this.items.size() > 0;
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.itemListName)) {
                jsonObject.put("item_list_name", this.itemListName);
            }
            if (this.items.size() > 0) {
                jsonObject.put("items", getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCViewItemListEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
