package com.amazonaws;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseMetadata {
    public static final String AWS_REQUEST_ID = "AWS_REQUEST_ID";
    protected final Map<String, String> metadata;

    public ResponseMetadata(Map<String, String> map) {
        this.metadata = map;
    }

    public ResponseMetadata(ResponseMetadata responseMetadata) {
        this(responseMetadata.metadata);
    }

    public String getRequestId() {
        return this.metadata.get(AWS_REQUEST_ID);
    }

    public String toString() {
        Map<String, String> map = this.metadata;
        if (map == null) {
            return "{}";
        }
        return map.toString();
    }
}
