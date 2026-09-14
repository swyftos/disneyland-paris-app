package com.amazonaws.mobileconnectors.p016s3.transfermanager.internal;

import com.amazonaws.services.p017s3.AmazonS3;
import com.amazonaws.services.p017s3.model.CopyPartRequest;
import com.amazonaws.services.p017s3.model.PartETag;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class CopyPartCallable implements Callable<PartETag> {
    private final CopyPartRequest request;

    /* JADX INFO: renamed from: s3 */
    private final AmazonS3 f351s3;

    public CopyPartCallable(AmazonS3 amazonS3, CopyPartRequest copyPartRequest) {
        this.f351s3 = amazonS3;
        this.request = copyPartRequest;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public PartETag call() throws Exception {
        return this.f351s3.copyPart(this.request).getPartETag();
    }
}
