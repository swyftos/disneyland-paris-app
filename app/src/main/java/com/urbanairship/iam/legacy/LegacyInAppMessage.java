package com.urbanairship.iam.legacy;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.contacts.ContactOperation;
import com.urbanairship.iam.content.Banner;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import com.urbanairship.messagecenter.actions.MessageCenterAction;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.DateUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B§\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0016J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010-\u001a\u00020\u0010H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'¨\u00060"}, m1836d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "", "id", "", "placement", "Lcom/urbanairship/iam/content/Banner$Placement;", "alert", "displayDurationMs", "", "expiryMs", "clickActionValues", "Lcom/urbanairship/json/JsonMap;", "buttonGroupId", "buttonActionValues", "", "primaryColor", "", "secondaryColor", Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "campaigns", "Lcom/urbanairship/json/JsonValue;", "extras", "(Ljava/lang/String;Lcom/urbanairship/iam/content/Banner$Placement;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/urbanairship/json/JsonMap;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/json/JsonMap;)V", "getAlert", "()Ljava/lang/String;", "getButtonActionValues", "()Ljava/util/Map;", "getButtonGroupId", "getClickActionValues", "()Lcom/urbanairship/json/JsonMap;", "getDisplayDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpiryMs", "getExtras", "getId", "getPlacement", "()Lcom/urbanairship/iam/content/Banner$Placement;", "getPrimaryColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSecondaryColor", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class LegacyInAppMessage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
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

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1836d2 = {"Lcom/urbanairship/iam/legacy/LegacyInAppMessage$Companion;", "", "()V", "ACTIONS_KEY", "", "ALERT_KEY", "BANNER_TYPE", "BUTTON_ACTIONS_KEY", "BUTTON_GROUP_KEY", "CAMPAIGNS_KEY", "DISPLAY_KEY", "DURATION_KEY", "EXPIRY_KEY", "EXTRA_KEY", "MESSAGE_CENTER_ACTION", "MESSAGE_TYPE_KEY", "ON_CLICK_KEY", "POSITION_KEY", "PRIMARY_COLOR_KEY", "SECONDARY_COLOR_KEY", ContactOperation.TYPE_KEY, "fromPush", "Lcom/urbanairship/iam/legacy/LegacyInAppMessage;", "pushMessage", "Lcom/urbanairship/push/PushMessage;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nLegacyInAppMessage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LegacyInAppMessage.kt\ncom/urbanairship/iam/legacy/LegacyInAppMessage$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n44#2,15:208\n79#2,16:223\n79#2,16:239\n79#2,16:255\n79#2,16:271\n79#2,16:294\n79#2,16:310\n79#2,16:326\n79#2,16:342\n79#2,16:358\n79#2,16:374\n79#2,16:390\n79#2,16:406\n79#2,16:422\n453#3:287\n403#3:288\n1238#4,4:289\n1#5:293\n*S KotlinDebug\n*F\n+ 1 LegacyInAppMessage.kt\ncom/urbanairship/iam/legacy/LegacyInAppMessage$Companion\n*L\n128#1:208,15\n129#1:223,16\n133#1:239,16\n134#1:255,16\n139#1:271,16\n146#1:294,16\n147#1:310,16\n150#1:326,16\n152#1:342,16\n154#1:358,16\n157#1:374,16\n160#1:390,16\n161#1:406,16\n162#1:422,16\n139#1:287\n139#1:288\n139#1:289,4\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:256:0x05b5  */
        /* JADX WARN: Code duplicated, block: B:333:0x0785  */
        @Nullable
        public final LegacyInAppMessage fromPush(@NotNull PushMessage pushMessage) throws JsonException {
            JsonMap jsonMapOptMap;
            String str;
            JsonMap jsonMap;
            String strOptString;
            String str2;
            JsonMap jsonMapOptMap2;
            Map linkedHashMap;
            LinkedHashMap linkedHashMap2;
            Banner.Placement placementFromJson;
            String str3;
            String strOptString2;
            String str4;
            String str5;
            LinkedHashMap linkedHashMap3;
            String str6;
            Long lValueOf;
            Long l;
            JsonMap jsonMap2;
            String strOptString3;
            String str7;
            String str8;
            String strOptString4;
            Integer numValueOf;
            Integer num;
            String strOptString5;
            Integer numValueOf2;
            String strOptString6;
            String str9;
            JsonValue jsonValue;
            JsonValue jsonValue2;
            JsonMap jsonMapOptMap3;
            JsonMap jsonMap3;
            JsonValue jsonValue3;
            String strOptString7;
            JsonMap jsonMapOptMap4;
            Map<String, JsonValue> map;
            JsonMap jsonMapOptMap5;
            Map<String, JsonValue> map2;
            Intrinsics.checkNotNullParameter(pushMessage, "pushMessage");
            String sendId = pushMessage.getSendId();
            JsonMap map3 = JsonValue.parseString(pushMessage.getExtra(PushMessage.EXTRA_IN_APP_MESSAGE)).getMap();
            if (map3 == null || sendId == null) {
                return null;
            }
            JsonValue jsonValue4 = map3.get("display");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'display" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonMapOptMap = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonMapOptMap = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                if (jsonSerializableOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonSerializableOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonMapOptMap = jsonValue4.optMap();
                if (jsonMapOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'display" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                JsonSerializable jsonValue5 = jsonValue4.getJsonValue();
                if (jsonValue5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                }
                jsonMapOptMap = (JsonMap) jsonValue5;
            }
            JsonValue jsonValue6 = jsonMapOptMap.get("type");
            if (jsonValue6 == null) {
                str = sendId;
                jsonMap = jsonMapOptMap;
                strOptString = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue6.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue6.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = sendId;
                    jsonMap = jsonMapOptMap;
                    strOptString = (String) Long.valueOf(jsonValue6.getLong(0L));
                } else {
                    str = sendId;
                    jsonMap = jsonMapOptMap;
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue6.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString = (String) Integer.valueOf(jsonValue6.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue6.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue6.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue6.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue7 = jsonValue6.getJsonValue();
                        if (jsonValue7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue7;
                    }
                }
                str = sendId;
                jsonMap = jsonMapOptMap;
            }
            if (!Intrinsics.areEqual("banner", strOptString)) {
                throw new JsonException("Only banner types are supported.");
            }
            JsonValue jsonValue8 = map3.get("actions");
            if (jsonValue8 == null) {
                str2 = "' for field '";
                jsonMapOptMap2 = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString3 = jsonValue8.optString();
                    if (objOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap2 = (JsonMap) objOptString3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString4 = jsonValue8.optString();
                    if (objOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap2 = (JsonMap) objOptString4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue8.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str2 = "' for field '";
                    jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue8.getLong(0L));
                } else {
                    str2 = "' for field '";
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap2 = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue8.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue8.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap2 = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue8.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList2 = jsonValue8.optList();
                        if (jsonSerializableOptList2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap2 = (JsonMap) jsonSerializableOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap2 = jsonValue8.optMap();
                        if (jsonMapOptMap2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + "actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue9 = jsonValue8.getJsonValue();
                        if (jsonValue9 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap2 = (JsonMap) jsonValue9;
                    }
                }
                str2 = "' for field '";
            }
            if (jsonMapOptMap2 == null) {
                linkedHashMap = new LinkedHashMap();
            } else {
                JsonValue jsonValue10 = jsonMapOptMap2.get("on_click");
                if (jsonValue10 == null) {
                    jsonMapOptMap5 = null;
                } else {
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString5 = jsonValue10.optString();
                        if (objOptString5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap5 = (JsonMap) objOptString5;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString6 = jsonValue10.optString();
                        if (objOptString6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap5 = (JsonMap) objOptString6;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap5 = (JsonMap) Boolean.valueOf(jsonValue10.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap5 = (JsonMap) Long.valueOf(jsonValue10.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap5 = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue10.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap5 = (JsonMap) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap5 = (JsonMap) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jsonMapOptMap5 = (JsonMap) Integer.valueOf(jsonValue10.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap5 = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue10.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList3 = jsonValue10.optList();
                        if (jsonSerializableOptList3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap5 = (JsonMap) jsonSerializableOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap5 = jsonValue10.optMap();
                        if (jsonMapOptMap5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + "on_click" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue11 = jsonValue10.getJsonValue();
                        if (jsonValue11 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap5 = (JsonMap) jsonValue11;
                    }
                }
                if (jsonMapOptMap5 == null || (map2 = jsonMapOptMap5.getMap()) == null || (linkedHashMap = MapsKt.toMutableMap(map2)) == null) {
                    linkedHashMap = new LinkedHashMap();
                }
            }
            if (pushMessage.getRichPushMessageId() != null) {
                linkedHashMap.put(MessageCenterAction.DEFAULT_REGISTRY_SHORT_NAME, JsonValue.wrap(pushMessage.getRichPushMessageId()));
            }
            if (jsonMapOptMap2 == null) {
                linkedHashMap2 = null;
            } else {
                JsonValue jsonValue12 = jsonMapOptMap2.get("button_actions");
                if (jsonValue12 == null) {
                    jsonMapOptMap4 = null;
                } else {
                    KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString7 = jsonValue12.optString();
                        if (objOptString7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap4 = (JsonMap) objOptString7;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString8 = jsonValue12.optString();
                        if (objOptString8 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap4 = (JsonMap) objOptString8;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap4 = (JsonMap) Boolean.valueOf(jsonValue12.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap4 = (JsonMap) Long.valueOf(jsonValue12.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap4 = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue12.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap4 = (JsonMap) Double.valueOf(jsonValue12.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap4 = (JsonMap) Float.valueOf(jsonValue12.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        jsonMapOptMap4 = (JsonMap) Integer.valueOf(jsonValue12.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap4 = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue12.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList4 = jsonValue12.optList();
                        if (jsonSerializableOptList4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap4 = (JsonMap) jsonSerializableOptList4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap4 = jsonValue12.optMap();
                        if (jsonMapOptMap4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + "button_actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue13 = jsonValue12.getJsonValue();
                        if (jsonValue13 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap4 = (JsonMap) jsonValue13;
                    }
                }
                if (jsonMapOptMap4 == null || (map = jsonMapOptMap4.getMap()) == null) {
                    linkedHashMap2 = null;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
                    Iterator<T> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        linkedHashMap4.put(entry.getKey(), ((JsonValue) entry.getValue()).optMap());
                    }
                    linkedHashMap2 = linkedHashMap4;
                }
            }
            JsonMap jsonMap4 = jsonMap;
            JsonValue jsonValue14 = jsonMap4.get(ViewProps.POSITION);
            if (jsonValue14 == null || (placementFromJson = Banner.Placement.INSTANCE.fromJson(jsonValue14)) == null) {
                placementFromJson = Banner.Placement.TOP;
            }
            Banner.Placement placement = placementFromJson;
            JsonValue jsonValue15 = jsonMap4.get("alert");
            if (jsonValue15 == null) {
                jsonMapOptMap2 = jsonMapOptMap2;
                str5 = null;
            } else {
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue15.optString();
                    jsonMapOptMap2 = jsonMapOptMap2;
                    str3 = strOptString2;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        str4 = (String) Boolean.valueOf(jsonValue15.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str4 = (String) Long.valueOf(jsonValue15.getLong(0L));
                    } else {
                        jsonMapOptMap2 = jsonMapOptMap2;
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue15.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString2 = (String) Double.valueOf(jsonValue15.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString2 = (String) Float.valueOf(jsonValue15.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            str3 = (String) Integer.valueOf(jsonValue15.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            str3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue15.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            str3 = (String) jsonValue15.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            str3 = (String) jsonValue15.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + "alert" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            str3 = (String) jsonValue15.getJsonValue();
                        }
                        str3 = strOptString2;
                    }
                    str3 = str4;
                }
                str5 = str3;
            }
            JsonValue jsonValue16 = jsonMap4.get(TypedValues.TransitionType.S_DURATION);
            if (jsonValue16 == null) {
                linkedHashMap3 = linkedHashMap2;
                str6 = str5;
                lValueOf = null;
            } else {
                KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Long.class);
                linkedHashMap3 = linkedHashMap2;
                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString9 = jsonValue16.optString();
                    if (objOptString9 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString9;
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString10 = jsonValue16.optString();
                    if (objOptString10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    lValueOf = (Long) objOptString10;
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    lValueOf = (Long) Boolean.valueOf(jsonValue16.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str6 = str5;
                    lValueOf = Long.valueOf(jsonValue16.getLong(0L));
                } else {
                    str6 = str5;
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue16.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf = (Long) Double.valueOf(jsonValue16.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf = (Long) Float.valueOf(jsonValue16.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        lValueOf = (Long) Integer.valueOf(jsonValue16.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue16.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList2 = jsonValue16.optList();
                        if (objOptList2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf = (Long) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap2 = jsonValue16.optMap();
                        if (objOptMap2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf = (Long) objOptMap2;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str2 + TypedValues.TransitionType.S_DURATION + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue17 = jsonValue16.getJsonValue();
                        if (jsonValue17 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        lValueOf = (Long) jsonValue17;
                    }
                }
                str6 = str5;
            }
            Long lValueOf2 = lValueOf != null ? Long.valueOf(TimeUnit.SECONDS.toMillis(lValueOf.longValue())) : null;
            JsonValue jsonValue18 = map3.get("expiry");
            if (jsonValue18 == null) {
                l = lValueOf2;
                jsonMap2 = map3;
                strOptString3 = null;
            } else {
                KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString3 = jsonValue18.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString3 = jsonValue18.optString();
                    if (strOptString3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString3 = (String) Boolean.valueOf(jsonValue18.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    l = lValueOf2;
                    jsonMap2 = map3;
                    strOptString3 = (String) Long.valueOf(jsonValue18.getLong(0L));
                } else {
                    l = lValueOf2;
                    jsonMap2 = map3;
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue18.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue18.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue18.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue18.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue18.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList3 = jsonValue18.optList();
                        if (objOptList3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap3 = jsonValue18.optMap();
                        if (objOptMap3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) objOptMap3;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + "expiry" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue19 = jsonValue18.getJsonValue();
                        if (jsonValue19 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString3 = (String) jsonValue19;
                    }
                }
                l = lValueOf2;
                jsonMap2 = map3;
            }
            Long lValueOf3 = strOptString3 != null ? Long.valueOf(DateUtils.parseIso8601(strOptString3)) : null;
            JsonMap jsonMap5 = !linkedHashMap.isEmpty() ? new JsonMap(linkedHashMap) : null;
            if (jsonMapOptMap2 == null || (jsonValue3 = jsonMapOptMap2.get("button_group")) == null) {
                str7 = null;
            } else {
                KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString7 = jsonValue3.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString7 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString7 = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString7 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString7 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString7 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString7 = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString7 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString7 = (String) jsonValue3.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString7 = (String) jsonValue3.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + "button_group" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString7 = (String) jsonValue3.getJsonValue();
                }
                str7 = strOptString7;
            }
            JsonValue jsonValue20 = jsonMap4.get("primary_color");
            if (jsonValue20 == null) {
                str8 = str7;
                strOptString4 = null;
            } else {
                KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString4 = jsonValue20.optString();
                    if (strOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString4 = jsonValue20.optString();
                    if (strOptString4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString4 = (String) Boolean.valueOf(jsonValue20.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str8 = str7;
                    strOptString4 = (String) Long.valueOf(jsonValue20.getLong(0L));
                } else {
                    str8 = str7;
                    if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue20.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString4 = (String) Double.valueOf(jsonValue20.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString4 = (String) Float.valueOf(jsonValue20.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString4 = (String) Integer.valueOf(jsonValue20.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue20.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList4 = jsonValue20.optList();
                        if (objOptList4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) objOptList4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap4 = jsonValue20.optMap();
                        if (objOptMap4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) objOptMap4;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + "primary_color" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue21 = jsonValue20.getJsonValue();
                        if (jsonValue21 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString4 = (String) jsonValue21;
                    }
                }
                str8 = str7;
            }
            if (strOptString4 != null) {
                try {
                    numValueOf = Integer.valueOf(Color.parseColor(strOptString4));
                } catch (Exception e) {
                    throw new JsonException("Invalid primary color " + strOptString4, e);
                }
            } else {
                numValueOf = null;
            }
            JsonValue jsonValue22 = jsonMap4.get("secondary_color");
            if (jsonValue22 == null) {
                num = numValueOf;
                strOptString5 = null;
            } else {
                KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString5 = jsonValue22.optString();
                    if (strOptString5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString5 = jsonValue22.optString();
                    if (strOptString5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString5 = (String) Boolean.valueOf(jsonValue22.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    num = numValueOf;
                    strOptString5 = (String) Long.valueOf(jsonValue22.getLong(0L));
                } else {
                    num = numValueOf;
                    if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString5 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue22.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString5 = (String) Double.valueOf(jsonValue22.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString5 = (String) Float.valueOf(jsonValue22.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString5 = (String) Integer.valueOf(jsonValue22.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString5 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue22.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList5 = jsonValue22.optList();
                        if (objOptList5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString5 = (String) objOptList5;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap5 = jsonValue22.optMap();
                        if (objOptMap5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString5 = (String) objOptMap5;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + "secondary_color" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue23 = jsonValue22.getJsonValue();
                        if (jsonValue23 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString5 = (String) jsonValue23;
                    }
                }
                num = numValueOf;
            }
            if (strOptString5 != null) {
                try {
                    numValueOf2 = Integer.valueOf(Color.parseColor(strOptString5));
                } catch (Exception e2) {
                    throw new JsonException("Invalid secondary color " + strOptString5, e2);
                }
            } else {
                numValueOf2 = null;
            }
            JsonMap jsonMap6 = jsonMap2;
            JsonValue jsonValue24 = jsonMap6.get(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            if (jsonValue24 == null) {
                str9 = null;
            } else {
                KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString6 = jsonValue24.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString6 = (String) Boolean.valueOf(jsonValue24.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString6 = (String) Long.valueOf(jsonValue24.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue24.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString6 = (String) Double.valueOf(jsonValue24.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString6 = (String) Float.valueOf(jsonValue24.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString6 = (String) Integer.valueOf(jsonValue24.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue24.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString6 = (String) jsonValue24.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString6 = (String) jsonValue24.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + Constants.MessagePayloadKeys.MESSAGE_TYPE + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString6 = (String) jsonValue24.getJsonValue();
                }
                str9 = strOptString6;
            }
            JsonValue jsonValue25 = jsonMap6.get("campaigns");
            if (jsonValue25 == null) {
                jsonValue2 = null;
            } else {
                KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(JsonValue.class);
                if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    jsonValue = (JsonValue) jsonValue25.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonValue = (JsonValue) Boolean.valueOf(jsonValue25.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonValue = (JsonValue) Long.valueOf(jsonValue25.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonValue = (JsonValue) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue25.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonValue = (JsonValue) Double.valueOf(jsonValue25.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonValue = (JsonValue) Float.valueOf(jsonValue25.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonValue = (JsonValue) Integer.valueOf(jsonValue25.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonValue = (JsonValue) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue25.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonValue = (JsonValue) jsonValue25.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonValue = (JsonValue) jsonValue25.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + str2 + "campaigns" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue = jsonValue25.getJsonValue();
                }
                jsonValue2 = jsonValue;
            }
            JsonValue jsonValue26 = jsonMap6.get(Message.KEY_EXTRAS);
            if (jsonValue26 == null) {
                jsonMap3 = null;
            } else {
                KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    jsonMapOptMap3 = (JsonMap) jsonValue26.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Boolean.valueOf(jsonValue26.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Long.valueOf(jsonValue26.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap3 = (JsonMap) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue26.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Double.valueOf(jsonValue26.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Float.valueOf(jsonValue26.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Integer.valueOf(jsonValue26.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap3 = (JsonMap) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue26.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    jsonMapOptMap3 = (JsonMap) jsonValue26.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap3 = jsonValue26.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + Message.KEY_EXTRAS + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonMapOptMap3 = (JsonMap) jsonValue26.getJsonValue();
                }
                jsonMap3 = jsonMapOptMap3;
            }
            return new LegacyInAppMessage(str, placement, str6, l, lValueOf3, jsonMap5, str8, linkedHashMap3, num, numValueOf2, str9, jsonValue2, jsonMap3);
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
