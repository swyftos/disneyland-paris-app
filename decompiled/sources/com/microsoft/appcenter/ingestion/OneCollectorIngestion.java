package com.microsoft.appcenter.ingestion;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.TicketCache;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class OneCollectorIngestion implements Ingestion {
    private final HttpClient mHttpClient;
    private final LogSerializer mLogSerializer;
    private String mLogUrl = "https://mobile.events.data.microsoft.com/OneCollector/1.0";

    public OneCollectorIngestion(@NonNull HttpClient httpClient, @NonNull LogSerializer logSerializer) {
        this.mLogSerializer = logSerializer;
        this.mHttpClient = httpClient;
    }

    @Override // com.microsoft.appcenter.ingestion.Ingestion
    public ServiceCall sendAsync(String str, UUID uuid, LogContainer logContainer, ServiceCallback serviceCallback) throws JSONException, IllegalArgumentException {
        HashMap map = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Log> it = logContainer.getLogs().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next().getTransmissionTargetTokens());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            sb.append(",");
        }
        if (!linkedHashSet.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        map.put("apikey", sb.toString());
        JSONObject jSONObject = new JSONObject();
        Iterator<Log> it3 = logContainer.getLogs().iterator();
        while (it3.hasNext()) {
            List<String> ticketKeys = ((CommonSchemaLog) it3.next()).getExt().getProtocol().getTicketKeys();
            if (ticketKeys != null) {
                for (String str2 : ticketKeys) {
                    String ticket = TicketCache.getTicket(str2);
                    if (ticket != null) {
                        try {
                            jSONObject.put(str2, ticket);
                        } catch (JSONException e) {
                            AppCenterLog.error("AppCenter", "Cannot serialize tickets, sending log anonymously", e);
                        }
                    }
                }
            }
        }
        if (jSONObject.length() > 0) {
            map.put("Tickets", jSONObject.toString());
            if (Constants.APPLICATION_DEBUGGABLE) {
                map.put("Strict", Boolean.TRUE.toString());
            }
        }
        map.put("Content-Type", "application/x-json-stream; charset=utf-8");
        map.put("Client-Version", String.format("ACS-Android-Java-no-%s-no", "3.3.0"));
        map.put("Upload-Time", String.valueOf(System.currentTimeMillis()));
        return this.mHttpClient.callAsync(this.mLogUrl, "POST", map, new IngestionCallTemplate(this.mLogSerializer, logContainer), serviceCallback);
    }

    @Override // com.microsoft.appcenter.ingestion.Ingestion
    public void setLogUrl(@NonNull String str) {
        this.mLogUrl = str;
    }

    @Override // com.microsoft.appcenter.ingestion.Ingestion
    public void reopen() {
        this.mHttpClient.reopen();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mHttpClient.close();
    }

    private static class IngestionCallTemplate implements HttpClient.CallTemplate {
        private final LogContainer mLogContainer;
        private final LogSerializer mLogSerializer;

        IngestionCallTemplate(LogSerializer logSerializer, LogContainer logContainer) {
            this.mLogSerializer = logSerializer;
            this.mLogContainer = logContainer;
        }

        @Override // com.microsoft.appcenter.http.HttpClient.CallTemplate
        public String buildRequestBody() {
            StringBuilder sb = new StringBuilder();
            Iterator<Log> it = this.mLogContainer.getLogs().iterator();
            while (it.hasNext()) {
                sb.append(this.mLogSerializer.serializeLog(it.next()));
                sb.append('\n');
            }
            return sb.toString();
        }

        @Override // com.microsoft.appcenter.http.HttpClient.CallTemplate
        public void onBeforeCalling(URL url, Map map) {
            if (AppCenterLog.getLogLevel() <= 2) {
                AppCenterLog.verbose("AppCenter", "Calling " + url + "...");
                HashMap map2 = new HashMap(map);
                String str = (String) map2.get("apikey");
                if (str != null) {
                    map2.put("apikey", HttpUtils.hideApiKeys(str));
                }
                String str2 = (String) map2.get("Tickets");
                if (str2 != null) {
                    map2.put("Tickets", HttpUtils.hideTickets(str2));
                }
                AppCenterLog.verbose("AppCenter", "Headers: " + map2);
            }
        }
    }
}
