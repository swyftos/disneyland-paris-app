package com.urbanairship.messagecenter;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.UrlBuilder;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 )2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\f\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J.\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u001b\"\u00020\bH\u0002¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\rH\u0002J2\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0086@¢\u0006\u0002\u0010$J2\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0086@¢\u0006\u0002\u0010$J$\u0010'\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010(R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/urbanairship/messagecenter/InboxApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", com.allegion.accesssdk.BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "payloadChannelsKey", "", "getPayloadChannelsKey", "()Ljava/lang/String;", "createUser", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/messagecenter/UserCredentials;", "channelId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorResult", ExifInterface.GPS_DIRECTION_TRUE, "message", "fetchMessages", "Lcom/urbanairship/json/JsonList;", TCEventPropertiesNames.TCE_USER, "ifModifiedSince", "(Lcom/urbanairship/messagecenter/UserCredentials;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserApiUrl", "Landroid/net/Uri;", "paths", "", "([Ljava/lang/String;)Landroid/net/Uri;", "getUserAuth", "Lcom/urbanairship/http/RequestAuth;", "syncDeletedMessageState", "", "reportingsToDelete", "", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/messagecenter/UserCredentials;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncReadMessageState", "reportingsToUpdate", "updateUser", "(Lcom/urbanairship/messagecenter/UserCredentials;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInboxApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InboxApiClient.kt\ncom/urbanairship/messagecenter/InboxApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,192:1\n1#2:193\n44#3,15:194\n44#3,15:209\n*S KotlinDebug\n*F\n+ 1 InboxApiClient.kt\ncom/urbanairship/messagecenter/InboxApiClient\n*L\n112#1:194,15\n113#1:209,15\n*E\n"})
/* loaded from: classes5.dex */
public final class InboxApiClient {
    private static final Companion Companion = new Companion(null);
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    public InboxApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(session, "session");
        this.runtimeConfig = runtimeConfig;
        this.session = session;
    }

    public /* synthetic */ InboxApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    @Nullable
    public final Object fetchMessages(@NotNull UserCredentials userCredentials, @NotNull String str, @Nullable String str2, @NotNull Continuation<? super RequestResult<JsonList>> continuation) {
        Uri userApiUrl = getUserApiUrl(userCredentials.getUsername(), "messages/");
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"), TuplesKt.to("X-UA-Channel-ID", str));
        if (str2 != null) {
            mapMutableMapOf.put("If-Modified-Since", str2);
        }
        return this.session.execute(new Request(userApiUrl, "GET", getUserAuth(userCredentials), null, MapsKt.toMap(mapMutableMapOf), false, 32, null), new ResponseParser() { // from class: com.urbanairship.messagecenter.InboxApiClient$$ExternalSyntheticLambda1
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str3) {
                return InboxApiClient.fetchMessages$lambda$1(i, map, str3);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonList fetchMessages$lambda$1(int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (UAHttpStatusUtil.inSuccessRange(i)) {
            return JsonValue.parseString(str).optMap().opt("messages").requireList();
        }
        return null;
    }

    @Nullable
    public final Object syncDeletedMessageState(@NotNull UserCredentials userCredentials, @NotNull String str, @NotNull List<? extends JsonValue> list, @NotNull Continuation<? super RequestResult<Unit>> continuation) throws JsonException {
        Uri userApiUrl = getUserApiUrl(userCredentials.getUsername(), "messages/delete/");
        final JsonMap jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("messages", JsonValue.wrapOpt(list)));
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.InboxApiClient.syncDeletedMessageState.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Deleting inbox messages with payload: " + jsonMapJsonMapOf;
            }
        }, 1, null);
        return this.session.execute(new Request(userApiUrl, "POST", getUserAuth(userCredentials), new RequestBody.Json(jsonMapJsonMapOf), MapsKt.mapOf(TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"), TuplesKt.to("X-UA-Channel-ID", str)), false, 32, null), continuation);
    }

    @Nullable
    public final Object syncReadMessageState(@NotNull UserCredentials userCredentials, @NotNull String str, @NotNull List<? extends JsonValue> list, @NotNull Continuation<? super RequestResult<Unit>> continuation) throws JsonException {
        Uri userApiUrl = getUserApiUrl(userCredentials.getUsername(), "messages/unread/");
        final JsonMap jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to("messages", JsonValue.wrapOpt(list)));
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.InboxApiClient.syncReadMessageState.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Marking inbox messages read request with payload: " + jsonMapJsonMapOf;
            }
        }, 1, null);
        return this.session.execute(new Request(userApiUrl, "POST", getUserAuth(userCredentials), new RequestBody.Json(jsonMapJsonMapOf), MapsKt.mapOf(TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"), TuplesKt.to("X-UA-Channel-ID", str)), false, 32, null), continuation);
    }

    @Nullable
    public final Object createUser(@NotNull String str, @NotNull Continuation<? super RequestResult<UserCredentials>> continuation) {
        Uri userApiUrl = getUserApiUrl(new String[0]);
        String payloadChannelsKey = getPayloadChannelsKey();
        if (payloadChannelsKey == null) {
            return errorResult("Missing platform");
        }
        JsonMap jsonMapBuild = JsonMap.newBuilder().putOpt(payloadChannelsKey, CollectionsKt.listOf(str)).build();
        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
        UALog.v("Creating Rich Push user with payload: %s", jsonMapBuild);
        return this.session.execute(new Request(userApiUrl, "POST", new RequestAuth.ChannelTokenAuth(str), new RequestBody.Json(jsonMapBuild), MapsKt.mapOf(TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"), TuplesKt.to("X-UA-Channel-ID", str)), false, 32, null), new ResponseParser() { // from class: com.urbanairship.messagecenter.InboxApiClient$$ExternalSyntheticLambda0
            @Override // com.urbanairship.http.ResponseParser
            public final Object parseResponse(int i, Map map, String str2) {
                return InboxApiClient.createUser$lambda$2(i, map, str2);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.urbanairship.messagecenter.UserCredentials createUser$lambda$2(int r18, java.util.Map r19, java.lang.String r20) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.messagecenter.InboxApiClient.createUser$lambda$2(int, java.util.Map, java.lang.String):com.urbanairship.messagecenter.UserCredentials");
    }

    @Nullable
    public final Object updateUser(@NotNull UserCredentials userCredentials, @NotNull String str, @NotNull Continuation<? super RequestResult<Unit>> continuation) {
        String payloadChannelsKey = getPayloadChannelsKey();
        if (payloadChannelsKey == null) {
            return errorResult("Missing platform");
        }
        final JsonMap jsonMapJsonMapOf = JsonExtensionsKt.jsonMapOf(TuplesKt.to(payloadChannelsKey, JsonExtensionsKt.jsonMapOf(TuplesKt.to("add", CollectionsKt.listOf(str)))));
        Uri userApiUrl = getUserApiUrl(userCredentials.getUsername());
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.messagecenter.InboxApiClient.updateUser.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Updating user with payload: " + jsonMapJsonMapOf;
            }
        }, 1, null);
        return this.session.execute(new Request(userApiUrl, "POST", getUserAuth(userCredentials), new RequestBody.Json(jsonMapJsonMapOf), MapsKt.mapOf(TuplesKt.to("Accept", "application/vnd.urbanairship+json; version=3;"), TuplesKt.to("X-UA-Channel-ID", str)), false, 32, null), continuation);
    }

    private final Uri getUserApiUrl(String... paths) {
        UrlBuilder urlBuilderAppendEncodedPath = this.runtimeConfig.getDeviceUrl().appendEncodedPath("api/user/");
        Intrinsics.checkNotNullExpressionValue(urlBuilderAppendEncodedPath, "appendEncodedPath(...)");
        for (String str : paths) {
            if (!StringsKt.endsWith$default(str, "/", false, 2, (Object) null)) {
                str = str + '/';
            }
            urlBuilderAppendEncodedPath.appendEncodedPath(str);
        }
        return urlBuilderAppendEncodedPath.build();
    }

    private final String getPayloadChannelsKey() {
        int platform = this.runtimeConfig.getPlatform();
        if (platform == 1) {
            return "amazon_channels";
        }
        if (platform != 2) {
            return null;
        }
        return "android_channels";
    }

    private final RequestAuth getUserAuth(UserCredentials user) {
        return new RequestAuth.BasicAuth(user.getUsername(), user.getPassword());
    }

    private final RequestResult errorResult(String message) {
        return new RequestResult(new RequestException(message));
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
