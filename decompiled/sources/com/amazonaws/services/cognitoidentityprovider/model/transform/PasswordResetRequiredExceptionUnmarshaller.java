package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.PasswordResetRequiredException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class PasswordResetRequiredExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public PasswordResetRequiredExceptionUnmarshaller() {
        super(PasswordResetRequiredException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("PasswordResetRequiredException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        PasswordResetRequiredException passwordResetRequiredException = (PasswordResetRequiredException) super.unmarshall(jsonErrorResponse);
        passwordResetRequiredException.setErrorCode("PasswordResetRequiredException");
        return passwordResetRequiredException;
    }
}
