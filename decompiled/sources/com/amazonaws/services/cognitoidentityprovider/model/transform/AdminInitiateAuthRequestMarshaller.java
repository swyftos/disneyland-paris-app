package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminInitiateAuthRequest;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.ContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class AdminInitiateAuthRequestMarshaller implements Marshaller<Request<AdminInitiateAuthRequest>, AdminInitiateAuthRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminInitiateAuthRequest> marshall(AdminInitiateAuthRequest adminInitiateAuthRequest) {
        if (adminInitiateAuthRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminInitiateAuthRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminInitiateAuthRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminInitiateAuth");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminInitiateAuthRequest.getUserPoolId() != null) {
                String userPoolId = adminInitiateAuthRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminInitiateAuthRequest.getClientId() != null) {
                String clientId = adminInitiateAuthRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (adminInitiateAuthRequest.getAuthFlow() != null) {
                String authFlow = adminInitiateAuthRequest.getAuthFlow();
                jsonWriter.name("AuthFlow");
                jsonWriter.value(authFlow);
            }
            if (adminInitiateAuthRequest.getAuthParameters() != null) {
                Map<String, String> authParameters = adminInitiateAuthRequest.getAuthParameters();
                jsonWriter.name("AuthParameters");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : authParameters.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
            }
            if (adminInitiateAuthRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = adminInitiateAuthRequest.getClientMetadata();
                jsonWriter.name("ClientMetadata");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry2 : clientMetadata.entrySet()) {
                    String value2 = entry2.getValue();
                    if (value2 != null) {
                        jsonWriter.name(entry2.getKey());
                        jsonWriter.value(value2);
                    }
                }
                jsonWriter.endObject();
            }
            if (adminInitiateAuthRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = adminInitiateAuthRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (adminInitiateAuthRequest.getContextData() != null) {
                ContextDataType contextData = adminInitiateAuthRequest.getContextData();
                jsonWriter.name("ContextData");
                ContextDataTypeJsonMarshaller.getInstance().marshall(contextData, jsonWriter);
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
