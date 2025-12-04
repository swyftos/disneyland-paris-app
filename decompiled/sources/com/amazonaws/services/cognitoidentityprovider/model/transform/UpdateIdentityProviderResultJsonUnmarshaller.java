package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.UpdateIdentityProviderResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class UpdateIdentityProviderResultJsonUnmarshaller implements Unmarshaller<UpdateIdentityProviderResult, JsonUnmarshallerContext> {
    private static UpdateIdentityProviderResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public UpdateIdentityProviderResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        UpdateIdentityProviderResult updateIdentityProviderResult = new UpdateIdentityProviderResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            if (reader.nextName().equals("IdentityProvider")) {
                updateIdentityProviderResult.setIdentityProvider(IdentityProviderTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return updateIdentityProviderResult;
    }

    public static UpdateIdentityProviderResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UpdateIdentityProviderResultJsonUnmarshaller();
        }
        return instance;
    }
}
