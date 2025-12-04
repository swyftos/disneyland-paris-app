package com.urbanairship.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.analytics.CustomEvent;
import java.math.BigDecimal;

/* loaded from: classes4.dex */
public class AccountEventTemplate {

    @NonNull
    public static final String ACCOUNT_EVENT_TEMPLATE = "account";

    @NonNull
    public static final String LOGGED_IN = "logged_in";

    @NonNull
    public static final String LOGGED_OUT = "logged_out";

    @NonNull
    public static final String REGISTERED_ACCOUNT_EVENT = "registered_account";
    private String category;
    private final String eventName;
    private String transactionId;
    private String type;
    private String userId;
    private BigDecimal value;

    private AccountEventTemplate(String str) {
        this.eventName = str;
    }

    @NonNull
    public static AccountEventTemplate newRegisteredTemplate() {
        return new AccountEventTemplate(REGISTERED_ACCOUNT_EVENT);
    }

    @NonNull
    public static AccountEventTemplate newLoggedInTemplate() {
        return new AccountEventTemplate(LOGGED_IN);
    }

    @NonNull
    public static AccountEventTemplate newLoggedOutTemplate() {
        return new AccountEventTemplate(LOGGED_OUT);
    }

    @NonNull
    public AccountEventTemplate setTransactionId(@Nullable String str) {
        this.transactionId = str;
        return this;
    }

    @NonNull
    public AccountEventTemplate setValue(@Nullable BigDecimal bigDecimal) {
        this.value = bigDecimal;
        return this;
    }

    @NonNull
    public AccountEventTemplate setValue(double d) {
        return setValue(BigDecimal.valueOf(d));
    }

    @NonNull
    public AccountEventTemplate setValue(@Nullable String str) {
        if (str == null || str.length() == 0) {
            this.value = null;
            return this;
        }
        return setValue(new BigDecimal(str));
    }

    @NonNull
    public AccountEventTemplate setValue(int i) {
        return setValue(new BigDecimal(i));
    }

    @NonNull
    public AccountEventTemplate setCategory(@Nullable String str) {
        this.category = str;
        return this;
    }

    @NonNull
    public AccountEventTemplate setUserId(String str) {
        this.userId = str;
        return this;
    }

    @NonNull
    public AccountEventTemplate setType(String str) {
        this.type = str;
        return this;
    }

    @NonNull
    public CustomEvent createEvent() {
        CustomEvent.Builder builderNewBuilder = CustomEvent.newBuilder(this.eventName);
        BigDecimal bigDecimal = this.value;
        if (bigDecimal != null) {
            builderNewBuilder.setEventValue(bigDecimal);
            builderNewBuilder.addProperty("ltv", true);
        } else {
            builderNewBuilder.addProperty("ltv", false);
        }
        String str = this.transactionId;
        if (str != null) {
            builderNewBuilder.setTransactionId(str);
        }
        String str2 = this.category;
        if (str2 != null) {
            builderNewBuilder.addProperty("category", str2);
        }
        String str3 = this.userId;
        if (str3 != null) {
            builderNewBuilder.addProperty("user_id", str3);
        }
        String str4 = this.type;
        if (str4 != null) {
            builderNewBuilder.addProperty("type", str4);
        }
        builderNewBuilder.setTemplateType("account");
        return builderNewBuilder.build();
    }
}
