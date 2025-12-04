package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AssociateSoftwareTokenResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class AssociateSoftwareTokenResultJsonUnmarshaller implements Unmarshaller<AssociateSoftwareTokenResult, JsonUnmarshallerContext> {
    private static AssociateSoftwareTokenResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AssociateSoftwareTokenResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AssociateSoftwareTokenResult associateSoftwareTokenResult = new AssociateSoftwareTokenResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("SecretCode")) {
                associateSoftwareTokenResult.setSecretCode(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Session")) {
                associateSoftwareTokenResult.setSession(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return associateSoftwareTokenResult;
    }

    public static AssociateSoftwareTokenResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AssociateSoftwareTokenResultJsonUnmarshaller();
        }
        return instance;
    }
}
