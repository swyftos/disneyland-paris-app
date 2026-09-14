package com.amazonaws.handlers;

import com.amazonaws.AmazonWebServiceRequest;

/* JADX INFO: loaded from: classes2.dex */
public interface AsyncHandler<REQUEST extends AmazonWebServiceRequest, RESULT> {
    void onError(Exception exc);

    void onSuccess(REQUEST request, RESULT result);
}
