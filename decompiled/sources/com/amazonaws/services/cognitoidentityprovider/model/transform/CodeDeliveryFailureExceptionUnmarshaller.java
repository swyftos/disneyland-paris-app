package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.CodeDeliveryFailureException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class CodeDeliveryFailureExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public CodeDeliveryFailureExceptionUnmarshaller() {
        super(CodeDeliveryFailureException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("CodeDeliveryFailureException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        CodeDeliveryFailureException codeDeliveryFailureException = (CodeDeliveryFailureException) super.unmarshall(jsonErrorResponse);
        codeDeliveryFailureException.setErrorCode("CodeDeliveryFailureException");
        return codeDeliveryFailureException;
    }
}
