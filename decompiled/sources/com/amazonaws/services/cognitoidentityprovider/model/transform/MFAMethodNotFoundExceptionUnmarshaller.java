package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.services.cognitoidentityprovider.model.MFAMethodNotFoundException;
import com.amazonaws.transform.JsonErrorUnmarshaller;

/* loaded from: classes2.dex */
public class MFAMethodNotFoundExceptionUnmarshaller extends JsonErrorUnmarshaller {
    public MFAMethodNotFoundExceptionUnmarshaller() {
        super(MFAMethodNotFoundException.class);
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller
    public boolean match(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        return jsonErrorResponse.getErrorCode().equals("MFAMethodNotFoundException");
    }

    @Override // com.amazonaws.transform.JsonErrorUnmarshaller, com.amazonaws.transform.Unmarshaller
    public AmazonServiceException unmarshall(JsonErrorResponseHandler.JsonErrorResponse jsonErrorResponse) throws Exception {
        MFAMethodNotFoundException mFAMethodNotFoundException = (MFAMethodNotFoundException) super.unmarshall(jsonErrorResponse);
        mFAMethodNotFoundException.setErrorCode("MFAMethodNotFoundException");
        return mFAMethodNotFoundException;
    }
}
