package com.contentsquare.android.sdk;

import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.i6 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2777i6 {
    private long timestamp;

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    @NotNull
    public abstract SessionRecordingV1.Event toProto();
}
