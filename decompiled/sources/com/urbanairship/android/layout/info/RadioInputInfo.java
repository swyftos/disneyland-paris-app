package com.urbanairship.android.layout.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/info/RadioInputInfo;", "Lcom/urbanairship/android/layout/info/CheckableInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "attributeValue", "Lcom/urbanairship/json/JsonValue;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "getAttributeValue", "()Lcom/urbanairship/json/JsonValue;", "reportingValue", "getReportingValue", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/RadioInputInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n79#2,16:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/RadioInputInfo\n*L\n620#1:945,15\n621#1:960,16\n*E\n"})
/* loaded from: classes5.dex */
public final class RadioInputInfo extends CheckableInfo {
    private final JsonValue attributeValue;
    private final JsonValue reportingValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioInputInfo(@NotNull JsonMap json) throws JsonException {
        JsonValue jsonValue;
        JsonValue jsonValue2;
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue3 = json.get("reporting_value");
        if (jsonValue3 == null) {
            throw new JsonException("Missing required field: 'reporting_value" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue3.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue3.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonValue = (JsonValue) Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonValue = (JsonValue) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonValue = (JsonValue) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonValue = (JsonValue) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonValue = (JsonValue) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue3.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonSerializable jsonSerializableOptMap = jsonValue3.optMap();
            if (jsonSerializableOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) jsonSerializableOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'reporting_value" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue = jsonValue3.getJsonValue();
            if (jsonValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
        }
        this.reportingValue = jsonValue;
        JsonValue jsonValue4 = json.get("attribute_value");
        if (jsonValue4 == null) {
            jsonValue2 = null;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonValue.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                jsonValue2 = (JsonValue) jsonValue4.optString();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonValue2 = (JsonValue) Boolean.valueOf(jsonValue4.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonValue2 = (JsonValue) Long.valueOf(jsonValue4.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonValue2 = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonValue2 = (JsonValue) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonValue2 = (JsonValue) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jsonValue2 = (JsonValue) Integer.valueOf(jsonValue4.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonValue2 = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonValue2 = (JsonValue) jsonValue4.optList();
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                jsonValue2 = (JsonValue) jsonValue4.optMap();
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'attribute_value" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue2 = jsonValue4.getJsonValue();
            }
        }
        this.attributeValue = jsonValue2;
    }

    @NotNull
    public final JsonValue getReportingValue() {
        return this.reportingValue;
    }

    @Nullable
    public final JsonValue getAttributeValue() {
        return this.attributeValue;
    }
}
