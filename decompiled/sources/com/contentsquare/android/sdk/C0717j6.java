package com.contentsquare.android.sdk;

import android.net.Uri;
import androidx.annotation.AnyThread;
import com.contentsquare.android.core.utils.SystemInstantiable;
import com.contentsquare.proto.replayproperties.v1.ReplayPropertiesV1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: com.contentsquare.android.sdk.j6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0717j6 {

    @NotNull
    public final SystemInstantiable a;

    @NotNull
    public final G5 b;

    public C0717j6(@NotNull SystemInstantiable systemInstantiable, @NotNull G5 sessionReplayProperties) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(sessionReplayProperties, "sessionReplayProperties");
        this.a = systemInstantiable;
        this.b = sessionReplayProperties;
    }

    @AnyThread
    @NotNull
    public final synchronized String a() {
        String string;
        ReplayPropertiesV1.ReplayProperties replayPropertiesA = this.b.a(this.a.currentTimeMillis());
        Uri.Builder builderBuildUpon = Uri.parse("https://app.contentsquare.com/quick-playback/index.html").buildUpon();
        builderBuildUpon.appendQueryParameter("uu", replayPropertiesA.getVisitorId());
        builderBuildUpon.appendQueryParameter("recordingType", "cs");
        builderBuildUpon.appendQueryParameter("pid", String.valueOf(replayPropertiesA.getProjectId()));
        builderBuildUpon.appendQueryParameter("sn", String.valueOf(replayPropertiesA.getSessionNumber()));
        string = builderBuildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "sessionReplayProperties.….build().toString()\n    }");
        return string;
    }
}
