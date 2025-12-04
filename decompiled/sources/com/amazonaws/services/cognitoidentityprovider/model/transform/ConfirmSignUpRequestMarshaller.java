package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConfirmSignUpRequestMarshaller implements Marshaller<Request<ConfirmSignUpRequest>, ConfirmSignUpRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ConfirmSignUpRequest> marshall(ConfirmSignUpRequest confirmSignUpRequest) {
        if (confirmSignUpRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ConfirmSignUpRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(confirmSignUpRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.ConfirmSignUp");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (confirmSignUpRequest.getClientId() != null) {
                String clientId = confirmSignUpRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (confirmSignUpRequest.getSecretHash() != null) {
                String secretHash = confirmSignUpRequest.getSecretHash();
                jsonWriter.name("SecretHash");
                jsonWriter.value(secretHash);
            }
            if (confirmSignUpRequest.getUsername() != null) {
                String username = confirmSignUpRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (confirmSignUpRequest.getConfirmationCode() != null) {
                String confirmationCode = confirmSignUpRequest.getConfirmationCode();
                jsonWriter.name("ConfirmationCode");
                jsonWriter.value(confirmationCode);
            }
            if (confirmSignUpRequest.getForceAliasCreation() != null) {
                Boolean forceAliasCreation = confirmSignUpRequest.getForceAliasCreation();
                jsonWriter.name("ForceAliasCreation");
                jsonWriter.value(forceAliasCreation.booleanValue());
            }
            if (confirmSignUpRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = confirmSignUpRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (confirmSignUpRequest.getUserContextData() != null) {
                UserContextDataType userContextData = confirmSignUpRequest.getUserContextData();
                jsonWriter.name("UserContextData");
                UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
            }
            if (confirmSignUpRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = confirmSignUpRequest.getClientMetadata();
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
