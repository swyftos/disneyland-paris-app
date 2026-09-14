package com.tagcommander.lib.p193serverside.events;

import androidx.annotation.NonNull;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.p193serverside.schemas.TCItem;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class TCPurchaseEvent extends TCECommerceEvent {

    /* JADX INFO: renamed from: ID */
    public String f3704ID;
    public String coupon;
    public String paymentMethod;
    public Float revenue;
    public Float shippingAmount;
    public String status;
    public Float taxAmount;
    public String type;
    public String url;
    public Float value;

    public TCPurchaseEvent() {
        this.name = "purchase";
    }

    public TCPurchaseEvent(@NonNull String str, float f, float f2, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull List<TCItem> list) {
        this();
        this.f3704ID = str;
        this.revenue = Float.valueOf(f);
        this.value = Float.valueOf(f2);
        this.currency = str2;
        this.type = str3;
        this.paymentMethod = str4;
        this.status = str5;
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCECommerceEvent, com.tagcommander.lib.p193serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.f3704ID) & TCUtils.testString(this.currency) & TCUtils.testString(this.type) & TCUtils.testString(this.paymentMethod) & TCUtils.testString(this.status) & (this.revenue != null) & (this.value != null) & (this.items.size() > 0);
    }

    @Override // com.tagcommander.lib.p193serverside.events.base.TCEvent
    public JSONObject getJsonObject() {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.f3704ID)) {
                jsonObject.put("id", this.f3704ID);
            }
            Float f = this.revenue;
            if (f != null) {
                jsonObject.put(TCEventPropertiesNames.TCE_REVENUE, f);
            }
            Float f2 = this.value;
            if (f2 != null) {
                jsonObject.put("value", f2);
            }
            Float f3 = this.shippingAmount;
            if (f3 != null) {
                jsonObject.put(TCEventPropertiesNames.TCE_SHIPPINGAMOUNT, f3);
            }
            Float f4 = this.taxAmount;
            if (f4 != null) {
                jsonObject.put(TCEventPropertiesNames.TCE_TAXAMOUNT, f4);
            }
            if (testString(this.currency)) {
                jsonObject.put(TCEventPropertiesNames.TCE_CURRENCY, this.currency);
            }
            if (testString(this.coupon)) {
                jsonObject.put("coupon", this.coupon);
            }
            if (testString(this.type)) {
                jsonObject.put("type", this.type);
            }
            if (testString(this.paymentMethod)) {
                jsonObject.put(TCEventPropertiesNames.TCE_PAYMENTMETHOD, this.paymentMethod);
            }
            if (testString(this.status)) {
                jsonObject.put("status", this.status);
            }
            if (testString(this.url)) {
                jsonObject.put("url", this.url);
            }
            if (this.items.size() > 0) {
                jsonObject.put(TCEventPropertiesNames.TCE_ITEMS, getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCPurchaseEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
