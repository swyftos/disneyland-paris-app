package com.urbanairship.contacts;

import ch.qos.logback.core.joran.action.Action;
import com.allegion.accesssdk.BuildConfig;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t0\b2\u0006\u0010\r\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/contacts/SubscriptionListApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "getSubscriptionLists", "Lcom/urbanairship/http/RequestResult;", "", "", "", "Lcom/urbanairship/contacts/Scope;", "contactId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubscriptionListApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionListApiClient.kt\ncom/urbanairship/contacts/SubscriptionListApiClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,85:1\n1549#2:86\n1620#2,3:87\n1238#2,4:92\n453#3:90\n403#3:91\n*S KotlinDebug\n*F\n+ 1 SubscriptionListApiClient.kt\ncom/urbanairship/contacts/SubscriptionListApiClient\n*L\n56#1:86\n56#1:87,3\n69#1:92,4\n69#1:90\n69#1:91\n*E\n"})
/* loaded from: classes5.dex */
public class SubscriptionListApiClient {
    private static final Companion Companion = new Companion(null);
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    /* renamed from: com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$1, reason: invalid class name */
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
    public Object getSubscriptionLists(@NotNull String str, @NotNull Continuation<? super RequestResult<Map<String, Set<Scope>>>> continuation) {
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
    static /* synthetic */ java.lang.Object getSubscriptionLists$suspendImpl(com.urbanairship.contacts.SubscriptionListApiClient r13, final java.lang.String r14, kotlin.coroutines.Continuation r15) {
        /*
            boolean r0 = r15 instanceof com.urbanairship.contacts.SubscriptionListApiClient.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r15
            com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$1 r0 = (com.urbanairship.contacts.SubscriptionListApiClient.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$1 r0 = new com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$1
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
            goto La3
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
            java.lang.String r4 = "api/subscription_lists/contacts/"
            r2.append(r4)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.urbanairship.config.UrlBuilder r15 = r15.appendEncodedPath(r2)
            android.net.Uri r5 = r15.build()
            java.lang.String r15 = "Accept"
            java.lang.String r2 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r15 = kotlin.TuplesKt.to(r15, r2)
            com.urbanairship.config.AirshipRuntimeConfig r2 = r13.runtimeConfig
            com.urbanairship.AirshipConfigOptions r2 = r2.getConfigOptions()
            java.lang.String r2 = r2.appKey
            java.lang.String r4 = "X-UA-Appkey"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r4, r2)
            kotlin.Pair[] r15 = new kotlin.Pair[]{r15, r2}
            java.util.Map r9 = kotlin.collections.MapsKt.mapOf(r15)
            com.urbanairship.http.Request r15 = new com.urbanairship.http.Request
            com.urbanairship.http.RequestAuth$ContactTokenAuth r7 = new com.urbanairship.http.RequestAuth$ContactTokenAuth
            r7.<init>(r14)
            r11 = 40
            r12 = 0
            java.lang.String r6 = "GET"
            r8 = 0
            r10 = 0
            r4 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$2 r2 = new com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$2
            r2.<init>()
            r4 = 0
            com.urbanairship.UALog.d$default(r4, r2, r3, r4)
            com.urbanairship.http.SuspendingRequestSession r13 = r13.session
            com.urbanairship.contacts.SubscriptionListApiClient$$ExternalSyntheticLambda0 r2 = new com.urbanairship.contacts.SubscriptionListApiClient$$ExternalSyntheticLambda0
            r2.<init>()
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r15 = r13.execute(r15, r2, r0)
            if (r15 != r1) goto La3
            return r1
        La3:
            r13 = r15
            com.urbanairship.http.RequestResult r13 = (com.urbanairship.http.RequestResult) r13
            com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$4$1 r0 = new com.urbanairship.contacts.SubscriptionListApiClient$getSubscriptionLists$4$1
            r0.<init>()
            com.urbanairship.http.SuspendingRequestSessionKt.log(r13, r0)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.SubscriptionListApiClient.getSubscriptionLists$suspendImpl(com.urbanairship.contacts.SubscriptionListApiClient, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getSubscriptionLists$lambda$2(int i, Map map, String str) throws JsonException {
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (!UAHttpStatusUtil.inSuccessRange(i)) {
            return null;
        }
        JsonList jsonListRequireList = JsonValue.parseString(str).requireMap().require("subscription_lists").requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        for (JsonValue jsonValue : jsonListRequireList) {
            Scope scopeFromJson = Scope.fromJson(jsonValue.optMap().opt(Action.SCOPE_ATTRIBUTE));
            Intrinsics.checkNotNullExpressionValue(scopeFromJson, "fromJson(...)");
            Iterator<JsonValue> it = jsonValue.optMap().opt("list_ids").optList().iterator();
            while (it.hasNext()) {
                String strRequireString = it.next().requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Set hashSet = (Set) linkedHashMap.get(strRequireString);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    linkedHashMap.put(strRequireString, hashSet);
                }
                hashSet.add(scopeFromJson);
            }
            arrayList.add(Unit.INSTANCE);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.toSet((Iterable) entry.getValue()));
        }
        return MapsKt.toMap(linkedHashMap2);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
