package com.amazonaws.services.p017s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.p017s3.model.ObjectMetadata;

/* JADX INFO: loaded from: classes2.dex */
public class S3MetadataResponseHandler extends AbstractS3ResponseHandler<ObjectMetadata> {
    @Override // com.amazonaws.http.HttpResponseHandler
    public AmazonWebServiceResponse<ObjectMetadata> handle(HttpResponse httpResponse) throws Exception {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        populateObjectMetadata(httpResponse, objectMetadata);
        AmazonWebServiceResponse<ObjectMetadata> responseMetadata = parseResponseMetadata(httpResponse);
        responseMetadata.setResult(objectMetadata);
        return responseMetadata;
    }
}
