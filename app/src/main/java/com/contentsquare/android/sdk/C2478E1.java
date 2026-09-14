package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.E1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2478E1 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final DeviceInfo f1539a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2442A5 f1540b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final C2564M7 f1541c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Configuration f1542d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public InterfaceC2903v2 f1543e;

    public C2478E1(@NotNull DeviceInfo deviceInfo, @NotNull C2442A5 session, @NotNull C2564M7 userIdRestoreHelper, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(userIdRestoreHelper, "userIdRestoreHelper");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.f1539a = deviceInfo;
        this.f1540b = session;
        this.f1541c = userIdRestoreHelper;
        this.f1542d = configuration;
    }

    @JvmOverloads
    @NotNull
    /* JADX INFO: renamed from: a */
    public final <T extends AbstractC2730e.a<? extends AbstractC2730e>> T m902a(int i, @Nullable String url) {
        T aVar;
        switch (i) {
            case -2:
                aVar = new C2893u2.a();
                break;
            case -1:
            case 3:
            case 7:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 17:
            case 20:
            case 27:
            default:
                aVar = new C2884t3.a();
                break;
            case 0:
                aVar = new C2506H.a();
                break;
            case 1:
                aVar = new C2496G.a();
                break;
            case 2:
                aVar = new C2456C.a();
                break;
            case 4:
                aVar = new C2716c5.a();
                break;
            case 5:
                aVar = new C2511H4.a();
                break;
            case 6:
                aVar = new C2670X6.a();
                break;
            case 8:
                aVar = new C2618S2.a();
                break;
            case 9:
                aVar = new C2742f1.a();
                break;
            case 10:
                aVar = new C2607R1.a();
                break;
            case 16:
                aVar = new C2504G7.a();
                break;
            case 18:
                aVar = new C2772i1.a();
                break;
            case 19:
                aVar = new C2762h1.a();
                break;
            case 21:
                aVar = new C2864r3.a();
                break;
            case 22:
                aVar = new C2574N7.a();
                break;
            case 23:
                aVar = new C2806l5.a();
                break;
            case 24:
                aVar = new C2792k1.a();
                break;
            case 25:
                aVar = new C2626T0.a();
                break;
            case 26:
                aVar = new C2439A2.a();
                break;
            case 28:
                aVar = new C2872s1.a();
                break;
            case 29:
                aVar = new C2822n1.a();
                break;
            case 30:
                aVar = new C2750g.a();
                break;
        }
        String carrierId = this.f1539a.getNetworkOperator();
        Intrinsics.checkNotNullParameter(carrierId, "carrierId");
        aVar.f2561e = carrierId;
        ConnectionType connectionType = this.f1539a.getActiveConnectionType();
        Intrinsics.checkNotNullParameter(connectionType, "connectionType");
        aVar.f2560d = connectionType;
        DeviceInfo.Orientation orientation = this.f1539a.getScreenOrientation();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        aVar.f2562f = orientation;
        DeviceInfo deviceInfo = this.f1539a;
        JSONObject originVersion = deviceInfo.getVersionOrigin(deviceInfo.getBuildInformation());
        Intrinsics.checkNotNullParameter(originVersion, "originVersion");
        aVar.f2563g = originVersion;
        C2442A5 c2442a5 = this.f1540b;
        aVar.f2564h = c2442a5.f1410k;
        aVar.f2559c = c2442a5.f1409j;
        if (url != null && url.length() != 0) {
            Intrinsics.checkNotNullParameter(url, "url");
            aVar.f2558b = url;
        }
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type T of com.contentsquare.android.analytics.internal.model.EventsBuildersFactory.builderFor");
        return aVar;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC2730e.a m901a(C2478E1 c2478e1, int i) {
        InterfaceC2903v2 interfaceC2903v2 = c2478e1.f1543e;
        return c2478e1.m902a(i, interfaceC2903v2 != null ? ((C2793k2) interfaceC2903v2).f2809d : null);
    }
}
