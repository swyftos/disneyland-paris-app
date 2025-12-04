package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ListUsersResult;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.ListUnmarshaller;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;

/* loaded from: classes2.dex */
public class ListUsersResultJsonUnmarshaller implements Unmarshaller<ListUsersResult, JsonUnmarshallerContext> {
    private static ListUsersResultJsonUnmarshaller instance;

    @Override // com.amazonaws.transform.Unmarshaller
    public ListUsersResult unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
        ListUsersResult listUsersResult = new ListUsersResult();
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("Users")) {
                listUsersResult.setUsers(new ListUnmarshaller(UserTypeJsonUnmarshaller.getInstance()).unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("PaginationToken")) {
                listUsersResult.setPaginationToken(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return listUsersResult;
    }

    public static ListUsersResultJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListUsersResultJsonUnmarshaller();
        }
        return instance;
    }
}
