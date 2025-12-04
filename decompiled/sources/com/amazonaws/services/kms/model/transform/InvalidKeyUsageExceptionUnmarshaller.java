package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.kms.model.InvalidKeyUsageException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class InvalidKeyUsageExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidKeyUsageExceptionUnmarshaller() {
        super(InvalidKeyUsageException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidKeyUsageException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidKeyUsageException invalidKeyUsageException = (InvalidKeyUsageException) super.unmarshall(jsonErrorResponse);
        invalidKeyUsageException.setErrorCode("InvalidKeyUsageException");
        return invalidKeyUsageException;
    }
}
