package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CompromisedCredentialsRiskConfigurationType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller implements Unmarshaller<CompromisedCredentialsRiskConfigurationType, JsonUnmarshallerContext> {
    private static CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller instance;

    CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public CompromisedCredentialsRiskConfigurationType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType = new CompromisedCredentialsRiskConfigurationType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("EventFilter")) {
                compromisedCredentialsRiskConfigurationType.setEventFilter(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Actions")) {
                compromisedCredentialsRiskConfigurationType.setActions(CompromisedCredentialsActionsTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return compromisedCredentialsRiskConfigurationType;
    }

    public static CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CompromisedCredentialsRiskConfigurationTypeJsonUnmarshaller();
        }
        return instance;
    }
}
