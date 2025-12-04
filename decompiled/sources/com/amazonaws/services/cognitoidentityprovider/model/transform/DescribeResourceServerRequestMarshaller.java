package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.DescribeResourceServerRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class DescribeResourceServerRequestMarshaller implements Marshaller<Request<DescribeResourceServerRequest>, DescribeResourceServerRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DescribeResourceServerRequest> marshall(DescribeResourceServerRequest describeResourceServerRequest) {
        if (describeResourceServerRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DescribeResourceServerRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeResourceServerRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.DescribeResourceServer");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (describeResourceServerRequest.getUserPoolId() != null) {
                String userPoolId = describeResourceServerRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (describeResourceServerRequest.getIdentifier() != null) {
                String identifier = describeResourceServerRequest.getIdentifier();
                jsonWriter.name("Identifier");
                jsonWriter.value(identifier);
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
