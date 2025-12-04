package com.amazonaws.services.s3.model;

/* loaded from: classes2.dex */
public enum S3Event {
    ReducedRedundancyLostObject("s3:ReducedRedundancyLostObject"),
    ObjectCreated("s3:ObjectCreated:*"),
    ObjectCreatedByPut("s3:ObjectCreated:Put"),
    ObjectCreatedByPost("s3:ObjectCreated:Post"),
    ObjectCreatedByCopy("s3:ObjectCreated:Copy"),
    ObjectCreatedByCompleteMultipartUpload("s3:ObjectCreated:CompleteMultipartUpload"),
    ObjectRemoved("s3:ObjectRemoved:*"),
    ObjectRemovedDelete("s3:ObjectRemoved:Delete"),
    ObjectRemovedDeleteMarkerCreated("s3:ObjectRemoved:DeleteMarkerCreated");

    private final String event;

    S3Event(String str) {
        this.event = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.event;
    }
}
