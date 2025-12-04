package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.InitiateAuthRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class InitiateAuthRequestMarshaller implements Marshaller<Request<InitiateAuthRequest>, InitiateAuthRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<InitiateAuthRequest> marshall(InitiateAuthRequest initiateAuthRequest) {
        if (initiateAuthRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(InitiateAuthRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(initiateAuthRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.InitiateAuth");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (initiateAuthRequest.getAuthFlow() != null) {
                String authFlow = initiateAuthRequest.getAuthFlow();
                jsonWriter.name("AuthFlow");
                jsonWriter.value(authFlow);
            }
            if (initiateAuthRequest.getAuthParameters() != null) {
                Map<String, String> authParameters = initiateAuthRequest.getAuthParameters();
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
            if (initiateAuthRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = initiateAuthRequest.getClientMetadata();
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
            if (initiateAuthRequest.getClientId() != null) {
                String clientId = initiateAuthRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (initiateAuthRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = initiateAuthRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (initiateAuthRequest.getUserContextData() != null) {
                UserContextDataType userContextData = initiateAuthRequest.getUserContextData();
                jsonWriter.name("UserContextData");
                UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
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
