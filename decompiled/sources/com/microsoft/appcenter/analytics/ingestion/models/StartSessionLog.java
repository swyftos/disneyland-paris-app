package com.microsoft.appcenter.analytics.ingestion.models;

import com.microsoft.appcenter.ingestion.models.AbstractLog;

/* loaded from: classes4.dex */
public class StartSessionLog extends AbstractLog {
    public static final String TYPE = "startSession";

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public String getType() {
        return TYPE;
    }
}
