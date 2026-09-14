package com.oneid.common;

import com.disney.p026id.android.Guest;
import com.disney.p026id.android.Profile;
import com.disney.p026id.android.Token;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u00006\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u00020\u0002\u001a\u0012\u0010\u0000\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u00020\u0003\u001a\u0012\u0010\u0000\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u00020\u0004\u001a\u0012\u0010\u0000\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u001a#\u0010\b\u001a\u00020\t2\u0016\u0010\n\u001a\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0018\u00010\u000b¢\u0006\u0002\u0010\f\u001a2\u0010\r\u001a\u00020\t2*\u0010\n\u001a&\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0018\u00010\u000ej\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001\u0018\u0001`\u000f¨\u0006\u0010"}, m1836d2 = {"toMap", "", "Lorg/json/JSONObject;", "Lcom/disney/id/android/Profile;", "Lcom/disney/id/android/Guest;", "Lcom/disney/id/android/Token;", "toWriteableMap", "Lcom/facebook/react/bridge/WritableMap;", "getReadableArray", "Lcom/facebook/react/bridge/WritableArray;", "list", "", "([Ljava/util/Map;)Lcom/facebook/react/bridge/WritableArray;", "getReadableArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dlp-mobile_react-native-oneid_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ExtensionsKt {
    @NotNull
    public static final Map<?, ?> toMap(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Object objFromJson = new Gson().fromJson(jSONObject.toString(), (Class<Object>) Map.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    @NotNull
    public static final Map<?, ?> toMap(@NotNull Profile profile) {
        Intrinsics.checkNotNullParameter(profile, "<this>");
        Object objFromJson = new Gson().fromJson(new Gson().toJson(profile), (Class<Object>) Map.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    @NotNull
    public static final Map<?, ?> toMap(@NotNull Guest guest) {
        Intrinsics.checkNotNullParameter(guest, "<this>");
        Object objFromJson = new Gson().fromJson(new Gson().toJson(guest), (Class<Object>) Map.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    @NotNull
    public static final Map<?, ?> toMap(@NotNull Token token) {
        Intrinsics.checkNotNullParameter(token, "<this>");
        Object objFromJson = new Gson().fromJson(new Gson().toJson(token), (Class<Object>) Map.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "fromJson(...)");
        return (Map) objFromJson;
    }

    @NotNull
    public static final WritableMap toWriteableMap(@NotNull Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry entry : MapsKt.asSequence(map)) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                writableMapCreateMap.putNull(String.valueOf(key));
            } else if (value instanceof Boolean) {
                writableMapCreateMap.putBoolean(String.valueOf(key), ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                writableMapCreateMap.putDouble(String.valueOf(key), ((Number) value).doubleValue());
            } else if (value instanceof Integer) {
                writableMapCreateMap.putInt(String.valueOf(key), ((Number) value).intValue());
            } else if (value instanceof String) {
                writableMapCreateMap.putString(String.valueOf(key), (String) value);
            } else if (value instanceof Map) {
                writableMapCreateMap.putMap(String.valueOf(key), toWriteableMap((Map) value));
            } else if (value instanceof Object[]) {
                writableMapCreateMap.putArray(String.valueOf(key), getReadableArray(value instanceof Map[] ? (Map[]) value : null));
            } else {
                boolean z = value instanceof ArrayList;
                if (z) {
                    writableMapCreateMap.putArray(String.valueOf(key), getReadableArrayList(z ? (ArrayList) value : null));
                }
            }
        }
        Intrinsics.checkNotNull(writableMapCreateMap);
        return writableMapCreateMap;
    }

    @NotNull
    public static final WritableArray getReadableArray(@Nullable Map<?, ?>[] mapArr) {
        if (mapArr != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator it = ArrayIteratorKt.iterator(mapArr);
            while (it.hasNext()) {
                writableArrayCreateArray.pushMap(toWriteableMap((Map) it.next()));
            }
            Intrinsics.checkNotNull(writableArrayCreateArray);
            return writableArrayCreateArray;
        }
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray2, "createArray(...)");
        return writableArrayCreateArray2;
    }

    @NotNull
    public static final WritableArray getReadableArrayList(@Nullable ArrayList<Map<?, ?>> arrayList) {
        if (arrayList != null) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<Map<?, ?>> it = arrayList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Map<?, ?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                writableArrayCreateArray.pushMap(toWriteableMap(next));
            }
            Intrinsics.checkNotNull(writableArrayCreateArray);
            return writableArrayCreateArray;
        }
        WritableArray writableArrayCreateArray2 = Arguments.createArray();
        Intrinsics.checkNotNullExpressionValue(writableArrayCreateArray2, "createArray(...)");
        return writableArrayCreateArray2;
    }
}
