package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.EnableSoftwareTokenMFAException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class EnableSoftwareTokenMFAExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public EnableSoftwareTokenMFAExceptionUnmarshaller() {
        super(EnableSoftwareTokenMFAException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("EnableSoftwareTokenMFAException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        EnableSoftwareTokenMFAException enableSoftwareTokenMFAException = (EnableSoftwareTokenMFAException) super.unmarshall(jsonErrorResponse);
        enableSoftwareTokenMFAException.setErrorCode("EnableSoftwareTokenMFAException");
        return enableSoftwareTokenMFAException;
    }
}
