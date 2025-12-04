package com.urbanairship.analytics.data;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import com.disney.id.android.tracker.OneIDTracker;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.analytics.AirshipEventData;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.analytics.data.EventEntity;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.Response;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.json.JsonException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class EventManager {

    @NonNull
    public static final String ACTION_SEND = "ACTION_SEND";
    private final ActivityMonitor activityMonitor;
    private final EventApiClient apiClient;
    private final EventDao eventDao;
    private final Object eventLock;
    private boolean isScheduled;
    private final JobDispatcher jobDispatcher;
    private final PreferenceDataStore preferenceDataStore;
    private final AirshipRuntimeConfig runtimeConfig;
    private final Object scheduleLock;

    public EventManager(@NonNull Context context, @NonNull PreferenceDataStore preferenceDataStore, @NonNull AirshipRuntimeConfig airshipRuntimeConfig) {
        this(preferenceDataStore, airshipRuntimeConfig, JobDispatcher.shared(context), GlobalActivityMonitor.shared(context), AnalyticsDatabase.createDatabase(context, airshipRuntimeConfig).getEventDao(), new EventApiClient(airshipRuntimeConfig));
    }

    EventManager(PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, JobDispatcher jobDispatcher, ActivityMonitor activityMonitor, EventDao eventDao, EventApiClient eventApiClient) {
        this.eventLock = new Object();
        this.scheduleLock = new Object();
        this.preferenceDataStore = preferenceDataStore;
        this.runtimeConfig = airshipRuntimeConfig;
        this.jobDispatcher = jobDispatcher;
        this.activityMonitor = activityMonitor;
        this.eventDao = eventDao;
        this.apiClient = eventApiClient;
    }

    public void scheduleEventUpload(long j, @NonNull TimeUnit timeUnit) {
        long millis = timeUnit.toMillis(j);
        UALog.v("Requesting to schedule event upload with delay %s ms.", Long.valueOf(millis));
        synchronized (this.scheduleLock) {
            try {
                int i = 0;
                if (this.isScheduled) {
                    long jMax = Math.max(System.currentTimeMillis() - this.preferenceDataStore.getLong("com.urbanairship.analytics.SCHEDULED_SEND_TIME", 0L), 0L);
                    if (jMax < millis) {
                        UALog.v("Event upload already scheduled for an earlier time.", new Object[0]);
                        i = 2;
                        millis = jMax;
                    }
                }
                UALog.v("Scheduling upload in %s ms.", Long.valueOf(millis));
                this.jobDispatcher.dispatch(JobInfo.newBuilder().setAction(ACTION_SEND).setNetworkAccessRequired(true).setAirshipComponent(Analytics.class).setMinDelay(millis, TimeUnit.MILLISECONDS).setConflictStrategy(i).build());
                this.preferenceDataStore.put("com.urbanairship.analytics.SCHEDULED_SEND_TIME", System.currentTimeMillis() + millis);
                this.isScheduled = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public void addEvent(@NonNull AirshipEventData airshipEventData, int i) {
        try {
            EventEntity eventEntityCreate = EventEntity.create(airshipEventData);
            synchronized (this.eventLock) {
                this.eventDao.insert(eventEntityCreate);
                this.eventDao.trimDatabase(this.preferenceDataStore.getInt("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", 5242880));
            }
            if (i == 1) {
                scheduleEventUpload(Math.max(getNextSendDelay(), 10000L), TimeUnit.MILLISECONDS);
                return;
            }
            if (i == 2) {
                scheduleEventUpload(0L, TimeUnit.MILLISECONDS);
            } else if (this.activityMonitor.getIsAppForegrounded()) {
                scheduleEventUpload(Math.max(getNextSendDelay(), 30000L), TimeUnit.MILLISECONDS);
            } else {
                scheduleEventUpload(Math.max(Math.max(this.runtimeConfig.getConfigOptions().backgroundReportingIntervalMS - (System.currentTimeMillis() - this.preferenceDataStore.getLong("com.urbanairship.analytics.LAST_SEND", 0L)), getNextSendDelay()), 30000L), TimeUnit.MILLISECONDS);
            }
        } catch (JsonException e) {
            UALog.e(e, "Analytics - Invalid event: %s", airshipEventData);
        }
    }

    @WorkerThread
    public void deleteEvents() {
        synchronized (this.eventLock) {
            this.eventDao.deleteAll();
        }
    }

    private long getNextSendDelay() {
        return Math.max((this.preferenceDataStore.getLong("com.urbanairship.analytics.LAST_SEND", 0L) + this.preferenceDataStore.getInt("com.urbanairship.analytics.MIN_BATCH_INTERVAL", OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC)) - System.currentTimeMillis(), 0L);
    }

    @WorkerThread
    public boolean uploadEvents(@NonNull String str, @NonNull Map<String, String> map) {
        synchronized (this.scheduleLock) {
            this.isScheduled = false;
            this.preferenceDataStore.put("com.urbanairship.analytics.LAST_SEND", System.currentTimeMillis());
        }
        try {
            synchronized (this.eventLock) {
                try {
                    int iCount = this.eventDao.count();
                    if (iCount <= 0) {
                        UALog.d("No events to send.", new Object[0]);
                        return true;
                    }
                    List<EventEntity.EventIdAndData> batch = this.eventDao.getBatch(Math.min(500, this.preferenceDataStore.getInt("com.urbanairship.analytics.MAX_BATCH_SIZE", 512000) / Math.max(1, this.eventDao.databaseSize() / iCount)));
                    if (batch.isEmpty()) {
                        UALog.v("No analytics events to send.", new Object[0]);
                        return false;
                    }
                    ArrayList arrayList = new ArrayList(batch.size());
                    Iterator<EventEntity.EventIdAndData> it = batch.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().data);
                    }
                    try {
                        Response responseSendEvents = this.apiClient.sendEvents(str, arrayList, map);
                        if (!responseSendEvents.isSuccessful()) {
                            UALog.d("Analytic upload failed.", new Object[0]);
                            return false;
                        }
                        UALog.d("Analytic events uploaded.", new Object[0]);
                        synchronized (this.eventLock) {
                            this.eventDao.deleteBatch(batch);
                        }
                        this.preferenceDataStore.put("com.urbanairship.analytics.MAX_TOTAL_DB_SIZE", ((EventResponse) responseSendEvents.getResult()).getMaxTotalSize());
                        this.preferenceDataStore.put("com.urbanairship.analytics.MAX_BATCH_SIZE", ((EventResponse) responseSendEvents.getResult()).getMaxBatchSize());
                        this.preferenceDataStore.put("com.urbanairship.analytics.MIN_BATCH_INTERVAL", ((EventResponse) responseSendEvents.getResult()).getMinBatchInterval());
                        if (iCount - batch.size() > 0) {
                            scheduleEventUpload(1000L, TimeUnit.MILLISECONDS);
                        }
                        return true;
                    } catch (RequestException e) {
                        UALog.e(e, "EventManager - Failed to upload events", new Object[0]);
                        return false;
                    }
                } finally {
                }
            }
        } catch (SQLiteException e2) {
            UALog.e(e2, "EventManager - Failed to query batched events", new Object[0]);
            return false;
        }
    }
}
