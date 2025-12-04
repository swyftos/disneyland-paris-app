package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.DeleteUserAttributesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class DeleteUserAttributesRequestMarshaller implements Marshaller<Request<DeleteUserAttributesRequest>, DeleteUserAttributesRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DeleteUserAttributesRequest> marshall(DeleteUserAttributesRequest deleteUserAttributesRequest) {
        if (deleteUserAttributesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DeleteUserAttributesRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(deleteUserAttributesRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.DeleteUserAttributes");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (deleteUserAttributesRequest.getUserAttributeNames() != null) {
                List<String> userAttributeNames = deleteUserAttributesRequest.getUserAttributeNames();
                jsonWriter.name("UserAttributeNames");
                jsonWriter.beginArray();
                for (String str : userAttributeNames) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (deleteUserAttributesRequest.getAccessToken() != null) {
                String accessToken = deleteUserAttributesRequest.getAccessToken();
                jsonWriter.name("AccessToken");
                jsonWriter.value(accessToken);
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
