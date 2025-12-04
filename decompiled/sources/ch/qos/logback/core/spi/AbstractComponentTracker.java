package ch.qos.logback.core.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class AbstractComponentTracker<C> implements ComponentTracker<C> {
    public static final long LINGERING_TIMEOUT = 10000;
    public static final long WAIT_BETWEEN_SUCCESSIVE_REMOVAL_ITERATIONS = 1000;
    protected int maxComponents = Integer.MAX_VALUE;
    protected long timeout = ComponentTracker.DEFAULT_TIMEOUT;
    LinkedHashMap liveMap = new LinkedHashMap(32, 0.75f, true);
    LinkedHashMap lingerersMap = new LinkedHashMap(16, 0.75f, true);
    long lastCheck = 0;
    private RemovalPredicator byExcedent = new RemovalPredicator() { // from class: ch.qos.logback.core.spi.AbstractComponentTracker.1
        @Override // ch.qos.logback.core.spi.AbstractComponentTracker.RemovalPredicator
        public boolean isSlatedForRemoval(Entry entry, long j) {
            return AbstractComponentTracker.this.liveMap.size() > AbstractComponentTracker.this.maxComponents;
        }
    };
    private RemovalPredicator byTimeout = new RemovalPredicator() { // from class: ch.qos.logback.core.spi.AbstractComponentTracker.2
        @Override // ch.qos.logback.core.spi.AbstractComponentTracker.RemovalPredicator
        public boolean isSlatedForRemoval(Entry entry, long j) {
            return AbstractComponentTracker.this.isEntryStale(entry, j);
        }
    };
    private RemovalPredicator byLingering = new RemovalPredicator() { // from class: ch.qos.logback.core.spi.AbstractComponentTracker.3
        @Override // ch.qos.logback.core.spi.AbstractComponentTracker.RemovalPredicator
        public boolean isSlatedForRemoval(Entry entry, long j) {
            return AbstractComponentTracker.this.isEntryDoneLingering(entry, j);
        }
    };

    private static class Entry {
        Object component;
        String key;
        long timestamp;

        Entry(String str, Object obj, long j) {
            this.key = str;
            this.component = obj;
            this.timestamp = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            String str = this.key;
            if (str == null) {
                if (entry.key != null) {
                    return false;
                }
            } else if (!str.equals(entry.key)) {
                return false;
            }
            Object obj2 = this.component;
            if (obj2 == null) {
                if (entry.component != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.component)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.key.hashCode();
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public String toString() {
            return "(" + this.key + ", " + this.component + ")";
        }
    }

    private interface RemovalPredicator {
        boolean isSlatedForRemoval(Entry entry, long j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void genericStaleComponentRemover(LinkedHashMap linkedHashMap, long j, RemovalPredicator removalPredicator) {
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) ((Map.Entry) it.next()).getValue();
            if (!removalPredicator.isSlatedForRemoval(entry, j)) {
                return;
            }
            it.remove();
            processPriorToRemoval(entry.component);
        }
    }

    private Entry getFromEitherMap(String str) {
        Entry entry = (Entry) this.liveMap.get(str);
        return entry != null ? entry : (Entry) this.lingerersMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEntryDoneLingering(Entry entry, long j) {
        return entry.timestamp + 10000 < j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean isEntryStale(Entry entry, long j) {
        return isComponentStale(entry.component) || entry.timestamp + this.timeout < j;
    }

    private boolean isTooSoonForRemovalIteration(long j) {
        if (this.lastCheck + 1000 > j) {
            return true;
        }
        this.lastCheck = j;
        return false;
    }

    private void removeExcedentComponents() {
        genericStaleComponentRemover(this.liveMap, 0L, this.byExcedent);
    }

    private void removeStaleComponentsFromLingerersMap(long j) {
        genericStaleComponentRemover(this.lingerersMap, j, this.byLingering);
    }

    private void removeStaleComponentsFromMainMap(long j) {
        genericStaleComponentRemover(this.liveMap, j, this.byTimeout);
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public Collection<C> allComponents() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.liveMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(((Entry) it.next()).component);
        }
        Iterator it2 = this.lingerersMap.values().iterator();
        while (it2.hasNext()) {
            arrayList.add(((Entry) it2.next()).component);
        }
        return arrayList;
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public Set<String> allKeys() {
        HashSet hashSet = new HashSet(this.liveMap.keySet());
        hashSet.addAll(this.lingerersMap.keySet());
        return hashSet;
    }

    protected abstract C buildComponent(String str);

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public void endOfLife(String str) {
        Entry entry = (Entry) this.liveMap.remove(str);
        if (entry == null) {
            return;
        }
        this.lingerersMap.put(str, entry);
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public synchronized C find(String str) {
        Entry fromEitherMap = getFromEitherMap(str);
        if (fromEitherMap == null) {
            return null;
        }
        return (C) fromEitherMap.component;
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public int getComponentCount() {
        return this.liveMap.size() + this.lingerersMap.size();
    }

    public int getMaxComponents() {
        return this.maxComponents;
    }

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public synchronized C getOrCreate(String str, long j) {
        Entry fromEitherMap;
        try {
            fromEitherMap = getFromEitherMap(str);
            if (fromEitherMap == null) {
                Entry entry = new Entry(str, buildComponent(str), j);
                this.liveMap.put(str, entry);
                fromEitherMap = entry;
            } else {
                fromEitherMap.setTimestamp(j);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (C) fromEitherMap.component;
    }

    public long getTimeout() {
        return this.timeout;
    }

    protected abstract boolean isComponentStale(C c);

    protected abstract void processPriorToRemoval(C c);

    @Override // ch.qos.logback.core.spi.ComponentTracker
    public synchronized void removeStaleComponents(long j) {
        if (isTooSoonForRemovalIteration(j)) {
            return;
        }
        removeExcedentComponents();
        removeStaleComponentsFromMainMap(j);
        removeStaleComponentsFromLingerersMap(j);
    }

    public void setMaxComponents(int i) {
        this.maxComponents = i;
    }

    public void setTimeout(long j) {
        this.timeout = j;
    }
}
