package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.EncryptRequest;
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
public class EncryptRequestMarshaller implements Marshaller<Request<EncryptRequest>, EncryptRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<EncryptRequest> marshall(EncryptRequest encryptRequest) {
        if (encryptRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(EncryptRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(encryptRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.Encrypt");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (encryptRequest.getKeyId() != null) {
                String keyId = encryptRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            if (encryptRequest.getPlaintext() != null) {
                ByteBuffer plaintext = encryptRequest.getPlaintext();
                jsonWriter.name("Plaintext");
                jsonWriter.value(plaintext);
            }
            if (encryptRequest.getEncryptionContext() != null) {
                Map<String, String> encryptionContext = encryptRequest.getEncryptionContext();
                jsonWriter.name("EncryptionContext");
                jsonWriter.beginObject();
                for (Map.Entry<String, String> entry : encryptionContext.entrySet()) {
                    String value = entry.getValue();
                    if (value != null) {
                        jsonWriter.name(entry.getKey());
                        jsonWriter.value(value);
                    }
                }
                jsonWriter.endObject();
            }
            if (encryptRequest.getGrantTokens() != null) {
                List<String> grantTokens = encryptRequest.getGrantTokens();
                jsonWriter.name("GrantTokens");
                jsonWriter.beginArray();
                for (String str : grantTokens) {
                    if (str != null) {
                        jsonWriter.value(str);
                    }
                }
                jsonWriter.endArray();
            }
            if (encryptRequest.getEncryptionAlgorithm() != null) {
                String encryptionAlgorithm = encryptRequest.getEncryptionAlgorithm();
                jsonWriter.name("EncryptionAlgorithm");
                jsonWriter.value(encryptionAlgorithm);
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
