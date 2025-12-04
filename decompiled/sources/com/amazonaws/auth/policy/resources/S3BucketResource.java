package com.amazonaws.auth.policy.resources;

import com.amazonaws.auth.policy.Resource;

/* loaded from: classes2.dex */
public class S3BucketResource extends Resource {
    public S3BucketResource(String str) {
        super("arn:aws:s3:::" + str);
    }
}
