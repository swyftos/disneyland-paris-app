package com.contentsquare.android.sdk;

import androidx.media3.common.MimeTypes;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.system.DeviceInfo;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.s7 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2878s7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final DeviceInfo f3104a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Configuration f3105b;

    public AbstractC2878s7(@NotNull DeviceInfo deviceInfo, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f3104a = deviceInfo;
        this.f3105b = configuration;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public JSONObject mo1179a(@NotNull C2828n7 telemetryReport) throws JSONException {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        JSONObject jSONObject = new JSONObject();
        JsonConfig.ProjectConfiguration projectConfig = this.f3105b.getProjectConfig();
        if (projectConfig != null) {
            jSONObject.put("pid", projectConfig.getCsProjectId());
        }
        jSONObject.put(MimeTypes.BASE_TYPE_APPLICATION, this.f3104a.getBuildInformation().getApplicationName());
        jSONObject.put("level", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO);
        jSONObject.put("version", this.f3104a.getBuildInformation().getSdkVersion());
        jSONObject.put("date", System.currentTimeMillis());
        String deviceModel = this.f3104a.getDeviceModel();
        if (deviceModel == null) {
            deviceModel = "";
        }
        jSONObject.put("device_model", deviceModel);
        jSONObject.put("os_type", "android");
        jSONObject.put("os_version", this.f3104a.getDeviceOs());
        jSONObject.put("os_api", this.f3104a.getDeviceOsApi());
        jSONObject.put("bundle_id", this.f3104a.getBuildInformation().getApplicationId());
        jSONObject.put("app_version", this.f3104a.getBuildInformation().getApplicationVersion());
        jSONObject.put("app_build_version", this.f3104a.getBuildInformation().getApplicationVersionCode());
        jSONObject.put("report", telemetryReport.f2922a);
        return jSONObject;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public abstract JSONObject mo1099b(@NotNull C2828n7 c2828n7);
}
