package com.tagcommander.lib.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class TCAdditionalProperties {
    final ConcurrentHashMap additionalProperties = new ConcurrentHashMap();

    public void addAdditionalProperty(String str, String str2) {
        this.additionalProperties.put(str, str2);
    }

    public void addAdditionalProperty(String str, JSONObject jSONObject) {
        this.additionalProperties.put(str, jSONObject);
    }

    public void addAdditionalProperty(String str, Boolean bool) {
        this.additionalProperties.put(str, bool);
    }

    public void addAdditionalProperty(String str, BigDecimal bigDecimal) {
        this.additionalProperties.put(str, bigDecimal);
    }

    public void addAdditionalProperty(String str, Float f) {
        this.additionalProperties.put(str, f);
    }

    public void addAdditionalProperty(String str, Integer num) {
        this.additionalProperties.put(str, num);
    }

    public void addAdditionalProperty(String str, List<JSONObject> list) {
        this.additionalProperties.put(str, list);
    }

    public ConcurrentHashMap<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void removeAdditionalProperty(String str) {
        this.additionalProperties.remove(str);
    }

    public void clearAdditionalProperties() {
        this.additionalProperties.clear();
    }

    public void addAdditionalProperty(TCDynamicStore tCDynamicStore) {
        if (tCDynamicStore != null) {
            for (String str : tCDynamicStore.orderedKeys) {
                this.additionalProperties.put(str, tCDynamicStore.getData(str));
            }
            for (String str2 : tCDynamicStore.orderedJsonKeys) {
                this.additionalProperties.put(str2, tCDynamicStore.getJsonData(str2));
            }
        }
    }
}
