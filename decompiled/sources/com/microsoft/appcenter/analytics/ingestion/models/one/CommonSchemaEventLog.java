package com.microsoft.appcenter.analytics.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;

/* loaded from: classes4.dex */
public class CommonSchemaEventLog extends CommonSchemaLog {
    public static final String TYPE = "commonSchemaEvent";

    @Override // com.microsoft.appcenter.ingestion.models.Log
    public String getType() {
        return TYPE;
    }
}
