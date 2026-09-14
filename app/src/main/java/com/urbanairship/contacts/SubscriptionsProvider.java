package com.urbanairship.contacts;

import ch.qos.logback.core.net.SyslogConstants;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PrivacyManager;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.util.AutoRefreshingDataProvider;
import com.urbanairship.util.Clock;
import com.urbanairship.util.TaskSleeper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u0012\u0004\u0012\u00020\u00060\u0001B3\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0002\u0010\u000eBO\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J<\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J6\u0010\u001b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006 "}, m1836d2 = {"Lcom/urbanairship/contacts/SubscriptionsProvider;", "Lcom/urbanairship/util/AutoRefreshingDataProvider;", "", "", "", "Lcom/urbanairship/contacts/Scope;", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "stableContactIdUpdates", "Lkotlinx/coroutines/flow/Flow;", "overrideUpdates", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "apiClient", "Lcom/urbanairship/contacts/SubscriptionListApiClient;", "clock", "Lcom/urbanairship/util/Clock;", "taskSleeper", "Lcom/urbanairship/util/TaskSleeper;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/contacts/SubscriptionListApiClient;Lcom/urbanairship/PrivacyManager;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lcom/urbanairship/util/Clock;Lcom/urbanairship/util/TaskSleeper;Lkotlinx/coroutines/CoroutineDispatcher;)V", "onApplyOverrides", "data", "overrides", "onFetch", "Lkotlin/Result;", "identifier", "onFetch-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nSubscriptionsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubscriptionsProvider.kt\ncom/urbanairship/contacts/SubscriptionsProvider\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,76:1\n453#2:77\n403#2:78\n1238#3,4:79\n1855#3,2:83\n*S KotlinDebug\n*F\n+ 1 SubscriptionsProvider.kt\ncom/urbanairship/contacts/SubscriptionsProvider\n*L\n67#1:77\n67#1:78\n67#1:79,4\n69#1:83,2\n*E\n"})
public final class SubscriptionsProvider extends AutoRefreshingDataProvider<Map<String, ? extends Set<? extends Scope>>, AudienceOverrides.Contact> {
    private final SubscriptionListApiClient apiClient;
    private final PrivacyManager privacyManager;

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
    public SubscriptionsProvider(@NotNull SubscriptionListApiClient apiClient, @NotNull PrivacyManager privacyManager, @NotNull Flow<String> stableContactIdUpdates, @NotNull Flow<AudienceOverrides.Contact> overrideUpdates, @NotNull Clock clock, @NotNull TaskSleeper taskSleeper, @NotNull CoroutineDispatcher dispatcher) {
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
    public SubscriptionsProvider(@NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull Flow<String> stableContactIdUpdates, @NotNull Flow<AudienceOverrides.Contact> overrideUpdates) {
        this(new SubscriptionListApiClient(config, null, 2, 0 == true ? 1 : 0), privacyManager, stableContactIdUpdates, overrideUpdates, null, null, null, SyslogConstants.LOG_ALERT, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(stableContactIdUpdates, "stableContactIdUpdates");
        Intrinsics.checkNotNullParameter(overrideUpdates, "overrideUpdates");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.urbanairship.util.AutoRefreshingDataProvider
    @Nullable
    /* JADX INFO: renamed from: onFetch-gIAlu-s */
    public Object mo5079onFetchgIAlus(@NotNull String str, @NotNull Continuation<? super Result<? extends Map<String, ? extends Set<? extends Scope>>>> continuation) {
        SubscriptionsProvider$onFetch$1 subscriptionsProvider$onFetch$1;
        if (continuation instanceof SubscriptionsProvider$onFetch$1) {
            subscriptionsProvider$onFetch$1 = (SubscriptionsProvider$onFetch$1) continuation;
            int i = subscriptionsProvider$onFetch$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                subscriptionsProvider$onFetch$1.label = i - Integer.MIN_VALUE;
            } else {
                subscriptionsProvider$onFetch$1 = new SubscriptionsProvider$onFetch$1(this, continuation);
            }
        } else {
            subscriptionsProvider$onFetch$1 = new SubscriptionsProvider$onFetch$1(this, continuation);
        }
        Object subscriptionLists = subscriptionsProvider$onFetch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = subscriptionsProvider$onFetch$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(subscriptionLists);
            if (!ContactKt.isContactsAudienceEnabled(this.privacyManager)) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m5277constructorimpl(ResultKt.createFailure(new IllegalStateException("Unable to fetch subscriptions when FEATURE_TAGS_AND_ATTRIBUTES or FEATURE_CONTACTS are disabled")));
            }
            SubscriptionListApiClient subscriptionListApiClient = this.apiClient;
            subscriptionsProvider$onFetch$1.label = 1;
            subscriptionLists = subscriptionListApiClient.getSubscriptionLists(str, subscriptionsProvider$onFetch$1);
            if (subscriptionLists == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(subscriptionLists);
        }
        RequestResult requestResult = (RequestResult) subscriptionLists;
        if (requestResult.isSuccessful() && requestResult.getValue() != null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m5277constructorimpl(requestResult.getValue());
        }
        Result.Companion companion3 = Result.INSTANCE;
        Throwable exception = requestResult.getException();
        if (exception == null) {
            exception = new IllegalStateException("Missing response body");
        }
        return Result.m5277constructorimpl(ResultKt.createFailure(exception));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbanairship.util.AutoRefreshingDataProvider
    @NotNull
    public Map<String, Set<Scope>> onApplyOverrides(@NotNull Map<String, ? extends Set<? extends Scope>> data, @NotNull AudienceOverrides.Contact overrides) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        List<ScopedSubscriptionListMutation> subscriptions = overrides.getSubscriptions();
        if (subscriptions == null || subscriptions.isEmpty()) {
            return data;
        }
        Map mutableMap = MapsKt.toMutableMap(data);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mutableMap.size()));
        for (Map.Entry entry : mutableMap.entrySet()) {
            linkedHashMap.put(entry.getKey(), CollectionsKt.toMutableSet((Iterable) entry.getValue()));
        }
        Iterator<T> it = subscriptions.iterator();
        while (it.hasNext()) {
            ((ScopedSubscriptionListMutation) it.next()).apply(linkedHashMap);
        }
        return linkedHashMap;
    }
}
