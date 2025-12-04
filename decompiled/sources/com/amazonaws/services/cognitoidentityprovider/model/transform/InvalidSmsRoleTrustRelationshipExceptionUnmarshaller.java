package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.InvalidSmsRoleTrustRelationshipException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class InvalidSmsRoleTrustRelationshipExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public InvalidSmsRoleTrustRelationshipExceptionUnmarshaller() {
        super(InvalidSmsRoleTrustRelationshipException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("InvalidSmsRoleTrustRelationshipException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        InvalidSmsRoleTrustRelationshipException invalidSmsRoleTrustRelationshipException = (InvalidSmsRoleTrustRelationshipException) super.unmarshall(jsonErrorResponse);
        invalidSmsRoleTrustRelationshipException.setErrorCode("InvalidSmsRoleTrustRelationshipException");
        return invalidSmsRoleTrustRelationshipException;
    }
}
