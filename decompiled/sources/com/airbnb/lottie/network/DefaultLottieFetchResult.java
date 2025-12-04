package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.utils.Logger;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {
    private final HttpURLConnection connection;

    public DefaultLottieFetchResult(@NonNull HttpURLConnection httpURLConnection) {
        this.connection = httpURLConnection;
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() throws IOException {
        try {
            HttpURLConnection httpURLConnection = this.connection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                return responseCode / 100 == 2;
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @NonNull
    public InputStream bodyByteStream() throws IOException {
        return InstrumentationCallbacks.getInputStream(this.connection);
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @Nullable
    public String contentType() throws IOException {
        HttpURLConnection httpURLConnection = this.connection;
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            String contentType = httpURLConnection.getContentType();
            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
            return contentType;
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @Nullable
    public String error() throws IOException {
        try {
            if (isSuccessful()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to fetch ");
            sb.append(this.connection.getURL());
            sb.append(". Failed with ");
            HttpURLConnection httpURLConnection = this.connection;
            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
            try {
                int responseCode = httpURLConnection.getResponseCode();
                InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                sb.append(responseCode);
                sb.append("\n");
                sb.append(getErrorFromConnection(this.connection));
                return sb.toString();
            } catch (IOException e) {
                InstrumentationCallbacks.networkError(httpURLConnection, e);
                throw e;
            }
        } catch (IOException e2) {
            Logger.warning("get error failed ", e2);
            return e2.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.connection.disconnect();
    }

    private String getErrorFromConnection(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(InstrumentationCallbacks.getErrorStream(httpURLConnection)));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
