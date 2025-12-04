package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminCreateUserConfigType;
import com.amazonaws.services.cognitoidentityprovider.model.MessageTemplateType;
import com.amazonaws.util.json.AwsJsonWriter;
import java.io.IOException;

/* loaded from: classes2.dex */
class AdminCreateUserConfigTypeJsonMarshaller {
    private static AdminCreateUserConfigTypeJsonMarshaller instance;

    AdminCreateUserConfigTypeJsonMarshaller() {
    }

    public void marshall(AdminCreateUserConfigType adminCreateUserConfigType, AwsJsonWriter awsJsonWriter) throws IOException {
        awsJsonWriter.beginObject();
        if (adminCreateUserConfigType.getAllowAdminCreateUserOnly() != null) {
            Boolean allowAdminCreateUserOnly = adminCreateUserConfigType.getAllowAdminCreateUserOnly();
            awsJsonWriter.name("AllowAdminCreateUserOnly");
            awsJsonWriter.value(allowAdminCreateUserOnly.booleanValue());
        }
        if (adminCreateUserConfigType.getUnusedAccountValidityDays() != null) {
            Integer unusedAccountValidityDays = adminCreateUserConfigType.getUnusedAccountValidityDays();
            awsJsonWriter.name("UnusedAccountValidityDays");
            awsJsonWriter.value(unusedAccountValidityDays);
        }
        if (adminCreateUserConfigType.getInviteMessageTemplate() != null) {
            MessageTemplateType inviteMessageTemplate = adminCreateUserConfigType.getInviteMessageTemplate();
            awsJsonWriter.name("InviteMessageTemplate");
            MessageTemplateTypeJsonMarshaller.getInstance().marshall(inviteMessageTemplate, awsJsonWriter);
        }
        awsJsonWriter.endObject();
    }

    public static AdminCreateUserConfigTypeJsonMarshaller getInstance() {
        if (instance == null) {
            instance = new AdminCreateUserConfigTypeJsonMarshaller();
        }
        return instance;
    }
}
