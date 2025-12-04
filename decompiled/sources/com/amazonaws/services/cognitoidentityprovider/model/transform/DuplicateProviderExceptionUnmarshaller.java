package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.DuplicateProviderException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class DuplicateProviderExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public DuplicateProviderExceptionUnmarshaller() {
        super(DuplicateProviderException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("DuplicateProviderException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        DuplicateProviderException duplicateProviderException = (DuplicateProviderException) super.unmarshall(jsonErrorResponse);
        duplicateProviderException.setErrorCode("DuplicateProviderException");
        return duplicateProviderException;
    }
}
