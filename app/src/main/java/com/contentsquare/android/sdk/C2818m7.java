package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.http.HttpConnection;
import com.contentsquare.android.core.features.http.HttpResponse;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.UriBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.m7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2818m7 extends AbstractC2878s7 {

    /* JADX INFO: renamed from: c */
    @NotNull
    public final HttpConnection f2887c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Logger f2888d;

    public C2818m7(DeviceInfo deviceInfo, Configuration configuration) {
        HttpConnection httpConnection = new HttpConnection();
        Intrinsics.checkNotNullParameter(httpConnection, "httpConnection");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        super(deviceInfo, configuration);
        this.f2887c = httpConnection;
        this.f2888d = new Logger("TelemetryQASubscriber");
    }

    @Override // com.contentsquare.android.sdk.AbstractC2878s7
    @NotNull
    /* JADX INFO: renamed from: a */
    public final JSONObject mo1179a(@NotNull C2828n7 telemetryReport) {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        return telemetryReport.f2922a;
    }

    @Override // com.contentsquare.android.sdk.AbstractC2878s7
    @NotNull
    /* JADX INFO: renamed from: b */
    public final JSONObject mo1099b(@NotNull C2828n7 telemetryReport) {
        String str;
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        JSONObject jSONObject = telemetryReport.f2922a;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "subscriberData.toString()");
        HttpResponse httpResponsePerformPostWithJson$default = HttpConnection.performPostWithJson$default(this.f2887c, UriBuilder.buildLogSdkMetricUrl$default(UriBuilder.INSTANCE, null, true, 1, null), string, null, 4, null);
        boolean zSuccess = httpResponsePerformPostWithJson$default.success();
        Logger logger = this.f2888d;
        if (zSuccess) {
            str = "Telemetry report successfully sent to Qa server: " + jSONObject;
        } else {
            str = "Could not send the telemetry report to Qa server: " + httpResponsePerformPostWithJson$default.getStatus() + '|' + httpResponsePerformPostWithJson$default.getStringResponse();
        }
        logger.m833p(str);
        return jSONObject;
    }
}
