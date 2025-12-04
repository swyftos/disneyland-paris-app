package com.allegion.accesssdk.actions;

import com.allegion.accesshub.api.AlMAHApiService;
import com.allegion.accesshub.exceptions.AlMAHException;
import com.allegion.accesshub.models.AccessPayloadsMAHResponse;
import com.allegion.accesshub.models.AccessPayloadsMAHResponseData;
import com.allegion.accesshub.models.GetRightsMAHResponse;
import com.allegion.accesshub.models.IsNoTourAvailableMAHWebRequest;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlAccessPayloadsException;
import com.allegion.accesssdk.exceptions.AlAccessRightsException;
import com.allegion.accesssdk.exceptions.AlDeviceNotRegisteredException;
import com.allegion.accesssdk.exceptions.AlInvalidAccessRightException;
import com.allegion.accesssdk.exceptions.AlInvalidHeadersException;
import com.allegion.accesssdk.exceptions.AlInvalidResponseException;
import com.allegion.accesssdk.exceptions.AlInvalidSubscriptionKeyException;
import com.allegion.accesssdk.exceptions.AlParameterFormatException;
import com.allegion.accesssdk.exceptions.AlServerException;
import com.allegion.accesssdk.models.AlPayload;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import com.allegion.accesssdk.models.AlRight;
import com.allegion.logging.AlLog;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.NotImplementedError;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Hex;
import retrofit2.Response;

/* loaded from: classes2.dex */
class AlRightsService implements IAlRightsService {
    AlRightsService() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteIsNoTourUpdateAvailableAttribute(AlPayload[] alPayloadArr) {
        HashMap map = new HashMap();
        for (AlPayload alPayload : alPayloadArr) {
            int iOrdinal = alPayload.getType().ordinal();
            if (iOrdinal == 1 || iOrdinal == 3) {
                map.put(alPayload.getRightId().toString(), Boolean.TRUE);
            }
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        if (strArr.length > 0) {
            AlLog.d("Found unique access rights: " + Arrays.toString(strArr), new Object[0]);
            IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
            ((com.allegion.accesshub.services.AlRightsService) AlMAHApiService.getServiceInstance(config.getEnvironment(), com.allegion.accesshub.services.AlRightsService.class, config)).deleteIsNoTourUpdateAvailableAttribute(new IsNoTourAvailableMAHWebRequest(strArr)).subscribe(new Consumer() { // from class: com.allegion.accesssdk.actions.AlRightsService$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    AlRightsService.lambda$deleteIsNoTourUpdateAvailableAttribute$0((Void) obj);
                }
            }, new Consumer() { // from class: com.allegion.accesssdk.actions.AlRightsService$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    AlRightsService.lambda$deleteIsNoTourUpdateAvailableAttribute$1((Throwable) obj);
                }
            }).dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Single errorMapping(Throwable th) {
        return th instanceof AlMAHException ? Single.error(new AlInvalidResponseException()) : th instanceof SSLPeerUnverifiedException ? Single.error(new AlServerException()) : Single.error(new AlAccessRightsException(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteIsNoTourUpdateAvailableAttribute$0(Void r0) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteIsNoTourUpdateAvailableAttribute$1(Throwable th) throws Exception {
        if (th != null) {
            AlLog.e(th);
        }
    }

    @Override // com.allegion.accesssdk.actions.IAlRightsService
    public Single<AlPullPayloadsResponse> pullPayloads(AlImmutablePayloadsPullRequest alImmutablePayloadsPullRequest) {
        IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
        return ((com.allegion.accesshub.services.AlRightsService) AlMAHApiService.getServiceInstance(config.getEnvironment(), com.allegion.accesshub.services.AlRightsService.class, config)).accessPayloads(alImmutablePayloadsPullRequest.getAccountId(), alImmutablePayloadsPullRequest.getRightId(), alImmutablePayloadsPullRequest).onErrorResumeNext(new AlRightsService$$ExternalSyntheticLambda0(this)).map(new Function<Response<AccessPayloadsMAHResponse>, AlPullPayloadsResponse>(this) { // from class: com.allegion.accesssdk.actions.AlRightsService.5
            @Override // io.reactivex.functions.Function
            public AlPullPayloadsResponse apply(Response<AccessPayloadsMAHResponse> response) throws Exception {
                Response<AccessPayloadsMAHResponse> response2 = response;
                if (response2.body() == null) {
                    int iCode = response2.code();
                    if (iCode == 400) {
                        throw new AlParameterFormatException();
                    }
                    if (iCode == 401) {
                        throw new AlInvalidSubscriptionKeyException();
                    }
                    if (iCode == 403) {
                        throw new AlDeviceNotRegisteredException();
                    }
                    if (iCode == 404) {
                        throw new AlInvalidAccessRightException();
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
                        throw new AlAccessPayloadsException(sb.toString());
                    } catch (IOException e) {
                        AlLog.e(e);
                        throw new AlAccessPayloadsException();
                    }
                }
                AlLog.d("Received pull payloads response.", new Object[0]);
                AccessPayloadsMAHResponse accessPayloadsMAHResponseBody = response2.body();
                ArrayList arrayList = new ArrayList();
                String string = accessPayloadsMAHResponseBody.getAccessRightId().toString();
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                String str = simpleDateFormat.format(date);
                AlLog.d("storeTimestamp: rightId " + string + " timestamp " + str, new Object[0]);
                if (StringUtils.isNotBlank(string) && StringUtils.isNotBlank(str)) {
                    ((IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class)).store(string, str);
                }
                for (AccessPayloadsMAHResponseData accessPayloadsMAHResponseData : accessPayloadsMAHResponseBody.getPayloads()) {
                    try {
                        AlPayloadType alPayloadTypeValueOf = AlPayloadType.valueOf(accessPayloadsMAHResponseData.getPayloadType());
                        AlLog.d("preparePullPayloadsResponse: rightId " + accessPayloadsMAHResponseBody.getAccessRightId() + " payloadType " + alPayloadTypeValueOf.toString() + " deviceId " + accessPayloadsMAHResponseData.getDeviceId(), new Object[0]);
                        arrayList.add(new AlPayload(accessPayloadsMAHResponseBody.getAccessRightId(), alPayloadTypeValueOf, Hex.decode(accessPayloadsMAHResponseData.getPayload()), accessPayloadsMAHResponseData.getDeviceId()));
                    } catch (IllegalArgumentException e2) {
                        AlLog.e(e2, "Invalid payload type received, unable to accommodate: %s", accessPayloadsMAHResponseData.getPayloadType());
                    }
                }
                return new AlPullPayloadsResponse((AlPayload[]) arrayList.toArray(new AlPayload[0]));
            }
        }).doAfterSuccess(new Consumer<AlPullPayloadsResponse>() { // from class: com.allegion.accesssdk.actions.AlRightsService.4
            @Override // io.reactivex.functions.Consumer
            public void accept(AlPullPayloadsResponse alPullPayloadsResponse) throws Exception {
                AlRightsService.this.deleteIsNoTourUpdateAvailableAttribute(alPullPayloadsResponse.getPayloads());
            }
        }).doOnError(new Consumer<Throwable>(this) { // from class: com.allegion.accesssdk.actions.AlRightsService.3
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
                AlLog.e(th);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.IAlRightsService
    public Single<AlPullRightsResponse> pullRights(AlImmutableRightsPullRequest alImmutableRightsPullRequest) {
        IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
        return ((com.allegion.accesshub.services.AlRightsService) AlMAHApiService.getServiceInstance(config.getEnvironment(), com.allegion.accesshub.services.AlRightsService.class, config)).accessRights(alImmutableRightsPullRequest.accountId).onErrorResumeNext(new AlRightsService$$ExternalSyntheticLambda0(this)).map(new Function<Response<GetRightsMAHResponse[]>, AlPullRightsResponse>(this) { // from class: com.allegion.accesssdk.actions.AlRightsService.2
            @Override // io.reactivex.functions.Function
            public AlPullRightsResponse apply(Response<GetRightsMAHResponse[]> response) throws Exception {
                Response<GetRightsMAHResponse[]> response2 = response;
                if (response2.body() == null) {
                    int iCode = response2.code();
                    if (iCode == 401) {
                        throw new AlInvalidSubscriptionKeyException();
                    }
                    if (iCode == 403) {
                        throw new AlDeviceNotRegisteredException();
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
                        throw new AlAccessRightsException(sb.toString());
                    } catch (IOException e) {
                        AlLog.e(e);
                        throw new AlAccessRightsException();
                    }
                }
                GetRightsMAHResponse[] getRightsMAHResponseArrBody = response2.body();
                ArrayList arrayList = new ArrayList();
                for (GetRightsMAHResponse getRightsMAHResponse : getRightsMAHResponseArrBody) {
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : getRightsMAHResponse.getPayloadTypes()) {
                        try {
                            arrayList2.add(AlPayloadType.valueOf(str));
                        } catch (IllegalArgumentException e2) {
                            AlLog.e(e2, "Invalid payload type received, unable to accommodate: %s", str);
                        }
                    }
                    arrayList.add(new AlRight(getRightsMAHResponse.getId(), (AlPayloadType[]) arrayList2.toArray(new AlPayloadType[0]), getRightsMAHResponse.getAttributes()));
                }
                return new AlPullRightsResponse((AlRight[]) arrayList.toArray(new AlRight[0]));
            }
        }).doOnError(new Consumer<Throwable>(this) { // from class: com.allegion.accesssdk.actions.AlRightsService.1
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) throws Exception {
                AlLog.e(th);
            }
        });
    }

    @Override // com.allegion.accesssdk.actions.IAlRightsService
    public Single<AlPullPayloadsResponse> updatePayloads(AlImmutablePayloadsUpdateRequest alImmutablePayloadsUpdateRequest) {
        throw new NotImplementedError();
    }
}
