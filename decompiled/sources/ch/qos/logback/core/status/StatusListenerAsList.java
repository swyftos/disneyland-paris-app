package ch.qos.logback.core.status;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class StatusListenerAsList implements StatusListener {
    List statusList = new ArrayList();

    @Override // ch.qos.logback.core.status.StatusListener
    public void addStatusEvent(Status status) {
        this.statusList.add(status);
    }

    public List<Status> getStatusList() {
        return this.statusList;
    }
}
