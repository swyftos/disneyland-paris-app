package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnexpectedLambdaException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UnexpectedLambdaExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnexpectedLambdaExceptionUnmarshaller() {
        super(UnexpectedLambdaException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnexpectedLambdaException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnexpectedLambdaException unexpectedLambdaException = (UnexpectedLambdaException) super.unmarshall(jsonErrorResponse);
        unexpectedLambdaException.setErrorCode("UnexpectedLambdaException");
        return unexpectedLambdaException;
    }
}
