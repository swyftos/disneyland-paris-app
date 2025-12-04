package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.UnsupportedUserStateException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class UnsupportedUserStateExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public UnsupportedUserStateExceptionUnmarshaller() {
        super(UnsupportedUserStateException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("UnsupportedUserStateException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        UnsupportedUserStateException unsupportedUserStateException = (UnsupportedUserStateException) super.unmarshall(jsonErrorResponse);
        unsupportedUserStateException.setErrorCode("UnsupportedUserStateException");
        return unsupportedUserStateException;
    }
}
