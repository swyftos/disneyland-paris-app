package com.urbanairship.deferred;

import android.net.Uri;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.allegion.accesssdk.BuildConfig;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.PlatformUtils;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JJ\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/deferred/DeferredApiClient;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "resolve", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/json/JsonValue;", ReactNativeBlobUtilConst.DATA_ENCODE_URI, "Landroid/net/Uri;", "channelId", "", "contactId", "stateOverrides", "Lcom/urbanairship/deferred/StateOverrides;", "audienceOverrides", "Lcom/urbanairship/audience/AudienceOverrides$Channel;", "triggerContext", "Lcom/urbanairship/deferred/DeferredTriggerContext;", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/deferred/StateOverrides;Lcom/urbanairship/audience/AudienceOverrides$Channel;Lcom/urbanairship/deferred/DeferredTriggerContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeferredApiClient {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String KEY_ATTRIBUTES_OVERRIDES = "attribute_overrides";

    @Deprecated
    @NotNull
    public static final String KEY_CHANNEL_ID = "channel_id";

    @Deprecated
    @NotNull
    public static final String KEY_CONTACT_ID = "contact_id";

    @Deprecated
    @NotNull
    public static final String KEY_PLATFORM = "platform";

    @Deprecated
    @NotNull
    public static final String KEY_STATE_OVERRIDES = "state_overrides";

    @Deprecated
    @NotNull
    public static final String KEY_TAG_OVERRIDES = "tag_overrides";

    @Deprecated
    @NotNull
    public static final String KEY_TRIGGER_CONTEXT = "trigger";
    private final AirshipRuntimeConfig config;
    private final SuspendingRequestSession session;

    public DeferredApiClient(@NotNull AirshipRuntimeConfig config, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(session, "session");
        this.config = config;
        this.session = session;
    }

    @Nullable
    public final Object resolve(@NotNull Uri uri, @NotNull String str, @Nullable String str2, @NotNull StateOverrides stateOverrides, @Nullable AudienceOverrides.Channel channel, @Nullable DeferredTriggerContext deferredTriggerContext, @NotNull Continuation<? super RequestResult<JsonValue>> continuation) {
        return this.session.execute(new Request(uri, "POST", new RequestAuth.ChannelTokenAuth(str), new RequestBody.Json(JsonExtensionsKt.jsonMapOf(TuplesKt.to(KEY_PLATFORM, PlatformUtils.asString(this.config.getPlatform())), TuplesKt.to("channel_id", str), TuplesKt.to(KEY_CONTACT_ID, str2), TuplesKt.to(KEY_STATE_OVERRIDES, stateOverrides), TuplesKt.to(KEY_TRIGGER_CONTEXT, deferredTriggerContext), TuplesKt.to(KEY_TAG_OVERRIDES, JsonValue.wrapOpt(channel != null ? channel.getTags() : null)), TuplesKt.to(KEY_ATTRIBUTES_OVERRIDES, JsonValue.wrapOpt(channel != null ? channel.getAttributes() : null)))), MapsKt.mapOf(TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;")), false, 32, null), new ResponseParser() { // from class: com.urbanairship.deferred.DeferredApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str3) {
                return DeferredApiClient.resolve$lambda$0(i, map, str3);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonValue resolve$lambda$0(int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return JsonValue.NULL;
        }
        return JsonValue.parseString(str);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
