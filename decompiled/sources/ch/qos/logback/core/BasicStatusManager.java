package ch.qos.logback.core;

import ch.qos.logback.core.helpers.CyclicBuffer;
import ch.qos.logback.core.spi.LogbackLock;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;
import ch.qos.logback.core.status.WarnStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BasicStatusManager implements StatusManager {
    public static final int MAX_HEADER_COUNT = 150;
    public static final int TAIL_SIZE = 150;
    int count = 0;
    protected final List<Status> statusList = new ArrayList();
    protected final CyclicBuffer<Status> tailBuffer = new CyclicBuffer<>(150);
    protected final LogbackLock statusListLock = new LogbackLock();
    int level = 0;
    protected final List<StatusListener> statusListenerList = new ArrayList();
    protected final LogbackLock statusListenerListLock = new LogbackLock();

    private boolean checkForPresence(List list, Class cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((StatusListener) it.next()).getClass() == cls) {
                return true;
            }
        }
        return false;
    }

    private void fireStatusAddEvent(Status status) {
        synchronized (this.statusListenerListLock) {
            try {
                Iterator<StatusListener> it = this.statusListenerList.iterator();
                while (it.hasNext()) {
                    it.next().addStatusEvent(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public void add(Status status) {
        fireStatusAddEvent(status);
        this.count++;
        if (status.getLevel() > this.level) {
            this.level = status.getLevel();
        }
        synchronized (this.statusListLock) {
            try {
                if (this.statusList.size() < 150) {
                    this.statusList.add(status);
                } else {
                    this.tailBuffer.add(status);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public boolean add(StatusListener statusListener) {
        synchronized (this.statusListenerListLock) {
            try {
                if ((statusListener instanceof OnConsoleStatusListener) && checkForPresence(this.statusListenerList, statusListener.getClass())) {
                    return false;
                }
                this.statusListenerList.add(statusListener);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public boolean addUniquely(StatusListener statusListener, Object obj) {
        for (StatusListener statusListener2 : getCopyOfStatusListenerList()) {
            if (statusListener2.getClass().isInstance(statusListener)) {
                add(new WarnStatus("A previous listener of type [" + statusListener2.getClass() + "] has been already registered. Skipping double registration.", obj));
                return false;
            }
        }
        add(statusListener);
        return true;
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public void clear() {
        synchronized (this.statusListLock) {
            this.count = 0;
            this.statusList.clear();
            this.tailBuffer.clear();
        }
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public List<Status> getCopyOfStatusList() {
        ArrayList arrayList;
        synchronized (this.statusListLock) {
            arrayList = new ArrayList(this.statusList);
            arrayList.addAll(this.tailBuffer.asList());
        }
        return arrayList;
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public List<StatusListener> getCopyOfStatusListenerList() {
        ArrayList arrayList;
        synchronized (this.statusListenerListLock) {
            arrayList = new ArrayList(this.statusListenerList);
        }
        return arrayList;
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public int getCount() {
        return this.count;
    }

    public int getLevel() {
        return this.level;
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public void remove(StatusListener statusListener) {
        synchronized (this.statusListenerListLock) {
            this.statusListenerList.remove(statusListener);
        }
    }
}
