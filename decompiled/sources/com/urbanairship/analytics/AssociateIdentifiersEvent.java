package com.urbanairship.analytics;

import com.urbanairship.UALog;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.Map;

/* loaded from: classes4.dex */
class AssociateIdentifiersEvent extends Event {
    private final Map ids;

    AssociateIdentifiersEvent(AssociatedIdentifiers associatedIdentifiers) {
        this.ids = associatedIdentifiers.getIds();
    }

    @Override // com.urbanairship.analytics.Event
    public EventType getType() {
        return EventType.ASSOCIATE_IDENTIFIERS;
    }

    @Override // com.urbanairship.analytics.Event
    public boolean isValid() {
        boolean z;
        if (this.ids.size() > 100) {
            UALog.e("Associated identifiers exceeds %s", 100);
            z = false;
        } else {
            z = true;
        }
        for (Map.Entry entry : this.ids.entrySet()) {
            if (((String) entry.getKey()).length() > 255) {
                UALog.e("Associated identifiers key %s exceeds %s characters.", entry.getKey(), 255);
                z = false;
            }
            if (((String) entry.getValue()).length() > 255) {
                UALog.e("Associated identifiers for key %s exceeds %s characters.", entry.getKey(), 255);
                z = false;
            }
        }
        return z;
    }

    @Override // com.urbanairship.analytics.Event
    public JsonMap getEventData(ConversionData conversionData) {
        return JsonValue.wrapOpt(this.ids).optMap();
    }
}
