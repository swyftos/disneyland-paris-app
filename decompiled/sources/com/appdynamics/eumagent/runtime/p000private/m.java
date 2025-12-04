package com.appdynamics.eumagent.runtime.p000private;

import com.appdynamics.eumagent.runtime.CollectorChannel;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class m extends CollectorChannel {
    private HttpURLConnection a;

    private synchronized HttpURLConnection a() {
        try {
            if (this.a == null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) getURL().openConnection();
                this.a = httpURLConnection;
                httpURLConnection.setReadTimeout(getReadTimeout());
                this.a.setConnectTimeout(getConnectTimeout());
                this.a.setRequestMethod(getRequestMethod());
                for (Map.Entry<String, List<String>> entry : getRequestProperties().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        this.a.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.a;
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final OutputStream getOutputStream() {
        HttpURLConnection httpURLConnectionA = a();
        httpURLConnectionA.setDoOutput(true);
        return httpURLConnectionA.getOutputStream();
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final InputStream getInputStream() {
        return a().getInputStream();
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final int getResponseCode() {
        return a().getResponseCode();
    }

    @Override // com.appdynamics.eumagent.runtime.CollectorChannel
    public final Map<String, List<String>> getHeaderFields() {
        return a().getHeaderFields();
    }
}
