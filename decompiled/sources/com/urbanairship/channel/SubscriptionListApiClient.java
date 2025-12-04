package com.urbanairship.channel;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbanairship/channel/SubscriptionListApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "getSubscriptionLists", "Lcom/urbanairship/http/RequestResult;", "", "", "channelId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubscriptionListApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionListApiClient.kt\ncom/urbanairship/channel/SubscriptionListApiClient\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n79#2,16:57\n1549#3:73\n1620#3,3:74\n*S KotlinDebug\n*F\n+ 1 SubscriptionListApiClient.kt\ncom/urbanairship/channel/SubscriptionListApiClient\n*L\n45#1:57,16\n46#1:73\n46#1:74,3\n*E\n"})
/* loaded from: classes5.dex */
public class SubscriptionListApiClient {
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    /* renamed from: com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubscriptionListApiClient.getSubscriptionLists$suspendImpl(SubscriptionListApiClient.this, null, this);
        }
    }

    @Nullable
    public Object getSubscriptionLists(@NotNull String str, @NotNull Continuation<? super RequestResult<Set<String>>> continuation) {
        return getSubscriptionLists$suspendImpl(this, str, continuation);
    }

    public SubscriptionListApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(session, "session");
        this.runtimeConfig = runtimeConfig;
        this.session = session;
    }

    public /* synthetic */ SubscriptionListApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object getSubscriptionLists$suspendImpl(com.urbanairship.channel.SubscriptionListApiClient r13, final java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            boolean r0 = r15 instanceof com.urbanairship.channel.SubscriptionListApiClient.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$1 r0 = (com.urbanairship.channel.SubscriptionListApiClient.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$1 r0 = new com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r13 = r0.L$0
            r14 = r13
            java.lang.String r14 = (java.lang.String) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L91
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            com.urbanairship.config.AirshipRuntimeConfig r15 = r13.runtimeConfig
            com.urbanairship.config.UrlBuilder r15 = r15.getDeviceUrl()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "api/subscription_lists/channels/"
            r2.append(r4)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.urbanairship.config.UrlBuilder r15 = r15.appendEncodedPath(r2)
            android.net.Uri r5 = r15.build()
            java.lang.String r15 = "Accept"
            java.lang.String r2 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r2)
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r15)
            com.urbanairship.http.Request r15 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$ChannelTokenAuth r7 = new com.urbanairship.http.RequestAuth$ChannelTokenAuth
            r7.<init>(r14)
            r11 = 40
            r12 = 0
            java.lang.String r6 = "GET"
            r8 = 0
            r10 = 0
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$2 r2 = new com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$2
            r2.<init>()
            r4 = 0
            com.urbanairship.UALog.d$default(r4, r2, r3, r4)
            com.urbanairship.http.SuspendingRequestSession r13 = r13.session
            com.urbanairship.channel.SubscriptionListApiClient$$ExternalSyntheticLambda0 r2 = new com.urbanairship.channel.SubscriptionListApiClient$$ExternalSyntheticLambda0
            r2.<init>()
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r15 = r13.execute(r15, r2, r0)
            if (r15 != r1) goto L91
            return r1
        L91:
            r13 = r15
            com.urbanairship.http.RequestResult r13 = (com.urbanairship.http.RequestResult) r13
            com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$4$1 r0 = new com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$4$1
            r0.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r13, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.SubscriptionListApiClient.getSubscriptionLists$suspendImpl(com.urbanairship.channel.SubscriptionListApiClient, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set getSubscriptionLists$lambda$1(int i, Map map, String str) throws JsonException {
        JsonList jsonListOptList;
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        JsonList jsonList = null;
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonMap jsonMapRequireMap = JsonValue.parseString(str).requireMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
        JsonValue jsonValue = jsonMapRequireMap.get("list_ids");
        if (jsonValue != null) {
            Intrinsics.checkNotNull(jsonValue);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonList.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) objOptString2;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                jsonListOptList = (JsonList) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                jsonListOptList = (JsonList) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                jsonListOptList = (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonListOptList = (JsonList) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonListOptList = (JsonList) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jsonListOptList = (JsonList) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonListOptList = (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                jsonListOptList = jsonValue.optList();
                if (jsonListOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Iterable iterableOptMap = jsonValue.optMap();
                if (iterableOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) iterableOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field 'list_ids" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                JsonSerializable jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
                }
                jsonListOptList = (JsonList) jsonValue2;
            }
            jsonList = jsonListOptList;
        }
        if (jsonList != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonList, 10));
            Iterator<JsonValue> it = jsonList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().requireString());
            }
            Set set = CollectionsKt.toSet(arrayList);
            if (set != null) {
                return set;
            }
        }
        return SetsKt.emptySet();
    }
}
