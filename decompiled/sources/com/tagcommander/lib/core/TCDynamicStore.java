package com.tagcommander.lib.core;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TCDynamicStore implements ITCDynamicStore, Serializable {
    public final ConcurrentHashMap<String, String> dynamicStore = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, JSONObject> jsonStore = new ConcurrentHashMap<>();
    public final List<String> orderedKeys = new ArrayList();
    public final List<String> orderedJsonKeys = new ArrayList();

    public void clearData() {
        synchronized (this.orderedKeys) {
            this.orderedKeys.clear();
        }
        this.dynamicStore.clear();
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public void addData(@NonNull TCDynamicStore tCDynamicStore) {
        synchronized (tCDynamicStore.orderedKeys) {
            try {
                int size = tCDynamicStore.orderedKeys.size();
                for (int i = 0; i < size; i++) {
                    String str = tCDynamicStore.orderedKeys.get(i);
                    addData(str, tCDynamicStore.getData(str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public void addData(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.orderedKeys) {
            try {
                if (!this.orderedKeys.contains(str)) {
                    this.orderedKeys.add(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.dynamicStore.put(str, str2);
    }

    public void addJsonData(@NonNull String str, @NonNull JSONObject jSONObject) {
        synchronized (this.orderedJsonKeys) {
            try {
                if (!this.orderedJsonKeys.contains(str)) {
                    this.orderedJsonKeys.add(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.jsonStore.put(str, jSONObject);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public String getData(@NonNull String str) {
        return this.dynamicStore.get(str);
    }

    public JSONObject getJsonData(@NonNull String str) {
        return this.jsonStore.get(str);
    }

    @Override // com.tagcommander.lib.core.ITCDynamicStore
    public String removeData(@NonNull String str) {
        synchronized (this.orderedKeys) {
            this.orderedKeys.remove(str);
        }
        return this.dynamicStore.remove(str);
    }

    public void removeJsonData(@NonNull String str) {
        synchronized (this.orderedJsonKeys) {
            try {
                if (this.orderedJsonKeys.contains(str)) {
                    this.orderedJsonKeys.remove(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.jsonStore.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Vars:\n");
        synchronized (this.orderedKeys) {
            for (int i = 0; i < this.orderedKeys.size(); i++) {
                try {
                    String str = this.orderedKeys.get(i);
                    sb.append("(");
                    sb.append(str);
                    sb.append(": ");
                    sb.append(getData(str));
                    sb.append(")");
                    sb.append("\n");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sb.toString();
    }
}
