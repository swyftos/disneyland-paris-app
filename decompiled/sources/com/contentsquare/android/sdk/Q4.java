package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SourceDebugExtension({"SMAP\nScreenCapture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenCapture.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCapture\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,109:1\n26#2:110\n*S KotlinDebug\n*F\n+ 1 ScreenCapture.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCapture\n*L\n50#1:110\n*E\n"})
/* loaded from: classes2.dex */
public final class Q4 {
    public int a;
    public int b;
    public int c;
    public int d;

    @Nullable
    public String f;

    @Nullable
    public String g;

    @Nullable
    public String h;

    @Nullable
    public String i;

    @Nullable
    public String j;

    @Nullable
    public String k;

    @Nullable
    public String l;

    @Nullable
    public String m;

    @Nullable
    public U4 n;
    public double e = 1.0d;

    @NotNull
    public String o = "";

    @NotNull
    public a p = a.b;

    public enum a {
        b("PerViews"),
        c("Fullscreen");


        @NotNull
        public final String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Enum
        @NotNull
        public final String toString() {
            return this.a;
        }
    }

    @NotNull
    public final JSONObject a(boolean z) throws JSONException {
        CustomVar[] customVarArr;
        CustomVar[] customVarArr2;
        U4 u4 = this.n;
        if (u4 == null) {
            throw new JSONException("Object is not valid. We are missing the ScreenGraph data.");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_height", this.b);
        jSONObject.put("device_width", this.a);
        jSONObject.put("device_ratio", this.e);
        jSONObject.put("device_model", this.f);
        jSONObject.put("device_manufacturer", this.g);
        jSONObject.put("version_sdk", this.h);
        jSONObject.put("version_json", this.i);
        jSONObject.put("device_id", this.c);
        jSONObject.put("project_id", this.d);
        jSONObject.put("version_app", this.j);
        jSONObject.put("version_os", this.k);
        jSONObject.put("inapp_user_id", this.l);
        jSONObject.put("url", this.m);
        jSONObject.put("bmp_capture_type", this.p.a);
        U4 u42 = this.n;
        if (u42 == null || (customVarArr = u42.c) == null) {
            customVarArr = new CustomVar[0];
        }
        if (!(customVarArr.length == 0)) {
            CustomVar.Companion companion = CustomVar.INSTANCE;
            if (u42 == null || (customVarArr2 = u42.c) == null) {
                customVarArr2 = new CustomVar[0];
            }
            jSONObject.put("cv", companion.serializeCustomVarsToJson(customVarArr2));
        }
        JSONArray jSONArray = new JSONArray();
        for (G2 g2 : u4.d) {
            if (z) {
                g2 = (G2) CollectionsKt.first(V4.a(g2, true));
            }
            jSONArray.put(g2.a());
        }
        jSONObject.put("screengraph", jSONArray);
        jSONObject.put("screenshot", this.o);
        return jSONObject;
    }
}
