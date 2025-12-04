package com.appdynamics.eumagent.runtime.p000private;

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

/* loaded from: classes2.dex */
public final class bj {
    private final ci a;

    public bj(ci ciVar) {
        this.a = ciVar;
    }

    /* JADX WARN: Finally extract failed */
    final Set<String> a(List<String> list) throws IOException {
        int responseCode;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            CollectorChannel collectorChannelA = this.a.a();
            collectorChannelA.addRequestProperty("Content-Type", "application/json");
            collectorChannelA.addRequestProperty("accept", "application/json");
            OutputStream outputStream = collectorChannelA.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            a(new JsonWriter(outputStreamWriter), list);
            outputStreamWriter.flush();
            outputStream.close();
            InputStream inputStream = collectorChannelA.getInputStream();
            try {
                try {
                    responseCode = collectorChannelA.getResponseCode();
                } catch (IOException e) {
                    ADLog.logAgentError("Failed to check needed tiles", e);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                if (responseCode == 200) {
                    Set<String> setA = a(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    TrafficStats.clearThreadStatsTag();
                    return setA;
                }
                ADLog.logAppError("Check tile request returned response code: ".concat(String.valueOf(responseCode)));
                if (inputStream != null) {
                    inputStream.close();
                }
                TrafficStats.clearThreadStatsTag();
                return null;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
        } catch (IOException e2) {
            ADLog.logAgentError("Failed to check needed tiles", e2);
            return null;
        }
    }

    final void a(bm bmVar, List<String> list) {
        TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
        try {
            try {
                CollectorChannel collectorChannelA = this.a.a();
                collectorChannelA.addRequestProperty("Content-Type", "multipart/form-data; boundary=screenshotTile");
                OutputStream outputStream = collectorChannelA.getOutputStream();
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    bl blVarA = bmVar.a(it.next());
                    outputStream.write("\r\n--screenshotTile\r\n".getBytes());
                    outputStream.write(("Content-Disposition: form-data; name=\"file\"; filename=\"" + blVarA.a + ".jpg\"\r\n").getBytes());
                    outputStream.write("Content-Type: image/jpeg\r\n\r\n".getBytes());
                    InputStream inputStream = blVarA.c;
                    if (inputStream != null) {
                        ct.a(inputStream, outputStream);
                    } else {
                        byte[] bArr = blVarA.b;
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
                    int responseCode = collectorChannelA.getResponseCode();
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

    private static void a(JsonWriter jsonWriter, List<String> list) throws IOException {
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

    private static Set<String> a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        if (!ct.b(bufferedInputStream)) {
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
