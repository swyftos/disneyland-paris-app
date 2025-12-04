package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.util.Log;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes3.dex */
final class zza extends Thread {
    private final /* synthetic */ Map zzl;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzl = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String message;
        StringBuilder sb;
        String str;
        new zzc();
        Map map = this.zzl;
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str2 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str2, (String) map.get(str2));
        }
        String string = builderBuildUpon.build().toString();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
                try {
                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                    try {
                        int responseCode = httpURLConnection.getResponseCode();
                        InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                        if (responseCode < 200 || responseCode >= 300) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 65);
                            sb2.append("Received non-success response code ");
                            sb2.append(responseCode);
                            sb2.append(" from pinging URL: ");
                            sb2.append(string);
                            Log.w("HttpUrlPinger", sb2.toString());
                        }
                    } catch (IOException e) {
                        InstrumentationCallbacks.networkError(httpURLConnection, e);
                        throw e;
                    }
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (IndexOutOfBoundsException e2) {
                e = e2;
                message = e.getMessage();
                sb = new StringBuilder(String.valueOf(string).length() + 32 + String.valueOf(message).length());
                str = "Error while parsing ping URL: ";
                sb.append(str);
                sb.append(string);
                sb.append(". ");
                sb.append(message);
                Log.w("HttpUrlPinger", sb.toString(), e);
            }
        } catch (IOException | RuntimeException e3) {
            e = e3;
            message = e.getMessage();
            sb = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(message).length());
            str = "Error while pinging URL: ";
            sb.append(str);
            sb.append(string);
            sb.append(". ");
            sb.append(message);
            Log.w("HttpUrlPinger", sb.toString(), e);
        }
    }
}
