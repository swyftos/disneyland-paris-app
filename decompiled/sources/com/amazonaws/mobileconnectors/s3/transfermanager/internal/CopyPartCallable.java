package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.PartETag;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class CopyPartCallable implements Callable<PartETag> {
    private final CopyPartRequest request;
    private final AmazonS3 s3;

    public CopyPartCallable(AmazonS3 amazonS3, CopyPartRequest copyPartRequest) {
        this.s3 = amazonS3;
        this.request = copyPartRequest;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PartETag call() throws Exception {
        return this.s3.copyPart(this.request).getPartETag();
    }
}
