package com.google.maps.android.quadtree;

import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class PointQuadTree<T extends Item> {
    private final Bounds mBounds;
    private List mChildren;
    private final int mDepth;
    private Set mItems;

    public interface Item {
        Point getPoint();
    }

    public PointQuadTree(double d, double d2, double d3, double d4) {
        this(new Bounds(d, d2, d3, d4));
    }

    public PointQuadTree(Bounds bounds) {
        this(bounds, 0);
    }

    private PointQuadTree(double d, double d2, double d3, double d4, int i) {
        this(new Bounds(d, d2, d3, d4), i);
    }

    private PointQuadTree(Bounds bounds, int i) {
        this.mChildren = null;
        this.mBounds = bounds;
        this.mDepth = i;
    }

    public void add(T t) {
        Point point = t.getPoint();
        if (this.mBounds.contains(point.x, point.y)) {
            insert(point.x, point.y, t);
        }
    }

    private void insert(double d, double d2, Item item) {
        List list = this.mChildren;
        if (list != null) {
            Bounds bounds = this.mBounds;
            if (d2 < bounds.midY) {
                if (d < bounds.midX) {
                    ((PointQuadTree) list.get(0)).insert(d, d2, item);
                    return;
                } else {
                    ((PointQuadTree) list.get(1)).insert(d, d2, item);
                    return;
                }
            }
            if (d < bounds.midX) {
                ((PointQuadTree) list.get(2)).insert(d, d2, item);
                return;
            } else {
                ((PointQuadTree) list.get(3)).insert(d, d2, item);
                return;
            }
        }
        if (this.mItems == null) {
            this.mItems = new LinkedHashSet();
        }
        this.mItems.add(item);
        if (this.mItems.size() <= 50 || this.mDepth >= 40) {
            return;
        }
        split();
    }

    private void split() {
        ArrayList arrayList = new ArrayList(4);
        this.mChildren = arrayList;
        Bounds bounds = this.mBounds;
        arrayList.add(new PointQuadTree(bounds.minX, bounds.midX, bounds.minY, bounds.midY, this.mDepth + 1));
        List list = this.mChildren;
        Bounds bounds2 = this.mBounds;
        list.add(new PointQuadTree(bounds2.midX, bounds2.maxX, bounds2.minY, bounds2.midY, this.mDepth + 1));
        List list2 = this.mChildren;
        Bounds bounds3 = this.mBounds;
        list2.add(new PointQuadTree(bounds3.minX, bounds3.midX, bounds3.midY, bounds3.maxY, this.mDepth + 1));
        List list3 = this.mChildren;
        Bounds bounds4 = this.mBounds;
        list3.add(new PointQuadTree(bounds4.midX, bounds4.maxX, bounds4.midY, bounds4.maxY, this.mDepth + 1));
        Set<Item> set = this.mItems;
        this.mItems = null;
        for (Item item : set) {
            insert(item.getPoint().x, item.getPoint().y, item);
        }
    }

    public boolean remove(T t) {
        Point point = t.getPoint();
        if (this.mBounds.contains(point.x, point.y)) {
            return remove(point.x, point.y, t);
        }
        return false;
    }

    private boolean remove(double d, double d2, Item item) {
        List list = this.mChildren;
        if (list != null) {
            Bounds bounds = this.mBounds;
            if (d2 < bounds.midY) {
                if (d < bounds.midX) {
                    return ((PointQuadTree) list.get(0)).remove(d, d2, item);
                }
                return ((PointQuadTree) list.get(1)).remove(d, d2, item);
            }
            if (d < bounds.midX) {
                return ((PointQuadTree) list.get(2)).remove(d, d2, item);
            }
            return ((PointQuadTree) list.get(3)).remove(d, d2, item);
        }
        Set set = this.mItems;
        if (set == null) {
            return false;
        }
        return set.remove(item);
    }

    public void clear() {
        this.mChildren = null;
        Set set = this.mItems;
        if (set != null) {
            set.clear();
        }
    }

    public Collection<T> search(Bounds bounds) {
        ArrayList arrayList = new ArrayList();
        search(bounds, arrayList);
        return arrayList;
    }

    private void search(Bounds bounds, Collection collection) {
        if (this.mBounds.intersects(bounds)) {
            List list = this.mChildren;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PointQuadTree) it.next()).search(bounds, collection);
                }
            } else if (this.mItems != null) {
                if (bounds.contains(this.mBounds)) {
                    collection.addAll(this.mItems);
                    return;
                }
                for (Item item : this.mItems) {
                    if (bounds.contains(item.getPoint())) {
                        collection.add(item);
                    }
                }
            }
        }
    }
}
