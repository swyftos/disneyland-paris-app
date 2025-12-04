package com.contentsquare.android.sdk;

import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.communication.error.analysis.NetworkEventBuilder;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.sdk.A2;
import com.contentsquare.android.sdk.T0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nWebViewEventBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebViewEventBuilder.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/webview/WebViewEventBuilder\n+ 2 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,180:1\n32#2:181\n33#2:183\n1#3:182\n*S KotlinDebug\n*F\n+ 1 WebViewEventBuilder.kt\ncom/contentsquare/android/analytics/internal/uigestureinterceptor/webview/WebViewEventBuilder\n*L\n85#1:181\n85#1:183\n*E\n"})
/* loaded from: classes2.dex */
public final class F8 {
    @NotNull
    public static T0.a a(@NotNull E1 eventsBuildersFactory, @NotNull JSONObject dataJsonObject, @NotNull ScreenViewTracker screenViewTracker) {
        Iterator<String> itKeys;
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        T0.a aVar = (T0.a) E1.a(eventsBuildersFactory, 25);
        Long longOrNull = ExtensionsKt.getLongOrNull(dataJsonObject, "date");
        long jLongValue = longOrNull != null ? longOrNull.longValue() : System.currentTimeMillis();
        aVar.i = jLongValue;
        aVar.m = Long.valueOf(jLongValue - screenViewTracker.getCurrentScreenTimestamp());
        aVar.k = ExtensionsKt.getStringOrNull(dataJsonObject, "message");
        JSONObject jSONObjectOptJSONObject = dataJsonObject.optJSONObject("attributes");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONObjectOptJSONObject != null && (itKeys = jSONObjectOptJSONObject.keys()) != null) {
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String stringOrNull = ExtensionsKt.getStringOrNull(jSONObjectOptJSONObject, key);
                if (stringOrNull != null) {
                    linkedHashMap.put(key, stringOrNull);
                }
            }
        }
        Intrinsics.checkNotNullParameter(linkedHashMap, "<set-?>");
        aVar.n = linkedHashMap;
        aVar.l = "webview";
        return aVar;
    }

    @NotNull
    public static A2.a b(@NotNull E1 eventsBuildersFactory, @NotNull JSONObject dataJsonObject, @NotNull ScreenViewTracker screenViewTracker) {
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(dataJsonObject, "dataJsonObject");
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        A2.a aVar = (A2.a) E1.a(eventsBuildersFactory, 26);
        Long longOrNull = ExtensionsKt.getLongOrNull(dataJsonObject, "date");
        long jLongValue = longOrNull != null ? longOrNull.longValue() : System.currentTimeMillis();
        aVar.i = jLongValue;
        aVar.q = Long.valueOf(jLongValue - screenViewTracker.getCurrentScreenTimestamp());
        aVar.k = ExtensionsKt.getStringOrNull(dataJsonObject, "message");
        aVar.l = ExtensionsKt.getStringOrNull(dataJsonObject, "filename");
        aVar.m = ExtensionsKt.getStringOrNull(dataJsonObject, "pageUrl");
        aVar.n = ExtensionsKt.getIntOrNull(dataJsonObject, "lineno");
        aVar.o = ExtensionsKt.getIntOrNull(dataJsonObject, "colno");
        aVar.p = "webview";
        return aVar;
    }

    @Nullable
    public static NetworkEvent a(@NotNull JSONObject json) throws JSONException {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(json, "json");
        NetworkEventBuilder networkEventBuilderBuilder = NetworkEventBuilder.INSTANCE.builder();
        if (json.has("url")) {
            String queryParams = json.optString("queryParameters");
            String string = json.getString("url");
            Intrinsics.checkNotNullExpressionValue(queryParams, "queryParams");
            if (queryParams.length() > 0) {
                string = string + '?' + queryParams;
            }
            networkEventBuilderBuilder.setUrl(string);
        }
        networkEventBuilderBuilder.setHttpMethod(ExtensionsKt.getStringOrNull(json, "method"));
        networkEventBuilderBuilder.setRequestStartTimeMillis(json.optLong("requestTime", 0L));
        networkEventBuilderBuilder.setTimeToResponseCompletedMillis(json.optLong("responseTime", 0L));
        networkEventBuilderBuilder.setHttpResponseCode(json.optInt("statusCode", 0));
        String stringOrNull = ExtensionsKt.getStringOrNull(json, "requestBody");
        if (stringOrNull != null) {
            byte[] bytes = stringOrNull.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            networkEventBuilderBuilder.setRequestBody(bytes);
        }
        String stringOrNull2 = ExtensionsKt.getStringOrNull(json, "responseBody");
        if (stringOrNull2 != null) {
            byte[] bytes2 = stringOrNull2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            networkEventBuilderBuilder.setResponseBody(bytes2);
        }
        JSONObject jSONObjectOrNull = ExtensionsKt.getJSONObjectOrNull(json, "standardResponseHeaders");
        LinkedHashMap linkedHashMap2 = null;
        if (jSONObjectOrNull != null) {
            linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObjectOrNull.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys()");
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String stringOrNull3 = ExtensionsKt.getStringOrNull(jSONObjectOrNull, key);
                if (stringOrNull3 != null) {
                    linkedHashMap.put(key, stringOrNull3);
                }
            }
        } else {
            linkedHashMap = null;
        }
        networkEventBuilderBuilder.setStandardResponseHeaders(linkedHashMap);
        JSONObject jSONObjectOrNull2 = ExtensionsKt.getJSONObjectOrNull(json, "standardRequestHeaders");
        if (jSONObjectOrNull2 != null) {
            linkedHashMap2 = new LinkedHashMap();
            Iterator<String> itKeys2 = jSONObjectOrNull2.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys2, "keys()");
            while (itKeys2.hasNext()) {
                String key2 = itKeys2.next();
                Intrinsics.checkNotNullExpressionValue(key2, "key");
                String stringOrNull4 = ExtensionsKt.getStringOrNull(jSONObjectOrNull2, key2);
                if (stringOrNull4 != null) {
                    linkedHashMap2.put(key2, stringOrNull4);
                }
            }
        }
        networkEventBuilderBuilder.setStandardRequestHeaders(linkedHashMap2);
        networkEventBuilderBuilder.setCustomRequestHeaders(ExtensionsKt.getStringOrNull(json, "customRequestHeaders"));
        networkEventBuilderBuilder.setCustomResponseHeaders(ExtensionsKt.getStringOrNull(json, "customResponseHeaders"));
        networkEventBuilderBuilder.setSource("webview");
        return networkEventBuilderBuilder.build();
    }
}
