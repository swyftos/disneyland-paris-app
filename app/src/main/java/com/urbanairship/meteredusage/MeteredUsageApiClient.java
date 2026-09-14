package com.urbanairship.meteredusage;

import android.net.Uri;
import com.allegion.accesssdk.BuildConfig;
import com.contentsquare.android.core.utils.UriBuilder;
import com.facebook.hermes.intl.Constants;
import com.urbanairship.UAirship;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestBody;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonExtensionsKt;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lcom/urbanairship/meteredusage/MeteredUsageApiClient;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "uploadEvents", "Lcom/urbanairship/http/RequestResult;", "", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "", "Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "channelId", "", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nMeteredUsageApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MeteredUsageApiClient.kt\ncom/urbanairship/meteredusage/MeteredUsageApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,57:1\n1#2:58\n1549#3:59\n1620#3,3:60\n*S KotlinDebug\n*F\n+ 1 MeteredUsageApiClient.kt\ncom/urbanairship/meteredusage/MeteredUsageApiClient\n*L\n48#1:59\n48#1:60,3\n*E\n"})
public final class MeteredUsageApiClient {
    private final AirshipRuntimeConfig config;
    private SuspendingRequestSession session;

    /* JADX INFO: renamed from: com.urbanairship.meteredusage.MeteredUsageApiClient$uploadEvents$1 */
    static final class C56441 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C56441(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MeteredUsageApiClient.this.uploadEvents(null, null, this);
        }
    }

    public MeteredUsageApiClient(@NotNull AirshipRuntimeConfig config, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(session, "session");
        this.config = config;
        this.session = session;
    }

    public /* synthetic */ MeteredUsageApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    @Nullable
    public final Object uploadEvents(@NotNull List<MeteredUsageEventEntity> list, @Nullable String str, @NotNull Continuation<? super RequestResult<Unit>> continuation) throws InvalidParameterException {
        C56441 c56441;
        String str2;
        if (continuation instanceof C56441) {
            c56441 = (C56441) continuation;
            int i = c56441.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c56441.label = i - Integer.MIN_VALUE;
            } else {
                c56441 = new C56441(continuation);
            }
        } else {
            c56441 = new C56441(continuation);
        }
        Object objExecute = c56441.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c56441.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            Uri uriBuild = this.config.getMeteredUsageUrl().appendEncodedPath("api/metered-usage").build();
            if (uriBuild == null) {
                throw new InvalidParameterException("Missing metered usage URL");
            }
            int platform = this.config.getPlatform();
            if (platform != 1) {
                str2 = platform != 2 ? null : "android";
            } else {
                str2 = "amazon";
            }
            if (str2 == null) {
                throw new InvalidParameterException("Invalid platform");
            }
            Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.m1842to("X-UA-Lib-Version", UAirship.getVersion()), TuplesKt.m1842to("X-UA-Device-Family", str2), TuplesKt.m1842to("Content-Type", "application/json"), TuplesKt.m1842to("Accept", "application/vnd.urbanairship+json; version=3;"));
            if (str != null) {
                mapMutableMapOf.put("X-UA-Channel-ID", str);
            }
            Map map = MapsKt.toMap(mapMutableMapOf);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MeteredUsageEventEntity) it.next()).toJson$urbanairship_core_release());
            }
            Request request = new Request(uriBuild, "POST", RequestAuth.GeneratedAppToken.INSTANCE, new RequestBody.Json(JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to(Constants.COLLATION_OPTION_USAGE, arrayList))), map, false, 32, null);
            SuspendingRequestSession suspendingRequestSession = this.session;
            c56441.label = 1;
            objExecute = suspendingRequestSession.execute(request, c56441);
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
        SuspendingRequestSessionKt.log(requestResult, new Function0() { // from class: com.urbanairship.meteredusage.MeteredUsageApiClient$uploadEvents$3$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Usage result: " + requestResult;
            }
        });
        return objExecute;
    }
}
