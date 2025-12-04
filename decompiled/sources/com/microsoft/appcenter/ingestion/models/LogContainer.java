package com.microsoft.appcenter.ingestion.models;

import java.util.List;

/* loaded from: classes4.dex */
public class LogContainer {
    private List logs;

    public List<Log> getLogs() {
        return this.logs;
    }

    public void setLogs(List<Log> list) {
        this.logs = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LogContainer logContainer = (LogContainer) obj;
        List list = this.logs;
        return list != null ? list.equals(logContainer.logs) : logContainer.logs == null;
    }

    public int hashCode() {
        List list = this.logs;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }
}
