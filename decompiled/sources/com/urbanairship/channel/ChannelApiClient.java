package com.urbanairship.channel;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.UrlBuilder;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/channel/ChannelApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "createChannel", "Lcom/urbanairship/http/RequestResult;", "Lcom/urbanairship/channel/Channel;", "channelPayload", "Lcom/urbanairship/channel/ChannelRegistrationPayload;", "createChannel$urbanairship_core_release", "(Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocation", "Landroid/net/Uri;", "channelId", "", "createLocation$urbanairship_core_release", "updateChannel", "updateChannel$urbanairship_core_release", "(Ljava/lang/String;Lcom/urbanairship/channel/ChannelRegistrationPayload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nChannelApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelApiClient.kt\ncom/urbanairship/channel/ChannelApiClient\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,102:1\n44#2,15:103\n*S KotlinDebug\n*F\n+ 1 ChannelApiClient.kt\ncom/urbanairship/channel/ChannelApiClient\n*L\n47#1:103,15\n*E\n"})
/* loaded from: classes5.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createChannel$urbanairship_core_release(@org.jetbrains.annotations.NotNull final com.urbanairship.channel.ChannelRegistrationPayload r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<com.urbanairship.channel.Channel>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.urbanairship.channel.ChannelApiClient$createChannel$1
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.channel.ChannelApiClient$createChannel$1 r0 = (com.urbanairship.channel.ChannelApiClient$createChannel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelApiClient$createChannel$1 r0 = new com.urbanairship.channel.ChannelApiClient$createChannel$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r15)
            goto L81
        L29:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L31:
            kotlin.ResultKt.throwOnFailure(r15)
            com.urbanairship.channel.ChannelApiClient$createChannel$2 r15 = new com.urbanairship.channel.ChannelApiClient$createChannel$2
            r15.<init>()
            r2 = 0
            com.urbanairship.UALog.d$default(r2, r15, r3, r2)
            com.urbanairship.config.AirshipRuntimeConfig r15 = r13.runtimeConfig
            com.urbanairship.config.UrlBuilder r15 = r15.getDeviceUrl()
            java.lang.String r2 = "api/channels/"
            com.urbanairship.config.UrlBuilder r15 = r15.appendEncodedPath(r2)
            java.lang.String r2 = "appendEncodedPath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r2)
            com.urbanairship.http.Request r2 = new com.urbanairship.http.Request
            android.net.Uri r5 = r15.build()
            com.urbanairship.http.RequestAuth$GeneratedAppToken r7 = com.urbanairship.http.RequestAuth.GeneratedAppToken.INSTANCE
            com.urbanairship.http.RequestBody$Json r8 = new com.urbanairship.http.RequestBody$Json
            r8.<init>(r14)
            java.lang.String r14 = "Accept"
            java.lang.String r4 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r14 = kotlin.TuplesKt.to(r14, r4)
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r14)
            r11 = 32
            r12 = 0
            java.lang.String r6 = "POST"
            r10 = 0
            r4 = r2
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.urbanairship.http.SuspendingRequestSession r13 = r13.session
            com.urbanairship.channel.ChannelApiClient$$ExternalSyntheticLambda0 r14 = new com.urbanairship.channel.ChannelApiClient$$ExternalSyntheticLambda0
            r14.<init>()
            r0.label = r3
            java.lang.Object r15 = r13.execute(r2, r14, r0)
            if (r15 != r1) goto L81
            return r1
        L81:
            r13 = r15
            com.urbanairship.http.RequestResult r13 = (com.urbanairship.http.RequestResult) r13
            com.urbanairship.channel.ChannelApiClient$createChannel$4$1 r14 = new com.urbanairship.channel.ChannelApiClient$createChannel$4$1
            r14.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelApiClient.createChannel$urbanairship_core_release(com.urbanairship.channel.ChannelRegistrationPayload, kotlin.coroutines.Continuation):java.lang.Object");
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
            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateChannel$urbanairship_core_release(@org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull final com.urbanairship.channel.ChannelRegistrationPayload r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<com.urbanairship.channel.Channel>> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof com.urbanairship.channel.ChannelApiClient$updateChannel$1
            if (r4 == 0) goto L1b
            r4 = r3
            com.urbanairship.channel.ChannelApiClient$updateChannel$1 r4 = (com.urbanairship.channel.ChannelApiClient$updateChannel$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.label = r5
            goto L20
        L1b:
            com.urbanairship.channel.ChannelApiClient$updateChannel$1 r4 = new com.urbanairship.channel.ChannelApiClient$updateChannel$1
            r4.<init>(r0, r3)
        L20:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 1
            if (r6 == 0) goto L41
            if (r6 != r7) goto L39
            java.lang.Object r0 = r4.L$1
            android.net.Uri r0 = (android.net.Uri) r0
            java.lang.Object r1 = r4.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L89
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.ResultKt.throwOnFailure(r3)
            com.urbanairship.channel.ChannelApiClient$updateChannel$2 r3 = new com.urbanairship.channel.ChannelApiClient$updateChannel$2
            r3.<init>()
            r6 = 0
            com.urbanairship.UALog.d$default(r6, r3, r7, r6)
            android.net.Uri r3 = r18.createLocation$urbanairship_core_release(r19)
            com.urbanairship.http.Request r6 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$ChannelTokenAuth r11 = new com.urbanairship.http.RequestAuth$ChannelTokenAuth
            r11.<init>(r1)
            com.urbanairship.http.RequestBody$Json r12 = new com.urbanairship.http.RequestBody$Json
            r12.<init>(r2)
            java.lang.String r2 = "Accept"
            java.lang.String r8 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r8)
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r2)
            r15 = 32
            r16 = 0
            java.lang.String r10 = "PUT"
            r14 = 0
            r8 = r6
            r9 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            com.urbanairship.http.SuspendingRequestSession r0 = r0.session
            r4.L$0 = r1
            r4.L$1 = r3
            r4.label = r7
            java.lang.Object r0 = r0.execute(r6, r4)
            if (r0 != r5) goto L84
            return r5
        L84:
            r17 = r3
            r3 = r0
            r0 = r17
        L89:
            com.urbanairship.http.RequestResult r3 = (com.urbanairship.http.RequestResult) r3
            com.urbanairship.channel.ChannelApiClient$updateChannel$3 r2 = new com.urbanairship.channel.ChannelApiClient$updateChannel$3
            r2.<init>()
            com.urbanairship.http.RequestResult r0 = r3.map(r2)
            com.urbanairship.channel.ChannelApiClient$updateChannel$4$1 r2 = new com.urbanairship.channel.ChannelApiClient$updateChannel$4$1
            r2.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelApiClient.updateChannel$urbanairship_core_release(java.lang.String, com.urbanairship.channel.ChannelRegistrationPayload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Uri createLocation$urbanairship_core_release(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return this.runtimeConfig.getDeviceUrl().appendEncodedPath("api/channels/").appendPath(channelId).build();
    }
}
