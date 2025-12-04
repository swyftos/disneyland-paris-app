package com.amazonaws.services.kms.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.kms.model.ScheduleKeyDeletionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class ScheduleKeyDeletionRequestMarshaller implements Marshaller<Request<ScheduleKeyDeletionRequest>, ScheduleKeyDeletionRequest> {
    @Override // com.amazonaws.transform.Marshaller
    public Request<ScheduleKeyDeletionRequest> marshall(ScheduleKeyDeletionRequest scheduleKeyDeletionRequest) {
        if (scheduleKeyDeletionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(ScheduleKeyDeletionRequest)");
        }
        DefaultRequest defaultRequest = new DefaultRequest(scheduleKeyDeletionRequest, "AWSKMS");
        defaultRequest.addHeader("X-Amz-Target", "TrentService.ScheduleKeyDeletion");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        defaultRequest.setResourcePath("/");
        try {
            StringWriter stringWriter = new StringWriter();
            AwsJsonWriter jsonWriter = JsonUtils.getJsonWriter(stringWriter);
            jsonWriter.beginObject();
            if (scheduleKeyDeletionRequest.getKeyId() != null) {
                String keyId = scheduleKeyDeletionRequest.getKeyId();
                jsonWriter.name("KeyId");
                jsonWriter.value(keyId);
            }
            if (scheduleKeyDeletionRequest.getPendingWindowInDays() != null) {
                Integer pendingWindowInDays = scheduleKeyDeletionRequest.getPendingWindowInDays();
                jsonWriter.name("PendingWindowInDays");
                jsonWriter.value(pendingWindowInDays);
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
