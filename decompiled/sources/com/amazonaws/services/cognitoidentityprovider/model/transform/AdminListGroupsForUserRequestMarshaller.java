package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminListGroupsForUserRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminListGroupsForUserRequestMarshaller implements Marshaller<Request<AdminListGroupsForUserRequest>, AdminListGroupsForUserRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminListGroupsForUserRequest> marshall(AdminListGroupsForUserRequest adminListGroupsForUserRequest) {
        if (adminListGroupsForUserRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminListGroupsForUserRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminListGroupsForUserRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminListGroupsForUser");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminListGroupsForUserRequest.getUsername() != null) {
                String username = adminListGroupsForUserRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminListGroupsForUserRequest.getUserPoolId() != null) {
                String userPoolId = adminListGroupsForUserRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminListGroupsForUserRequest.getLimit() != null) {
                Integer limit = adminListGroupsForUserRequest.getLimit();
                jsonWriter.name("Limit");
                jsonWriter.value(limit);
            }
            if (adminListGroupsForUserRequest.getNextToken() != null) {
                String nextToken = adminListGroupsForUserRequest.getNextToken();
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
