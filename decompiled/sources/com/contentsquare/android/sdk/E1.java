package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.system.ConnectionType;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.sdk.A2;
import com.contentsquare.android.sdk.AbstractC0660e;
import com.contentsquare.android.sdk.C;
import com.contentsquare.android.sdk.C0646c5;
import com.contentsquare.android.sdk.C0672f1;
import com.contentsquare.android.sdk.C0680g;
import com.contentsquare.android.sdk.C0692h1;
import com.contentsquare.android.sdk.C0702i1;
import com.contentsquare.android.sdk.C0722k1;
import com.contentsquare.android.sdk.C0736l5;
import com.contentsquare.android.sdk.C0752n1;
import com.contentsquare.android.sdk.C0793r3;
import com.contentsquare.android.sdk.C0801s1;
import com.contentsquare.android.sdk.C0813t3;
import com.contentsquare.android.sdk.C0822u2;
import com.contentsquare.android.sdk.G;
import com.contentsquare.android.sdk.G7;
import com.contentsquare.android.sdk.H;
import com.contentsquare.android.sdk.H4;
import com.contentsquare.android.sdk.N7;
import com.contentsquare.android.sdk.R1;
import com.contentsquare.android.sdk.S2;
import com.contentsquare.android.sdk.T0;
import com.contentsquare.android.sdk.X6;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class E1 {

    @NotNull
    public final DeviceInfo a;

    @NotNull
    public final A5 b;

    @NotNull
    public final M7 c;

    @NotNull
    public final Configuration d;

    @Nullable
    public InterfaceC0832v2 e;

    public E1(@NotNull DeviceInfo deviceInfo, @NotNull A5 session, @NotNull M7 userIdRestoreHelper, @NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(userIdRestoreHelper, "userIdRestoreHelper");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.a = deviceInfo;
        this.b = session;
        this.c = userIdRestoreHelper;
        this.d = configuration;
    }

    @JvmOverloads
    @NotNull
    public final <T extends AbstractC0660e.a<? extends AbstractC0660e>> T a(int i, @Nullable String url) throws JSONException {
        T aVar;
        switch (i) {
            case -2:
                aVar = new C0822u2.a();
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
                aVar = new C0813t3.a();
                break;
            case 0:
                aVar = new H.a();
                break;
            case 1:
                aVar = new G.a();
                break;
            case 2:
                aVar = new C.a();
                break;
            case 4:
                aVar = new C0646c5.a();
                break;
            case 5:
                aVar = new H4.a();
                break;
            case 6:
                aVar = new X6.a();
                break;
            case 8:
                aVar = new S2.a();
                break;
            case 9:
                aVar = new C0672f1.a();
                break;
            case 10:
                aVar = new R1.a();
                break;
            case 16:
                aVar = new G7.a();
                break;
            case 18:
                aVar = new C0702i1.a();
                break;
            case 19:
                aVar = new C0692h1.a();
                break;
            case 21:
                aVar = new C0793r3.a();
                break;
            case 22:
                aVar = new N7.a();
                break;
            case 23:
                aVar = new C0736l5.a();
                break;
            case 24:
                aVar = new C0722k1.a();
                break;
            case 25:
                aVar = new T0.a();
                break;
            case 26:
                aVar = new A2.a();
                break;
            case 28:
                aVar = new C0801s1.a();
                break;
            case 29:
                aVar = new C0752n1.a();
                break;
            case 30:
                aVar = new C0680g.a();
                break;
        }
        String carrierId = this.a.getNetworkOperator();
        Intrinsics.checkNotNullParameter(carrierId, "carrierId");
        aVar.e = carrierId;
        ConnectionType connectionType = this.a.getActiveConnectionType();
        Intrinsics.checkNotNullParameter(connectionType, "connectionType");
        aVar.d = connectionType;
        DeviceInfo.Orientation orientation = this.a.getScreenOrientation();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        aVar.f = orientation;
        DeviceInfo deviceInfo = this.a;
        JSONObject originVersion = deviceInfo.getVersionOrigin(deviceInfo.getBuildInformation());
        Intrinsics.checkNotNullParameter(originVersion, "originVersion");
        aVar.g = originVersion;
        A5 a5 = this.b;
        aVar.h = a5.k;
        aVar.c = a5.j;
        if (url != null && url.length() != 0) {
            Intrinsics.checkNotNullParameter(url, "url");
            aVar.b = url;
        }
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type T of com.contentsquare.android.analytics.internal.model.EventsBuildersFactory.builderFor");
        return aVar;
    }

    public static AbstractC0660e.a a(E1 e1, int i) {
        InterfaceC0832v2 interfaceC0832v2 = e1.e;
        return e1.a(i, interfaceC0832v2 != null ? ((C0723k2) interfaceC0832v2).d : null);
    }
}
