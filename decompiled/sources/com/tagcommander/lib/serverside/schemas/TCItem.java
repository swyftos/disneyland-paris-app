package com.tagcommander.lib.serverside.schemas;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCItem extends TCAdditionalProperties {
    public String ID;
    public String affiliation;
    public String coupon;
    public Float discount;
    public Integer list_position;
    public TCProduct product;
    public Integer quantity;
    public String variant;

    public TCItem() {
        this.product = new TCProduct();
    }

    public TCItem(String str, TCProduct tCProduct, int i) {
        this.ID = str;
        this.product = tCProduct;
        this.quantity = Integer.valueOf(i);
    }

    public boolean verifyItem() {
        boolean zTestString = TCUtils.testString(this.ID);
        TCProduct tCProduct = this.product;
        return zTestString & (tCProduct != null && tCProduct.verifyProduct()) & (this.quantity != null);
    }

    public JSONObject getJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString("id", this.ID, jSONObject);
            TCUtils.setString("variant", this.variant, jSONObject);
            TCUtils.setString("coupon", this.coupon, jSONObject);
            TCUtils.setString("affiliation", this.affiliation, jSONObject);
            TCUtils.setInteger("quantity", this.quantity, jSONObject);
            TCUtils.setInteger(TCEventPropertiesNames.TCI_LISTPOSITION, this.list_position, jSONObject);
            TCUtils.setFloat("discount", this.discount, jSONObject);
            TCProduct tCProduct = this.product;
            if (tCProduct != null) {
                jSONObject.put(TCEventPropertiesNames.TCI_PRODUCT, tCProduct.getJsonObject());
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCItem: Error creating JSON Object: " + e.getMessage(), 6);
        }
        return jSONObject;
    }
}
