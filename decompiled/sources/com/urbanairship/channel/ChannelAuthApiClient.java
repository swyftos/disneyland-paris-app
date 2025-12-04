package com.urbanairship.channel;

import android.net.Uri;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.AuthToken;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.Clock;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/channel/ChannelAuthApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "requestSession", "Lcom/urbanairship/http/SuspendingRequestSession;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;Lcom/urbanairship/util/Clock;)V", "getToken", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/http/AuthToken;", "channelId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelAuthApiClient {
    private final Clock clock;
    private final SuspendingRequestSession requestSession;
    private final AirshipRuntimeConfig runtimeConfig;

    public ChannelAuthApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession requestSession, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(requestSession, "requestSession");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.runtimeConfig = runtimeConfig;
        this.requestSession = requestSession;
        this.clock = clock;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChannelAuthApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        suspendingRequestSession = (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession;
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(airshipRuntimeConfig, suspendingRequestSession, DEFAULT_CLOCK);
    }

    @Nullable
    public final Object getToken(@NotNull final String str, @NotNull Continuation<? super RequestResult<AuthToken>> continuation) {
        Uri uriBuild = this.runtimeConfig.getDeviceUrl().appendEncodedPath("api/auth/device").build();
        final long jCurrentTimeMillis = this.clock.currentTimeMillis();
        return this.requestSession.execute(new Request(uriBuild, "GET", new RequestAuth.GeneratedChannelToken(str), null, null, false, 56, null), new ResponseParser() { // from class: com.urbanairship.channel.ChannelAuthApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str2) {
                return ChannelAuthApiClient.getToken$lambda$1(str, jCurrentTimeMillis, i, map, str2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthToken getToken$lambda$1(String channelId, long j, int i, Map map, String str) throws JsonException {
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonMap jsonMapRequireMap = JsonValue.parseString(str).requireMap();
        String strRequireString = jsonMapRequireMap.require("token").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
        return new AuthToken(channelId, strRequireString, j + jsonMapRequireMap.require("expires_in").getLong(0L));
    }
}
