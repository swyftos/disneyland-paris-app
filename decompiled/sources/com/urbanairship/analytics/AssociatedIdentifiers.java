package com.urbanairship.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.collection.ScatterMapKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.picocontainer.Characteristics;

/* loaded from: classes4.dex */
public class AssociatedIdentifiers implements JsonSerializable {
    public static final int MAX_CHARACTER_COUNT = 255;
    public static final int MAX_IDS = 100;
    private final Map ids;

    AssociatedIdentifiers() {
        this.ids = new HashMap();
    }

    AssociatedIdentifiers(Map map) {
        this.ids = new HashMap(map);
    }

    @NonNull
    public Map<String, String> getIds() {
        return Collections.unmodifiableMap(this.ids);
    }

    @Nullable
    public String getAdvertisingId() {
        return (String) this.ids.get("com.urbanairship.aaid");
    }

    public boolean isLimitAdTrackingEnabled() {
        String str = (String) this.ids.get("com.urbanairship.limited_ad_tracking_enabled");
        return str != null && str.equalsIgnoreCase(Characteristics.TRUE);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public JsonValue toJsonValue() {
        return JsonValue.wrapOpt(this.ids);
    }

    @NonNull
    public static AssociatedIdentifiers fromJson(@NonNull JsonValue jsonValue) throws JsonException {
        HashMap map = new HashMap();
        if (jsonValue.isJsonMap()) {
            Iterator<Map.Entry<String, JsonValue>> it = jsonValue.optMap().iterator();
            while (it.hasNext()) {
                Map.Entry<String, JsonValue> next = it.next();
                map.put(next.getKey(), next.getValue().optString());
            }
            return new AssociatedIdentifiers(map);
        }
        throw new JsonException("Associated identifiers not found in JsonValue: " + jsonValue);
    }

    public static abstract class Editor {
        private boolean clear = false;
        private final Map idsToAdd = new HashMap();
        private final List idsToRemove = new ArrayList();

        abstract void onApply(boolean z, Map map, List list);

        @NonNull
        public Editor setAdvertisingId(@NonNull @Size(max = ScatterMapKt.Sentinel, min = 1) String str, boolean z) {
            addIdentifier("com.urbanairship.aaid", str);
            addIdentifier("com.urbanairship.limited_ad_tracking_enabled", z ? Characteristics.TRUE : "false");
            return this;
        }

        @NonNull
        public Editor removeAdvertisingId() {
            removeIdentifier("com.urbanairship.aaid");
            removeIdentifier("com.urbanairship.limited_ad_tracking_enabled");
            return this;
        }

        @NonNull
        public Editor addIdentifier(@NonNull @Size(max = ScatterMapKt.Sentinel, min = 1) String str, @NonNull @Size(max = ScatterMapKt.Sentinel, min = 1) String str2) {
            this.idsToRemove.remove(str);
            this.idsToAdd.put(str, str2);
            return this;
        }

        @NonNull
        public Editor removeIdentifier(@NonNull @Size(max = ScatterMapKt.Sentinel, min = 1) String str) {
            this.idsToAdd.remove(str);
            this.idsToRemove.add(str);
            return this;
        }

        @NonNull
        public Editor clear() {
            this.clear = true;
            return this;
        }

        public void apply() {
            onApply(this.clear, this.idsToAdd, this.idsToRemove);
        }
    }
}
