package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cognitoidentityprovider.model.DescribeUserPoolDomainRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class DescribeUserPoolDomainRequestMarshaller implements Marshaller<Request<DescribeUserPoolDomainRequest>, DescribeUserPoolDomainRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<DescribeUserPoolDomainRequest> marshall(DescribeUserPoolDomainRequest describeUserPoolDomainRequest) {
        if (describeUserPoolDomainRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(DescribeUserPoolDomainRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(describeUserPoolDomainRequest, "AmazonCognitoIdentityProvider");
        defaultRequest.addHeader("X-Amz-Target", "AWSCognitoIdentityProviderService.DescribeUserPoolDomain");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (describeUserPoolDomainRequest.getDomain() != null) {
                String domain = describeUserPoolDomainRequest.getDomain();
                jsonWriter.name("Domain");
                jsonWriter.value(domain);
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
