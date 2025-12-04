package ch.qos.logback.core.status;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class StatusUtil {
    StatusManager sm;

    public StatusUtil(Context context) {
        this.sm = context.getStatusManager();
    }

    public StatusUtil(StatusManager statusManager) {
        this.sm = statusManager;
    }

    public static boolean contextHasStatusListener(Context context) {
        List<StatusListener> copyOfStatusListenerList;
        StatusManager statusManager = context.getStatusManager();
        return (statusManager == null || (copyOfStatusListenerList = statusManager.getCopyOfStatusListenerList()) == null || copyOfStatusListenerList.size() == 0) ? false : true;
    }

    public static List<Status> filterStatusListByTimeThreshold(List<Status> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (Status status : list) {
            if (status.getDate().longValue() >= j) {
                arrayList.add(status);
            }
        }
        return arrayList;
    }

    public void addError(Object obj, String str, Throwable th) {
        addStatus(new ErrorStatus(str, obj, th));
    }

    public void addInfo(Object obj, String str) {
        addStatus(new InfoStatus(str, obj));
    }

    public void addStatus(Status status) {
        StatusManager statusManager = this.sm;
        if (statusManager != null) {
            statusManager.add(status);
        }
    }

    public void addWarn(Object obj, String str) {
        addStatus(new WarnStatus(str, obj));
    }

    public boolean containsException(Class<?> cls) {
        Iterator<Status> it = this.sm.getCopyOfStatusList().iterator();
        while (it.hasNext()) {
            for (Throwable throwable = it.next().getThrowable(); throwable != null; throwable = throwable.getCause()) {
                if (throwable.getClass().getName().equals(cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsMatch(int i, String str) {
        return containsMatch(0L, i, str);
    }

    public boolean containsMatch(long j, int i, String str) {
        List<Status> listFilterStatusListByTimeThreshold = filterStatusListByTimeThreshold(this.sm.getCopyOfStatusList(), j);
        Pattern patternCompile = Pattern.compile(str);
        for (Status status : listFilterStatusListByTimeThreshold) {
            if (i == status.getLevel() && patternCompile.matcher(status.getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMatch(String str) {
        Pattern patternCompile = Pattern.compile(str);
        Iterator<Status> it = this.sm.getCopyOfStatusList().iterator();
        while (it.hasNext()) {
            if (patternCompile.matcher(it.next().getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    public int getHighestLevel(long j) {
        int level = 0;
        for (Status status : filterStatusListByTimeThreshold(this.sm.getCopyOfStatusList(), j)) {
            if (status.getLevel() > level) {
                level = status.getLevel();
            }
        }
        return level;
    }

    public boolean hasXMLParsingErrors(long j) {
        return containsMatch(j, 2, CoreConstants.XML_PARSING);
    }

    public boolean isErrorFree(long j) {
        return 2 > getHighestLevel(j);
    }

    public boolean isWarningOrErrorFree(long j) {
        return 1 > getHighestLevel(j);
    }

    public int matchCount(String str) {
        Pattern patternCompile = Pattern.compile(str);
        Iterator<Status> it = this.sm.getCopyOfStatusList().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (patternCompile.matcher(it.next().getMessage()).lookingAt()) {
                i++;
            }
        }
        return i;
    }

    public boolean noXMLParsingErrorsOccurred(long j) {
        return !hasXMLParsingErrors(j);
    }

    public long timeOfLastReset() {
        List<Status> copyOfStatusList = this.sm.getCopyOfStatusList();
        if (copyOfStatusList == null) {
            return -1L;
        }
        for (int size = copyOfStatusList.size() - 1; size >= 0; size--) {
            Status status = copyOfStatusList.get(size);
            if (CoreConstants.RESET_MSG_PREFIX.equals(status.getMessage())) {
                return status.getDate().longValue();
            }
        }
        return -1L;
    }
}
