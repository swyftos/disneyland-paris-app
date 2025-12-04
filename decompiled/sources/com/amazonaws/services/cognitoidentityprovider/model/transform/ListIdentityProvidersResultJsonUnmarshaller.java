package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ListIdentityProvidersResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class ListIdentityProvidersResultJsonUnmarshaller implements Unmarshaller<ListIdentityProvidersResult, JsonUnmarshallerContext> {
    private static ListIdentityProvidersResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ListIdentityProvidersResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListIdentityProvidersResult listIdentityProvidersResult = new ListIdentityProvidersResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("Providers")) {
                listIdentityProvidersResult.setProviders(new ListUnmarshaller(ProviderDescriptionJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NextToken")) {
                listIdentityProvidersResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listIdentityProvidersResult;
    }

    public static ListIdentityProvidersResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListIdentityProvidersResultJsonUnmarshaller();
        }
        return instance;
    }
}
