package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.ImportKeyMaterialRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: classes2.dex */
public class ImportKeyMaterialRequestMarshaller implements Marshaller<Request<ImportKeyMaterialRequest>, ImportKeyMaterialRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ImportKeyMaterialRequest> marshall(ImportKeyMaterialRequest importKeyMaterialRequest) {
        if (importKeyMaterialRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ImportKeyMaterialRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(importKeyMaterialRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.ImportKeyMaterial");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (importKeyMaterialRequest.getKeyId() != null) {
                String keyId = importKeyMaterialRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            if (importKeyMaterialRequest.getImportToken() != null) {
                ByteBuffer importToken = importKeyMaterialRequest.getImportToken();
                jsonWriter.name("ImportToken");
                jsonWriter.value(importToken);
            }
            if (importKeyMaterialRequest.getEncryptedKeyMaterial() != null) {
                ByteBuffer encryptedKeyMaterial = importKeyMaterialRequest.getEncryptedKeyMaterial();
                jsonWriter.name("EncryptedKeyMaterial");
                jsonWriter.value(encryptedKeyMaterial);
            }
            if (importKeyMaterialRequest.getValidTo() != null) {
                Date validTo = importKeyMaterialRequest.getValidTo();
                jsonWriter.name("ValidTo");
                jsonWriter.value(validTo);
            }
            if (importKeyMaterialRequest.getExpirationModel() != null) {
                String expirationModel = importKeyMaterialRequest.getExpirationModel();
                jsonWriter.name("ExpirationModel");
                jsonWriter.value(expirationModel);
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
