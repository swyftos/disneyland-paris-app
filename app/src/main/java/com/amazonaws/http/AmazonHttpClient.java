package com.amazonaws.http;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Signer;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class AmazonHttpClient {
    private static final Log REQUEST_LOG = LogFactory.getLog("com.amazonaws.request");
    static final Log log = LogFactory.getLog(AmazonHttpClient.class);
    final ClientConfiguration config;
    final HttpClient httpClient;
    private final HttpRequestFactory requestFactory;
    private final RequestMetricCollector requestMetricCollector;

    @Deprecated
    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return null;
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        this(clientConfiguration, new UrlHttpClient(clientConfiguration), requestMetricCollector);
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = null;
    }

    @Deprecated
    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient, RequestMetricCollector requestMetricCollector) {
        this.requestFactory = new HttpRequestFactory();
        this.config = clientConfiguration;
        this.httpClient = httpClient;
        this.requestMetricCollector = requestMetricCollector;
    }

    public <T> Response<T> execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) throws Throwable {
        Response<T> responseExecuteHelper;
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List listRequestHandler2s = requestHandler2s(request, executionContext);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        try {
            responseExecuteHelper = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
            try {
                afterResponse(request, listRequestHandler2s, responseExecuteHelper, awsRequestMetrics.getTimingInfo().endTiming());
                return responseExecuteHelper;
            } catch (AmazonClientException e) {
                e = e;
                afterError(request, responseExecuteHelper, listRequestHandler2s, e);
                throw e;
            }
        } catch (AmazonClientException e2) {
            e = e2;
            responseExecuteHelper = null;
        }
    }

    void afterError(Request request, Response response, List list, AmazonClientException amazonClientException) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RequestHandler2) it.next()).afterError(request, response, amazonClientException);
        }
    }

    void afterResponse(Request request, List list, Response response, TimingInfo timingInfo) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((RequestHandler2) it.next()).afterResponse(request, response);
        }
    }

    List requestHandler2s(Request request, ExecutionContext executionContext) {
        List<RequestHandler2> requestHandler2s = executionContext.getRequestHandler2s();
        if (requestHandler2s == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 requestHandler2 : requestHandler2s) {
            if (requestHandler2 instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) requestHandler2).setCredentials(executionContext.getCredentials());
            }
            requestHandler2.beforeRequest(request);
        }
        return requestHandler2s;
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0212  */
    /* JADX WARN: Code duplicated, block: B:139:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:146:0x02f3 A[Catch: all -> 0x0301, Error -> 0x0308, RuntimeException -> 0x030e, IOException -> 0x0314, TryCatch #38 {IOException -> 0x0314, Error -> 0x0308, RuntimeException -> 0x030e, all -> 0x0301, blocks: (B:144:0x02ed, B:146:0x02f3, B:148:0x02f9, B:158:0x031d, B:169:0x0346), top: B:292:0x02ed }] */
    /* JADX WARN: Code duplicated, block: B:148:0x02f9 A[Catch: all -> 0x0301, Error -> 0x0308, RuntimeException -> 0x030e, IOException -> 0x0314, TryCatch #38 {IOException -> 0x0314, Error -> 0x0308, RuntimeException -> 0x030e, all -> 0x0301, blocks: (B:144:0x02ed, B:146:0x02f3, B:148:0x02f9, B:158:0x031d, B:169:0x0346), top: B:292:0x02ed }] */
    /* JADX WARN: Code duplicated, block: B:164:0x032d A[Catch: IOException -> 0x0335, TRY_LEAVE, TryCatch #30 {IOException -> 0x0335, blocks: (B:162:0x0327, B:164:0x032d), top: B:268:0x0327 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0346 A[Catch: all -> 0x0301, Error -> 0x0308, RuntimeException -> 0x030e, IOException -> 0x0314, TRY_ENTER, TRY_LEAVE, TryCatch #38 {IOException -> 0x0314, Error -> 0x0308, RuntimeException -> 0x030e, all -> 0x0301, blocks: (B:144:0x02ed, B:146:0x02f3, B:148:0x02f9, B:158:0x031d, B:169:0x0346), top: B:292:0x02ed }] */
    /* JADX WARN: Code duplicated, block: B:227:0x03ec A[Catch: all -> 0x03ab, TRY_ENTER, TryCatch #6 {all -> 0x03ab, blocks: (B:224:0x03e2, B:227:0x03ec, B:228:0x0402, B:230:0x0444, B:241:0x0470, B:202:0x03a5, B:203:0x03aa), top: B:253:0x03e2 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x0444 A[Catch: all -> 0x03ab, TRY_LEAVE, TryCatch #6 {all -> 0x03ab, blocks: (B:224:0x03e2, B:227:0x03ec, B:228:0x0402, B:230:0x0444, B:241:0x0470, B:202:0x03a5, B:203:0x03aa), top: B:253:0x03e2 }] */
    /* JADX WARN: Code duplicated, block: B:232:0x0449 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:235:0x0451 A[Catch: IOException -> 0x0459, TRY_LEAVE, TryCatch #40 {IOException -> 0x0459, blocks: (B:233:0x044b, B:235:0x0451), top: B:276:0x044b }] */
    /* JADX WARN: Code duplicated, block: B:243:0x0473 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:262:0x01ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x01cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x0470 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:312:? A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0179 A[Catch: all -> 0x00da, Error -> 0x00e3, RuntimeException -> 0x00eb, IOException -> 0x0162, TRY_ENTER, TRY_LEAVE, TryCatch #25 {all -> 0x00da, blocks: (B:23:0x00c7, B:25:0x00d0, B:27:0x00d6, B:61:0x0144, B:67:0x0156, B:69:0x015e, B:74:0x016a, B:75:0x0170, B:78:0x0179, B:45:0x0103, B:46:0x0108), top: B:251:0x00c7 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d3 A[Catch: IOException -> 0x01db, TRY_LEAVE, TryCatch #59 {IOException -> 0x01db, blocks: (B:90:0x01cd, B:92:0x01d3), top: B:285:0x01cd }] */
    /* JADX WARN: Instruction removed from duplicated block: B:227:0x03ec, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:78:0x0179, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    Response executeHelper(Request request, HttpResponseHandler httpResponseHandler, HttpResponseHandler httpResponseHandler2, ExecutionContext executionContext) throws Throwable {
        Throwable th;
        ExecutionContext executionContext2;
        Object obj;
        HttpResponse httpResponse;
        String str;
        Signer signer;
        String str2;
        Throwable th2;
        LinkedHashMap linkedHashMap;
        Log log2;
        AmazonClientException amazonClientException;
        String str3;
        Log log3;
        HttpRequest httpRequestCreateHttpRequest;
        String str4;
        HttpResponse httpResponseExecute;
        Object obj2;
        String str5;
        String str6;
        AmazonClientException amazonClientException2;
        HttpResponse httpResponse2;
        boolean zNeedsConnectionLeftOpen;
        AmazonServiceException amazonServiceExceptionHandleErrorResponse;
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.ServiceName, request.getServiceName());
        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.ServiceEndpoint, request.getEndpoint());
        setUserAgent(request);
        request.addHeader("aws-sdk-invocation-id", UUID.randomUUID().toString());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(request.getParameters());
        HashMap map = new HashMap(request.getHeaders());
        InputStream content = request.getContent();
        if (content != null && content.markSupported()) {
            content.mark(-1);
        }
        AWSCredentials credentials = executionContext.getCredentials();
        int i = 0;
        long j = 0;
        AmazonClientException amazonClientException3 = null;
        Signer signerByURI = null;
        HttpResponse httpResponse3 = null;
        URI uriCreate = null;
        HttpRequest httpRequest = null;
        boolean z = false;
        while (true) {
            int i2 = i + 1;
            boolean z2 = z;
            long jPauseBeforeNextRetry = j;
            awsRequestMetrics.setCounter(AWSRequestMetrics.Field.RequestCount, i2);
            boolean zNeedsConnectionLeftOpen2 = true;
            if (i2 > 1) {
                request.setParameters(linkedHashMap2);
                request.setHeaders(map);
                request.setContent(content);
            }
            if (uriCreate != null && request.getEndpoint() == null && request.getResourcePath() == null) {
                request.setEndpoint(URI.create(uriCreate.getScheme() + "://" + uriCreate.getAuthority()));
                request.setResourcePath(uriCreate.getPath());
            }
            String str7 = "Cannot close the response content.";
            try {
                if (i2 > 1) {
                    try {
                        MetricType metricType = AWSRequestMetrics.Field.RetryPauseTime;
                        awsRequestMetrics.startEvent(metricType);
                        try {
                            httpResponse = httpResponse3;
                            try {
                                jPauseBeforeNextRetry = pauseBeforeNextRetry(request.getOriginalRequest(), amazonClientException3, i2, this.config.getRetryPolicy());
                                try {
                                    try {
                                        try {
                                            awsRequestMetrics.endEvent(metricType);
                                            InputStream content2 = request.getContent();
                                            if (content2 != null && content2.markSupported()) {
                                                content2.reset();
                                            }
                                        } catch (Error e) {
                                            e = e;
                                            throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                        } catch (RuntimeException e2) {
                                            e = e2;
                                            throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        str3 = "Cannot close the response content.";
                                        zNeedsConnectionLeftOpen2 = z2;
                                        httpResponse3 = httpResponse;
                                        executionContext2 = str3;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    str = "Cannot close the response content.";
                                    signer = signerByURI;
                                    linkedHashMap = linkedHashMap2;
                                    str2 = str;
                                    try {
                                        log2 = log;
                                        if (log2.isDebugEnabled()) {
                                            log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                        }
                                        MetricType metricType2 = AWSRequestMetrics.Field.Exception;
                                        awsRequestMetrics.incrementCounter(metricType2);
                                        awsRequestMetrics.addProperty(metricType2, e);
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                        amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                        if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                            throw amazonClientException;
                                        }
                                        resetRequestAfterError(request, e);
                                        if (!z2 && httpResponse != null) {
                                            try {
                                                if (httpResponse.getRawContent() != null) {
                                                    httpResponse.getRawContent().close();
                                                }
                                            } catch (IOException e4) {
                                                log.warn(str2, e4);
                                            }
                                        }
                                        z = z2;
                                        j = jPauseBeforeNextRetry;
                                        httpResponse3 = httpResponse;
                                        amazonClientException3 = amazonClientException;
                                        signerByURI = signer;
                                        i = i2;
                                        linkedHashMap2 = linkedHashMap;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        th = th2;
                                        str3 = str2;
                                        zNeedsConnectionLeftOpen2 = z2;
                                        httpResponse3 = httpResponse;
                                        executionContext2 = str3;
                                        if (zNeedsConnectionLeftOpen2) {
                                            throw th;
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RetryPauseTime);
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            httpResponse = httpResponse3;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        httpResponse = httpResponse3;
                    } catch (Error e6) {
                        e = e6;
                    } catch (RuntimeException e7) {
                        e = e7;
                        throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                    } catch (Throwable th7) {
                        th = th7;
                        obj = "Cannot close the response content.";
                        zNeedsConnectionLeftOpen2 = z2;
                        executionContext2 = obj;
                        if (zNeedsConnectionLeftOpen2) {
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    httpResponse = httpResponse3;
                }
                long j2 = jPauseBeforeNextRetry;
                try {
                    try {
                        request.addHeader("aws-sdk-retry", i + "/" + j2);
                        if (signerByURI == null) {
                            try {
                                signerByURI = executionContext.getSignerByURI(request.getEndpoint());
                            } catch (IOException e8) {
                                e = e8;
                                jPauseBeforeNextRetry = j2;
                                str = "Cannot close the response content.";
                                signer = signerByURI;
                                linkedHashMap = linkedHashMap2;
                                str2 = str;
                                log2 = log;
                                if (log2.isDebugEnabled()) {
                                    log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                }
                                MetricType metricType3 = AWSRequestMetrics.Field.Exception;
                                awsRequestMetrics.incrementCounter(metricType3);
                                awsRequestMetrics.addProperty(metricType3, e);
                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                    throw amazonClientException;
                                }
                                resetRequestAfterError(request, e);
                                if (!z2) {
                                    if (httpResponse.getRawContent() != null) {
                                        httpResponse.getRawContent().close();
                                    }
                                }
                                z = z2;
                                j = jPauseBeforeNextRetry;
                                httpResponse3 = httpResponse;
                                amazonClientException3 = amazonClientException;
                                signerByURI = signer;
                                i = i2;
                                linkedHashMap2 = linkedHashMap;
                            }
                        }
                        signer = signerByURI;
                        if (signer != null && credentials != null) {
                            try {
                                MetricType metricType4 = AWSRequestMetrics.Field.RequestSigningTime;
                                awsRequestMetrics.startEvent(metricType4);
                                try {
                                    signer.sign(request, credentials);
                                    awsRequestMetrics.endEvent(metricType4);
                                    log3 = REQUEST_LOG;
                                    if (log3.isDebugEnabled()) {
                                        log3.debug("Sending Request: " + request.toString());
                                    }
                                    httpRequestCreateHttpRequest = this.requestFactory.createHttpRequest(request, this.config, executionContext);
                                    MetricType metricType5 = AWSRequestMetrics.Field.HttpRequestTime;
                                    awsRequestMetrics.startEvent(metricType5);
                                    httpResponseExecute = this.httpClient.execute(httpRequestCreateHttpRequest);
                                    awsRequestMetrics.endEvent(metricType5);
                                    if (isRequestSuccessful(httpResponseExecute)) {
                                        jPauseBeforeNextRetry = j2;
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(httpResponseExecute.getStatusCode()));
                                        zNeedsConnectionLeftOpen2 = httpResponseHandler.needsConnectionLeftOpen();
                                        Response response = new Response(handleResponse(request, httpResponseHandler, httpResponseExecute, executionContext), httpResponseExecute);
                                        if (!zNeedsConnectionLeftOpen2) {
                                            if (httpResponseExecute.getRawContent() != null) {
                                                httpResponseExecute.getRawContent().close();
                                            }
                                        }
                                        return response;
                                    }
                                    jPauseBeforeNextRetry = j2;
                                    if (isTemporaryRedirect(httpResponseExecute)) {
                                        String str8 = httpResponseExecute.getHeaders().get("Location");
                                        Log log4 = log;
                                        StringBuilder sb = new StringBuilder();
                                        str5 = "Cannot close the response content.";
                                        sb.append("Redirecting to: ");
                                        sb.append(str8);
                                        log4.debug(sb.toString());
                                        uriCreate = URI.create(str8);
                                        request.setEndpoint(null);
                                        request.setResourcePath(null);
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(httpResponseExecute.getStatusCode()));
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.RedirectLocation, str8);
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                        httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                                        signer = signer;
                                        z = z2;
                                        str6 = str5;
                                        amazonClientException2 = null;
                                        linkedHashMap = linkedHashMap2;
                                        httpResponse2 = httpResponseExecute;
                                    } else {
                                        zNeedsConnectionLeftOpen = httpResponseHandler2.needsConnectionLeftOpen();
                                        amazonServiceExceptionHandleErrorResponse = handleErrorResponse(request, httpResponseHandler2, httpResponseExecute);
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, amazonServiceExceptionHandleErrorResponse.getRequestId());
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSErrorCode, amazonServiceExceptionHandleErrorResponse.getErrorCode());
                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(amazonServiceExceptionHandleErrorResponse.getStatusCode()));
                                        str4 = "Cannot close the response content.";
                                        linkedHashMap = linkedHashMap2;
                                        httpResponse2 = httpResponseExecute;
                                        httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                                        signer = signer;
                                        if (shouldRetry(request.getOriginalRequest(), httpRequestCreateHttpRequest.getContent(), amazonServiceExceptionHandleErrorResponse, i2, this.config.getRetryPolicy())) {
                                            throw amazonServiceExceptionHandleErrorResponse;
                                        }
                                        if (RetryUtils.isClockSkewError(amazonServiceExceptionHandleErrorResponse)) {
                                            SDKGlobalConfiguration.setGlobalTimeOffset(parseClockSkewOffset(httpResponse2, amazonServiceExceptionHandleErrorResponse));
                                        }
                                        resetRequestAfterError(request, amazonServiceExceptionHandleErrorResponse);
                                        amazonClientException2 = amazonServiceExceptionHandleErrorResponse;
                                        z = zNeedsConnectionLeftOpen;
                                        str6 = str4;
                                    }
                                    if (!z) {
                                        if (httpResponse2.getRawContent() != null) {
                                            httpResponse2.getRawContent().close();
                                        }
                                    }
                                    amazonClientException3 = amazonClientException2;
                                    httpResponse3 = httpResponse2;
                                    j = jPauseBeforeNextRetry;
                                    httpRequest = httpRequestCreateHttpRequest;
                                    signerByURI = signer;
                                    i = i2;
                                    linkedHashMap2 = linkedHashMap;
                                } catch (Throwable th8) {
                                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestSigningTime);
                                    throw th8;
                                }
                            } catch (IOException e9) {
                                e = e9;
                                jPauseBeforeNextRetry = j2;
                                signer = signer;
                                str = str7;
                                linkedHashMap = linkedHashMap2;
                                str2 = str;
                                log2 = log;
                                if (log2.isDebugEnabled()) {
                                    log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                }
                                MetricType metricType6 = AWSRequestMetrics.Field.Exception;
                                awsRequestMetrics.incrementCounter(metricType6);
                                awsRequestMetrics.addProperty(metricType6, e);
                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                    throw amazonClientException;
                                }
                                resetRequestAfterError(request, e);
                                if (!z2) {
                                    if (httpResponse.getRawContent() != null) {
                                        httpResponse.getRawContent().close();
                                    }
                                }
                                z = z2;
                                j = jPauseBeforeNextRetry;
                                httpResponse3 = httpResponse;
                                amazonClientException3 = amazonClientException;
                                signerByURI = signer;
                                i = i2;
                                linkedHashMap2 = linkedHashMap;
                            }
                            throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                        }
                        log3 = REQUEST_LOG;
                        if (log3.isDebugEnabled()) {
                            log3.debug("Sending Request: " + request.toString());
                        }
                        httpRequestCreateHttpRequest = this.requestFactory.createHttpRequest(request, this.config, executionContext);
                        try {
                            MetricType metricType7 = AWSRequestMetrics.Field.HttpRequestTime;
                            awsRequestMetrics.startEvent(metricType7);
                            try {
                                httpResponseExecute = this.httpClient.execute(httpRequestCreateHttpRequest);
                                try {
                                    try {
                                        awsRequestMetrics.endEvent(metricType7);
                                        if (isRequestSuccessful(httpResponseExecute)) {
                                            try {
                                                try {
                                                    jPauseBeforeNextRetry = j2;
                                                    try {
                                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(httpResponseExecute.getStatusCode()));
                                                        zNeedsConnectionLeftOpen2 = httpResponseHandler.needsConnectionLeftOpen();
                                                        try {
                                                            Response response2 = new Response(handleResponse(request, httpResponseHandler, httpResponseExecute, executionContext), httpResponseExecute);
                                                            if (!zNeedsConnectionLeftOpen2) {
                                                                try {
                                                                    if (httpResponseExecute.getRawContent() != null) {
                                                                        httpResponseExecute.getRawContent().close();
                                                                    }
                                                                } catch (IOException e10) {
                                                                    log.warn("Cannot close the response content.", e10);
                                                                }
                                                            }
                                                            return response2;
                                                        } catch (IOException e11) {
                                                            e = e11;
                                                            z2 = zNeedsConnectionLeftOpen2;
                                                            httpResponse = httpResponseExecute;
                                                            httpRequest = httpRequestCreateHttpRequest;
                                                            signer = signer;
                                                            str = str7;
                                                            linkedHashMap = linkedHashMap2;
                                                            str2 = str;
                                                            log2 = log;
                                                            if (log2.isDebugEnabled()) {
                                                                log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                                            }
                                                            MetricType metricType8 = AWSRequestMetrics.Field.Exception;
                                                            awsRequestMetrics.incrementCounter(metricType8);
                                                            awsRequestMetrics.addProperty(metricType8, e);
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                            amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                            if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                                                throw amazonClientException;
                                                            }
                                                            resetRequestAfterError(request, e);
                                                            if (!z2) {
                                                                if (httpResponse.getRawContent() != null) {
                                                                    httpResponse.getRawContent().close();
                                                                }
                                                            }
                                                            z = z2;
                                                            j = jPauseBeforeNextRetry;
                                                            httpResponse3 = httpResponse;
                                                            amazonClientException3 = amazonClientException;
                                                            signerByURI = signer;
                                                            i = i2;
                                                            linkedHashMap2 = linkedHashMap;
                                                        } catch (Error e12) {
                                                            e = e12;
                                                        } catch (RuntimeException e13) {
                                                            e = e13;
                                                            throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            executionContext2 = "Cannot close the response content.";
                                                            httpResponse3 = httpResponseExecute;
                                                        }
                                                    } catch (IOException e14) {
                                                        e = e14;
                                                    }
                                                } catch (Error e15) {
                                                    e = e15;
                                                } catch (RuntimeException e16) {
                                                    e = e16;
                                                    throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                                } catch (Throwable th10) {
                                                    th = th10;
                                                    obj = "Cannot close the response content.";
                                                    httpResponse3 = httpResponseExecute;
                                                    zNeedsConnectionLeftOpen2 = z2;
                                                    executionContext2 = obj;
                                                }
                                            } catch (IOException e17) {
                                                e = e17;
                                                jPauseBeforeNextRetry = j2;
                                            }
                                        } else {
                                            jPauseBeforeNextRetry = j2;
                                            try {
                                                if (isTemporaryRedirect(httpResponseExecute)) {
                                                    try {
                                                        String str9 = httpResponseExecute.getHeaders().get("Location");
                                                        Log log5 = log;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        str5 = "Cannot close the response content.";
                                                        try {
                                                            sb2.append("Redirecting to: ");
                                                            sb2.append(str9);
                                                            log5.debug(sb2.toString());
                                                            uriCreate = URI.create(str9);
                                                            request.setEndpoint(null);
                                                            request.setResourcePath(null);
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(httpResponseExecute.getStatusCode()));
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.RedirectLocation, str9);
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                            httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                                                            signer = signer;
                                                            z = z2;
                                                            str6 = str5;
                                                            amazonClientException2 = null;
                                                            linkedHashMap = linkedHashMap2;
                                                            httpResponse2 = httpResponseExecute;
                                                        } catch (IOException e18) {
                                                            e = e18;
                                                            httpResponse = httpResponseExecute;
                                                            httpRequest = httpRequestCreateHttpRequest;
                                                            signer = signer;
                                                            str = str5;
                                                            linkedHashMap = linkedHashMap2;
                                                            str2 = str;
                                                            log2 = log;
                                                            if (log2.isDebugEnabled()) {
                                                                log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                                            }
                                                            MetricType metricType9 = AWSRequestMetrics.Field.Exception;
                                                            awsRequestMetrics.incrementCounter(metricType9);
                                                            awsRequestMetrics.addProperty(metricType9, e);
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                            amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                            if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                                                throw amazonClientException;
                                                            }
                                                            resetRequestAfterError(request, e);
                                                            if (!z2) {
                                                                if (httpResponse.getRawContent() != null) {
                                                                    httpResponse.getRawContent().close();
                                                                }
                                                            }
                                                            z = z2;
                                                            j = jPauseBeforeNextRetry;
                                                            httpResponse3 = httpResponse;
                                                            amazonClientException3 = amazonClientException;
                                                            signerByURI = signer;
                                                        } catch (Error e19) {
                                                            e = e19;
                                                            throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                                        } catch (RuntimeException e20) {
                                                            e = e20;
                                                            throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                                        } catch (Throwable th11) {
                                                            th = th11;
                                                            th = th;
                                                            httpResponse3 = httpResponseExecute;
                                                            zNeedsConnectionLeftOpen2 = z2;
                                                            executionContext2 = str5;
                                                            if (zNeedsConnectionLeftOpen2) {
                                                                throw th;
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (IOException e21) {
                                                        e = e21;
                                                        str5 = "Cannot close the response content.";
                                                    } catch (Error e22) {
                                                        e = e22;
                                                        str5 = "Cannot close the response content.";
                                                    } catch (RuntimeException e23) {
                                                        e = e23;
                                                        str5 = "Cannot close the response content.";
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        str5 = "Cannot close the response content.";
                                                    }
                                                } else {
                                                    try {
                                                        zNeedsConnectionLeftOpen = httpResponseHandler2.needsConnectionLeftOpen();
                                                        try {
                                                            amazonServiceExceptionHandleErrorResponse = handleErrorResponse(request, httpResponseHandler2, httpResponseExecute);
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, amazonServiceExceptionHandleErrorResponse.getRequestId());
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSErrorCode, amazonServiceExceptionHandleErrorResponse.getErrorCode());
                                                            awsRequestMetrics.addProperty(AWSRequestMetrics.Field.StatusCode, Integer.valueOf(amazonServiceExceptionHandleErrorResponse.getStatusCode()));
                                                            str4 = "Cannot close the response content.";
                                                            linkedHashMap = linkedHashMap2;
                                                            httpResponse2 = httpResponseExecute;
                                                            httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                                                            signer = signer;
                                                            try {
                                                                if (shouldRetry(request.getOriginalRequest(), httpRequestCreateHttpRequest.getContent(), amazonServiceExceptionHandleErrorResponse, i2, this.config.getRetryPolicy())) {
                                                                    throw amazonServiceExceptionHandleErrorResponse;
                                                                }
                                                                if (RetryUtils.isClockSkewError(amazonServiceExceptionHandleErrorResponse)) {
                                                                    SDKGlobalConfiguration.setGlobalTimeOffset(parseClockSkewOffset(httpResponse2, amazonServiceExceptionHandleErrorResponse));
                                                                }
                                                                resetRequestAfterError(request, amazonServiceExceptionHandleErrorResponse);
                                                                amazonClientException2 = amazonServiceExceptionHandleErrorResponse;
                                                                z = zNeedsConnectionLeftOpen;
                                                                str6 = str4;
                                                            } catch (IOException e24) {
                                                                e = e24;
                                                                httpResponse = httpResponse2;
                                                                z2 = zNeedsConnectionLeftOpen;
                                                                httpRequest = httpRequestCreateHttpRequest;
                                                                str2 = str4;
                                                                log2 = log;
                                                                if (log2.isDebugEnabled()) {
                                                                    log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                                                }
                                                                MetricType metricType10 = AWSRequestMetrics.Field.Exception;
                                                                awsRequestMetrics.incrementCounter(metricType10);
                                                                awsRequestMetrics.addProperty(metricType10, e);
                                                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                                if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                                                    throw amazonClientException;
                                                                }
                                                                resetRequestAfterError(request, e);
                                                                if (!z2) {
                                                                    if (httpResponse.getRawContent() != null) {
                                                                        httpResponse.getRawContent().close();
                                                                    }
                                                                }
                                                                z = z2;
                                                                j = jPauseBeforeNextRetry;
                                                                httpResponse3 = httpResponse;
                                                                amazonClientException3 = amazonClientException;
                                                                signerByURI = signer;
                                                            } catch (Error e25) {
                                                                e = e25;
                                                                throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                                            } catch (RuntimeException e26) {
                                                                e = e26;
                                                                throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                                            } catch (Throwable th13) {
                                                                th = th13;
                                                                th = th;
                                                                httpResponse3 = httpResponse2;
                                                                zNeedsConnectionLeftOpen2 = zNeedsConnectionLeftOpen;
                                                                executionContext2 = str4;
                                                                if (zNeedsConnectionLeftOpen2) {
                                                                    throw th;
                                                                }
                                                                throw th;
                                                            }
                                                        } catch (IOException e27) {
                                                            e = e27;
                                                            httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                                                            signer = signer;
                                                            str4 = "Cannot close the response content.";
                                                            linkedHashMap = linkedHashMap2;
                                                            httpResponse2 = httpResponseExecute;
                                                        } catch (Error e28) {
                                                            e = e28;
                                                            httpResponse2 = httpResponseExecute;
                                                        } catch (RuntimeException e29) {
                                                            e = e29;
                                                            httpResponse2 = httpResponseExecute;
                                                        } catch (Throwable th14) {
                                                            th = th14;
                                                            httpResponse2 = httpResponseExecute;
                                                            str4 = "Cannot close the response content.";
                                                        }
                                                    } catch (IOException e30) {
                                                        e = e30;
                                                        str4 = "Cannot close the response content.";
                                                        linkedHashMap = linkedHashMap2;
                                                        httpResponse = httpResponseExecute;
                                                        httpRequest = httpRequestCreateHttpRequest;
                                                        str2 = str4;
                                                        log2 = log;
                                                        if (log2.isDebugEnabled()) {
                                                            log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                                        }
                                                        MetricType metricType11 = AWSRequestMetrics.Field.Exception;
                                                        awsRequestMetrics.incrementCounter(metricType11);
                                                        awsRequestMetrics.addProperty(metricType11, e);
                                                        awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                        amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                        if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                                            throw amazonClientException;
                                                        }
                                                        resetRequestAfterError(request, e);
                                                        if (!z2) {
                                                            if (httpResponse.getRawContent() != null) {
                                                                httpResponse.getRawContent().close();
                                                            }
                                                        }
                                                        z = z2;
                                                        j = jPauseBeforeNextRetry;
                                                        httpResponse3 = httpResponse;
                                                        amazonClientException3 = amazonClientException;
                                                        signerByURI = signer;
                                                        i = i2;
                                                        linkedHashMap2 = linkedHashMap;
                                                    } catch (Error e31) {
                                                        e = e31;
                                                    } catch (RuntimeException e32) {
                                                        e = e32;
                                                        throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                                    } catch (Throwable th15) {
                                                        th = th15;
                                                        obj2 = "Cannot close the response content.";
                                                        th = th;
                                                        httpResponse3 = httpResponseExecute;
                                                        obj = obj2;
                                                        zNeedsConnectionLeftOpen2 = z2;
                                                        executionContext2 = obj;
                                                    }
                                                }
                                                if (!z && httpResponse2 != null) {
                                                    try {
                                                        if (httpResponse2.getRawContent() != null) {
                                                            httpResponse2.getRawContent().close();
                                                        }
                                                    } catch (IOException e33) {
                                                        log.warn(str6, e33);
                                                    }
                                                }
                                                amazonClientException3 = amazonClientException2;
                                                httpResponse3 = httpResponse2;
                                                j = jPauseBeforeNextRetry;
                                                httpRequest = httpRequestCreateHttpRequest;
                                                signerByURI = signer;
                                            } catch (IOException e34) {
                                                e = e34;
                                                str4 = "Cannot close the response content.";
                                                linkedHashMap = linkedHashMap2;
                                                httpResponse = httpResponseExecute;
                                                httpRequest = httpRequestCreateHttpRequest;
                                                str2 = str4;
                                                log2 = log;
                                                if (log2.isDebugEnabled()) {
                                                    log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                                }
                                                MetricType metricType12 = AWSRequestMetrics.Field.Exception;
                                                awsRequestMetrics.incrementCounter(metricType12);
                                                awsRequestMetrics.addProperty(metricType12, e);
                                                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                                amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                                if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                                    throw amazonClientException;
                                                }
                                                resetRequestAfterError(request, e);
                                                if (!z2) {
                                                    if (httpResponse.getRawContent() != null) {
                                                        httpResponse.getRawContent().close();
                                                    }
                                                }
                                                z = z2;
                                                j = jPauseBeforeNextRetry;
                                                httpResponse3 = httpResponse;
                                                amazonClientException3 = amazonClientException;
                                                signerByURI = signer;
                                                i = i2;
                                                linkedHashMap2 = linkedHashMap;
                                            }
                                            i = i2;
                                            linkedHashMap2 = linkedHashMap;
                                        }
                                    } catch (Error e35) {
                                        e = e35;
                                    } catch (RuntimeException e36) {
                                        e = e36;
                                    } catch (Throwable th16) {
                                        th = th16;
                                        obj2 = "Cannot close the response content.";
                                    }
                                } catch (IOException e37) {
                                    e = e37;
                                    jPauseBeforeNextRetry = j2;
                                }
                            } catch (Throwable th17) {
                                jPauseBeforeNextRetry = j2;
                                str4 = "Cannot close the response content.";
                                httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                                signer = signer;
                                linkedHashMap = linkedHashMap2;
                                try {
                                    awsRequestMetrics.endEvent(AWSRequestMetrics.Field.HttpRequestTime);
                                    throw th17;
                                } catch (IOException e38) {
                                    e = e38;
                                    httpRequest = httpRequestCreateHttpRequest;
                                    str2 = str4;
                                    log2 = log;
                                    if (log2.isDebugEnabled()) {
                                        log2.debug("Unable to execute HTTP request: " + e.getMessage(), e);
                                    }
                                    MetricType metricType13 = AWSRequestMetrics.Field.Exception;
                                    awsRequestMetrics.incrementCounter(metricType13);
                                    awsRequestMetrics.addProperty(metricType13, e);
                                    awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, (Object) null);
                                    amazonClientException = new AmazonClientException("Unable to execute HTTP request: " + e.getMessage(), e);
                                    if (!shouldRetry(request.getOriginalRequest(), httpRequest.getContent(), amazonClientException, i2, this.config.getRetryPolicy())) {
                                        throw amazonClientException;
                                    }
                                    resetRequestAfterError(request, e);
                                    if (!z2) {
                                        if (httpResponse.getRawContent() != null) {
                                            httpResponse.getRawContent().close();
                                        }
                                    }
                                    z = z2;
                                    j = jPauseBeforeNextRetry;
                                    httpResponse3 = httpResponse;
                                    amazonClientException3 = amazonClientException;
                                    signerByURI = signer;
                                    i = i2;
                                    linkedHashMap2 = linkedHashMap;
                                } catch (Error e39) {
                                    e = e39;
                                    throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                                } catch (RuntimeException e40) {
                                    e = e40;
                                    throw ((RuntimeException) handleUnexpectedFailure(e, awsRequestMetrics));
                                }
                            }
                        } catch (IOException e41) {
                            e = e41;
                            jPauseBeforeNextRetry = j2;
                            str4 = "Cannot close the response content.";
                            httpRequestCreateHttpRequest = httpRequestCreateHttpRequest;
                            signer = signer;
                            linkedHashMap = linkedHashMap2;
                        }
                        throw ((Error) handleUnexpectedFailure(e, awsRequestMetrics));
                    } catch (IOException e42) {
                        e = e42;
                        jPauseBeforeNextRetry = j2;
                        str2 = "Cannot close the response content.";
                        linkedHashMap = linkedHashMap2;
                        signer = signerByURI;
                    }
                } catch (Throwable th18) {
                    th2 = th18;
                    str2 = "Cannot close the response content.";
                    th = th2;
                    str3 = str2;
                    zNeedsConnectionLeftOpen2 = z2;
                    httpResponse3 = httpResponse;
                    executionContext2 = str3;
                }
            } catch (Throwable th19) {
                th = th19;
                executionContext2 = executionContext;
            }
            if (zNeedsConnectionLeftOpen2 || httpResponse3 == null) {
                throw th;
            }
            try {
                if (httpResponse3.getRawContent() == null) {
                    throw th;
                }
                httpResponse3.getRawContent().close();
                throw th;
            } catch (IOException e43) {
                log.warn(executionContext2, e43);
                throw th;
            }
        }
    }

    private Throwable handleUnexpectedFailure(Throwable th, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.incrementCounter(field);
        aWSRequestMetrics.addProperty(field, th);
        return th;
    }

    void resetRequestAfterError(Request request, Exception exc) {
        if (request.getContent() == null) {
            return;
        }
        if (!request.getContent().markSupported()) {
            throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
        }
        try {
            request.getContent().reset();
        } catch (IOException unused) {
            throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
        }
    }

    void setUserAgent(Request request) {
        RequestClientOptions requestClientOptions;
        String clientMarker;
        String str = ClientConfiguration.DEFAULT_USER_AGENT;
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        String strCreateUserAgentString = (originalRequest == null || (requestClientOptions = originalRequest.getRequestClientOptions()) == null || (clientMarker = requestClientOptions.getClientMarker(RequestClientOptions.Marker.USER_AGENT)) == null) ? str : createUserAgentString(str, clientMarker);
        if (!str.equals(this.config.getUserAgent())) {
            strCreateUserAgentString = createUserAgentString(strCreateUserAgentString, this.config.getUserAgent());
        }
        if (this.config.getUserAgentOverride() != null) {
            strCreateUserAgentString = this.config.getUserAgentOverride();
        }
        request.addHeader("User-Agent", strCreateUserAgentString);
    }

    static String createUserAgentString(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    public void shutdown() {
        this.httpClient.shutdown();
    }

    private boolean shouldRetry(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 1;
        int maxErrorRetry = this.config.getMaxErrorRetry();
        if (maxErrorRetry < 0 || !retryPolicy.isMaxErrorRetryInClientConfigHonored()) {
            maxErrorRetry = retryPolicy.getMaxErrorRetry();
        }
        if (i2 >= maxErrorRetry) {
            return false;
        }
        if (inputStream != null && !inputStream.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Content not repeatable");
            }
            return false;
        }
        return retryPolicy.getRetryCondition().shouldRetry(amazonWebServiceRequest, amazonClientException, i2);
    }

    private static boolean isTemporaryRedirect(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        String str = httpResponse.getHeaders().get("Location");
        return (statusCode != 307 || str == null || str.isEmpty()) ? false : true;
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusCode();
        return statusCode >= 200 && statusCode < 300;
    }

    Object handleResponse(Request request, HttpResponseHandler httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        try {
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            awsRequestMetrics.startEvent(field);
            try {
                AmazonWebServiceResponse amazonWebServiceResponse = (AmazonWebServiceResponse) httpResponseHandler.handle(httpResponse);
                awsRequestMetrics.endEvent(field);
                if (amazonWebServiceResponse == null) {
                    throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText());
                }
                Log log2 = REQUEST_LOG;
                if (log2.isDebugEnabled()) {
                    log2.debug("Received successful response: " + httpResponse.getStatusCode() + ", AWS Request ID: " + amazonWebServiceResponse.getRequestId());
                }
                awsRequestMetrics.addProperty(AWSRequestMetrics.Field.AWSRequestID, amazonWebServiceResponse.getRequestId());
                return amazonWebServiceResponse.getResult();
            } catch (Throwable th) {
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
                throw th;
            }
        } catch (CRC32MismatchException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new AmazonClientException("Unable to unmarshall response (" + e3.getMessage() + "). Response Code: " + httpResponse.getStatusCode() + ", Response Text: " + httpResponse.getStatusText(), e3);
        }
    }

    AmazonServiceException handleErrorResponse(Request request, HttpResponseHandler httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusCode();
        try {
            amazonServiceException = (AmazonServiceException) httpResponseHandler.handle(httpResponse);
            REQUEST_LOG.debug("Received error response: " + amazonServiceException.toString());
        } catch (Exception e) {
            if (statusCode == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(413);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == 503 && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusText())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(TypedValues.PositionType.TYPE_PERCENT_WIDTH);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else {
                if (e instanceof IOException) {
                    throw ((IOException) e);
                }
                throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + "). Response Code: " + statusCode + ", Response Text: " + httpResponse.getStatusText() + ", Response Headers: " + httpResponse.getHeaders(), e);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    private long pauseBeforeNextRetry(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i, RetryPolicy retryPolicy) {
        int i2 = i - 2;
        long jDelayBeforeNextRetry = retryPolicy.getBackoffStrategy().delayBeforeNextRetry(amazonWebServiceRequest, amazonClientException, i2);
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Retriable error detected, will retry in " + jDelayBeforeNextRetry + "ms, attempt number: " + i2);
        }
        try {
            Thread.sleep(jDelayBeforeNextRetry);
            return jDelayBeforeNextRetry;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    private String getServerDateFromException(String str) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf("(");
        if (str.contains(" + 15")) {
            iIndexOf = str.indexOf(" + 15");
        } else {
            iIndexOf = str.indexOf(" - 15");
        }
        return str.substring(iIndexOf2 + 1, iIndexOf);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025 A[Catch: RuntimeException -> 0x0022, TRY_ENTER, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0022, blocks: (B:4:0x0014, B:13:0x0025), top: B:19:0x0014 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [long] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    int parseClockSkewOffset(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date rFC822Date;
        Date date = new Date();
        String time = httpResponse.getHeaders().get("Date");
        try {
            if (time != 0) {
                try {
                    if (time.isEmpty()) {
                        rFC822Date = DateUtils.parseCompressedISO8601Date(getServerDateFromException(amazonServiceException.getMessage()));
                    } else {
                        rFC822Date = DateUtils.parseRFC822Date(time);
                    }
                } catch (RuntimeException e) {
                    e = e;
                    time = 0;
                    log.warn("Unable to parse clock skew offset from response: " + time, e);
                    return 0;
                }
            } else {
                rFC822Date = DateUtils.parseCompressedISO8601Date(getServerDateFromException(amazonServiceException.getMessage()));
            }
            time = (date.getTime() - rFC822Date.getTime()) / 1000;
            return (int) time;
        } catch (RuntimeException e2) {
            e = e2;
        }
    }

    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public RequestMetricCollector getRequestMetricCollector() {
        return this.requestMetricCollector;
    }
}
