package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class CreateUserPoolDomainResultJsonUnmarshaller implements Unmarshaller<CreateUserPoolDomainResult, JsonUnmarshallerContext> {
    private static CreateUserPoolDomainResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public CreateUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateUserPoolDomainResult createUserPoolDomainResult = new CreateUserPoolDomainResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("CloudFrontDomain")) {
                createUserPoolDomainResult.setCloudFrontDomain(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createUserPoolDomainResult;
    }

    public static CreateUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }
}
