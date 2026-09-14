package com.contentsquare.android.sdk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n7 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2828n7 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final JSONObject f2922a;

    public C2828n7(@NotNull JSONObject content, long j, long j2, @NotNull String reportType) throws JSONException {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(reportType, "reportType");
        this.f2922a = content;
        content.put("type", reportType);
        content.put("from", j);
        content.put(TypedValues.TransitionType.S_TO, j2);
    }
}
