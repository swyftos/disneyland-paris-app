package com.urbanairship.channel;

import android.net.Uri;
import com.allegion.accesssdk.BuildConfig;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.config.UrlBuilder;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002Jd\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/channel/ChannelBatchUpdateApiClient;", "", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "bulkUpdateUrl", "Landroid/net/Uri;", "channelId", "", "update", "Lcom/urbanairship/http/RequestResult;", "", FetchDeviceInfoAction.TAGS_KEY, "", "Lcom/urbanairship/channel/TagGroupsMutation;", "attributes", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptions", "Lcom/urbanairship/channel/SubscriptionListMutation;", "liveUpdates", "Lcom/urbanairship/channel/LiveUpdateMutation;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelBatchUpdateApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelBatchUpdateApiClient.kt\ncom/urbanairship/channel/ChannelBatchUpdateApiClient\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
/* loaded from: classes5.dex */
public final class ChannelBatchUpdateApiClient {
    private static final Companion Companion = new Companion(null);
    private final AirshipRuntimeConfig config;
    private final SuspendingRequestSession session;

    /* renamed from: com.urbanairship.channel.ChannelBatchUpdateApiClient$update$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelBatchUpdateApiClient.this.update(null, null, null, null, null, this);
        }
    }

    public ChannelBatchUpdateApiClient(@NotNull AirshipRuntimeConfig config, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(session, "session");
        this.config = config;
        this.session = session;
    }

    public /* synthetic */ ChannelBatchUpdateApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull final java.lang.String r18, @org.jetbrains.annotations.Nullable java.util.List<? extends com.urbanairship.channel.TagGroupsMutation> r19, @org.jetbrains.annotations.Nullable java.util.List<? extends com.urbanairship.channel.AttributeMutation> r20, @org.jetbrains.annotations.Nullable java.util.List<? extends com.urbanairship.channel.SubscriptionListMutation> r21, @org.jetbrains.annotations.Nullable java.util.List<? extends com.urbanairship.channel.LiveUpdateMutation> r22, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.urbanairship.http.RequestResult<kotlin.Unit>> r23) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r23
            boolean r3 = r2 instanceof com.urbanairship.channel.ChannelBatchUpdateApiClient.AnonymousClass1
            if (r3 == 0) goto L19
            r3 = r2
            com.urbanairship.channel.ChannelBatchUpdateApiClient$update$1 r3 = (com.urbanairship.channel.ChannelBatchUpdateApiClient.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.urbanairship.channel.ChannelBatchUpdateApiClient$update$1 r3 = new com.urbanairship.channel.ChannelBatchUpdateApiClient$update$1
            r3.<init>(r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L39
            if (r5 != r6) goto L31
            kotlin.ResultKt.throwOnFailure(r2)
            goto Ld1
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r19 == 0) goto L4f
            boolean r2 = r19.isEmpty()
            if (r2 == 0) goto L46
            r2 = r7
            goto L48
        L46:
            r2 = r19
        L48:
            if (r2 == 0) goto L4f
            com.urbanairship.json.JsonMap r2 = com.urbanairship.channel.ChannelBatchUpdateApiClientKt.access$tagsPayload(r2)
            goto L50
        L4f:
            r2 = r7
        L50:
            java.lang.String r5 = "tags"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r5, r2)
            if (r20 == 0) goto L62
            boolean r5 = r20.isEmpty()
            if (r5 == 0) goto L5f
            goto L62
        L5f:
            r5 = r20
            goto L63
        L62:
            r5 = r7
        L63:
            java.lang.String r8 = "attributes"
            kotlin.Pair r5 = kotlin.TuplesKt.to(r8, r5)
            if (r21 == 0) goto L75
            boolean r8 = r21.isEmpty()
            if (r8 == 0) goto L72
            goto L75
        L72:
            r8 = r21
            goto L76
        L75:
            r8 = r7
        L76:
            java.lang.String r9 = "subscription_lists"
            kotlin.Pair r8 = kotlin.TuplesKt.to(r9, r8)
            if (r22 == 0) goto L88
            boolean r9 = r22.isEmpty()
            if (r9 == 0) goto L85
            goto L88
        L85:
            r9 = r22
            goto L89
        L88:
            r9 = r7
        L89:
            java.lang.String r10 = "live_updates"
            kotlin.Pair r9 = kotlin.TuplesKt.to(r10, r9)
            kotlin.Pair[] r2 = new kotlin.Pair[]{r2, r5, r8, r9}
            com.urbanairship.json.JsonMap r2 = com.urbanairship.json.JsonExtensionsKt.jsonMapOf(r2)
            com.urbanairship.channel.ChannelBatchUpdateApiClient$update$2 r5 = new com.urbanairship.channel.ChannelBatchUpdateApiClient$update$2
            r5.<init>()
            com.urbanairship.UALog.v$default(r7, r5, r6, r7)
            com.urbanairship.http.Request r5 = new com.urbanairship.http.Request
            android.net.Uri r9 = r17.bulkUpdateUrl(r18)
            com.urbanairship.http.RequestAuth$ChannelTokenAuth r11 = new com.urbanairship.http.RequestAuth$ChannelTokenAuth
            r11.<init>(r1)
            com.urbanairship.http.RequestBody$Json r12 = new com.urbanairship.http.RequestBody$Json
            r12.<init>(r2)
            java.lang.String r1 = "Accept"
            java.lang.String r2 = "application/vnd.urbanairship+json; version=3;"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r2)
            java.util.Map r13 = kotlin.collections.MapsKt.mapOf(r1)
            r15 = 32
            r16 = 0
            java.lang.String r10 = "PUT"
            r14 = 0
            r8 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            com.urbanairship.http.SuspendingRequestSession r0 = r0.session
            r3.label = r6
            java.lang.Object r2 = r0.execute(r5, r3)
            if (r2 != r4) goto Ld1
            return r4
        Ld1:
            com.urbanairship.http.RequestResult r2 = (com.urbanairship.http.RequestResult) r2
            com.urbanairship.channel.ChannelBatchUpdateApiClient$update$3 r0 = new com.urbanairship.channel.ChannelBatchUpdateApiClient$update$3
            r0.<init>()
            com.urbanairship.UALog.d$default(r7, r0, r6, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelBatchUpdateApiClient.update(java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Uri bulkUpdateUrl(String channelId) {
        String str;
        UrlBuilder urlBuilderAppendPath = this.config.getDeviceUrl().appendEncodedPath("api/channels/sdk/batch").appendPath(channelId);
        Intrinsics.checkNotNullExpressionValue(urlBuilderAppendPath, "appendPath(...)");
        int platform = this.config.getPlatform();
        if (platform != 1) {
            str = platform != 2 ? null : "android";
        } else {
            str = "amazon";
        }
        if (str != null) {
            urlBuilderAppendPath.appendQueryParameter(DeferredApiClient.KEY_PLATFORM, str);
        }
        return urlBuilderAppendPath.build();
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
