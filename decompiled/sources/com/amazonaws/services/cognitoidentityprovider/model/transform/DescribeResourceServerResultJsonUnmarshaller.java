package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class DescribeResourceServerResultJsonUnmarshaller implements Unmarshaller<DescribeResourceServerResult, JsonUnmarshallerContext> {
    private static DescribeResourceServerResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public DescribeResourceServerResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeResourceServerResult describeResourceServerResult = new DescribeResourceServerResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("ResourceServer")) {
                describeResourceServerResult.setResourceServer(ResourceServerTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeResourceServerResult;
    }

    public static DescribeResourceServerResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeResourceServerResultJsonUnmarshaller();
        }
        return instance;
    }
}
