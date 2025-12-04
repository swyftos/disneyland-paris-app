package com.allegion.core.scanning;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.allegion.core.enums.ProtocolBlockType;
import com.allegion.core.exception.BleException;
import com.allegion.core.exception.BleExceptionHandler;
import com.allegion.logging.AlLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
/* loaded from: classes2.dex */
public abstract class BleScanner implements BluetoothAdapter.LeScanCallback {
    private static final int MAX_RSSI = 0;
    private static final int MIN_RSSI = -100;
    private static final int SCAN_INTERVAL = 20;
    protected static Handler scannerHandler = new Handler(Looper.getMainLooper());
    private BleScanListener bleScanListener;
    protected List<ScanFilter> filters;
    private BluetoothAdapter mBluetoothAdapter;
    protected Context mContext;
    private BluetoothLeScanner mLeScanner;
    private ScanCallback mScanCallback;
    private int scanTime;
    private ScheduledThreadPoolExecutor scheduledThread;
    private ScanSettings settings;
    private BroadcastReceiver scanReceiver = new BroadcastReceiver() { // from class: com.allegion.core.scanning.BleScanner.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                BleScanner bleScanner = BleScanner.this;
                bleScanner.startScan(bleScanner.scanTime);
            }
        }
    };
    private Runnable mStopRunnable = new Runnable() { // from class: com.allegion.core.scanning.BleScanner$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$2();
        }
    };
    private Runnable mPauseRunnable = new Runnable() { // from class: com.allegion.core.scanning.BleScanner$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$3();
        }
    };
    private Runnable mStartRunnable = new Runnable() { // from class: com.allegion.core.scanning.BleScanner.3
        @Override // java.lang.Runnable
        public void run() {
            AlLog.d("starting scan", new Object[0]);
            if (BleScanner.this.mLeScanner != null) {
                BluetoothLeScanner bluetoothLeScanner = BleScanner.this.mLeScanner;
                BleScanner bleScanner = BleScanner.this;
                bluetoothLeScanner.startScan(bleScanner.filters, bleScanner.settings, BleScanner.this.mScanCallback);
                return;
            }
            BleScanner.this.mBluetoothAdapter.startLeScan(BleScanner.this);
        }
    };

    public interface BleScanListener {
        void onStartScan(BleException bleException);

        void onStopScan();
    }

    public abstract void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr, Advertisement advertisement);

    public void setOnBleScanListener(BleScanListener bleScanListener) {
        this.bleScanListener = bleScanListener;
    }

    public BleScanner(Context context) {
        this.mContext = context;
        this.mContext.registerReceiver(this.scanReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager != null) {
            this.mBluetoothAdapter = bluetoothManager.getAdapter();
        }
        this.mScanCallback = new ScanCallback() { // from class: com.allegion.core.scanning.BleScanner.1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i, ScanResult scanResult) {
                byte[] bytes = new byte[0];
                if (scanResult.getScanRecord() != null) {
                    bytes = scanResult.getScanRecord().getBytes();
                }
                BleScanner.this.onLeScan(scanResult.getDevice(), scanResult.getRssi(), bytes);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> list) {
                Iterator<ScanResult> it = list.iterator();
                while (it.hasNext()) {
                    AlLog.i("ScanResult - Results : %s", it.next().toString());
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int i) {
                AlLog.e("Scan FailedError Code: " + i, new Object[0]);
            }
        };
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            this.mLeScanner = bluetoothAdapter.getBluetoothLeScanner();
        }
        this.settings = new ScanSettings.Builder().setScanMode(2).build();
    }

    public void startScan(int i) {
        this.scanTime = i;
        BleException bleExceptionCheckBluetoothExceptions = BleExceptionHandler.checkBluetoothExceptions(this.mContext, true);
        if (bleExceptionCheckBluetoothExceptions != null) {
            BleScanListener bleScanListener = this.bleScanListener;
            if (bleScanListener != null) {
                bleScanListener.onStartScan(bleExceptionCheckBluetoothExceptions);
                return;
            }
            return;
        }
        AlLog.d("Scan for locks in range: set up schedulers", new Object[0]);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduledThread;
        if (scheduledThreadPoolExecutor == null || scheduledThreadPoolExecutor.isShutdown() || this.scheduledThread.isTerminating()) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(2);
            this.scheduledThread = scheduledThreadPoolExecutor2;
            Runnable runnable = this.mPauseRunnable;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            scheduledThreadPoolExecutor2.scheduleAtFixedRate(runnable, 0L, 20L, timeUnit);
            this.scheduledThread.scheduleAtFixedRate(this.mStartRunnable, 1L, 20L, timeUnit);
            if (i > 0) {
                this.scheduledThread.schedule(this.mStopRunnable, i, timeUnit);
            }
            scannerHandler.post(new Runnable() { // from class: com.allegion.core.scanning.BleScanner$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startScan$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startScan$0() {
        BleScanListener bleScanListener = this.bleScanListener;
        if (bleScanListener != null) {
            bleScanListener.onStartScan(null);
        }
    }

    /* renamed from: stopScan, reason: merged with bridge method [inline-methods] */
    public void lambda$new$2() {
        AlLog.d("stopping scan", new Object[0]);
        try {
            this.mContext.unregisterReceiver(this.scanReceiver);
        } catch (IllegalArgumentException e) {
            AlLog.e(e);
        }
        AlLog.d("Scan for locks in range: stop scanning", new Object[0]);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.scheduledThread;
        if (scheduledThreadPoolExecutor != null) {
            scheduledThreadPoolExecutor.shutdown();
        }
        lambda$new$3();
        scannerHandler.post(new Runnable() { // from class: com.allegion.core.scanning.BleScanner$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopScan$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopScan$1() {
        BleScanListener bleScanListener = this.bleScanListener;
        if (bleScanListener != null) {
            bleScanListener.onStopScan();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: pauseScan, reason: merged with bridge method [inline-methods] */
    public void lambda$new$3() {
        ScanCallback scanCallback;
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled() && this.mBluetoothAdapter.getState() == 12) {
            BluetoothLeScanner bluetoothLeScanner = this.mLeScanner;
            if (bluetoothLeScanner != null && (scanCallback = this.mScanCallback) != null) {
                bluetoothLeScanner.stopScan(scanCallback);
                return;
            } else {
                this.mBluetoothAdapter.stopLeScan(this);
                return;
            }
        }
        AlLog.e("Bluetooth stop scan failed.", new Object[0]);
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        Advertisement uUIDs = AdvertisementParser.parseUUIDs(bArr);
        if ((bluetoothDevice.getName() != null || isSenseFourTwentyFiveDevice(bArr)) && i >= -100 && i < 0) {
            onLeScan(bluetoothDevice, i, bArr, uUIDs);
            StringBuilder sb = new StringBuilder();
            sb.append("Scan for locks in range: Adding device: ");
            sb.append(bluetoothDevice.getName() != null ? bluetoothDevice.getName() : "null");
            sb.append(" UUID: ");
            sb.append(bluetoothDevice.getAddress() != null ? bluetoothDevice.getAddress() : "null");
            sb.append(" model: ");
            sb.append(uUIDs.getDeviceType());
            AlLog.d(sb.toString(), new Object[0]);
        }
    }

    @Deprecated
    public boolean isAllegionDevice(Advertisement advertisement) {
        return advertisement.isAllegion() && !advertisement.isUnconnected();
    }

    public boolean isAllegionDevice(Advertisement advertisement, ProtocolBlockType protocolBlockType) {
        return advertisement.isAllegion() && !advertisement.isUnconnected(protocolBlockType);
    }

    protected boolean isSenseFourTwentyFiveDevice(byte[] bArr) {
        if (bArr[0] != 2 || bArr[1] != 1 || bArr[2] != 6) {
            return false;
        }
        for (int i = 3; i < bArr.length; i++) {
            if (bArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public void startScan() {
        startScan(0);
    }

    public void turnOnAndScan() {
        turnOnAndScan(0);
    }

    public void turnOnAndScan(final int i) {
        this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.allegion.core.scanning.BleScanner.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action != null && action.equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                    BleScanner.this.startScan(i);
                    context.unregisterReceiver(this);
                }
            }
        }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.isEnabled()) {
            return;
        }
        defaultAdapter.enable();
    }
}
