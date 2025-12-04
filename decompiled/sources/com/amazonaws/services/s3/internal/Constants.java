package com.amazonaws.services.s3.internal;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.SSEAlgorithm;

/* loaded from: classes2.dex */
public class Constants {
    public static final int BUCKET_ACCESS_FORBIDDEN_STATUS_CODE = 403;
    public static final int BUCKET_REDIRECT_STATUS_CODE = 301;
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 131073;
    public static final int FAILED_PRECONDITION_STATUS_CODE = 412;
    public static final long GB = 1073741824;
    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    public static final int KB = 1024;
    public static final String LOCAL_TESTING_ENDPOINT = "http://10.0.2.2:20005";
    public static final String LOCAL_TESTING_FLAG_NAME = "DangerouslyConnectToHTTPEndpointForTesting";
    public static final int MAXIMUM_UPLOAD_PARTS = 10000;
    public static final int MB = 1048576;
    public static final int NO_SUCH_BUCKET_STATUS_CODE = 404;
    public static final String NULL_VERSION_ID = "null";
    public static final String REQUESTER_PAYS = "requester";
    public static final String S3_ACCELERATE_DUALSTACK_HOSTNAME = "s3-accelerate.dualstack.amazonaws.com";
    public static final String S3_ACCELERATE_HOSTNAME = "s3-accelerate.amazonaws.com";
    public static final String S3_DUALSTACK_QUALIFIER = "dualstack";
    public static final String S3_ENDPOINT_PREFIX = "s3";
    public static final String S3_EXTERNAL_1_HOSTNAME = "s3-external-1.amazonaws.com";
    public static final String S3_HOSTNAME = "s3.amazonaws.com";
    public static final String S3_SERVICE_DISPLAY_NAME = "Amazon S3";
    public static final String URL_ENCODING = "url";
    public static final String XML_NAMESPACE = "http://s3.amazonaws.com/doc/2006-03-01/";
    private static Log log = LogFactory.getLog(AmazonS3Client.class);
    public static final String SSE_AWS_KMS_ENCRYPTION_SCHEME = SSEAlgorithm.KMS.getAlgorithm();

    @Deprecated
    public static int getStreamBufferSize() {
        String property = System.getProperty(SDKGlobalConfiguration.DEFAULT_S3_STREAM_BUFFER_SIZE);
        if (property != null) {
            try {
                return Integer.parseInt(property);
            } catch (Exception unused) {
                log.warn("Unable to parse buffer size override from value: " + property);
            }
        }
        return 131073;
    }

    public static Integer getS3StreamBufferSize() {
        String property = System.getProperty(SDKGlobalConfiguration.DEFAULT_S3_STREAM_BUFFER_SIZE);
        if (property == null) {
            return null;
        }
        try {
            return Integer.valueOf(property);
        } catch (Exception unused) {
            log.warn("Unable to parse buffer size override from value: " + property);
            return null;
        }
    }
}
