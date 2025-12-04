package com.amazonaws.services.securitytoken;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.HandlerChainFactory;
import com.amazonaws.http.DefaultErrorResponseHandler;
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.regions.ServiceAbbreviations;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.services.securitytoken.model.transform.AssumeRoleRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.AssumeRoleResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.DecodeAuthorizationMessageResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.ExpiredTokenExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetCallerIdentityResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetFederationTokenRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetFederationTokenResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetSessionTokenRequestMarshaller;
import com.amazonaws.services.securitytoken.model.transform.GetSessionTokenResultStaxUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.IDPCommunicationErrorExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.IDPRejectedClaimExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.InvalidAuthorizationMessageExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.InvalidIdentityTokenExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.MalformedPolicyDocumentExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.PackedPolicyTooLargeExceptionUnmarshaller;
import com.amazonaws.services.securitytoken.model.transform.RegionDisabledExceptionUnmarshaller;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

/* loaded from: classes2.dex */
public class AWSSecurityTokenServiceClient extends AmazonWebServiceClient implements AWSSecurityTokenService {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AWSSecurityTokenServiceClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AWSSecurityTokenServiceClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AWSSecurityTokenServiceClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AWSSecurityTokenServiceClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AWSSecurityTokenServiceClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.exceptionUnmarshallers = new ArrayList();
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        this.exceptionUnmarshallers.add(new ExpiredTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new IDPCommunicationErrorExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new IDPRejectedClaimExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidAuthorizationMessageExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new InvalidIdentityTokenExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new MalformedPolicyDocumentExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new PackedPolicyTooLargeExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new RegionDisabledExceptionUnmarshaller());
        this.exceptionUnmarshallers.add(new StandardErrorUnmarshaller());
        setEndpoint("sts.amazonaws.com");
        this.endpointPrefix = ServiceAbbreviations.STS;
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/securitytoken/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/securitytoken/request.handler2s"));
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public AssumeRoleResult assumeRole(AssumeRoleRequest assumeRoleRequest) throws Throwable {
        Response<?> response;
        Request<AssumeRoleRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(assumeRoleRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<AssumeRoleRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new AssumeRoleRequestMarshaller().marshall(assumeRoleRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new AssumeRoleResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            AssumeRoleResult assumeRoleResult = (AssumeRoleResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return assumeRoleResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public AssumeRoleWithSAMLResult assumeRoleWithSAML(AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest) throws Throwable {
        Response<?> response;
        Request<AssumeRoleWithSAMLRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(assumeRoleWithSAMLRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<AssumeRoleWithSAMLRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new AssumeRoleWithSAMLRequestMarshaller().marshall(assumeRoleWithSAMLRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new AssumeRoleWithSAMLResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            AssumeRoleWithSAMLResult assumeRoleWithSAMLResult = (AssumeRoleWithSAMLResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return assumeRoleWithSAMLResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequest assumeRoleWithWebIdentityRequest) throws Throwable {
        Response<?> response;
        Request<AssumeRoleWithWebIdentityRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(assumeRoleWithWebIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<AssumeRoleWithWebIdentityRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new AssumeRoleWithWebIdentityRequestMarshaller().marshall(assumeRoleWithWebIdentityRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new AssumeRoleWithWebIdentityResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentityResult = (AssumeRoleWithWebIdentityResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return assumeRoleWithWebIdentityResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public DecodeAuthorizationMessageResult decodeAuthorizationMessage(DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest) throws Throwable {
        Response<?> response;
        Request<DecodeAuthorizationMessageRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(decodeAuthorizationMessageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<DecodeAuthorizationMessageRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new DecodeAuthorizationMessageRequestMarshaller().marshall(decodeAuthorizationMessageRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new DecodeAuthorizationMessageResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            DecodeAuthorizationMessageResult decodeAuthorizationMessageResult = (DecodeAuthorizationMessageResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return decodeAuthorizationMessageResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public GetAccessKeyInfoResult getAccessKeyInfo(GetAccessKeyInfoRequest getAccessKeyInfoRequest) throws Throwable {
        Response<?> response;
        Request<GetAccessKeyInfoRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getAccessKeyInfoRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<GetAccessKeyInfoRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new GetAccessKeyInfoRequestMarshaller().marshall(getAccessKeyInfoRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new GetAccessKeyInfoResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            GetAccessKeyInfoResult getAccessKeyInfoResult = (GetAccessKeyInfoResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return getAccessKeyInfoResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public GetCallerIdentityResult getCallerIdentity(GetCallerIdentityRequest getCallerIdentityRequest) throws Throwable {
        Response<?> response;
        Request<GetCallerIdentityRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getCallerIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<GetCallerIdentityRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new GetCallerIdentityRequestMarshaller().marshall(getCallerIdentityRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new GetCallerIdentityResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            GetCallerIdentityResult getCallerIdentityResult = (GetCallerIdentityResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return getCallerIdentityResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public GetFederationTokenResult getFederationToken(GetFederationTokenRequest getFederationTokenRequest) throws Throwable {
        Response<?> response;
        Request<GetFederationTokenRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getFederationTokenRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<GetFederationTokenRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new GetFederationTokenRequestMarshaller().marshall(getFederationTokenRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new GetFederationTokenResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            GetFederationTokenResult getFederationTokenResult = (GetFederationTokenResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return getFederationTokenResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public GetSessionTokenResult getSessionToken(GetSessionTokenRequest getSessionTokenRequest) throws Throwable {
        Response<?> response;
        Request<GetSessionTokenRequest> requestMarshall2;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getSessionTokenRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        Request<GetSessionTokenRequest> request = null;
        Response<?> responseInvoke = null;
        try {
            requestMarshall2 = new GetSessionTokenRequestMarshaller().marshall(getSessionTokenRequest);
        } catch (Throwable th) {
            th = th;
            response = null;
        }
        try {
            requestMarshall2.setAWSRequestMetrics(awsRequestMetrics);
            responseInvoke = invoke(requestMarshall2, new GetSessionTokenResultStaxUnmarshaller(), executionContextCreateExecutionContext);
            GetSessionTokenResult getSessionTokenResult = (GetSessionTokenResult) responseInvoke.getAwsResponse();
            awsRequestMetrics.endEvent(field);
            endClientExecution(awsRequestMetrics, requestMarshall2, responseInvoke);
            return getSessionTokenResult;
        } catch (Throwable th2) {
            th = th2;
            Response<?> response2 = responseInvoke;
            request = requestMarshall2;
            response = response2;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, request, response);
            throw th;
        }
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public GetSessionTokenResult getSessionToken() throws AmazonClientException {
        return getSessionToken(new GetSessionTokenRequest());
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    public GetCallerIdentityResult getCallerIdentity() throws AmazonClientException {
        return getCallerIdentity(new GetCallerIdentityRequest());
    }

    @Override // com.amazonaws.services.securitytoken.AWSSecurityTokenService
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    private Response invoke(Request request, Unmarshaller unmarshaller, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }
        executionContext.setCredentials(credentials);
        return this.client.execute(request, new StaxResponseHandler(unmarshaller), new DefaultErrorResponseHandler(this.exceptionUnmarshallers), executionContext);
    }
}
