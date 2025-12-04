package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.CreateKeyRequest;
import com.amazonaws.services.kms.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import com.google.common.net.HttpHeaders;
import java.io.StringWriter;
import java.util.List;

/* loaded from: classes2.dex */
public class CreateKeyRequestMarshaller implements Marshaller<Request<CreateKeyRequest>, CreateKeyRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<CreateKeyRequest> marshall(CreateKeyRequest createKeyRequest) {
        if (createKeyRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(CreateKeyRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(createKeyRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.CreateKey");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (createKeyRequest.getPolicy() != null) {
                String policy = createKeyRequest.getPolicy();
                jsonWriter.name("Policy");
                jsonWriter.value(policy);
            }
            if (createKeyRequest.getDescription() != null) {
                String description = createKeyRequest.getDescription();
                jsonWriter.name("Description");
                jsonWriter.value(description);
            }
            if (createKeyRequest.getKeyUsage() != null) {
                String keyUsage = createKeyRequest.getKeyUsage();
                jsonWriter.name("KeyUsage");
                jsonWriter.value(keyUsage);
            }
            if (createKeyRequest.getCustomerMasterKeySpec() != null) {
                String customerMasterKeySpec = createKeyRequest.getCustomerMasterKeySpec();
                jsonWriter.name("CustomerMasterKeySpec");
                jsonWriter.value(customerMasterKeySpec);
            }
            if (createKeyRequest.getOrigin() != null) {
                String origin = createKeyRequest.getOrigin();
                jsonWriter.name(HttpHeaders.ORIGIN);
                jsonWriter.value(origin);
            }
            if (createKeyRequest.getCustomKeyStoreId() != null) {
                String customKeyStoreId = createKeyRequest.getCustomKeyStoreId();
                jsonWriter.name("CustomKeyStoreId");
                jsonWriter.value(customKeyStoreId);
            }
            if (createKeyRequest.getBypassPolicyLockoutSafetyCheck() != null) {
                Boolean bypassPolicyLockoutSafetyCheck = createKeyRequest.getBypassPolicyLockoutSafetyCheck();
                jsonWriter.name("BypassPolicyLockoutSafetyCheck");
                jsonWriter.value(bypassPolicyLockoutSafetyCheck.booleanValue());
            }
            if (createKeyRequest.getTags() != null) {
                List<Tag> tags = createKeyRequest.getTags();
                jsonWriter.name("Tags");
                jsonWriter.beginArray();
                for (Tag tag : tags) {
                    if (tag != null) {
                        TagJsonMarshaller.getInstance().marshall(tag, jsonWriter);
                    }
                }
                jsonWriter.endArray();
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
