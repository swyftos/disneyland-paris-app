package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class UpdateUserPoolDomainResultJsonUnmarshaller implements Unmarshaller<UpdateUserPoolDomainResult, JsonUnmarshallerContext> {
    private static UpdateUserPoolDomainResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateUserPoolDomainResult updateUserPoolDomainResult = new UpdateUserPoolDomainResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CloudFrontDomain")) {
                updateUserPoolDomainResult.setCloudFrontDomain(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateUserPoolDomainResult;
    }

    public static UpdateUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }
}
