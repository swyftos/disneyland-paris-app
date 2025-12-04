package com.amazonaws.auth;

/* loaded from: classes2.dex */
public interface AWSCredentialsProvider {
    AWSCredentials getCredentials();

    void refresh();
}
