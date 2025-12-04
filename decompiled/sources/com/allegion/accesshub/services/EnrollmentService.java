package com.allegion.accesshub.services;

import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHResponse;
import com.allegion.accesshub.models.CreateConnectedAccountMAHWebRequest;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHWebRequest;
import com.allegion.accesshub.models.RetrieveConnectedAccountMAHResponse;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H'¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0012\u001a\u00020\u000bH'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/allegion/accesshub/services/EnrollmentService;", "", "Lcom/allegion/accesshub/models/RegisterDeviceMAHWebRequest;", "request", "Lretrofit2/Call;", "Lcom/allegion/accesshub/models/RegisterDeviceMAHResponse;", "registerDevice", "(Lcom/allegion/accesshub/models/RegisterDeviceMAHWebRequest;)Lretrofit2/Call;", "Lcom/allegion/accesshub/models/CreateAccountMAHResponse;", "createAccount", "()Lretrofit2/Call;", "Ljava/util/UUID;", "accountId", "integrationId", "Lcom/allegion/accesshub/models/CreateConnectedAccountMAHWebRequest;", "Lcom/allegion/accesshub/models/CreateConnectedAccountMAHResponse;", "createConnectedAccount", "(Ljava/util/UUID;Ljava/util/UUID;Lcom/allegion/accesshub/models/CreateConnectedAccountMAHWebRequest;)Lretrofit2/Call;", "connectedAccountId", "Lcom/allegion/accesshub/models/RetrieveConnectedAccountMAHResponse;", "retrieveConnectedAccount", "(Ljava/util/UUID;Ljava/util/UUID;)Lretrofit2/Call;", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface EnrollmentService {
    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:AUTH"})
    @POST("app/api/accounts")
    @NotNull
    Call<CreateAccountMAHResponse> createAccount();

    @Headers({"AlHeader:CONTENT_TYPE_JSON", "AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @POST("app/api/accounts/{accountId}/connectedaccounts/{integrationId}")
    @NotNull
    Call<CreateConnectedAccountMAHResponse> createConnectedAccount(@Path("accountId") @NotNull UUID accountId, @Path("integrationId") @NotNull UUID integrationId, @Body @NotNull CreateConnectedAccountMAHWebRequest request);

    @Headers({"AlHeader:CONTENT_TYPE_JSON", "AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG"})
    @POST("app/api/mobiledevices")
    @NotNull
    Call<RegisterDeviceMAHResponse> registerDevice(@Body @NotNull RegisterDeviceMAHWebRequest request);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:AUTH"})
    @GET("app/api/accounts/{accountId}/connectedaccounts/{connectedAccountId}")
    @NotNull
    Call<RetrieveConnectedAccountMAHResponse> retrieveConnectedAccount(@Path("accountId") @NotNull UUID accountId, @Path("connectedAccountId") @NotNull UUID connectedAccountId);
}
