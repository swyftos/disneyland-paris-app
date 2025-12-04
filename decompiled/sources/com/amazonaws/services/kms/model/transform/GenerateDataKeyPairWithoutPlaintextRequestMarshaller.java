package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.GenerateDataKeyPairWithoutPlaintextRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class GenerateDataKeyPairWithoutPlaintextRequestMarshaller implements Marshaller<Request<GenerateDataKeyPairWithoutPlaintextRequest>, GenerateDataKeyPairWithoutPlaintextRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<GenerateDataKeyPairWithoutPlaintextRequest> marshall(GenerateDataKeyPairWithoutPlaintextRequest generateDataKeyPairWithoutPlaintextRequest) {
        if (generateDataKeyPairWithoutPlaintextRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(GenerateDataKeyPairWithoutPlaintextRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(generateDataKeyPairWithoutPlaintextRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.GenerateDataKeyPairWithoutPlaintext");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext() != null) {
                Map<String, String> encryptionContext = generateDataKeyPairWithoutPlaintextRequest.getEncryptionContext();
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
            if (generateDataKeyPairWithoutPlaintextRequest.getKeyId() != null) {
                String keyId = generateDataKeyPairWithoutPlaintextRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            if (generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec() != null) {
                String keyPairSpec = generateDataKeyPairWithoutPlaintextRequest.getKeyPairSpec();
                jsonWriter.name("KeyPairSpec");
                jsonWriter.value(keyPairSpec);
            }
            if (generateDataKeyPairWithoutPlaintextRequest.getGrantTokens() != null) {
                List<String> grantTokens = generateDataKeyPairWithoutPlaintextRequest.getGrantTokens();
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
