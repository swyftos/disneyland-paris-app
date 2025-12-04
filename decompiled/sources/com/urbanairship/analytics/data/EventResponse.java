package com.urbanairship.analytics.data;

import androidx.work.Data;
import com.disney.id.android.tracker.OneIDTracker;
import com.urbanairship.util.UAMathUtil;
import java.util.Map;

/* loaded from: classes4.dex */
class EventResponse {
    private final Map headers;

    public EventResponse(Map map) {
        this.headers = map;
    }

    int getMaxTotalSize() {
        String str = (String) this.headers.get("X-UA-Max-Total");
        return str != null ? UAMathUtil.constrain(Integer.parseInt(str) * 1024, Data.MAX_DATA_BYTES, 5242880) : Data.MAX_DATA_BYTES;
    }

    int getMaxBatchSize() {
        String str = (String) this.headers.get("X-UA-Max-Batch");
        return str != null ? UAMathUtil.constrain(Integer.parseInt(str) * 1024, Data.MAX_DATA_BYTES, 512000) : Data.MAX_DATA_BYTES;
    }

    int getMinBatchInterval() {
        String str = (String) this.headers.get("X-UA-Min-Batch-Interval");
        return str != null ? UAMathUtil.constrain(Integer.parseInt(str), OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC, 604800000) : OneIDTracker.CONTEXT_TIMEOUT_MILLI_SEC;
    }
}
