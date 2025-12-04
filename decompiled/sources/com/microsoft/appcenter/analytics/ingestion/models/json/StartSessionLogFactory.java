package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.StartSessionLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

/* loaded from: classes4.dex */
public class StartSessionLogFactory extends AbstractLogFactory {
    @Override // com.microsoft.appcenter.ingestion.models.json.LogFactory
    public StartSessionLog create() {
        return new StartSessionLog();
    }
}
