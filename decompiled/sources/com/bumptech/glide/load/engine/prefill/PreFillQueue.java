package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class PreFillQueue {
    private final Map bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List keyList;

    public PreFillQueue(Map map) {
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            this.bitmapsRemaining += ((Integer) it.next()).intValue();
        }
    }

    public PreFillType remove() {
        PreFillType preFillType = (PreFillType) this.keyList.get(this.keyIndex);
        Integer num = (Integer) this.bitmapsPerType.get(preFillType);
        if (num.intValue() == 1) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        } else {
            this.bitmapsPerType.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.bitmapsRemaining--;
        this.keyIndex = this.keyList.isEmpty() ? 0 : (this.keyIndex + 1) % this.keyList.size();
        return preFillType;
    }

    public boolean isEmpty() {
        return this.bitmapsRemaining == 0;
    }
}
