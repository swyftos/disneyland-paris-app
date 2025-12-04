package com.tagcommander.lib.serverside.schemas;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCProduct extends TCAdditionalProperties {
    public String ID;
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
        this.ID = str;
        this.name = str2;
        this.price = f;
    }

    public boolean verifyProduct() {
        return (this.price != null) & TCUtils.testString(this.ID) & TCUtils.testString(this.name);
    }

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString("id", this.ID, jSONObject);
            TCUtils.setString("name", this.name, jSONObject);
            TCUtils.setString("currency", this.currency, jSONObject);
            TCUtils.setFloat("price", this.price, jSONObject);
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
