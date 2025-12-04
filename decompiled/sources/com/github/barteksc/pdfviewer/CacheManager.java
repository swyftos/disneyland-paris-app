package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.model.PagePart;
import com.github.barteksc.pdfviewer.util.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* loaded from: classes3.dex */
class CacheManager {
    private final PriorityQueue activeCache;
    private final PagePartComparator orderComparator;
    private final Object passiveActiveLock = new Object();
    private final PriorityQueue passiveCache;
    private final List thumbnails;

    public CacheManager() {
        PagePartComparator pagePartComparator = new PagePartComparator();
        this.orderComparator = pagePartComparator;
        this.activeCache = new PriorityQueue(Constants.Cache.CACHE_SIZE, pagePartComparator);
        this.passiveCache = new PriorityQueue(Constants.Cache.CACHE_SIZE, pagePartComparator);
        this.thumbnails = new ArrayList();
    }

    public void cachePart(PagePart pagePart) {
        synchronized (this.passiveActiveLock) {
            makeAFreeSpace();
            this.activeCache.offer(pagePart);
        }
    }

    public void makeANewSet() {
        synchronized (this.passiveActiveLock) {
            this.passiveCache.addAll(this.activeCache);
            this.activeCache.clear();
        }
    }

    private void makeAFreeSpace() {
        synchronized (this.passiveActiveLock) {
            while (this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE && !this.passiveCache.isEmpty()) {
                try {
                    ((PagePart) this.passiveCache.poll()).getRenderedBitmap().recycle();
                } catch (Throwable th) {
                    throw th;
                }
            }
            while (this.activeCache.size() + this.passiveCache.size() >= Constants.Cache.CACHE_SIZE && !this.activeCache.isEmpty()) {
                ((PagePart) this.activeCache.poll()).getRenderedBitmap().recycle();
            }
        }
    }

    public void cacheThumbnail(PagePart pagePart) {
        synchronized (this.thumbnails) {
            while (this.thumbnails.size() >= Constants.Cache.THUMBNAILS_CACHE_SIZE) {
                try {
                    ((PagePart) this.thumbnails.remove(0)).getRenderedBitmap().recycle();
                } catch (Throwable th) {
                    throw th;
                }
            }
            addWithoutDuplicates(this.thumbnails, pagePart);
        }
    }

    public boolean upPartIfContained(int i, RectF rectF, int i2) {
        PagePart pagePart = new PagePart(i, null, rectF, false, 0);
        synchronized (this.passiveActiveLock) {
            try {
                PagePart pagePartFind = find(this.passiveCache, pagePart);
                boolean z = true;
                if (pagePartFind != null) {
                    this.passiveCache.remove(pagePartFind);
                    pagePartFind.setCacheOrder(i2);
                    this.activeCache.offer(pagePartFind);
                    return true;
                }
                if (find(this.activeCache, pagePart) == null) {
                    z = false;
                }
                return z;
            } finally {
            }
        }
    }

    public boolean containsThumbnail(int i, RectF rectF) {
        PagePart pagePart = new PagePart(i, null, rectF, true, 0);
        synchronized (this.thumbnails) {
            try {
                Iterator it = this.thumbnails.iterator();
                while (it.hasNext()) {
                    if (((PagePart) it.next()).equals(pagePart)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void addWithoutDuplicates(Collection collection, PagePart pagePart) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((PagePart) it.next()).equals(pagePart)) {
                pagePart.getRenderedBitmap().recycle();
                return;
            }
        }
        collection.add(pagePart);
    }

    private static PagePart find(PriorityQueue priorityQueue, PagePart pagePart) {
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            PagePart pagePart2 = (PagePart) it.next();
            if (pagePart2.equals(pagePart)) {
                return pagePart2;
            }
        }
        return null;
    }

    public List getPageParts() {
        ArrayList arrayList;
        synchronized (this.passiveActiveLock) {
            arrayList = new ArrayList(this.passiveCache);
            arrayList.addAll(this.activeCache);
        }
        return arrayList;
    }

    public List getThumbnails() {
        List list;
        synchronized (this.thumbnails) {
            list = this.thumbnails;
        }
        return list;
    }

    public void recycle() {
        synchronized (this.passiveActiveLock) {
            try {
                Iterator it = this.passiveCache.iterator();
                while (it.hasNext()) {
                    ((PagePart) it.next()).getRenderedBitmap().recycle();
                }
                this.passiveCache.clear();
                Iterator it2 = this.activeCache.iterator();
                while (it2.hasNext()) {
                    ((PagePart) it2.next()).getRenderedBitmap().recycle();
                }
                this.activeCache.clear();
            } finally {
            }
        }
        synchronized (this.thumbnails) {
            try {
                Iterator it3 = this.thumbnails.iterator();
                while (it3.hasNext()) {
                    ((PagePart) it3.next()).getRenderedBitmap().recycle();
                }
                this.thumbnails.clear();
            } finally {
            }
        }
    }

    class PagePartComparator implements Comparator {
        PagePartComparator() {
        }

        @Override // java.util.Comparator
        public int compare(PagePart pagePart, PagePart pagePart2) {
            if (pagePart.getCacheOrder() == pagePart2.getCacheOrder()) {
                return 0;
            }
            return pagePart.getCacheOrder() > pagePart2.getCacheOrder() ? 1 : -1;
        }
    }
}
