package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.MapUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class InitiateAuthResultJsonUnmarshaller implements Unmarshaller<InitiateAuthResult, JsonUnmarshallerContext> {
    private static InitiateAuthResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public InitiateAuthResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        InitiateAuthResult initiateAuthResult = new InitiateAuthResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("ChallengeName")) {
                initiateAuthResult.setChallengeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Session")) {
                initiateAuthResult.setSession(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ChallengeParameters")) {
                initiateAuthResult.setChallengeParameters(new MapUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("AuthenticationResult")) {
                initiateAuthResult.setAuthenticationResult(AuthenticationResultTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return initiateAuthResult;
    }

    public static InitiateAuthResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InitiateAuthResultJsonUnmarshaller();
        }
        return instance;
    }
}
