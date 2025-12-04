package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.XpathUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

/* loaded from: classes2.dex */
public class S3ErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    private static final Log log = LogFactory.getLog(S3ErrorResponseHandler.class);

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean needsConnectionLeftOpen() {
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.http.HttpResponseHandler
    public AmazonServiceException handle(HttpResponse httpResponse) throws IOException {
        InputStream content = httpResponse.getContent();
        if (content == null) {
            return newAmazonS3Exception(httpResponse.getStatusText(), httpResponse);
        }
        try {
            String string = IOUtils.toString(content);
            try {
                Document documentDocumentFrom = XpathUtils.documentFrom(string);
                String strAsString = XpathUtils.asString("Error/Message", documentDocumentFrom);
                String strAsString2 = XpathUtils.asString("Error/Code", documentDocumentFrom);
                String strAsString3 = XpathUtils.asString("Error/RequestId", documentDocumentFrom);
                String strAsString4 = XpathUtils.asString("Error/HostId", documentDocumentFrom);
                AmazonS3Exception amazonS3Exception = new AmazonS3Exception(strAsString);
                int statusCode = httpResponse.getStatusCode();
                amazonS3Exception.setStatusCode(statusCode);
                amazonS3Exception.setErrorType(errorTypeOf(statusCode));
                amazonS3Exception.setErrorCode(strAsString2);
                amazonS3Exception.setRequestId(strAsString3);
                amazonS3Exception.setExtendedRequestId(strAsString4);
                amazonS3Exception.setCloudFrontId(httpResponse.getHeaders().get(Headers.CLOUD_FRONT_ID));
                return amazonS3Exception;
            } catch (Exception e) {
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("Failed in parsing the response as XML: " + string, e);
                }
                return newAmazonS3Exception(string, httpResponse);
            }
        } catch (IOException e2) {
            if (log.isDebugEnabled()) {
                log.debug("Failed in reading the error response", e2);
            }
            return newAmazonS3Exception(httpResponse.getStatusText(), httpResponse);
        }
    }

    private AmazonS3Exception newAmazonS3Exception(String str, HttpResponse httpResponse) {
        AmazonS3Exception amazonS3Exception = new AmazonS3Exception(str);
        int statusCode = httpResponse.getStatusCode();
        amazonS3Exception.setErrorCode(statusCode + " " + httpResponse.getStatusText());
        amazonS3Exception.setStatusCode(statusCode);
        amazonS3Exception.setErrorType(errorTypeOf(statusCode));
        Map<String, String> headers = httpResponse.getHeaders();
        amazonS3Exception.setRequestId(headers.get(Headers.REQUEST_ID));
        amazonS3Exception.setExtendedRequestId(headers.get(Headers.EXTENDED_REQUEST_ID));
        amazonS3Exception.setCloudFrontId(headers.get(Headers.CLOUD_FRONT_ID));
        HashMap map = new HashMap();
        map.put(Headers.S3_BUCKET_REGION, headers.get(Headers.S3_BUCKET_REGION));
        amazonS3Exception.setAdditionalDetails(map);
        return amazonS3Exception;
    }

    private AmazonServiceException.ErrorType errorTypeOf(int i) {
        return i >= 500 ? AmazonServiceException.ErrorType.Service : AmazonServiceException.ErrorType.Client;
    }
}
