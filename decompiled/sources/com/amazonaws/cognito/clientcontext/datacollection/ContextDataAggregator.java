package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ContextDataAggregator {
    private final List dataCollectors;

    private static class InstanceHolder {
        private static final ContextDataAggregator INSTANCE = new ContextDataAggregator();
    }

    private ContextDataAggregator() {
        this.dataCollectors = getDataCollectors();
    }

    protected ContextDataAggregator(List<DataCollector> list) {
        this.dataCollectors = list;
    }

    public static ContextDataAggregator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public Map<String, String> getAggregatedData(Context context) {
        HashMap map = new HashMap();
        Iterator it = this.dataCollectors.iterator();
        while (it.hasNext()) {
            map.putAll(((DataCollector) it.next()).collect(context));
        }
        removerNullEntries(map);
        return map;
    }

    private void removerNullEntries(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() == null) {
                map.remove(entry.getKey());
            }
        }
    }

    private List getDataCollectors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ApplicationDataCollector());
        arrayList.add(new BuildDataCollector());
        arrayList.add(new DeviceDataCollector());
        arrayList.add(new TelephonyDataCollector());
        return arrayList;
    }
}
