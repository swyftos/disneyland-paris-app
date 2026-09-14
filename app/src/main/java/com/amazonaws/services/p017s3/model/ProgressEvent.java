package com.amazonaws.services.p017s3.model;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class ProgressEvent extends com.amazonaws.event.ProgressEvent {
    public ProgressEvent(int i) {
        super(i);
    }

    public ProgressEvent(int i, long j) {
        super(i, j);
    }

    @Deprecated
    public void setBytesTransfered(int i) {
        setBytesTransferred(i);
    }

    @Deprecated
    public int getBytesTransfered() {
        return (int) getBytesTransferred();
    }
}
