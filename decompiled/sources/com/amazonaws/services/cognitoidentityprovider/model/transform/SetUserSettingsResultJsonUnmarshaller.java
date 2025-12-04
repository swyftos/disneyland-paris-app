package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.SetUserSettingsResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class SetUserSettingsResultJsonUnmarshaller implements Unmarshaller<SetUserSettingsResult, JsonUnmarshallerContext> {
    private static SetUserSettingsResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public SetUserSettingsResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new SetUserSettingsResult();
    }

    public static SetUserSettingsResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetUserSettingsResultJsonUnmarshaller();
        }
        return instance;
    }
}
