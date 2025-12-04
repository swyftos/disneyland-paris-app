package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ListUserPoolClientsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class ListUserPoolClientsResultJsonUnmarshaller implements Unmarshaller<ListUserPoolClientsResult, JsonUnmarshallerContext> {
    private static ListUserPoolClientsResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ListUserPoolClientsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListUserPoolClientsResult listUserPoolClientsResult = new ListUserPoolClientsResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("UserPoolClients")) {
                listUserPoolClientsResult.setUserPoolClients(new ListUnmarshaller(UserPoolClientDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NextToken")) {
                listUserPoolClientsResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listUserPoolClientsResult;
    }

    public static ListUserPoolClientsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListUserPoolClientsResultJsonUnmarshaller();
        }
        return instance;
    }
}
