package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.p193serverside.events.base.TCEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.p193serverside.schemas.TCItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCSelectItemEvent extends TCEvent {
    public String itemListName;
    public List<TCItem> items;

    public TCSelectItemEvent() {
        this.name = "select_item";
        this.items = new ArrayList();
    }

    public TCSelectItemEvent(@NonNull List<TCItem> list) {
        this();
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return this.items.size() > 0;
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.itemListName)) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMLISTNAME, this.itemListName);
            }
            if (this.items.size() > 0) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMS, getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCSelectItemEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
