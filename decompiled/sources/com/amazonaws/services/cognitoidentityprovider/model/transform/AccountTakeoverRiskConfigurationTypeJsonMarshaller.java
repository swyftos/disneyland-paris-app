package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionsType;
import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverRiskConfigurationType;
import com.amazonaws.services.cognitoidentityprovider.model.NotifyConfigurationType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AccountTakeoverRiskConfigurationTypeJsonMarshaller {
    private static AccountTakeoverRiskConfigurationTypeJsonMarshaller instance;

    AccountTakeoverRiskConfigurationTypeJsonMarshaller() {
    }

    public void marshall(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (accountTakeoverRiskConfigurationType.getNotifyConfiguration() != null) {
            NotifyConfigurationType notifyConfiguration = accountTakeoverRiskConfigurationType.getNotifyConfiguration();
            awsJsonWriter.name("NotifyConfiguration");
            NotifyConfigurationTypeJsonMarshaller.getInstance().marshall(notifyConfiguration, awsJsonWriter);
        }
        if (accountTakeoverRiskConfigurationType.getActions() != null) {
            AccountTakeoverActionsType actions = accountTakeoverRiskConfigurationType.getActions();
            awsJsonWriter.name("Actions");
            AccountTakeoverActionsTypeJsonMarshaller.getInstance().marshall(actions, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static AccountTakeoverRiskConfigurationTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverRiskConfigurationTypeJsonMarshaller();
        }
        return instance;
    }
}
