package com.allegion.accesshub.services;

import com.allegion.accesshub.models.AccessPayloadsMAHResponse;
import com.allegion.accesshub.models.AccessPayloadsMAHWebRequest;
import com.allegion.accesshub.models.GetRightsMAHResponse;
import com.allegion.accesshub.models.IsNoTourAvailableMAHWebRequest;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/allegion/accesshub/services/RightsService;", "", "Ljava/util/UUID;", "accountId", "Lretrofit2/Call;", "", "Lcom/allegion/accesshub/models/GetRightsMAHResponse;", "accessRights", "(Ljava/util/UUID;)Lretrofit2/Call;", "accessRightId", "Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequest;", "payloadRequest", "Lcom/allegion/accesshub/models/AccessPayloadsMAHResponse;", "accessPayloads", "(Ljava/util/UUID;Ljava/util/UUID;Lcom/allegion/accesshub/models/AccessPayloadsMAHWebRequest;)Lretrofit2/Call;", "Lcom/allegion/accesshub/models/IsNoTourAvailableMAHWebRequest;", "isNoTourAvailableMAHWebRequest", "Ljava/lang/Void;", "deleteIsNoTourUpdateAvailableAttribute", "(Lcom/allegion/accesshub/models/IsNoTourAvailableMAHWebRequest;)Lretrofit2/Call;", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface RightsService {
    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @POST("app/api/accounts/{accountId}/accessrights/{accessRightId}/accessPayloads")
    @NotNull
    Call<AccessPayloadsMAHResponse> accessPayloads(@Path("accountId") @NotNull UUID accountId, @Path("accessRightId") @NotNull UUID accessRightId, @Body @NotNull AccessPayloadsMAHWebRequest payloadRequest);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:AUTH"})
    @GET("app/api/accounts/{accountId}/accessrights")
    @NotNull
    Call<GetRightsMAHResponse[]> accessRights(@Path("accountId") @NotNull UUID accountId);

    @Headers({"AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @NotNull
    @HTTP(hasBody = true, method = "DELETE", path = "app/api/AccessRights/NoTourUpdateAvailable")
    Call<Void> deleteIsNoTourUpdateAvailableAttribute(@Body @NotNull IsNoTourAvailableMAHWebRequest isNoTourAvailableMAHWebRequest);
}
