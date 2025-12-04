package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserImportJobRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class DescribeUserImportJobRequestMarshaller implements Marshaller<Request<DescribeUserImportJobRequest>, DescribeUserImportJobRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DescribeUserImportJobRequest> marshall(DescribeUserImportJobRequest describeUserImportJobRequest) {
        if (describeUserImportJobRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DescribeUserImportJobRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeUserImportJobRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.DescribeUserImportJob");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (describeUserImportJobRequest.getUserPoolId() != null) {
                String userPoolId = describeUserImportJobRequest.getUserPoolId();
                jsonWriter.name("UserPoolId");
                jsonWriter.value(userPoolId);
            }
            if (describeUserImportJobRequest.getJobId() != null) {
                String jobId = describeUserImportJobRequest.getJobId();
                jsonWriter.name("JobId");
                jsonWriter.value(jobId);
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
