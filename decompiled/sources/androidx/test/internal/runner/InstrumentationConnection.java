package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.LogUtil;
import androidx.test.internal.util.ParcelableIBinder;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.MonitoringInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Beta
/* loaded from: classes2.dex */
public class InstrumentationConnection {
    public static final String BROADCAST_FILTER = "androidx.test.runner.InstrumentationConnection.event";
    private static final InstrumentationConnection DEFAULT_INSTANCE = new InstrumentationConnection(InstrumentationRegistry.getInstrumentation().getTargetContext());
    private static MonitoringInstrumentation.ActivityFinisher activityFinisher;
    private static Instrumentation instrumentation;
    IncomingHandler incomingHandler;
    final BroadcastReceiver messengerReceiver = new MessengerReceiver();
    private Context targetContext;

    InstrumentationConnection(Context context) {
        this.targetContext = (Context) Checks.checkNotNull(context, "Context can't be null");
    }

    public static InstrumentationConnection getInstance() {
        return DEFAULT_INSTANCE;
    }

    public synchronized void init(Instrumentation instrumentation2, MonitoringInstrumentation.ActivityFinisher activityFinisher2) {
        LogUtil.logDebugWithProcess("InstrConnection", "init", new Object[0]);
        if (this.incomingHandler == null) {
            instrumentation = instrumentation2;
            activityFinisher = activityFinisher2;
            HandlerThread handlerThread = new HandlerThread("InstrumentationConnectionThread");
            handlerThread.start();
            this.incomingHandler = new IncomingHandler(handlerThread.getLooper());
            Intent intent = new Intent(BROADCAST_FILTER);
            Bundle bundle = new Bundle();
            bundle.putParcelable("new_instrumentation_binder", new ParcelableIBinder(this.incomingHandler.messengerHandler.getBinder()));
            intent.putExtra("new_instrumentation_binder", bundle);
            try {
                this.targetContext.sendBroadcast(intent);
                this.targetContext.registerReceiver(this.messengerReceiver, new IntentFilter(BROADCAST_FILTER));
            } catch (SecurityException unused) {
                Log.i("InstrConnection", "Could not send broadcast or register receiver (isolatedProcess?)");
            }
        }
    }

    public synchronized void terminate() {
        LogUtil.logDebugWithProcess("InstrConnection", "Terminate is called", new Object[0]);
        IncomingHandler incomingHandler = this.incomingHandler;
        if (incomingHandler != null) {
            incomingHandler.runSyncTask(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.1
                @Override // java.util.concurrent.Callable
                public Void call() throws RemoteException {
                    InstrumentationConnection.this.incomingHandler.doDie();
                    return null;
                }
            });
            this.targetContext.unregisterReceiver(this.messengerReceiver);
            this.incomingHandler = null;
        }
    }

    public synchronized void requestRemoteInstancesActivityCleanup() {
        IncomingHandler incomingHandler;
        Checks.checkState(this.incomingHandler != null, "Instrumentation Connection in not yet initialized");
        UUID uuidRandomUUID = UUID.randomUUID();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.incomingHandler.associateLatch(uuidRandomUUID, countDownLatch);
        Message messageObtainMessage = this.incomingHandler.obtainMessage(10);
        messageObtainMessage.replyTo = this.incomingHandler.messengerHandler;
        Bundle data = messageObtainMessage.getData();
        data.putSerializable("instr_uuid", uuidRandomUUID);
        messageObtainMessage.setData(data);
        this.incomingHandler.sendMessage(messageObtainMessage);
        try {
            try {
                if (!countDownLatch.await(2L, TimeUnit.SECONDS)) {
                    String strValueOf = String.valueOf(uuidRandomUUID);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 60);
                    sb.append("Timed out while attempting to perform activity clean up for ");
                    sb.append(strValueOf);
                    Log.w("InstrConnection", sb.toString());
                }
                incomingHandler = this.incomingHandler;
            } catch (InterruptedException e) {
                String strValueOf2 = String.valueOf(uuidRandomUUID);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 61);
                sb2.append("Interrupted while waiting for response from message with id: ");
                sb2.append(strValueOf2);
                Log.e("InstrConnection", sb2.toString(), e);
                incomingHandler = this.incomingHandler;
            }
            incomingHandler.disassociateLatch(uuidRandomUUID);
        } catch (Throwable th) {
            this.incomingHandler.disassociateLatch(uuidRandomUUID);
            throw th;
        }
    }

    public synchronized void registerClient(String str, Messenger messenger) {
        try {
            Checks.checkState(this.incomingHandler != null, "Instrumentation Connection in not yet initialized");
            String strValueOf = String.valueOf(str);
            Log.i("InstrConnection", strValueOf.length() != 0 ? "Register client of type: ".concat(strValueOf) : new String("Register client of type: "));
            Bundle bundle = new Bundle();
            bundle.putString("instr_client_type", str);
            bundle.putParcelable("instr_client_msgr", messenger);
            Message messageObtainMessage = this.incomingHandler.obtainMessage(8);
            messageObtainMessage.setData(bundle);
            this.incomingHandler.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized Set<Messenger> getClientsForType(String str) {
        return this.incomingHandler.getClientsForType(str);
    }

    public synchronized void unregisterClient(String str, Messenger messenger) {
        try {
            Checks.checkState(this.incomingHandler != null, "Instrumentation Connection in not yet initialized");
            String strValueOf = String.valueOf(str);
            Log.i("InstrConnection", strValueOf.length() != 0 ? "Unregister client of type: ".concat(strValueOf) : new String("Unregister client of type: "));
            Bundle bundle = new Bundle();
            bundle.putString("instr_client_type", str);
            bundle.putParcelable("instr_client_msgr", messenger);
            Message messageObtainMessage = this.incomingHandler.obtainMessage(9);
            messageObtainMessage.setData(bundle);
            this.incomingHandler.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            throw th;
        }
    }

    @VisibleForTesting
    class MessengerReceiver extends BroadcastReceiver {
        MessengerReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LogUtil.logDebugWithProcess("InstrConnection", "Broadcast received", new Object[0]);
            Bundle bundleExtra = intent.getBundleExtra("new_instrumentation_binder");
            if (bundleExtra == null) {
                Log.w("InstrConnection", "Broadcast intent doesn't contain any extras, ignoring it..");
                return;
            }
            ParcelableIBinder parcelableIBinder = (ParcelableIBinder) bundleExtra.getParcelable("new_instrumentation_binder");
            if (parcelableIBinder != null) {
                Messenger messenger = new Messenger(parcelableIBinder.getIBinder());
                Message messageObtainMessage = InstrumentationConnection.this.incomingHandler.obtainMessage(3);
                messageObtainMessage.replyTo = messenger;
                InstrumentationConnection.this.incomingHandler.sendMessage(messageObtainMessage);
            }
        }
    }

    @VisibleForTesting
    static class IncomingHandler extends Handler {
        private final Map latches;
        Messenger messengerHandler;
        Set otherInstrumentations;
        Map typedClients;

        public IncomingHandler(Looper looper) {
            super(looper);
            this.messengerHandler = new Messenger(this);
            this.otherInstrumentations = new HashSet();
            this.typedClients = new HashMap();
            this.latches = new HashMap();
            if (Looper.getMainLooper() == looper || Looper.myLooper() == looper) {
                throw new IllegalStateException("This handler should not be using the main thread looper nor the instrumentation thread looper.");
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws RemoteException {
            int i = message.what;
            switch (i) {
                case 0:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_REMOTE_ADD_CLIENT)", new Object[0]);
                    registerClient(message.getData().getString("instr_client_type"), (Messenger) message.getData().getParcelable("instr_client_msgr"));
                    break;
                case 1:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_REMOTE_REMOVE_CLIENT)", new Object[0]);
                    unregisterClient(message.getData().getString("instr_client_type"), message.replyTo);
                    break;
                case 2:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_TERMINATE)", new Object[0]);
                    doDie();
                    break;
                case 3:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_HANDLE_INSTRUMENTATION_FROM_BROADCAST)", new Object[0]);
                    if (this.otherInstrumentations.add(message.replyTo)) {
                        sendMessageWithReply(message.replyTo, 4, null);
                        break;
                    } else {
                        Log.w("InstrConnection", "Broadcast with existing binder was received, ignoring it..");
                        break;
                    }
                case 4:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_ADD_INSTRUMENTATION)", new Object[0]);
                    if (this.otherInstrumentations.add(message.replyTo)) {
                        if (!this.typedClients.isEmpty()) {
                            sendMessageWithReply(message.replyTo, 6, null);
                        }
                        clientsRegistrationFromBundle(message.getData(), true);
                        break;
                    } else {
                        Log.w("InstrConnection", "Message with existing binder was received, ignoring it..");
                        break;
                    }
                case 5:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_REMOVE_INSTRUMENTATION)", new Object[0]);
                    if (!this.otherInstrumentations.remove(message.replyTo)) {
                        Log.w("InstrConnection", "Attempting to remove a non-existent binder!");
                        break;
                    }
                    break;
                case 6:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_ADD_CLIENTS_IN_BUNDLE)", new Object[0]);
                    clientsRegistrationFromBundle(message.getData(), true);
                    break;
                case 7:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_REMOVE_CLIENTS_IN_BUNDLE)", new Object[0]);
                    clientsRegistrationFromBundle(message.getData(), false);
                    break;
                case 8:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_REG_CLIENT)", new Object[0]);
                    registerClient(message.getData().getString("instr_client_type"), (Messenger) message.getData().getParcelable("instr_client_msgr"));
                    sendMessageToOtherInstr(0, message.getData());
                    break;
                case 9:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_UN_REG_CLIENT)", new Object[0]);
                    unregisterClient(message.getData().getString("instr_client_type"), (Messenger) message.getData().getParcelable("instr_client_msgr"));
                    sendMessageToOtherInstr(1, message.getData());
                    break;
                case 10:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_REMOTE_CLEANUP_REQUEST)", new Object[0]);
                    if (this.otherInstrumentations.isEmpty()) {
                        Message messageObtainMessage = obtainMessage(12);
                        messageObtainMessage.setData(message.getData());
                        sendMessage(messageObtainMessage);
                        break;
                    } else {
                        sendMessageToOtherInstr(11, message.getData());
                        break;
                    }
                case 11:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_PERFORM_CLEANUP)", new Object[0]);
                    InstrumentationConnection.instrumentation.runOnMainSync(InstrumentationConnection.activityFinisher);
                    sendMessageWithReply(message.replyTo, 12, message.getData());
                    break;
                case 12:
                    LogUtil.logDebugWithProcess("InstrConnection", "handleMessage(MSG_PERFORM_CLEANUP_FINISHED)", new Object[0]);
                    notifyLatch((UUID) message.getData().getSerializable("instr_uuid"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder(42);
                    sb.append("Unknown message code received: ");
                    sb.append(i);
                    Log.w("InstrConnection", sb.toString());
                    super.handleMessage(message);
                    break;
            }
        }

        private void notifyLatch(UUID uuid) {
            if (uuid != null && this.latches.containsKey(uuid)) {
                ((CountDownLatch) this.latches.get(uuid)).countDown();
                return;
            }
            String strValueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 16);
            sb.append("Latch not found ");
            sb.append(strValueOf);
            Log.w("InstrConnection", sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void associateLatch(final UUID uuid, final CountDownLatch countDownLatch) {
            runSyncTask(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.1
                @Override // java.util.concurrent.Callable
                public Void call() {
                    IncomingHandler.this.latches.put(uuid, countDownLatch);
                    return null;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void disassociateLatch(final UUID uuid) {
            runSyncTask(new Callable<Void>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.2
                @Override // java.util.concurrent.Callable
                public Void call() {
                    IncomingHandler.this.latches.remove(uuid);
                    return null;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object runSyncTask(Callable callable) {
            FutureTask futureTask = new FutureTask(callable);
            post(futureTask);
            try {
                return futureTask.get();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getCause());
            } catch (ExecutionException e2) {
                throw new IllegalStateException(e2.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doDie() throws RemoteException {
            Log.i("InstrConnection", "terminating process");
            sendMessageToOtherInstr(5, null);
            this.otherInstrumentations.clear();
            this.typedClients.clear();
            LogUtil.logDebugWithProcess("InstrConnection", "quitting looper...", new Object[0]);
            getLooper().quit();
            LogUtil.logDebugWithProcess("InstrConnection", "finishing instrumentation...", new Object[0]);
            InstrumentationConnection.instrumentation.finish(0, null);
            Instrumentation unused = InstrumentationConnection.instrumentation = null;
            MonitoringInstrumentation.ActivityFinisher unused2 = InstrumentationConnection.activityFinisher = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Set getClientsForType(final String str) {
            FutureTask futureTask = new FutureTask(new Callable<Set<Messenger>>() { // from class: androidx.test.internal.runner.InstrumentationConnection.IncomingHandler.3
                @Override // java.util.concurrent.Callable
                public Set<Messenger> call() {
                    return (Set) IncomingHandler.this.typedClients.get(str);
                }
            });
            post(futureTask);
            try {
                return (Set) futureTask.get();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } catch (ExecutionException e2) {
                throw new IllegalStateException(e2.getCause());
            }
        }

        private void sendMessageWithReply(Messenger messenger, int i, Bundle bundle) throws RemoteException {
            StringBuilder sb = new StringBuilder(45);
            sb.append("sendMessageWithReply type: ");
            sb.append(i);
            sb.append(" called");
            LogUtil.logDebugWithProcess("InstrConnection", sb.toString(), new Object[0]);
            Message messageObtainMessage = obtainMessage(i);
            messageObtainMessage.replyTo = this.messengerHandler;
            if (bundle != null) {
                messageObtainMessage.setData(bundle);
            }
            if (!this.typedClients.isEmpty()) {
                Bundle data = messageObtainMessage.getData();
                data.putStringArrayList("instr_clients", new ArrayList<>(this.typedClients.keySet()));
                for (Map.Entry entry : this.typedClients.entrySet()) {
                    data.putParcelableArray(String.valueOf(entry.getKey()), (Messenger[]) ((Set) entry.getValue()).toArray(new Messenger[((Set) entry.getValue()).size()]));
                }
                messageObtainMessage.setData(data);
            }
            try {
                messenger.send(messageObtainMessage);
            } catch (RemoteException e) {
                Log.w("InstrConnection", "The remote process is terminated unexpectedly", e);
                instrBinderDied(messenger);
            }
        }

        private void sendMessageToOtherInstr(int i, Bundle bundle) throws RemoteException {
            LogUtil.logDebugWithProcess("InstrConnection", "sendMessageToOtherInstr() called with: what = [%s], data = [%s]", Integer.valueOf(i), bundle);
            Iterator it = this.otherInstrumentations.iterator();
            while (it.hasNext()) {
                sendMessageWithReply((Messenger) it.next(), i, bundle);
            }
        }

        private void clientsRegistrationFromBundle(Bundle bundle, boolean z) {
            LogUtil.logDebugWithProcess("InstrConnection", "clientsRegistrationFromBundle called", new Object[0]);
            if (bundle == null) {
                Log.w("InstrConnection", "The client bundle is null, ignoring...");
                return;
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList("instr_clients");
            if (stringArrayList == null) {
                Log.w("InstrConnection", "No clients found in the given bundle");
                return;
            }
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Parcelable[] parcelableArray = bundle.getParcelableArray(String.valueOf(next));
                if (parcelableArray != null) {
                    for (Parcelable parcelable : parcelableArray) {
                        if (z) {
                            registerClient(next, (Messenger) parcelable);
                        } else {
                            unregisterClient(next, (Messenger) parcelable);
                        }
                    }
                }
            }
        }

        private void registerClient(String str, Messenger messenger) {
            LogUtil.logDebugWithProcess("InstrConnection", "registerClient called with type = [%s] client = [%s]", str, messenger);
            Checks.checkNotNull(str, "type cannot be null!");
            Checks.checkNotNull(messenger, "client cannot be null!");
            Set set = (Set) this.typedClients.get(str);
            if (set == null) {
                HashSet hashSet = new HashSet();
                hashSet.add(messenger);
                this.typedClients.put(str, hashSet);
                return;
            }
            set.add(messenger);
        }

        private void unregisterClient(String str, Messenger messenger) {
            LogUtil.logDebugWithProcess("InstrConnection", "unregisterClient called with type = [%s] client = [%s]", str, messenger);
            Checks.checkNotNull(str, "type cannot be null!");
            Checks.checkNotNull(messenger, "client cannot be null!");
            if (!this.typedClients.containsKey(str)) {
                String strValueOf = String.valueOf(str);
                Log.w("InstrConnection", strValueOf.length() != 0 ? "There are no registered clients for type: ".concat(strValueOf) : new String("There are no registered clients for type: "));
                return;
            }
            Set set = (Set) this.typedClients.get(str);
            if (!set.contains(messenger)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
                sb.append("Could not unregister client for type ");
                sb.append(str);
                sb.append(" because it doesn't seem to be registered");
                Log.w("InstrConnection", sb.toString());
                return;
            }
            set.remove(messenger);
            if (set.isEmpty()) {
                this.typedClients.remove(str);
            }
        }

        private void instrBinderDied(Messenger messenger) {
            Message messageObtainMessage = obtainMessage(5);
            messageObtainMessage.replyTo = messenger;
            sendMessage(messageObtainMessage);
        }
    }
}
