package com.urbanairship.analytics;

import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.collection.ScatterMapKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.templates.AccountEventTemplate;
import com.urbanairship.analytics.templates.MediaEventTemplate;
import com.urbanairship.analytics.templates.RetailEventTemplate;
import com.urbanairship.analytics.templates.SearchEventTemplate;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.UAStringUtil;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002*+B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bi\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0017J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0012H\u0016J\u0006\u0010)\u001a\u00020\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u0006,"}, d2 = {"Lcom/urbanairship/analytics/CustomEvent;", "Lcom/urbanairship/analytics/Event;", "Lcom/urbanairship/json/JsonSerializable;", "builder", "Lcom/urbanairship/analytics/CustomEvent$Builder;", "(Lcom/urbanairship/analytics/CustomEvent$Builder;)V", "eventName", "", "eventValue", "Ljava/math/BigDecimal;", "transactionId", "interactionType", "interactionId", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "sendId", "templateType", "inAppContext", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonValue;)V", "getEventName", "()Ljava/lang/String;", "getEventValue", "()Ljava/math/BigDecimal;", "getInAppContext$urbanairship_core_release", "()Lcom/urbanairship/json/JsonValue;", "getInteractionId", "getInteractionType", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "getSendId$urbanairship_core_release", "getTemplateType$urbanairship_core_release", "getTransactionId", "getEventData", "conversionData", "Lcom/urbanairship/analytics/ConversionData;", "getType", "Lcom/urbanairship/analytics/EventType;", "isValid", "", "toJsonValue", "track", "Builder", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CustomEvent extends Event implements JsonSerializable {

    @NotNull
    public static final String CONVERSION_METADATA = "conversion_metadata";

    @NotNull
    public static final String CONVERSION_SEND_ID = "conversion_send_id";

    @NotNull
    public static final String EVENT_NAME = "event_name";

    @NotNull
    public static final String EVENT_VALUE = "event_value";

    @NotNull
    public static final String INTERACTION_ID = "interaction_id";

    @NotNull
    public static final String INTERACTION_TYPE = "interaction_type";

    @NotNull
    public static final String LAST_RECEIVED_METADATA = "last_received_metadata";
    public static final int MAX_CHARACTER_LENGTH = 255;
    public static final int MAX_TOTAL_PROPERTIES_SIZE = 65536;

    @NotNull
    public static final String MCRAP_TRANSACTION_TYPE = "ua_mcrap";

    @NotNull
    public static final String PROPERTIES = "properties";

    @NotNull
    public static final String TEMPLATE_TYPE = "template_type";

    @NotNull
    public static final String TRANSACTION_ID = "transaction_id";
    private final String eventName;
    private final BigDecimal eventValue;
    private final JsonValue inAppContext;
    private final String interactionId;
    private final String interactionType;
    private final JsonMap properties;
    private final String sendId;
    private final String templateType;
    private final String transactionId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final BigDecimal MAX_VALUE = new BigDecimal(Integer.MAX_VALUE);
    private static final BigDecimal MIN_VALUE = new BigDecimal(Integer.MIN_VALUE);

    public /* synthetic */ CustomEvent(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull AccountEventTemplate.Type type) {
        return INSTANCE.newBuilder(type);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull AccountEventTemplate.Type type, @NotNull AccountEventTemplate.Properties properties) {
        return INSTANCE.newBuilder(type, properties);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull MediaEventTemplate.Type type) {
        return INSTANCE.newBuilder(type);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull MediaEventTemplate.Type type, @NotNull MediaEventTemplate.Properties properties) {
        return INSTANCE.newBuilder(type, properties);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull RetailEventTemplate.Type type) {
        return INSTANCE.newBuilder(type);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull RetailEventTemplate.Type type, @NotNull RetailEventTemplate.Properties properties) {
        return INSTANCE.newBuilder(type, properties);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull SearchEventTemplate.Type type) {
        return INSTANCE.newBuilder(type);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final Builder newBuilder(@NotNull SearchEventTemplate.Type type, @NotNull SearchEventTemplate.Properties properties) {
        return INSTANCE.newBuilder(type, properties);
    }

    @JvmStatic
    @NotNull
    public static final Builder newBuilder(@NotNull String str) {
        return INSTANCE.newBuilder(str);
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final BigDecimal getEventValue() {
        return this.eventValue;
    }

    @Nullable
    public final String getTransactionId() {
        return this.transactionId;
    }

    @Nullable
    public final String getInteractionType() {
        return this.interactionType;
    }

    @Nullable
    public final String getInteractionId() {
        return this.interactionId;
    }

    @NotNull
    public final JsonMap getProperties() {
        return this.properties;
    }

    @Nullable
    /* renamed from: getSendId$urbanairship_core_release, reason: from getter */
    public final String getSendId() {
        return this.sendId;
    }

    @Nullable
    /* renamed from: getTemplateType$urbanairship_core_release, reason: from getter */
    public final String getTemplateType() {
        return this.templateType;
    }

    @Nullable
    /* renamed from: getInAppContext$urbanairship_core_release, reason: from getter */
    public final JsonValue getInAppContext() {
        return this.inAppContext;
    }

    private CustomEvent(String str, BigDecimal bigDecimal, String str2, String str3, String str4, JsonMap jsonMap, String str5, String str6, JsonValue jsonValue) {
        this.eventName = str;
        this.eventValue = bigDecimal;
        this.transactionId = str2;
        this.interactionType = str3;
        this.interactionId = str4;
        this.properties = jsonMap;
        this.sendId = str5;
        this.templateType = str6;
        this.inAppContext = jsonValue;
    }

    private CustomEvent(Builder builder) {
        this(builder.getEventName(), builder.getValue(), builder.getTransactionId(), builder.getInteractionType(), builder.getInteractionId(), JsonExtensionsKt.toJsonMap(builder.getProperties()), builder.getPushSendId(), builder.getTemplateType(), builder.getInAppContext());
    }

    @Override // com.urbanairship.analytics.Event
    @NotNull
    public EventType getType() {
        return EventType.CUSTOM_EVENT;
    }

    @Override // com.urbanairship.analytics.Event
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public JsonMap getEventData(@NotNull ConversionData conversionData) {
        BigDecimal bigDecimalMovePointRight;
        Intrinsics.checkNotNullParameter(conversionData, "conversionData");
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        String conversionSendId = conversionData.getConversionSendId();
        String conversionMetadata = conversionData.getConversionMetadata();
        builderNewBuilder.put("event_name", this.eventName);
        builderNewBuilder.put(INTERACTION_ID, this.interactionId);
        builderNewBuilder.put(INTERACTION_TYPE, this.interactionType);
        builderNewBuilder.put("transaction_id", this.transactionId);
        builderNewBuilder.put(TEMPLATE_TYPE, this.templateType);
        builderNewBuilder.put("in_app", this.inAppContext);
        BigDecimal bigDecimal = this.eventValue;
        builderNewBuilder.putOpt(EVENT_VALUE, (bigDecimal == null || (bigDecimalMovePointRight = bigDecimal.movePointRight(6)) == null) ? null : Long.valueOf(bigDecimalMovePointRight.longValue()));
        if (!UAStringUtil.isEmpty(this.sendId)) {
            builderNewBuilder.put(CONVERSION_SEND_ID, this.sendId);
        } else {
            builderNewBuilder.put(CONVERSION_SEND_ID, conversionSendId);
        }
        if (conversionMetadata != null) {
            builderNewBuilder.put(CONVERSION_METADATA, conversionMetadata);
        } else {
            builderNewBuilder.put(LAST_RECEIVED_METADATA, conversionData.getLastReceivedMetadata());
        }
        Map<String, JsonValue> map = this.properties.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "getMap(...)");
        if (!map.isEmpty()) {
            builderNewBuilder.put(PROPERTIES, this.properties);
        }
        JsonMap jsonMapBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        return jsonMapBuild;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        Pair pair = TuplesKt.to("event_name", this.eventName);
        BigDecimal bigDecimal = this.eventValue;
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, TuplesKt.to(EVENT_VALUE, bigDecimal != null ? Double.valueOf(bigDecimal.doubleValue()) : null), TuplesKt.to(INTERACTION_ID, this.interactionId), TuplesKt.to(INTERACTION_TYPE, this.interactionType), TuplesKt.to("transaction_id", this.transactionId), TuplesKt.to("in_app", this.inAppContext), TuplesKt.to(PROPERTIES, this.properties)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Override // com.urbanairship.analytics.Event
    public boolean isValid() {
        if (UAStringUtil.isEmpty(this.eventName) || !CustomEventKt.isLengthValid(this.eventName)) {
            UALog.e("Event name must not be null, empty, or larger than 255 characters.", new Object[0]);
            return false;
        }
        BigDecimal bigDecimal = this.eventValue;
        if (bigDecimal != null) {
            BigDecimal bigDecimal2 = MAX_VALUE;
            if (bigDecimal.compareTo(bigDecimal2) > 0) {
                UALog.e("Event value is bigger than " + bigDecimal2, new Object[0]);
                return false;
            }
            BigDecimal bigDecimal3 = MIN_VALUE;
            if (bigDecimal.compareTo(bigDecimal3) < 0) {
                UALog.e("Event value is smaller than " + bigDecimal3, new Object[0]);
                return false;
            }
        }
        String str = this.transactionId;
        if (str != null && !CustomEventKt.isLengthValid(str)) {
            UALog.e("Transaction ID is larger than 255 characters.", new Object[0]);
            return false;
        }
        String str2 = this.interactionId;
        if (str2 != null && !CustomEventKt.isLengthValid(str2)) {
            UALog.e("Interaction ID is larger than 255 characters.", new Object[0]);
            return false;
        }
        String str3 = this.interactionType;
        if (str3 != null && !CustomEventKt.isLengthValid(str3)) {
            UALog.e("Interaction type is larger than 255 characters.", new Object[0]);
            return false;
        }
        String str4 = this.templateType;
        if (str4 == null || CustomEventKt.isLengthValid(str4)) {
            if (CustomEventKt.sizeInBytes(this.properties) <= 65536) {
                return true;
            }
            UALog.e("Total custom properties size (" + CustomEventKt.sizeInBytes(this.properties) + " bytes) exceeds maximum size of 65536 bytes.", new Object[0]);
            return false;
        }
        UALog.e("Template type is larger than 255 characters.", new Object[0]);
        return false;
    }

    @NotNull
    public final CustomEvent track() {
        UAirship.shared().getAnalytics().recordCustomEvent(this);
        return this;
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020 J\u0018\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020!J\u0018\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\"J\u0018\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020#J\u0018\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020$J\u001a\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010\u001f\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010*\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\"J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020#J\u0010\u0010*\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\u0012\u0010+\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0007J\u001e\u0010,\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0003J\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u000100J\u0014\u00101\u001a\u00020\u00002\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0007J\u0012\u00102\u001a\u00020\u00002\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R6\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Lcom/urbanairship/analytics/CustomEvent$Builder;", "", "eventName", "", "(Ljava/lang/String;)V", "getEventName", "()Ljava/lang/String;", "<set-?>", "Lcom/urbanairship/json/JsonValue;", "inAppContext", "getInAppContext", "()Lcom/urbanairship/json/JsonValue;", "interactionId", "getInteractionId", "interactionType", "getInteractionType", "", CustomEvent.PROPERTIES, "getProperties", "()Ljava/util/Map;", "pushSendId", "getPushSendId", "templateType", "getTemplateType", "transactionId", "getTransactionId", "Ljava/math/BigDecimal;", "value", "getValue", "()Ljava/math/BigDecimal;", "addProperty", "name", "Lcom/urbanairship/json/JsonSerializable;", "", "", "", "", "build", "Lcom/urbanairship/analytics/CustomEvent;", "setAttribution", "pushMessage", "Lcom/urbanairship/push/PushMessage;", "setEventValue", "setInAppContext", "setInteraction", "setMessageCenterInteraction", "richPushMessageId", "setProperties", "Lcom/urbanairship/json/JsonMap;", "setTemplateType", "setTransactionId", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCustomEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomEvent.kt\ncom/urbanairship/analytics/CustomEvent$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,688:1\n1#2:689\n*E\n"})
    public static final class Builder {
        private final String eventName;
        private JsonValue inAppContext;
        private String interactionId;
        private String interactionType;
        private Map properties;
        private String pushSendId;
        private String templateType;
        private String transactionId;
        private BigDecimal value;

        public Builder(@Size(max = ScatterMapKt.Sentinel, min = 1) @NotNull String eventName) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            this.eventName = eventName;
            this.properties = new HashMap();
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        @Nullable
        public final BigDecimal getValue() {
            return this.value;
        }

        @Nullable
        public final String getTransactionId() {
            return this.transactionId;
        }

        @Nullable
        public final String getInteractionType() {
            return this.interactionType;
        }

        @Nullable
        public final String getInteractionId() {
            return this.interactionId;
        }

        @Nullable
        public final String getPushSendId() {
            return this.pushSendId;
        }

        @Nullable
        public final String getTemplateType() {
            return this.templateType;
        }

        @NotNull
        public final Map<String, JsonValue> getProperties() {
            return this.properties;
        }

        @Nullable
        public final JsonValue getInAppContext() {
            return this.inAppContext;
        }

        @NotNull
        public final Builder setProperties(@Nullable JsonMap properties) {
            if (properties == null) {
                this.properties.clear();
            } else {
                Map map = this.properties;
                Map<String, JsonValue> map2 = properties.getMap();
                Intrinsics.checkNotNullExpressionValue(map2, "getMap(...)");
                map.putAll(map2);
            }
            return this;
        }

        @NotNull
        public final Builder setEventValue(@Nullable BigDecimal value) {
            this.value = value;
            return this;
        }

        @NotNull
        public final Builder setEventValue(double value) throws NumberFormatException {
            return setEventValue(BigDecimal.valueOf(value));
        }

        @NotNull
        public final Builder setEventValue(@Nullable String value) throws NumberFormatException {
            if (UAStringUtil.isEmpty(value)) {
                this.value = null;
                return this;
            }
            return setEventValue(new BigDecimal(value));
        }

        @NotNull
        public final Builder setEventValue(int value) {
            return setEventValue(new BigDecimal(value));
        }

        @NotNull
        public final Builder setTransactionId(@Size(max = ScatterMapKt.Sentinel, min = 1) @Nullable String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        @NotNull
        public final Builder setMessageCenterInteraction(@NotNull String richPushMessageId) {
            Intrinsics.checkNotNullParameter(richPushMessageId, "richPushMessageId");
            this.interactionType = CustomEvent.MCRAP_TRANSACTION_TYPE;
            this.interactionId = richPushMessageId;
            return this;
        }

        @NotNull
        public final Builder setInteraction(@Size(max = ScatterMapKt.Sentinel, min = 1) @Nullable String interactionType, @Size(max = ScatterMapKt.Sentinel, min = 1) @Nullable String interactionId) {
            this.interactionId = interactionId;
            this.interactionType = interactionType;
            return this;
        }

        @NotNull
        public final Builder setAttribution(@Nullable PushMessage pushMessage) {
            if (pushMessage != null) {
                this.pushSendId = pushMessage.getSendId();
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final Builder setTemplateType(@Size(max = ScatterMapKt.Sentinel, min = 1) @Nullable String templateType) {
            this.templateType = templateType;
            return this;
        }

        @NotNull
        public final Builder addProperty(@Size(min = 1) @NotNull String name, @NotNull JsonSerializable value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Map map = this.properties;
            JsonValue jsonValue = value.toJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            map.put(name, jsonValue);
            return this;
        }

        @NotNull
        public final Builder addProperty(@Size(min = 1) @NotNull String name, @Size(min = 1) @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Map map = this.properties;
            JsonValue jsonValueWrap = JsonValue.wrap(value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            map.put(name, jsonValueWrap);
            return this;
        }

        @NotNull
        public final Builder addProperty(@Size(min = 1) @NotNull String name, int value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Map map = this.properties;
            JsonValue jsonValueWrap = JsonValue.wrap(value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            map.put(name, jsonValueWrap);
            return this;
        }

        @NotNull
        public final Builder addProperty(@Size(min = 1) @NotNull String name, long value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Map map = this.properties;
            JsonValue jsonValueWrap = JsonValue.wrap(value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            map.put(name, jsonValueWrap);
            return this;
        }

        @NotNull
        public final Builder addProperty(@Size(min = 1) @NotNull String name, double value) throws NumberFormatException {
            Intrinsics.checkNotNullParameter(name, "name");
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                throw new NumberFormatException("Infinity or NaN: " + value);
            }
            Map map = this.properties;
            JsonValue jsonValueWrap = JsonValue.wrap(value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            map.put(name, jsonValueWrap);
            return this;
        }

        @NotNull
        public final Builder addProperty(@Size(min = 1) @NotNull String name, boolean value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Map map = this.properties;
            JsonValue jsonValueWrap = JsonValue.wrap(value);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            map.put(name, jsonValueWrap);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final Builder setInAppContext(@Nullable JsonValue value) {
            this.inAppContext = value;
            return this;
        }

        @NotNull
        public final CustomEvent build() {
            return new CustomEvent(this, null);
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001c2\b\b\u0002\u0010\u001a\u001a\u00020\u001dH\u0007J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001e2\b\b\u0002\u0010\u001a\u001a\u00020\u001fH\u0007J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020 2\b\b\u0002\u0010\u001a\u001a\u00020!H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/urbanairship/analytics/CustomEvent$Companion;", "", "()V", "CONVERSION_METADATA", "", "CONVERSION_SEND_ID", "EVENT_NAME", "EVENT_VALUE", "INTERACTION_ID", "INTERACTION_TYPE", "IN_APP_KEY", "LAST_RECEIVED_METADATA", "MAX_CHARACTER_LENGTH", "", "MAX_TOTAL_PROPERTIES_SIZE", "MAX_VALUE", "Ljava/math/BigDecimal;", "MCRAP_TRANSACTION_TYPE", "MIN_VALUE", "PROPERTIES", "TEMPLATE_TYPE", "TRANSACTION_ID", "newBuilder", "Lcom/urbanairship/analytics/CustomEvent$Builder;", "type", "Lcom/urbanairship/analytics/templates/AccountEventTemplate$Type;", CustomEvent.PROPERTIES, "Lcom/urbanairship/analytics/templates/AccountEventTemplate$Properties;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Type;", "Lcom/urbanairship/analytics/templates/MediaEventTemplate$Properties;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Type;", "Lcom/urbanairship/analytics/templates/RetailEventTemplate$Properties;", "Lcom/urbanairship/analytics/templates/SearchEventTemplate$Type;", "Lcom/urbanairship/analytics/templates/SearchEventTemplate$Properties;", "name", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull AccountEventTemplate.Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return newBuilder$default(this, type, (AccountEventTemplate.Properties) null, 2, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull MediaEventTemplate.Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return newBuilder$default(this, type, (MediaEventTemplate.Properties) null, 2, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull RetailEventTemplate.Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return newBuilder$default(this, type, (RetailEventTemplate.Properties) null, 2, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull SearchEventTemplate.Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return newBuilder$default(this, type, (SearchEventTemplate.Properties) null, 2, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Builder newBuilder(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new Builder(name);
        }

        public static /* synthetic */ Builder newBuilder$default(Companion companion, MediaEventTemplate.Type type, MediaEventTemplate.Properties properties, int i, Object obj) {
            MediaEventTemplate.Properties properties2;
            if ((i & 2) != 0) {
                properties2 = new MediaEventTemplate.Properties(null, null, null, null, null, null, null, false, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
            } else {
                properties2 = properties;
            }
            return companion.newBuilder(type, properties2);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull MediaEventTemplate.Type type, @NotNull MediaEventTemplate.Properties properties) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(properties, "properties");
            if (type instanceof MediaEventTemplate.Type.Shared) {
                MediaEventTemplate.Properties.Builder builder = new MediaEventTemplate.Properties.Builder(properties);
                MediaEventTemplate.Type.Shared shared = (MediaEventTemplate.Type.Shared) type;
                properties = builder.setSource$urbanairship_core_release(shared.getSource()).setMedium$urbanairship_core_release(shared.getMedium()).build();
            }
            return newBuilder(type.getEventName()).setTemplateType("media").setProperties(properties.toJsonValue().optMap());
        }

        public static /* synthetic */ Builder newBuilder$default(Companion companion, AccountEventTemplate.Type type, AccountEventTemplate.Properties properties, int i, Object obj) {
            if ((i & 2) != 0) {
                properties = new AccountEventTemplate.Properties(null, null, null, false, 15, null);
            }
            return companion.newBuilder(type, properties);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull AccountEventTemplate.Type type, @NotNull AccountEventTemplate.Properties properties) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(properties, "properties");
            return newBuilder(type.getEventName()).setTemplateType("account").setProperties(properties.toJsonValue().optMap());
        }

        public static /* synthetic */ Builder newBuilder$default(Companion companion, RetailEventTemplate.Type type, RetailEventTemplate.Properties properties, int i, Object obj) {
            if ((i & 2) != 0) {
                properties = new RetailEventTemplate.Properties(null, null, null, null, null, null, null, false, 255, null);
            }
            return companion.newBuilder(type, properties);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull RetailEventTemplate.Type type, @NotNull RetailEventTemplate.Properties properties) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(properties, "properties");
            if (type instanceof RetailEventTemplate.Type.Shared) {
                RetailEventTemplate.Properties.Builder builder = new RetailEventTemplate.Properties.Builder(properties);
                RetailEventTemplate.Type.Shared shared = (RetailEventTemplate.Type.Shared) type;
                properties = builder.setSource$urbanairship_core_release(shared.getSource()).setMedium$urbanairship_core_release(shared.getMedium()).build();
            } else if (type instanceof RetailEventTemplate.Type.Wishlist) {
                RetailEventTemplate.Properties.Builder builder2 = new RetailEventTemplate.Properties.Builder(properties);
                RetailEventTemplate.Type.Wishlist wishlist = (RetailEventTemplate.Type.Wishlist) type;
                properties = builder2.setWhishlistName$urbanairship_core_release(wishlist.getName()).setWishlistId$urbanairship_core_release(wishlist.getId()).build();
            }
            return newBuilder(type.getEventName()).setTemplateType("retail").setProperties(properties.toJsonValue().optMap());
        }

        public static /* synthetic */ Builder newBuilder$default(Companion companion, SearchEventTemplate.Type type, SearchEventTemplate.Properties properties, int i, Object obj) {
            if ((i & 2) != 0) {
                properties = new SearchEventTemplate.Properties(null, null, null, null, null, false, 63, null);
            }
            return companion.newBuilder(type, properties);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final Builder newBuilder(@NotNull SearchEventTemplate.Type type, @NotNull SearchEventTemplate.Properties properties) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(properties, "properties");
            return newBuilder(type.getEventName()).setTemplateType("search").setProperties(properties.toJsonValue().optMap());
        }
    }
}
