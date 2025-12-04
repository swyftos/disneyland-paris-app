package com.allegion.core.operations;

import com.allegion.core.enums.BluetoothState;
import com.dlp.BluetoothManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/allegion/core/operations/IOnBluetoothStateChangeListener;", "", "onBluetoothStateChange", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/allegion/core/enums/BluetoothState;", "AlBle_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IOnBluetoothStateChangeListener {
    void onBluetoothStateChange(@NotNull BluetoothState state);
}
