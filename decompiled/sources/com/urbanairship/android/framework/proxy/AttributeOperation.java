package com.urbanairship.android.framework.proxy;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BA\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000fHÆ\u0003JM\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AttributeOperation;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "attribute", "", "value", "Lcom/urbanairship/json/JsonValue;", "valueType", "Lcom/urbanairship/android/framework/proxy/AttributeValueType;", "action", "Lcom/urbanairship/android/framework/proxy/AttributeOperationAction;", Constants.FirelogAnalytics.PARAM_INSTANCE_ID, "expiry", "Ljava/util/Date;", "(Ljava/lang/String;Lcom/urbanairship/json/JsonValue;Lcom/urbanairship/android/framework/proxy/AttributeValueType;Lcom/urbanairship/android/framework/proxy/AttributeOperationAction;Ljava/lang/String;Ljava/util/Date;)V", "getAction", "()Lcom/urbanairship/android/framework/proxy/AttributeOperationAction;", "getAttribute", "()Ljava/lang/String;", "getExpiry", "()Ljava/util/Date;", "getInstanceId", "getValue", "()Lcom/urbanairship/json/JsonValue;", "getValueType", "()Lcom/urbanairship/android/framework/proxy/AttributeValueType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAttributeOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttributeOperation.kt\ncom/urbanairship/android/framework/proxy/AttributeOperation\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,75:1\n44#2,15:76\n79#2,16:91\n44#2,15:107\n79#2,16:122\n79#2,16:138\n*S KotlinDebug\n*F\n+ 1 AttributeOperation.kt\ncom/urbanairship/android/framework/proxy/AttributeOperation\n*L\n29#1:76,15\n31#1:91,16\n35#1:107,15\n37#1:122,16\n38#1:138,16\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class AttributeOperation {
    private final AttributeOperationAction action;
    private final String attribute;
    private final Date expiry;
    private final String instanceId;
    private final JsonValue value;
    private final AttributeValueType valueType;

    public static /* synthetic */ AttributeOperation copy$default(AttributeOperation attributeOperation, String str, JsonValue jsonValue, AttributeValueType attributeValueType, AttributeOperationAction attributeOperationAction, String str2, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attributeOperation.attribute;
        }
        if ((i & 2) != 0) {
            jsonValue = attributeOperation.value;
        }
        JsonValue jsonValue2 = jsonValue;
        if ((i & 4) != 0) {
            attributeValueType = attributeOperation.valueType;
        }
        AttributeValueType attributeValueType2 = attributeValueType;
        if ((i & 8) != 0) {
            attributeOperationAction = attributeOperation.action;
        }
        AttributeOperationAction attributeOperationAction2 = attributeOperationAction;
        if ((i & 16) != 0) {
            str2 = attributeOperation.instanceId;
        }
        String str3 = str2;
        if ((i & 32) != 0) {
            date = attributeOperation.expiry;
        }
        return attributeOperation.copy(str, jsonValue2, attributeValueType2, attributeOperationAction2, str3, date);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAttribute() {
        return this.attribute;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JsonValue getValue() {
        return this.value;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final AttributeValueType getValueType() {
        return this.valueType;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final AttributeOperationAction getAction() {
        return this.action;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Date getExpiry() {
        return this.expiry;
    }

    @NotNull
    public final AttributeOperation copy(@NotNull String attribute, @Nullable JsonValue value, @Nullable AttributeValueType valueType, @NotNull AttributeOperationAction action, @Nullable String instanceId, @Nullable Date expiry) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(action, "action");
        return new AttributeOperation(attribute, value, valueType, action, instanceId, expiry);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttributeOperation)) {
            return false;
        }
        AttributeOperation attributeOperation = (AttributeOperation) other;
        return Intrinsics.areEqual(this.attribute, attributeOperation.attribute) && Intrinsics.areEqual(this.value, attributeOperation.value) && this.valueType == attributeOperation.valueType && this.action == attributeOperation.action && Intrinsics.areEqual(this.instanceId, attributeOperation.instanceId) && Intrinsics.areEqual(this.expiry, attributeOperation.expiry);
    }

    public int hashCode() {
        int iHashCode = this.attribute.hashCode() * 31;
        JsonValue jsonValue = this.value;
        int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        AttributeValueType attributeValueType = this.valueType;
        int iHashCode3 = (((iHashCode2 + (attributeValueType == null ? 0 : attributeValueType.hashCode())) * 31) + this.action.hashCode()) * 31;
        String str = this.instanceId;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Date date = this.expiry;
        return iHashCode4 + (date != null ? date.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AttributeOperation(attribute=" + this.attribute + ", value=" + this.value + ", valueType=" + this.valueType + ", action=" + this.action + ", instanceId=" + this.instanceId + ", expiry=" + this.expiry + ")";
    }

    public AttributeOperation(@NotNull String attribute, @Nullable JsonValue jsonValue, @Nullable AttributeValueType attributeValueType, @NotNull AttributeOperationAction action, @Nullable String str, @Nullable Date date) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(action, "action");
        this.attribute = attribute;
        this.value = jsonValue;
        this.valueType = attributeValueType;
        this.action = action;
        this.instanceId = str;
        this.expiry = date;
    }

    public /* synthetic */ AttributeOperation(String str, JsonValue jsonValue, AttributeValueType attributeValueType, AttributeOperationAction attributeOperationAction, String str2, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jsonValue, attributeValueType, attributeOperationAction, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : date);
    }

    @NotNull
    public final String getAttribute() {
        return this.attribute;
    }

    @Nullable
    public final JsonValue getValue() {
        return this.value;
    }

    @Nullable
    public final AttributeValueType getValueType() {
        return this.valueType;
    }

    @NotNull
    public final AttributeOperationAction getAction() {
        return this.action;
    }

    @Nullable
    public final String getInstanceId() {
        return this.instanceId;
    }

    @Nullable
    public final Date getExpiry() {
        return this.expiry;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AttributeOperation(@NotNull JsonMap json) throws JsonException {
        String strOptString;
        String str;
        String strOptString2;
        AttributeValueType attributeValueTypeValueOf;
        String strOptString3;
        String strOptString4;
        String str2;
        Long lValueOf;
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue = json.get("key");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'key" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue2;
        }
        String str3 = strOptString;
        JsonValue jsonValue3 = json.get("value");
        JsonValue jsonValue4 = json.get("type");
        if (jsonValue4 == null) {
            str = "' for field '";
            strOptString2 = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString2 = jsonValue4.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString2 = jsonValue4.optString();
                if (strOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString2 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                str = "' for field '";
                strOptString2 = (String) Long.valueOf(jsonValue4.getLong(0L));
            } else {
                str = "' for field '";
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList2 = jsonValue4.optList();
                    if (objOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap2 = jsonValue4.optMap();
                    if (objOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue5 = jsonValue4.getJsonValue();
                    if (jsonValue5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) jsonValue5;
                }
            }
            str = "' for field '";
        }
        if (strOptString2 != null) {
            String upperCase = strOptString2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            attributeValueTypeValueOf = AttributeValueType.valueOf(upperCase);
        } else {
            attributeValueTypeValueOf = null;
        }
        JsonValue jsonValue6 = json.get("action");
        if (jsonValue6 == null) {
            throw new JsonException("Missing required field: 'action" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString3 = jsonValue6.optString();
            if (strOptString3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString3 = jsonValue6.optString();
            if (strOptString3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList3 = jsonValue6.optList();
            if (objOptList3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString3 = (String) objOptList3;
        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap3 = jsonValue6.optMap();
            if (objOptMap3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString3 = (String) objOptMap3;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "action" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue7 = jsonValue6.getJsonValue();
            if (jsonValue7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString3 = (String) jsonValue7;
        }
        String upperCase2 = strOptString3.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        AttributeOperationAction attributeOperationActionValueOf = AttributeOperationAction.valueOf(upperCase2);
        JsonValue jsonValue8 = json.get("instance_id");
        if (jsonValue8 == null) {
            str2 = null;
        } else {
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString4 = jsonValue8.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString4 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString4 = (String) Long.valueOf(jsonValue8.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString4 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue8.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString4 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString4 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                strOptString4 = (String) Integer.valueOf(jsonValue8.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString4 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue8.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                strOptString4 = (String) jsonValue8.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                strOptString4 = (String) jsonValue8.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "instance_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                strOptString4 = (String) jsonValue8.getJsonValue();
            }
            str2 = strOptString4;
        }
        JsonValue jsonValue9 = json.get("expiration_milliseconds");
        if (jsonValue9 == null) {
            lValueOf = null;
        } else {
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue9.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue9.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                lValueOf = (Long) Boolean.valueOf(jsonValue9.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                lValueOf = Long.valueOf(jsonValue9.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                lValueOf = (Long) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                lValueOf = (Long) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                lValueOf = (Long) Integer.valueOf(jsonValue9.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList4 = jsonValue9.optList();
                if (objOptList4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptList4;
            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap4 = jsonValue9.optMap();
                if (objOptMap4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptMap4;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + Long.class.getSimpleName() + str + "expiration_milliseconds" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue10 = jsonValue9.getJsonValue();
                if (jsonValue10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) jsonValue10;
            }
        }
        this(str3, jsonValue3, attributeValueTypeValueOf, attributeOperationActionValueOf, str2, lValueOf != null ? new Date(lValueOf.longValue()) : null);
    }
}
