package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/* loaded from: classes2.dex */
public class GlobalSignOutResultJsonUnmarshaller implements Unmarshaller<GlobalSignOutResult, JsonUnmarshallerContext> {
    private static GlobalSignOutResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public GlobalSignOutResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        return new GlobalSignOutResult();
    }

    public static GlobalSignOutResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GlobalSignOutResultJsonUnmarshaller();
        }
        return instance;
    }
}
