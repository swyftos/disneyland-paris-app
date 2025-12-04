package com.urbanairship.automation.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.util.DerivedStateFlow;
import com.urbanairship.util.Network;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/automation/utils/NetworkMonitor;", "", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCN_NETWORK, "Lcom/urbanairship/util/Network;", "(Landroid/content/Context;Lcom/urbanairship/util/Network;)V", "isConnected", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "setConnected", "(Lkotlinx/coroutines/flow/StateFlow;)V", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NetworkMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private StateFlow isConnected;

    public NetworkMonitor(@NotNull final Context context, @NotNull final Network network) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(network, "network");
        this.isConnected = new DerivedStateFlow(new Function0() { // from class: com.urbanairship.automation.utils.NetworkMonitor.isConnected.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(network.isConnected(context));
            }
        }, FlowKt.callbackFlow(new AnonymousClass2(context, network, null)));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NetworkMonitor(Context context, Network network, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            network = Network.shared();
            Intrinsics.checkNotNullExpressionValue(network, "shared(...)");
        }
        this(context, network);
    }

    @NotNull
    public final StateFlow<Boolean> isConnected() {
        return this.isConnected;
    }

    public final void setConnected(@NotNull StateFlow<Boolean> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.isConnected = stateFlow;
    }

    /* renamed from: com.urbanairship.automation.utils.NetworkMonitor$isConnected$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ Network $network;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Network network, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$network = network;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$context, this.$network, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((AnonymousClass2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v1, types: [android.net.ConnectivityManager$NetworkCallback, com.urbanairship.automation.utils.NetworkMonitor$isConnected$2$callback$1] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.L$0;
                final ?? r1 = new ConnectivityManager.NetworkCallback() { // from class: com.urbanairship.automation.utils.NetworkMonitor$isConnected$2$callback$1
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(@NotNull android.net.Network network) {
                        Intrinsics.checkNotNullParameter(network, "network");
                        producerScope.mo3620trySendJP2dKIU(Boolean.TRUE);
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(@NotNull android.net.Network network) {
                        Intrinsics.checkNotNullParameter(network, "network");
                        producerScope.mo3620trySendJP2dKIU(Boolean.FALSE);
                    }
                };
                Object systemService = this.$context.getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                final ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    connectivityManager.registerDefaultNetworkCallback(r1);
                } catch (Exception e) {
                    UALog.e(e, new Function0() { // from class: com.urbanairship.automation.utils.NetworkMonitor.isConnected.2.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Failed to subscribe for network status update";
                        }
                    });
                    producerScope.mo3620trySendJP2dKIU(Boxing.boxBoolean(true));
                }
                producerScope.mo3620trySendJP2dKIU(Boxing.boxBoolean(this.$network.isConnected(this.$context)));
                Function0 function0 = new Function0() { // from class: com.urbanairship.automation.utils.NetworkMonitor.isConnected.2.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2820invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2820invoke() {
                        connectivityManager.unregisterNetworkCallback(r1);
                    }
                };
                this.label = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/automation/utils/NetworkMonitor$Companion;", "", "()V", "shared", "Lcom/urbanairship/automation/utils/NetworkMonitor;", "context", "Landroid/content/Context;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final NetworkMonitor shared(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new NetworkMonitor(context, null, 2, 0 == true ? 1 : 0);
        }
    }
}
