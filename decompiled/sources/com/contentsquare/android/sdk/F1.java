package com.contentsquare.android.sdk;

import com.contentsquare.android.core.system.DeviceInfo;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class F1 {

    @Nullable
    public final String a;
    public final int b;

    @NotNull
    public final DeviceInfo.DeviceType c;

    @NotNull
    public final String d;

    @NotNull
    public final String e;

    @Nullable
    public final String f;

    @Nullable
    public final String g;

    @NotNull
    public final String h;

    @NotNull
    public final JSONObject i;

    @NotNull
    public final JSONObject j;

    @NotNull
    public final JSONArray k;
    public final long l;

    public static final class a {

        @NotNull
        public final DeviceInfo.DeviceType a;

        @NotNull
        public final String b;

        @NotNull
        public final String c;

        @Nullable
        public final String d;

        @Nullable
        public final String e;

        @NotNull
        public final String f;

        @NotNull
        public final JSONObject g;

        @NotNull
        public final JSONObject h;

        @NotNull
        public final JSONArray i;
        public final long j;

        @Nullable
        public String k;
        public int l;

        public a(@NotNull DeviceInfo deviceInfo) {
            Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
            this.a = deviceInfo.getDeviceType();
            this.b = deviceInfo.getDeviceOs();
            this.c = deviceInfo.getUserLanguage();
            this.d = deviceInfo.getDeviceModel();
            this.e = deviceInfo.getDeviceManufacturer();
            this.f = deviceInfo.getUserTimezone();
            this.g = deviceInfo.typeOrigin();
            this.h = deviceInfo.deviceResolutionJson();
            this.i = new JSONArray();
            this.j = new Date().getTime();
        }
    }

    public F1(a aVar) {
        this.a = aVar.k;
        this.b = aVar.l;
        this.c = aVar.a;
        this.d = aVar.b;
        this.e = aVar.c;
        this.f = aVar.d;
        this.g = aVar.e;
        this.h = aVar.f;
        this.i = aVar.g;
        this.j = aVar.h;
        this.k = aVar.i;
        this.l = aVar.j;
    }
}
