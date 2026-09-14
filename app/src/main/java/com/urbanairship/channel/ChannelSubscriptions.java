package com.urbanairship.channel;

import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.util.CachedValue;
import com.urbanairship.util.Clock;
import com.urbanairship.util.SerialQueue;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ*\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0086@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0082@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, m1836d2 = {"Lcom/urbanairship/channel/ChannelSubscriptions;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/audience/AudienceOverridesProvider;)V", "subscriptionListApiClient", "Lcom/urbanairship/channel/SubscriptionListApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/channel/SubscriptionListApiClient;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/util/Clock;)V", "subscriptionFetchQueue", "Lcom/urbanairship/util/SerialQueue;", "subscriptionListCache", "Lcom/urbanairship/util/CachedValue;", "Lcom/urbanairship/channel/SubscriptionsResult;", "fetchSubscriptionLists", "Lkotlin/Result;", "", "", "channelId", "fetchSubscriptionLists-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveSubscriptionLists", "resolveSubscriptionLists-gIAlu-s", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nChannelSubscriptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelSubscriptions.kt\ncom/urbanairship/channel/ChannelSubscriptions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1855#2,2:74\n*S KotlinDebug\n*F\n+ 1 ChannelSubscriptions.kt\ncom/urbanairship/channel/ChannelSubscriptions\n*L\n33#1:74,2\n*E\n"})
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

    /* JADX WARN: Code duplicated, block: B:38:0x0097  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1 A[LOOP:0: B:39:0x009b->B:41:0x00a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    @Nullable
    /* JADX INFO: renamed from: fetchSubscriptionLists-gIAlu-s, reason: not valid java name */
    public final Object m5078fetchSubscriptionListsgIAlus(@NotNull String str, @NotNull Continuation<? super Result<? extends Set<String>>> continuation) {
        ChannelSubscriptions$fetchSubscriptionLists$1 channelSubscriptions$fetchSubscriptionLists$1;
        Object objM5077resolveSubscriptionListsgIAlus;
        Set<String> set;
        List<SubscriptionListMutation> subscriptions;
        Iterator<T> it;
        if (continuation instanceof ChannelSubscriptions$fetchSubscriptionLists$1) {
            channelSubscriptions$fetchSubscriptionLists$1 = (ChannelSubscriptions$fetchSubscriptionLists$1) continuation;
            int i = channelSubscriptions$fetchSubscriptionLists$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelSubscriptions$fetchSubscriptionLists$1.label = i - Integer.MIN_VALUE;
            } else {
                channelSubscriptions$fetchSubscriptionLists$1 = new ChannelSubscriptions$fetchSubscriptionLists$1(this, continuation);
            }
        } else {
            channelSubscriptions$fetchSubscriptionLists$1 = new ChannelSubscriptions$fetchSubscriptionLists$1(this, continuation);
        }
        ChannelSubscriptions$fetchSubscriptionLists$1 channelSubscriptions$fetchSubscriptionLists$2 = channelSubscriptions$fetchSubscriptionLists$1;
        Object objChannelOverrides$urbanairship_core_release$default = channelSubscriptions$fetchSubscriptionLists$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelSubscriptions$fetchSubscriptionLists$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objChannelOverrides$urbanairship_core_release$default);
            channelSubscriptions$fetchSubscriptionLists$2.L$0 = this;
            channelSubscriptions$fetchSubscriptionLists$2.L$1 = str;
            channelSubscriptions$fetchSubscriptionLists$2.label = 1;
            objM5077resolveSubscriptionListsgIAlus = m5077resolveSubscriptionListsgIAlus(str, channelSubscriptions$fetchSubscriptionLists$2);
            if (objM5077resolveSubscriptionListsgIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 == 1) {
                str = (String) channelSubscriptions$fetchSubscriptionLists$2.L$1;
                this = (ChannelSubscriptions) channelSubscriptions$fetchSubscriptionLists$2.L$0;
                ResultKt.throwOnFailure(objChannelOverrides$urbanairship_core_release$default);
                objM5077resolveSubscriptionListsgIAlus = ((Result) objChannelOverrides$urbanairship_core_release$default).getValue();
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                set = (Set) channelSubscriptions$fetchSubscriptionLists$2.L$0;
                ResultKt.throwOnFailure(objChannelOverrides$urbanairship_core_release$default);
            }
            subscriptions = ((AudienceOverrides.Channel) objChannelOverrides$urbanairship_core_release$default).getSubscriptions();
            if (subscriptions != null) {
                it = subscriptions.iterator();
                while (it.hasNext()) {
                    ((SubscriptionListMutation) it.next()).apply(set);
                }
            }
            return Result.m5277constructorimpl(set);
        }
        Set set2 = (Set) (Result.m5282isFailureimpl(objM5077resolveSubscriptionListsgIAlus) ? null : objM5077resolveSubscriptionListsgIAlus);
        Set<String> mutableSet = set2 != null ? CollectionsKt.toMutableSet(set2) : null;
        if (Result.m5282isFailureimpl(objM5077resolveSubscriptionListsgIAlus) || mutableSet == null) {
            return objM5077resolveSubscriptionListsgIAlus;
        }
        AudienceOverridesProvider audienceOverridesProvider = this.audienceOverridesProvider;
        channelSubscriptions$fetchSubscriptionLists$2.L$0 = mutableSet;
        channelSubscriptions$fetchSubscriptionLists$2.L$1 = null;
        channelSubscriptions$fetchSubscriptionLists$2.label = 2;
        objChannelOverrides$urbanairship_core_release$default = AudienceOverridesProvider.channelOverrides$urbanairship_core_release$default(audienceOverridesProvider, str, null, channelSubscriptions$fetchSubscriptionLists$2, 2, null);
        if (objChannelOverrides$urbanairship_core_release$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        set = mutableSet;
        subscriptions = ((AudienceOverrides.Channel) objChannelOverrides$urbanairship_core_release$default).getSubscriptions();
        if (subscriptions != null) {
            it = subscriptions.iterator();
            while (it.hasNext()) {
                ((SubscriptionListMutation) it.next()).apply(set);
            }
        }
        return Result.m5277constructorimpl(set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: resolveSubscriptionLists-gIAlu-s, reason: not valid java name */
    public final Object m5077resolveSubscriptionListsgIAlus(String str, Continuation continuation) {
        ChannelSubscriptions$resolveSubscriptionLists$1 channelSubscriptions$resolveSubscriptionLists$1;
        if (continuation instanceof ChannelSubscriptions$resolveSubscriptionLists$1) {
            channelSubscriptions$resolveSubscriptionLists$1 = (ChannelSubscriptions$resolveSubscriptionLists$1) continuation;
            int i = channelSubscriptions$resolveSubscriptionLists$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelSubscriptions$resolveSubscriptionLists$1.label = i - Integer.MIN_VALUE;
            } else {
                channelSubscriptions$resolveSubscriptionLists$1 = new ChannelSubscriptions$resolveSubscriptionLists$1(this, continuation);
            }
        } else {
            channelSubscriptions$resolveSubscriptionLists$1 = new ChannelSubscriptions$resolveSubscriptionLists$1(this, continuation);
        }
        Object objRun = channelSubscriptions$resolveSubscriptionLists$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelSubscriptions$resolveSubscriptionLists$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objRun);
            SerialQueue serialQueue = this.subscriptionFetchQueue;
            ChannelSubscriptions$resolveSubscriptionLists$2 channelSubscriptions$resolveSubscriptionLists$2 = new ChannelSubscriptions$resolveSubscriptionLists$2(this, str, null);
            channelSubscriptions$resolveSubscriptionLists$1.label = 1;
            objRun = serialQueue.run(channelSubscriptions$resolveSubscriptionLists$2, channelSubscriptions$resolveSubscriptionLists$1);
            if (objRun == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRun);
        }
        return ((Result) objRun).getValue();
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
