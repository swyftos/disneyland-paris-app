package com.microsoft.appcenter.analytics.ingestion.models.json;

import com.microsoft.appcenter.analytics.ingestion.models.EventLog;
import com.microsoft.appcenter.analytics.ingestion.models.one.CommonSchemaEventLog;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaDataUtils;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.PartAUtils;
import java.util.Collection;
import java.util.LinkedList;
import org.json.JSONException;

/* loaded from: classes4.dex */
public class EventLogFactory extends AbstractLogFactory {
    @Override // com.microsoft.appcenter.ingestion.models.json.LogFactory
    public EventLog create() {
        return new EventLog();
    }

    @Override // com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory, com.microsoft.appcenter.ingestion.models.json.LogFactory
    public Collection<CommonSchemaLog> toCommonSchemaLogs(Log log) throws JSONException, IllegalArgumentException {
        LinkedList linkedList = new LinkedList();
        for (String str : log.getTransmissionTargetTokens()) {
            CommonSchemaEventLog commonSchemaEventLog = new CommonSchemaEventLog();
            EventLog eventLog = (EventLog) log;
            PartAUtils.setName(commonSchemaEventLog, eventLog.getName());
            PartAUtils.addPartAFromLog(log, commonSchemaEventLog, str);
            CommonSchemaDataUtils.addCommonSchemaData(eventLog.getTypedProperties(), commonSchemaEventLog);
            linkedList.add(commonSchemaEventLog);
            commonSchemaEventLog.setTag(log.getTag());
        }
        return linkedList;
    }
}
