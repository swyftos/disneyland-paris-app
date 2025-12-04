package com.microsoft.appcenter.analytics.ingestion.models.one.json;

import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

/* loaded from: classes4.dex */
public class CommonSchemaEventLogFactory extends AbstractLogFactory {
    @Override // com.microsoft.appcenter.ingestion.models.json.LogFactory
    public CommonSchemaEventLog create() {
        return new CommonSchemaEventLog();
    }
}
