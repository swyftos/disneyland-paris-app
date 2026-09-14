package com.contentsquare.android.sdk;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.z5 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nSerializationExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SerializationExtensions.kt\ncom/contentsquare/android/internal/util/SerializationExtensionsKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,30:1\n215#2,2:31\n*S KotlinDebug\n*F\n+ 1 SerializationExtensions.kt\ncom/contentsquare/android/internal/util/SerializationExtensionsKt\n*L\n25#1:31,2\n*E\n"})
public final class C2946z5 {
    @NotNull
    /* JADX INFO: renamed from: a */
    public static final JsonElement m1253a(@Nullable Object obj) {
        String string;
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Intrinsics.checkNotNullParameter(map, "<this>");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put(key, m1253a(value));
            }
            return new JsonObject(linkedHashMap);
        }
        if (obj instanceof Boolean) {
            return JsonElementKt.JsonPrimitive((Boolean) obj);
        }
        if (obj instanceof Number) {
            return JsonElementKt.JsonPrimitive((Number) obj);
        }
        if (obj instanceof String) {
            string = (String) obj;
        } else {
            if (!(obj instanceof Enum)) {
                throw new IllegalStateException("Can't serialize unknown type: " + obj);
            }
            string = obj.toString();
        }
        return JsonElementKt.JsonPrimitive(string);
    }
}
