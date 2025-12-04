package com.urbanairship.channel;

import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.util.CachedValue;
import com.urbanairship.util.Clock;
import com.urbanairship.util.SerialQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ*\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/channel/ChannelSubscriptions;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/audience/AudienceOverridesProvider;)V", "subscriptionListApiClient", "Lcom/urbanairship/channel/SubscriptionListApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/channel/SubscriptionListApiClient;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/util/Clock;)V", "subscriptionFetchQueue", "Lcom/urbanairship/util/SerialQueue;", "subscriptionListCache", "Lcom/urbanairship/util/CachedValue;", "Lcom/urbanairship/channel/SubscriptionsResult;", "fetchSubscriptionLists", "Lkotlin/Result;", "", "", "channelId", "fetchSubscriptionLists-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveSubscriptionLists", "resolveSubscriptionLists-gIAlu-s", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelSubscriptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelSubscriptions.kt\ncom/urbanairship/channel/ChannelSubscriptions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1855#2,2:74\n*S KotlinDebug\n*F\n+ 1 ChannelSubscriptions.kt\ncom/urbanairship/channel/ChannelSubscriptions\n*L\n33#1:74,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ChannelSubscriptions {
    private static final Companion Companion = new Companion(null);
    private final AudienceOverridesProvider audienceOverridesProvider;
    private final Clock clock;
    private final SerialQueue subscriptionFetchQueue;
    private final SubscriptionListApiClient subscriptionListApiClient;
    private final CachedValue subscriptionListCache;

    public ChannelSubscriptions(@NotNull SubscriptionListApiClient subscriptionListApiClient, @NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(subscriptionListApiClient, "subscriptionListApiClient");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.subscriptionListApiClient = subscriptionListApiClient;
        this.audienceOverridesProvider = audienceOverridesProvider;
        this.clock = clock;
        this.subscriptionFetchQueue = new SerialQueue();
        this.subscriptionListCache = new CachedValue(clock);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ChannelSubscriptions(SubscriptionListApiClient subscriptionListApiClient, AudienceOverridesProvider audienceOverridesProvider, Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(subscriptionListApiClient, audienceOverridesProvider, DEFAULT_CLOCK);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelSubscriptions(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull AudienceOverridesProvider audienceOverridesProvider) {
        this(new SubscriptionListApiClient(runtimeConfig, null, 2, 0 == true ? 1 : 0), audienceOverridesProvider, null, 4, null);
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: fetchSubscriptionLists-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2836fetchSubscriptionListsgIAlus(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.Set<java.lang.String>>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.urbanairship.channel.ChannelSubscriptions$fetchSubscriptionLists$1
            if (r0 == 0) goto L14
            r0 = r10
            com.urbanairship.channel.ChannelSubscriptions$fetchSubscriptionLists$1 r0 = (com.urbanairship.channel.ChannelSubscriptions$fetchSubscriptionLists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.urbanairship.channel.ChannelSubscriptions$fetchSubscriptionLists$1 r0 = new com.urbanairship.channel.ChannelSubscriptions$fetchSubscriptionLists$1
            r0.<init>(r8, r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L4d
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.lang.Object r8 = r4.L$0
            java.util.Set r8 = (java.util.Set) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8f
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r8 = r4.L$1
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r8 = r4.L$0
            com.urbanairship.channel.ChannelSubscriptions r8 = (com.urbanairship.channel.ChannelSubscriptions) r8
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.getValue()
            goto L5d
        L4d:
            kotlin.ResultKt.throwOnFailure(r10)
            r4.L$0 = r8
            r4.L$1 = r9
            r4.label = r3
            java.lang.Object r10 = r8.m2835resolveSubscriptionListsgIAlus(r9, r4)
            if (r10 != r0) goto L5d
            return r0
        L5d:
            boolean r1 = kotlin.Result.m2973isFailureimpl(r10)
            r3 = 0
            if (r1 == 0) goto L66
            r1 = r3
            goto L67
        L66:
            r1 = r10
        L67:
            java.util.Set r1 = (java.util.Set) r1
            if (r1 == 0) goto L71
            java.util.Set r1 = kotlin.collections.CollectionsKt.toMutableSet(r1)
            r7 = r1
            goto L72
        L71:
            r7 = r3
        L72:
            boolean r1 = kotlin.Result.m2973isFailureimpl(r10)
            if (r1 != 0) goto Lb0
            if (r7 != 0) goto L7b
            goto Lb0
        L7b:
            com.urbanairship.audience.AudienceOverridesProvider r1 = r8.audienceOverridesProvider
            r4.L$0 = r7
            r4.L$1 = r3
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r9
            java.lang.Object r10 = com.urbanairship.audience.AudienceOverridesProvider.channelOverrides$urbanairship_core_release$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L8e
            return r0
        L8e:
            r8 = r7
        L8f:
            com.urbanairship.audience.AudienceOverrides$Channel r10 = (com.urbanairship.audience.AudienceOverrides.Channel) r10
            java.util.List r9 = r10.getSubscriptions()
            if (r9 == 0) goto Lab
            java.util.Iterator r9 = r9.iterator()
        L9b:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lab
            java.lang.Object r10 = r9.next()
            com.urbanairship.channel.SubscriptionListMutation r10 = (com.urbanairship.channel.SubscriptionListMutation) r10
            r10.apply(r8)
            goto L9b
        Lab:
            java.lang.Object r8 = kotlin.Result.m2968constructorimpl(r8)
            return r8
        Lb0:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelSubscriptions.m2836fetchSubscriptionListsgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: resolveSubscriptionLists-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m2835resolveSubscriptionListsgIAlus(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$1 r0 = (com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$1 r0 = new com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.urbanairship.util.SerialQueue r7 = r5.subscriptionFetchQueue
            com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$2 r2 = new com.urbanairship.channel.ChannelSubscriptions$resolveSubscriptionLists$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = r7.run(r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.ChannelSubscriptions.m2835resolveSubscriptionListsgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
