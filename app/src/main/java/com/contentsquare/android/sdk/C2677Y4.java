package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Y4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2677Y4 implements ComponentCallbacksC2547L0.a {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2478E1 f2297a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2780j f2298b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final DeviceInfo f2299c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Logger f2300d;

    public C2677Y4(@NotNull C2478E1 eventsBuildersFactory, @NotNull C2780j analyticsPipeline, @NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.f2297a = eventsBuildersFactory;
        this.f2298b = analyticsPipeline;
        this.f2299c = deviceInfo;
        this.f2300d = new Logger("ScreenOrientationChangeHandler");
    }

    @Override // com.contentsquare.android.sdk.ComponentCallbacksC2547L0.a
    /* JADX INFO: renamed from: a */
    public final void mo976a(int i, int i2) {
        int iPixelsToDp = this.f2299c.pixelsToDp(i);
        int iPixelsToDp2 = this.f2299c.pixelsToDp(i2);
        this.f2300d.m827d("Screen dimensions: " + i + 'x' + i2 + ", " + iPixelsToDp + 'x' + iPixelsToDp2 + "dp");
        C2511H4.a aVar = (C2511H4.a) C2478E1.m901a(this.f2297a, 5);
        aVar.f1679k = iPixelsToDp;
        aVar.f1680l = iPixelsToDp2;
        this.f2298b.m1159a(aVar);
        Logger logger = this.f2300d;
        StringBuilder sb = new StringBuilder("message sent to the reservoir: [ ");
        sb.append(aVar);
        sb.append(" ]");
        logger.m827d(sb.toString());
    }
}
