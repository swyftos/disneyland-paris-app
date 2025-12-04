package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionType;
import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionsType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AccountTakeoverActionsTypeJsonMarshaller {
    private static AccountTakeoverActionsTypeJsonMarshaller instance;

    AccountTakeoverActionsTypeJsonMarshaller() {
    }

    public void marshall(AccountTakeoverActionsType accountTakeoverActionsType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (accountTakeoverActionsType.getLowAction() != null) {
            AccountTakeoverActionType lowAction = accountTakeoverActionsType.getLowAction();
            awsJsonWriter.name("LowAction");
            AccountTakeoverActionTypeJsonMarshaller.getInstance().marshall(lowAction, awsJsonWriter);
        }
        if (accountTakeoverActionsType.getMediumAction() != null) {
            AccountTakeoverActionType mediumAction = accountTakeoverActionsType.getMediumAction();
            awsJsonWriter.name("MediumAction");
            AccountTakeoverActionTypeJsonMarshaller.getInstance().marshall(mediumAction, awsJsonWriter);
        }
        if (accountTakeoverActionsType.getHighAction() != null) {
            AccountTakeoverActionType highAction = accountTakeoverActionsType.getHighAction();
            awsJsonWriter.name("HighAction");
            AccountTakeoverActionTypeJsonMarshaller.getInstance().marshall(highAction, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static AccountTakeoverActionsTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverActionsTypeJsonMarshaller();
        }
        return instance;
    }
}
