package com.amazonaws.auth;

/* JADX INFO: loaded from: classes2.dex */
public interface AWSIdentityProvider {
    String getToken();

    String refresh();
}
