package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminRemoveUserFromGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminRemoveUserFromGroupRequestMarshaller implements Marshaller<Request<AdminRemoveUserFromGroupRequest>, AdminRemoveUserFromGroupRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminRemoveUserFromGroupRequest> marshall(AdminRemoveUserFromGroupRequest adminRemoveUserFromGroupRequest) {
        if (adminRemoveUserFromGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminRemoveUserFromGroupRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminRemoveUserFromGroupRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminRemoveUserFromGroup");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminRemoveUserFromGroupRequest.getUserPoolId() != null) {
                String userPoolId = adminRemoveUserFromGroupRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminRemoveUserFromGroupRequest.getUsername() != null) {
                String username = adminRemoveUserFromGroupRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminRemoveUserFromGroupRequest.getGroupName() != null) {
                String groupName = adminRemoveUserFromGroupRequest.getGroupName();
                jsonWriter.name("GroupName");
                jsonWriter.value(groupName);
            }
            jsonWriter.endObject();
            jsonWriter.close();
            String string = stringWriter.toString();
            byte[] bytes = string.getBytes(StringUtils.UTF8);
            defaultRequest.setContent(new StringInputStream(string));
            defaultRequest.addHeader("Content-Length", Integer.toString(bytes.length));
            if (!defaultRequest.getHeaders().containsKey("Content-Type")) {
                defaultRequest.addHeader("Content-Type", "application/x-amz-json-1.1");
            }
            return defaultRequest;
        } catch (Throwable th) {
            throw new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
