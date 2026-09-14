package com.allegion.core.operations;

import com.allegion.core.enums.BluetoothState;
import com.dlp.BluetoothManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1834bv = {1, 0, 3}, m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1836d2 = {"Lcom/allegion/core/operations/IOnBluetoothStateChangeListener;", "", "onBluetoothStateChange", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/allegion/core/enums/BluetoothState;", "AlBle_release"}, m1837k = 1, m1838mv = {1, 1, 15})
public interface IOnBluetoothStateChangeListener {
    void onBluetoothStateChange(@NotNull BluetoothState state);
}
