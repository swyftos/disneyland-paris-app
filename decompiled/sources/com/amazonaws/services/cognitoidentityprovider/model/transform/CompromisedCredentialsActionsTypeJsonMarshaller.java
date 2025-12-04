package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CompromisedCredentialsActionsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class CompromisedCredentialsActionsTypeJsonMarshaller {
    private static CompromisedCredentialsActionsTypeJsonMarshaller instance;

    CompromisedCredentialsActionsTypeJsonMarshaller() {
    }

    public void marshall(CompromisedCredentialsActionsType compromisedCredentialsActionsType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (compromisedCredentialsActionsType.getEventAction() != null) {
            String eventAction = compromisedCredentialsActionsType.getEventAction();
            awsJsonWriter.name("EventAction");
            awsJsonWriter.value(eventAction);
        }
        awsJsonWriter.endObject();
    }

    public static CompromisedCredentialsActionsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new CompromisedCredentialsActionsTypeJsonMarshaller();
        }
        return instance;
    }
}
