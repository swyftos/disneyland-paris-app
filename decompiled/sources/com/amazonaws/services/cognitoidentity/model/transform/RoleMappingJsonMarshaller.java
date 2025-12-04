package com.amazonaws.services.cognitoidentity.model.transform;

import com.amazonaws.services.cognitoidentity.model.RoleMapping;
import com.amazonaws.services.cognitoidentity.model.RulesConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class RoleMappingJsonMarshaller {
    private static RoleMappingJsonMarshaller instance;

    RoleMappingJsonMarshaller() {
    }

    public void marshall(RoleMapping roleMapping, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (roleMapping.getType() != null) {
            String type = roleMapping.getType();
            awsJsonWriter.name("Type");
            awsJsonWriter.value(type);
        }
        if (roleMapping.getAmbiguousRoleResolution() != null) {
            String ambiguousRoleResolution = roleMapping.getAmbiguousRoleResolution();
            awsJsonWriter.name("AmbiguousRoleResolution");
            awsJsonWriter.value(ambiguousRoleResolution);
        }
        if (roleMapping.getRulesConfiguration() != null) {
            RulesConfigurationType rulesConfiguration = roleMapping.getRulesConfiguration();
            awsJsonWriter.name("RulesConfiguration");
            RulesConfigurationTypeJsonMarshaller.getInstance().marshall(rulesConfiguration, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static RoleMappingJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new RoleMappingJsonMarshaller();
        }
        return instance;
    }
}
