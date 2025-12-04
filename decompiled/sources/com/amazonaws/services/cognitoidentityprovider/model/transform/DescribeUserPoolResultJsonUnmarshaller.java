package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class DescribeUserPoolResultJsonUnmarshaller implements Unmarshaller<DescribeUserPoolResult, JsonUnmarshallerContext> {
    private static DescribeUserPoolResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public DescribeUserPoolResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeUserPoolResult describeUserPoolResult = new DescribeUserPoolResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("UserPool")) {
                describeUserPoolResult.setUserPool(UserPoolTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeUserPoolResult;
    }

    public static DescribeUserPoolResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeUserPoolResultJsonUnmarshaller();
        }
        return instance;
    }
}
