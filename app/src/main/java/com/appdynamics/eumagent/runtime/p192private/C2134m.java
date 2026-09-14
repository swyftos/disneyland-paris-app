package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.CollectorChannel;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.m */
/* JADX INFO: loaded from: classes2.dex */
public final class C2134m extends CollectorChannel {

    /* JADX INFO: renamed from: a */
    private HttpURLConnection f897a;

    /* JADX INFO: renamed from: a */
    private synchronized HttpURLConnection m707a() {
        try {
            if (this.f897a == null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) getURL().openConnection();
                this.f897a = httpURLConnection;
                httpURLConnection.setReadTimeout(getReadTimeout());
                this.f897a.setConnectTimeout(getConnectTimeout());
                this.f897a.setRequestMethod(getRequestMethod());
                for (Map.Entry<String, List<String>> entry : getRequestProperties().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        this.f897a.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f897a;
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final OutputStream getOutputStream() {
        HttpURLConnection httpURLConnectionM707a = m707a();
        httpURLConnectionM707a.setDoOutput(true);
        return httpURLConnectionM707a.getOutputStream();
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final InputStream getInputStream() {
        return m707a().getInputStream();
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final int getResponseCode() {
        return m707a().getResponseCode();
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final Map<String, List<String>> getHeaderFields() {
        return m707a().getHeaderFields();
    }
}
