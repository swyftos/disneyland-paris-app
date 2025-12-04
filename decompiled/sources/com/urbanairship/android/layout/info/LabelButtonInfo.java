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

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/info/LabelButtonInfo;", "Lcom/urbanairship/android/layout/info/ButtonInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "label", "Lcom/urbanairship/android/layout/info/LabelInfo;", "getLabel", "()Lcom/urbanairship/android/layout/info/LabelInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelButtonInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LabelButtonInfo\n*L\n600#1:945,15\n*E\n"})
/* loaded from: classes5.dex */
public final class LabelButtonInfo extends ButtonInfo {
    private final LabelInfo label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelButtonInfo(@NotNull JsonMap json) throws JsonException {
        JsonMap jsonMapOptMap;
        super(json);
        Intrinsics.checkNotNullParameter(json, "json");
        JsonValue jsonValue = json.get("label");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'label" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue.optList();
            if (jsonSerializableOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonSerializableOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            jsonMapOptMap = jsonValue.optMap();
            if (jsonMapOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'label" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            jsonMapOptMap = (JsonMap) jsonValue2;
        }
        this.label = new LabelInfo(jsonMapOptMap);
    }

    @NotNull
    public final LabelInfo getLabel() {
        return this.label;
    }
}
