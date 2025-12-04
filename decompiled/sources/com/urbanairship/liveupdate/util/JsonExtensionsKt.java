package com.urbanairship.liveupdate.util;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0000¢\u0006\u0002\u0010\b\u001a5\u0010\t\u001a\u00020\n2&\u0010\u000b\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0004\u0012\u00020\r\u0012\u0002\b\u00030\f0\u0006\"\f\u0012\u0004\u0012\u00020\r\u0012\u0002\b\u00030\fH\u0000¢\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0080\b¢\u0006\u0002\u0010\u0012\u001a\"\u0010\u0013\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0080\b¢\u0006\u0002\u0010\u0012\u001a\u0012\u0010\u0014\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0000\u001a\u001a\u0010\u0017\u001a\u00020\n*\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, d2 = {"isNotEmpty", "", "Lcom/urbanairship/json/JsonList;", "(Lcom/urbanairship/json/JsonList;)Z", "jsonListOf", "values", "", "", "([Ljava/lang/Object;)Lcom/urbanairship/json/JsonList;", "jsonMapOf", "Lcom/urbanairship/json/JsonMap;", "fields", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Lcom/urbanairship/json/JsonMap;", "optionalField", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Lcom/urbanairship/json/JsonMap;Ljava/lang/String;)Ljava/lang/Object;", "requireField", "toJsonList", "", "Lcom/urbanairship/json/JsonSerializable;", "toJsonMap", "", "Lcom/urbanairship/json/JsonValue;", "urbanairship-live-update_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJsonExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonExtensions.kt\ncom/urbanairship/liveupdate/util/JsonExtensionsKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n11065#2:71\n11400#2,3:72\n1549#3:75\n1620#3,3:76\n*S KotlinDebug\n*F\n+ 1 JsonExtensions.kt\ncom/urbanairship/liveupdate/util/JsonExtensionsKt\n*L\n20#1:71\n20#1:72,3\n22#1:75\n22#1:76,3\n*E\n"})
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

    public static final boolean isNotEmpty(@NotNull JsonList jsonList) {
        Intrinsics.checkNotNullParameter(jsonList, "<this>");
        return !jsonList.isEmpty();
    }

    @NotNull
    public static final JsonMap toJsonMap(@NotNull Map<String, ? extends JsonValue> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new JsonMap(map);
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
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t2 = (T) Boolean.valueOf(jsonValue.getBoolean(false));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t2;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            T t3 = (T) Long.valueOf(jsonValue.getLong(0L));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t3;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T t4 = (T) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t4;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            T t5 = (T) Integer.valueOf(jsonValue.getInt(0));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t5;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            T t6 = (T) jsonValue.optList();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t6;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            T t7 = (T) jsonValue.optMap();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t7;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            T t8 = (T) jsonValue.getJsonValue();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t8;
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
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            T t2 = (T) Boolean.valueOf(jsonValue.getBoolean(false));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t2;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            T t3 = (T) Long.valueOf(jsonValue.getLong(0L));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t3;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            T t4 = (T) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t4;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            T t5 = (T) Integer.valueOf(jsonValue.getInt(0));
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t5;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            T t6 = (T) jsonValue.optList();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t6;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            T t7 = (T) jsonValue.optMap();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t7;
        }
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
            T t8 = (T) jsonValue.getJsonValue();
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t8;
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
    public static final JsonList toJsonList(@NotNull List<? extends JsonSerializable> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((JsonSerializable) it.next()).getJsonValue());
        }
        return new JsonList(arrayList);
    }

    @NotNull
    public static final JsonList jsonListOf(@NotNull Object... values) throws JsonException {
        Intrinsics.checkNotNullParameter(values, "values");
        ArrayList arrayList = new ArrayList(values.length);
        for (Object obj : values) {
            arrayList.add(JsonValue.wrap(obj));
        }
        return new JsonList(arrayList);
    }
}
