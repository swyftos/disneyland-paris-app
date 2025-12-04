package com.contentsquare.android.sdk;

import androidx.media3.common.MimeTypes;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.system.DeviceInfo;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.s7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0807s7 {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public final Configuration b;

    public AbstractC0807s7(@NotNull DeviceInfo deviceInfo, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = deviceInfo;
        this.b = configuration;
    }

    @NotNull
    public JSONObject a(@NotNull C0758n7 telemetryReport) throws JSONException {
        Intrinsics.checkNotNullParameter(telemetryReport, "telemetryReport");
        JSONObject jSONObject = new JSONObject();
        JsonConfig.ProjectConfiguration projectConfig = this.b.getProjectConfig();
        if (projectConfig != null) {
            jSONObject.put("pid", projectConfig.getCsProjectId());
        }
        jSONObject.put(MimeTypes.BASE_TYPE_APPLICATION, this.a.getBuildInformation().getApplicationName());
        jSONObject.put("level", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO);
        jSONObject.put("version", this.a.getBuildInformation().getSdkVersion());
        jSONObject.put("date", System.currentTimeMillis());
        String deviceModel = this.a.getDeviceModel();
        if (deviceModel == null) {
            deviceModel = "";
        }
        jSONObject.put("device_model", deviceModel);
        jSONObject.put("os_type", "android");
        jSONObject.put("os_version", this.a.getDeviceOs());
        jSONObject.put("os_api", this.a.getDeviceOsApi());
        jSONObject.put("bundle_id", this.a.getBuildInformation().getApplicationId());
        jSONObject.put("app_version", this.a.getBuildInformation().getApplicationVersion());
        jSONObject.put("app_build_version", this.a.getBuildInformation().getApplicationVersionCode());
        jSONObject.put("report", telemetryReport.a);
        return jSONObject;
    }

    @NotNull
    public abstract JSONObject b(@NotNull C0758n7 c0758n7);
}
