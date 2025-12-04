package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class F2 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    @Nullable
    public String f;

    @Nullable
    public String g;
    public boolean h;
    public float i;

    @Nullable
    public Boolean j;

    @NotNull
    public final Logger k;

    public F2(int i, int i2, int i3, int i4, float f, String str, String str2, boolean z, float f2, int i5) {
        i = (i5 & 1) != 0 ? 0 : i;
        i2 = (i5 & 2) != 0 ? 0 : i2;
        i3 = (i5 & 4) != 0 ? 0 : i3;
        i4 = (i5 & 8) != 0 ? 0 : i4;
        f = (i5 & 16) != 0 ? 0.0f : f;
        str = (i5 & 32) != 0 ? null : str;
        str2 = (i5 & 64) != 0 ? null : str2;
        z = (i5 & 128) != 0 ? false : z;
        f2 = (i5 & 256) != 0 ? 0.0f : f2;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = f;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = f2;
        this.j = null;
        this.k = new Logger("JsonStyleView");
    }

    @NotNull
    public final JSONObject a() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("height", this.b);
            jSONObject.put("width", this.a);
            jSONObject.put("x", this.c);
            jSONObject.put("y", this.d);
            jSONObject.put("z", this.e);
            jSONObject.putOpt("bmp", this.f);
            String str = this.g;
            if (str != null) {
                jSONObject.put("bg", str);
                jSONObject.put("alpha", this.i);
            }
            jSONObject.put("visibility", this.h);
            Boolean bool = this.j;
            if (bool == null) {
                return jSONObject;
            }
            jSONObject.put("interactionEnabled", bool);
            return jSONObject;
        } catch (JSONException e) {
            Q2.a(this.k, "Failed to build style object " + e.getMessage(), e);
            return new JSONObject();
        }
    }
}
