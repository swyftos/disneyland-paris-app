package com.urbanairship.remoteconfig;

import android.content.Context;
import androidx.annotation.RestrictTo;
import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.json.JsonMap;
import com.urbanairship.remotedata.RemoteData;
import com.urbanairship.remotedata.RemoteDataPayload;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;

@OpenForTesting
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0010\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0012J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0012R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0092\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0092\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/remoteconfig/RemoteConfigManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "remoteData", "Lcom/urbanairship/remotedata/RemoteData;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/remotedata/RemoteData;Lkotlinx/coroutines/CoroutineDispatcher;)V", "privacyManagerListener", "com/urbanairship/remoteconfig/RemoteConfigManager$privacyManagerListener$1", "Lcom/urbanairship/remoteconfig/RemoteConfigManager$privacyManagerListener$1;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "subscription", "Lkotlinx/coroutines/Job;", "processConfig", "", "config", "Lcom/urbanairship/json/JsonMap;", "tearDown", "updateSubscription", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class RemoteConfigManager extends AirshipComponent {
    private static final Companion Companion = new Companion(null);
    private final PrivacyManager privacyManager;
    private final RemoteConfigManager$privacyManagerListener$1 privacyManagerListener;
    private final RemoteData remoteData;
    private final AirshipRuntimeConfig runtimeConfig;
    private final CoroutineScope scope;
    private Job subscription;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteConfigManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull RemoteData remoteData) {
        this(context, dataStore, runtimeConfig, privacyManager, remoteData, null, 32, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
    }

    public /* synthetic */ RemoteConfigManager(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, PrivacyManager privacyManager, RemoteData remoteData, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, remoteData, (i & 32) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.urbanairship.PrivacyManager$Listener, com.urbanairship.remoteconfig.RemoteConfigManager$privacyManagerListener$1] */
    @JvmOverloads
    public RemoteConfigManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull RemoteData remoteData, @NotNull CoroutineDispatcher dispatcher) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(remoteData, "remoteData");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.runtimeConfig = runtimeConfig;
        this.privacyManager = privacyManager;
        this.remoteData = remoteData;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        ?? r2 = new PrivacyManager.Listener() { // from class: com.urbanairship.remoteconfig.RemoteConfigManager$privacyManagerListener$1
            @Override // com.urbanairship.PrivacyManager.Listener
            public void onEnabledFeaturesChanged() {
                this.this$0.updateSubscription();
            }
        };
        this.privacyManagerListener = r2;
        updateSubscription();
        privacyManager.addListener(r2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubscription() {
        if (this.privacyManager.isAnyFeatureEnabled()) {
            Job job = this.subscription;
            if (job == null || !job.isActive()) {
                this.subscription = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(this.runtimeConfig.getPlatform() == 1 ? "app_config:amazon" : "app_config:android", null), 3, null);
                return;
            }
            return;
        }
        Job job2 = this.subscription;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    /* renamed from: com.urbanairship.remoteconfig.RemoteConfigManager$updateSubscription$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $platformConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation continuation) {
            super(2, continuation);
            this.$platformConfig = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteConfigManager.this.new AnonymousClass1(this.$platformConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<RemoteDataPayload>> flowPayloadFlow = RemoteConfigManager.this.remoteData.payloadFlow(CollectionsKt.listOf((Object[]) new String[]{"app_config", this.$platformConfig}));
                final RemoteConfigManager remoteConfigManager = RemoteConfigManager.this;
                FlowCollector<? super List<RemoteDataPayload>> flowCollector = new FlowCollector() { // from class: com.urbanairship.remoteconfig.RemoteConfigManager.updateSubscription.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(List list, Continuation continuation) {
                        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
                        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            builderNewBuilder.putAll(((RemoteDataPayload) it.next()).getData());
                        }
                        JsonMap jsonMapBuild = builderNewBuilder.build();
                        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
                        try {
                            remoteConfigManager.processConfig(jsonMapBuild);
                        } catch (Exception e) {
                            UALog.e(e, "Failed to process remote data", new Object[0]);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowPayloadFlow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processConfig(JsonMap config) {
        this.runtimeConfig.updateRemoteConfig(RemoteConfig.INSTANCE.fromJson(config));
    }

    @Override // com.urbanairship.AirshipComponent
    protected void tearDown() {
        super.tearDown();
        Job job = this.subscription;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.privacyManager.removeListener(this.privacyManagerListener);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
