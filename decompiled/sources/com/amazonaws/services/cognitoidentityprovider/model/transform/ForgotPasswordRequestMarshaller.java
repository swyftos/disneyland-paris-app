package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class ForgotPasswordRequestMarshaller implements Marshaller<Request<ForgotPasswordRequest>, ForgotPasswordRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ForgotPasswordRequest> marshall(ForgotPasswordRequest forgotPasswordRequest) {
        if (forgotPasswordRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ForgotPasswordRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(forgotPasswordRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ForgotPassword");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (forgotPasswordRequest.getClientId() != null) {
                String clientId = forgotPasswordRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (forgotPasswordRequest.getSecretHash() != null) {
                String secretHash = forgotPasswordRequest.getSecretHash();
                jsonWriter.name("SecretHash");
                jsonWriter.value(secretHash);
            }
            if (forgotPasswordRequest.getUserContextData() != null) {
                UserContextDataType userContextData = forgotPasswordRequest.getUserContextData();
                jsonWriter.name("UserContextData");
                UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
            }
            if (forgotPasswordRequest.getUsername() != null) {
                String username = forgotPasswordRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (forgotPasswordRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = forgotPasswordRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (forgotPasswordRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = forgotPasswordRequest.getClientMetadata();
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
