package com.allegion.accesshub.services;

import com.allegion.accesshub.models.CommissionRequest;
import com.allegion.accesshub.models.CommissionResponse;
import com.allegion.accesshub.models.DecommissionRequest;
import com.allegion.accesshub.models.DecommissionResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/allegion/accesshub/services/CommissioningService;", "", "Lcom/allegion/accesshub/models/CommissionRequest;", "request", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lcom/allegion/accesshub/models/CommissionResponse;", "commissionDevice", "(Lcom/allegion/accesshub/models/CommissionRequest;)Lio/reactivex/Single;", "Lcom/allegion/accesshub/models/DecommissionRequest;", "Lcom/allegion/accesshub/models/DecommissionResponse;", "decommissionDevice", "(Lcom/allegion/accesshub/models/DecommissionRequest;)Lio/reactivex/Single;", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface CommissioningService {
    @Headers({"AlHeader:CONTENT_TYPE_JSON", "AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @POST("app/api/CommissioningPayloads")
    @NotNull
    Single<Response<CommissionResponse>> commissionDevice(@Body @NotNull CommissionRequest request);

    @Headers({"AlHeader:CONTENT_TYPE_JSON", "AlHeader:SUBSCRIPTION_KEY", "AlHeader:DEVICE_SIG", "AlHeader:AUTH"})
    @NotNull
    @HTTP(hasBody = true, method = "DELETE", path = "app/api/CommissioningPayloads/Decommission")
    Single<Response<DecommissionResponse>> decommissionDevice(@Body @NotNull DecommissionRequest request);
}
