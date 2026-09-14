package com.urbanairship.channel;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.config.AirshipRuntimeConfig;
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
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@OpenForTesting
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lcom/urbanairship/channel/SubscriptionListApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "getSubscriptionLists", "Lcom/urbanairship/http/RequestResult;", "", "", "channelId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSubscriptionListApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionListApiClient.kt\ncom/urbanairship/channel/SubscriptionListApiClient\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n79#2,16:57\n1549#3:73\n1620#3,3:74\n*S KotlinDebug\n*F\n+ 1 SubscriptionListApiClient.kt\ncom/urbanairship/channel/SubscriptionListApiClient\n*L\n45#1:57,16\n46#1:73\n46#1:74,3\n*E\n"})
public class SubscriptionListApiClient {
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    /* JADX INFO: renamed from: com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$1 */
    static final class C52001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52001(Continuation continuation) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static /* synthetic */ Object getSubscriptionLists$suspendImpl(SubscriptionListApiClient subscriptionListApiClient, final String str, Continuation continuation) {
        C52001 c52001;
        if (continuation instanceof C52001) {
            c52001 = (C52001) continuation;
            int i = c52001.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52001.label = i - Integer.MIN_VALUE;
            } else {
                c52001 = subscriptionListApiClient.new C52001(continuation);
            }
        } else {
            c52001 = subscriptionListApiClient.new C52001(continuation);
        }
        Object objExecute = c52001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52001.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            String str2 = "GET";
            RequestBody requestBody = null;
            final Request request = new Request(subscriptionListApiClient.runtimeConfig.getDeviceUrl().appendEncodedPath("api/subscription_lists/channels/" + str).build(), str2, new RequestAuth.ChannelTokenAuth(str), requestBody, MapsKt.mapOf(TuplesKt.m1842to("Accept", "application/vnd.urbanairship+json; version=3;")), false, 40, null);
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.SubscriptionListApiClient.getSubscriptionLists.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Fetching contact subscription lists for " + str + " request: " + request;
                }
            }, 1, null);
            SuspendingRequestSession suspendingRequestSession = subscriptionListApiClient.session;
            ResponseParser responseParser = new ResponseParser() { // from class: com.urbanairship.channel.SubscriptionListApiClient$$ExternalSyntheticLambda0
                @Override // com.urbanairship.http.ResponseParser
                public final Object parseResponse(int i3, Map map, String str3) {
                    return SubscriptionListApiClient.getSubscriptionLists$lambda$1(i3, map, str3);
                }
            };
            c52001.L$0 = str;
            c52001.label = 1;
            objExecute = suspendingRequestSession.execute(request, responseParser, c52001);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c52001.L$0;
            ResultKt.throwOnFailure(objExecute);
        }
        final RequestResult requestResult = (RequestResult) objExecute;
        SuspendingRequestSessionKt.log(requestResult, new Function0() { // from class: com.urbanairship.channel.SubscriptionListApiClient$getSubscriptionLists$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Fetching contact subscription lists for " + str + " finished with result: " + requestResult;
            }
        });
        return objExecute;
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
                jsonListOptList = (JsonList) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                jsonListOptList = (JsonList) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                jsonListOptList = (JsonList) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                jsonListOptList = (JsonList) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                jsonListOptList = (JsonList) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
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
