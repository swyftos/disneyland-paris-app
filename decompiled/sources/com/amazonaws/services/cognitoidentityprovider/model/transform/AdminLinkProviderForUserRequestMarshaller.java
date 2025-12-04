package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminLinkProviderForUserRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ProviderUserIdentifierType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminLinkProviderForUserRequestMarshaller implements Marshaller<Request<AdminLinkProviderForUserRequest>, AdminLinkProviderForUserRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminLinkProviderForUserRequest> marshall(AdminLinkProviderForUserRequest adminLinkProviderForUserRequest) {
        if (adminLinkProviderForUserRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminLinkProviderForUserRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminLinkProviderForUserRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminLinkProviderForUser");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminLinkProviderForUserRequest.getUserPoolId() != null) {
                String userPoolId = adminLinkProviderForUserRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminLinkProviderForUserRequest.getDestinationUser() != null) {
                ProviderUserIdentifierType destinationUser = adminLinkProviderForUserRequest.getDestinationUser();
                jsonWriter.name("DestinationUser");
                ProviderUserIdentifierTypeJsonMarshaller.getInstance().marshall(destinationUser, jsonWriter);
            }
            if (adminLinkProviderForUserRequest.getSourceUser() != null) {
                ProviderUserIdentifierType sourceUser = adminLinkProviderForUserRequest.getSourceUser();
                jsonWriter.name("SourceUser");
                ProviderUserIdentifierTypeJsonMarshaller.getInstance().marshall(sourceUser, jsonWriter);
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
