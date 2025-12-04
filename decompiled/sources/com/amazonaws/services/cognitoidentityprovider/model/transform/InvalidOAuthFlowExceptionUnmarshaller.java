package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidOAuthFlowException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class InvalidOAuthFlowExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidOAuthFlowExceptionUnmarshaller() {
        super(InvalidOAuthFlowException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidOAuthFlowException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidOAuthFlowException invalidOAuthFlowException = (InvalidOAuthFlowException) super.unmarshall(jsonErrorResponse);
        invalidOAuthFlowException.setErrorCode("InvalidOAuthFlowException");
        return invalidOAuthFlowException;
    }
}
