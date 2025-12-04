package com.allegion.accesssdk.actions;

import com.allegion.accesshub.api.AlMAHApiService;
import com.allegion.accesshub.exceptions.AlMAHException;
import com.allegion.accesshub.models.AuthenticationMAHResponse;
import com.allegion.accesshub.models.AuthenticationMAHWebRequest;
import com.allegion.accesshub.services.AuthenticationService;
import com.allegion.accesssdk.enums.IAlSdkEnvironment;
import com.allegion.accesssdk.exceptions.AlAccountConflictException;
import com.allegion.accesssdk.exceptions.AlAuthenticationException;
import com.allegion.accesssdk.exceptions.AlDeviceEncryptionKeyException;
import com.allegion.accesssdk.exceptions.AlInvalidHeadersException;
import com.allegion.accesssdk.exceptions.AlInvalidIdTokenException;
import com.allegion.accesssdk.exceptions.AlInvalidIntegrationIdException;
import com.allegion.accesssdk.exceptions.AlInvalidResponseException;
import com.allegion.accesssdk.exceptions.AlInvalidSubscriptionKeyException;
import com.allegion.accesssdk.exceptions.AlServerException;
import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.allegion.logging.AlLog;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.IOException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/allegion/accesssdk/actions/AlAuthenticationService;", "Lcom/allegion/accesssdk/actions/IAlAuthenticationService;", "Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;", "request", "Lio/reactivex/Single;", "Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", "validateSecret", "(Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;)Lio/reactivex/Single;", "<init>", "()V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlAuthenticationService implements IAlAuthenticationService {
    public static final SingleSource access$errorMapping(AlAuthenticationService alAuthenticationService, Throwable th) {
        alAuthenticationService.getClass();
        if (th instanceof AlMAHException) {
            Single singleError = Single.error(new AlInvalidResponseException());
            Intrinsics.checkExpressionValueIsNotNull(singleError, "Single.error(AlInvalidResponseException())");
            return singleError;
        }
        if (th instanceof SSLPeerUnverifiedException) {
            Single singleError2 = Single.error(new AlServerException());
            Intrinsics.checkExpressionValueIsNotNull(singleError2, "Single.error(AlServerException())");
            return singleError2;
        }
        Single singleError3 = Single.error(new AlAuthenticationException(th));
        Intrinsics.checkExpressionValueIsNotNull(singleError3, "Single.error(AlAuthenticationException(error))");
        return singleError3;
    }

    @Override // com.allegion.accesssdk.actions.IAlAuthenticationService
    @NotNull
    public Single<AlAuthenticationResponse> validateSecret(@NotNull AlImmutableAuthenticationRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
        IAlSdkEnvironment environment = config.getEnvironment();
        Intrinsics.checkExpressionValueIsNotNull(config, "config");
        Object serviceInstance = AlMAHApiService.getServiceInstance(environment, AuthenticationService.class, config);
        if (serviceInstance == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.allegion.accesshub.services.AuthenticationService");
        }
        Single map = ((AuthenticationService) serviceInstance).validateSecret(request.getSubscriptionKey(), request.getInviteId(), new AuthenticationMAHWebRequest(request.getInviteSecret())).onErrorResumeNext(new Function<Throwable, SingleSource<? extends Response<AuthenticationMAHResponse>>>() { // from class: com.allegion.accesssdk.actions.AlAuthenticationService.validateSecret.1
            @Override // io.reactivex.functions.Function
            public SingleSource<? extends Response<AuthenticationMAHResponse>> apply(Throwable th) {
                Throwable it = th;
                Intrinsics.checkParameterIsNotNull(it, "it");
                return AlAuthenticationService.access$errorMapping(AlAuthenticationService.this, it);
            }
        }).map(new Function<T, R>() { // from class: com.allegion.accesssdk.actions.AlAuthenticationService.validateSecret.2
            @Override // io.reactivex.functions.Function
            public Object apply(Object obj) throws AlInvalidSubscriptionKeyException, AlInvalidHeadersException, AlInvalidIntegrationIdException, AlAccountConflictException, AlServerException, AlAuthenticationException, AlInvalidIdTokenException, AlDeviceEncryptionKeyException {
                String strString;
                Response it = (Response) obj;
                Intrinsics.checkParameterIsNotNull(it, "it");
                if (it.body() != null) {
                    Object objBody = it.body();
                    if (objBody == null) {
                        Intrinsics.throwNpe();
                    }
                    String idToken = ((AuthenticationMAHResponse) objBody).getIdToken();
                    Object objBody2 = it.body();
                    if (objBody2 == null) {
                        Intrinsics.throwNpe();
                    }
                    String accessToken = ((AuthenticationMAHResponse) objBody2).getCom.disney.id.android.OneIDRecoveryContext.ACCESS_TOKEN java.lang.String();
                    Object objBody3 = it.body();
                    if (objBody3 == null) {
                        Intrinsics.throwNpe();
                    }
                    return new AlAuthenticationResponse(accessToken, idToken, ((AuthenticationMAHResponse) objBody3).getIntegrationId());
                }
                int iCode = it.code();
                if (iCode == 400) {
                    throw new AlInvalidIdTokenException();
                }
                if (iCode == 401) {
                    throw new AlInvalidSubscriptionKeyException();
                }
                if (iCode == 403) {
                    throw new AlDeviceEncryptionKeyException();
                }
                if (iCode == 404) {
                    throw new AlInvalidIntegrationIdException();
                }
                if (iCode == 409) {
                    throw new AlAccountConflictException();
                }
                if (iCode == 415) {
                    throw new AlInvalidHeadersException();
                }
                if (iCode == 500) {
                    throw new AlServerException();
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(it.code()));
                    sb.append(": ");
                    if (it.errorBody() != null) {
                        ResponseBody responseBodyErrorBody = it.errorBody();
                        if (responseBodyErrorBody == null) {
                            Intrinsics.throwNpe();
                        }
                        strString = responseBodyErrorBody.string();
                    } else {
                        strString = "Unknown Error";
                    }
                    sb.append(strString);
                    throw new AlAuthenticationException(sb.toString());
                } catch (IOException e) {
                    AlLog.e(e);
                    throw new AlAuthenticationException();
                }
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(map, "authenticationService\n  …          }\n            }");
        return map;
    }
}
