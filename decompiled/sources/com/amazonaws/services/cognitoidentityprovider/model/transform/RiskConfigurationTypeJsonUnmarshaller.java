package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.RiskConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class RiskConfigurationTypeJsonUnmarshaller implements Unmarshaller<RiskConfigurationType, JsonUnmarshallerContext> {
    private static RiskConfigurationTypeJsonUnmarshaller instance;

    RiskConfigurationTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public RiskConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        RiskConfigurationType riskConfigurationType = new RiskConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("UserPoolId")) {
                riskConfigurationType.setUserPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ClientId")) {
                riskConfigurationType.setClientId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("CompromisedCredentialsRiskConfiguration")) {
                riskConfigurationType.setCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("AccountTakeoverRiskConfiguration")) {
                riskConfigurationType.setAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("RiskExceptionConfiguration")) {
                riskConfigurationType.setRiskExceptionConfiguration(RiskExceptionConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("LastModifiedDate")) {
                riskConfigurationType.setLastModifiedDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return riskConfigurationType;
    }

    public static RiskConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RiskConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
