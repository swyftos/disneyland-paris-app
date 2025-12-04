package com.allegion.accesssdk.actions;

import com.allegion.accesshub.api.AlMAHApiService;
import com.allegion.accesshub.exceptions.AlMAHException;
import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHWebRequest;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHWebRequest;
import com.allegion.accesshub.services.AlEnrollmentService;
import com.allegion.accesssdk.exceptions.AlAccountConflictException;
import com.allegion.accesssdk.exceptions.AlAccountConnectionException;
import com.allegion.accesssdk.exceptions.AlAccountCreationException;
import com.allegion.accesssdk.exceptions.AlDeviceEncryptionKeyException;
import com.allegion.accesssdk.exceptions.AlDeviceRegistrationException;
import com.allegion.accesssdk.exceptions.AlInvalidHeadersException;
import com.allegion.accesssdk.exceptions.AlInvalidIdTokenException;
import com.allegion.accesssdk.exceptions.AlInvalidIntegrationIdException;
import com.allegion.accesssdk.exceptions.AlInvalidResponseException;
import com.allegion.accesssdk.exceptions.AlInvalidSubscriptionKeyException;
import com.allegion.accesssdk.exceptions.AlPublicKeyExportException;
import com.allegion.accesssdk.exceptions.AlServerException;
import com.allegion.logging.AlLog;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.UUID;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.bouncycastle.util.encoders.Hex;
import retrofit2.Response;

/* loaded from: classes2.dex */
class AlEnrollmentProvidable implements IAlEnrollmentProvidable {
    AlEnrollmentProvidable() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Single errorMapping(Throwable th) {
        return th instanceof AlMAHException ? Single.error(new AlInvalidResponseException()) : th instanceof SSLPeerUnverifiedException ? Single.error(new AlServerException()) : Single.error(new AlDeviceRegistrationException(th));
    }

    @Override // com.allegion.accesssdk.actions.IAlEnrollmentProvidable
    public Single<CreateConnectedAccountMAHResponse> connectedAccount(UUID uuid, AlImmutableEnrollmentRequest alImmutableEnrollmentRequest) {
        IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
        return ((AlEnrollmentService) AlMAHApiService.getServiceInstance(config.getEnvironment(), AlEnrollmentService.class, config)).connectedAccount(uuid, alImmutableEnrollmentRequest.getIntegrationId(), new CreateConnectedAccountMAHWebRequest(alImmutableEnrollmentRequest.getIdToken())).onErrorResumeNext(new AlEnrollmentProvidable$$ExternalSyntheticLambda0(this)).map(new Function<Response<CreateConnectedAccountMAHResponse>, CreateConnectedAccountMAHResponse>(this) { // from class: com.allegion.accesssdk.actions.AlEnrollmentProvidable.6
            @Override // io.reactivex.functions.Function
            public CreateConnectedAccountMAHResponse apply(Response<CreateConnectedAccountMAHResponse> response) throws Exception {
                Response<CreateConnectedAccountMAHResponse> response2 = response;
                if (response2.body() != null) {
                    return response2.body();
                }
                int iCode = response2.code();
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
                    sb.append(response2.code());
                    sb.append(": ");
                    sb.append(response2.errorBody() == null ? "Unknown Error" : response2.errorBody().string());
                    throw new AlAccountConnectionException(sb.toString());
                } catch (IOException e) {
                    AlLog.e(e);
                    throw new AlAccountConnectionException();
                }
            }
        }).doOnError(new Consumer<Throwable>(this) { // from class: com.allegion.accesssdk.actions.AlEnrollmentProvidable.5
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
                AlLog.e(th);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.IAlEnrollmentProvidable
    public Single<CreateAccountMAHResponse> createAccount(AlImmutableEnrollmentCreateAccountRequest alImmutableEnrollmentCreateAccountRequest) {
        IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
        return ((AlEnrollmentService) AlMAHApiService.getServiceInstance(config.getEnvironment(), AlEnrollmentService.class, config)).createAccount().onErrorResumeNext(new AlEnrollmentProvidable$$ExternalSyntheticLambda0(this)).map(new Function<Response<CreateAccountMAHResponse>, CreateAccountMAHResponse>(this) { // from class: com.allegion.accesssdk.actions.AlEnrollmentProvidable.4
            @Override // io.reactivex.functions.Function
            public CreateAccountMAHResponse apply(Response<CreateAccountMAHResponse> response) throws Exception {
                Response<CreateAccountMAHResponse> response2 = response;
                if (response2.body() != null) {
                    return response2.body();
                }
                int iCode = response2.code();
                if (iCode == 401) {
                    throw new AlInvalidSubscriptionKeyException();
                }
                if (iCode == 403) {
                    throw new AlDeviceEncryptionKeyException();
                }
                if (iCode == 409) {
                    throw new AlAccountConflictException();
                }
                if (iCode == 500) {
                    throw new AlServerException();
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(response2.code());
                    sb.append(": ");
                    sb.append(response2.errorBody() == null ? "Unknown Error" : response2.errorBody().string());
                    throw new AlAccountCreationException(sb.toString());
                } catch (IOException e) {
                    AlLog.e(e);
                    throw new AlAccountCreationException();
                }
            }
        }).doOnError(new Consumer<Throwable>(this) { // from class: com.allegion.accesssdk.actions.AlEnrollmentProvidable.3
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
                AlLog.e(th);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.IAlEnrollmentProvidable
    public Single<RegisterDeviceMAHResponse> registerDevice(AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest) {
        IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
        try {
            return ((AlEnrollmentService) AlMAHApiService.getServiceInstance(config.getEnvironment(), AlEnrollmentService.class, config)).registerDevice(new RegisterDeviceMAHWebRequest(Hex.toHexString(config.exportEccDevicePublicKeyUncompressed()))).onErrorResumeNext(new AlEnrollmentProvidable$$ExternalSyntheticLambda0(this)).map(new Function<Response<RegisterDeviceMAHResponse>, RegisterDeviceMAHResponse>(this) { // from class: com.allegion.accesssdk.actions.AlEnrollmentProvidable.2
                @Override // io.reactivex.functions.Function
                public RegisterDeviceMAHResponse apply(Response<RegisterDeviceMAHResponse> response) throws Exception {
                    Response<RegisterDeviceMAHResponse> response2 = response;
                    if (response2.body() != null) {
                        return response2.body();
                    }
                    int iCode = response2.code();
                    if (iCode == 401) {
                        throw new AlInvalidSubscriptionKeyException();
                    }
                    if (iCode == 403) {
                        throw new AlDeviceEncryptionKeyException();
                    }
                    if (iCode == 415) {
                        throw new AlInvalidHeadersException();
                    }
                    if (iCode == 500) {
                        throw new AlServerException();
                    }
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append(response2.code());
                        sb.append(": ");
                        sb.append(response2.errorBody() == null ? "Unknown Error" : response2.errorBody().string());
                        throw new AlDeviceRegistrationException(sb.toString());
                    } catch (IOException e) {
                        AlLog.e(e);
                        throw new AlDeviceRegistrationException();
                    }
                }
            }).doOnError(new Consumer<Throwable>(this) { // from class: com.allegion.accesssdk.actions.AlEnrollmentProvidable.1
                @Override // io.reactivex.functions.Consumer
                public void accept(Throwable th) throws Exception {
                    AlLog.e(th);
                }
            });
        } catch (AlPublicKeyExportException e) {
            return Single.error(new AlDeviceEncryptionKeyException(e));
        }
    }
}
