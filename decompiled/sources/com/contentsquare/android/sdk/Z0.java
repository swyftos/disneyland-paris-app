package com.contentsquare.android.sdk;

import androidx.exifinterface.media.ExifInterface;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.UriBuilder;
import com.contentsquare.android.sdk.Q4;
import com.contentsquare.android.sdk.S4;
import com.contentsquare.android.sdk.Z4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class Z0 implements N0 {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public final S4 b;

    @NotNull
    public final PreferencesStore c;

    @NotNull
    public final Configuration d;

    @NotNull
    public final Logger e;

    public Z0(@NotNull DeviceInfo deviceInfo, @NotNull S4 screenCaptureProcessor, @NotNull PreferencesStore preferencesStore, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(screenCaptureProcessor, "screenCaptureProcessor");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = deviceInfo;
        this.b = screenCaptureProcessor;
        this.c = preferencesStore;
        this.d = configuration;
        this.e = new Logger("DefaultCsScreenGraphCallback");
    }

    @Override // com.contentsquare.android.sdk.N0
    public final void a(@NotNull String screenName) {
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        S4 s4 = this.b;
        Z4.b.e reason = Z4.b.e.a;
        s4.getClass();
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        s4.b.tryEmit(new Z4.a(reason, screenName));
    }

    @Override // com.contentsquare.android.sdk.N0
    public final void a(@NotNull U4 screenGraph, @NotNull String encodedScreenshot, boolean z) {
        JsonConfig.ClientMode clientMode;
        Intrinsics.checkNotNullParameter(screenGraph, "screenGraph");
        Intrinsics.checkNotNullParameter(encodedScreenshot, "encodedScreenshot");
        JsonConfig.ProjectConfiguration projectConfig = this.d.getProjectConfig();
        if (projectConfig != null) {
            Q4 screenCapture = new Q4();
            screenCapture.n = screenGraph;
            screenCapture.d = projectConfig.getCsProjectId();
            screenCapture.c = this.a.getDeviceType().getValue();
            Q4.a aVar = z ? Q4.a.c : Q4.a.b;
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            screenCapture.p = aVar;
            screenCapture.b = this.a.getDeviceHeight();
            screenCapture.a = this.a.getDeviceWidth();
            screenCapture.e = this.a.getDeviceScale();
            screenCapture.h = this.a.getBuildInformation().getSdkVersion();
            screenCapture.i = ExifInterface.GPS_MEASUREMENT_2D;
            screenCapture.j = this.a.getBuildInformation().getApplicationVersion();
            screenCapture.k = this.a.getDeviceOs();
            String snapshotEndpoint = null;
            screenCapture.l = this.c.getString(PreferencesKey.INAPP_USER_ID, null);
            screenCapture.f = this.a.getDeviceModel();
            screenCapture.g = this.a.getDeviceManufacturer();
            screenCapture.m = screenGraph.a;
            Intrinsics.checkNotNullParameter(encodedScreenshot, "<set-?>");
            screenCapture.o = encodedScreenshot;
            JsonConfig.ProjectConfiguration projectConfig2 = this.d.getProjectConfig();
            if (projectConfig2 != null && (clientMode = projectConfig2.getClientMode()) != null) {
                snapshotEndpoint = clientMode.getSnapshotEndpoint();
            }
            if (snapshotEndpoint == null) {
                snapshotEndpoint = "";
            }
            String servicePath = UriBuilder.INSTANCE.buildScreengraphUrl(snapshotEndpoint);
            S4 s4 = this.b;
            s4.getClass();
            Intrinsics.checkNotNullParameter(screenCapture, "screenCapture");
            Intrinsics.checkNotNullParameter(servicePath, "servicePath");
            if (s4.a.submit(new S4.b(s4, new S4.a(screenCapture, servicePath), s4.e, s4.c)) != null) {
                return;
            }
        }
        this.e.w("The raw configuration living in configuration shouldn't be null");
    }
}
