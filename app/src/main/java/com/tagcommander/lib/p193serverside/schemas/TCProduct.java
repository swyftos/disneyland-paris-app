package com.tagcommander.lib.p193serverside.schemas;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCProduct extends TCAdditionalProperties {

    /* JADX INFO: renamed from: ID */
    public String f3707ID;
    public String brand;
    public List<String> categories;
    public List<String> colors;
    public String currency;
    public String name;
    public Float price;
    public String size;

    public TCProduct() {
        this.categories = new ArrayList();
        this.colors = new ArrayList();
    }

    public TCProduct(String str, String str2, Float f) {
        this();
        this.f3707ID = str;
        this.name = str2;
        this.price = f;
    }

    public boolean verifyProduct() {
        return (this.price != null) & TCUtils.testString(this.f3707ID) & TCUtils.testString(this.name);
    }

    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString("id", this.f3707ID, jSONObject);
            TCUtils.setString("name", this.name, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCE_CURRENCY, this.currency, jSONObject);
            TCUtils.setFloat(TCEventPropertiesNames.TCP_PRICE, this.price, jSONObject);
            int i = 0;
            while (i < this.categories.size()) {
                String str = this.categories.get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(TCEventPropertiesNames.TCP_CATEGORY_N);
                i++;
                sb.append(i);
                TCUtils.setString(sb.toString(), str, jSONObject);
            }
            TCUtils.setString(TCEventPropertiesNames.TCP_BRAND, this.brand, jSONObject);
            if (this.colors.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.colors.size(); i2++) {
                    jSONArray.put(i2, this.colors.get(i2));
                }
                jSONObject.put("colors", jSONArray);
            }
            TCUtils.setString(TCEventPropertiesNames.TCP_SIZE, this.size, jSONObject);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCProduct: Error creating JSON Object: " + e.getMessage(), 6);
        }
        return jSONObject;
    }
}
