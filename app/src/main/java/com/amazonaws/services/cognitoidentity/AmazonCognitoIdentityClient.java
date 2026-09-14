package com.amazonaws.services.cognitoidentity;

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
import com.amazonaws.http.ExecutionContext;
import com.amazonaws.http.HttpClient;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.http.JsonErrorResponseHandler;
import com.amazonaws.http.JsonResponseHandler;
import com.amazonaws.http.UrlHttpClient;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.CreateIdentityPoolResult;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesRequest;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentitiesResult;
import com.amazonaws.services.cognitoidentity.model.DeleteIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityPoolResult;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.DescribeIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetCredentialsForIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdentityPoolRolesResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenForDeveloperIdentityResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import com.amazonaws.services.cognitoidentity.model.ListIdentitiesRequest;
import com.amazonaws.services.cognitoidentity.model.ListIdentitiesResult;
import com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsRequest;
import com.amazonaws.services.cognitoidentity.model.ListIdentityPoolsResult;
import com.amazonaws.services.cognitoidentity.model.ListTagsForResourceRequest;
import com.amazonaws.services.cognitoidentity.model.ListTagsForResourceResult;
import com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.LookupDeveloperIdentityResult;
import com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesRequest;
import com.amazonaws.services.cognitoidentity.model.MergeDeveloperIdentitiesResult;
import com.amazonaws.services.cognitoidentity.model.SetIdentityPoolRolesRequest;
import com.amazonaws.services.cognitoidentity.model.TagResourceRequest;
import com.amazonaws.services.cognitoidentity.model.TagResourceResult;
import com.amazonaws.services.cognitoidentity.model.UnlinkDeveloperIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.UnlinkIdentityRequest;
import com.amazonaws.services.cognitoidentity.model.UntagResourceRequest;
import com.amazonaws.services.cognitoidentity.model.UntagResourceResult;
import com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolRequest;
import com.amazonaws.services.cognitoidentity.model.UpdateIdentityPoolResult;
import com.amazonaws.services.cognitoidentity.model.transform.ConcurrentModificationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.CreateIdentityPoolResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentitiesRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentitiesResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeleteIdentityPoolRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityPoolRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityPoolResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DescribeIdentityResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.DeveloperUserAlreadyRegisteredExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ExternalServiceExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetCredentialsForIdentityResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetIdRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetIdResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetIdentityPoolRolesRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetIdentityPoolRolesResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenForDeveloperIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenForDeveloperIdentityResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.GetOpenIdTokenResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InternalErrorExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidIdentityPoolConfigurationExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.InvalidParameterExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.LimitExceededExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ListIdentitiesRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ListIdentitiesResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ListIdentityPoolsRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ListIdentityPoolsResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ListTagsForResourceRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ListTagsForResourceResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.LookupDeveloperIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.LookupDeveloperIdentityResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.MergeDeveloperIdentitiesRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.MergeDeveloperIdentitiesResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.NotAuthorizedExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceConflictExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.ResourceNotFoundExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.SetIdentityPoolRolesRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.TagResourceRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.TagResourceResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.TooManyRequestsExceptionUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UnlinkDeveloperIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UnlinkIdentityRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UntagResourceRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UntagResourceResultJsonUnmarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UpdateIdentityPoolRequestMarshaller;
import com.amazonaws.services.cognitoidentity.model.transform.UpdateIdentityPoolResultJsonUnmarshaller;
import com.amazonaws.transform.JsonErrorUnmarshaller;
import com.amazonaws.util.AWSRequestMetrics;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AmazonCognitoIdentityClient extends AmazonWebServiceClient implements AmazonCognitoIdentity {
    private AWSCredentialsProvider awsCredentialsProvider;
    protected List<JsonErrorUnmarshaller> jsonErrorUnmarshallers;

    private static ClientConfiguration adjustClientConfiguration(ClientConfiguration clientConfiguration) {
        return clientConfiguration;
    }

    @Deprecated
    public AmazonCognitoIdentityClient() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    @Deprecated
    public AmazonCognitoIdentityClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    public AmazonCognitoIdentityClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, new ClientConfiguration());
    }

    public AmazonCognitoIdentityClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration) {
        this(new StaticCredentialsProvider(aWSCredentials), clientConfiguration);
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, new ClientConfiguration());
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(aWSCredentialsProvider, clientConfiguration, new UrlHttpClient(clientConfiguration));
    }

    @Deprecated
    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, RequestMetricCollector requestMetricCollector) {
        super(adjustClientConfiguration(clientConfiguration), requestMetricCollector);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    public AmazonCognitoIdentityClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, HttpClient httpClient) {
        super(adjustClientConfiguration(clientConfiguration), httpClient);
        this.awsCredentialsProvider = aWSCredentialsProvider;
        init();
    }

    private void init() {
        ArrayList arrayList = new ArrayList();
        this.jsonErrorUnmarshallers = arrayList;
        arrayList.add(new ConcurrentModificationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new DeveloperUserAlreadyRegisteredExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ExternalServiceExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InternalErrorExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidIdentityPoolConfigurationExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new InvalidParameterExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new LimitExceededExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new NotAuthorizedExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceConflictExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new ResourceNotFoundExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new TooManyRequestsExceptionUnmarshaller());
        this.jsonErrorUnmarshallers.add(new JsonErrorUnmarshaller());
        setEndpoint("cognito-identity.us-east-1.amazonaws.com");
        this.endpointPrefix = "cognito-identity";
        HandlerChainFactory handlerChainFactory = new HandlerChainFactory();
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandlerChain("/com/amazonaws/services/cognitoidentity/request.handlers"));
        this.requestHandler2s.addAll(handlerChainFactory.newRequestHandler2Chain("/com/amazonaws/services/cognitoidentity/request.handler2s"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public CreateIdentityPoolResult createIdentityPool(CreateIdentityPoolRequest createIdentityPoolRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(createIdentityPoolRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<CreateIdentityPoolRequest> requestMarshall = new CreateIdentityPoolRequestMarshaller().marshall(createIdentityPoolRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new CreateIdentityPoolResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        CreateIdentityPoolResult createIdentityPoolResult = (CreateIdentityPoolResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return createIdentityPoolResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = createIdentityPoolRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public DeleteIdentitiesResult deleteIdentities(DeleteIdentitiesRequest deleteIdentitiesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteIdentitiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<DeleteIdentitiesRequest> requestMarshall = new DeleteIdentitiesRequestMarshaller().marshall(deleteIdentitiesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DeleteIdentitiesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DeleteIdentitiesResult deleteIdentitiesResult = (DeleteIdentitiesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return deleteIdentitiesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = deleteIdentitiesRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.DeleteIdentityPoolRequest] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public void deleteIdentityPool(DeleteIdentityPoolRequest deleteIdentityPoolRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(deleteIdentityPoolRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<DeleteIdentityPoolRequest> requestMarshall = new DeleteIdentityPoolRequestMarshaller().marshall((DeleteIdentityPoolRequest) deleteIdentityPoolRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                deleteIdentityPoolRequest = 0;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, deleteIdentityPoolRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, deleteIdentityPoolRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public DescribeIdentityResult describeIdentity(DescribeIdentityRequest describeIdentityRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<DescribeIdentityRequest> requestMarshall = new DescribeIdentityRequestMarshaller().marshall(describeIdentityRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeIdentityResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeIdentityResult describeIdentityResult = (DescribeIdentityResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeIdentityResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = describeIdentityRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public DescribeIdentityPoolResult describeIdentityPool(DescribeIdentityPoolRequest describeIdentityPoolRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(describeIdentityPoolRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<DescribeIdentityPoolRequest> requestMarshall = new DescribeIdentityPoolRequestMarshaller().marshall(describeIdentityPoolRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new DescribeIdentityPoolResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        DescribeIdentityPoolResult describeIdentityPoolResult = (DescribeIdentityPoolResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return describeIdentityPoolResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = describeIdentityPoolRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetCredentialsForIdentityResult getCredentialsForIdentity(GetCredentialsForIdentityRequest getCredentialsForIdentityRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getCredentialsForIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<GetCredentialsForIdentityRequest> requestMarshall = new GetCredentialsForIdentityRequestMarshaller().marshall(getCredentialsForIdentityRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetCredentialsForIdentityResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetCredentialsForIdentityResult getCredentialsForIdentityResult = (GetCredentialsForIdentityResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getCredentialsForIdentityResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = getCredentialsForIdentityRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetIdResult getId(GetIdRequest getIdRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getIdRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<GetIdRequest> requestMarshall = new GetIdRequestMarshaller().marshall(getIdRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetIdResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetIdResult getIdResult = (GetIdResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getIdResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = getIdRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetIdentityPoolRolesResult getIdentityPoolRoles(GetIdentityPoolRolesRequest getIdentityPoolRolesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getIdentityPoolRolesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<GetIdentityPoolRolesRequest> requestMarshall = new GetIdentityPoolRolesRequestMarshaller().marshall(getIdentityPoolRolesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetIdentityPoolRolesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetIdentityPoolRolesResult getIdentityPoolRolesResult = (GetIdentityPoolRolesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getIdentityPoolRolesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = getIdentityPoolRolesRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetOpenIdTokenResult getOpenIdToken(GetOpenIdTokenRequest getOpenIdTokenRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getOpenIdTokenRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<GetOpenIdTokenRequest> requestMarshall = new GetOpenIdTokenRequestMarshaller().marshall(getOpenIdTokenRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetOpenIdTokenResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetOpenIdTokenResult getOpenIdTokenResult = (GetOpenIdTokenResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getOpenIdTokenResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = getOpenIdTokenRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public GetOpenIdTokenForDeveloperIdentityResult getOpenIdTokenForDeveloperIdentity(GetOpenIdTokenForDeveloperIdentityRequest getOpenIdTokenForDeveloperIdentityRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(getOpenIdTokenForDeveloperIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<GetOpenIdTokenForDeveloperIdentityRequest> requestMarshall = new GetOpenIdTokenForDeveloperIdentityRequestMarshaller().marshall(getOpenIdTokenForDeveloperIdentityRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new GetOpenIdTokenForDeveloperIdentityResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        GetOpenIdTokenForDeveloperIdentityResult getOpenIdTokenForDeveloperIdentityResult = (GetOpenIdTokenForDeveloperIdentityResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return getOpenIdTokenForDeveloperIdentityResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = getOpenIdTokenForDeveloperIdentityRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public ListIdentitiesResult listIdentities(ListIdentitiesRequest listIdentitiesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listIdentitiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<ListIdentitiesRequest> requestMarshall = new ListIdentitiesRequestMarshaller().marshall(listIdentitiesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListIdentitiesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListIdentitiesResult listIdentitiesResult = (ListIdentitiesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listIdentitiesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = listIdentitiesRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public ListIdentityPoolsResult listIdentityPools(ListIdentityPoolsRequest listIdentityPoolsRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listIdentityPoolsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<ListIdentityPoolsRequest> requestMarshall = new ListIdentityPoolsRequestMarshaller().marshall(listIdentityPoolsRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListIdentityPoolsResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListIdentityPoolsResult listIdentityPoolsResult = (ListIdentityPoolsResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listIdentityPoolsResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = listIdentityPoolsRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest listTagsForResourceRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(listTagsForResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<ListTagsForResourceRequest> requestMarshall = new ListTagsForResourceRequestMarshaller().marshall(listTagsForResourceRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new ListTagsForResourceResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        ListTagsForResourceResult listTagsForResourceResult = (ListTagsForResourceResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return listTagsForResourceResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = listTagsForResourceRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public LookupDeveloperIdentityResult lookupDeveloperIdentity(LookupDeveloperIdentityRequest lookupDeveloperIdentityRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(lookupDeveloperIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<LookupDeveloperIdentityRequest> requestMarshall = new LookupDeveloperIdentityRequestMarshaller().marshall(lookupDeveloperIdentityRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new LookupDeveloperIdentityResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        LookupDeveloperIdentityResult lookupDeveloperIdentityResult = (LookupDeveloperIdentityResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return lookupDeveloperIdentityResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = lookupDeveloperIdentityRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public MergeDeveloperIdentitiesResult mergeDeveloperIdentities(MergeDeveloperIdentitiesRequest mergeDeveloperIdentitiesRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(mergeDeveloperIdentitiesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<MergeDeveloperIdentitiesRequest> requestMarshall = new MergeDeveloperIdentitiesRequestMarshaller().marshall(mergeDeveloperIdentitiesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new MergeDeveloperIdentitiesResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        MergeDeveloperIdentitiesResult mergeDeveloperIdentitiesResult = (MergeDeveloperIdentitiesResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return mergeDeveloperIdentitiesResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = mergeDeveloperIdentitiesRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.SetIdentityPoolRolesRequest] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public void setIdentityPoolRoles(SetIdentityPoolRolesRequest setIdentityPoolRolesRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(setIdentityPoolRolesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<SetIdentityPoolRolesRequest> requestMarshall = new SetIdentityPoolRolesRequestMarshaller().marshall((SetIdentityPoolRolesRequest) setIdentityPoolRolesRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                setIdentityPoolRolesRequest = 0;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, setIdentityPoolRolesRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, setIdentityPoolRolesRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public TagResourceResult tagResource(TagResourceRequest tagResourceRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(tagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<TagResourceRequest> requestMarshall = new TagResourceRequestMarshaller().marshall(tagResourceRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new TagResourceResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        TagResourceResult tagResourceResult = (TagResourceResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return tagResourceResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = tagResourceRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.UnlinkDeveloperIdentityRequest] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public void unlinkDeveloperIdentity(UnlinkDeveloperIdentityRequest unlinkDeveloperIdentityRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(unlinkDeveloperIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<UnlinkDeveloperIdentityRequest> requestMarshall = new UnlinkDeveloperIdentityRequestMarshaller().marshall((UnlinkDeveloperIdentityRequest) unlinkDeveloperIdentityRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                unlinkDeveloperIdentityRequest = 0;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, unlinkDeveloperIdentityRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, unlinkDeveloperIdentityRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceRequest, com.amazonaws.services.cognitoidentity.model.UnlinkIdentityRequest] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.amazonaws.Request] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public void unlinkIdentity(UnlinkIdentityRequest unlinkIdentityRequest) throws Throwable {
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(unlinkIdentityRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<UnlinkIdentityRequest> requestMarshall = new UnlinkIdentityRequestMarshaller().marshall((UnlinkIdentityRequest) unlinkIdentityRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        invoke(requestMarshall, new JsonResponseHandler(null), executionContextCreateExecutionContext);
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, null, true);
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                unlinkIdentityRequest = 0;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, unlinkIdentityRequest, null, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, unlinkIdentityRequest, null, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public UntagResourceResult untagResource(UntagResourceRequest untagResourceRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(untagResourceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<UntagResourceRequest> requestMarshall = new UntagResourceRequestMarshaller().marshall(untagResourceRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UntagResourceResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UntagResourceResult untagResourceResult = (UntagResourceResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return untagResourceResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = untagResourceRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.amazonaws.Request] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.amazonaws.AmazonWebServiceClient, com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient] */
    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    public UpdateIdentityPoolResult updateIdentityPool(UpdateIdentityPoolRequest updateIdentityPoolRequest) throws Throwable {
        Response response;
        ExecutionContext executionContextCreateExecutionContext = createExecutionContext(updateIdentityPoolRequest);
        AWSRequestMetrics awsRequestMetrics = executionContextCreateExecutionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ClientExecuteTime;
        awsRequestMetrics.startEvent(field);
        ?? r4 = 0;
        try {
            try {
                AWSRequestMetrics.Field field2 = AWSRequestMetrics.Field.RequestMarshallTime;
                awsRequestMetrics.startEvent(field2);
                try {
                    Request<UpdateIdentityPoolRequest> requestMarshall = new UpdateIdentityPoolRequestMarshaller().marshall(updateIdentityPoolRequest);
                    try {
                        requestMarshall.setAWSRequestMetrics(awsRequestMetrics);
                        awsRequestMetrics.endEvent(field2);
                        Response responseInvoke = invoke(requestMarshall, new JsonResponseHandler(new UpdateIdentityPoolResultJsonUnmarshaller()), executionContextCreateExecutionContext);
                        UpdateIdentityPoolResult updateIdentityPoolResult = (UpdateIdentityPoolResult) responseInvoke.getAwsResponse();
                        awsRequestMetrics.endEvent(field);
                        endClientExecution(awsRequestMetrics, requestMarshall, responseInvoke, true);
                        return updateIdentityPoolResult;
                    } catch (Throwable th) {
                        th = th;
                        awsRequestMetrics.endEvent(AWSRequestMetrics.Field.RequestMarshallTime);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                r4 = updateIdentityPoolRequest;
                response = null;
                awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
                endClientExecution(awsRequestMetrics, r4, response, true);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            response = null;
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.ClientExecuteTime);
            endClientExecution(awsRequestMetrics, r4, response, true);
            throw th;
        }
    }

    @Override // com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity
    @Deprecated
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.client.getResponseMetadataForRequest(amazonWebServiceRequest);
    }

    private Response invoke(Request request, HttpResponseHandler httpResponseHandler, ExecutionContext executionContext) {
        request.setEndpoint(this.endpoint);
        request.setTimeOffset(this.timeOffset);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.CredentialsRequestTime;
        awsRequestMetrics.startEvent(field);
        try {
            AWSCredentials credentials = this.awsCredentialsProvider.getCredentials();
            awsRequestMetrics.endEvent(field);
            AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
            if (originalRequest != null && originalRequest.getRequestCredentials() != null) {
                credentials = originalRequest.getRequestCredentials();
            }
            executionContext.setCredentials(credentials);
            return this.client.execute(request, httpResponseHandler, new JsonErrorResponseHandler(this.jsonErrorUnmarshallers), executionContext);
        } catch (Throwable th) {
            awsRequestMetrics.endEvent(AWSRequestMetrics.Field.CredentialsRequestTime);
            throw th;
        }
    }
}
