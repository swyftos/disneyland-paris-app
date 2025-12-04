package com.urbanairship.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.actions.SearchIntents;
import com.urbanairship.analytics.CustomEvent;
import java.math.BigDecimal;

/* loaded from: classes4.dex */
public class SearchEventTemplate {
    private String category;
    private final String eventName;
    private String id;
    private String query;
    private long total_results;
    private String type;
    private BigDecimal value;

    private SearchEventTemplate(String str) {
        this.eventName = str;
    }

    public static SearchEventTemplate newSearchTemplate() {
        return new SearchEventTemplate("search");
    }

    @NonNull
    public SearchEventTemplate setValue(@Nullable BigDecimal bigDecimal) {
        this.value = bigDecimal;
        return this;
    }

    @NonNull
    public SearchEventTemplate setValue(double d) {
        return setValue(BigDecimal.valueOf(d));
    }

    @NonNull
    public SearchEventTemplate setValue(@Nullable String str) {
        if (str == null || str.length() == 0) {
            this.value = null;
            return this;
        }
        return setValue(new BigDecimal(str));
    }

    @NonNull
    public SearchEventTemplate setValue(int i) {
        return setValue(new BigDecimal(i));
    }

    @NonNull
    public SearchEventTemplate setType(String str) {
        this.type = str;
        return this;
    }

    @NonNull
    public SearchEventTemplate setQuery(String str) {
        this.query = str;
        return this;
    }

    @NonNull
    public SearchEventTemplate setCategory(String str) {
        this.category = str;
        return this;
    }

    @NonNull
    public SearchEventTemplate setId(String str) {
        this.id = str;
        return this;
    }

    @NonNull
    public SearchEventTemplate setTotalResults(long j) {
        this.total_results = j;
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
        String str = this.type;
        if (str != null) {
            builderNewBuilder.addProperty("type", str);
        }
        String str2 = this.query;
        if (str2 != null) {
            builderNewBuilder.addProperty(SearchIntents.EXTRA_QUERY, str2);
        }
        String str3 = this.category;
        if (str3 != null) {
            builderNewBuilder.addProperty("category", str3);
        }
        String str4 = this.id;
        if (str4 != null) {
            builderNewBuilder.addProperty("id", str4);
        }
        builderNewBuilder.addProperty("total_results", this.total_results);
        builderNewBuilder.setTemplateType("search");
        return builderNewBuilder.build();
    }
}
