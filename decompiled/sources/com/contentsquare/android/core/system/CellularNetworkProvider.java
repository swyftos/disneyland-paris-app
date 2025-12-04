package com.contentsquare.android.core.system;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.autofill.HintConstants;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.system.CellularNetworkProvider$callbackStartingApi31$2;
import com.contentsquare.android.core.utils.BuildInstantiable;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\f\u000f\u0018\u00002\u00020\u0001:\u0001)B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0003J\u000e\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/contentsquare/android/core/system/CellularNetworkProvider;", "", "context", "Landroid/content/Context;", "cellularHelper", "Lcom/contentsquare/android/core/system/CellularNetworkHelper;", "buildInstantiable", "Lcom/contentsquare/android/core/utils/BuildInstantiable;", "(Landroid/content/Context;Lcom/contentsquare/android/core/system/CellularNetworkHelper;Lcom/contentsquare/android/core/utils/BuildInstantiable;)V", "callback", "Lcom/contentsquare/android/core/system/CellularNetworkProvider$CellularNetworkChanged;", "callbackForApi30", "com/contentsquare/android/core/system/CellularNetworkProvider$callbackForApi30$1", "Lcom/contentsquare/android/core/system/CellularNetworkProvider$callbackForApi30$1;", "callbackStartingApi31", "com/contentsquare/android/core/system/CellularNetworkProvider$callbackStartingApi31$2$1", "getCallbackStartingApi31", "()Lcom/contentsquare/android/core/system/CellularNetworkProvider$callbackStartingApi31$2$1;", "callbackStartingApi31$delegate", "Lkotlin/Lazy;", "connectivityManager", "Landroid/net/ConnectivityManager;", "isConnectedToWifi", "", "()Z", "<set-?>", "isListening", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "telephonyManager", "Landroid/telephony/TelephonyManager;", "determineCellularConnectionType", "Lcom/contentsquare/android/core/system/ConnectionType;", TCEventPropertiesNames.TCN_NETWORK, "Landroid/net/Network;", "dispatchConnectionTypeChanged", "", "telephonyDisplayInfo", "Landroid/telephony/TelephonyDisplayInfo;", "register", "onCellularNetworkChanged", "CellularNetworkChanged", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CellularNetworkProvider {

    @NotNull
    private final BuildInstantiable buildInstantiable;

    @Nullable
    private CellularNetworkChanged callback;

    @RequiresApi(30)
    @SuppressLint({"MissingPermission"})
    @NotNull
    private final CellularNetworkProvider$callbackForApi30$1 callbackForApi30;

    /* renamed from: callbackStartingApi31$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy callbackStartingApi31;

    @NotNull
    private final CellularNetworkHelper cellularHelper;

    @NotNull
    private final ConnectivityManager connectivityManager;

    @NotNull
    private final Context context;
    private boolean isListening;

    @NotNull
    private final Logger logger;

    @NotNull
    private final TelephonyManager telephonyManager;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/system/CellularNetworkProvider$CellularNetworkChanged;", "", "onCellularNetworkChanged", "", "connectionType", "Lcom/contentsquare/android/core/system/ConnectionType;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CellularNetworkChanged {
        void onCellularNetworkChanged(ConnectionType connectionType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.telephony.PhoneStateListener, com.contentsquare.android.core.system.CellularNetworkProvider$callbackForApi30$1] */
    public CellularNetworkProvider(Context context, CellularNetworkHelper cellularHelper, BuildInstantiable buildInstantiable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cellularHelper, "cellularHelper");
        Intrinsics.checkNotNullParameter(buildInstantiable, "buildInstantiable");
        this.context = context;
        this.cellularHelper = cellularHelper;
        this.buildInstantiable = buildInstantiable;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        Object systemService2 = context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService2;
        this.telephonyManager = telephonyManager;
        this.logger = new Logger("CellularNetworkDetection");
        this.callbackStartingApi31 = LazyKt.lazy(new Function0<CellularNetworkProvider$callbackStartingApi31$2.AnonymousClass1>() { // from class: com.contentsquare.android.core.system.CellularNetworkProvider$callbackStartingApi31$2

            @RequiresApi(31)
            @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/contentsquare/android/core/system/CellularNetworkProvider$callbackStartingApi31$2$1", "Landroid/telephony/TelephonyCallback;", "Landroid/telephony/TelephonyCallback$DisplayInfoListener;", "onDisplayInfoChanged", "", "telephonyDisplayInfo", "Landroid/telephony/TelephonyDisplayInfo;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            /* renamed from: com.contentsquare.android.core.system.CellularNetworkProvider$callbackStartingApi31$2$1, reason: invalid class name */
            public static final class AnonymousClass1 extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
                final /* synthetic */ CellularNetworkProvider this$0;

                public AnonymousClass1(CellularNetworkProvider cellularNetworkProvider) {
                    this.this$0 = cellularNetworkProvider;
                }

                public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                    Intrinsics.checkNotNullParameter(telephonyDisplayInfo, "telephonyDisplayInfo");
                    this.this$0.dispatchConnectionTypeChanged(telephonyDisplayInfo);
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                return new AnonymousClass1(this.this$0);
            }
        });
        ?? r0 = new PhoneStateListener() { // from class: com.contentsquare.android.core.system.CellularNetworkProvider$callbackForApi30$1
            @Override // android.telephony.PhoneStateListener
            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                Intrinsics.checkNotNullParameter(telephonyDisplayInfo, "telephonyDisplayInfo");
                super.onDisplayInfoChanged(telephonyDisplayInfo);
                this.this$0.dispatchConnectionTypeChanged(telephonyDisplayInfo);
            }
        };
        this.callbackForApi30 = r0;
        if (cellularHelper.isCellularPermissionsGranted()) {
            try {
                if (buildInstantiable.isAtLeastSdkVersion(31)) {
                    telephonyManager.registerTelephonyCallback(new Executor() { // from class: com.contentsquare.android.core.system.CellularNetworkProvider$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Executor
                        public final void execute(Runnable runnable) {
                            CellularNetworkProvider._init_$lambda$0(runnable);
                        }
                    }, getCallbackStartingApi31());
                } else if (Build.VERSION.SDK_INT != 30) {
                    return;
                } else {
                    telephonyManager.listen(r0, 1048576);
                }
                this.isListening = true;
            } catch (SecurityException e) {
                this.isListening = false;
                this.logger.e(e, "We couldn't register on TelephonyManager on SDK " + Build.VERSION.SDK_INT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Runnable obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        obj.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(30)
    public final void dispatchConnectionTypeChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        if (isConnectedToWifi()) {
            return;
        }
        ConnectionType connectionTypeDetermineCellularConnectionType = this.cellularHelper.determineCellularConnectionType(telephonyDisplayInfo);
        CellularNetworkChanged cellularNetworkChanged = this.callback;
        if (cellularNetworkChanged != null) {
            cellularNetworkChanged.onCellularNetworkChanged(connectionTypeDetermineCellularConnectionType);
        }
    }

    private final CellularNetworkProvider$callbackStartingApi31$2.AnonymousClass1 getCallbackStartingApi31() {
        return (CellularNetworkProvider$callbackStartingApi31$2.AnonymousClass1) this.callbackStartingApi31.getValue();
    }

    private final boolean isConnectedToWifi() {
        ConnectivityManager connectivityManager = this.connectivityManager;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(1);
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    @NotNull
    public final ConnectionType determineCellularConnectionType(Network network) {
        int subtype;
        Intrinsics.checkNotNullParameter(network, "network");
        if (!this.cellularHelper.isCellularPermissionsGranted()) {
            this.logger.w("Required permissions not granted for determining Cellular Network !");
            return ConnectionType.CONNECTIVITY_ERROR;
        }
        int i = 0;
        try {
        } catch (SecurityException e) {
            this.logger.e(e, "Failed to get connection type");
        }
        if (!this.buildInstantiable.isAtLeastSdkVersion(24)) {
            NetworkInfo networkInfo = this.connectivityManager.getNetworkInfo(network);
            if (networkInfo != null) {
                subtype = networkInfo.getSubtype();
            }
            return this.cellularHelper.determineCellularConnectionType(i);
        }
        subtype = this.telephonyManager.getDataNetworkType();
        i = subtype;
        return this.cellularHelper.determineCellularConnectionType(i);
    }

    /* renamed from: isListening, reason: from getter */
    public final boolean getIsListening() {
        return this.isListening;
    }

    public final void register(CellularNetworkChanged onCellularNetworkChanged) {
        Intrinsics.checkNotNullParameter(onCellularNetworkChanged, "onCellularNetworkChanged");
        this.callback = onCellularNetworkChanged;
    }

    public /* synthetic */ CellularNetworkProvider(Context context, CellularNetworkHelper cellularNetworkHelper, BuildInstantiable buildInstantiable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new CellularNetworkHelper(context, null, 2, null) : cellularNetworkHelper, (i & 4) != 0 ? new BuildInstantiable() : buildInstantiable);
    }
}
