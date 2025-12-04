package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.ScopeDoesNotExistException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class ScopeDoesNotExistExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public ScopeDoesNotExistExceptionUnmarshaller() {
        super(ScopeDoesNotExistException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("ScopeDoesNotExistException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        ScopeDoesNotExistException scopeDoesNotExistException = (ScopeDoesNotExistException) super.unmarshall(jsonErrorResponse);
        scopeDoesNotExistException.setErrorCode("ScopeDoesNotExistException");
        return scopeDoesNotExistException;
    }
}
