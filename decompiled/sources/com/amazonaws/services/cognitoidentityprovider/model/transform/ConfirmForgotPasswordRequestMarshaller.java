package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmForgotPasswordRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConfirmForgotPasswordRequestMarshaller implements Marshaller<Request<ConfirmForgotPasswordRequest>, ConfirmForgotPasswordRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ConfirmForgotPasswordRequest> marshall(ConfirmForgotPasswordRequest confirmForgotPasswordRequest) {
        if (confirmForgotPasswordRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ConfirmForgotPasswordRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(confirmForgotPasswordRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ConfirmForgotPassword");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (confirmForgotPasswordRequest.getClientId() != null) {
                String clientId = confirmForgotPasswordRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (confirmForgotPasswordRequest.getSecretHash() != null) {
                String secretHash = confirmForgotPasswordRequest.getSecretHash();
                jsonWriter.name("SecretHash");
                jsonWriter.value(secretHash);
            }
            if (confirmForgotPasswordRequest.getUsername() != null) {
                String username = confirmForgotPasswordRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (confirmForgotPasswordRequest.getConfirmationCode() != null) {
                String confirmationCode = confirmForgotPasswordRequest.getConfirmationCode();
                jsonWriter.name("ConfirmationCode");
                jsonWriter.value(confirmationCode);
            }
            if (confirmForgotPasswordRequest.getPassword() != null) {
                String password = confirmForgotPasswordRequest.getPassword();
                jsonWriter.name("Password");
                jsonWriter.value(password);
            }
            if (confirmForgotPasswordRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = confirmForgotPasswordRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (confirmForgotPasswordRequest.getUserContextData() != null) {
                UserContextDataType userContextData = confirmForgotPasswordRequest.getUserContextData();
                jsonWriter.name("UserContextData");
                UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
            }
            if (confirmForgotPasswordRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = confirmForgotPasswordRequest.getClientMetadata();
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
