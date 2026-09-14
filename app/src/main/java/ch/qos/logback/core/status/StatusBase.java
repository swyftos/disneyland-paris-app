package ch.qos.logback.core.status;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StatusBase implements Status {
    private static final List EMPTY_LIST = new ArrayList(0);
    List childrenList;
    long date;
    int level;
    final String message;
    final Object origin;
    Throwable throwable;

    StatusBase(int i, String str, Object obj) {
        this(i, str, obj, null);
    }

    StatusBase(int i, String str, Object obj, Throwable th) {
        this.level = i;
        this.message = str;
        this.origin = obj;
        this.throwable = th;
        this.date = System.currentTimeMillis();
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized void add(Status status) {
        try {
            if (status == null) {
                throw new NullPointerException("Null values are not valid Status.");
            }
            if (this.childrenList == null) {
                this.childrenList = new ArrayList();
            }
            this.childrenList.add(status);
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StatusBase statusBase = (StatusBase) obj;
        if (this.level != statusBase.level) {
            return false;
        }
        String str = this.message;
        if (str == null) {
            if (statusBase.message != null) {
                return false;
            }
        } else if (!str.equals(statusBase.message)) {
            return false;
        }
        return true;
    }

    @Override // ch.qos.logback.core.status.Status
    public Long getDate() {
        return Long.valueOf(this.date);
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized int getEffectiveLevel() {
        int i;
        i = this.level;
        Iterator<Status> it = iterator();
        while (it.hasNext()) {
            int effectiveLevel = it.next().getEffectiveLevel();
            if (effectiveLevel > i) {
                i = effectiveLevel;
            }
        }
        return i;
    }

    @Override // ch.qos.logback.core.status.Status
    public int getLevel() {
        return this.level;
    }

    @Override // ch.qos.logback.core.status.Status
    public String getMessage() {
        return this.message;
    }

    @Override // ch.qos.logback.core.status.Status
    public Object getOrigin() {
        return this.origin;
    }

    @Override // ch.qos.logback.core.status.Status
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized boolean hasChildren() {
        List list;
        list = this.childrenList;
        return list != null && list.size() > 0;
    }

    public int hashCode() {
        int i = (this.level + 31) * 31;
        String str = this.message;
        return i + (str == null ? 0 : str.hashCode());
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized Iterator<Status> iterator() {
        List list = this.childrenList;
        if (list != null) {
            return list.iterator();
        }
        return EMPTY_LIST.iterator();
    }

    @Override // ch.qos.logback.core.status.Status
    public synchronized boolean remove(Status status) {
        List list = this.childrenList;
        if (list == null) {
            return false;
        }
        return list.remove(status);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0022  */
    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int effectiveLevel = getEffectiveLevel();
        if (effectiveLevel == 0) {
            str = "INFO";
        } else {
            if (effectiveLevel != 1) {
                if (effectiveLevel == 2) {
                    str = "ERROR";
                }
                if (this.origin != null) {
                    sb.append(" in ");
                    sb.append(this.origin);
                    sb.append(" -");
                }
                sb.append(" ");
                sb.append(this.message);
                if (this.throwable != null) {
                    sb.append(" ");
                    sb.append(this.throwable);
                }
                return sb.toString();
            }
            str = "WARN";
        }
        sb.append(str);
        if (this.origin != null) {
            sb.append(" in ");
            sb.append(this.origin);
            sb.append(" -");
        }
        sb.append(" ");
        sb.append(this.message);
        if (this.throwable != null) {
            sb.append(" ");
            sb.append(this.throwable);
        }
        return sb.toString();
    }
}
