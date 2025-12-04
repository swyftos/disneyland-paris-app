package com.microsoft.appcenter.channel;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.media3.common.C;
import com.microsoft.appcenter.CancellationException;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.HttpResponse;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.AppCenterIngestion;
import com.microsoft.appcenter.ingestion.Ingestion;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import com.microsoft.appcenter.persistence.DatabasePersistence;
import com.microsoft.appcenter.persistence.Persistence;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.DeviceInfoHelper;
import com.microsoft.appcenter.utils.IdHelper;
import com.microsoft.appcenter.utils.storage.SharedPreferencesManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes4.dex */
public class DefaultChannel implements Channel {
    private final Handler mAppCenterHandler;
    private String mAppSecret;
    private final Context mContext;
    private int mCurrentState;
    private Device mDevice;
    private boolean mDiscardLogs;
    private boolean mEnabled;
    private final Map mGroupStates;
    private final Ingestion mIngestion;
    private final Set mIngestions;
    private final UUID mInstallId;
    private final Collection mListeners;
    private final Persistence mPersistence;

    public DefaultChannel(@NonNull Context context, String str, @NonNull LogSerializer logSerializer, @NonNull HttpClient httpClient, @NonNull Handler handler) {
        this(context, str, buildDefaultPersistence(context, logSerializer), new AppCenterIngestion(httpClient, logSerializer), handler);
    }

    DefaultChannel(Context context, String str, Persistence persistence, Ingestion ingestion, Handler handler) {
        this.mContext = context;
        this.mAppSecret = str;
        this.mInstallId = IdHelper.getInstallId();
        this.mGroupStates = new HashMap();
        this.mListeners = new LinkedHashSet();
        this.mPersistence = persistence;
        this.mIngestion = ingestion;
        HashSet hashSet = new HashSet();
        this.mIngestions = hashSet;
        hashSet.add(ingestion);
        this.mAppCenterHandler = handler;
        this.mEnabled = true;
    }

    private static Persistence buildDefaultPersistence(Context context, LogSerializer logSerializer) {
        DatabasePersistence databasePersistence = new DatabasePersistence(context);
        databasePersistence.setLogSerializer(logSerializer);
        return databasePersistence;
    }

    @Override // com.microsoft.appcenter.channel.Channel
    @WorkerThread
    public boolean setMaxStorageSize(long j) {
        return this.mPersistence.setMaxStorageSize(j);
    }

    private boolean checkStateDidNotChange(GroupState groupState, int i) {
        return i == this.mCurrentState && groupState == this.mGroupStates.get(groupState.mName);
    }

    @Override // com.microsoft.appcenter.channel.Channel
    @WorkerThread
    public void setAppSecret(@NonNull String str) throws IllegalArgumentException {
        this.mAppSecret = str;
        if (this.mEnabled) {
            for (GroupState groupState : this.mGroupStates.values()) {
                if (groupState.mIngestion == this.mIngestion) {
                    checkPendingLogs(groupState);
                }
            }
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void addGroup(String str, int i, long j, int i2, Ingestion ingestion, Channel.GroupListener groupListener) throws IllegalArgumentException {
        AppCenterLog.debug("AppCenter", "addGroup(" + str + ")");
        Ingestion ingestion2 = ingestion == null ? this.mIngestion : ingestion;
        this.mIngestions.add(ingestion2);
        GroupState groupState = new GroupState(str, i, j, i2, ingestion2, groupListener);
        this.mGroupStates.put(str, groupState);
        groupState.mPendingLogCount = this.mPersistence.countLogs(str);
        if (this.mAppSecret != null || this.mIngestion != ingestion2) {
            checkPendingLogs(groupState);
        }
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((Channel.Listener) it.next()).onGroupAdded(str, groupListener, j);
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void removeGroup(String str) {
        AppCenterLog.debug("AppCenter", "removeGroup(" + str + ")");
        GroupState groupState = (GroupState) this.mGroupStates.remove(str);
        if (groupState != null) {
            cancelTimer(groupState);
        }
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((Channel.Listener) it.next()).onGroupRemoved(str);
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void pauseGroup(String str, String str2) {
        GroupState groupState = (GroupState) this.mGroupStates.get(str);
        if (groupState != null) {
            if (str2 != null) {
                String targetKey = PartAUtils.getTargetKey(str2);
                if (groupState.mPausedTargetKeys.add(targetKey)) {
                    AppCenterLog.debug("AppCenter", "pauseGroup(" + str + ", " + targetKey + ")");
                }
            } else if (!groupState.mPaused) {
                AppCenterLog.debug("AppCenter", "pauseGroup(" + str + ")");
                groupState.mPaused = true;
                cancelTimer(groupState);
            }
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((Channel.Listener) it.next()).onPaused(str, str2);
            }
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void resumeGroup(String str, String str2) throws IllegalArgumentException {
        GroupState groupState = (GroupState) this.mGroupStates.get(str);
        if (groupState != null) {
            if (str2 != null) {
                String targetKey = PartAUtils.getTargetKey(str2);
                if (groupState.mPausedTargetKeys.remove(targetKey)) {
                    AppCenterLog.debug("AppCenter", "resumeGroup(" + str + ", " + targetKey + ")");
                    groupState.mPendingLogCount = this.mPersistence.countLogs(str);
                    checkPendingLogs(groupState);
                }
            } else if (groupState.mPaused) {
                AppCenterLog.debug("AppCenter", "resumeGroup(" + str + ")");
                groupState.mPaused = false;
                checkPendingLogs(groupState);
            }
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((Channel.Listener) it.next()).onResumed(str, str2);
            }
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void setEnabled(boolean z) throws IOException, IllegalArgumentException {
        if (this.mEnabled == z) {
            return;
        }
        if (z) {
            this.mEnabled = true;
            this.mDiscardLogs = false;
            this.mCurrentState++;
            Iterator it = this.mIngestions.iterator();
            while (it.hasNext()) {
                ((Ingestion) it.next()).reopen();
            }
            Iterator it2 = this.mGroupStates.values().iterator();
            while (it2.hasNext()) {
                checkPendingLogs((GroupState) it2.next());
            }
        } else {
            suspend(true, new CancellationException());
        }
        Iterator it3 = this.mListeners.iterator();
        while (it3.hasNext()) {
            ((Channel.Listener) it3.next()).onGloballyEnabled(z);
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void setLogUrl(String str) {
        this.mIngestion.setLogUrl(str);
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void clear(String str) {
        if (this.mGroupStates.containsKey(str)) {
            AppCenterLog.debug("AppCenter", "clear(" + str + ")");
            this.mPersistence.deleteLogs(str);
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((Channel.Listener) it.next()).onClear(str);
            }
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void invalidateDeviceCache() {
        this.mDevice = null;
    }

    private void suspend(boolean z, Exception exc) throws IOException {
        Channel.GroupListener groupListener;
        this.mEnabled = false;
        this.mDiscardLogs = z;
        this.mCurrentState++;
        for (GroupState groupState : this.mGroupStates.values()) {
            cancelTimer(groupState);
            Iterator it = groupState.mSendingBatches.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                it.remove();
                if (z && (groupListener = groupState.mListener) != null) {
                    Iterator it2 = ((List) entry.getValue()).iterator();
                    while (it2.hasNext()) {
                        groupListener.onFailure((Log) it2.next(), exc);
                    }
                }
            }
        }
        for (Ingestion ingestion : this.mIngestions) {
            try {
                ingestion.close();
            } catch (IOException e) {
                AppCenterLog.error("AppCenter", "Failed to close ingestion: " + ingestion, e);
            }
        }
        if (z) {
            Iterator it3 = this.mGroupStates.values().iterator();
            while (it3.hasNext()) {
                deleteLogsOnSuspended((GroupState) it3.next());
            }
            return;
        }
        this.mPersistence.clearPendingLogState();
    }

    private void deleteLogsOnSuspended(GroupState groupState) {
        ArrayList<Log> arrayList = new ArrayList();
        this.mPersistence.getLogs(groupState.mName, Collections.emptyList(), 100, arrayList);
        if (arrayList.size() > 0 && groupState.mListener != null) {
            for (Log log : arrayList) {
                groupState.mListener.onBeforeSending(log);
                groupState.mListener.onFailure(log, new CancellationException());
            }
        }
        if (arrayList.size() >= 100 && groupState.mListener != null) {
            deleteLogsOnSuspended(groupState);
        } else {
            this.mPersistence.deleteLogs(groupState.mName);
        }
    }

    void cancelTimer(GroupState groupState) {
        if (groupState.mScheduled) {
            groupState.mScheduled = false;
            this.mAppCenterHandler.removeCallbacks(groupState.mRunnable);
            SharedPreferencesManager.remove("startTimerPrefix." + groupState.mName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerIngestion(GroupState groupState) throws IllegalArgumentException {
        if (this.mEnabled) {
            int i = groupState.mPendingLogCount;
            int iMin = Math.min(i, groupState.mMaxLogsPerBatch);
            AppCenterLog.debug("AppCenter", "triggerIngestion(" + groupState.mName + ") pendingLogCount=" + i);
            cancelTimer(groupState);
            if (groupState.mSendingBatches.size() == groupState.mMaxParallelBatches) {
                AppCenterLog.debug("AppCenter", "Already sending " + groupState.mMaxParallelBatches + " batches of analytics data to the server.");
                return;
            }
            ArrayList arrayList = new ArrayList(iMin);
            String logs = this.mPersistence.getLogs(groupState.mName, groupState.mPausedTargetKeys, iMin, arrayList);
            groupState.mPendingLogCount -= iMin;
            if (logs == null) {
                return;
            }
            AppCenterLog.debug("AppCenter", "ingestLogs(" + groupState.mName + "," + logs + ") pendingLogCount=" + groupState.mPendingLogCount);
            if (groupState.mListener != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    groupState.mListener.onBeforeSending((Log) it.next());
                }
            }
            groupState.mSendingBatches.put(logs, arrayList);
            sendLogs(groupState, this.mCurrentState, arrayList, logs);
        }
    }

    private void sendLogs(final GroupState groupState, final int i, List list, final String str) throws IllegalArgumentException {
        LogContainer logContainer = new LogContainer();
        logContainer.setLogs(list);
        groupState.mIngestion.sendAsync(this.mAppSecret, this.mInstallId, logContainer, new ServiceCallback() { // from class: com.microsoft.appcenter.channel.DefaultChannel.1
            @Override // com.microsoft.appcenter.http.ServiceCallback
            public void onCallSucceeded(HttpResponse httpResponse) {
                DefaultChannel.this.mAppCenterHandler.post(new Runnable() { // from class: com.microsoft.appcenter.channel.DefaultChannel.1.1
                    @Override // java.lang.Runnable
                    public void run() throws IllegalArgumentException {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        DefaultChannel.this.handleSendingSuccess(groupState, str);
                    }
                });
            }

            @Override // com.microsoft.appcenter.http.ServiceCallback
            public void onCallFailed(final Exception exc) {
                DefaultChannel.this.mAppCenterHandler.post(new Runnable() { // from class: com.microsoft.appcenter.channel.DefaultChannel.1.2
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        DefaultChannel.this.handleSendingFailure(groupState, str, exc);
                    }
                });
            }
        });
        this.mAppCenterHandler.post(new Runnable() { // from class: com.microsoft.appcenter.channel.DefaultChannel.2
            @Override // java.lang.Runnable
            public void run() throws IllegalArgumentException {
                DefaultChannel.this.checkPendingLogsAfterPost(groupState, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPendingLogsAfterPost(GroupState groupState, int i) throws IllegalArgumentException {
        if (checkStateDidNotChange(groupState, i)) {
            checkPendingLogs(groupState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendingSuccess(GroupState groupState, String str) throws IllegalArgumentException {
        List list = (List) groupState.mSendingBatches.remove(str);
        if (list != null) {
            this.mPersistence.deleteLogs(groupState.mName, str);
            Channel.GroupListener groupListener = groupState.mListener;
            if (groupListener != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    groupListener.onSuccess((Log) it.next());
                }
            }
            checkPendingLogs(groupState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendingFailure(GroupState groupState, String str, Exception exc) throws IOException {
        String str2 = groupState.mName;
        List list = (List) groupState.mSendingBatches.remove(str);
        if (list != null) {
            AppCenterLog.error("AppCenter", "Sending logs groupName=" + str2 + " id=" + str + " failed", exc);
            boolean zIsRecoverableError = HttpUtils.isRecoverableError(exc);
            if (zIsRecoverableError) {
                groupState.mPendingLogCount += list.size();
            } else {
                Channel.GroupListener groupListener = groupState.mListener;
                if (groupListener != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        groupListener.onFailure((Log) it.next(), exc);
                    }
                }
            }
            suspend(!zIsRecoverableError, exc);
        }
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void enqueue(@NonNull Log log, @NonNull String str, int i) throws IllegalArgumentException {
        boolean z;
        GroupState groupState = (GroupState) this.mGroupStates.get(str);
        if (groupState == null) {
            AppCenterLog.error("AppCenter", "Invalid group name:" + str);
            return;
        }
        if (this.mDiscardLogs) {
            AppCenterLog.warn("AppCenter", "Channel is disabled, the log is discarded.");
            Channel.GroupListener groupListener = groupState.mListener;
            if (groupListener != null) {
                groupListener.onBeforeSending(log);
                groupState.mListener.onFailure(log, new CancellationException());
                return;
            }
            return;
        }
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((Channel.Listener) it.next()).onPreparingLog(log, str);
        }
        if (log.getDevice() == null) {
            if (this.mDevice == null) {
                try {
                    this.mDevice = DeviceInfoHelper.getDeviceInfo(this.mContext);
                } catch (DeviceInfoHelper.DeviceInfoException e) {
                    AppCenterLog.error("AppCenter", "Device log cannot be generated", e);
                    return;
                }
            }
            log.setDevice(this.mDevice);
        }
        if (log.getTimestamp() == null) {
            log.setTimestamp(new Date());
        }
        Iterator it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            ((Channel.Listener) it2.next()).onPreparedLog(log, str, i);
        }
        loop2: while (true) {
            for (Channel.Listener listener : this.mListeners) {
                z = z || listener.shouldFilter(log);
            }
        }
        if (z) {
            AppCenterLog.debug("AppCenter", "Log of type '" + log.getType() + "' was filtered out by listener(s)");
            return;
        }
        if (this.mAppSecret == null && groupState.mIngestion == this.mIngestion) {
            AppCenterLog.debug("AppCenter", "Log of type '" + log.getType() + "' was not filtered out by listener(s) but no app secret was provided. Not persisting/sending the log.");
            return;
        }
        try {
            this.mPersistence.putLog(log, str, i);
            Iterator<String> it3 = log.getTransmissionTargetTokens().iterator();
            String targetKey = it3.hasNext() ? PartAUtils.getTargetKey(it3.next()) : null;
            if (groupState.mPausedTargetKeys.contains(targetKey)) {
                AppCenterLog.debug("AppCenter", "Transmission target ikey=" + targetKey + " is paused.");
                return;
            }
            groupState.mPendingLogCount++;
            AppCenterLog.debug("AppCenter", "enqueue(" + groupState.mName + ") pendingLogCount=" + groupState.mPendingLogCount);
            if (!this.mEnabled) {
                AppCenterLog.debug("AppCenter", "Channel is temporarily disabled, log was saved to disk.");
            } else {
                checkPendingLogs(groupState);
            }
        } catch (Persistence.PersistenceException e2) {
            AppCenterLog.error("AppCenter", "Error persisting log", e2);
            Channel.GroupListener groupListener2 = groupState.mListener;
            if (groupListener2 != null) {
                groupListener2.onBeforeSending(log);
                groupState.mListener.onFailure(log, e2);
            }
        }
    }

    void checkPendingLogs(GroupState groupState) throws IllegalArgumentException {
        AppCenterLog.debug("AppCenter", String.format("checkPendingLogs(%s) pendingLogCount=%s batchTimeInterval=%s", groupState.mName, Integer.valueOf(groupState.mPendingLogCount), Long.valueOf(groupState.mBatchTimeInterval)));
        Long lResolveTriggerInterval = resolveTriggerInterval(groupState);
        if (lResolveTriggerInterval == null || groupState.mPaused) {
            return;
        }
        if (lResolveTriggerInterval.longValue() == 0) {
            triggerIngestion(groupState);
        } else {
            if (groupState.mScheduled) {
                return;
            }
            groupState.mScheduled = true;
            this.mAppCenterHandler.postDelayed(groupState.mRunnable, lResolveTriggerInterval.longValue());
        }
    }

    private Long resolveTriggerInterval(GroupState groupState) {
        if (groupState.mBatchTimeInterval > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            return resolveCustomTriggerInterval(groupState);
        }
        return resolveDefaultTriggerInterval(groupState);
    }

    private Long resolveCustomTriggerInterval(GroupState groupState) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = SharedPreferencesManager.getLong("startTimerPrefix." + groupState.mName);
        if (groupState.mPendingLogCount <= 0) {
            if (j + groupState.mBatchTimeInterval >= jCurrentTimeMillis) {
                return null;
            }
            SharedPreferencesManager.remove("startTimerPrefix." + groupState.mName);
            AppCenterLog.debug("AppCenter", "The timer for " + groupState.mName + " channel finished.");
            return null;
        }
        if (j == 0 || j > jCurrentTimeMillis) {
            SharedPreferencesManager.putLong("startTimerPrefix." + groupState.mName, jCurrentTimeMillis);
            AppCenterLog.debug("AppCenter", "The timer value for " + groupState.mName + " has been saved.");
            return Long.valueOf(groupState.mBatchTimeInterval);
        }
        return Long.valueOf(Math.max(groupState.mBatchTimeInterval - (jCurrentTimeMillis - j), 0L));
    }

    private Long resolveDefaultTriggerInterval(GroupState groupState) {
        int i = groupState.mPendingLogCount;
        if (i >= groupState.mMaxLogsPerBatch) {
            return 0L;
        }
        if (i > 0) {
            return Long.valueOf(groupState.mBatchTimeInterval);
        }
        return null;
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void addListener(Channel.Listener listener) {
        this.mListeners.add(listener);
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void removeListener(Channel.Listener listener) {
        this.mListeners.remove(listener);
    }

    @Override // com.microsoft.appcenter.channel.Channel
    public void shutdown() throws IOException {
        suspend(false, new CancellationException());
    }

    class GroupState {
        final long mBatchTimeInterval;
        final Ingestion mIngestion;
        final Channel.GroupListener mListener;
        final int mMaxLogsPerBatch;
        final int mMaxParallelBatches;
        final String mName;
        boolean mPaused;
        int mPendingLogCount;
        boolean mScheduled;
        final Map mSendingBatches = new HashMap();
        final Collection mPausedTargetKeys = new HashSet();
        final Runnable mRunnable = new Runnable() { // from class: com.microsoft.appcenter.channel.DefaultChannel.GroupState.1
            @Override // java.lang.Runnable
            public void run() throws IllegalArgumentException {
                GroupState groupState = GroupState.this;
                groupState.mScheduled = false;
                DefaultChannel.this.triggerIngestion(groupState);
            }
        };

        GroupState(String str, int i, long j, int i2, Ingestion ingestion, Channel.GroupListener groupListener) {
            this.mName = str;
            this.mMaxLogsPerBatch = i;
            this.mBatchTimeInterval = j;
            this.mMaxParallelBatches = i2;
            this.mIngestion = ingestion;
            this.mListener = groupListener;
        }
    }
}
