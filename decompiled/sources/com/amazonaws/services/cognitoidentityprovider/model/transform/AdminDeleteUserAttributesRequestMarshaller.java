package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminDeleteUserAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class AdminDeleteUserAttributesRequestMarshaller implements Marshaller<Request<AdminDeleteUserAttributesRequest>, AdminDeleteUserAttributesRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminDeleteUserAttributesRequest> marshall(AdminDeleteUserAttributesRequest adminDeleteUserAttributesRequest) {
        if (adminDeleteUserAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminDeleteUserAttributesRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminDeleteUserAttributesRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminDeleteUserAttributes");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminDeleteUserAttributesRequest.getUserPoolId() != null) {
                String userPoolId = adminDeleteUserAttributesRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminDeleteUserAttributesRequest.getUsername() != null) {
                String username = adminDeleteUserAttributesRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminDeleteUserAttributesRequest.getUserAttributeNames() != null) {
                List<String> userAttributeNames = adminDeleteUserAttributesRequest.getUserAttributeNames();
                jsonWriter.name("UserAttributeNames");
                jsonWriter.beginArray();
                for (String str : userAttributeNames) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
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
