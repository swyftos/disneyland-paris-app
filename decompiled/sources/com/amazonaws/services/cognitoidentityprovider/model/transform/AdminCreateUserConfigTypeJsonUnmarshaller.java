package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserConfigType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class AdminCreateUserConfigTypeJsonUnmarshaller implements Unmarshaller<AdminCreateUserConfigType, JsonUnmarshallerContext> {
    private static AdminCreateUserConfigTypeJsonUnmarshaller instance;

    AdminCreateUserConfigTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminCreateUserConfigType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        AdminCreateUserConfigType adminCreateUserConfigType = new AdminCreateUserConfigType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("AllowAdminCreateUserOnly")) {
                adminCreateUserConfigType.setAllowAdminCreateUserOnly(SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("UnusedAccountValidityDays")) {
                adminCreateUserConfigType.setUnusedAccountValidityDays(SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("InviteMessageTemplate")) {
                adminCreateUserConfigType.setInviteMessageTemplate(MessageTemplateTypeJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminCreateUserConfigType;
    }

    public static AdminCreateUserConfigTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminCreateUserConfigTypeJsonUnmarshaller();
        }
        return instance;
    }
}
