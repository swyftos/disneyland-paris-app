package com.contentsquare.android.sdk;

import com.contentsquare.android.core.system.DeviceInfo;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F1 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2488F1 {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f1571a;

    /* JADX INFO: renamed from: b */
    public final int f1572b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final DeviceInfo.DeviceType f1573c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final String f1574d;

    /* JADX INFO: renamed from: e */
    @NotNull
    public final String f1575e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final String f1576f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final String f1577g;

    /* JADX INFO: renamed from: h */
    @NotNull
    public final String f1578h;

    /* JADX INFO: renamed from: i */
    @NotNull
    public final JSONObject f1579i;

    /* JADX INFO: renamed from: j */
    @NotNull
    public final JSONObject f1580j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final JSONArray f1581k;

    /* JADX INFO: renamed from: l */
    public final long f1582l;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.F1$a */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @NotNull
        public final DeviceInfo.DeviceType f1583a;

        /* JADX INFO: renamed from: b */
        @NotNull
        public final String f1584b;

        /* JADX INFO: renamed from: c */
        @NotNull
        public final String f1585c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public final String f1586d;

        /* JADX INFO: renamed from: e */
        @Nullable
        public final String f1587e;

        /* JADX INFO: renamed from: f */
        @NotNull
        public final String f1588f;

        /* JADX INFO: renamed from: g */
        @NotNull
        public final JSONObject f1589g;

        /* JADX INFO: renamed from: h */
        @NotNull
        public final JSONObject f1590h;

        /* JADX INFO: renamed from: i */
        @NotNull
        public final JSONArray f1591i;

        /* JADX INFO: renamed from: j */
        public final long f1592j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public String f1593k;

        /* JADX INFO: renamed from: l */
        public int f1594l;

        public a(@NotNull DeviceInfo deviceInfo) {
            Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
            this.f1583a = deviceInfo.getDeviceType();
            this.f1584b = deviceInfo.getDeviceOs();
            this.f1585c = deviceInfo.getUserLanguage();
            this.f1586d = deviceInfo.getDeviceModel();
            this.f1587e = deviceInfo.getDeviceManufacturer();
            this.f1588f = deviceInfo.getUserTimezone();
            this.f1589g = deviceInfo.typeOrigin();
            this.f1590h = deviceInfo.deviceResolutionJson();
            this.f1591i = new JSONArray();
            this.f1592j = new Date().getTime();
        }
    }

    public C2488F1(a aVar) {
        this.f1571a = aVar.f1593k;
        this.f1572b = aVar.f1594l;
        this.f1573c = aVar.f1583a;
        this.f1574d = aVar.f1584b;
        this.f1575e = aVar.f1585c;
        this.f1576f = aVar.f1586d;
        this.f1577g = aVar.f1587e;
        this.f1578h = aVar.f1588f;
        this.f1579i = aVar.f1589g;
        this.f1580j = aVar.f1590h;
        this.f1581k = aVar.f1591i;
        this.f1582l = aVar.f1592j;
    }
}
