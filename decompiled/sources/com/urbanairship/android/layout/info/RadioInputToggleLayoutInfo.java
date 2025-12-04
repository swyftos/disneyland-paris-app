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

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/info/RadioInputToggleLayoutInfo;", "Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "reportingValue", "Lcom/urbanairship/json/JsonValue;", "getReportingValue", "()Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/RadioInputToggleLayoutInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/RadioInputToggleLayoutInfo\n*L\n910#1:945,15\n*E\n"})
/* loaded from: classes5.dex */
public final class RadioInputToggleLayoutInfo extends BaseToggleLayoutInfo {
    private final JsonValue reportingValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioInputToggleLayoutInfo(@NotNull JsonMap json) throws JsonException {
        JsonValue jsonValue;
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue2 = json.get("reporting_value");
        if (jsonValue2 == null) {
            throw new JsonException("Missing required field: 'reporting_value" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonValue.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue2.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue2.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonValue = (JsonValue) Boolean.valueOf(jsonValue2.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonValue = (JsonValue) Long.valueOf(jsonValue2.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonValue = (JsonValue) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonValue = (JsonValue) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonValue = (JsonValue) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonValue = (JsonValue) Integer.valueOf(jsonValue2.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonValue = (JsonValue) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue2.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonSerializable jsonSerializableOptMap = jsonValue2.optMap();
            if (jsonSerializableOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
            jsonValue = (JsonValue) jsonSerializableOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonValue.class.getSimpleName() + "' for field 'reporting_value" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            jsonValue = jsonValue2.getJsonValue();
            if (jsonValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonValue");
            }
        }
        this.reportingValue = jsonValue;
    }

    @NotNull
    public final JsonValue getReportingValue() {
        return this.reportingValue;
    }
}
