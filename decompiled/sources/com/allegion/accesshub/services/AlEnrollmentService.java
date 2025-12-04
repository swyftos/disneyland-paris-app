package com.allegion.accesshub.services;

import androidx.autofill.HintConstants;
import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHWebRequest;
import com.allegion.accesshub.models.PhoneVerificationMAHResponse;
import com.allegion.accesshub.models.PhoneVerificationMAHWebRequest;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHWebRequest;
import com.allegion.accesshub.models.RetrieveConnectedAccountMAHResponse;
import io.reactivex.Single;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004H'¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00050\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\b\b\u0001\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0018\u001a\u00020\u0011H'¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/allegion/accesshub/services/AlEnrollmentService;", "", "Lcom/allegion/accesshub/models/PhoneVerificationMAHWebRequest;", HintConstants.AUTOFILL_HINT_PHONE, "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lcom/allegion/accesshub/models/PhoneVerificationMAHResponse;", "phoneVerification", "(Lcom/allegion/accesshub/models/PhoneVerificationMAHWebRequest;)Lio/reactivex/Single;", "Lcom/allegion/accesshub/models/RegisterDeviceMAHWebRequest;", "request", "Lcom/allegion/accesshub/models/RegisterDeviceMAHResponse;", "registerDevice", "(Lcom/allegion/accesshub/models/RegisterDeviceMAHWebRequest;)Lio/reactivex/Single;", "Lcom/allegion/accesshub/models/CreateAccountMAHResponse;", "createAccount", "()Lio/reactivex/Single;", "Ljava/util/UUID;", "accountId", "integrationId", "Lcom/allegion/accesshub/models/CreateConnectedAccountMAHWebRequest;", "Lcom/allegion/accesshub/models/CreateConnectedAccountMAHResponse;", "connectedAccount", "(Ljava/util/UUID;Ljava/util/UUID;Lcom/allegion/accesshub/models/CreateConnectedAccountMAHWebRequest;)Lio/reactivex/Single;", "connectedAccountId", "Lcom/allegion/accesshub/models/RetrieveConnectedAccountMAHResponse;", "connectedAccountDescription", "(Ljava/util/UUID;Ljava/util/UUID;)Lio/reactivex/Single;", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface AlEnrollmentService {
    @Headers({"AlHeader:CONTENT_TYPE_JSON", "AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @POST("app/api/accounts/{accountId}/connectedaccounts/{integrationId}")
    @NotNull
    Single<Response<CreateConnectedAccountMAHResponse>> connectedAccount(@Path("accountId") @NotNull UUID accountId, @Path("integrationId") @NotNull UUID integrationId, @Body @NotNull CreateConnectedAccountMAHWebRequest request);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:AUTH"})
    @GET("app/api/accounts/{accountId}/connectedaccounts/{connectedAccountId}")
    @NotNull
    Single<Response<RetrieveConnectedAccountMAHResponse>> connectedAccountDescription(@Path("accountId") @NotNull UUID accountId, @Path("connectedAccountId") @NotNull UUID connectedAccountId);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:AUTH"})
    @POST("app/api/accounts")
    @NotNull
    Single<Response<CreateAccountMAHResponse>> createAccount();

    @POST("app/api/phoneverification")
    @NotNull
    Single<Response<PhoneVerificationMAHResponse>> phoneVerification(@Body @NotNull PhoneVerificationMAHWebRequest phone);

    @Headers({"AlHeader:CONTENT_TYPE_JSON", "AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG"})
    @POST("app/api/mobiledevices")
    @NotNull
    Single<Response<RegisterDeviceMAHResponse>> registerDevice(@Body @NotNull RegisterDeviceMAHWebRequest request);
}
