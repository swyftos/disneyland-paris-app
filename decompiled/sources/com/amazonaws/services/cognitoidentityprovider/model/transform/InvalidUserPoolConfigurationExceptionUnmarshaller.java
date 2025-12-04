package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidUserPoolConfigurationException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class InvalidUserPoolConfigurationExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidUserPoolConfigurationExceptionUnmarshaller() {
        super(InvalidUserPoolConfigurationException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidUserPoolConfigurationException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidUserPoolConfigurationException invalidUserPoolConfigurationException = (InvalidUserPoolConfigurationException) super.unmarshall(jsonErrorResponse);
        invalidUserPoolConfigurationException.setErrorCode("InvalidUserPoolConfigurationException");
        return invalidUserPoolConfigurationException;
    }
}
