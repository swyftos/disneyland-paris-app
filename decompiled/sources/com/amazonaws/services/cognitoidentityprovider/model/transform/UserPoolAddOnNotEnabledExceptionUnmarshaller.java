package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UserPoolAddOnNotEnabledException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UserPoolAddOnNotEnabledExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UserPoolAddOnNotEnabledExceptionUnmarshaller() {
        super(UserPoolAddOnNotEnabledException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UserPoolAddOnNotEnabledException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UserPoolAddOnNotEnabledException userPoolAddOnNotEnabledException = (UserPoolAddOnNotEnabledException) super.unmarshall(jsonErrorResponse);
        userPoolAddOnNotEnabledException.setErrorCode("UserPoolAddOnNotEnabledException");
        return userPoolAddOnNotEnabledException;
    }
}
