package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AnalyticsMetadataTypeJsonMarshaller {
    private static AnalyticsMetadataTypeJsonMarshaller instance;

    AnalyticsMetadataTypeJsonMarshaller() {
    }

    public void marshall(AnalyticsMetadataType analyticsMetadataType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (analyticsMetadataType.getAnalyticsEndpointId() != null) {
            String analyticsEndpointId = analyticsMetadataType.getAnalyticsEndpointId();
            awsJsonWriter.name("AnalyticsEndpointId");
            awsJsonWriter.value(analyticsEndpointId);
        }
        awsJsonWriter.endObject();
    }

    public static AnalyticsMetadataTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AnalyticsMetadataTypeJsonMarshaller();
        }
        return instance;
    }
}
