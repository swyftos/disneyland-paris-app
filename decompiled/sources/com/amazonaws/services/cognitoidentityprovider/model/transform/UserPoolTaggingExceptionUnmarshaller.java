package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolTaggingException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UserPoolTaggingExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserPoolTaggingExceptionUnmarshaller() {
        super(UserPoolTaggingException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserPoolTaggingException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserPoolTaggingException userPoolTaggingException = (UserPoolTaggingException) super.unmarshall(jsonErrorResponse);
        userPoolTaggingException.setErrorCode("UserPoolTaggingException");
        return userPoolTaggingException;
    }
}
