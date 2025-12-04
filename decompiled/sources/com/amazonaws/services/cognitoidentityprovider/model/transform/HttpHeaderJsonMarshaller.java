package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.HttpHeader;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class HttpHeaderJsonMarshaller {
    private static HttpHeaderJsonMarshaller instance;

    HttpHeaderJsonMarshaller() {
    }

    public void marshall(HttpHeader httpHeader, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (httpHeader.getHeaderName() != null) {
            String headerName = httpHeader.getHeaderName();
            awsJsonWriter.name("headerName");
            awsJsonWriter.value(headerName);
        }
        if (httpHeader.getHeaderValue() != null) {
            String headerValue = httpHeader.getHeaderValue();
            awsJsonWriter.name("headerValue");
            awsJsonWriter.value(headerValue);
        }
        awsJsonWriter.endObject();
    }

    public static HttpHeaderJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new HttpHeaderJsonMarshaller();
        }
        return instance;
    }
}
