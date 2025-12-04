package com.tagcommander.lib.serverside.events;

import androidx.annotation.NonNull;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tagcommander.lib.core.TCLogger;
import com.tagcommander.lib.core.TCUtils;
import com.tagcommander.lib.serverside.events.base.TCECommerceEvent;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCItem;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCPurchaseEvent extends TCECommerceEvent {
    public String ID;
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
        this.name = FirebaseAnalytics.Event.PURCHASE;
    }

    public TCPurchaseEvent(@NonNull String str, float f, float f2, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @NonNull List<TCItem> list) {
        this();
        this.ID = str;
        this.revenue = Float.valueOf(f);
        this.value = Float.valueOf(f2);
        this.currency = str2;
        this.type = str3;
        this.paymentMethod = str4;
        this.status = str5;
        this.items.addAll(list);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCECommerceEvent, com.tagcommander.lib.serverside.events.base.TCEvent
    public boolean verifyEvent() {
        return TCUtils.testString(this.ID) & TCUtils.testString(this.currency) & TCUtils.testString(this.type) & TCUtils.testString(this.paymentMethod) & TCUtils.testString(this.status) & (this.revenue != null) & (this.value != null) & (this.items.size() > 0);
    }

    @Override // com.tagcommander.lib.serverside.events.base.TCEvent
    public JSONObject getJsonObject() throws JSONException {
        JSONObject jsonObject = super.getJsonObject();
        try {
            if (testString(this.ID)) {
                jsonObject.put("id", this.ID);
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
                jsonObject.put("currency", this.currency);
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
                jsonObject.put("items", getItemListAsJson(this.items));
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("TCPurchaseEvent: Error putting information in JSON Object: " + e.getMessage(), 6);
        }
        return jsonObject;
    }
}
