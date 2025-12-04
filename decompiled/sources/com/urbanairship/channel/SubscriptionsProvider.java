package com.urbanairship.channel;

import ch.qos.logback.core.net.SyslogConstants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PrivacyManager;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.util.AutoRefreshingDataProvider;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B3\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0002\u0010\fBO\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J*\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/channel/SubscriptionsProvider;", "Lcom/urbanairship/util/AutoRefreshingDataProvider;", "", "", "Lcom/urbanairship/audience/AudienceOverrides$Channel;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "stableContactIdUpdates", "Lkotlinx/coroutines/flow/Flow;", "overrideUpdates", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "apiClient", "Lcom/urbanairship/channel/SubscriptionListApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/channel/SubscriptionListApiClient;Lcom/urbanairship/PrivacyManager;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;)V", "onApplyOverrides", "data", "overrides", "onFetch", "Lkotlin/Result;", "identifier", "onFetch-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSubscriptionsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionsProvider.kt\ncom/urbanairship/channel/SubscriptionsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,74:1\n1855#2,2:75\n*S KotlinDebug\n*F\n+ 1 SubscriptionsProvider.kt\ncom/urbanairship/channel/SubscriptionsProvider\n*L\n67#1:75,2\n*E\n"})
/* loaded from: classes5.dex */
public final class SubscriptionsProvider extends AutoRefreshingDataProvider<Set<? extends String>, AudienceOverrides.Channel> {
    private final SubscriptionListApiClient apiClient;
    private final PrivacyManager privacyManager;

    @Override // com.urbanairship.util.AutoRefreshingDataProvider
    public /* bridge */ /* synthetic */ Set<? extends String> onApplyOverrides(Set<? extends String> set, AudienceOverrides.Channel channel) {
        return onApplyOverrides2((Set<String>) set, channel);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SubscriptionsProvider(SubscriptionListApiClient subscriptionListApiClient, PrivacyManager privacyManager, Flow flow, Flow flow2, Clock clock, TaskSleeper taskSleeper, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        if ((i & 16) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(subscriptionListApiClient, privacyManager, flow, flow2, clock2, (i & 32) != 0 ? TaskSleeper.INSTANCE.getDefault() : taskSleeper, (i & 64) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionsProvider(@NotNull SubscriptionListApiClient apiClient, @NotNull PrivacyManager privacyManager, @NotNull Flow<String> stableContactIdUpdates, @NotNull Flow<AudienceOverrides.Channel> overrideUpdates, @NotNull Clock clock, @NotNull TaskSleeper taskSleeper, @NotNull CoroutineDispatcher dispatcher) {
        super(stableContactIdUpdates, overrideUpdates, clock, taskSleeper, dispatcher);
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(stableContactIdUpdates, "stableContactIdUpdates");
        Intrinsics.checkNotNullParameter(overrideUpdates, "overrideUpdates");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(taskSleeper, "taskSleeper");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.apiClient = apiClient;
        this.privacyManager = privacyManager;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubscriptionsProvider(@NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull Flow<String> stableContactIdUpdates, @NotNull Flow<AudienceOverrides.Channel> overrideUpdates) {
        this(new SubscriptionListApiClient(config, null, 2, 0 == true ? 1 : 0), privacyManager, stableContactIdUpdates, overrideUpdates, null, null, null, SyslogConstants.LOG_ALERT, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(stableContactIdUpdates, "stableContactIdUpdates");
        Intrinsics.checkNotNullParameter(overrideUpdates, "overrideUpdates");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.util.AutoRefreshingDataProvider
    @org.jetbrains.annotations.Nullable
    /* renamed from: onFetch-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo2837onFetchgIAlus(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<? extends java.util.Set<? extends java.lang.String>>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.channel.SubscriptionsProvider$onFetch$1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.channel.SubscriptionsProvider$onFetch$1 r0 = (com.urbanairship.channel.SubscriptionsProvider$onFetch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.SubscriptionsProvider$onFetch$1 r0 = new com.urbanairship.channel.SubscriptionsProvider$onFetch$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.PrivacyManager r6 = r4.privacyManager
            com.urbanairship.PrivacyManager$Feature r2 = com.urbanairship.PrivacyManager.Feature.TAGS_AND_ATTRIBUTES
            com.urbanairship.PrivacyManager$Feature[] r2 = new com.urbanairship.PrivacyManager.Feature[]{r2}
            boolean r6 = r6.isEnabled(r2)
            if (r6 != 0) goto L54
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Unable to fetch subscriptions when FEATURE_TAGS_AND_ATTRIBUTES are disabled"
            r4.<init>(r5)
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m2968constructorimpl(r4)
            return r4
        L54:
            com.urbanairship.channel.SubscriptionListApiClient r4 = r4.apiClient
            r0.label = r3
            java.lang.Object r6 = r4.getSubscriptionLists(r5, r0)
            if (r6 != r1) goto L5f
            return r1
        L5f:
            com.urbanairship.http.RequestResult r6 = (com.urbanairship.http.RequestResult) r6
            boolean r4 = r6.isSuccessful()
            if (r4 == 0) goto L78
            java.lang.Object r4 = r6.getValue()
            if (r4 == 0) goto L78
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
            java.lang.Object r4 = r6.getValue()
            java.lang.Object r4 = kotlin.Result.m2968constructorimpl(r4)
            return r4
        L78:
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE
            java.lang.Throwable r4 = r6.getException()
            if (r4 != 0) goto L87
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Missing response body"
            r4.<init>(r5)
        L87:
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m2968constructorimpl(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.SubscriptionsProvider.mo2837onFetchgIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    /* renamed from: onApplyOverrides, reason: avoid collision after fix types in other method */
    public Set<String> onApplyOverrides2(@NotNull Set<String> data, @NotNull AudienceOverrides.Channel overrides) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List<SubscriptionListMutation> subscriptions = overrides.getSubscriptions();
        if (subscriptions != null && !subscriptions.isEmpty()) {
            data = CollectionsKt.toMutableSet(data);
            Iterator<T> it = subscriptions.iterator();
            while (it.hasNext()) {
                ((SubscriptionListMutation) it.next()).apply(data);
            }
        }
        return data;
    }
}
