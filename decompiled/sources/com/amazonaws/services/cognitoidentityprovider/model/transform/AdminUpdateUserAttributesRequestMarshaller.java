package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminUpdateUserAttributesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdminUpdateUserAttributesRequestMarshaller implements Marshaller<Request<AdminUpdateUserAttributesRequest>, AdminUpdateUserAttributesRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminUpdateUserAttributesRequest> marshall(AdminUpdateUserAttributesRequest adminUpdateUserAttributesRequest) {
        if (adminUpdateUserAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminUpdateUserAttributesRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminUpdateUserAttributesRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminUpdateUserAttributes");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminUpdateUserAttributesRequest.getUserPoolId() != null) {
                String userPoolId = adminUpdateUserAttributesRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminUpdateUserAttributesRequest.getUsername() != null) {
                String username = adminUpdateUserAttributesRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminUpdateUserAttributesRequest.getUserAttributes() != null) {
                List<AttributeType> userAttributes = adminUpdateUserAttributesRequest.getUserAttributes();
                jsonWriter.name("UserAttributes");
                jsonWriter.beginArray();
                for (AttributeType attributeType : userAttributes) {
                    if (attributeType != null) {
                        AttributeTypeJsonMarshaller.getInstance().marshall(attributeType, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (adminUpdateUserAttributesRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = adminUpdateUserAttributesRequest.getClientMetadata();
                jsonWriter.name("ClientMetadata");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : clientMetadata.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
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
