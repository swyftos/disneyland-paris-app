package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.PreconditionNotMetException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class PreconditionNotMetExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public PreconditionNotMetExceptionUnmarshaller() {
        super(PreconditionNotMetException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("PreconditionNotMetException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        PreconditionNotMetException preconditionNotMetException = (PreconditionNotMetException) super.unmarshall(jsonErrorResponse);
        preconditionNotMetException.setErrorCode("PreconditionNotMetException");
        return preconditionNotMetException;
    }
}
