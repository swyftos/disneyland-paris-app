package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GetGroupResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class GetGroupResultJsonUnmarshaller implements Unmarshaller<GetGroupResult, JsonUnmarshallerContext> {
    private static GetGroupResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public GetGroupResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        GetGroupResult getGroupResult = new GetGroupResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Group")) {
                getGroupResult.setGroup(GroupTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return getGroupResult;
    }

    public static GetGroupResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetGroupResultJsonUnmarshaller();
        }
        return instance;
    }
}
