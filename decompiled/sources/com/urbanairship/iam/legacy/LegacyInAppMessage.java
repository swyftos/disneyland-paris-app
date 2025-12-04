package com.urbanairship.iam.legacy;

import androidx.annotation.ColorInt;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.contacts.ContactOperation;
import com.urbanairship.iam.content.Banner;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B§\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0016J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010-\u001a\u00020\u0010H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'¨\u00060"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "", "id", "", "placement", "Lcom/urbanairship/iam/content/Banner$Placement;", "alert", "displayDurationMs", "", "expiryMs", "clickActionValues", "Lcom/urbanairship/json/JsonMap;", "buttonGroupId", "buttonActionValues", "", "primaryColor", "", "secondaryColor", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "campaigns", "Lcom/urbanairship/json/JsonValue;", "extras", "(Ljava/lang/String;Lcom/urbanairship/iam/content/Banner$Placement;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/urbanairship/json/JsonMap;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonMap;)V", "getAlert", "()Ljava/lang/String;", "getButtonActionValues", "()Ljava/util/Map;", "getButtonGroupId", "getClickActionValues", "()Lcom/urbanairship/json/JsonMap;", "getDisplayDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpiryMs", "getExtras", "getId", "getPlacement", "()Lcom/urbanairship/iam/content/Banner$Placement;", "getPrimaryColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSecondaryColor", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LegacyInAppMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String alert;
    private final Map buttonActionValues;
    private final String buttonGroupId;
    private final JsonValue campaigns;
    private final JsonMap clickActionValues;
    private final Long displayDurationMs;
    private final Long expiryMs;
    private final JsonMap extras;
    private final String id;
    private final String messageType;
    private final Banner.Placement placement;
    private final Integer primaryColor;
    private final Integer secondaryColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement) {
        this(id, placement, null, null, null, null, null, null, null, null, null, null, null, 8188, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str) {
        this(id, placement, str, null, null, null, null, null, null, null, null, null, null, 8184, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l) {
        this(id, placement, str, l, null, null, null, null, null, null, null, null, null, 8176, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2) {
        this(id, placement, str, l, l2, null, null, null, null, null, null, null, null, 8160, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap) {
        this(id, placement, str, l, l2, jsonMap, null, null, null, null, null, null, null, 8128, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2) {
        this(id, placement, str, l, l2, jsonMap, str2, null, null, null, null, null, null, 8064, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2, @Nullable Map<String, ? extends JsonMap> map) {
        this(id, placement, str, l, l2, jsonMap, str2, map, null, null, null, null, null, 7936, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2, @Nullable Map<String, ? extends JsonMap> map, @ColorInt @Nullable Integer num) {
        this(id, placement, str, l, l2, jsonMap, str2, map, num, null, null, null, null, 7680, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2, @Nullable Map<String, ? extends JsonMap> map, @ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2) {
        this(id, placement, str, l, l2, jsonMap, str2, map, num, num2, null, null, null, 7168, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2, @Nullable Map<String, ? extends JsonMap> map, @ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2, @Nullable String str3) {
        this(id, placement, str, l, l2, jsonMap, str2, map, num, num2, str3, null, null, 6144, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2, @Nullable Map<String, ? extends JsonMap> map, @ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2, @Nullable String str3, @Nullable JsonValue jsonValue) {
        this(id, placement, str, l, l2, jsonMap, str2, map, num, num2, str3, jsonValue, null, 4096, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
    }

    @JvmOverloads
    public LegacyInAppMessage(@NotNull String id, @NotNull Banner.Placement placement, @Nullable String str, @Nullable Long l, @Nullable Long l2, @Nullable JsonMap jsonMap, @Nullable String str2, @Nullable Map<String, ? extends JsonMap> map, @ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2, @Nullable String str3, @Nullable JsonValue jsonValue, @Nullable JsonMap jsonMap2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.id = id;
        this.placement = placement;
        this.alert = str;
        this.displayDurationMs = l;
        this.expiryMs = l2;
        this.clickActionValues = jsonMap;
        this.buttonGroupId = str2;
        this.buttonActionValues = map;
        this.primaryColor = num;
        this.secondaryColor = num2;
        this.messageType = str3;
        this.campaigns = jsonValue;
        this.extras = jsonMap2;
    }

    public /* synthetic */ LegacyInAppMessage(String str, Banner.Placement placement, String str2, Long l, Long l2, JsonMap jsonMap, String str3, Map map, Integer num, Integer num2, String str4, JsonValue jsonValue, JsonMap jsonMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, placement, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : jsonMap, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : map, (i & 256) != 0 ? null : num, (i & 512) != 0 ? null : num2, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : jsonValue, (i & 4096) != 0 ? null : jsonMap2);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Banner.Placement getPlacement() {
        return this.placement;
    }

    @Nullable
    public final String getAlert() {
        return this.alert;
    }

    @Nullable
    public final Long getDisplayDurationMs() {
        return this.displayDurationMs;
    }

    @Nullable
    public final Long getExpiryMs() {
        return this.expiryMs;
    }

    @Nullable
    public final JsonMap getClickActionValues() {
        return this.clickActionValues;
    }

    @Nullable
    public final String getButtonGroupId() {
        return this.buttonGroupId;
    }

    @Nullable
    public final Map<String, JsonMap> getButtonActionValues() {
        return this.buttonActionValues;
    }

    @Nullable
    public final Integer getPrimaryColor() {
        return this.primaryColor;
    }

    @Nullable
    public final Integer getSecondaryColor() {
        return this.secondaryColor;
    }

    @Nullable
    public final JsonMap getExtras() {
        return this.extras;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessage$Companion;", "", "()V", "ACTIONS_KEY", "", "ALERT_KEY", "BANNER_TYPE", "BUTTON_ACTIONS_KEY", "BUTTON_GROUP_KEY", "CAMPAIGNS_KEY", "DISPLAY_KEY", "DURATION_KEY", "EXPIRY_KEY", "EXTRA_KEY", "MESSAGE_CENTER_ACTION", "MESSAGE_TYPE_KEY", "ON_CLICK_KEY", "POSITION_KEY", "PRIMARY_COLOR_KEY", "SECONDARY_COLOR_KEY", ContactOperation.TYPE_KEY, "fromPush", "Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "pushMessage", "Lcom/urbanairship/push/PushMessage;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLegacyInAppMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyInAppMessage.kt\ncom/urbanairship/iam/legacy/LegacyInAppMessage$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n44#2,15:208\n79#2,16:223\n79#2,16:239\n79#2,16:255\n79#2,16:271\n79#2,16:294\n79#2,16:310\n79#2,16:326\n79#2,16:342\n79#2,16:358\n79#2,16:374\n79#2,16:390\n79#2,16:406\n79#2,16:422\n453#3:287\n403#3:288\n1238#4,4:289\n1#5:293\n*S KotlinDebug\n*F\n+ 1 LegacyInAppMessage.kt\ncom/urbanairship/iam/legacy/LegacyInAppMessage$Companion\n*L\n128#1:208,15\n129#1:223,16\n133#1:239,16\n134#1:255,16\n139#1:271,16\n146#1:294,16\n147#1:310,16\n150#1:326,16\n152#1:342,16\n154#1:358,16\n157#1:374,16\n160#1:390,16\n161#1:406,16\n162#1:422,16\n139#1:287\n139#1:288\n139#1:289,4\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:256:0x05b5  */
        /* JADX WARN: Removed duplicated region for block: B:333:0x0785  */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.iam.legacy.LegacyInAppMessage fromPush(@org.jetbrains.annotations.NotNull com.urbanairship.push.PushMessage r32) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 5530
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.legacy.LegacyInAppMessage.Companion.fromPush(com.urbanairship.push.PushMessage):com.urbanairship.iam.legacy.LegacyInAppMessage");
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(LegacyInAppMessage.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.legacy.LegacyInAppMessage");
        LegacyInAppMessage legacyInAppMessage = (LegacyInAppMessage) other;
        return Intrinsics.areEqual(this.id, legacyInAppMessage.id) && this.placement == legacyInAppMessage.placement && Intrinsics.areEqual(this.alert, legacyInAppMessage.alert) && Intrinsics.areEqual(this.displayDurationMs, legacyInAppMessage.displayDurationMs) && Intrinsics.areEqual(this.expiryMs, legacyInAppMessage.expiryMs) && Intrinsics.areEqual(this.clickActionValues, legacyInAppMessage.clickActionValues) && Intrinsics.areEqual(this.buttonGroupId, legacyInAppMessage.buttonGroupId) && Intrinsics.areEqual(this.buttonActionValues, legacyInAppMessage.buttonActionValues) && Intrinsics.areEqual(this.primaryColor, legacyInAppMessage.primaryColor) && Intrinsics.areEqual(this.secondaryColor, legacyInAppMessage.secondaryColor) && Intrinsics.areEqual(this.messageType, legacyInAppMessage.messageType) && Intrinsics.areEqual(this.campaigns, legacyInAppMessage.campaigns) && Intrinsics.areEqual(this.extras, legacyInAppMessage.extras);
    }

    public int hashCode() {
        String str = this.id;
        Banner.Placement placement = this.placement;
        String str2 = this.alert;
        Long l = this.displayDurationMs;
        Long l2 = this.expiryMs;
        return ObjectsCompat.hash(str, placement, str2, l, l2, this.clickActionValues, this.buttonActionValues, this.buttonGroupId, this.primaryColor, this.secondaryColor, this.messageType, this.campaigns, l2);
    }

    @NotNull
    public String toString() {
        return "LegacyInAppMessage(id='" + this.id + "', placement=" + this.placement + ", alert=" + this.alert + ", displayDurationMs=" + this.displayDurationMs + ", expiryMs=" + this.expiryMs + ", clickActionValues=" + this.clickActionValues + ", buttonGroupId=" + this.buttonGroupId + ", buttonActionValues=" + this.buttonActionValues + ", primaryColor=" + this.primaryColor + ", secondaryColor=" + this.secondaryColor + ", messageType=" + this.messageType + ", campaigns=" + this.campaigns + ", extras=" + this.extras + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
