package com.tagcommander.lib.p193serverside.schemas;

import com.tagcommander.lib.core.TCAdditionalProperties;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCItem extends TCAdditionalProperties {

    /* JADX INFO: renamed from: ID */
    public String f3706ID;
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
        this.f3706ID = str;
        this.product = tCProduct;
        this.quantity = Integer.valueOf(i);
    }

    public boolean verifyItem() {
        boolean zTestString = TCUtils.testString(this.f3706ID);
        TCProduct tCProduct = this.product;
        return zTestString & (tCProduct != null && tCProduct.verifyProduct()) & (this.quantity != null);
    }

    public JSONObject getJsonObject() {
        JSONObject jSONObject = new JSONObject(getAdditionalProperties());
        try {
            TCUtils.setString("id", this.f3706ID, jSONObject);
            TCUtils.setString("variant", this.variant, jSONObject);
            TCUtils.setString("coupon", this.coupon, jSONObject);
            TCUtils.setString(TCEventPropertiesNames.TCI_AFFILIATION, this.affiliation, jSONObject);
            TCUtils.setInteger(TCEventPropertiesNames.TCI_QUANTITY, this.quantity, jSONObject);
            TCUtils.setInteger(TCEventPropertiesNames.TCI_LISTPOSITION, this.list_position, jSONObject);
            TCUtils.setFloat(TCEventPropertiesNames.TCI_DISCOUNT, this.discount, jSONObject);
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
