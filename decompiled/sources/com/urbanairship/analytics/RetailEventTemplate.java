package com.urbanairship.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import java.math.BigDecimal;

/* loaded from: classes4.dex */
public class RetailEventTemplate {

    @NonNull
    public static final String ADDED_TO_CART_EVENT = "added_to_cart";

    @NonNull
    public static final String BROWSED_PRODUCT_EVENT = "browsed";

    @NonNull
    public static final String PURCHASED_EVENT = "purchased";

    @NonNull
    public static final String RETAIL_EVENT_TEMPLATE = "retail";

    @NonNull
    public static final String SHARED_PRODUCT_EVENT = "shared_product";

    @NonNull
    public static final String STARRED_PRODUCT_EVENT = "starred_product";

    @NonNull
    public static final String WISHLIST_EVENT = "wishlist";
    private String brand;
    private String category;
    private String currency;
    private String description;
    private final String eventName;
    private String id;
    private String medium;
    private boolean newItem;
    private boolean newItemSet;
    private String source;
    private String transactionId;
    private BigDecimal value;
    private String wishlistId;
    private String wishlistName;

    private RetailEventTemplate(String str) {
        this.eventName = str;
    }

    private RetailEventTemplate(String str, String str2, String str3, String str4, String str5) {
        this.eventName = str;
        this.source = str2;
        this.medium = str3;
        this.wishlistName = str4;
        this.wishlistId = str5;
    }

    @NonNull
    public static RetailEventTemplate newBrowsedTemplate() {
        return new RetailEventTemplate(BROWSED_PRODUCT_EVENT);
    }

    @NonNull
    public static RetailEventTemplate newAddedToCartTemplate() {
        return new RetailEventTemplate(ADDED_TO_CART_EVENT);
    }

    @NonNull
    public static RetailEventTemplate newStarredProductTemplate() {
        return new RetailEventTemplate(STARRED_PRODUCT_EVENT);
    }

    @NonNull
    public static RetailEventTemplate newSharedProductTemplate() {
        return new RetailEventTemplate(SHARED_PRODUCT_EVENT);
    }

    @NonNull
    public static RetailEventTemplate newSharedProductTemplate(@Nullable String str, @Nullable String str2) {
        return new RetailEventTemplate(SHARED_PRODUCT_EVENT, str, str2, null, null);
    }

    @NonNull
    public static RetailEventTemplate newWishlistTemplate() {
        return new RetailEventTemplate(WISHLIST_EVENT);
    }

    @NonNull
    public static RetailEventTemplate newWishlistTemplate(@Nullable String str, @Nullable String str2) {
        return new RetailEventTemplate(WISHLIST_EVENT, null, null, str, str2);
    }

    @NonNull
    public static RetailEventTemplate newPurchasedTemplate() {
        return new RetailEventTemplate(PURCHASED_EVENT);
    }

    @NonNull
    public RetailEventTemplate setTransactionId(@Nullable String str) {
        this.transactionId = str;
        return this;
    }

    @NonNull
    public RetailEventTemplate setValue(@Nullable BigDecimal bigDecimal) {
        this.value = bigDecimal;
        return this;
    }

    @NonNull
    public RetailEventTemplate setValue(double d) {
        return setValue(BigDecimal.valueOf(d));
    }

    @NonNull
    public RetailEventTemplate setValue(@Nullable String str) {
        if (str == null || str.length() == 0) {
            this.value = null;
            return this;
        }
        return setValue(new BigDecimal(str));
    }

    @NonNull
    public RetailEventTemplate setValue(int i) {
        return setValue(new BigDecimal(i));
    }

    @NonNull
    public RetailEventTemplate setId(@Nullable String str) {
        this.id = str;
        return this;
    }

    @NonNull
    public RetailEventTemplate setCategory(@Nullable String str) {
        this.category = str;
        return this;
    }

    @NonNull
    public RetailEventTemplate setDescription(@Nullable String str) {
        this.description = str;
        return this;
    }

    @NonNull
    public RetailEventTemplate setCurrency(@Nullable String str) {
        this.currency = str;
        return this;
    }

    @NonNull
    public RetailEventTemplate setBrand(@Nullable String str) {
        this.brand = str;
        return this;
    }

    @NonNull
    public RetailEventTemplate setNewItem(boolean z) {
        this.newItem = z;
        this.newItemSet = true;
        return this;
    }

    @NonNull
    public CustomEvent createEvent() {
        CustomEvent.Builder builderNewBuilder = CustomEvent.newBuilder(this.eventName);
        BigDecimal bigDecimal = this.value;
        if (bigDecimal != null) {
            builderNewBuilder.setEventValue(bigDecimal);
        }
        if (PURCHASED_EVENT.equals(this.eventName) && this.value != null) {
            builderNewBuilder.addProperty("ltv", true);
        } else {
            builderNewBuilder.addProperty("ltv", false);
        }
        String str = this.transactionId;
        if (str != null) {
            builderNewBuilder.setTransactionId(str);
        }
        String str2 = this.id;
        if (str2 != null) {
            builderNewBuilder.addProperty("id", str2);
        }
        String str3 = this.category;
        if (str3 != null) {
            builderNewBuilder.addProperty("category", str3);
        }
        String str4 = this.description;
        if (str4 != null) {
            builderNewBuilder.addProperty("description", str4);
        }
        String str5 = this.brand;
        if (str5 != null) {
            builderNewBuilder.addProperty(TCEventPropertiesNames.TCP_BRAND, str5);
        }
        if (this.newItemSet) {
            builderNewBuilder.addProperty("new_item", this.newItem);
        }
        String str6 = this.source;
        if (str6 != null) {
            builderNewBuilder.addProperty("source", str6);
        }
        String str7 = this.medium;
        if (str7 != null) {
            builderNewBuilder.addProperty("medium", str7);
        }
        String str8 = this.wishlistName;
        if (str8 != null) {
            builderNewBuilder.addProperty("wishlist_name", str8);
        }
        String str9 = this.wishlistId;
        if (str9 != null) {
            builderNewBuilder.addProperty("wishlist_id", str9);
        }
        String str10 = this.currency;
        if (str10 != null) {
            builderNewBuilder.addProperty("currency", str10);
        }
        builderNewBuilder.setTemplateType("retail");
        return builderNewBuilder.build();
    }
}
