package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.LambdaConfigType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class LambdaConfigTypeJsonMarshaller {
    private static LambdaConfigTypeJsonMarshaller instance;

    LambdaConfigTypeJsonMarshaller() {
    }

    public void marshall(LambdaConfigType lambdaConfigType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (lambdaConfigType.getPreSignUp() != null) {
            String preSignUp = lambdaConfigType.getPreSignUp();
            awsJsonWriter.name("PreSignUp");
            awsJsonWriter.value(preSignUp);
        }
        if (lambdaConfigType.getCustomMessage() != null) {
            String customMessage = lambdaConfigType.getCustomMessage();
            awsJsonWriter.name("CustomMessage");
            awsJsonWriter.value(customMessage);
        }
        if (lambdaConfigType.getPostConfirmation() != null) {
            String postConfirmation = lambdaConfigType.getPostConfirmation();
            awsJsonWriter.name("PostConfirmation");
            awsJsonWriter.value(postConfirmation);
        }
        if (lambdaConfigType.getPreAuthentication() != null) {
            String preAuthentication = lambdaConfigType.getPreAuthentication();
            awsJsonWriter.name("PreAuthentication");
            awsJsonWriter.value(preAuthentication);
        }
        if (lambdaConfigType.getPostAuthentication() != null) {
            String postAuthentication = lambdaConfigType.getPostAuthentication();
            awsJsonWriter.name("PostAuthentication");
            awsJsonWriter.value(postAuthentication);
        }
        if (lambdaConfigType.getDefineAuthChallenge() != null) {
            String defineAuthChallenge = lambdaConfigType.getDefineAuthChallenge();
            awsJsonWriter.name("DefineAuthChallenge");
            awsJsonWriter.value(defineAuthChallenge);
        }
        if (lambdaConfigType.getCreateAuthChallenge() != null) {
            String createAuthChallenge = lambdaConfigType.getCreateAuthChallenge();
            awsJsonWriter.name("CreateAuthChallenge");
            awsJsonWriter.value(createAuthChallenge);
        }
        if (lambdaConfigType.getVerifyAuthChallengeResponse() != null) {
            String verifyAuthChallengeResponse = lambdaConfigType.getVerifyAuthChallengeResponse();
            awsJsonWriter.name("VerifyAuthChallengeResponse");
            awsJsonWriter.value(verifyAuthChallengeResponse);
        }
        if (lambdaConfigType.getPreTokenGeneration() != null) {
            String preTokenGeneration = lambdaConfigType.getPreTokenGeneration();
            awsJsonWriter.name("PreTokenGeneration");
            awsJsonWriter.value(preTokenGeneration);
        }
        if (lambdaConfigType.getUserMigration() != null) {
            String userMigration = lambdaConfigType.getUserMigration();
            awsJsonWriter.name("UserMigration");
            awsJsonWriter.value(userMigration);
        }
        awsJsonWriter.endObject();
    }

    public static LambdaConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new LambdaConfigTypeJsonMarshaller();
        }
        return instance;
    }
}
