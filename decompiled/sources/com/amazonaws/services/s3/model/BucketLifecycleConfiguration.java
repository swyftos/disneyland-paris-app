package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class BucketLifecycleConfiguration implements Serializable {
    public static final String DISABLED = "Disabled";
    public static final String ENABLED = "Enabled";
    private List rules;

    public List<Rule> getRules() {
        return this.rules;
    }

    public void setRules(List<Rule> list) {
        this.rules = list;
    }

    public BucketLifecycleConfiguration withRules(List<Rule> list) {
        setRules(list);
        return this;
    }

    public BucketLifecycleConfiguration withRules(Rule... ruleArr) {
        setRules(Arrays.asList(ruleArr));
        return this;
    }

    public BucketLifecycleConfiguration(List<Rule> list) {
        this.rules = list;
    }

    public BucketLifecycleConfiguration() {
    }

    public static class Rule implements Serializable {
        private AbortIncompleteMultipartUpload abortIncompleteMultipartUpload;
        private Date expirationDate;
        private LifecycleFilter filter;
        private String id;
        private List noncurrentVersionTransitions;
        private String prefix;
        private String status;
        private List transitions;
        private int expirationInDays = -1;
        private boolean expiredObjectDeleteMarker = false;
        private int noncurrentVersionExpirationInDays = -1;

        public void setId(String str) {
            this.id = str;
        }

        @Deprecated
        public void setPrefix(String str) {
            this.prefix = str;
        }

        public void setExpirationInDays(int i) {
            this.expirationInDays = i;
        }

        public void setNoncurrentVersionExpirationInDays(int i) {
            this.noncurrentVersionExpirationInDays = i;
        }

        public String getId() {
            return this.id;
        }

        public Rule withId(String str) {
            this.id = str;
            return this;
        }

        @Deprecated
        public String getPrefix() {
            return this.prefix;
        }

        @Deprecated
        public Rule withPrefix(String str) {
            this.prefix = str;
            return this;
        }

        public int getExpirationInDays() {
            return this.expirationInDays;
        }

        public Rule withExpirationInDays(int i) {
            this.expirationInDays = i;
            return this;
        }

        public int getNoncurrentVersionExpirationInDays() {
            return this.noncurrentVersionExpirationInDays;
        }

        public Rule withNoncurrentVersionExpirationInDays(int i) {
            setNoncurrentVersionExpirationInDays(i);
            return this;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public Rule withStatus(String str) {
            setStatus(str);
            return this;
        }

        public void setExpirationDate(Date date) {
            this.expirationDate = date;
        }

        public Date getExpirationDate() {
            return this.expirationDate;
        }

        public Rule withExpirationDate(Date date) {
            this.expirationDate = date;
            return this;
        }

        @Deprecated
        public void setTransition(Transition transition) {
            setTransitions(Arrays.asList(transition));
        }

        @Deprecated
        public Transition getTransition() {
            List<Transition> transitions = getTransitions();
            if (transitions == null || transitions.isEmpty()) {
                return null;
            }
            return transitions.get(transitions.size() - 1);
        }

        @Deprecated
        public Rule withTransition(Transition transition) {
            setTransitions(Arrays.asList(transition));
            return this;
        }

        @Deprecated
        public void setNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
            setNoncurrentVersionTransitions(Arrays.asList(noncurrentVersionTransition));
        }

        @Deprecated
        public NoncurrentVersionTransition getNoncurrentVersionTransition() {
            List<NoncurrentVersionTransition> noncurrentVersionTransitions = getNoncurrentVersionTransitions();
            if (noncurrentVersionTransitions == null || noncurrentVersionTransitions.isEmpty()) {
                return null;
            }
            return noncurrentVersionTransitions.get(noncurrentVersionTransitions.size() - 1);
        }

        @Deprecated
        public Rule withNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
            setNoncurrentVersionTransitions(Arrays.asList(noncurrentVersionTransition));
            return this;
        }

        public List<Transition> getTransitions() {
            return this.transitions;
        }

        public void setTransitions(List<Transition> list) {
            if (list != null) {
                this.transitions = new ArrayList(list);
            }
        }

        public Rule withTransitions(List<Transition> list) {
            setTransitions(list);
            return this;
        }

        public Rule addTransition(Transition transition) {
            if (transition == null) {
                throw new IllegalArgumentException("Transition cannot be null.");
            }
            if (this.transitions == null) {
                this.transitions = new ArrayList();
            }
            this.transitions.add(transition);
            return this;
        }

        public List<NoncurrentVersionTransition> getNoncurrentVersionTransitions() {
            return this.noncurrentVersionTransitions;
        }

        public void setNoncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
            this.noncurrentVersionTransitions = new ArrayList(list);
        }

        public Rule withNoncurrentVersionTransitions(List<NoncurrentVersionTransition> list) {
            setNoncurrentVersionTransitions(list);
            return this;
        }

        public Rule addNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
            if (noncurrentVersionTransition == null) {
                throw new IllegalArgumentException("NoncurrentVersionTransition cannot be null.");
            }
            if (this.noncurrentVersionTransitions == null) {
                this.noncurrentVersionTransitions = new ArrayList();
            }
            this.noncurrentVersionTransitions.add(noncurrentVersionTransition);
            return this;
        }

        public AbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
            return this.abortIncompleteMultipartUpload;
        }

        public void setAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload) {
            this.abortIncompleteMultipartUpload = abortIncompleteMultipartUpload;
        }

        public Rule withAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload) {
            setAbortIncompleteMultipartUpload(abortIncompleteMultipartUpload);
            return this;
        }

        public boolean isExpiredObjectDeleteMarker() {
            return this.expiredObjectDeleteMarker;
        }

        public void setExpiredObjectDeleteMarker(boolean z) {
            this.expiredObjectDeleteMarker = z;
        }

        public Rule withExpiredObjectDeleteMarker(boolean z) {
            this.expiredObjectDeleteMarker = z;
            return this;
        }

        public LifecycleFilter getFilter() {
            return this.filter;
        }

        public void setFilter(LifecycleFilter lifecycleFilter) {
            this.filter = lifecycleFilter;
        }

        public Rule withFilter(LifecycleFilter lifecycleFilter) {
            setFilter(lifecycleFilter);
            return this;
        }
    }

    public static class Transition implements Serializable {
        private Date date;
        private int days = -1;
        private String storageClass;

        public void setDays(int i) {
            this.days = i;
        }

        public int getDays() {
            return this.days;
        }

        public Transition withDays(int i) {
            this.days = i;
            return this;
        }

        public void setStorageClass(StorageClass storageClass) {
            if (storageClass == null) {
                setStorageClass((String) null);
            } else {
                setStorageClass(storageClass.toString());
            }
        }

        public void setStorageClass(String str) {
            this.storageClass = str;
        }

        @Deprecated
        public StorageClass getStorageClass() {
            try {
                return StorageClass.fromValue(this.storageClass);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public String getStorageClassAsString() {
            return this.storageClass;
        }

        public Transition withStorageClass(StorageClass storageClass) {
            setStorageClass(storageClass);
            return this;
        }

        public Transition withStorageClass(String str) {
            setStorageClass(str);
            return this;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getDate() {
            return this.date;
        }

        public Transition withDate(Date date) {
            this.date = date;
            return this;
        }
    }

    public static class NoncurrentVersionTransition implements Serializable {
        private int days = -1;
        private String storageClass;

        public void setDays(int i) {
            this.days = i;
        }

        public int getDays() {
            return this.days;
        }

        public NoncurrentVersionTransition withDays(int i) {
            this.days = i;
            return this;
        }

        public void setStorageClass(StorageClass storageClass) {
            if (storageClass == null) {
                setStorageClass((String) null);
            } else {
                setStorageClass(storageClass.toString());
            }
        }

        public void setStorageClass(String str) {
            this.storageClass = str;
        }

        @Deprecated
        public StorageClass getStorageClass() {
            try {
                return StorageClass.fromValue(this.storageClass);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public String getStorageClassAsString() {
            return this.storageClass;
        }

        public NoncurrentVersionTransition withStorageClass(StorageClass storageClass) {
            setStorageClass(storageClass);
            return this;
        }

        public NoncurrentVersionTransition withStorageClass(String str) {
            setStorageClass(str);
            return this;
        }
    }
}
