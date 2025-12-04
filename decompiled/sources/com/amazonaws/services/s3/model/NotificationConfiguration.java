package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class NotificationConfiguration {
    private Filter filter;
    private Set events = new HashSet();
    private List objectPrefixes = new ArrayList();

    protected NotificationConfiguration() {
    }

    protected NotificationConfiguration(EnumSet<S3Event> enumSet) {
        if (enumSet != null) {
            Iterator<S3Event> it = enumSet.iterator();
            while (it.hasNext()) {
                this.events.add(it.next().toString());
            }
        }
    }

    protected NotificationConfiguration(String... strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                this.events.add(str);
            }
        }
    }

    public Set<String> getEvents() {
        return this.events;
    }

    public void setEvents(Set<String> set) {
        this.events = set;
    }

    @Deprecated
    public List<String> getObjectPrefixes() {
        return this.objectPrefixes;
    }

    @Deprecated
    public void setObjectPrefixes(List<String> list) {
        this.objectPrefixes = list;
    }

    public NotificationConfiguration withEvents(Set<String> set) {
        this.events.clear();
        this.events.addAll(set);
        return this;
    }

    @Deprecated
    public NotificationConfiguration withObjectPrefixes(String... strArr) {
        this.objectPrefixes.clear();
        if (strArr != null && strArr.length > 0) {
            this.objectPrefixes.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public void addEvent(String str) {
        this.events.add(str);
    }

    public void addEvent(S3Event s3Event) {
        this.events.add(s3Event.toString());
    }

    @Deprecated
    public void addObjectPrefix(String str) {
        this.objectPrefixes.add(str);
    }

    public Filter getFilter() {
        return this.filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public NotificationConfiguration withFilter(Filter filter) {
        setFilter(filter);
        return this;
    }
}
