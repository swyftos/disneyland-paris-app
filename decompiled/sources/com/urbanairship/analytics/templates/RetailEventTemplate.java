package com.urbanairship.analytics.templates;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate;", "", "()V", "Companion", "Properties", "Type", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RetailEventTemplate {

    @NotNull
    public static final String TEMPLATE_NAME = "retail";

    public /* synthetic */ RetailEventTemplate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RetailEventTemplate() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "", "eventName", "", "(Ljava/lang/String;)V", "getEventName$urbanairship_core_release", "()Ljava/lang/String;", "AddedToCart", "Browsed", "Purchased", "Shared", "Starred", "Wishlist", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$AddedToCart;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Browsed;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Purchased;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Shared;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Starred;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Wishlist;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Type {
        private final String eventName;

        public /* synthetic */ Type(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Browsed;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Browsed extends Type {

            @NotNull
            public static final Browsed INSTANCE = new Browsed();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Browsed);
            }

            public int hashCode() {
                return -490655635;
            }

            @NotNull
            public String toString() {
                return "Browsed";
            }

            private Browsed() {
                super(com.urbanairship.analytics.RetailEventTemplate.BROWSED_PRODUCT_EVENT, null);
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

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$AddedToCart;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AddedToCart extends Type {

            @NotNull
            public static final AddedToCart INSTANCE = new AddedToCart();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof AddedToCart);
            }

            public int hashCode() {
                return 1899329838;
            }

            @NotNull
            public String toString() {
                return "AddedToCart";
            }

            private AddedToCart() {
                super(com.urbanairship.analytics.RetailEventTemplate.ADDED_TO_CART_EVENT, null);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Starred;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Starred extends Type {

            @NotNull
            public static final Starred INSTANCE = new Starred();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Starred);
            }

            public int hashCode() {
                return 1756184146;
            }

            @NotNull
            public String toString() {
                return "Starred";
            }

            private Starred() {
                super(com.urbanairship.analytics.RetailEventTemplate.STARRED_PRODUCT_EVENT, null);
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Purchased;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Purchased extends Type {

            @NotNull
            public static final Purchased INSTANCE = new Purchased();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Purchased);
            }

            public int hashCode() {
                return 109942806;
            }

            @NotNull
            public String toString() {
                return "Purchased";
            }

            private Purchased() {
                super(com.urbanairship.analytics.RetailEventTemplate.PURCHASED_EVENT, null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Shared;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "source", "", "medium", "(Ljava/lang/String;Ljava/lang/String;)V", "getMedium$urbanairship_core_release", "()Ljava/lang/String;", "getSource$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                super(com.urbanairship.analytics.RetailEventTemplate.SHARED_PRODUCT_EVENT, null);
                this.source = str;
                this.medium = str2;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type$Wishlist;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "id", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getId$urbanairship_core_release", "()Ljava/lang/String;", "getName$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Wishlist extends Type {
            private final String id;
            private final String name;

            public Wishlist() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Wishlist(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            @Nullable
            /* renamed from: getId$urbanairship_core_release, reason: from getter */
            public final String getId() {
                return this.id;
            }

            @Nullable
            /* renamed from: getName$urbanairship_core_release, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public Wishlist(@Nullable String str, @Nullable String str2) {
                super(com.urbanairship.analytics.RetailEventTemplate.WISHLIST_EVENT, null);
                this.id = str;
                this.name = str2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u0001:\u0002&'Bc\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\b\u0010$\u001a\u00020%H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0019R\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0019¨\u0006("}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties;", "Lcom/urbanairship/json/JsonSerializable;", "id", "", "category", "type", "eventDescription", TCEventPropertiesNames.TCP_BRAND, "isNewItem", "", "currency", "isLTV", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Z)V", "getBrand", "()Ljava/lang/String;", "getCategory", "getCurrency", "getEventDescription", "getId", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "medium", "getMedium$urbanairship_core_release", "setMedium$urbanairship_core_release", "(Ljava/lang/String;)V", "source", "getSource$urbanairship_core_release", "setSource$urbanairship_core_release", "getType", "wishlistId", "getWishlistId$urbanairship_core_release", "setWishlistId$urbanairship_core_release", "wishlistName", "getWishlistName$urbanairship_core_release", "setWishlistName$urbanairship_core_release", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Builder", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Properties implements JsonSerializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String brand;
        private final String category;
        private final String currency;
        private final String eventDescription;
        private final String id;
        private final boolean isLTV;
        private final Boolean isNewItem;
        private String medium;
        private String source;
        private final String type;
        private String wishlistId;
        private String wishlistName;

        public Properties() {
            this(null, null, null, null, null, null, null, false, 255, null);
        }

        @JvmStatic
        @NotNull
        public static final Builder newBuilder() {
            return INSTANCE.newBuilder();
        }

        public Properties(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable String str6, boolean z) {
            this.id = str;
            this.category = str2;
            this.type = str3;
            this.eventDescription = str4;
            this.brand = str5;
            this.isNewItem = bool;
            this.currency = str6;
            this.isLTV = z;
        }

        public /* synthetic */ Properties(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? false : z);
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
        public final String getBrand() {
            return this.brand;
        }

        @Nullable
        /* renamed from: isNewItem, reason: from getter */
        public final Boolean getIsNewItem() {
            return this.isNewItem;
        }

        @Nullable
        public final String getCurrency() {
            return this.currency;
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

        public final void setSource$urbanairship_core_release(@Nullable String str) {
            this.source = str;
        }

        @Nullable
        /* renamed from: getMedium$urbanairship_core_release, reason: from getter */
        public final String getMedium() {
            return this.medium;
        }

        public final void setMedium$urbanairship_core_release(@Nullable String str) {
            this.medium = str;
        }

        @Nullable
        /* renamed from: getWishlistName$urbanairship_core_release, reason: from getter */
        public final String getWishlistName() {
            return this.wishlistName;
        }

        public final void setWishlistName$urbanairship_core_release(@Nullable String str) {
            this.wishlistName = str;
        }

        @Nullable
        /* renamed from: getWishlistId$urbanairship_core_release, reason: from getter */
        public final String getWishlistId() {
            return this.wishlistId;
        }

        public final void setWishlistId$urbanairship_core_release(@Nullable String str) {
            this.wishlistId = str;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties$Companion;", "", "()V", "BRAND", "", "CATEGORY", "CURRENCY", "EVENT_DESCRIPTION", "ID", "IS_LTV", "IS_NEW_ITEM", "MEDIUM", "SOURCE", "TYPE", "WISHLIST_ID", "WISHLIST_NAME", "newBuilder", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties$Builder;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Builder newBuilder() {
                return new Builder(null, null, null, null, null, null, null, false, null, null, null, null, 4095, null);
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b8\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0093\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0013J\u0006\u00103\u001a\u00020\u0003J\u0010\u00104\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u00105\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u00106\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0010\u00107\u001a\u00020\u00002\b\u00108\u001a\u0004\u0018\u00010\u0006J\u0010\u00109\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\fJ\u0017\u0010<\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b*J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\fJ\u0017\u0010?\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b,J\u0010\u0010@\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0006J\u0017\u0010A\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\bBJ\u0017\u0010C\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b0R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017¨\u0006D"}, d2 = {"Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties$Builder;", "", CustomEvent.PROPERTIES, "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties;", "(Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties;)V", "id", "", "category", "type", "eventDescription", TCEventPropertiesNames.TCP_BRAND, "isNewItem", "", "currency", "isLTV", "source", "medium", "wishlistName", "wishlistId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrand$urbanairship_core_release", "()Ljava/lang/String;", "setBrand$urbanairship_core_release", "(Ljava/lang/String;)V", "getCategory$urbanairship_core_release", "setCategory$urbanairship_core_release", "getCurrency$urbanairship_core_release", "setCurrency$urbanairship_core_release", "getEventDescription$urbanairship_core_release", "setEventDescription$urbanairship_core_release", "getId$urbanairship_core_release", "setId$urbanairship_core_release", "isLTV$urbanairship_core_release", "()Z", "setLTV$urbanairship_core_release", "(Z)V", "isNewItem$urbanairship_core_release", "()Ljava/lang/Boolean;", "setNewItem$urbanairship_core_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMedium$urbanairship_core_release", "setMedium$urbanairship_core_release", "getSource$urbanairship_core_release", "setSource$urbanairship_core_release", "getType$urbanairship_core_release", "setType$urbanairship_core_release", "getWishlistId$urbanairship_core_release", "setWishlistId$urbanairship_core_release", "getWishlistName$urbanairship_core_release", "setWishlistName$urbanairship_core_release", "build", "setBrand", "setCategory", "setCurrency", "setDescription", "description", "setId", "setIsLifetimeValue", "value", "setMedium", "setNewItem", "newItem", "setSource", "setType", "setWhishlistName", "setWhishlistName$urbanairship_core_release", "setWishlistId", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nRetailEventTemplate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RetailEventTemplate.kt\ncom/urbanairship/analytics/templates/RetailEventTemplate$Properties$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,240:1\n1#2:241\n*E\n"})
        public static final class Builder {
            private String brand;
            private String category;
            private String currency;
            private String eventDescription;
            private String id;
            private boolean isLTV;
            private Boolean isNewItem;
            private String medium;
            private String source;
            private String type;
            private String wishlistId;
            private String wishlistName;

            public Builder() {
                this(null, null, null, null, null, null, null, false, null, null, null, null, 4095, null);
            }

            public Builder(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable String str6, boolean z, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
                this.id = str;
                this.category = str2;
                this.type = str3;
                this.eventDescription = str4;
                this.brand = str5;
                this.isNewItem = bool;
                this.currency = str6;
                this.isLTV = z;
                this.source = str7;
                this.medium = str8;
                this.wishlistName = str9;
                this.wishlistId = str10;
            }

            public /* synthetic */ Builder(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, boolean z, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10);
            }

            @Nullable
            /* renamed from: getId$urbanairship_core_release, reason: from getter */
            public final String getId() {
                return this.id;
            }

            public final void setId$urbanairship_core_release(@Nullable String str) {
                this.id = str;
            }

            @Nullable
            /* renamed from: getCategory$urbanairship_core_release, reason: from getter */
            public final String getCategory() {
                return this.category;
            }

            public final void setCategory$urbanairship_core_release(@Nullable String str) {
                this.category = str;
            }

            @Nullable
            /* renamed from: getType$urbanairship_core_release, reason: from getter */
            public final String getType() {
                return this.type;
            }

            public final void setType$urbanairship_core_release(@Nullable String str) {
                this.type = str;
            }

            @Nullable
            /* renamed from: getEventDescription$urbanairship_core_release, reason: from getter */
            public final String getEventDescription() {
                return this.eventDescription;
            }

            public final void setEventDescription$urbanairship_core_release(@Nullable String str) {
                this.eventDescription = str;
            }

            @Nullable
            /* renamed from: getBrand$urbanairship_core_release, reason: from getter */
            public final String getBrand() {
                return this.brand;
            }

            public final void setBrand$urbanairship_core_release(@Nullable String str) {
                this.brand = str;
            }

            @Nullable
            /* renamed from: isNewItem$urbanairship_core_release, reason: from getter */
            public final Boolean getIsNewItem() {
                return this.isNewItem;
            }

            public final void setNewItem$urbanairship_core_release(@Nullable Boolean bool) {
                this.isNewItem = bool;
            }

            @Nullable
            /* renamed from: getCurrency$urbanairship_core_release, reason: from getter */
            public final String getCurrency() {
                return this.currency;
            }

            public final void setCurrency$urbanairship_core_release(@Nullable String str) {
                this.currency = str;
            }

            /* renamed from: isLTV$urbanairship_core_release, reason: from getter */
            public final boolean getIsLTV() {
                return this.isLTV;
            }

            public final void setLTV$urbanairship_core_release(boolean z) {
                this.isLTV = z;
            }

            @Nullable
            /* renamed from: getSource$urbanairship_core_release, reason: from getter */
            public final String getSource() {
                return this.source;
            }

            /* renamed from: setSource$urbanairship_core_release, reason: collision with other method in class */
            public final void m2707setSource$urbanairship_core_release(@Nullable String str) {
                this.source = str;
            }

            @Nullable
            /* renamed from: getMedium$urbanairship_core_release, reason: from getter */
            public final String getMedium() {
                return this.medium;
            }

            /* renamed from: setMedium$urbanairship_core_release, reason: collision with other method in class */
            public final void m2706setMedium$urbanairship_core_release(@Nullable String str) {
                this.medium = str;
            }

            @Nullable
            /* renamed from: getWishlistName$urbanairship_core_release, reason: from getter */
            public final String getWishlistName() {
                return this.wishlistName;
            }

            public final void setWishlistName$urbanairship_core_release(@Nullable String str) {
                this.wishlistName = str;
            }

            @Nullable
            /* renamed from: getWishlistId$urbanairship_core_release, reason: from getter */
            public final String getWishlistId() {
                return this.wishlistId;
            }

            /* renamed from: setWishlistId$urbanairship_core_release, reason: collision with other method in class */
            public final void m2708setWishlistId$urbanairship_core_release(@Nullable String str) {
                this.wishlistId = str;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Builder(@NotNull Properties properties) {
                this(properties.getId(), properties.getCategory(), properties.getType(), properties.getEventDescription(), properties.getBrand(), properties.getIsNewItem(), properties.getCurrency(), properties.getIsLTV(), properties.getSource(), properties.getMedium(), properties.getWishlistName(), properties.getWishlistId());
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
            public final Builder setCurrency(@Nullable String currency) {
                this.currency = currency;
                return this;
            }

            @NotNull
            public final Builder setBrand(@Nullable String brand) {
                this.brand = brand;
                return this;
            }

            @NotNull
            public final Builder setNewItem(boolean newItem) {
                this.isNewItem = Boolean.valueOf(newItem);
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
            public final Builder setWhishlistName$urbanairship_core_release(@Nullable String wishlistName) {
                this.wishlistName = wishlistName;
                return this;
            }

            @NotNull
            public final Builder setWishlistId$urbanairship_core_release(@Nullable String wishlistId) {
                this.wishlistId = wishlistId;
                return this;
            }

            @NotNull
            public final Properties build() {
                Properties properties = new Properties(this.id, this.category, this.type, this.eventDescription, this.brand, this.isNewItem, this.currency, this.isLTV);
                properties.setSource$urbanairship_core_release(this.source);
                properties.setMedium$urbanairship_core_release(this.medium);
                properties.setWishlistName$urbanairship_core_release(this.wishlistName);
                properties.setWishlistId$urbanairship_core_release(this.wishlistId);
                return properties;
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.id), TuplesKt.to("category", this.category), TuplesKt.to("type", this.type), TuplesKt.to("description", this.eventDescription), TuplesKt.to(TCEventPropertiesNames.TCP_BRAND, this.brand), TuplesKt.to("new_item", this.isNewItem), TuplesKt.to("currency", this.currency), TuplesKt.to("ltv", Boolean.valueOf(this.isLTV)), TuplesKt.to("source", this.source), TuplesKt.to("medium", this.medium), TuplesKt.to("wishlist_name", this.wishlistName), TuplesKt.to("wishlist_id", this.wishlistId)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
