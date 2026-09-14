package com.amazonaws.auth;

/* JADX INFO: loaded from: classes2.dex */
public interface AWSCredentialsProvider {
    AWSCredentials getCredentials();

    void refresh();
}
