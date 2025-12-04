package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class TimingInfoFullSupport extends TimingInfo {
    private final Map countersByName;
    private final Map subMeasurementsByName;

    TimingInfoFullSupport(Long l, long j, Long l2) {
        super(l, j, l2);
        this.subMeasurementsByName = new HashMap();
        this.countersByName = new HashMap();
    }

    @Override // com.amazonaws.util.TimingInfo
    public void addSubMeasurement(String str, TimingInfo timingInfo) {
        List arrayList = (List) this.subMeasurementsByName.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.subMeasurementsByName.put(str, arrayList);
        }
        if (timingInfo.isEndTimeKnown()) {
            arrayList.add(timingInfo);
            return;
        }
        LogFactory.getLog(getClass()).debug("Skip submeasurement timing info with no end time for " + str);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo getSubMeasurement(String str) {
        return getSubMeasurement(str, 0);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo getSubMeasurement(String str, int i) {
        List list = (List) this.subMeasurementsByName.get(str);
        if (i < 0 || list == null || list.size() == 0 || i >= list.size()) {
            return null;
        }
        return (TimingInfo) list.get(i);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo getLastSubMeasurement(String str) {
        List list;
        Map map = this.subMeasurementsByName;
        if (map == null || map.size() == 0 || (list = (List) this.subMeasurementsByName.get(str)) == null || list.size() == 0) {
            return null;
        }
        return (TimingInfo) list.get(list.size() - 1);
    }

    @Override // com.amazonaws.util.TimingInfo
    public List getAllSubMeasurements(String str) {
        return (List) this.subMeasurementsByName.get(str);
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map getSubMeasurementsByName() {
        return this.subMeasurementsByName;
    }

    @Override // com.amazonaws.util.TimingInfo
    public Number getCounter(String str) {
        return (Number) this.countersByName.get(str);
    }

    @Override // com.amazonaws.util.TimingInfo
    public Map getAllCounters() {
        return this.countersByName;
    }

    @Override // com.amazonaws.util.TimingInfo
    public void setCounter(String str, long j) {
        this.countersByName.put(str, Long.valueOf(j));
    }

    @Override // com.amazonaws.util.TimingInfo
    public void incrementCounter(String str) {
        setCounter(str, (getCounter(str) != null ? r0.intValue() : 0) + 1);
    }
}
