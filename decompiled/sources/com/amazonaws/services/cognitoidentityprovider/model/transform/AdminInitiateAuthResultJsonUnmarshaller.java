package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class AdminInitiateAuthResultJsonUnmarshaller implements Unmarshaller<AdminInitiateAuthResult, JsonUnmarshallerContext> {
    private static AdminInitiateAuthResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminInitiateAuthResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AdminInitiateAuthResult adminInitiateAuthResult = new AdminInitiateAuthResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("ChallengeName")) {
                adminInitiateAuthResult.setChallengeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Session")) {
                adminInitiateAuthResult.setSession(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ChallengeParameters")) {
                adminInitiateAuthResult.setChallengeParameters(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("AuthenticationResult")) {
                adminInitiateAuthResult.setAuthenticationResult(AuthenticationResultTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminInitiateAuthResult;
    }

    public static AdminInitiateAuthResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminInitiateAuthResultJsonUnmarshaller();
        }
        return instance;
    }
}
