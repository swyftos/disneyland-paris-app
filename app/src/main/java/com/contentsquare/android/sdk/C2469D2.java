package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.D2 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2469D2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1509a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f1510b;

    /* JADX INFO: renamed from: c */
    public final int f1511c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final Logger f1512d;

    public C2469D2(int i, @NotNull String className, @NotNull String fullPath) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        this.f1509a = className;
        this.f1510b = fullPath;
        this.f1511c = i;
        this.f1512d = new Logger("JsonMetadataView");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final JSONObject m897a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("class_name", this.f1509a);
            jSONObject.put("fullpath", this.f1510b);
            jSONObject.put("child_order", this.f1511c);
            return jSONObject;
        } catch (JSONException e) {
            C2599Q2.m1011a(this.f1512d, "Failed to build metadata object " + e.getMessage(), e);
            return new JSONObject();
        }
    }
}
