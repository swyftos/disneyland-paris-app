package com.contentsquare.android.sdk;

import android.net.Uri;
import androidx.annotation.AnyThread;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.proto.replayproperties.p022v1.ReplayPropertiesV1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.j6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2787j6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final SystemInstantiable f2782a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2502G5 f2783b;

    public C2787j6(@NotNull SystemInstantiable systemInstantiable, @NotNull C2502G5 sessionReplayProperties) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(sessionReplayProperties, "sessionReplayProperties");
        this.f2782a = systemInstantiable;
        this.f2783b = sessionReplayProperties;
    }

    @AnyThread
    @NotNull
    /* JADX INFO: renamed from: a */
    public final synchronized String m1164a() {
        String string;
        ReplayPropertiesV1.ReplayProperties replayPropertiesM925a = this.f2783b.m925a(this.f2782a.currentTimeMillis());
        Uri.Builder builderBuildUpon = Uri.parse("https://app.contentsquare.com/quick-playback/index.html").buildUpon();
        builderBuildUpon.appendQueryParameter("uu", replayPropertiesM925a.getVisitorId());
        builderBuildUpon.appendQueryParameter("recordingType", "cs");
        builderBuildUpon.appendQueryParameter("pid", String.valueOf(replayPropertiesM925a.getProjectId()));
        builderBuildUpon.appendQueryParameter("sn", String.valueOf(replayPropertiesM925a.getSessionNumber()));
        string = builderBuildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "sessionReplayProperties.….build().toString()\n    }");
        return string;
    }
}
