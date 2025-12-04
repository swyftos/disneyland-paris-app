package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.LambdaConfigType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class LambdaConfigTypeJsonUnmarshaller implements Unmarshaller<LambdaConfigType, JsonUnmarshallerContext> {
    private static LambdaConfigTypeJsonUnmarshaller instance;

    LambdaConfigTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public LambdaConfigType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        LambdaConfigType lambdaConfigType = new LambdaConfigType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("PreSignUp")) {
                lambdaConfigType.setPreSignUp(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("CustomMessage")) {
                lambdaConfigType.setCustomMessage(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("PostConfirmation")) {
                lambdaConfigType.setPostConfirmation(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("PreAuthentication")) {
                lambdaConfigType.setPreAuthentication(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("PostAuthentication")) {
                lambdaConfigType.setPostAuthentication(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("DefineAuthChallenge")) {
                lambdaConfigType.setDefineAuthChallenge(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("CreateAuthChallenge")) {
                lambdaConfigType.setCreateAuthChallenge(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("VerifyAuthChallengeResponse")) {
                lambdaConfigType.setVerifyAuthChallengeResponse(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("PreTokenGeneration")) {
                lambdaConfigType.setPreTokenGeneration(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("UserMigration")) {
                lambdaConfigType.setUserMigration(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return lambdaConfigType;
    }

    public static LambdaConfigTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LambdaConfigTypeJsonUnmarshaller();
        }
        return instance;
    }
}
