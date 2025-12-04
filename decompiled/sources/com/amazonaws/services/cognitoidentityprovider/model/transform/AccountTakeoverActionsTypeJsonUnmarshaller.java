package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AccountTakeoverActionsType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class AccountTakeoverActionsTypeJsonUnmarshaller implements Unmarshaller<AccountTakeoverActionsType, JsonUnmarshallerContext> {
    private static AccountTakeoverActionsTypeJsonUnmarshaller instance;

    AccountTakeoverActionsTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AccountTakeoverActionsType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AccountTakeoverActionsType accountTakeoverActionsType = new AccountTakeoverActionsType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("LowAction")) {
                accountTakeoverActionsType.setLowAction(AccountTakeoverActionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("MediumAction")) {
                accountTakeoverActionsType.setMediumAction(AccountTakeoverActionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("HighAction")) {
                accountTakeoverActionsType.setHighAction(AccountTakeoverActionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return accountTakeoverActionsType;
    }

    public static AccountTakeoverActionsTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AccountTakeoverActionsTypeJsonUnmarshaller();
        }
        return instance;
    }
}
