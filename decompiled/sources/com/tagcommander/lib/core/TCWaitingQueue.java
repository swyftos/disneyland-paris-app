package com.tagcommander.lib.core;

import android.content.Context;
import com.tagcommander.lib.core.TCEventManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCWaitingQueue implements TCEventManager.TCLifecycleListener, TCEventManager.TCNetworkListener, TCEventManager.TCServerSideStateListener {
    private volatile Context appContext;
    public int offlineHitMaxHitInQueue;
    private volatile ETCWaitingQueueState queueState;
    public ETCConsentState serverSideState;
    private final ScheduledThreadPoolExecutor tcAsyncLoader = new ScheduledThreadPoolExecutor(1);
    private final CopyOnWriteArrayList queue = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList tempQueue = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList consentQueue = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList treatedQueue = new CopyOnWriteArrayList();

    public TCWaitingQueue(Context context) throws IOException {
        this.appContext = context.getApplicationContext();
        setQueueState(ETCWaitingQueueState.OFFLINE);
        this.offlineHitMaxHitInQueue = 2000;
        TCEventManager.getInstance().registerLifecycleListener(this);
        TCEventManager.getInstance().registerNetworkListener(this);
        TCEventManager.getInstance().registerServerSideStateListener(this);
    }

    private ETCWaitingQueueState getWaitingQueueState() {
        ETCWaitingQueueState eTCWaitingQueueState;
        synchronized (this.queueState) {
            eTCWaitingQueueState = this.queueState;
        }
        return eTCWaitingQueueState;
    }

    public void addConsent(TCHTTPOperation tCHTTPOperation) {
        synchronized (this.consentQueue) {
            this.consentQueue.add(tCHTTPOperation);
            tryToExecuteConsent();
        }
    }

    public void add(TCHTTPOperation tCHTTPOperation) throws IOException {
        if (getWaitingQueueState() == ETCWaitingQueueState.EXECUTING) {
            this.tempQueue.add(tCHTTPOperation);
            return;
        }
        ETCWaitingQueueState waitingQueueState = getWaitingQueueState();
        ETCWaitingQueueState eTCWaitingQueueState = ETCWaitingQueueState.OFFLINE;
        if (waitingQueueState == eTCWaitingQueueState && TCEventManager.getInstance().internetUp.booleanValue() && TCEventManager.getInstance().isForeground.booleanValue()) {
            setQueueState(ETCWaitingQueueState.WAITING);
        }
        this.queue.add(tCHTTPOperation);
        checkOperationsInQueue();
        if (getWaitingQueueState() == eTCWaitingQueueState && TCCoreVariables.getInstance().enableHTTPInBG) {
            saveQueue();
        }
        tryToExecuteQueue();
    }

    void checkOperationsInQueue() {
        ArrayList arrayList = new ArrayList();
        int size = this.queue.size() - this.offlineHitMaxHitInQueue;
        for (int i = 0; i < size; i++) {
            TCHTTPOperation tCHTTPOperation = (TCHTTPOperation) this.queue.get(i);
            if (tCHTTPOperation != null) {
                arrayList.add(tCHTTPOperation);
            }
        }
        this.queue.removeAll(arrayList);
    }

    public void tryToExecuteQueue() throws IOException {
        if (getWaitingQueueState() != ETCWaitingQueueState.WAITING || this.queue.size() <= 0 || this.serverSideState == ETCConsentState.WAITING_FOR_CONSENT) {
            return;
        }
        setQueueState(ETCWaitingQueueState.EXECUTING);
        this.tcAsyncLoader.execute(new Runnable() { // from class: com.tagcommander.lib.core.TCWaitingQueue.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                TCWaitingQueue.this.processQueue();
            }
        });
    }

    public void tryToExecuteConsent() {
        if (this.consentQueue.size() > 0) {
            this.tcAsyncLoader.execute(new Runnable() { // from class: com.tagcommander.lib.core.TCWaitingQueue.2
                @Override // java.lang.Runnable
                public void run() {
                    TCWaitingQueue.this.processConsentHit();
                }
            });
        }
    }

    public void processConsentHit() {
        if (this.consentQueue.size() <= 0 || !TCEventManager.getInstance().internetUp.booleanValue()) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.consentQueue.iterator();
            while (it.hasNext()) {
                TCHTTPOperation tCHTTPOperation = (TCHTTPOperation) it.next();
                if (tCHTTPOperation.treatOperation() == 0 || (TCEventManager.getInstance().internetUp.booleanValue() && getWaitingQueueState() != ETCWaitingQueueState.OFFLINE)) {
                    arrayList.add(tCHTTPOperation);
                }
                arrayList.add(tCHTTPOperation);
            }
            this.consentQueue.removeAll(arrayList);
        } catch (Exception e) {
            TCLogger.getInstance().logMessage("" + e.getMessage(), 7);
        }
    }

    void processQueue() throws IOException {
        if (this.queue.size() > 0 && this.queue.get(0) != null && !TCEventManager.getInstance().internetUp.booleanValue()) {
            setQueueState(ETCWaitingQueueState.OFFLINE);
            return;
        }
        try {
            ListIterator listIterator = new CopyOnWriteArrayList(this.queue).listIterator();
            while (listIterator.hasNext()) {
                TCHTTPOperation tCHTTPOperation = (TCHTTPOperation) listIterator.next();
                this.treatedQueue.add(tCHTTPOperation);
                if (tCHTTPOperation.treatOperation() != 0 && (!TCEventManager.getInstance().internetUp.booleanValue() || getWaitingQueueState() == ETCWaitingQueueState.OFFLINE)) {
                    setQueueState(ETCWaitingQueueState.OFFLINE);
                    break;
                } else if (getWaitingQueueState() == ETCWaitingQueueState.OFFLINE) {
                    break;
                } else if (TCCoreVariables.getInstance().enableHTTPInBG) {
                    saveQueue();
                }
            }
        } catch (Exception e) {
            TCLogger.getInstance().logMessage(e.getMessage(), 7);
        }
        this.queue.removeAll(this.treatedQueue);
        this.treatedQueue.clear();
        if (this.tempQueue.size() > 0) {
            this.queue.addAll(this.tempQueue);
            this.tempQueue.clear();
            if (getWaitingQueueState() != ETCWaitingQueueState.OFFLINE) {
                processQueue();
                return;
            }
            return;
        }
        if (getWaitingQueueState() == ETCWaitingQueueState.EXECUTING) {
            setQueueState(ETCWaitingQueueState.WAITING);
        }
    }

    public int size() {
        return this.queue.size();
    }

    public void waitUntilProcessingIsDone() {
        while (this.queueState != ETCWaitingQueueState.WAITING) {
        }
    }

    public void clearAllOperationInQueue() {
        synchronized (this.queue) {
            this.queue.clear();
        }
        synchronized (this.tempQueue) {
            this.tempQueue.clear();
        }
    }

    public void setQueueState(ETCWaitingQueueState eTCWaitingQueueState) throws IOException {
        if (eTCWaitingQueueState == ETCWaitingQueueState.OFFLINE && TCCoreVariables.getInstance().enableHTTPInBG) {
            saveQueue();
        }
        synchronized (eTCWaitingQueueState) {
            this.queueState = eTCWaitingQueueState;
        }
    }

    public int getQueueState() {
        return this.queueState.getValue();
    }

    public List<TCHTTPOperation> getOperations() {
        return this.queue;
    }

    private void updateQueueWithCategories(JSONObject jSONObject) {
        synchronized (this.queue) {
            try {
                Iterator it = this.queue.iterator();
                while (it.hasNext()) {
                    ((TCHTTPOperation) it.next()).addTCUserData(jSONObject);
                }
            } finally {
            }
        }
        synchronized (this.tempQueue) {
            try {
                Iterator it2 = this.tempQueue.iterator();
                while (it2.hasNext()) {
                    ((TCHTTPOperation) it2.next()).addTCUserData(jSONObject);
                }
            } finally {
            }
        }
    }

    private void saveQueue() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.queue.removeAll(this.treatedQueue);
        this.treatedQueue.clear();
        arrayList.addAll(this.queue);
        if (!TCCoreVariables.getInstance().enableHTTPInBG) {
            this.queue.clear();
        }
        arrayList.addAll(this.tempQueue);
        if (!TCCoreVariables.getInstance().enableHTTPInBG) {
            this.tempQueue.clear();
        }
        writeNetworkOfflineData(arrayList);
    }

    public void writeNetworkOfflineData(List<TCHTTPOperation> list) throws IOException {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        TCLogger.getInstance().logMessage("Storing " + list.size() + " offline hits", 3);
        for (TCHTTPOperation tCHTTPOperation : list) {
            if (tCHTTPOperation != null) {
                arrayList.add(tCHTTPOperation.information);
            }
        }
        writeOfflineData(arrayList);
    }

    public void writeOfflineData(List<?> list) throws IOException {
        if (list.size() <= 0) {
            this.appContext.deleteFile(TCCoreConstants.kTCDefaultOfflineFileNameHTTPOperations);
            return;
        }
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = this.appContext.openFileOutput(TCCoreConstants.kTCDefaultOfflineFileNameHTTPOperations, 0);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStreamOpenFileOutput);
            objectOutputStream.writeObject(list);
            fileOutputStreamOpenFileOutput.close();
            objectOutputStream.close();
        } catch (Exception unused) {
            Object obj = list.get(0);
            TCLogger.getInstance().logMessage("Error writing offline data of type: " + obj.getClass().getName() + "(" + list.size() + ")", 6);
        }
    }

    public List<TCHTTPOperationInformation> restoreNetworkManagerOfflineData() {
        try {
            ArrayList arrayList = (ArrayList) new ObjectInputStream(this.appContext.openFileInput(TCCoreConstants.kTCDefaultOfflineFileNameHTTPOperations)).readObject();
            TCLogger.getInstance().logMessage("Restoring " + arrayList.size() + " offline hits", 3);
            this.appContext.deleteFile(TCCoreConstants.kTCDefaultOfflineFileNameHTTPOperations);
            return arrayList;
        } catch (FileNotFoundException unused) {
            TCLogger.getInstance().logMessage("No offline HTTPOperations", 4);
            return new ArrayList();
        } catch (Exception unused2) {
            TCLogger.getInstance().logMessage("Error reading NetworkManager's offline data", 7);
            return new ArrayList();
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLifecycleListener
    public void onGoingBackground() throws IOException {
        if (TCCoreVariables.getInstance().enableHTTPInBG) {
            return;
        }
        setQueueState(ETCWaitingQueueState.OFFLINE);
        saveQueue();
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCLifecycleListener
    public void onGoingForeground() throws IOException {
        if (!TCCoreVariables.getInstance().enableHTTPInBG || (TCCoreVariables.getInstance().enableHTTPInBG && this.queueState != ETCWaitingQueueState.EXECUTING)) {
            List<TCHTTPOperationInformation> listRestoreNetworkManagerOfflineData = restoreNetworkManagerOfflineData();
            if (listRestoreNetworkManagerOfflineData.size() > 0) {
                Iterator<TCHTTPOperationInformation> it = listRestoreNetworkManagerOfflineData.iterator();
                while (it.hasNext()) {
                    add(new TCHTTPOperation(it.next(), this.appContext));
                }
            }
            if (this.queueState != ETCWaitingQueueState.EXECUTING) {
                setQueueState(ETCWaitingQueueState.WAITING);
                tryToExecuteQueue();
            }
        }
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCNetworkListener
    public void onInternetUp() throws IOException {
        if (this.queueState == ETCWaitingQueueState.OFFLINE) {
            setQueueState(ETCWaitingQueueState.WAITING);
            tryToExecuteQueue();
        }
        tryToExecuteConsent();
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCNetworkListener
    public void onInternetDown() throws IOException {
        setQueueState(ETCWaitingQueueState.OFFLINE);
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onEnablingTheServerSide() throws IOException {
        updateQueueWithCategories(TCUser.getInstance().getJsonObject());
        this.serverSideState = ETCConsentState.ENABLED;
        tryToExecuteQueue();
    }

    @Override // com.tagcommander.lib.core.TCEventManager.TCServerSideStateListener
    public void onStoppingTheServerSide() {
        if (this.serverSideState == ETCConsentState.WAITING_FOR_CONSENT) {
            clearAllOperationInQueue();
        }
        this.serverSideState = ETCConsentState.DISABLED;
    }
}
