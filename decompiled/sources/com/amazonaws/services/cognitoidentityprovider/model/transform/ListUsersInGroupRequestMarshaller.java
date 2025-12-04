package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.ListUsersInGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class ListUsersInGroupRequestMarshaller implements Marshaller<Request<ListUsersInGroupRequest>, ListUsersInGroupRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ListUsersInGroupRequest> marshall(ListUsersInGroupRequest listUsersInGroupRequest) {
        if (listUsersInGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ListUsersInGroupRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(listUsersInGroupRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ListUsersInGroup");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (listUsersInGroupRequest.getUserPoolId() != null) {
                String userPoolId = listUsersInGroupRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (listUsersInGroupRequest.getGroupName() != null) {
                String groupName = listUsersInGroupRequest.getGroupName();
                jsonWriter.name("GroupName");
                jsonWriter.value(groupName);
            }
            if (listUsersInGroupRequest.getLimit() != null) {
                Integer limit = listUsersInGroupRequest.getLimit();
                jsonWriter.name("Limit");
                jsonWriter.value(limit);
            }
            if (listUsersInGroupRequest.getNextToken() != null) {
                String nextToken = listUsersInGroupRequest.getNextToken();
                jsonWriter.name("NextToken");
                jsonWriter.value(nextToken);
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
