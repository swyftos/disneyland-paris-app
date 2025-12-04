package com.amazonaws;

/* loaded from: classes2.dex */
public class AmazonWebServiceResponse<T> {
    private ResponseMetadata responseMetadata;
    private Object result;

    public T getResult() {
        return (T) this.result;
    }

    public void setResult(T t) {
        this.result = t;
    }

    public void setResponseMetadata(ResponseMetadata responseMetadata) {
        this.responseMetadata = responseMetadata;
    }

    public ResponseMetadata getResponseMetadata() {
        return this.responseMetadata;
    }

    public String getRequestId() {
        ResponseMetadata responseMetadata = this.responseMetadata;
        if (responseMetadata == null) {
            return null;
        }
        return responseMetadata.getRequestId();
    }
}
