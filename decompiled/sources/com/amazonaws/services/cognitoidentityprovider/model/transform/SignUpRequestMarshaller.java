package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.SignUpRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SignUpRequestMarshaller implements Marshaller<Request<SignUpRequest>, SignUpRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<SignUpRequest> marshall(SignUpRequest signUpRequest) {
        if (signUpRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(SignUpRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(signUpRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.SignUp");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (signUpRequest.getClientId() != null) {
                String clientId = signUpRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (signUpRequest.getSecretHash() != null) {
                String secretHash = signUpRequest.getSecretHash();
                jsonWriter.name("SecretHash");
                jsonWriter.value(secretHash);
            }
            if (signUpRequest.getUsername() != null) {
                String username = signUpRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (signUpRequest.getPassword() != null) {
                String password = signUpRequest.getPassword();
                jsonWriter.name("Password");
                jsonWriter.value(password);
            }
            if (signUpRequest.getUserAttributes() != null) {
                List<AttributeType> userAttributes = signUpRequest.getUserAttributes();
                jsonWriter.name("UserAttributes");
                jsonWriter.beginArray();
                for (AttributeType attributeType : userAttributes) {
                    if (attributeType != null) {
                        AttributeTypeJsonMarshaller.getInstance().marshall(attributeType, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (signUpRequest.getValidationData() != null) {
                List<AttributeType> validationData = signUpRequest.getValidationData();
                jsonWriter.name("ValidationData");
                jsonWriter.beginArray();
                for (AttributeType attributeType2 : validationData) {
                    if (attributeType2 != null) {
                        AttributeTypeJsonMarshaller.getInstance().marshall(attributeType2, jsonWriter);
                    }
                }
                jsonWriter.endArray();
            }
            if (signUpRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = signUpRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (signUpRequest.getUserContextData() != null) {
                UserContextDataType userContextData = signUpRequest.getUserContextData();
                jsonWriter.name("UserContextData");
                UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
            }
            if (signUpRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = signUpRequest.getClientMetadata();
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
