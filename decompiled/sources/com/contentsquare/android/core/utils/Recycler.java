package com.contentsquare.android.core.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00028\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/utils/Recycler;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "recyclerIn", "Lcom/contentsquare/android/core/utils/RecyclerWrapperQueue;", "recyclerOut", "obtain", "instanceCreator", "Lcom/contentsquare/android/core/utils/InstanceCreator;", "(Lcom/contentsquare/android/core/utils/InstanceCreator;)Ljava/lang/Object;", "recycle", "", "item", "(Ljava/lang/Object;)V", "toString", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Recycler<T> {

    @NotNull
    private final RecyclerWrapperQueue<T> recyclerIn = new RecyclerWrapperQueue<>();

    @NotNull
    private final RecyclerWrapperQueue<T> recyclerOut = new RecyclerWrapperQueue<>();

    public final synchronized T obtain(InstanceCreator<T> instanceCreator) {
        T item;
        try {
            Intrinsics.checkNotNullParameter(instanceCreator, "instanceCreator");
            RecyclerWrapper<T> recyclerWrapperObtain = this.recyclerOut.obtain();
            item = recyclerWrapperObtain.getItem();
            if (item == null) {
                item = instanceCreator.create();
                recyclerWrapperObtain.setItem(item);
            }
            this.recyclerIn.recycle(recyclerWrapperObtain);
        } catch (Throwable th) {
            throw th;
        }
        return item;
    }

    public final synchronized void recycle(T item) {
        RecyclerWrapper<T> recyclerWrapperObtain = this.recyclerIn.obtain();
        recyclerWrapperObtain.setItem(item);
        this.recyclerOut.recycle(recyclerWrapperObtain);
    }

    @NotNull
    public String toString() {
        return "Recycler{in=" + this.recyclerIn + ", out=" + this.recyclerOut + '}';
    }
}
