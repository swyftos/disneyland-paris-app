package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface OnInputFrameProcessedListener {
    void onInputFrameProcessed(int i, long j) throws VideoFrameProcessingException;
}
