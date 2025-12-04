package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RiskExceptionConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
class RiskExceptionConfigurationTypeJsonMarshaller {
    private static RiskExceptionConfigurationTypeJsonMarshaller instance;

    RiskExceptionConfigurationTypeJsonMarshaller() {
    }

    public void marshall(RiskExceptionConfigurationType riskExceptionConfigurationType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (riskExceptionConfigurationType.getBlockedIPRangeList() != null) {
            List<String> blockedIPRangeList = riskExceptionConfigurationType.getBlockedIPRangeList();
            awsJsonWriter.name("BlockedIPRangeList");
            awsJsonWriter.beginArray();
            for (String str : blockedIPRangeList) {
                if (str != null) {
                    awsJsonWriter.value(str);
                }
            }
            awsJsonWriter.endArray();
        }
        if (riskExceptionConfigurationType.getSkippedIPRangeList() != null) {
            List<String> skippedIPRangeList = riskExceptionConfigurationType.getSkippedIPRangeList();
            awsJsonWriter.name("SkippedIPRangeList");
            awsJsonWriter.beginArray();
            for (String str2 : skippedIPRangeList) {
                if (str2 != null) {
                    awsJsonWriter.value(str2);
                }
            }
            awsJsonWriter.endArray();
        }
        awsJsonWriter.endObject();
    }

    public static RiskExceptionConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RiskExceptionConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
