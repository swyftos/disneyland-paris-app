package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.amazonaws.internal.ListWithAutoConstructFlag;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class FreezableUtils {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull ArrayList<E> arrayList) {
        ListWithAutoConstructFlag listWithAutoConstructFlag = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            listWithAutoConstructFlag.add(arrayList.get(i).freeze());
        }
        return listWithAutoConstructFlag;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(@NonNull Iterable<E> iterable) {
        ListWithAutoConstructFlag listWithAutoConstructFlag = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            listWithAutoConstructFlag.add(it.next().freeze());
        }
        return listWithAutoConstructFlag;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(@NonNull E[] eArr) {
        ListWithAutoConstructFlag listWithAutoConstructFlag = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            listWithAutoConstructFlag.add(e.freeze());
        }
        return listWithAutoConstructFlag;
    }
}
