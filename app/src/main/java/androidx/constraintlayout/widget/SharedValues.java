package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues = new SparseIntArray();
    private HashMap mValuesListeners = new HashMap();

    public interface SharedValuesListener {
        void onNewValue(int i, int i2, int i3);
    }

    public void addListener(int i, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.mValuesListeners.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.mValuesListeners.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void removeListener(int i, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference> hashSet = (HashSet) this.mValuesListeners.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : hashSet) {
            SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        Iterator it = this.mValuesListeners.keySet().iterator();
        while (it.hasNext()) {
            removeListener(((Integer) it.next()).intValue(), sharedValuesListener);
        }
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public int getValue(int i) {
        return this.mValues.get(i, -1);
    }

    public void fireNewValue(int i, int i2) {
        int i3 = this.mValues.get(i, -1);
        if (i3 == i2) {
            return;
        }
        this.mValues.put(i, i2);
        HashSet<WeakReference> hashSet = (HashSet) this.mValuesListeners.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        Iterator it = hashSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            SharedValuesListener sharedValuesListener = (SharedValuesListener) ((WeakReference) it.next()).get();
            if (sharedValuesListener != null) {
                sharedValuesListener.onNewValue(i, i2, i3);
            } else {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (WeakReference weakReference : hashSet) {
                if (((SharedValuesListener) weakReference.get()) == null) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }
}
