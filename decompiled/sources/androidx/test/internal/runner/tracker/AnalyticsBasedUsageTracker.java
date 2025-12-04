package androidx.test.internal.runner.tracker;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.test.internal.util.Checks;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class AnalyticsBasedUsageTracker implements UsageTracker {
    private final URL analyticsURI;
    private final String apiLevel;
    private final String model;
    private final String screenResolution;
    private final String targetPackage;
    private final String trackingId;
    private final Map usageTypeToVersion;
    private final String userId;

    private AnalyticsBasedUsageTracker(Builder builder) {
        this.usageTypeToVersion = new HashMap();
        this.trackingId = (String) Checks.checkNotNull(builder.trackingId);
        this.targetPackage = (String) Checks.checkNotNull(builder.targetPackage);
        this.analyticsURI = (URL) Checks.checkNotNull(builder.analyticsURI);
        this.apiLevel = (String) Checks.checkNotNull(builder.apiLevel);
        this.model = (String) Checks.checkNotNull(builder.model);
        this.screenResolution = (String) Checks.checkNotNull(builder.screenResolution);
        this.userId = (String) Checks.checkNotNull(builder.userId);
    }

    public static class Builder {
        private URL analyticsURI;
        private boolean hashed;
        private String screenResolution;
        private final Context targetContext;
        private String targetPackage;
        private String userId;
        private Uri analyticsUri = new Uri.Builder().scheme("https").authority("www.google-analytics.com").path("collect").build();
        private String trackingId = "UA-36650409-3";
        private String apiLevel = String.valueOf(Build.VERSION.SDK_INT);
        private String model = Build.MODEL;

        public Builder(Context context) {
            if (context == null) {
                throw new NullPointerException("Context null!?");
            }
            this.targetContext = context;
        }

        public Builder withTrackingId(String str) {
            this.trackingId = str;
            return this;
        }

        public Builder withAnalyticsUri(Uri uri) {
            Checks.checkNotNull(uri);
            this.analyticsUri = uri;
            return this;
        }

        public Builder withApiLevel(String str) {
            this.apiLevel = str;
            return this;
        }

        public Builder withScreenResolution(String str) {
            this.screenResolution = str;
            return this;
        }

        public Builder withUserId(String str) {
            this.userId = str;
            return this;
        }

        public Builder withModel(String str) {
            this.model = str;
            return this;
        }

        public Builder withTargetPackage(String str) {
            this.hashed = false;
            this.targetPackage = str;
            return this;
        }

        public UsageTracker buildIfPossible() throws NoSuchAlgorithmException {
            if (!hasInternetPermission()) {
                Log.d("InfraTrack", "Tracking disabled due to lack of internet permissions");
                return null;
            }
            if (this.targetPackage == null) {
                withTargetPackage(this.targetContext.getPackageName());
            }
            if (this.targetPackage.contains("com.google.analytics")) {
                Log.d("InfraTrack", "Refusing to use analytics while testing analytics.");
                return null;
            }
            try {
                if (!this.targetPackage.startsWith("com.google.") && !this.targetPackage.startsWith("com.android.") && !this.targetPackage.startsWith("android.support.")) {
                    if (!this.hashed) {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                        messageDigest.reset();
                        messageDigest.update(this.targetPackage.getBytes("UTF-8"));
                        String strValueOf = String.valueOf(new BigInteger(messageDigest.digest()).toString(16));
                        this.targetPackage = strValueOf.length() != 0 ? "sha256-".concat(strValueOf) : new String("sha256-");
                    }
                    this.hashed = true;
                }
                try {
                    this.analyticsURI = new URL(this.analyticsUri.toString());
                    if (this.screenResolution == null) {
                        Display defaultDisplay = ((WindowManager) this.targetContext.getSystemService("window")).getDefaultDisplay();
                        if (defaultDisplay == null) {
                            this.screenResolution = "0x0";
                        } else {
                            this.screenResolution = defaultDisplay.getWidth() + "x" + defaultDisplay.getHeight();
                        }
                    }
                    if (this.userId == null) {
                        this.userId = UUID.randomUUID().toString();
                    }
                    return new AnalyticsBasedUsageTracker(this);
                } catch (MalformedURLException e) {
                    String strValueOf2 = String.valueOf(this.analyticsUri.toString());
                    Log.w("InfraTrack", strValueOf2.length() != 0 ? "Tracking disabled bad url: ".concat(strValueOf2) : new String("Tracking disabled bad url: "), e);
                    return null;
                }
            } catch (UnsupportedEncodingException e2) {
                Log.d("InfraTrack", "Impossible - no utf-8 encoding?", e2);
                return null;
            } catch (NoSuchAlgorithmException e3) {
                Log.d("InfraTrack", "Cannot hash package name.", e3);
                return null;
            }
        }

        private boolean hasInternetPermission() {
            return this.targetContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void trackUsage(String str, String str2) {
        synchronized (this.usageTypeToVersion) {
            this.usageTypeToVersion.put(str, str2);
        }
    }

    @Override // androidx.test.internal.runner.tracker.UsageTracker
    public void sendUsages() throws Throwable {
        String str;
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        synchronized (this.usageTypeToVersion) {
            try {
                if (this.usageTypeToVersion.isEmpty()) {
                    return;
                }
                HashMap map = new HashMap(this.usageTypeToVersion);
                this.usageTypeToVersion.clear();
                HttpURLConnection httpURLConnection2 = null;
                try {
                    str = "an=" + URLEncoder.encode(this.targetPackage, "UTF-8") + "&tid=" + URLEncoder.encode(this.trackingId, "UTF-8") + "&v=1&z=" + SystemClock.uptimeMillis() + "&cid=" + URLEncoder.encode(this.userId, "UTF-8") + "&sr=" + URLEncoder.encode(this.screenResolution, "UTF-8") + "&cd2=" + URLEncoder.encode(this.apiLevel, "UTF-8") + "&cd3=" + URLEncoder.encode(this.model, "UTF-8") + "&t=appview&sc=start";
                } catch (IOException e) {
                    Log.w("InfraTrack", "Impossible error happened. analytics disabled.", e);
                    str = null;
                }
                for (Map.Entry entry : map.entrySet()) {
                    try {
                        httpURLConnection = (HttpURLConnection) this.analyticsURI.openConnection();
                    } catch (IOException e2) {
                        e = e2;
                        httpURLConnection = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            bytes = (str + "&cd=" + URLEncoder.encode((String) entry.getKey(), "UTF-8") + "&av=" + URLEncoder.encode((String) entry.getValue(), "UTF-8")).getBytes();
                            httpURLConnection.setConnectTimeout(3000);
                            httpURLConnection.setReadTimeout(5000);
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                            InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection2 = httpURLConnection;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        String strValueOf = String.valueOf(entry);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                        sb.append("Analytics post: ");
                        sb.append(strValueOf);
                        sb.append(" failed. ");
                        Log.w("InfraTrack", sb.toString(), e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        InstrumentationCallbacks.requestSent(httpURLConnection);
                        outputStream.write(bytes);
                        InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                        try {
                            int responseCode = httpURLConnection.getResponseCode();
                            InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                            if (responseCode / 100 != 2) {
                                String strValueOf2 = String.valueOf(entry);
                                InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                                try {
                                    int responseCode2 = httpURLConnection.getResponseCode();
                                    InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                    InstrumentationCallbacks.requestAboutToBeSent(httpURLConnection);
                                    try {
                                        String responseMessage = httpURLConnection.getResponseMessage();
                                        InstrumentationCallbacks.requestHarvestable(httpURLConnection);
                                        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 45 + String.valueOf(responseMessage).length());
                                        sb2.append("Analytics post: ");
                                        sb2.append(strValueOf2);
                                        sb2.append(" failed. code: ");
                                        sb2.append(responseCode2);
                                        sb2.append(" - ");
                                        sb2.append(responseMessage);
                                        Log.w("InfraTrack", sb2.toString());
                                    } catch (IOException e4) {
                                        InstrumentationCallbacks.networkError(httpURLConnection, e4);
                                        throw e4;
                                    }
                                } catch (IOException e5) {
                                    InstrumentationCallbacks.networkError(httpURLConnection, e5);
                                    throw e5;
                                }
                            }
                            httpURLConnection.disconnect();
                        } catch (IOException e6) {
                            InstrumentationCallbacks.networkError(httpURLConnection, e6);
                            throw e6;
                        }
                    } catch (IOException e7) {
                        InstrumentationCallbacks.networkError(httpURLConnection, e7);
                        throw e7;
                    }
                }
            } finally {
            }
        }
    }
}
