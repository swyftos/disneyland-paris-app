package com.urbanairship.reactnative;

import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\nH\u0007J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0017\u001a\u00020\u0006R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/reactnative/Utils;", "", "<init>", "()V", "eventMap", "", "", "", "Lcom/urbanairship/android/framework/proxy/EventType;", "convertArray", "Lcom/urbanairship/json/JsonValue;", "array", "Lcom/facebook/react/bridge/ReadableArray;", "convertDynamic", "obj", "Lcom/facebook/react/bridge/Dynamic;", "convertMap", "Lcom/urbanairship/json/JsonMap;", "map", "Lcom/facebook/react/bridge/ReadableMap;", "convertJsonValue", "value", "parseEventTypes", "string", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Utils {

    @NotNull
    public static final Utils INSTANCE = new Utils();
    private static final Map eventMap = MapsKt.mapOf(TuplesKt.to("com.airship.deep_link", CollectionsKt.listOf(EventType.DEEP_LINK_RECEIVED)), TuplesKt.to("com.airship.channel_created", CollectionsKt.listOf(EventType.CHANNEL_CREATED)), TuplesKt.to("com.airship.push_token_received", CollectionsKt.listOf(EventType.PUSH_TOKEN_RECEIVED)), TuplesKt.to("com.airship.message_center_updated", CollectionsKt.listOf(EventType.MESSAGE_CENTER_UPDATED)), TuplesKt.to("com.airship.display_message_center", CollectionsKt.listOf(EventType.DISPLAY_MESSAGE_CENTER)), TuplesKt.to("com.airship.display_preference_center", CollectionsKt.listOf(EventType.DISPLAY_PREFERENCE_CENTER)), TuplesKt.to("com.airship.notification_response", CollectionsKt.listOf((Object[]) new EventType[]{EventType.FOREGROUND_NOTIFICATION_RESPONSE_RECEIVED, EventType.BACKGROUND_NOTIFICATION_RESPONSE_RECEIVED})), TuplesKt.to("com.airship.push_received", CollectionsKt.listOf((Object[]) new EventType[]{EventType.FOREGROUND_PUSH_RECEIVED, EventType.BACKGROUND_PUSH_RECEIVED})), TuplesKt.to("com.airship.notification_status_changed", CollectionsKt.listOf(EventType.NOTIFICATION_STATUS_CHANGED)), TuplesKt.to("com.airship.pending_embedded_updated", CollectionsKt.listOf(EventType.PENDING_EMBEDDED_UPDATED)));

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.String.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Utils() {
    }

    @NotNull
    public final JsonValue convertArray(@Nullable ReadableArray array) {
        if (array == null) {
            JsonValue jsonValue = JsonValue.NULL;
            Intrinsics.checkNotNull(jsonValue);
            return jsonValue;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            arrayList.add(convertDynamic(array.getDynamic(i)));
        }
        JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(arrayList);
        Intrinsics.checkNotNull(jsonValueWrapOpt);
        return jsonValueWrapOpt;
    }

    @JvmStatic
    @NotNull
    public static final JsonValue convertDynamic(@Nullable Dynamic obj) {
        if (obj == null) {
            JsonValue jsonValue = JsonValue.NULL;
            Intrinsics.checkNotNull(jsonValue);
            return jsonValue;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[obj.getType().ordinal()]) {
            case 1:
                JsonValue NULL = JsonValue.NULL;
                Intrinsics.checkNotNullExpressionValue(NULL, "NULL");
                return NULL;
            case 2:
                JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(Boolean.valueOf(obj.asBoolean()));
                Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
                return jsonValueWrapOpt;
            case 3:
                JsonValue jsonValueWrapOpt2 = JsonValue.wrapOpt(obj.asString());
                Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt2, "wrapOpt(...)");
                return jsonValueWrapOpt2;
            case 4:
                JsonValue jsonValueWrapOpt3 = JsonValue.wrapOpt(Double.valueOf(obj.asDouble()));
                Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt3, "wrapOpt(...)");
                return jsonValueWrapOpt3;
            case 5:
                JsonValue jsonValue2 = convertMap(obj.asMap()).getJsonValue();
                Intrinsics.checkNotNull(jsonValue2);
                return jsonValue2;
            case 6:
                return INSTANCE.convertArray(obj.asArray());
            default:
                JsonValue NULL2 = JsonValue.NULL;
                Intrinsics.checkNotNullExpressionValue(NULL2, "NULL");
                return NULL2;
        }
    }

    @JvmStatic
    @NotNull
    public static final JsonMap convertMap(@Nullable ReadableMap map) {
        if (map == null) {
            JsonMap EMPTY_MAP = JsonMap.EMPTY_MAP;
            Intrinsics.checkNotNullExpressionValue(EMPTY_MAP, "EMPTY_MAP");
            return EMPTY_MAP;
        }
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = map.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            builderNewBuilder.putOpt(strNextKey, convertDynamic(map.getDynamic(strNextKey)));
        }
        JsonMap jsonMapBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        return jsonMapBuild;
    }

    @JvmStatic
    @Nullable
    public static final Object convertJsonValue(@NotNull JsonValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.isNull()) {
            return null;
        }
        if (value.isJsonList()) {
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator<JsonValue> it = value.optList().iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.isNull()) {
                    writableArrayCreateArray.pushNull();
                } else if (next.isBoolean()) {
                    writableArrayCreateArray.pushBoolean(next.getBoolean(false));
                } else if (next.isInteger()) {
                    writableArrayCreateArray.pushInt(next.getInt(0));
                } else if (next.isDouble() || next.isNumber()) {
                    writableArrayCreateArray.pushDouble(next.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (next.isString()) {
                    writableArrayCreateArray.pushString(next.getString());
                } else if (next.isJsonList()) {
                    Intrinsics.checkNotNull(next);
                    writableArrayCreateArray.pushArray((WritableArray) convertJsonValue(next));
                } else if (next.isJsonMap()) {
                    Intrinsics.checkNotNull(next);
                    writableArrayCreateArray.pushMap((WritableMap) convertJsonValue(next));
                }
            }
            return writableArrayCreateArray;
        }
        if (value.isJsonMap()) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            for (Map.Entry<String, JsonValue> entry : value.optMap().entrySet()) {
                Intrinsics.checkNotNull(entry);
                String key = entry.getKey();
                JsonValue value2 = entry.getValue();
                if (value2.isNull()) {
                    Intrinsics.checkNotNull(key);
                    writableMapCreateMap.putNull(key);
                } else if (value2.isBoolean()) {
                    Intrinsics.checkNotNull(key);
                    writableMapCreateMap.putBoolean(key, value2.getBoolean(false));
                } else if (value2.isInteger()) {
                    Intrinsics.checkNotNull(key);
                    writableMapCreateMap.putInt(key, value2.getInt(0));
                } else if (value2.isDouble() || value2.isNumber()) {
                    Intrinsics.checkNotNull(key);
                    writableMapCreateMap.putDouble(key, value2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (value2.isString()) {
                    Intrinsics.checkNotNull(key);
                    writableMapCreateMap.putString(key, value2.getString());
                } else if (value2.isJsonList()) {
                    Intrinsics.checkNotNull(key);
                    Intrinsics.checkNotNull(value2);
                    writableMapCreateMap.putArray(key, (WritableArray) convertJsonValue(value2));
                } else if (value2.isJsonMap()) {
                    Intrinsics.checkNotNull(key);
                    Intrinsics.checkNotNull(value2);
                    writableMapCreateMap.putMap(key, (WritableMap) convertJsonValue(value2));
                }
            }
            return writableMapCreateMap;
        }
        return value.getValue();
    }

    @NotNull
    public final List<EventType> parseEventTypes(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        List<EventType> list = (List) eventMap.get(string);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
