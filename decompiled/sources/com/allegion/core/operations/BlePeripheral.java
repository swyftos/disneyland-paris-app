package com.allegion.core.operations;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.allegion.core.exception.BleException;
import com.allegion.core.exception.BleExceptionHandler;
import com.allegion.core.operations.gatt.GattLookup;
import com.allegion.core.operations.support.HexConverter;
import com.allegion.logging.AlLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes2.dex */
public abstract class BlePeripheral {
    private static final String BLE_ERROR_CONNECTING = "Unable to communicate with device.";
    private static final int CONNECT_TIMEOUT = 6000;
    private static final int DISCOVER_TIMEOUT = 2000;
    private static final int GATT_ERROR = 133;
    private static final int GATT_INTERNAL_ERROR = 129;
    private static final int RECONNECT_TIMEOUT = 2000;
    private static final int RETRY_ATTEMPTS = 4;
    protected String currentAction;
    private Context mContext;
    private BluetoothDevice mDevice;
    private BluetoothGatt mGatt;
    private boolean mSynchronizeCallbacks;
    protected static final UUID CONFIG_DESCRIPTOR = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private static Handler sPeripheralHandler = new Handler(Looper.getMainLooper());
    private static Integer[] sRetryStatusInts = {62, 128, 257};
    private boolean stopDisconnectRunnable = false;
    protected boolean stopDataTransfer = false;
    private boolean isWriting = false;
    private final Object mWriteLockMonitor = new Object();
    private BleState mBleState = BleState.INITIAL;
    private int customMTUValue = -1;
    private int mConnectionAttemptCounter = 0;
    private int mDiscoverServicesCounter = 0;
    protected boolean tryConnectingAgain = false;
    private int mRetries = 4;
    private int mResetCounter = 0;
    private BluetoothGattCallback mGattCallback = new AnonymousClass1();
    private Runnable mDisconnectCloseRunnable = new Runnable() { // from class: com.allegion.core.operations.BlePeripheral.2
        @Override // java.lang.Runnable
        public void run() {
            AlLog.d("disconnectCloseRunnable", new Object[0]);
            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.mRetryBleConnectionOrDisconnectRunnable);
            BlePeripheral.this.stopDisconnectRunnable = true;
            BlePeripheral.this.disconnected();
        }
    };
    private Runnable mCeaseConnectionAttemptAndRetryRunnable = new Runnable() { // from class: com.allegion.core.operations.BlePeripheral.3
        @Override // java.lang.Runnable
        public void run() {
            AlLog.d("ceaseConnectionAttemptAndRetryRunnable", new Object[0]);
            if (BlePeripheral.this.mGatt != null) {
                BlePeripheral.this.mGatt.disconnect();
                BlePeripheral.this.mGatt.close();
            }
            BlePeripheral.this.tryConnectingAgain = true;
            BlePeripheral.sPeripheralHandler.postDelayed(BlePeripheral.this.mRetryBleConnectionOrDisconnectRunnable, 2000L);
        }
    };
    private Runnable mRetryBleConnectionOrDisconnectRunnable = new Runnable() { // from class: com.allegion.core.operations.BlePeripheral.4
        @Override // java.lang.Runnable
        public void run() {
            if (BlePeripheral.this.stopDisconnectRunnable) {
                return;
            }
            AlLog.d("retryBleConnectionOrDisconnectRunnable", new Object[0]);
            BlePeripheral blePeripheral = BlePeripheral.this;
            if (blePeripheral.tryConnectingAgain) {
                blePeripheral.tryConnecting();
            } else {
                blePeripheral.disconnected();
            }
        }
    };
    private Runnable discoverServicesRunnable = new Runnable() { // from class: com.allegion.core.operations.BlePeripheral.5
        @Override // java.lang.Runnable
        public void run() {
            AlLog.d("Running post delayed for discoverServicesRunnable", new Object[0]);
            if (BlePeripheral.this.mDiscoverServicesCounter <= 3) {
                AlLog.d("discoverServicesCounter: " + BlePeripheral.this.mDiscoverServicesCounter, new Object[0]);
                if (BlePeripheral.this.mBleState == BleState.WAITING_GATT_CONNECT) {
                    AlLog.d("Retry tryDiscoveringServices", new Object[0]);
                    BlePeripheral.this.tryDiscoveringServices();
                    return;
                }
                return;
            }
            AlLog.d("discover services failed", new Object[0]);
            BlePeripheral.this.disconnect(false);
        }
    };

    protected enum BleState {
        INITIAL,
        WAITING_CONNECT,
        WAITING_GATT_CONNECT,
        GATT_CONNECTED,
        PROCESSING
    }

    protected static int getConnectTimeout() {
        return 6000;
    }

    protected static int getDiscoverTimeout() {
        return 2000;
    }

    protected static int getReconnectTimeout() {
        return 2000;
    }

    protected static int getRetryAttempts() {
        return 4;
    }

    protected abstract void connectFailed(BleException bleException);

    protected abstract void disconnected();

    protected abstract GattLookup getGattLookup();

    protected abstract void onCharacteristicChanged(BluetoothGattCharacteristic bluetoothGattCharacteristic);

    protected abstract void onCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    protected abstract void onCharacteristicWrite(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i);

    protected abstract void onDescriptorWrite(BluetoothGattDescriptor bluetoothGattDescriptor, int i);

    protected abstract void onMtuChanged(int i);

    protected abstract void onServicesDiscovered(int i);

    static /* synthetic */ int access$1108(BlePeripheral blePeripheral) {
        int i = blePeripheral.mResetCounter;
        blePeripheral.mResetCounter = i + 1;
        return i;
    }

    public BlePeripheral(BluetoothDevice bluetoothDevice, Context context, boolean z) {
        this.mSynchronizeCallbacks = false;
        this.mDevice = bluetoothDevice;
        this.mContext = context;
        this.mSynchronizeCallbacks = z;
    }

    public void connect(int i) {
        this.mRetries = i;
        connect();
    }

    public void connect() {
        BleException bleExceptionCheckBluetoothExceptions = BleExceptionHandler.checkBluetoothExceptions(this.mContext, false);
        if (bleExceptionCheckBluetoothExceptions != null) {
            connectFailed(bleExceptionCheckBluetoothExceptions);
        } else {
            tryConnecting();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryConnecting() {
        this.mConnectionAttemptCounter++;
        this.tryConnectingAgain = true;
        this.stopDisconnectRunnable = false;
        AlLog.d("Calling tryConnecting with counter value: " + this.mConnectionAttemptCounter, new Object[0]);
        if (this.mConnectionAttemptCounter <= this.mRetries) {
            new Thread(new Runnable() { // from class: com.allegion.core.operations.BlePeripheral$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws NoSuchMethodException, SecurityException {
                    this.f$0.lambda$tryConnecting$0();
                }
            }).start();
            return;
        }
        AlLog.d("connect Failed ", new Object[0]);
        this.mConnectionAttemptCounter = 0;
        if (this.mGatt != null) {
            AlLog.d("closing Gatt", new Object[0]);
            this.mGatt.close();
            this.mGatt = null;
        }
        connectFailed(new BleException(BleException.BLE_FAILED_TO_CONNECT, BLE_ERROR_CONNECTING));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryConnecting$0() throws NoSuchMethodException, SecurityException {
        connectGatt(this.mConnectionAttemptCounter * 6000);
    }

    private void connectGatt(int i) throws NoSuchMethodException, SecurityException {
        AlLog.d("connecting with time %d", Integer.valueOf(i));
        sPeripheralHandler.postDelayed(this.mCeaseConnectionAttemptAndRetryRunnable, i);
        this.mBleState = BleState.WAITING_CONNECT;
        this.currentAction = null;
        this.mGatt = getDevice().connectGatt(this.mContext, false, this.mGattCallback, 2);
        refreshDeviceCache();
    }

    private boolean refreshDeviceCache() throws NoSuchMethodException, SecurityException {
        try {
            Method method = this.mGatt.getClass().getMethod("refresh", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(this.mGatt, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            AlLog.e(e);
        }
        return false;
    }

    /* renamed from: com.allegion.core.operations.BlePeripheral$1, reason: invalid class name */
    class AnonymousClass1 extends BluetoothGattCallback {
        private boolean callbackSent = false;

        AnonymousClass1() {
        }

        private void resetBluetooth() {
            AlLog.d("resetting bluetooth", new Object[0]);
            final BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            BlePeripheral.sPeripheralHandler.postDelayed(BlePeripheral.this.mDisconnectCloseRunnable, 15000L);
            BlePeripheral.this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.allegion.core.operations.BlePeripheral.1.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                        if (intExtra == 10) {
                            BlePeripheral.sPeripheralHandler.postDelayed(new Runnable() { // from class: com.allegion.core.operations.BlePeripheral.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    defaultAdapter.enable();
                                }
                            }, 2000L);
                        } else {
                            if (intExtra != 12) {
                                return;
                            }
                            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.mDisconnectCloseRunnable);
                            context.unregisterReceiver(this);
                            BlePeripheral.this.mConnectionAttemptCounter = 0;
                            BlePeripheral.this.tryConnecting();
                        }
                    }
                }
            }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            defaultAdapter.disable();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            AlLog.d(".BluetoothGattCallback.onConnectionStateChange Bluetooth profile: " + i2 + " status: " + i, new Object[0]);
            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.mCeaseConnectionAttemptAndRetryRunnable);
            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.mRetryBleConnectionOrDisconnectRunnable);
            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.discoverServicesRunnable);
            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.mDisconnectCloseRunnable);
            BlePeripheral.this.onConnectionStateChanged(i, i2);
            if (i2 == 2) {
                AlLog.d("Connected to the device with state: " + BlePeripheral.this.mBleState, new Object[0]);
                if (BlePeripheral.this.customMTUValue > 0) {
                    AlLog.d("Requesting custom MTU size of " + BlePeripheral.this.customMTUValue, new Object[0]);
                    bluetoothGatt.requestMtu(BlePeripheral.this.customMTUValue);
                }
                if (BlePeripheral.this.mBleState == BleState.WAITING_CONNECT) {
                    if (i == BlePeripheral.GATT_ERROR) {
                        BlePeripheral.this.tryConnecting();
                        return;
                    }
                    BlePeripheral.this.mBleState = BleState.WAITING_GATT_CONNECT;
                    AlLog.d("Connected to the device: " + BlePeripheral.this.mDevice.getAddress(), new Object[0]);
                    BlePeripheral.this.mConnectionAttemptCounter = 0;
                    BlePeripheral.this.mResetCounter = 0;
                    BlePeripheral.this.mGatt = bluetoothGatt;
                    BlePeripheral.this.tryDiscoveringServices();
                    return;
                }
                return;
            }
            if (i2 == 0) {
                if (i == BlePeripheral.GATT_ERROR) {
                    BlePeripheral.access$1108(BlePeripheral.this);
                }
                BlePeripheral.this.mBleState = BleState.INITIAL;
                AlLog.d("Disconnected from the device: " + BlePeripheral.this.mDevice.getAddress(), new Object[0]);
                if (BlePeripheral.this.mGatt != null) {
                    AlLog.d("closing Gatt", new Object[0]);
                    BlePeripheral.this.mGatt.close();
                    BlePeripheral.this.mGatt = null;
                }
                if (Arrays.asList(BlePeripheral.sRetryStatusInts).contains(Integer.valueOf(i)) || BlePeripheral.this.mResetCounter == BlePeripheral.this.mRetries) {
                    resetBluetooth();
                    BlePeripheral.this.tryConnectingAgain = false;
                    return;
                }
                BlePeripheral blePeripheral = BlePeripheral.this;
                if (blePeripheral.tryConnectingAgain) {
                    blePeripheral.tryConnecting();
                    return;
                }
                blePeripheral.mConnectionAttemptCounter = 0;
                BlePeripheral.this.mDiscoverServicesCounter = 0;
                BlePeripheral.sPeripheralHandler.postDelayed(BlePeripheral.this.mDisconnectCloseRunnable, 100L);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            AlLog.d(".BluetoothGattCallback.onServicesDiscovered with status: " + i, new Object[0]);
            BlePeripheral.sPeripheralHandler.removeCallbacks(BlePeripheral.this.discoverServicesRunnable);
            if (i == 0) {
                BlePeripheral.this.mDiscoverServicesCounter = 0;
                BlePeripheral blePeripheral = BlePeripheral.this;
                blePeripheral.tryConnectingAgain = false;
                blePeripheral.onServicesDiscovered(i);
                return;
            }
            if (i == 129) {
                BlePeripheral.sPeripheralHandler.postDelayed(BlePeripheral.this.mCeaseConnectionAttemptAndRetryRunnable, 0L);
                return;
            }
            BlePeripheral.this.mBleState = BleState.INITIAL;
            if (BlePeripheral.this.mGatt != null) {
                BlePeripheral.this.mGatt.close();
                BlePeripheral.this.mGatt = null;
            }
            BlePeripheral.this.connectFailed(new BleException(BleException.BLE_FAILED_TO_CONNECT, BlePeripheral.BLE_ERROR_CONNECTING));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
            BlePeripheral.this.onDescriptorWrite(bluetoothGattDescriptor, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            this.callbackSent = false;
            if (!BlePeripheral.this.mSynchronizeCallbacks) {
                BlePeripheral.this.onCharacteristicChanged(bluetoothGattCharacteristic);
            } else {
                new Thread(new Runnable() { // from class: com.allegion.core.operations.BlePeripheral$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onCharacteristicChanged$0(bluetoothGattCharacteristic);
                    }
                }).start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCharacteristicChanged$0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            while (!this.callbackSent) {
                synchronized (BlePeripheral.this.mWriteLockMonitor) {
                    if (BlePeripheral.this.isWriting) {
                        try {
                            BlePeripheral.this.mWriteLockMonitor.wait();
                        } catch (InterruptedException e) {
                            AlLog.e(e);
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        BlePeripheral.this.onCharacteristicChanged(bluetoothGattCharacteristic);
                        this.callbackSent = true;
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            synchronized (BlePeripheral.this.mWriteLockMonitor) {
                BlePeripheral.this.isWriting = false;
                BlePeripheral.this.mWriteLockMonitor.notify();
                BlePeripheral.this.onCharacteristicWrite(bluetoothGattCharacteristic, i);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
            BlePeripheral.this.onCharacteristicRead(bluetoothGattCharacteristic, i);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onMtuChanged(bluetoothGatt, i, i2);
            BlePeripheral.this.onMtuChanged(i);
        }
    }

    protected void setCustomMTUValues(int i) {
        this.customMTUValue = i;
    }

    public boolean isConnected() {
        return this.mBleState == BleState.GATT_CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryDiscoveringServices() {
        AlLog.d("Calling tryDiscoveringServices", new Object[0]);
        this.mDiscoverServicesCounter++;
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.discoverServices();
        }
        sPeripheralHandler.postDelayed(this.discoverServicesRunnable, this.mDiscoverServicesCounter * 2000);
    }

    public void disconnect(boolean z) {
        AlLog.d("BlePeripheral : disconnect", new Object[0]);
        this.tryConnectingAgain = z;
        sPeripheralHandler.postDelayed(this.mRetryBleConnectionOrDisconnectRunnable, 2000L);
        if (!z) {
            sPeripheralHandler.removeCallbacks(this.mCeaseConnectionAttemptAndRetryRunnable);
            sPeripheralHandler.removeCallbacks(this.discoverServicesRunnable);
        }
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    public void stopDataTransfer() {
        this.stopDataTransfer = true;
    }

    public void setCurrentAction(String str) {
        this.currentAction = str;
    }

    protected BluetoothGattCharacteristic getCharacteristic(String str) {
        BluetoothGattService service;
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(getGattLookup().getServiceUUID(str))) == null) {
            return null;
        }
        return service.getCharacteristic(getGattLookup().getUUID(str));
    }

    protected boolean writeCharacteristic(String str, byte[] bArr, int i) {
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.isWriting = true;
        AlLog.d("writeCharacteristic:" + str + " with type: " + String.valueOf(i) + " and data: " + HexConverter.bytesToString(bArr), new Object[0]);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (bluetoothGatt == null || (service = bluetoothGatt.getService(getGattLookup().getServiceUUID(str))) == null || (characteristic = service.getCharacteristic(getGattLookup().getUUID(str))) == null || bArr == null || !characteristic.setValue(bArr)) {
            return false;
        }
        characteristic.setWriteType(i);
        return this.mGatt.writeCharacteristic(characteristic);
    }

    public boolean writeIndicationDescriptor(String str, boolean z) throws InterruptedException {
        byte[] bArr;
        AlLog.d("writeIndicationDescriptor: %s", str);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (bluetoothGatt == null) {
            tryConnecting();
            AlLog.d("Failed to writeIndicationDescriptor GATT was NULL.", new Object[0]);
            return false;
        }
        BluetoothGattService service = bluetoothGatt.getService(getGattLookup().getServiceUUID(str));
        if (service == null) {
            AlLog.d("Failed to writeIndicationDescriptor SERVICE was NULL.", new Object[0]);
            disconnect(true);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(getGattLookup().getUUID(str));
        if (characteristic == null) {
            AlLog.d("Failed to writeIndicationDescriptor CHARACTERISTIC was NULL.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CONFIG_DESCRIPTOR);
        if (descriptor == null) {
            AlLog.d("Failed to writeIndicationDescriptor DESCRIPTOR was NULL.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        if (z) {
            bArr = BluetoothGattDescriptor.ENABLE_INDICATION_VALUE;
        } else {
            bArr = new byte[]{0, 0};
        }
        if (!descriptor.setValue(bArr)) {
            AlLog.d("Failed to writeIndicationDescriptor DESCRIPTOR ENABLE/DISABLE failed.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        if (!this.mGatt.setCharacteristicNotification(characteristic, z)) {
            AlLog.d("Failed to writeIndicationDescriptor CHARACTERISTIC'S NOTIFICATION ENABLE/DISABLE failed.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        return this.mGatt.writeDescriptor(descriptor);
    }

    protected boolean writeNotificationDescriptor(String str, boolean z) throws InterruptedException {
        byte[] bArr;
        AlLog.d("writeNotificationDescriptor: %s", str);
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (bluetoothGatt == null) {
            tryConnecting();
            AlLog.d("Failed to writeNotificationDescriptor GATT was NULL.", new Object[0]);
            return false;
        }
        BluetoothGattService service = bluetoothGatt.getService(getGattLookup().getServiceUUID(str));
        if (service == null) {
            AlLog.d("Failed to writeNotificationDescriptor SERVICE was NULL.", new Object[0]);
            disconnect(true);
            return false;
        }
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(getGattLookup().getUUID(str));
        if (characteristic == null) {
            AlLog.d("Failed to writeNotificationDescriptor CHARACTERISTIC was NULL.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(CONFIG_DESCRIPTOR);
        if (descriptor == null) {
            AlLog.d("Failed to writeNotificationDescriptor DESCRIPTOR was NULL.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        if (z) {
            bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        } else {
            bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        }
        if (!descriptor.setValue(bArr)) {
            AlLog.d("Failed to writeNotificationDescriptor DESCRIPTOR ENABLE/DISABLE failed.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        if (!this.mGatt.setCharacteristicNotification(characteristic, z)) {
            AlLog.d("Failed to writeNotificationDescriptor CHARACTERISTIC'S NOTIFICATION ENABLE/DISABLE failed.", new Object[0]);
            rediscoverServicesAfterSomeRest();
            return false;
        }
        return this.mGatt.writeDescriptor(descriptor);
    }

    private void rediscoverServicesAfterSomeRest() throws InterruptedException {
        try {
            AlLog.d("Rediscovering service after some rest.", new Object[0]);
            sPeripheralHandler.removeCallbacks(this.discoverServicesRunnable);
            Thread.sleep(100L);
            this.mDiscoverServicesCounter = 0;
            tryDiscoveringServices();
        } catch (Exception e) {
            AlLog.e(e);
            BluetoothGatt bluetoothGatt = this.mGatt;
            if (bluetoothGatt != null) {
                bluetoothGatt.disconnect();
            }
        }
    }

    public String getUUID() {
        BluetoothDevice bluetoothDevice = this.mDevice;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getAddress();
        }
        return null;
    }

    public String getName() {
        BluetoothDevice bluetoothDevice = this.mDevice;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getName();
        }
        return null;
    }

    protected boolean readCharacteristic(String str) {
        AlLog.d(" Calling readCharacteristic for: %s", str);
        BluetoothGattCharacteristic characteristic = getCharacteristic(str);
        return characteristic != null && this.mGatt.readCharacteristic(characteristic);
    }

    protected void setBleState(BleState bleState) {
        this.mBleState = bleState;
    }

    protected BleState getBleState() {
        return this.mBleState;
    }

    protected Context getContext() {
        return this.mContext;
    }

    protected BluetoothDevice getDevice() {
        return this.mDevice;
    }

    protected BluetoothGatt getGatt() {
        return this.mGatt;
    }

    protected BluetoothGattCallback getGattCallback() {
        return this.mGattCallback;
    }

    protected static Handler getPeripheralHandler() {
        return sPeripheralHandler;
    }

    protected static void setPeripheralHander(Handler handler) {
        sPeripheralHandler = handler;
    }

    protected void onConnectionStateChanged(int i, int i2) {
        AlLog.d(" onConnectionStateChanged ", new Object[0]);
    }

    protected Runnable getRetryBleConnectionOrDisconnectRunnable() {
        return this.mRetryBleConnectionOrDisconnectRunnable;
    }
}
