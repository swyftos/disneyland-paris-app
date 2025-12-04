package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.TooManyFailedAttemptsException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class TooManyFailedAttemptsExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public TooManyFailedAttemptsExceptionUnmarshaller() {
        super(TooManyFailedAttemptsException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("TooManyFailedAttemptsException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        TooManyFailedAttemptsException tooManyFailedAttemptsException = (TooManyFailedAttemptsException) super.unmarshall(jsonErrorResponse);
        tooManyFailedAttemptsException.setErrorCode("TooManyFailedAttemptsException");
        return tooManyFailedAttemptsException;
    }
}
