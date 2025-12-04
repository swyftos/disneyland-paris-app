package com.allegion.accesshub.services;

import com.allegion.accesshub.models.AuthenticationMAHResponse;
import com.allegion.accesshub.models.AuthenticationMAHWebRequest;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/allegion/accesshub/services/AuthenticationService;", "", "", "subscriptionKey", "inviteId", "Lcom/allegion/accesshub/models/AuthenticationMAHWebRequest;", "inviteSecret", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Lcom/allegion/accesshub/models/AuthenticationMAHResponse;", "validateSecret", "(Ljava/lang/String;Ljava/lang/String;Lcom/allegion/accesshub/models/AuthenticationMAHWebRequest;)Lio/reactivex/Single;", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface AuthenticationService {
    @POST("invitetoken/api/Invites/{inviteId}/tokens")
    @NotNull
    Single<Response<AuthenticationMAHResponse>> validateSecret(@Header("alle-subscription-key") @NotNull String subscriptionKey, @Path("inviteId") @NotNull String inviteId, @Body @NotNull AuthenticationMAHWebRequest inviteSecret);
}
