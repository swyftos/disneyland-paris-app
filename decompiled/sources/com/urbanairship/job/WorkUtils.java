package com.urbanairship.job;

import androidx.work.Data;
import com.urbanairship.job.JobInfo;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
abstract class WorkUtils {
    static Data convertToData(JobInfo jobInfo) {
        return new Data.Builder().putString("action", jobInfo.getAction()).putString("extras", jobInfo.getExtras().toString()).putString("component", jobInfo.getAirshipComponentName()).putBoolean("network_required", jobInfo.isNetworkAccessRequired()).putLong("min_delay", jobInfo.getMinDelayMs()).putLong("initial_backoff", jobInfo.getInitialBackOffMs()).putInt("conflict_strategy", jobInfo.getConflictStrategy()).putString("rate_limit_ids", JsonValue.wrapOpt(jobInfo.getRateLimitIds()).toString()).build();
    }

    static JobInfo convertToJobInfo(Data data) {
        JobInfo.Builder extras = JobInfo.newBuilder().setAction(data.getString("action")).setExtras(JsonValue.parseString(data.getString("extras")).optMap());
        long j = data.getLong("min_delay", 0L);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        JobInfo.Builder conflictStrategy = extras.setMinDelay(j, timeUnit).setInitialBackOff(data.getLong("initial_backoff", 0L), timeUnit).setNetworkAccessRequired(data.getBoolean("network_required", false)).setAirshipComponent(data.getString("component")).setConflictStrategy(data.getInt("conflict_strategy", 0));
        Iterator<JsonValue> it = JsonValue.parseString(data.getString("rate_limit_ids")).optList().iterator();
        while (it.hasNext()) {
            conflictStrategy.addRateLimit(it.next().requireString());
        }
        return conflictStrategy.build();
    }
}
