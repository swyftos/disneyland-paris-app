package com.allegion.accesshub.services;

import com.allegion.accesshub.models.AccessPayloadsMAHResponse;
import com.allegion.accesshub.models.AccessPayloadsMAHWebRequest;
import com.allegion.accesshub.models.GetRightsMAHResponse;
import com.allegion.accesshub.models.IsNoTourAvailableMAHWebRequest;
import io.reactivex.Single;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ9\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/allegion/accesshub/services/AlRightsService;", "", "Ljava/util/UUID;", "accountId", "Lio/reactivex/Single;", "Lretrofit2/Response;", "", "Lcom/allegion/accesshub/models/GetRightsMAHResponse;", "accessRights", "(Ljava/util/UUID;)Lio/reactivex/Single;", "accessRightId", "Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequest;", "payloadRequest", "Lcom/allegion/accesshub/models/AccessPayloadsMAHResponse;", "accessPayloads", "(Ljava/util/UUID;Ljava/util/UUID;Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequest;)Lio/reactivex/Single;", "Lcom/allegion/accesshub/models/IsNoTourAvailableMAHWebRequest;", "isNoTourAvailableMAHWebRequest", "Ljava/lang/Void;", "deleteIsNoTourUpdateAvailableAttribute", "(Lcom/allegion/accesshub/models/IsNoTourAvailableMAHWebRequest;)Lio/reactivex/Single;", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface AlRightsService {
    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @POST("app/api/accounts/{accountId}/accessrights/{accessRightId}/accessPayloads")
    @NotNull
    Single<Response<AccessPayloadsMAHResponse>> accessPayloads(@Path("accountId") @NotNull UUID accountId, @Path("accessRightId") @NotNull UUID accessRightId, @Body @NotNull AccessPayloadsMAHWebRequest payloadRequest);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:AUTH"})
    @GET("app/api/accounts/{accountId}/accessrights")
    @NotNull
    Single<Response<GetRightsMAHResponse[]>> accessRights(@Path("accountId") @NotNull UUID accountId);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @NotNull
    @HTTP(hasBody = true, method = "DELETE", path = "app/api/AccessRights/NoTourUpdateAvailable")
    Single<Void> deleteIsNoTourUpdateAvailableAttribute(@Body @NotNull IsNoTourAvailableMAHWebRequest isNoTourAvailableMAHWebRequest);
}
