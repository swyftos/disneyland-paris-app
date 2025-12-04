package com.contentsquare.android.core.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/contentsquare/android/core/utils/RecyclerWrapperQueue;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "head", "Lcom/contentsquare/android/core/utils/RecyclerWrapper;", "obtain", "recycle", "", "objectToRecycle", "toString", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class RecyclerWrapperQueue<T> {

    @Nullable
    private RecyclerWrapper<T> head;

    @NotNull
    public final RecyclerWrapper<T> obtain() {
        RecyclerWrapper<T> recyclerWrapper = this.head;
        if (recyclerWrapper == null) {
            return new RecyclerWrapper<>();
        }
        this.head = recyclerWrapper.getNext();
        return recyclerWrapper;
    }

    public final void recycle(RecyclerWrapper<T> objectToRecycle) {
        Intrinsics.checkNotNullParameter(objectToRecycle, "objectToRecycle");
        objectToRecycle.setNext(this.head);
        this.head = objectToRecycle;
    }

    @NotNull
    public String toString() {
        return "RecyclerWrapperQueue{head=" + this.head + '}';
    }
}
