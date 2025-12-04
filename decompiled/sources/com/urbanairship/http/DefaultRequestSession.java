package com.urbanairship.http;

import android.util.Base64;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Provider;
import com.urbanairship.UAirship;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.util.Clock;
import com.urbanairship.util.DateUtils;
import com.urbanairship.util.PlatformUtils;
import com.urbanairship.util.UAStringUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u000201B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007B?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ*\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001f0#H\u0002J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010 \u001a\u00020!H\u0016J*\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u001f0%\"\u0004\b\u0000\u0010\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001f0#H\u0016J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0002R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/urbanairship/http/DefaultRequestSession;", "Lcom/urbanairship/http/RequestSession;", "configOptions", "Lcom/urbanairship/AirshipConfigOptions;", "platformProvider", "Lcom/urbanairship/Provider;", "", "(Lcom/urbanairship/AirshipConfigOptions;Lcom/urbanairship/Provider;)V", "httpClient", "Lcom/urbanairship/http/HttpClient;", "clock", "Lcom/urbanairship/util/Clock;", "nonceTokenFactory", "Lkotlin/Function0;", "", "(Lcom/urbanairship/AirshipConfigOptions;Lcom/urbanairship/Provider;Lcom/urbanairship/http/HttpClient;Lcom/urbanairship/util/Clock;Lkotlin/jvm/functions/Function0;)V", "channelAuthTokenProvider", "Lcom/urbanairship/http/AuthTokenProvider;", "getChannelAuthTokenProvider", "()Lcom/urbanairship/http/AuthTokenProvider;", "setChannelAuthTokenProvider", "(Lcom/urbanairship/http/AuthTokenProvider;)V", "contactAuthTokenProvider", "getContactAuthTokenProvider", "setContactAuthTokenProvider", "defaultHeaders", "", "getDefaultHeaders", "()Ljava/util/Map;", "doExecute", "Lcom/urbanairship/http/DefaultRequestSession$RequestResult;", ExifInterface.GPS_DIRECTION_TRUE, "request", "Lcom/urbanairship/http/Request;", "parser", "Lcom/urbanairship/http/ResponseParser;", "execute", "Lcom/urbanairship/http/Response;", "", "expireAuth", "auth", "Lcom/urbanairship/http/RequestAuth;", "token", "getToken", "identifier", "provider", "resolveAuth", "Lcom/urbanairship/http/DefaultRequestSession$ResolvedAuth;", "RequestResult", "ResolvedAuth", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class DefaultRequestSession implements RequestSession {
    private AuthTokenProvider channelAuthTokenProvider;
    private final Clock clock;
    private final AirshipConfigOptions configOptions;
    private AuthTokenProvider contactAuthTokenProvider;
    private final HttpClient httpClient;
    private final Function0 nonceTokenFactory;
    private final Provider platformProvider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultRequestSession(@NotNull AirshipConfigOptions configOptions, @NotNull Provider<Integer> platformProvider) {
        this(configOptions, platformProvider, new DefaultHttpClient(), null, null, 24, null);
        Intrinsics.checkNotNullParameter(configOptions, "configOptions");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DefaultRequestSession(AirshipConfigOptions airshipConfigOptions, Provider provider, HttpClient httpClient, Clock DEFAULT_CLOCK, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 8) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(airshipConfigOptions, provider, httpClient, DEFAULT_CLOCK, (i & 16) != 0 ? new Function0() { // from class: com.urbanairship.http.DefaultRequestSession.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        } : function0);
    }

    public DefaultRequestSession(@NotNull AirshipConfigOptions configOptions, @NotNull Provider<Integer> platformProvider, @NotNull HttpClient httpClient, @NotNull Clock clock, @NotNull Function0<String> nonceTokenFactory) {
        Intrinsics.checkNotNullParameter(configOptions, "configOptions");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(nonceTokenFactory, "nonceTokenFactory");
        this.configOptions = configOptions;
        this.platformProvider = platformProvider;
        this.httpClient = httpClient;
        this.nonceTokenFactory = nonceTokenFactory;
        this.clock = clock;
    }

    @Override // com.urbanairship.http.RequestSession
    @Nullable
    public AuthTokenProvider getChannelAuthTokenProvider() {
        return this.channelAuthTokenProvider;
    }

    @Override // com.urbanairship.http.RequestSession
    public void setChannelAuthTokenProvider(@Nullable AuthTokenProvider authTokenProvider) {
        this.channelAuthTokenProvider = authTokenProvider;
    }

    @Override // com.urbanairship.http.RequestSession
    @Nullable
    public AuthTokenProvider getContactAuthTokenProvider() {
        return this.contactAuthTokenProvider;
    }

    @Override // com.urbanairship.http.RequestSession
    public void setContactAuthTokenProvider(@Nullable AuthTokenProvider authTokenProvider) {
        this.contactAuthTokenProvider = authTokenProvider;
    }

    private final Map getDefaultHeaders() {
        return MapsKt.mapOf(TuplesKt.to("X-UA-App-Key", this.configOptions.appKey), TuplesKt.to("User-Agent", "(UrbanAirshipLib-" + PlatformUtils.asString(((Number) this.platformProvider.get()).intValue()) + '/' + UAirship.getVersion() + "; " + this.configOptions.appKey + CoreConstants.RIGHT_PARENTHESIS_CHAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit execute$lambda$0(int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        return Unit.INSTANCE;
    }

    @Override // com.urbanairship.http.RequestSession
    @NotNull
    public Response<Unit> execute(@NotNull Request request) throws RequestException {
        Intrinsics.checkNotNullParameter(request, "request");
        return execute(request, new ResponseParser() { // from class: com.urbanairship.http.DefaultRequestSession$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str) {
                return DefaultRequestSession.execute$lambda$0(i, map, str);
            }
        });
    }

    @Override // com.urbanairship.http.RequestSession
    @NotNull
    public <T> Response<T> execute(@NotNull Request request, @NotNull ResponseParser<T> parser) throws RequestException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(parser, "parser");
        RequestResult requestResultDoExecute = doExecute(request, parser);
        if (requestResultDoExecute.getShouldRetry()) {
            return doExecute(request, parser).getResponse();
        }
        return requestResultDoExecute.getResponse();
    }

    private final RequestResult doExecute(Request request, ResponseParser parser) throws RequestException {
        if (request.getUrl() == null) {
            throw new RequestException("Missing URL");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(getDefaultHeaders());
        linkedHashMap.putAll(request.getHeaders());
        try {
            RequestAuth auth = request.getAuth();
            ResolvedAuth resolvedAuthResolveAuth = auth != null ? resolveAuth(auth) : null;
            if (resolvedAuthResolveAuth != null) {
                linkedHashMap.putAll(resolvedAuthResolveAuth.getHeaders());
            }
            Response responseExecute = this.httpClient.execute(request.getUrl(), request.getMethod(), linkedHashMap, request.getBody(), request.getFollowRedirects(), parser);
            if (responseExecute.getStatus() == 401 && resolvedAuthResolveAuth != null && resolvedAuthResolveAuth.getAuthToken() != null) {
                expireAuth(request.getAuth(), resolvedAuthResolveAuth.getAuthToken());
                return new RequestResult(true, responseExecute);
            }
            return new RequestResult(false, responseExecute);
        } catch (Exception e) {
            throw new RequestException("Request failed: " + request, e);
        }
    }

    private final ResolvedAuth resolveAuth(RequestAuth auth) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        ResolvedAuth resolvedAuth;
        ResolvedAuth resolvedAuth2;
        int i = 2;
        String str = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        byte b7 = 0;
        byte b8 = 0;
        byte b9 = 0;
        if (auth instanceof RequestAuth.BasicAppAuth) {
            byte[] bytes = (this.configOptions.appKey + ':' + this.configOptions.appSecret).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("Authorization", "Basic " + Base64.encodeToString(bytes, 2))), str, i, b9 == true ? 1 : 0);
        }
        if (auth instanceof RequestAuth.BasicAuth) {
            StringBuilder sb = new StringBuilder();
            RequestAuth.BasicAuth basicAuth = (RequestAuth.BasicAuth) auth;
            sb.append(basicAuth.getUser());
            sb.append(':');
            sb.append(basicAuth.getPassword());
            byte[] bytes2 = sb.toString().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("Authorization", "Basic " + Base64.encodeToString(bytes2, 2))), b8 == true ? 1 : 0, i, b7 == true ? 1 : 0);
        }
        if (auth instanceof RequestAuth.BearerToken) {
            return new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + ((RequestAuth.BearerToken) auth).getToken())), b6 == true ? 1 : 0, i, b5 == true ? 1 : 0);
        }
        if (auth instanceof RequestAuth.ChannelTokenAuth) {
            String channelId = ((RequestAuth.ChannelTokenAuth) auth).getChannelId();
            AuthTokenProvider channelAuthTokenProvider = getChannelAuthTokenProvider();
            if (channelAuthTokenProvider == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String token = getToken(channelId, channelAuthTokenProvider);
            resolvedAuth2 = new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + token), TuplesKt.to("X-UA-Appkey", this.configOptions.appKey)), token);
        } else if (auth instanceof RequestAuth.ContactTokenAuth) {
            String contactId = ((RequestAuth.ContactTokenAuth) auth).getContactId();
            AuthTokenProvider contactAuthTokenProvider = getContactAuthTokenProvider();
            if (contactAuthTokenProvider == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            String token2 = getToken(contactId, contactAuthTokenProvider);
            resolvedAuth2 = new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + token2), TuplesKt.to("X-UA-Appkey", this.configOptions.appKey)), token2);
        } else {
            if (auth instanceof RequestAuth.GeneratedAppToken) {
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                String str2 = (String) this.nonceTokenFactory.invoke();
                String strCreateIso8601TimeStamp = DateUtils.createIso8601TimeStamp(jCurrentTimeMillis);
                Intrinsics.checkNotNullExpressionValue(strCreateIso8601TimeStamp, "createIso8601TimeStamp(...)");
                AirshipConfigOptions airshipConfigOptions = this.configOptions;
                String strGenerateSignedToken = UAStringUtil.generateSignedToken(airshipConfigOptions.appSecret, CollectionsKt.listOf((Object[]) new String[]{airshipConfigOptions.appKey, str2, strCreateIso8601TimeStamp}));
                Intrinsics.checkNotNullExpressionValue(strGenerateSignedToken, "generateSignedToken(...)");
                resolvedAuth = new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("X-UA-Appkey", this.configOptions.appKey), TuplesKt.to("X-UA-Nonce", str2), TuplesKt.to("X-UA-Timestamp", strCreateIso8601TimeStamp), TuplesKt.to("Authorization", "Bearer " + strGenerateSignedToken)), b4 == true ? 1 : 0, i, b3 == true ? 1 : 0);
            } else {
                if (!(auth instanceof RequestAuth.GeneratedChannelToken)) {
                    throw new NoWhenBranchMatchedException();
                }
                long jCurrentTimeMillis2 = this.clock.currentTimeMillis();
                String str3 = (String) this.nonceTokenFactory.invoke();
                String strCreateIso8601TimeStamp2 = DateUtils.createIso8601TimeStamp(jCurrentTimeMillis2);
                Intrinsics.checkNotNullExpressionValue(strCreateIso8601TimeStamp2, "createIso8601TimeStamp(...)");
                AirshipConfigOptions airshipConfigOptions2 = this.configOptions;
                RequestAuth.GeneratedChannelToken generatedChannelToken = (RequestAuth.GeneratedChannelToken) auth;
                String strGenerateSignedToken2 = UAStringUtil.generateSignedToken(airshipConfigOptions2.appSecret, CollectionsKt.listOf((Object[]) new String[]{airshipConfigOptions2.appKey, generatedChannelToken.getChannelId(), str3, strCreateIso8601TimeStamp2}));
                Intrinsics.checkNotNullExpressionValue(strGenerateSignedToken2, "generateSignedToken(...)");
                resolvedAuth = new ResolvedAuth(MapsKt.mapOf(TuplesKt.to("X-UA-Appkey", this.configOptions.appKey), TuplesKt.to("X-UA-Nonce", str3), TuplesKt.to("X-UA-Channel-ID", generatedChannelToken.getChannelId()), TuplesKt.to("X-UA-Timestamp", strCreateIso8601TimeStamp2), TuplesKt.to("Authorization", "Bearer " + strGenerateSignedToken2)), b2 == true ? 1 : 0, i, b == true ? 1 : 0);
            }
            return resolvedAuth;
        }
        return resolvedAuth2;
    }

    /* renamed from: com.urbanairship.http.DefaultRequestSession$expireAuth$1, reason: invalid class name and case insensitive filesystem */
    static final class C11291 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11291(String str, Continuation continuation) {
            super(2, continuation);
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DefaultRequestSession.this.new C11291(this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AuthTokenProvider channelAuthTokenProvider = DefaultRequestSession.this.getChannelAuthTokenProvider();
                if (channelAuthTokenProvider == null) {
                    return null;
                }
                String str = this.$token;
                this.label = 1;
                if (channelAuthTokenProvider.expireToken(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final void expireAuth(RequestAuth auth, String token) {
        if (auth instanceof RequestAuth.ChannelTokenAuth) {
            BuildersKt__BuildersKt.runBlocking$default(null, new C11291(token, null), 1, null);
        } else if (auth instanceof RequestAuth.ContactTokenAuth) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass2(token, null), 1, null);
        }
    }

    /* renamed from: com.urbanairship.http.DefaultRequestSession$expireAuth$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation continuation) {
            super(2, continuation);
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return DefaultRequestSession.this.new AnonymousClass2(this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AuthTokenProvider contactAuthTokenProvider = DefaultRequestSession.this.getContactAuthTokenProvider();
                if (contactAuthTokenProvider == null) {
                    return null;
                }
                String str = this.$token;
                this.label = 1;
                if (contactAuthTokenProvider.expireToken(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final String getToken(String identifier, AuthTokenProvider provider) {
        Object value = ((Result) BuildersKt__BuildersKt.runBlocking$default(null, new DefaultRequestSession$getToken$result$1(provider, identifier, null), 1, null)).getValue();
        ResultKt.throwOnFailure(value);
        return (String) value;
    }

    private static final class RequestResult {
        private final Response response;
        private final boolean shouldRetry;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestResult)) {
                return false;
            }
            RequestResult requestResult = (RequestResult) obj;
            return this.shouldRetry == requestResult.shouldRetry && Intrinsics.areEqual(this.response, requestResult.response);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.shouldRetry) * 31) + this.response.hashCode();
        }

        public String toString() {
            return "RequestResult(shouldRetry=" + this.shouldRetry + ", response=" + this.response + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public RequestResult(boolean z, Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.shouldRetry = z;
            this.response = response;
        }

        public final Response getResponse() {
            return this.response;
        }

        public final boolean getShouldRetry() {
            return this.shouldRetry;
        }
    }

    private static final class ResolvedAuth {
        private final String authToken;
        private final Map headers;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedAuth)) {
                return false;
            }
            ResolvedAuth resolvedAuth = (ResolvedAuth) obj;
            return Intrinsics.areEqual(this.headers, resolvedAuth.headers) && Intrinsics.areEqual(this.authToken, resolvedAuth.authToken);
        }

        public int hashCode() {
            int iHashCode = this.headers.hashCode() * 31;
            String str = this.authToken;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ResolvedAuth(headers=" + this.headers + ", authToken=" + this.authToken + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public ResolvedAuth(Map headers, String str) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers;
            this.authToken = str;
        }

        public /* synthetic */ ResolvedAuth(Map map, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i & 2) != 0 ? null : str);
        }

        public final Map getHeaders() {
            return this.headers;
        }

        public final String getAuthToken() {
            return this.authToken;
        }
    }
}
