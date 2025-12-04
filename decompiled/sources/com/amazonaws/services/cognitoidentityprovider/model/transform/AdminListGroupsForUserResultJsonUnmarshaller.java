package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class AdminListGroupsForUserResultJsonUnmarshaller implements Unmarshaller<AdminListGroupsForUserResult, JsonUnmarshallerContext> {
    private static AdminListGroupsForUserResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public AdminListGroupsForUserResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        AdminListGroupsForUserResult adminListGroupsForUserResult = new AdminListGroupsForUserResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("Groups")) {
                adminListGroupsForUserResult.setGroups(new ListUnmarshaller(GroupTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("NextToken")) {
                adminListGroupsForUserResult.setNextToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return adminListGroupsForUserResult;
    }

    public static AdminListGroupsForUserResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdminListGroupsForUserResultJsonUnmarshaller();
        }
        return instance;
    }
}
