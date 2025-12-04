package com.disney.id.android.services;

import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.lightbox.WebToNativeBridgeBase;
import com.disney.id.android.services.GCErrorHandlingAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b`\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ2\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J2\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0007H'JC\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0019\b\u0001\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000f0\u000eH'JC\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0019\b\u0001\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000f0\u000eH'J2\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'JM\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\u0019\b\u0001\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000f0\u000eH'J2\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J2\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'JT\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0019\b\u0001\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000f0\u000eH'¢\u0006\u0002\u0010\u0018JC\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0019\b\u0001\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\u000f0\u000eH'JC\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0002\u0010\u001bJ<\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J2\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'¨\u0006\u001f"}, d2 = {"Lcom/disney/id/android/services/GCService;", "", "changePassword", "Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCall;", "Lcom/disney/id/android/services/BaseGCResponse;", "Lcom/google/gson/JsonElement;", LightboxActivity.EVENT_ID_EXTRA, "", LightboxActivity.ACTION_NAME_EXTRA, "bodyJSON", "Lcom/google/gson/JsonObject;", "getGuest", "swid", "getGuestflow", "", "Lkotlin/jvm/JvmSuppressWildcards;", FirebaseAnalytics.Event.LOGIN, "loginRecoveryToken", WebToNativeBridgeBase.LIGHTBOX_EVENT_LOGOUT, "notificationOtpRecovery", "otpRedeem", "refreshAuth", "isJwtEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;)Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCall;", "register", "autogenerateUsername", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Boolean;)Lcom/disney/id/android/services/GCErrorHandlingAdapter$GCCall;", "updateGuest", "updateMarketing", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GCService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String FOR_INTERCEPTOR_ACTION_NAME = "deleteMe";

    @NotNull
    public static final String FOR_INTERCEPTOR_EVENT_ID = "replaceWithConversationId";

    @NotNull
    public static final String HEADER_FLAG_APIKEY = "replaceWithApiKey";

    @NotNull
    public static final String HEADER_FLAG_RECOVERY_TOKEN = "replaceWithRecoveryToken";

    @NotNull
    public static final String HEADER_NAME_AUTHORIZATION = "Authorization";

    @NotNull
    public static final String HEADER_NAME_AUTOMATION_TOKEN = "automation-token";

    @NotNull
    public static final String HEADER_NAME_CONVERSATIONID = "CONVERSATION-ID";

    @NotNull
    public static final String HEADER_NAME_JWT_ALLOWED = "X-Feature-Flag-Return-Jwt-Allowed";

    @NotNull
    public static final String HEADER_NAME_ONEID_REPORTING = "OneID-Reporting";

    @NotNull
    public static final String HEADER_NAME_TRANSACTIONID = "CORRELATION-ID";

    @NotNull
    public static final String RESPONSE_HEADER_NAME_APIKEY = "api-key";

    @Headers({"Authorization: replaceWithRecoveryToken"})
    @POST("clickback-token/change-password")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> changePassword(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull JsonObject bodyJSON);

    @GET("guest/{swid}")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> getGuest(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Path("swid") @NotNull String swid);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("guest-flow")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> getGuestflow(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull Map<String, Object> bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("guest/login")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> login(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull Map<String, Object> bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("guest/login/recoveryToken")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> loginRecoveryToken(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull JsonObject bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("guest/{swid}/logout")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<String>> logout(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Path("swid") @NotNull String swid, @Body @NotNull Map<String, Object> bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("notification/otp/recovery")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> notificationOtpRecovery(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull JsonObject bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("otp/redeem")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> otpRedeem(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull JsonObject bodyJSON);

    @POST("guest/refresh-auth")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> refreshAuth(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Header("X-Feature-Flag-Return-Jwt-Allowed") @Nullable Boolean isJwtEnabled, @Body @NotNull Map<String, Object> bodyJSON);

    @POST("guest/refresh-auth")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> refreshAuth(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull Map<String, Object> bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("guest/register")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> register(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull JsonObject bodyJSON, @Nullable @Query("autogenerateUsername") Boolean autogenerateUsername);

    @POST("guest/{swid}")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> updateGuest(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Path("swid") @NotNull String swid, @Body @NotNull JsonObject bodyJSON);

    @Headers({"Authorization: replaceWithApiKey"})
    @POST("marketing")
    @NotNull
    GCErrorHandlingAdapter.GCCall<BaseGCResponse<JsonElement>> updateMarketing(@Header("replaceWithConversationId") @NotNull String eventId, @Header("deleteMe") @NotNull String actionName, @Body @NotNull JsonObject bodyJSON);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/disney/id/android/services/GCService$Companion;", "", "()V", "FOR_INTERCEPTOR_ACTION_NAME", "", "FOR_INTERCEPTOR_EVENT_ID", "HEADER_FLAG_APIKEY", "HEADER_FLAG_RECOVERY_TOKEN", "HEADER_NAME_AUTHORIZATION", "HEADER_NAME_AUTOMATION_TOKEN", "HEADER_NAME_CONVERSATIONID", "HEADER_NAME_JWT_ALLOWED", "HEADER_NAME_ONEID_REPORTING", "HEADER_NAME_TRANSACTIONID", "RESPONSE_HEADER_NAME_APIKEY", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String FOR_INTERCEPTOR_ACTION_NAME = "deleteMe";

        @NotNull
        public static final String FOR_INTERCEPTOR_EVENT_ID = "replaceWithConversationId";

        @NotNull
        public static final String HEADER_FLAG_APIKEY = "replaceWithApiKey";

        @NotNull
        public static final String HEADER_FLAG_RECOVERY_TOKEN = "replaceWithRecoveryToken";

        @NotNull
        public static final String HEADER_NAME_AUTHORIZATION = "Authorization";

        @NotNull
        public static final String HEADER_NAME_AUTOMATION_TOKEN = "automation-token";

        @NotNull
        public static final String HEADER_NAME_CONVERSATIONID = "CONVERSATION-ID";

        @NotNull
        public static final String HEADER_NAME_JWT_ALLOWED = "X-Feature-Flag-Return-Jwt-Allowed";

        @NotNull
        public static final String HEADER_NAME_ONEID_REPORTING = "OneID-Reporting";

        @NotNull
        public static final String HEADER_NAME_TRANSACTIONID = "CORRELATION-ID";

        @NotNull
        public static final String RESPONSE_HEADER_NAME_APIKEY = "api-key";

        private Companion() {
        }
    }
}
