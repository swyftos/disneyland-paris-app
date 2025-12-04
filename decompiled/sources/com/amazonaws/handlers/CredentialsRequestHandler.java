package com.amazonaws.handlers;

import com.amazonaws.auth.AWSCredentials;

/* loaded from: classes2.dex */
public abstract class CredentialsRequestHandler extends RequestHandler2 {
    protected AWSCredentials awsCredentials;

    public void setCredentials(AWSCredentials aWSCredentials) {
        this.awsCredentials = aWSCredentials;
    }
}
