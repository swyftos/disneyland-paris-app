package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AnalyticsMetadataType;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UserContextDataType;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class RespondToAuthChallengeRequestMarshaller implements Marshaller<Request<RespondToAuthChallengeRequest>, RespondToAuthChallengeRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<RespondToAuthChallengeRequest> marshall(RespondToAuthChallengeRequest respondToAuthChallengeRequest) {
        if (respondToAuthChallengeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(RespondToAuthChallengeRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(respondToAuthChallengeRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.RespondToAuthChallenge");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (respondToAuthChallengeRequest.getClientId() != null) {
                String clientId = respondToAuthChallengeRequest.getClientId();
                jsonWriter.name("ClientId");
                jsonWriter.value(clientId);
            }
            if (respondToAuthChallengeRequest.getChallengeName() != null) {
                String challengeName = respondToAuthChallengeRequest.getChallengeName();
                jsonWriter.name("ChallengeName");
                jsonWriter.value(challengeName);
            }
            if (respondToAuthChallengeRequest.getSession() != null) {
                String session = respondToAuthChallengeRequest.getSession();
                jsonWriter.name("Session");
                jsonWriter.value(session);
            }
            if (respondToAuthChallengeRequest.getChallengeResponses() != null) {
                Map<String, String> challengeResponses = respondToAuthChallengeRequest.getChallengeResponses();
                jsonWriter.name("ChallengeResponses");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : challengeResponses.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
            }
            if (respondToAuthChallengeRequest.getAnalyticsMetadata() != null) {
                AnalyticsMetadataType analyticsMetadata = respondToAuthChallengeRequest.getAnalyticsMetadata();
                jsonWriter.name("AnalyticsMetadata");
                AnalyticsMetadataTypeJsonMarshaller.getInstance().marshall(analyticsMetadata, jsonWriter);
            }
            if (respondToAuthChallengeRequest.getUserContextData() != null) {
                UserContextDataType userContextData = respondToAuthChallengeRequest.getUserContextData();
                jsonWriter.name("UserContextData");
                UserContextDataTypeJsonMarshaller.getInstance().marshall(userContextData, jsonWriter);
            }
            if (respondToAuthChallengeRequest.getClientMetadata() != null) {
                Map<String, String> clientMetadata = respondToAuthChallengeRequest.getClientMetadata();
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
