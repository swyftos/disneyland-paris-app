package com.contentsquare.android.sdk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.contentsquare.android.sdk.n7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0758n7 {

    @NotNull
    public final JSONObject a;

    public C0758n7(@NotNull JSONObject content, long j, long j2, @NotNull String reportType) throws JSONException {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        this.a = content;
        content.put("type", reportType);
        content.put("from", j);
        content.put(TypedValues.TransitionType.S_TO, j2);
    }
}
