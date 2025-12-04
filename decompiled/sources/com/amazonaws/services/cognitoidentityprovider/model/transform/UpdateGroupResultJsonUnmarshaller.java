package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateGroupResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class UpdateGroupResultJsonUnmarshaller implements Unmarshaller<UpdateGroupResult, JsonUnmarshallerContext> {
    private static UpdateGroupResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateGroupResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateGroupResult updateGroupResult = new UpdateGroupResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("Group")) {
                updateGroupResult.setGroup(GroupTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateGroupResult;
    }

    public static UpdateGroupResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateGroupResultJsonUnmarshaller();
        }
        return instance;
    }
}
