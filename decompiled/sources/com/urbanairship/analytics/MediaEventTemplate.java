package com.urbanairship.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.urbanairship.analytics.CustomEvent;
import java.math.BigDecimal;

/* loaded from: classes4.dex */
public class MediaEventTemplate {

    @NonNull
    public static final String BROWSED_CONTENT_EVENT = "browsed_content";

    @NonNull
    public static final String CONSUMED_CONTENT_EVENT = "consumed_content";

    @NonNull
    public static final String MEDIA_EVENT_TEMPLATE = "media";

    @NonNull
    public static final String SHARED_CONTENT_EVENT = "shared_content";

    @NonNull
    public static final String STARRED_CONTENT_EVENT = "starred_content";
    private String author;
    private String category;
    private String description;
    private final String eventName;
    private boolean feature;
    private boolean featureSet;
    private String id;
    private String medium;
    private String publishedDate;
    private String source;
    private String type;
    private BigDecimal value;

    private MediaEventTemplate(String str, BigDecimal bigDecimal) {
        this.eventName = str;
        this.value = bigDecimal;
    }

    private MediaEventTemplate(String str, String str2, String str3) {
        this.eventName = str;
        this.source = str2;
        this.medium = str3;
    }

    @NonNull
    public static MediaEventTemplate newStarredTemplate() {
        return new MediaEventTemplate(STARRED_CONTENT_EVENT, null);
    }

    @NonNull
    public static MediaEventTemplate newSharedTemplate() {
        return new MediaEventTemplate(SHARED_CONTENT_EVENT, null);
    }

    @NonNull
    public static MediaEventTemplate newSharedTemplate(@Nullable String str, @Nullable String str2) {
        return new MediaEventTemplate(SHARED_CONTENT_EVENT, str, str2);
    }

    @NonNull
    public static MediaEventTemplate newConsumedTemplate() {
        return new MediaEventTemplate(CONSUMED_CONTENT_EVENT, null);
    }

    @NonNull
    public static MediaEventTemplate newBrowsedTemplate() {
        return new MediaEventTemplate(BROWSED_CONTENT_EVENT, null);
    }

    @NonNull
    public static MediaEventTemplate newConsumedTemplate(@Nullable BigDecimal bigDecimal) {
        return new MediaEventTemplate(CONSUMED_CONTENT_EVENT, bigDecimal);
    }

    @NonNull
    public static MediaEventTemplate newConsumedTemplate(double d) {
        return new MediaEventTemplate(CONSUMED_CONTENT_EVENT, BigDecimal.valueOf(d));
    }

    @NonNull
    public static MediaEventTemplate newConsumedTemplate(@Nullable String str) {
        if (str == null || str.length() == 0) {
            return new MediaEventTemplate(CONSUMED_CONTENT_EVENT, null);
        }
        return new MediaEventTemplate(CONSUMED_CONTENT_EVENT, new BigDecimal(str));
    }

    @NonNull
    public static MediaEventTemplate newConsumedTemplate(int i) {
        return new MediaEventTemplate(CONSUMED_CONTENT_EVENT, new BigDecimal(i));
    }

    @NonNull
    public MediaEventTemplate setId(@Nullable String str) {
        this.id = str;
        return this;
    }

    @NonNull
    public MediaEventTemplate setCategory(@Nullable String str) {
        this.category = str;
        return this;
    }

    @NonNull
    public MediaEventTemplate setType(@Nullable String str) {
        this.type = str;
        return this;
    }

    @NonNull
    public MediaEventTemplate setDescription(@Nullable String str) {
        this.description = str;
        return this;
    }

    @NonNull
    public MediaEventTemplate setFeature(boolean z) {
        this.feature = z;
        this.featureSet = true;
        return this;
    }

    @NonNull
    public MediaEventTemplate setAuthor(@Nullable String str) {
        this.author = str;
        return this;
    }

    @NonNull
    public MediaEventTemplate setPublishedDate(@Nullable String str) {
        this.publishedDate = str;
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
        String str = this.id;
        if (str != null) {
            builderNewBuilder.addProperty("id", str);
        }
        String str2 = this.category;
        if (str2 != null) {
            builderNewBuilder.addProperty("category", str2);
        }
        String str3 = this.description;
        if (str3 != null) {
            builderNewBuilder.addProperty("description", str3);
        }
        String str4 = this.type;
        if (str4 != null) {
            builderNewBuilder.addProperty("type", str4);
        }
        if (this.featureSet) {
            builderNewBuilder.addProperty("feature", this.feature);
        }
        String str5 = this.author;
        if (str5 != null) {
            builderNewBuilder.addProperty("author", str5);
        }
        String str6 = this.publishedDate;
        if (str6 != null) {
            builderNewBuilder.addProperty("published_date", str6);
        }
        String str7 = this.source;
        if (str7 != null) {
            builderNewBuilder.addProperty("source", str7);
        }
        String str8 = this.medium;
        if (str8 != null) {
            builderNewBuilder.addProperty("medium", str8);
        }
        builderNewBuilder.setTemplateType("media");
        return builderNewBuilder.build();
    }
}
