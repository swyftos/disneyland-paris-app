package com.microsoft.appcenter.analytics.channel;

import com.microsoft.appcenter.ingestion.models.Log;

/* loaded from: classes4.dex */
public interface AnalyticsListener {
    void onBeforeSending(Log log);

    void onSendingFailed(Log log, Exception exc);

    void onSendingSucceeded(Log log);
}
