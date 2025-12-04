package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class DescribeUserPoolDomainResultJsonUnmarshaller implements Unmarshaller<DescribeUserPoolDomainResult, JsonUnmarshallerContext> {
    private static DescribeUserPoolDomainResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public DescribeUserPoolDomainResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeUserPoolDomainResult describeUserPoolDomainResult = new DescribeUserPoolDomainResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("DomainDescription")) {
                describeUserPoolDomainResult.setDomainDescription(DomainDescriptionTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeUserPoolDomainResult;
    }

    public static DescribeUserPoolDomainResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeUserPoolDomainResultJsonUnmarshaller();
        }
        return instance;
    }
}
