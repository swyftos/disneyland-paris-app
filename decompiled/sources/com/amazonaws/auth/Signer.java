package com.amazonaws.auth;

import com.amazonaws.Request;

/* loaded from: classes2.dex */
public interface Signer {
    void sign(Request<?> request, AWSCredentials aWSCredentials);
}
