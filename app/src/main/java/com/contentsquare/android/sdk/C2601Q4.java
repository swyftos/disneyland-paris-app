package com.contentsquare.android.sdk;

import com.contentsquare.android.api.model.CustomVar;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.Q4 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nScreenCapture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenCapture.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCapture\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,109:1\n26#2:110\n*S KotlinDebug\n*F\n+ 1 ScreenCapture.kt\ncom/contentsquare/android/analytics/internal/features/clientmode/screencapture/ScreenCapture\n*L\n50#1:110\n*E\n"})
public final class C2601Q4 {

    /* JADX INFO: renamed from: a */
    public int f1994a;

    /* JADX INFO: renamed from: b */
    public int f1995b;

    /* JADX INFO: renamed from: c */
    public int f1996c;

    /* JADX INFO: renamed from: d */
    public int f1997d;

    /* JADX INFO: renamed from: f */
    @Nullable
    public String f1999f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public String f2000g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public String f2001h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public String f2002i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public String f2003j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public String f2004k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public String f2005l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public String f2006m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public C2640U4 f2007n;

    /* JADX INFO: renamed from: e */
    public double f1998e = 1.0d;

    /* JADX INFO: renamed from: o */
    @NotNull
    public String f2008o = "";

    /* JADX INFO: renamed from: p */
    @NotNull
    public a f2009p = a.f2010b;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.Q4$a */
    public enum a {
        f2010b("PerViews"),
        f2011c("Fullscreen");


        /* JADX INFO: renamed from: a */
        @NotNull
        public final String f2013a;

        a(String str) {
            this.f2013a = str;
        }

        @Override // java.lang.Enum
        @NotNull
        public final String toString() {
            return this.f2013a;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final JSONObject m1012a(boolean z) throws JSONException {
        CustomVar[] customVarArr;
        CustomVar[] customVarArr2;
        C2640U4 c2640u4 = this.f2007n;
        if (c2640u4 == null) {
            throw new JSONException("Object is not valid. We are missing the ScreenGraph data.");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_height", this.f1995b);
        jSONObject.put("device_width", this.f1994a);
        jSONObject.put("device_ratio", this.f1998e);
        jSONObject.put("device_model", this.f1999f);
        jSONObject.put("device_manufacturer", this.f2000g);
        jSONObject.put("version_sdk", this.f2001h);
        jSONObject.put("version_json", this.f2002i);
        jSONObject.put("device_id", this.f1996c);
        jSONObject.put("project_id", this.f1997d);
        jSONObject.put("version_app", this.f2003j);
        jSONObject.put("version_os", this.f2004k);
        jSONObject.put("inapp_user_id", this.f2005l);
        jSONObject.put("url", this.f2006m);
        jSONObject.put("bmp_capture_type", this.f2009p.f2013a);
        C2640U4 c2640u5 = this.f2007n;
        if (c2640u5 == null || (customVarArr = c2640u5.f2178c) == null) {
            customVarArr = new CustomVar[0];
        }
        if (!(customVarArr.length == 0)) {
            CustomVar.Companion companion = CustomVar.INSTANCE;
            if (c2640u5 == null || (customVarArr2 = c2640u5.f2178c) == null) {
                customVarArr2 = new CustomVar[0];
            }
            jSONObject.put("cv", companion.serializeCustomVarsToJson(customVarArr2));
        }
        JSONArray jSONArray = new JSONArray();
        for (C2499G2 c2499g2 : c2640u4.f2179d) {
            if (z) {
                c2499g2 = (C2499G2) CollectionsKt.first(C2650V4.m1044a(c2499g2, true));
            }
            jSONArray.put(c2499g2.m924a());
        }
        jSONObject.put("screengraph", jSONArray);
        jSONObject.put("screenshot", this.f2008o);
        return jSONObject;
    }
}
