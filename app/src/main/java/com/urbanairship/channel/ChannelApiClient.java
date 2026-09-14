package com.urbanairship.channel;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.UrlBuilder;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1836d2 = {"Lcom/urbanairship/channel/ChannelApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "createChannel", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/channel/Channel;", "channelPayload", "Lcom/urbanairship/channel/ChannelRegistrationPayload;", "createChannel$urbanairship_core_release", "(Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocation", "Landroid/net/Uri;", "channelId", "", "createLocation$urbanairship_core_release", "updateChannel", "updateChannel$urbanairship_core_release", "(Ljava/lang/String;Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nChannelApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelApiClient.kt\ncom/urbanairship/channel/ChannelApiClient\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,102:1\n44#2,15:103\n*S KotlinDebug\n*F\n+ 1 ChannelApiClient.kt\ncom/urbanairship/channel/ChannelApiClient\n*L\n47#1:103,15\n*E\n"})
public final class ChannelApiClient {
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    @VisibleForTesting
    public ChannelApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(session, "session");
        this.runtimeConfig = runtimeConfig;
        this.session = session;
    }

    public /* synthetic */ ChannelApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object createChannel$urbanairship_core_release(@NotNull final ChannelRegistrationPayload channelRegistrationPayload, @NotNull Continuation<? super RequestResult<Channel>> continuation) {
        ChannelApiClient$createChannel$1 channelApiClient$createChannel$1;
        if (continuation instanceof ChannelApiClient$createChannel$1) {
            channelApiClient$createChannel$1 = (ChannelApiClient$createChannel$1) continuation;
            int i = channelApiClient$createChannel$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelApiClient$createChannel$1.label = i - Integer.MIN_VALUE;
            } else {
                channelApiClient$createChannel$1 = new ChannelApiClient$createChannel$1(this, continuation);
            }
        } else {
            channelApiClient$createChannel$1 = new ChannelApiClient$createChannel$1(this, continuation);
        }
        Object objExecute = channelApiClient$createChannel$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelApiClient$createChannel$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelApiClient$createChannel$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Creating channel with payload: " + channelRegistrationPayload;
                }
            }, 1, null);
            final UrlBuilder urlBuilderAppendEncodedPath = this.runtimeConfig.getDeviceUrl().appendEncodedPath("api/channels/");
            Intrinsics.checkNotNullExpressionValue(urlBuilderAppendEncodedPath, "appendEncodedPath(...)");
            Request request = new Request(urlBuilderAppendEncodedPath.build(), "POST", RequestAuth.GeneratedAppToken.INSTANCE, new RequestBody.Json(channelRegistrationPayload), MapsKt.mapOf(TuplesKt.m1842to("Accept", "application/vnd.urbanairship+json; version=3;")), false, 32, null);
            SuspendingRequestSession suspendingRequestSession = this.session;
            ResponseParser responseParser = new ResponseParser() { // from class: com.urbanairship.channel.ChannelApiClient$$ExternalSyntheticLambda0
                @Override // com.urbanairship.http.ResponseParser
                public final Object parseResponse(int i3, Map map, String str) {
                    return ChannelApiClient.createChannel$lambda$0(urlBuilderAppendEncodedPath, i3, map, str);
                }
            };
            channelApiClient$createChannel$1.label = 1;
            objExecute = suspendingRequestSession.execute(request, responseParser, channelApiClient$createChannel$1);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objExecute);
        }
        final RequestResult requestResult = (RequestResult) objExecute;
        SuspendingRequestSessionKt.log(requestResult, new Function0() { // from class: com.urbanairship.channel.ChannelApiClient$createChannel$4$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Creating channel finished with result: " + requestResult;
            }
        });
        return objExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Channel createChannel$lambda$0(UrlBuilder builder, int i, Map map, String str) throws JsonException {
        String strOptString;
        Intrinsics.checkNotNullParameter(builder, "$builder");
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonMap jsonMapRequireMap = JsonValue.parseString(str).requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue = jsonMapRequireMap.get("channel_id");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        Intrinsics.checkNotNull(jsonValue);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            strOptString = jsonValue.optString();
            if (strOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
            strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            Object objOptList = jsonValue.optList();
            if (objOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptList;
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            Object objOptMap = jsonValue.optMap();
            if (objOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) objOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.getJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue2;
        }
        return new Channel(strOptString, String.valueOf(builder.appendPath(strOptString).build()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    @Nullable
    public final Object updateChannel$urbanairship_core_release(@NotNull String str, @NotNull final ChannelRegistrationPayload channelRegistrationPayload, @NotNull Continuation<? super RequestResult<Channel>> continuation) {
        ChannelApiClient$updateChannel$1 channelApiClient$updateChannel$1;
        final Uri uri;
        final String str2 = str;
        if (continuation instanceof ChannelApiClient$updateChannel$1) {
            channelApiClient$updateChannel$1 = (ChannelApiClient$updateChannel$1) continuation;
            int i = channelApiClient$updateChannel$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelApiClient$updateChannel$1.label = i - Integer.MIN_VALUE;
            } else {
                channelApiClient$updateChannel$1 = new ChannelApiClient$updateChannel$1(this, continuation);
            }
        } else {
            channelApiClient$updateChannel$1 = new ChannelApiClient$updateChannel$1(this, continuation);
        }
        Object obj = channelApiClient$updateChannel$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelApiClient$updateChannel$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.ChannelApiClient$updateChannel$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Updating channel " + str2 + " with payload: " + channelRegistrationPayload;
                }
            }, 1, null);
            Uri uriCreateLocation$urbanairship_core_release = createLocation$urbanairship_core_release(str);
            Request request = new Request(uriCreateLocation$urbanairship_core_release, "PUT", new RequestAuth.ChannelTokenAuth(str2), new RequestBody.Json(channelRegistrationPayload), MapsKt.mapOf(TuplesKt.m1842to("Accept", "application/vnd.urbanairship+json; version=3;")), false, 32, null);
            SuspendingRequestSession suspendingRequestSession = this.session;
            channelApiClient$updateChannel$1.L$0 = str2;
            channelApiClient$updateChannel$1.L$1 = uriCreateLocation$urbanairship_core_release;
            channelApiClient$updateChannel$1.label = 1;
            Object objExecute = suspendingRequestSession.execute(request, channelApiClient$updateChannel$1);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objExecute;
            uri = uriCreateLocation$urbanairship_core_release;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            uri = (Uri) channelApiClient$updateChannel$1.L$1;
            str2 = (String) channelApiClient$updateChannel$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        final RequestResult map = ((RequestResult) obj).map(new Function1() { // from class: com.urbanairship.channel.ChannelApiClient$updateChannel$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Channel invoke(Unit unit) {
                return new Channel(str2, String.valueOf(uri));
            }
        });
        SuspendingRequestSessionKt.log(map, new Function0() { // from class: com.urbanairship.channel.ChannelApiClient$updateChannel$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Updating channel " + str2 + " finished with result: " + map;
            }
        });
        return map;
    }

    @Nullable
    public final Uri createLocation$urbanairship_core_release(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return this.runtimeConfig.getDeviceUrl().appendEncodedPath("api/channels/").appendPath(channelId).build();
    }
}
