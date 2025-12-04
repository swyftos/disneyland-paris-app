package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.AdminListUserAuthEventsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class AdminListUserAuthEventsRequestMarshaller implements Marshaller<Request<AdminListUserAuthEventsRequest>, AdminListUserAuthEventsRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<AdminListUserAuthEventsRequest> marshall(AdminListUserAuthEventsRequest adminListUserAuthEventsRequest) {
        if (adminListUserAuthEventsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(AdminListUserAuthEventsRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(adminListUserAuthEventsRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.AdminListUserAuthEvents");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (adminListUserAuthEventsRequest.getUserPoolId() != null) {
                String userPoolId = adminListUserAuthEventsRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (adminListUserAuthEventsRequest.getUsername() != null) {
                String username = adminListUserAuthEventsRequest.getUsername();
                jsonWriter.name("Username");
                jsonWriter.value(username);
            }
            if (adminListUserAuthEventsRequest.getMaxResults() != null) {
                Integer maxResults = adminListUserAuthEventsRequest.getMaxResults();
                jsonWriter.name("MaxResults");
                jsonWriter.value(maxResults);
            }
            if (adminListUserAuthEventsRequest.getNextToken() != null) {
                String nextToken = adminListUserAuthEventsRequest.getNextToken();
                jsonWriter.name("NextToken");
                jsonWriter.value(nextToken);
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
