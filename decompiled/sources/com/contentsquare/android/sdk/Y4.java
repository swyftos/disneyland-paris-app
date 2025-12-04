package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.sdk.H4;
import com.contentsquare.android.sdk.L0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class Y4 implements L0.a {

    @NotNull
    public final E1 a;

    @NotNull
    public final C0710j b;

    @NotNull
    public final DeviceInfo c;

    @NotNull
    public final Logger d;

    public Y4(@NotNull E1 eventsBuildersFactory, @NotNull C0710j analyticsPipeline, @NotNull DeviceInfo deviceInfo) {
        Intrinsics.checkNotNullParameter(eventsBuildersFactory, "eventsBuildersFactory");
        Intrinsics.checkNotNullParameter(analyticsPipeline, "analyticsPipeline");
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        this.a = eventsBuildersFactory;
        this.b = analyticsPipeline;
        this.c = deviceInfo;
        this.d = new Logger("ScreenOrientationChangeHandler");
    }

    @Override // com.contentsquare.android.sdk.L0.a
    public final void a(int i, int i2) {
        int iPixelsToDp = this.c.pixelsToDp(i);
        int iPixelsToDp2 = this.c.pixelsToDp(i2);
        this.d.d("Screen dimensions: " + i + 'x' + i2 + ", " + iPixelsToDp + 'x' + iPixelsToDp2 + "dp");
        H4.a aVar = (H4.a) E1.a(this.a, 5);
        aVar.k = iPixelsToDp;
        aVar.l = iPixelsToDp2;
        this.b.a(aVar);
        Logger logger = this.d;
        StringBuilder sb = new StringBuilder("message sent to the reservoir: [ ");
        sb.append(aVar);
        sb.append(" ]");
        logger.d(sb.toString());
    }
}
