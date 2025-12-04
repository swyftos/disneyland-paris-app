package com.urbanairship.analytics.templates;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate;", "", "()V", "Companion", "Properties", "Type", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class MediaEventTemplate {

    @NotNull
    public static final String TEMPLATE_NAME = "media";

    public /* synthetic */ MediaEventTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MediaEventTemplate() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type;", "", "eventName", "", "(Ljava/lang/String;)V", "getEventName$urbanairship_core_release", "()Ljava/lang/String;", "Browsed", "Consumed", "Shared", "Starred", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Browsed;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Consumed;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Shared;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Starred;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Type {
        private final String eventName;

        public /* synthetic */ Type(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Browsed;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Browsed extends Type {

            @NotNull
            public static final Browsed INSTANCE = new Browsed();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Browsed);
            }

            public int hashCode() {
                return 1028161146;
            }

            @NotNull
            public String toString() {
                return "Browsed";
            }

            private Browsed() {
                super(com.urbanairship.analytics.MediaEventTemplate.BROWSED_CONTENT_EVENT, null);
            }
        }

        private Type(String str) {
            this.eventName = str;
        }

        @NotNull
        /* renamed from: getEventName$urbanairship_core_release, reason: from getter */
        public final String getEventName() {
            return this.eventName;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Consumed;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Consumed extends Type {

            @NotNull
            public static final Consumed INSTANCE = new Consumed();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Consumed);
            }

            public int hashCode() {
                return 856267912;
            }

            @NotNull
            public String toString() {
                return "Consumed";
            }

            private Consumed() {
                super(com.urbanairship.analytics.MediaEventTemplate.CONSUMED_CONTENT_EVENT, null);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Starred;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Starred extends Type {

            @NotNull
            public static final Starred INSTANCE = new Starred();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Starred);
            }

            public int hashCode() {
                return -1019966369;
            }

            @NotNull
            public String toString() {
                return "Starred";
            }

            private Starred() {
                super(com.urbanairship.analytics.MediaEventTemplate.STARRED_CONTENT_EVENT, null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type$Shared;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type;", "source", "", "medium", "(Ljava/lang/String;Ljava/lang/String;)V", "getMedium$urbanairship_core_release", "()Ljava/lang/String;", "getSource$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Shared extends Type {
            private final String medium;
            private final String source;

            public Shared() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Shared(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            @Nullable
            /* renamed from: getSource$urbanairship_core_release, reason: from getter */
            public final String getSource() {
                return this.source;
            }

            @Nullable
            /* renamed from: getMedium$urbanairship_core_release, reason: from getter */
            public final String getMedium() {
                return this.medium;
            }

            public Shared(@Nullable String str, @Nullable String str2) {
                super(com.urbanairship.analytics.MediaEventTemplate.SHARED_CONTENT_EVENT, null);
                this.source = str;
                this.medium = str2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", "category", "type", "eventDescription", "author", "publishedDate", "isFeature", "", "isLTV", "source", "medium", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getCategory", "getEventDescription", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "getMedium$urbanairship_core_release", "getPublishedDate", "getSource$urbanairship_core_release", "getType", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Builder", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Properties implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String author;
        private final String category;
        private final String eventDescription;
        private final String id;
        private final Boolean isFeature;
        private final boolean isLTV;
        private final String medium;
        private final String publishedDate;
        private final String source;
        private final String type;

        public Properties() {
            this(null, null, null, null, null, null, null, false, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
        }

        @JvmStatic
        @NotNull
        public static final Builder newBuilder() {
            return INSTANCE.newBuilder();
        }

        public Properties(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, boolean z, @Nullable String str7, @Nullable String str8) {
            this.id = str;
            this.category = str2;
            this.type = str3;
            this.eventDescription = str4;
            this.author = str5;
            this.publishedDate = str6;
            this.isFeature = bool;
            this.isLTV = z;
            this.source = str7;
            this.medium = str8;
        }

        public /* synthetic */ Properties(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, boolean z, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getEventDescription() {
            return this.eventDescription;
        }

        @Nullable
        public final String getAuthor() {
            return this.author;
        }

        @Nullable
        public final String getPublishedDate() {
            return this.publishedDate;
        }

        @Nullable
        /* renamed from: isFeature, reason: from getter */
        public final Boolean getIsFeature() {
            return this.isFeature;
        }

        /* renamed from: isLTV, reason: from getter */
        public final boolean getIsLTV() {
            return this.isLTV;
        }

        @Nullable
        /* renamed from: getSource$urbanairship_core_release, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @Nullable
        /* renamed from: getMedium$urbanairship_core_release, reason: from getter */
        public final String getMedium() {
            return this.medium;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties$Companion;", "", "()V", "AUTHOR", "", "CATEGORY", "EVENT_DESCRIPTION", "ID", "IS_FEATURE", "IS_LTV", "MEDIUM", "PUBLISHED_DATE", "SOURCE", "TYPE", "newBuilder", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties$Builder;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Builder newBuilder() {
                return new Builder(null, null, null, null, null, null, null, false, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B}\b\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0013\u001a\u00020\u0003J\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\rJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u001eJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0017\u0010!\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties$Builder;", "", CustomEvent.PROPERTIES, "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties;", "(Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties;)V", "id", "", "category", "type", "eventDescription", "author", "publishedDate", "isFeature", "", "isLTV", "source", "medium", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Boolean;", "build", "setAuthor", "setCategory", "setDescription", "description", "setFeature", "feature", "setId", "setIsLifetimeValue", "value", "setMedium", "setMedium$urbanairship_core_release", "setPublishedDate", "date", "setSource", "setSource$urbanairship_core_release", "setType", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nMediaEventTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaEventTemplate.kt\ncom/urbanairship/analytics/templates/MediaEventTemplate$Properties$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n1#2:231\n*E\n"})
        public static final class Builder {
            private String author;
            private String category;
            private String eventDescription;
            private String id;
            private Boolean isFeature;
            private boolean isLTV;
            private String medium;
            private String publishedDate;
            private String source;
            private String type;

            public Builder() {
                this(null, null, null, null, null, null, null, false, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
            }

            public Builder(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Boolean bool, boolean z, @Nullable String str7, @Nullable String str8) {
                this.id = str;
                this.category = str2;
                this.type = str3;
                this.eventDescription = str4;
                this.author = str5;
                this.publishedDate = str6;
                this.isFeature = bool;
                this.isLTV = z;
                this.source = str7;
                this.medium = str8;
            }

            public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool, boolean z, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Builder(@NotNull Properties properties) {
                this(properties.getId(), properties.getCategory(), properties.getType(), properties.getEventDescription(), properties.getAuthor(), properties.getPublishedDate(), properties.getIsFeature(), properties.getIsLTV(), properties.getSource(), properties.getMedium());
                Intrinsics.checkNotNullParameter(properties, "properties");
            }

            @NotNull
            public final Builder setId(@Nullable String id) {
                this.id = id;
                return this;
            }

            @NotNull
            public final Builder setCategory(@Nullable String category) {
                this.category = category;
                return this;
            }

            @NotNull
            public final Builder setType(@Nullable String type) {
                this.type = type;
                return this;
            }

            @NotNull
            public final Builder setDescription(@Nullable String description) {
                this.eventDescription = description;
                return this;
            }

            @NotNull
            public final Builder setFeature(boolean feature) {
                this.isFeature = Boolean.valueOf(feature);
                return this;
            }

            @NotNull
            public final Builder setAuthor(@Nullable String author) {
                this.author = author;
                return this;
            }

            @NotNull
            public final Builder setPublishedDate(@Nullable String date) {
                this.publishedDate = date;
                return this;
            }

            @NotNull
            public final Builder setIsLifetimeValue(boolean value) {
                this.isLTV = value;
                return this;
            }

            @NotNull
            public final Builder setSource$urbanairship_core_release(@Nullable String source) {
                this.source = source;
                return this;
            }

            @NotNull
            public final Builder setMedium$urbanairship_core_release(@Nullable String medium) {
                this.medium = medium;
                return this;
            }

            @NotNull
            public final Properties build() {
                return new Properties(this.id, this.category, this.type, this.eventDescription, this.author, this.publishedDate, this.isFeature, this.isLTV, this.source, this.medium);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("ltv", Boolean.valueOf(this.isLTV)), TuplesKt.to("feature", this.isFeature), TuplesKt.to("id", this.id), TuplesKt.to("category", this.category), TuplesKt.to("type", this.type), TuplesKt.to("source", this.source), TuplesKt.to("medium", this.medium), TuplesKt.to("description", this.eventDescription), TuplesKt.to("author", this.author), TuplesKt.to("published_date", this.publishedDate)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
