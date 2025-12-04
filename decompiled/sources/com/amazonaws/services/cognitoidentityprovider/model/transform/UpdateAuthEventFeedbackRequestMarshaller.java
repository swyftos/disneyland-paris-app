package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateAuthEventFeedbackRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class UpdateAuthEventFeedbackRequestMarshaller implements Marshaller<Request<UpdateAuthEventFeedbackRequest>, UpdateAuthEventFeedbackRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<UpdateAuthEventFeedbackRequest> marshall(UpdateAuthEventFeedbackRequest updateAuthEventFeedbackRequest) {
        if (updateAuthEventFeedbackRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(UpdateAuthEventFeedbackRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(updateAuthEventFeedbackRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.UpdateAuthEventFeedback");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (updateAuthEventFeedbackRequest.getUserPoolId() != null) {
                String userPoolId = updateAuthEventFeedbackRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (updateAuthEventFeedbackRequest.getUsername() != null) {
                String username = updateAuthEventFeedbackRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (updateAuthEventFeedbackRequest.getEventId() != null) {
                String eventId = updateAuthEventFeedbackRequest.getEventId();
                jsonWriter.name("EventId");
                jsonWriter.value(eventId);
            }
            if (updateAuthEventFeedbackRequest.getFeedbackToken() != null) {
                String feedbackToken = updateAuthEventFeedbackRequest.getFeedbackToken();
                jsonWriter.name("FeedbackToken");
                jsonWriter.value(feedbackToken);
            }
            if (updateAuthEventFeedbackRequest.getFeedbackValue() != null) {
                String feedbackValue = updateAuthEventFeedbackRequest.getFeedbackValue();
                jsonWriter.name("FeedbackValue");
                jsonWriter.value(feedbackValue);
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
