package com.amazonaws.services.s3.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes2.dex */
public class BucketNotificationConfiguration implements Serializable {
    private Map configurations;

    public BucketNotificationConfiguration() {
        this.configurations = null;
        this.configurations = new HashMap();
    }

    public BucketNotificationConfiguration(String str, NotificationConfiguration notificationConfiguration) {
        this.configurations = null;
        this.configurations = new HashMap();
        addConfiguration(str, notificationConfiguration);
    }

    public BucketNotificationConfiguration withNotificationConfiguration(Map<String, NotificationConfiguration> map) {
        this.configurations.clear();
        this.configurations.putAll(map);
        return this;
    }

    public BucketNotificationConfiguration addConfiguration(String str, NotificationConfiguration notificationConfiguration) {
        this.configurations.put(str, notificationConfiguration);
        return this;
    }

    public Map<String, NotificationConfiguration> getConfigurations() {
        return this.configurations;
    }

    public void setConfigurations(Map<String, NotificationConfiguration> map) {
        this.configurations = map;
    }

    public NotificationConfiguration getConfigurationByName(String str) {
        return (NotificationConfiguration) this.configurations.get(str);
    }

    public NotificationConfiguration removeConfiguration(String str) {
        return (NotificationConfiguration) this.configurations.remove(str);
    }

    @Deprecated
    public BucketNotificationConfiguration(Collection<TopicConfiguration> collection) {
        this.configurations = null;
        this.configurations = new HashMap();
        if (collection != null) {
            Iterator<TopicConfiguration> it = collection.iterator();
            while (it.hasNext()) {
                addConfiguration(UUID.randomUUID().toString(), it.next());
            }
        }
    }

    @Deprecated
    public BucketNotificationConfiguration withTopicConfigurations(TopicConfiguration... topicConfigurationArr) {
        setTopicConfigurations(Arrays.asList(topicConfigurationArr));
        return this;
    }

    @Deprecated
    public void setTopicConfigurations(Collection<TopicConfiguration> collection) {
        this.configurations.clear();
        if (collection != null) {
            Iterator<TopicConfiguration> it = collection.iterator();
            while (it.hasNext()) {
                addConfiguration(UUID.randomUUID().toString(), it.next());
            }
        }
    }

    @Deprecated
    public List<TopicConfiguration> getTopicConfigurations() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.configurations.entrySet()) {
            if (entry.getValue() instanceof TopicConfiguration) {
                arrayList.add((TopicConfiguration) entry.getValue());
            }
        }
        return arrayList;
    }

    public String toString() {
        return new Gson().toJson(getConfigurations());
    }

    @Deprecated
    public static class TopicConfiguration extends com.amazonaws.services.s3.model.TopicConfiguration {
        public TopicConfiguration(String str, String str2) {
            super(str, str2);
        }

        public String getTopic() {
            return getTopicARN();
        }

        @Deprecated
        public String getEvent() {
            Set<String> events = getEvents();
            return ((String[]) events.toArray(new String[events.size()]))[0];
        }

        public String toString() {
            return new Gson().toJson(this);
        }
    }
}
