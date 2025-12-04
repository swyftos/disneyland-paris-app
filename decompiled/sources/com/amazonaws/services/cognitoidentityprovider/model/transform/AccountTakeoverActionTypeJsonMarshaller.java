package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AccountTakeoverActionTypeJsonMarshaller {
    private static AccountTakeoverActionTypeJsonMarshaller instance;

    AccountTakeoverActionTypeJsonMarshaller() {
    }

    public void marshall(AccountTakeoverActionType accountTakeoverActionType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (accountTakeoverActionType.getNotify() != null) {
            Boolean notify = accountTakeoverActionType.getNotify();
            awsJsonWriter.name("Notify");
            awsJsonWriter.value(notify.booleanValue());
        }
        if (accountTakeoverActionType.getEventAction() != null) {
            String eventAction = accountTakeoverActionType.getEventAction();
            awsJsonWriter.name("EventAction");
            awsJsonWriter.value(eventAction);
        }
        awsJsonWriter.endObject();
    }

    public static AccountTakeoverActionTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverActionTypeJsonMarshaller();
        }
        return instance;
    }
}
