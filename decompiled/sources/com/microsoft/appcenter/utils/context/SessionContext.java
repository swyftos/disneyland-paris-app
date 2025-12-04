package com.microsoft.appcenter.utils.context;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

/* loaded from: classes4.dex */
public class SessionContext {
    private static SessionContext sInstance;
    private final NavigableMap mSessions = new TreeMap();
    private final long mAppLaunchTimestamp = System.currentTimeMillis();

    private SessionContext() throws NumberFormatException {
        Set<String> stringSet = SharedPreferencesManager.getStringSet("sessions");
        if (stringSet != null) {
            for (String str : stringSet) {
                String[] strArrSplit = str.split("/", -1);
                try {
                    long j = Long.parseLong(strArrSplit[0]);
                    String str2 = strArrSplit[1];
                    this.mSessions.put(Long.valueOf(j), new SessionInfo(j, str2.isEmpty() ? null : UUID.fromString(str2), strArrSplit.length > 2 ? Long.parseLong(strArrSplit[2]) : j));
                } catch (RuntimeException e) {
                    AppCenterLog.warn("AppCenter", "Ignore invalid session in store: " + str, e);
                }
            }
        }
        AppCenterLog.debug("AppCenter", "Loaded stored sessions: " + this.mSessions);
        addSession(null);
    }

    @WorkerThread
    public static synchronized SessionContext getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new SessionContext();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    @VisibleForTesting
    public static synchronized void unsetInstance() {
        sInstance = null;
    }

    public synchronized void addSession(UUID uuid) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.mSessions.put(Long.valueOf(jCurrentTimeMillis), new SessionInfo(jCurrentTimeMillis, uuid, this.mAppLaunchTimestamp));
            if (this.mSessions.size() > 10) {
                this.mSessions.pollFirstEntry();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = this.mSessions.values().iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((SessionInfo) it.next()).toString());
            }
            SharedPreferencesManager.putStringSet("sessions", linkedHashSet);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized SessionInfo getSessionAt(long j) {
        Map.Entry entryFloorEntry = this.mSessions.floorEntry(Long.valueOf(j));
        if (entryFloorEntry == null) {
            return null;
        }
        return (SessionInfo) entryFloorEntry.getValue();
    }

    public synchronized void clearSessions() {
        this.mSessions.clear();
        SharedPreferencesManager.remove("sessions");
    }

    public static class SessionInfo {
        private final long mAppLaunchTimestamp;
        private final UUID mSessionId;
        private final long mTimestamp;

        SessionInfo(long j, UUID uuid, long j2) {
            this.mTimestamp = j;
            this.mSessionId = uuid;
            this.mAppLaunchTimestamp = j2;
        }

        long getTimestamp() {
            return this.mTimestamp;
        }

        public UUID getSessionId() {
            return this.mSessionId;
        }

        public long getAppLaunchTimestamp() {
            return this.mAppLaunchTimestamp;
        }

        @NonNull
        public String toString() {
            String str = getTimestamp() + "/";
            if (getSessionId() != null) {
                str = str + getSessionId();
            }
            return str + "/" + getAppLaunchTimestamp();
        }
    }
}
