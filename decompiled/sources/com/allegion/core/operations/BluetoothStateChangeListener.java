package com.allegion.core.operations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.allegion.core.enums.BluetoothState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/allegion/core/operations/BluetoothStateChangeListener;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "iBluetoothStateChangeListener", "Lcom/allegion/core/operations/IOnBluetoothStateChangeListener;", "mReceiver", "Lcom/allegion/core/operations/BluetoothStateChangeListener$BluetoothReceiver;", "noOpListener", "register", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregister", "BluetoothReceiver", "AlBle_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class BluetoothStateChangeListener {
    private IOnBluetoothStateChangeListener iBluetoothStateChangeListener;
    private final Context mContext;
    private BluetoothReceiver mReceiver;
    private final IOnBluetoothStateChangeListener noOpListener;

    public BluetoothStateChangeListener(@NotNull Context mContext) {
        Intrinsics.checkParameterIsNotNull(mContext, "mContext");
        this.mContext = mContext;
        IOnBluetoothStateChangeListener iOnBluetoothStateChangeListener = new IOnBluetoothStateChangeListener() { // from class: com.allegion.core.operations.BluetoothStateChangeListener$noOpListener$1
            @Override // com.allegion.core.operations.IOnBluetoothStateChangeListener
            public void onBluetoothStateChange(@NotNull BluetoothState state) {
                Intrinsics.checkParameterIsNotNull(state, "state");
            }
        };
        this.noOpListener = iOnBluetoothStateChangeListener;
        this.iBluetoothStateChangeListener = iOnBluetoothStateChangeListener;
    }

    public final void register(@NotNull IOnBluetoothStateChangeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.iBluetoothStateChangeListener = listener;
        if (this.mReceiver == null) {
            this.mReceiver = new BluetoothReceiver();
            this.mContext.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public final void unregister() {
        BluetoothReceiver bluetoothReceiver = this.mReceiver;
        if (bluetoothReceiver != null) {
            this.mContext.unregisterReceiver(bluetoothReceiver);
            this.mReceiver = null;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/allegion/core/operations/BluetoothStateChangeListener$BluetoothReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/allegion/core/operations/BluetoothStateChangeListener;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "AlBle_release"}, k = 1, mv = {1, 1, 15})
    public final class BluetoothReceiver extends BroadcastReceiver {
        public BluetoothReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            if (intent == null) {
                Intrinsics.throwNpe();
            }
            switch (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE)) {
                case 10:
                    BluetoothStateChangeListener.this.iBluetoothStateChangeListener.onBluetoothStateChange(BluetoothState.OFF);
                    break;
                case 11:
                    BluetoothStateChangeListener.this.iBluetoothStateChangeListener.onBluetoothStateChange(BluetoothState.TURNING_ON);
                    break;
                case 12:
                    BluetoothStateChangeListener.this.iBluetoothStateChangeListener.onBluetoothStateChange(BluetoothState.ON);
                    break;
                case 13:
                    BluetoothStateChangeListener.this.iBluetoothStateChangeListener.onBluetoothStateChange(BluetoothState.TURNING_OFF);
                    break;
            }
        }
    }
}
