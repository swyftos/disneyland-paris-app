package com.amazonaws.services.p017s3;

import com.amazonaws.services.p017s3.internal.FileDeletionEvent;

/* JADX INFO: loaded from: classes2.dex */
public interface OnFileDelete {
    void onFileDelete(FileDeletionEvent fileDeletionEvent);
}
