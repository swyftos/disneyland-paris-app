package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminDisableProviderForUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ProviderUserIdentifierType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminDisableProviderForUserRequestMarshaller implements Marshaller<Request<AdminDisableProviderForUserRequest>, AdminDisableProviderForUserRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminDisableProviderForUserRequest> marshall(AdminDisableProviderForUserRequest adminDisableProviderForUserRequest) {
        if (adminDisableProviderForUserRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminDisableProviderForUserRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminDisableProviderForUserRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminDisableProviderForUser");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminDisableProviderForUserRequest.getUserPoolId() != null) {
                String userPoolId = adminDisableProviderForUserRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminDisableProviderForUserRequest.getUser() != null) {
                ProviderUserIdentifierType user = adminDisableProviderForUserRequest.getUser();
                jsonWriter.name("User");
                ProviderUserIdentifierTypeJsonMarshaller.getInstance().marshall(user, jsonWriter);
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
