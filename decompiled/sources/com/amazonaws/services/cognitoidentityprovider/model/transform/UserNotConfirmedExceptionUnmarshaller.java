package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserNotConfirmedException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UserNotConfirmedExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserNotConfirmedExceptionUnmarshaller() {
        super(UserNotConfirmedException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserNotConfirmedException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserNotConfirmedException userNotConfirmedException = (UserNotConfirmedException) super.unmarshall(jsonErrorResponse);
        userNotConfirmedException.setErrorCode("UserNotConfirmedException");
        return userNotConfirmedException;
    }
}
