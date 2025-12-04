package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserLambdaValidationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UserLambdaValidationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserLambdaValidationExceptionUnmarshaller() {
        super(UserLambdaValidationException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserLambdaValidationException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserLambdaValidationException userLambdaValidationException = (UserLambdaValidationException) super.unmarshall(jsonErrorResponse);
        userLambdaValidationException.setErrorCode("UserLambdaValidationException");
        return userLambdaValidationException;
    }
}
