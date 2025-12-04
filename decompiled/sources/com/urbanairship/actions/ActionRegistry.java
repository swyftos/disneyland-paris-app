package com.urbanairship.actions;

import android.content.Context;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import com.urbanairship.R;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class ActionRegistry {
    private final Map actionMap = new HashMap();

    public interface Predicate {
        boolean apply(@NonNull ActionArguments actionArguments);
    }

    @NonNull
    public Entry registerAction(@NonNull Action action, @NonNull String... strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Unable to register an action without a name.");
        }
        return registerEntry(new Entry(action, new ArrayList(Arrays.asList(strArr))));
    }

    @NonNull
    public Entry registerAction(@NonNull Class<? extends Action> cls, @NonNull String... strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Unable to register an action without a name.");
        }
        return registerEntry(new Entry(cls, new ArrayList(Arrays.asList(strArr))));
    }

    private Entry registerEntry(Entry entry) {
        List<String> names = entry.getNames();
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            if (UAStringUtil.isEmpty(it.next())) {
                throw new IllegalArgumentException("Unable to register action because one or more of the names was null or empty.");
            }
        }
        synchronized (this.actionMap) {
            try {
                for (String str : names) {
                    if (!UAStringUtil.isEmpty(str)) {
                        Entry entry2 = (Entry) this.actionMap.remove(str);
                        if (entry2 != null) {
                            entry2.removeName(str);
                        }
                        this.actionMap.put(str, entry);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return entry;
    }

    @Nullable
    public Entry getEntry(@NonNull String str) {
        Entry entry;
        if (UAStringUtil.isEmpty(str)) {
            return null;
        }
        synchronized (this.actionMap) {
            entry = (Entry) this.actionMap.get(str);
        }
        return entry;
    }

    @NonNull
    public Set<Entry> getEntries() {
        HashSet hashSet;
        synchronized (this.actionMap) {
            hashSet = new HashSet(this.actionMap.values());
        }
        return hashSet;
    }

    public void unregisterAction(@NonNull String str) {
        if (UAStringUtil.isEmpty(str)) {
            return;
        }
        synchronized (this.actionMap) {
            try {
                Entry entry = getEntry(str);
                if (entry == null) {
                    return;
                }
                Iterator<String> it = entry.getNames().iterator();
                while (it.hasNext()) {
                    this.actionMap.remove(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void registerDefaultActions(@NonNull Context context) {
        registerActions(context, R.xml.ua_default_actions);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void registerActions(@NonNull Context context, @XmlRes int i) {
        Iterator it = ActionEntryParser.fromXml(context, i).iterator();
        while (it.hasNext()) {
            registerEntry((Entry) it.next());
        }
    }

    public static final class Entry {
        private Action defaultAction;
        private Class defaultActionClass;
        private final List names;
        private Predicate predicate;
        private final SparseArray situationOverrides = new SparseArray();

        Entry(Action action, List list) {
            this.defaultAction = action;
            this.names = list;
        }

        Entry(Class cls, List list) {
            this.defaultActionClass = cls;
            this.names = list;
        }

        @NonNull
        public Action getActionForSituation(int i) {
            Action action = (Action) this.situationOverrides.get(i);
            return action != null ? action : getDefaultAction();
        }

        @Nullable
        public Predicate getPredicate() {
            return this.predicate;
        }

        public void setPredicate(@Nullable Predicate predicate) {
            this.predicate = predicate;
        }

        @NonNull
        public Action getDefaultAction() {
            if (this.defaultAction == null) {
                try {
                    this.defaultAction = (Action) this.defaultActionClass.newInstance();
                } catch (Exception unused) {
                    throw new IllegalArgumentException("Unable to instantiate action class.");
                }
            }
            return this.defaultAction;
        }

        public void setDefaultAction(@NonNull Action action) {
            this.defaultAction = action;
        }

        public void setSituationOverride(int i, @Nullable Action action) {
            if (action == null) {
                this.situationOverrides.remove(i);
            } else {
                this.situationOverrides.put(i, action);
            }
        }

        @NonNull
        public List<String> getNames() {
            ArrayList arrayList;
            synchronized (this.names) {
                arrayList = new ArrayList(this.names);
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeName(String str) {
            synchronized (this.names) {
                this.names.remove(str);
            }
        }

        @NonNull
        public String toString() {
            return "Action Entry: " + this.names;
        }
    }
}
