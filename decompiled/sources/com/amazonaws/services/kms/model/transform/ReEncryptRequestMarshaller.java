package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.ReEncryptRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReEncryptRequestMarshaller implements Marshaller<Request<ReEncryptRequest>, ReEncryptRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ReEncryptRequest> marshall(ReEncryptRequest reEncryptRequest) {
        if (reEncryptRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ReEncryptRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(reEncryptRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.ReEncrypt");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (reEncryptRequest.getCiphertextBlob() != null) {
                ByteBuffer ciphertextBlob = reEncryptRequest.getCiphertextBlob();
                jsonWriter.name("CiphertextBlob");
                jsonWriter.value(ciphertextBlob);
            }
            if (reEncryptRequest.getSourceEncryptionContext() != null) {
                Map<String, String> sourceEncryptionContext = reEncryptRequest.getSourceEncryptionContext();
                jsonWriter.name("SourceEncryptionContext");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : sourceEncryptionContext.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
            }
            if (reEncryptRequest.getSourceKeyId() != null) {
                String sourceKeyId = reEncryptRequest.getSourceKeyId();
                jsonWriter.name("SourceKeyId");
                jsonWriter.value(sourceKeyId);
            }
            if (reEncryptRequest.getDestinationKeyId() != null) {
                String destinationKeyId = reEncryptRequest.getDestinationKeyId();
                jsonWriter.name("DestinationKeyId");
                jsonWriter.value(destinationKeyId);
            }
            if (reEncryptRequest.getDestinationEncryptionContext() != null) {
                Map<String, String> destinationEncryptionContext = reEncryptRequest.getDestinationEncryptionContext();
                jsonWriter.name("DestinationEncryptionContext");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry2 : destinationEncryptionContext.entrySet()) {
                    String value2 = entry2.getValue();
                    if (value2 != null) {
                        jsonWriter.name(entry2.getKey());
                        jsonWriter.value(value2);
                    }
                }
                jsonWriter.endObject();
            }
            if (reEncryptRequest.getSourceEncryptionAlgorithm() != null) {
                String sourceEncryptionAlgorithm = reEncryptRequest.getSourceEncryptionAlgorithm();
                jsonWriter.name("SourceEncryptionAlgorithm");
                jsonWriter.value(sourceEncryptionAlgorithm);
            }
            if (reEncryptRequest.getDestinationEncryptionAlgorithm() != null) {
                String destinationEncryptionAlgorithm = reEncryptRequest.getDestinationEncryptionAlgorithm();
                jsonWriter.name("DestinationEncryptionAlgorithm");
                jsonWriter.value(destinationEncryptionAlgorithm);
            }
            if (reEncryptRequest.getGrantTokens() != null) {
                List<String> grantTokens = reEncryptRequest.getGrantTokens();
                jsonWriter.name("GrantTokens");
                jsonWriter.beginArray();
                for (String str : grantTokens) {
                    if (str != null) {
                        jsonWriter.value(str);
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
