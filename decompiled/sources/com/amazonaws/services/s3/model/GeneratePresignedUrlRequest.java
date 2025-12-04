package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.HttpMethod;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GeneratePresignedUrlRequest extends AmazonWebServiceRequest implements SSECustomerKeyProvider, Serializable {
    private String bucketName;
    private String contentMd5;
    private String contentType;
    private Map customQueryParameters;
    private Date expiration;
    private String key;
    private String kmsCmkId;
    private HttpMethod method;
    private final Map requestParameters;
    private ResponseHeaderOverrides responseHeaders;
    private String sseAlgorithm;
    private SSECustomerKey sseCustomerKey;
    private String versionId;
    private boolean zeroByteContent;

    public String getKmsCmkId() {
        return this.kmsCmkId;
    }

    public void setKmsCmkId(String str) {
        this.kmsCmkId = str;
    }

    public GeneratePresignedUrlRequest withKmsCmkId(String str) {
        setKmsCmkId(str);
        return this;
    }

    public String getSSEAlgorithm() {
        return this.sseAlgorithm;
    }

    public void setSSEAlgorithm(String str) {
        this.sseAlgorithm = str;
    }

    public GeneratePresignedUrlRequest withSSEAlgorithm(String str) {
        setSSEAlgorithm(str);
        return this;
    }

    public void setSSEAlgorithm(SSEAlgorithm sSEAlgorithm) {
        this.sseAlgorithm = sSEAlgorithm.getAlgorithm();
    }

    public GeneratePresignedUrlRequest withSSEAlgorithm(SSEAlgorithm sSEAlgorithm) {
        setSSEAlgorithm(sSEAlgorithm);
        return this;
    }

    public GeneratePresignedUrlRequest(String str, String str2) {
        this(str, str2, HttpMethod.GET);
    }

    public GeneratePresignedUrlRequest(String str, String str2, HttpMethod httpMethod) {
        this.requestParameters = new HashMap();
        this.bucketName = str;
        this.key = str2;
        this.method = httpMethod;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public GeneratePresignedUrlRequest withMethod(HttpMethod httpMethod) {
        setMethod(httpMethod);
        return this;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public GeneratePresignedUrlRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public GeneratePresignedUrlRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public GeneratePresignedUrlRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public GeneratePresignedUrlRequest withExpiration(Date date) {
        setExpiration(date);
        return this;
    }

    public void addRequestParameter(String str, String str2) {
        this.requestParameters.put(str, str2);
    }

    public Map<String, String> getRequestParameters() {
        return this.requestParameters;
    }

    public Map<String, String> getCustomQueryParameters() {
        Map map = this.customQueryParameters;
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(map);
    }

    public void addCustomQueryParameter(String str, String str2) {
        if (this.customQueryParameters == null) {
            this.customQueryParameters = new HashMap();
        }
        if (this.customQueryParameters.get(str) == null) {
            this.customQueryParameters.put(str, str2);
        }
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public GeneratePresignedUrlRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public GeneratePresignedUrlRequest withContentType(String str) {
        setContentType(str);
        return this;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public GeneratePresignedUrlRequest withContentMd5(String str) {
        this.contentMd5 = str;
        return this;
    }

    @Override // com.amazonaws.services.s3.model.SSECustomerKeyProvider
    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sseCustomerKey = sSECustomerKey;
    }

    public GeneratePresignedUrlRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public void setSSECustomerKeyAlgorithm(SSEAlgorithm sSEAlgorithm) {
        if (sSEAlgorithm == null) {
            this.sseCustomerKey = null;
            return;
        }
        String algorithm = sSEAlgorithm.getAlgorithm();
        SSEAlgorithm sSEAlgorithm2 = SSEAlgorithm.AES256;
        if (algorithm.equals(sSEAlgorithm2.getAlgorithm())) {
            this.sseCustomerKey = SSECustomerKey.generateSSECustomerKeyForPresignUrl(sSEAlgorithm.getAlgorithm());
            return;
        }
        throw new IllegalArgumentException("Currently the only supported Server Side Encryption algorithm is " + sSEAlgorithm2);
    }

    public GeneratePresignedUrlRequest withSSECustomerKeyAlgorithm(SSEAlgorithm sSEAlgorithm) {
        setSSECustomerKeyAlgorithm(sSEAlgorithm);
        return this;
    }

    public boolean isZeroByteContent() {
        return this.zeroByteContent;
    }

    public void setZeroByteContent(boolean z) {
        this.zeroByteContent = z;
    }

    public GeneratePresignedUrlRequest withZeroByteContent(boolean z) {
        setZeroByteContent(z);
        return this;
    }

    public void rejectIllegalArguments() {
        if (this.bucketName == null) {
            throw new IllegalArgumentException("The bucket name parameter must be specified when generating a pre-signed URL");
        }
        if (this.method == null) {
            throw new IllegalArgumentException("The HTTP method request parameter must be specified when generating a pre-signed URL");
        }
        if (this.sseCustomerKey != null) {
            if (this.sseAlgorithm != null) {
                throw new IllegalArgumentException("Either SSE or SSE-C can be specified but not both");
            }
            if (this.kmsCmkId != null) {
                throw new IllegalArgumentException("KMS CMK is not applicable for SSE-C");
            }
            return;
        }
        if (this.kmsCmkId != null) {
            SSEAlgorithm sSEAlgorithm = SSEAlgorithm.KMS;
            if (sSEAlgorithm.getAlgorithm().equals(this.sseAlgorithm)) {
                return;
            }
            throw new IllegalArgumentException("For KMS server side encryption, the SSE algorithm must be set to " + sSEAlgorithm);
        }
    }
}
