package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetCSVHeaderResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class GetCSVHeaderResultJsonUnmarshaller implements Unmarshaller<GetCSVHeaderResult, JsonUnmarshallerContext> {
    private static GetCSVHeaderResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public GetCSVHeaderResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetCSVHeaderResult getCSVHeaderResult = new GetCSVHeaderResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("UserPoolId")) {
                getCSVHeaderResult.setUserPoolId(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("CSVHeader")) {
                getCSVHeaderResult.setCSVHeader(new ListUnmarshaller(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getCSVHeaderResult;
    }

    public static GetCSVHeaderResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetCSVHeaderResultJsonUnmarshaller();
        }
        return instance;
    }
}
