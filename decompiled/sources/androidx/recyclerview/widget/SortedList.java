package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    Object[] mData;
    private int mNewDataStart;
    private Object[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class mTClass;

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i) {
        this.mTClass = cls;
        this.mData = (Object[]) Array.newInstance((Class<?>) cls, i);
        this.mCallback = callback;
        this.mSize = 0;
    }

    public int size() {
        return this.mSize;
    }

    public int add(T t) {
        throwIfInMutationOperation();
        return add(t, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    public void replaceAll(@NonNull T[] tArr, boolean z) {
        throwIfInMutationOperation();
        if (z) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    private void addAllInternal(Object[] objArr) {
        if (objArr.length < 1) {
            return;
        }
        int iSortAndDedup = sortAndDedup(objArr);
        if (this.mSize == 0) {
            this.mData = objArr;
            this.mSize = iSortAndDedup;
            this.mCallback.onInserted(0, iSortAndDedup);
            return;
        }
        merge(objArr, iSortAndDedup);
    }

    private void replaceAllInternal(Object[] objArr) {
        boolean z = this.mCallback instanceof BatchedCallback;
        if (!z) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int iSortAndDedup = sortAndDedup(objArr);
        this.mData = (Object[]) Array.newInstance((Class<?>) this.mTClass, iSortAndDedup);
        while (true) {
            int i = this.mNewDataStart;
            if (i >= iSortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i2 = this.mOldDataStart;
            int i3 = this.mOldDataSize;
            if (i2 >= i3) {
                int i4 = iSortAndDedup - i;
                System.arraycopy(objArr, i, this.mData, i, i4);
                this.mNewDataStart += i4;
                this.mSize += i4;
                this.mCallback.onInserted(i, i4);
                break;
            }
            if (i >= iSortAndDedup) {
                int i5 = i3 - i2;
                this.mSize -= i5;
                this.mCallback.onRemoved(i, i5);
                break;
            }
            Object obj = this.mOldData[i2];
            Object obj2 = objArr[i];
            int iCompare = this.mCallback.compare(obj, obj2);
            if (iCompare < 0) {
                replaceAllRemove();
            } else if (iCompare > 0) {
                replaceAllInsert(obj2);
            } else if (!this.mCallback.areItemsTheSame(obj, obj2)) {
                replaceAllRemove();
                replaceAllInsert(obj2);
            } else {
                Object[] objArr2 = this.mData;
                int i6 = this.mNewDataStart;
                objArr2[i6] = obj2;
                this.mOldDataStart++;
                this.mNewDataStart = i6 + 1;
                if (!this.mCallback.areContentsTheSame(obj, obj2)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(obj, obj2));
                }
            }
        }
        this.mOldData = null;
        if (z) {
            return;
        }
        endBatchedUpdates();
    }

    private void replaceAllInsert(Object obj) {
        Object[] objArr = this.mData;
        int i = this.mNewDataStart;
        objArr[i] = obj;
        this.mNewDataStart = i + 1;
        this.mSize++;
        this.mCallback.onInserted(i, 1);
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(Object[] objArr) {
        if (objArr.length == 0) {
            return 0;
        }
        Arrays.sort(objArr, this.mCallback);
        int i = 0;
        int i2 = 1;
        for (int i3 = 1; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (this.mCallback.compare(objArr[i], obj) == 0) {
                int iFindSameItem = findSameItem(obj, objArr, i, i2);
                if (iFindSameItem != -1) {
                    objArr[iFindSameItem] = obj;
                } else {
                    if (i2 != i3) {
                        objArr[i2] = obj;
                    }
                    i2++;
                }
            } else {
                if (i2 != i3) {
                    objArr[i2] = obj;
                }
                i = i2;
                i2++;
            }
        }
        return i2;
    }

    private int findSameItem(Object obj, Object[] objArr, int i, int i2) {
        while (i < i2) {
            if (this.mCallback.areItemsTheSame(objArr[i], obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void merge(Object[] objArr, int i) {
        boolean z = this.mCallback instanceof BatchedCallback;
        if (!z) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i2 = 0;
        this.mOldDataStart = 0;
        int i3 = this.mSize;
        this.mOldDataSize = i3;
        this.mData = (Object[]) Array.newInstance((Class<?>) this.mTClass, i3 + i + 10);
        this.mNewDataStart = 0;
        while (true) {
            int i4 = this.mOldDataStart;
            int i5 = this.mOldDataSize;
            if (i4 >= i5 && i2 >= i) {
                break;
            }
            if (i4 == i5) {
                int i6 = i - i2;
                System.arraycopy(objArr, i2, this.mData, this.mNewDataStart, i6);
                int i7 = this.mNewDataStart + i6;
                this.mNewDataStart = i7;
                this.mSize += i6;
                this.mCallback.onInserted(i7 - i6, i6);
                break;
            }
            if (i2 == i) {
                int i8 = i5 - i4;
                System.arraycopy(this.mOldData, i4, this.mData, this.mNewDataStart, i8);
                this.mNewDataStart += i8;
                break;
            }
            Object obj = this.mOldData[i4];
            Object obj2 = objArr[i2];
            int iCompare = this.mCallback.compare(obj, obj2);
            if (iCompare > 0) {
                Object[] objArr2 = this.mData;
                int i9 = this.mNewDataStart;
                this.mNewDataStart = i9 + 1;
                objArr2[i9] = obj2;
                this.mSize++;
                i2++;
                this.mCallback.onInserted(i9, 1);
            } else if (iCompare == 0 && this.mCallback.areItemsTheSame(obj, obj2)) {
                Object[] objArr3 = this.mData;
                int i10 = this.mNewDataStart;
                this.mNewDataStart = i10 + 1;
                objArr3[i10] = obj2;
                i2++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(obj, obj2)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(obj, obj2));
                }
            } else {
                Object[] objArr4 = this.mData;
                int i11 = this.mNewDataStart;
                this.mNewDataStart = i11 + 1;
                objArr4[i11] = obj;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z) {
            return;
        }
        endBatchedUpdates();
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    private int add(Object obj, boolean z) {
        int iFindIndexOf = findIndexOf(obj, this.mData, 0, this.mSize, 1);
        if (iFindIndexOf == -1) {
            iFindIndexOf = 0;
        } else if (iFindIndexOf < this.mSize) {
            Object obj2 = this.mData[iFindIndexOf];
            if (this.mCallback.areItemsTheSame(obj2, obj)) {
                if (this.mCallback.areContentsTheSame(obj2, obj)) {
                    this.mData[iFindIndexOf] = obj;
                    return iFindIndexOf;
                }
                this.mData[iFindIndexOf] = obj;
                Callback callback = this.mCallback;
                callback.onChanged(iFindIndexOf, 1, callback.getChangePayload(obj2, obj));
                return iFindIndexOf;
            }
        }
        addToData(iFindIndexOf, obj);
        if (z) {
            this.mCallback.onInserted(iFindIndexOf, 1);
        }
        return iFindIndexOf;
    }

    public boolean remove(T t) {
        throwIfInMutationOperation();
        return remove(t, true);
    }

    public T removeItemAt(int i) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t = get(i);
        removeItemAtIndex(i, true);
        return t;
    }

    private boolean remove(Object obj, boolean z) {
        int iFindIndexOf = findIndexOf(obj, this.mData, 0, this.mSize, 2);
        if (iFindIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(iFindIndexOf, z);
        return true;
    }

    private void removeItemAtIndex(int i, boolean z) {
        Object[] objArr = this.mData;
        System.arraycopy(objArr, i + 1, objArr, i, (this.mSize - i) - 1);
        int i2 = this.mSize - 1;
        this.mSize = i2;
        this.mData[i2] = null;
        if (z) {
            this.mCallback.onRemoved(i, 1);
        }
    }

    public void updateItemAt(int i, T t) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t2 = get(i);
        boolean z = t2 == t || !this.mCallback.areContentsTheSame(t2, t);
        if (t2 != t && this.mCallback.compare(t2, t) == 0) {
            this.mData[i] = t;
            if (z) {
                Callback callback = this.mCallback;
                callback.onChanged(i, 1, callback.getChangePayload(t2, t));
                return;
            }
            return;
        }
        if (z) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i, 1, callback2.getChangePayload(t2, t));
        }
        removeItemAtIndex(i, false);
        int iAdd = add(t, false);
        if (i != iAdd) {
            this.mCallback.onMoved(i, iAdd);
        }
    }

    public void recalculatePositionOfItemAt(int i) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t = get(i);
        removeItemAtIndex(i, false);
        int iAdd = add(t, false);
        if (i != iAdd) {
            this.mCallback.onMoved(i, iAdd);
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        int i2;
        if (i >= this.mSize || i < 0) {
            throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.mSize);
        }
        Object[] objArr = this.mOldData;
        if (objArr != null && i >= (i2 = this.mNewDataStart)) {
            return (T) objArr[(i - i2) + this.mOldDataStart];
        }
        return (T) this.mData[i];
    }

    public int indexOf(T t) {
        if (this.mOldData != null) {
            int iFindIndexOf = findIndexOf(t, this.mData, 0, this.mNewDataStart, 4);
            if (iFindIndexOf != -1) {
                return iFindIndexOf;
            }
            int iFindIndexOf2 = findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (iFindIndexOf2 != -1) {
                return (iFindIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
            }
            return -1;
        }
        return findIndexOf(t, this.mData, 0, this.mSize, 4);
    }

    private int findIndexOf(Object obj, Object[] objArr, int i, int i2, int i3) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            Object obj2 = objArr[i4];
            int iCompare = this.mCallback.compare(obj2, obj);
            if (iCompare < 0) {
                i = i4 + 1;
            } else {
                if (iCompare == 0) {
                    if (this.mCallback.areItemsTheSame(obj2, obj)) {
                        return i4;
                    }
                    int iLinearEqualitySearch = linearEqualitySearch(obj, i4, i, i2);
                    return (i3 == 1 && iLinearEqualitySearch == -1) ? i4 : iLinearEqualitySearch;
                }
                i2 = i4;
            }
        }
        if (i3 == 1) {
            return i;
        }
        return -1;
    }

    private int linearEqualitySearch(Object obj, int i, int i2, int i3) {
        Object obj2;
        for (int i4 = i - 1; i4 >= i2; i4--) {
            Object obj3 = this.mData[i4];
            if (this.mCallback.compare(obj3, obj) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(obj3, obj)) {
                return i4;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -1;
            }
            obj2 = this.mData[i];
            if (this.mCallback.compare(obj2, obj) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(obj2, obj));
        return i;
    }

    private void addToData(int i, Object obj) {
        int i2 = this.mSize;
        if (i > i2) {
            throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.mSize);
        }
        Object[] objArr = this.mData;
        if (i2 == objArr.length) {
            Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.mTClass, objArr.length + 10);
            System.arraycopy(this.mData, 0, objArr2, 0, i);
            objArr2[i] = obj;
            System.arraycopy(this.mData, i, objArr2, i + 1, this.mSize - i);
            this.mData = objArr2;
        } else {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
            this.mData[i] = obj;
        }
        this.mSize++;
    }

    private Object[] copyArray(Object[] objArr) {
        Object[] objArr2 = (Object[]) Array.newInstance((Class<?>) this.mTClass, objArr.length);
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return objArr2;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i = this.mSize;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i);
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i, int i2);

        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback mWrappedCallback;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.mWrappedCallback.compare(t2, t22);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.mBatchingListUpdateCallback.onInserted(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.mBatchingListUpdateCallback.onRemoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.mBatchingListUpdateCallback.onMoved(i, i2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i2) {
            this.mBatchingListUpdateCallback.onChanged(i, i2, null);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        @SuppressLint({"UnknownNullness"})
        public void onChanged(int i, int i2, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i, i2, obj);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.mWrappedCallback.getChangePayload(t2, t22);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }
    }
}
