package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Map;

/* loaded from: classes2.dex */
public class TransferService extends Service {
    public static final String INTENT_KEY_NOTIFICATION = "notification";
    public static final String INTENT_KEY_NOTIFICATION_ID = "ongoing-notification-id";
    public static final String INTENT_KEY_REMOVE_NOTIFICATION = "remove-notification";
    private static final Log LOGGER = LogFactory.getLog(TransferService.class);
    static TransferNetworkLossHandler transferNetworkLossHandler;
    boolean isReceiverNotRegistered = true;
    private int ongoingNotificationId = 1;
    private boolean removeNotification = true;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log log = LOGGER;
        log.info("Starting Transfer Service to listen for network connectivity changes.");
        transferNetworkLossHandler = TransferNetworkLossHandler.getInstance(getApplicationContext());
        synchronized (this) {
            if (this.isReceiverNotRegistered) {
                try {
                    log.info("Registering the network receiver");
                    registerReceiver(transferNetworkLossHandler, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                    this.isReceiverNotRegistered = false;
                } catch (IllegalArgumentException unused) {
                    LOGGER.warn("Ignoring the exception trying to register the receiver for connectivity change.");
                } catch (IllegalStateException unused2) {
                    LOGGER.warn("Ignoring the leak in registering the receiver.");
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
        } catch (Exception e) {
            LOGGER.error("Error in moving the service to foreground state: " + e);
        }
        synchronized (this) {
            try {
                Notification notification = (Notification) intent.getParcelableExtra(INTENT_KEY_NOTIFICATION);
                if (notification != null) {
                    this.ongoingNotificationId = intent.getIntExtra(INTENT_KEY_NOTIFICATION_ID, this.ongoingNotificationId);
                    this.removeNotification = intent.getBooleanExtra(INTENT_KEY_REMOVE_NOTIFICATION, this.removeNotification);
                    LOGGER.info("Putting the service in Foreground state.");
                    startForeground(this.ongoingNotificationId, notification);
                } else {
                    LOGGER.error("No notification is passed in the intent. Unable to transition to foreground.");
                }
                synchronized (this) {
                    if (this.isReceiverNotRegistered) {
                        try {
                            LOGGER.info("Registering the network receiver");
                            registerReceiver(transferNetworkLossHandler, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
                            this.isReceiverNotRegistered = false;
                        } catch (IllegalArgumentException unused) {
                            LOGGER.warn("Ignoring the exception trying to register the receiver for connectivity change.");
                        } catch (IllegalStateException unused2) {
                            LOGGER.warn("Ignoring the leak in registering the receiver.");
                        }
                    }
                }
            } finally {
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            LOGGER.info("Moving the service out of the Foreground state.");
        } catch (Exception e) {
            LOGGER.error("Error in moving the service out of the foreground state: " + e);
        }
        synchronized (this) {
            stopForeground(this.removeNotification);
            try {
                LOGGER.info("De-registering the network receiver.");
                synchronized (this) {
                    try {
                        if (!this.isReceiverNotRegistered) {
                            unregisterReceiver(transferNetworkLossHandler);
                            this.isReceiverNotRegistered = true;
                            transferNetworkLossHandler = null;
                        }
                    } finally {
                    }
                }
            } catch (IllegalArgumentException unused) {
                LOGGER.warn("Exception trying to de-register the network receiver");
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("network status: %s\n", Boolean.valueOf(transferNetworkLossHandler.isNetworkConnected()));
        Map transfers = TransferStatusUpdater.getInstance(this).getTransfers();
        printWriter.printf("# of active transfers: %d\n", Integer.valueOf(transfers.size()));
        for (TransferRecord transferRecord : transfers.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", transferRecord.bucketName, transferRecord.key, transferRecord.state, Long.valueOf(transferRecord.bytesTotal), Long.valueOf(transferRecord.bytesCurrent));
        }
        printWriter.flush();
    }
}
