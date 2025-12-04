package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnsupportedIdentityProviderException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UnsupportedIdentityProviderExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedIdentityProviderExceptionUnmarshaller() {
        super(UnsupportedIdentityProviderException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnsupportedIdentityProviderException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnsupportedIdentityProviderException unsupportedIdentityProviderException = (UnsupportedIdentityProviderException) super.unmarshall(jsonErrorResponse);
        unsupportedIdentityProviderException.setErrorCode("UnsupportedIdentityProviderException");
        return unsupportedIdentityProviderException;
    }
}
