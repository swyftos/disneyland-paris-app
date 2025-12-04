package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.MappingRule;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class MappingRuleJsonMarshaller {
    private static MappingRuleJsonMarshaller instance;

    MappingRuleJsonMarshaller() {
    }

    public void marshall(MappingRule mappingRule, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (mappingRule.getClaim() != null) {
            String claim = mappingRule.getClaim();
            awsJsonWriter.name("Claim");
            awsJsonWriter.value(claim);
        }
        if (mappingRule.getMatchType() != null) {
            String matchType = mappingRule.getMatchType();
            awsJsonWriter.name("MatchType");
            awsJsonWriter.value(matchType);
        }
        if (mappingRule.getValue() != null) {
            String value = mappingRule.getValue();
            awsJsonWriter.name("Value");
            awsJsonWriter.value(value);
        }
        if (mappingRule.getRoleARN() != null) {
            String roleARN = mappingRule.getRoleARN();
            awsJsonWriter.name("RoleARN");
            awsJsonWriter.value(roleARN);
        }
        awsJsonWriter.endObject();
    }

    public static MappingRuleJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new MappingRuleJsonMarshaller();
        }
        return instance;
    }
}
