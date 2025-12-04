package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.RevokeGrantRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class RevokeGrantRequestMarshaller implements Marshaller<Request<RevokeGrantRequest>, RevokeGrantRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<RevokeGrantRequest> marshall(RevokeGrantRequest revokeGrantRequest) {
        if (revokeGrantRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(RevokeGrantRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(revokeGrantRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.RevokeGrant");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (revokeGrantRequest.getKeyId() != null) {
                String keyId = revokeGrantRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            if (revokeGrantRequest.getGrantId() != null) {
                String grantId = revokeGrantRequest.getGrantId();
                jsonWriter.name("GrantId");
                jsonWriter.value(grantId);
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
