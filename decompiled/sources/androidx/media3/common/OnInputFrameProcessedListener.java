package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes.dex */
public interface OnInputFrameProcessedListener {
    void onInputFrameProcessed(int i, long j) throws VideoFrameProcessingException;
}
