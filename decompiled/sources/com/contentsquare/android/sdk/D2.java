package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class D2 {

    @NotNull
    public final String a;

    @NotNull
    public final String b;
    public final int c;

    @NotNull
    public final Logger d;

    public D2(int i, @NotNull String className, @NotNull String fullPath) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        this.a = className;
        this.b = fullPath;
        this.c = i;
        this.d = new Logger("JsonMetadataView");
    }

    @NotNull
    public final JSONObject a() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class_name", this.a);
            jSONObject.put("fullpath", this.b);
            jSONObject.put("child_order", this.c);
            return jSONObject;
        } catch (JSONException e) {
            Q2.a(this.d, "Failed to build metadata object " + e.getMessage(), e);
            return new JSONObject();
        }
    }
}
