package com.amazonaws.auth;

/* loaded from: classes2.dex */
public interface AWSIdentityProvider {
    String getToken();

    String refresh();
}
