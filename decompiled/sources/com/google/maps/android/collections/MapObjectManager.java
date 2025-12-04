package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.GoogleMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class MapObjectManager {
    protected final GoogleMap mMap;
    private final Map mNamedCollections = new HashMap();
    protected final Map<Object, Collection> mAllObjects = new HashMap();

    public abstract Collection newCollection();

    protected abstract void removeObjectFromMap(Object obj);

    abstract void setListenersOnUiThread();

    public MapObjectManager(GoogleMap googleMap) {
        this.mMap = googleMap;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.maps.android.collections.MapObjectManager.1
            @Override // java.lang.Runnable
            public void run() {
                MapObjectManager.this.setListenersOnUiThread();
            }
        });
    }

    public Collection newCollection(String str) {
        if (this.mNamedCollections.get(str) != null) {
            throw new IllegalArgumentException("collection id is not unique: " + str);
        }
        Collection collectionNewCollection = newCollection();
        this.mNamedCollections.put(str, collectionNewCollection);
        return collectionNewCollection;
    }

    public Collection getCollection(String str) {
        return (Collection) this.mNamedCollections.get(str);
    }

    public boolean remove(Object obj) {
        Collection collection = this.mAllObjects.get(obj);
        return collection != null && collection.remove(obj);
    }

    public class Collection {
        private final Set mObjects = new LinkedHashSet();

        public Collection() {
        }

        protected void add(Object obj) {
            this.mObjects.add(obj);
            MapObjectManager.this.mAllObjects.put(obj, this);
        }

        protected boolean remove(Object obj) {
            if (!this.mObjects.remove(obj)) {
                return false;
            }
            MapObjectManager.this.mAllObjects.remove(obj);
            MapObjectManager.this.removeObjectFromMap(obj);
            return true;
        }

        public void clear() {
            for (Object obj : this.mObjects) {
                MapObjectManager.this.removeObjectFromMap(obj);
                MapObjectManager.this.mAllObjects.remove(obj);
            }
            this.mObjects.clear();
        }

        protected java.util.Collection<Object> getObjects() {
            return Collections.unmodifiableCollection(this.mObjects);
        }
    }
}
