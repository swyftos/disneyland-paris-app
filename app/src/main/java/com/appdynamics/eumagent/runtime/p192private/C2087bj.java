package com.appdynamics.eumagent.runtime.p192private;

import android.net.TrafficStats;
import com.appdynamics.eumagent.runtime.CollectorChannel;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonWriter;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.bj */
/* JADX INFO: loaded from: classes2.dex */
public final class C2087bj {

    /* JADX INFO: renamed from: a */
    private final C2113ci f677a;

    public C2087bj(C2113ci c2113ci) {
        this.f677a = c2113ci;
    }

    /* JADX INFO: renamed from: a */
    final Set<String> m603a(List<String> list) {
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            CollectorChannel collectorChannelM649a = this.f677a.m649a();
            collectorChannelM649a.addRequestProperty("Content-Type", "application/json");
            collectorChannelM649a.addRequestProperty("accept", "application/json");
            OutputStream outputStream = collectorChannelM649a.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            m602a(new JsonWriter(outputStreamWriter), list);
            outputStreamWriter.flush();
            outputStream.close();
            InputStream inputStream = collectorChannelM649a.getInputStream();
            try {
                int responseCode = collectorChannelM649a.getResponseCode();
                if (responseCode == 200) {
                    return m601a(inputStream);
                }
                ADLog.logAppError("Check tile request returned response code: ".concat(String.valueOf(responseCode)));
                return null;
            } catch (IOException e) {
                ADLog.logAgentError("Failed to check needed tiles", e);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                TrafficStats.clearThreadStatsTag();
            }
        } catch (IOException e2) {
            ADLog.logAgentError("Failed to check needed tiles", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    final void m604a(C2090bm c2090bm, List<String> list) {
        TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
        try {
            try {
                CollectorChannel collectorChannelM649a = this.f677a.m649a();
                collectorChannelM649a.addRequestProperty("Content-Type", "multipart/form-data; boundary=screenshotTile");
                OutputStream outputStream = collectorChannelM649a.getOutputStream();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    C2089bl c2089blM613a = c2090bm.m613a(it.next());
                    outputStream.write("\r\n--screenshotTile\r\n".getBytes());
                    outputStream.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + c2089blM613a.f678a + ".jpg\"\r\n").getBytes());
                    outputStream.write("Content-Type: image/jpeg\r\n\r\n".getBytes());
                    InputStream inputStream = c2089blM613a.f680c;
                    if (inputStream != null) {
                        C2124ct.m664a(inputStream, outputStream);
                    } else {
                        byte[] bArr = c2089blM613a.f679b;
                        if (bArr != null) {
                            outputStream.write(bArr);
                        } else {
                            throw new RuntimeException("No InputStream or Bitmap to write!");
                        }
                    }
                }
                outputStream.write("\r\n--screenshotTile--\r\n".getBytes());
                outputStream.flush();
                outputStream.close();
                try {
                    int responseCode = collectorChannelM649a.getResponseCode();
                    if (responseCode != 200) {
                        ADLog.logAppError("Upload tiles request returned response code: ".concat(String.valueOf(responseCode)));
                    }
                } catch (IOException e) {
                    ADLog.logAgentError("Failed to upload tiles", e);
                }
                TrafficStats.clearThreadStatsTag();
            } catch (IOException e2) {
                ADLog.logAgentError("Failed to upload tiles", e2);
                TrafficStats.clearThreadStatsTag();
            }
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m602a(JsonWriter jsonWriter, List<String> list) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("tiles");
        jsonWriter.beginArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jsonWriter.value(it.next());
        }
        jsonWriter.endArray();
        jsonWriter.endObject();
    }

    /* JADX INFO: renamed from: a */
    private static Set<String> m601a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        if (!C2124ct.m670b(bufferedInputStream)) {
            return Collections.emptySet();
        }
        JsonReader jsonReader = new JsonReader(new InputStreamReader(bufferedInputStream));
        HashSet hashSet = new HashSet();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if ("tiles".equals(jsonReader.nextName())) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    hashSet.add(jsonReader.nextString());
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return hashSet;
    }
}
