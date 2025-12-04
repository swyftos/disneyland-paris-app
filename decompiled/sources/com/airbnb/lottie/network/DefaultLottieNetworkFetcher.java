package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    @Override // com.airbnb.lottie.network.LottieNetworkFetcher
    @NonNull
    public LottieFetchResult fetchSync(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
        try {
            httpURLConnection.connect();
            InstrumentationCallbacks.requestSent(httpURLConnection);
            return new DefaultLottieFetchResult(httpURLConnection);
        } catch (IOException e) {
            InstrumentationCallbacks.networkError(httpURLConnection, e);
            throw e;
        }
    }
}
