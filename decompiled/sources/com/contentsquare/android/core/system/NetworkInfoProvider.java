package com.contentsquare.android.core.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.CellularNetworkProvider;
import com.contentsquare.android.core.utils.BuildInstantiable;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0019\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006$"}, d2 = {"Lcom/contentsquare/android/core/system/NetworkInfoProvider;", "", "context", "Landroid/content/Context;", "buildInstantiable", "Lcom/contentsquare/android/core/utils/BuildInstantiable;", "cellularNetworkProvider", "Lcom/contentsquare/android/core/system/CellularNetworkProvider;", "(Landroid/content/Context;Lcom/contentsquare/android/core/utils/BuildInstantiable;Lcom/contentsquare/android/core/system/CellularNetworkProvider;)V", "value", "Lcom/contentsquare/android/core/system/ConnectionType;", "connectionType", "getConnectionType", "()Lcom/contentsquare/android/core/system/ConnectionType;", "setConnectionType", "(Lcom/contentsquare/android/core/system/ConnectionType;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "listeners", "Ljava/util/WeakHashMap;", "Lcom/contentsquare/android/core/system/OnNetworkStateChangeListener;", "", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "networkCallback", "com/contentsquare/android/core/system/NetworkInfoProvider$networkCallback$1", "Lcom/contentsquare/android/core/system/NetworkInfoProvider$networkCallback$1;", "dispatchStateChanged", "", TCEventPropertiesNames.TCN_NETWORK, "Landroid/net/Network;", "capabilities", "Landroid/net/NetworkCapabilities;", "registerNetworkCallback", "registerOnNetworkStateChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetworkInfoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkInfoProvider.kt\ncom/contentsquare/android/core/system/NetworkInfoProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,163:1\n215#2,2:164\n*S KotlinDebug\n*F\n+ 1 NetworkInfoProvider.kt\ncom/contentsquare/android/core/system/NetworkInfoProvider\n*L\n96#1:164,2\n*E\n"})
/* loaded from: classes2.dex */
public final class NetworkInfoProvider {

    @NotNull
    private final BuildInstantiable buildInstantiable;

    @NotNull
    private final CellularNetworkProvider cellularNetworkProvider;

    @NotNull
    private ConnectionType connectionType;

    @NotNull
    private final ConnectivityManager connectivityManager;

    @NotNull
    private final Context context;

    @NotNull
    private final WeakHashMap<OnNetworkStateChangeListener, Boolean> listeners;

    @NotNull
    private final Logger logger;

    @NotNull
    private final NetworkInfoProvider$networkCallback$1 networkCallback;

    /* JADX WARN: Type inference failed for: r2v5, types: [com.contentsquare.android.core.system.NetworkInfoProvider$networkCallback$1] */
    public NetworkInfoProvider(Context context, BuildInstantiable buildInstantiable, CellularNetworkProvider cellularNetworkProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInstantiable, "buildInstantiable");
        Intrinsics.checkNotNullParameter(cellularNetworkProvider, "cellularNetworkProvider");
        this.context = context;
        this.buildInstantiable = buildInstantiable;
        this.cellularNetworkProvider = cellularNetworkProvider;
        this.logger = new Logger("NetworkInfoProvider");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        this.listeners = new WeakHashMap<>();
        this.connectionType = ConnectionType.CONNECTIVITY_ERROR;
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.contentsquare.android.core.system.NetworkInfoProvider$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                NetworkCapabilities networkCapabilities = this.this$0.connectivityManager.getNetworkCapabilities(network);
                NetworkInfoProvider networkInfoProvider = this.this$0;
                networkInfoProvider.setConnectionType(networkCapabilities == null ? ConnectionType.CONNECTIVITY_ERROR : networkInfoProvider.getConnectionType(network, networkCapabilities));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(capabilities, "capabilities");
                if (capabilities.hasTransport(1) || !this.this$0.cellularNetworkProvider.getIsListening()) {
                    NetworkInfoProvider networkInfoProvider = this.this$0;
                    networkInfoProvider.setConnectionType(networkInfoProvider.getConnectionType(network, capabilities));
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                this.this$0.setConnectionType(ConnectionType.OFFLINE);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                this.this$0.setConnectionType(ConnectionType.CONNECTIVITY_ERROR);
            }
        };
        cellularNetworkProvider.register(new CellularNetworkProvider.CellularNetworkChanged() { // from class: com.contentsquare.android.core.system.NetworkInfoProvider$$ExternalSyntheticLambda0
            @Override // com.contentsquare.android.core.system.CellularNetworkProvider.CellularNetworkChanged
            public final void onCellularNetworkChanged(ConnectionType connectionType) {
                NetworkInfoProvider._init_$lambda$0(this.f$0, connectionType);
            }
        });
        registerNetworkCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(NetworkInfoProvider this$0, ConnectionType newConnectionType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(newConnectionType, "newConnectionType");
        this$0.setConnectionType(newConnectionType);
    }

    private final synchronized void dispatchStateChanged() {
        Iterator<Map.Entry<OnNetworkStateChangeListener, Boolean>> it = this.listeners.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getKey().onNetworkStateChanged();
        }
    }

    private final void registerNetworkCallback() {
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
        try {
            if (this.buildInstantiable.isAtLeastSdkVersion(24)) {
                this.connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
            } else {
                this.connectivityManager.registerNetworkCallback(networkRequestBuild, this.networkCallback);
            }
        } catch (SecurityException e) {
            this.logger.e(e, "We couldn't register a Network Callback, the network information will be less accurate.");
            setConnectionType(ConnectionType.CONNECTIVITY_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setConnectionType(ConnectionType connectionType) {
        if (this.connectionType != connectionType) {
            this.logger.d("Network type change from: " + this.connectionType + " to: " + connectionType);
            this.connectionType = connectionType;
            dispatchStateChanged();
        }
    }

    @NotNull
    public final ConnectionType getConnectionType() {
        return this.connectionType;
    }

    public final synchronized void registerOnNetworkStateChangedListener(OnNetworkStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.put(listener, Boolean.TRUE);
    }

    public /* synthetic */ NetworkInfoProvider(Context context, BuildInstantiable buildInstantiable, CellularNetworkProvider cellularNetworkProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new BuildInstantiable() : buildInstantiable, (i & 4) != 0 ? new CellularNetworkProvider(context, null, null, 6, null) : cellularNetworkProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConnectionType getConnectionType(Network network, NetworkCapabilities capabilities) {
        return capabilities.hasTransport(1) ? ConnectionType.WIFI : capabilities.hasTransport(0) ? this.cellularNetworkProvider.determineCellularConnectionType(network) : ConnectionType.OFFLINE;
    }
}
