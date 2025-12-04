package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.CreateResourceServerResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class CreateResourceServerResultJsonUnmarshaller implements Unmarshaller<CreateResourceServerResult, JsonUnmarshallerContext> {
    private static CreateResourceServerResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public CreateResourceServerResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        CreateResourceServerResult createResourceServerResult = new CreateResourceServerResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("ResourceServer")) {
                createResourceServerResult.setResourceServer(ResourceServerTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return createResourceServerResult;
    }

    public static CreateResourceServerResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateResourceServerResultJsonUnmarshaller();
        }
        return instance;
    }
}
