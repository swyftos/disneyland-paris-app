package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CompromisedCredentialsActionsType;
import com.amazonaws.services.cognitoidentityprovider.model.CompromisedCredentialsRiskConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
class CompromisedCredentialsRiskConfigurationTypeJsonMarshaller {
    private static CompromisedCredentialsRiskConfigurationTypeJsonMarshaller instance;

    CompromisedCredentialsRiskConfigurationTypeJsonMarshaller() {
    }

    public void marshall(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (compromisedCredentialsRiskConfigurationType.getEventFilter() != null) {
            List<String> eventFilter = compromisedCredentialsRiskConfigurationType.getEventFilter();
            awsJsonWriter.name("EventFilter");
            awsJsonWriter.beginArray();
            for (String str : eventFilter) {
                if (str != null) {
                    awsJsonWriter.value(str);
                }
            }
            awsJsonWriter.endArray();
        }
        if (compromisedCredentialsRiskConfigurationType.getActions() != null) {
            CompromisedCredentialsActionsType actions = compromisedCredentialsRiskConfigurationType.getActions();
            awsJsonWriter.name("Actions");
            CompromisedCredentialsActionsTypeJsonMarshaller.getInstance().marshall(actions, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static CompromisedCredentialsRiskConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CompromisedCredentialsRiskConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
