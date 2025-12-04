package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AnalyticsConfigurationTypeJsonMarshaller {
    private static AnalyticsConfigurationTypeJsonMarshaller instance;

    AnalyticsConfigurationTypeJsonMarshaller() {
    }

    public void marshall(AnalyticsConfigurationType analyticsConfigurationType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (analyticsConfigurationType.getApplicationId() != null) {
            String applicationId = analyticsConfigurationType.getApplicationId();
            awsJsonWriter.name("ApplicationId");
            awsJsonWriter.value(applicationId);
        }
        if (analyticsConfigurationType.getRoleArn() != null) {
            String roleArn = analyticsConfigurationType.getRoleArn();
            awsJsonWriter.name("RoleArn");
            awsJsonWriter.value(roleArn);
        }
        if (analyticsConfigurationType.getExternalId() != null) {
            String externalId = analyticsConfigurationType.getExternalId();
            awsJsonWriter.name("ExternalId");
            awsJsonWriter.value(externalId);
        }
        if (analyticsConfigurationType.getUserDataShared() != null) {
            Boolean userDataShared = analyticsConfigurationType.getUserDataShared();
            awsJsonWriter.name("UserDataShared");
            awsJsonWriter.value(userDataShared.booleanValue());
        }
        awsJsonWriter.endObject();
    }

    public static AnalyticsConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AnalyticsConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
