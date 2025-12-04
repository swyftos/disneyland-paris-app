package com.urbanairship.json;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonMap;
import com.urbanairship.util.DateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\b\u001a3\u0010\t\u001a\u00020\u00032&\u0010\n\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000b0\u0006\"\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000b¢\u0006\u0002\u0010\r\u001a7\u0010\u000e\u001a\u00020\u0003*\u00020\u00032&\u0010\n\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000b0\u0006\"\f\u0012\u0004\u0012\u00020\f\u0012\u0002\b\u00030\u000b¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0014\u001a$\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\u0017\u001a=\u0010\u0018\u001a\u0004\u0018\u0001H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001H\u00160\u001aH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f\u001a\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f\u001a\"\u0010\u001e\u001a\u0002H\u0016\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u0086\b¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f\u001a\u0012\u0010 \u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\f\u001a\u001a\u0010!\u001a\u00020\u0001\"\b\b\u0000\u0010\u0016*\u00020\"*\b\u0012\u0004\u0012\u0002H\u00160#\u001a\"\u0010$\u001a\u00020\u0003\"\b\b\u0000\u0010\u0016*\u00020\"*\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001H\u00160%\u001aE\u0010&\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u0016\"\b\b\u0001\u0010'*\u00020\"*\u0002H'2\b\b\u0002\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u0002H\u00160\u001aH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"emptyJsonList", "Lcom/urbanairship/json/JsonList;", "emptyJsonMap", "Lcom/urbanairship/json/JsonMap;", "jsonListOf", "values", "", "", "([Ljava/lang/Object;)Lcom/urbanairship/json/JsonList;", "jsonMapOf", "fields", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Lcom/urbanairship/json/JsonMap;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "(Lcom/urbanairship/json/JsonMap;[Lkotlin/Pair;)Lcom/urbanairship/json/JsonMap;", "isoDateAsMilliseconds", "", "key", "defaultValue", "(Lcom/urbanairship/json/JsonMap;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "optionalField", ExifInterface.GPS_DIRECTION_TRUE, "(Lcom/urbanairship/json/JsonMap;Ljava/lang/String;)Ljava/lang/Object;", "optionalFieldConverted", "builder", "Lkotlin/Function1;", "(Lcom/urbanairship/json/JsonMap;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "optionalList", "optionalMap", "requireField", "requireList", "requireMap", "toJsonList", "Lcom/urbanairship/json/JsonSerializable;", "", "toJsonMap", "", "tryParse", "R", "logError", "", "parser", "(Lcom/urbanairship/json/JsonSerializable;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJsonExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,178:1\n79#1,16:193\n44#1,15:209\n44#1,15:224\n79#1,16:239\n79#1,16:255\n79#1,16:271\n11065#2:179\n11400#2,3:180\n1549#3:183\n1620#3,3:184\n1238#3,4:189\n453#4:187\n403#4:188\n*S KotlinDebug\n*F\n+ 1 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n107#1:193,16\n126#1:209,15\n136#1:224,15\n147#1:239,16\n157#1:255,16\n172#1:271,16\n29#1:179\n29#1:180,3\n32#1:183\n32#1:184,3\n35#1:189,4\n35#1:187\n35#1:188\n*E\n"})
/* loaded from: classes5.dex */
public final class JsonExtensionsKt {
    @NotNull
    public static final JsonMap jsonMapOf(@NotNull Pair<String, ?>... fields) throws JsonException {
        Intrinsics.checkNotNullParameter(fields, "fields");
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        for (Pair<String, ?> pair : fields) {
            builderNewBuilder.put(pair.component1(), JsonValue.wrap(pair.component2()));
        }
        JsonMap jsonMapBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        return jsonMapBuild;
    }

    public static /* synthetic */ Object tryParse$default(JsonSerializable jsonSerializable, boolean z, Function1 parser, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(jsonSerializable, "<this>");
        Intrinsics.checkNotNullParameter(parser, "parser");
        try {
            return parser.invoke(jsonSerializable);
        } catch (JsonException e) {
            if (z) {
                UALog.e("Failed to parse json", e);
            }
            return null;
        }
    }

    @Nullable
    public static final <T, R extends JsonSerializable> T tryParse(@NotNull R r, boolean z, @NotNull Function1<? super R, ? extends T> parser) {
        Intrinsics.checkNotNullParameter(r, "<this>");
        Intrinsics.checkNotNullParameter(parser, "parser");
        try {
            return parser.invoke(r);
        } catch (JsonException e) {
            if (z) {
                UALog.e("Failed to parse json", e);
            }
            return null;
        }
    }

    public static final /* synthetic */ <T> T requireField(JsonMap jsonMap, String key) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            throw new JsonException("Missing required field: '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            T t = (T) jsonValue.optString();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            T t2 = (T) jsonValue.optString();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t2;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t3 = (T) Boolean.valueOf(jsonValue.getBoolean(false));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t3;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            T t4 = (T) Long.valueOf(jsonValue.getLong(0L));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t4;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            T t5 = (T) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t5;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T t6 = (T) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t6;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T t7 = (T) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t7;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            T t8 = (T) Integer.valueOf(jsonValue.getInt(0));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t8;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            T t9 = (T) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t9;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            T t10 = (T) jsonValue.optList();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t10;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            T t11 = (T) jsonValue.optMap();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t11;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            T t12 = (T) jsonValue.toJsonValue();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t12;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid type '");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getSimpleName());
        sb.append("' for field '");
        sb.append(key);
        sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
        throw new JsonException(sb.toString());
    }

    @NotNull
    public static final JsonList requireList(@NotNull JsonMap jsonMap, @NotNull String key) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            throw new JsonException("Missing required field: '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonList.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString != null) {
                return (JsonList) objOptString;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 != null) {
                return (JsonList) objOptString2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (JsonList) Boolean.valueOf(jsonValue.getBoolean(false));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (JsonList) Long.valueOf(jsonValue.getLong(0L));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            return (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (JsonList) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return (JsonList) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return (JsonList) Integer.valueOf(jsonValue.getInt(0));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            return (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonList jsonListOptList = jsonValue.optList();
            if (jsonListOptList != null) {
                return jsonListOptList;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonSerializable jsonSerializableOptMap = jsonValue.optMap();
            if (jsonSerializableOptMap != null) {
                return (JsonList) jsonSerializableOptMap;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            JsonSerializable jsonValue2 = jsonValue.toJsonValue();
            if (jsonValue2 != null) {
                return (JsonList) jsonValue2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
    }

    @NotNull
    public static final JsonMap requireMap(@NotNull JsonMap jsonMap, @NotNull String key) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            throw new JsonException("Missing required field: '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString != null) {
                return (JsonMap) objOptString;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 != null) {
                return (JsonMap) objOptString2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (JsonMap) Long.valueOf(jsonValue.getLong(0L));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            return (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            return (JsonMap) Integer.valueOf(jsonValue.getInt(0));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            return (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            JsonSerializable jsonSerializableOptList = jsonValue.optList();
            if (jsonSerializableOptList != null) {
                return (JsonMap) jsonSerializableOptList;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonMap jsonMapOptMap = jsonValue.optMap();
            if (jsonMapOptMap != null) {
                return jsonMapOptMap;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            JsonSerializable jsonValue2 = jsonValue.toJsonValue();
            if (jsonValue2 != null) {
                return (JsonMap) jsonValue2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
    }

    @NotNull
    public static final JsonMap extend(@NotNull JsonMap jsonMap, @NotNull Pair<String, ?>... fields) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(fields, "fields");
        JsonMap.Builder builderPutAll = JsonMap.newBuilder().putAll(jsonMap);
        for (Pair<String, ?> pair : fields) {
            builderPutAll.put(pair.component1(), JsonValue.wrap(pair.component2()));
        }
        JsonMap jsonMapBuild = builderPutAll.build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        return jsonMapBuild;
    }

    @Nullable
    public static final Long isoDateAsMilliseconds(@NotNull JsonMap jsonMap, @NotNull String key, @Nullable Long l) throws JsonException {
        String strOptString;
        long iso8601;
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            JsonValue jsonValue = jsonMap.get(key);
            if (jsonValue == null) {
                strOptString = null;
            } else {
                Intrinsics.checkNotNull(jsonValue);
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
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
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
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.toJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
            }
            if (strOptString == null) {
                return null;
            }
            if (l != null) {
                iso8601 = DateUtils.parseIso8601(strOptString, l.longValue());
            } else {
                iso8601 = DateUtils.parseIso8601(strOptString);
            }
            return Long.valueOf(iso8601);
        } catch (Exception e) {
            throw new JsonException("Unable to parse value as date: " + jsonMap.get(key), e);
        }
    }

    public static final /* synthetic */ <T> T optionalField(JsonMap jsonMap, String key) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            T t = (T) jsonValue.optString();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            T t2 = (T) jsonValue.optString();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t2;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t3 = (T) Boolean.valueOf(jsonValue.getBoolean(false));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t3;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            T t4 = (T) Long.valueOf(jsonValue.getLong(0L));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t4;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            T t5 = (T) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t5;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T t6 = (T) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t6;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            T t7 = (T) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t7;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            T t8 = (T) Integer.valueOf(jsonValue.getInt(0));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t8;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            T t9 = (T) Integer.valueOf(jsonValue.getInt(0));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t9;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            T t10 = (T) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t10;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            T t11 = (T) jsonValue.optList();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t11;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            T t12 = (T) jsonValue.optMap();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t12;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            T t13 = (T) jsonValue.toJsonValue();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t13;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid type '");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getSimpleName());
        sb.append("' for field '");
        sb.append(key);
        sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
        throw new JsonException(sb.toString());
    }

    public static final /* synthetic */ <T> T optionalFieldConverted(JsonMap jsonMap, final String key, Function1<? super String, ? extends T> builder) throws JsonException {
        String strOptString;
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(builder, "builder");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            strOptString = null;
        } else {
            Intrinsics.checkNotNull(jsonValue);
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
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
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
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
        }
        T tInvoke = strOptString != null ? builder.invoke(strOptString) : null;
        if (tInvoke == null) {
            Intrinsics.needClassReification();
            UALog.e$default(null, new Function0<String>() { // from class: com.urbanairship.json.JsonExtensionsKt.optionalFieldConverted.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to parse ");
                    Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                    sb.append(Reflection.getOrCreateKotlinClass(Object.class).getSimpleName());
                    sb.append(" from ");
                    sb.append(key);
                    return sb.toString();
                }
            }, 1, null);
        }
        return tInvoke;
    }

    @Nullable
    public static final JsonList optionalList(@NotNull JsonMap jsonMap, @NotNull String key) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            return null;
        }
        Intrinsics.checkNotNull(jsonValue);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonList.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString != null) {
                return (JsonList) objOptString;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 != null) {
                return (JsonList) objOptString2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (JsonList) Boolean.valueOf(jsonValue.getBoolean(false));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (JsonList) Long.valueOf(jsonValue.getLong(0L));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            return (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (JsonList) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return (JsonList) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        }
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                return (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            }
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonList jsonListOptList = jsonValue.optList();
                if (jsonListOptList != null) {
                    return jsonListOptList;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonSerializable jsonSerializableOptMap = jsonValue.optMap();
                if (jsonSerializableOptMap != null) {
                    return (JsonList) jsonSerializableOptMap;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                JsonSerializable jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 != null) {
                    return (JsonList) jsonValue2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        return (JsonList) Integer.valueOf(jsonValue.getInt(0));
    }

    @Nullable
    public static final JsonMap optionalMap(@NotNull JsonMap jsonMap, @NotNull String key) throws JsonException {
        Intrinsics.checkNotNullParameter(jsonMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        JsonValue jsonValue = jsonMap.get(key);
        if (jsonValue == null) {
            return null;
        }
        Intrinsics.checkNotNull(jsonValue);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue.optString();
            if (objOptString != null) {
                return (JsonMap) objOptString;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue.optString();
            if (objOptString2 != null) {
                return (JsonMap) objOptString2;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            return (JsonMap) Boolean.valueOf(jsonValue.getBoolean(false));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            return (JsonMap) Long.valueOf(jsonValue.getLong(0L));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            return (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            return (JsonMap) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            return (JsonMap) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        }
        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                return (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            }
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                JsonSerializable jsonSerializableOptList = jsonValue.optList();
                if (jsonSerializableOptList != null) {
                    return (JsonMap) jsonSerializableOptList;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                JsonMap jsonMapOptMap = jsonValue.optMap();
                if (jsonMapOptMap != null) {
                    return jsonMapOptMap;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                JsonSerializable jsonValue2 = jsonValue.toJsonValue();
                if (jsonValue2 != null) {
                    return (JsonMap) jsonValue2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
            }
            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field '" + key + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        return (JsonMap) Integer.valueOf(jsonValue.getInt(0));
    }

    public static /* synthetic */ Long isoDateAsMilliseconds$default(JsonMap jsonMap, String str, Long l, int i, Object obj) throws JsonException {
        if ((i & 2) != 0) {
            l = null;
        }
        return isoDateAsMilliseconds(jsonMap, str, l);
    }

    @NotNull
    public static final JsonMap emptyJsonMap() {
        JsonMap EMPTY_MAP = JsonMap.EMPTY_MAP;
        Intrinsics.checkNotNullExpressionValue(EMPTY_MAP, "EMPTY_MAP");
        return EMPTY_MAP;
    }

    @NotNull
    public static final JsonList emptyJsonList() {
        JsonList EMPTY_LIST = JsonList.EMPTY_LIST;
        Intrinsics.checkNotNullExpressionValue(EMPTY_LIST, "EMPTY_LIST");
        return EMPTY_LIST;
    }

    @NotNull
    public static final <T extends JsonSerializable> JsonList toJsonList(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JsonSerializable) it.next()).toJsonValue());
        }
        return new JsonList(arrayList);
    }

    @NotNull
    public static final <T extends JsonSerializable> JsonMap toJsonMap(@NotNull Map<String, ? extends T> map) {
        JsonValue jsonValue;
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            JsonSerializable jsonSerializable = (JsonSerializable) entry.getValue();
            if (jsonSerializable == null || (jsonValue = jsonSerializable.toJsonValue()) == null) {
                jsonValue = JsonValue.NULL;
            }
            linkedHashMap.put(key, jsonValue);
        }
        return new JsonMap(linkedHashMap);
    }

    @NotNull
    public static final JsonList jsonListOf(@NotNull Object... values) {
        Intrinsics.checkNotNullParameter(values, "values");
        ArrayList arrayList = new ArrayList(values.length);
        for (Object obj : values) {
            arrayList.add(JsonValue.wrap(obj));
        }
        return new JsonList(arrayList);
    }
}
