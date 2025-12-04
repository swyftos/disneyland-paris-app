package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.DescribeRiskConfigurationResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class DescribeRiskConfigurationResultJsonUnmarshaller implements Unmarshaller<DescribeRiskConfigurationResult, JsonUnmarshallerContext> {
    private static DescribeRiskConfigurationResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public DescribeRiskConfigurationResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        DescribeRiskConfigurationResult describeRiskConfigurationResult = new DescribeRiskConfigurationResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("RiskConfiguration")) {
                describeRiskConfigurationResult.setRiskConfiguration(RiskConfigurationTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return describeRiskConfigurationResult;
    }

    public static DescribeRiskConfigurationResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeRiskConfigurationResultJsonUnmarshaller();
        }
        return instance;
    }
}
