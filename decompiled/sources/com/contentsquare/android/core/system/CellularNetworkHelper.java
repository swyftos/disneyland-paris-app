package com.contentsquare.android.core.system;

import android.content.Context;
import android.telephony.TelephonyDisplayInfo;
import androidx.annotation.RequiresApi;
import com.contentsquare.android.core.utils.BuildInstantiable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/contentsquare/android/core/system/CellularNetworkHelper;", "", "context", "Landroid/content/Context;", "buildInstantiable", "Lcom/contentsquare/android/core/utils/BuildInstantiable;", "(Landroid/content/Context;Lcom/contentsquare/android/core/utils/BuildInstantiable;)V", "determineCellularConnectionType", "Lcom/contentsquare/android/core/system/ConnectionType;", "telephonyDisplayInfo", "Landroid/telephony/TelephonyDisplayInfo;", "networkSubtype", "", "isCellularPermissionsGranted", "", "hasPermissionGranted", "permission", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CellularNetworkHelper {

    @NotNull
    private final BuildInstantiable buildInstantiable;

    @NotNull
    private final Context context;

    public CellularNetworkHelper(Context context, BuildInstantiable buildInstantiable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInstantiable, "buildInstantiable");
        this.context = context;
        this.buildInstantiable = buildInstantiable;
    }

    private final boolean hasPermissionGranted(Context context, String str) {
        return context.getApplicationContext().checkCallingOrSelfPermission(str) == 0;
    }

    @NotNull
    public final ConnectionType determineCellularConnectionType(int networkSubtype) {
        if (networkSubtype == 20) {
            return ConnectionType.MOBILE_5G;
        }
        switch (networkSubtype) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 11:
                return ConnectionType.MOBILE_2G;
            case 3:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
                return ConnectionType.MOBILE_3G;
            case 13:
            case 15:
                return ConnectionType.MOBILE_4G;
            default:
                return ConnectionType.CONNECTIVITY_ERROR;
        }
    }

    public final boolean isCellularPermissionsGranted() {
        Context context;
        String str = "android.permission.READ_PHONE_STATE";
        if (this.buildInstantiable.isAtLeastSdkVersion(33)) {
            return hasPermissionGranted(this.context, "android.permission.READ_PHONE_STATE") || hasPermissionGranted(this.context, "android.permission.READ_BASIC_PHONE_STATE");
        }
        if (this.buildInstantiable.isAtLeastSdkVersion(24)) {
            context = this.context;
        } else {
            context = this.context;
            str = "android.permission.ACCESS_NETWORK_STATE";
        }
        return hasPermissionGranted(context, str);
    }

    public /* synthetic */ CellularNetworkHelper(Context context, BuildInstantiable buildInstantiable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new BuildInstantiable() : buildInstantiable);
    }

    @RequiresApi(30)
    @NotNull
    public final ConnectionType determineCellularConnectionType(TelephonyDisplayInfo telephonyDisplayInfo) {
        Intrinsics.checkNotNullParameter(telephonyDisplayInfo, "telephonyDisplayInfo");
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        return overrideNetworkType != 1 ? (overrideNetworkType == 2 || overrideNetworkType == 3 || overrideNetworkType == 5) ? ConnectionType.MOBILE_5G : determineCellularConnectionType(telephonyDisplayInfo.getNetworkType()) : ConnectionType.MOBILE_4G;
    }
}
