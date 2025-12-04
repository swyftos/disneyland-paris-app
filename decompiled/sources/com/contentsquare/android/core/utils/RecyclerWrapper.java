package com.contentsquare.android.core.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/utils/RecyclerWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "item", "getItem", "()Ljava/lang/Object;", "setItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "next", "getNext", "()Lcom/contentsquare/android/core/utils/RecyclerWrapper;", "setNext", "(Lcom/contentsquare/android/core/utils/RecyclerWrapper;)V", "toString", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class RecyclerWrapper<T> {

    @Nullable
    private T item;

    @Nullable
    private RecyclerWrapper<T> next;

    @Nullable
    public final T getItem() {
        return this.item;
    }

    @Nullable
    public final RecyclerWrapper<T> getNext() {
        return this.next;
    }

    public final void setItem(T t) {
        this.item = t;
    }

    public final void setNext(RecyclerWrapper<T> recyclerWrapper) {
        this.next = recyclerWrapper;
    }

    @NotNull
    public String toString() {
        return "RecyclerWrapper{item=" + this.item + ", next=" + this.next + '}';
    }
}
