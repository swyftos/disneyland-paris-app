package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes2.dex */
public class S3XmlResponseHandler<T> extends AbstractS3ResponseHandler<T> {
    private static final Log log = LogFactory.getLog("com.amazonaws.request");
    private Map responseHeaders;
    private Unmarshaller responseUnmarshaller;

    public S3XmlResponseHandler(Unmarshaller<T, InputStream> unmarshaller) {
        this.responseUnmarshaller = unmarshaller;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amazonaws.http.HttpResponseHandler
    public AmazonWebServiceResponse<T> handle(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<T> responseMetadata = parseResponseMetadata(httpResponse);
        this.responseHeaders = httpResponse.getHeaders();
        if (this.responseUnmarshaller != null) {
            Log log2 = log;
            log2.trace("Beginning to parse service response XML");
            Object objUnmarshall = this.responseUnmarshaller.unmarshall(httpResponse.getContent());
            log2.trace("Done parsing service response XML");
            responseMetadata.setResult(objUnmarshall);
        }
        return responseMetadata;
    }

    public Map<String, String> getResponseHeaders() {
        return this.responseHeaders;
    }
}
