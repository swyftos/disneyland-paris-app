package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidLambdaResponseException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class InvalidLambdaResponseExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidLambdaResponseExceptionUnmarshaller() {
        super(InvalidLambdaResponseException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidLambdaResponseException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidLambdaResponseException invalidLambdaResponseException = (InvalidLambdaResponseException) super.unmarshall(jsonErrorResponse);
        invalidLambdaResponseException.setErrorCode("InvalidLambdaResponseException");
        return invalidLambdaResponseException;
    }
}
