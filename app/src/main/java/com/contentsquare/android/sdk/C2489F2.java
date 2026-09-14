package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.F2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2489F2 {

    /* JADX INFO: renamed from: a */
    public final int f1595a;

    /* JADX INFO: renamed from: b */
    public final int f1596b;

    /* JADX INFO: renamed from: c */
    public final int f1597c;

    /* JADX INFO: renamed from: d */
    public final int f1598d;

    /* JADX INFO: renamed from: e */
    public final float f1599e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public String f1600f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public String f1601g;

    /* JADX INFO: renamed from: h */
    public boolean f1602h;

    /* JADX INFO: renamed from: i */
    public float f1603i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Boolean f1604j;

    /* JADX INFO: renamed from: k */
    @NotNull
    public final Logger f1605k;

    public C2489F2(int i, int i2, int i3, int i4, float f, String str, String str2, boolean z, float f2, int i5) {
        i = (i5 & 1) != 0 ? 0 : i;
        i2 = (i5 & 2) != 0 ? 0 : i2;
        i3 = (i5 & 4) != 0 ? 0 : i3;
        i4 = (i5 & 8) != 0 ? 0 : i4;
        f = (i5 & 16) != 0 ? 0.0f : f;
        str = (i5 & 32) != 0 ? null : str;
        str2 = (i5 & 64) != 0 ? null : str2;
        z = (i5 & 128) != 0 ? false : z;
        f2 = (i5 & 256) != 0 ? 0.0f : f2;
        this.f1595a = i;
        this.f1596b = i2;
        this.f1597c = i3;
        this.f1598d = i4;
        this.f1599e = f;
        this.f1600f = str;
        this.f1601g = str2;
        this.f1602h = z;
        this.f1603i = f2;
        this.f1604j = null;
        this.f1605k = new Logger("JsonStyleView");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final JSONObject m916a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("height", this.f1596b);
            jSONObject.put("width", this.f1595a);
            jSONObject.put("x", this.f1597c);
            jSONObject.put("y", this.f1598d);
            jSONObject.put("z", this.f1599e);
            jSONObject.putOpt("bmp", this.f1600f);
            String str = this.f1601g;
            if (str != null) {
                jSONObject.put("bg", str);
                jSONObject.put("alpha", this.f1603i);
            }
            jSONObject.put("visibility", this.f1602h);
            Boolean bool = this.f1604j;
            if (bool == null) {
                return jSONObject;
            }
            jSONObject.put("interactionEnabled", bool);
            return jSONObject;
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1605k, "Failed to build style object " + e.getMessage(), e);
            return new JSONObject();
        }
    }
}
