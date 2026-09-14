package com.amazonaws.services.p017s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.p017s3.Headers;
import com.amazonaws.services.p017s3.model.DeleteObjectTaggingResult;

/* JADX INFO: loaded from: classes2.dex */
public class DeleteObjectTaggingHeaderHandler implements HeaderHandler<DeleteObjectTaggingResult> {
    @Override // com.amazonaws.services.p017s3.internal.HeaderHandler
    public void handle(DeleteObjectTaggingResult deleteObjectTaggingResult, HttpResponse httpResponse) {
        deleteObjectTaggingResult.setVersionId(httpResponse.getHeaders().get(Headers.S3_VERSION_ID));
    }
}
