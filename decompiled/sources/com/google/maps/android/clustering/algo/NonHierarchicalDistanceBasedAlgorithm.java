package com.google.maps.android.clustering.algo;

import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private int mMaxDistance = 100;
    private final Collection mItems = new LinkedHashSet();
    private final PointQuadTree mQuadTree = new PointQuadTree(AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T t) {
        boolean zAdd;
        QuadItem quadItem = new QuadItem(t);
        synchronized (this.mQuadTree) {
            try {
                zAdd = this.mItems.add(quadItem);
                if (zAdd) {
                    this.mQuadTree.add(quadItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zAdd;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (addItem(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        synchronized (this.mQuadTree) {
            this.mItems.clear();
            this.mQuadTree.clear();
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T t) {
        boolean zRemove;
        QuadItem quadItem = new QuadItem(t);
        synchronized (this.mQuadTree) {
            try {
                zRemove = this.mItems.remove(quadItem);
                if (zRemove) {
                    this.mQuadTree.remove(quadItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zRemove;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> collection) {
        boolean z;
        synchronized (this.mQuadTree) {
            try {
                Iterator<T> it = collection.iterator();
                z = false;
                while (it.hasNext()) {
                    QuadItem quadItem = new QuadItem(it.next());
                    if (this.mItems.remove(quadItem)) {
                        this.mQuadTree.remove(quadItem);
                        z = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T t) {
        boolean zRemoveItem;
        synchronized (this.mQuadTree) {
            try {
                zRemoveItem = removeItem(t);
                if (zRemoveItem) {
                    zRemoveItem = addItem(t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zRemoveItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f) {
        double dPow = (this.mMaxDistance / Math.pow(2.0d, (int) f)) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        synchronized (this.mQuadTree) {
            try {
                Iterator<QuadItem<T>> it = getClusteringItems(this.mQuadTree, f).iterator();
                while (it.hasNext()) {
                    QuadItem<T> next = it.next();
                    if (!hashSet.contains(next)) {
                        Collection<QuadItem> collectionSearch = this.mQuadTree.search(createBoundsFromSpan(next.getPoint(), dPow));
                        if (collectionSearch.size() == 1) {
                            hashSet2.add(next);
                            hashSet.add(next);
                            map.put(next, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else {
                            StaticCluster staticCluster = new StaticCluster(((QuadItem) next).mClusterItem.getPosition());
                            hashSet2.add(staticCluster);
                            for (QuadItem quadItem : collectionSearch) {
                                Double d = (Double) map.get(quadItem);
                                Iterator<QuadItem<T>> it2 = it;
                                double dDistanceSquared = distanceSquared(quadItem.getPoint(), next.getPoint());
                                if (d == null) {
                                    map.put(quadItem, Double.valueOf(dDistanceSquared));
                                    staticCluster.add(quadItem.mClusterItem);
                                    map2.put(quadItem, staticCluster);
                                } else if (d.doubleValue() >= dDistanceSquared) {
                                    ((StaticCluster) map2.get(quadItem)).remove(quadItem.mClusterItem);
                                    map.put(quadItem, Double.valueOf(dDistanceSquared));
                                    staticCluster.add(quadItem.mClusterItem);
                                    map2.put(quadItem, staticCluster);
                                }
                                it = it2;
                            }
                            hashSet.addAll(collectionSearch);
                            it = it;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashSet2;
    }

    protected Collection<QuadItem<T>> getClusteringItems(PointQuadTree<QuadItem<T>> pointQuadTree, float f) {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.mQuadTree) {
            try {
                Iterator it = this.mItems.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(((QuadItem) it.next()).mClusterItem);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.mMaxDistance = i;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mMaxDistance;
    }

    private double distanceSquared(Point point, Point point2) {
        double d = point.x;
        double d2 = point2.x;
        double d3 = (d - d2) * (d - d2);
        double d4 = point.y;
        double d5 = point2.y;
        return d3 + ((d4 - d5) * (d4 - d5));
    }

    private Bounds createBoundsFromSpan(Point point, double d) {
        double d2 = d / 2.0d;
        double d3 = point.x;
        double d4 = d3 - d2;
        double d5 = d3 + d2;
        double d6 = point.y;
        return new Bounds(d4, d5, d6 - d2, d6 + d2);
    }

    protected static class QuadItem<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        private final ClusterItem mClusterItem;
        private final Point mPoint;
        private final LatLng mPosition;
        private Set singletonSet;

        @Override // com.google.maps.android.clustering.Cluster
        public int getSize() {
            return 1;
        }

        private QuadItem(ClusterItem clusterItem) {
            this.mClusterItem = clusterItem;
            LatLng position = clusterItem.getPosition();
            this.mPosition = position;
            this.mPoint = NonHierarchicalDistanceBasedAlgorithm.PROJECTION.toPoint(position);
            this.singletonSet = Collections.singleton(clusterItem);
        }

        @Override // com.google.maps.android.quadtree.PointQuadTree.Item
        public Point getPoint() {
            return this.mPoint;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public LatLng getPosition() {
            return this.mPosition;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public Set<T> getItems() {
            return this.singletonSet;
        }

        public int hashCode() {
            return this.mClusterItem.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof QuadItem) {
                return ((QuadItem) obj).mClusterItem.equals(this.mClusterItem);
            }
            return false;
        }
    }
}
