package com.urbanairship.analytics.data;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.UALog;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestSession;
import com.urbanairship.http.Response;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class EventApiClient {
    private final AirshipRuntimeConfig runtimeConfig;
    private final RequestSession session;

    public EventApiClient(@NonNull AirshipRuntimeConfig airshipRuntimeConfig) {
        this(airshipRuntimeConfig, airshipRuntimeConfig.getRequestSession());
    }

    EventApiClient(AirshipRuntimeConfig airshipRuntimeConfig, RequestSession requestSession) {
        this.runtimeConfig = airshipRuntimeConfig;
        this.session = requestSession;
    }

    Response sendEvents(String str, List list, Map map) throws RequestException {
        HashMap map2 = new HashMap(map);
        map2.put("X-UA-Sent-At", String.format(Locale.US, "%.3f", Double.valueOf(System.currentTimeMillis() / 1000.0d)));
        Request request = new Request(this.runtimeConfig.getAnalyticsUrl().appendEncodedPath("warp9/").build(), "POST", new RequestAuth.ChannelTokenAuth(str), new RequestBody.GzippedJson(JsonValue.wrapOpt(list)), map2);
        UALog.d("Sending analytics events. Request: %s Events: %s", request, list);
        Response responseExecute = this.session.execute(request, new ResponseParser() { // from class: com.urbanairship.analytics.data.EventApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map3, String str2) {
                return EventApiClient.lambda$sendEvents$0(i, map3, str2);
            }
        });
        UALog.d("Analytics event response: %s", responseExecute);
        return responseExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EventResponse lambda$sendEvents$0(int i, Map map, String str) {
        return new EventResponse(map);
    }
}
